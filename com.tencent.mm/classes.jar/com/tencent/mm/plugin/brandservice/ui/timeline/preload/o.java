package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.f;
import a.f.a.a;
import a.f.b.j;
import a.f.b.r;
import a.f.b.v;
import a.g;
import a.j.k;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ckj;
import com.tencent.mm.sdk.platformtools.as;
import java.io.File;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"TAG", "", "TMPL_CONTROL_FLAG", "", "getTMPL_CONTROL_FLAG", "()J", "TMPL_CONTROL_FLAG$delegate", "Lkotlin/Lazy;", "kvTmpl", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvTmpl", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "basePath", "Lcom/tencent/mm/protocal/protobuf/TmplInfo;", "getBasePath", "(Lcom/tencent/mm/protocal/protobuf/TmplInfo;)Ljava/lang/String;", "indexPath", "getIndexPath", "isFileExists", "", "(Ljava/lang/String;)Z", "isLatestVerifiedExpired", "(Lcom/tencent/mm/protocal/protobuf/TmplInfo;)Z", "isValid", "isZip", "keyLatestResp", "", "getKeyLatestResp", "(I)Ljava/lang/String;", "keyLatestVerified", "getKeyLatestVerified", "keyLatestVerifiedMD5", "getKeyLatestVerifiedMD5", "keyLatestVerifiedTime", "getKeyLatestVerifiedTime", "keyStore", "getKeyStore", "keyVersions", "getKeyVersions", "getRelaunchState", "pidMM", "startMM", "pidMP", "startMP", "toFile", "Ljava/io/File;", "plugin-brandservice_release"})
public final class o
{
  private static final String TAG = "MicroMsg.TmplInfoEx";
  private static final f kcv;
  
  static
  {
    AppMethodBeat.i(14955);
    eOJ = new k[] { (k)v.a(new r(v.i(o.class, "plugin-brandservice_release"), "TMPL_CONTROL_FLAG", "getTMPL_CONTROL_FLAG()J")) };
    TAG = "MicroMsg.TmplInfoEx";
    kcv = g.j((a)o.a.kcw);
    AppMethodBeat.o(14955);
  }
  
  public static final File GZ(String paramString)
  {
    AppMethodBeat.i(14958);
    j.q(paramString, "receiver$0");
    paramString = new File(paramString);
    AppMethodBeat.o(14958);
    return paramString;
  }
  
  public static final boolean Ha(String paramString)
  {
    AppMethodBeat.i(14959);
    j.q(paramString, "receiver$0");
    boolean bool = GZ(paramString).exists();
    AppMethodBeat.o(14959);
    return bool;
  }
  
  public static final int a(int paramInt1, long paramLong1, int paramInt2, long paramLong2)
  {
    AppMethodBeat.i(14970);
    paramInt1 = (paramInt1 + '-' + paramLong1).hashCode();
    if (aXO().getInt("_tmpl_lastest_mm_open", 0) == paramInt1)
    {
      paramInt1 = (paramInt2 + '-' + paramLong2).hashCode();
      if (aXO().getInt("_tmpl_lastest_mp_open", 0) == paramInt1)
      {
        AppMethodBeat.o(14970);
        return 2;
      }
      aXO().putInt("_tmpl_lastest_mp_open", paramInt1);
      AppMethodBeat.o(14970);
      return 1;
    }
    aXO().putInt("_tmpl_lastest_mm_open", paramInt1);
    AppMethodBeat.o(14970);
    return 0;
  }
  
  public static final boolean a(ckj paramckj)
  {
    AppMethodBeat.i(14960);
    j.q(paramckj, "receiver$0");
    if (paramckj.Version != 0)
    {
      AppMethodBeat.o(14960);
      return true;
    }
    AppMethodBeat.o(14960);
    return false;
  }
  
  public static final long aXN()
  {
    AppMethodBeat.i(14956);
    long l = ((Number)kcv.getValue()).longValue();
    AppMethodBeat.o(14956);
    return l;
  }
  
