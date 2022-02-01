package com.tencent.mm.plugin.finder.report;

import android.app.Activity;
import android.content.Context;
import android.util.ArrayMap;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.dx;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.view.FinderRefreshLayout;
import com.tencent.mm.plugin.finder.view.FinderRefreshLayout.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderEnterCostReporter;", "", "()V", "TAG", "", "dataMap", "Landroid/util/ArrayMap;", "", "Lcom/tencent/mm/plugin/finder/report/FinderEnterCostReporter$RecordData;", "enterTimestamp", "", "appendExtraJson", "", "hashCode", "json", "Lorg/json/JSONObject;", "buildJson", "data", "checkDataValid", "", "findRlViewTraversal", "Lcom/tencent/mm/plugin/finder/view/FinderRefreshLayout;", "view", "Landroid/view/View;", "findViewTraversal", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getData", "isCreate", "notifyEnter", "notifyFinish", "activity", "Landroid/app/Activity;", "notifyOnCreate", "tag", "notifyOnPause", "notifyOnResume", "notifyRefreshEnd", "notifyRefreshStart", "registerCallback", "parentView", "registerNewView", "registerOldView", "report21680", "RecordData", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public static long AxK;
  public static final j Fpm;
  public static final ArrayMap<Integer, a> Fpn;
  
  static
  {
    AppMethodBeat.i(331480);
    Fpm = new j();
    Fpn = new ArrayMap();
    AppMethodBeat.o(331480);
  }
  
  public static void Se(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(331431);
    a locala = aJ(paramInt, false);
    if (locala != null)
    {
      paramInt = i;
      if (locala.Fpq == 0L) {
        paramInt = 1;
      }
      if (paramInt == 0) {
        break label56;
      }
    }
    for (;;)
    {
      if (locala != null)
      {
        locala.Fpq = cn.bDw();
        locala.Fpr = 0L;
      }
      AppMethodBeat.o(331431);
      return;
      label56:
      locala = null;
    }
  }
  
  public static void Sf(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(331435);
    a locala = aJ(paramInt, false);
    if (locala != null)
    {
      if (locala.Fpq != 0L)
      {
        paramInt = i;
        if (locala.Fpr != 0L) {}
      }
      else
      {
        paramInt = 1;
      }
      if (paramInt == 0) {}
    }
    for (;;)
    {
      if (locala != null) {
        locala.Fpr = cn.bDw();
      }
      AppMethodBeat.o(331435);
      return;
      locala = null;
    }
  }
  
  private static JSONObject a(a parama)
  {
    AppMethodBeat.i(331455);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("totalCost", parama.Fpr - parama.EQt);
    localJSONObject.put("loadCost", parama.Fpr - parama.Fpo);
    localJSONObject.put("clickToCreateCost", parama.Fpo - parama.EQt);
    localJSONObject.put("createToResumeCost", parama.Fpp - parama.Fpo);
    if (parama.Fpq == 0L)
    {
      l = 0L;
      localJSONObject.put("resumeToRefreshStartCost", l);
      if (parama.Fpq != 0L) {
        break label219;
      }
    }
    label219:
    for (long l = parama.Fpr - parama.Fpp;; l = parama.Fpr - parama.Fpq)
    {
      localJSONObject.put("refreshCost", l);
      parama = parama.Fps;
      if (parama != null) {
        try
        {
          Iterator localIterator = parama.keys();
          s.s(localIterator, "it.keys()");
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            localJSONObject.put(str, parama.get(str));
          }
          AppMethodBeat.o(331455);
        }
        finally
        {
          Log.e("FinderEnterCostReporter", "buildJson: extra json err", new Object[] { parama });
        }
      }
      return localJSONObject;
      l = parama.Fpq - parama.Fpp;
      break;
    }
  }
  
  public static void a(View paramView, Activity paramActivity)
  {
    AppMethodBeat.i(331415);
    s.u(paramView, "parentView");
    s.u(paramActivity, "activity");
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = gE(paramView);
    if (localRefreshLoadMoreLayout != null) {
      localRefreshLoadMoreLayout.setReportCallback((RefreshLoadMoreLayout.b)new c(paramActivity));
    }
    paramView = gF(paramView);
    if (paramView != null) {
      paramView.setReportAction((FinderRefreshLayout.a)new b(paramActivity));
    }
    AppMethodBeat.o(331415);
  }
  
  public static a aJ(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(331460);
    if (paramBoolean)
    {
      locala = new a();
      ((Map)Fpn).put(Integer.valueOf(paramInt), locala);
      AppMethodBeat.o(331460);
      return locala;
    }
    a locala = (a)Fpn.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(331460);
    return locala;
  }
  
  public static void b(int paramInt, Activity paramActivity)
  {
    AppMethodBeat.i(331443);
    s.u(paramActivity, "activity");
    a locala = aJ(paramInt, false);
    int i;
    if (locala != null)
    {
      if ((locala.EQt <= 0L) || (locala.Fpo <= 0L) || (locala.Fpp <= 0L) || (locala.Fpq < 0L) || (locala.Fpr <= 0L) || (locala.Fpr <= locala.Fpq) || (locala.Fpp <= locala.Fpo) || (locala.Fpo <= locala.EQt)) {
        break label183;
      }
      i = 1;
      if (i != 0) {
        break label188;
      }
      Log.w("FinderEnterCostReporter", s.X("report21680: invalid data ", locala));
    }
    for (;;)
    {
      Fpn.remove(Integer.valueOf(paramInt));
      if (((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).ek((Context)paramActivity))
      {
        Log.i("FinderEnterCostReporter", s.X("notifyFinish: remain size ", Integer.valueOf(Fpn.size())));
        Fpn.clear();
      }
      AppMethodBeat.o(331443);
      return;
      label183:
      i = 0;
      break;
      label188:
      dx localdx = new dx();
      localdx.aIM();
      localdx.ixD = 4L;
      String str = a(locala).toString();
      s.s(str, "buildJson(data).toString()");
      localdx.nZ(n.m(str, ",", ";", false));
      localdx.oa(locala.tag);
      localdx.ob(String.valueOf(locala.Fpr - locala.EQt));
      localdx.bMH();
      Log.i("FinderEnterCostReporter", s.X("report21680 info:", localdx.aIF()));
    }
  }
  
  public static void eMt()
  {
    AppMethodBeat.i(331430);
    AxK = cn.bDw();
    AppMethodBeat.o(331430);
  }
  
  private static RefreshLoadMoreLayout gE(View paramView)
  {
    AppMethodBeat.i(331420);
    if ((paramView instanceof RefreshLoadMoreLayout))
    {
      paramView = (RefreshLoadMoreLayout)paramView;
      AppMethodBeat.o(331420);
      return paramView;
    }
    int i;
    label53:
    int j;
    RefreshLoadMoreLayout localRefreshLoadMoreLayout;
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      if (paramView == null) {
        break label111;
      }
      i = 0;
      int k = paramView.getChildCount();
      if (k <= 0) {
        break label124;
      }
      j = i + 1;
      localObject = paramView.getChildAt(i);
      s.s(localObject, "it.getChildAt(i)");
      localRefreshLoadMoreLayout = gE((View)localObject);
      localObject = localRefreshLoadMoreLayout;
      if (localRefreshLoadMoreLayout == null) {
        if (j < k) {
          break label119;
        }
      }
    }
    label111:
    label119:
    label124:
    for (Object localObject = localRefreshLoadMoreLayout;; localObject = null)
    {
      AppMethodBeat.o(331420);
      return localObject;
      paramView = null;
      break;
      AppMethodBeat.o(331420);
      return null;
      i = j;
      break label53;
    }
  }
  
  private static FinderRefreshLayout gF(View paramView)
  {
    AppMethodBeat.i(331427);
    if ((paramView instanceof FinderRefreshLayout))
    {
      paramView = (FinderRefreshLayout)paramView;
      AppMethodBeat.o(331427);
      return paramView;
    }
    int i;
    label53:
    int j;
    FinderRefreshLayout localFinderRefreshLayout;
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      if (paramView == null) {
        break label111;
      }
      i = 0;
      int k = paramView.getChildCount();
      if (k <= 0) {
        break label124;
      }
      j = i + 1;
      localObject = paramView.getChildAt(i);
      s.s(localObject, "it.getChildAt(i)");
      localFinderRefreshLayout = gF((View)localObject);
      localObject = localFinderRefreshLayout;
      if (localFinderRefreshLayout == null) {
        if (j < k) {
          break label119;
        }
      }
    }
    label111:
    label119:
    label124:
    for (Object localObject = localFinderRefreshLayout;; localObject = null)
    {
      AppMethodBeat.o(331427);
      return localObject;
      paramView = null;
      break;
      AppMethodBeat.o(331427);
      return null;
      i = j;
      break label53;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderEnterCostReporter$RecordData;", "", "()V", "clickEnterTime", "", "getClickEnterTime", "()J", "setClickEnterTime", "(J)V", "extraJson", "Lorg/json/JSONObject;", "getExtraJson", "()Lorg/json/JSONObject;", "setExtraJson", "(Lorg/json/JSONObject;)V", "onCreateTime", "getOnCreateTime", "setOnCreateTime", "onResumeTime", "getOnResumeTime", "setOnResumeTime", "refreshEndTime", "getRefreshEndTime", "setRefreshEndTime", "refreshStartTime", "getRefreshStartTime", "setRefreshStartTime", "tag", "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "toString", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public long EQt;
    public long Fpo;
    public long Fpp;
    public long Fpq;
    public long Fpr;
    public JSONObject Fps;
    public String tag = "";
    
    public final String toString()
    {
      AppMethodBeat.i(331201);
      String str = "tag = " + this.tag + ", clickEnterTime = " + this.EQt + ", onCreateTime = " + this.Fpo + ", onResumeTime = " + this.Fpp + ", refreshStartTime = " + this.Fpq + ", refreshEndTime = " + this.Fpr + ", extraJson = " + this.Fps;
      AppMethodBeat.o(331201);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/report/FinderEnterCostReporter$registerNewView$1$1", "Lcom/tencent/mm/plugin/finder/view/FinderRefreshLayout$ActionCallback;", "isReport", "", "onRefreshBegin", "", "isAuto", "onRefreshEnd", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends FinderRefreshLayout.a
  {
    private boolean lAr;
    
    b(Activity paramActivity) {}
    
    public final void eby()
    {
      AppMethodBeat.i(331226);
      if (this.lAr)
      {
        j localj = j.Fpm;
        j.Sf(this.rxb.hashCode());
        this.lAr = false;
      }
      AppMethodBeat.o(331226);
    }
    
    public final void tL(boolean paramBoolean)
    {
      AppMethodBeat.i(331217);
      this.lAr = true;
      if (paramBoolean)
      {
        j localj = j.Fpm;
        j.Se(this.rxb.hashCode());
      }
      AppMethodBeat.o(331217);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/report/FinderEnterCostReporter$registerOldView$1$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "isPull", "", "onRefreshBegin", "", "refreshType", "", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RefreshLoadMoreLayout.b
  {
    private boolean Fpt;
    
    c(Activity paramActivity) {}
    
    public final void IH(int paramInt)
    {
      AppMethodBeat.i(331212);
      Object localObject = RefreshLoadMoreLayout.d.agJr;
      if (paramInt == RefreshLoadMoreLayout.d.jMK())
      {
        this.Fpt = true;
        AppMethodBeat.o(331212);
        return;
      }
      this.Fpt = false;
      localObject = j.Fpm;
      j.Se(this.rxb.hashCode());
      AppMethodBeat.o(331212);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(331222);
      s.u(paramd, "reason");
      if (paramd.actionType == 2)
      {
        AppMethodBeat.o(331222);
        return;
      }
      if (!this.Fpt)
      {
        paramd = j.Fpm;
        j.Sf(this.rxb.hashCode());
      }
      this.Fpt = false;
      AppMethodBeat.o(331222);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.j
 * JD-Core Version:    0.7.0.1
 */