package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.b;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.c;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.d;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.plugin.appbrand.y.e;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.ui.y;
import java.util.List;

public class AppBrandDesktopDragView
  extends DragFeatureView
{
  private List hfb;
  private List hpL;
  private boolean hpM = false;
  private boolean hpN = false;
  private a hpO = null;
  private e hpP;
  private HeaderContainer hph;
  private ValueAnimator jQ;
  
  public AppBrandDesktopDragView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AppBrandDesktopDragView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected final RecyclerView.v I(float paramFloat1, float paramFloat2)
  {
    getRecyclerView().getGlobalVisibleRect(this.mRect);
    if (!this.mRect.contains((int)paramFloat1, (int)paramFloat2)) {
      return null;
    }
    int k = 0;
    Object localObject1 = null;
    int i = 0;
    label36:
    Object localObject3;
    Object localObject2;
    int j;
    int m;
    if (k < getRecyclerView().getChildCount())
    {
      localObject3 = getRecyclerView().aT(getRecyclerView().getChildAt(k));
      localObject2 = localObject1;
      j = i;
      if (((RecyclerView.v)localObject3).aii != 7)
      {
        localObject2 = localObject1;
        j = i;
        if (((RecyclerView.v)localObject3).aii != 3)
        {
          localObject2 = localObject1;
          j = i;
          if (((RecyclerView.v)localObject3).aii != 8)
          {
            ((RecyclerView.v)localObject3).aie.getGlobalVisibleRect(this.mRect);
            localObject2 = localObject1;
            j = i;
            if (this.mRect.contains((int)paramFloat1, (int)paramFloat2)) {
              if (2 == ((RecyclerView.v)localObject3).aii)
              {
                localObject3 = (RecyclerView)((RecyclerView.v)localObject3).aie;
                m = 0;
                label172:
                localObject2 = localObject1;
                j = i;
                if (m >= ((RecyclerView)localObject3).getAdapter().getItemCount()) {
                  break label250;
                }
                localObject2 = ((RecyclerView)localObject3).bK(m);
                ((RecyclerView.v)localObject2).aie.getGlobalVisibleRect(this.mRect);
                if (!this.mRect.contains((int)paramFloat1, (int)paramFloat2)) {
                  break label343;
                }
                i = 1;
                localObject1 = localObject2;
              }
            }
          }
        }
      }
    }
    label343:
    for (;;)
    {
      m += 1;
      break label172;
      localObject2 = localObject3;
      j = 1;
      label250:
      k += 1;
      localObject1 = localObject2;
      i = j;
      break label36;
      if (i != 0) {
        return localObject1;
      }
      i = getRecyclerView().getChildCount() - 1;
      while (i >= 0)
      {
        localObject1 = getRecyclerView().aT(getRecyclerView().getChildAt(i));
        if (this.hpM)
        {
          if (((RecyclerView.v)localObject1).aii == 1) {
            return localObject1;
          }
        }
        else if (((RecyclerView.v)localObject1).aii == 7) {
          return localObject1;
        }
        i -= 1;
      }
      break;
    }
  }
  
  protected final b I(RecyclerView.v paramv)
  {
    if ((paramv != null) && (paramv.aii == 2))
    {
      this.hpM = false;
      paramv = new c(this, this.hpL, this.hfb, new AppBrandDesktopDragView.1(this));
      paramv.hsb = new AppBrandDesktopDragView.2(this);
      return paramv;
    }
    this.hpM = true;
    paramv = new d(this, this.hfb, new AppBrandDesktopDragView.3(this));
    paramv.hsb = new AppBrandDesktopDragView.4(this);
    return paramv;
  }
  
  protected final View a(RecyclerView paramRecyclerView, e parame)
  {
    if (this.hpP == null)
    {
      localView1 = y.gt(getContext()).inflate(y.h.appbrand_preview_item, null, false);
      localView1.setLayoutParams(new RecyclerView.LayoutParams(-1, getResources().getDisplayMetrics().widthPixels / 4));
      this.hpP = new e(localView1);
    }
    e locale = this.hpP;
    View localView2 = parame.aie;
    View localView1 = locale.aie;
    localView1.setLayoutParams(new FrameLayout.LayoutParams(localView2.getWidth(), localView2.getHeight()));
    locale.gSx.setImageDrawable(parame.gSx.getDrawable());
    locale.gSx.setBackground(parame.gSx.getBackground());
    locale.hqC.setText(parame.hqC.getText());
    locale.hqC.setVisibility(parame.hqC.getVisibility());
    locale.eXr.setText(parame.eXr.getText());
    locale.eXr.setVisibility(4);
    locale.hqD.setVisibility(4);
    float f1 = localView2.getLeft() + paramRecyclerView.getLeft();
    float f2 = localView2.getTop() + paramRecyclerView.getTop();
    float f4;
    float f3;
    if (parame.aii == 2)
    {
      f4 = ((View)localView2.getParent()).getLeft();
      f3 = ((View)localView2.getParent()).getTop();
      f1 += f4;
      f2 = f3 + f2;
    }
    for (;;)
    {
      paramRecyclerView = parame.aie;
      if (paramRecyclerView != null)
      {
        paramRecyclerView = (TextView)paramRecyclerView.findViewById(y.g.title);
        if (paramRecyclerView != null)
        {
          parame = (RelativeLayout.LayoutParams)paramRecyclerView.getLayoutParams();
          f4 = paramRecyclerView.getHeight();
          f3 = f4;
          if (parame != null)
          {
            int i = parame.topMargin;
            f3 = f4 + (parame.bottomMargin + i);
          }
        }
      }
      for (f3 /= 2.0F;; f3 = 0.0F)
      {
        localView1.animate().scaleX(1.5F).scaleY(1.5F).setDuration(200L).setListener(null).start();
        localView1.animate().alpha(0.5F).setDuration(1L).setListener(null).start();
        localView1.setTranslationX(f1);
        localView1.setTranslationY(f3 + f2);
        return localView1;
      }
    }
  }
  
  public void setCollectionCallback(a parama)
  {
    this.hpO = parama;
  }
  
  public void setCopyList(List paramList)
  {
    this.hpL = paramList;
  }
  
  public void setHeaderContainer(HeaderContainer paramHeaderContainer)
  {
    this.hph = paramHeaderContainer;
  }
  
  public void setList(List paramList)
  {
    this.hfb = paramList;
  }
  
  protected void setRubbishViewVisible(int paramInt)
  {
    super.setRubbishViewVisible(paramInt);
    if (paramInt == 0)
    {
      paramInt = 1;
      f = getResources().getDimension(y.e.rubbish_height);
      if (paramInt == 0) {
        break label119;
      }
    }
    label119:
    for (float f = this.hph.getBottom() - f - this.hph.getBackUpFooterRect().top;; f = this.hph.getBottom() - this.hph.getBackUpFooterRect().top)
    {
      this.jQ = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("transY", new float[] { 0.0F, f }) });
      this.jQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        float hpR = 0.0F;
        
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue("transY")).floatValue();
          paramAnonymousValueAnimator = AppBrandDesktopDragView.b(AppBrandDesktopDragView.this).getBackUpFooterRect();
          paramAnonymousValueAnimator.top = ((int)(paramAnonymousValueAnimator.top + (f - this.hpR)));
          this.hpR = f;
          ((ViewGroup)AppBrandDesktopDragView.b(AppBrandDesktopDragView.this).getParent()).invalidate();
        }
      });
      this.jQ.setDuration(250L);
      this.jQ.start();
      return;
      paramInt = 0;
      break;
    }
  }
  
  public static abstract interface a
  {
    public abstract void arn();
    
    public abstract void bb(Object paramObject);
    
    public abstract void bc(Object paramObject);
    
    public abstract void bd(Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView
 * JD-Core Version:    0.7.0.1
 */