package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.eib;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.o;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"TAG", "", "TMPL_CONTROL_FLAG", "", "getTMPL_CONTROL_FLAG", "()J", "TMPL_CONTROL_FLAG$delegate", "Lkotlin/Lazy;", "kvTmpl", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvTmpl", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "basePath", "Lcom/tencent/mm/protocal/protobuf/TmplInfo;", "getBasePath", "(Lcom/tencent/mm/protocal/protobuf/TmplInfo;)Ljava/lang/String;", "indexPath", "getIndexPath", "isFileExists", "", "(Ljava/lang/String;)Z", "isLatestVerifiedExpired", "(Lcom/tencent/mm/protocal/protobuf/TmplInfo;)Z", "isValid", "isZip", "keyLatestResp", "", "getKeyLatestResp", "(I)Ljava/lang/String;", "keyLatestVerified", "getKeyLatestVerified", "keyLatestVerifiedMD5", "getKeyLatestVerifiedMD5", "keyLatestVerifiedTime", "getKeyLatestVerifiedTime", "keyStore", "getKeyStore", "keyVersions", "getKeyVersions", "getRelaunchState", "pidMM", "startMM", "pidMP", "startMP", "toFile", "Lcom/tencent/mm/vfs/VFSFile;", "plugin-brandservice_release"})
public final class u
{
  private static final String TAG = "MicroMsg.TmplInfoEx";
  private static final f pDv;
  
  static
  {
    AppMethodBeat.i(6740);
    TAG = "MicroMsg.TmplInfoEx";
    pDv = g.ah((a)u.a.pDw);
    AppMethodBeat.o(6740);
  }
  
  public static final String Dx(int paramInt)
  {
    AppMethodBeat.i(6749);
    String str = "_tmpl_info_latest_responsed_-".concat(String.valueOf(paramInt));
    AppMethodBeat.o(6749);
    return str;
  }
  
  public static final int a(int paramInt1, long paramLong1, int paramInt2, long paramLong2)
  {
    AppMethodBeat.i(6755);
    paramInt1 = (paramInt1 + '-' + paramLong1).hashCode();
    if (coo().getInt("_tmpl_lastest_mm_open", 0) == paramInt1)
    {
      paramInt1 = (paramInt2 + '-' + paramLong2).hashCode();
      if (coo().getInt("_tmpl_lastest_mp_open", 0) == paramInt1)
      {
        AppMethodBeat.o(6755);
        return 2;
      }
      coo().putInt("_tmpl_lastest_mp_open", paramInt1);
      AppMethodBeat.o(6755);
      return 1;
    }
    coo().putInt("_tmpl_lastest_mm_open", paramInt1);
    AppMethodBeat.o(6755);
    return 0;
  }
  
  public static final boolean a(eib parameib)
  {
    AppMethodBeat.i(6745);
    p.h(parameib, "$this$isValid");
    if (parameib.Version != 0)
    {
      AppMethodBeat.o(6745);
      return true;
    }
    AppMethodBeat.o(6745);
    return false;
  }
  
  public static final o aim(String paramString)
  {
    AppMethodBeat.i(6743);
    p.h(paramString, "$this$toFile");
    paramString = new o(paramString);
    AppMethodBeat.o(6743);
    return paramString;
  }
  
  public static final boolean ain(String paramString)
  {
    AppMethodBeat.i(6744);
    p.h(paramString, "$this$isFileExists");
    boolean bool = aim(paramString).exists();
    AppMethodBeat.o(6744);
    return bool;
  }
  
  public static final String b(eib parameib)
  {
    AppMethodBeat.i(6746);
    p.h(parameib, "$this$basePath");
    int i = parameib.oUv;
    Object localObject = parameib.LQx;
    p.g(localObject, "this.Uid");
    String str = t.u(i, (String)localObject, "");
    localObject = str;
    if (!ain(str))
    {
      i = parameib.oUv;
      parameib = parameib.LQx;
      p.g(parameib, "this.Uid");
      localObject = t.aF(i, parameib);
    }
    AppMethodBeat.o(6746);
    return localObject;
  }
  
  public static final String c(eib parameib)
  {
    AppMethodBeat.i(6747);
    p.h(parameib, "$this$indexPath");
    int i = parameib.oUv;
    Object localObject = parameib.LQx;
    p.g(localObject, "this.Uid");
    String str = t.aG(i, (String)localObject);
    localObject = str;
    if (!ain(str))
    {
      i = parameib.oUv;
      parameib = parameib.LQx;
      p.g(parameib, "this.Uid");
      localObject = t.aF(i, parameib);
    }
    AppMethodBeat.o(6747);
    return localObject;
  }
  
  public static final long con()
  {
    AppMethodBeat.i(6741);
    long l = ((Number)pDv.getValue()).longValue();
    AppMethodBeat.o(6741);
    return l;
  }
  
  public static final MultiProcessMMKV coo()
  {
    AppMethodBeat.i(6742);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("_webview_tmpl_info");
    p.g(localMultiProcessMMKV, "MultiProcessMMKV.getMMKV…d.MMKV_WEBVIEW_TMPL_INFO)");
    AppMethodBeat.o(6742);
    return localMultiProcessMMKV;
  }
  
  public static final boolean d(eib parameib)
  {
    AppMethodBeat.i(6748);
    p.h(parameib, "$this$isZip");
    String str = c(parameib);
    int i = parameib.oUv;
    parameib = parameib.LQx;
    p.g(parameib, "this.Uid");
    boolean bool = p.j(str, t.aG(i, parameib));
    AppMethodBeat.o(6748);
    return bool;
  }
  
  public static final String e(eib parameib)
  {
    AppMethodBeat.i(6750);
    p.h(parameib, "$this$keyStore");
    parameib = "_tmpl_info_-" + parameib.oUv + '-' + parameib.LQx;
    AppMethodBeat.o(6750);
    return parameib;
  }
  
  public static final String f(eib parameib)
  {
    AppMethodBeat.i(6751);
    p.h(parameib, "$this$keyLatestVerified");
    parameib = "_tmpl_info_latest_verified_-" + parameib.oUv + '-' + parameib.Nhq;
    AppMethodBeat.o(6751);
    return parameib;
  }
  
  public static final String g(eib parameib)
  {
    AppMethodBeat.i(6752);
    p.h(parameib, "$this$keyLatestVerifiedTime");
    parameib = "_tmpl_info_latest_verified_time_-" + parameib.oUv + '-' + parameib.Nhq;
    AppMethodBeat.o(6752);
    return parameib;
  }
  
  public static final String h(eib parameib)
  {
    AppMethodBeat.i(6753);
    p.h(parameib, "$this$keyVersions");
    parameib = "_tmpl_info_version_list_-" + parameib.oUv + '-' + parameib.Nhq;
    AppMethodBeat.o(6753);
    return parameib;
  }
  
  public static final boolean i(eib parameib)
  {
    AppMethodBeat.i(6754);
    p.h(parameib, "$this$isLatestVerifiedExpired");
    boolean bool = MMSlotKt.isExpire(coo().getLong(g(parameib), 0L), 3600000);
    AppMethodBeat.o(6754);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.u
 * JD-Core Version:    0.7.0.1
 */