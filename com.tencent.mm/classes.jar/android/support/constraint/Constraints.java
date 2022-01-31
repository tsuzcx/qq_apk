package android.support.constraint;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class Constraints
  extends ViewGroup
{
  public static final String TAG = "Constraints";
  ConstraintSet myConstraintSet;
  
  public Constraints(Context paramContext)
  {
    super(paramContext);
    super.setVisibility(8);
  }
  
  public Constraints(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramAttributeSet);
    super.setVisibility(8);
  }
  
  public Constraints(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramAttributeSet);
    super.setVisibility(8);
  }
  
  private void init(AttributeSet paramAttributeSet) {}
  
  protected LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-2, -2);
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new ConstraintLayout.LayoutParams(paramLayoutParams);
  }
  
  public ConstraintSet getConstraintSet()
  {
    if (this.myConstraintSet == null) {
      this.myConstraintSet = new ConstraintSet();
    }
    this.myConstraintSet.clone(this);
    return this.myConstraintSet;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public static class LayoutParams
    extends ConstraintLayout.LayoutParams
  {
    public float alpha = 1.0F;
    public boolean applyElevation = false;
    public float elevation = 0.0F;
    public float rotation = 0.0F;
    public float rotationX = 0.0F;
    public float rotationY = 0.0F;
    public float scaleX = 1.0F;
    public float scaleY = 1.0F;
    public float transformPivotX = 0.0F;
    public float transformPivotY = 0.0F;
    public float translationX = 0.0F;
    public float translationY = 0.0F;
    public float translationZ = 0.0F;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintSet);
      int j = paramContext.getIndexCount();
      if (i < j)
      {
        int k = paramContext.getIndex(i);
        if (k == 13) {
          this.alpha = paramContext.getFloat(k, this.alpha);
        }
        for (;;)
        {
          i += 1;
          break;
          if (k == 26)
          {
            this.elevation = paramContext.getFloat(k, this.elevation);
            this.applyElevation = true;
          }
          else if (k == 21)
          {
            this.rotationX = paramContext.getFloat(k, this.rotationX);
          }
          else if (k == 22)
          {
            this.rotationY = paramContext.getFloat(k, this.rotationY);
          }
          else if (k == 20)
          {
            this.rotation = paramContext.getFloat(k, this.rotation);
          }
          else if (k == 18)
          {
            this.scaleX = paramContext.getFloat(k, this.scaleX);
          }
          else if (k == 19)
          {
            this.scaleY = paramContext.getFloat(k, this.scaleY);
          }
          else if (k == 14)
          {
            this.transformPivotX = paramContext.getFloat(k, this.transformPivotX);
          }
          else if (k == 15)
          {
            this.transformPivotY = paramContext.getFloat(k, this.transformPivotY);
          }
          else if (k == 16)
          {
            this.translationX = paramContext.getFloat(k, this.translationX);
          }
          else if (k == 17)
          {
            this.translationY = paramContext.getFloat(k, this.translationY);
          }
          else if (k == 25)
          {
            this.translationX = paramContext.getFloat(k, this.translationZ);
          }
        }
      }
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.constraint.Constraints
 * JD-Core Version:    0.7.0.1
 */