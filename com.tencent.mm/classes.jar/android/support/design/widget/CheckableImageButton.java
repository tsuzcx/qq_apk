package android.support.design.widget;

import android.content.Context;
import android.support.v4.view.q;
import android.support.v7.a.a.a;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;
import android.widget.Checkable;

public class CheckableImageButton
  extends AppCompatImageButton
  implements Checkable
{
  private static final int[] fP = { 16842912 };
  private boolean fQ;
  
  public CheckableImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.imageButtonStyle);
  }
  
  public CheckableImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    q.a(this, new CheckableImageButton.1(this));
  }
  
  public boolean isChecked()
  {
    return this.fQ;
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    if (this.fQ) {
      return mergeDrawableStates(super.onCreateDrawableState(fP.length + paramInt), fP);
    }
    return super.onCreateDrawableState(paramInt);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.fQ != paramBoolean)
    {
      this.fQ = paramBoolean;
      refreshDrawableState();
      sendAccessibilityEvent(2048);
    }
  }
  
  public void toggle()
  {
    if (!this.fQ) {}
    for (boolean bool = true;; bool = false)
    {
      setChecked(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.design.widget.CheckableImageButton
 * JD-Core Version:    0.7.0.1
 */