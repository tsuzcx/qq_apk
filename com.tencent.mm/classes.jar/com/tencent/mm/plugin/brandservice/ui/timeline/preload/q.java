package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fnm;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"TAG", "", "TMPL_CONTROL_FLAG", "", "getTMPL_CONTROL_FLAG", "()J", "TMPL_CONTROL_FLAG$delegate", "Lkotlin/Lazy;", "kvTmpl", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvTmpl", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "basePath", "Lcom/tencent/mm/protocal/protobuf/TmplInfo;", "getBasePath", "(Lcom/tencent/mm/protocal/protobuf/TmplInfo;)Ljava/lang/String;", "indexPath", "getIndexPath", "isFileExists", "", "(Ljava/lang/String;)Z", "isFileValid", "isLatestVerifiedExpired", "(Lcom/tencent/mm/protocal/protobuf/TmplInfo;)Z", "isValid", "isZip", "keyLatestResp", "", "getKeyLatestResp", "(I)Ljava/lang/String;", "keyLatestVerified", "getKeyLatestVerified", "keyLatestVerifiedMD5", "getKeyLatestVerifiedMD5", "keyLatestVerifiedTime", "getKeyLatestVerifiedTime", "keyStore", "getKeyStore", "keyVersions", "getKeyVersions", "getRelaunchState", "pidMM", "startMM", "pidMP", "startMP", "toFile", "Lcom/tencent/mm/vfs/VFSFile;", "plugin-brandservice_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class q
{
  private static final String TAG;
  private static final j vTd;
  
  static
  {
    AppMethodBeat.i(6740);
    TAG = "MicroMsg.TmplInfoEx";
    vTd = k.cm((a)a.vTe);
    AppMethodBeat.o(6740);
  }
  
  public static final String HF(int paramInt)
  {
    AppMethodBeat.i(6749);
    String str = s.X("_tmpl_info_latest_responsed_-", Integer.valueOf(paramInt));
    AppMethodBeat.o(6749);
    return str;
  }
  
  public static final int a(int paramInt1, long paramLong1, int paramInt2, long paramLong2)
  {
    AppMethodBeat.i(6755);
    paramInt1 = (paramInt1 + '-' + paramLong1).hashCode();
    if (dfF().getInt("_tmpl_lastest_mm_open", 0) == paramInt1)
    {
      paramInt1 = (paramInt2 + '-' + paramLong2).hashCode();
      if (dfF().getInt("_tmpl_lastest_mp_open", 0) == paramInt1)
      {
        AppMethodBeat.o(6755);
        return 2;
      }
      dfF().putInt("_tmpl_lastest_mp_open", paramInt1);
      AppMethodBeat.o(6755);
      return 1;
    }
    dfF().putInt("_tmpl_lastest_mm_open", paramInt1);
    AppMethodBeat.o(6755);
    return 0;
  }
  
  public static final boolean a(fnm paramfnm)
  {
    AppMethodBeat.i(6745);
    s.u(paramfnm, "<this>");
    if (paramfnm.crz != 0)
    {
      AppMethodBeat.o(6745);
      return true;
    }
    AppMethodBeat.o(6745);
    return false;
  }
  
  public static final boolean ajA(String paramString)
  {
    AppMethodBeat.i(6744);
    s.u(paramString, "<this>");
    boolean bool = ajz(paramString).jKS();
    AppMethodBeat.o(6744);
    return bool;
  }
  
  public static final com.tencent.mm.vfs.u ajz(String paramString)
  {
    AppMethodBeat.i(6743);
    s.u(paramString, "<this>");
    paramString = new com.tencent.mm.vfs.u(paramString);
    AppMethodBeat.o(6743);
    return paramString;
  }
  
  public static final String b(fnm paramfnm)
  {
    AppMethodBeat.i(6746);
    s.u(paramfnm, "<this>");
    int i = paramfnm.vhJ;
    Object localObject = paramfnm.aalQ;
    s.s(localObject, "this.Uid");
    String str = p.x(i, (String)localObject, "");
    localObject = str;
    if (!ajA(str))
    {
      i = paramfnm.vhJ;
      paramfnm = paramfnm.aalQ;
      s.s(paramfnm, "this.Uid");
      localObject = p.aU(i, paramfnm);
    }
    AppMethodBeat.o(6746);
    return localObject;
  }
  
  public static final String c(fnm paramfnm)
  {
    AppMethodBeat.i(6747);
    s.u(paramfnm, "<this>");
    int i = paramfnm.vhJ;
    Object localObject = paramfnm.aalQ;
    s.s(localObject, "this.Uid");
    String str = p.aV(i, (String)localObject);
    localObject = str;
    if (!ajA(str))
    {
      i = paramfnm.vhJ;
      paramfnm = paramfnm.aalQ;
      s.s(paramfnm, "this.Uid");
      localObject = p.aU(i, paramfnm);
    }
    AppMethodBeat.o(6747);
    return localObject;
  }
  
  public static final boolean d(fnm paramfnm)
  {
    AppMethodBeat.i(6748);
    s.u(paramfnm, "<this>");
    String str = c(paramfnm);
    int i = paramfnm.vhJ;
    paramfnm = paramfnm.aalQ;
    s.s(paramfnm, "this.Uid");
    boolean bool = s.p(str, p.aV(i, paramfnm));
    AppMethodBeat.o(6748);
    return bool;
  }
  
  public static final long dfE()
  {
    AppMethodBeat.i(6741);
    long l = ((Number)vTd.getValue()).longValue();
    AppMethodBeat.o(6741);
    return l;
  }
  
  public static final MultiProcessMMKV dfF()
  {
    AppMethodBeat.i(6742);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("_webview_tmpl_info");
    s.s(localMultiProcessMMKV, "getMMKV(ConstantsPreload.MMKV_WEBVIEW_TMPL_INFO)");
    AppMethodBeat.o(6742);
    return localMultiProcessMMKV;
  }
  
  public static final String e(fnm paramfnm)
  {
    AppMethodBeat.i(6750);
    s.u(paramfnm, "<this>");
    paramfnm = "_tmpl_info_-" + paramfnm.vhJ + '-' + paramfnm.aalQ;
    AppMethodBeat.o(6750);
    return paramfnm;
  }
  
  public static final String f(fnm paramfnm)
  {
    AppMethodBeat.i(6751);
    s.u(paramfnm, "<this>");
    paramfnm = "_tmpl_info_latest_verified_-" + paramfnm.vhJ + '-' + paramfnm.abNx;
    AppMethodBeat.o(6751);
    return paramfnm;
  }
  
  public static final String g(fnm paramfnm)
  {
    AppMethodBeat.i(6752);
    s.u(paramfnm, "<this>");
    paramfnm = "_tmpl_info_latest_verified_time_-" + paramfnm.vhJ + '-' + paramfnm.abNx;
    AppMethodBeat.o(6752);
    return paramfnm;
  }
  
  public static final String h(fnm paramfnm)
  {
    AppMethodBeat.i(6753);
    s.u(paramfnm, "<this>");
    paramfnm = "_tmpl_info_version_list_-" + paramfnm.vhJ + '-' + paramfnm.abNx;
    AppMethodBeat.o(6753);
    return paramfnm;
  }
  
  public static final boolean i(fnm paramfnm)
  {
    AppMethodBeat.i(6754);
    s.u(paramfnm, "<this>");
    boolean bool = MMSlotKt.isExpire(dfF().getLong(g(paramfnm), 0L), 3600000);
    AppMethodBeat.o(6754);
    return bool;
  }
  
  public static final boolean isFileValid(String paramString)
  {
    AppMethodBeat.i(303240);
    s.u(paramString, "<this>");
    paramString = ajz(paramString);
    if (paramString.isDirectory())
    {
      if (paramString.jKS())
      {
        paramString = paramString.jKX();
        if (paramString != null)
        {
          if (paramString.length != 0) {
            break label65;
          }
          i = 1;
          if (i == 0) {
            break label70;
          }
        }
        label65:
        label70:
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label75;
          }
          AppMethodBeat.o(303240);
          return true;
          i = 0;
          break;
        }
      }
      label75:
      AppMethodBeat.o(303240);
      return false;
    }
    boolean bool = paramString.jKS();
    AppMethodBeat.o(303240);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements a<Long>
  {
    public static final a vTe;
    
    static
    {
      AppMethodBeat.i(6739);
      vTe = new a();
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