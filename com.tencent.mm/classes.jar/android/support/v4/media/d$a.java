package android.support.v4.media;

import android.os.Build.VERSION;

public final class d$a
{
  d.b Me;
  
  public d$a(String paramString, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.Me = new f.a(paramString, paramInt1, paramInt2);
      return;
    }
    this.Me = new g.a(paramString, paramInt1, paramInt2);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof a)) {
      return false;
    }
    return this.Me.equals(((a)paramObject).Me);
  }
  
  public final int hashCode()
  {
    return this.Me.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.media.d.a
 * JD-Core Version:    0.7.0.1
 */