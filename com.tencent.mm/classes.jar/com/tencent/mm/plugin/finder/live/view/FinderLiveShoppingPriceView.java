package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.view.convert.k;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.aoj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShoppingPriceView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "label", "Landroid/widget/TextView;", "getLabel", "()Landroid/widget/TextView;", "originalPrice", "getOriginalPrice", "price", "getPrice", "priceContainer", "Landroid/view/ViewGroup;", "getPriceContainer", "()Landroid/view/ViewGroup;", "update", "", "item", "Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowShelfProductItem;", "config", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShoppingPriceView$Config;", "forceShowOriginalPrice", "", "Companion", "Config", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveShoppingPriceView
  extends FrameLayout
{
  public static final a DPr;
  private static final b DPv;
  private final ViewGroup DPs;
  private final TextView DPt;
  private final TextView DPu;
  private final TextView wCa;
  
  static
  {
    AppMethodBeat.i(357544);
    DPr = new a((byte)0);
    DPv = new b(a.fromDPToPix(MMApplicationContext.getContext(), 17.0F), a.fromDPToPix(MMApplicationContext.getContext(), 12.0F), a.ms(MMApplicationContext.getContext()));
    AppMethodBeat.o(357544);
  }
  
  public FinderLiveShoppingPriceView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(357517);
    addView(LayoutInflater.from(getContext()).inflate(p.f.CfH, (ViewGroup)this, false), -2, -2);
    paramContext = findViewById(p.e.BZG);
    s.s(paramContext, "findViewById(R.id.price_container)");
    this.DPs = ((ViewGroup)paramContext);
    paramContext = findViewById(p.e.BZQ);
    s.s(paramContext, "findViewById(R.id.product_price)");
    this.wCa = ((TextView)paramContext);
    paramContext = findViewById(p.e.BCW);
    s.s(paramContext, "findViewById(R.id.exclusive_label)");
    this.DPt = ((TextView)paramContext);
    paramContext = findViewById(p.e.BZd);
    s.s(paramContext, "findViewById(R.id.original_price)");
    this.DPu = ((TextView)paramContext);
    paramContext = aw.Gjk;
    aw.f(this.wCa, false);
    paramContext = aw.Gjk;
    aw.f(this.DPu, false);
    this.DPu.getPaint().setFlags(16);
    AppMethodBeat.o(357517);
  }
  
  public FinderLiveShoppingPriceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(357524);
    addView(LayoutInflater.from(getContext()).inflate(p.f.CfH, (ViewGroup)this, false), -2, -2);
    paramContext = findViewById(p.e.BZG);
    s.s(paramContext, "findViewById(R.id.price_container)");
    this.DPs = ((ViewGroup)paramContext);
    paramContext = findViewById(p.e.BZQ);
    s.s(paramContext, "findViewById(R.id.product_price)");
    this.wCa = ((TextView)paramContext);
    paramContext = findViewById(p.e.BCW);
    s.s(paramContext, "findViewById(R.id.exclusive_label)");
    this.DPt = ((TextView)paramContext);
    paramContext = findViewById(p.e.BZd);
    s.s(paramContext, "findViewById(R.id.original_price)");
    this.DPu = ((TextView)paramContext);
    paramContext = aw.Gjk;
    aw.f(this.wCa, false);
    paramContext = aw.Gjk;
    aw.f(this.DPu, false);
    this.DPu.getPaint().setFlags(16);
    AppMethodBeat.o(357524);
  }
  
  public final void a(k paramk, b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(357580);
    s.u(paramk, "item");
    s.u(paramb, "config");
    aoj localaoj = paramk.ewd();
    this.wCa.setTextSize(0, paramb.DPw);
    this.DPt.setTextSize(0, paramb.DPx);
    this.DPu.setTextSize(0, paramb.DPx);
    if (localaoj != null)
    {
      this.DPu.setVisibility(0);
      this.DPs.setBackgroundResource(p.d.BAN);
      this.DPt.setVisibility(0);
      a.a(this.wCa, localaoj.MRD, localaoj.MRD);
      a.a(this.DPu, paramk.DVn, paramk.DVo);
      if (!paramBoolean)
      {
        measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        if (getMeasuredWidth() > paramb.maxWidth)
        {
          this.DPu.setVisibility(8);
          AppMethodBeat.o(357580);
        }
      }
    }
    else
    {
      this.DPu.setVisibility(8);
      this.DPs.setBackground(null);
      this.DPt.setVisibility(8);
      a.a(this.wCa, paramk.DVn, paramk.DVo);
    }
    AppMethodBeat.o(357580);
  }
  
  public final TextView getLabel()
  {
    return this.DPt;
  }
  
  public final TextView getOriginalPrice()
  {
    return this.DPu;
  }
  
  public final TextView getPrice()
  {
    return this.wCa;
  }
  
  public final ViewGroup getPriceContainer()
  {
    return this.DPs;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShoppingPriceView$Companion;", "", "()V", "DEFAULT_CONFIG", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShoppingPriceView$Config;", "getDEFAULT_CONFIG", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShoppingPriceView$Config;", "TAG", "", "getConfigForMaxWidth", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowShelfProductItem;", "maxWidthPx", "", "getPriceAreaLength", "", "setProductPrice", "", "priceTv", "Landroid/widget/TextView;", "maxPrice", "minPrice", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static FinderLiveShoppingPriceView.b a(Context paramContext, k paramk, float paramFloat)
    {
      AppMethodBeat.i(357562);
      s.u(paramContext, "context");
      s.u(paramk, "item");
      FinderLiveShoppingPriceView localFinderLiveShoppingPriceView = new FinderLiveShoppingPriceView(paramContext);
      FinderLiveShoppingPriceView.b localb = new FinderLiveShoppingPriceView.b(a.fromDPToPix(MMApplicationContext.getContext(), 17.0F), a.fromDPToPix(MMApplicationContext.getContext(), 12.0F), paramFloat);
      localFinderLiveShoppingPriceView.a(paramk, localb, true);
      localFinderLiveShoppingPriceView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      paramk = localb;
      if (localFinderLiveShoppingPriceView.getMeasuredWidth() > paramFloat) {
        paramk = new FinderLiveShoppingPriceView.b(a.fromDPToPix(paramContext, 15.0F), a.fromDPToPix(paramContext, 10.0F), paramFloat);
      }
      AppMethodBeat.o(357562);
      return paramk;
    }
    
    public static void a(TextView paramTextView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(357575);
      s.u(paramTextView, "priceTv");
      Resources localResources = MMApplicationContext.getContext().getResources();
      int i = p.h.finder_live_shopping_price;
      aw localaw = aw.Gjk;
      paramTextView.setText((CharSequence)localResources.getString(i, new Object[] { aw.Uu(paramInt2) }));
      if ((paramInt2 > paramInt1) || (paramInt2 < 0)) {
        Log.i("Finder.LiveShoppingListAdapter", "invalid price,min:" + paramInt2 + ",max:" + paramInt1);
      }
      AppMethodBeat.o(357575);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShoppingPriceView$Config;", "", "priceSizePx", "", "labelSizePx", "maxWidth", "(FFF)V", "getLabelSizePx", "()F", "getMaxWidth", "getPriceSizePx", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    final float DPw;
    final float DPx;
    final float maxWidth;
    
    public b(float paramFloat1, float paramFloat2, float paramFloat3)
    {
      this.DPw = paramFloat1;
      this.DPx = paramFloat2;
      this.maxWidth = paramFloat3;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(357582);
      if (this == paramObject)
      {
        AppMethodBeat.o(357582);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(357582);
        return false;
      }
      paramObject = (b)paramObject;
      if (!s.p(Float.valueOf(this.DPw), Float.valueOf(paramObject.DPw)))
      {
        AppMethodBeat.o(357582);
        return false;
      }
      if (!s.p(Float.valueOf(this.DPx), Float.valueOf(paramObject.DPx)))
      {
        AppMethodBeat.o(357582);
        return false;
      }
      if (!s.p(Float.valueOf(this.maxWidth), Float.valueOf(paramObject.maxWidth)))
      {
        AppMethodBeat.o(357582);
        return false;
      }
      AppMethodBeat.o(357582);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(357572);
      int i = Float.floatToIntBits(this.DPw);
      int j = Float.floatToIntBits(this.DPx);
      int k = Float.floatToIntBits(this.maxWidth);
      AppMethodBeat.o(357572);
      return (i * 31 + j) * 31 + k;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(357563);
      String str = "Config(priceSizePx=" + this.DPw + ", labelSizePx=" + this.DPx + ", maxWidth=" + this.maxWidth + ')';
      AppMethodBeat.o(357563);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveShoppingPriceView
 * JD-Core Version:    0.7.0.1
 */