package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dni;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.vfs.e;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"TAG", "", "TMPL_CONTROL_FLAG", "", "getTMPL_CONTROL_FLAG", "()J", "TMPL_CONTROL_FLAG$delegate", "Lkotlin/Lazy;", "kvTmpl", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvTmpl", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "basePath", "Lcom/tencent/mm/protocal/protobuf/TmplInfo;", "getBasePath", "(Lcom/tencent/mm/protocal/protobuf/TmplInfo;)Ljava/lang/String;", "indexPath", "getIndexPath", "isFileExists", "", "(Ljava/lang/String;)Z", "isLatestVerifiedExpired", "(Lcom/tencent/mm/protocal/protobuf/TmplInfo;)Z", "isValid", "isZip", "keyLatestResp", "", "getKeyLatestResp", "(I)Ljava/lang/String;", "keyLatestVerified", "getKeyLatestVerified", "keyLatestVerifiedMD5", "getKeyLatestVerifiedMD5", "keyLatestVerifiedTime", "getKeyLatestVerifiedTime", "keyStore", "getKeyStore", "keyVersions", "getKeyVersions", "getRelaunchState", "pidMM", "startMM", "pidMP", "startMP", "toFile", "Lcom/tencent/mm/vfs/VFSFile;", "plugin-brandservice_release"})
public final class s
{
  private static final String TAG = "MicroMsg.TmplInfoEx";
  private static final f ojU;
  
  static
  {
    AppMethodBeat.i(6740);
    TAG = "MicroMsg.TmplInfoEx";
    ojU = g.O((a)a.ojV);
    AppMethodBeat.o(6740);
  }
  
  public static final boolean XA(String paramString)
  {
    AppMethodBeat.i(6744);
    p.h(paramString, "$this$isFileExists");
    boolean bool = Xz(paramString).exists();
    AppMethodBeat.o(6744);
    return bool;
  }
  
  public static final e Xz(String paramString)
  {
    AppMethodBeat.i(6743);
    p.h(paramString, "$this$toFile");
    paramString = new e(paramString);
    AppMethodBeat.o(6743);
    return paramString;
  }
  
  public static final int a(int paramInt1, long paramLong1, int paramInt2, long paramLong2)
  {
    AppMethodBeat.i(6755);
    paramInt1 = (paramInt1 + '-' + paramLong1).hashCode();
    if (bPI().getInt("_tmpl_lastest_mm_open", 0) == paramInt1)
    {
      paramInt1 = (paramInt2 + '-' + paramLong2).hashCode();
      if (bPI().getInt("_tmpl_lastest_mp_open", 0) == paramInt1)
      {
        AppMethodBeat.o(6755);
        return 2;
      }
      bPI().putInt("_tmpl_lastest_mp_open", paramInt1);
      AppMethodBeat.o(6755);
      return 1;
    }
    bPI().putInt("_tmpl_lastest_mm_open", paramInt1);
    AppMethodBeat.o(6755);
    return 0;
  }
  
  public static final boolean a(dni paramdni)
  {
    AppMethodBeat.i(6745);
    p.h(paramdni, "$this$isValid");
    if (paramdni.Version != 0)
    {
      AppMethodBeat.o(6745);
      return true;
    }
    AppMethodBeat.o(6745);
    return false;
  }
  
  public static final String b(dni paramdni)
  {
    AppMethodBeat.i(6746);
    p.h(paramdni, "$this$basePath");
    int i = paramdni.nEf;
    Object localObject = paramdni.GsT;
    p.g(localObject, "this.Uid");
    String str = r.t(i, (String)localObject, "");
    localObject = str;
    if (!XA(str))
    {
      i = paramdni.nEf;
      paramdni = paramdni.GsT;
      p.g(paramdni, "this.Uid");
      localObject = r.aB(i, paramdni);
    }
    AppMethodBeat.o(6746);
    return localObject;
  }
  
  public static final long bPH()
  {
    AppMethodBeat.i(6741);
    long l = ((Number)ojU.getValue()).longValue();
    AppMethodBeat.o(6741);
    return l;
  }
  
  public static final ax bPI()
  {
    AppMethodBeat.i(6742);
    ax localax = ax.aQz("_webview_tmpl_info");
    p.g(localax, "MultiProcessMMKV.getMMKV…d.MMKV_WEBVIEW_TMPL_INFO)");
    AppMethodBeat.o(6742);
    return localax;
  }
  
  public static final String c(dni paramdni)
  {
    AppMethodBeat.i(6747);
    p.h(paramdni, "$this$indexPath");
    int i = paramdni.nEf;
    Object localObject = paramdni.GsT;
    p.g(localObject, "this.Uid");
    String str = r.aC(i, (String)localObject);
    localObject = str;
    if (!XA(str))
    {
      i = paramdni.nEf;
      paramdni = paramdni.GsT;
      p.g(paramdni, "this.Uid");
      localObject = r.aB(i, paramdni);
    }
    AppMethodBeat.o(6747);
    return localObject;
  }
  
  public static final boolean d(dni paramdni)
  {
    AppMethodBeat.i(6748);
    p.h(paramdni, "$this$isZip");
    String str = c(paramdni);
    int i = paramdni.nEf;
    paramdni = paramdni.GsT;
    p.g(paramdni, "this.Uid");
    boolean bool = p.i(str, r.aC(i, paramdni));
    AppMethodBeat.o(6748);
    return bool;
  }
  
  public static final String e(dni paramdni)
  {
    AppMethodBeat.i(6750);
    p.h(paramdni, "$this$keyStore");
    paramdni = "_tmpl_info_-" + paramdni.nEf + '-' + paramdni.GsT;
    AppMethodBeat.o(6750);
    return paramdni;
  }
  
  public static final String f(dni paramdni)
  {
    AppMethodBeat.i(6751);
    p.h(paramdni, "$this$keyLatestVerified");
    paramdni = "_tmpl_info_latest_verified_-" + paramdni.nEf + '-' + paramdni.HBt;
    AppMethodBeat.o(6751);
    return paramdni;
  }
  
  public static final String g(dni paramdni)
  {
    AppMethodBeat.i(6752);
    p.h(paramdni, "$this$keyLatestVerifiedTime");
    paramdni = "_tmpl_info_latest_verified_time_-" + paramdni.nEf + '-' + paramdni.HBt;
    AppMethodBeat.o(6752);
    return paramdni;
  }
  
  public static final String h(dni paramdni)
  {
    AppMethodBeat.i(6753);
    p.h(paramdni, "$this$keyVersions");
    paramdni = "_tmpl_info_version_list_-" + paramdni.nEf + '-' + paramdni.HBt;
    AppMethodBeat.o(6753);
    return paramdni;
  }
  
  public static final boolean i(dni paramdni)
  {
    AppMethodBeat.i(6754);
    p.h(paramdni, "$this$isLatestVerifiedExpired");
    boolean bool = as.al(bPI().getLong(g(paramdni), 0L), 3600000);
    AppMethodBeat.o(6754);
    return bool;
  }
  
  public static final String zI(int paramInt)
  {
    AppMethodBeat.i(6749);
    String str = "_tmpl_info_latest_responsed_-".concat(String.valueOf(paramInt));
    AppMethodBeat.o(6749);
    return str;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<Long>
  {
    public static final a ojV;
    
    static
    {
      AppMethodBeat.i(6739);
      ojV = new a();
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