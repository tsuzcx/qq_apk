package com.tencent.mm.plugin.finder.report;

import android.app.Activity;
import android.util.ArrayMap;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.cm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderEnterCostReporter;", "", "()V", "TAG", "", "dataMap", "Landroid/util/ArrayMap;", "", "Lcom/tencent/mm/plugin/finder/report/FinderEnterCostReporter$RecordData;", "enterTimestamp", "", "appendExtraJson", "", "hashCode", "json", "Lorg/json/JSONObject;", "buildJson", "data", "checkDataValid", "", "findViewTraversal", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "view", "Landroid/view/View;", "getData", "isCreate", "notifyEnter", "notifyFinish", "activity", "Landroid/app/Activity;", "notifyOnCreate", "tag", "notifyOnPause", "notifyOnResume", "notifyRefreshEnd", "notifyRefreshStart", "registerCallback", "parentView", "report21680", "RecordData", "plugin-finder-base_release"})
public final class e
{
  public static final ArrayMap<Integer, a> zUE;
  public static long zUF;
  public static final e zUG;
  
  static
  {
    AppMethodBeat.i(258446);
    zUG = new e();
    zUE = new ArrayMap();
    AppMethodBeat.o(258446);
  }
  
  public static void Pd(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(258441);
    a locala = ap(paramInt, false);
    if (locala != null)
    {
      if (locala.zUK != 0L)
      {
        paramInt = i;
        if (locala.zUL != 0L) {}
      }
      else
      {
        paramInt = 1;
      }
      if (paramInt != 0) {}
      while (locala != null)
      {
        locala.zUL = cm.bfE();
        AppMethodBeat.o(258441);
        return;
        locala = null;
      }
    }
    AppMethodBeat.o(258441);
  }
  
