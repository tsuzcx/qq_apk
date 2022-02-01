package android.support.v4.view.a;

import android.view.accessibility.AccessibilityRecord;

public final class e
{
  private final AccessibilityRecord Pe;
  
  @Deprecated
  private e(Object paramObject)
  {
    this.Pe = ((AccessibilityRecord)paramObject);
  }
  
  @Deprecated
  public static e fd()
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
        if (this.Pe != null) {
          break;
        }
      } while (paramObject.Pe == null);
      return false;
    } while (this.Pe.equals(paramObject.Pe));
    return false;
  }
  
  @Deprecated
  public final int hashCode()
  {
    if (this.Pe == null) {
      return 0;
    }
    return this.Pe.hashCode();
  }
  
  @Deprecated
  public final void setFromIndex(int paramInt)
  {
    this.Pe.setFromIndex(paramInt);
  }
  
  @Deprecated
  public final void setItemCount(int paramInt)
  {
    this.Pe.setItemCount(paramInt);
  }
  
  @Deprecated
  public final void setScrollable(boolean paramBoolean)
  {
    this.Pe.setScrollable(paramBoolean);
  }
  
  @Deprecated
  public final void setToIndex(int paramInt)
  {
    this.Pe.setToIndex(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.view.a.e
 * JD-Core Version:    0.7.0.1
 */