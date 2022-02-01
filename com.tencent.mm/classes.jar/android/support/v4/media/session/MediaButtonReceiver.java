package android.support.v4.media.session;

import android.content.BroadcastReceiver;
import android.content.BroadcastReceiver.PendingResult;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaBrowserCompat.b;
import android.support.v4.media.MediaBrowserCompat.d;
import android.view.KeyEvent;
import java.util.List;

public class MediaButtonReceiver
  extends BroadcastReceiver
{
  private static ComponentName g(Context paramContext, String paramString)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    Intent localIntent = new Intent(paramString);
    localIntent.setPackage(paramContext.getPackageName());
    paramContext = localPackageManager.queryIntentServices(localIntent, 0);
    if (paramContext.size() == 1)
    {
      paramContext = (ResolveInfo)paramContext.get(0);
      return new ComponentName(paramContext.serviceInfo.packageName, paramContext.serviceInfo.name);
    }
    if (paramContext.isEmpty()) {
      return null;
    }
    throw new IllegalStateException("Expected 1 service that handles " + paramString + ", found " + paramContext.size());
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (!"android.intent.action.MEDIA_BUTTON".equals(paramIntent.getAction())) || (!paramIntent.hasExtra("android.intent.extra.KEY_EVENT")))
    {
      new StringBuilder("Ignore unsupported intent: ").append(paramIntent);
      return;
    }
    ComponentName localComponentName = g(paramContext, "android.intent.action.MEDIA_BUTTON");
    if (localComponentName != null)
    {
      paramIntent.setComponent(localComponentName);
      if (Build.VERSION.SDK_INT >= 26)
      {
        paramContext.startForegroundService(paramIntent);
        return;
      }
      paramContext.startService(paramIntent);
      return;
    }
    localComponentName = g(paramContext, "android.media.browse.MediaBrowserService");
    if (localComponentName != null)
    {
      BroadcastReceiver.PendingResult localPendingResult = goAsync();
      paramContext = paramContext.getApplicationContext();
      paramIntent = new a(paramContext, paramIntent, localPendingResult);
      paramContext = new MediaBrowserCompat(paramContext, localComponentName, paramIntent);
      paramIntent.Mv = paramContext;
      paramContext.KQ.connect();
      return;
    }
    throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
  }
  
  static final class a
    extends MediaBrowserCompat.b
  {
    private final BroadcastReceiver.PendingResult Mu;
    MediaBrowserCompat Mv;
    private final Context mContext;
    private final Intent mIntent;
    
    a(Context paramContext, Intent paramIntent, BroadcastReceiver.PendingResult paramPendingResult)
    {
      this.mContext = paramContext;
      this.mIntent = paramIntent;
      this.Mu = paramPendingResult;
    }
    
    private void finish()
    {
      this.Mv.disconnect();
      this.Mu.finish();
    }
    
    public final void onConnected()
    {
      KeyEvent localKeyEvent;
      try
      {
        MediaControllerCompat localMediaControllerCompat = new MediaControllerCompat(this.mContext, this.Mv.KQ.eK());
        localKeyEvent = (KeyEvent)this.mIntent.getParcelableExtra("android.intent.extra.KEY_EVENT");
        if (localKeyEvent == null) {
          throw new IllegalArgumentException("KeyEvent may not be null");
        }
      }
      catch (RemoteException localRemoteException) {}
      for (;;)
      {
        finish();
        return;
        localRemoteException.Mw.dispatchMediaButtonEvent(localKeyEvent);
      }
    }
    
    public final void onConnectionFailed()
    {
      finish();
    }
    
    public final void onConnectionSuspended()
    {
      finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v4.media.session.MediaButtonReceiver
 * JD-Core Version:    0.7.0.1
 */