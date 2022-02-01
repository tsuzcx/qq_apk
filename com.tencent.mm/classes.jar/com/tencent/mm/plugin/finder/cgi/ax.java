package com.tencent.mm.plugin.finder.cgi;

import android.content.Context;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.cgi.report.e;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.utils.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "Lcom/tencent/mm/plugin/finder/cgi/report/ICgiTrack;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "loadingComponent", "Lcom/tencent/mm/plugin/finder/utils/DelayLoadingComponent;", "report", "Lcom/tencent/mm/plugin/finder/cgi/report/FinderCgiReport;", "getReport", "()Lcom/tencent/mm/plugin/finder/cgi/report/FinderCgiReport;", "report$delegate", "Lkotlin/Lazy;", "timeout", "", "timeoutCallback", "Lkotlin/Function0;", "", "timeoutTask", "Lcom/tencent/threadpool/runnable/FutureEx;", "actionExt", "Lorg/json/JSONObject;", "cancel", "delayLoading", "context", "Landroid/content/Context;", "wording", "delay", "", "customLoadingComponent", "dispatch", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "rr", "Lcom/tencent/mm/network/IReqResp;", "callback", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "isFetchFeedCgi", "", "onCgiEnd", "netId", "errType", "errCode", "errMsg", "cookie", "", "onGYNetEnd", "resultExt", "setTimeOut", "timeoutLogic", "updateFeedSessionBuffer", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "plugin-finder_release"})
public abstract class ax
  extends com.tencent.mm.ak.q
  implements m, e
{
  final String TAG;
  private int timeout;
  public final bbn ttO;
  com.tencent.f.i.d<?> tuR;
  kotlin.g.a.a<x> tuS;
  private com.tencent.mm.plugin.finder.utils.b tux;
  private final f tuz;
  
  public ax(bbn parambbn)
  {
    this.ttO = parambbn;
    this.TAG = "Finder.NetSceneFinderBase";
    this.tuz = kotlin.g.ah((kotlin.g.a.a)new a(this));
    if (cXQ())
    {
      parambbn = k.vfA;
      parambbn = this.ttO;
      if (parambbn == null) {
        break label121;
      }
    }
    label121:
    for (int i = parambbn.tCE;; i = 0)
    {
      k.Ku(i);
      parambbn = this.ttO;
      if (parambbn != null)
      {
        Log.i(this.TAG, "Create commentScene:" + parambbn.tCE + " fromCommentScene:" + parambbn.tyh);
        cYa().tyh = parambbn.tyh;
      }
      return;
    }
  }
  
  private final com.tencent.mm.plugin.finder.cgi.report.d cYa()
  {
    return (com.tencent.mm.plugin.finder.cgi.report.d)this.tuz.getValue();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params) {}
  
  public boolean cXQ()
  {
    return false;
  }
  
  public com.tencent.mm.plugin.finder.cgi.report.b cXS()
  {
    return com.tencent.mm.plugin.finder.cgi.report.b.tyd;
  }
  
  public JSONObject cXV()
  {
    return null;
  }
  
  public JSONObject cXW()
  {
    return null;
  }
  
  public void cancel()
  {
    com.tencent.mm.plugin.finder.utils.b localb = this.tux;
    if (localb != null) {
      localb.end();
    }
    super.cancel();
  }
  
  public final ax d(Context paramContext, String paramString, long paramLong)
  {
    p.h(paramContext, "context");
    b.a locala = com.tencent.mm.plugin.finder.utils.b.vVa;
    this.tux = b.a.e(paramContext, paramString, paramLong);
    return this;
  }
  
  public final void d(FinderObject paramFinderObject)
  {
    p.h(paramFinderObject, "finderObject");
    Object localObject = this.ttO;
    k localk;
    if (localObject != null)
    {
      localk = k.vfA;
      k.e(paramFinderObject.id, ((bbn)localObject).tCE, paramFinderObject.sessionBuffer);
    }
    paramFinderObject = paramFinderObject.foldedLayout;
    if (paramFinderObject != null)
    {
      paramFinderObject = paramFinderObject.LCW;
      if (paramFinderObject != null)
      {
        paramFinderObject = ((Iterable)paramFinderObject).iterator();
        while (paramFinderObject.hasNext())
        {
          localObject = (FinderObject)paramFinderObject.next();
          localk = k.vfA;
          k.e(((FinderObject)localObject).id, 14, ((FinderObject)localObject).sessionBuffer);
        }
      }
    }
  }
  
  public int dispatch(com.tencent.mm.network.g paramg, s params, m paramm)
  {
    Object localObject = this.tux;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.utils.b)localObject).begin();
    }
    com.tencent.mm.plugin.finder.cgi.report.d locald = cYa();
    if (locald != null) {
      if ((params instanceof com.tencent.mm.ak.d)) {
        break label137;
      }
    }
    label137:
    for (localObject = null;; localObject = params)
    {
      locald.g((com.tencent.mm.ak.d)localObject);
      localObject = this.tuR;
      if (localObject != null) {
        ((com.tencent.f.i.d)localObject).cancel(false);
      }
      if (this.timeout > 0)
      {
        Log.i(this.TAG, "time out:" + this.timeout);
        this.tuR = h.RTc.o((Runnable)new b(this), this.timeout);
      }
      return super.dispatch(paramg, params, paramm);
    }
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    cYa().cZt();
    paramArrayOfByte = this.tux;
    if (paramArrayOfByte != null) {
      paramArrayOfByte.end();
    }
    paramArrayOfByte = this.tuR;
    if (paramArrayOfByte != null) {
      paramArrayOfByte.cancel(false);
    }
    paramArrayOfByte = com.tencent.mm.plugin.finder.spam.a.vwk;
    com.tencent.mm.plugin.finder.spam.a.t(paramInt2, paramInt3, paramString);
    paramArrayOfByte = com.tencent.mm.plugin.finder.spam.a.vwk;
    com.tencent.mm.plugin.finder.spam.a.u(paramInt2, paramInt3, paramString);
    a(paramInt1, paramInt2, paramInt3, paramString, params);
    cYa().cZu();
    paramArrayOfByte = cYa();
    if (!(params instanceof com.tencent.mm.ak.d)) {
      params = null;
    }
    for (;;)
    {
      paramArrayOfByte.b(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.d)params);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/cgi/report/FinderCgiReport;", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.cgi.report.d>
  {
    a(ax paramax)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(ax paramax) {}
    
    public final void run()
    {
      AppMethodBeat.i(242359);
      this.tuT.cancel();
      this.tuT.tuR = null;
      Log.i(this.tuT.TAG, "time out!");
      kotlin.g.a.a locala = this.tuT.tuS;
      if (locala != null)
      {
        locala.invoke();
        AppMethodBeat.o(242359);
        return;
      }
      AppMethodBeat.o(242359);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ax
 * JD-Core Version:    0.7.0.1
 */