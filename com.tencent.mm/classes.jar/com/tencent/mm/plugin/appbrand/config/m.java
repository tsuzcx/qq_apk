package com.tencent.mm.plugin.appbrand.config;

import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public enum m
{
  private static final a kbI;
  private static final a kbJ;
  
  static
  {
    AppMethodBeat.i(147003);
    kbK = new m[0];
    kbI = new a((byte)0);
    kbJ = new a((byte)0);
    AppMethodBeat.o(147003);
  }
  
  public static int NX(String paramString)
  {
    AppMethodBeat.i(147000);
    int j = kbI.NZ(paramString);
    i = j;
    if (j <= 0) {
      localObject = null;
    }
    try
    {
      y.bfa();
      WxaAttributes localWxaAttributes = y.e(paramString, new String[] { "dynamicInfo" });
      localObject = localWxaAttributes;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.AppServiceSettingsResolver", localException, "queryWithAppId(%s)", new Object[] { paramString });
        continue;
        i = localObject.beU().kcY.cne;
        continue;
        i = 5;
      }
    }
    if (localObject == null)
    {
      i = -1;
      ae.i("MicroMsg.AppServiceSettingsResolver", "readAppFileStorageMaxSizeInBytes, appId = %s, MaxLocalstorageSize = %d", new Object[] { paramString, Integer.valueOf(i) });
      if (localObject == null) {
        break label137;
      }
      i = localObject.beU().kcY.cne;
      br(paramString, i);
      AppMethodBeat.o(147000);
      return i * 1048576;
    }
  }
  
  public static int NY(String paramString)
  {
    AppMethodBeat.i(147002);
    int j = kbJ.NZ(paramString);
    i = j;
    if (j <= 0) {
      localObject = null;
    }
    try
    {
      y.bfa();
      WxaAttributes localWxaAttributes = y.e(paramString, new String[] { "dynamicInfo" });
      localObject = localWxaAttributes;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.AppServiceSettingsResolver", localException, "queryWithAppId(%s)", new Object[] { paramString });
        continue;
        i = localObject.beU().kcY.kda;
        continue;
        i = 5;
      }
    }
    if (localObject == null)
    {
      i = -1;
      ae.i("MicroMsg.AppServiceSettingsResolver", "readAppOpendataLocalStorageMaxSizeInBytes, appId = %s, MaxLocalstorageSize = %d", new Object[] { paramString, Integer.valueOf(i) });
      if (localObject == null) {
        break label137;
      }
      i = localObject.beU().kcY.kda;
      bs(paramString, i);
      AppMethodBeat.o(147002);
      return i * 1048576;
    }
  }
  
  public static void br(String paramString, int paramInt)
  {
    AppMethodBeat.i(146999);
    kbI.put(paramString, paramInt);
    AppMethodBeat.o(146999);
  }
  
  public static void bs(String paramString, int paramInt)
  {
    AppMethodBeat.i(147001);
    kbJ.put(paramString, paramInt);
    AppMethodBeat.o(147001);
  }
  
  static final class a
  {
    private final SparseIntArray kbL;
    
    private a()
    {
      AppMethodBeat.i(146994);
      this.kbL = new SparseIntArray();
      AppMethodBeat.o(146994);
    }
    
    public final int NZ(String paramString)
    {
      AppMethodBeat.i(146996);
      if (TextUtils.isEmpty(paramString))
      {
        AppMethodBeat.o(146996);
        return -1;
      }
      synchronized (this.kbL)
      {
        int i = this.kbL.get(paramString.hashCode(), -1);
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
      synchronized (this.kbL)
      {
        this.kbL.put(paramString.hashCode(), paramInt);
        AppMethodBeat.o(146995);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.m
 * JD-Core Version:    0.7.0.1
 */