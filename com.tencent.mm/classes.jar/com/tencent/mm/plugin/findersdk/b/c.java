package com.tencent.mm.plugin.findersdk.b;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.findersdk.b.a.d;
import com.tencent.mm.plugin.findersdk.b.a.e;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.dyy;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "_Resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/plugin/findersdk/cgi/report/ICgiTrack;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "loadingComponent", "Lcom/tencent/mm/plugin/findersdk/cgi/DelayLoadingComponent;", "report", "Lcom/tencent/mm/plugin/findersdk/cgi/report/FinderCgiReport;", "getReport", "()Lcom/tencent/mm/plugin/findersdk/cgi/report/FinderCgiReport;", "report$delegate", "Lkotlin/Lazy;", "showErrorTips", "", "actionExt", "Lorg/json/JSONObject;", "cancel", "", "delayLoading", "context", "Landroid/content/Context;", "wording", "", "delay", "", "customLoadingComponent", "getCgiReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getCmdId", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "isFetchFeedCgi", "onCgiBack", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "(IILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "onCgiEnd", "resultExt", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "setShowErrorTips", "Companion", "finder-sdk_release"})
public abstract class c<_Resp extends dyy>
  extends com.tencent.mm.an.c<_Resp>
  implements e
{
  public static final a BvA = new a((byte)0);
  private static final String TAG = "Finder.FinderCgi";
  private static final SparseArray<Long> zWE = new SparseArray();
  public boolean Bvy;
  private final kotlin.f Bvz;
  protected final bid xbu;
  private b ywG;
  
  public c(bid parambid)
  {
    this.xbu = parambid;
    this.Bvy = true;
    this.Bvz = g.ar((kotlin.g.a.a)new b(this));
  }
  
  private final d enm()
  {
    return (d)this.Bvz.getValue();
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, _Resp param_Resp, com.tencent.mm.an.q paramq)
  {
    p.k(param_Resp, "resp");
    super.a(paramInt1, paramInt2, paramString, param_Resp, paramq);
    enm().enp();
    b localb = this.ywG;
    if (localb != null) {
      localb.end();
    }
    b(paramInt1, paramInt2, paramString, param_Resp, paramq);
    enm().enq();
    enm().b(paramInt1, paramInt2, paramString, bhU());
    if (this.Bvy)
    {
      param_Resp = com.tencent.mm.plugin.findersdk.c.a.Bwg;
      com.tencent.mm.plugin.findersdk.c.a.v(paramInt1, paramInt2, paramString);
      param_Resp = com.tencent.mm.plugin.findersdk.c.a.Bwg;
      com.tencent.mm.plugin.findersdk.c.a.w(paramInt1, paramInt2, paramString);
    }
  }
  
  public abstract void b(int paramInt1, int paramInt2, String paramString, _Resp param_Resp, com.tencent.mm.an.q paramq);
  
  public com.tencent.mm.cw.f<com.tencent.mm.an.c.a<_Resp>> bhW()
  {
    Object localObject;
    if (dnD())
    {
      localObject = this.xbu;
      if (localObject == null) {
        break label62;
      }
    }
    label62:
    for (int i = ((bid)localObject).xkX;; i = 0)
    {
      a.Px(i);
      localObject = this.ywG;
      if (localObject != null) {
        ((b)localObject).begin();
      }
      enm().h(bhU());
      localObject = super.bhW();
      p.j(localObject, "super.run()");
      return localObject;
    }
  }
  
  public final void cancel()
  {
    b localb = this.ywG;
    if (localb != null) {
      localb.end();
    }
    super.cancel();
  }
  
  public boolean dnD()
  {
    return false;
  }
  
  public com.tencent.mm.plugin.findersdk.b.a.b dnF()
  {
    return com.tencent.mm.plugin.findersdk.b.a.b.BvT;
  }
  
  public JSONObject dnI()
  {
    return null;
  }
  
  public JSONObject dnJ()
  {
    return null;
  }
  
  public final c<_Resp> e(Context paramContext, String paramString, long paramLong)
  {
    p.k(paramContext, "context");
    b.a locala = b.Bvw;
    this.ywG = b.a.d(paramContext, paramString, paramLong);
    return this;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi$Companion;", "", "()V", "TAG", "", "finderFeedCgiFetchTimeMap", "Landroid/util/SparseArray;", "", "getFeedCigFetchTime", "commentScene", "", "putFeedCgiFetchTime", "", "finder-sdk_release"})
  public static final class a
  {
    public static void Px(int paramInt)
    {
      AppMethodBeat.i(207740);
      c.enn().put(paramInt, Long.valueOf(cm.bfE()));
      AppMethodBeat.o(207740);
    }
    
    public static long Sh(int paramInt)
    {
      AppMethodBeat.i(207737);
      Long localLong = (Long)c.enn().get(paramInt);
      if (localLong != null)
      {
        long l = localLong.longValue();
        AppMethodBeat.o(207737);
        return l;
      }
      AppMethodBeat.o(207737);
      return 0L;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/findersdk/cgi/report/FinderCgiReport;", "_Resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<d>
  {
    b(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.b.c
 * JD-Core Version:    0.7.0.1
 */