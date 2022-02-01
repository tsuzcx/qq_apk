package com.tencent.mm.plugin.findersdk.b;

import android.content.Context;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.findersdk.b.a.e;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "Lcom/tencent/mm/plugin/findersdk/cgi/report/ICgiTrack;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "loadingComponent", "Lcom/tencent/mm/plugin/findersdk/cgi/DelayLoadingComponent;", "report", "Lcom/tencent/mm/plugin/findersdk/cgi/report/FinderCgiReport;", "getReport", "()Lcom/tencent/mm/plugin/findersdk/cgi/report/FinderCgiReport;", "report$delegate", "Lkotlin/Lazy;", "timeout", "", "timeoutCallback", "Lkotlin/Function0;", "", "timeoutTask", "Lcom/tencent/threadpool/runnable/FutureEx;", "actionExt", "Lorg/json/JSONObject;", "cancel", "delayLoading", "context", "Landroid/content/Context;", "wording", "", "delay", "", "customLoadingComponent", "dispatch", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "rr", "Lcom/tencent/mm/network/IReqResp;", "callback", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "isFetchFeedCgi", "", "onCgiEnd", "netId", "errType", "errCode", "errMsg", "cookie", "", "onGYNetEnd", "resultExt", "setTimeOut", "timeoutLogic", "Companion", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class h
  extends p
  implements m, e
{
  public static final a HcN = new a((byte)0);
  private static final String TAG = "Finder.NetSceneFinderBase";
  private final bui Auc;
  private b DiB;
  private final j HcJ;
  private com.tencent.threadpool.i.d<?> HcO;
  private kotlin.g.a.a<ah> HcP;
  private int timeout;
  
  public h(bui parambui)
  {
    this.Auc = parambui;
    this.HcJ = k.cm((kotlin.g.a.a)new b(this));
    parambui = this.Auc;
    if (parambui != null)
    {
      Log.i(TAG, "Create commentScene:" + parambui.AJo + " fromCommentScene:" + parambui.hLK);
      frV().hLK = parambui.hLK;
    }
  }
  
  private static final void a(h paramh)
  {
    kotlin.g.b.s.u(paramh, "this$0");
    paramh.cancel();
    paramh.HcO = null;
    Log.i(TAG, "time out!");
    paramh = paramh.HcP;
    if (paramh != null) {
      paramh.invoke();
    }
  }
  
  private final com.tencent.mm.plugin.findersdk.b.a.d frV()
  {
    return (com.tencent.mm.plugin.findersdk.b.a.d)this.HcJ.getValue();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params) {}
  
  public void cancel()
  {
    b localb = this.DiB;
    if (localb != null) {
      localb.end();
    }
    super.cancel();
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
  
  public int dispatch(g paramg, com.tencent.mm.network.s params, m paramm)
  {
    Object localObject1 = this.DiB;
    if (localObject1 != null) {
      ((b)localObject1).begin();
    }
    Object localObject2 = TAG;
    if (params == null)
    {
      localObject1 = null;
      Log.i((String)localObject2, kotlin.g.b.s.X("[dispatchCgi] ", localObject1));
      localObject2 = frV();
      if (!(params instanceof com.tencent.mm.am.c)) {
        break label180;
      }
      localObject1 = (com.tencent.mm.am.c)params;
      label59:
      ((com.tencent.mm.plugin.findersdk.b.a.d)localObject2).h((com.tencent.mm.am.c)localObject1);
      localObject1 = c.HcH;
      localObject1 = this.Auc;
      if (localObject1 != null) {
        break label186;
      }
    }
    label180:
    label186:
    for (int i = 0;; i = ((bui)localObject1).AJo)
    {
      c.a.SB(i);
      localObject1 = this.HcO;
      if (localObject1 != null) {
        ((com.tencent.threadpool.i.d)localObject1).cancel(false);
      }
      if (this.timeout > 0)
      {
        Log.i(TAG, kotlin.g.b.s.X("time out:", Integer.valueOf(this.timeout)));
        this.HcO = com.tencent.threadpool.h.ahAA.p(new h..ExternalSyntheticLambda0(this), this.timeout);
      }
      return super.dispatch(paramg, params, paramm);
      localObject1 = params.getUri();
      break;
      localObject1 = null;
      break label59;
    }
  }
  
  public final h f(Context paramContext, String paramString, long paramLong)
  {
    kotlin.g.b.s.u(paramContext, "context");
    b.a locala = b.HcE;
    this.DiB = b.a.d(paramContext, paramString, paramLong);
    return this;
  }
  
  public final bui getContextObj()
  {
    return this.Auc;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    frV().frZ();
    paramArrayOfByte = this.DiB;
    if (paramArrayOfByte != null) {
      paramArrayOfByte.end();
    }
    paramArrayOfByte = this.HcO;
    if (paramArrayOfByte != null) {
      paramArrayOfByte.cancel(false);
    }
    paramArrayOfByte = com.tencent.mm.plugin.findersdk.d.a.Hdr;
    com.tencent.mm.plugin.findersdk.d.a.z(paramInt2, paramInt3, paramString);
    paramArrayOfByte = com.tencent.mm.plugin.findersdk.d.a.Hdr;
    com.tencent.mm.plugin.findersdk.d.a.A(paramInt2, paramInt3, paramString);
    a(paramInt1, paramInt2, paramInt3, paramString, params);
    frV().fsa();
    paramArrayOfByte = frV();
    if ((params instanceof com.tencent.mm.am.c)) {}
    for (params = (com.tencent.mm.am.c)params;; params = null)
    {
      paramArrayOfByte.b(paramInt2, paramInt3, paramString, params);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase$Companion;", "", "()V", "TAG", "", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/findersdk/cgi/report/FinderCgiReport;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.findersdk.b.a.d>
  {
    b(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.b.h
 * JD-Core Version:    0.7.0.1
 */