package android.support.v4.media;

import android.media.session.MediaSessionManager.RemoteUserInfo;
import android.support.v4.e.j;

final class f
  extends e
{
  static final class a
    implements d.b
  {
    final MediaSessionManager.RemoteUserInfo Mp;
    
    a(String paramString, int paramInt1, int paramInt2)
    {
      this.Mp = new MediaSessionManager.RemoteUserInfo(paramString, paramInt1, paramInt2);
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
      return this.Mp.equals(paramObject.Mp);
    }
    
    public final int hashCode()
    {
      return j.hash(new Object[] { this.Mp });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v4.media.f
 * JD-Core Version:    0.7.0.1
 */