package com.tencent.mm.network;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.a.b;
import com.tencent.mm.sdk.platformtools.ay;

public final class ae
{
  public b hMF = null;
  public boolean hMG = false;
  
  public static boolean cI(Context paramContext)
  {
    AppMethodBeat.i(132931);
    if ((paramContext != null) && (!ay.isWap(paramContext)))
    {
      AppMethodBeat.o(132931);
      return true;
    }
    AppMethodBeat.o(132931);
    return false;
  }
  
  public static boolean cJ(Context paramContext)
  {
    AppMethodBeat.i(132932);
    if ((paramContext != null) && (ay.isWifi(paramContext)))
    {
      AppMethodBeat.o(132932);
      return true;
    }
    AppMethodBeat.o(132932);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.network.ae
 * JD-Core Version:    0.7.0.1
 */