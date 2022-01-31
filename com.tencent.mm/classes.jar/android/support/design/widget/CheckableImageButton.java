package android.support.design.widget;

import android.content.Context;
import android.support.v4.view.a;
import android.support.v4.view.a.b;
import android.support.v4.view.t;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;

public class CheckableImageButton
  extends AppCompatImageButton
  implements Checkable
{
  private static final int[] gJ = { 16842912 };
  private boolean gK;
  
  public CheckableImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130772187);
  }
  
  public CheckableImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    t.a(this, new a()
    {
      public final void onInitializeAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
      {
        super.onInitializeAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
        paramAnonymousAccessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
      }
      
      public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, b paramAnonymousb)
      {
        super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousb);
        paramAnonymousb.setCheckable(true);
        boolean bool = CheckableImageButton.this.isChecked();
        paramAnonymousb.Hq.setChecked(bool);
      }
    });
  }
  
  public boolean isChecked()
  {
    return this.gK;
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    if (this.gK) {
      return mergeDrawableStates(super.onCreateDrawableState(gJ.length + paramInt), gJ);
    }
    return super.onCreateDrawableState(paramInt);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.gK != paramBoolean)
    {
      this.gK = paramBoolean;
      refreshDrawableState();
      sendAccessibilityEvent(2048);
    }
  }
  
  public void toggle()
  {
    if (!this.gK) {}
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