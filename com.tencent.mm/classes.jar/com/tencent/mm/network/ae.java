package com.tencent.mm.network;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.a.b;
import com.tencent.mm.sdk.platformtools.az;

public final class ae
{
  public b iJn = null;
  public boolean iJo = false;
  
  public static boolean cQ(Context paramContext)
  {
    AppMethodBeat.i(132931);
    if ((paramContext != null) && (!az.isWap(paramContext)))
    {
      AppMethodBeat.o(132931);
      return true;
    }
    AppMethodBeat.o(132931);
    return false;
  }
  
  public static boolean cR(Context paramContext)
  {
    AppMethodBeat.i(132932);
    if ((paramContext != null) && (az.isWifi(paramContext)))
    {
      AppMethodBeat.o(132932);
      return true;
    }
    AppMethodBeat.o(132932);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.ae
 * JD-Core Version:    0.7.0.1
 */