package com.tencent.mm.ba;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m.a;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.ai.o;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.mt;
import com.tencent.mm.g.a.mt.a;
import com.tencent.mm.g.a.ui;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.c;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.protocal.protobuf.bka;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
  extends com.tencent.mm.ai.m
  implements o, com.tencent.mm.network.k
{
  private f callback;
  private int cpQ;
  private boolean fME;
  private int flags;
  private com.tencent.mm.ai.b rr;
  
  public k(int paramInt)
  {
    AppMethodBeat.i(78459);
    this.fME = false;
    this.flags = -1;
    this.cpQ = paramInt;
    this.fME = false;
    ab.d("MicroMsg.NetSceneGetPackageList", "Init dkregcode:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(78459);
  }
  
  public k(boolean paramBoolean)
  {
    AppMethodBeat.i(78458);
    this.fME = false;
    this.flags = -1;
    this.cpQ = 26;
    this.fME = false;
    ab.d("MicroMsg.NetSceneGetPackageList", "Init dkregcode:26");
    ab.d("MicroMsg.NetSceneGetPackageList", "isOnlyCheckInReqList: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      this.flags = 1;
    }
    AppMethodBeat.o(78458);
  }
  
  private m a(bka parambka)
  {
    AppMethodBeat.i(78461);
    m localm = new m();
    localm.id = parambka.nuk;
    localm.version = parambka.Version;
    localm.name = parambka.Name;
    localm.size = parambka.jKn;
    localm.fMJ = parambka.PackName;
    localm.status = 5;
    localm.cvs = this.cpQ;
    AppMethodBeat.o(78461);
    return localm;
  }
  
  private void ab(List<bka> paramList)
  {
    AppMethodBeat.i(78470);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      ab.d("MicroMsg.NetSceneGetPackageList", "[oneliang]empty update expose scene list");
      AppMethodBeat.o(78470);
      return;
    }
    r.aiP();
    String str = n.aiM();
    int i = 0;
    if (i < paramList.size())
    {
      bka localbka = (bka)paramList.get(i);
      Object localObject = r.aiP().cz(localbka.nuk, this.cpQ);
      m localm;
      if ((localObject == null) || (((m)localObject).version != localbka.Version))
      {
        com.tencent.mm.a.e.deleteFile(str + r.aiP().cB(localbka.nuk, this.cpQ));
        localm = a(localbka);
        localm.bsY = -1;
        if (localObject != null) {
          break label225;
        }
        r.aiP().a(localm);
      }
      for (;;)
      {
        localObject = new j(localm.id, 19);
        g.RK().eHt.a((com.tencent.mm.ai.m)localObject, 0);
        ab.d("MicroMsg.NetSceneGetPackageList", "[oneliang]name:%s,packName:%s", new Object[] { localbka.Name, localbka.PackName });
        i += 1;
        break;
        label225:
        r.aiP().b(localm);
      }
    }
    AppMethodBeat.o(78470);
  }
  
  private void ac(List<bka> paramList)
  {
    AppMethodBeat.i(78471);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ab.d("MicroMsg.NetSceneGetPackageList", "updateIPCallCountryCodeConfig, package list is empty");
      AppMethodBeat.o(78471);
      return;
    }
    ab.d("MicroMsg.NetSceneGetPackageList", "updateIPCallCountryCodeConfig, pkgList.size: %d", new Object[] { Integer.valueOf(paramList.size()) });
    int i = ((Integer)g.RL().Ru().get(ac.a.yzZ, Integer.valueOf(-1))).intValue();
    ab.d("MicroMsg.NetSceneGetPackageList", "configPkgId: %d", new Object[] { Integer.valueOf(i) });
    if (i == -1)
    {
      AppMethodBeat.o(78471);
      return;
    }
    m localm1 = r.aiP().cz(i, this.cpQ);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      m localm2 = a((bka)paramList.next());
      ab.d("MicroMsg.NetSceneGetPackageList", "newInfo.id: %d, version: %d", new Object[] { Integer.valueOf(localm2.id), Integer.valueOf(localm2.version) });
      if ((localm1 != null) && (localm2.id == i))
      {
        ab.d("MicroMsg.NetSceneGetPackageList", "find match old pkg, update one");
        r.aiP().b(localm2);
        AppMethodBeat.o(78471);
        return;
      }
      if ((localm1 == null) && (localm2.id == i))
      {
        ab.d("MicroMsg.NetSceneGetPackageList", "insert new pkg");
        r.aiP().a(localm2);
        AppMethodBeat.o(78471);
        return;
      }
    }
    AppMethodBeat.o(78471);
  }
  
  private void ad(List<bka> paramList)
  {
    AppMethodBeat.i(78472);
    if ((paramList == null) || (paramList.size() == 0))
    {
      ab.d("MicroMsg.NetSceneGetPackageList", "update sense where location but package list is empty.");
      AppMethodBeat.o(78472);
      return;
    }
    ab.i("MicroMsg.NetSceneGetPackageList", "start update sense where location. package list size " + paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject2 = (bka)paramList.next();
      Object localObject1 = r.aiP().cz(((bka)localObject2).nuk, this.cpQ);
      if ((localObject1 == null) || (((m)localObject1).version != ((bka)localObject2).Version))
      {
        localObject2 = a((bka)localObject2);
        ((m)localObject2).bsY = -1;
        if (localObject1 == null) {
          r.aiP().a((m)localObject2);
        }
        for (;;)
        {
          localObject1 = new j(((m)localObject2).id, 36);
          g.RK().eHt.a((com.tencent.mm.ai.m)localObject1, 0);
          break;
          r.aiP().b((m)localObject2);
        }
      }
    }
    AppMethodBeat.o(78472);
  }
  
  private void g(LinkedList<bka> paramLinkedList)
  {
    AppMethodBeat.i(78463);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ab.d("MicroMsg.NetSceneGetPackageList", "empty upload speex config list");
      AppMethodBeat.o(78463);
      return;
    }
    r.aiP();
    String str = n.aiM();
    int i = 0;
    if (i < paramLinkedList.size())
    {
      bka localbka = (bka)paramLinkedList.get(i);
      Object localObject = r.aiP().cz(localbka.nuk, this.cpQ);
      m localm;
      if ((localObject == null) || (((m)localObject).version != localbka.Version))
      {
        com.tencent.mm.a.e.deleteFile(str + r.aiP().cB(localbka.nuk, this.cpQ));
        localm = a(localbka);
        localm.bsY = -1;
        if (localObject != null) {
          break label353;
        }
        r.aiP().a(localm);
      }
      for (;;)
      {
        localObject = new j(localm.id, 9);
        g.RK().eHt.a((com.tencent.mm.ai.m)localObject, 0);
        if (aa.a(localbka.wpT) != null) {
          ab.v("MicroMsg.NetSceneGetPackageList", "xml:".concat(String.valueOf(new String(aa.a(localbka.wpT)))));
        }
        if (aa.a(localbka.xyz) != null) {
          ab.v("MicroMsg.NetSceneGetPackageList", "xml2:".concat(String.valueOf(new String(aa.a(localbka.xyz)))));
        }
        ab.v("MicroMsg.NetSceneGetPackageList", "xml3:" + localbka.toString());
        ab.v("MicroMsg.NetSceneGetPackageList", "xml4:" + localbka.Name);
        ab.v("MicroMsg.NetSceneGetPackageList", "xml5:" + localbka.PackName);
        i += 1;
        break;
        label353:
        r.aiP().b(localm);
      }
    }
    AppMethodBeat.o(78463);
  }
  
  private void h(LinkedList<bka> paramLinkedList)
  {
    AppMethodBeat.i(78464);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ab.e("MicroMsg.NetSceneGetPackageList", "empty background pkg list");
      AppMethodBeat.o(78464);
      return;
    }
    r.aiP();
    String str = n.aiM();
    int i = 0;
    if (i < paramLinkedList.size())
    {
      Object localObject1 = (bka)paramLinkedList.get(i);
      Object localObject2 = r.aiP().cz(((bka)localObject1).nuk, this.cpQ);
      m localm;
      if ((localObject2 == null) || (((m)localObject2).version != ((bka)localObject1).Version))
      {
        com.tencent.mm.a.e.deleteFile(str + r.aiP().cB(((bka)localObject1).nuk, this.cpQ));
        localm = a((bka)localObject1);
        localm.bsY = -1;
        if (localObject2 != null) {
          break label275;
        }
      }
      label275:
      for (boolean bool = r.aiP().a(localm);; bool = r.aiP().b(localm))
      {
        ab.i("MicroMsg.NetSceneGetPackageList", "[updateBackgroundPkg] ret:%s newInfo:%s", new Object[] { Boolean.valueOf(bool), localm });
        localObject2 = aa.a(((bka)localObject1).wpT);
        if ((localObject2 != null) && (localObject2.length > 0))
        {
          r.aiP();
          localObject1 = n.cA(((bka)localObject1).nuk, this.cpQ);
          com.tencent.mm.a.e.deleteFile(str + (String)localObject1);
          if (com.tencent.mm.a.e.b(str, (String)localObject1, (byte[])localObject2) < 0) {
            ab.e("MicroMsg.NetSceneGetPackageList", "[updateBackgroundPkg] appendBuf thumb error!");
          }
        }
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(78464);
  }
  
  @Deprecated
  private void i(LinkedList<bka> paramLinkedList)
  {
    AppMethodBeat.i(78465);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ab.d("MicroMsg.NetSceneGetPackageList", "empty emoji pkg list");
      AppMethodBeat.o(78465);
      return;
    }
    int i = 0;
    if (i < paramLinkedList.size())
    {
      Object localObject1 = (bka)paramLinkedList.get(i);
      Object localObject2 = r.aiP().cz(((bka)localObject1).nuk, this.cpQ);
      m localm = a((bka)localObject1);
      localm.bsY = -1;
      if (localObject2 == null) {
        r.aiP().a(localm);
      }
      for (;;)
      {
        localObject1 = aa.a(((bka)localObject1).wpT);
        if ((localObject1 != null) && (localObject1.length > 0))
        {
          localObject2 = new ArrayList();
          ((List)localObject2).add(new String((byte[])localObject1));
          ((List)localObject2).size();
        }
        i += 1;
        break;
        r.aiP().b(localm);
      }
    }
    AppMethodBeat.o(78465);
  }
  
  private void j(LinkedList<bka> paramLinkedList)
  {
    AppMethodBeat.i(78466);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ab.d("MicroMsg.NetSceneGetPackageList", "empty emoji pkg list");
      AppMethodBeat.o(78466);
      return;
    }
    ab.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + paramLinkedList.size());
    r.aiP();
    String str1 = n.aiM();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      bka localbka = (bka)paramLinkedList.get(i);
      m localm = r.aiP().cz(localbka.nuk, this.cpQ);
      byte[] arrayOfByte = aa.a(localbka.wpT);
      if (localbka.wpT == null)
      {
        ab.e("MicroMsg.NetSceneGetPackageList", "error give me a null thumb it should be xml");
        i += 1;
      }
      else
      {
        String str2;
        Object localObject;
        if ((localm == null) || (localm.version != localbka.Version))
        {
          str2 = new String(arrayOfByte);
          localObject = "zh_CN";
          if (str2.indexOf("zh_CN") >= 0)
          {
            label180:
            str2 = (String)localObject + "_ARTIST.mm";
            com.tencent.mm.a.e.deleteFile(str1 + str2);
            com.tencent.mm.a.e.deleteFile(str1 + (String)localObject + "_ARTISTF.mm");
            com.tencent.mm.a.e.b(str1, str2, arrayOfByte);
          }
        }
        else
        {
          localObject = a(localbka);
          ((m)localObject).bsY = -1;
          if (localm != null) {
            break label395;
          }
          r.aiP().a((m)localObject);
        }
        for (;;)
        {
          ab.d("MicroMsg.NetSceneGetPackageList", localbka.Name + " - " + localbka.nuk + " - " + localbka.PackName + " - " + localbka.jKn);
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
          label395:
          r.aiP().b((m)localObject);
        }
      }
    }
    AppMethodBeat.o(78466);
  }
  
  private void k(LinkedList<bka> paramLinkedList)
  {
    AppMethodBeat.i(78467);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ab.d("MicroMsg.NetSceneGetPackageList", "empty config list");
      AppMethodBeat.o(78467);
      return;
    }
    ab.d("MicroMsg.NetSceneGetPackageList", "updateConfigList pkgList size " + paramLinkedList.size());
    int i = 0;
    if (i < paramLinkedList.size())
    {
      Object localObject1 = (bka)paramLinkedList.get(i);
      Object localObject2 = r.aiP().cz(((bka)localObject1).nuk, this.cpQ);
      Object localObject3 = a((bka)localObject1);
      ((m)localObject3).bsY = -1;
      if (localObject2 == null) {
        r.aiP().a((m)localObject3);
      }
      for (;;)
      {
        ab.d("MicroMsg.NetSceneGetPackageList", ((bka)localObject1).Name + " - " + ((bka)localObject1).nuk + " - " + ((bka)localObject1).PackName + " - " + ((bka)localObject1).jKn);
        localObject2 = aa.a(((bka)localObject1).wpT);
        ab.d("MicroMsg.NetSceneGetPackageList", "ConfigList xml : ".concat(String.valueOf(new String((byte[])localObject2))));
        localObject3 = ((com.tencent.mm.plugin.zero.b.a)g.E(com.tencent.mm.plugin.zero.b.a.class)).Nr();
        int j = ((bka)localObject1).nuk;
        localObject1 = new File(c.etL);
        if (!((File)localObject1).exists()) {
          ((File)localObject1).mkdir();
        }
        try
        {
          localObject1 = new File(c.iV(j));
          if (!((File)localObject1).exists()) {
            ((File)localObject1).createNewFile();
          }
          com.tencent.mm.a.e.b(c.iV(j), (byte[])localObject2, localObject2.length);
          ((c)localObject3).r(j, new String((byte[])localObject2));
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ab.e("MicroMsg.ConfigListDecoder", "exception:%s", new Object[] { bo.l(localException) });
          }
        }
        i += 1;
        break;
        r.aiP().b((m)localObject3);
      }
    }
    AppMethodBeat.o(78467);
  }
  
  private void l(LinkedList<bka> paramLinkedList)
  {
    AppMethodBeat.i(78468);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ab.d("MicroMsg.NetSceneGetPackageList", "empty regioncode pkg list");
      AppMethodBeat.o(78468);
      return;
    }
    ab.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + paramLinkedList.size());
    paramLinkedList = paramLinkedList.iterator();
    if (paramLinkedList.hasNext())
    {
      bka localbka = (bka)paramLinkedList.next();
      m localm1 = r.aiP().cz(localbka.nuk, this.cpQ);
      m localm2 = a(localbka);
      localm2.bsY = -1;
      if (localm1 == null) {
        r.aiP().a(localm2);
      }
      for (;;)
      {
        ab.d("MicroMsg.NetSceneGetPackageList", localbka.Name + " - " + localbka.nuk + " - " + localbka.PackName + " - " + localbka.jKn);
        break;
        r.aiP().b(localm2);
      }
    }
    AppMethodBeat.o(78468);
  }
  
  private void m(LinkedList<bka> paramLinkedList)
  {
    AppMethodBeat.i(78469);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      ab.e("MicroMsg.NetSceneGetPackageList", "empty address pkg list");
      AppMethodBeat.o(78469);
      return;
    }
    ab.i("MicroMsg.NetSceneGetPackageList", "updateRcptAddress pkgList size " + paramLinkedList.size());
    int i = 0;
    if (i < paramLinkedList.size())
    {
      Object localObject2 = (bka)paramLinkedList.get(i);
      Object localObject1 = r.aiP().cz(((bka)localObject2).nuk, this.cpQ);
      localObject2 = a((bka)localObject2);
      ((m)localObject2).bsY = -1;
      if (localObject1 == null) {
        r.aiP().a((m)localObject2);
      }
      for (;;)
      {
        localObject1 = new j(((m)localObject2).id, 12);
        g.RK().eHt.a((com.tencent.mm.ai.m)localObject1, 0);
        i += 1;
        break;
        r.aiP().b((m)localObject2);
      }
    }
    AppMethodBeat.o(78469);
  }
  
  private void n(LinkedList<bka> paramLinkedList)
  {
    AppMethodBeat.i(78473);
    ab.d("MicroMsg.NetSceneGetPackageList", "updateLangPkg");
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      ab.d("MicroMsg.NetSceneGetPackageList", "empty langage package list");
      AppMethodBeat.o(78473);
      return;
    }
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      Object localObject = (bka)paramLinkedList.next();
      ab.d("MicroMsg.NetSceneGetPackageList", "pkg.toString %s", new Object[] { localObject.toString() });
      m localm = r.aiP().cz(((bka)localObject).nuk, this.cpQ);
      localObject = a((bka)localObject);
      ((m)localObject).bsY = -1;
      if (localm == null) {
        r.aiP().a((m)localObject);
      } else {
        r.aiP().b((m)localObject);
      }
    }
    AppMethodBeat.o(78473);
  }
  
  private void o(LinkedList<bka> paramLinkedList)
  {
    AppMethodBeat.i(78474);
    ab.d("MicroMsg.NetSceneGetPackageList", "updateAppleEmojiPackage");
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      ab.d("MicroMsg.NetSceneGetPackageList", "update apple emoji but package list is empty.");
      AppMethodBeat.o(78474);
      return;
    }
    ab.i("MicroMsg.NetSceneGetPackageList", "start update apple emoji. package list size " + paramLinkedList.size());
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      Object localObject2 = (bka)paramLinkedList.next();
      Object localObject1 = r.aiP().cz(((bka)localObject2).nuk, this.cpQ);
      if ((localObject1 == null) || (((m)localObject1).version != ((bka)localObject2).Version))
      {
        localObject2 = a((bka)localObject2);
        ((m)localObject2).bsY = -1;
        if (localObject1 == null) {
          r.aiP().a((m)localObject2);
        }
        for (;;)
        {
          localObject1 = new j(((m)localObject2).id, 37);
          g.RK().eHt.a((com.tencent.mm.ai.m)localObject1, 0);
          break;
          r.aiP().b((m)localObject2);
        }
      }
    }
    AppMethodBeat.o(78474);
  }
  
  public final boolean acceptConcurrent(com.tencent.mm.ai.m paramm)
  {
    if (!(paramm instanceof k)) {}
    while (this.cpQ != ((k)paramm).cpQ) {
      return true;
    }
    return false;
  }
  
  public final int ads()
  {
    return this.cpQ;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(78460);
    this.callback = paramf;
    ab.d("MicroMsg.NetSceneGetPackageList", "DoScene dkregcode :" + this.cpQ);
    paramf = new b.a();
    paramf.fsX = new ann();
    paramf.fsY = new ano();
    paramf.uri = "/cgi-bin/micromsg-bin/getpackagelist";
    paramf.funcId = 159;
    paramf.reqCmdId = 51;
    paramf.respCmdId = 1000000051;
    this.rr = paramf.ado();
    paramf = (ann)this.rr.fsV.fta;
    LinkedList localLinkedList = new LinkedList();
    if (!g.RJ().QU())
    {
      AppMethodBeat.o(78460);
      return -1;
    }
    m[] arrayOfm = r.aiP().lS(this.cpQ);
    if ((arrayOfm != null) && (arrayOfm.length > 0))
    {
      i = 0;
      if (i < arrayOfm.length)
      {
        bka localbka = new bka();
        localbka.nuk = arrayOfm[i].id;
        if ((ae.gkA) && (this.cpQ == 7))
        {
          ab.d("MicroMsg.NetSceneGetPackageList", "isShakeGetConfigList");
          localbka.Version = 0;
        }
        for (;;)
        {
          ab.d("MicroMsg.NetSceneGetPackageList", "package, id:%d, ver:%d", new Object[] { Integer.valueOf(localbka.nuk), Integer.valueOf(localbka.Version) });
          localLinkedList.add(localbka);
          i += 1;
          break;
          if ((12 == this.cpQ) && (!com.tencent.mm.vfs.e.cN(g.RL().cachePath + "address")))
          {
            ab.i("MicroMsg.NetSceneGetPackageList", "MMRCPTADDRESS final save file not found, set pkg.Version=0");
            localbka.Version = 0;
          }
          else
          {
            localbka.Version = arrayOfm[i].version;
          }
        }
      }
    }
    paramf.jJv = localLinkedList;
    paramf.jJu = localLinkedList.size();
    paramf.jKs = this.cpQ;
    if (this.flags != -1) {
      paramf.woE = this.flags;
    }
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78460);
    return i;
  }
  
  public final int getType()
  {
    return 159;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78462);
    ab.i("MicroMsg.NetSceneGetPackageList", "onGYNetEnd, netid:%d, errType:%d, errCode:%d, pkgType:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.cpQ), paramString });
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(78462);
      return;
    }
    paramq = (ano)((com.tencent.mm.ai.b)paramq).fsW.fta;
    if (paramq.jKs != this.cpQ)
    {
      ab.e("MicroMsg.NetSceneGetPackageList", "packageType is not consistent, respType = %d", new Object[] { Integer.valueOf(paramq.jKs) });
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(78462);
      return;
    }
    paramArrayOfByte = paramq.jJv;
    Object localObject1 = new StringBuilder("summer list size:");
    if (paramArrayOfByte == null)
    {
      paramInt1 = 0;
      ab.i("MicroMsg.NetSceneGetPackageList", paramInt1 + " packageType: " + this.cpQ + " resp.Type: " + paramq.jKs);
      if (this.cpQ != 2) {
        break label332;
      }
      i(paramArrayOfByte);
    }
    for (;;)
    {
      localObject1 = new ui();
      ((ui)localObject1).cKQ.cKR = paramArrayOfByte;
      ((ui)localObject1).cKQ.cpQ = this.cpQ;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
      if (paramq.wBX <= 0) {
        break label1391;
      }
      if (doScene(dispatcher(), this.callback) != -1) {
        break label1412;
      }
      this.callback.onSceneEnd(3, -1, "doScene failed", this);
      AppMethodBeat.o(78462);
      return;
      paramInt1 = paramArrayOfByte.size();
      break;
      label332:
      if (this.cpQ == 1)
      {
        h(paramArrayOfByte);
      }
      else if (this.cpQ == 4)
      {
        j(paramArrayOfByte);
      }
      else if (this.cpQ == 6)
      {
        ab.i("MicroMsg.NetSceneGetPackageList", "change new egg.");
      }
      else if (this.cpQ == 7)
      {
        k(paramArrayOfByte);
      }
      else if (this.cpQ == 9)
      {
        g(paramArrayOfByte);
      }
      else
      {
        Object localObject2;
        if (this.cpQ == 10)
        {
          if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
          {
            ab.e("MicroMsg.NetSceneGetPackageList", "empty mass send top config package");
          }
          else
          {
            ab.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + paramArrayOfByte.size());
            localObject2 = (bka)paramArrayOfByte.get(0);
            localObject1 = r.aiP().cz(((bka)localObject2).nuk, this.cpQ);
            localObject2 = a((bka)localObject2);
            ((m)localObject2).bsY = -1;
            if (localObject1 == null) {
              r.aiP().a((m)localObject2);
            } else {
              r.aiP().b((m)localObject2);
            }
          }
        }
        else if (this.cpQ != 11) {
          if (this.cpQ == 12) {
            m(paramArrayOfByte);
          } else if (this.cpQ == 5) {
            n(paramArrayOfByte);
          } else if (this.cpQ == 20) {
            l(paramArrayOfByte);
          } else if (this.cpQ == 17)
          {
            if ((paramArrayOfByte == null) || (paramArrayOfByte.size() == 0))
            {
              ab.d("MicroMsg.NetSceneGetPackageList", "poi type is null");
            }
            else
            {
              localObject1 = (bka)paramArrayOfByte.get(0);
              ab.d("MicroMsg.NetSceneGetPackageList", ((bka)localObject1).Name + " - " + ((bka)localObject1).nuk + " - " + ((bka)localObject1).PackName + " - " + ((bka)localObject1).jKn);
              localObject2 = r.aiP().cz(((bka)localObject1).nuk, this.cpQ);
              m localm2 = a((bka)localObject1);
              localm2.bsY = -1;
              if (localObject2 == null) {
                r.aiP().a(localm2);
              }
              for (;;)
              {
                for (;;)
                {
                  localObject2 = new mt();
                  try
                  {
                    ((mt)localObject2).cCO.content = aa.a(((bka)localObject1).wpT);
                    if (((mt)localObject2).cCO.content == null) {
                      break;
                    }
                    com.tencent.mm.sdk.b.a.ymk.a((com.tencent.mm.sdk.b.b)localObject2, Looper.getMainLooper());
                  }
                  catch (Exception localException)
                  {
                    ab.e("MicroMsg.NetSceneGetPackageList", localException.getMessage());
                  }
                }
                r.aiP().b(localm2);
              }
            }
          }
          else if (this.cpQ != 18) {
            if (this.cpQ == 19)
            {
              ab(paramArrayOfByte);
            }
            else
            {
              m localm1;
              if (this.cpQ == 21)
              {
                if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
                {
                  ab.d("MicroMsg.NetSceneGetPackageList", "summer trace config empty scene list");
                }
                else
                {
                  localObject2 = (bka)paramArrayOfByte.get(0);
                  ab.d("MicroMsg.NetSceneGetPackageList", "summer getpackage pkg: " + localObject2 + "|id = " + ((bka)localObject2).nuk + "|Name = " + ((bka)localObject2).Name + "|PackName = " + ((bka)localObject2).PackName + "|Size = " + ((bka)localObject2).jKn + "|Version = " + ((bka)localObject2).Version);
                  localm1 = r.aiP().cz(((bka)localObject2).nuk, this.cpQ);
                  localObject2 = a((bka)localObject2);
                  ((m)localObject2).bsY = -1;
                  if (localm1 == null) {
                    r.aiP().a((m)localObject2);
                  } else if (localm1.version < ((m)localObject2).version) {
                    r.aiP().b((m)localObject2);
                  } else {
                    ab.d("MicroMsg.NetSceneGetPackageList", "summer old version [%d] new version[%d], not need update", new Object[] { Integer.valueOf(localm1.version), Integer.valueOf(((m)localObject2).version) });
                  }
                }
              }
              else if (23 == this.cpQ)
              {
                if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
                {
                  ab.d("MicroMsg.NetSceneGetPackageList", "permission tips config is empty");
                }
                else
                {
                  localObject2 = (bka)paramArrayOfByte.get(0);
                  ab.d("MicroMsg.NetSceneGetPackageList", "permission getpackage pkg: " + localObject2 + "|id = " + ((bka)localObject2).nuk + "|Name = " + ((bka)localObject2).Name + "|PackName = " + ((bka)localObject2).PackName + "|Size = " + ((bka)localObject2).jKn + "|Version = " + ((bka)localObject2).Version);
                  localm1 = r.aiP().cz(((bka)localObject2).nuk, this.cpQ);
                  localObject2 = a((bka)localObject2);
                  ((m)localObject2).bsY = -1;
                  if (localm1 == null) {
                    r.aiP().a((m)localObject2);
                  } else if (localm1.version < ((m)localObject2).version) {
                    r.aiP().b((m)localObject2);
                  }
                }
              }
              else if (this.cpQ == 26) {
                ac(paramArrayOfByte);
              } else if (this.cpQ == 36) {
                ad(paramArrayOfByte);
              } else if (this.cpQ == 37) {
                o(paramArrayOfByte);
              }
            }
          }
        }
      }
    }
    label1391:
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78462);
    return;
    label1412:
    AppMethodBeat.o(78462);
  }
  
  public final int securityLimitCount()
  {
    return 20;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
  
  public final void setSecurityCheckError(m.a parama) {}
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ba.k
 * JD-Core Version:    0.7.0.1
 */