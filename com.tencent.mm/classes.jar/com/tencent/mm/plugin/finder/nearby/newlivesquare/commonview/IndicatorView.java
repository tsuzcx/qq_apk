package com.tencent.mm.plugin.finder.nearby.newlivesquare.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.nearby.f.c;
import com.tencent.mm.plugin.finder.nearby.f.d;
import com.tencent.mm.plugin.finder.nearby.f.e;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/commonview/IndicatorView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "views", "", "Landroid/view/View;", "setPointCount", "", "count", "", "setSelectPoint", "selectIndex", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class IndicatorView
  extends LinearLayout
{
  public static final a akia;
  private static final int akib;
  private final List<View> FaY;
  
  static
  {
    AppMethodBeat.i(370465);
    akia = new a((byte)0);
    akib = a.fromDPToPix(MMApplicationContext.getContext(), 6);
    AppMethodBeat.o(370465);
  }
  
  public IndicatorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(370463);
    LinearLayout.inflate(paramContext, f.e.akhq, (ViewGroup)this);
    this.FaY = ((List)new ArrayList());
    AppMethodBeat.o(370463);
  }
  
  public final void setPointCount(int paramInt)
  {
    AppMethodBeat.i(370466);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(f.d.akhm);
    localLinearLayout.removeAllViews();
    this.FaY.clear();
    int i;
    if (paramInt > 0) {
      i = 1;
    }
    for (;;)
    {
      View localView = new View(getContext());
      localView.setBackgroundResource(f.c.finder_stagged_feed_banner_indicator_normal);
      int j = akib;
      localView.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(j, j));
      this.FaY.add(localView);
      localLinearLayout.addView(localView);
      if (i == paramInt)
      {
        AppMethodBeat.o(370466);
        return;
      }
      i += 1;
    }
  }
  
  public final void setSelectPoint(int paramInt)
  {
    AppMethodBeat.i(370468);
    Object localObject1 = (Iterable)this.FaY;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        p.kkW();
      }
      localObject2 = (View)localObject2;
      if (i == paramInt) {}
      for (int j = f.c.finder_stagged_feed_banner_indicator_select;; j = f.c.finder_stagged_feed_banner_indicator_normal)
      {
        ((View)localObject2).setBackgroundResource(j);
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(370468);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/commonview/IndicatorView$Companion;", "", "()V", "DP_6", "", "getDP_6", "()I", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.commonview.IndicatorView
 * JD-Core Version:    0.7.0.1
 */