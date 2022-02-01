package android.support.v4.media;

import android.support.v4.e.j;
import android.text.TextUtils;

class g
{
  private static final boolean DEBUG = d.DEBUG;
  
  static final class a
    implements d.b
  {
    private int Mq;
    private int Mr;
    private String mPackageName;
    
    a(String paramString, int paramInt1, int paramInt2)
    {
      this.mPackageName = paramString;
      this.Mq = paramInt1;
      this.Mr = paramInt2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof a)) {
          return false;
        }
        paramObject = (a)paramObject;
      } while ((TextUtils.equals(this.mPackageName, paramObject.mPackageName)) && (this.Mq == paramObject.Mq) && (this.Mr == paramObject.Mr));
      return false;
    }
    
    public final int hashCode()
    {
      return j.hash(new Object[] { this.mPackageName, Integer.valueOf(this.Mq), Integer.valueOf(this.Mr) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v4.media.g
 * JD-Core Version:    0.7.0.1
 */