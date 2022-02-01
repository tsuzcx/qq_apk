package com.tencent.mm.network;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.a.b;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;

public final class ah
{
  public b ppT = null;
  public boolean ppU = false;
  
  public static boolean ea(Context paramContext)
  {
    AppMethodBeat.i(132931);
    if ((paramContext != null) && (!NetStatusUtil.isWap(paramContext)))
    {
      AppMethodBeat.o(132931);
      return true;
    }
    AppMethodBeat.o(132931);
    return false;
  }
  
  public static boolean eb(Context paramContext)
  {
    AppMethodBeat.i(132932);
    if ((paramContext != null) && (NetStatusUtil.isWifi(paramContext)))
    {
      AppMethodBeat.o(132932);
      return true;
    }
    AppMethodBeat.o(132932);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.network.ah
 * JD-Core Version:    0.7.0.1
 */