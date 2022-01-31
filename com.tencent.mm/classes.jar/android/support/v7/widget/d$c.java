package android.support.v7.widget;

import android.content.ComponentName;
import java.math.BigDecimal;

public final class d$c
{
  public final ComponentName YF;
  public final long time;
  public final float weight;
  
  public d$c(ComponentName paramComponentName, long paramLong, float paramFloat)
  {
    this.YF = paramComponentName;
    this.time = paramLong;
    this.weight = paramFloat;
  }
  
  public d$c(String paramString, long paramLong, float paramFloat)
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
      if (this.YF == null)
      {
        if (paramObject.YF != null) {
          return false;
        }
      }
      else if (!this.YF.equals(paramObject.YF)) {
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
    if (this.YF == null) {}
    for (int i = 0;; i = this.YF.hashCode()) {
      return ((i + 31) * 31 + (int)(this.time ^ this.time >>> 32)) * 31 + Float.floatToIntBits(this.weight);
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append("; activity:").append(this.YF);
    localStringBuilder.append("; time:").append(this.time);
    localStringBuilder.append("; weight:").append(new BigDecimal(this.weight));
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.d.c
 * JD-Core Version:    0.7.0.1
 */