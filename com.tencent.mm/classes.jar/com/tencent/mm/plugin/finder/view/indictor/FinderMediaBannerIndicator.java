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
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.i;
import com.tencent.mm.view.i.a;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaBannerIndicator;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/view/IMediaBannerIndicator;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "count", "currentIndex", "indicatorLeft", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getIndicatorLeft", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "indicatorLeft$delegate", "Lkotlin/Lazy;", "indicatorRight", "getIndicatorRight", "indicatorRight$delegate", "indicatorTv", "Landroid/widget/TextView;", "getIndicatorTv", "()Landroid/widget/TextView;", "indicatorTv$delegate", "isShowOnlyOneIndicator", "", "onSelectedPageListener", "Lcom/tencent/mm/view/IMediaBannerIndicator$OnSelectedPageListener;", "getCount", "getCurrentIndex", "getOnSelectedPageListener", "getView", "Landroid/view/View;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setCount", "", "setCurrentIndex", "i", "setOnSelectedPageListener", "listener", "setShowOnlyOneIndicator", "isShow", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderMediaBannerIndicator
  extends LinearLayout
  implements i
{
  private final j GHj;
  private final j GHk;
  private final j GHl;
  private i.a GHm;
  private boolean GHn;
  private int count;
  private int currentIndex;
  
  public FinderMediaBannerIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(345511);
    LayoutInflater.from(getContext()).inflate(e.f.finder_media_banner_indicator_layout, (ViewGroup)this, true);
    this.GHj = k.cm((a)new c(this));
    this.GHk = k.cm((a)new a(this));
    this.GHl = k.cm((a)new b(this));
    this.GHn = true;
    AppMethodBeat.o(345511);
  }
  
  public FinderMediaBannerIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(345521);
    LayoutInflater.from(getContext()).inflate(e.f.finder_media_banner_indicator_layout, (ViewGroup)this, true);
    this.GHj = k.cm((a)new c(this));
    this.GHk = k.cm((a)new a(this));
    this.GHl = k.cm((a)new b(this));
    this.GHn = true;
    AppMethodBeat.o(345521);
  }
  
  private final WeImageView getIndicatorLeft()
  {
    AppMethodBeat.i(345538);
    Object localObject = this.GHk.getValue();
    s.s(localObject, "<get-indicatorLeft>(...)");
    localObject = (WeImageView)localObject;
    AppMethodBeat.o(345538);
    return localObject;
  }
  
  private final WeImageView getIndicatorRight()
  {
    AppMethodBeat.i(345547);
    Object localObject = this.GHl.getValue();
    s.s(localObject, "<get-indicatorRight>(...)");
    localObject = (WeImageView)localObject;
    AppMethodBeat.o(345547);
    return localObject;
  }
  
  private final TextView getIndicatorTv()
  {
    AppMethodBeat.i(345528);
    Object localObject = this.GHj.getValue();
    s.s(localObject, "<get-indicatorTv>(...)");
    localObject = (TextView)localObject;
    AppMethodBeat.o(345528);
    return localObject;
  }
  
  public final int getCount()
  {
    return this.count;
  }
  
  public final int getCurrentIndex()
  {
    return this.currentIndex;
  }
  
  public final i.a getOnSelectedPageListener()
  {
    return this.GHm;
  }
  
  public final View getView()
  {
    return (View)this;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(345552);
    s.u(paramMotionEvent, "event");
    if (paramMotionEvent.getAction() == 1)
    {
      if (paramMotionEvent.getX() > getWidth() / 2) {
        break label69;
      }
      if (this.currentIndex > 0)
      {
        paramMotionEvent = this.GHm;
        if (paramMotionEvent != null) {
          paramMotionEvent.Ng(this.currentIndex - 1);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(345552);
      return true;
      label69:
      if (this.currentIndex + 1 < this.count)
      {
        paramMotionEvent = this.GHm;
        if (paramMotionEvent != null) {
          paramMotionEvent.Ng(this.currentIndex + 1);
        }
      }
    }
  }
  
  public final void setCount(int paramInt)
  {
    AppMethodBeat.i(345563);
    this.count = paramInt;
    setCurrentIndex(0);
    AppMethodBeat.o(345563);
  }
  
  public final void setCurrentIndex(int paramInt)
  {
    AppMethodBeat.i(345577);
    if (paramInt + 1 > this.count) {}
    for (int i = 0;; i = paramInt)
    {
      if (this.count == 1)
      {
        getIndicatorRight().setIconColor(getContext().getResources().getColor(e.b.hot_tab_BW_100_Alpha_0_2));
        getIndicatorLeft().setIconColor(getContext().getResources().getColor(e.b.hot_tab_BW_100_Alpha_0_2));
      }
      for (;;)
      {
        this.currentIndex = paramInt;
        getIndicatorTv().setText((CharSequence)(i + 1 + " / " + this.count));
        AppMethodBeat.o(345577);
        return;
        if (i == 0)
        {
          getIndicatorLeft().setIconColor(getContext().getResources().getColor(e.b.hot_tab_BW_100_Alpha_0_2));
          getIndicatorRight().setIconColor(getContext().getResources().getColor(e.b.hot_tab_BW_100_Alpha_0_8));
        }
        else if (paramInt + 1 == this.count)
        {
          getIndicatorRight().setIconColor(getContext().getResources().getColor(e.b.hot_tab_BW_100_Alpha_0_2));
          getIndicatorLeft().setIconColor(getContext().getResources().getColor(e.b.hot_tab_BW_100_Alpha_0_8));
        }
      }
    }
  }
  
  public final void setOnSelectedPageListener(i.a parama)
  {
    AppMethodBeat.i(345593);
    s.u(parama, "listener");
    this.GHm = parama;
    AppMethodBeat.o(345593);
  }
  
  public final void setShowOnlyOneIndicator(boolean paramBoolean)
  {
    this.GHn = paramBoolean;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<WeImageView>
  {
    a(FinderMediaBannerIndicator paramFinderMediaBannerIndicator)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<WeImageView>
  {
    b(FinderMediaBannerIndicator paramFinderMediaBannerIndicator)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
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