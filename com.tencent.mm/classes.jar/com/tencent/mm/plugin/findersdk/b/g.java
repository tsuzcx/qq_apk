package com.tencent.mm.plugin.findersdk.b;

import android.content.Context;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.findersdk.b.a.e;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "Lcom/tencent/mm/plugin/findersdk/cgi/report/ICgiTrack;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "loadingComponent", "Lcom/tencent/mm/plugin/findersdk/cgi/DelayLoadingComponent;", "report", "Lcom/tencent/mm/plugin/findersdk/cgi/report/FinderCgiReport;", "getReport", "()Lcom/tencent/mm/plugin/findersdk/cgi/report/FinderCgiReport;", "report$delegate", "Lkotlin/Lazy;", "timeout", "", "timeoutCallback", "Lkotlin/Function0;", "", "timeoutTask", "Lcom/tencent/threadpool/runnable/FutureEx;", "actionExt", "Lorg/json/JSONObject;", "cancel", "delayLoading", "context", "Landroid/content/Context;", "wording", "", "delay", "", "customLoadingComponent", "dispatch", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "rr", "Lcom/tencent/mm/network/IReqResp;", "callback", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "isFetchFeedCgi", "", "onCgiEnd", "netId", "errType", "errCode", "errMsg", "cookie", "", "onGYNetEnd", "resultExt", "setTimeOut", "timeoutLogic", "Companion", "finder-sdk_release"})
public abstract class g
  extends com.tencent.mm.an.q
  implements m, e
{
  public static final a BvE = new a((byte)0);
  private static final String TAG = "Finder.NetSceneFinderBase";
  private com.tencent.e.i.d<?> BvC;
  private kotlin.g.a.a<x> BvD;
  private final f Bvz;
  private int timeout;
  public final bid xbu;
  private b ywG;
  
  public g(bid parambid)
  {
    this.xbu = parambid;
    this.Bvz = kotlin.g.ar((kotlin.g.a.a)new b(this));
    parambid = this.xbu;
    if (parambid != null)
    {
      Log.i(TAG, "Create commentScene:" + parambid.xkX + " fromCommentScene:" + parambid.fGo);
      enm().fGo = parambid.fGo;
    }
  }
  
  private final com.tencent.mm.plugin.findersdk.b.a.d enm()
  {
    return (com.tencent.mm.plugin.findersdk.b.a.d)this.Bvz.getValue();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params) {}
  
  public void cancel()
  {
    b localb = this.ywG;
    if (localb != null) {
      localb.end();
    }
    super.cancel();
  }
  
  public int dispatch(com.tencent.mm.network.g paramg, s params, m paramm)
  {
    Object localObject = this.ywG;
    if (localObject != null) {
      ((b)localObject).begin();
    }
    com.tencent.mm.plugin.findersdk.b.a.d locald = enm();
    if (!(params instanceof com.tencent.mm.an.d)) {}
    for (localObject = null;; localObject = params)
    {
      locald.h((com.tencent.mm.an.d)localObject);
      localObject = c.BvA;
      localObject = this.xbu;
      if (localObject != null) {}
      for (int i = ((bid)localObject).xkX;; i = 0)
      {
        c.a.Px(i);
        localObject = this.BvC;
        if (localObject != null) {
          ((com.tencent.e.i.d)localObject).cancel(false);
        }
        if (this.timeout > 0)
        {
          Log.i(TAG, "time out:" + this.timeout);
          this.BvC = h.ZvG.o((Runnable)new c(this), this.timeout);
        }
        return super.dispatch(paramg, params, paramm);
      }
    }
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
  
  public final g f(Context paramContext, String paramString, long paramLong)
  {
    p.k(paramContext, "context");
    b.a locala = b.Bvw;
    this.ywG = b.a.d(paramContext, paramString, paramLong);
    return this;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    enm().enp();
    paramArrayOfByte = this.ywG;
    if (paramArrayOfByte != null) {
      paramArrayOfByte.end();
    }
    paramArrayOfByte = this.BvC;
    if (paramArrayOfByte != null) {
      paramArrayOfByte.cancel(false);
    }
    paramArrayOfByte = com.tencent.mm.plugin.findersdk.c.a.Bwg;
    com.tencent.mm.plugin.findersdk.c.a.v(paramInt2, paramInt3, paramString);
    paramArrayOfByte = com.tencent.mm.plugin.findersdk.c.a.Bwg;
    com.tencent.mm.plugin.findersdk.c.a.w(paramInt2, paramInt3, paramString);
    a(paramInt1, paramInt2, paramInt3, paramString, params);
    enm().enq();
    paramArrayOfByte = enm();
    if (!(params instanceof com.tencent.mm.an.d)) {
      params = null;
    }
    for (;;)
    {
      paramArrayOfByte.b(paramInt2, paramInt3, paramString, (com.tencent.mm.an.d)params);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase$Companion;", "", "()V", "TAG", "", "finder-sdk_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/findersdk/cgi/report/FinderCgiReport;", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<com.tencent.mm.plugin.findersdk.b.a.d>
  {
    b(g paramg)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(g paramg) {}
    
    public final void run()
    {
      AppMethodBeat.i(207537);
      this.BvF.cancel();
      g.a(this.BvF);
      Log.i(g.access$getTAG$cp(), "time out!");
      kotlin.g.a.a locala = g.b(this.BvF);
      if (locala != null)
      {
        locala.invoke();
        AppMethodBeat.o(207537);
        return;
      }
      AppMethodBeat.o(207537);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.b.g
 * JD-Core Version:    0.7.0.1
 */