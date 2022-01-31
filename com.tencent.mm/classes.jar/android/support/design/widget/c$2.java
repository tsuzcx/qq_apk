package android.support.design.widget;

import android.os.Bundle;
import android.support.v4.view.a;
import android.support.v4.view.a.b;
import android.view.View;

final class c$2
  extends a
{
  c$2(c paramc) {}
  
  public final void onInitializeAccessibilityNodeInfo(View paramView, b paramb)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramb);
    if (this.gI.mCancelable)
    {
      paramb.addAction(1048576);
      paramb.setDismissable(true);
      return;
    }
    paramb.setDismissable(false);
  }
  
  public final boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    if ((paramInt == 1048576) && (this.gI.mCancelable))
    {
      this.gI.cancel();
      return true;
    }
    return super.performAccessibilityAction(paramView, paramInt, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.design.widget.c.2
 * JD-Core Version:    0.7.0.1
 */