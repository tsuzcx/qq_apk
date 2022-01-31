package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.cb.a;

public final class AppBrandNearbyShowcaseView
  extends FrameLayout
{
  private int dz = a.fromDPToPix(getContext(), 25);
  private int hnE = a.fromDPToPix(getContext(), 19);
  
  public AppBrandNearbyShowcaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AppBrandNearbyShowcaseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void aqS()
  {
    if (getChildCount() > 0)
    {
      int i = getChildCount() - 1;
      while (i >= 0)
      {
        View localView = getChildAt(i);
        Object localObject = localView.getLayoutParams();
        ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
        int j = this.dz;
        localLayoutParams.height = j;
        ((ViewGroup.LayoutParams)localObject).width = j;
        localObject = (FrameLayout.LayoutParams)localView.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).gravity |= 0x5;
        ((FrameLayout.LayoutParams)localView.getLayoutParams()).rightMargin = (this.hnE * i);
        i -= 1;
      }
      requestLayout();
      invalidate();
    }
  }
  
  public final void aqT()
  {
    int i = 1;
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
  }
  
  public final void dK(boolean paramBoolean)
  {
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
  }
  
  public final int getExpandDuration()
  {
    if (getChildCount() <= 1) {
      return 0;
    }
    return (getChildCount() - 2) * 50 + 200;
  }
  
  public final ImageView mB(int paramInt)
  {
    return (ImageView)getChildAt(getChildCount() - 1 - paramInt);
  }
  
  public final void setIconGap(int paramInt)
  {
    if ((paramInt >= 0) && (this.hnE != paramInt))
    {
      this.hnE = paramInt;
      aqS();
    }
  }
  
  public final void setIconLayerCount(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt != getChildCount()))
    {
      if (paramInt > getChildCount())
      {
        int j = getChildCount();
        int i = 0;
        while (i < paramInt - j)
        {
          ImageView localImageView = new ImageView(getContext());
          FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.dz, this.dz);
          localLayoutParams.gravity = 16;
          addViewInLayout(localImageView, 0, localLayoutParams, true);
          i += 1;
        }
      }
      if (paramInt < getChildCount()) {
        removeViewsInLayout(0, getChildCount() - paramInt);
      }
      aqS();
    }
  }
  
  public final void setIconSize(int paramInt)
  {
    if ((paramInt > 0) && (paramInt != this.dz))
    {
      this.dz = paramInt;
      aqS();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView
 * JD-Core Version:    0.7.0.1
 */