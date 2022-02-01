package androidx.appcompat.widget;

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
  private int yL;
  private int yM;
  private WeakReference<View> yN;
  private a yO;
  
  public ViewStubCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ViewStubCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(200269);
    this.yL = 0;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.j.ViewStubCompat, paramInt, 0);
    this.yM = paramContext.getResourceId(a.j.ViewStubCompat_android_inflatedId, -1);
    this.yL = paramContext.getResourceId(a.j.ViewStubCompat_android_layout, 0);
    setId(paramContext.getResourceId(a.j.ViewStubCompat_android_id, -1));
    paramContext.recycle();
    setVisibility(8);
    setWillNotDraw(true);
    AppMethodBeat.o(200269);
  }
  
  protected final void dispatchDraw(Canvas paramCanvas) {}
  
  public final void draw(Canvas paramCanvas) {}
  
  public final View fF()
  {
    AppMethodBeat.i(200343);
    Object localObject = getParent();
    if ((localObject != null) && ((localObject instanceof ViewGroup)))
    {
      if (this.yL != 0)
      {
        ViewGroup localViewGroup = (ViewGroup)localObject;
        int i;
        if (this.mInflater != null)
        {
          localObject = this.mInflater;
          localObject = ((LayoutInflater)localObject).inflate(this.yL, localViewGroup, false);
          if (this.yM != -1) {
            ((View)localObject).setId(this.yM);
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
          this.yN = new WeakReference(localObject);
          AppMethodBeat.o(200343);
          return localObject;
          localObject = LayoutInflater.from(getContext());
          break;
          label132:
          localViewGroup.addView((View)localObject, i);
        }
      }
      localObject = new IllegalArgumentException("ViewStub must have a valid layoutResource");
      AppMethodBeat.o(200343);
      throw ((Throwable)localObject);
    }
    localObject = new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
    AppMethodBeat.o(200343);
    throw ((Throwable)localObject);
  }
  
  public final int getInflatedId()
  {
    return this.yM;
  }
  
  public final LayoutInflater getLayoutInflater()
  {
    return this.mInflater;
  }
  
  public final int getLayoutResource()
  {
    return this.yL;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200302);
    setMeasuredDimension(0, 0);
    AppMethodBeat.o(200302);
  }
  
  public final void setInflatedId(int paramInt)
  {
    this.yM = paramInt;
  }
  
  public final void setLayoutInflater(LayoutInflater paramLayoutInflater)
  {
    this.mInflater = paramLayoutInflater;
  }
  
  public final void setLayoutResource(int paramInt)
  {
    this.yL = paramInt;
  }
  
  public final void setOnInflateListener(a parama)
  {
    this.yO = parama;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(200333);
    if (this.yN != null)
    {
      Object localObject = (View)this.yN.get();
      if (localObject != null)
      {
        ((View)localObject).setVisibility(paramInt);
        AppMethodBeat.o(200333);
        return;
      }
      localObject = new IllegalStateException("setVisibility called on un-referenced view");
      AppMethodBeat.o(200333);
      throw ((Throwable)localObject);
    }
    super.setVisibility(paramInt);
    if ((paramInt == 0) || (paramInt == 4)) {
      fF();
    }
    AppMethodBeat.o(200333);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.ViewStubCompat
 * JD-Core Version:    0.7.0.1
 */