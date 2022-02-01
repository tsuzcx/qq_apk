package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.ag;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.x;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCanvas;", "", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "TAG", "", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "canvasView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvasView;", "getCanvasView", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvasView;", "canvasView$delegate", "Lkotlin/Lazy;", "hasProcessCrash", "", "newTipsLayout", "Landroid/widget/LinearLayout;", "getNewTipsLayout", "()Landroid/widget/LinearLayout;", "newTipsLayout$delegate", "topLayout", "getTopLayout", "topLayout$delegate", "viewParent", "Landroid/view/ViewGroup;", "getViewParent", "()Landroid/view/ViewGroup;", "viewParent$delegate", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "pos", "", "convertView", "Landroid/view/View;", "parent", "getView", "resetUnReadIfNeed", "Companion", "plugin-brandservice_release"})
public final class k
{
  private static final f odd;
  public static final k.a ode;
  public final String TAG;
  private final Context context;
  public final b obC;
  private final f ocY;
  public final f ocZ;
  public final f oda;
  public final f odb;
  public boolean odc;
  
  static
  {
    AppMethodBeat.i(209723);
    ode = new k.a((byte)0);
    odd = g.O((a)b.odf);
    AppMethodBeat.o(209723);
  }
  
  public k(Context paramContext, b paramb)
  {
    AppMethodBeat.i(209722);
    this.context = paramContext;
    this.obC = paramb;
    this.TAG = "MicroMsg.BizTLRecCanvas";
    this.ocY = g.O((a)new g(this));
    this.ocZ = g.O((a)new c(this));
    this.oda = g.O((a)new f(this));
    this.odb = g.O((a)new d(this));
    AppMethodBeat.o(209722);
  }
  
  public static void h(w paramw)
  {
    AppMethodBeat.i(209721);
    x localx = ag.aGf();
    p.g(localx, "SubCoreBiz.getBizTimeLineInfoStorage()");
    long l = localx.fpt();
    if (paramw.fpb() == l)
    {
      AppMethodBeat.o(209721);
      return;
    }
    if ((paramw.field_status != 4) || (paramw.field_hasShow != 1))
    {
      paramw.field_status = 4;
      paramw.field_hasShow = 1;
      h.LTJ.aR((Runnable)new e(paramw));
    }
    AppMethodBeat.o(209721);
  }
  
  public final ViewGroup bOD()
  {
    AppMethodBeat.i(209720);
    ViewGroup localViewGroup = (ViewGroup)this.ocY.getValue();
    AppMethodBeat.o(209720);
    return localViewGroup;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine;", "invoke"})
  static final class b
    extends d.g.b.q
    implements a<q>
  {
    public static final b odf;
    
    static
    {
      AppMethodBeat.i(209713);
      odf = new b();
      AppMethodBeat.o(209713);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvasView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends d.g.b.q
    implements a<BizTLRecCardCanvasView>
  {
    c(k paramk)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/LinearLayout;", "invoke"})
  static final class d
    extends d.g.b.q
    implements a<LinearLayout>
  {
    d(k paramk)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(w paramw) {}
    
    public final void run()
    {
      AppMethodBeat.i(209717);
      ag.aGf().q(this.ocJ);
      AppMethodBeat.o(209717);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/LinearLayout;", "invoke"})
  static final class f
    extends d.g.b.q
    implements a<LinearLayout>
  {
    f(k paramk)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/ViewGroup;", "invoke"})
  static final class g
    extends d.g.b.q
    implements a<ViewGroup>
  {
    g(k paramk)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.k
 * JD-Core Version:    0.7.0.1
 */