package com.tencent.mm.network;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.a.b;
import com.tencent.mm.sdk.platformtools.at;

public final class ac
{
  public b geK = null;
  public boolean geL = false;
  
  public static boolean cl(Context paramContext)
  {
    AppMethodBeat.i(58681);
    if ((paramContext != null) && (!at.isWap(paramContext)))
    {
      AppMethodBeat.o(58681);
      return true;
    }
    AppMethodBeat.o(58681);
    return false;
  }
  
  public static boolean cm(Context paramContext)
  {
    AppMethodBeat.i(58682);
    if ((paramContext != null) && (at.isWifi(paramContext)))
    {
      AppMethodBeat.o(58682);
      return true;
    }
    AppMethodBeat.o(58682);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.network.ac
 * JD-Core Version:    0.7.0.1
 */