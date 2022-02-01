package androidx.media.session;

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
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaControllerCompat.b;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class MediaButtonReceiver
  extends BroadcastReceiver
{
  private static ComponentName g(Context paramContext, String paramString)
  {
    AppMethodBeat.i(242868);
    PackageManager localPackageManager = paramContext.getPackageManager();
    Intent localIntent = new Intent(paramString);
    localIntent.setPackage(paramContext.getPackageName());
    paramContext = localPackageManager.queryIntentServices(localIntent, 0);
    if (paramContext.size() == 1)
    {
      paramContext = (ResolveInfo)paramContext.get(0);
      paramContext = new ComponentName(paramContext.serviceInfo.packageName, paramContext.serviceInfo.name);
      AppMethodBeat.o(242868);
      return paramContext;
    }
    if (paramContext.isEmpty())
    {
      AppMethodBeat.o(242868);
      return null;
    }
    paramContext = new IllegalStateException("Expected 1 service that handles " + paramString + ", found " + paramContext.size());
    AppMethodBeat.o(242868);
    throw paramContext;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(242865);
    if ((paramIntent == null) || (!"android.intent.action.MEDIA_BUTTON".equals(paramIntent.getAction())) || (!paramIntent.hasExtra("android.intent.extra.KEY_EVENT")))
    {
      new StringBuilder("Ignore unsupported intent: ").append(paramIntent);
      AppMethodBeat.o(242865);
      return;
    }
    ComponentName localComponentName = g(paramContext, "android.intent.action.MEDIA_BUTTON");
    if (localComponentName != null)
    {
      paramIntent.setComponent(localComponentName);
      if (Build.VERSION.SDK_INT >= 26)
      {
        paramContext.startForegroundService(paramIntent);
        AppMethodBeat.o(242865);
        return;
      }
      paramContext.startService(paramIntent);
      AppMethodBeat.o(242865);
      return;
    }
    localComponentName = g(paramContext, "android.media.browse.MediaBrowserService");
    if (localComponentName != null)
    {
      BroadcastReceiver.PendingResult localPendingResult = goAsync();
      paramContext = paramContext.getApplicationContext();
      paramIntent = new a(paramContext, paramIntent, localPendingResult);
      paramContext = new MediaBrowserCompat(paramContext, localComponentName, paramIntent);
      paramIntent.acz = paramContext;
      paramContext.cp.connect();
      AppMethodBeat.o(242865);
      return;
    }
    paramContext = new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
    AppMethodBeat.o(242865);
    throw paramContext;
  }
  
  static final class a
    extends MediaBrowserCompat.b
  {
    private final BroadcastReceiver.PendingResult acy;
    MediaBrowserCompat acz;
    private final Context mContext;
    private final Intent mIntent;
    
    a(Context paramContext, Intent paramIntent, BroadcastReceiver.PendingResult paramPendingResult)
    {
      this.mContext = paramContext;
      this.mIntent = paramIntent;
      this.acy = paramPendingResult;
    }
    
    private void finish()
    {
      AppMethodBeat.i(242853);
      this.acz.disconnect();
      this.acy.finish();
      AppMethodBeat.o(242853);
    }
    
    public final void onConnected()
    {
      AppMethodBeat.i(242849);
      KeyEvent localKeyEvent;
      try
      {
        Object localObject = new MediaControllerCompat(this.mContext, this.acz.cp.W());
        localKeyEvent = (KeyEvent)this.mIntent.getParcelableExtra("android.intent.extra.KEY_EVENT");
        if (localKeyEvent == null)
        {
          localObject = new IllegalArgumentException("KeyEvent may not be null");
          AppMethodBeat.o(242849);
          throw ((Throwable)localObject);
        }
      }
      catch (RemoteException localRemoteException) {}
      for (;;)
      {
        finish();
        AppMethodBeat.o(242849);
        return;
        localRemoteException.dp.b(localKeyEvent);
      }
    }
    
    public final void onConnectionFailed()
    {
      AppMethodBeat.i(242851);
      finish();
      AppMethodBeat.o(242851);
    }
    
    public final void onConnectionSuspended()
    {
      AppMethodBeat.i(242850);
      finish();
      AppMethodBeat.o(242850);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.media.session.MediaButtonReceiver
 * JD-Core Version:    0.7.0.1
 */