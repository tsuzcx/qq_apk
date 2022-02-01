package com.tencent.mm.plugin.appbrand.config;

import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public enum n
{
  private static final a leP;
  private static final a leQ;
  
  static
  {
    AppMethodBeat.i(147003);
    leR = new n[0];
    leP = new a((byte)0);
    leQ = new a((byte)0);
    AppMethodBeat.o(147003);
  }
  
  public static int Xg(String paramString)
  {
    AppMethodBeat.i(147000);
    int j = leP.Xi(paramString);
    i = j;
    if (j <= 0) {
      localObject = null;
    }
    try
    {
      ab.bAu();
      WxaAttributes localWxaAttributes = ab.e(paramString, new String[] { "dynamicInfo" });
      localObject = localWxaAttributes;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.AppServiceSettingsResolver", localException, "queryWithAppId(%s)", new Object[] { paramString });
        continue;
        i = localObject.bAo().lgD.cza;
        continue;
        i = 5;
      }
    }
    if (localObject == null)
    {
      i = -1;
      Log.i("MicroMsg.AppServiceSettingsResolver", "readAppFileStorageMaxSizeInBytes, appId = %s, MaxLocalstorageSize = %d", new Object[] { paramString, Integer.valueOf(i) });
      if (localObject == null) {
        break label137;
      }
      i = localObject.bAo().lgD.cza;
      bw(paramString, i);
      AppMethodBeat.o(147000);
      return i * 1048576;
    }
  }
  
  public static int Xh(String paramString)
  {
    AppMethodBeat.i(147002);
    int j = leQ.Xi(paramString);
    i = j;
    if (j <= 0) {
      localObject = null;
    }
    try
    {
      ab.bAu();
      WxaAttributes localWxaAttributes = ab.e(paramString, new String[] { "dynamicInfo" });
      localObject = localWxaAttributes;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.AppServiceSettingsResolver", localException, "queryWithAppId(%s)", new Object[] { paramString });
        continue;
        i = localObject.bAo().lgD.lgF;
        continue;
        i = 5;
      }
    }
    if (localObject == null)
    {
      i = -1;
      Log.i("MicroMsg.AppServiceSettingsResolver", "readAppOpendataLocalStorageMaxSizeInBytes, appId = %s, MaxLocalstorageSize = %d", new Object[] { paramString, Integer.valueOf(i) });
      if (localObject == null) {
        break label137;
      }
      i = localObject.bAo().lgD.lgF;
      bx(paramString, i);
      AppMethodBeat.o(147002);
      return i * 1048576;
    }
  }
  
  public static void bw(String paramString, int paramInt)
  {
    AppMethodBeat.i(146999);
    leP.put(paramString, paramInt);
    AppMethodBeat.o(146999);
  }
  
  public static void bx(String paramString, int paramInt)
  {
    AppMethodBeat.i(147001);
    leQ.put(paramString, paramInt);
    AppMethodBeat.o(147001);
  }
  
  static final class a
  {
    private final SparseIntArray leS;
    
    private a()
    {
      AppMethodBeat.i(146994);
      this.leS = new SparseIntArray();
      AppMethodBeat.o(146994);
    }
    
    public final int Xi(String paramString)
    {
      AppMethodBeat.i(146996);
      if (TextUtils.isEmpty(paramString))
      {
        AppMethodBeat.o(146996);
        return -1;
      }
      synchronized (this.leS)
      {
        int i = this.leS.get(paramString.hashCode(), -1);
        AppMethodBeat.o(146996);
        return i;
      }
    }
    
    public final void put(String paramString, int paramInt)
    {
      AppMethodBeat.i(146995);
      if (TextUtils.isEmpty(paramString))
      {
        AppMethodBeat.o(146995);
        return;
      }
      synchronized (this.leS)
      {
        this.leS.put(paramString.hashCode(), paramInt);
        AppMethodBeat.o(146995);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.n
 * JD-Core Version:    0.7.0.1
 */