package coil.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"coil/network/NetworkObserverApi14$connectionReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class NetworkObserverApi14$connectionReceiver$1
  extends BroadcastReceiver
{
  NetworkObserverApi14$connectionReceiver$1(c.b paramb, d paramd) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(187786);
    s.u(paramContext, "context");
    if (paramIntent == null) {}
    for (paramContext = null;; paramContext = paramIntent.getAction())
    {
      if (s.p(paramContext, "android.net.conn.CONNECTIVITY_CHANGE")) {
        this.coW.bp(this.coX.MX());
      }
      AppMethodBeat.o(187786);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     coil.network.NetworkObserverApi14.connectionReceiver.1
 * JD-Core Version:    0.7.0.1
 */