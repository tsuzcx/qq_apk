package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esd;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"TAG", "", "TMPL_CONTROL_FLAG", "", "getTMPL_CONTROL_FLAG", "()J", "TMPL_CONTROL_FLAG$delegate", "Lkotlin/Lazy;", "kvTmpl", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvTmpl", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "basePath", "Lcom/tencent/mm/protocal/protobuf/TmplInfo;", "getBasePath", "(Lcom/tencent/mm/protocal/protobuf/TmplInfo;)Ljava/lang/String;", "indexPath", "getIndexPath", "isFileExists", "", "(Ljava/lang/String;)Z", "isLatestVerifiedExpired", "(Lcom/tencent/mm/protocal/protobuf/TmplInfo;)Z", "isValid", "isZip", "keyLatestResp", "", "getKeyLatestResp", "(I)Ljava/lang/String;", "keyLatestVerified", "getKeyLatestVerified", "keyLatestVerifiedMD5", "getKeyLatestVerifiedMD5", "keyLatestVerifiedTime", "getKeyLatestVerifiedTime", "keyStore", "getKeyStore", "keyVersions", "getKeyVersions", "getRelaunchState", "pidMM", "startMM", "pidMP", "startMP", "toFile", "Lcom/tencent/mm/vfs/VFSFile;", "plugin-brandservice_release"})
public final class q
{
  private static final String TAG = "MicroMsg.TmplInfoEx";
  private static final f sNy;
  
  static
  {
    AppMethodBeat.i(6740);
    TAG = "MicroMsg.TmplInfoEx";
    sNy = g.ar((a)a.sNz);
    AppMethodBeat.o(6740);
  }
  
  public static final String Hg(int paramInt)
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
    if (cCt().getInt("_tmpl_lastest_mm_open", 0) == paramInt1)
    {
      paramInt1 = (paramInt2 + '-' + paramLong2).hashCode();
      if (cCt().getInt("_tmpl_lastest_mp_open", 0) == paramInt1)
      {
        AppMethodBeat.o(6755);
        return 2;
      }
      cCt().putInt("_tmpl_lastest_mp_open", paramInt1);
      AppMethodBeat.o(6755);
      return 1;
    }
    cCt().putInt("_tmpl_lastest_mm_open", paramInt1);
    AppMethodBeat.o(6755);
    return 0;
  }
  
  public static final boolean a(esd paramesd)
  {
    AppMethodBeat.i(6745);
    kotlin.g.b.p.k(paramesd, "$this$isValid");
    if (paramesd.rWt != 0)
    {
      AppMethodBeat.o(6745);
      return true;
    }
    AppMethodBeat.o(6745);
    return false;
  }
  
  public static final com.tencent.mm.vfs.q apY(String paramString)
  {
    AppMethodBeat.i(6743);
    kotlin.g.b.p.k(paramString, "$this$toFile");
    paramString = new com.tencent.mm.vfs.q(paramString);
    AppMethodBeat.o(6743);
    return paramString;
  }
  
  public static final boolean apZ(String paramString)
  {
    AppMethodBeat.i(6744);
    kotlin.g.b.p.k(paramString, "$this$isFileExists");
    boolean bool = apY(paramString).ifE();
    AppMethodBeat.o(6744);
    return bool;
  }
  
  public static final String b(esd paramesd)
  {
    AppMethodBeat.i(6746);
    kotlin.g.b.p.k(paramesd, "$this$basePath");
    int i = paramesd.rWu;
    Object localObject = paramesd.SYY;
    kotlin.g.b.p.j(localObject, "this.Uid");
    String str = p.u(i, (String)localObject, "");
    localObject = str;
    if (!apZ(str))
    {
      i = paramesd.rWu;
      paramesd = paramesd.SYY;
      kotlin.g.b.p.j(paramesd, "this.Uid");
      localObject = p.aH(i, paramesd);
    }
    AppMethodBeat.o(6746);
    return localObject;
  }
  
  public static final String c(esd paramesd)
  {
    AppMethodBeat.i(6747);
    kotlin.g.b.p.k(paramesd, "$this$indexPath");
    int i = paramesd.rWu;
    Object localObject = paramesd.SYY;
    kotlin.g.b.p.j(localObject, "this.Uid");
    String str = p.aI(i, (String)localObject);
    localObject = str;
    if (!apZ(str))
    {
      i = paramesd.rWu;
      paramesd = paramesd.SYY;
      kotlin.g.b.p.j(paramesd, "this.Uid");
      localObject = p.aH(i, paramesd);
    }
    AppMethodBeat.o(6747);
    return localObject;
  }
  
  public static final long cCs()
  {
    AppMethodBeat.i(6741);
    long l = ((Number)sNy.getValue()).longValue();
    AppMethodBeat.o(6741);
    return l;
  }
  
  public static final MultiProcessMMKV cCt()
  {
    AppMethodBeat.i(6742);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("_webview_tmpl_info");
    kotlin.g.b.p.j(localMultiProcessMMKV, "MultiProcessMMKV.getMMKV…d.MMKV_WEBVIEW_TMPL_INFO)");
    AppMethodBeat.o(6742);
    return localMultiProcessMMKV;
  }
  
  public static final boolean d(esd paramesd)
  {
    AppMethodBeat.i(6748);
    kotlin.g.b.p.k(paramesd, "$this$isZip");
    String str = c(paramesd);
    int i = paramesd.rWu;
    paramesd = paramesd.SYY;
    kotlin.g.b.p.j(paramesd, "this.Uid");
    boolean bool = kotlin.g.b.p.h(str, p.aI(i, paramesd));
    AppMethodBeat.o(6748);
    return bool;
  }
  
  public static final String e(esd paramesd)
  {
    AppMethodBeat.i(6750);
    kotlin.g.b.p.k(paramesd, "$this$keyStore");
    paramesd = "_tmpl_info_-" + paramesd.rWu + '-' + paramesd.SYY;
    AppMethodBeat.o(6750);
    return paramesd;
  }
  
  public static final String f(esd paramesd)
  {
    AppMethodBeat.i(6751);
    kotlin.g.b.p.k(paramesd, "$this$keyLatestVerified");
    paramesd = "_tmpl_info_latest_verified_-" + paramesd.rWu + '-' + paramesd.UtW;
    AppMethodBeat.o(6751);
    return paramesd;
  }
  
  public static final String g(esd paramesd)
  {
    AppMethodBeat.i(6752);
    kotlin.g.b.p.k(paramesd, "$this$keyLatestVerifiedTime");
    paramesd = "_tmpl_info_latest_verified_time_-" + paramesd.rWu + '-' + paramesd.UtW;
    AppMethodBeat.o(6752);
    return paramesd;
  }
  
  public static final String h(esd paramesd)
  {
    AppMethodBeat.i(6753);
    kotlin.g.b.p.k(paramesd, "$this$keyVersions");
    paramesd = "_tmpl_info_version_list_-" + paramesd.rWu + '-' + paramesd.UtW;
    AppMethodBeat.o(6753);
    return paramesd;
  }
  
  public static final boolean i(esd paramesd)
  {
    AppMethodBeat.i(6754);
    kotlin.g.b.p.k(paramesd, "$this$isLatestVerifiedExpired");
    boolean bool = MMSlotKt.isExpire(cCt().getLong(g(paramesd), 0L), 3600000);
    AppMethodBeat.o(6754);
    return bool;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements a<Long>
  {
    public static final a sNz;
    
    static
    {
      AppMethodBeat.i(6739);
      sNz = new a();
      AppMethodBeat.o(6739);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.q
 * JD-Core Version:    0.7.0.1
 */