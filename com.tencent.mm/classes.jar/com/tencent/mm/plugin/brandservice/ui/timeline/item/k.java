package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.x;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCanvas;", "", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "canvasView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvasView;", "getCanvasView", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvasView;", "canvasView$delegate", "Lkotlin/Lazy;", "newTipsLayout", "Landroid/widget/LinearLayout;", "getNewTipsLayout", "()Landroid/widget/LinearLayout;", "newTipsLayout$delegate", "topLayout", "getTopLayout", "topLayout$delegate", "viewParent", "Landroid/view/ViewGroup;", "getViewParent", "()Landroid/view/ViewGroup;", "viewParent$delegate", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "pos", "", "convertView", "Landroid/view/View;", "parent", "getView", "resetUnReadIfNeed", "Companion", "plugin-brandservice_release"})
public final class k
{
  private static final f oiR;
  public static final k.a oiS;
  private final Context context;
  public final b ohs;
  private final f oiN;
  public final f oiO;
  public final f oiP;
  public final f oiQ;
  
  static
  {
    AppMethodBeat.i(208697);
    oiS = new k.a((byte)0);
    oiR = g.O((a)k.b.oiT);
    AppMethodBeat.o(208697);
  }
  
  public k(Context paramContext, b paramb)
  {
    AppMethodBeat.i(208696);
    this.context = paramContext;
    this.ohs = paramb;
    this.oiN = g.O((a)new g(this));
    this.oiO = g.O((a)new c(this));
    this.oiP = g.O((a)new f(this));
    this.oiQ = g.O((a)new d(this));
    AppMethodBeat.o(208696);
  }
  
  public static void h(w paramw)
  {
    AppMethodBeat.i(208695);
    x localx = ag.aGv();
    p.g(localx, "SubCoreBiz.getBizTimeLineInfoStorage()");
    long l = localx.fts();
    if (paramw.fsY() == l)
    {
      AppMethodBeat.o(208695);
      return;
    }
    if ((paramw.field_status != 4) || (paramw.field_hasShow != 1))
    {
      paramw.field_status = 4;
      paramw.field_hasShow = 1;
      h.MqF.aO((Runnable)new e(paramw));
    }
    AppMethodBeat.o(208695);
  }
  
  public final ViewGroup bPB()
  {
    AppMethodBeat.i(208694);
    ViewGroup localViewGroup = (ViewGroup)this.oiN.getValue();
    AppMethodBeat.o(208694);
    return localViewGroup;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardCanvasView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements a<BizTLRecCardCanvasView>
  {
    c(k paramk)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/LinearLayout;", "invoke"})
  static final class d
    extends q
    implements a<LinearLayout>
  {
    d(k paramk)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(w paramw) {}
    
    public final void run()
    {
      AppMethodBeat.i(208691);
      ag.aGv().b(this.oiy, false);
      AppMethodBeat.o(208691);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/LinearLayout;", "invoke"})
  static final class f
    extends q
    implements a<LinearLayout>
  {
    f(k paramk)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/ViewGroup;", "invoke"})
  static final class g
    extends q
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