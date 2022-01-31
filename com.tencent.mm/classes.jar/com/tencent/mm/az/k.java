package com.tencent.mm.az;

import android.os.Looper;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m.a;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.ah.o;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.mb;
import com.tencent.mm.h.a.mb.a;
import com.tencent.mm.h.a.sp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.c;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.protocal.c.aik;
import com.tencent.mm.protocal.c.ail;
import com.tencent.mm.protocal.c.bcr;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
  extends com.tencent.mm.ah.m
  implements o, com.tencent.mm.network.k
{
  private int bIv;
  private com.tencent.mm.ah.b dmK;
  private f dmL;
  private boolean ewO = false;
  private int flags = -1;
  
  public k(int paramInt)
  {
    this.bIv = paramInt;
    this.ewO = false;
    y.d("MicroMsg.NetSceneGetPackageList", "Init dkregcode:" + paramInt);
  }
  
  public k(boolean paramBoolean)
  {
    this.bIv = 26;
    this.ewO = false;
    y.d("MicroMsg.NetSceneGetPackageList", "Init dkregcode:26");
    y.d("MicroMsg.NetSceneGetPackageList", "isOnlyCheckInReqList: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      this.flags = 1;
    }
  }
  
  private void U(List<bcr> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0))
    {
      y.d("MicroMsg.NetSceneGetPackageList", "[oneliang]empty update expose scene list");
      return;
    }
    r.PK();
    String str = n.PH();
    int i = 0;
    label31:
    bcr localbcr;
    Object localObject;
    m localm;
    if (i < paramList.size())
    {
      localbcr = (bcr)paramList.get(i);
      localObject = r.PK().bp(localbcr.kWl, this.bIv);
      if ((localObject == null) || (((m)localObject).version != localbcr.hQQ))
      {
        com.tencent.mm.a.e.deleteFile(str + r.PK().br(localbcr.kWl, this.bIv));
        localm = a(localbcr);
        localm.bcw = -1;
        if (localObject != null) {
          break label215;
        }
        r.PK().a(localm);
      }
    }
    for (;;)
    {
      localObject = new j(localm.id, 19);
      g.DO().dJT.a((com.tencent.mm.ah.m)localObject, 0);
      y.d("MicroMsg.NetSceneGetPackageList", "[oneliang]name:%s,packName:%s", new Object[] { localbcr.kRZ, localbcr.sSc });
      i += 1;
      break label31;
      break;
      label215:
      r.PK().b(localm);
    }
  }
  
  private void V(List<bcr> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      y.d("MicroMsg.NetSceneGetPackageList", "updateIPCallCountryCodeConfig, package list is empty");
    }
    int i;
    m localm1;
    m localm2;
    do
    {
      return;
      while (!paramList.hasNext())
      {
        do
        {
          y.d("MicroMsg.NetSceneGetPackageList", "updateIPCallCountryCodeConfig, pkgList.size: %d", new Object[] { Integer.valueOf(paramList.size()) });
          i = ((Integer)g.DP().Dz().get(ac.a.upZ, Integer.valueOf(-1))).intValue();
          y.d("MicroMsg.NetSceneGetPackageList", "configPkgId: %d", new Object[] { Integer.valueOf(i) });
        } while (i == -1);
        localm1 = r.PK().bp(i, this.bIv);
        paramList = paramList.iterator();
      }
      localm2 = a((bcr)paramList.next());
      y.d("MicroMsg.NetSceneGetPackageList", "newInfo.id: %d, version: %d", new Object[] { Integer.valueOf(localm2.id), Integer.valueOf(localm2.version) });
      if ((localm1 != null) && (localm2.id == i))
      {
        y.d("MicroMsg.NetSceneGetPackageList", "find match old pkg, update one");
        r.PK().b(localm2);
        return;
      }
    } while ((localm1 != null) || (localm2.id != i));
    y.d("MicroMsg.NetSceneGetPackageList", "insert new pkg");
    r.PK().a(localm2);
  }
  
  private void W(List<bcr> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      y.d("MicroMsg.NetSceneGetPackageList", "update sense where location but package list is empty.");
      return;
    }
    y.i("MicroMsg.NetSceneGetPackageList", "start update sense where location. package list size " + paramList.size());
    paramList = paramList.iterator();
    label54:
    Object localObject2;
    Object localObject1;
    while (paramList.hasNext())
    {
      localObject2 = (bcr)paramList.next();
      localObject1 = r.PK().bp(((bcr)localObject2).kWl, this.bIv);
      if ((localObject1 == null) || (((m)localObject1).version != ((bcr)localObject2).hQQ))
      {
        localObject2 = a((bcr)localObject2);
        ((m)localObject2).bcw = -1;
        if (localObject1 != null) {
          break label155;
        }
        r.PK().a((m)localObject2);
      }
    }
    for (;;)
    {
      localObject1 = new j(((m)localObject2).id, 36);
      g.DO().dJT.a((com.tencent.mm.ah.m)localObject1, 0);
      break label54;
      break;
      label155:
      r.PK().b((m)localObject2);
    }
  }
  
  private m a(bcr parambcr)
  {
    m localm = new m();
    localm.id = parambcr.kWl;
    localm.version = parambcr.hQQ;
    localm.name = parambcr.kRZ;
    localm.size = parambcr.hQL;
    localm.ewT = parambcr.sSc;
    localm.status = 5;
    localm.bOa = this.bIv;
    return localm;
  }
  
  private void g(LinkedList<bcr> paramLinkedList)
  {
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      y.d("MicroMsg.NetSceneGetPackageList", "empty upload speex config list");
      return;
    }
    r.PK();
    String str = n.PH();
    int i = 0;
    label30:
    bcr localbcr;
    Object localObject;
    m localm;
    if (i < paramLinkedList.size())
    {
      localbcr = (bcr)paramLinkedList.get(i);
      localObject = r.PK().bp(localbcr.kWl, this.bIv);
      if ((localObject == null) || (((m)localObject).version != localbcr.hQQ))
      {
        com.tencent.mm.a.e.deleteFile(str + r.PK().br(localbcr.kWl, this.bIv));
        localm = a(localbcr);
        localm.bcw = -1;
        if (localObject != null) {
          break label363;
        }
        r.PK().a(localm);
      }
    }
    for (;;)
    {
      localObject = new j(localm.id, 9);
      g.DO().dJT.a((com.tencent.mm.ah.m)localObject, 0);
      if (aa.a(localbcr.swR) != null)
      {
        localObject = new String(aa.a(localbcr.swR));
        y.v("MicroMsg.NetSceneGetPackageList", "xml:" + (String)localObject);
      }
      if (aa.a(localbcr.txZ) != null)
      {
        localObject = new String(aa.a(localbcr.txZ));
        y.v("MicroMsg.NetSceneGetPackageList", "xml2:" + (String)localObject);
      }
      y.v("MicroMsg.NetSceneGetPackageList", "xml3:" + localbcr.toString());
      y.v("MicroMsg.NetSceneGetPackageList", "xml4:" + localbcr.kRZ);
      y.v("MicroMsg.NetSceneGetPackageList", "xml5:" + localbcr.sSc);
      i += 1;
      break label30;
      break;
      label363:
      r.PK().b(localm);
    }
  }
  
  private void h(LinkedList<bcr> paramLinkedList)
  {
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      y.d("MicroMsg.NetSceneGetPackageList", "empty background pkg list");
      return;
    }
    r.PK();
    String str = n.PH();
    int i = 0;
    label30:
    Object localObject1;
    Object localObject2;
    m localm;
    if (i < paramLinkedList.size())
    {
      localObject1 = (bcr)paramLinkedList.get(i);
      localObject2 = r.PK().bp(((bcr)localObject1).kWl, this.bIv);
      if ((localObject2 == null) || (((m)localObject2).version != ((bcr)localObject1).hQQ))
      {
        com.tencent.mm.a.e.deleteFile(str + r.PK().br(((bcr)localObject1).kWl, this.bIv));
        localm = a((bcr)localObject1);
        localm.bcw = -1;
        if (localObject2 != null) {
          break label225;
        }
        r.PK().a(localm);
      }
    }
    for (;;)
    {
      localObject2 = aa.a(((bcr)localObject1).swR);
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        r.PK();
        localObject1 = n.bq(((bcr)localObject1).kWl, this.bIv);
        com.tencent.mm.a.e.deleteFile(str + (String)localObject1);
        com.tencent.mm.a.e.b(str, (String)localObject1, (byte[])localObject2);
      }
      i += 1;
      break label30;
      break;
      label225:
      r.PK().b(localm);
    }
  }
  
  @Deprecated
  private void i(LinkedList<bcr> paramLinkedList)
  {
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      y.d("MicroMsg.NetSceneGetPackageList", "empty emoji pkg list");
      return;
    }
    int i = 0;
    label22:
    Object localObject1;
    Object localObject2;
    m localm;
    if (i < paramLinkedList.size())
    {
      localObject1 = (bcr)paramLinkedList.get(i);
      localObject2 = r.PK().bp(((bcr)localObject1).kWl, this.bIv);
      localm = a((bcr)localObject1);
      localm.bcw = -1;
      if (localObject2 != null) {
        break label139;
      }
      r.PK().a(localm);
    }
    for (;;)
    {
      localObject1 = aa.a(((bcr)localObject1).swR);
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        localObject2 = new ArrayList();
        ((List)localObject2).add(new String((byte[])localObject1));
        ((List)localObject2).size();
      }
      i += 1;
      break label22;
      break;
      label139:
      r.PK().b(localm);
    }
  }
  
  private void j(LinkedList<bcr> paramLinkedList)
  {
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0)) {
      y.d("MicroMsg.NetSceneGetPackageList", "empty emoji pkg list");
    }
    String str1;
    bcr localbcr;
    m localm;
    byte[] arrayOfByte;
    for (;;)
    {
      return;
      y.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + paramLinkedList.size());
      r.PK();
      str1 = n.PH();
      int i = 0;
      while (i < paramLinkedList.size())
      {
        localbcr = (bcr)paramLinkedList.get(i);
        localm = r.PK().bp(localbcr.kWl, this.bIv);
        arrayOfByte = aa.a(localbcr.swR);
        if (localbcr.swR != null) {
          break label124;
        }
        y.e("MicroMsg.NetSceneGetPackageList", "error give me a null thumb it should be xml");
        i += 1;
      }
    }
    label124:
    String str2;
    Object localObject;
    if ((localm == null) || (localm.version != localbcr.hQQ))
    {
      str2 = new String(arrayOfByte);
      localObject = "zh_CN";
      if (str2.indexOf("zh_CN") >= 0)
      {
        label168:
        str2 = (String)localObject + "_ARTIST.mm";
        com.tencent.mm.a.e.deleteFile(str1 + str2);
        com.tencent.mm.a.e.deleteFile(str1 + (String)localObject + "_ARTISTF.mm");
        com.tencent.mm.a.e.b(str1, str2, arrayOfByte);
      }
    }
    else
    {
      localObject = a(localbcr);
      ((m)localObject).bcw = -1;
      if (localm != null) {
        break label383;
      }
      r.PK().a((m)localObject);
    }
    for (;;)
    {
      y.d("MicroMsg.NetSceneGetPackageList", localbcr.kRZ + " - " + localbcr.kWl + " - " + localbcr.sSc + " - " + localbcr.hQL);
      break;
      localObject = "en";
      if (str2.indexOf("en") >= 0) {
        break label168;
      }
      localObject = "zh_TW";
      if (str2.indexOf("zh_TW") >= 0) {
        break label168;
      }
      localObject = "en";
      break label168;
      label383:
      r.PK().b((m)localObject);
    }
  }
  
  private void k(LinkedList<bcr> paramLinkedList)
  {
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      y.d("MicroMsg.NetSceneGetPackageList", "empty config list");
      return;
    }
    y.d("MicroMsg.NetSceneGetPackageList", "updateConfigList pkgList size " + paramLinkedList.size());
    int i = 0;
    label47:
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (i < paramLinkedList.size())
    {
      localObject1 = (bcr)paramLinkedList.get(i);
      localObject2 = r.PK().bp(((bcr)localObject1).kWl, this.bIv);
      localObject3 = a((bcr)localObject1);
      ((m)localObject3).bcw = -1;
      if (localObject2 != null) {
        break label329;
      }
      r.PK().a((m)localObject3);
    }
    for (;;)
    {
      y.d("MicroMsg.NetSceneGetPackageList", ((bcr)localObject1).kRZ + " - " + ((bcr)localObject1).kWl + " - " + ((bcr)localObject1).sSc + " - " + ((bcr)localObject1).hQL);
      localObject2 = aa.a(((bcr)localObject1).swR);
      localObject3 = new String((byte[])localObject2);
      y.d("MicroMsg.NetSceneGetPackageList", "ConfigList xml : " + (String)localObject3);
      localObject3 = ((com.tencent.mm.plugin.zero.b.a)g.r(com.tencent.mm.plugin.zero.b.a.class)).AB();
      int j = ((bcr)localObject1).kWl;
      localObject1 = new File(c.dAj);
      if (!((File)localObject1).exists()) {
        ((File)localObject1).mkdir();
      }
      try
      {
        localObject1 = new File(c.gI(j));
        if (!((File)localObject1).exists()) {
          ((File)localObject1).createNewFile();
        }
        com.tencent.mm.a.e.b(c.gI(j), (byte[])localObject2, localObject2.length);
        ((c)localObject3).m(j, new String((byte[])localObject2));
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.e("MicroMsg.ConfigListDecoder", "exception:%s", new Object[] { bk.j(localException) });
        }
      }
      i += 1;
      break label47;
      break;
      label329:
      r.PK().b((m)localObject3);
    }
  }
  
  private void l(LinkedList<bcr> paramLinkedList)
  {
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      y.d("MicroMsg.NetSceneGetPackageList", "empty regioncode pkg list");
      return;
    }
    y.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + paramLinkedList.size());
    paramLinkedList = paramLinkedList.iterator();
    label50:
    bcr localbcr;
    m localm2;
    if (paramLinkedList.hasNext())
    {
      localbcr = (bcr)paramLinkedList.next();
      m localm1 = r.PK().bp(localbcr.kWl, this.bIv);
      localm2 = a(localbcr);
      localm2.bcw = -1;
      if (localm1 != null) {
        break label174;
      }
      r.PK().a(localm2);
    }
    for (;;)
    {
      y.d("MicroMsg.NetSceneGetPackageList", localbcr.kRZ + " - " + localbcr.kWl + " - " + localbcr.sSc + " - " + localbcr.hQL);
      break label50;
      break;
      label174:
      r.PK().b(localm2);
    }
  }
  
  private void m(LinkedList<bcr> paramLinkedList)
  {
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      y.e("MicroMsg.NetSceneGetPackageList", "empty address pkg list");
      return;
    }
    y.i("MicroMsg.NetSceneGetPackageList", "updateRcptAddress pkgList size " + paramLinkedList.size());
    int i = 0;
    label47:
    Object localObject2;
    Object localObject1;
    if (i < paramLinkedList.size())
    {
      localObject2 = (bcr)paramLinkedList.get(i);
      localObject1 = r.PK().bp(((bcr)localObject2).kWl, this.bIv);
      localObject2 = a((bcr)localObject2);
      ((m)localObject2).bcw = -1;
      if (localObject1 != null) {
        break label142;
      }
      r.PK().a((m)localObject2);
    }
    for (;;)
    {
      localObject1 = new j(((m)localObject2).id, 12);
      g.DO().dJT.a((com.tencent.mm.ah.m)localObject1, 0);
      i += 1;
      break label47;
      break;
      label142:
      r.PK().b((m)localObject2);
    }
  }
  
  private void n(LinkedList<bcr> paramLinkedList)
  {
    y.d("MicroMsg.NetSceneGetPackageList", "updateLangPkg");
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0)) {
      y.d("MicroMsg.NetSceneGetPackageList", "empty langage package list");
    }
    for (;;)
    {
      return;
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        Object localObject = (bcr)paramLinkedList.next();
        y.d("MicroMsg.NetSceneGetPackageList", "pkg.toString %s", new Object[] { localObject.toString() });
        m localm = r.PK().bp(((bcr)localObject).kWl, this.bIv);
        localObject = a((bcr)localObject);
        ((m)localObject).bcw = -1;
        if (localm == null) {
          r.PK().a((m)localObject);
        } else {
          r.PK().b((m)localObject);
        }
      }
    }
  }
  
  private void o(LinkedList<bcr> paramLinkedList)
  {
    y.d("MicroMsg.NetSceneGetPackageList", "updateAppleEmojiPackage");
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      y.d("MicroMsg.NetSceneGetPackageList", "update apple emoji but package list is empty.");
      return;
    }
    y.i("MicroMsg.NetSceneGetPackageList", "start update apple emoji. package list size " + paramLinkedList.size());
    paramLinkedList = paramLinkedList.iterator();
    label58:
    Object localObject2;
    Object localObject1;
    while (paramLinkedList.hasNext())
    {
      localObject2 = (bcr)paramLinkedList.next();
      localObject1 = r.PK().bp(((bcr)localObject2).kWl, this.bIv);
      if ((localObject1 == null) || (((m)localObject1).version != ((bcr)localObject2).hQQ))
      {
        localObject2 = a((bcr)localObject2);
        ((m)localObject2).bcw = -1;
        if (localObject1 != null) {
          break label159;
        }
        r.PK().a((m)localObject2);
      }
    }
    for (;;)
    {
      localObject1 = new j(((m)localObject2).id, 37);
      g.DO().dJT.a((com.tencent.mm.ah.m)localObject1, 0);
      break label58;
      break;
      label159:
      r.PK().b((m)localObject2);
    }
  }
  
  public final int KF()
  {
    return this.bIv;
  }
  
  protected final int Ka()
  {
    return 20;
  }
  
  public final boolean Kx()
  {
    return true;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    y.d("MicroMsg.NetSceneGetPackageList", "DoScene dkregcode :" + this.bIv);
    paramf = new b.a();
    paramf.ecH = new aik();
    paramf.ecI = new ail();
    paramf.uri = "/cgi-bin/micromsg-bin/getpackagelist";
    paramf.ecG = 159;
    paramf.ecJ = 51;
    paramf.ecK = 1000000051;
    this.dmK = paramf.Kt();
    paramf = (aik)this.dmK.ecE.ecN;
    LinkedList localLinkedList = new LinkedList();
    if (!g.DN().Dc()) {
      return -1;
    }
    m[] arrayOfm = r.PK().ja(this.bIv);
    if ((arrayOfm != null) && (arrayOfm.length > 0))
    {
      int i = 0;
      if (i < arrayOfm.length)
      {
        bcr localbcr = new bcr();
        localbcr.kWl = arrayOfm[i].id;
        if ((ae.eSF) && (this.bIv == 7)) {
          y.d("MicroMsg.NetSceneGetPackageList", "isShakeGetConfigList");
        }
        for (localbcr.hQQ = 0;; localbcr.hQQ = arrayOfm[i].version)
        {
          y.d("MicroMsg.NetSceneGetPackageList", "package, id:%d, ver:%d", new Object[] { Integer.valueOf(localbcr.kWl), Integer.valueOf(localbcr.hQQ) });
          localLinkedList.add(localbcr);
          i += 1;
          break;
        }
      }
    }
    paramf.hPT = localLinkedList;
    paramf.hPS = localLinkedList.size();
    paramf.hQR = this.bIv;
    if (this.flags != -1) {
      paramf.svx = this.flags;
    }
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneGetPackageList", "onGYNetEnd, netid:%d, errType:%d, errCode:%d, pkgType:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.bIv), paramString });
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    paramq = (ail)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    if (paramq.hQR != this.bIv)
    {
      y.e("MicroMsg.NetSceneGetPackageList", "packageType is not consistent, respType = %d", new Object[] { Integer.valueOf(paramq.hQR) });
      this.dmL.onSceneEnd(3, -1, "", this);
      return;
    }
    paramArrayOfByte = paramq.hPT;
    Object localObject1 = new StringBuilder("summer list size:");
    if (paramArrayOfByte == null)
    {
      paramInt1 = 0;
      label164:
      y.v("MicroMsg.NetSceneGetPackageList", paramInt1 + " packageType: " + this.bIv + " resp.Type: " + paramq.hQR);
      if (this.bIv != 2) {
        break label308;
      }
      i(paramArrayOfByte);
    }
    for (;;)
    {
      localObject1 = new sp();
      ((sp)localObject1).ccg.cch = paramArrayOfByte;
      ((sp)localObject1).ccg.bIv = this.bIv;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
      if (paramq.sFD <= 0) {
        break label1367;
      }
      if (a(this.edc, this.dmL) != -1) {
        break;
      }
      this.dmL.onSceneEnd(3, -1, "doScene failed", this);
      return;
      paramInt1 = paramArrayOfByte.size();
      break label164;
      label308:
      if (this.bIv == 1)
      {
        h(paramArrayOfByte);
      }
      else if (this.bIv == 4)
      {
        j(paramArrayOfByte);
      }
      else if (this.bIv == 6)
      {
        y.i("MicroMsg.NetSceneGetPackageList", "change new egg.");
      }
      else if (this.bIv == 7)
      {
        k(paramArrayOfByte);
      }
      else if (this.bIv == 9)
      {
        g(paramArrayOfByte);
      }
      else
      {
        Object localObject2;
        if (this.bIv == 10)
        {
          if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
          {
            y.e("MicroMsg.NetSceneGetPackageList", "empty mass send top config package");
          }
          else
          {
            y.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + paramArrayOfByte.size());
            localObject2 = (bcr)paramArrayOfByte.get(0);
            localObject1 = r.PK().bp(((bcr)localObject2).kWl, this.bIv);
            localObject2 = a((bcr)localObject2);
            ((m)localObject2).bcw = -1;
            if (localObject1 == null) {
              r.PK().a((m)localObject2);
            } else {
              r.PK().b((m)localObject2);
            }
          }
        }
        else if (this.bIv != 11) {
          if (this.bIv == 12) {
            m(paramArrayOfByte);
          } else if (this.bIv == 5) {
            n(paramArrayOfByte);
          } else if (this.bIv == 20) {
            l(paramArrayOfByte);
          } else if (this.bIv == 17)
          {
            if ((paramArrayOfByte == null) || (paramArrayOfByte.size() == 0))
            {
              y.d("MicroMsg.NetSceneGetPackageList", "poi type is null");
            }
            else
            {
              localObject1 = (bcr)paramArrayOfByte.get(0);
              y.d("MicroMsg.NetSceneGetPackageList", ((bcr)localObject1).kRZ + " - " + ((bcr)localObject1).kWl + " - " + ((bcr)localObject1).sSc + " - " + ((bcr)localObject1).hQL);
              localObject2 = r.PK().bp(((bcr)localObject1).kWl, this.bIv);
              m localm2 = a((bcr)localObject1);
              localm2.bcw = -1;
              if (localObject2 == null) {
                r.PK().a(localm2);
              }
              for (;;)
              {
                for (;;)
                {
                  localObject2 = new mb();
                  try
                  {
                    ((mb)localObject2).bVg.content = aa.a(((bcr)localObject1).swR);
                    if (((mb)localObject2).bVg.content == null) {
                      break;
                    }
                    com.tencent.mm.sdk.b.a.udP.a((com.tencent.mm.sdk.b.b)localObject2, Looper.getMainLooper());
                  }
                  catch (Exception localException)
                  {
                    y.e("MicroMsg.NetSceneGetPackageList", localException.getMessage());
                  }
                }
                r.PK().b(localm2);
              }
            }
          }
          else if (this.bIv != 18) {
            if (this.bIv == 19)
            {
              U(paramArrayOfByte);
            }
            else
            {
              m localm1;
              if (this.bIv == 21)
              {
                if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
                {
                  y.d("MicroMsg.NetSceneGetPackageList", "summer trace config empty scene list");
                }
                else
                {
                  localObject2 = (bcr)paramArrayOfByte.get(0);
                  y.d("MicroMsg.NetSceneGetPackageList", "summer getpackage pkg: " + localObject2 + "|id = " + ((bcr)localObject2).kWl + "|Name = " + ((bcr)localObject2).kRZ + "|PackName = " + ((bcr)localObject2).sSc + "|Size = " + ((bcr)localObject2).hQL + "|Version = " + ((bcr)localObject2).hQQ);
                  localm1 = r.PK().bp(((bcr)localObject2).kWl, this.bIv);
                  localObject2 = a((bcr)localObject2);
                  ((m)localObject2).bcw = -1;
                  if (localm1 == null) {
                    r.PK().a((m)localObject2);
                  } else if (localm1.version < ((m)localObject2).version) {
                    r.PK().b((m)localObject2);
                  } else {
                    y.d("MicroMsg.NetSceneGetPackageList", "summer old version [%d] new version[%d], not need update", new Object[] { Integer.valueOf(localm1.version), Integer.valueOf(((m)localObject2).version) });
                  }
                }
              }
              else if (23 == this.bIv)
              {
                if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
                {
                  y.d("MicroMsg.NetSceneGetPackageList", "permission tips config is empty");
                }
                else
                {
                  localObject2 = (bcr)paramArrayOfByte.get(0);
                  y.d("MicroMsg.NetSceneGetPackageList", "permission getpackage pkg: " + localObject2 + "|id = " + ((bcr)localObject2).kWl + "|Name = " + ((bcr)localObject2).kRZ + "|PackName = " + ((bcr)localObject2).sSc + "|Size = " + ((bcr)localObject2).hQL + "|Version = " + ((bcr)localObject2).hQQ);
                  localm1 = r.PK().bp(((bcr)localObject2).kWl, this.bIv);
                  localObject2 = a((bcr)localObject2);
                  ((m)localObject2).bcw = -1;
                  if (localm1 == null) {
                    r.PK().a((m)localObject2);
                  } else if (localm1.version < ((m)localObject2).version) {
                    r.PK().b((m)localObject2);
                  }
                }
              }
              else if (this.bIv == 26) {
                V(paramArrayOfByte);
              } else if (this.bIv == 36) {
                W(paramArrayOfByte);
              } else if (this.bIv == 37) {
                o(paramArrayOfByte);
              }
            }
          }
        }
      }
    }
    label1367:
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  protected final void a(m.a parama) {}
  
  protected final m.b b(q paramq)
  {
    return m.b.edr;
  }
  
  protected final boolean b(com.tencent.mm.ah.m paramm)
  {
    if (!(paramm instanceof k)) {}
    while (this.bIv != ((k)paramm).bIv) {
      return true;
    }
    return false;
  }
  
  public final int getType()
  {
    return 159;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.az.k
 * JD-Core Version:    0.7.0.1
 */