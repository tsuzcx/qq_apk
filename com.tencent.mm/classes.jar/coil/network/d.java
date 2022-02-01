package coil.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcoil/network/NetworkObserverApi14;", "Lcoil/network/NetworkObserver;", "context", "Landroid/content/Context;", "connectivityManager", "Landroid/net/ConnectivityManager;", "listener", "Lcoil/network/NetworkObserver$Listener;", "(Landroid/content/Context;Landroid/net/ConnectivityManager;Lcoil/network/NetworkObserver$Listener;)V", "connectionReceiver", "coil/network/NetworkObserverApi14$connectionReceiver$1", "Lcoil/network/NetworkObserverApi14$connectionReceiver$1;", "isOnline", "", "()Z", "shutdown", "", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
final class d
  implements c
{
  private final NetworkObserverApi14.connectionReceiver.1 coV;
  private final ConnectivityManager connectivityManager;
  private final Context context;
  
  public d(Context paramContext, ConnectivityManager paramConnectivityManager, c.b paramb)
  {
    AppMethodBeat.i(187794);
    this.context = paramContext;
    this.connectivityManager = paramConnectivityManager;
    this.coV = new NetworkObserverApi14.connectionReceiver.1(paramb, this);
    this.context.registerReceiver((BroadcastReceiver)this.coV, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    AppMethodBeat.o(187794);
  }
  
  public final boolean MX()
  {
    AppMethodBeat.i(187798);
    NetworkInfo localNetworkInfo = this.connectivityManager.getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.isConnectedOrConnecting() == true))
    {
      AppMethodBeat.o(187798);
      return true;
    }
    AppMethodBeat.o(187798);
    return false;
  }
  
  public final void shutdown()
  {
    AppMethodBeat.i(187807);
    this.context.unregisterReceiver((BroadcastReceiver)this.coV);
    AppMethodBeat.o(187807);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     coil.network.d
 * JD-Core Version:    0.7.0.1
 */