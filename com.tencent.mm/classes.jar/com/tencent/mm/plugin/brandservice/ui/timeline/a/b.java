package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.f.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/model/BizTimeLineExposeHelper;", "", "context", "Landroid/content/Context;", "report", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineReport;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineReport;)V", "getContext", "()Landroid/content/Context;", "doingReport", "", "getDoingReport", "()Z", "setDoingReport", "(Z)V", "exposedMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "pendingMap", "renderMap", "getReport", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineReport;", "screenHeight", "", "getScreenHeight", "()I", "setScreenHeight", "(I)V", "sessionItemCache", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineReport$ReportBrandExposeItem;", "getSessionItemCache", "()Ljava/util/HashMap;", "setSessionItemCache", "(Ljava/util/HashMap;)V", "addToRenderMap", "", "id", "doUpdateReadStatus", "firstVisibleItem", "lastVisibleItem", "listView", "Landroid/widget/ListView;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "putToSessionItemCache", "key", "item", "realExpose", "Landroid/view/View;", "removeFormRenderMap", "reportExpose", "keyWithExpandStatus", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "Companion", "plugin-brandservice_release"})
public final class b
{
  public static final b.a sIB;
  public final Context context;
  public int pEk;
  boolean sIA;
  public final HashMap<String, Boolean> sIw;
  private final HashMap<String, Boolean> sIx;
  private final HashMap<String, Boolean> sIy;
  public HashMap<String, f.b> sIz;
  final f szZ;
  
  static
  {
    AppMethodBeat.i(259245);
    sIB = new b.a((byte)0);
    AppMethodBeat.o(259245);
  }
  
  public b(Context paramContext, f paramf)
  {
    AppMethodBeat.i(259244);
    this.context = paramContext;
    this.szZ = paramf;
    this.sIw = new HashMap();
    this.sIx = new HashMap();
    this.sIy = new HashMap();
    this.sIz = new HashMap();
    this.pEk = com.tencent.mm.ci.a.ks(this.context);
    this.szZ.a(this);
    AppMethodBeat.o(259244);
  }
  
  private final boolean dV(View paramView)
  {
    AppMethodBeat.i(259242);
    int j = paramView.getHeight();
    int i = j;
    if (paramView.getTop() < 0) {
      i = j + paramView.getTop();
    }
    j = i;
    if (paramView.getBottom() > this.pEk) {
      j = i - (paramView.getBottom() - this.pEk);
    }
    if (j / paramView.getHeight() > 0.5D)
    {
      AppMethodBeat.o(259242);
      return true;
    }
    AppMethodBeat.o(259242);
    return false;
  }
  
  public static String o(z paramz)
  {
    AppMethodBeat.i(259240);
    p.k(paramz, "$this$keyWithExpandStatus");
    paramz = paramz.getId() + '-' + paramz.field_isExpand;
    AppMethodBeat.o(259240);
    return paramz;
  }
  
