package android.support.v4.view.a;

import android.view.accessibility.AccessibilityRecord;

public final class c
{
  private final AccessibilityRecord It;
  
  @Deprecated
  private c(Object paramObject)
  {
    this.It = ((AccessibilityRecord)paramObject);
  }
  
  @Deprecated
  public static c dw()
  {
    return new c(AccessibilityRecord.obtain());
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
        paramObject = (c)paramObject;
        if (this.It != null) {
          break;
        }
      } while (paramObject.It == null);
      return false;
    } while (this.It.equals(paramObject.It));
    return false;
  }
  
  @Deprecated
  public final int hashCode()
  {
    if (this.It == null) {
      return 0;
    }
    return this.It.hashCode();
  }
  
  @Deprecated
  public final void setFromIndex(int paramInt)
  {
    this.It.setFromIndex(paramInt);
  }
  
  @Deprecated
  public final void setItemCount(int paramInt)
  {
    this.It.setItemCount(paramInt);
  }
  
  @Deprecated
  public final void setScrollable(boolean paramBoolean)
  {
    this.It.setScrollable(paramBoolean);
  }
  
  @Deprecated
  public final void setToIndex(int paramInt)
  {
    this.It.setToIndex(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v4.view.a.c
 * JD-Core Version:    0.7.0.1
 */