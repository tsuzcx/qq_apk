package android.support.v4.widget;

import android.os.Bundle;
import android.support.v4.view.a.b;
import android.support.v4.view.a.c;

final class j$a
  extends c
{
  j$a(j paramj) {}
  
  public final b ax(int paramInt)
  {
    return b.a(this.Kz.obtainAccessibilityNodeInfo(paramInt));
  }
  
  public final b ay(int paramInt)
  {
    if (paramInt == 2) {}
    for (paramInt = this.Kz.mAccessibilityFocusedVirtualViewId; paramInt == -2147483648; paramInt = this.Kz.mKeyboardFocusedVirtualViewId) {
      return null;
    }
    return ax(paramInt);
  }
  
  public final boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return this.Kz.performAction(paramInt1, paramInt2, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.widget.j.a
 * JD-Core Version:    0.7.0.1
 */