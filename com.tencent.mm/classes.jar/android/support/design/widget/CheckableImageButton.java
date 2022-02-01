package android.support.design.widget;

import android.content.Context;
import android.support.v4.view.a;
import android.support.v4.view.a.c;
import android.support.v4.view.u;
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
  private static final int[] oC = { 16842912 };
  private boolean oD;
  
  public CheckableImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969117);
  }
  
  public CheckableImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    u.a(this, new a()
    {
      public final void onInitializeAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
      {
        super.onInitializeAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
        paramAnonymousAccessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
      }
      
      public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, c paramAnonymousc)
      {
        super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousc);
        paramAnonymousc.setCheckable(true);
        boolean bool = CheckableImageButton.this.isChecked();
        paramAnonymousc.Ro.setChecked(bool);
      }
    });
  }
  
  public boolean isChecked()
  {
    return this.oD;
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    if (this.oD) {
      return mergeDrawableStates(super.onCreateDrawableState(oC.length + paramInt), oC);
    }
    return super.onCreateDrawableState(paramInt);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.oD != paramBoolean)
    {
      this.oD = paramBoolean;
      refreshDrawableState();
      sendAccessibilityEvent(2048);
    }
  }
  
  public void toggle()
  {
    if (!this.oD) {}
    for (boolean bool = true;; bool = false)
    {
      setChecked(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.CheckableImageButton
 * JD-Core Version:    0.7.0.1
 */