  public static JSONObject a(a parama)
  {
    AppMethodBeat.i(258442);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("totalCost", parama.zUL - parama.zUH);
    localJSONObject.put("loadCost", parama.zUL - parama.zUI);
    localJSONObject.put("clickToCreateCost", parama.zUI - parama.zUH);
    localJSONObject.put("createToResumeCost", parama.zUJ - parama.zUI);
    if (parama.zUK == 0L)
    {
      l = 0L;
      localJSONObject.put("resumeToRefreshStartCost", l);
      if (parama.zUK != 0L) {
        break label219;
      }
    }
    label219:
    for (long l = parama.zUL - parama.zUJ;; l = parama.zUL - parama.zUK)
    {
      localJSONObject.put("refreshCost", l);
      parama = parama.zUM;
      if (parama != null) {
        try
        {
          Iterator localIterator = parama.keys();
          p.j(localIterator, "it.keys()");
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            localJSONObject.put(str, parama.get(str));
          }
          AppMethodBeat.o(258442);
        }
        catch (Throwable parama)
        {
          Log.e("FinderEnterCostReporter", "buildJson: extra json err", new Object[] { parama });
        }
      }
      return localJSONObject;
      l = parama.zUK - parama.zUJ;
      break;
    }
  }
  
  public static void a(View paramView, Activity paramActivity)
  {
    AppMethodBeat.i(258438);
    p.k(paramView, "parentView");
    p.k(paramActivity, "activity");
    paramView = eF(paramView);
    if (paramView != null)
    {
      paramView.setReportCallback((RefreshLoadMoreLayout.a)new b(paramActivity));
      AppMethodBeat.o(258438);
      return;
    }
    AppMethodBeat.o(258438);
  }
  
  public static a ap(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(258444);
    if (paramBoolean)
    {
      locala = new a();
      ((Map)zUE).put(Integer.valueOf(paramInt), locala);
      AppMethodBeat.o(258444);
      return locala;
    }
    a locala = (a)zUE.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(258444);
    return locala;
  }
  
  public static void dPi()
  {
    AppMethodBeat.i(258440);
    zUF = cm.bfE();
    AppMethodBeat.o(258440);
  }
  
  private static RefreshLoadMoreLayout eF(View paramView)
  {
    View localView = null;
    AppMethodBeat.i(258439);
    if ((paramView instanceof RefreshLoadMoreLayout))
    {
      paramView = (RefreshLoadMoreLayout)paramView;
      AppMethodBeat.o(258439);
      return paramView;
    }
    if (!(paramView instanceof ViewGroup)) {
      paramView = null;
    }
    for (;;)
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      if (localViewGroup != null)
      {
        int i = 0;
        int j = localViewGroup.getChildCount();
        paramView = localView;
        for (;;)
        {
          localView = paramView;
          if (i >= j) {
            break;
          }
          paramView = localViewGroup.getChildAt(i);
          p.j(paramView, "it.getChildAt(i)");
          paramView = eF(paramView);
          localView = paramView;
          if (paramView != null) {
            break;
          }
          i += 1;
        }
        AppMethodBeat.o(258439);
        return localView;
      }
      AppMethodBeat.o(258439);
      return null;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderEnterCostReporter$RecordData;", "", "()V", "clickEnterTime", "", "getClickEnterTime", "()J", "setClickEnterTime", "(J)V", "extraJson", "Lorg/json/JSONObject;", "getExtraJson", "()Lorg/json/JSONObject;", "setExtraJson", "(Lorg/json/JSONObject;)V", "onCreateTime", "getOnCreateTime", "setOnCreateTime", "onResumeTime", "getOnResumeTime", "setOnResumeTime", "refreshEndTime", "getRefreshEndTime", "setRefreshEndTime", "refreshStartTime", "getRefreshStartTime", "setRefreshStartTime", "tag", "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "toString", "plugin-finder-base_release"})
  public static final class a
  {
    public String tag = "";
    public long zUH;
    public long zUI;
    public long zUJ;
    public long zUK;
    public long zUL;
    public JSONObject zUM;
    
    public final String toString()
    {
      AppMethodBeat.i(258908);
      String str = "tag = " + this.tag + ", clickEnterTime = " + this.zUH + ", onCreateTime = " + this.zUI + ", onResumeTime = " + this.zUJ + ", refreshStartTime = " + this.zUK + ", refreshEndTime = " + this.zUL + ", extraJson = " + this.zUM;
      AppMethodBeat.o(258908);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/report/FinderEnterCostReporter$registerCallback$1$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "isPull", "", "onRefreshBegin", "", "refreshType", "", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder-base_release"})
  public static final class b
    extends RefreshLoadMoreLayout.a
  {
    private boolean zUN;
    
    b(Activity paramActivity) {}
    
    public final void Ie(int paramInt)
    {
      AppMethodBeat.i(259157);
      Object localObject = new b();
      ((b)localObject).sg(paramInt);
      a.c("com/tencent/mm/plugin/finder/report/FinderEnterCostReporter$registerCallback$$inlined$let$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, ((b)localObject).aFi());
      localObject = RefreshLoadMoreLayout.c.YNO;
      if (paramInt == RefreshLoadMoreLayout.c.ihw())
      {
        this.zUN = true;
        a.a(this, "com/tencent/mm/plugin/finder/report/FinderEnterCostReporter$registerCallback$$inlined$let$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
        AppMethodBeat.o(259157);
        return;
      }
      this.zUN = false;
      localObject = e.zUG;
      localObject = e.Pe(this.qgJ.hashCode());
      if (localObject != null)
      {
        if (((e.a)localObject).zUK != 0L) {
          break label141;
        }
        paramInt = 1;
        if (paramInt == 0) {
          break label146;
        }
      }
      for (;;)
      {
        if (localObject != null)
        {
          ((e.a)localObject).zUK = cm.bfE();
          ((e.a)localObject).zUL = 0L;
        }
        a.a(this, "com/tencent/mm/plugin/finder/report/FinderEnterCostReporter$registerCallback$$inlined$let$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
        AppMethodBeat.o(259157);
        return;
        label141:
        paramInt = 0;
        break;
        label146:
        localObject = null;
      }
    }
    
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(259160);
      b localb = new b();
      localb.bn(paramc);
      a.c("com/tencent/mm/plugin/finder/report/FinderEnterCostReporter$registerCallback$$inlined$let$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      super.a(paramc);
      a.a(this, "com/tencent/mm/plugin/finder/report/FinderEnterCostReporter$registerCallback$$inlined$let$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(259160);
    }
    
    public final void cKQ()
    {
      AppMethodBeat.i(259159);
      a.b("com/tencent/mm/plugin/finder/report/FinderEnterCostReporter$registerCallback$$inlined$let$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      super.cKQ();
      a.a(this, "com/tencent/mm/plugin/finder/report/FinderEnterCostReporter$registerCallback$$inlined$let$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(259159);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(259158);
      b localb = new b();
      localb.bn(paramc);
      a.c("com/tencent/mm/plugin/finder/report/FinderEnterCostReporter$registerCallback$$inlined$let$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      p.k(paramc, "reason");
      if (paramc.actionType == 2)
      {
        a.a(this, "com/tencent/mm/plugin/finder/report/FinderEnterCostReporter$registerCallback$$inlined$let$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(259158);
        return;
      }
      if (!this.zUN)
      {
        paramc = e.zUG;
        e.Pd(this.qgJ.hashCode());
      }
      this.zUN = false;
      a.a(this, "com/tencent/mm/plugin/finder/report/FinderEnterCostReporter$registerCallback$$inlined$let$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(259158);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.e
 * JD-Core Version:    0.7.0.1
 */