package android.support.design.widget;

import android.os.Bundle;
import android.support.v4.view.a.c;
import android.view.View;

final class a$2
  extends android.support.v4.view.a
{
  a$2(a parama) {}
  
  public final void onInitializeAccessibilityNodeInfo(View paramView, c paramc)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramc);
    if (this.oB.ox)
    {
      paramc.addAction(1048576);
      paramc.setDismissable(true);
      return;
    }
    paramc.setDismissable(false);
  }
  
  public final boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    if ((paramInt == 1048576) && (this.oB.ox))
    {
      this.oB.cancel();
      return true;
    }
    return super.performAccessibilityAction(paramView, paramInt, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.a.2
 * JD-Core Version:    0.7.0.1
 */