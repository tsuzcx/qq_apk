package android.support.v7.widget;

import android.os.Bundle;
import android.view.View;

public final class ak$a
  extends android.support.v4.view.a
{
  final ak aiw;
  
  public ak$a(ak paramak)
  {
    this.aiw = paramak;
  }
  
  public final void a(View paramView, android.support.v4.view.a.a parama)
  {
    super.a(paramView, parama);
    if ((!this.aiw.acI.hM()) && (this.aiw.acI.getLayoutManager() != null)) {
      this.aiw.acI.getLayoutManager().b(paramView, parama);
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
      } while (this.aiw.acI.hM());
      bool1 = bool2;
    } while (this.aiw.acI.getLayoutManager() == null);
    paramView = this.aiw.acI.getLayoutManager();
    paramBundle = paramView.acI.afy;
    paramView = paramView.acI.agu;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.widget.ak.a
 * JD-Core Version:    0.7.0.1
 */