package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.aa;
import com.tencent.mm.plugin.appbrand.service.IBSPatchJNIService;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.webcanvas.k.a;
import com.tencent.mm.protocal.protobuf.ghs;
import com.tencent.mm.protocal.protobuf.vn;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherPkgDiffManager;", "", "()V", "TAG", "", "enableDownloadPkgByHttp", "", "Ljava/lang/Boolean;", "pkgVersionManager", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getPkgVersionManager$plugin_brandservice_release", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "pkgVersionManager$delegate", "Lkotlin/Lazy;", "checkNeedUpdatePkg", "appId", "currentPkgInfo", "Lcom/tencent/mm/protocal/protobuf/CanvasPkgInfo;", "target", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcher$PrefetchTarget;", "checkUpdateDiffResult", "", "conn", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "prefetchTarget", "downloadPkgFile", "Lcom/tencent/mm/vfs/VFSFile;", "getAndUpdateAllPkgVersion", "", "getCurrentPkgInfo", "getPkgInfo", "Lcom/tencent/mm/protocal/protobuf/WebPrefetcherPkgInfo;", "pkgVersion", "getPkgInfoByUrl", "url", "getPkgKey", "getUrlKey", "init", "", "initWebPrefetcherPkgConfig", "isResultOk", "result", "mergeDiff", "patchFile", "baseFilePath", "mergedMD5", "patchFileMd5", "processMergeDiffPkg", "saveCurrentPkgInfo", "pkgInfo", "savePkgInfo", "pkgPath", "setRequestPkgVersion", "setRequestProperty", "key", "value", "pkgValid", "MergeDiffResult", "PkgUpdateResult", "Reporter", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v
{
  public static final v vVd;
  private static final kotlin.j vVe;
  private static Boolean vVf;
  
  static
  {
    AppMethodBeat.i(303379);
    vVd = new v();
    vVe = kotlin.k.cm((kotlin.g.a.a)c.vVh);
    AppMethodBeat.o(303379);
  }
  
  public static final boolean HJ(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 5);
  }
  
  public static final int a(aa paramaa, r.d paramd, com.tencent.mm.vfs.u paramu)
  {
    AppMethodBeat.i(303370);
    s.u(paramaa, "conn");
    s.u(paramd, "prefetchTarget");
    s.u(paramu, "downloadPkgFile");
    Object localObject1 = new HashMap();
    Object localObject2;
    Object localObject4;
    Object localObject3;
    try
    {
      localObject2 = paramaa.ppr;
      s.s(localObject2, "conn.headerFields");
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (Map.Entry)((Iterator)localObject2).next();
        localObject3 = (String)((Map.Entry)localObject4).getKey();
        localObject4 = (List)((Map.Entry)localObject4).getValue();
        Log.v("MicroMsg.WebPrefetcherPkgDiffManager", "fetchBizPkg header key: " + localObject3 + ", value: " + localObject4);
        Map localMap = (Map)localObject1;
        s.s(localObject3, "key");
        localObject3 = ((String)localObject3).toLowerCase();
        s.s(localObject3, "(this as java.lang.String).toLowerCase()");
        s.s(localObject4, "value");
        localMap.put(localObject3, localObject4);
      }
      localObject2 = kotlin.ah.aiuX;
    }
    finally
    {
      AppMethodBeat.o(303370);
    }
    paramaa = (List)((HashMap)localObject1).get("x-wx-prefetch-baseversion");
    int i;
    if (paramaa == null)
    {
      paramaa = "";
      if (((CharSequence)paramaa).length() != 0) {
        break label310;
      }
      i = 1;
      label238:
      if (i == 0) {
        break label328;
      }
      if (!paramu.jKS()) {
        break label315;
      }
      Log.i("MicroMsg.WebPrefetcherPkgDiffManager", s.X("checkUpdateResult updateByFullPkg success, file size: ", Long.valueOf(y.bEl(com.tencent.mm.vfs.ah.v(paramu.mUri)))));
      i = 3;
    }
    for (;;)
    {
      paramaa = a.vVg;
      a.HK(i);
      AppMethodBeat.o(303370);
      return i;
      paramaa = (String)p.oL(paramaa);
      if (paramaa == null)
      {
        paramaa = "";
        break;
      }
      break;
      label310:
      i = 0;
      break label238;
      label315:
      Log.e("MicroMsg.WebPrefetcherPkgDiffManager", "checkUpdateResult updateByFullPkg but pkg file not exist");
      i = 2;
      continue;
      label328:
      long l1 = System.currentTimeMillis();
      localObject3 = fX(paramd.dfY(), paramaa);
      paramaa = (List)paramd.dgb().get("x-wx-prefetch-pkg-md5");
      if (paramaa == null)
      {
        paramaa = "";
        label364:
        paramd = (List)((HashMap)localObject1).get("x-wx-prefetch-patch-md5");
        if (paramd != null) {
          break label534;
        }
        paramd = "";
        label383:
        if (localObject3 == null) {
          break label889;
        }
        localObject2 = ((ghs)localObject3).pkgPath;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        if (paramu.jKS()) {
          break label555;
        }
        i = 10;
      }
      label534:
      label555:
      label711:
      for (;;)
      {
        long l2 = System.currentTimeMillis();
        Log.i("MicroMsg.WebPrefetcherPkgDiffManager", "processMergeDiffPkg basePkg: " + localObject3 + ", result: " + i + ", fullPkgMd5: " + paramaa + ", patchFileMd5: " + paramd + ", cost: " + (l2 - l1) + "ms");
        paramaa = a.vVg;
        a.HL(i);
        if (i != 0) {
          break label895;
        }
        i = 5;
        break;
        paramaa = (String)p.oL(paramaa);
        if (paramaa == null)
        {
          paramaa = "";
          break label364;
        }
        break label364;
        paramd = (String)p.oL(paramd);
        if (paramd == null)
        {
          paramd = "";
          break label383;
        }
        break label383;
        if (((CharSequence)localObject1).length() == 0) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label585;
          }
          i = 11;
          break;
        }
        label585:
        if (!y.ZC((String)localObject1))
        {
          i = 12;
        }
        else
        {
          if (((CharSequence)paramaa).length() == 0) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label628;
            }
            i = 14;
            break;
          }
          label628:
          if (((CharSequence)paramd).length() > 0) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label711;
            }
            localObject2 = y.bub(com.tencent.mm.vfs.ah.v(paramu.mUri));
            if (s.p(localObject2, paramd)) {
              break label711;
            }
            Log.e("MicroMsg.WebPrefetcherPkgDiffManager", "mergeDiff patchFile MD5 not match, downloaded: " + localObject2 + ", target: " + paramd);
            i = 16;
            break;
          }
          localObject2 = s.X((String)localObject1, ".patch");
          if (((IBSPatchJNIService)h.ax(IBSPatchJNIService.class)).bspatch((String)localObject1, (String)localObject2, com.tencent.mm.vfs.ah.v(paramu.jKT())) == 0)
          {
            Log.i("MicroMsg.WebPrefetcherPkgDiffManager", "mergeDiff patch download success");
            localObject2 = new com.tencent.mm.vfs.u((String)localObject2);
            localObject4 = y.bub(com.tencent.mm.vfs.ah.v(((com.tencent.mm.vfs.u)localObject2).mUri));
            if ((!Util.isNullOrNil((String)localObject4)) && (s.p(localObject4, paramaa)))
            {
              Log.i("MicroMsg.WebPrefetcherPkgDiffManager", "mergeDiff patch MD5 verify success");
              y.qn(com.tencent.mm.vfs.ah.v(((com.tencent.mm.vfs.u)localObject2).mUri), com.tencent.mm.vfs.ah.v(paramu.mUri));
              i = 0;
            }
            else
            {
              ((com.tencent.mm.vfs.u)localObject2).diJ();
              Log.e("MicroMsg.WebPrefetcherPkgDiffManager", "mergeDiff MD5 not match after patch, base: %s, patch: %s, computeMd5: %s, targetMd5: %s", new Object[] { localObject1, paramu.jKU(), localObject4, paramaa });
              i = 15;
            }
          }
          else
          {
            Log.e("MicroMsg.WebPrefetcherPkgDiffManager", "mergeDiff patch fail");
            i = 13;
            continue;
            label889:
            i = 17;
          }
        }
      }
      label895:
      i = 4;
    }
  }
  
  public static final void a(aa paramaa, String paramString, vn paramvn)
  {
    AppMethodBeat.i(303336);
    s.u(paramaa, "conn");
    s.u(paramString, "appId");
    Object localObject;
    if (paramvn == null)
    {
      paramvn = "";
      a(paramaa, "x-wx-prefetch-fullversioninuse", paramvn);
      s.u(paramString, "appId");
      paramvn = (Set)new LinkedHashSet();
      localObject = dgD().decodeStringSet(paramString, (Set)new LinkedHashSet());
      s.s(localObject, "set");
      localObject = ((Iterable)localObject).iterator();
    }
    label196:
    for (;;)
    {
      label91:
      if (!((Iterator)localObject).hasNext()) {
        break label198;
      }
      String str = (String)((Iterator)localObject).next();
      CharSequence localCharSequence = (CharSequence)str;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label196;
        }
        s.s(str, "pkgVersion");
        if (!a(fX(paramString, str))) {
          break label91;
        }
        paramvn.add(str);
        break label91;
        localObject = paramvn.Zbk;
        paramvn = (vn)localObject;
        if (localObject != null) {
          break;
        }
        paramvn = "";
        break;
      }
    }
    label198:
    dgD().encode(paramString, paramvn);
    a(paramaa, "x-wx-prefetch-fullversions", p.a((Iterable)p.p((Iterable)paramvn), (CharSequence)";", null, null, 0, null, null, 62));
    AppMethodBeat.o(303336);
  }
  
  private static void a(aa paramaa, String paramString1, String paramString2)
  {
    AppMethodBeat.i(303340);
    Log.i("MicroMsg.WebPrefetcherPkgDiffManager", "alvinluo setRequestProperty key: " + paramString1 + ", value: " + paramString2);
    paramaa.setRequestProperty(paramString1, paramString2);
    AppMethodBeat.o(303340);
  }
  
  private static boolean a(ghs paramghs)
  {
    AppMethodBeat.i(303264);
    if ((paramghs != null) && (y.ZC(paramghs.pkgPath)))
    {
      AppMethodBeat.o(303264);
      return true;
    }
    AppMethodBeat.o(303264);
    return false;
  }
  
  public static final boolean a(String paramString, vn paramvn, r.d paramd)
  {
    AppMethodBeat.i(303347);
    s.u(paramString, "appId");
    s.u(paramd, "target");
    if (((CharSequence)paramd.dgj()).length() > 0) {}
    ghs localghs;
    for (int i = 1; i != 0; i = 0)
    {
      localghs = fX(paramString, paramd.dgj());
      if ((paramvn == null) || (!a(localghs))) {
        break;
      }
      Log.i("MicroMsg.WebPrefetcherPkgDiffManager", "checkNeedUpdatePkg basePkgVersion valid appId: " + paramString + ", basePkgVersion: " + paramd.dgj() + ", pkgVersion: " + paramd.dgk() + ", current.pkgVersion: " + paramvn.Zbk);
      if (!s.p(paramvn.Zbk, paramd.dgj())) {
        b(localghs);
      }
      if (!s.p(paramd.dgk(), paramd.dgj())) {
        break;
      }
      AppMethodBeat.o(303347);
      return false;
    }
    label201:
    String str;
    if (((CharSequence)paramd.dgk()).length() > 0)
    {
      i = 1;
      if (i == 0) {
        break label301;
      }
      localghs = fX(paramString, paramd.dgk());
      if (!a(localghs)) {
        break label323;
      }
      if (paramvn != null)
      {
        str = paramvn.Zbk;
        if (localghs != null) {
          break label314;
        }
      }
    }
    label301:
    label314:
    for (paramvn = null;; paramvn = localghs.mup)
    {
      if (!s.p(str, paramvn)) {
        b(localghs);
      }
      Log.i("MicroMsg.WebPrefetcherPkgDiffManager", "checkNeedUpdatePkg pkg exists appId: " + paramString + ", pkgVersion: " + paramd.dgk() + ", " + paramd.url);
      AppMethodBeat.o(303347);
      return false;
      i = 0;
      break;
      localghs = fY(paramString, paramd.url);
      break label201;
    }
    label323:
    AppMethodBeat.o(303347);
    return true;
  }
  
  public static final vn ajI(String paramString)
  {
    AppMethodBeat.i(303309);
    s.u(paramString, "appId");
    com.tencent.mm.plugin.webcanvas.k localk = com.tencent.mm.plugin.webcanvas.k.WkZ;
    paramString = com.tencent.mm.plugin.webcanvas.k.bic(paramString);
    AppMethodBeat.o(303309);
    return paramString;
  }
  
  private static void b(ghs paramghs)
  {
    AppMethodBeat.i(303305);
    if (paramghs == null)
    {
      AppMethodBeat.o(303305);
      return;
    }
    Log.i("MicroMsg.WebPrefetcherPkgDiffManager", "saveCurrentPkgInfo appId: " + paramghs.appId + ", pkgVersion: " + paramghs.mup);
    Object localObject = com.tencent.mm.plugin.webcanvas.k.WkZ;
    String str2 = paramghs.appId;
    s.s(str2, "pkgInfo.appId");
    vn localvn = new vn();
    String str1 = paramghs.appId;
    localObject = str1;
    if (str1 == null) {
      localObject = "";
    }
    localvn.appId = ((String)localObject);
    str1 = paramghs.pkgPath;
    localObject = str1;
    if (str1 == null) {
      localObject = "";
    }
    localvn.path = ((String)localObject);
    localObject = paramghs.mup;
    paramghs = (ghs)localObject;
    if (localObject == null) {
      paramghs = "";
    }
    localvn.Zbk = paramghs;
    paramghs = kotlin.ah.aiuX;
    com.tencent.mm.plugin.webcanvas.k.a(str2, localvn);
    AppMethodBeat.o(303305);
  }
  
  public static MultiProcessMMKV dgD()
  {
    AppMethodBeat.i(303261);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)vVe.getValue();
    AppMethodBeat.o(303261);
    return localMultiProcessMMKV;
  }
  
  public static final boolean dgE()
  {
    AppMethodBeat.i(303281);
    int i;
    if (vVf == null)
    {
      i = ((c)h.ax(c.class)).a(c.a.zgF, 1);
      if ((i != 1) && (!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_RED)) {
        break label112;
      }
    }
    label112:
    for (boolean bool = true;; bool = false)
    {
      vVf = Boolean.valueOf(bool);
      Log.i("MicroMsg.WebPrefetcherPkgDiffManager", "initWebPrefetcherPkgConfig enableDownloadPkgByHttp config: " + i + ", enable: " + vVf);
      Boolean localBoolean = vVf;
      s.checkNotNull(localBoolean);
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(303281);
      return bool;
    }
  }
  
  private static String fV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(303314);
    if (((CharSequence)paramString2).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(303314);
      return paramString1;
    }
    paramString1 = paramString1 + '_' + paramString2.hashCode();
    AppMethodBeat.o(303314);
    return paramString1;
  }
  
  private static String fW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(303318);
    paramString1 = paramString1 + '_' + paramString2.hashCode();
    AppMethodBeat.o(303318);
    return paramString1;
  }
  
  private static ghs fX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(303320);
    s.u(paramString1, "appId");
    s.u(paramString2, "pkgVersion");
    int i;
    if (((CharSequence)paramString1).length() > 0)
    {
      i = 1;
      if (i == 0) {
        break label182;
      }
      paramString1 = fV(paramString1, paramString2);
      Log.d("MicroMsg.WebPrefetcherPkgDiffManager", "getPkgInfo pkgVersion: %s, pkgKey: %s", new Object[] { paramString2, paramString1 });
      paramString2 = dgD();
      s.s(paramString2, "pkgVersionManager");
      if (!paramString2.containsKey(paramString1)) {
        break label177;
      }
      paramString1 = paramString2.decodeBytes(paramString1);
      if (paramString1 == null) {
        break label177;
      }
      if (paramString1.length != 0) {
        break label149;
      }
      i = 1;
      label100:
      if (i != 0) {
        break label154;
      }
      i = 1;
      label106:
      if (i == 0) {
        break label177;
      }
    }
    for (;;)
    {
      try
      {
        paramString2 = ghs.class.newInstance();
        ((com.tencent.mm.bx.a)paramString2).parseFrom(paramString1);
        paramString1 = (com.tencent.mm.bx.a)paramString2;
        paramString1 = (ghs)paramString1;
        AppMethodBeat.o(303320);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        label149:
        label154:
        Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)paramString1, "decode ProtoBuffer", new Object[0]);
      }
      i = 0;
      break;
      i = 0;
      break label100;
      i = 0;
      break label106;
      label177:
      paramString1 = null;
    }
    label182:
    AppMethodBeat.o(303320);
    return null;
  }
  
  private static ghs fY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(303327);
    s.u(paramString1, "appId");
    CharSequence localCharSequence = (CharSequence)paramString2;
    int i;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label177;
      }
      paramString1 = fW(paramString1, paramString2);
      Log.d("MicroMsg.WebPrefetcherPkgDiffManager", "getPkgInfoByUrl pkgKey: %s", new Object[] { paramString1 });
      paramString2 = dgD();
      s.s(paramString2, "pkgVersionManager");
      if (!paramString2.containsKey(paramString1)) {
        break label172;
      }
      paramString1 = paramString2.decodeBytes(paramString1);
      if (paramString1 == null) {
        break label172;
      }
      if (paramString1.length != 0) {
        break label144;
      }
      i = 1;
      label95:
      if (i != 0) {
        break label149;
      }
      i = 1;
      label101:
      if (i == 0) {
        break label172;
      }
    }
    for (;;)
    {
      try
      {
        paramString2 = ghs.class.newInstance();
        ((com.tencent.mm.bx.a)paramString2).parseFrom(paramString1);
        paramString1 = (com.tencent.mm.bx.a)paramString2;
        paramString1 = (ghs)paramString1;
        AppMethodBeat.o(303327);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        label144:
        label149:
        Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)paramString1, "decode ProtoBuffer", new Object[0]);
      }
      i = 0;
      break;
      i = 0;
      break label95;
      i = 0;
      break label101;
      label172:
      paramString1 = null;
    }
    label177:
    AppMethodBeat.o(303327);
    return null;
  }
  
  public static final void init()
  {
    AppMethodBeat.i(303270);
    com.tencent.mm.plugin.webcanvas.k.a((k.a)new b());
    AppMethodBeat.o(303270);
  }
  
  public static final void p(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(303295);
    s.u(paramString1, "appId");
    s.u(paramString2, "pkgPath");
    s.u(paramString3, "pkgVersion");
    Object localObject2 = dgD().decodeStringSet(paramString1, (Set)new LinkedHashSet());
    Log.i("MicroMsg.WebPrefetcherPkgDiffManager", "alvinluo savePkgInfo appId: " + paramString1 + ", pkgVersion: " + paramString3 + ", pkgPath: " + paramString2);
    s.s(localObject2, "set");
    Object localObject1 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject1).hasNext()) {
      Log.v("MicroMsg.WebPrefetcherPkgDiffManager", s.X("alvinluo savePkgInfo pkgVersion: ", (String)((Iterator)localObject1).next()));
    }
    localObject1 = new ghs();
    ((ghs)localObject1).appId = paramString1;
    ((ghs)localObject1).pkgPath = paramString2;
    ((ghs)localObject1).mup = paramString3;
    int i;
    if (((CharSequence)paramString3).length() > 0)
    {
      i = 1;
      if (i == 0) {
        break label371;
      }
      ((Set)localObject2).add(paramString3);
      dgD().encode(paramString1, (Set)localObject2);
      localObject2 = fV(paramString1, paramString3);
      paramString2 = ((ghs)localObject1).toByteArray();
      dgD().encode((String)localObject2, paramString2);
      Log.v("MicroMsg.WebPrefetcherPkgDiffManager", "savePkgInfo pkgKey: " + (String)localObject2 + ", pkgVersion: " + paramString3);
    }
    for (;;)
    {
      localObject2 = (CharSequence)paramString4;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0)
        {
          paramString4 = fW(paramString1, paramString4);
          paramString1 = paramString2;
          if (paramString2 == null) {
            paramString1 = ((ghs)localObject1).toByteArray();
          }
          Log.v("MicroMsg.WebPrefetcherPkgDiffManager", "savePkgInfoByUrl urlKey: " + paramString4 + ", pkgVersion: " + paramString3);
          dgD().encode(paramString4, paramString1);
        }
        AppMethodBeat.o(303295);
        return;
        i = 0;
        break;
      }
      label371:
      paramString2 = null;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherPkgDiffManager$Reporter;", "", "()V", "reportMergeDiffResult", "", "mergeResult", "", "reportUpdateResult", "result", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
  {
    public static final a vVg;
    
    static
    {
      AppMethodBeat.i(302908);
      vVg = new a();
      AppMethodBeat.o(302908);
    }
    
    public static void HK(int paramInt)
    {
      AppMethodBeat.i(302896);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(302896);
        return;
        com.tencent.mm.plugin.webcanvas.j localj = com.tencent.mm.plugin.webcanvas.j.WkY;
        com.tencent.mm.plugin.webcanvas.j.xC(200L);
        AppMethodBeat.o(302896);
        return;
        localj = com.tencent.mm.plugin.webcanvas.j.WkY;
        com.tencent.mm.plugin.webcanvas.j.xC(201L);
        AppMethodBeat.o(302896);
        return;
        localj = com.tencent.mm.plugin.webcanvas.j.WkY;
        com.tencent.mm.plugin.webcanvas.j.xC(202L);
        AppMethodBeat.o(302896);
        return;
        localj = com.tencent.mm.plugin.webcanvas.j.WkY;
        com.tencent.mm.plugin.webcanvas.j.xC(203L);
      }
    }
    
    public static void HL(int paramInt)
    {
      AppMethodBeat.i(302904);
      switch (paramInt)
      {
      default: 
        paramInt = -1;
      }
      for (;;)
      {
        if (paramInt != -1)
        {
          com.tencent.mm.plugin.webcanvas.j localj = com.tencent.mm.plugin.webcanvas.j.WkY;
          com.tencent.mm.plugin.webcanvas.j.xC(paramInt);
        }
        AppMethodBeat.o(302904);
        return;
        paramInt = 204;
        continue;
        paramInt = 205;
        continue;
        paramInt = 206;
        continue;
        paramInt = 207;
        continue;
        paramInt = 208;
        continue;
        paramInt = 209;
        continue;
        paramInt = 210;
        continue;
        paramInt = 211;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/WebPrefetcherPkgDiffManager$init$1", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasStorageLogic$PkgClearListener;", "onPkgClear", "", "appId", "", "pkgFile", "Lcom/tencent/mm/vfs/VFSFile;", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements k.a
  {
    public final void d(String paramString, com.tencent.mm.vfs.u paramu)
    {
      AppMethodBeat.i(302901);
      StringBuilder localStringBuilder = new StringBuilder("onPkgClear appId: ").append(paramString).append(", pkgFile: ");
      if (paramu == null) {}
      for (paramString = null;; paramString = com.tencent.mm.vfs.ah.v(paramu.jKT()))
      {
        Log.i("MicroMsg.WebPrefetcherPkgDiffManager", paramString);
        AppMethodBeat.o(302901);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.a<MultiProcessMMKV>
  {
    public static final c vVh;
    
    static
    {
      AppMethodBeat.i(302897);
      vVh = new c();
      AppMethodBeat.o(302897);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.v
 * JD-Core Version:    0.7.0.1
 */