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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveGiftPanelIndicator;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "INDICATOR_H", "getINDICATOR_H", "()I", "INDICATOR_MARGIN", "getINDICATOR_MARGIN", "INDICATOR_W", "getINDICATOR_W", "TAG", "", "indicatorList", "Ljava/util/ArrayList;", "Landroid/widget/ImageView;", "Lkotlin/collections/ArrayList;", "getIndicatorList", "()Ljava/util/ArrayList;", "attachViewPager", "", "viewpager", "Landroid/support/v4/view/ViewPager;", "init", "setCurrentChoosedIndicator", "choosedIndicator", "setIndicatorSize", "indicatorSize", "plugin-finder_release"})
public final class FinderLiveGiftPanelIndicator
  extends LinearLayout
{
  private final String TAG;
  private final int uyr;
  private final int uys;
  private final int uyt;
  private final ArrayList<ImageView> uyu;
  
  public FinderLiveGiftPanelIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(247448);
    this.TAG = "FinderLiveGiftPanelIndicator";
    paramContext = MMApplicationContext.getContext();
    p.g(paramContext, "MMApplicationContext.getContext()");
    this.uyr = paramContext.getResources().getDimensionPixelOffset(2131165314);
    this.uys = this.uyr;
    paramContext = MMApplicationContext.getContext();
    p.g(paramContext, "MMApplicationContext.getContext()");
    this.uyt = paramContext.getResources().getDimensionPixelOffset(2131165277);
    this.uyu = new ArrayList();
    setOrientation(0);
    AppMethodBeat.o(247448);
  }
  
  public FinderLiveGiftPanelIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(247449);
    this.TAG = "FinderLiveGiftPanelIndicator";
    paramContext = MMApplicationContext.getContext();
    p.g(paramContext, "MMApplicationContext.getContext()");
    this.uyr = paramContext.getResources().getDimensionPixelOffset(2131165314);
    this.uys = this.uyr;
    paramContext = MMApplicationContext.getContext();
    p.g(paramContext, "MMApplicationContext.getContext()");
    this.uyt = paramContext.getResources().getDimensionPixelOffset(2131165277);
    this.uyu = new ArrayList();
    setOrientation(0);
    AppMethodBeat.o(247449);
  }
  
  public final int getINDICATOR_H()
  {
    return this.uys;
  }
  
  public final int getINDICATOR_MARGIN()
  {
    return this.uyt;
  }
  
  public final int getINDICATOR_W()
  {
    return this.uyr;
  }
  
  public final ArrayList<ImageView> getIndicatorList()
  {
    return this.uyu;
  }
  
  public final void setCurrentChoosedIndicator(int paramInt)
  {
    AppMethodBeat.i(247447);
    int j = this.uyu.size();
    int i = 0;
    if (i < j)
    {
      if (i == paramInt) {
        ((ImageView)this.uyu.get(i)).setImageResource(2131232611);
      }
      for (;;)
      {
        i += 1;
        break;
        ((ImageView)this.uyu.get(i)).setImageResource(2131232635);
      }
    }
    AppMethodBeat.o(247447);
  }
  
  public final void setIndicatorSize(int paramInt)
  {
    AppMethodBeat.i(247446);
    removeAllViews();
    this.uyu.clear();
    Log.i(this.TAG, "setIndicatorSize indicatorSize:".concat(String.valueOf(paramInt)));
    if (paramInt < 2)
    {
      AppMethodBeat.o(247446);
      return;
    }
    int i = 0;
    while (i < paramInt)
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.uyr, this.uys);
      localLayoutParams.setMargins(this.uyt, 0, this.uyt, 0);
      localLayoutParams.gravity = 16;
      ImageView localImageView = new ImageView(getContext());
      localImageView.setImageResource(2131232635);
      localImageView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      addView((View)localImageView);
      this.uyu.add(localImageView);
      i += 1;
    }
    AppMethodBeat.o(247446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveGiftPanelIndicator
 * JD-Core Version:    0.7.0.1
 */