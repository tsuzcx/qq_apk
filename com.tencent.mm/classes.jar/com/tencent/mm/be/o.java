package com.tencent.mm.be;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q.a;
import com.tencent.mm.an.q.b;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.qo;
import com.tencent.mm.f.a.qo.a;
import com.tencent.mm.f.a.zx;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.protocal.protobuf.bzw;
import com.tencent.mm.protocal.protobuf.bzx;
import com.tencent.mm.protocal.protobuf.dhn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class o
  extends com.tencent.mm.an.q
  implements com.tencent.mm.an.s, m
{
  private i callback;
  private int flags;
  private int fyH;
  private boolean lXS;
  private com.tencent.mm.an.d rr;
  
  public o(int paramInt)
  {
    AppMethodBeat.i(150814);
    this.lXS = false;
    this.flags = -1;
    this.fyH = paramInt;
    this.lXS = false;
    Log.d("MicroMsg.NetSceneGetPackageList", "Init dkregcode:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(150814);
  }
  
  public o(boolean paramBoolean)
  {
    AppMethodBeat.i(150813);
    this.lXS = false;
    this.flags = -1;
    this.fyH = 26;
    this.lXS = false;
    Log.d("MicroMsg.NetSceneGetPackageList", "Init dkregcode:26");
    Log.d("MicroMsg.NetSceneGetPackageList", "isOnlyCheckInReqList: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      this.flags = 1;
    }
    AppMethodBeat.o(150813);
  }
  
  private r a(dhn paramdhn)
  {
    AppMethodBeat.i(150816);
    r localr = new r();
    localr.id = paramdhn.CRP;
    localr.version = paramdhn.rWt;
    localr.name = paramdhn.CMP;
    localr.size = paramdhn.rWo;
    localr.lXZ = paramdhn.Suv;
    localr.status = 5;
    localr.fES = this.fyH;
    AppMethodBeat.o(150816);
    return localr;
  }
  
  private void aA(List<dhn> paramList)
  {
    AppMethodBeat.i(150827);
    if ((paramList == null) || (paramList.size() == 0))
    {
      Log.d("MicroMsg.NetSceneGetPackageList", "update sense where location but package list is empty.");
      AppMethodBeat.o(150827);
      return;
    }
    Log.i("MicroMsg.NetSceneGetPackageList", "start update sense where location. package list size " + paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject2 = (dhn)paramList.next();
      Object localObject1 = w.bnU().dQ(((dhn)localObject2).CRP, this.fyH);
      if ((localObject1 == null) || (((r)localObject1).version != ((dhn)localObject2).rWt))
      {
        localObject2 = a((dhn)localObject2);
        ((r)localObject2).cUP = -1;
        if (localObject1 == null) {
          w.bnU().a((r)localObject2);
        }
        for (;;)
        {
          localObject1 = new n(((r)localObject2).id, 36);
          h.aHF().kcd.a((com.tencent.mm.an.q)localObject1, 0);
          break;
          w.bnU().b((r)localObject2);
        }
      }
    }
    AppMethodBeat.o(150827);
  }
  
  private void ay(List<dhn> paramList)
  {
    AppMethodBeat.i(150825);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      Log.d("MicroMsg.NetSceneGetPackageList", "[oneliang]empty update expose scene list");
      AppMethodBeat.o(150825);
      return;
    }
    w.bnU();
    String str = s.bnR();
    int i = 0;
    if (i < paramList.size())
    {
      dhn localdhn = (dhn)paramList.get(i);
      Object localObject = w.bnU().dQ(localdhn.CRP, this.fyH);
      r localr;
      if ((localObject == null) || (((r)localObject).version != localdhn.rWt))
      {
        u.deleteFile(str + w.bnU().dS(localdhn.CRP, this.fyH));
        localr = a(localdhn);
        localr.cUP = -1;
        if (localObject != null) {
          break label225;
        }
        w.bnU().a(localr);
      }
      for (;;)
      {
        localObject = new n(localr.id, 19);
        h.aHF().kcd.a((com.tencent.mm.an.q)localObject, 0);
        Log.d("MicroMsg.NetSceneGetPackageList", "[oneliang]name:%s,packName:%s", new Object[] { localdhn.CMP, localdhn.Suv });
        i += 1;
        break;
        label225:
        w.bnU().b(localr);
      }
    }
    AppMethodBeat.o(150825);
  }
  
  private void az(List<dhn> paramList)
  {
    AppMethodBeat.i(150826);
    if ((paramList == null) || (paramList.size() == 0))
    {
      Log.d("MicroMsg.NetSceneGetPackageList", "updateIPCallCountryCodeConfig, package list is empty");
      AppMethodBeat.o(150826);
      return;
    }
    Log.d("MicroMsg.NetSceneGetPackageList", "updateIPCallCountryCodeConfig, pkgList.size: %d", new Object[] { Integer.valueOf(paramList.size()) });
    int i = ((Integer)h.aHG().aHp().get(ar.a.Vjb, Integer.valueOf(-1))).intValue();
    Log.d("MicroMsg.NetSceneGetPackageList", "configPkgId: %d", new Object[] { Integer.valueOf(i) });
    if (i == -1)
    {
      AppMethodBeat.o(150826);
      return;
    }
    r localr1 = w.bnU().dQ(i, this.fyH);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      r localr2 = a((dhn)paramList.next());
      Log.d("MicroMsg.NetSceneGetPackageList", "newInfo.id: %d, version: %d", new Object[] { Integer.valueOf(localr2.id), Integer.valueOf(localr2.version) });
      if ((localr1 != null) && (localr2.id == i))
      {
        Log.d("MicroMsg.NetSceneGetPackageList", "find match old pkg, update one");
        w.bnU().b(localr2);
        AppMethodBeat.o(150826);
        return;
      }
      if ((localr1 == null) && (localr2.id == i))
      {
        Log.d("MicroMsg.NetSceneGetPackageList", "insert new pkg");
        w.bnU().a(localr2);
        AppMethodBeat.o(150826);
        return;
      }
    }
    AppMethodBeat.o(150826);
  }
  
  public static String bnO()
  {
    AppMethodBeat.i(187635);
    String str = h.aHG().cachePath;
    AppMethodBeat.o(187635);
    return str;
  }
  
  private void g(LinkedList<dhn> paramLinkedList)
  {
    AppMethodBeat.i(150818);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      Log.d("MicroMsg.NetSceneGetPackageList", "empty upload speex config list");
      AppMethodBeat.o(150818);
      return;
    }
    w.bnU();
    String str = s.bnR();
    int i = 0;
    if (i < paramLinkedList.size())
    {
      dhn localdhn = (dhn)paramLinkedList.get(i);
      Object localObject = w.bnU().dQ(localdhn.CRP, this.fyH);
      r localr;
      if ((localObject == null) || (((r)localObject).version != localdhn.rWt))
      {
        u.deleteFile(str + w.bnU().dS(localdhn.CRP, this.fyH));
        localr = a(localdhn);
        localr.cUP = -1;
        if (localObject != null) {
          break label353;
        }
        w.bnU().a(localr);
      }
      for (;;)
      {
        localObject = new n(localr.id, 9);
        h.aHF().kcd.a((com.tencent.mm.an.q)localObject, 0);
        if (z.a(localdhn.RJR) != null) {
          Log.v("MicroMsg.NetSceneGetPackageList", "xml:".concat(String.valueOf(new String(z.a(localdhn.RJR)))));
        }
        if (z.a(localdhn.TOI) != null) {
          Log.v("MicroMsg.NetSceneGetPackageList", "xml2:".concat(String.valueOf(new String(z.a(localdhn.TOI)))));
        }
        Log.v("MicroMsg.NetSceneGetPackageList", "xml3:" + localdhn.toString());
        Log.v("MicroMsg.NetSceneGetPackageList", "xml4:" + localdhn.CMP);
        Log.v("MicroMsg.NetSceneGetPackageList", "xml5:" + localdhn.Suv);
        i += 1;
        break;
        label353:
        w.bnU().b(localr);
      }
    }
    AppMethodBeat.o(150818);
  }
  
  private void h(LinkedList<dhn> paramLinkedList)
  {
    AppMethodBeat.i(150819);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      Log.e("MicroMsg.NetSceneGetPackageList", "empty background pkg list");
      AppMethodBeat.o(150819);
      return;
    }
    w.bnU();
    String str = s.bnR();
    int i = 0;
    if (i < paramLinkedList.size())
    {
      Object localObject1 = (dhn)paramLinkedList.get(i);
      Object localObject2 = w.bnU().dQ(((dhn)localObject1).CRP, this.fyH);
      r localr;
      if ((localObject2 == null) || (((r)localObject2).version != ((dhn)localObject1).rWt))
      {
        u.deleteFile(str + w.bnU().dS(((dhn)localObject1).CRP, this.fyH));
        localr = a((dhn)localObject1);
        localr.cUP = -1;
        if (localObject2 != null) {
          break label291;
        }
      }
      label291:
      for (boolean bool = w.bnU().a(localr);; bool = w.bnU().b(localr))
      {
        Log.i("MicroMsg.NetSceneGetPackageList", "[updateBackgroundPkg] ret:%s newInfo:%s", new Object[] { Boolean.valueOf(bool), localr });
        localObject2 = z.a(((dhn)localObject1).RJR);
        if ((localObject2 != null) && (localObject2.length > 0))
        {
          w.bnU();
          localObject1 = s.dR(((dhn)localObject1).CRP, this.fyH);
          u.deleteFile(str + (String)localObject1);
          if (u.F(str + (String)localObject1, (byte[])localObject2) < 0) {
            Log.e("MicroMsg.NetSceneGetPackageList", "[updateBackgroundPkg] appendBuf thumb error!");
          }
        }
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(150819);
  }
  
  @Deprecated
  private void i(LinkedList<dhn> paramLinkedList)
  {
    AppMethodBeat.i(150820);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      Log.d("MicroMsg.NetSceneGetPackageList", "empty emoji pkg list");
      AppMethodBeat.o(150820);
      return;
    }
    int i = 0;
    if (i < paramLinkedList.size())
    {
      Object localObject1 = (dhn)paramLinkedList.get(i);
      Object localObject2 = w.bnU().dQ(((dhn)localObject1).CRP, this.fyH);
      r localr = a((dhn)localObject1);
      localr.cUP = -1;
      if (localObject2 == null) {
        w.bnU().a(localr);
      }
      for (;;)
      {
        localObject1 = z.a(((dhn)localObject1).RJR);
        if ((localObject1 != null) && (localObject1.length > 0))
        {
          localObject2 = new ArrayList();
          ((List)localObject2).add(new String((byte[])localObject1));
          ((List)localObject2).size();
        }
        i += 1;
        break;
        w.bnU().b(localr);
      }
    }
    AppMethodBeat.o(150820);
  }
  
  private void j(LinkedList<dhn> paramLinkedList)
  {
    AppMethodBeat.i(150821);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      Log.d("MicroMsg.NetSceneGetPackageList", "empty emoji pkg list");
      AppMethodBeat.o(150821);
      return;
    }
    Log.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + paramLinkedList.size());
    w.bnU();
    String str1 = s.bnR();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      dhn localdhn = (dhn)paramLinkedList.get(i);
      r localr = w.bnU().dQ(localdhn.CRP, this.fyH);
      byte[] arrayOfByte = z.a(localdhn.RJR);
      if (localdhn.RJR == null)
      {
        Log.e("MicroMsg.NetSceneGetPackageList", "error give me a null thumb it should be xml");
        i += 1;
      }
      else
      {
        String str2;
        Object localObject;
        if ((localr == null) || (localr.version != localdhn.rWt))
        {
          str2 = new String(arrayOfByte);
          localObject = "zh_CN";
          if (str2.indexOf("zh_CN") >= 0)
          {
            label180:
            str2 = (String)localObject + "_ARTIST.mm";
            u.deleteFile(str1 + str2);
            u.deleteFile(str1 + (String)localObject + "_ARTISTF.mm");
            u.F(str1 + str2, arrayOfByte);
          }
        }
        else
        {
          localObject = a(localdhn);
          ((r)localObject).cUP = -1;
          if (localr != null) {
            break label411;
          }
          w.bnU().a((r)localObject);
        }
        for (;;)
        {
          Log.d("MicroMsg.NetSceneGetPackageList", localdhn.CMP + " - " + localdhn.CRP + " - " + localdhn.Suv + " - " + localdhn.rWo);
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
          label411:
          w.bnU().b((r)localObject);
        }
      }
    }
    AppMethodBeat.o(150821);
  }
  
  private void k(LinkedList<dhn> paramLinkedList)
  {
    AppMethodBeat.i(150822);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      Log.d("MicroMsg.NetSceneGetPackageList", "empty config list");
      AppMethodBeat.o(150822);
      return;
    }
    Log.d("MicroMsg.NetSceneGetPackageList", "updateConfigList pkgList size " + paramLinkedList.size());
    int i = 0;
    if (i < paramLinkedList.size())
    {
      Object localObject1 = (dhn)paramLinkedList.get(i);
      Object localObject2 = w.bnU().dQ(((dhn)localObject1).CRP, this.fyH);
      Object localObject3 = a((dhn)localObject1);
      ((r)localObject3).cUP = -1;
      if (localObject2 == null) {
        w.bnU().a((r)localObject3);
      }
      for (;;)
      {
        Log.d("MicroMsg.NetSceneGetPackageList", ((dhn)localObject1).CMP + " - " + ((dhn)localObject1).CRP + " - " + ((dhn)localObject1).Suv + " - " + ((dhn)localObject1).rWo);
        localObject2 = z.a(((dhn)localObject1).RJR);
        Log.d("MicroMsg.NetSceneGetPackageList", "ConfigList xml : ".concat(String.valueOf(new String((byte[])localObject2))));
        localObject3 = ((a)h.ae(a.class)).axd();
        int j = ((dhn)localObject1).CRP;
        localObject1 = new com.tencent.mm.vfs.q(com.tencent.mm.n.d.jwu);
        if (!((com.tencent.mm.vfs.q)localObject1).ifE()) {
          ((com.tencent.mm.vfs.q)localObject1).ifK();
        }
        try
        {
          localObject1 = new com.tencent.mm.vfs.q(com.tencent.mm.n.d.qZ(j));
          if (!((com.tencent.mm.vfs.q)localObject1).ifE()) {
            ((com.tencent.mm.vfs.q)localObject1).ifM();
          }
          u.f(com.tencent.mm.n.d.qZ(j), (byte[])localObject2, localObject2.length);
          ((com.tencent.mm.n.d)localObject3).z(j, new String((byte[])localObject2));
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("MicroMsg.ConfigListDecoder", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
          }
        }
        i += 1;
        break;
        w.bnU().b((r)localObject3);
      }
    }
    AppMethodBeat.o(150822);
  }
  
  private void l(LinkedList<dhn> paramLinkedList)
  {
    AppMethodBeat.i(150823);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      Log.d("MicroMsg.NetSceneGetPackageList", "empty regioncode pkg list");
      AppMethodBeat.o(150823);
      return;
    }
    Log.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + paramLinkedList.size());
    paramLinkedList = paramLinkedList.iterator();
    if (paramLinkedList.hasNext())
    {
      dhn localdhn = (dhn)paramLinkedList.next();
      r localr1 = w.bnU().dQ(localdhn.CRP, this.fyH);
      r localr2 = a(localdhn);
      localr2.cUP = -1;
      if (localr1 == null) {
        w.bnU().a(localr2);
      }
      for (;;)
      {
        Log.d("MicroMsg.NetSceneGetPackageList", localdhn.CMP + " - " + localdhn.CRP + " - " + localdhn.Suv + " - " + localdhn.rWo);
        break;
        w.bnU().b(localr2);
      }
    }
    AppMethodBeat.o(150823);
  }
  
  private void m(LinkedList<dhn> paramLinkedList)
  {
    AppMethodBeat.i(150824);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      Log.e("MicroMsg.NetSceneGetPackageList", "empty address pkg list");
      AppMethodBeat.o(150824);
      return;
    }
    Log.i("MicroMsg.NetSceneGetPackageList", "updateRcptAddress pkgList size " + paramLinkedList.size());
    int i = 0;
    if (i < paramLinkedList.size())
    {
      Object localObject2 = (dhn)paramLinkedList.get(i);
      Object localObject1 = w.bnU().dQ(((dhn)localObject2).CRP, this.fyH);
      localObject2 = a((dhn)localObject2);
      ((r)localObject2).cUP = -1;
      if (localObject1 == null) {
        w.bnU().a((r)localObject2);
      }
      for (;;)
      {
        localObject1 = new n(((r)localObject2).id, 12);
        h.aHF().kcd.a((com.tencent.mm.an.q)localObject1, 0);
        i += 1;
        break;
        w.bnU().b((r)localObject2);
      }
    }
    AppMethodBeat.o(150824);
  }
  
  private void n(LinkedList<dhn> paramLinkedList)
  {
    AppMethodBeat.i(150828);
    Log.d("MicroMsg.NetSceneGetPackageList", "updateLangPkg");
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      Log.d("MicroMsg.NetSceneGetPackageList", "empty langage package list");
      AppMethodBeat.o(150828);
      return;
    }
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      Object localObject = (dhn)paramLinkedList.next();
      Log.d("MicroMsg.NetSceneGetPackageList", "pkg.toString %s", new Object[] { localObject.toString() });
      r localr = w.bnU().dQ(((dhn)localObject).CRP, this.fyH);
      localObject = a((dhn)localObject);
      ((r)localObject).cUP = -1;
      if (localr == null) {
        w.bnU().a((r)localObject);
      } else {
        w.bnU().b((r)localObject);
      }
    }
    AppMethodBeat.o(150828);
  }
  
  private void o(LinkedList<dhn> paramLinkedList)
  {
    AppMethodBeat.i(150829);
    Log.d("MicroMsg.NetSceneGetPackageList", "updateAppleEmojiPackage");
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      Log.d("MicroMsg.NetSceneGetPackageList", "update apple emoji but package list is empty.");
      AppMethodBeat.o(150829);
      return;
    }
    Log.i("MicroMsg.NetSceneGetPackageList", "start update apple emoji. package list size " + paramLinkedList.size());
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      Object localObject2 = (dhn)paramLinkedList.next();
      Object localObject1 = w.bnU().dQ(((dhn)localObject2).CRP, this.fyH);
      if ((localObject1 == null) || (((r)localObject1).version != ((dhn)localObject2).rWt))
      {
        localObject2 = a((dhn)localObject2);
        ((r)localObject2).cUP = -1;
        if (localObject1 == null) {
          w.bnU().a((r)localObject2);
        }
        for (;;)
        {
          localObject1 = new n(((r)localObject2).id, 37);
          h.aHF().kcd.a((com.tencent.mm.an.q)localObject1, 0);
          break;
          w.bnU().b((r)localObject2);
        }
      }
    }
    AppMethodBeat.o(150829);
  }
  
  public final boolean acceptConcurrent(com.tencent.mm.an.q paramq)
  {
    if (!(paramq instanceof o)) {}
    while (this.fyH != ((o)paramq).fyH) {
      return true;
    }
    return false;
  }
  
  public final int big()
  {
    return this.fyH;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(150815);
    this.callback = parami;
    Log.d("MicroMsg.NetSceneGetPackageList", "DoScene dkregcode :" + this.fyH);
    parami = new d.a();
    parami.lBU = new bzw();
    parami.lBV = new bzx();
    parami.uri = "/cgi-bin/micromsg-bin/getpackagelist";
    parami.funcId = 159;
    parami.lBW = 51;
    parami.respCmdId = 1000000051;
    this.rr = parami.bgN();
    parami = (bzw)d.b.b(this.rr.lBR);
    LinkedList localLinkedList = new LinkedList();
    if (!h.aHE().aGM())
    {
      AppMethodBeat.o(150815);
      return -1;
    }
    r[] arrayOfr = w.bnU().wJ(this.fyH);
    if ((arrayOfr != null) && (arrayOfr.length > 0))
    {
      i = 0;
      if (i < arrayOfr.length)
      {
        dhn localdhn = new dhn();
        localdhn.CRP = arrayOfr[i].id;
        if ((ac.mFB) && (this.fyH == 7))
        {
          Log.d("MicroMsg.NetSceneGetPackageList", "isShakeGetConfigList");
          localdhn.rWt = 0;
        }
        for (;;)
        {
          Log.d("MicroMsg.NetSceneGetPackageList", "package, id:%d, ver:%d", new Object[] { Integer.valueOf(localdhn.CRP), Integer.valueOf(localdhn.rWt) });
          localLinkedList.add(localdhn);
          i += 1;
          break;
          if ((12 == this.fyH) && (!u.agG(h.aHG().cachePath + "address")))
          {
            Log.i("MicroMsg.NetSceneGetPackageList", "MMRCPTADDRESS final save file not found, set pkg.Version=0");
            localdhn.rWt = 0;
          }
          else
          {
            localdhn.rWt = arrayOfr[i].version;
          }
        }
      }
    }
    parami.rVy = localLinkedList;
    parami.rVx = localLinkedList.size();
    parami.rWu = this.fyH;
    if (this.flags != -1) {
      parami.RIs = this.flags;
    }
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(150815);
    return i;
  }
  
  public final int getType()
  {
    return 159;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150817);
    Log.i("MicroMsg.NetSceneGetPackageList", "onGYNetEnd, netid:%d, errType:%d, errCode:%d, pkgType:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.fyH), paramString });
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150817);
      return;
    }
    params = (bzx)d.c.b(((com.tencent.mm.an.d)params).lBS);
    if (params.rWu != this.fyH)
    {
      Log.e("MicroMsg.NetSceneGetPackageList", "packageType is not consistent, respType = %d", new Object[] { Integer.valueOf(params.rWu) });
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(150817);
      return;
    }
    paramArrayOfByte = params.rVy;
    Object localObject1 = new StringBuilder("summer list size:");
    if (paramArrayOfByte == null)
    {
      paramInt1 = 0;
      Log.i("MicroMsg.NetSceneGetPackageList", paramInt1 + " packageType: " + this.fyH + " resp.Type: " + params.rWu);
      if (this.fyH != 2) {
        break label332;
      }
      i(paramArrayOfByte);
    }
    for (;;)
    {
      localObject1 = new zx();
      ((zx)localObject1).fZj.fZk = paramArrayOfByte;
      ((zx)localObject1).fZj.fyH = this.fyH;
      EventCenter.instance.publish((IEvent)localObject1);
      if (params.Saq <= 0) {
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
      if (this.fyH == 1)
      {
        h(paramArrayOfByte);
      }
      else if (this.fyH == 4)
      {
        j(paramArrayOfByte);
      }
      else if (this.fyH == 6)
      {
        Log.i("MicroMsg.NetSceneGetPackageList", "change new egg.");
      }
      else if (this.fyH == 7)
      {
        k(paramArrayOfByte);
      }
      else if (this.fyH == 9)
      {
        g(paramArrayOfByte);
      }
      else
      {
        Object localObject2;
        if (this.fyH == 10)
        {
          if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
          {
            Log.e("MicroMsg.NetSceneGetPackageList", "empty mass send top config package");
          }
          else
          {
            Log.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + paramArrayOfByte.size());
            localObject2 = (dhn)paramArrayOfByte.get(0);
            localObject1 = w.bnU().dQ(((dhn)localObject2).CRP, this.fyH);
            localObject2 = a((dhn)localObject2);
            ((r)localObject2).cUP = -1;
            if (localObject1 == null) {
              w.bnU().a((r)localObject2);
            } else {
              w.bnU().b((r)localObject2);
            }
          }
        }
        else if (this.fyH != 11) {
          if (this.fyH == 12) {
            m(paramArrayOfByte);
          } else if (this.fyH == 5) {
            n(paramArrayOfByte);
          } else if (this.fyH == 20) {
            l(paramArrayOfByte);
          } else if (this.fyH == 17)
          {
            if ((paramArrayOfByte == null) || (paramArrayOfByte.size() == 0))
            {
              Log.d("MicroMsg.NetSceneGetPackageList", "poi type is null");
            }
            else
            {
              localObject1 = (dhn)paramArrayOfByte.get(0);
              Log.d("MicroMsg.NetSceneGetPackageList", ((dhn)localObject1).CMP + " - " + ((dhn)localObject1).CRP + " - " + ((dhn)localObject1).Suv + " - " + ((dhn)localObject1).rWo);
              localObject2 = w.bnU().dQ(((dhn)localObject1).CRP, this.fyH);
              r localr2 = a((dhn)localObject1);
              localr2.cUP = -1;
              if (localObject2 == null) {
                w.bnU().a(localr2);
              }
              for (;;)
              {
                for (;;)
                {
                  localObject2 = new qo();
                  try
                  {
                    ((qo)localObject2).fPj.fPk = z.a(((dhn)localObject1).RJR);
                    if (((qo)localObject2).fPj.fPk == null) {
                      break;
                    }
                    EventCenter.instance.asyncPublish((IEvent)localObject2, Looper.getMainLooper());
                  }
                  catch (Exception localException)
                  {
                    Log.e("MicroMsg.NetSceneGetPackageList", localException.getMessage());
                  }
                }
                w.bnU().b(localr2);
              }
            }
          }
          else if (this.fyH != 18) {
            if (this.fyH == 19)
            {
              ay(paramArrayOfByte);
            }
            else
            {
              r localr1;
              if (this.fyH == 21)
              {
                if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
                {
                  Log.d("MicroMsg.NetSceneGetPackageList", "summer trace config empty scene list");
                }
                else
                {
                  localObject2 = (dhn)paramArrayOfByte.get(0);
                  Log.d("MicroMsg.NetSceneGetPackageList", "summer getpackage pkg: " + localObject2 + "|id = " + ((dhn)localObject2).CRP + "|Name = " + ((dhn)localObject2).CMP + "|PackName = " + ((dhn)localObject2).Suv + "|Size = " + ((dhn)localObject2).rWo + "|Version = " + ((dhn)localObject2).rWt);
                  localr1 = w.bnU().dQ(((dhn)localObject2).CRP, this.fyH);
                  localObject2 = a((dhn)localObject2);
                  ((r)localObject2).cUP = -1;
                  if (localr1 == null) {
                    w.bnU().a((r)localObject2);
                  } else if (localr1.version < ((r)localObject2).version) {
                    w.bnU().b((r)localObject2);
                  } else {
                    Log.d("MicroMsg.NetSceneGetPackageList", "summer old version [%d] new version[%d], not need update", new Object[] { Integer.valueOf(localr1.version), Integer.valueOf(((r)localObject2).version) });
                  }
                }
              }
              else if (23 == this.fyH)
              {
                if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
                {
                  Log.d("MicroMsg.NetSceneGetPackageList", "permission tips config is empty");
                }
                else
                {
                  localObject2 = (dhn)paramArrayOfByte.get(0);
                  Log.d("MicroMsg.NetSceneGetPackageList", "permission getpackage pkg: " + localObject2 + "|id = " + ((dhn)localObject2).CRP + "|Name = " + ((dhn)localObject2).CMP + "|PackName = " + ((dhn)localObject2).Suv + "|Size = " + ((dhn)localObject2).rWo + "|Version = " + ((dhn)localObject2).rWt);
                  localr1 = w.bnU().dQ(((dhn)localObject2).CRP, this.fyH);
                  localObject2 = a((dhn)localObject2);
                  ((r)localObject2).cUP = -1;
                  if (localr1 == null) {
                    w.bnU().a((r)localObject2);
                  } else if (localr1.version < ((r)localObject2).version) {
                    w.bnU().b((r)localObject2);
                  }
                }
              }
              else if (this.fyH == 26) {
                az(paramArrayOfByte);
              } else if (this.fyH == 36) {
                aA(paramArrayOfByte);
              } else if (this.fyH == 37) {
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
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return q.b.lCx;
  }
  
  public final void setSecurityCheckError(q.a parama) {}
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.be.o
 * JD-Core Version:    0.7.0.1
 */