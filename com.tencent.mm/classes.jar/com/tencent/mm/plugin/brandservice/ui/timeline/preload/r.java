package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dcg;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.vfs.e;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.s;
import d.g.b.w;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"TAG", "", "TMPL_CONTROL_FLAG", "", "getTMPL_CONTROL_FLAG", "()J", "TMPL_CONTROL_FLAG$delegate", "Lkotlin/Lazy;", "kvTmpl", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvTmpl", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "basePath", "Lcom/tencent/mm/protocal/protobuf/TmplInfo;", "getBasePath", "(Lcom/tencent/mm/protocal/protobuf/TmplInfo;)Ljava/lang/String;", "indexPath", "getIndexPath", "isFileExists", "", "(Ljava/lang/String;)Z", "isLatestVerifiedExpired", "(Lcom/tencent/mm/protocal/protobuf/TmplInfo;)Z", "isValid", "isZip", "keyLatestResp", "", "getKeyLatestResp", "(I)Ljava/lang/String;", "keyLatestVerified", "getKeyLatestVerified", "keyLatestVerifiedMD5", "getKeyLatestVerifiedMD5", "keyLatestVerifiedTime", "getKeyLatestVerifiedTime", "keyStore", "getKeyStore", "keyVersions", "getKeyVersions", "getRelaunchState", "pidMM", "startMM", "pidMP", "startMP", "toFile", "Lcom/tencent/mm/vfs/VFSFile;", "plugin-brandservice_release"})
public final class r
{
  private static final String TAG = "MicroMsg.TmplInfoEx";
  private static final f neG;
  
