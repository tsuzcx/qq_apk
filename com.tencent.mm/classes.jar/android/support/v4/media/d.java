package android.support.v4.media;

import android.os.Build.VERSION;
import android.util.Log;

public final class d
{
  static final boolean DEBUG = Log.isLoggable("MediaSessionManager", 3);
  private static final Object sLock = new Object();
  
  public static final class a
  {
    d.b Mo;
    
    public a(String paramString, int paramInt1, int paramInt2)
    {
      if (Build.VERSION.SDK_INT >= 28)
      {
        this.Mo = new f.a(paramString, paramInt1, paramInt2);
        return;
      }
      this.Mo = new g.a(paramString, paramInt1, paramInt2);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof a)) {
        return false;
      }
      return this.Mo.equals(((a)paramObject).Mo);
    }
    
    public final int hashCode()
    {
      return this.Mo.hashCode();
    }
  }
  
  static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v4.media.d
 * JD-Core Version:    0.7.0.1
 */