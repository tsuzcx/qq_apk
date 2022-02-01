package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public class Constraints
  extends ViewGroup
{
  a bmP;
  
  public Constraints(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(194173);
    super.setVisibility(8);
    AppMethodBeat.o(194173);
  }
  
  public Constraints(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(194180);
    super.setVisibility(8);
    AppMethodBeat.o(194180);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(194184);
    paramLayoutParams = new ConstraintLayout.LayoutParams(paramLayoutParams);
    AppMethodBeat.o(194184);
    return paramLayoutParams;
  }
  
  public a getConstraintSet()
  {
    AppMethodBeat.i(194192);
    if (this.bmP == null) {
      this.bmP = new a();
    }
    Object localObject1 = this.bmP;
    int j = getChildCount();
    ((a)localObject1).bmp.clear();
    int i = 0;
    while (i < j)
    {
      Object localObject2 = getChildAt(i);
      LayoutParams localLayoutParams = (LayoutParams)((View)localObject2).getLayoutParams();
      int k = ((View)localObject2).getId();
      if (k == -1)
      {
        localObject1 = new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
        AppMethodBeat.o(194192);
        throw ((Throwable)localObject1);
      }
      if (!((a)localObject1).bmp.containsKey(Integer.valueOf(k))) {
        ((a)localObject1).bmp.put(Integer.valueOf(k), new a.a((byte)0));
      }
      a.a locala = (a.a)((a)localObject1).bmp.get(Integer.valueOf(k));
      if ((localObject2 instanceof ConstraintHelper))
      {
        localObject2 = (ConstraintHelper)localObject2;
        locala.a(k, localLayoutParams);
        if ((localObject2 instanceof Barrier))
        {
          locala.bmM = 1;
          localObject2 = (Barrier)localObject2;
          locala.bmL = ((Barrier)localObject2).getType();
          locala.bmN = ((Barrier)localObject2).getReferencedIds();
        }
      }
      locala.a(k, localLayoutParams);
      i += 1;
    }
    localObject1 = this.bmP;
    AppMethodBeat.o(194192);
    return localObject1;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public static class LayoutParams
    extends ConstraintLayout.LayoutParams
  {
    public float alpha;
    public float ayc;
    public float ayd;
    public float ayf;
    public float ayg;
    public float bmA;
    public float bmB;
    public float bmC;
    public float bmD;
    public boolean bmz;
    public float rotation;
    public float scaleX;
    public float scaleY;
    
    public LayoutParams()
    {
      super(-2);
      this.alpha = 1.0F;
      this.bmz = false;
      this.bmA = 0.0F;
      this.rotation = 0.0F;
      this.ayf = 0.0F;
      this.ayg = 0.0F;
      this.scaleX = 1.0F;
      this.scaleY = 1.0F;
      this.bmB = 0.0F;
      this.bmC = 0.0F;
      this.ayc = 0.0F;
      this.ayd = 0.0F;
      this.bmD = 0.0F;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(194185);
      this.alpha = 1.0F;
      this.bmz = false;
      this.bmA = 0.0F;
      this.rotation = 0.0F;
      this.ayf = 0.0F;
      this.ayg = 0.0F;
      this.scaleX = 1.0F;
      this.scaleY = 1.0F;
      this.bmB = 0.0F;
      this.bmC = 0.0F;
      this.ayc = 0.0F;
      this.ayd = 0.0F;
      this.bmD = 0.0F;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintSet);
      int j = paramContext.getIndexCount();
      if (i < j)
      {
        int k = paramContext.getIndex(i);
        if (k == R.styleable.ConstraintSet_android_alpha) {
          this.alpha = paramContext.getFloat(k, this.alpha);
        }
        for (;;)
        {
          i += 1;
          break;
          if (k == R.styleable.ConstraintSet_android_elevation)
          {
            this.bmA = paramContext.getFloat(k, this.bmA);
            this.bmz = true;
          }
          else if (k == R.styleable.ConstraintSet_android_rotationX)
          {
            this.ayf = paramContext.getFloat(k, this.ayf);
          }
          else if (k == R.styleable.ConstraintSet_android_rotationY)
          {
            this.ayg = paramContext.getFloat(k, this.ayg);
          }
          else if (k == R.styleable.ConstraintSet_android_rotation)
          {
            this.rotation = paramContext.getFloat(k, this.rotation);
          }
          else if (k == R.styleable.ConstraintSet_android_scaleX)
          {
            this.scaleX = paramContext.getFloat(k, this.scaleX);
          }
          else if (k == R.styleable.ConstraintSet_android_scaleY)
          {
            this.scaleY = paramContext.getFloat(k, this.scaleY);
          }
          else if (k == R.styleable.ConstraintSet_android_transformPivotX)
          {
            this.bmB = paramContext.getFloat(k, this.bmB);
          }
          else if (k == R.styleable.ConstraintSet_android_transformPivotY)
          {
            this.bmC = paramContext.getFloat(k, this.bmC);
          }
          else if (k == R.styleable.ConstraintSet_android_translationX)
          {
            this.ayc = paramContext.getFloat(k, this.ayc);
          }
          else if (k == R.styleable.ConstraintSet_android_translationY)
          {
            this.ayd = paramContext.getFloat(k, this.ayd);
          }
          else if (k == R.styleable.ConstraintSet_android_translationZ)
          {
            this.ayc = paramContext.getFloat(k, this.bmD);
          }
        }
      }
      AppMethodBeat.o(194185);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.constraintlayout.widget.Constraints
 * JD-Core Version:    0.7.0.1
 */