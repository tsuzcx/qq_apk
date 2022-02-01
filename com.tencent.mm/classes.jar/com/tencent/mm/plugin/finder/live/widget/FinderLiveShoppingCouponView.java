package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.view.convert.j;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingCouponView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "value", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingCouponView$Callback;", "callback", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingCouponView$Callback;", "setCallback", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingCouponView$Callback;)V", "item", "Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowCouponItem;", "root", "Landroid/view/View;", "kotlin.jvm.PlatformType", "fillWithCouponItem", "", "isAnchor", "", "removeActionButton", "setActionButtonState", "text", "", "enable", "active", "setTextSizeToFitMaxWidth", "textView", "Landroid/widget/TextView;", "maxWidth", "", "maxFontSize", "setupActionButton", "setupCenterText", "setupDiscountLabel", "Callback", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveShoppingCouponView
  extends FrameLayout
{
  public static final FinderLiveShoppingCouponView.b Eug;
  private j Euh;
  private a Eui;
  private final View lBX;
  
  static
  {
    AppMethodBeat.i(361311);
    Eug = new FinderLiveShoppingCouponView.b((byte)0);
    AppMethodBeat.o(361311);
  }
  
  public FinderLiveShoppingCouponView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(361251);
    this.lBX = LayoutInflater.from(paramContext).inflate(p.f.Cfz, (ViewGroup)this, false);
    addView(this.lBX, -1, -1);
    paramContext = aw.Gjk;
    paramContext = findViewById(p.e.BCM);
    s.s(paramContext, "findViewById<TextView>(R.id.discount)");
    aw.f((TextView)paramContext, true);
    paramContext = aw.Gjk;
    paramContext = findViewById(p.e.BCN);
    s.s(paramContext, "findViewById<TextView>(R.id.discount_desc)");
    aw.f((TextView)paramContext, false);
    paramContext = com.tencent.mm.plugin.finder.accessibility.a.Ate;
    paramContext = this.lBX.getContext();
    s.s(paramContext, "root.context");
    float f = com.tencent.mm.plugin.finder.accessibility.a.g(paramContext, 14.0F);
    ((TextView)findViewById(p.e.title)).setTextSize(1, f);
    paramContext = com.tencent.mm.plugin.finder.accessibility.a.Ate;
    paramContext = this.lBX.getContext();
    s.s(paramContext, "root.context");
    f = com.tencent.mm.plugin.finder.accessibility.a.g(paramContext, 12.0F);
    ((TextView)findViewById(p.e.Caj)).setTextSize(1, f);
    ((TextView)findViewById(p.e.desc)).setTextSize(1, f);
    AppMethodBeat.o(361251);
  }
  
  private final void a(j paramj, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(361261);
    Object localObject1 = (TextView)findViewById(p.e.BCN);
    int i;
    if (paramBoolean)
    {
      i = 0;
      ((TextView)localObject1).setVisibility(i);
      switch (paramj.type)
      {
      default: 
        label72:
        ((TextView)findViewById(p.e.BCN)).setText((CharSequence)paramj.DUY);
        paramj = findViewById(p.e.BCM);
        s.s(paramj, "findViewById<TextView>(R.id.discount)");
        paramj = (TextView)paramj;
        i = com.tencent.mm.cd.a.bs(getContext(), p.c.Bzp);
        localObject1 = getContext();
        if (!paramBoolean) {
          break;
        }
      }
    }
    for (float f = 32.0F;; f = 26.0F)
    {
      b(paramj, i, com.tencent.mm.cd.a.fromDPToPix((Context)localObject1, f));
      paramj = findViewById(p.e.BCN);
      s.s(paramj, "findViewById<TextView>(R.id.discount_desc)");
      b((TextView)paramj, com.tencent.mm.cd.a.bs(getContext(), p.c.Bzp), com.tencent.mm.cd.a.fromDPToPix(getContext(), 12));
      AppMethodBeat.o(361261);
      return;
      i = 8;
      break;
      localObject1 = (TextView)findViewById(p.e.BCM);
      Object localObject2 = am.aixg;
      localObject2 = com.tencent.mm.cd.a.bt(getContext(), p.h.Csv);
      s.s(localObject2, "getString(context, R.str…ping_coupon_money_prefix)");
      localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { paramj.DUX }, 1));
      s.s(localObject2, "java.lang.String.format(format, *args)");
      ((TextView)localObject1).setText((CharSequence)localObject2);
      break label72;
      localObject1 = am.aixg;
      localObject1 = com.tencent.mm.cd.a.bt(getContext(), p.h.Csu);
      s.s(localObject1, "getString(context, R.str…g_coupon_discount_subfix)");
      localObject1 = String.format((String)localObject1, Arrays.copyOf(new Object[] { paramj.DUX }, 1));
      s.s(localObject1, "java.lang.String.format(format, *args)");
      localObject2 = new SpannableString((CharSequence)localObject1);
      AbsoluteSizeSpan localAbsoluteSizeSpan = new AbsoluteSizeSpan(com.tencent.mm.cd.a.bs(getContext(), p.c.SmallTextSize));
      String str = paramj.DUX;
      if (str == null) {}
      for (i = j;; i = str.length())
      {
        ((SpannableString)localObject2).setSpan(localAbsoluteSizeSpan, i, ((String)localObject1).length(), 18);
        ((TextView)findViewById(p.e.BCM)).setText((CharSequence)localObject2);
        break;
      }
      ((TextView)findViewById(p.e.BCM)).setText((CharSequence)String.valueOf(paramj.DUX));
      break label72;
    }
  }
  
  private static final void a(FinderLiveShoppingCouponView paramFinderLiveShoppingCouponView, View paramView)
  {
    AppMethodBeat.i(361305);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderLiveShoppingCouponView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingCouponView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveShoppingCouponView, "this$0");
    Log.i("MicroMsg.FinderLiveShoppingCouponView", s.X("coupon action clicked: ", paramFinderLiveShoppingCouponView.Euh));
    paramView = paramFinderLiveShoppingCouponView.getCallback();
    if (paramView != null)
    {
      localObject = paramFinderLiveShoppingCouponView.Euh;
      s.checkNotNull(localObject);
      paramView.a((j)localObject, paramFinderLiveShoppingCouponView);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingCouponView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(361305);
  }
  
  private final void b(TextView paramTextView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(361286);
    CharSequence localCharSequence = paramTextView.getText();
    Paint localPaint = new Paint();
    localPaint.setTypeface(paramTextView.getTypeface());
    localPaint.setTextSize(paramInt2);
    while (localPaint.measureText(localCharSequence.toString()) > paramInt1) {
      localPaint.setTextSize(localPaint.getTextSize() - com.tencent.mm.cd.a.fromDPToPix(getContext(), 0.5F));
    }
    paramTextView.setTextSize(0, localPaint.getTextSize());
    AppMethodBeat.o(361286);
  }
  
  private final void b(j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(361271);
    Object localObject2 = (TextView)findViewById(p.e.title);
    if (paramBoolean) {}
    for (Object localObject1 = (CharSequence)paramj.title;; localObject1 = (CharSequence)paramj.DVb)
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      if (!paramBoolean) {
        break;
      }
      localObject1 = String.valueOf(paramj.DUZ);
      localObject2 = am.aixg;
      localObject2 = com.tencent.mm.cd.a.bt(getContext(), p.h.Csx);
      s.s(localObject2, "getString(context, R.str…e_shopping_coupon_remain)");
      localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { localObject1 }, 1));
      s.s(localObject2, "java.lang.String.format(format, *args)");
      localObject2 = new SpannableString((CharSequence)localObject2);
      int i = n.a((CharSequence)localObject2, (String)localObject1, 0, false, 6);
      ((SpannableString)localObject2).setSpan(new ForegroundColorSpan(com.tencent.mm.cd.a.w(getContext(), p.b.finder_live_logo_color)), i, ((String)localObject1).length() + i, 33);
      ((TextView)findViewById(p.e.Caj)).setText((CharSequence)localObject2);
      ((TextView)findViewById(p.e.Caj)).setVisibility(0);
      ((TextView)findViewById(p.e.desc)).setText((CharSequence)paramj.source);
      AppMethodBeat.o(361271);
      return;
    }
    ((TextView)findViewById(p.e.Caj)).setVisibility(8);
    ((TextView)findViewById(p.e.desc)).setText((CharSequence)paramj.DVa);
    AppMethodBeat.o(361271);
  }
  
  private final void c(j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(361278);
    if (paramBoolean)
    {
      if (paramj.DVc)
      {
        paramj = getContext().getString(p.h.Csq);
        s.s(paramj, "context.getString(R.stri…g_coupon_anchor_end_send)");
        h(paramj, true, false);
        AppMethodBeat.o(361278);
        return;
      }
      paramj = getContext().getString(p.h.Css);
      s.s(paramj, "context.getString(R.stri…pping_coupon_anchor_send)");
      h(paramj, true, true);
      AppMethodBeat.o(361278);
      return;
    }
    if ((paramj.DVd) || (!paramj.DVe))
    {
      h(paramj.DVf, false, false);
      AppMethodBeat.o(361278);
      return;
    }
    h(paramj.DVf, true, true);
    AppMethodBeat.o(361278);
  }
  
  private final void h(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(361295);
    TextView localTextView = (TextView)findViewById(p.e.action_btn);
    localTextView.setText((CharSequence)paramString);
    localTextView.setEnabled(paramBoolean1);
    if (!paramBoolean1)
    {
      localTextView.setTextColor(localTextView.getContext().getResources().getColor(p.b.UN_BW_0_Alpha_0_1));
      localTextView.setBackgroundResource(p.d.BAO);
      AppMethodBeat.o(361295);
      return;
    }
    if (paramBoolean2)
    {
      localTextView.setTextColor(localTextView.getContext().getResources().getColor(p.b.White));
      localTextView.setBackgroundResource(p.d.BzN);
      AppMethodBeat.o(361295);
      return;
    }
    localTextView.setTextColor(localTextView.getContext().getResources().getColor(p.b.finder_live_logo_color));
    localTextView.setBackgroundResource(p.d.BAO);
    AppMethodBeat.o(361295);
  }
  
  public final void a(j paramj, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(361344);
    s.u(paramj, "item");
    this.Euh = paramj;
    a(paramj, paramBoolean1);
    b(paramj, paramBoolean1);
    View localView = findViewById(p.e.action_btn);
    if (paramBoolean2) {}
    for (int i = 4;; i = 0)
    {
      localView.setVisibility(i);
      c(paramj, paramBoolean1);
      AppMethodBeat.o(361344);
      return;
    }
  }
  
  public final a getCallback()
  {
    return this.Eui;
  }
  
  public final void setCallback(a parama)
  {
    AppMethodBeat.i(361331);
    this.Eui = parama;
    findViewById(p.e.action_btn).setOnClickListener(new FinderLiveShoppingCouponView..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(361331);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingCouponView$Callback;", "", "onActionButtonClicked", "", "item", "Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowCouponItem;", "view", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingCouponView;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(j paramj, FinderLiveShoppingCouponView paramFinderLiveShoppingCouponView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.FinderLiveShoppingCouponView
 * JD-Core Version:    0.7.0.1
 */