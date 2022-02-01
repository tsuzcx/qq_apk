package com.tencent.mm.bb;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.a;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.g.a.oy;
import com.tencent.mm.g.a.oy.a;
import com.tencent.mm.g.a.xp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.c;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.bge;
import com.tencent.mm.protocal.protobuf.bgf;
import com.tencent.mm.protocal.protobuf.chu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class l
  extends n
  implements com.tencent.mm.ak.p, com.tencent.mm.network.k
{
  private f callback;
  private int doK;
  private int flags;
  private boolean img;
  private com.tencent.mm.ak.b rr;
  
  public l(int paramInt)
  {
    AppMethodBeat.i(150814);
    this.img = false;
    this.flags = -1;
    this.doK = paramInt;
    this.img = false;
    ae.d("MicroMsg.NetSceneGetPackageList", "Init dkregcode:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(150814);
  }
  
  public l(boolean paramBoolean)
  {
    AppMethodBeat.i(150813);
    this.img = false;
    this.flags = -1;
    this.doK = 26;
    this.img = false;
    ae.d("MicroMsg.NetSceneGetPackageList", "Init dkregcode:26");
    ae.d("MicroMsg.NetSceneGetPackageList", "isOnlyCheckInReqList: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      this.flags = 1;
    }
    AppMethodBeat.o(150813);
  }
  
  private o a(chu paramchu)
  {
    AppMethodBeat.i(150816);
    o localo = new o();
    localo.id = paramchu.uvE;
    localo.version = paramchu.Version;
    localo.name = paramchu.Name;
    localo.size = paramchu.nJv;
    localo.imo = paramchu.PackName;
    localo.status = 5;
    localo.duK = this.doK;
    AppMethodBeat.o(150816);
    return localo;
  }
  
  private void ar(List<chu> paramList)
  {
    AppMethodBeat.i(150825);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      ae.d("MicroMsg.NetSceneGetPackageList", "[oneliang]empty update expose scene list");
      AppMethodBeat.o(150825);
      return;
    }
    t.aKs();
    String str = p.aKp();
    int i = 0;
    if (i < paramList.size())
    {
      chu localchu = (chu)paramList.get(i);
      Object localObject = t.aKs().dj(localchu.uvE, this.doK);
      o localo;
      if ((localObject == null) || (((o)localObject).version != localchu.Version))
      {
        com.tencent.mm.vfs.o.deleteFile(str + t.aKs().dl(localchu.uvE, this.doK));
        localo = a(localchu);
        localo.dEu = -1;
        if (localObject != null) {
          break label225;
        }
        t.aKs().a(localo);
      }
      for (;;)
      {
        localObject = new k(localo.id, 19);
        g.ajQ().gDv.a((n)localObject, 0);
        ae.d("MicroMsg.NetSceneGetPackageList", "[oneliang]name:%s,packName:%s", new Object[] { localchu.Name, localchu.PackName });
        i += 1;
        break;
        label225:
        t.aKs().b(localo);
      }
    }
    AppMethodBeat.o(150825);
  }
  
  private void as(List<chu> paramList)
  {
    AppMethodBeat.i(150826);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ae.d("MicroMsg.NetSceneGetPackageList", "updateIPCallCountryCodeConfig, package list is empty");
      AppMethodBeat.o(150826);
      return;
    }
    ae.d("MicroMsg.NetSceneGetPackageList", "updateIPCallCountryCodeConfig, pkgList.size: %d", new Object[] { Integer.valueOf(paramList.size()) });
    int i = ((Integer)g.ajR().ajA().get(am.a.IMY, Integer.valueOf(-1))).intValue();
    ae.d("MicroMsg.NetSceneGetPackageList", "configPkgId: %d", new Object[] { Integer.valueOf(i) });
    if (i == -1)
    {
      AppMethodBeat.o(150826);
      return;
    }
    o localo1 = t.aKs().dj(i, this.doK);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      o localo2 = a((chu)paramList.next());
      ae.d("MicroMsg.NetSceneGetPackageList", "newInfo.id: %d, version: %d", new Object[] { Integer.valueOf(localo2.id), Integer.valueOf(localo2.version) });
      if ((localo1 != null) && (localo2.id == i))
      {
        ae.d("MicroMsg.NetSceneGetPackageList", "find match old pkg, update one");
        t.aKs().b(localo2);
        AppMethodBeat.o(150826);
        return;
      }
      if ((localo1 == null) && (localo2.id == i))
      {
        ae.d("MicroMsg.NetSceneGetPackageList", "insert new pkg");
        t.aKs().a(localo2);
        AppMethodBeat.o(150826);
        return;
      }
    }
    AppMethodBeat.o(150826);
  }
  
  private void at(List<chu> paramList)
  {
    AppMethodBeat.i(150827);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ae.d("MicroMsg.NetSceneGetPackageList", "update sense where location but package list is empty.");
      AppMethodBeat.o(150827);
      return;
    }
    ae.i("MicroMsg.NetSceneGetPackageList", "start update sense where location. package list size " + paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject2 = (chu)paramList.next();
      Object localObject1 = t.aKs().dj(((chu)localObject2).uvE, this.doK);
      if ((localObject1 == null) || (((o)localObject1).version != ((chu)localObject2).Version))
      {
        localObject2 = a((chu)localObject2);
        ((o)localObject2).dEu = -1;
        if (localObject1 == null) {
          t.aKs().a((o)localObject2);
        }
        for (;;)
        {
          localObject1 = new k(((o)localObject2).id, 36);
          g.ajQ().gDv.a((n)localObject1, 0);
          break;
          t.aKs().b((o)localObject2);
        }
      }
    }
    AppMethodBeat.o(150827);
  }
  
  private void g(LinkedList<chu> paramLinkedList)
  {
    AppMethodBeat.i(150818);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ae.d("MicroMsg.NetSceneGetPackageList", "empty upload speex config list");
      AppMethodBeat.o(150818);
      return;
    }
    t.aKs();
    String str = p.aKp();
    int i = 0;
    if (i < paramLinkedList.size())
    {
      chu localchu = (chu)paramLinkedList.get(i);
      Object localObject = t.aKs().dj(localchu.uvE, this.doK);
      o localo;
      if ((localObject == null) || (((o)localObject).version != localchu.Version))
      {
        com.tencent.mm.vfs.o.deleteFile(str + t.aKs().dl(localchu.uvE, this.doK));
        localo = a(localchu);
        localo.dEu = -1;
        if (localObject != null) {
          break label353;
        }
        t.aKs().a(localo);
      }
      for (;;)
      {
        localObject = new k(localo.id, 9);
        g.ajQ().gDv.a((n)localObject, 0);
        if (z.a(localchu.FOS) != null) {
          ae.v("MicroMsg.NetSceneGetPackageList", "xml:".concat(String.valueOf(new String(z.a(localchu.FOS)))));
        }
        if (z.a(localchu.Huc) != null) {
          ae.v("MicroMsg.NetSceneGetPackageList", "xml2:".concat(String.valueOf(new String(z.a(localchu.Huc)))));
        }
        ae.v("MicroMsg.NetSceneGetPackageList", "xml3:" + localchu.toString());
        ae.v("MicroMsg.NetSceneGetPackageList", "xml4:" + localchu.Name);
        ae.v("MicroMsg.NetSceneGetPackageList", "xml5:" + localchu.PackName);
        i += 1;
        break;
        label353:
        t.aKs().b(localo);
      }
    }
    AppMethodBeat.o(150818);
  }
  
  private void h(LinkedList<chu> paramLinkedList)
  {
    AppMethodBeat.i(150819);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ae.e("MicroMsg.NetSceneGetPackageList", "empty background pkg list");
      AppMethodBeat.o(150819);
      return;
    }
    t.aKs();
    String str = p.aKp();
    int i = 0;
    if (i < paramLinkedList.size())
    {
      Object localObject1 = (chu)paramLinkedList.get(i);
      Object localObject2 = t.aKs().dj(((chu)localObject1).uvE, this.doK);
      o localo;
      if ((localObject2 == null) || (((o)localObject2).version != ((chu)localObject1).Version))
      {
        com.tencent.mm.vfs.o.deleteFile(str + t.aKs().dl(((chu)localObject1).uvE, this.doK));
        localo = a((chu)localObject1);
        localo.dEu = -1;
        if (localObject2 != null) {
          break label294;
        }
      }
      label294:
      for (boolean bool = t.aKs().a(localo);; bool = t.aKs().b(localo))
      {
        ae.i("MicroMsg.NetSceneGetPackageList", "[updateBackgroundPkg] ret:%s newInfo:%s", new Object[] { Boolean.valueOf(bool), localo });
        localObject2 = z.a(((chu)localObject1).FOS);
        if ((localObject2 != null) && (localObject2.length > 0))
        {
          t.aKs();
          localObject1 = p.dk(((chu)localObject1).uvE, this.doK);
          com.tencent.mm.vfs.o.deleteFile(str + (String)localObject1);
          if (com.tencent.mm.vfs.o.e(str + (String)localObject1, (byte[])localObject2, localObject2.length) < 0) {
            ae.e("MicroMsg.NetSceneGetPackageList", "[updateBackgroundPkg] appendBuf thumb error!");
          }
        }
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(150819);
  }
  
  @Deprecated
  private void i(LinkedList<chu> paramLinkedList)
  {
    AppMethodBeat.i(150820);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ae.d("MicroMsg.NetSceneGetPackageList", "empty emoji pkg list");
      AppMethodBeat.o(150820);
      return;
    }
    int i = 0;
    if (i < paramLinkedList.size())
    {
      Object localObject1 = (chu)paramLinkedList.get(i);
      Object localObject2 = t.aKs().dj(((chu)localObject1).uvE, this.doK);
      o localo = a((chu)localObject1);
      localo.dEu = -1;
      if (localObject2 == null) {
        t.aKs().a(localo);
      }
      for (;;)
      {
        localObject1 = z.a(((chu)localObject1).FOS);
        if ((localObject1 != null) && (localObject1.length > 0))
        {
          localObject2 = new ArrayList();
          ((List)localObject2).add(new String((byte[])localObject1));
          ((List)localObject2).size();
        }
        i += 1;
        break;
        t.aKs().b(localo);
      }
    }
    AppMethodBeat.o(150820);
  }
  
  private void j(LinkedList<chu> paramLinkedList)
  {
    AppMethodBeat.i(150821);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ae.d("MicroMsg.NetSceneGetPackageList", "empty emoji pkg list");
      AppMethodBeat.o(150821);
      return;
    }
    ae.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + paramLinkedList.size());
    t.aKs();
    String str1 = p.aKp();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      chu localchu = (chu)paramLinkedList.get(i);
      o localo = t.aKs().dj(localchu.uvE, this.doK);
      byte[] arrayOfByte = z.a(localchu.FOS);
      if (localchu.FOS == null)
      {
        ae.e("MicroMsg.NetSceneGetPackageList", "error give me a null thumb it should be xml");
        i += 1;
      }
      else
      {
        String str2;
        Object localObject;
        if ((localo == null) || (localo.version != localchu.Version))
        {
          str2 = new String(arrayOfByte);
          localObject = "zh_CN";
          if (str2.indexOf("zh_CN") >= 0)
          {
            label180:
            str2 = (String)localObject + "_ARTIST.mm";
            com.tencent.mm.vfs.o.deleteFile(str1 + str2);
            com.tencent.mm.vfs.o.deleteFile(str1 + (String)localObject + "_ARTISTF.mm");
            com.tencent.mm.vfs.o.e(str1 + str2, arrayOfByte, arrayOfByte.length);
          }
        }
        else
        {
          localObject = a(localchu);
          ((o)localObject).dEu = -1;
          if (localo != null) {
            break label414;
          }
          t.aKs().a((o)localObject);
        }
        for (;;)
        {
          ae.d("MicroMsg.NetSceneGetPackageList", localchu.Name + " - " + localchu.uvE + " - " + localchu.PackName + " - " + localchu.nJv);
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
          t.aKs().b((o)localObject);
        }
      }
    }
    AppMethodBeat.o(150821);
  }
  
  private void k(LinkedList<chu> paramLinkedList)
  {
    AppMethodBeat.i(150822);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ae.d("MicroMsg.NetSceneGetPackageList", "empty config list");
      AppMethodBeat.o(150822);
      return;
    }
    ae.d("MicroMsg.NetSceneGetPackageList", "updateConfigList pkgList size " + paramLinkedList.size());
    int i = 0;
    if (i < paramLinkedList.size())
    {
      Object localObject1 = (chu)paramLinkedList.get(i);
      Object localObject2 = t.aKs().dj(((chu)localObject1).uvE, this.doK);
      Object localObject3 = a((chu)localObject1);
      ((o)localObject3).dEu = -1;
      if (localObject2 == null) {
        t.aKs().a((o)localObject3);
      }
      for (;;)
      {
        ae.d("MicroMsg.NetSceneGetPackageList", ((chu)localObject1).Name + " - " + ((chu)localObject1).uvE + " - " + ((chu)localObject1).PackName + " - " + ((chu)localObject1).nJv);
        localObject2 = z.a(((chu)localObject1).FOS);
        ae.d("MicroMsg.NetSceneGetPackageList", "ConfigList xml : ".concat(String.valueOf(new String((byte[])localObject2))));
        localObject3 = ((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).acM();
        int j = ((chu)localObject1).uvE;
        localObject1 = new com.tencent.mm.vfs.k(c.ggA);
        if (!((com.tencent.mm.vfs.k)localObject1).exists()) {
          ((com.tencent.mm.vfs.k)localObject1).mkdirs();
        }
        try
        {
          localObject1 = new com.tencent.mm.vfs.k(c.lE(j));
          if (!((com.tencent.mm.vfs.k)localObject1).exists()) {
            ((com.tencent.mm.vfs.k)localObject1).createNewFile();
          }
          com.tencent.mm.vfs.o.f(c.lE(j), (byte[])localObject2, localObject2.length);
          ((c)localObject3).w(j, new String((byte[])localObject2));
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ae.e("MicroMsg.ConfigListDecoder", "exception:%s", new Object[] { bu.o(localException) });
          }
        }
        i += 1;
        break;
        t.aKs().b((o)localObject3);
      }
    }
    AppMethodBeat.o(150822);
  }
  
  private void l(LinkedList<chu> paramLinkedList)
  {
    AppMethodBeat.i(150823);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ae.d("MicroMsg.NetSceneGetPackageList", "empty regioncode pkg list");
      AppMethodBeat.o(150823);
      return;
    }
    ae.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + paramLinkedList.size());
    paramLinkedList = paramLinkedList.iterator();
    if (paramLinkedList.hasNext())
    {
      chu localchu = (chu)paramLinkedList.next();
      o localo1 = t.aKs().dj(localchu.uvE, this.doK);
      o localo2 = a(localchu);
      localo2.dEu = -1;
      if (localo1 == null) {
        t.aKs().a(localo2);
      }
      for (;;)
      {
        ae.d("MicroMsg.NetSceneGetPackageList", localchu.Name + " - " + localchu.uvE + " - " + localchu.PackName + " - " + localchu.nJv);
        break;
        t.aKs().b(localo2);
      }
    }
    AppMethodBeat.o(150823);
  }
  
  private void m(LinkedList<chu> paramLinkedList)
  {
    AppMethodBeat.i(150824);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ae.e("MicroMsg.NetSceneGetPackageList", "empty address pkg list");
      AppMethodBeat.o(150824);
      return;
    }
    ae.i("MicroMsg.NetSceneGetPackageList", "updateRcptAddress pkgList size " + paramLinkedList.size());
    int i = 0;
    if (i < paramLinkedList.size())
    {
      Object localObject2 = (chu)paramLinkedList.get(i);
      Object localObject1 = t.aKs().dj(((chu)localObject2).uvE, this.doK);
      localObject2 = a((chu)localObject2);
      ((o)localObject2).dEu = -1;
      if (localObject1 == null) {
        t.aKs().a((o)localObject2);
      }
      for (;;)
      {
        localObject1 = new k(((o)localObject2).id, 12);
        g.ajQ().gDv.a((n)localObject1, 0);
        i += 1;
        break;
        t.aKs().b((o)localObject2);
      }
    }
    AppMethodBeat.o(150824);
  }
  
  private void n(LinkedList<chu> paramLinkedList)
  {
    AppMethodBeat.i(150828);
    ae.d("MicroMsg.NetSceneGetPackageList", "updateLangPkg");
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      ae.d("MicroMsg.NetSceneGetPackageList", "empty langage package list");
      AppMethodBeat.o(150828);
      return;
    }
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      Object localObject = (chu)paramLinkedList.next();
      ae.d("MicroMsg.NetSceneGetPackageList", "pkg.toString %s", new Object[] { localObject.toString() });
      o localo = t.aKs().dj(((chu)localObject).uvE, this.doK);
      localObject = a((chu)localObject);
      ((o)localObject).dEu = -1;
      if (localo == null) {
        t.aKs().a((o)localObject);
      } else {
        t.aKs().b((o)localObject);
      }
    }
    AppMethodBeat.o(150828);
  }
  
  private void o(LinkedList<chu> paramLinkedList)
  {
    AppMethodBeat.i(150829);
    ae.d("MicroMsg.NetSceneGetPackageList", "updateAppleEmojiPackage");
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      ae.d("MicroMsg.NetSceneGetPackageList", "update apple emoji but package list is empty.");
      AppMethodBeat.o(150829);
      return;
    }
    ae.i("MicroMsg.NetSceneGetPackageList", "start update apple emoji. package list size " + paramLinkedList.size());
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      Object localObject2 = (chu)paramLinkedList.next();
      Object localObject1 = t.aKs().dj(((chu)localObject2).uvE, this.doK);
      if ((localObject1 == null) || (((o)localObject1).version != ((chu)localObject2).Version))
      {
        localObject2 = a((chu)localObject2);
        ((o)localObject2).dEu = -1;
        if (localObject1 == null) {
          t.aKs().a((o)localObject2);
        }
        for (;;)
        {
          localObject1 = new k(((o)localObject2).id, 37);
          g.ajQ().gDv.a((n)localObject1, 0);
          break;
          t.aKs().b((o)localObject2);
        }
      }
    }
    AppMethodBeat.o(150829);
  }
  
  public final int aFc()
  {
    return this.doK;
  }
  
  public final boolean acceptConcurrent(n paramn)
  {
    if (!(paramn instanceof l)) {}
    while (this.doK != ((l)paramn).doK) {
      return true;
    }
    return false;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(150815);
    this.callback = paramf;
    ae.d("MicroMsg.NetSceneGetPackageList", "DoScene dkregcode :" + this.doK);
    paramf = new b.a();
    paramf.hQF = new bge();
    paramf.hQG = new bgf();
    paramf.uri = "/cgi-bin/micromsg-bin/getpackagelist";
    paramf.funcId = 159;
    paramf.hQH = 51;
    paramf.respCmdId = 1000000051;
    this.rr = paramf.aDS();
    paramf = (bge)this.rr.hQD.hQJ;
    LinkedList localLinkedList = new LinkedList();
    if (!g.ajP().aiZ())
    {
      AppMethodBeat.o(150815);
      return -1;
    }
    o[] arrayOfo = t.aKs().pU(this.doK);
    if ((arrayOfo != null) && (arrayOfo.length > 0))
    {
      i = 0;
      if (i < arrayOfo.length)
      {
        chu localchu = new chu();
        localchu.uvE = arrayOfo[i].id;
        if ((ac.iRx) && (this.doK == 7))
        {
          ae.d("MicroMsg.NetSceneGetPackageList", "isShakeGetConfigList");
          localchu.Version = 0;
        }
        for (;;)
        {
          ae.d("MicroMsg.NetSceneGetPackageList", "package, id:%d, ver:%d", new Object[] { Integer.valueOf(localchu.uvE), Integer.valueOf(localchu.Version) });
          localLinkedList.add(localchu);
          i += 1;
          break;
          if ((12 == this.doK) && (!com.tencent.mm.vfs.o.fB(g.ajR().cachePath + "address")))
          {
            ae.i("MicroMsg.NetSceneGetPackageList", "MMRCPTADDRESS final save file not found, set pkg.Version=0");
            localchu.Version = 0;
          }
          else
          {
            localchu.Version = arrayOfo[i].version;
          }
        }
      }
    }
    paramf.nIE = localLinkedList;
    paramf.nID = localLinkedList.size();
    paramf.nJA = this.doK;
    if (this.flags != -1) {
      paramf.FNv = this.flags;
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
    ae.i("MicroMsg.NetSceneGetPackageList", "onGYNetEnd, netid:%d, errType:%d, errCode:%d, pkgType:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.doK), paramString });
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150817);
      return;
    }
    paramq = (bgf)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    if (paramq.nJA != this.doK)
    {
      ae.e("MicroMsg.NetSceneGetPackageList", "packageType is not consistent, respType = %d", new Object[] { Integer.valueOf(paramq.nJA) });
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(150817);
      return;
    }
    paramArrayOfByte = paramq.nIE;
    Object localObject1 = new StringBuilder("summer list size:");
    if (paramArrayOfByte == null)
    {
      paramInt1 = 0;
      ae.i("MicroMsg.NetSceneGetPackageList", paramInt1 + " packageType: " + this.doK + " resp.Type: " + paramq.nJA);
      if (this.doK != 2) {
        break label332;
      }
      i(paramArrayOfByte);
    }
    for (;;)
    {
      localObject1 = new xp();
      ((xp)localObject1).dNc.dNd = paramArrayOfByte;
      ((xp)localObject1).dNc.doK = this.doK;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
      if (paramq.GeQ <= 0) {
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
      if (this.doK == 1)
      {
        h(paramArrayOfByte);
      }
      else if (this.doK == 4)
      {
        j(paramArrayOfByte);
      }
      else if (this.doK == 6)
      {
        ae.i("MicroMsg.NetSceneGetPackageList", "change new egg.");
      }
      else if (this.doK == 7)
      {
        k(paramArrayOfByte);
      }
      else if (this.doK == 9)
      {
        g(paramArrayOfByte);
      }
      else
      {
        Object localObject2;
        if (this.doK == 10)
        {
          if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
          {
            ae.e("MicroMsg.NetSceneGetPackageList", "empty mass send top config package");
          }
          else
          {
            ae.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + paramArrayOfByte.size());
            localObject2 = (chu)paramArrayOfByte.get(0);
            localObject1 = t.aKs().dj(((chu)localObject2).uvE, this.doK);
            localObject2 = a((chu)localObject2);
            ((o)localObject2).dEu = -1;
            if (localObject1 == null) {
              t.aKs().a((o)localObject2);
            } else {
              t.aKs().b((o)localObject2);
            }
          }
        }
        else if (this.doK != 11) {
          if (this.doK == 12) {
            m(paramArrayOfByte);
          } else if (this.doK == 5) {
            n(paramArrayOfByte);
          } else if (this.doK == 20) {
            l(paramArrayOfByte);
          } else if (this.doK == 17)
          {
            if ((paramArrayOfByte == null) || (paramArrayOfByte.size() == 0))
            {
              ae.d("MicroMsg.NetSceneGetPackageList", "poi type is null");
            }
            else
            {
              localObject1 = (chu)paramArrayOfByte.get(0);
              ae.d("MicroMsg.NetSceneGetPackageList", ((chu)localObject1).Name + " - " + ((chu)localObject1).uvE + " - " + ((chu)localObject1).PackName + " - " + ((chu)localObject1).nJv);
              localObject2 = t.aKs().dj(((chu)localObject1).uvE, this.doK);
              o localo2 = a((chu)localObject1);
              localo2.dEu = -1;
              if (localObject2 == null) {
                t.aKs().a(localo2);
              }
              for (;;)
              {
                for (;;)
                {
                  localObject2 = new oy();
                  try
                  {
                    ((oy)localObject2).dDS.content = z.a(((chu)localObject1).FOS);
                    if (((oy)localObject2).dDS.content == null) {
                      break;
                    }
                    com.tencent.mm.sdk.b.a.IvT.a((com.tencent.mm.sdk.b.b)localObject2, Looper.getMainLooper());
                  }
                  catch (Exception localException)
                  {
                    ae.e("MicroMsg.NetSceneGetPackageList", localException.getMessage());
                  }
                }
                t.aKs().b(localo2);
              }
            }
          }
          else if (this.doK != 18) {
            if (this.doK == 19)
            {
              ar(paramArrayOfByte);
            }
            else
            {
              o localo1;
              if (this.doK == 21)
              {
                if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
                {
                  ae.d("MicroMsg.NetSceneGetPackageList", "summer trace config empty scene list");
                }
                else
                {
                  localObject2 = (chu)paramArrayOfByte.get(0);
                  ae.d("MicroMsg.NetSceneGetPackageList", "summer getpackage pkg: " + localObject2 + "|id = " + ((chu)localObject2).uvE + "|Name = " + ((chu)localObject2).Name + "|PackName = " + ((chu)localObject2).PackName + "|Size = " + ((chu)localObject2).nJv + "|Version = " + ((chu)localObject2).Version);
                  localo1 = t.aKs().dj(((chu)localObject2).uvE, this.doK);
                  localObject2 = a((chu)localObject2);
                  ((o)localObject2).dEu = -1;
                  if (localo1 == null) {
                    t.aKs().a((o)localObject2);
                  } else if (localo1.version < ((o)localObject2).version) {
                    t.aKs().b((o)localObject2);
                  } else {
                    ae.d("MicroMsg.NetSceneGetPackageList", "summer old version [%d] new version[%d], not need update", new Object[] { Integer.valueOf(localo1.version), Integer.valueOf(((o)localObject2).version) });
                  }
                }
              }
              else if (23 == this.doK)
              {
                if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
                {
                  ae.d("MicroMsg.NetSceneGetPackageList", "permission tips config is empty");
                }
                else
                {
                  localObject2 = (chu)paramArrayOfByte.get(0);
                  ae.d("MicroMsg.NetSceneGetPackageList", "permission getpackage pkg: " + localObject2 + "|id = " + ((chu)localObject2).uvE + "|Name = " + ((chu)localObject2).Name + "|PackName = " + ((chu)localObject2).PackName + "|Size = " + ((chu)localObject2).nJv + "|Version = " + ((chu)localObject2).Version);
                  localo1 = t.aKs().dj(((chu)localObject2).uvE, this.doK);
                  localObject2 = a((chu)localObject2);
                  ((o)localObject2).dEu = -1;
                  if (localo1 == null) {
                    t.aKs().a((o)localObject2);
                  } else if (localo1.version < ((o)localObject2).version) {
                    t.aKs().b((o)localObject2);
                  }
                }
              }
              else if (this.doK == 26) {
                as(paramArrayOfByte);
              } else if (this.doK == 36) {
                at(paramArrayOfByte);
              } else if (this.doK == 37) {
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
    return n.b.hRi;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bb.l
 * JD-Core Version:    0.7.0.1
 */