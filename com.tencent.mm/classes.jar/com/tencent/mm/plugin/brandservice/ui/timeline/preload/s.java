package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dht;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.vfs.e;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.w;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"TAG", "", "TMPL_CONTROL_FLAG", "", "getTMPL_CONTROL_FLAG", "()J", "TMPL_CONTROL_FLAG$delegate", "Lkotlin/Lazy;", "kvTmpl", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvTmpl", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "basePath", "Lcom/tencent/mm/protocal/protobuf/TmplInfo;", "getBasePath", "(Lcom/tencent/mm/protocal/protobuf/TmplInfo;)Ljava/lang/String;", "indexPath", "getIndexPath", "isFileExists", "", "(Ljava/lang/String;)Z", "isLatestVerifiedExpired", "(Lcom/tencent/mm/protocal/protobuf/TmplInfo;)Z", "isValid", "isZip", "keyLatestResp", "", "getKeyLatestResp", "(I)Ljava/lang/String;", "keyLatestVerified", "getKeyLatestVerified", "keyLatestVerifiedMD5", "getKeyLatestVerifiedMD5", "keyLatestVerifiedTime", "getKeyLatestVerifiedTime", "keyStore", "getKeyStore", "keyVersions", "getKeyVersions", "getRelaunchState", "pidMM", "startMM", "pidMP", "startMP", "toFile", "Lcom/tencent/mm/vfs/VFSFile;", "plugin-brandservice_release"})
public final class s
{
  private static final String TAG = "MicroMsg.TmplInfoEx";
  private static final f nHr;
  
