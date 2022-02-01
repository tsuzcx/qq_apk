package com.tencent.mm.plugin.finder.cgi;

import android.content.Context;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.plugin.finder.cgi.report.d;
import com.tencent.mm.plugin.finder.cgi.report.e;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.utils.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "_Resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/plugin/finder/cgi/report/ICgiTrack;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "loadingComponent", "Lcom/tencent/mm/plugin/finder/utils/DelayLoadingComponent;", "report", "Lcom/tencent/mm/plugin/finder/cgi/report/FinderCgiReport;", "getReport", "()Lcom/tencent/mm/plugin/finder/cgi/report/FinderCgiReport;", "report$delegate", "Lkotlin/Lazy;", "showErrorTips", "", "actionExt", "Lorg/json/JSONObject;", "cancel", "", "delayLoading", "context", "Landroid/content/Context;", "wording", "delay", "", "customLoadingComponent", "getCgiReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getCmdId", "", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "isFetchFeedCgi", "onCgiBack", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "(IILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "onCgiEnd", "resultExt", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "setShowErrorTips", "updateFeedSessionBuffer", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "plugin-finder_release"})
public abstract class an<_Resp extends dpc>
  extends c<_Resp>
  implements e
{
  private final String TAG;
  final bbn ttO;
  private com.tencent.mm.plugin.finder.utils.b tux;
  public boolean tuy;
  private final kotlin.f tuz;
  
  public an(bbn parambbn)
  {
    this.ttO = parambbn;
    this.TAG = "Finder.FinderCgi";
    this.tuy = true;
    this.tuz = g.ah((kotlin.g.a.a)new a(this));
    if (cXQ())
    {
      parambbn = k.vfA;
      parambbn = this.ttO;
      if (parambbn == null) {
        break label126;
      }
    }
    label126:
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
  
  private final d cYa()
  {
    return (d)this.tuz.getValue();
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, _Resp param_Resp, com.tencent.mm.ak.q paramq)
  {
    p.h(param_Resp, "resp");
    super.a(paramInt1, paramInt2, paramString, param_Resp, paramq);
    cYa().cZt();
    com.tencent.mm.plugin.finder.utils.b localb = this.tux;
    if (localb != null) {
      localb.end();
    }
    b(paramInt1, paramInt2, paramString, param_Resp, paramq);
    cYa().cZu();
    cYa().b(paramInt1, paramInt2, paramString, aYG());
    if (this.tuy)
    {
      param_Resp = com.tencent.mm.plugin.finder.spam.a.vwk;
      com.tencent.mm.plugin.finder.spam.a.t(paramInt1, paramInt2, paramString);
      param_Resp = com.tencent.mm.plugin.finder.spam.a.vwk;
      com.tencent.mm.plugin.finder.spam.a.u(paramInt1, paramInt2, paramString);
    }
  }
  
  public com.tencent.mm.co.f<c.a<_Resp>> aYI()
  {
    Object localObject = this.tux;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.utils.b)localObject).begin();
    }
    localObject = cYa();
    if (localObject != null) {
      ((d)localObject).g(aYG());
    }
    localObject = super.aYI();
    p.g(localObject, "super.run()");
    return localObject;
  }
  
  public abstract void b(int paramInt1, int paramInt2, String paramString, _Resp param_Resp, com.tencent.mm.ak.q paramq);
  
  public final an<_Resp> c(Context paramContext, String paramString, long paramLong)
  {
    p.h(paramContext, "context");
    b.a locala = com.tencent.mm.plugin.finder.utils.b.vVa;
    this.tux = b.a.e(paramContext, paramString, paramLong);
    return this;
  }
  
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
  
  public final void cancel()
  {
    com.tencent.mm.plugin.finder.utils.b localb = this.tux;
    if (localb != null) {
      localb.end();
    }
    super.cancel();
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/cgi/report/FinderCgiReport;", "_Resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<d>
  {
    a(an paraman)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.an
 * JD-Core Version:    0.7.0.1
 */