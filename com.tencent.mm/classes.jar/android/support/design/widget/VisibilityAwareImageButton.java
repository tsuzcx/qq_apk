package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

class VisibilityAwareImageButton
  extends ImageButton
{
  private int ni = getVisibility();
  
  public VisibilityAwareImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VisibilityAwareImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  final void f(int paramInt, boolean paramBoolean)
  {
    super.setVisibility(paramInt);
    if (paramBoolean) {
      this.ni = paramInt;
    }
  }
  
  final int getUserSetVisibility()
  {
    return this.ni;
  }
  
  public void setVisibility(int paramInt)
  {
    f(paramInt, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.widget.VisibilityAwareImageButton
 * JD-Core Version:    0.7.0.1
 */