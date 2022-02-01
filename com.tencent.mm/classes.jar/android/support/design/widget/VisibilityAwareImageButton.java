package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class VisibilityAwareImageButton
  extends ImageButton
{
  private int wC = getVisibility();
  
  public VisibilityAwareImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VisibilityAwareImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void e(int paramInt, boolean paramBoolean)
  {
    super.setVisibility(paramInt);
    if (paramBoolean) {
      this.wC = paramInt;
    }
  }
  
  public final int getUserSetVisibility()
  {
    return this.wC;
  }
  
  public void setVisibility(int paramInt)
  {
    e(paramInt, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.widget.VisibilityAwareImageButton
 * JD-Core Version:    0.7.0.1
 */