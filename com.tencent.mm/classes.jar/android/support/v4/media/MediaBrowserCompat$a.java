package android.support.v4.media;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompat.Token;
import java.lang.ref.WeakReference;

final class MediaBrowserCompat$a
  extends Handler
{
  private final WeakReference<MediaBrowserCompat.i> AD;
  private WeakReference<Messenger> AE;
  
  MediaBrowserCompat$a(MediaBrowserCompat.i parami)
  {
    this.AD = new WeakReference(parami);
  }
  
  final void a(Messenger paramMessenger)
  {
    this.AE = new WeakReference(paramMessenger);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if ((this.AE == null) || (this.AE.get() == null) || (this.AD.get() == null)) {
      return;
    }
    Bundle localBundle = paramMessage.getData();
    localBundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
    MediaBrowserCompat.i locali = (MediaBrowserCompat.i)this.AD.get();
    Messenger localMessenger = (Messenger)this.AE.get();
    for (;;)
    {
      try
      {
        switch (paramMessage.what)
        {
        case 1: 
          new StringBuilder("Unhandled message: ").append(paramMessage).append("\n  Client version: 1\n  Service version: ").append(paramMessage.arg1);
          return;
        }
      }
      catch (BadParcelableException localBadParcelableException) {}
      if (paramMessage.what != 1) {
        break;
      }
      locali.b(localMessenger);
      return;
      locali.a(localMessenger, localBadParcelableException.getString("data_media_item_id"), (MediaSessionCompat.Token)localBadParcelableException.getParcelable("data_media_session_token"), localBadParcelableException.getBundle("data_root_hints"));
      return;
      locali.b(localMessenger);
      return;
      String str = localBadParcelableException.getString("data_media_item_id");
      localBadParcelableException.getParcelableArrayList("data_media_item_list");
      locali.a(localMessenger, str, localBadParcelableException.getBundle("data_options"));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompat.a
 * JD-Core Version:    0.7.0.1
 */