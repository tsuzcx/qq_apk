package android.support.v4.view.a;

import android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener;

public final class b$b
  implements AccessibilityManager.TouchExplorationStateChangeListener
{
  final b.a Oo;
  
  public b$b(b.a parama)
  {
    this.Oo = parama;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    paramObject = (b)paramObject;
    return this.Oo.equals(paramObject.Oo);
  }
  
  public final int hashCode()
  {
    return this.Oo.hashCode();
  }
  
  public final void onTouchExplorationStateChanged(boolean paramBoolean)
  {
    this.Oo.onTouchExplorationStateChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.view.a.b.b
 * JD-Core Version:    0.7.0.1
 */