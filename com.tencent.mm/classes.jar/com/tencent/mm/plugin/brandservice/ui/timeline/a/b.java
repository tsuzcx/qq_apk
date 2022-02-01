package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.an.af;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.brandservice.model.l;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.f.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.r;
import com.tencent.threadpool.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/model/BizTimeLineExposeHelper;", "", "context", "Landroid/content/Context;", "report", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineReport;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineReport;)V", "contentBottom", "", "getContentBottom", "()I", "setContentBottom", "(I)V", "getContext", "()Landroid/content/Context;", "doingReport", "", "getDoingReport", "()Z", "setDoingReport", "(Z)V", "exposedMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "pendingMap", "renderMap", "getReport", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineReport;", "sessionItemCache", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineReport$ReportBrandExposeItem;", "getSessionItemCache", "()Ljava/util/HashMap;", "setSessionItemCache", "(Ljava/util/HashMap;)V", "addToRenderMap", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "pos", "doUpdateReadStatus", "firstVisibleItem", "lastVisibleItem", "listView", "Landroid/widget/ListView;", "onConfigurationChanged", "view", "Landroid/view/View;", "newConfig", "Landroid/content/res/Configuration;", "onFirstExpose", "putToSessionItemCache", "key", "item", "realExpose", "removeFormRenderMap", "id", "reportExpose", "updateContentBottom", "keyWithExpandStatus", "Companion", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a vNY;
  private final Context context;
  private final f vFK;
  private final HashMap<String, Boolean> vNZ;
  private final HashMap<String, Boolean> vOa;
  private final HashMap<String, Boolean> vOb;
  public HashMap<String, f.b> vOc;
  private int vOd;
  private boolean vOe;
  
  static
  {
    AppMethodBeat.i(302240);
    vNY = new b.a((byte)0);
    AppMethodBeat.o(302240);
  }
  
  public b(Context paramContext, f paramf)
  {
    AppMethodBeat.i(302185);
    this.context = paramContext;
    this.vFK = paramf;
    this.vNZ = new HashMap();
    this.vOa = new HashMap();
    this.vOb = new HashMap();
    this.vOc = new HashMap();
    this.vOd = com.tencent.mm.cd.a.mt(this.context);
    this.vFK.vHg = this;
    AppMethodBeat.o(302185);
  }
  
  private static final void a(View paramView, ab paramab, b paramb, String paramString, f paramf)
  {
    AppMethodBeat.i(302224);
    kotlin.g.b.s.u(paramView, "$viewItem");
    kotlin.g.b.s.u(paramab, "$info");
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.u(paramString, "$infoKeyWithExpandStatus");
    kotlin.g.b.s.u(paramf, "$report");
    Object localObject = paramView.getTag();
    if ((localObject instanceof com.tencent.mm.plugin.brandservice.ui.timeline.item.a)) {}
    for (localObject = (com.tencent.mm.plugin.brandservice.ui.timeline.item.a)localObject; localObject == null; localObject = null)
    {
      AppMethodBeat.o(302224);
      return;
    }
    ab localab = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.a)localObject).vGS;
    if (localab == null)
    {
      AppMethodBeat.o(302224);
      return;
    }
    int i = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.a)localObject).position;
    Log.v("MicroMsg.BizTimeLineExposeHelper", kotlin.g.b.s.X("doUpdateReadStatus on time ", paramab.getId()));
    paramb.vOa.remove(paramString);
    localObject = n(localab);
    if ((kotlin.g.b.s.p(localObject, paramString)) && ((paramView.isShown()) || (paramView.isAttachedToWindow())))
    {
      paramView = paramab.getId();
      kotlin.g.b.s.s(paramView, "info.id");
      kotlin.g.b.s.u(paramView, "id");
      paramb.vNZ.remove(paramView);
      Log.v("MicroMsg.BizTimeLineExposeHelper", kotlin.g.b.s.X("doUpdateReadStatus on expose ", paramab.getId()));
      if (!paramb.vOb.containsKey(localObject))
      {
        paramb.def();
        kotlin.g.b.s.u(paramab, "info");
        paramView = r.acDM;
        if ((r.iXr()) && (paramab.iYg()))
        {
          af.bHm().A(paramab);
          af.bHl().G(paramab);
        }
      }
      ((Map)paramb.vOb).put(localObject, Boolean.TRUE);
      com.tencent.threadpool.h.ahAA.g(new b..ExternalSyntheticLambda4(paramf, paramab, i), "BizTimeLineExpose");
    }
    AppMethodBeat.o(302224);
  }
  
  private static final void a(b paramb)
  {
    AppMethodBeat.i(302231);
    kotlin.g.b.s.u(paramb, "this$0");
    paramb.vOe = false;
    Object localObject;
    try
    {
      localObject = (Map)paramb.vOc;
      if (localObject != null)
      {
        boolean bool = ((Map)localObject).isEmpty();
        if (!bool) {
          break label59;
        }
      }
      label59:
      for (int i = 1; i != 0; i = 0) {
        return;
      }
      localObject = new LinkedList();
      Iterator localIterator = paramb.vOc.entrySet().iterator();
      while (localIterator.hasNext())
      {
        f.b localb = (f.b)((Map.Entry)localIterator.next()).getValue();
        if (!Util.isNullOrNil(localb.vHw))
        {
          MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.vXs;
          localb.YTU = MPVideoPreviewMgr.ajW(localb.vHw);
          localMPVideoPreviewMgr = MPVideoPreviewMgr.vXs;
          localb.YTV = MPVideoPreviewMgr.ajX(localb.vHw);
        }
        ((LinkedList)localObject).add(localb);
      }
      paramb.vOc.clear();
    }
    finally
    {
      AppMethodBeat.o(302231);
    }
    Log.i("MicroMsg.BizTimeLineExposeHelper", kotlin.g.b.s.X("reportExpose size = ", Integer.valueOf(((LinkedList)localObject).size())));
    com.tencent.mm.kernel.h.baD().mCm.a((p)new l((LinkedList)localObject, paramb.vFK.vGW, paramb.vFK.vGX, paramb.vFK.hBm, paramb.vFK.vGY, 1, 0, paramb.vFK.vGZ), 0);
    paramb = ah.aiuX;
    AppMethodBeat.o(302231);
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(302203);
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.u(paramView, "$view");
    paramb.eI(paramView);
    AppMethodBeat.o(302203);
  }
  
  private static final void a(b paramb, ab paramab, int paramInt)
  {
    AppMethodBeat.i(302210);
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.u(paramab, "$info");
    paramb.vFK.a(paramab, paramInt, 0);
    AppMethodBeat.o(302210);
  }
  
  private static final void a(f paramf, ab paramab, int paramInt)
  {
    AppMethodBeat.i(302213);
    kotlin.g.b.s.u(paramf, "$report");
    kotlin.g.b.s.u(paramab, "$info");
    paramf.a(paramab, paramInt, 1);
    AppMethodBeat.o(302213);
  }
  
  private static String n(ab paramab)
  {
    AppMethodBeat.i(302194);
    paramab = paramab.getId() + '-' + paramab.field_isExpand;
    AppMethodBeat.o(302194);
    return paramab;
  }
  
  public final void a(int paramInt1, int paramInt2, ListView paramListView, f paramf)
  {
    AppMethodBeat.i(302282);
    kotlin.g.b.s.u(paramListView, "listView");
    kotlin.g.b.s.u(paramf, "report");
    int j = 0;
    int i;
    if (paramInt1 <= paramInt2) {
      i = paramInt1;
    }
    for (;;)
    {
      Object localObject2;
      Object localObject1;
      label79:
      Object localObject3;
      float f1;
      if (i != 0)
      {
        localObject2 = paramListView.getChildAt(j);
        if (localObject2 != null)
        {
          localObject1 = ((View)localObject2).getTag();
          if (!(localObject1 instanceof com.tencent.mm.plugin.brandservice.ui.timeline.item.a)) {
            break label308;
          }
          localObject1 = (com.tencent.mm.plugin.brandservice.ui.timeline.item.a)localObject1;
          if (localObject1 != null) {
            break label314;
          }
          localObject1 = null;
          if (localObject1 != null)
          {
            String str = n((ab)localObject1);
            if ((this.vNZ.containsKey(((ab)localObject1).getId())) && (!this.vOa.containsKey(str)))
            {
              int k = ((View)localObject2).getHeight();
              paramInt1 = k;
              if (((View)localObject2).getTop() < 0) {
                paramInt1 = k + ((View)localObject2).getTop();
              }
              k = paramInt1;
              if (((View)localObject2).getBottom() > this.vOd) {
                k = paramInt1 - (((View)localObject2).getBottom() - this.vOd);
              }
              float f2 = k / ((View)localObject2).getHeight();
              if (!((ab)localObject1).iYg()) {
                break label324;
              }
              localObject3 = r.acDM;
              r.iXF();
              f1 = r.acEn;
              label207:
              if (f2 <= f1) {
                break label332;
              }
              paramInt1 = 1;
              label217:
              if (paramInt1 != 0)
              {
                ((Map)this.vOa).put(str, Boolean.TRUE);
                localObject3 = com.tencent.threadpool.h.ahAA;
                localObject2 = new b..ExternalSyntheticLambda0((View)localObject2, (ab)localObject1, this, str, paramf);
                if (!((ab)localObject1).iYg()) {
                  break label337;
                }
                localObject1 = r.acDM;
                r.iXF();
              }
            }
          }
        }
      }
      label308:
      label314:
      label324:
      label332:
      label337:
      for (long l = r.acEo;; l = 500L)
      {
        ((i)localObject3).o((Runnable)localObject2, l);
        if (i != paramInt2) {
          break label345;
        }
        AppMethodBeat.o(302282);
        return;
        localObject1 = null;
        break;
        localObject1 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.a)localObject1).vGS;
        break label79;
        f1 = 0.5F;
        break label207;
        paramInt1 = 0;
        break label217;
      }
      label345:
      j += 1;
      i += 1;
    }
  }
  
  public final void a(View paramView, Configuration paramConfiguration)
  {
    AppMethodBeat.i(302269);
    kotlin.g.b.s.u(paramView, "view");
    kotlin.g.b.s.u(paramConfiguration, "newConfig");
    com.tencent.threadpool.h.ahAA.o(new b..ExternalSyntheticLambda2(this, paramView), 100L);
    AppMethodBeat.o(302269);
  }
  
  public final void def()
  {
    AppMethodBeat.i(302287);
    if (this.vOe)
    {
      AppMethodBeat.o(302287);
      return;
    }
    this.vOe = true;
    com.tencent.threadpool.h.ahAA.a(new b..ExternalSyntheticLambda1(this), 1000L, "BizTimeLineExpose");
    AppMethodBeat.o(302287);
  }
  
  public final void eI(View paramView)
  {
    AppMethodBeat.i(302267);
    if ((paramView != null) && (paramView.getBottom() > 0) && (paramView.getBottom() <= com.tencent.mm.cd.a.mt(this.context)))
    {
      this.vOd = paramView.getBottom();
      Log.d("MicroMsg.BizTimeLineExposeHelper", kotlin.g.b.s.X("updateContentBottom contentBottom=", Integer.valueOf(this.vOd)));
    }
    AppMethodBeat.o(302267);
  }
  
  public final void g(ab paramab, int paramInt)
  {
    AppMethodBeat.i(302275);
    kotlin.g.b.s.u(paramab, "info");
    Map localMap = (Map)this.vNZ;
    String str = paramab.getId();
    kotlin.g.b.s.s(str, "info.id");
    localMap.put(str, Boolean.TRUE);
    com.tencent.threadpool.h.ahAA.g(new b..ExternalSyntheticLambda3(this, paramab, paramInt), "BizTimeLineExpose");
    AppMethodBeat.o(302275);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.b
 * JD-Core Version:    0.7.0.1
 */