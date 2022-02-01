package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.lifecycle.j;
import androidx.lifecycle.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ao.a;
import com.tencent.mm.ui.base.v;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderTipsBubbleWindow;", "T", "Lcom/tencent/mm/ui/base/MMPopupWindow;", "context", "Landroid/content/Context;", "onClickListener", "Lcom/tencent/mm/plugin/finder/view/FinderTipsBubbleWindow$OnClickListener;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/view/FinderTipsBubbleWindow$OnClickListener;)V", "autoDismissTime", "", "dismissRunnable", "Lkotlin/Function0;", "", "hasMeasure", "", "item", "Ljava/lang/Object;", "leftTipsContainer", "Landroid/widget/LinearLayout;", "getLeftTipsContainer", "()Landroid/widget/LinearLayout;", "menuLayout", "Landroid/view/View;", "getOnClickListener", "()Lcom/tencent/mm/plugin/finder/view/FinderTipsBubbleWindow$OnClickListener;", "popupPadding", "", "rightMargin", "tipsTv", "Landroid/widget/TextView;", "topMargin", "vArrow", "dismiss", "setAutoDismissTimeMs", "time", "setGone", "setItem", "(Ljava/lang/Object;)V", "setPopupPadding", "padding", "setPopupRightMargin", "setPopupTopMargin", "setTips", "tips", "Landroid/text/SpannableString;", "tipsId", "", "setTipsTextSize", "size", "", "setVisible", "showWith", "anchor", "showWithBottom", "Companion", "OnClickListener", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u<T>
  extends v
{
  public static final u.a GDs;
  public final TextView DMt;
  private final kotlin.g.a.a<ah> GDA;
  private final u.b<T> GDt;
  private final View GDu;
  private final LinearLayout GDv;
  private final View GDw;
  private boolean GDx;
  private int GDy;
  public long GDz;
  public int bmu;
  public final Context context;
  
  static
  {
    AppMethodBeat.i(344455);
    GDs = new u.a((byte)0);
    AppMethodBeat.o(344455);
  }
  
  private u(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(344401);
    this.context = paramContext;
    this.GDt = null;
    this.GDy = 5;
    this.GDz = 10000L;
    setContentView(LayoutInflater.from(this.context).inflate(e.f.finder_tips_bubble_window_layout, null));
    setClippingEnabled(false);
    paramContext = getContentView().findViewById(e.e.tv_tips);
    s.s(paramContext, "contentView.findViewById(R.id.tv_tips)");
    this.DMt = ((TextView)paramContext);
    paramContext = getContentView().findViewById(e.e.v_arrow);
    s.s(paramContext, "contentView.findViewById(R.id.v_arrow)");
    this.GDu = paramContext;
    paramContext = getContentView().findViewById(e.e.tips_left_container);
    s.s(paramContext, "contentView.findViewById(R.id.tips_left_container)");
    this.GDv = ((LinearLayout)paramContext);
    paramContext = getContentView().findViewById(e.e.menu_content);
    s.s(paramContext, "contentView.findViewById(R.id.menu_content)");
    this.GDw = paramContext;
    setOutsideTouchable(true);
    getContentView().setOnClickListener(new u..ExternalSyntheticLambda0(this));
    if ((this.context instanceof MMActivity)) {
      ((MMActivity)this.context).getLifecycle().addObserver((p)new FinderTipsBubbleWindow.2(this));
    }
    this.GDA = ((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(344401);
  }
  
  private static final void a(u paramu, View paramView)
  {
    AppMethodBeat.i(344423);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramu);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderTipsBubbleWindow", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramu, "this$0");
    paramu.dismiss();
    paramView = paramu.getContentView();
    if (paramView != null) {
      paramView.removeCallbacks(new u..ExternalSyntheticLambda3(paramu.GDA));
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderTipsBubbleWindow", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(344423);
  }
  
  private static final void bA(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(344440);
    s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(344440);
  }
  
  private static final void bx(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(344413);
    s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(344413);
  }
  
  private static final void by(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(344426);
    s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(344426);
  }
  
  private static final void bz(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(344435);
    s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(344435);
  }
  
  public final void dUX()
  {
    AppMethodBeat.i(344498);
    View localView = getContentView();
    if (localView != null) {
      localView.setVisibility(0);
    }
    AppMethodBeat.o(344498);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(344478);
    super.dismiss();
    View localView = getContentView();
    if (localView != null) {
      localView.removeCallbacks(new u..ExternalSyntheticLambda2(this.GDA));
    }
    AppMethodBeat.o(344478);
  }
  
  public final void gX(View paramView)
  {
    AppMethodBeat.i(344481);
    s.u(paramView, "anchor");
    if (!this.GDx)
    {
      getContentView().measure(0, 0);
      this.GDx = true;
    }
    int i = getContentView().getMeasuredWidth();
    int j = getContentView().getMeasuredHeight();
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    Object localObject = ao.mX(this.context);
    int k = ((ao.a)localObject).width;
    int m = ((ao.a)localObject).height;
    int i1 = com.tencent.mm.cd.a.fromDPToPix(this.context, 16);
    int n = arrayOfInt[1] - j;
    i1 = k - i - i1;
    localObject = this.GDu.getLayoutParams();
    if (localObject == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(344481);
      throw paramView;
    }
    localObject = (RelativeLayout.LayoutParams)localObject;
    ((RelativeLayout.LayoutParams)localObject).setMarginStart(arrayOfInt[0] + paramView.getWidth() / 2 - i1 - this.GDu.getMeasuredWidth() / 2);
    if (((RelativeLayout.LayoutParams)localObject).getMarginStart() < 0)
    {
      s.X("invalid loc:", Integer.valueOf(((RelativeLayout.LayoutParams)localObject).getMarginStart()));
      dismiss();
      AppMethodBeat.o(344481);
      return;
    }
    setAnimationStyle(e.i.TipsBubbleAnim);
    showAtLocation(paramView, 0, i1, n);
    if (this.GDz > 0L)
    {
      paramView = getContentView();
      if (paramView != null) {
        paramView.postDelayed(new u..ExternalSyntheticLambda1(this.GDA), this.GDz);
      }
    }
    paramView = am.aixg;
    s.s(String.format("popX:%s, popY:%s, sw:%s, sh:%s, pw:%s, ph:%s", Arrays.copyOf(new Object[] { Integer.valueOf(i1), Integer.valueOf(n), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j) }, 6)), "java.lang.String.format(format, *args)");
    AppMethodBeat.o(344481);
  }
  
  public final void gY(View paramView)
  {
    AppMethodBeat.i(344490);
    s.u(paramView, "anchor");
    if (!this.GDx)
    {
      getContentView().measure(0, 0);
      this.GDx = true;
    }
    int i = getContentView().getMeasuredWidth();
    int j = getContentView().getMeasuredHeight();
    int k = paramView.getHeight();
    int i2 = paramView.getWidth();
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    ao.a locala = ao.mX(this.context);
    int m = locala.width;
    int n = locala.height;
    int i1 = arrayOfInt[1];
    i2 = m - i - this.bmu - i2;
    setAnimationStyle(e.i.TipsBubbleAnim);
    showAtLocation(paramView, 0, i2, k + i1);
    if (this.GDz > 0L)
    {
      paramView = getContentView();
      if (paramView != null) {
        paramView.postDelayed(new u..ExternalSyntheticLambda4(this.GDA), this.GDz);
      }
    }
    paramView = am.aixg;
    s.s(String.format("popX:%s, popY:%s, sw:%s, sh:%s, pw:%s, ph:%s", Arrays.copyOf(new Object[] { Integer.valueOf(i2), Integer.valueOf(i1), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(j) }, 6)), "java.lang.String.format(format, *args)");
    AppMethodBeat.o(344490);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    c(u<T> paramu)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.u
 * JD-Core Version:    0.7.0.1
 */