package com.tencent.mm.plugin.hld.floatview;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import com.tencent.threadpool.i.d;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/floatview/ImeClickFloatView;", "Lcom/tencent/mm/plugin/hld/floatview/IImeFloatView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "allView", "Lcom/tencent/mm/plugin/hld/floatview/ImeFloatViewClickBg;", "getAllView", "()Lcom/tencent/mm/plugin/hld/floatview/ImeFloatViewClickBg;", "allView$delegate", "Lkotlin/Lazy;", "getContext", "()Landroid/content/Context;", "delayHideFuture", "Lcom/tencent/threadpool/runnable/FutureEx;", "leftView", "getLeftView", "leftView$delegate", "mAnchorView", "Landroid/view/View;", "mCompositionStr", "", "mFloatCompositionWidow", "Landroid/widget/PopupWindow;", "mLeftUpperTextTv", "Landroid/widget/TextView;", "getMLeftUpperTextTv", "()Landroid/widget/TextView;", "mLeftUpperTextTv$delegate", "mRightUpperTextTv", "getMRightUpperTextTv", "mRightUpperTextTv$delegate", "mUpperLeftRl", "Landroid/widget/RelativeLayout;", "getMUpperLeftRl", "()Landroid/widget/RelativeLayout;", "mUpperLeftRl$delegate", "mUpperRightRl", "getMUpperRightRl", "mUpperRightRl$delegate", "mUpperTextTv", "getMUpperTextTv", "mUpperTextTv$delegate", "rightView", "getRightView", "rightView$delegate", "rootView", "getRootView", "()Landroid/view/View;", "rootView$delegate", "onHide", "", "end", "", "delayMs", "", "onHideImpl", "onShowView", "textList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "keyboard", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView;", "button", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/ImeButton;", "lastKeyOperation", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardView$KeyOperation;", "parent", "Lcom/tencent/mm/plugin/hld/view/ImeKeyRelativeLayout;", "anchorView", "Lcom/tencent/mm/plugin/hld/keyboard/KeyOperation;", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements a
{
  public static final b.a JpP;
  private final j JpQ;
  private final j JpR;
  private final j JpS;
  private final j JpT;
  public PopupWindow JpU;
  private final j JpV;
  private final j JpW;
  private final j JpX;
  private final j JpY;
  private final j JpZ;
  public String Jqa;
  private d<?> Jqb;
  public final Context context;
  public View mF;
  
  static
  {
    AppMethodBeat.i(312848);
    JpP = new b.a((byte)0);
    AppMethodBeat.o(312848);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(312803);
    this.context = paramContext;
    this.JpQ = k.cm((kotlin.g.a.a)new j(this));
    this.JpR = k.cm((kotlin.g.a.a)new b(this));
    this.JpS = k.cm((kotlin.g.a.a)new c(this));
    this.JpT = k.cm((kotlin.g.a.a)new i(this));
    this.JpV = k.cm((kotlin.g.a.a)new h(this));
    this.JpW = k.cm((kotlin.g.a.a)new d(this));
    this.JpX = k.cm((kotlin.g.a.a)new e(this));
    this.JpY = k.cm((kotlin.g.a.a)new f(this));
    this.JpZ = k.cm((kotlin.g.a.a)new g(this));
    paramContext = new PopupWindow(getRootView());
    paramContext.setClippingEnabled(false);
    paramContext.setInputMethodMode(2);
    paramContext.setTouchable(false);
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject = l.JyV;
      paramContext.setWindowLayoutType(l.fOG());
    }
    Object localObject = ah.aiuX;
    this.JpU = paramContext;
    AppMethodBeat.o(312803);
  }
  
  private static final void a(b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(312827);
    s.u(paramb, "this$0");
    paramb.fLs();
    AppMethodBeat.o(312827);
  }
  
  private final void fLs()
  {
    AppMethodBeat.i(312819);
    PopupWindow localPopupWindow = this.JpU;
    if (localPopupWindow != null) {
      localPopupWindow.dismiss();
    }
    AppMethodBeat.o(312819);
  }
  
  private final View getRootView()
  {
    AppMethodBeat.i(312814);
    Object localObject = this.JpQ.getValue();
    s.s(localObject, "<get-rootView>(...)");
    localObject = (View)localObject;
    AppMethodBeat.o(312814);
    return localObject;
  }
  
  public final ImeFloatViewClickBg fLk()
  {
    AppMethodBeat.i(312865);
    Object localObject = this.JpR.getValue();
    s.s(localObject, "<get-allView>(...)");
    localObject = (ImeFloatViewClickBg)localObject;
    AppMethodBeat.o(312865);
    return localObject;
  }
  
  public final ImeFloatViewClickBg fLl()
  {
    AppMethodBeat.i(312872);
    Object localObject = this.JpS.getValue();
    s.s(localObject, "<get-leftView>(...)");
    localObject = (ImeFloatViewClickBg)localObject;
    AppMethodBeat.o(312872);
    return localObject;
  }
  
  public final ImeFloatViewClickBg fLm()
  {
    AppMethodBeat.i(312886);
    Object localObject = this.JpT.getValue();
    s.s(localObject, "<get-rightView>(...)");
    localObject = (ImeFloatViewClickBg)localObject;
    AppMethodBeat.o(312886);
    return localObject;
  }
  
  public final TextView fLn()
  {
    AppMethodBeat.i(312898);
    Object localObject = this.JpV.getValue();
    s.s(localObject, "<get-mUpperTextTv>(...)");
    localObject = (TextView)localObject;
    AppMethodBeat.o(312898);
    return localObject;
  }
  
  public final TextView fLo()
  {
    AppMethodBeat.i(312909);
    Object localObject = this.JpW.getValue();
    s.s(localObject, "<get-mLeftUpperTextTv>(...)");
    localObject = (TextView)localObject;
    AppMethodBeat.o(312909);
    return localObject;
  }
  
  public final TextView fLp()
  {
    AppMethodBeat.i(312919);
    Object localObject = this.JpX.getValue();
    s.s(localObject, "<get-mRightUpperTextTv>(...)");
    localObject = (TextView)localObject;
    AppMethodBeat.o(312919);
    return localObject;
  }
  
  public final RelativeLayout fLq()
  {
    AppMethodBeat.i(312929);
    Object localObject = this.JpY.getValue();
    s.s(localObject, "<get-mUpperLeftRl>(...)");
    localObject = (RelativeLayout)localObject;
    AppMethodBeat.o(312929);
    return localObject;
  }
  
  public final RelativeLayout fLr()
  {
    AppMethodBeat.i(312939);
    Object localObject = this.JpZ.getValue();
    s.s(localObject, "<get-mUpperRightRl>(...)");
    localObject = (RelativeLayout)localObject;
    AppMethodBeat.o(312939);
    return localObject;
  }
  
  public final void l(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(312952);
    d locald = this.Jqb;
    if (locald != null) {
      locald.cancel(false);
    }
    this.Jqb = null;
    if (paramLong == 0L)
    {
      fLs();
      AppMethodBeat.o(312952);
      return;
    }
    this.Jqb = h.ahAA.o(new b..ExternalSyntheticLambda0(this, paramBoolean), paramLong);
    AppMethodBeat.o(312952);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/hld/floatview/ImeFloatViewClickBg;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ImeFloatViewClickBg>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/hld/floatview/ImeFloatViewClickBg;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ImeFloatViewClickBg>
  {
    c(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<TextView>
  {
    d(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<TextView>
  {
    e(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    f(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    g(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<TextView>
  {
    h(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/hld/floatview/ImeFloatViewClickBg;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ImeFloatViewClickBg>
  {
    i(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<View>
  {
    j(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.floatview.b
 * JD-Core Version:    0.7.0.1
 */