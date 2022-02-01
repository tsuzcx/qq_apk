package com.tencent.mm.plugin.appbrand.config;

import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public enum n
{
  private static final a nZc;
  private static final a nZd;
  
  static
  {
    AppMethodBeat.i(147003);
    nZe = new n[0];
    nZc = new a((byte)0);
    nZd = new a((byte)0);
    AppMethodBeat.o(147003);
  }
  
  public static int aeS(String paramString)
  {
    AppMethodBeat.i(147000);
    int j = nZc.aeU(paramString);
    i = j;
    if (j <= 0) {
      localObject = null;
    }
    try
    {
      ab.bLM();
      WxaAttributes localWxaAttributes = ab.d(paramString, new String[] { "dynamicInfo" });
      localObject = localWxaAttributes;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.AppServiceSettingsResolver", localException, "queryWithAppId(%s)", new Object[] { paramString });
        continue;
        i = localObject.bLG().obf.cxI;
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
      i = localObject.bLG().obf.cxI;
      bP(paramString, i);
      AppMethodBeat.o(147000);
      return i * 1048576;
    }
  }
  
  public static int aeT(String paramString)
  {
    AppMethodBeat.i(147002);
    int j = nZd.aeU(paramString);
    i = j;
    if (j <= 0) {
      localObject = null;
    }
    try
    {
      ab.bLM();
      WxaAttributes localWxaAttributes = ab.d(paramString, new String[] { "dynamicInfo" });
      localObject = localWxaAttributes;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.AppServiceSettingsResolver", localException, "queryWithAppId(%s)", new Object[] { paramString });
        continue;
        i = localObject.bLG().obf.obh;
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
      i = localObject.bLG().obf.obh;
      bQ(paramString, i);
      AppMethodBeat.o(147002);
      return i * 1048576;
    }
  }
  
  public static void bP(String paramString, int paramInt)
  {
    AppMethodBeat.i(146999);
    nZc.bR(paramString, paramInt);
    AppMethodBeat.o(146999);
  }
  
  public static void bQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(147001);
    nZd.bR(paramString, paramInt);
    AppMethodBeat.o(147001);
  }
  
  static final class a
  {
    private final SparseIntArray nZf;
    
    private a()
    {
      AppMethodBeat.i(146994);
      this.nZf = new SparseIntArray();
      AppMethodBeat.o(146994);
    }
    
    public final int aeU(String paramString)
    {
      AppMethodBeat.i(146996);
      if (TextUtils.isEmpty(paramString))
      {
        AppMethodBeat.o(146996);
        return -1;
      }
      synchronized (this.nZf)
      {
        int i = this.nZf.get(paramString.hashCode(), -1);
        AppMethodBeat.o(146996);
        return i;
      }
    }
    
    public final void bR(String paramString, int paramInt)
    {
      AppMethodBeat.i(146995);
      if (TextUtils.isEmpty(paramString))
      {
        AppMethodBeat.o(146995);
        return;
      }
      synchronized (this.nZf)
      {
        this.nZf.put(paramString.hashCode(), paramInt);
        AppMethodBeat.o(146995);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.n
 * JD-Core Version:    0.7.0.1
 */