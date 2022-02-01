package android.support.v4.view.a;

import android.view.accessibility.AccessibilityRecord;

public final class e
{
  private final AccessibilityRecord RO;
  
  @Deprecated
  private e(Object paramObject)
  {
    this.RO = ((AccessibilityRecord)paramObject);
  }
  
  @Deprecated
  public static e fC()
  {
    return new e(AccessibilityRecord.obtain());
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
        paramObject = (e)paramObject;
        if (this.RO != null) {
          break;
        }
      } while (paramObject.RO == null);
      return false;
    } while (this.RO.equals(paramObject.RO));
    return false;
  }
  
  @Deprecated
  public final int hashCode()
  {
    if (this.RO == null) {
      return 0;
    }
    return this.RO.hashCode();
  }
  
  @Deprecated
  public final void setFromIndex(int paramInt)
  {
    this.RO.setFromIndex(paramInt);
  }
  
  @Deprecated
  public final void setItemCount(int paramInt)
  {
    this.RO.setItemCount(paramInt);
  }
  
  @Deprecated
  public final void setScrollable(boolean paramBoolean)
  {
    this.RO.setScrollable(paramBoolean);
  }
  
  @Deprecated
  public final void setToIndex(int paramInt)
  {
    this.RO.setToIndex(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.view.a.e
 * JD-Core Version:    0.7.0.1
 */