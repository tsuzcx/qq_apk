package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Messenger;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.util.Log;

public final class MediaBrowserCompat
{
  static final boolean DEBUG = Log.isLoggable("MediaBrowserCompat", 3);
  public final MediaBrowserCompat.d AC;
  
  public MediaBrowserCompat(Context paramContext, ComponentName paramComponentName, MediaBrowserCompat.b paramb)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.AC = new MediaBrowserCompat.g(paramContext, paramComponentName, paramb);
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.AC = new f(paramContext, paramComponentName, paramb);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.AC = new MediaBrowserCompat.e(paramContext, paramComponentName, paramb);
      return;
    }
    this.AC = new MediaBrowserCompat.h(paramContext, paramComponentName, paramb);
  }
  
  static class f
    extends MediaBrowserCompat.e
  {
    f(Context paramContext, ComponentName paramComponentName, MediaBrowserCompat.b paramb)
    {
      super(paramComponentName, paramb);
    }
  }
  
  static abstract interface i
  {
    public abstract void a(Messenger paramMessenger, String paramString, Bundle paramBundle);
    
    public abstract void a(Messenger paramMessenger, String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle);
    
    public abstract void b(Messenger paramMessenger);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompat
 * JD-Core Version:    0.7.0.1
 */