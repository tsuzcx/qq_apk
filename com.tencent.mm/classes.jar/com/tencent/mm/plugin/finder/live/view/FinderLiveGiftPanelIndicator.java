package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveGiftPanelIndicator;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "INDICATOR_H", "getINDICATOR_H", "()I", "INDICATOR_MARGIN", "getINDICATOR_MARGIN", "INDICATOR_W", "getINDICATOR_W", "TAG", "", "indicatorList", "Ljava/util/ArrayList;", "Landroid/widget/ImageView;", "Lkotlin/collections/ArrayList;", "getIndicatorList", "()Ljava/util/ArrayList;", "attachViewPager", "", "viewpager", "Landroidx/viewpager/widget/ViewPager;", "init", "setCurrentChoosedIndicator", "choosedIndicator", "setIndicatorSize", "indicatorSize", "plugin-finder_release"})
public final class FinderLiveGiftPanelIndicator
  extends LinearLayout
{
  private final String TAG;
  private final int yUi;
  private final int yUj;
  private final int yUk;
  private final ArrayList<ImageView> yUl;
  
  public FinderLiveGiftPanelIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(289145);
    this.TAG = "FinderLiveGiftPanelIndicator";
    paramContext = MMApplicationContext.getContext();
    p.j(paramContext, "MMApplicationContext.getContext()");
    this.yUi = paramContext.getResources().getDimensionPixelOffset(b.d.Edge_A);
    this.yUj = this.yUi;
    paramContext = MMApplicationContext.getContext();
    p.j(paramContext, "MMApplicationContext.getContext()");
    this.yUk = paramContext.getResources().getDimensionPixelOffset(b.d.Edge_0_5_A);
    this.yUl = new ArrayList();
    setOrientation(0);
    AppMethodBeat.o(289145);
  }
  
  public FinderLiveGiftPanelIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(289147);
    this.TAG = "FinderLiveGiftPanelIndicator";
    paramContext = MMApplicationContext.getContext();
    p.j(paramContext, "MMApplicationContext.getContext()");
    this.yUi = paramContext.getResources().getDimensionPixelOffset(b.d.Edge_A);
    this.yUj = this.yUi;
    paramContext = MMApplicationContext.getContext();
    p.j(paramContext, "MMApplicationContext.getContext()");
    this.yUk = paramContext.getResources().getDimensionPixelOffset(b.d.Edge_0_5_A);
    this.yUl = new ArrayList();
    setOrientation(0);
    AppMethodBeat.o(289147);
  }
  
  public final int getINDICATOR_H()
  {
    return this.yUj;
  }
  
  public final int getINDICATOR_MARGIN()
  {
    return this.yUk;
  }
  
  public final int getINDICATOR_W()
  {
    return this.yUi;
  }
  
  public final ArrayList<ImageView> getIndicatorList()
  {
    return this.yUl;
  }
  
  public final void setCurrentChoosedIndicator(int paramInt)
  {
    AppMethodBeat.i(289144);
    int j = this.yUl.size();
    int i = 0;
    if (i < j)
    {
      if (i == paramInt) {
        ((ImageView)this.yUl.get(i)).setImageResource(b.e.finder_live_indicator_light_round_bg);
      }
      for (;;)
      {
        i += 1;
        break;
        ((ImageView)this.yUl.get(i)).setImageResource(b.e.finder_live_round_dark_btn_bg);
      }
    }
    AppMethodBeat.o(289144);
  }
  
  public final void setIndicatorSize(int paramInt)
  {
    AppMethodBeat.i(289142);
    removeAllViews();
    this.yUl.clear();
    Log.i(this.TAG, "setIndicatorSize indicatorSize:".concat(String.valueOf(paramInt)));
    if (paramInt < 2)
    {
      AppMethodBeat.o(289142);
      return;
    }
    int i = 0;
    while (i < paramInt)
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.yUi, this.yUj);
      localLayoutParams.setMargins(this.yUk, 0, this.yUk, 0);
      localLayoutParams.gravity = 16;
      ImageView localImageView = new ImageView(getContext());
      localImageView.setImageResource(b.e.finder_live_round_dark_btn_bg);
      localImageView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      addView((View)localImageView);
      this.yUl.add(localImageView);
      i += 1;
    }
    AppMethodBeat.o(289142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveGiftPanelIndicator
 * JD-Core Version:    0.7.0.1
 */