  static
  {
    AppMethodBeat.i(6740);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.s(w.g(s.class, "plugin-brandservice_release"), "TMPL_CONTROL_FLAG", "getTMPL_CONTROL_FLAG()J")) };
    TAG = "MicroMsg.TmplInfoEx";
    nHr = g.K((a)a.nHs);
    AppMethodBeat.o(6740);
  }
  
  public static final e TR(String paramString)
  {
    AppMethodBeat.i(6743);
    d.g.b.k.h(paramString, "$this$toFile");
    paramString = new e(paramString);
    AppMethodBeat.o(6743);
    return paramString;
  }
  
  public static final boolean TS(String paramString)
  {
    AppMethodBeat.i(6744);
    d.g.b.k.h(paramString, "$this$isFileExists");
    boolean bool = TR(paramString).exists();
    AppMethodBeat.o(6744);
    return bool;
  }
  
  public static final int a(int paramInt1, long paramLong1, int paramInt2, long paramLong2)
  {
    AppMethodBeat.i(6755);
    paramInt1 = (paramInt1 + '-' + paramLong1).hashCode();
    if (bLh().getInt("_tmpl_lastest_mm_open", 0) == paramInt1)
    {
      paramInt1 = (paramInt2 + '-' + paramLong2).hashCode();
      if (bLh().getInt("_tmpl_lastest_mp_open", 0) == paramInt1)
      {
        AppMethodBeat.o(6755);
        return 2;
      }
      bLh().putInt("_tmpl_lastest_mp_open", paramInt1);
      AppMethodBeat.o(6755);
      return 1;
    }
    bLh().putInt("_tmpl_lastest_mm_open", paramInt1);
    AppMethodBeat.o(6755);
    return 0;
  }
  
  public static final boolean a(dht paramdht)
  {
    AppMethodBeat.i(6745);
    d.g.b.k.h(paramdht, "$this$isValid");
    if (paramdht.Version != 0)
    {
      AppMethodBeat.o(6745);
      return true;
    }
    AppMethodBeat.o(6745);
    return false;
  }
  
  public static final String b(dht paramdht)
  {
    AppMethodBeat.i(6746);
    d.g.b.k.h(paramdht, "$this$basePath");
    int i = paramdht.ndI;
    Object localObject = paramdht.EJR;
    d.g.b.k.g(localObject, "this.Uid");
    String str = r.t(i, (String)localObject, "");
    localObject = str;
    if (!TS(str))
    {
      i = paramdht.ndI;
      paramdht = paramdht.EJR;
      d.g.b.k.g(paramdht, "this.Uid");
      localObject = r.ay(i, paramdht);
    }
    AppMethodBeat.o(6746);
    return localObject;
  }
  
  public static final long bLg()
  {
    AppMethodBeat.i(6741);
    long l = ((Number)nHr.getValue()).longValue();
    AppMethodBeat.o(6741);
    return l;
  }
  
  public static final aw bLh()
  {
    AppMethodBeat.i(6742);
    aw localaw = aw.aKT("_webview_tmpl_info");
    d.g.b.k.g(localaw, "MultiProcessMMKV.getMMKV…d.MMKV_WEBVIEW_TMPL_INFO)");
    AppMethodBeat.o(6742);
    return localaw;
  }
  
  public static final String c(dht paramdht)
  {
    AppMethodBeat.i(6747);
    d.g.b.k.h(paramdht, "$this$indexPath");
    int i = paramdht.ndI;
    Object localObject = paramdht.EJR;
    d.g.b.k.g(localObject, "this.Uid");
    String str = r.az(i, (String)localObject);
    localObject = str;
    if (!TS(str))
    {
      i = paramdht.ndI;
      paramdht = paramdht.EJR;
      d.g.b.k.g(paramdht, "this.Uid");
      localObject = r.ay(i, paramdht);
    }
    AppMethodBeat.o(6747);
    return localObject;
  }
  
  public static final boolean d(dht paramdht)
  {
    AppMethodBeat.i(6748);
    d.g.b.k.h(paramdht, "$this$isZip");
    String str = c(paramdht);
    int i = paramdht.ndI;
    paramdht = paramdht.EJR;
    d.g.b.k.g(paramdht, "this.Uid");
    boolean bool = d.g.b.k.g(str, r.az(i, paramdht));
    AppMethodBeat.o(6748);
    return bool;
  }
  
  public static final String e(dht paramdht)
  {
    AppMethodBeat.i(6750);
    d.g.b.k.h(paramdht, "$this$keyStore");
    paramdht = "_tmpl_info_-" + paramdht.ndI + '-' + paramdht.EJR;
    AppMethodBeat.o(6750);
    return paramdht;
  }
  
  public static final String f(dht paramdht)
  {
    AppMethodBeat.i(6751);
    d.g.b.k.h(paramdht, "$this$keyLatestVerified");
    paramdht = "_tmpl_info_latest_verified_-" + paramdht.ndI + '-' + paramdht.FQN;
    AppMethodBeat.o(6751);
    return paramdht;
  }
  
  public static final String g(dht paramdht)
  {
    AppMethodBeat.i(6752);
    d.g.b.k.h(paramdht, "$this$keyLatestVerifiedTime");
    paramdht = "_tmpl_info_latest_verified_time_-" + paramdht.ndI + '-' + paramdht.FQN;
    AppMethodBeat.o(6752);
    return paramdht;
  }
  
  public static final String h(dht paramdht)
  {
    AppMethodBeat.i(6753);
    d.g.b.k.h(paramdht, "$this$keyVersions");
    paramdht = "_tmpl_info_version_list_-" + paramdht.ndI + '-' + paramdht.FQN;
    AppMethodBeat.o(6753);
    return paramdht;
  }
  
  public static final boolean i(dht paramdht)
  {
    AppMethodBeat.i(6754);
    d.g.b.k.h(paramdht, "$this$isLatestVerifiedExpired");
    boolean bool = ar.ag(bLh().getLong(g(paramdht), 0L), 3600000);
    AppMethodBeat.o(6754);
    return bool;
  }
  
  public static final String yY(int paramInt)
  {
    AppMethodBeat.i(6749);
    String str = "_tmpl_info_latest_responsed_-".concat(String.valueOf(paramInt));
    AppMethodBeat.o(6749);
    return str;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<Long>
  {
    public static final a nHs;
    
    static
    {
      AppMethodBeat.i(6739);
      nHs = new a();
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