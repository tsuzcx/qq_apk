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
import com.tencent.mm.plugin.finder.live.plugin.v;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveStatisticsWidget;", "", "context", "Landroid/content/Context;", "rootView", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "TAG", "", "textview", "Landroid/widget/TextView;", "hideStatistics", "", "showStatistics", "statistics", "plugin-finder_release"})
public final class m
{
  private final String TAG;
  public final TextView uHs;
  
  public m(final Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(248148);
    this.TAG = "Finder.LiveStatisticsWidget";
    this.uHs = new TextView(paramContext);
    ao.a((Paint)this.uHs.getPaint(), 0.8F);
    Object localObject = this.uHs;
    Context localContext = MMApplicationContext.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    ((TextView)localObject).setTextColor(localContext.getResources().getColor(2131099677));
    localObject = this.uHs;
    localContext = MMApplicationContext.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    ((TextView)localObject).setTextSize(0, localContext.getResources().getDimension(2131165220));
    this.uHs.setBackgroundResource(2131232648);
    this.uHs.setPadding(com.tencent.mm.view.d.e(MMApplicationContext.getContext(), 10.0F), this.uHs.getPaddingTop(), com.tencent.mm.view.d.e(MMApplicationContext.getContext(), 10.0F), this.uHs.getPaddingBottom());
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).topMargin = com.tencent.mm.view.d.e(MMApplicationContext.getContext(), 150.0F);
    paramViewGroup.addView((View)this.uHs, (ViewGroup.LayoutParams)localObject);
    paramViewGroup = this.uHs.getLayoutParams();
    double d = au.az(MMApplicationContext.getContext()).x;
    localObject = v.uoz;
    int i = (int)(d * v.dhd());
    if (i > 0) {
      paramViewGroup.width = i;
    }
    if ((paramViewGroup instanceof ViewGroup.MarginLayoutParams))
    {
      paramViewGroup = (ViewGroup.MarginLayoutParams)paramViewGroup;
      localObject = MMApplicationContext.getContext();
      p.g(localObject, "MMApplicationContext.getContext()");
      paramViewGroup.setMarginStart(((Context)localObject).getResources().getDimensionPixelOffset(2131165296));
    }
    this.uHs.setOnLongClickListener((View.OnLongClickListener)new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(248146);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveStatisticsWidget$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).axR());
        paramAnonymousView = new StringBuilder().append(this.uHt.uHs.getText()).append("cdnUrl:");
        localObject = com.tencent.mm.live.core.core.d.hwY;
        paramAnonymousView = com.tencent.mm.live.core.core.d.aCd() + '\n';
        localObject = MMApplicationContext.getContext().getSystemService("clipboard");
        if (localObject == null)
        {
          paramAnonymousView = new t("null cannot be cast to non-null type android.content.ClipboardManager");
          AppMethodBeat.o(248146);
          throw paramAnonymousView;
        }
        ((ClipboardManager)localObject).setText((CharSequence)paramAnonymousView);
        Toast.makeText(paramContext, (CharSequence)"copy done", 0).show();
        a.a(true, this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveStatisticsWidget$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(248146);
        return true;
      }
    });
    AppMethodBeat.o(248148);
  }
  
  public final void atZ(String paramString)
  {
    AppMethodBeat.i(248147);
    p.h(paramString, "statistics");
    this.uHs.setVisibility(0);
    this.uHs.setText((CharSequence)paramString);
    AppMethodBeat.o(248147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.m
 * JD-Core Version:    0.7.0.1
 */