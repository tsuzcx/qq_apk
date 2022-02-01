package android.support.v4.view.a;

import android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener;

public final class b$b
  implements AccessibilityManager.TouchExplorationStateChangeListener
{
  final b.a Pl;
  
  public b$b(b.a parama)
  {
    this.Pl = parama;
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
    return this.Pl.equals(paramObject.Pl);
  }
  
  public final int hashCode()
  {
    return this.Pl.hashCode();
  }
  
  public final void onTouchExplorationStateChanged(boolean paramBoolean)
  {
    this.Pl.onTouchExplorationStateChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.view.a.b.b
 * JD-Core Version:    0.7.0.1
 */