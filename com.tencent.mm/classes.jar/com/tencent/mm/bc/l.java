package com.tencent.mm.bc;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.a;
import com.tencent.mm.al.n.b;
import com.tencent.mm.g.a.of;
import com.tencent.mm.g.a.of.a;
import com.tencent.mm.g.a.wh;
import com.tencent.mm.m.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.axs;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.bxo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class l
  extends n
  implements com.tencent.mm.al.p, com.tencent.mm.network.k
{
  private com.tencent.mm.al.g callback;
  private int deP;
  private int flags;
  private boolean hpx;
  private com.tencent.mm.al.b rr;
  
  public l(int paramInt)
  {
    AppMethodBeat.i(150814);
    this.hpx = false;
    this.flags = -1;
    this.deP = paramInt;
    this.hpx = false;
    ad.d("MicroMsg.NetSceneGetPackageList", "Init dkregcode:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(150814);
  }
  
  public l(boolean paramBoolean)
  {
    AppMethodBeat.i(150813);
    this.hpx = false;
    this.flags = -1;
    this.deP = 26;
    this.hpx = false;
    ad.d("MicroMsg.NetSceneGetPackageList", "Init dkregcode:26");
    ad.d("MicroMsg.NetSceneGetPackageList", "isOnlyCheckInReqList: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      this.flags = 1;
    }
    AppMethodBeat.o(150813);
  }
  
  private o a(bxo parambxo)
  {
    AppMethodBeat.i(150816);
    o localo = new o();
    localo.id = parambxo.sdO;
    localo.version = parambxo.Version;
    localo.name = parambxo.Name;
    localo.size = parambxo.mBC;
    localo.hpF = parambxo.PackName;
    localo.status = 5;
    localo.dkC = this.deP;
    AppMethodBeat.o(150816);
    return localo;
  }
  
  private void at(List<bxo> paramList)
  {
    AppMethodBeat.i(150825);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      ad.d("MicroMsg.NetSceneGetPackageList", "[oneliang]empty update expose scene list");
      AppMethodBeat.o(150825);
      return;
    }
    t.azY();
    String str = p.azV();
    int i = 0;
    if (i < paramList.size())
    {
      bxo localbxo = (bxo)paramList.get(i);
      Object localObject = t.azY().dg(localbxo.sdO, this.deP);
      o localo;
      if ((localObject == null) || (((o)localObject).version != localbxo.Version))
      {
        i.deleteFile(str + t.azY().di(localbxo.sdO, this.deP));
        localo = a(localbxo);
        localo.dtM = -1;
        if (localObject != null) {
          break label225;
        }
        t.azY().a(localo);
      }
      for (;;)
      {
        localObject = new k(localo.id, 19);
        com.tencent.mm.kernel.g.afA().gcy.a((n)localObject, 0);
        ad.d("MicroMsg.NetSceneGetPackageList", "[oneliang]name:%s,packName:%s", new Object[] { localbxo.Name, localbxo.PackName });
        i += 1;
        break;
        label225:
        t.azY().b(localo);
      }
    }
    AppMethodBeat.o(150825);
  }
  
  private void au(List<bxo> paramList)
  {
    AppMethodBeat.i(150826);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ad.d("MicroMsg.NetSceneGetPackageList", "updateIPCallCountryCodeConfig, package list is empty");
      AppMethodBeat.o(150826);
      return;
    }
    ad.d("MicroMsg.NetSceneGetPackageList", "updateIPCallCountryCodeConfig, pkgList.size: %d", new Object[] { Integer.valueOf(paramList.size()) });
    int i = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fiv, Integer.valueOf(-1))).intValue();
    ad.d("MicroMsg.NetSceneGetPackageList", "configPkgId: %d", new Object[] { Integer.valueOf(i) });
    if (i == -1)
    {
      AppMethodBeat.o(150826);
      return;
    }
    o localo1 = t.azY().dg(i, this.deP);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      o localo2 = a((bxo)paramList.next());
      ad.d("MicroMsg.NetSceneGetPackageList", "newInfo.id: %d, version: %d", new Object[] { Integer.valueOf(localo2.id), Integer.valueOf(localo2.version) });
      if ((localo1 != null) && (localo2.id == i))
      {
        ad.d("MicroMsg.NetSceneGetPackageList", "find match old pkg, update one");
        t.azY().b(localo2);
        AppMethodBeat.o(150826);
        return;
      }
      if ((localo1 == null) && (localo2.id == i))
      {
        ad.d("MicroMsg.NetSceneGetPackageList", "insert new pkg");
        t.azY().a(localo2);
        AppMethodBeat.o(150826);
        return;
      }
    }
    AppMethodBeat.o(150826);
  }
  
  private void av(List<bxo> paramList)
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
      Object localObject2 = (bxo)paramList.next();
      Object localObject1 = t.azY().dg(((bxo)localObject2).sdO, this.deP);
      if ((localObject1 == null) || (((o)localObject1).version != ((bxo)localObject2).Version))
      {
        localObject2 = a((bxo)localObject2);
        ((o)localObject2).dtM = -1;
        if (localObject1 == null) {
          t.azY().a((o)localObject2);
        }
        for (;;)
        {
          localObject1 = new k(((o)localObject2).id, 36);
          com.tencent.mm.kernel.g.afA().gcy.a((n)localObject1, 0);
          break;
          t.azY().b((o)localObject2);
        }
      }
    }
    AppMethodBeat.o(150827);
  }
  
  private void g(LinkedList<bxo> paramLinkedList)
  {
    AppMethodBeat.i(150818);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ad.d("MicroMsg.NetSceneGetPackageList", "empty upload speex config list");
      AppMethodBeat.o(150818);
      return;
    }
    t.azY();
    String str = p.azV();
    int i = 0;
    if (i < paramLinkedList.size())
    {
      bxo localbxo = (bxo)paramLinkedList.get(i);
      Object localObject = t.azY().dg(localbxo.sdO, this.deP);
      o localo;
      if ((localObject == null) || (((o)localObject).version != localbxo.Version))
      {
        i.deleteFile(str + t.azY().di(localbxo.sdO, this.deP));
        localo = a(localbxo);
        localo.dtM = -1;
        if (localObject != null) {
          break label353;
        }
        t.azY().a(localo);
      }
      for (;;)
      {
        localObject = new k(localo.id, 9);
        com.tencent.mm.kernel.g.afA().gcy.a((n)localObject, 0);
        if (z.a(localbxo.CyG) != null) {
          ad.v("MicroMsg.NetSceneGetPackageList", "xml:".concat(String.valueOf(new String(z.a(localbxo.CyG)))));
        }
        if (z.a(localbxo.DUf) != null) {
          ad.v("MicroMsg.NetSceneGetPackageList", "xml2:".concat(String.valueOf(new String(z.a(localbxo.DUf)))));
        }
        ad.v("MicroMsg.NetSceneGetPackageList", "xml3:" + localbxo.toString());
        ad.v("MicroMsg.NetSceneGetPackageList", "xml4:" + localbxo.Name);
        ad.v("MicroMsg.NetSceneGetPackageList", "xml5:" + localbxo.PackName);
        i += 1;
        break;
        label353:
        t.azY().b(localo);
      }
    }
    AppMethodBeat.o(150818);
  }
  
  private void h(LinkedList<bxo> paramLinkedList)
  {
    AppMethodBeat.i(150819);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ad.e("MicroMsg.NetSceneGetPackageList", "empty background pkg list");
      AppMethodBeat.o(150819);
      return;
    }
    t.azY();
    String str = p.azV();
    int i = 0;
    if (i < paramLinkedList.size())
    {
      Object localObject1 = (bxo)paramLinkedList.get(i);
      Object localObject2 = t.azY().dg(((bxo)localObject1).sdO, this.deP);
      o localo;
      if ((localObject2 == null) || (((o)localObject2).version != ((bxo)localObject1).Version))
      {
        i.deleteFile(str + t.azY().di(((bxo)localObject1).sdO, this.deP));
        localo = a((bxo)localObject1);
        localo.dtM = -1;
        if (localObject2 != null) {
          break label294;
        }
      }
      label294:
      for (boolean bool = t.azY().a(localo);; bool = t.azY().b(localo))
      {
        ad.i("MicroMsg.NetSceneGetPackageList", "[updateBackgroundPkg] ret:%s newInfo:%s", new Object[] { Boolean.valueOf(bool), localo });
        localObject2 = z.a(((bxo)localObject1).CyG);
        if ((localObject2 != null) && (localObject2.length > 0))
        {
          t.azY();
          localObject1 = p.dh(((bxo)localObject1).sdO, this.deP);
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
  private void i(LinkedList<bxo> paramLinkedList)
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
      Object localObject1 = (bxo)paramLinkedList.get(i);
      Object localObject2 = t.azY().dg(((bxo)localObject1).sdO, this.deP);
      o localo = a((bxo)localObject1);
      localo.dtM = -1;
      if (localObject2 == null) {
        t.azY().a(localo);
      }
      for (;;)
      {
        localObject1 = z.a(((bxo)localObject1).CyG);
        if ((localObject1 != null) && (localObject1.length > 0))
        {
          localObject2 = new ArrayList();
          ((List)localObject2).add(new String((byte[])localObject1));
          ((List)localObject2).size();
        }
        i += 1;
        break;
        t.azY().b(localo);
      }
    }
    AppMethodBeat.o(150820);
  }
  
  private void j(LinkedList<bxo> paramLinkedList)
  {
    AppMethodBeat.i(150821);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ad.d("MicroMsg.NetSceneGetPackageList", "empty emoji pkg list");
      AppMethodBeat.o(150821);
      return;
    }
    ad.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + paramLinkedList.size());
    t.azY();
    String str1 = p.azV();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      bxo localbxo = (bxo)paramLinkedList.get(i);
      o localo = t.azY().dg(localbxo.sdO, this.deP);
      byte[] arrayOfByte = z.a(localbxo.CyG);
      if (localbxo.CyG == null)
      {
        ad.e("MicroMsg.NetSceneGetPackageList", "error give me a null thumb it should be xml");
        i += 1;
      }
      else
      {
        String str2;
        Object localObject;
        if ((localo == null) || (localo.version != localbxo.Version))
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
          localObject = a(localbxo);
          ((o)localObject).dtM = -1;
          if (localo != null) {
            break label414;
          }
          t.azY().a((o)localObject);
        }
        for (;;)
        {
          ad.d("MicroMsg.NetSceneGetPackageList", localbxo.Name + " - " + localbxo.sdO + " - " + localbxo.PackName + " - " + localbxo.mBC);
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
          t.azY().b((o)localObject);
        }
      }
    }
    AppMethodBeat.o(150821);
  }
  
  private void k(LinkedList<bxo> paramLinkedList)
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
      Object localObject1 = (bxo)paramLinkedList.get(i);
      Object localObject2 = t.azY().dg(((bxo)localObject1).sdO, this.deP);
      Object localObject3 = a((bxo)localObject1);
      ((o)localObject3).dtM = -1;
      if (localObject2 == null) {
        t.azY().a((o)localObject3);
      }
      for (;;)
      {
        ad.d("MicroMsg.NetSceneGetPackageList", ((bxo)localObject1).Name + " - " + ((bxo)localObject1).sdO + " - " + ((bxo)localObject1).PackName + " - " + ((bxo)localObject1).mBC);
        localObject2 = z.a(((bxo)localObject1).CyG);
        ad.d("MicroMsg.NetSceneGetPackageList", "ConfigList xml : ".concat(String.valueOf(new String((byte[])localObject2))));
        localObject3 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Ze();
        int j = ((bxo)localObject1).sdO;
        localObject1 = new com.tencent.mm.vfs.e(c.fHk);
        if (!((com.tencent.mm.vfs.e)localObject1).exists()) {
          ((com.tencent.mm.vfs.e)localObject1).mkdirs();
        }
        try
        {
          localObject1 = new com.tencent.mm.vfs.e(c.lj(j));
          if (!((com.tencent.mm.vfs.e)localObject1).exists()) {
            ((com.tencent.mm.vfs.e)localObject1).createNewFile();
          }
          i.f(c.lj(j), (byte[])localObject2, localObject2.length);
          ((c)localObject3).w(j, new String((byte[])localObject2));
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.e("MicroMsg.ConfigListDecoder", "exception:%s", new Object[] { bt.m(localException) });
          }
        }
        i += 1;
        break;
        t.azY().b((o)localObject3);
      }
    }
    AppMethodBeat.o(150822);
  }
  
  private void l(LinkedList<bxo> paramLinkedList)
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
      bxo localbxo = (bxo)paramLinkedList.next();
      o localo1 = t.azY().dg(localbxo.sdO, this.deP);
      o localo2 = a(localbxo);
      localo2.dtM = -1;
      if (localo1 == null) {
        t.azY().a(localo2);
      }
      for (;;)
      {
        ad.d("MicroMsg.NetSceneGetPackageList", localbxo.Name + " - " + localbxo.sdO + " - " + localbxo.PackName + " - " + localbxo.mBC);
        break;
        t.azY().b(localo2);
      }
    }
    AppMethodBeat.o(150823);
  }
  
  private void m(LinkedList<bxo> paramLinkedList)
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
      Object localObject2 = (bxo)paramLinkedList.get(i);
      Object localObject1 = t.azY().dg(((bxo)localObject2).sdO, this.deP);
      localObject2 = a((bxo)localObject2);
      ((o)localObject2).dtM = -1;
      if (localObject1 == null) {
        t.azY().a((o)localObject2);
      }
      for (;;)
      {
        localObject1 = new k(((o)localObject2).id, 12);
        com.tencent.mm.kernel.g.afA().gcy.a((n)localObject1, 0);
        i += 1;
        break;
        t.azY().b((o)localObject2);
      }
    }
    AppMethodBeat.o(150824);
  }
  
  private void n(LinkedList<bxo> paramLinkedList)
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
      Object localObject = (bxo)paramLinkedList.next();
      ad.d("MicroMsg.NetSceneGetPackageList", "pkg.toString %s", new Object[] { localObject.toString() });
      o localo = t.azY().dg(((bxo)localObject).sdO, this.deP);
      localObject = a((bxo)localObject);
      ((o)localObject).dtM = -1;
      if (localo == null) {
        t.azY().a((o)localObject);
      } else {
        t.azY().b((o)localObject);
      }
    }
    AppMethodBeat.o(150828);
  }
  
  private void o(LinkedList<bxo> paramLinkedList)
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
      Object localObject2 = (bxo)paramLinkedList.next();
      Object localObject1 = t.azY().dg(((bxo)localObject2).sdO, this.deP);
      if ((localObject1 == null) || (((o)localObject1).version != ((bxo)localObject2).Version))
      {
        localObject2 = a((bxo)localObject2);
        ((o)localObject2).dtM = -1;
        if (localObject1 == null) {
          t.azY().a((o)localObject2);
        }
        for (;;)
        {
          localObject1 = new k(((o)localObject2).id, 37);
          com.tencent.mm.kernel.g.afA().gcy.a((n)localObject1, 0);
          break;
          t.azY().b((o)localObject2);
        }
      }
    }
    AppMethodBeat.o(150829);
  }
  
  public final boolean acceptConcurrent(n paramn)
  {
    if (!(paramn instanceof l)) {}
    while (this.deP != ((l)paramn).deP) {
      return true;
    }
    return false;
  }
  
  public final int auQ()
  {
    return this.deP;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(150815);
    this.callback = paramg;
    ad.d("MicroMsg.NetSceneGetPackageList", "DoScene dkregcode :" + this.deP);
    paramg = new b.a();
    paramg.gUU = new axs();
    paramg.gUV = new axt();
    paramg.uri = "/cgi-bin/micromsg-bin/getpackagelist";
    paramg.funcId = 159;
    paramg.reqCmdId = 51;
    paramg.respCmdId = 1000000051;
    this.rr = paramg.atI();
    paramg = (axs)this.rr.gUS.gUX;
    LinkedList localLinkedList = new LinkedList();
    if (!com.tencent.mm.kernel.g.afz().aeI())
    {
      AppMethodBeat.o(150815);
      return -1;
    }
    o[] arrayOfo = t.azY().oA(this.deP);
    if ((arrayOfo != null) && (arrayOfo.length > 0))
    {
      i = 0;
      if (i < arrayOfo.length)
      {
        bxo localbxo = new bxo();
        localbxo.sdO = arrayOfo[i].id;
        if ((com.tencent.mm.platformtools.ab.hVs) && (this.deP == 7))
        {
          ad.d("MicroMsg.NetSceneGetPackageList", "isShakeGetConfigList");
          localbxo.Version = 0;
        }
        for (;;)
        {
          ad.d("MicroMsg.NetSceneGetPackageList", "package, id:%d, ver:%d", new Object[] { Integer.valueOf(localbxo.sdO), Integer.valueOf(localbxo.Version) });
          localLinkedList.add(localbxo);
          i += 1;
          break;
          if ((12 == this.deP) && (!i.eK(com.tencent.mm.kernel.g.afB().cachePath + "address")))
          {
            ad.i("MicroMsg.NetSceneGetPackageList", "MMRCPTADDRESS final save file not found, set pkg.Version=0");
            localbxo.Version = 0;
          }
          else
          {
            localbxo.Version = arrayOfo[i].version;
          }
        }
      }
    }
    paramg.mAL = localLinkedList;
    paramg.mAK = localLinkedList.size();
    paramg.mBH = this.deP;
    if (this.flags != -1) {
      paramg.Cxm = this.flags;
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
    ad.i("MicroMsg.NetSceneGetPackageList", "onGYNetEnd, netid:%d, errType:%d, errCode:%d, pkgType:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.deP), paramString });
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150817);
      return;
    }
    paramq = (axt)((com.tencent.mm.al.b)paramq).gUT.gUX;
    if (paramq.mBH != this.deP)
    {
      ad.e("MicroMsg.NetSceneGetPackageList", "packageType is not consistent, respType = %d", new Object[] { Integer.valueOf(paramq.mBH) });
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(150817);
      return;
    }
    paramArrayOfByte = paramq.mAL;
    Object localObject1 = new StringBuilder("summer list size:");
    if (paramArrayOfByte == null)
    {
      paramInt1 = 0;
      ad.i("MicroMsg.NetSceneGetPackageList", paramInt1 + " packageType: " + this.deP + " resp.Type: " + paramq.mBH);
      if (this.deP != 2) {
        break label332;
      }
      i(paramArrayOfByte);
    }
    for (;;)
    {
      localObject1 = new wh();
      ((wh)localObject1).dBN.dBO = paramArrayOfByte;
      ((wh)localObject1).dBN.deP = this.deP;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
      if (paramq.CNq <= 0) {
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
      if (this.deP == 1)
      {
        h(paramArrayOfByte);
      }
      else if (this.deP == 4)
      {
        j(paramArrayOfByte);
      }
      else if (this.deP == 6)
      {
        ad.i("MicroMsg.NetSceneGetPackageList", "change new egg.");
      }
      else if (this.deP == 7)
      {
        k(paramArrayOfByte);
      }
      else if (this.deP == 9)
      {
        g(paramArrayOfByte);
      }
      else
      {
        Object localObject2;
        if (this.deP == 10)
        {
          if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
          {
            ad.e("MicroMsg.NetSceneGetPackageList", "empty mass send top config package");
          }
          else
          {
            ad.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + paramArrayOfByte.size());
            localObject2 = (bxo)paramArrayOfByte.get(0);
            localObject1 = t.azY().dg(((bxo)localObject2).sdO, this.deP);
            localObject2 = a((bxo)localObject2);
            ((o)localObject2).dtM = -1;
            if (localObject1 == null) {
              t.azY().a((o)localObject2);
            } else {
              t.azY().b((o)localObject2);
            }
          }
        }
        else if (this.deP != 11) {
          if (this.deP == 12) {
            m(paramArrayOfByte);
          } else if (this.deP == 5) {
            n(paramArrayOfByte);
          } else if (this.deP == 20) {
            l(paramArrayOfByte);
          } else if (this.deP == 17)
          {
            if ((paramArrayOfByte == null) || (paramArrayOfByte.size() == 0))
            {
              ad.d("MicroMsg.NetSceneGetPackageList", "poi type is null");
            }
            else
            {
              localObject1 = (bxo)paramArrayOfByte.get(0);
              ad.d("MicroMsg.NetSceneGetPackageList", ((bxo)localObject1).Name + " - " + ((bxo)localObject1).sdO + " - " + ((bxo)localObject1).PackName + " - " + ((bxo)localObject1).mBC);
              localObject2 = t.azY().dg(((bxo)localObject1).sdO, this.deP);
              o localo2 = a((bxo)localObject1);
              localo2.dtM = -1;
              if (localObject2 == null) {
                t.azY().a(localo2);
              }
              for (;;)
              {
                for (;;)
                {
                  localObject2 = new of();
                  try
                  {
                    ((of)localObject2).dtm.content = z.a(((bxo)localObject1).CyG);
                    if (((of)localObject2).dtm.content == null) {
                      break;
                    }
                    com.tencent.mm.sdk.b.a.ESL.a((com.tencent.mm.sdk.b.b)localObject2, Looper.getMainLooper());
                  }
                  catch (Exception localException)
                  {
                    ad.e("MicroMsg.NetSceneGetPackageList", localException.getMessage());
                  }
                }
                t.azY().b(localo2);
              }
            }
          }
          else if (this.deP != 18) {
            if (this.deP == 19)
            {
              at(paramArrayOfByte);
            }
            else
            {
              o localo1;
              if (this.deP == 21)
              {
                if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
                {
                  ad.d("MicroMsg.NetSceneGetPackageList", "summer trace config empty scene list");
                }
                else
                {
                  localObject2 = (bxo)paramArrayOfByte.get(0);
                  ad.d("MicroMsg.NetSceneGetPackageList", "summer getpackage pkg: " + localObject2 + "|id = " + ((bxo)localObject2).sdO + "|Name = " + ((bxo)localObject2).Name + "|PackName = " + ((bxo)localObject2).PackName + "|Size = " + ((bxo)localObject2).mBC + "|Version = " + ((bxo)localObject2).Version);
                  localo1 = t.azY().dg(((bxo)localObject2).sdO, this.deP);
                  localObject2 = a((bxo)localObject2);
                  ((o)localObject2).dtM = -1;
                  if (localo1 == null) {
                    t.azY().a((o)localObject2);
                  } else if (localo1.version < ((o)localObject2).version) {
                    t.azY().b((o)localObject2);
                  } else {
                    ad.d("MicroMsg.NetSceneGetPackageList", "summer old version [%d] new version[%d], not need update", new Object[] { Integer.valueOf(localo1.version), Integer.valueOf(((o)localObject2).version) });
                  }
                }
              }
              else if (23 == this.deP)
              {
                if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
                {
                  ad.d("MicroMsg.NetSceneGetPackageList", "permission tips config is empty");
                }
                else
                {
                  localObject2 = (bxo)paramArrayOfByte.get(0);
                  ad.d("MicroMsg.NetSceneGetPackageList", "permission getpackage pkg: " + localObject2 + "|id = " + ((bxo)localObject2).sdO + "|Name = " + ((bxo)localObject2).Name + "|PackName = " + ((bxo)localObject2).PackName + "|Size = " + ((bxo)localObject2).mBC + "|Version = " + ((bxo)localObject2).Version);
                  localo1 = t.azY().dg(((bxo)localObject2).sdO, this.deP);
                  localObject2 = a((bxo)localObject2);
                  ((o)localObject2).dtM = -1;
                  if (localo1 == null) {
                    t.azY().a((o)localObject2);
                  } else if (localo1.version < ((o)localObject2).version) {
                    t.azY().b((o)localObject2);
                  }
                }
              }
              else if (this.deP == 26) {
                au(paramArrayOfByte);
              } else if (this.deP == 36) {
                av(paramArrayOfByte);
              } else if (this.deP == 37) {
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
    return n.b.gVB;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bc.l
 * JD-Core Version:    0.7.0.1
 */