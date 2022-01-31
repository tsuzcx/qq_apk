package android.support.v7.widget;

import android.content.pm.ResolveInfo;
import java.math.BigDecimal;

public final class c$a
  implements Comparable<a>
{
  public final ResolveInfo resolveInfo;
  public float weight;
  
  public c$a(ResolveInfo paramResolveInfo)
  {
    this.resolveInfo = paramResolveInfo;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (a)paramObject;
    } while (Float.floatToIntBits(this.weight) == Float.floatToIntBits(paramObject.weight));
    return false;
  }
  
  public final int hashCode()
  {
    return Float.floatToIntBits(this.weight) + 31;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append("resolveInfo:").append(this.resolveInfo.toString());
    localStringBuilder.append("; weight:").append(new BigDecimal(this.weight));
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v7.widget.c.a
 * JD-Core Version:    0.7.0.1
 */