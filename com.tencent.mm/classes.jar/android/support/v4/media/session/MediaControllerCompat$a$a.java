package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

final class MediaControllerCompat$a$a
  extends Handler
{
  boolean JH;
  
  public final void handleMessage(Message paramMessage)
  {
    if (!this.JH) {
      return;
    }
    switch (paramMessage.what)
    {
    case 8: 
    case 10: 
    default: 
      return;
    case 1: 
      MediaSessionCompat.d(paramMessage.getData());
      paramMessage = paramMessage.obj;
      return;
    case 2: 
      paramMessage = paramMessage.obj;
      return;
    case 3: 
      paramMessage = paramMessage.obj;
      return;
    case 5: 
      paramMessage = paramMessage.obj;
      return;
    case 6: 
      paramMessage = paramMessage.obj;
      return;
    case 11: 
      ((Boolean)paramMessage.obj).booleanValue();
      return;
    case 9: 
      ((Integer)paramMessage.obj).intValue();
      return;
    case 12: 
      ((Integer)paramMessage.obj).intValue();
      return;
    case 7: 
      MediaSessionCompat.d((Bundle)paramMessage.obj);
      return;
    }
    paramMessage = paramMessage.obj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.media.session.MediaControllerCompat.a.a
 * JD-Core Version:    0.7.0.1
 */