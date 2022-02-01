package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dof;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.vfs.k;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"TAG", "", "TMPL_CONTROL_FLAG", "", "getTMPL_CONTROL_FLAG", "()J", "TMPL_CONTROL_FLAG$delegate", "Lkotlin/Lazy;", "kvTmpl", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvTmpl", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "basePath", "Lcom/tencent/mm/protocal/protobuf/TmplInfo;", "getBasePath", "(Lcom/tencent/mm/protocal/protobuf/TmplInfo;)Ljava/lang/String;", "indexPath", "getIndexPath", "isFileExists", "", "(Ljava/lang/String;)Z", "isLatestVerifiedExpired", "(Lcom/tencent/mm/protocal/protobuf/TmplInfo;)Z", "isValid", "isZip", "keyLatestResp", "", "getKeyLatestResp", "(I)Ljava/lang/String;", "keyLatestVerified", "getKeyLatestVerified", "keyLatestVerifiedMD5", "getKeyLatestVerifiedMD5", "keyLatestVerifiedTime", "getKeyLatestVerifiedTime", "keyStore", "getKeyStore", "keyVersions", "getKeyVersions", "getRelaunchState", "pidMM", "startMM", "pidMP", "startMP", "toFile", "Lcom/tencent/mm/vfs/VFSFile;", "plugin-brandservice_release"})
public final class s
{
  private static final String TAG = "MicroMsg.TmplInfoEx";
  private static final f opU;
  
  static
  {
    AppMethodBeat.i(6740);
    TAG = "MicroMsg.TmplInfoEx";
    opU = g.O((a)a.opV);
    AppMethodBeat.o(6740);
  }
  
  public static final k Ym(String paramString)
  {
    AppMethodBeat.i(6743);
    p.h(paramString, "$this$toFile");
    paramString = new k(paramString);
    AppMethodBeat.o(6743);
    return paramString;
  }
  
  public static final boolean Yn(String paramString)
  {
    AppMethodBeat.i(6744);
    p.h(paramString, "$this$isFileExists");
    boolean bool = Ym(paramString).exists();
    AppMethodBeat.o(6744);
    return bool;
  }
  
  public static final int a(int paramInt1, long paramLong1, int paramInt2, long paramLong2)
  {
    AppMethodBeat.i(6755);
    paramInt1 = (paramInt1 + '-' + paramLong1).hashCode();
    if (bQG().getInt("_tmpl_lastest_mm_open", 0) == paramInt1)
    {
      paramInt1 = (paramInt2 + '-' + paramLong2).hashCode();
      if (bQG().getInt("_tmpl_lastest_mp_open", 0) == paramInt1)
      {
        AppMethodBeat.o(6755);
        return 2;
      }
      bQG().putInt("_tmpl_lastest_mp_open", paramInt1);
      AppMethodBeat.o(6755);
      return 1;
    }
    bQG().putInt("_tmpl_lastest_mm_open", paramInt1);
    AppMethodBeat.o(6755);
    return 0;
  }
  
  public static final boolean a(dof paramdof)
  {
    AppMethodBeat.i(6745);
    p.h(paramdof, "$this$isValid");
    if (paramdof.Version != 0)
    {
      AppMethodBeat.o(6745);
      return true;
    }
    AppMethodBeat.o(6745);
    return false;
  }
  
  public static final String b(dof paramdof)
  {
    AppMethodBeat.i(6746);
    p.h(paramdof, "$this$basePath");
    int i = paramdof.nJA;
    Object localObject = paramdof.GMr;
    p.g(localObject, "this.Uid");
    String str = r.t(i, (String)localObject, "");
    localObject = str;
    if (!Yn(str))
    {
      i = paramdof.nJA;
      paramdof = paramdof.GMr;
      p.g(paramdof, "this.Uid");
      localObject = r.aA(i, paramdof);
    }
    AppMethodBeat.o(6746);
    return localObject;
  }
  
  public static final long bQF()
  {
    AppMethodBeat.i(6741);
    long l = ((Number)opU.getValue()).longValue();
    AppMethodBeat.o(6741);
    return l;
  }
  
  public static final ay bQG()
  {
    AppMethodBeat.i(6742);
    ay localay = ay.aRW("_webview_tmpl_info");
    p.g(localay, "MultiProcessMMKV.getMMKV…d.MMKV_WEBVIEW_TMPL_INFO)");
    AppMethodBeat.o(6742);
    return localay;
  }
  
  public static final String c(dof paramdof)
  {
    AppMethodBeat.i(6747);
    p.h(paramdof, "$this$indexPath");
    int i = paramdof.nJA;
    Object localObject = paramdof.GMr;
    p.g(localObject, "this.Uid");
    String str = r.aB(i, (String)localObject);
    localObject = str;
    if (!Yn(str))
    {
      i = paramdof.nJA;
      paramdof = paramdof.GMr;
      p.g(paramdof, "this.Uid");
      localObject = r.aA(i, paramdof);
    }
    AppMethodBeat.o(6747);
    return localObject;
  }
  
  public static final boolean d(dof paramdof)
  {
    AppMethodBeat.i(6748);
    p.h(paramdof, "$this$isZip");
    String str = c(paramdof);
    int i = paramdof.nJA;
    paramdof = paramdof.GMr;
    p.g(paramdof, "this.Uid");
    boolean bool = p.i(str, r.aB(i, paramdof));
    AppMethodBeat.o(6748);
    return bool;
  }
  
  public static final String e(dof paramdof)
  {
    AppMethodBeat.i(6750);
    p.h(paramdof, "$this$keyStore");
    paramdof = "_tmpl_info_-" + paramdof.nJA + '-' + paramdof.GMr;
    AppMethodBeat.o(6750);
    return paramdof;
  }
  
  public static final String f(dof paramdof)
  {
    AppMethodBeat.i(6751);
    p.h(paramdof, "$this$keyLatestVerified");
    paramdof = "_tmpl_info_latest_verified_-" + paramdof.nJA + '-' + paramdof.HVg;
    AppMethodBeat.o(6751);
    return paramdof;
  }
  
  public static final String g(dof paramdof)
  {
    AppMethodBeat.i(6752);
    p.h(paramdof, "$this$keyLatestVerifiedTime");
    paramdof = "_tmpl_info_latest_verified_time_-" + paramdof.nJA + '-' + paramdof.HVg;
    AppMethodBeat.o(6752);
    return paramdof;
  }
  
  public static final String h(dof paramdof)
  {
    AppMethodBeat.i(6753);
    p.h(paramdof, "$this$keyVersions");
    paramdof = "_tmpl_info_version_list_-" + paramdof.nJA + '-' + paramdof.HVg;
    AppMethodBeat.o(6753);
    return paramdof;
  }
  
  public static final boolean i(dof paramdof)
  {
    AppMethodBeat.i(6754);
    p.h(paramdof, "$this$isLatestVerifiedExpired");
    boolean bool = at.al(bQG().getLong(g(paramdof), 0L), 3600000);
    AppMethodBeat.o(6754);
    return bool;
  }
  
  public static final String zR(int paramInt)
  {
    AppMethodBeat.i(6749);
    String str = "_tmpl_info_latest_responsed_-".concat(String.valueOf(paramInt));
    AppMethodBeat.o(6749);
    return str;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<Long>
  {
    public static final a opV;
    
    static
    {
      AppMethodBeat.i(6739);
      opV = new a();
      AppMethodBeat.o(6739);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.s
 * JD-Core Version:    0.7.0.1
 */