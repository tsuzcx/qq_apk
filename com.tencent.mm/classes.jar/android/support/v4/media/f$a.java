package android.support.v4.media;

import android.media.session.MediaSessionManager.RemoteUserInfo;
import android.support.v4.e.j;

final class f$a
  implements d.b
{
  final MediaSessionManager.RemoteUserInfo Ju;
  
  f$a(String paramString, int paramInt1, int paramInt2)
  {
    this.Ju = new MediaSessionManager.RemoteUserInfo(paramString, paramInt1, paramInt2);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof a)) {
      return false;
    }
    paramObject = (a)paramObject;
    return this.Ju.equals(paramObject.Ju);
  }
  
  public final int hashCode()
  {
    return j.hash(new Object[] { this.Ju });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.media.f.a
 * JD-Core Version:    0.7.0.1
 */