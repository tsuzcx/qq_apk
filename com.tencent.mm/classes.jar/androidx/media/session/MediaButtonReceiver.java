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
  private static ComponentName j(Context paramContext, String paramString)
  {
    AppMethodBeat.i(193089);
    PackageManager localPackageManager = paramContext.getPackageManager();
    Intent localIntent = new Intent(paramString);
    localIntent.setPackage(paramContext.getPackageName());
    paramContext = localPackageManager.queryIntentServices(localIntent, 0);
    if (paramContext.size() == 1)
    {
      paramContext = (ResolveInfo)paramContext.get(0);
      paramContext = new ComponentName(paramContext.serviceInfo.packageName, paramContext.serviceInfo.name);
      AppMethodBeat.o(193089);
      return paramContext;
    }
    if (paramContext.isEmpty())
    {
      AppMethodBeat.o(193089);
      return null;
    }
    paramContext = new IllegalStateException("Expected 1 service that handles " + paramString + ", found " + paramContext.size());
    AppMethodBeat.o(193089);
    throw paramContext;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(193102);
    if ((paramIntent == null) || (!"android.intent.action.MEDIA_BUTTON".equals(paramIntent.getAction())) || (!paramIntent.hasExtra("android.intent.extra.KEY_EVENT")))
    {
      new StringBuilder("Ignore unsupported intent: ").append(paramIntent);
      AppMethodBeat.o(193102);
      return;
    }
    ComponentName localComponentName = j(paramContext, "android.intent.action.MEDIA_BUTTON");
    if (localComponentName != null)
    {
      paramIntent.setComponent(localComponentName);
      if (Build.VERSION.SDK_INT >= 26)
      {
        paramContext.startForegroundService(paramIntent);
        AppMethodBeat.o(193102);
        return;
      }
      paramContext.startService(paramIntent);
      AppMethodBeat.o(193102);
      return;
    }
    localComponentName = j(paramContext, "android.media.browse.MediaBrowserService");
    if (localComponentName != null)
    {
      BroadcastReceiver.PendingResult localPendingResult = goAsync();
      paramContext = paramContext.getApplicationContext();
      paramIntent = new a(paramContext, paramIntent, localPendingResult);
      paramContext = new MediaBrowserCompat(paramContext, localComponentName, paramIntent);
      paramIntent.bKi = paramContext;
      paramContext.cp.connect();
      AppMethodBeat.o(193102);
      return;
    }
    paramContext = new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
    AppMethodBeat.o(193102);
    throw paramContext;
  }
  
  static final class a
    extends MediaBrowserCompat.b
  {
    private final BroadcastReceiver.PendingResult bKh;
    MediaBrowserCompat bKi;
    private final Context mContext;
    private final Intent mIntent;
    
    a(Context paramContext, Intent paramIntent, BroadcastReceiver.PendingResult paramPendingResult)
    {
      this.mContext = paramContext;
      this.mIntent = paramIntent;
      this.bKh = paramPendingResult;
    }
    
    private void finish()
    {
      AppMethodBeat.i(193074);
      this.bKi.disconnect();
      this.bKh.finish();
      AppMethodBeat.o(193074);
    }
    
    public final void onConnected()
    {
      AppMethodBeat.i(193082);
      KeyEvent localKeyEvent;
      try
      {
        Object localObject = new MediaControllerCompat(this.mContext, this.bKi.cp.aO());
        localKeyEvent = (KeyEvent)this.mIntent.getParcelableExtra("android.intent.extra.KEY_EVENT");
        if (localKeyEvent == null)
        {
          localObject = new IllegalArgumentException("KeyEvent may not be null");
          AppMethodBeat.o(193082);
          throw ((Throwable)localObject);
        }
      }
      catch (RemoteException localRemoteException) {}
      for (;;)
      {
        finish();
        AppMethodBeat.o(193082);
        return;
        localRemoteException.dp.b(localKeyEvent);
      }
    }
    
    public final void onConnectionFailed()
    {
      AppMethodBeat.i(193098);
      finish();
      AppMethodBeat.o(193098);
    }
    
    public final void onConnectionSuspended()
    {
      AppMethodBeat.i(193091);
      finish();
      AppMethodBeat.o(193091);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.media.session.MediaButtonReceiver
 * JD-Core Version:    0.7.0.1
 */