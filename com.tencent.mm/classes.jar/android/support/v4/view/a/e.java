package android.support.v4.view.a;

import android.view.accessibility.AccessibilityRecord;

public final class e
{
  private final AccessibilityRecord PZ;
  
  @Deprecated
  private e(Object paramObject)
  {
    this.PZ = ((AccessibilityRecord)paramObject);
  }
  
  @Deprecated
  public static e fl()
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
        if (this.PZ != null) {
          break;
        }
      } while (paramObject.PZ == null);
      return false;
    } while (this.PZ.equals(paramObject.PZ));
    return false;
  }
  
  @Deprecated
  public final int hashCode()
  {
    if (this.PZ == null) {
      return 0;
    }
    return this.PZ.hashCode();
  }
  
  @Deprecated
  public final void setFromIndex(int paramInt)
  {
    this.PZ.setFromIndex(paramInt);
  }
  
  @Deprecated
  public final void setItemCount(int paramInt)
  {
    this.PZ.setItemCount(paramInt);
  }
  
  @Deprecated
  public final void setScrollable(boolean paramBoolean)
  {
    this.PZ.setScrollable(paramBoolean);
  }
  
  @Deprecated
  public final void setToIndex(int paramInt)
  {
    this.PZ.setToIndex(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.view.a.e
 * JD-Core Version:    0.7.0.1
 */