package android.support.v4.view.a;

import android.view.accessibility.AccessibilityRecord;

public final class d
{
  private final AccessibilityRecord Ie;
  
  @Deprecated
  private d(Object paramObject)
  {
    this.Ie = ((AccessibilityRecord)paramObject);
  }
  
  @Deprecated
  public static d dL()
  {
    return new d(AccessibilityRecord.obtain());
  }
  
  @Deprecated
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (d)paramObject;
        if (this.Ie != null) {
          break;
        }
      } while (paramObject.Ie == null);
      return false;
    } while (this.Ie.equals(paramObject.Ie));
    return false;
  }
  
  @Deprecated
  public final int hashCode()
  {
    if (this.Ie == null) {
      return 0;
    }
    return this.Ie.hashCode();
  }
  
  @Deprecated
  public final void setFromIndex(int paramInt)
  {
    this.Ie.setFromIndex(paramInt);
  }
  
  @Deprecated
  public final void setItemCount(int paramInt)
  {
    this.Ie.setItemCount(paramInt);
  }
  
  @Deprecated
  public final void setScrollable(boolean paramBoolean)
  {
    this.Ie.setScrollable(paramBoolean);
  }
  
  @Deprecated
  public final void setToIndex(int paramInt)
  {
    this.Ie.setToIndex(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v4.view.a.d
 * JD-Core Version:    0.7.0.1
 */