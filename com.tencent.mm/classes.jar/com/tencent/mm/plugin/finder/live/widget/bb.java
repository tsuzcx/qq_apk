package com.tencent.mm.plugin.finder.live.widget;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.d;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveStatisticsWidget;", "", "context", "Landroid/content/Context;", "rootView", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "TAG", "", "cdnUrl", "imageView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "textview", "Landroid/widget/TextView;", "hideStatistics", "", "setCdnUrl", "setIconListener", "clickListener", "Landroid/view/View$OnClickListener;", "showStatistics", "statistics", "showStatisticsSpan", "span", "Landroid/text/SpannableStringBuilder;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bb
{
  public final TextView Euy;
  public final WeImageView Euz;
  private final String TAG;
  public String mOI;
  
  public bb(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(361328);
    this.TAG = "Finder.LiveStatisticsWidget";
    this.Euy = new TextView(paramContext);
    this.Euz = new WeImageView(paramContext);
    this.mOI = "";
    aw.a((Paint)this.Euy.getPaint(), 0.8F);
    this.Euy.setTextColor(MMApplicationContext.getContext().getResources().getColor(p.b.BW_100_Alpha_0_5));
    this.Euy.setTextSize(0, MMApplicationContext.getContext().getResources().getDimension(p.c.ChatLucyTitleTextSize));
    this.Euy.setBackgroundResource(p.d.BAP);
    this.Euy.setPadding(d.e(MMApplicationContext.getContext(), 10.0F), this.Euy.getPaddingTop(), d.e(MMApplicationContext.getContext(), 10.0F), this.Euy.getPaddingBottom());
    Object localObject = this.Euz;
    int j = p.g.icons_filled_close;
    Resources localResources = paramContext.getResources();
    int i;
    if (localResources == null)
    {
      i = -1;
      ((WeImageView)localObject).setImageDrawable(com.tencent.mm.ui.bb.m(paramContext, j, i));
      if (!(paramViewGroup instanceof RelativeLayout)) {
        break label406;
      }
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).topMargin = d.e(MMApplicationContext.getContext(), 150.0F);
      paramViewGroup.addView((View)this.Euy, (ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams((int)paramContext.getResources().getDimension(p.c.Edge_2_5_A), (int)paramContext.getResources().getDimension(p.c.Edge_2_5_A));
      ((RelativeLayout.LayoutParams)localObject).topMargin = d.e(MMApplicationContext.getContext(), 150.0F);
      paramViewGroup.addView((View)this.Euz, (ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      paramViewGroup = this.Euy.getLayoutParams();
      i = (int)(bf.bf(MMApplicationContext.getContext()).x - MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.finder_live_last_option_margin));
      if (i > 0) {
        paramViewGroup.width = i;
      }
      if ((paramViewGroup instanceof ViewGroup.MarginLayoutParams)) {
        ((ViewGroup.MarginLayoutParams)paramViewGroup).setMarginStart(MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_2A));
      }
      this.Euy.setOnLongClickListener(new bb..ExternalSyntheticLambda0(this, paramContext));
      AppMethodBeat.o(361328);
      return;
      i = localResources.getColor(p.b.BW_100_Alpha_0_5);
      break;
      label406:
      paramViewGroup.addView((View)this.Euy);
      paramViewGroup.addView((View)this.Euz);
    }
  }
  
  private static final boolean a(bb parambb, Context paramContext, View paramView)
  {
    AppMethodBeat.i(361343);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parambb);
    localb.cH(paramContext);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveStatisticsWidget", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    s.u(parambb, "this$0");
    s.u(paramContext, "$context");
    parambb = parambb.Euy.getText() + "cdnUrl:" + parambb.mOI + '\n';
    paramView = MMApplicationContext.getContext().getSystemService("clipboard");
    if (paramView == null)
    {
      parambb = new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
      AppMethodBeat.o(361343);
      throw parambb;
    }
    ((ClipboardManager)paramView).setText((CharSequence)parambb);
    Toast.makeText(paramContext, (CharSequence)"copy done", 0).show();
    a.a(true, new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveStatisticsWidget", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(361343);
    return true;
  }
  
  public final void hideStatistics()
  {
    AppMethodBeat.i(361361);
    this.Euy.setVisibility(8);
    this.Euz.setVisibility(8);
    AppMethodBeat.o(361361);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.bb
 * JD-Core Version:    0.7.0.1
 */