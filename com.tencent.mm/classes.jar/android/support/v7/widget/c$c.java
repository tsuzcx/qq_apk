package android.support.v7.widget;

import android.content.ComponentName;
import java.math.BigDecimal;

public final class c$c
{
  public final ComponentName Zq;
  public final long time;
  public final float weight;
  
  public c$c(ComponentName paramComponentName, long paramLong, float paramFloat)
  {
    this.Zq = paramComponentName;
    this.time = paramLong;
    this.weight = paramFloat;
  }
  
  public c$c(String paramString, long paramLong, float paramFloat)
  {
    this(ComponentName.unflattenFromString(paramString), paramLong, paramFloat);
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
      paramObject = (c)paramObject;
      if (this.Zq == null)
      {
        if (paramObject.Zq != null) {
          return false;
        }
      }
      else if (!this.Zq.equals(paramObject.Zq)) {
        return false;
      }
      if (this.time != paramObject.time) {
        return false;
      }
    } while (Float.floatToIntBits(this.weight) == Float.floatToIntBits(paramObject.weight));
    return false;
  }
  
  public final int hashCode()
  {
    if (this.Zq == null) {}
    for (int i = 0;; i = this.Zq.hashCode()) {
      return ((i + 31) * 31 + (int)(this.time ^ this.time >>> 32)) * 31 + Float.floatToIntBits(this.weight);
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append("; activity:").append(this.Zq);
    localStringBuilder.append("; time:").append(this.time);
    localStringBuilder.append("; weight:").append(new BigDecimal(this.weight));
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v7.widget.c.c
 * JD-Core Version:    0.7.0.1
 */