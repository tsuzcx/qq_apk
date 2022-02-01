package android.support.v4.media;

import android.os.Build.VERSION;

public final class d$a
{
  d.b Ko;
  
  public d$a(String paramString, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.Ko = new f.a(paramString, paramInt1, paramInt2);
      return;
    }
    this.Ko = new g.a(paramString, paramInt1, paramInt2);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof a)) {
      return false;
    }
    return this.Ko.equals(((a)paramObject).Ko);
  }
  
  public final int hashCode()
  {
    return this.Ko.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.media.d.a
 * JD-Core Version:    0.7.0.1
 */