  public static final as aXO()
  {
    AppMethodBeat.i(14957);
    as localas = as.eu("_webview_tmpl_info", 2);
    j.p(localas, "MultiProcessMMKV.getMMKV… MMKV.MULTI_PROCESS_MODE)");
    AppMethodBeat.o(14957);
    return localas;
  }
  
  public static final String b(ckj paramckj)
  {
    AppMethodBeat.i(14961);
    j.q(paramckj, "receiver$0");
    int i = paramckj.jKs;
    Object localObject = paramckj.wXS;
    j.p(localObject, "this.Uid");
    String str = n.q(i, (String)localObject, "");
    localObject = str;
    if (!Ha(str))
    {
      i = paramckj.jKs;
      paramckj = paramckj.wXS;
      j.p(paramckj, "this.Uid");
      localObject = n.ak(i, paramckj);
    }
    AppMethodBeat.o(14961);
    return localObject;
  }
  
  public static final String c(ckj paramckj)
  {
    AppMethodBeat.i(14962);
    j.q(paramckj, "receiver$0");
    int i = paramckj.jKs;
    Object localObject = paramckj.wXS;
    j.p(localObject, "this.Uid");
    String str = n.al(i, (String)localObject);
    localObject = str;
    if (!Ha(str))
    {
      i = paramckj.jKs;
      paramckj = paramckj.wXS;
      j.p(paramckj, "this.Uid");
      localObject = n.ak(i, paramckj);
    }
    AppMethodBeat.o(14962);
    return localObject;
  }
  
  public static final boolean d(ckj paramckj)
  {
    AppMethodBeat.i(14963);
    j.q(paramckj, "receiver$0");
    String str = c(paramckj);
    int i = paramckj.jKs;
    paramckj = paramckj.wXS;
    j.p(paramckj, "this.Uid");
    boolean bool = j.e(str, n.al(i, paramckj));
    AppMethodBeat.o(14963);
    return bool;
  }
  
  public static final String e(ckj paramckj)
  {
    AppMethodBeat.i(14965);
    j.q(paramckj, "receiver$0");
    paramckj = "_tmpl_info_-" + paramckj.jKs + '-' + paramckj.wXS;
    AppMethodBeat.o(14965);
    return paramckj;
  }
  
  public static final String f(ckj paramckj)
  {
    AppMethodBeat.i(14966);
    j.q(paramckj, "receiver$0");
    paramckj = "_tmpl_info_latest_verified_-" + paramckj.jKs + '-' + paramckj.xUp;
    AppMethodBeat.o(14966);
    return paramckj;
  }
  
  public static final String g(ckj paramckj)
  {
    AppMethodBeat.i(14967);
    j.q(paramckj, "receiver$0");
    paramckj = "_tmpl_info_latest_verified_time_-" + paramckj.jKs + '-' + paramckj.xUp;
    AppMethodBeat.o(14967);
    return paramckj;
  }
  
  public static final String h(ckj paramckj)
  {
    AppMethodBeat.i(14968);
    j.q(paramckj, "receiver$0");
    paramckj = "_tmpl_info_version_list_-" + paramckj.jKs + '-' + paramckj.xUp;
    AppMethodBeat.o(14968);
    return paramckj;
  }
  
  public static final boolean i(ckj paramckj)
  {
    AppMethodBeat.i(14969);
    j.q(paramckj, "receiver$0");
    boolean bool = d.E(aXO().getLong(g(paramckj), 0L), 3600000L);
    AppMethodBeat.o(14969);
    return bool;
  }
  
  public static final String sr(int paramInt)
  {
    AppMethodBeat.i(14964);
    String str = "_tmpl_info_latest_responsed_-".concat(String.valueOf(paramInt));
    AppMethodBeat.o(14964);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.o
 * JD-Core Version:    0.7.0.1
 */