package com.tencent.mm.bb;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.a;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.g.a.oo;
import com.tencent.mm.g.a.oo.a;
import com.tencent.mm.g.a.ws;
import com.tencent.mm.m.c;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.bbk;
import com.tencent.mm.protocal.protobuf.bbl;
import com.tencent.mm.protocal.protobuf.ccj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class l
  extends n
  implements com.tencent.mm.ak.p, com.tencent.mm.network.k
{
  private com.tencent.mm.ak.g callback;
  private int dcj;
  private int flags;
  private boolean hPZ;
  private com.tencent.mm.ak.b rr;
  
  public l(int paramInt)
  {
    AppMethodBeat.i(150814);
    this.hPZ = false;
    this.flags = -1;
    this.dcj = paramInt;
    this.hPZ = false;
    ac.d("MicroMsg.NetSceneGetPackageList", "Init dkregcode:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(150814);
  }
  
  public l(boolean paramBoolean)
  {
    AppMethodBeat.i(150813);
    this.hPZ = false;
    this.flags = -1;
    this.dcj = 26;
    this.hPZ = false;
    ac.d("MicroMsg.NetSceneGetPackageList", "Init dkregcode:26");
    ac.d("MicroMsg.NetSceneGetPackageList", "isOnlyCheckInReqList: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      this.flags = 1;
    }
    AppMethodBeat.o(150813);
  }
  
  private o a(ccj paramccj)
  {
    AppMethodBeat.i(150816);
    o localo = new o();
    localo.id = paramccj.tlI;
    localo.version = paramccj.Version;
    localo.name = paramccj.Name;
    localo.size = paramccj.ndD;
    localo.hQh = paramccj.PackName;
    localo.status = 5;
    localo.dib = this.dcj;
    AppMethodBeat.o(150816);
    return localo;
  }
  
  private void aq(List<ccj> paramList)
  {
    AppMethodBeat.i(150825);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      ac.d("MicroMsg.NetSceneGetPackageList", "[oneliang]empty update expose scene list");
      AppMethodBeat.o(150825);
      return;
    }
    t.aGO();
    String str = p.aGL();
    int i = 0;
    if (i < paramList.size())
    {
      ccj localccj = (ccj)paramList.get(i);
      Object localObject = t.aGO().dg(localccj.tlI, this.dcj);
      o localo;
      if ((localObject == null) || (((o)localObject).version != localccj.Version))
      {
        i.deleteFile(str + t.aGO().di(localccj.tlI, this.dcj));
        localo = a(localccj);
        localo.drx = -1;
        if (localObject != null) {
          break label225;
        }
        t.aGO().a(localo);
      }
      for (;;)
      {
        localObject = new k(localo.id, 19);
        com.tencent.mm.kernel.g.agQ().ghe.a((n)localObject, 0);
        ac.d("MicroMsg.NetSceneGetPackageList", "[oneliang]name:%s,packName:%s", new Object[] { localccj.Name, localccj.PackName });
        i += 1;
        break;
        label225:
        t.aGO().b(localo);
      }
    }
    AppMethodBeat.o(150825);
  }
  
  private void ar(List<ccj> paramList)
  {
    AppMethodBeat.i(150826);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ac.d("MicroMsg.NetSceneGetPackageList", "updateIPCallCountryCodeConfig, package list is empty");
      AppMethodBeat.o(150826);
      return;
    }
    ac.d("MicroMsg.NetSceneGetPackageList", "updateIPCallCountryCodeConfig, pkgList.size: %d", new Object[] { Integer.valueOf(paramList.size()) });
    int i = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GGk, Integer.valueOf(-1))).intValue();
    ac.d("MicroMsg.NetSceneGetPackageList", "configPkgId: %d", new Object[] { Integer.valueOf(i) });
    if (i == -1)
    {
      AppMethodBeat.o(150826);
      return;
    }
    o localo1 = t.aGO().dg(i, this.dcj);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      o localo2 = a((ccj)paramList.next());
      ac.d("MicroMsg.NetSceneGetPackageList", "newInfo.id: %d, version: %d", new Object[] { Integer.valueOf(localo2.id), Integer.valueOf(localo2.version) });
      if ((localo1 != null) && (localo2.id == i))
      {
        ac.d("MicroMsg.NetSceneGetPackageList", "find match old pkg, update one");
        t.aGO().b(localo2);
        AppMethodBeat.o(150826);
        return;
      }
      if ((localo1 == null) && (localo2.id == i))
      {
        ac.d("MicroMsg.NetSceneGetPackageList", "insert new pkg");
        t.aGO().a(localo2);
        AppMethodBeat.o(150826);
        return;
      }
    }
    AppMethodBeat.o(150826);
  }
  
  private void as(List<ccj> paramList)
  {
    AppMethodBeat.i(150827);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ac.d("MicroMsg.NetSceneGetPackageList", "update sense where location but package list is empty.");
      AppMethodBeat.o(150827);
      return;
    }
    ac.i("MicroMsg.NetSceneGetPackageList", "start update sense where location. package list size " + paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject2 = (ccj)paramList.next();
      Object localObject1 = t.aGO().dg(((ccj)localObject2).tlI, this.dcj);
      if ((localObject1 == null) || (((o)localObject1).version != ((ccj)localObject2).Version))
      {
        localObject2 = a((ccj)localObject2);
        ((o)localObject2).drx = -1;
        if (localObject1 == null) {
          t.aGO().a((o)localObject2);
        }
        for (;;)
        {
          localObject1 = new k(((o)localObject2).id, 36);
          com.tencent.mm.kernel.g.agQ().ghe.a((n)localObject1, 0);
          break;
          t.aGO().b((o)localObject2);
        }
      }
    }
    AppMethodBeat.o(150827);
  }
  
  private void g(LinkedList<ccj> paramLinkedList)
  {
    AppMethodBeat.i(150818);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ac.d("MicroMsg.NetSceneGetPackageList", "empty upload speex config list");
      AppMethodBeat.o(150818);
      return;
    }
    t.aGO();
    String str = p.aGL();
    int i = 0;
    if (i < paramLinkedList.size())
    {
      ccj localccj = (ccj)paramLinkedList.get(i);
      Object localObject = t.aGO().dg(localccj.tlI, this.dcj);
      o localo;
      if ((localObject == null) || (((o)localObject).version != localccj.Version))
      {
        i.deleteFile(str + t.aGO().di(localccj.tlI, this.dcj));
        localo = a(localccj);
        localo.drx = -1;
        if (localObject != null) {
          break label353;
        }
        t.aGO().a(localo);
      }
      for (;;)
      {
        localObject = new k(localo.id, 9);
        com.tencent.mm.kernel.g.agQ().ghe.a((n)localObject, 0);
        if (z.a(localccj.DRc) != null) {
          ac.v("MicroMsg.NetSceneGetPackageList", "xml:".concat(String.valueOf(new String(z.a(localccj.DRc)))));
        }
        if (z.a(localccj.FqS) != null) {
          ac.v("MicroMsg.NetSceneGetPackageList", "xml2:".concat(String.valueOf(new String(z.a(localccj.FqS)))));
        }
        ac.v("MicroMsg.NetSceneGetPackageList", "xml3:" + localccj.toString());
        ac.v("MicroMsg.NetSceneGetPackageList", "xml4:" + localccj.Name);
        ac.v("MicroMsg.NetSceneGetPackageList", "xml5:" + localccj.PackName);
        i += 1;
        break;
        label353:
        t.aGO().b(localo);
      }
    }
    AppMethodBeat.o(150818);
  }
  
  private void h(LinkedList<ccj> paramLinkedList)
  {
    AppMethodBeat.i(150819);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ac.e("MicroMsg.NetSceneGetPackageList", "empty background pkg list");
      AppMethodBeat.o(150819);
      return;
    }
    t.aGO();
    String str = p.aGL();
    int i = 0;
    if (i < paramLinkedList.size())
    {
      Object localObject1 = (ccj)paramLinkedList.get(i);
      Object localObject2 = t.aGO().dg(((ccj)localObject1).tlI, this.dcj);
      o localo;
      if ((localObject2 == null) || (((o)localObject2).version != ((ccj)localObject1).Version))
      {
        i.deleteFile(str + t.aGO().di(((ccj)localObject1).tlI, this.dcj));
        localo = a((ccj)localObject1);
        localo.drx = -1;
        if (localObject2 != null) {
          break label294;
        }
      }
      label294:
      for (boolean bool = t.aGO().a(localo);; bool = t.aGO().b(localo))
      {
        ac.i("MicroMsg.NetSceneGetPackageList", "[updateBackgroundPkg] ret:%s newInfo:%s", new Object[] { Boolean.valueOf(bool), localo });
        localObject2 = z.a(((ccj)localObject1).DRc);
        if ((localObject2 != null) && (localObject2.length > 0))
        {
          t.aGO();
          localObject1 = p.dh(((ccj)localObject1).tlI, this.dcj);
          i.deleteFile(str + (String)localObject1);
          if (i.e(str + (String)localObject1, (byte[])localObject2, localObject2.length) < 0) {
            ac.e("MicroMsg.NetSceneGetPackageList", "[updateBackgroundPkg] appendBuf thumb error!");
          }
        }
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(150819);
  }
  
  @Deprecated
  private void i(LinkedList<ccj> paramLinkedList)
  {
    AppMethodBeat.i(150820);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ac.d("MicroMsg.NetSceneGetPackageList", "empty emoji pkg list");
      AppMethodBeat.o(150820);
      return;
    }
    int i = 0;
    if (i < paramLinkedList.size())
    {
      Object localObject1 = (ccj)paramLinkedList.get(i);
      Object localObject2 = t.aGO().dg(((ccj)localObject1).tlI, this.dcj);
      o localo = a((ccj)localObject1);
      localo.drx = -1;
      if (localObject2 == null) {
        t.aGO().a(localo);
      }
      for (;;)
      {
        localObject1 = z.a(((ccj)localObject1).DRc);
        if ((localObject1 != null) && (localObject1.length > 0))
        {
          localObject2 = new ArrayList();
          ((List)localObject2).add(new String((byte[])localObject1));
          ((List)localObject2).size();
        }
        i += 1;
        break;
        t.aGO().b(localo);
      }
    }
    AppMethodBeat.o(150820);
  }
  
  private void j(LinkedList<ccj> paramLinkedList)
  {
    AppMethodBeat.i(150821);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ac.d("MicroMsg.NetSceneGetPackageList", "empty emoji pkg list");
      AppMethodBeat.o(150821);
      return;
    }
    ac.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + paramLinkedList.size());
    t.aGO();
    String str1 = p.aGL();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      ccj localccj = (ccj)paramLinkedList.get(i);
      o localo = t.aGO().dg(localccj.tlI, this.dcj);
      byte[] arrayOfByte = z.a(localccj.DRc);
      if (localccj.DRc == null)
      {
        ac.e("MicroMsg.NetSceneGetPackageList", "error give me a null thumb it should be xml");
        i += 1;
      }
      else
      {
        String str2;
        Object localObject;
        if ((localo == null) || (localo.version != localccj.Version))
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
          localObject = a(localccj);
          ((o)localObject).drx = -1;
          if (localo != null) {
            break label414;
          }
          t.aGO().a((o)localObject);
        }
        for (;;)
        {
          ac.d("MicroMsg.NetSceneGetPackageList", localccj.Name + " - " + localccj.tlI + " - " + localccj.PackName + " - " + localccj.ndD);
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
          t.aGO().b((o)localObject);
        }
      }
    }
    AppMethodBeat.o(150821);
  }
  
  private void k(LinkedList<ccj> paramLinkedList)
  {
    AppMethodBeat.i(150822);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ac.d("MicroMsg.NetSceneGetPackageList", "empty config list");
      AppMethodBeat.o(150822);
      return;
    }
    ac.d("MicroMsg.NetSceneGetPackageList", "updateConfigList pkgList size " + paramLinkedList.size());
    int i = 0;
    if (i < paramLinkedList.size())
    {
      Object localObject1 = (ccj)paramLinkedList.get(i);
      Object localObject2 = t.aGO().dg(((ccj)localObject1).tlI, this.dcj);
      Object localObject3 = a((ccj)localObject1);
      ((o)localObject3).drx = -1;
      if (localObject2 == null) {
        t.aGO().a((o)localObject3);
      }
      for (;;)
      {
        ac.d("MicroMsg.NetSceneGetPackageList", ((ccj)localObject1).Name + " - " + ((ccj)localObject1).tlI + " - " + ((ccj)localObject1).PackName + " - " + ((ccj)localObject1).ndD);
        localObject2 = z.a(((ccj)localObject1).DRc);
        ac.d("MicroMsg.NetSceneGetPackageList", "ConfigList xml : ".concat(String.valueOf(new String((byte[])localObject2))));
        localObject3 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZZ();
        int j = ((ccj)localObject1).tlI;
        localObject1 = new com.tencent.mm.vfs.e(c.fKR);
        if (!((com.tencent.mm.vfs.e)localObject1).exists()) {
          ((com.tencent.mm.vfs.e)localObject1).mkdirs();
        }
        try
        {
          localObject1 = new com.tencent.mm.vfs.e(c.ld(j));
          if (!((com.tencent.mm.vfs.e)localObject1).exists()) {
            ((com.tencent.mm.vfs.e)localObject1).createNewFile();
          }
          i.f(c.ld(j), (byte[])localObject2, localObject2.length);
          ((c)localObject3).w(j, new String((byte[])localObject2));
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.e("MicroMsg.ConfigListDecoder", "exception:%s", new Object[] { bs.m(localException) });
          }
        }
        i += 1;
        break;
        t.aGO().b((o)localObject3);
      }
    }
    AppMethodBeat.o(150822);
  }
  
  private void l(LinkedList<ccj> paramLinkedList)
  {
    AppMethodBeat.i(150823);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ac.d("MicroMsg.NetSceneGetPackageList", "empty regioncode pkg list");
      AppMethodBeat.o(150823);
      return;
    }
    ac.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + paramLinkedList.size());
    paramLinkedList = paramLinkedList.iterator();
    if (paramLinkedList.hasNext())
    {
      ccj localccj = (ccj)paramLinkedList.next();
      o localo1 = t.aGO().dg(localccj.tlI, this.dcj);
      o localo2 = a(localccj);
      localo2.drx = -1;
      if (localo1 == null) {
        t.aGO().a(localo2);
      }
      for (;;)
      {
        ac.d("MicroMsg.NetSceneGetPackageList", localccj.Name + " - " + localccj.tlI + " - " + localccj.PackName + " - " + localccj.ndD);
        break;
        t.aGO().b(localo2);
      }
    }
    AppMethodBeat.o(150823);
  }
  
  private void m(LinkedList<ccj> paramLinkedList)
  {
    AppMethodBeat.i(150824);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ac.e("MicroMsg.NetSceneGetPackageList", "empty address pkg list");
      AppMethodBeat.o(150824);
      return;
    }
    ac.i("MicroMsg.NetSceneGetPackageList", "updateRcptAddress pkgList size " + paramLinkedList.size());
    int i = 0;
    if (i < paramLinkedList.size())
    {
      Object localObject2 = (ccj)paramLinkedList.get(i);
      Object localObject1 = t.aGO().dg(((ccj)localObject2).tlI, this.dcj);
      localObject2 = a((ccj)localObject2);
      ((o)localObject2).drx = -1;
      if (localObject1 == null) {
        t.aGO().a((o)localObject2);
      }
      for (;;)
      {
        localObject1 = new k(((o)localObject2).id, 12);
        com.tencent.mm.kernel.g.agQ().ghe.a((n)localObject1, 0);
        i += 1;
        break;
        t.aGO().b((o)localObject2);
      }
    }
    AppMethodBeat.o(150824);
  }
  
  private void n(LinkedList<ccj> paramLinkedList)
  {
    AppMethodBeat.i(150828);
    ac.d("MicroMsg.NetSceneGetPackageList", "updateLangPkg");
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      ac.d("MicroMsg.NetSceneGetPackageList", "empty langage package list");
      AppMethodBeat.o(150828);
      return;
    }
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      Object localObject = (ccj)paramLinkedList.next();
      ac.d("MicroMsg.NetSceneGetPackageList", "pkg.toString %s", new Object[] { localObject.toString() });
      o localo = t.aGO().dg(((ccj)localObject).tlI, this.dcj);
      localObject = a((ccj)localObject);
      ((o)localObject).drx = -1;
      if (localo == null) {
        t.aGO().a((o)localObject);
      } else {
        t.aGO().b((o)localObject);
      }
    }
    AppMethodBeat.o(150828);
  }
  
  private void o(LinkedList<ccj> paramLinkedList)
  {
    AppMethodBeat.i(150829);
    ac.d("MicroMsg.NetSceneGetPackageList", "updateAppleEmojiPackage");
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      ac.d("MicroMsg.NetSceneGetPackageList", "update apple emoji but package list is empty.");
      AppMethodBeat.o(150829);
      return;
    }
    ac.i("MicroMsg.NetSceneGetPackageList", "start update apple emoji. package list size " + paramLinkedList.size());
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      Object localObject2 = (ccj)paramLinkedList.next();
      Object localObject1 = t.aGO().dg(((ccj)localObject2).tlI, this.dcj);
      if ((localObject1 == null) || (((o)localObject1).version != ((ccj)localObject2).Version))
      {
        localObject2 = a((ccj)localObject2);
        ((o)localObject2).drx = -1;
        if (localObject1 == null) {
          t.aGO().a((o)localObject2);
        }
        for (;;)
        {
          localObject1 = new k(((o)localObject2).id, 37);
          com.tencent.mm.kernel.g.agQ().ghe.a((n)localObject1, 0);
          break;
          t.aGO().b((o)localObject2);
        }
      }
    }
    AppMethodBeat.o(150829);
  }
  
  public final int aBJ()
  {
    return this.dcj;
  }
  
  public final boolean acceptConcurrent(n paramn)
  {
    if (!(paramn instanceof l)) {}
    while (this.dcj != ((l)paramn).dcj) {
      return true;
    }
    return false;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(150815);
    this.callback = paramg;
    ac.d("MicroMsg.NetSceneGetPackageList", "DoScene dkregcode :" + this.dcj);
    paramg = new b.a();
    paramg.hvt = new bbk();
    paramg.hvu = new bbl();
    paramg.uri = "/cgi-bin/micromsg-bin/getpackagelist";
    paramg.funcId = 159;
    paramg.reqCmdId = 51;
    paramg.respCmdId = 1000000051;
    this.rr = paramg.aAz();
    paramg = (bbk)this.rr.hvr.hvw;
    LinkedList localLinkedList = new LinkedList();
    if (!com.tencent.mm.kernel.g.agP().afY())
    {
      AppMethodBeat.o(150815);
      return -1;
    }
    o[] arrayOfo = t.aGO().po(this.dcj);
    if ((arrayOfo != null) && (arrayOfo.length > 0))
    {
      i = 0;
      if (i < arrayOfo.length)
      {
        ccj localccj = new ccj();
        localccj.tlI = arrayOfo[i].id;
        if ((ab.ivw) && (this.dcj == 7))
        {
          ac.d("MicroMsg.NetSceneGetPackageList", "isShakeGetConfigList");
          localccj.Version = 0;
        }
        for (;;)
        {
          ac.d("MicroMsg.NetSceneGetPackageList", "package, id:%d, ver:%d", new Object[] { Integer.valueOf(localccj.tlI), Integer.valueOf(localccj.Version) });
          localLinkedList.add(localccj);
          i += 1;
          break;
          if ((12 == this.dcj) && (!i.eA(com.tencent.mm.kernel.g.agR().cachePath + "address")))
          {
            ac.i("MicroMsg.NetSceneGetPackageList", "MMRCPTADDRESS final save file not found, set pkg.Version=0");
            localccj.Version = 0;
          }
          else
          {
            localccj.Version = arrayOfo[i].version;
          }
        }
      }
    }
    paramg.ncM = localLinkedList;
    paramg.ncL = localLinkedList.size();
    paramg.ndI = this.dcj;
    if (this.flags != -1) {
      paramg.DPI = this.flags;
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
    ac.i("MicroMsg.NetSceneGetPackageList", "onGYNetEnd, netid:%d, errType:%d, errCode:%d, pkgType:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.dcj), paramString });
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150817);
      return;
    }
    paramq = (bbl)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    if (paramq.ndI != this.dcj)
    {
      ac.e("MicroMsg.NetSceneGetPackageList", "packageType is not consistent, respType = %d", new Object[] { Integer.valueOf(paramq.ndI) });
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(150817);
      return;
    }
    paramArrayOfByte = paramq.ncM;
    Object localObject1 = new StringBuilder("summer list size:");
    if (paramArrayOfByte == null)
    {
      paramInt1 = 0;
      ac.i("MicroMsg.NetSceneGetPackageList", paramInt1 + " packageType: " + this.dcj + " resp.Type: " + paramq.ndI);
      if (this.dcj != 2) {
        break label332;
      }
      i(paramArrayOfByte);
    }
    for (;;)
    {
      localObject1 = new ws();
      ((ws)localObject1).dzB.dzC = paramArrayOfByte;
      ((ws)localObject1).dzB.dcj = this.dcj;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
      if (paramq.EfS <= 0) {
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
      if (this.dcj == 1)
      {
        h(paramArrayOfByte);
      }
      else if (this.dcj == 4)
      {
        j(paramArrayOfByte);
      }
      else if (this.dcj == 6)
      {
        ac.i("MicroMsg.NetSceneGetPackageList", "change new egg.");
      }
      else if (this.dcj == 7)
      {
        k(paramArrayOfByte);
      }
      else if (this.dcj == 9)
      {
        g(paramArrayOfByte);
      }
      else
      {
        Object localObject2;
        if (this.dcj == 10)
        {
          if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
          {
            ac.e("MicroMsg.NetSceneGetPackageList", "empty mass send top config package");
          }
          else
          {
            ac.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + paramArrayOfByte.size());
            localObject2 = (ccj)paramArrayOfByte.get(0);
            localObject1 = t.aGO().dg(((ccj)localObject2).tlI, this.dcj);
            localObject2 = a((ccj)localObject2);
            ((o)localObject2).drx = -1;
            if (localObject1 == null) {
              t.aGO().a((o)localObject2);
            } else {
              t.aGO().b((o)localObject2);
            }
          }
        }
        else if (this.dcj != 11) {
          if (this.dcj == 12) {
            m(paramArrayOfByte);
          } else if (this.dcj == 5) {
            n(paramArrayOfByte);
          } else if (this.dcj == 20) {
            l(paramArrayOfByte);
          } else if (this.dcj == 17)
          {
            if ((paramArrayOfByte == null) || (paramArrayOfByte.size() == 0))
            {
              ac.d("MicroMsg.NetSceneGetPackageList", "poi type is null");
            }
            else
            {
              localObject1 = (ccj)paramArrayOfByte.get(0);
              ac.d("MicroMsg.NetSceneGetPackageList", ((ccj)localObject1).Name + " - " + ((ccj)localObject1).tlI + " - " + ((ccj)localObject1).PackName + " - " + ((ccj)localObject1).ndD);
              localObject2 = t.aGO().dg(((ccj)localObject1).tlI, this.dcj);
              o localo2 = a((ccj)localObject1);
              localo2.drx = -1;
              if (localObject2 == null) {
                t.aGO().a(localo2);
              }
              for (;;)
              {
                for (;;)
                {
                  localObject2 = new oo();
                  try
                  {
                    ((oo)localObject2).dqW.content = z.a(((ccj)localObject1).DRc);
                    if (((oo)localObject2).dqW.content == null) {
                      break;
                    }
                    com.tencent.mm.sdk.b.a.GpY.a((com.tencent.mm.sdk.b.b)localObject2, Looper.getMainLooper());
                  }
                  catch (Exception localException)
                  {
                    ac.e("MicroMsg.NetSceneGetPackageList", localException.getMessage());
                  }
                }
                t.aGO().b(localo2);
              }
            }
          }
          else if (this.dcj != 18) {
            if (this.dcj == 19)
            {
              aq(paramArrayOfByte);
            }
            else
            {
              o localo1;
              if (this.dcj == 21)
              {
                if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
                {
                  ac.d("MicroMsg.NetSceneGetPackageList", "summer trace config empty scene list");
                }
                else
                {
                  localObject2 = (ccj)paramArrayOfByte.get(0);
                  ac.d("MicroMsg.NetSceneGetPackageList", "summer getpackage pkg: " + localObject2 + "|id = " + ((ccj)localObject2).tlI + "|Name = " + ((ccj)localObject2).Name + "|PackName = " + ((ccj)localObject2).PackName + "|Size = " + ((ccj)localObject2).ndD + "|Version = " + ((ccj)localObject2).Version);
                  localo1 = t.aGO().dg(((ccj)localObject2).tlI, this.dcj);
                  localObject2 = a((ccj)localObject2);
                  ((o)localObject2).drx = -1;
                  if (localo1 == null) {
                    t.aGO().a((o)localObject2);
                  } else if (localo1.version < ((o)localObject2).version) {
                    t.aGO().b((o)localObject2);
                  } else {
                    ac.d("MicroMsg.NetSceneGetPackageList", "summer old version [%d] new version[%d], not need update", new Object[] { Integer.valueOf(localo1.version), Integer.valueOf(((o)localObject2).version) });
                  }
                }
              }
              else if (23 == this.dcj)
              {
                if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
                {
                  ac.d("MicroMsg.NetSceneGetPackageList", "permission tips config is empty");
                }
                else
                {
                  localObject2 = (ccj)paramArrayOfByte.get(0);
                  ac.d("MicroMsg.NetSceneGetPackageList", "permission getpackage pkg: " + localObject2 + "|id = " + ((ccj)localObject2).tlI + "|Name = " + ((ccj)localObject2).Name + "|PackName = " + ((ccj)localObject2).PackName + "|Size = " + ((ccj)localObject2).ndD + "|Version = " + ((ccj)localObject2).Version);
                  localo1 = t.aGO().dg(((ccj)localObject2).tlI, this.dcj);
                  localObject2 = a((ccj)localObject2);
                  ((o)localObject2).drx = -1;
                  if (localo1 == null) {
                    t.aGO().a((o)localObject2);
                  } else if (localo1.version < ((o)localObject2).version) {
                    t.aGO().b((o)localObject2);
                  }
                }
              }
              else if (this.dcj == 26) {
                ar(paramArrayOfByte);
              } else if (this.dcj == 36) {
                as(paramArrayOfByte);
              } else if (this.dcj == 37) {
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
    return n.b.hwa;
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