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
import com.tencent.mm.cd.a;

public final class AppBrandNearbyShowcaseView
  extends FrameLayout
{
  private int uwj;
  private int uwk;
  
  public AppBrandNearbyShowcaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(121094);
    this.uwj = a.fromDPToPix(getContext(), 25);
    this.uwk = a.fromDPToPix(getContext(), 19);
    AppMethodBeat.o(121094);
  }
  
  public AppBrandNearbyShowcaseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(121095);
    this.uwj = a.fromDPToPix(getContext(), 25);
    this.uwk = a.fromDPToPix(getContext(), 19);
    AppMethodBeat.o(121095);
  }
  
  private void cOG()
  {
    AppMethodBeat.i(121098);
    if (getChildCount() > 0)
    {
      int i = getChildCount() - 1;
      while (i >= 0)
      {
        View localView = getChildAt(i);
        Object localObject = localView.getLayoutParams();
        ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
        int j = this.uwj;
        localLayoutParams.height = j;
        ((ViewGroup.LayoutParams)localObject).width = j;
        localObject = (FrameLayout.LayoutParams)localView.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).gravity |= 0x5;
        ((FrameLayout.LayoutParams)localView.getLayoutParams()).rightMargin = (this.uwk * i);
        i -= 1;
      }
      requestLayout();
      invalidate();
    }
    AppMethodBeat.o(121098);
  }
  
  public final ImageView DS(int paramInt)
  {
    AppMethodBeat.i(121100);
    ImageView localImageView = (ImageView)getChildAt(getChildCount() - 1 - paramInt);
    AppMethodBeat.o(121100);
    return localImageView;
  }
  
  public final void cOH()
  {
    AppMethodBeat.i(184009);
    if (getChildCount() > 1)
    {
      int i = getChildCount() - 1;
      while (i >= 0)
      {
        View localView = getChildAt(i);
        localView.setTranslationX(((FrameLayout.LayoutParams)localView.getLayoutParams()).rightMargin);
        i -= 1;
      }
    }
    AppMethodBeat.o(184009);
  }
  
  public final void cOI()
  {
    int i = 1;
    AppMethodBeat.i(323959);
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
    AppMethodBeat.o(323959);
  }
  
  public final int getExpandDuration()
  {
    AppMethodBeat.i(121103);
    if (getChildCount() <= 1)
    {
      AppMethodBeat.o(121103);
      return 0;
    }
    int i = getChildCount();
    AppMethodBeat.o(121103);
    return (i - 2) * 50 + 200;
  }
  
  public final void setIconGap(int paramInt)
  {
    AppMethodBeat.i(121097);
    if ((paramInt >= 0) && (this.uwk != paramInt))
    {
      this.uwk = paramInt;
      cOG();
    }
    AppMethodBeat.o(121097);
  }
  
  public final void setIconLayerCount(int paramInt)
  {
    AppMethodBeat.i(121099);
    if ((paramInt >= 0) && (paramInt != getChildCount()))
    {
      if (paramInt > getChildCount())
      {
        int j = getChildCount();
        int i = 0;
        while (i < paramInt - j)
        {
          ImageView localImageView = new ImageView(getContext());
          FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.uwj, this.uwj);
          localLayoutParams.gravity = 16;
          addViewInLayout(localImageView, 0, localLayoutParams, true);
          i += 1;
        }
      }
      if (paramInt < getChildCount()) {
        removeViewsInLayout(0, getChildCount() - paramInt);
      }
      cOG();
    }
    AppMethodBeat.o(121099);
  }
  
  public final void setIconSize(int paramInt)
  {
    AppMethodBeat.i(121096);
    if ((paramInt > 0) && (paramInt != this.uwj))
    {
      this.uwj = paramInt;
      cOG();
    }
    AppMethodBeat.o(121096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView
 * JD-Core Version:    0.7.0.1
 */