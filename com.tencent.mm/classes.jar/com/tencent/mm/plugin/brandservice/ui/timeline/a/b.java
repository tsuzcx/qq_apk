package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.k;
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
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/model/BizTimeLineExposeHelper;", "", "context", "Landroid/content/Context;", "report", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineReport;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineReport;)V", "getContext", "()Landroid/content/Context;", "doingReport", "", "getDoingReport", "()Z", "setDoingReport", "(Z)V", "exposedMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "pendingMap", "renderMap", "getReport", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineReport;", "screenHeight", "", "getScreenHeight", "()I", "setScreenHeight", "(I)V", "sessionItemCache", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineReport$ReportBrandExposeItem;", "getSessionItemCache", "()Ljava/util/HashMap;", "setSessionItemCache", "(Ljava/util/HashMap;)V", "addToRenderMap", "", "id", "doUpdateReadStatus", "firstVisibleItem", "lastVisibleItem", "listView", "Landroid/widget/ListView;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "putToSessionItemCache", "key", "item", "realExpose", "Landroid/view/View;", "removeFormRenderMap", "reportExpose", "keyWithExpandStatus", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "Companion", "plugin-brandservice_release"})
public final class b
{
  public static final b.a pyS;
  public final Context context;
  public int mEY;
  final f pqZ;
  public final HashMap<String, Boolean> pyN;
  private final HashMap<String, Boolean> pyO;
  private final HashMap<String, Boolean> pyP;
  public HashMap<String, f.b> pyQ;
  boolean pyR;
  
  static
  {
    AppMethodBeat.i(195518);
    pyS = new b.a((byte)0);
    AppMethodBeat.o(195518);
  }
  
  public b(Context paramContext, f paramf)
  {
    AppMethodBeat.i(195517);
    this.context = paramContext;
    this.pqZ = paramf;
    this.pyN = new HashMap();
    this.pyO = new HashMap();
    this.pyP = new HashMap();
    this.pyQ = new HashMap();
    this.mEY = com.tencent.mm.cb.a.jo(this.context);
    this.pqZ.a(this);
    AppMethodBeat.o(195517);
  }
  
  private final boolean dx(View paramView)
  {
    AppMethodBeat.i(195515);
    int j = paramView.getHeight();
    int i = j;
    if (paramView.getTop() < 0) {
      i = j + paramView.getTop();
    }
    j = i;
    if (paramView.getBottom() > this.mEY) {
      j = i - (paramView.getBottom() - this.mEY);
    }
    if (j / paramView.getHeight() > 0.5D)
    {
      AppMethodBeat.o(195515);
      return true;
    }
    AppMethodBeat.o(195515);
    return false;
  }
  
  public static String n(z paramz)
  {
    AppMethodBeat.i(195513);
    p.h(paramz, "$this$keyWithExpandStatus");
    paramz = paramz.getId() + '-' + paramz.field_isExpand;
    AppMethodBeat.o(195513);
    return paramz;
  }
  
