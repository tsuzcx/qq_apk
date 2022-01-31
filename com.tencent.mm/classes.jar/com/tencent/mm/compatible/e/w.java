package com.tencent.mm.compatible.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mm.sdk.platformtools.ae;

public final class w
{
  private static w dyP = null;
  
  public static int zx()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)ae.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
    if (localNetworkInfo == null) {
      return 0;
    }
    int i = localNetworkInfo.getSubtype();
    if (localNetworkInfo.getType() == 1) {
      return 1;
    }
    switch (i)
    {
    case 8: 
    case 9: 
    case 10: 
    case 16: 
    default: 
      return 0;
    case 13: 
    case 14: 
    case 15: 
      return 4;
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 12: 
    case 17: 
      return 3;
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.compatible.e.w
 * JD-Core Version:    0.7.0.1
 */