  public final void a(int paramInt1, int paramInt2, ListView paramListView, final f paramf)
  {
    AppMethodBeat.i(259241);
    p.k(paramListView, "listView");
    p.k(paramf, "report");
    int j = 0;
    if (paramInt1 <= paramInt2)
    {
      int i = paramInt1;
      paramInt1 = j;
      final View localView;
      if (i != 0)
      {
        localView = paramListView.getChildAt(paramInt1);
        if (localView != null) {
          break label68;
        }
      }
      for (;;)
      {
        if (i == paramInt2) {
          break label206;
        }
        i += 1;
        paramInt1 += 1;
        break;
        label68:
        Object localObject2 = localView.getTag();
        Object localObject1 = localObject2;
        if (!(localObject2 instanceof com.tencent.mm.plugin.brandservice.ui.timeline.item.a)) {
          localObject1 = null;
        }
        localObject1 = (com.tencent.mm.plugin.brandservice.ui.timeline.item.a)localObject1;
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.a)localObject1).sBt;
          if ((localObject1 != null) && (this.sIw.containsKey(((z)localObject1).getId())) && (!this.sIx.containsKey(o((z)localObject1))) && (dV(localView)))
          {
            ((Map)this.sIx).put(o((z)localObject1), Boolean.TRUE);
            com.tencent.e.h.ZvG.n((Runnable)new b(this, localView, (z)localObject1, paramf), 500L);
          }
        }
      }
    }
    label206:
    AppMethodBeat.o(259241);
  }
  
  public final void cBa()
  {
    AppMethodBeat.i(259243);
    if (this.sIA)
    {
      AppMethodBeat.o(259243);
      return;
    }
    this.sIA = true;
    com.tencent.e.h.ZvG.a((Runnable)new c(this), 1000L, "BizTimeLineExpose");
    AppMethodBeat.o(259243);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(b paramb, View paramView, z paramz, f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(264380);
      Object localObject2 = localView.getTag();
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof com.tencent.mm.plugin.brandservice.ui.timeline.item.a)) {
        localObject1 = null;
      }
      localObject2 = (com.tencent.mm.plugin.brandservice.ui.timeline.item.a)localObject1;
      if (localObject2 == null)
      {
        AppMethodBeat.o(264380);
        return;
      }
      localObject1 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.a)localObject2).sBt;
      if (localObject1 == null)
      {
        AppMethodBeat.o(264380);
        return;
      }
      final int i = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.a)localObject2).position;
      if ((p.h(b.o((z)localObject1), b.o(this.sAV))) && ((localView.isShown()) || (localView.isAttachedToWindow())))
      {
        b.b(this.sIC).remove(b.o(this.sAV));
        localObject2 = this.sIC;
        String str = this.sAV.getId();
        p.j(str, "info.id");
        p.k(str, "id");
        ((b)localObject2).sIw.remove(str);
        Log.v("MicroMsg.BizTimeLineExposeHelper", "doUpdateReadStatus on expose " + this.sAV.getId());
        if (!b.c(this.sIC).containsKey(b.o((z)localObject1))) {
          this.sIC.cBa();
        }
        ((Map)b.c(this.sIC)).put(b.o((z)localObject1), Boolean.TRUE);
        com.tencent.e.h.ZvG.d((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(265609);
            this.sIE.sAQ.c(this.sIE.sAV, i);
            AppMethodBeat.o(265609);
          }
        }, "BizTimeLineExpose");
      }
      AppMethodBeat.o(264380);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(265413);
      this.sIC.sIA = false;
      try
      {
        Object localObject1 = (Map)this.sIC.sIz;
        if (localObject1 != null)
        {
          boolean bool = ((Map)localObject1).isEmpty();
          if (!bool) {
            break label57;
          }
        }
        label57:
        for (int i = 1; i != 0; i = 0) {
          return;
        }
        localObject1 = new LinkedList();
        localObject2 = this.sIC.sIz.entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          f.b localb = (f.b)((Map.Entry)((Iterator)localObject2).next()).getValue();
          if (!Util.isNullOrNil(localb.sBR))
          {
            MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.sSn;
            localb.RWq = MPVideoPreviewMgr.aqx(localb.sBR);
            localMPVideoPreviewMgr = MPVideoPreviewMgr.sSn;
            localb.RWr = MPVideoPreviewMgr.aqy(localb.sBR);
          }
          ((LinkedList)localObject1).add(localb);
        }
        this.sIC.sIz.clear();
      }
      finally
      {
        AppMethodBeat.o(265413);
      }
      Log.i("MicroMsg.BizTimeLineExposeHelper", "reportExpose size = " + localLinkedList.size());
      Object localObject2 = com.tencent.mm.kernel.h.aHF();
      p.j(localObject2, "MMKernel.network()");
      ((c)localObject2).aGY().b((q)new com.tencent.mm.plugin.brandservice.b.l(localLinkedList, this.sIC.szZ.sBx, this.sIC.szZ.sBy, this.sIC.szZ.fwM, this.sIC.szZ.sBz, 1, 0, this.sIC.szZ.sBA));
      AppMethodBeat.o(265413);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.b
 * JD-Core Version:    0.7.0.1
 */