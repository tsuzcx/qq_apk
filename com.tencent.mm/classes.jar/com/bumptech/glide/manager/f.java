package com.bumptech.glide.manager;

import android.content.Context;
import android.support.v4.content.b;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  implements d
{
  public final c a(Context paramContext, c.a parama)
  {
    AppMethodBeat.i(77552);
    if (b.checkSelfPermission(paramContext, "android.permission.ACCESS_NETWORK_STATE") == 0) {}
    for (int i = 1;; i = 0)
    {
      Log.isLoggable("ConnectivityMonitor", 3);
      if (i == 0) {
        break;
      }
      paramContext = new e(paramContext, parama);
      AppMethodBeat.o(77552);
      return paramContext;
    }
    paramContext = new j();
    AppMethodBeat.o(77552);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.manager.f
 * JD-Core Version:    0.7.0.1
 */