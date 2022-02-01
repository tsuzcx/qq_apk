package coil.network;

import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/network/NetworkObserverApi21;", "Lcoil/network/NetworkObserver;", "connectivityManager", "Landroid/net/ConnectivityManager;", "listener", "Lcoil/network/NetworkObserver$Listener;", "(Landroid/net/ConnectivityManager;Lcoil/network/NetworkObserver$Listener;)V", "isOnline", "", "()Z", "networkCallback", "coil/network/NetworkObserverApi21$networkCallback$1", "Lcoil/network/NetworkObserverApi21$networkCallback$1;", "onConnectivityChange", "", "network", "Landroid/net/Network;", "shutdown", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
final class e
  implements c
{
  private final c.b coY;
  private final a coZ;
  private final ConnectivityManager connectivityManager;
  
  public e(ConnectivityManager paramConnectivityManager, c.b paramb)
  {
    AppMethodBeat.i(187791);
    this.connectivityManager = paramConnectivityManager;
    this.coY = paramb;
    this.coZ = new a(this);
    paramConnectivityManager = new NetworkRequest.Builder().addCapability(12).build();
    this.connectivityManager.registerNetworkCallback(paramConnectivityManager, (ConnectivityManager.NetworkCallback)this.coZ);
    AppMethodBeat.o(187791);
  }
  
  private final boolean a(Network paramNetwork)
  {
    AppMethodBeat.i(187797);
    paramNetwork = this.connectivityManager.getNetworkCapabilities(paramNetwork);
    if ((paramNetwork != null) && (paramNetwork.hasCapability(12)))
    {
      AppMethodBeat.o(187797);
      return true;
    }
    AppMethodBeat.o(187797);
    return false;
  }
  
  public final boolean MX()
  {
    AppMethodBeat.i(187812);
    Object localObject = this.connectivityManager.getAllNetworks();
    s.s(localObject, "connectivityManager.allNetworks");
    localObject = (Object[])localObject;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      Network localNetwork = (Network)localObject[i];
      s.s(localNetwork, "it");
      if (a(localNetwork))
      {
        AppMethodBeat.o(187812);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(187812);
    return false;
  }
  
  public final void shutdown()
  {
    AppMethodBeat.i(187817);
    this.connectivityManager.unregisterNetworkCallback((ConnectivityManager.NetworkCallback)this.coZ);
    AppMethodBeat.o(187817);
  }
  
  @Metadata(d1={""}, d2={"coil/network/NetworkObserverApi21$networkCallback$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "onAvailable", "", "network", "Landroid/net/Network;", "onLost", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends ConnectivityManager.NetworkCallback
  {
    a(e parame) {}
    
    public final void onAvailable(Network paramNetwork)
    {
      AppMethodBeat.i(187801);
      s.u(paramNetwork, "network");
      e.a(this.cpa, paramNetwork, true);
      AppMethodBeat.o(187801);
    }
    
    public final void onLost(Network paramNetwork)
    {
      AppMethodBeat.i(187810);
      s.u(paramNetwork, "network");
      e.a(this.cpa, paramNetwork, false);
      AppMethodBeat.o(187810);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     coil.network.e
 * JD-Core Version:    0.7.0.1
 */