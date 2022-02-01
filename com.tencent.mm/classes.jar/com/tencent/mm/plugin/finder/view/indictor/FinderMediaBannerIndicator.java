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
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.h;
import com.tencent.mm.view.h.a;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/indictor/FinderMediaBannerIndicator;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/view/IMediaBannerIndicator;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "count", "currentIndex", "indicatorLeft", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getIndicatorLeft", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "indicatorLeft$delegate", "Lkotlin/Lazy;", "indicatorRight", "getIndicatorRight", "indicatorRight$delegate", "indicatorTv", "Landroid/widget/TextView;", "getIndicatorTv", "()Landroid/widget/TextView;", "indicatorTv$delegate", "isShowOnlyOneIndicator", "", "onSelectedPageListener", "Lcom/tencent/mm/view/IMediaBannerIndicator$OnSelectedPageListener;", "getCount", "getCurrentIndex", "getOnSelectedPageListener", "getView", "Landroid/view/View;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setCount", "", "setCurrentIndex", "i", "setOnSelectedPageListener", "listener", "setShowOnlyOneIndicator", "isShow", "plugin-finder_release"})
public final class FinderMediaBannerIndicator
  extends LinearLayout
  implements h
{
  private int count;
  private int currentIndex;
  private final f wsl;
  private final f wsm;
  private final f wsn;
  private h.a wso;
  private boolean wsp;
  
  public FinderMediaBannerIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(255222);
    LayoutInflater.from(getContext()).inflate(2131494499, (ViewGroup)this, true);
    this.wsl = g.ah((a)new c(this));
    this.wsm = g.ah((a)new a(this));
    this.wsn = g.ah((a)new b(this));
    this.wsp = true;
    AppMethodBeat.o(255222);
  }
  
  public FinderMediaBannerIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(255223);
    LayoutInflater.from(getContext()).inflate(2131494499, (ViewGroup)this, true);
    this.wsl = g.ah((a)new c(this));
    this.wsm = g.ah((a)new a(this));
    this.wsn = g.ah((a)new b(this));
    this.wsp = true;
    AppMethodBeat.o(255223);
  }
  
  private final WeImageView getIndicatorLeft()
  {
    AppMethodBeat.i(255216);
    WeImageView localWeImageView = (WeImageView)this.wsm.getValue();
    AppMethodBeat.o(255216);
    return localWeImageView;
  }
  
  private final WeImageView getIndicatorRight()
  {
    AppMethodBeat.i(255217);
    WeImageView localWeImageView = (WeImageView)this.wsn.getValue();
    AppMethodBeat.o(255217);
    return localWeImageView;
  }
  
  private final TextView getIndicatorTv()
  {
    AppMethodBeat.i(255215);
    TextView localTextView = (TextView)this.wsl.getValue();
    AppMethodBeat.o(255215);
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
    return this.wso;
  }
  
  public final View getView()
  {
    return (View)this;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(255218);
    p.h(paramMotionEvent, "event");
    if (paramMotionEvent.getAction() == 1)
    {
      if (paramMotionEvent.getX() > getWidth() / 2) {
        break label69;
      }
      if (this.currentIndex > 0)
      {
        paramMotionEvent = this.wso;
        if (paramMotionEvent != null) {
          paramMotionEvent.Ir(this.currentIndex - 1);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(255218);
      return true;
      label69:
      if (this.currentIndex + 1 < this.count)
      {
        paramMotionEvent = this.wso;
        if (paramMotionEvent != null) {
          paramMotionEvent.Ir(this.currentIndex + 1);
        }
      }
    }
  }
  
  public final void setCount(int paramInt)
  {
    AppMethodBeat.i(255219);
    this.count = paramInt;
    setCurrentIndex(0);
    AppMethodBeat.o(255219);
  }
  
  public final void setCurrentIndex(int paramInt)
  {
    AppMethodBeat.i(255220);
    if (paramInt + 1 > this.count) {}
    for (int i = 0;; i = paramInt)
    {
      WeImageView localWeImageView;
      Context localContext;
      if (this.count == 1)
      {
        localWeImageView = getIndicatorRight();
        localContext = getContext();
        p.g(localContext, "context");
        localWeImageView.setIconColor(localContext.getResources().getColor(2131100613));
        localWeImageView = getIndicatorLeft();
        localContext = getContext();
        p.g(localContext, "context");
        localWeImageView.setIconColor(localContext.getResources().getColor(2131100613));
      }
      for (;;)
      {
        this.currentIndex = paramInt;
        getIndicatorTv().setText((CharSequence)(i + 1 + " / " + this.count));
        AppMethodBeat.o(255220);
        return;
        if (i == 0)
        {
          localWeImageView = getIndicatorLeft();
          localContext = getContext();
          p.g(localContext, "context");
          localWeImageView.setIconColor(localContext.getResources().getColor(2131100613));
          localWeImageView = getIndicatorRight();
          localContext = getContext();
          p.g(localContext, "context");
          localWeImageView.setIconColor(localContext.getResources().getColor(2131100620));
        }
        else if (paramInt + 1 == this.count)
        {
          localWeImageView = getIndicatorRight();
          localContext = getContext();
          p.g(localContext, "context");
          localWeImageView.setIconColor(localContext.getResources().getColor(2131100613));
          localWeImageView = getIndicatorLeft();
          localContext = getContext();
          p.g(localContext, "context");
          localWeImageView.setIconColor(localContext.getResources().getColor(2131100620));
        }
      }
    }
  }
  
  public final void setOnSelectedPageListener(h.a parama)
  {
    AppMethodBeat.i(255221);
    p.h(parama, "listener");
    this.wso = parama;
    AppMethodBeat.o(255221);
  }
  
  public final void setShowOnlyOneIndicator(boolean paramBoolean)
  {
    this.wsp = paramBoolean;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements a<WeImageView>
  {
    a(FinderMediaBannerIndicator paramFinderMediaBannerIndicator)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements a<WeImageView>
  {
    b(FinderMediaBannerIndicator paramFinderMediaBannerIndicator)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.indictor.FinderMediaBannerIndicator
 * JD-Core Version:    0.7.0.1
 */