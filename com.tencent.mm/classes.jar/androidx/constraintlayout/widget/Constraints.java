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
  a GP;
  
  public Constraints(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(194932);
    super.setVisibility(8);
    AppMethodBeat.o(194932);
  }
  
  public Constraints(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(194935);
    super.setVisibility(8);
    AppMethodBeat.o(194935);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(194938);
    paramLayoutParams = new ConstraintLayout.LayoutParams(paramLayoutParams);
    AppMethodBeat.o(194938);
    return paramLayoutParams;
  }
  
  public a getConstraintSet()
  {
    AppMethodBeat.i(194944);
    if (this.GP == null) {
      this.GP = new a();
    }
    Object localObject1 = this.GP;
    int j = getChildCount();
    ((a)localObject1).Gl.clear();
    int i = 0;
    while (i < j)
    {
      Object localObject2 = getChildAt(i);
      LayoutParams localLayoutParams = (LayoutParams)((View)localObject2).getLayoutParams();
      int k = ((View)localObject2).getId();
      if (k == -1)
      {
        localObject1 = new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
        AppMethodBeat.o(194944);
        throw ((Throwable)localObject1);
      }
      if (!((a)localObject1).Gl.containsKey(Integer.valueOf(k))) {
        ((a)localObject1).Gl.put(Integer.valueOf(k), new a.a((byte)0));
      }
      a.a locala = (a.a)((a)localObject1).Gl.get(Integer.valueOf(k));
      if ((localObject2 instanceof ConstraintHelper))
      {
        localObject2 = (ConstraintHelper)localObject2;
        locala.a(k, localLayoutParams);
        if ((localObject2 instanceof Barrier))
        {
          locala.GM = 1;
          localObject2 = (Barrier)localObject2;
          locala.GL = ((Barrier)localObject2).getType();
          locala.GN = ((Barrier)localObject2).getReferencedIds();
        }
      }
      locala.a(k, localLayoutParams);
      i += 1;
    }
    localObject1 = this.GP;
    AppMethodBeat.o(194944);
    return localObject1;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public static class LayoutParams
    extends ConstraintLayout.LayoutParams
  {
    public float GA;
    public float GB;
    public float GC;
    public float GD;
    public boolean Gv;
    public float Gw;
    public float Gx;
    public float Gy;
    public float Gz;
    public float alpha;
    public float rotation;
    public float scaleX;
    public float scaleY;
    
    public LayoutParams()
    {
      super(-2);
      this.alpha = 1.0F;
      this.Gv = false;
      this.Gw = 0.0F;
      this.rotation = 0.0F;
      this.Gx = 0.0F;
      this.Gy = 0.0F;
      this.scaleX = 1.0F;
      this.scaleY = 1.0F;
      this.Gz = 0.0F;
      this.GA = 0.0F;
      this.GB = 0.0F;
      this.GC = 0.0F;
      this.GD = 0.0F;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(194927);
      this.alpha = 1.0F;
      this.Gv = false;
      this.Gw = 0.0F;
      this.rotation = 0.0F;
      this.Gx = 0.0F;
      this.Gy = 0.0F;
      this.scaleX = 1.0F;
      this.scaleY = 1.0F;
      this.Gz = 0.0F;
      this.GA = 0.0F;
      this.GB = 0.0F;
      this.GC = 0.0F;
      this.GD = 0.0F;
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
            this.Gw = paramContext.getFloat(k, this.Gw);
            this.Gv = true;
          }
          else if (k == R.styleable.ConstraintSet_android_rotationX)
          {
            this.Gx = paramContext.getFloat(k, this.Gx);
          }
          else if (k == R.styleable.ConstraintSet_android_rotationY)
          {
            this.Gy = paramContext.getFloat(k, this.Gy);
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
            this.Gz = paramContext.getFloat(k, this.Gz);
          }
          else if (k == R.styleable.ConstraintSet_android_transformPivotY)
          {
            this.GA = paramContext.getFloat(k, this.GA);
          }
          else if (k == R.styleable.ConstraintSet_android_translationX)
          {
            this.GB = paramContext.getFloat(k, this.GB);
          }
          else if (k == R.styleable.ConstraintSet_android_translationY)
          {
            this.GC = paramContext.getFloat(k, this.GC);
          }
          else if (k == R.styleable.ConstraintSet_android_translationZ)
          {
            this.GB = paramContext.getFloat(k, this.GD);
          }
        }
      }
      AppMethodBeat.o(194927);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.constraintlayout.widget.Constraints
 * JD-Core Version:    0.7.0.1
 */