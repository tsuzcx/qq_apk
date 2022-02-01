package coil.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build.VERSION;
import coil.util.f;
import coil.util.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/network/NetworkObserver;", "", "isOnline", "", "()Z", "shutdown", "", "Companion", "Listener", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface c
{
  public static final a coT = a.coU;
  
  public abstract boolean MX();
  
  public abstract void shutdown();
  
  @Metadata(d1={""}, d2={"Lcoil/network/NetworkObserver$Companion;", "", "()V", "TAG", "", "invoke", "Lcoil/network/NetworkObserver;", "context", "Landroid/content/Context;", "isEnabled", "", "listener", "Lcoil/network/NetworkObserver$Listener;", "logger", "Lcoil/util/Logger;", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static
    {
      AppMethodBeat.i(187796);
      coU = new a();
      AppMethodBeat.o(187796);
    }
    
    public static c a(Context paramContext, boolean paramBoolean, c.b paramb, k paramk)
    {
      AppMethodBeat.i(187792);
      s.u(paramContext, "context");
      s.u(paramb, "listener");
      if (!paramBoolean)
      {
        paramContext = (c)a.coR;
        AppMethodBeat.o(187792);
        return paramContext;
      }
      ConnectivityManager localConnectivityManager = (ConnectivityManager)androidx.core.content.a.a(paramContext, ConnectivityManager.class);
      if (localConnectivityManager != null) {
        if (androidx.core.content.a.checkSelfPermission(paramContext, "android.permission.ACCESS_NETWORK_STATE") != 0) {
          break label82;
        }
      }
      label82:
      for (int i = 1; i == 0; i = 0)
      {
        paramContext = (c)a.coR;
        AppMethodBeat.o(187792);
        return paramContext;
      }
      try
      {
        if (Build.VERSION.SDK_INT >= 21) {}
        for (paramContext = (c)new e(localConnectivityManager, paramb);; paramContext = (c)new d(paramContext, localConnectivityManager, paramb))
        {
          AppMethodBeat.o(187792);
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          if (paramk != null) {
            f.a(paramk, "NetworkObserver", (Throwable)new RuntimeException("Failed to register network observer.", (Throwable)paramContext));
          }
          paramContext = (c)a.coR;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcoil/network/NetworkObserver$Listener;", "", "onConnectivityChange", "", "isOnline", "", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void bp(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     coil.network.c
 * JD-Core Version:    0.7.0.1
 */