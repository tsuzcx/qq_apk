package android.support.v4.media.session;

import android.media.session.MediaSession.Token;

final class d
{
  public static Object i(Object paramObject)
  {
    if ((paramObject instanceof MediaSession.Token)) {
      return paramObject;
    }
    throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.media.session.d
 * JD-Core Version:    0.7.0.1
 */