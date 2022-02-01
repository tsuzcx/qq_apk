package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.q.cc;
import com.tencent.mm.plugin.finder.live.utils.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveGiftPanelIndicator;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "INDICATOR_H", "getINDICATOR_H", "()I", "INDICATOR_MARGIN", "getINDICATOR_MARGIN", "INDICATOR_W", "getINDICATOR_W", "TAG", "", "indicatorList", "Ljava/util/ArrayList;", "Landroid/widget/ImageView;", "Lkotlin/collections/ArrayList;", "getIndicatorList", "()Ljava/util/ArrayList;", "attachViewPager", "", "viewpager", "Landroidx/viewpager/widget/ViewPager;", "init", "setCurrentChoosedIndicator", "choosedIndicator", "setIndicatorSize", "indicatorSize", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveGiftPanelIndicator
  extends LinearLayout
{
  private final int DNA;
  private final int DNB;
  private final int DNC;
  private final ArrayList<ImageView> DND;
  private final String TAG;
  
  public FinderLiveGiftPanelIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(357503);
    this.TAG = "FinderLiveGiftPanelIndicator";
    this.DNA = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_A);
    this.DNB = this.DNA;
    this.DNC = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_0_5_A);
    this.DND = new ArrayList();
    setOrientation(0);
    AppMethodBeat.o(357503);
  }
  
  public FinderLiveGiftPanelIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(357510);
    this.TAG = "FinderLiveGiftPanelIndicator";
    this.DNA = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_A);
    this.DNB = this.DNA;
    this.DNC = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_0_5_A);
    this.DND = new ArrayList();
    setOrientation(0);
    AppMethodBeat.o(357510);
  }
  
  public final int getINDICATOR_H()
  {
    return this.DNB;
  }
  
  public final int getINDICATOR_MARGIN()
  {
    return this.DNC;
  }
  
  public final int getINDICATOR_W()
  {
    return this.DNA;
  }
  
  public final ArrayList<ImageView> getIndicatorList()
  {
    return this.DND;
  }
  
  public final void setCurrentChoosedIndicator(int paramInt)
  {
    AppMethodBeat.i(357543);
    int k = this.DND.size();
    int i = 0;
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      if (i == paramInt) {
        ((ImageView)this.DND.get(i)).setImageResource(p.d.BAh);
      }
      while (j >= k)
      {
        AppMethodBeat.o(357543);
        return;
        ((ImageView)this.DND.get(i)).setImageResource(p.d.BAK);
      }
      i = j;
    }
  }
  
  public final void setIndicatorSize(int paramInt)
  {
    AppMethodBeat.i(357535);
    removeAllViews();
    this.DND.clear();
    Log.i(this.TAG, s.X("setIndicatorSize indicatorSize:", Integer.valueOf(paramInt)));
    if (paramInt < 2)
    {
      AppMethodBeat.o(357535);
      return;
    }
    int i;
    if (paramInt > 0) {
      i = 0;
    }
    for (;;)
    {
      i += 1;
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.DNA, this.DNB);
      localLayoutParams.setMargins(this.DNC, 0, this.DNC, 0);
      localLayoutParams.gravity = 16;
      ImageView localImageView = new ImageView(getContext());
      localImageView.setImageResource(p.d.BAK);
      localImageView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      addView((View)localImageView);
      this.DND.add(localImageView);
      if (i >= paramInt)
      {
        AppMethodBeat.o(357535);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/view/FinderLiveGiftPanelIndicator$attachViewPager$1", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "p0", "", "onPageScrolled", "p1", "", "p2", "onPageSelected", "selectedIndex", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements ViewPager.OnPageChangeListener
  {
    public a(FinderLiveGiftPanelIndicator paramFinderLiveGiftPanelIndicator) {}
    
    public final void onPageScrollStateChanged(int paramInt) {}
    
    public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
    
    public final void onPageSelected(int paramInt)
    {
      AppMethodBeat.i(357714);
      this.DNE.setCurrentChoosedIndicator(paramInt);
      a locala = a.DJT;
      if (!a.bUx()) {
        k.Doi.a(q.cc.DEB, "", 0);
      }
      AppMethodBeat.o(357714);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveGiftPanelIndicator
 * JD-Core Version:    0.7.0.1
 */