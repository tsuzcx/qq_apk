package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.a;
import android.support.v4.view.a.b;
import android.view.View;

public final class al$a
  extends a
{
  final al akM;
  
  public al$a(al paramal)
  {
    this.akM = paramal;
  }
  
  public final void onInitializeAccessibilityNodeInfo(View paramView, b paramb)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramb);
    if ((!this.akM.adt.js()) && (this.akM.adt.getLayoutManager() != null)) {
      this.akM.adt.getLayoutManager().a(paramView, paramb);
    }
  }
  
  public final boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    boolean bool2 = false;
    boolean bool1;
    if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this.akM.adt.js());
      bool1 = bool2;
    } while (this.akM.adt.getLayoutManager() == null);
    this.akM.adt.getLayoutManager();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.al.a
 * JD-Core Version:    0.7.0.1
 */