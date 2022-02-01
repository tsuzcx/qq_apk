package com.tencent.mm.network;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.a.b;
import com.tencent.mm.sdk.platformtools.ax;

public final class ae
{
  public b inc = null;
  public boolean ind = false;
  
  public static boolean cR(Context paramContext)
  {
    AppMethodBeat.i(132931);
    if ((paramContext != null) && (!ax.isWap(paramContext)))
    {
      AppMethodBeat.o(132931);
      return true;
    }
    AppMethodBeat.o(132931);
    return false;
  }
  
  public static boolean cS(Context paramContext)
  {
    AppMethodBeat.i(132932);
    if ((paramContext != null) && (ax.isWifi(paramContext)))
    {
      AppMethodBeat.o(132932);
      return true;
    }
    AppMethodBeat.o(132932);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.network.ae
 * JD-Core Version:    0.7.0.1
 */