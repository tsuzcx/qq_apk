package com.tencent.mm.bb;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q.a;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.pq;
import com.tencent.mm.g.a.pq.a;
import com.tencent.mm.g.a.yq;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.bsa;
import com.tencent.mm.protocal.protobuf.bsb;
import com.tencent.mm.protocal.protobuf.cyb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class n
  extends com.tencent.mm.ak.q
  implements com.tencent.mm.ak.s, com.tencent.mm.network.m
{
  private i callback;
  private int flags;
  private boolean jhp;
  private int packageType;
  private com.tencent.mm.ak.d rr;
  
  public n(int paramInt)
  {
    AppMethodBeat.i(150814);
    this.jhp = false;
    this.flags = -1;
    this.packageType = paramInt;
    this.jhp = false;
    Log.d("MicroMsg.NetSceneGetPackageList", "Init dkregcode:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(150814);
  }
  
  public n(boolean paramBoolean)
  {
    AppMethodBeat.i(150813);
    this.jhp = false;
    this.flags = -1;
    this.packageType = 26;
    this.jhp = false;
    Log.d("MicroMsg.NetSceneGetPackageList", "Init dkregcode:26");
    Log.d("MicroMsg.NetSceneGetPackageList", "isOnlyCheckInReqList: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      this.flags = 1;
    }
    AppMethodBeat.o(150813);
  }
  
  private q a(cyb paramcyb)
  {
    AppMethodBeat.i(150816);
    q localq = new q();
    localq.id = paramcyb.xNF;
    localq.version = paramcyb.Version;
    localq.name = paramcyb.Name;
    localq.size = paramcyb.oUq;
    localq.jhw = paramcyb.PackName;
    localq.status = 5;
    localq.dMe = this.packageType;
    AppMethodBeat.o(150816);
    return localq;
  }
  
  private void aA(List<cyb> paramList)
  {
    AppMethodBeat.i(150825);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      Log.d("MicroMsg.NetSceneGetPackageList", "[oneliang]empty update expose scene list");
      AppMethodBeat.o(150825);
      return;
    }
    v.bev();
    String str = r.bes();
    int i = 0;
    if (i < paramList.size())
    {
      cyb localcyb = (cyb)paramList.get(i);
      Object localObject = v.bev().dt(localcyb.xNF, this.packageType);
      q localq;
      if ((localObject == null) || (((q)localObject).version != localcyb.Version))
      {
        com.tencent.mm.vfs.s.deleteFile(str + v.bev().dv(localcyb.xNF, this.packageType));
        localq = a(localcyb);
        localq.cSx = -1;
        if (localObject != null) {
          break label225;
        }
        v.bev().a(localq);
      }
      for (;;)
      {
        localObject = new m(localq.id, 19);
        com.tencent.mm.kernel.g.aAg().hqi.a((com.tencent.mm.ak.q)localObject, 0);
        Log.d("MicroMsg.NetSceneGetPackageList", "[oneliang]name:%s,packName:%s", new Object[] { localcyb.Name, localcyb.PackName });
        i += 1;
        break;
        label225:
        v.bev().b(localq);
      }
    }
    AppMethodBeat.o(150825);
  }
  
  private void aB(List<cyb> paramList)
  {
    AppMethodBeat.i(150826);
    if ((paramList == null) || (paramList.size() == 0))
    {
      Log.d("MicroMsg.NetSceneGetPackageList", "updateIPCallCountryCodeConfig, package list is empty");
      AppMethodBeat.o(150826);
      return;
    }
    Log.d("MicroMsg.NetSceneGetPackageList", "updateIPCallCountryCodeConfig, pkgList.size: %d", new Object[] { Integer.valueOf(paramList.size()) });
    int i = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NVb, Integer.valueOf(-1))).intValue();
    Log.d("MicroMsg.NetSceneGetPackageList", "configPkgId: %d", new Object[] { Integer.valueOf(i) });
    if (i == -1)
    {
      AppMethodBeat.o(150826);
      return;
    }
    q localq1 = v.bev().dt(i, this.packageType);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      q localq2 = a((cyb)paramList.next());
      Log.d("MicroMsg.NetSceneGetPackageList", "newInfo.id: %d, version: %d", new Object[] { Integer.valueOf(localq2.id), Integer.valueOf(localq2.version) });
      if ((localq1 != null) && (localq2.id == i))
      {
        Log.d("MicroMsg.NetSceneGetPackageList", "find match old pkg, update one");
        v.bev().b(localq2);
        AppMethodBeat.o(150826);
        return;
      }
      if ((localq1 == null) && (localq2.id == i))
      {
        Log.d("MicroMsg.NetSceneGetPackageList", "insert new pkg");
        v.bev().a(localq2);
        AppMethodBeat.o(150826);
        return;
      }
    }
    AppMethodBeat.o(150826);
  }
  
  private void aC(List<cyb> paramList)
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
      Object localObject2 = (cyb)paramList.next();
      Object localObject1 = v.bev().dt(((cyb)localObject2).xNF, this.packageType);
      if ((localObject1 == null) || (((q)localObject1).version != ((cyb)localObject2).Version))
      {
        localObject2 = a((cyb)localObject2);
        ((q)localObject2).cSx = -1;
        if (localObject1 == null) {
          v.bev().a((q)localObject2);
        }
        for (;;)
        {
          localObject1 = new m(((q)localObject2).id, 36);
          com.tencent.mm.kernel.g.aAg().hqi.a((com.tencent.mm.ak.q)localObject1, 0);
          break;
          v.bev().b((q)localObject2);
        }
      }
    }
    AppMethodBeat.o(150827);
  }
  
  private void g(LinkedList<cyb> paramLinkedList)
  {
    AppMethodBeat.i(150818);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      Log.d("MicroMsg.NetSceneGetPackageList", "empty upload speex config list");
      AppMethodBeat.o(150818);
      return;
    }
    v.bev();
    String str = r.bes();
    int i = 0;
    if (i < paramLinkedList.size())
    {
      cyb localcyb = (cyb)paramLinkedList.get(i);
      Object localObject = v.bev().dt(localcyb.xNF, this.packageType);
      q localq;
      if ((localObject == null) || (((q)localObject).version != localcyb.Version))
      {
        com.tencent.mm.vfs.s.deleteFile(str + v.bev().dv(localcyb.xNF, this.packageType));
        localq = a(localcyb);
        localq.cSx = -1;
        if (localObject != null) {
          break label353;
        }
        v.bev().a(localq);
      }
      for (;;)
      {
        localObject = new m(localq.id, 9);
        com.tencent.mm.kernel.g.aAg().hqi.a((com.tencent.mm.ak.q)localObject, 0);
        if (z.a(localcyb.KIA) != null) {
          Log.v("MicroMsg.NetSceneGetPackageList", "xml:".concat(String.valueOf(new String(z.a(localcyb.KIA)))));
        }
        if (z.a(localcyb.MDa) != null) {
          Log.v("MicroMsg.NetSceneGetPackageList", "xml2:".concat(String.valueOf(new String(z.a(localcyb.MDa)))));
        }
        Log.v("MicroMsg.NetSceneGetPackageList", "xml3:" + localcyb.toString());
        Log.v("MicroMsg.NetSceneGetPackageList", "xml4:" + localcyb.Name);
        Log.v("MicroMsg.NetSceneGetPackageList", "xml5:" + localcyb.PackName);
        i += 1;
        break;
        label353:
        v.bev().b(localq);
      }
    }
    AppMethodBeat.o(150818);
  }
  
  private void h(LinkedList<cyb> paramLinkedList)
  {
    AppMethodBeat.i(150819);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      Log.e("MicroMsg.NetSceneGetPackageList", "empty background pkg list");
      AppMethodBeat.o(150819);
      return;
    }
    v.bev();
    String str = r.bes();
    int i = 0;
    if (i < paramLinkedList.size())
    {
      Object localObject1 = (cyb)paramLinkedList.get(i);
      Object localObject2 = v.bev().dt(((cyb)localObject1).xNF, this.packageType);
      q localq;
      if ((localObject2 == null) || (((q)localObject2).version != ((cyb)localObject1).Version))
      {
        com.tencent.mm.vfs.s.deleteFile(str + v.bev().dv(((cyb)localObject1).xNF, this.packageType));
        localq = a((cyb)localObject1);
        localq.cSx = -1;
        if (localObject2 != null) {
          break label294;
        }
      }
      label294:
      for (boolean bool = v.bev().a(localq);; bool = v.bev().b(localq))
      {
        Log.i("MicroMsg.NetSceneGetPackageList", "[updateBackgroundPkg] ret:%s newInfo:%s", new Object[] { Boolean.valueOf(bool), localq });
        localObject2 = z.a(((cyb)localObject1).KIA);
        if ((localObject2 != null) && (localObject2.length > 0))
        {
          v.bev();
          localObject1 = r.du(((cyb)localObject1).xNF, this.packageType);
          com.tencent.mm.vfs.s.deleteFile(str + (String)localObject1);
          if (com.tencent.mm.vfs.s.e(str + (String)localObject1, (byte[])localObject2, localObject2.length) < 0) {
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
  private void i(LinkedList<cyb> paramLinkedList)
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
      Object localObject1 = (cyb)paramLinkedList.get(i);
      Object localObject2 = v.bev().dt(((cyb)localObject1).xNF, this.packageType);
      q localq = a((cyb)localObject1);
      localq.cSx = -1;
      if (localObject2 == null) {
        v.bev().a(localq);
      }
      for (;;)
      {
        localObject1 = z.a(((cyb)localObject1).KIA);
        if ((localObject1 != null) && (localObject1.length > 0))
        {
          localObject2 = new ArrayList();
          ((List)localObject2).add(new String((byte[])localObject1));
          ((List)localObject2).size();
        }
        i += 1;
        break;
        v.bev().b(localq);
      }
    }
    AppMethodBeat.o(150820);
  }
  
  private void j(LinkedList<cyb> paramLinkedList)
  {
    AppMethodBeat.i(150821);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      Log.d("MicroMsg.NetSceneGetPackageList", "empty emoji pkg list");
      AppMethodBeat.o(150821);
      return;
    }
    Log.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + paramLinkedList.size());
    v.bev();
    String str1 = r.bes();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      cyb localcyb = (cyb)paramLinkedList.get(i);
      q localq = v.bev().dt(localcyb.xNF, this.packageType);
      byte[] arrayOfByte = z.a(localcyb.KIA);
      if (localcyb.KIA == null)
      {
        Log.e("MicroMsg.NetSceneGetPackageList", "error give me a null thumb it should be xml");
        i += 1;
      }
      else
      {
        String str2;
        Object localObject;
        if ((localq == null) || (localq.version != localcyb.Version))
        {
          str2 = new String(arrayOfByte);
          localObject = "zh_CN";
          if (str2.indexOf("zh_CN") >= 0)
          {
            label180:
            str2 = (String)localObject + "_ARTIST.mm";
            com.tencent.mm.vfs.s.deleteFile(str1 + str2);
            com.tencent.mm.vfs.s.deleteFile(str1 + (String)localObject + "_ARTISTF.mm");
            com.tencent.mm.vfs.s.e(str1 + str2, arrayOfByte, arrayOfByte.length);
          }
        }
        else
        {
          localObject = a(localcyb);
          ((q)localObject).cSx = -1;
          if (localq != null) {
            break label414;
          }
          v.bev().a((q)localObject);
        }
        for (;;)
        {
          Log.d("MicroMsg.NetSceneGetPackageList", localcyb.Name + " - " + localcyb.xNF + " - " + localcyb.PackName + " - " + localcyb.oUq);
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
          v.bev().b((q)localObject);
        }
      }
    }
    AppMethodBeat.o(150821);
  }
  
  private void k(LinkedList<cyb> paramLinkedList)
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
      Object localObject1 = (cyb)paramLinkedList.get(i);
      Object localObject2 = v.bev().dt(((cyb)localObject1).xNF, this.packageType);
      Object localObject3 = a((cyb)localObject1);
      ((q)localObject3).cSx = -1;
      if (localObject2 == null) {
        v.bev().a((q)localObject3);
      }
      for (;;)
      {
        Log.d("MicroMsg.NetSceneGetPackageList", ((cyb)localObject1).Name + " - " + ((cyb)localObject1).xNF + " - " + ((cyb)localObject1).PackName + " - " + ((cyb)localObject1).oUq);
        localObject2 = z.a(((cyb)localObject1).KIA);
        Log.d("MicroMsg.NetSceneGetPackageList", "ConfigList xml : ".concat(String.valueOf(new String((byte[])localObject2))));
        localObject3 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqK();
        int j = ((cyb)localObject1).xNF;
        localObject1 = new o(com.tencent.mm.n.d.gMf);
        if (!((o)localObject1).exists()) {
          ((o)localObject1).mkdirs();
        }
        try
        {
          localObject1 = new o(com.tencent.mm.n.d.oH(j));
          if (!((o)localObject1).exists()) {
            ((o)localObject1).createNewFile();
          }
          com.tencent.mm.vfs.s.f(com.tencent.mm.n.d.oH(j), (byte[])localObject2, localObject2.length);
          ((com.tencent.mm.n.d)localObject3).y(j, new String((byte[])localObject2));
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
        v.bev().b((q)localObject3);
      }
    }
    AppMethodBeat.o(150822);
  }
  
  private void l(LinkedList<cyb> paramLinkedList)
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
      cyb localcyb = (cyb)paramLinkedList.next();
      q localq1 = v.bev().dt(localcyb.xNF, this.packageType);
      q localq2 = a(localcyb);
      localq2.cSx = -1;
      if (localq1 == null) {
        v.bev().a(localq2);
      }
      for (;;)
      {
        Log.d("MicroMsg.NetSceneGetPackageList", localcyb.Name + " - " + localcyb.xNF + " - " + localcyb.PackName + " - " + localcyb.oUq);
        break;
        v.bev().b(localq2);
      }
    }
    AppMethodBeat.o(150823);
  }
  
  private void m(LinkedList<cyb> paramLinkedList)
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
      Object localObject2 = (cyb)paramLinkedList.get(i);
      Object localObject1 = v.bev().dt(((cyb)localObject2).xNF, this.packageType);
      localObject2 = a((cyb)localObject2);
      ((q)localObject2).cSx = -1;
      if (localObject1 == null) {
        v.bev().a((q)localObject2);
      }
      for (;;)
      {
        localObject1 = new m(((q)localObject2).id, 12);
        com.tencent.mm.kernel.g.aAg().hqi.a((com.tencent.mm.ak.q)localObject1, 0);
        i += 1;
        break;
        v.bev().b((q)localObject2);
      }
    }
    AppMethodBeat.o(150824);
  }
  
  private void n(LinkedList<cyb> paramLinkedList)
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
      Object localObject = (cyb)paramLinkedList.next();
      Log.d("MicroMsg.NetSceneGetPackageList", "pkg.toString %s", new Object[] { localObject.toString() });
      q localq = v.bev().dt(((cyb)localObject).xNF, this.packageType);
      localObject = a((cyb)localObject);
      ((q)localObject).cSx = -1;
      if (localq == null) {
        v.bev().a((q)localObject);
      } else {
        v.bev().b((q)localObject);
      }
    }
    AppMethodBeat.o(150828);
  }
  
  private void o(LinkedList<cyb> paramLinkedList)
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
      Object localObject2 = (cyb)paramLinkedList.next();
      Object localObject1 = v.bev().dt(((cyb)localObject2).xNF, this.packageType);
      if ((localObject1 == null) || (((q)localObject1).version != ((cyb)localObject2).Version))
      {
        localObject2 = a((cyb)localObject2);
        ((q)localObject2).cSx = -1;
        if (localObject1 == null) {
          v.bev().a((q)localObject2);
        }
        for (;;)
        {
          localObject1 = new m(((q)localObject2).id, 37);
          com.tencent.mm.kernel.g.aAg().hqi.a((com.tencent.mm.ak.q)localObject1, 0);
          break;
          v.bev().b((q)localObject2);
        }
      }
    }
    AppMethodBeat.o(150829);
  }
  
  public final int aYR()
  {
    return this.packageType;
  }
  
  public final boolean acceptConcurrent(com.tencent.mm.ak.q paramq)
  {
    if (!(paramq instanceof n)) {}
    while (this.packageType != ((n)paramq).packageType) {
      return true;
    }
    return false;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(150815);
    this.callback = parami;
    Log.d("MicroMsg.NetSceneGetPackageList", "DoScene dkregcode :" + this.packageType);
    parami = new d.a();
    parami.iLN = new bsa();
    parami.iLO = new bsb();
    parami.uri = "/cgi-bin/micromsg-bin/getpackagelist";
    parami.funcId = 159;
    parami.iLP = 51;
    parami.respCmdId = 1000000051;
    this.rr = parami.aXF();
    parami = (bsa)this.rr.iLK.iLR;
    LinkedList localLinkedList = new LinkedList();
    if (!com.tencent.mm.kernel.g.aAf().azp())
    {
      AppMethodBeat.o(150815);
      return -1;
    }
    q[] arrayOfq = v.bev().tJ(this.packageType);
    if ((arrayOfq != null) && (arrayOfq.length > 0))
    {
      i = 0;
      if (i < arrayOfq.length)
      {
        cyb localcyb = new cyb();
        localcyb.xNF = arrayOfq[i].id;
        if ((ac.jOs) && (this.packageType == 7))
        {
          Log.d("MicroMsg.NetSceneGetPackageList", "isShakeGetConfigList");
          localcyb.Version = 0;
        }
        for (;;)
        {
          Log.d("MicroMsg.NetSceneGetPackageList", "package, id:%d, ver:%d", new Object[] { Integer.valueOf(localcyb.xNF), Integer.valueOf(localcyb.Version) });
          localLinkedList.add(localcyb);
          i += 1;
          break;
          if ((12 == this.packageType) && (!com.tencent.mm.vfs.s.YS(com.tencent.mm.kernel.g.aAh().cachePath + "address")))
          {
            Log.i("MicroMsg.NetSceneGetPackageList", "MMRCPTADDRESS final save file not found, set pkg.Version=0");
            localcyb.Version = 0;
          }
          else
          {
            localcyb.Version = arrayOfq[i].version;
          }
        }
      }
    }
    parami.oTA = localLinkedList;
    parami.oTz = localLinkedList.size();
    parami.oUv = this.packageType;
    if (this.flags != -1) {
      parami.KHa = this.flags;
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
    Log.i("MicroMsg.NetSceneGetPackageList", "onGYNetEnd, netid:%d, errType:%d, errCode:%d, pkgType:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.packageType), paramString });
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150817);
      return;
    }
    params = (bsb)((com.tencent.mm.ak.d)params).iLL.iLR;
    if (params.oUv != this.packageType)
    {
      Log.e("MicroMsg.NetSceneGetPackageList", "packageType is not consistent, respType = %d", new Object[] { Integer.valueOf(params.oUv) });
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(150817);
      return;
    }
    paramArrayOfByte = params.oTA;
    Object localObject1 = new StringBuilder("summer list size:");
    if (paramArrayOfByte == null)
    {
      paramInt1 = 0;
      Log.i("MicroMsg.NetSceneGetPackageList", paramInt1 + " packageType: " + this.packageType + " resp.Type: " + params.oUv);
      if (this.packageType != 2) {
        break label332;
      }
      i(paramArrayOfByte);
    }
    for (;;)
    {
      localObject1 = new yq();
      ((yq)localObject1).eeU.eeV = paramArrayOfByte;
      ((yq)localObject1).eeU.packageType = this.packageType;
      EventCenter.instance.publish((IEvent)localObject1);
      if (params.KZh <= 0) {
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
      if (this.packageType == 1)
      {
        h(paramArrayOfByte);
      }
      else if (this.packageType == 4)
      {
        j(paramArrayOfByte);
      }
      else if (this.packageType == 6)
      {
        Log.i("MicroMsg.NetSceneGetPackageList", "change new egg.");
      }
      else if (this.packageType == 7)
      {
        k(paramArrayOfByte);
      }
      else if (this.packageType == 9)
      {
        g(paramArrayOfByte);
      }
      else
      {
        Object localObject2;
        if (this.packageType == 10)
        {
          if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
          {
            Log.e("MicroMsg.NetSceneGetPackageList", "empty mass send top config package");
          }
          else
          {
            Log.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + paramArrayOfByte.size());
            localObject2 = (cyb)paramArrayOfByte.get(0);
            localObject1 = v.bev().dt(((cyb)localObject2).xNF, this.packageType);
            localObject2 = a((cyb)localObject2);
            ((q)localObject2).cSx = -1;
            if (localObject1 == null) {
              v.bev().a((q)localObject2);
            } else {
              v.bev().b((q)localObject2);
            }
          }
        }
        else if (this.packageType != 11) {
          if (this.packageType == 12) {
            m(paramArrayOfByte);
          } else if (this.packageType == 5) {
            n(paramArrayOfByte);
          } else if (this.packageType == 20) {
            l(paramArrayOfByte);
          } else if (this.packageType == 17)
          {
            if ((paramArrayOfByte == null) || (paramArrayOfByte.size() == 0))
            {
              Log.d("MicroMsg.NetSceneGetPackageList", "poi type is null");
            }
            else
            {
              localObject1 = (cyb)paramArrayOfByte.get(0);
              Log.d("MicroMsg.NetSceneGetPackageList", ((cyb)localObject1).Name + " - " + ((cyb)localObject1).xNF + " - " + ((cyb)localObject1).PackName + " - " + ((cyb)localObject1).oUq);
              localObject2 = v.bev().dt(((cyb)localObject1).xNF, this.packageType);
              q localq2 = a((cyb)localObject1);
              localq2.cSx = -1;
              if (localObject2 == null) {
                v.bev().a(localq2);
              }
              for (;;)
              {
                for (;;)
                {
                  localObject2 = new pq();
                  try
                  {
                    ((pq)localObject2).dVG.content = z.a(((cyb)localObject1).KIA);
                    if (((pq)localObject2).dVG.content == null) {
                      break;
                    }
                    EventCenter.instance.asyncPublish((IEvent)localObject2, Looper.getMainLooper());
                  }
                  catch (Exception localException)
                  {
                    Log.e("MicroMsg.NetSceneGetPackageList", localException.getMessage());
                  }
                }
                v.bev().b(localq2);
              }
            }
          }
          else if (this.packageType != 18) {
            if (this.packageType == 19)
            {
              aA(paramArrayOfByte);
            }
            else
            {
              q localq1;
              if (this.packageType == 21)
              {
                if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
                {
                  Log.d("MicroMsg.NetSceneGetPackageList", "summer trace config empty scene list");
                }
                else
                {
                  localObject2 = (cyb)paramArrayOfByte.get(0);
                  Log.d("MicroMsg.NetSceneGetPackageList", "summer getpackage pkg: " + localObject2 + "|id = " + ((cyb)localObject2).xNF + "|Name = " + ((cyb)localObject2).Name + "|PackName = " + ((cyb)localObject2).PackName + "|Size = " + ((cyb)localObject2).oUq + "|Version = " + ((cyb)localObject2).Version);
                  localq1 = v.bev().dt(((cyb)localObject2).xNF, this.packageType);
                  localObject2 = a((cyb)localObject2);
                  ((q)localObject2).cSx = -1;
                  if (localq1 == null) {
                    v.bev().a((q)localObject2);
                  } else if (localq1.version < ((q)localObject2).version) {
                    v.bev().b((q)localObject2);
                  } else {
                    Log.d("MicroMsg.NetSceneGetPackageList", "summer old version [%d] new version[%d], not need update", new Object[] { Integer.valueOf(localq1.version), Integer.valueOf(((q)localObject2).version) });
                  }
                }
              }
              else if (23 == this.packageType)
              {
                if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
                {
                  Log.d("MicroMsg.NetSceneGetPackageList", "permission tips config is empty");
                }
                else
                {
                  localObject2 = (cyb)paramArrayOfByte.get(0);
                  Log.d("MicroMsg.NetSceneGetPackageList", "permission getpackage pkg: " + localObject2 + "|id = " + ((cyb)localObject2).xNF + "|Name = " + ((cyb)localObject2).Name + "|PackName = " + ((cyb)localObject2).PackName + "|Size = " + ((cyb)localObject2).oUq + "|Version = " + ((cyb)localObject2).Version);
                  localq1 = v.bev().dt(((cyb)localObject2).xNF, this.packageType);
                  localObject2 = a((cyb)localObject2);
                  ((q)localObject2).cSx = -1;
                  if (localq1 == null) {
                    v.bev().a((q)localObject2);
                  } else if (localq1.version < ((q)localObject2).version) {
                    v.bev().b((q)localObject2);
                  }
                }
              }
              else if (this.packageType == 26) {
                aB(paramArrayOfByte);
              } else if (this.packageType == 36) {
                aC(paramArrayOfByte);
              } else if (this.packageType == 37) {
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
    return q.b.iMq;
  }
  
  public final void setSecurityCheckError(q.a parama) {}
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bb.n
 * JD-Core Version:    0.7.0.1
 */