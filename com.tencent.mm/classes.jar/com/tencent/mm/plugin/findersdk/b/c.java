package com.tencent.mm.plugin.findersdk.b;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.cp.f;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.findersdk.b.a.d;
import com.tencent.mm.plugin.findersdk.b.a.e;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "_Resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lcom/tencent/mm/plugin/datapreloader/cgi/FutureCgi;", "", "Lcom/tencent/mm/plugin/findersdk/cgi/report/ICgiTrack;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "loadingComponent", "Lcom/tencent/mm/plugin/findersdk/cgi/DelayLoadingComponent;", "report", "Lcom/tencent/mm/plugin/findersdk/cgi/report/FinderCgiReport;", "getReport", "()Lcom/tencent/mm/plugin/findersdk/cgi/report/FinderCgiReport;", "report$delegate", "Lkotlin/Lazy;", "showErrorTips", "", "tag", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "actionExt", "Lorg/json/JSONObject;", "cancel", "", "delayLoading", "context", "Landroid/content/Context;", "wording", "delay", "", "customLoadingComponent", "getCgiReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getCmdId", "", "getFunId", "getKey", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "isFetchFeedCgi", "onCgiBack", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "(IILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "onCgiEnd", "resultExt", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "setShowErrorTips", "Companion", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class c<_Resp extends esc>
  extends com.tencent.mm.plugin.datapreloader.b.b<String, _Resp>
  implements e
{
  private static final SparseArray<Long> Fsf = new SparseArray();
  public static final a HcH = new a((byte)0);
  private static final String TAG = "Finder.FinderCgi";
  protected final bui Auc;
  private b DiB;
  public boolean HcI;
  private final j HcJ;
  private String tag;
  
  public c(bui parambui)
  {
    this.Auc = parambui;
    this.tag = "";
    this.HcI = true;
    this.HcJ = k.cm((kotlin.g.a.a)new b(this));
  }
  
  private final d frV()
  {
    return (d)this.HcJ.getValue();
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, _Resp param_Resp, p paramp)
  {
    s.u(param_Resp, "resp");
    super.a(paramInt1, paramInt2, paramString, param_Resp, paramp);
    frV().frZ();
    b localb = this.DiB;
    if (localb != null) {
      localb.end();
    }
    b(paramInt1, paramInt2, paramString, param_Resp, paramp);
    frV().fsa();
    frV().b(paramInt1, paramInt2, paramString, this.rr);
    if (this.HcI)
    {
      param_Resp = com.tencent.mm.plugin.findersdk.d.a.Hdr;
      com.tencent.mm.plugin.findersdk.d.a.z(paramInt1, paramInt2, paramString);
      param_Resp = com.tencent.mm.plugin.findersdk.d.a.Hdr;
      com.tencent.mm.plugin.findersdk.d.a.A(paramInt1, paramInt2, paramString);
    }
  }
  
  public abstract void b(int paramInt1, int paramInt2, String paramString, _Resp param_Resp, p paramp);
  
  public f<com.tencent.mm.am.b.a<_Resp>> bFJ()
  {
    Object localObject = this.DiB;
    if (localObject != null) {
      ((b)localObject).begin();
    }
    Log.i(TAG, s.X("[dispatchCgi] ", frW().getUri()));
    if (dVg())
    {
      localObject = this.Auc;
      if (localObject != null) {
        break label77;
      }
    }
    label77:
    for (int i = 0;; i = ((bui)localObject).AJo)
    {
      a.SB(i);
      frV().h(this.rr);
      localObject = super.bFJ();
      s.s(localObject, "super.run()");
      return localObject;
    }
  }
  
  public final void cancel()
  {
    b localb = this.DiB;
    if (localb != null) {
      localb.end();
    }
    super.cancel();
  }
  
  public boolean dVg()
  {
    return false;
  }
  
  public com.tencent.mm.plugin.findersdk.b.a.b dVi()
  {
    return com.tencent.mm.plugin.findersdk.b.a.b.Hdd;
  }
  
  public JSONObject dVk()
  {
    return null;
  }
  
  public JSONObject dVl()
  {
    return null;
  }
  
  public final c<_Resp> e(Context paramContext, String paramString, long paramLong)
  {
    s.u(paramContext, "context");
    b.a locala = b.HcE;
    this.DiB = b.a.d(paramContext, paramString, paramLong);
    return this;
  }
  
  public final com.tencent.mm.am.c frW()
  {
    com.tencent.mm.am.c localc = this.rr;
    s.s(localc, "reqResp");
    return localc;
  }
  
  public String getKey()
  {
    return String.valueOf(this.rr.getType());
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi$Companion;", "", "()V", "TAG", "", "finderFeedCgiFetchTimeMap", "Landroid/util/SparseArray;", "", "getFeedCigFetchTime", "commentScene", "", "putFeedCgiFetchTime", "", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void SB(int paramInt)
    {
      AppMethodBeat.i(273869);
      c.frX().put(paramInt, Long.valueOf(cn.bDw()));
      AppMethodBeat.o(273869);
    }
    
    public static long VA(int paramInt)
    {
      AppMethodBeat.i(273860);
      Long localLong = (Long)c.frX().get(paramInt);
      if (localLong == null)
      {
        AppMethodBeat.o(273860);
        return 0L;
      }
      long l = localLong.longValue();
      AppMethodBeat.o(273860);
      return l;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/findersdk/cgi/report/FinderCgiReport;", "_Resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<d>
  {
    b(c<_Resp> paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.b.c
 * JD-Core Version:    0.7.0.1
 */