  public final void a(int paramInt1, int paramInt2, ListView paramListView, final f paramf)
  {
    AppMethodBeat.i(195514);
    p.h(paramListView, "listView");
    p.h(paramf, "report");
    int j = 0;
    if (paramInt1 <= paramInt2)
    {
      int i = paramInt1;
      paramInt1 = j;
      if (i == 0) {
        paramInt1 += 1;
      }
      for (;;)
      {
        if (i == paramInt2) {
          break label226;
        }
        i += 1;
        break;
        j = paramInt1 + 1;
        final View localView = paramListView.getChildAt(paramInt1);
        if (localView == null)
        {
          paramInt1 = j;
        }
        else
        {
          Object localObject2 = localView.getTag();
          Object localObject1 = localObject2;
          if (!(localObject2 instanceof com.tencent.mm.plugin.brandservice.ui.timeline.item.a)) {
            localObject1 = null;
          }
          localObject1 = (com.tencent.mm.plugin.brandservice.ui.timeline.item.a)localObject1;
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.a)localObject1).psm;
            if (localObject1 != null) {}
          }
          else
          {
            AppMethodBeat.o(195514);
            return;
          }
          if ((this.pyN.containsKey(((z)localObject1).getId())) && (!this.pyO.containsKey(n((z)localObject1))) && (dx(localView)))
          {
            ((Map)this.pyO).put(n((z)localObject1), Boolean.TRUE);
            h.RTc.n((Runnable)new b(this, localView, (z)localObject1, paramf), 500L);
          }
          paramInt1 = j;
        }
      }
    }
    label226:
    AppMethodBeat.o(195514);
  }
  
  public final void cnl()
  {
    AppMethodBeat.i(195516);
    if (this.pyR)
    {
      AppMethodBeat.o(195516);
      return;
    }
    this.pyR = true;
    h.RTc.a((Runnable)new c(this), 1000L, "BizTimeLineExpose");
    AppMethodBeat.o(195516);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(b paramb, View paramView, z paramz, f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(195511);
      Object localObject2 = localView.getTag();
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof com.tencent.mm.plugin.brandservice.ui.timeline.item.a)) {
        localObject1 = null;
      }
      localObject2 = (com.tencent.mm.plugin.brandservice.ui.timeline.item.a)localObject1;
      if (localObject2 == null)
      {
        AppMethodBeat.o(195511);
        return;
      }
      localObject1 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.a)localObject2).psm;
      if (localObject1 == null)
      {
        AppMethodBeat.o(195511);
        return;
      }
      final int i = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.a)localObject2).position;
      if ((p.j(b.n((z)localObject1), b.n(this.prL))) && ((localView.isShown()) || (localView.isAttachedToWindow())))
      {
        b.b(this.pyT).remove(b.n(this.prL));
        localObject2 = this.pyT;
        String str = this.prL.getId();
        p.g(str, "info.id");
        p.h(str, "id");
        ((b)localObject2).pyN.remove(str);
        Log.v("MicroMsg.BizTimeLineExposeHelper", "doUpdateReadStatus on expose " + this.prL.getId());
        if (!b.c(this.pyT).containsKey(b.n((z)localObject1))) {
          this.pyT.cnl();
        }
        ((Map)b.c(this.pyT)).put(b.n((z)localObject1), Boolean.TRUE);
        h.RTc.b((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(195510);
            this.pyV.prI.c(this.pyV.prL, i);
            AppMethodBeat.o(195510);
          }
        }, "BizTimeLineExpose");
      }
      AppMethodBeat.o(195511);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(195512);
      this.pyT.pyR = false;
      try
      {
        Object localObject1 = (Map)this.pyT.pyQ;
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
        localObject2 = this.pyT.pyQ.entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          f.b localb = (f.b)((Map.Entry)((Iterator)localObject2).next()).getValue();
          if (!Util.isNullOrNil(localb.psI))
          {
            MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
            localb.KVl = MPVideoPreviewMgr.aiL(localb.psI);
            localMPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
            localb.KVm = MPVideoPreviewMgr.aiM(localb.psI);
          }
          ((LinkedList)localObject1).add(localb);
        }
        this.pyT.pyQ.clear();
      }
      finally
      {
        AppMethodBeat.o(195512);
      }
      Log.i("MicroMsg.BizTimeLineExposeHelper", "reportExpose size = " + localLinkedList.size());
      Object localObject2 = g.aAg();
      p.g(localObject2, "MMKernel.network()");
      ((com.tencent.mm.kernel.b)localObject2).azz().b((q)new k(localLinkedList, this.pyT.pqZ.psq, this.pyT.pqZ.psr, this.pyT.pqZ.dEb, this.pyT.pqZ.pss, 1, 0));
      AppMethodBeat.o(195512);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.b
 * JD-Core Version:    0.7.0.1
 */