package com.tencent.mm.modelpackage;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p.a;
import com.tencent.mm.am.p.b;
import com.tencent.mm.am.r;
import com.tencent.mm.autogen.a.abu;
import com.tencent.mm.autogen.a.sb;
import com.tencent.mm.autogen.a.sb.a;
import com.tencent.mm.k.d;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.protocal.protobuf.cpf;
import com.tencent.mm.protocal.protobuf.cpg;
import com.tencent.mm.protocal.protobuf.dzx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class p
  extends com.tencent.mm.am.p
  implements r, m
{
  private com.tencent.mm.am.h callback;
  private int flags;
  private int hDq;
  private boolean oQW;
  private com.tencent.mm.am.c rr;
  
  public p(int paramInt)
  {
    AppMethodBeat.i(150814);
    this.oQW = false;
    this.flags = -1;
    this.hDq = paramInt;
    this.oQW = false;
    Log.d("MicroMsg.NetSceneGetPackageList", "Init dkregcode:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(150814);
  }
  
  public p(boolean paramBoolean)
  {
    AppMethodBeat.i(150813);
    this.oQW = false;
    this.flags = -1;
    this.hDq = 26;
    this.oQW = false;
    Log.d("MicroMsg.NetSceneGetPackageList", "Init dkregcode:26");
    Log.d("MicroMsg.NetSceneGetPackageList", "isOnlyCheckInReqList: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      this.flags = 1;
    }
    AppMethodBeat.o(150813);
  }
  
  private s a(dzx paramdzx)
  {
    AppMethodBeat.i(150816);
    s locals = new s();
    locals.id = paramdzx.IMf;
    locals.version = paramdzx.crz;
    locals.name = paramdzx.IGU;
    locals.size = paramdzx.vhE;
    locals.oRd = paramdzx.Zul;
    locals.status = 5;
    locals.hJK = this.hDq;
    AppMethodBeat.o(150816);
    return locals;
  }
  
  public static String bLB()
  {
    AppMethodBeat.i(231003);
    String str = com.tencent.mm.kernel.h.baE().cachePath;
    AppMethodBeat.o(231003);
    return str;
  }
  
  private void cd(List<dzx> paramList)
  {
    AppMethodBeat.i(150825);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      Log.d("MicroMsg.NetSceneGetPackageList", "[oneliang]empty update expose scene list");
      AppMethodBeat.o(150825);
      return;
    }
    u.bLH();
    String str = t.bLE();
    int i = 0;
    if (i < paramList.size())
    {
      dzx localdzx = (dzx)paramList.get(i);
      Object localObject = u.bLH().eI(localdzx.IMf, this.hDq);
      s locals;
      if ((localObject == null) || (((s)localObject).version != localdzx.crz))
      {
        y.deleteFile(str + u.bLH().eK(localdzx.IMf, this.hDq));
        locals = a(localdzx);
        locals.eQp = -1;
        if (localObject != null) {
          break label225;
        }
        u.bLH().a(locals);
      }
      for (;;)
      {
        localObject = new o(locals.id, 19);
        com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)localObject, 0);
        Log.d("MicroMsg.NetSceneGetPackageList", "[oneliang]name:%s,packName:%s", new Object[] { localdzx.IGU, localdzx.Zul });
        i += 1;
        break;
        label225:
        u.bLH().b(locals);
      }
    }
    AppMethodBeat.o(150825);
  }
  
  private void ce(List<dzx> paramList)
  {
    AppMethodBeat.i(150826);
    if ((paramList == null) || (paramList.size() == 0))
    {
      Log.d("MicroMsg.NetSceneGetPackageList", "updateIPCallCountryCodeConfig, package list is empty");
      AppMethodBeat.o(150826);
      return;
    }
    Log.d("MicroMsg.NetSceneGetPackageList", "updateIPCallCountryCodeConfig, pkgList.size: %d", new Object[] { Integer.valueOf(paramList.size()) });
    int i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acKv, Integer.valueOf(-1))).intValue();
    Log.d("MicroMsg.NetSceneGetPackageList", "configPkgId: %d", new Object[] { Integer.valueOf(i) });
    if (i == -1)
    {
      AppMethodBeat.o(150826);
      return;
    }
    s locals1 = u.bLH().eI(i, this.hDq);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      s locals2 = a((dzx)paramList.next());
      Log.d("MicroMsg.NetSceneGetPackageList", "newInfo.id: %d, version: %d", new Object[] { Integer.valueOf(locals2.id), Integer.valueOf(locals2.version) });
      if ((locals1 != null) && (locals2.id == i))
      {
        Log.d("MicroMsg.NetSceneGetPackageList", "find match old pkg, update one");
        u.bLH().b(locals2);
        AppMethodBeat.o(150826);
        return;
      }
      if ((locals1 == null) && (locals2.id == i))
      {
        Log.d("MicroMsg.NetSceneGetPackageList", "insert new pkg");
        u.bLH().a(locals2);
        AppMethodBeat.o(150826);
        return;
      }
    }
    AppMethodBeat.o(150826);
  }
  
  private void cf(List<dzx> paramList)
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
      Object localObject2 = (dzx)paramList.next();
      Object localObject1 = u.bLH().eI(((dzx)localObject2).IMf, this.hDq);
      if ((localObject1 == null) || (((s)localObject1).version != ((dzx)localObject2).crz))
      {
        localObject2 = a((dzx)localObject2);
        ((s)localObject2).eQp = -1;
        if (localObject1 == null) {
          u.bLH().a((s)localObject2);
        }
        for (;;)
        {
          localObject1 = new o(((s)localObject2).id, 36);
          com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)localObject1, 0);
          break;
          u.bLH().b((s)localObject2);
        }
      }
    }
    AppMethodBeat.o(150827);
  }
  
  private void g(LinkedList<dzx> paramLinkedList)
  {
    AppMethodBeat.i(150818);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      Log.d("MicroMsg.NetSceneGetPackageList", "empty upload speex config list");
      AppMethodBeat.o(150818);
      return;
    }
    u.bLH();
    String str = t.bLE();
    int i = 0;
    if (i < paramLinkedList.size())
    {
      dzx localdzx = (dzx)paramLinkedList.get(i);
      Object localObject = u.bLH().eI(localdzx.IMf, this.hDq);
      s locals;
      if ((localObject == null) || (((s)localObject).version != localdzx.crz))
      {
        y.deleteFile(str + u.bLH().eK(localdzx.IMf, this.hDq));
        locals = a(localdzx);
        locals.eQp = -1;
        if (localObject != null) {
          break label353;
        }
        u.bLH().a(locals);
      }
      for (;;)
      {
        localObject = new o(locals.id, 9);
        com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)localObject, 0);
        if (w.a(localdzx.YHl) != null) {
          Log.v("MicroMsg.NetSceneGetPackageList", "xml:".concat(String.valueOf(new String(w.a(localdzx.YHl)))));
        }
        if (w.a(localdzx.abfg) != null) {
          Log.v("MicroMsg.NetSceneGetPackageList", "xml2:".concat(String.valueOf(new String(w.a(localdzx.abfg)))));
        }
        Log.v("MicroMsg.NetSceneGetPackageList", "xml3:" + localdzx.toString());
        Log.v("MicroMsg.NetSceneGetPackageList", "xml4:" + localdzx.IGU);
        Log.v("MicroMsg.NetSceneGetPackageList", "xml5:" + localdzx.Zul);
        i += 1;
        break;
        label353:
        u.bLH().b(locals);
      }
    }
    AppMethodBeat.o(150818);
  }
  
  private void h(LinkedList<dzx> paramLinkedList)
  {
    AppMethodBeat.i(150819);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      Log.e("MicroMsg.NetSceneGetPackageList", "empty background pkg list");
      AppMethodBeat.o(150819);
      return;
    }
    u.bLH();
    String str = t.bLE();
    int i = 0;
    if (i < paramLinkedList.size())
    {
      Object localObject1 = (dzx)paramLinkedList.get(i);
      Object localObject2 = u.bLH().eI(((dzx)localObject1).IMf, this.hDq);
      s locals;
      if ((localObject2 == null) || (((s)localObject2).version != ((dzx)localObject1).crz))
      {
        y.deleteFile(str + u.bLH().eK(((dzx)localObject1).IMf, this.hDq));
        locals = a((dzx)localObject1);
        locals.eQp = -1;
        if (localObject2 != null) {
          break label294;
        }
      }
      label294:
      for (boolean bool = u.bLH().a(locals);; bool = u.bLH().b(locals))
      {
        Log.i("MicroMsg.NetSceneGetPackageList", "[updateBackgroundPkg] ret:%s newInfo:%s", new Object[] { Boolean.valueOf(bool), locals });
        localObject2 = w.a(((dzx)localObject1).YHl);
        if ((localObject2 != null) && (localObject2.length > 0))
        {
          u.bLH();
          localObject1 = t.eJ(((dzx)localObject1).IMf, this.hDq);
          y.deleteFile(str + (String)localObject1);
          if (y.e(str + (String)localObject1, (byte[])localObject2, localObject2.length) < 0) {
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
  private void i(LinkedList<dzx> paramLinkedList)
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
      Object localObject1 = (dzx)paramLinkedList.get(i);
      Object localObject2 = u.bLH().eI(((dzx)localObject1).IMf, this.hDq);
      s locals = a((dzx)localObject1);
      locals.eQp = -1;
      if (localObject2 == null) {
        u.bLH().a(locals);
      }
      for (;;)
      {
        localObject1 = w.a(((dzx)localObject1).YHl);
        if ((localObject1 != null) && (localObject1.length > 0))
        {
          localObject2 = new ArrayList();
          ((List)localObject2).add(new String((byte[])localObject1));
          ((List)localObject2).size();
        }
        i += 1;
        break;
        u.bLH().b(locals);
      }
    }
    AppMethodBeat.o(150820);
  }
  
  private void j(LinkedList<dzx> paramLinkedList)
  {
    AppMethodBeat.i(150821);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      Log.d("MicroMsg.NetSceneGetPackageList", "empty emoji pkg list");
      AppMethodBeat.o(150821);
      return;
    }
    Log.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + paramLinkedList.size());
    u.bLH();
    String str1 = t.bLE();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      dzx localdzx = (dzx)paramLinkedList.get(i);
      s locals = u.bLH().eI(localdzx.IMf, this.hDq);
      byte[] arrayOfByte = w.a(localdzx.YHl);
      if (localdzx.YHl == null)
      {
        Log.e("MicroMsg.NetSceneGetPackageList", "error give me a null thumb it should be xml");
        i += 1;
      }
      else
      {
        String str2;
        Object localObject;
        if ((locals == null) || (locals.version != localdzx.crz))
        {
          str2 = new String(arrayOfByte);
          localObject = "zh_CN";
          if (str2.indexOf("zh_CN") >= 0)
          {
            label180:
            str2 = (String)localObject + "_ARTIST.mm";
            y.deleteFile(str1 + str2);
            y.deleteFile(str1 + (String)localObject + "_ARTISTF.mm");
            y.e(str1 + str2, arrayOfByte, arrayOfByte.length);
          }
        }
        else
        {
          localObject = a(localdzx);
          ((s)localObject).eQp = -1;
          if (locals != null) {
            break label414;
          }
          u.bLH().a((s)localObject);
        }
        for (;;)
        {
          Log.d("MicroMsg.NetSceneGetPackageList", localdzx.IGU + " - " + localdzx.IMf + " - " + localdzx.Zul + " - " + localdzx.vhE);
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
          u.bLH().b((s)localObject);
        }
      }
    }
    AppMethodBeat.o(150821);
  }
  
  private void k(LinkedList<dzx> paramLinkedList)
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
      Object localObject1 = (dzx)paramLinkedList.get(i);
      Object localObject2 = u.bLH().eI(((dzx)localObject1).IMf, this.hDq);
      Object localObject3 = a((dzx)localObject1);
      ((s)localObject3).eQp = -1;
      if (localObject2 == null) {
        u.bLH().a((s)localObject3);
      }
      for (;;)
      {
        Log.d("MicroMsg.NetSceneGetPackageList", ((dzx)localObject1).IGU + " - " + ((dzx)localObject1).IMf + " - " + ((dzx)localObject1).Zul + " - " + ((dzx)localObject1).vhE);
        localObject2 = w.a(((dzx)localObject1).YHl);
        Log.d("MicroMsg.NetSceneGetPackageList", "ConfigList xml : ".concat(String.valueOf(new String((byte[])localObject2))));
        localObject3 = ((a)com.tencent.mm.kernel.h.ax(a.class)).aRD();
        int j = ((dzx)localObject1).IMf;
        localObject1 = new com.tencent.mm.vfs.u(d.lZM);
        if (!((com.tencent.mm.vfs.u)localObject1).jKS()) {
          ((com.tencent.mm.vfs.u)localObject1).jKY();
        }
        try
        {
          localObject1 = new com.tencent.mm.vfs.u(d.rh(j));
          if (!((com.tencent.mm.vfs.u)localObject1).jKS()) {
            ((com.tencent.mm.vfs.u)localObject1).jKZ();
          }
          y.f(d.rh(j), (byte[])localObject2, localObject2.length);
          ((d)localObject3).z(j, new String((byte[])localObject2));
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
        u.bLH().b((s)localObject3);
      }
    }
    AppMethodBeat.o(150822);
  }
  
  private void l(LinkedList<dzx> paramLinkedList)
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
      dzx localdzx = (dzx)paramLinkedList.next();
      s locals1 = u.bLH().eI(localdzx.IMf, this.hDq);
      s locals2 = a(localdzx);
      locals2.eQp = -1;
      if (locals1 == null) {
        u.bLH().a(locals2);
      }
      for (;;)
      {
        Log.d("MicroMsg.NetSceneGetPackageList", localdzx.IGU + " - " + localdzx.IMf + " - " + localdzx.Zul + " - " + localdzx.vhE);
        break;
        u.bLH().b(locals2);
      }
    }
    AppMethodBeat.o(150823);
  }
  
  private void m(LinkedList<dzx> paramLinkedList)
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
      Object localObject2 = (dzx)paramLinkedList.get(i);
      Object localObject1 = u.bLH().eI(((dzx)localObject2).IMf, this.hDq);
      localObject2 = a((dzx)localObject2);
      ((s)localObject2).eQp = -1;
      if (localObject1 == null) {
        u.bLH().a((s)localObject2);
      }
      for (;;)
      {
        localObject1 = new o(((s)localObject2).id, 12);
        com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)localObject1, 0);
        i += 1;
        break;
        u.bLH().b((s)localObject2);
      }
    }
    AppMethodBeat.o(150824);
  }
  
  private void n(LinkedList<dzx> paramLinkedList)
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
      Object localObject = (dzx)paramLinkedList.next();
      Log.d("MicroMsg.NetSceneGetPackageList", "pkg.toString %s", new Object[] { localObject.toString() });
      s locals = u.bLH().eI(((dzx)localObject).IMf, this.hDq);
      localObject = a((dzx)localObject);
      ((s)localObject).eQp = -1;
      if (locals == null) {
        u.bLH().a((s)localObject);
      } else {
        u.bLH().b((s)localObject);
      }
    }
    AppMethodBeat.o(150828);
  }
  
  private void o(LinkedList<dzx> paramLinkedList)
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
      Object localObject2 = (dzx)paramLinkedList.next();
      Object localObject1 = u.bLH().eI(((dzx)localObject2).IMf, this.hDq);
      if ((localObject1 == null) || (((s)localObject1).version != ((dzx)localObject2).crz))
      {
        localObject2 = a((dzx)localObject2);
        ((s)localObject2).eQp = -1;
        if (localObject1 == null) {
          u.bLH().a((s)localObject2);
        }
        for (;;)
        {
          localObject1 = new o(((s)localObject2).id, 37);
          com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)localObject1, 0);
          break;
          u.bLH().b((s)localObject2);
        }
      }
    }
    AppMethodBeat.o(150829);
  }
  
  public final boolean acceptConcurrent(com.tencent.mm.am.p paramp)
  {
    if (!(paramp instanceof p)) {}
    while (this.hDq != ((p)paramp).hDq) {
      return true;
    }
    return false;
  }
  
  public final int bFO()
  {
    return this.hDq;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(150815);
    this.callback = paramh;
    Log.d("MicroMsg.NetSceneGetPackageList", "DoScene dkregcode :" + this.hDq);
    paramh = new c.a();
    paramh.otE = new cpf();
    paramh.otF = new cpg();
    paramh.uri = "/cgi-bin/micromsg-bin/getpackagelist";
    paramh.funcId = 159;
    paramh.otG = 51;
    paramh.respCmdId = 1000000051;
    this.rr = paramh.bEF();
    paramh = (cpf)c.b.b(this.rr.otB);
    LinkedList localLinkedList = new LinkedList();
    if (!com.tencent.mm.kernel.h.baC().aZN())
    {
      AppMethodBeat.o(150815);
      return -1;
    }
    s[] arrayOfs = u.bLH().wK(this.hDq);
    if ((arrayOfs != null) && (arrayOfs.length > 0))
    {
      i = 0;
      if (i < arrayOfs.length)
      {
        dzx localdzx = new dzx();
        localdzx.IMf = arrayOfs[i].id;
        if ((z.pCc) && (this.hDq == 7))
        {
          Log.d("MicroMsg.NetSceneGetPackageList", "isShakeGetConfigList");
          localdzx.crz = 0;
        }
        for (;;)
        {
          Log.d("MicroMsg.NetSceneGetPackageList", "package, id:%d, ver:%d", new Object[] { Integer.valueOf(localdzx.IMf), Integer.valueOf(localdzx.crz) });
          localLinkedList.add(localdzx);
          i += 1;
          break;
          if ((12 == this.hDq) && (!y.ZC(com.tencent.mm.kernel.h.baE().cachePath + "address")))
          {
            Log.i("MicroMsg.NetSceneGetPackageList", "MMRCPTADDRESS final save file not found, set pkg.Version=0");
            localdzx.crz = 0;
          }
          else
          {
            localdzx.crz = arrayOfs[i].version;
          }
        }
      }
    }
    paramh.vgO = localLinkedList;
    paramh.vgN = localLinkedList.size();
    paramh.vhJ = this.hDq;
    if (this.flags != -1) {
      paramh.YFu = this.flags;
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
    Log.i("MicroMsg.NetSceneGetPackageList", "onGYNetEnd, netid:%d, errType:%d, errCode:%d, pkgType:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.hDq), paramString });
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150817);
      return;
    }
    params = (cpg)c.c.b(((com.tencent.mm.am.c)params).otC);
    if (params.vhJ != this.hDq)
    {
      Log.e("MicroMsg.NetSceneGetPackageList", "packageType is not consistent, respType = %d", new Object[] { Integer.valueOf(params.vhJ) });
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(150817);
      return;
    }
    paramArrayOfByte = params.vgO;
    Object localObject1 = new StringBuilder("summer list size:");
    if (paramArrayOfByte == null)
    {
      paramInt1 = 0;
      Log.i("MicroMsg.NetSceneGetPackageList", paramInt1 + " packageType: " + this.hDq + " resp.Type: " + params.vhJ);
      if (this.hDq != 2) {
        break label329;
      }
      i(paramArrayOfByte);
    }
    for (;;)
    {
      localObject1 = new abu();
      ((abu)localObject1).ifo.ifp = paramArrayOfByte;
      ((abu)localObject1).ifo.hDq = this.hDq;
      ((abu)localObject1).publish();
      if (params.YYp <= 0) {
        break label1385;
      }
      if (doScene(dispatcher(), this.callback) != -1) {
        break label1406;
      }
      this.callback.onSceneEnd(3, -1, "doScene failed", this);
      AppMethodBeat.o(150817);
      return;
      paramInt1 = paramArrayOfByte.size();
      break;
      label329:
      if (this.hDq == 1)
      {
        h(paramArrayOfByte);
      }
      else if (this.hDq == 4)
      {
        j(paramArrayOfByte);
      }
      else if (this.hDq == 6)
      {
        Log.i("MicroMsg.NetSceneGetPackageList", "change new egg.");
      }
      else if (this.hDq == 7)
      {
        k(paramArrayOfByte);
      }
      else if (this.hDq == 9)
      {
        g(paramArrayOfByte);
      }
      else
      {
        Object localObject2;
        if (this.hDq == 10)
        {
          if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
          {
            Log.e("MicroMsg.NetSceneGetPackageList", "empty mass send top config package");
          }
          else
          {
            Log.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + paramArrayOfByte.size());
            localObject2 = (dzx)paramArrayOfByte.get(0);
            localObject1 = u.bLH().eI(((dzx)localObject2).IMf, this.hDq);
            localObject2 = a((dzx)localObject2);
            ((s)localObject2).eQp = -1;
            if (localObject1 == null) {
              u.bLH().a((s)localObject2);
            } else {
              u.bLH().b((s)localObject2);
            }
          }
        }
        else if (this.hDq != 11) {
          if (this.hDq == 12) {
            m(paramArrayOfByte);
          } else if (this.hDq == 5) {
            n(paramArrayOfByte);
          } else if (this.hDq == 20) {
            l(paramArrayOfByte);
          } else if (this.hDq == 17)
          {
            if ((paramArrayOfByte == null) || (paramArrayOfByte.size() == 0))
            {
              Log.d("MicroMsg.NetSceneGetPackageList", "poi type is null");
            }
            else
            {
              localObject1 = (dzx)paramArrayOfByte.get(0);
              Log.d("MicroMsg.NetSceneGetPackageList", ((dzx)localObject1).IGU + " - " + ((dzx)localObject1).IMf + " - " + ((dzx)localObject1).Zul + " - " + ((dzx)localObject1).vhE);
              localObject2 = u.bLH().eI(((dzx)localObject1).IMf, this.hDq);
              s locals2 = a((dzx)localObject1);
              locals2.eQp = -1;
              if (localObject2 == null) {
                u.bLH().a(locals2);
              }
              for (;;)
              {
                for (;;)
                {
                  localObject2 = new sb();
                  try
                  {
                    ((sb)localObject2).hVc.hVd = w.a(((dzx)localObject1).YHl);
                    if (((sb)localObject2).hVc.hVd == null) {
                      break;
                    }
                    ((sb)localObject2).asyncPublish(Looper.getMainLooper());
                  }
                  catch (Exception localException)
                  {
                    Log.e("MicroMsg.NetSceneGetPackageList", localException.getMessage());
                  }
                }
                u.bLH().b(locals2);
              }
            }
          }
          else if (this.hDq != 18) {
            if (this.hDq == 19)
            {
              cd(paramArrayOfByte);
            }
            else
            {
              s locals1;
              if (this.hDq == 21)
              {
                if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
                {
                  Log.d("MicroMsg.NetSceneGetPackageList", "summer trace config empty scene list");
                }
                else
                {
                  localObject2 = (dzx)paramArrayOfByte.get(0);
                  Log.d("MicroMsg.NetSceneGetPackageList", "summer getpackage pkg: " + localObject2 + "|id = " + ((dzx)localObject2).IMf + "|Name = " + ((dzx)localObject2).IGU + "|PackName = " + ((dzx)localObject2).Zul + "|Size = " + ((dzx)localObject2).vhE + "|Version = " + ((dzx)localObject2).crz);
                  locals1 = u.bLH().eI(((dzx)localObject2).IMf, this.hDq);
                  localObject2 = a((dzx)localObject2);
                  ((s)localObject2).eQp = -1;
                  if (locals1 == null) {
                    u.bLH().a((s)localObject2);
                  } else if (locals1.version < ((s)localObject2).version) {
                    u.bLH().b((s)localObject2);
                  } else {
                    Log.d("MicroMsg.NetSceneGetPackageList", "summer old version [%d] new version[%d], not need update", new Object[] { Integer.valueOf(locals1.version), Integer.valueOf(((s)localObject2).version) });
                  }
                }
              }
              else if (23 == this.hDq)
              {
                if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
                {
                  Log.d("MicroMsg.NetSceneGetPackageList", "permission tips config is empty");
                }
                else
                {
                  localObject2 = (dzx)paramArrayOfByte.get(0);
                  Log.d("MicroMsg.NetSceneGetPackageList", "permission getpackage pkg: " + localObject2 + "|id = " + ((dzx)localObject2).IMf + "|Name = " + ((dzx)localObject2).IGU + "|PackName = " + ((dzx)localObject2).Zul + "|Size = " + ((dzx)localObject2).vhE + "|Version = " + ((dzx)localObject2).crz);
                  locals1 = u.bLH().eI(((dzx)localObject2).IMf, this.hDq);
                  localObject2 = a((dzx)localObject2);
                  ((s)localObject2).eQp = -1;
                  if (locals1 == null) {
                    u.bLH().a((s)localObject2);
                  } else if (locals1.version < ((s)localObject2).version) {
                    u.bLH().b((s)localObject2);
                  }
                }
              }
              else if (this.hDq == 26) {
                ce(paramArrayOfByte);
              } else if (this.hDq == 36) {
                cf(paramArrayOfByte);
              } else if (this.hDq == 37) {
                o(paramArrayOfByte);
              }
            }
          }
        }
      }
    }
    label1385:
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150817);
    return;
    label1406:
    AppMethodBeat.o(150817);
  }
  
  public final int securityLimitCount()
  {
    return 20;
  }
  
  public final p.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return p.b.ouh;
  }
  
  public final void setSecurityCheckError(p.a parama) {}
  
  public final boolean uniqueInNetsceneQueue()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelpackage.p
 * JD-Core Version:    0.7.0.1
 */