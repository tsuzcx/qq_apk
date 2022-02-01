package com.tencent.mm.compatible.deviceinfo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;

public final class ab
{
  private static ab fIZ = null;
  
  public static int Yu()
  {
    AppMethodBeat.i(155821);
    NetworkInfo localNetworkInfo = ((ConnectivityManager)ai.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
    if (localNetworkInfo == null)
    {
      AppMethodBeat.o(155821);
      return 0;
    }
    int i = localNetworkInfo.getSubtype();
    if (localNetworkInfo.getType() == 1)
    {
      AppMethodBeat.o(155821);
      return 1;
    }
    switch (i)
    {
    case 8: 
    case 9: 
    case 10: 
    case 16: 
    default: 
      AppMethodBeat.o(155821);
      return 0;
    case 13: 
    case 14: 
    case 15: 
      AppMethodBeat.o(155821);
      return 4;
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 12: 
    case 17: 
      AppMethodBeat.o(155821);
      return 3;
    }
    AppMethodBeat.o(155821);
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.ab
 * JD-Core Version:    0.7.0.1
 */