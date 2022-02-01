package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.appcompat.a.a;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.g.a;
import androidx.core.g.a.d;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CheckableImageButton
  extends AppCompatImageButton
  implements Checkable
{
  private static final int[] bBg = { 16842912 };
  private boolean bBh;
  
  public CheckableImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.imageButtonStyle);
  }
  
  public CheckableImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(237529);
    w.a(this, new a()
    {
      public final void onInitializeAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
      {
        AppMethodBeat.i(237523);
        super.onInitializeAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
        paramAnonymousAccessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
        AppMethodBeat.o(237523);
      }
      
      public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, d paramAnonymousd)
      {
        AppMethodBeat.i(237524);
        super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousd);
        paramAnonymousd.setCheckable(true);
        boolean bool = CheckableImageButton.this.isChecked();
        paramAnonymousd.Ov.setChecked(bool);
        AppMethodBeat.o(237524);
      }
    });
    AppMethodBeat.o(237529);
  }
  
  public boolean isChecked()
  {
    return this.bBh;
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    AppMethodBeat.i(237532);
    if (this.bBh)
    {
      arrayOfInt = mergeDrawableStates(super.onCreateDrawableState(bBg.length + paramInt), bBg);
      AppMethodBeat.o(237532);
      return arrayOfInt;
    }
    int[] arrayOfInt = super.onCreateDrawableState(paramInt);
    AppMethodBeat.o(237532);
    return arrayOfInt;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(237530);
    if (this.bBh != paramBoolean)
    {
      this.bBh = paramBoolean;
      refreshDrawableState();
      sendAccessibilityEvent(2048);
    }
    AppMethodBeat.o(237530);
  }
  
  public void toggle()
  {
    AppMethodBeat.i(237531);
    if (!this.bBh) {}
    for (boolean bool = true;; bool = false)
    {
      setChecked(bool);
      AppMethodBeat.o(237531);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.internal.CheckableImageButton
 * JD-Core Version:    0.7.0.1
 */