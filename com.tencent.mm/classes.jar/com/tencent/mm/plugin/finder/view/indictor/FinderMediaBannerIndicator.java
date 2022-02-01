package com.tencent.mm.plugin.finder.view.indictor;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.h;
import com.tencent.mm.view.h.a;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaBannerIndicator;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/view/IMediaBannerIndicator;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "count", "currentIndex", "indicatorLeft", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getIndicatorLeft", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "indicatorLeft$delegate", "Lkotlin/Lazy;", "indicatorRight", "getIndicatorRight", "indicatorRight$delegate", "indicatorTv", "Landroid/widget/TextView;", "getIndicatorTv", "()Landroid/widget/TextView;", "indicatorTv$delegate", "isShowOnlyOneIndicator", "", "onSelectedPageListener", "Lcom/tencent/mm/view/IMediaBannerIndicator$OnSelectedPageListener;", "getCount", "getCurrentIndex", "getOnSelectedPageListener", "getView", "Landroid/view/View;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setCount", "", "setCurrentIndex", "i", "setOnSelectedPageListener", "listener", "setShowOnlyOneIndicator", "isShow", "plugin-finder_release"})
public final class FinderMediaBannerIndicator
  extends LinearLayout
  implements h
{
  private final f BeD;
  private final f BeE;
  private final f BeF;
  private h.a BeG;
  private boolean BeH;
  private int count;
  private int currentIndex;
  
  public FinderMediaBannerIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(284984);
    LayoutInflater.from(getContext()).inflate(b.g.finder_media_banner_indicator_layout, (ViewGroup)this, true);
    this.BeD = g.ar((a)new c(this));
    this.BeE = g.ar((a)new a(this));
    this.BeF = g.ar((a)new b(this));
    this.BeH = true;
    AppMethodBeat.o(284984);
  }
  
  public FinderMediaBannerIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(284985);
    LayoutInflater.from(getContext()).inflate(b.g.finder_media_banner_indicator_layout, (ViewGroup)this, true);
    this.BeD = g.ar((a)new c(this));
    this.BeE = g.ar((a)new a(this));
    this.BeF = g.ar((a)new b(this));
    this.BeH = true;
    AppMethodBeat.o(284985);
  }
  
  private final WeImageView getIndicatorLeft()
  {
    AppMethodBeat.i(284977);
    WeImageView localWeImageView = (WeImageView)this.BeE.getValue();
    AppMethodBeat.o(284977);
    return localWeImageView;
  }
  
  private final WeImageView getIndicatorRight()
  {
    AppMethodBeat.i(284978);
    WeImageView localWeImageView = (WeImageView)this.BeF.getValue();
    AppMethodBeat.o(284978);
    return localWeImageView;
  }
  
  private final TextView getIndicatorTv()
  {
    AppMethodBeat.i(284976);
    TextView localTextView = (TextView)this.BeD.getValue();
    AppMethodBeat.o(284976);
    return localTextView;
  }
  
  public final int getCount()
  {
    return this.count;
  }
  
  public final int getCurrentIndex()
  {
    return this.currentIndex;
  }
  
  public final h.a getOnSelectedPageListener()
  {
    return this.BeG;
  }
  
  public final View getView()
  {
    return (View)this;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(284979);
    p.k(paramMotionEvent, "event");
    if (paramMotionEvent.getAction() == 1)
    {
      if (paramMotionEvent.getX() > getWidth() / 2) {
        break label69;
      }
      if (this.currentIndex > 0)
      {
        paramMotionEvent = this.BeG;
        if (paramMotionEvent != null) {
          paramMotionEvent.Mc(this.currentIndex - 1);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(284979);
      return true;
      label69:
      if (this.currentIndex + 1 < this.count)
      {
        paramMotionEvent = this.BeG;
        if (paramMotionEvent != null) {
          paramMotionEvent.Mc(this.currentIndex + 1);
        }
      }
    }
  }
  
  public final void setCount(int paramInt)
  {
    AppMethodBeat.i(284980);
    this.count = paramInt;
    setCurrentIndex(0);
    AppMethodBeat.o(284980);
  }
  
  public final void setCurrentIndex(int paramInt)
  {
    AppMethodBeat.i(284981);
    if (paramInt + 1 > this.count) {}
    for (int i = 0;; i = paramInt)
    {
      WeImageView localWeImageView;
      Context localContext;
      if (this.count == 1)
      {
        localWeImageView = getIndicatorRight();
        localContext = getContext();
        p.j(localContext, "context");
        localWeImageView.setIconColor(localContext.getResources().getColor(b.c.hot_tab_BW_100_Alpha_0_2));
        localWeImageView = getIndicatorLeft();
        localContext = getContext();
        p.j(localContext, "context");
        localWeImageView.setIconColor(localContext.getResources().getColor(b.c.hot_tab_BW_100_Alpha_0_2));
      }
      for (;;)
      {
        this.currentIndex = paramInt;
        getIndicatorTv().setText((CharSequence)(i + 1 + " / " + this.count));
        AppMethodBeat.o(284981);
        return;
        if (i == 0)
        {
          localWeImageView = getIndicatorLeft();
          localContext = getContext();
          p.j(localContext, "context");
          localWeImageView.setIconColor(localContext.getResources().getColor(b.c.hot_tab_BW_100_Alpha_0_2));
          localWeImageView = getIndicatorRight();
          localContext = getContext();
          p.j(localContext, "context");
          localWeImageView.setIconColor(localContext.getResources().getColor(b.c.hot_tab_BW_100_Alpha_0_8));
        }
        else if (paramInt + 1 == this.count)
        {
          localWeImageView = getIndicatorRight();
          localContext = getContext();
          p.j(localContext, "context");
          localWeImageView.setIconColor(localContext.getResources().getColor(b.c.hot_tab_BW_100_Alpha_0_2));
          localWeImageView = getIndicatorLeft();
          localContext = getContext();
          p.j(localContext, "context");
          localWeImageView.setIconColor(localContext.getResources().getColor(b.c.hot_tab_BW_100_Alpha_0_8));
        }
      }
    }
  }
  
  public final void setOnSelectedPageListener(h.a parama)
  {
    AppMethodBeat.i(284983);
    p.k(parama, "listener");
    this.BeG = parama;
    AppMethodBeat.o(284983);
  }
  
  public final void setShowOnlyOneIndicator(boolean paramBoolean)
  {
    this.BeH = paramBoolean;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements a<WeImageView>
  {
    a(FinderMediaBannerIndicator paramFinderMediaBannerIndicator)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements a<WeImageView>
  {
    b(FinderMediaBannerIndicator paramFinderMediaBannerIndicator)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements a<TextView>
  {
    c(FinderMediaBannerIndicator paramFinderMediaBannerIndicator)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.indictor.FinderMediaBannerIndicator
 * JD-Core Version:    0.7.0.1
 */