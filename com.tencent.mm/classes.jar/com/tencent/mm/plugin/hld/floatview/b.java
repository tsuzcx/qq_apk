package com.tencent.mm.plugin.hld.floatview;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.e.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.q;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/floatview/ImeClickFloatView;", "Lcom/tencent/mm/plugin/hld/floatview/IImeFloatView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "allView", "Lcom/tencent/mm/plugin/hld/floatview/ImeFloatViewClickBg;", "getAllView", "()Lcom/tencent/mm/plugin/hld/floatview/ImeFloatViewClickBg;", "allView$delegate", "Lkotlin/Lazy;", "getContext", "()Landroid/content/Context;", "delayHideFuture", "Lcom/tencent/threadpool/runnable/FutureEx;", "leftView", "getLeftView", "leftView$delegate", "mAnchorView", "Landroid/view/View;", "mCompositionStr", "", "mFloatCompositionWidow", "Landroid/widget/PopupWindow;", "mLeftUpperTextTv", "Landroid/widget/TextView;", "getMLeftUpperTextTv", "()Landroid/widget/TextView;", "mLeftUpperTextTv$delegate", "mRightUpperTextTv", "getMRightUpperTextTv", "mRightUpperTextTv$delegate", "mUpperLeftRl", "Landroid/widget/RelativeLayout;", "getMUpperLeftRl", "()Landroid/widget/RelativeLayout;", "mUpperLeftRl$delegate", "mUpperRightRl", "getMUpperRightRl", "mUpperRightRl$delegate", "mUpperTextTv", "getMUpperTextTv", "mUpperTextTv$delegate", "rightView", "getRightView", "rightView$delegate", "rootView", "getRootView", "()Landroid/view/View;", "rootView$delegate", "onHide", "", "end", "", "delayMs", "", "onHideImpl", "onShowView", "textList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "keyboard", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;", "button", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "lastKeyOperation", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$KeyOperation;", "parent", "Lcom/tencent/mm/plugin/hld/view/ImeKeyRelativeLayout;", "anchorView", "Lcom/tencent/mm/plugin/hld/keyboard/KeyOperation;", "Companion", "plugin-hld_release"})
public final class b
  implements a
{
  public static final a DwV;
  private final f DwJ;
  private final f DwK;
  private final f DwL;
  private final f DwM;
  public PopupWindow DwN;
  private final f DwO;
  private final f DwP;
  private final f DwQ;
  private final f DwR;
  private final f DwS;
  public String DwT;
  private d<?> DwU;
  public final Context context;
  public View lJ;
  
  static
  {
    AppMethodBeat.i(216720);
    DwV = new a((byte)0);
    AppMethodBeat.o(216720);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(216719);
    this.context = paramContext;
    this.DwJ = g.ar((kotlin.g.a.a)new k(this));
    this.DwK = g.ar((kotlin.g.a.a)new b(this));
    this.DwL = g.ar((kotlin.g.a.a)new c(this));
    this.DwM = g.ar((kotlin.g.a.a)new j(this));
    this.DwO = g.ar((kotlin.g.a.a)new h(this));
    this.DwP = g.ar((kotlin.g.a.a)new d(this));
    this.DwQ = g.ar((kotlin.g.a.a)new e(this));
    this.DwR = g.ar((kotlin.g.a.a)new f(this));
    this.DwS = g.ar((kotlin.g.a.a)new g(this));
    paramContext = new PopupWindow(getRootView());
    paramContext.setClippingEnabled(false);
    paramContext.setInputMethodMode(2);
    paramContext.setTouchable(false);
    if (Build.VERSION.SDK_INT >= 23)
    {
      com.tencent.mm.plugin.hld.f.l locall = com.tencent.mm.plugin.hld.f.l.DHK;
      paramContext.setWindowLayoutType(1003);
    }
    this.DwN = paramContext;
    AppMethodBeat.o(216719);
  }
  
  private final void eDs()
  {
    AppMethodBeat.i(216718);
    PopupWindow localPopupWindow = this.DwN;
    if (localPopupWindow != null)
    {
      localPopupWindow.dismiss();
      AppMethodBeat.o(216718);
      return;
    }
    AppMethodBeat.o(216718);
  }
  
  private final View getRootView()
  {
    AppMethodBeat.i(216706);
    View localView = (View)this.DwJ.getValue();
    AppMethodBeat.o(216706);
    return localView;
  }
  
  public final ImeFloatViewClickBg eDk()
  {
    AppMethodBeat.i(216707);
    ImeFloatViewClickBg localImeFloatViewClickBg = (ImeFloatViewClickBg)this.DwK.getValue();
    AppMethodBeat.o(216707);
    return localImeFloatViewClickBg;
  }
  
  public final ImeFloatViewClickBg eDl()
  {
    AppMethodBeat.i(216709);
    ImeFloatViewClickBg localImeFloatViewClickBg = (ImeFloatViewClickBg)this.DwL.getValue();
    AppMethodBeat.o(216709);
    return localImeFloatViewClickBg;
  }
  
  public final ImeFloatViewClickBg eDm()
  {
    AppMethodBeat.i(216710);
    ImeFloatViewClickBg localImeFloatViewClickBg = (ImeFloatViewClickBg)this.DwM.getValue();
    AppMethodBeat.o(216710);
    return localImeFloatViewClickBg;
  }
  
  public final TextView eDn()
  {
    AppMethodBeat.i(216712);
    TextView localTextView = (TextView)this.DwO.getValue();
    AppMethodBeat.o(216712);
    return localTextView;
  }
  
  public final TextView eDo()
  {
    AppMethodBeat.i(216713);
    TextView localTextView = (TextView)this.DwP.getValue();
    AppMethodBeat.o(216713);
    return localTextView;
  }
  
  public final TextView eDp()
  {
    AppMethodBeat.i(216714);
    TextView localTextView = (TextView)this.DwQ.getValue();
    AppMethodBeat.o(216714);
    return localTextView;
  }
  
  public final RelativeLayout eDq()
  {
    AppMethodBeat.i(216715);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.DwR.getValue();
    AppMethodBeat.o(216715);
    return localRelativeLayout;
  }
  
  public final RelativeLayout eDr()
  {
    AppMethodBeat.i(216716);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.DwS.getValue();
    AppMethodBeat.o(216716);
    return localRelativeLayout;
  }
  
  public final void i(final boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(216717);
    d locald = this.DwU;
    if (locald != null) {
      locald.cancel(false);
    }
    this.DwU = null;
    if (paramLong == 0L)
    {
      eDs();
      AppMethodBeat.o(216717);
      return;
    }
    this.DwU = h.ZvG.n((Runnable)new i(this, paramBoolean), paramLong);
    AppMethodBeat.o(216717);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/floatview/ImeClickFloatView$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/hld/floatview/ImeFloatViewClickBg;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<ImeFloatViewClickBg>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/hld/floatview/ImeFloatViewClickBg;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<ImeFloatViewClickBg>
  {
    c(b paramb)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<TextView>
  {
    d(b paramb)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<TextView>
  {
    e(b paramb)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<RelativeLayout>
  {
    f(b paramb)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<RelativeLayout>
  {
    g(b paramb)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<TextView>
  {
    h(b paramb)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(b paramb, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(209965);
      b.a(this.DwW);
      AppMethodBeat.o(209965);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/hld/floatview/ImeFloatViewClickBg;", "kotlin.jvm.PlatformType", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<ImeFloatViewClickBg>
  {
    j(b paramb)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<View>
  {
    k(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.floatview.b
 * JD-Core Version:    0.7.0.1
 */