  static
  {
    AppMethodBeat.i(6740);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new s(w.g(r.class, "plugin-brandservice_release"), "TMPL_CONTROL_FLAG", "getTMPL_CONTROL_FLAG()J")) };
    TAG = "MicroMsg.TmplInfoEx";
    neG = g.E((a)a.neH);
    AppMethodBeat.o(6740);
  }
  
  public static final e PG(String paramString)
  {
    AppMethodBeat.i(6743);
    d.g.b.k.h(paramString, "$this$toFile");
    paramString = new e(paramString);
    AppMethodBeat.o(6743);
    return paramString;
  }
  
  public static final boolean PH(String paramString)
  {
    AppMethodBeat.i(6744);
    d.g.b.k.h(paramString, "$this$isFileExists");
    boolean bool = PG(paramString).exists();
    AppMethodBeat.o(6744);
    return bool;
  }
  
  public static final int a(int paramInt1, long paramLong1, int paramInt2, long paramLong2)
  {
    AppMethodBeat.i(6755);
    paramInt1 = (paramInt1 + '-' + paramLong1).hashCode();
    if (bDU().getInt("_tmpl_lastest_mm_open", 0) == paramInt1)
    {
      paramInt1 = (paramInt2 + '-' + paramLong2).hashCode();
      if (bDU().getInt("_tmpl_lastest_mp_open", 0) == paramInt1)
      {
        AppMethodBeat.o(6755);
        return 2;
      }
      bDU().putInt("_tmpl_lastest_mp_open", paramInt1);
      AppMethodBeat.o(6755);
      return 1;
    }
    bDU().putInt("_tmpl_lastest_mm_open", paramInt1);
    AppMethodBeat.o(6755);
    return 0;
  }
  
  public static final boolean a(dcg paramdcg)
  {
    AppMethodBeat.i(6745);
    d.g.b.k.h(paramdcg, "$this$isValid");
    if (paramdcg.Version != 0)
    {
      AppMethodBeat.o(6745);
      return true;
    }
    AppMethodBeat.o(6745);
    return false;
  }
  
  public static final String b(dcg paramdcg)
  {
    AppMethodBeat.i(6746);
    d.g.b.k.h(paramdcg, "$this$basePath");
    int i = paramdcg.mBH;
    Object localObject = paramdcg.DoR;
    d.g.b.k.g(localObject, "this.Uid");
    String str = q.t(i, (String)localObject, "");
    localObject = str;
    if (!PH(str))
    {
      i = paramdcg.mBH;
      paramdcg = paramdcg.DoR;
      d.g.b.k.g(paramdcg, "this.Uid");
      localObject = q.ax(i, paramdcg);
    }
    AppMethodBeat.o(6746);
    return localObject;
  }
  
  public static final long bDT()
  {
    AppMethodBeat.i(6741);
    long l = ((Number)neG.getValue()).longValue();
    AppMethodBeat.o(6741);
    return l;
  }
  
  public static final ax bDU()
  {
    AppMethodBeat.i(6742);
    ax localax = ax.aFC("_webview_tmpl_info");
    d.g.b.k.g(localax, "MultiProcessMMKV.getMMKV…d.MMKV_WEBVIEW_TMPL_INFO)");
    AppMethodBeat.o(6742);
    return localax;
  }
  
  public static final String c(dcg paramdcg)
  {
    AppMethodBeat.i(6747);
    d.g.b.k.h(paramdcg, "$this$indexPath");
    int i = paramdcg.mBH;
    Object localObject = paramdcg.DoR;
    d.g.b.k.g(localObject, "this.Uid");
    String str = q.ay(i, (String)localObject);
    localObject = str;
    if (!PH(str))
    {
      i = paramdcg.mBH;
      paramdcg = paramdcg.DoR;
      d.g.b.k.g(paramdcg, "this.Uid");
      localObject = q.ax(i, paramdcg);
    }
    AppMethodBeat.o(6747);
    return localObject;
  }
  
  public static final boolean d(dcg paramdcg)
  {
    AppMethodBeat.i(6748);
    d.g.b.k.h(paramdcg, "$this$isZip");
    String str = c(paramdcg);
    int i = paramdcg.mBH;
    paramdcg = paramdcg.DoR;
    d.g.b.k.g(paramdcg, "this.Uid");
    boolean bool = d.g.b.k.g(str, q.ay(i, paramdcg));
    AppMethodBeat.o(6748);
    return bool;
  }
  
  public static final String e(dcg paramdcg)
  {
    AppMethodBeat.i(6750);
    d.g.b.k.h(paramdcg, "$this$keyStore");
    paramdcg = "_tmpl_info_-" + paramdcg.mBH + '-' + paramdcg.DoR;
    AppMethodBeat.o(6750);
    return paramdcg;
  }
  
  public static final String f(dcg paramdcg)
  {
    AppMethodBeat.i(6751);
    d.g.b.k.h(paramdcg, "$this$keyLatestVerified");
    paramdcg = "_tmpl_info_latest_verified_-" + paramdcg.mBH + '-' + paramdcg.EtL;
    AppMethodBeat.o(6751);
    return paramdcg;
  }
  
  public static final String g(dcg paramdcg)
  {
    AppMethodBeat.i(6752);
    d.g.b.k.h(paramdcg, "$this$keyLatestVerifiedTime");
    paramdcg = "_tmpl_info_latest_verified_time_-" + paramdcg.mBH + '-' + paramdcg.EtL;
    AppMethodBeat.o(6752);
    return paramdcg;
  }
  
  public static final String h(dcg paramdcg)
  {
    AppMethodBeat.i(6753);
    d.g.b.k.h(paramdcg, "$this$keyVersions");
    paramdcg = "_tmpl_info_version_list_-" + paramdcg.mBH + '-' + paramdcg.EtL;
    AppMethodBeat.o(6753);
    return paramdcg;
  }
  
  public static final boolean i(dcg paramdcg)
  {
    AppMethodBeat.i(6754);
    d.g.b.k.h(paramdcg, "$this$isLatestVerifiedExpired");
    boolean bool = as.ad(bDU().getLong(g(paramdcg), 0L), 3600000);
    AppMethodBeat.o(6754);
    return bool;
  }
  
  public static final String yh(int paramInt)
  {
    AppMethodBeat.i(6749);
    String str = "_tmpl_info_latest_responsed_-".concat(String.valueOf(paramInt));
    AppMethodBeat.o(6749);
    return str;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<Long>
  {
    public static final a neH;
    
    static
    {
      AppMethodBeat.i(6739);
      neH = new a();
      AppMethodBeat.o(6739);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.r
 * JD-Core Version:    0.7.0.1
 */