package android.support.v4.view.a;

import android.view.accessibility.AccessibilityRecord;

public final class e
{
  private final AccessibilityRecord Sb;
  
  @Deprecated
  private e(Object paramObject)
  {
    this.Sb = ((AccessibilityRecord)paramObject);
  }
  
  @Deprecated
  public static e fJ()
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
        if (this.Sb != null) {
          break;
        }
      } while (paramObject.Sb == null);
      return false;
    } while (this.Sb.equals(paramObject.Sb));
    return false;
  }
  
  @Deprecated
  public final int hashCode()
  {
    if (this.Sb == null) {
      return 0;
    }
    return this.Sb.hashCode();
  }
  
  @Deprecated
  public final void setFromIndex(int paramInt)
  {
    this.Sb.setFromIndex(paramInt);
  }
  
  @Deprecated
  public final void setItemCount(int paramInt)
  {
    this.Sb.setItemCount(paramInt);
  }
  
  @Deprecated
  public final void setScrollable(boolean paramBoolean)
  {
    this.Sb.setScrollable(paramBoolean);
  }
  
  @Deprecated
  public final void setToIndex(int paramInt)
  {
    this.Sb.setToIndex(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.view.a.e
 * JD-Core Version:    0.7.0.1
 */