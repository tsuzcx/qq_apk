package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.appcompat.a.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public final class ViewStubCompat
  extends View
{
  private LayoutInflater mInflater;
  private int xQ;
  private int xR;
  private WeakReference<View> xS;
  private a xT;
  
  public ViewStubCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ViewStubCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(242503);
    this.xQ = 0;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.j.ViewStubCompat, paramInt, 0);
    this.xR = paramContext.getResourceId(a.j.ViewStubCompat_android_inflatedId, -1);
    this.xQ = paramContext.getResourceId(a.j.ViewStubCompat_android_layout, 0);
    setId(paramContext.getResourceId(a.j.ViewStubCompat_android_id, -1));
    paramContext.recycle();
    setVisibility(8);
    setWillNotDraw(true);
    AppMethodBeat.o(242503);
  }
  
  protected final void dispatchDraw(Canvas paramCanvas) {}
  
  @SuppressLint({"MissingSuperCall"})
  public final void draw(Canvas paramCanvas) {}
  
  public final View eI()
  {
    AppMethodBeat.i(242507);
    Object localObject = getParent();
    if ((localObject != null) && ((localObject instanceof ViewGroup)))
    {
      if (this.xQ != 0)
      {
        ViewGroup localViewGroup = (ViewGroup)localObject;
        int i;
        if (this.mInflater != null)
        {
          localObject = this.mInflater;
          localObject = ((LayoutInflater)localObject).inflate(this.xQ, localViewGroup, false);
          if (this.xR != -1) {
            ((View)localObject).setId(this.xR);
          }
          i = localViewGroup.indexOfChild(this);
          localViewGroup.removeViewInLayout(this);
          ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
          if (localLayoutParams == null) {
            break label132;
          }
          localViewGroup.addView((View)localObject, i, localLayoutParams);
        }
        for (;;)
        {
          this.xS = new WeakReference(localObject);
          AppMethodBeat.o(242507);
          return localObject;
          localObject = LayoutInflater.from(getContext());
          break;
          label132:
          localViewGroup.addView((View)localObject, i);
        }
      }
      localObject = new IllegalArgumentException("ViewStub must have a valid layoutResource");
      AppMethodBeat.o(242507);
      throw ((Throwable)localObject);
    }
    localObject = new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
    AppMethodBeat.o(242507);
    throw ((Throwable)localObject);
  }
  
  public final int getInflatedId()
  {
    return this.xR;
  }
  
  public final LayoutInflater getLayoutInflater()
  {
    return this.mInflater;
  }
  
  public final int getLayoutResource()
  {
    return this.xQ;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(242504);
    setMeasuredDimension(0, 0);
    AppMethodBeat.o(242504);
  }
  
  public final void setInflatedId(int paramInt)
  {
    this.xR = paramInt;
  }
  
  public final void setLayoutInflater(LayoutInflater paramLayoutInflater)
  {
    this.mInflater = paramLayoutInflater;
  }
  
  public final void setLayoutResource(int paramInt)
  {
    this.xQ = paramInt;
  }
  
  public final void setOnInflateListener(a parama)
  {
    this.xT = parama;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(242506);
    if (this.xS != null)
    {
      Object localObject = (View)this.xS.get();
      if (localObject != null)
      {
        ((View)localObject).setVisibility(paramInt);
        AppMethodBeat.o(242506);
        return;
      }
      localObject = new IllegalStateException("setVisibility called on un-referenced view");
      AppMethodBeat.o(242506);
      throw ((Throwable)localObject);
    }
    super.setVisibility(paramInt);
    if ((paramInt == 0) || (paramInt == 4)) {
      eI();
    }
    AppMethodBeat.o(242506);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.appcompat.widget.ViewStubCompat
 * JD-Core Version:    0.7.0.1
 */