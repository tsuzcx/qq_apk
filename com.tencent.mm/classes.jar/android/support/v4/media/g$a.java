package android.support.v4.media;

import android.support.v4.e.j;
import android.text.TextUtils;

final class g$a
  implements d.b
{
  private int Mg;
  private int Mh;
  private String mPackageName;
  
  g$a(String paramString, int paramInt1, int paramInt2)
  {
    this.mPackageName = paramString;
    this.Mg = paramInt1;
    this.Mh = paramInt2;
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
    } while ((TextUtils.equals(this.mPackageName, paramObject.mPackageName)) && (this.Mg == paramObject.Mg) && (this.Mh == paramObject.Mh));
    return false;
  }
  
  public final int hashCode()
  {
    return j.hash(new Object[] { this.mPackageName, Integer.valueOf(this.Mg), Integer.valueOf(this.Mh) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.media.g.a
 * JD-Core Version:    0.7.0.1
 */