package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import androidx.appcompat.a.a;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.g.a;
import androidx.core.g.a.d;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CheckableImageButton
  extends AppCompatImageButton
  implements Checkable
{
  private static final int[] dui = { 16842912 };
  private boolean duj;
  
  public CheckableImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.imageButtonStyle);
  }
  
  public CheckableImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(209389);
    z.a(this, new a()
    {
      public final void onInitializeAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
      {
        AppMethodBeat.i(209416);
        super.onInitializeAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
        paramAnonymousAccessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
        AppMethodBeat.o(209416);
      }
      
      public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, d paramAnonymousd)
      {
        AppMethodBeat.i(209425);
        super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousd);
        paramAnonymousd.setCheckable(true);
        paramAnonymousd.setChecked(CheckableImageButton.this.isChecked());
        AppMethodBeat.o(209425);
      }
    });
    AppMethodBeat.o(209389);
  }
  
  public boolean isChecked()
  {
    return this.duj;
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    AppMethodBeat.i(209433);
    if (this.duj)
    {
      arrayOfInt = mergeDrawableStates(super.onCreateDrawableState(dui.length + paramInt), dui);
      AppMethodBeat.o(209433);
      return arrayOfInt;
    }
    int[] arrayOfInt = super.onCreateDrawableState(paramInt);
    AppMethodBeat.o(209433);
    return arrayOfInt;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(209406);
    if (this.duj != paramBoolean)
    {
      this.duj = paramBoolean;
      refreshDrawableState();
      sendAccessibilityEvent(2048);
    }
    AppMethodBeat.o(209406);
  }
  
  public void toggle()
  {
    AppMethodBeat.i(209424);
    if (!this.duj) {}
    for (boolean bool = true;; bool = false)
    {
      setChecked(bool);
      AppMethodBeat.o(209424);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.internal.CheckableImageButton
 * JD-Core Version:    0.7.0.1
 */