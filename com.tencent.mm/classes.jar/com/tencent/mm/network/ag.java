package com.tencent.mm.network;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.a.b;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;

public final class ag
{
  public b mwu = null;
  public boolean mwv = false;
  
  public static boolean di(Context paramContext)
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
  
  public static boolean dj(Context paramContext)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.network.ag
 * JD-Core Version:    0.7.0.1
 */