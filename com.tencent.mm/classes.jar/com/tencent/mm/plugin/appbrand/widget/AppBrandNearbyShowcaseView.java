package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

public final class AppBrandNearbyShowcaseView
  extends FrameLayout
{
  private int eB;
  private int jak;
  
  public AppBrandNearbyShowcaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(93789);
    this.eB = a.fromDPToPix(getContext(), 25);
    this.jak = a.fromDPToPix(getContext(), 19);
    AppMethodBeat.o(93789);
  }
  
  public AppBrandNearbyShowcaseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(93790);
    this.eB = a.fromDPToPix(getContext(), 25);
    this.jak = a.fromDPToPix(getContext(), 19);
    AppMethodBeat.o(93790);
  }
  
  private void aOw()
  {
    AppMethodBeat.i(93793);
    if (getChildCount() > 0)
    {
      int i = getChildCount() - 1;
      while (i >= 0)
      {
        View localView = getChildAt(i);
        Object localObject = localView.getLayoutParams();
        ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
        int j = this.eB;
        localLayoutParams.height = j;
        ((ViewGroup.LayoutParams)localObject).width = j;
        localObject = (FrameLayout.LayoutParams)localView.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).gravity |= 0x5;
        ((FrameLayout.LayoutParams)localView.getLayoutParams()).rightMargin = (this.jak * i);
        i -= 1;
      }
      requestLayout();
      invalidate();
    }
    AppMethodBeat.o(93793);
  }
  
  public final void aOx()
  {
    int i = 1;
    AppMethodBeat.i(93797);
    if (getChildCount() > 1)
    {
      int j = 200;
      while (i < getChildCount())
      {
        getChildAt(i).animate().setDuration(j).translationX(0.0F).start();
        j += 50;
        i += 1;
      }
    }
    AppMethodBeat.o(93797);
  }
  
  public final void fa(boolean paramBoolean)
  {
    AppMethodBeat.i(93796);
    if (getChildCount() > 1)
    {
      int j = 200;
      int i = getChildCount() - 1;
      if (i >= 0)
      {
        View localView = getChildAt(i);
        if (paramBoolean) {
          localView.animate().setDuration(j).translationX(((FrameLayout.LayoutParams)localView.getLayoutParams()).rightMargin).start();
        }
        for (;;)
        {
          j += 50;
          i -= 1;
          break;
          localView.setTranslationX(((FrameLayout.LayoutParams)localView.getLayoutParams()).rightMargin);
        }
      }
    }
    AppMethodBeat.o(93796);
  }
  
  public final int getExpandDuration()
  {
    AppMethodBeat.i(93798);
    if (getChildCount() <= 1)
    {
      AppMethodBeat.o(93798);
      return 0;
    }
    int i = getChildCount();
    AppMethodBeat.o(93798);
    return (i - 2) * 50 + 200;
  }
  
  public final ImageView pU(int paramInt)
  {
    AppMethodBeat.i(93795);
    ImageView localImageView = (ImageView)getChildAt(getChildCount() - 1 - paramInt);
    AppMethodBeat.o(93795);
    return localImageView;
  }
  
  public final void setIconGap(int paramInt)
  {
    AppMethodBeat.i(93792);
    if ((paramInt >= 0) && (this.jak != paramInt))
    {
      this.jak = paramInt;
      aOw();
    }
    AppMethodBeat.o(93792);
  }
  
  public final void setIconLayerCount(int paramInt)
  {
    AppMethodBeat.i(93794);
    if ((paramInt >= 0) && (paramInt != getChildCount()))
    {
      if (paramInt > getChildCount())
      {
        int j = getChildCount();
        int i = 0;
        while (i < paramInt - j)
        {
          ImageView localImageView = new ImageView(getContext());
          FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.eB, this.eB);
          localLayoutParams.gravity = 16;
          addViewInLayout(localImageView, 0, localLayoutParams, true);
          i += 1;
        }
      }
      if (paramInt < getChildCount()) {
        removeViewsInLayout(0, getChildCount() - paramInt);
      }
      aOw();
    }
    AppMethodBeat.o(93794);
  }
  
  public final void setIconSize(int paramInt)
  {
    AppMethodBeat.i(93791);
    if ((paramInt > 0) && (paramInt != this.eB))
    {
      this.eB = paramInt;
      aOw();
    }
    AppMethodBeat.o(93791);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView
 * JD-Core Version:    0.7.0.1
 */