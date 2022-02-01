package com.tencent.mm.plugin.finder.live.widget;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.ax;
import com.tencent.mm.view.d;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveStatisticsWidget;", "", "context", "Landroid/content/Context;", "rootView", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "TAG", "", "cdnUrl", "textview", "Landroid/widget/TextView;", "hideStatistics", "", "setCdnUrl", "showStatistics", "statistics", "plugin-finder_release"})
public final class am
{
  private final String TAG;
  public String smT;
  public final TextView zrr;
  
  public am(final Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(289757);
    this.TAG = "Finder.LiveStatisticsWidget";
    this.zrr = new TextView(paramContext);
    this.smT = "";
    ar.a((Paint)this.zrr.getPaint(), 0.8F);
    Object localObject = this.zrr;
    Context localContext = MMApplicationContext.getContext();
    p.j(localContext, "MMApplicationContext.getContext()");
    ((TextView)localObject).setTextColor(localContext.getResources().getColor(b.c.BW_100_Alpha_0_5));
    localObject = this.zrr;
    localContext = MMApplicationContext.getContext();
    p.j(localContext, "MMApplicationContext.getContext()");
    ((TextView)localObject).setTextSize(0, localContext.getResources().getDimension(b.d.ChatLucyTitleTextSize));
    this.zrr.setBackgroundResource(b.e.finder_live_statictis_bg);
    this.zrr.setPadding(d.e(MMApplicationContext.getContext(), 10.0F), this.zrr.getPaddingTop(), d.e(MMApplicationContext.getContext(), 10.0F), this.zrr.getPaddingBottom());
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).topMargin = d.e(MMApplicationContext.getContext(), 150.0F);
    paramViewGroup.addView((View)this.zrr, (ViewGroup.LayoutParams)localObject);
    paramViewGroup = this.zrr.getLayoutParams();
    float f = ax.au(MMApplicationContext.getContext()).x;
    localObject = MMApplicationContext.getContext();
    p.j(localObject, "MMApplicationContext.getContext()");
    int i = (int)(f - ((Context)localObject).getResources().getDimensionPixelOffset(b.d.finder_live_last_option_margin));
    if (i > 0) {
      paramViewGroup.width = i;
    }
    if ((paramViewGroup instanceof ViewGroup.MarginLayoutParams))
    {
      paramViewGroup = (ViewGroup.MarginLayoutParams)paramViewGroup;
      localObject = MMApplicationContext.getContext();
      p.j(localObject, "MMApplicationContext.getContext()");
      paramViewGroup.setMarginStart(((Context)localObject).getResources().getDimensionPixelOffset(b.d.Edge_2A));
    }
    this.zrr.setOnLongClickListener((View.OnLongClickListener)new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(275185);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveStatisticsWidget$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).aFi());
        paramAnonymousView = am.a(this.zrs).getText() + "cdnUrl:" + am.b(this.zrs) + '\n';
        localObject = MMApplicationContext.getContext().getSystemService("clipboard");
        if (localObject == null)
        {
          paramAnonymousView = new t("null cannot be cast to non-null type android.content.ClipboardManager");
          AppMethodBeat.o(275185);
          throw paramAnonymousView;
        }
        ((ClipboardManager)localObject).setText((CharSequence)paramAnonymousView);
        Toast.makeText(paramContext, (CharSequence)"copy done", 0).show();
        a.a(true, this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveStatisticsWidget$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(275185);
        return true;
      }
    });
    AppMethodBeat.o(289757);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.am
 * JD-Core Version:    0.7.0.1
 */