package com.tencent.mm.bc;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.a;
import com.tencent.mm.al.n.b;
import com.tencent.mm.g.a.ox;
import com.tencent.mm.g.a.ox.a;
import com.tencent.mm.g.a.xl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.c;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.bfo;
import com.tencent.mm.protocal.protobuf.bfp;
import com.tencent.mm.protocal.protobuf.cha;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class l
  extends n
  implements com.tencent.mm.al.p, com.tencent.mm.network.k
{
  private f callback;
  private int dnF;
  private int flags;
  private boolean ijn;
  private com.tencent.mm.al.b rr;
  
  public l(int paramInt)
  {
    AppMethodBeat.i(150814);
    this.ijn = false;
    this.flags = -1;
    this.dnF = paramInt;
    this.ijn = false;
    ad.d("MicroMsg.NetSceneGetPackageList", "Init dkregcode:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(150814);
  }
  
  public l(boolean paramBoolean)
  {
    AppMethodBeat.i(150813);
    this.ijn = false;
    this.flags = -1;
    this.dnF = 26;
    this.ijn = false;
    ad.d("MicroMsg.NetSceneGetPackageList", "Init dkregcode:26");
    ad.d("MicroMsg.NetSceneGetPackageList", "isOnlyCheckInReqList: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      this.flags = 1;
    }
    AppMethodBeat.o(150813);
  }
  
  private o a(cha paramcha)
  {
    AppMethodBeat.i(150816);
    o localo = new o();
    localo.id = paramcha.ukh;
    localo.version = paramcha.Version;
    localo.name = paramcha.Name;
    localo.size = paramcha.nEa;
    localo.ijv = paramcha.PackName;
    localo.status = 5;
    localo.dtF = this.dnF;
    AppMethodBeat.o(150816);
    return localo;
  }
  
  private void ar(List<cha> paramList)
  {
    AppMethodBeat.i(150825);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      ad.d("MicroMsg.NetSceneGetPackageList", "[oneliang]empty update expose scene list");
      AppMethodBeat.o(150825);
      return;
    }
    t.aJZ();
    String str = p.aJW();
    int i = 0;
    if (i < paramList.size())
    {
      cha localcha = (cha)paramList.get(i);
      Object localObject = t.aJZ().dj(localcha.ukh, this.dnF);
      o localo;
      if ((localObject == null) || (((o)localObject).version != localcha.Version))
      {
        i.deleteFile(str + t.aJZ().dl(localcha.ukh, this.dnF));
        localo = a(localcha);
        localo.dDp = -1;
        if (localObject != null) {
          break label225;
        }
        t.aJZ().a(localo);
      }
      for (;;)
      {
        localObject = new k(localo.id, 19);
        g.ajB().gAO.a((n)localObject, 0);
        ad.d("MicroMsg.NetSceneGetPackageList", "[oneliang]name:%s,packName:%s", new Object[] { localcha.Name, localcha.PackName });
        i += 1;
        break;
        label225:
        t.aJZ().b(localo);
      }
    }
    AppMethodBeat.o(150825);
  }
  
  private void as(List<cha> paramList)
  {
    AppMethodBeat.i(150826);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ad.d("MicroMsg.NetSceneGetPackageList", "updateIPCallCountryCodeConfig, package list is empty");
      AppMethodBeat.o(150826);
      return;
    }
    ad.d("MicroMsg.NetSceneGetPackageList", "updateIPCallCountryCodeConfig, pkgList.size: %d", new Object[] { Integer.valueOf(paramList.size()) });
    int i = ((Integer)g.ajC().ajl().get(al.a.IsC, Integer.valueOf(-1))).intValue();
    ad.d("MicroMsg.NetSceneGetPackageList", "configPkgId: %d", new Object[] { Integer.valueOf(i) });
    if (i == -1)
    {
      AppMethodBeat.o(150826);
      return;
    }
    o localo1 = t.aJZ().dj(i, this.dnF);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      o localo2 = a((cha)paramList.next());
      ad.d("MicroMsg.NetSceneGetPackageList", "newInfo.id: %d, version: %d", new Object[] { Integer.valueOf(localo2.id), Integer.valueOf(localo2.version) });
      if ((localo1 != null) && (localo2.id == i))
      {
        ad.d("MicroMsg.NetSceneGetPackageList", "find match old pkg, update one");
        t.aJZ().b(localo2);
        AppMethodBeat.o(150826);
        return;
      }
      if ((localo1 == null) && (localo2.id == i))
      {
        ad.d("MicroMsg.NetSceneGetPackageList", "insert new pkg");
        t.aJZ().a(localo2);
        AppMethodBeat.o(150826);
        return;
      }
    }
    AppMethodBeat.o(150826);
  }
  
  private void at(List<cha> paramList)
  {
    AppMethodBeat.i(150827);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ad.d("MicroMsg.NetSceneGetPackageList", "update sense where location but package list is empty.");
      AppMethodBeat.o(150827);
      return;
    }
    ad.i("MicroMsg.NetSceneGetPackageList", "start update sense where location. package list size " + paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject2 = (cha)paramList.next();
      Object localObject1 = t.aJZ().dj(((cha)localObject2).ukh, this.dnF);
      if ((localObject1 == null) || (((o)localObject1).version != ((cha)localObject2).Version))
      {
        localObject2 = a((cha)localObject2);
        ((o)localObject2).dDp = -1;
        if (localObject1 == null) {
          t.aJZ().a((o)localObject2);
        }
        for (;;)
        {
          localObject1 = new k(((o)localObject2).id, 36);
          g.ajB().gAO.a((n)localObject1, 0);
          break;
          t.aJZ().b((o)localObject2);
        }
      }
    }
    AppMethodBeat.o(150827);
  }
  
  private void g(LinkedList<cha> paramLinkedList)
  {
    AppMethodBeat.i(150818);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ad.d("MicroMsg.NetSceneGetPackageList", "empty upload speex config list");
      AppMethodBeat.o(150818);
      return;
    }
    t.aJZ();
    String str = p.aJW();
    int i = 0;
    if (i < paramLinkedList.size())
    {
      cha localcha = (cha)paramLinkedList.get(i);
      Object localObject = t.aJZ().dj(localcha.ukh, this.dnF);
      o localo;
      if ((localObject == null) || (((o)localObject).version != localcha.Version))
      {
        i.deleteFile(str + t.aJZ().dl(localcha.ukh, this.dnF));
        localo = a(localcha);
        localo.dDp = -1;
        if (localObject != null) {
          break label353;
        }
        t.aJZ().a(localo);
      }
      for (;;)
      {
        localObject = new k(localo.id, 9);
        g.ajB().gAO.a((n)localObject, 0);
        if (z.a(localcha.Fwu) != null) {
          ad.v("MicroMsg.NetSceneGetPackageList", "xml:".concat(String.valueOf(new String(z.a(localcha.Fwu)))));
        }
        if (z.a(localcha.HaC) != null) {
          ad.v("MicroMsg.NetSceneGetPackageList", "xml2:".concat(String.valueOf(new String(z.a(localcha.HaC)))));
        }
        ad.v("MicroMsg.NetSceneGetPackageList", "xml3:" + localcha.toString());
        ad.v("MicroMsg.NetSceneGetPackageList", "xml4:" + localcha.Name);
        ad.v("MicroMsg.NetSceneGetPackageList", "xml5:" + localcha.PackName);
        i += 1;
        break;
        label353:
        t.aJZ().b(localo);
      }
    }
    AppMethodBeat.o(150818);
  }
  
  private void h(LinkedList<cha> paramLinkedList)
  {
    AppMethodBeat.i(150819);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ad.e("MicroMsg.NetSceneGetPackageList", "empty background pkg list");
      AppMethodBeat.o(150819);
      return;
    }
    t.aJZ();
    String str = p.aJW();
    int i = 0;
    if (i < paramLinkedList.size())
    {
      Object localObject1 = (cha)paramLinkedList.get(i);
      Object localObject2 = t.aJZ().dj(((cha)localObject1).ukh, this.dnF);
      o localo;
      if ((localObject2 == null) || (((o)localObject2).version != ((cha)localObject1).Version))
      {
        i.deleteFile(str + t.aJZ().dl(((cha)localObject1).ukh, this.dnF));
        localo = a((cha)localObject1);
        localo.dDp = -1;
        if (localObject2 != null) {
          break label294;
        }
      }
      label294:
      for (boolean bool = t.aJZ().a(localo);; bool = t.aJZ().b(localo))
      {
        ad.i("MicroMsg.NetSceneGetPackageList", "[updateBackgroundPkg] ret:%s newInfo:%s", new Object[] { Boolean.valueOf(bool), localo });
        localObject2 = z.a(((cha)localObject1).Fwu);
        if ((localObject2 != null) && (localObject2.length > 0))
        {
          t.aJZ();
          localObject1 = p.dk(((cha)localObject1).ukh, this.dnF);
          i.deleteFile(str + (String)localObject1);
          if (i.e(str + (String)localObject1, (byte[])localObject2, localObject2.length) < 0) {
            ad.e("MicroMsg.NetSceneGetPackageList", "[updateBackgroundPkg] appendBuf thumb error!");
          }
        }
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(150819);
  }
  
  @Deprecated
  private void i(LinkedList<cha> paramLinkedList)
  {
    AppMethodBeat.i(150820);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ad.d("MicroMsg.NetSceneGetPackageList", "empty emoji pkg list");
      AppMethodBeat.o(150820);
      return;
    }
    int i = 0;
    if (i < paramLinkedList.size())
    {
      Object localObject1 = (cha)paramLinkedList.get(i);
      Object localObject2 = t.aJZ().dj(((cha)localObject1).ukh, this.dnF);
      o localo = a((cha)localObject1);
      localo.dDp = -1;
      if (localObject2 == null) {
        t.aJZ().a(localo);
      }
      for (;;)
      {
        localObject1 = z.a(((cha)localObject1).Fwu);
        if ((localObject1 != null) && (localObject1.length > 0))
        {
          localObject2 = new ArrayList();
          ((List)localObject2).add(new String((byte[])localObject1));
          ((List)localObject2).size();
        }
        i += 1;
        break;
        t.aJZ().b(localo);
      }
    }
    AppMethodBeat.o(150820);
  }
  
  private void j(LinkedList<cha> paramLinkedList)
  {
    AppMethodBeat.i(150821);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ad.d("MicroMsg.NetSceneGetPackageList", "empty emoji pkg list");
      AppMethodBeat.o(150821);
      return;
    }
    ad.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + paramLinkedList.size());
    t.aJZ();
    String str1 = p.aJW();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      cha localcha = (cha)paramLinkedList.get(i);
      o localo = t.aJZ().dj(localcha.ukh, this.dnF);
      byte[] arrayOfByte = z.a(localcha.Fwu);
      if (localcha.Fwu == null)
      {
        ad.e("MicroMsg.NetSceneGetPackageList", "error give me a null thumb it should be xml");
        i += 1;
      }
      else
      {
        String str2;
        Object localObject;
        if ((localo == null) || (localo.version != localcha.Version))
        {
          str2 = new String(arrayOfByte);
          localObject = "zh_CN";
          if (str2.indexOf("zh_CN") >= 0)
          {
            label180:
            str2 = (String)localObject + "_ARTIST.mm";
            i.deleteFile(str1 + str2);
            i.deleteFile(str1 + (String)localObject + "_ARTISTF.mm");
            i.e(str1 + str2, arrayOfByte, arrayOfByte.length);
          }
        }
        else
        {
          localObject = a(localcha);
          ((o)localObject).dDp = -1;
          if (localo != null) {
            break label414;
          }
          t.aJZ().a((o)localObject);
        }
        for (;;)
        {
          ad.d("MicroMsg.NetSceneGetPackageList", localcha.Name + " - " + localcha.ukh + " - " + localcha.PackName + " - " + localcha.nEa);
          break;
          localObject = "en";
          if (str2.indexOf("en") >= 0) {
            break label180;
          }
          localObject = "zh_TW";
          if (str2.indexOf("zh_TW") >= 0) {
            break label180;
          }
          localObject = "en";
          break label180;
          label414:
          t.aJZ().b((o)localObject);
        }
      }
    }
    AppMethodBeat.o(150821);
  }
  
  private void k(LinkedList<cha> paramLinkedList)
  {
    AppMethodBeat.i(150822);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ad.d("MicroMsg.NetSceneGetPackageList", "empty config list");
      AppMethodBeat.o(150822);
      return;
    }
    ad.d("MicroMsg.NetSceneGetPackageList", "updateConfigList pkgList size " + paramLinkedList.size());
    int i = 0;
    if (i < paramLinkedList.size())
    {
      Object localObject1 = (cha)paramLinkedList.get(i);
      Object localObject2 = t.aJZ().dj(((cha)localObject1).ukh, this.dnF);
      Object localObject3 = a((cha)localObject1);
      ((o)localObject3).dDp = -1;
      if (localObject2 == null) {
        t.aJZ().a((o)localObject3);
      }
      for (;;)
      {
        ad.d("MicroMsg.NetSceneGetPackageList", ((cha)localObject1).Name + " - " + ((cha)localObject1).ukh + " - " + ((cha)localObject1).PackName + " - " + ((cha)localObject1).nEa);
        localObject2 = z.a(((cha)localObject1).Fwu);
        ad.d("MicroMsg.NetSceneGetPackageList", "ConfigList xml : ".concat(String.valueOf(new String((byte[])localObject2))));
        localObject3 = ((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).acB();
        int j = ((cha)localObject1).ukh;
        localObject1 = new com.tencent.mm.vfs.e(c.ges);
        if (!((com.tencent.mm.vfs.e)localObject1).exists()) {
          ((com.tencent.mm.vfs.e)localObject1).mkdirs();
        }
        try
        {
          localObject1 = new com.tencent.mm.vfs.e(c.lC(j));
          if (!((com.tencent.mm.vfs.e)localObject1).exists()) {
            ((com.tencent.mm.vfs.e)localObject1).createNewFile();
          }
          i.f(c.lC(j), (byte[])localObject2, localObject2.length);
          ((c)localObject3).w(j, new String((byte[])localObject2));
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.e("MicroMsg.ConfigListDecoder", "exception:%s", new Object[] { bt.n(localException) });
          }
        }
        i += 1;
        break;
        t.aJZ().b((o)localObject3);
      }
    }
    AppMethodBeat.o(150822);
  }
  
  private void l(LinkedList<cha> paramLinkedList)
  {
    AppMethodBeat.i(150823);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ad.d("MicroMsg.NetSceneGetPackageList", "empty regioncode pkg list");
      AppMethodBeat.o(150823);
      return;
    }
    ad.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + paramLinkedList.size());
    paramLinkedList = paramLinkedList.iterator();
    if (paramLinkedList.hasNext())
    {
      cha localcha = (cha)paramLinkedList.next();
      o localo1 = t.aJZ().dj(localcha.ukh, this.dnF);
      o localo2 = a(localcha);
      localo2.dDp = -1;
      if (localo1 == null) {
        t.aJZ().a(localo2);
      }
      for (;;)
      {
        ad.d("MicroMsg.NetSceneGetPackageList", localcha.Name + " - " + localcha.ukh + " - " + localcha.PackName + " - " + localcha.nEa);
        break;
        t.aJZ().b(localo2);
      }
    }
    AppMethodBeat.o(150823);
  }
  
  private void m(LinkedList<cha> paramLinkedList)
  {
    AppMethodBeat.i(150824);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ad.e("MicroMsg.NetSceneGetPackageList", "empty address pkg list");
      AppMethodBeat.o(150824);
      return;
    }
    ad.i("MicroMsg.NetSceneGetPackageList", "updateRcptAddress pkgList size " + paramLinkedList.size());
    int i = 0;
    if (i < paramLinkedList.size())
    {
      Object localObject2 = (cha)paramLinkedList.get(i);
      Object localObject1 = t.aJZ().dj(((cha)localObject2).ukh, this.dnF);
      localObject2 = a((cha)localObject2);
      ((o)localObject2).dDp = -1;
      if (localObject1 == null) {
        t.aJZ().a((o)localObject2);
      }
      for (;;)
      {
        localObject1 = new k(((o)localObject2).id, 12);
        g.ajB().gAO.a((n)localObject1, 0);
        i += 1;
        break;
        t.aJZ().b((o)localObject2);
      }
    }
    AppMethodBeat.o(150824);
  }
  
  private void n(LinkedList<cha> paramLinkedList)
  {
    AppMethodBeat.i(150828);
    ad.d("MicroMsg.NetSceneGetPackageList", "updateLangPkg");
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      ad.d("MicroMsg.NetSceneGetPackageList", "empty langage package list");
      AppMethodBeat.o(150828);
      return;
    }
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      Object localObject = (cha)paramLinkedList.next();
      ad.d("MicroMsg.NetSceneGetPackageList", "pkg.toString %s", new Object[] { localObject.toString() });
      o localo = t.aJZ().dj(((cha)localObject).ukh, this.dnF);
      localObject = a((cha)localObject);
      ((o)localObject).dDp = -1;
      if (localo == null) {
        t.aJZ().a((o)localObject);
      } else {
        t.aJZ().b((o)localObject);
      }
    }
    AppMethodBeat.o(150828);
  }
  
  private void o(LinkedList<cha> paramLinkedList)
  {
    AppMethodBeat.i(150829);
    ad.d("MicroMsg.NetSceneGetPackageList", "updateAppleEmojiPackage");
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      ad.d("MicroMsg.NetSceneGetPackageList", "update apple emoji but package list is empty.");
      AppMethodBeat.o(150829);
      return;
    }
    ad.i("MicroMsg.NetSceneGetPackageList", "start update apple emoji. package list size " + paramLinkedList.size());
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      Object localObject2 = (cha)paramLinkedList.next();
      Object localObject1 = t.aJZ().dj(((cha)localObject2).ukh, this.dnF);
      if ((localObject1 == null) || (((o)localObject1).version != ((cha)localObject2).Version))
      {
        localObject2 = a((cha)localObject2);
        ((o)localObject2).dDp = -1;
        if (localObject1 == null) {
          t.aJZ().a((o)localObject2);
        }
        for (;;)
        {
          localObject1 = new k(((o)localObject2).id, 37);
          g.ajB().gAO.a((n)localObject1, 0);
          break;
          t.aJZ().b((o)localObject2);
        }
      }
    }
    AppMethodBeat.o(150829);
  }
  
  public final int aEM()
  {
    return this.dnF;
  }
  
  public final boolean acceptConcurrent(n paramn)
  {
    if (!(paramn instanceof l)) {}
    while (this.dnF != ((l)paramn).dnF) {
      return true;
    }
    return false;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(150815);
    this.callback = paramf;
    ad.d("MicroMsg.NetSceneGetPackageList", "DoScene dkregcode :" + this.dnF);
    paramf = new b.a();
    paramf.hNM = new bfo();
    paramf.hNN = new bfp();
    paramf.uri = "/cgi-bin/micromsg-bin/getpackagelist";
    paramf.funcId = 159;
    paramf.hNO = 51;
    paramf.respCmdId = 1000000051;
    this.rr = paramf.aDC();
    paramf = (bfo)this.rr.hNK.hNQ;
    LinkedList localLinkedList = new LinkedList();
    if (!g.ajA().aiK())
    {
      AppMethodBeat.o(150815);
      return -1;
    }
    o[] arrayOfo = t.aJZ().pR(this.dnF);
    if ((arrayOfo != null) && (arrayOfo.length > 0))
    {
      i = 0;
      if (i < arrayOfo.length)
      {
        cha localcha = new cha();
        localcha.ukh = arrayOfo[i].id;
        if ((ac.iOD) && (this.dnF == 7))
        {
          ad.d("MicroMsg.NetSceneGetPackageList", "isShakeGetConfigList");
          localcha.Version = 0;
        }
        for (;;)
        {
          ad.d("MicroMsg.NetSceneGetPackageList", "package, id:%d, ver:%d", new Object[] { Integer.valueOf(localcha.ukh), Integer.valueOf(localcha.Version) });
          localLinkedList.add(localcha);
          i += 1;
          break;
          if ((12 == this.dnF) && (!i.fv(g.ajC().cachePath + "address")))
          {
            ad.i("MicroMsg.NetSceneGetPackageList", "MMRCPTADDRESS final save file not found, set pkg.Version=0");
            localcha.Version = 0;
          }
          else
          {
            localcha.Version = arrayOfo[i].version;
          }
        }
      }
    }
    paramf.nDj = localLinkedList;
    paramf.nDi = localLinkedList.size();
    paramf.nEf = this.dnF;
    if (this.flags != -1) {
      paramf.FuX = this.flags;
    }
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(150815);
    return i;
  }
  
  public final int getType()
  {
    return 159;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150817);
    ad.i("MicroMsg.NetSceneGetPackageList", "onGYNetEnd, netid:%d, errType:%d, errCode:%d, pkgType:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.dnF), paramString });
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150817);
      return;
    }
    paramq = (bfp)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    if (paramq.nEf != this.dnF)
    {
      ad.e("MicroMsg.NetSceneGetPackageList", "packageType is not consistent, respType = %d", new Object[] { Integer.valueOf(paramq.nEf) });
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(150817);
      return;
    }
    paramArrayOfByte = paramq.nDj;
    Object localObject1 = new StringBuilder("summer list size:");
    if (paramArrayOfByte == null)
    {
      paramInt1 = 0;
      ad.i("MicroMsg.NetSceneGetPackageList", paramInt1 + " packageType: " + this.dnF + " resp.Type: " + paramq.nEf);
      if (this.dnF != 2) {
        break label332;
      }
      i(paramArrayOfByte);
    }
    for (;;)
    {
      localObject1 = new xl();
      ((xl)localObject1).dLN.dLO = paramArrayOfByte;
      ((xl)localObject1).dLN.dnF = this.dnF;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
      if (paramq.FMr <= 0) {
        break label1391;
      }
      if (doScene(dispatcher(), this.callback) != -1) {
        break label1412;
      }
      this.callback.onSceneEnd(3, -1, "doScene failed", this);
      AppMethodBeat.o(150817);
      return;
      paramInt1 = paramArrayOfByte.size();
      break;
      label332:
      if (this.dnF == 1)
      {
        h(paramArrayOfByte);
      }
      else if (this.dnF == 4)
      {
        j(paramArrayOfByte);
      }
      else if (this.dnF == 6)
      {
        ad.i("MicroMsg.NetSceneGetPackageList", "change new egg.");
      }
      else if (this.dnF == 7)
      {
        k(paramArrayOfByte);
      }
      else if (this.dnF == 9)
      {
        g(paramArrayOfByte);
      }
      else
      {
        Object localObject2;
        if (this.dnF == 10)
        {
          if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
          {
            ad.e("MicroMsg.NetSceneGetPackageList", "empty mass send top config package");
          }
          else
          {
            ad.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + paramArrayOfByte.size());
            localObject2 = (cha)paramArrayOfByte.get(0);
            localObject1 = t.aJZ().dj(((cha)localObject2).ukh, this.dnF);
            localObject2 = a((cha)localObject2);
            ((o)localObject2).dDp = -1;
            if (localObject1 == null) {
              t.aJZ().a((o)localObject2);
            } else {
              t.aJZ().b((o)localObject2);
            }
          }
        }
        else if (this.dnF != 11) {
          if (this.dnF == 12) {
            m(paramArrayOfByte);
          } else if (this.dnF == 5) {
            n(paramArrayOfByte);
          } else if (this.dnF == 20) {
            l(paramArrayOfByte);
          } else if (this.dnF == 17)
          {
            if ((paramArrayOfByte == null) || (paramArrayOfByte.size() == 0))
            {
              ad.d("MicroMsg.NetSceneGetPackageList", "poi type is null");
            }
            else
            {
              localObject1 = (cha)paramArrayOfByte.get(0);
              ad.d("MicroMsg.NetSceneGetPackageList", ((cha)localObject1).Name + " - " + ((cha)localObject1).ukh + " - " + ((cha)localObject1).PackName + " - " + ((cha)localObject1).nEa);
              localObject2 = t.aJZ().dj(((cha)localObject1).ukh, this.dnF);
              o localo2 = a((cha)localObject1);
              localo2.dDp = -1;
              if (localObject2 == null) {
                t.aJZ().a(localo2);
              }
              for (;;)
              {
                for (;;)
                {
                  localObject2 = new ox();
                  try
                  {
                    ((ox)localObject2).dCN.content = z.a(((cha)localObject1).Fwu);
                    if (((ox)localObject2).dCN.content == null) {
                      break;
                    }
                    com.tencent.mm.sdk.b.a.IbL.a((com.tencent.mm.sdk.b.b)localObject2, Looper.getMainLooper());
                  }
                  catch (Exception localException)
                  {
                    ad.e("MicroMsg.NetSceneGetPackageList", localException.getMessage());
                  }
                }
                t.aJZ().b(localo2);
              }
            }
          }
          else if (this.dnF != 18) {
            if (this.dnF == 19)
            {
              ar(paramArrayOfByte);
            }
            else
            {
              o localo1;
              if (this.dnF == 21)
              {
                if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
                {
                  ad.d("MicroMsg.NetSceneGetPackageList", "summer trace config empty scene list");
                }
                else
                {
                  localObject2 = (cha)paramArrayOfByte.get(0);
                  ad.d("MicroMsg.NetSceneGetPackageList", "summer getpackage pkg: " + localObject2 + "|id = " + ((cha)localObject2).ukh + "|Name = " + ((cha)localObject2).Name + "|PackName = " + ((cha)localObject2).PackName + "|Size = " + ((cha)localObject2).nEa + "|Version = " + ((cha)localObject2).Version);
                  localo1 = t.aJZ().dj(((cha)localObject2).ukh, this.dnF);
                  localObject2 = a((cha)localObject2);
                  ((o)localObject2).dDp = -1;
                  if (localo1 == null) {
                    t.aJZ().a((o)localObject2);
                  } else if (localo1.version < ((o)localObject2).version) {
                    t.aJZ().b((o)localObject2);
                  } else {
                    ad.d("MicroMsg.NetSceneGetPackageList", "summer old version [%d] new version[%d], not need update", new Object[] { Integer.valueOf(localo1.version), Integer.valueOf(((o)localObject2).version) });
                  }
                }
              }
              else if (23 == this.dnF)
              {
                if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
                {
                  ad.d("MicroMsg.NetSceneGetPackageList", "permission tips config is empty");
                }
                else
                {
                  localObject2 = (cha)paramArrayOfByte.get(0);
                  ad.d("MicroMsg.NetSceneGetPackageList", "permission getpackage pkg: " + localObject2 + "|id = " + ((cha)localObject2).ukh + "|Name = " + ((cha)localObject2).Name + "|PackName = " + ((cha)localObject2).PackName + "|Size = " + ((cha)localObject2).nEa + "|Version = " + ((cha)localObject2).Version);
                  localo1 = t.aJZ().dj(((cha)localObject2).ukh, this.dnF);
                  localObject2 = a((cha)localObject2);
                  ((o)localObject2).dDp = -1;
                  if (localo1 == null) {
                    t.aJZ().a((o)localObject2);
                  } else if (localo1.version < ((o)localObject2).version) {
                    t.aJZ().b((o)localObject2);
                  }
                }
              }
              else if (this.dnF == 26) {
                as(paramArrayOfByte);
              } else if (this.dnF == 36) {
                at(paramArrayOfByte);
              } else if (this.dnF == 37) {
                o(paramArrayOfByte);
              }
            }
          }
        }
      }
    }
    label1391:
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150817);
    return;
    label1412:
    AppMethodBeat.o(150817);
  }
  
  public final int securityLimitCount()
  {
    return 20;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.hOp;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bc.l
 * JD-Core Version:    0.7.0.1
 */