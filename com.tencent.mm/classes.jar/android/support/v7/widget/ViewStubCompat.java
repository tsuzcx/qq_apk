package android.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.v7.a.a.a;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.lang.ref.WeakReference;

public final class ViewStubCompat
  extends View
{
  private int ayk = 0;
  private int ayl;
  private WeakReference<View> aym;
  private a ayn;
  private LayoutInflater mInflater;
  
  public ViewStubCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ViewStubCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.ViewStubCompat, paramInt, 0);
    this.ayl = paramContext.getResourceId(2, -1);
    this.ayk = paramContext.getResourceId(1, 0);
    setId(paramContext.getResourceId(0, -1));
    paramContext.recycle();
    setVisibility(8);
    setWillNotDraw(true);
  }
  
  protected final void dispatchDraw(Canvas paramCanvas) {}
  
  @SuppressLint({"MissingSuperCall"})
  public final void draw(Canvas paramCanvas) {}
  
  public final int getInflatedId()
  {
    return this.ayl;
  }
  
  public final LayoutInflater getLayoutInflater()
  {
    return this.mInflater;
  }
  
  public final int getLayoutResource()
  {
    return this.ayk;
  }
  
  public final View inflate()
  {
    Object localObject = getParent();
    if ((localObject != null) && ((localObject instanceof ViewGroup)))
    {
      if (this.ayk != 0)
      {
        ViewGroup localViewGroup = (ViewGroup)localObject;
        int i;
        if (this.mInflater != null)
        {
          localObject = this.mInflater;
          localObject = ((LayoutInflater)localObject).inflate(this.ayk, localViewGroup, false);
          if (this.ayl != -1) {
            ((View)localObject).setId(this.ayl);
          }
          i = localViewGroup.indexOfChild(this);
          localViewGroup.removeViewInLayout(this);
          ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
          if (localLayoutParams == null) {
            break label122;
          }
          localViewGroup.addView((View)localObject, i, localLayoutParams);
        }
        for (;;)
        {
          this.aym = new WeakReference(localObject);
          return localObject;
          localObject = LayoutInflater.from(getContext());
          break;
          label122:
          localViewGroup.addView((View)localObject, i);
        }
      }
      throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
    }
    throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(0, 0);
  }
  
  public final void setInflatedId(int paramInt)
  {
    this.ayl = paramInt;
  }
  
  public final void setLayoutInflater(LayoutInflater paramLayoutInflater)
  {
    this.mInflater = paramLayoutInflater;
  }
  
  public final void setLayoutResource(int paramInt)
  {
    this.ayk = paramInt;
  }
  
  public final void setOnInflateListener(a parama)
  {
    this.ayn = parama;
  }
  
  public final void setVisibility(int paramInt)
  {
    if (this.aym != null)
    {
      View localView = (View)this.aym.get();
      if (localView != null) {
        localView.setVisibility(paramInt);
      }
    }
    do
    {
      return;
      throw new IllegalStateException("setVisibility called on un-referenced view");
      super.setVisibility(paramInt);
    } while ((paramInt != 0) && (paramInt != 4));
    inflate();
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ViewStubCompat
 * JD-Core Version:    0.7.0.1
 */