package com.tencent.mm.plugin.appbrand.config;

import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public enum m
{
  private static final a jYt;
  private static final a jYu;
  
  static
  {
    AppMethodBeat.i(147003);
    jYv = new m[0];
    jYt = new a((byte)0);
    jYu = new a((byte)0);
    AppMethodBeat.o(147003);
  }
  
  public static int Np(String paramString)
  {
    AppMethodBeat.i(147000);
    int j = jYt.Nr(paramString);
    i = j;
    if (j <= 0) {
      localObject = null;
    }
    try
    {
      y.bes();
      WxaAttributes localWxaAttributes = y.e(paramString, new String[] { "dynamicInfo" });
      localObject = localWxaAttributes;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.AppServiceSettingsResolver", localException, "queryWithAppId(%s)", new Object[] { paramString });
        continue;
        i = localObject.bem().jZH.cnc;
        continue;
        i = 5;
      }
    }
    if (localObject == null)
    {
      i = -1;
      ad.i("MicroMsg.AppServiceSettingsResolver", "readAppFileStorageMaxSizeInBytes, appId = %s, MaxLocalstorageSize = %d", new Object[] { paramString, Integer.valueOf(i) });
      if (localObject == null) {
        break label137;
      }
      i = localObject.bem().jZH.cnc;
      bo(paramString, i);
      AppMethodBeat.o(147000);
      return i * 1048576;
    }
  }
  
  public static int Nq(String paramString)
  {
    AppMethodBeat.i(147002);
    int j = jYu.Nr(paramString);
    i = j;
    if (j <= 0) {
      localObject = null;
    }
    try
    {
      y.bes();
      WxaAttributes localWxaAttributes = y.e(paramString, new String[] { "dynamicInfo" });
      localObject = localWxaAttributes;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.AppServiceSettingsResolver", localException, "queryWithAppId(%s)", new Object[] { paramString });
        continue;
        i = localObject.bem().jZH.jZJ;
        continue;
        i = 5;
      }
    }
    if (localObject == null)
    {
      i = -1;
      ad.i("MicroMsg.AppServiceSettingsResolver", "readAppOpendataLocalStorageMaxSizeInBytes, appId = %s, MaxLocalstorageSize = %d", new Object[] { paramString, Integer.valueOf(i) });
      if (localObject == null) {
        break label137;
      }
      i = localObject.bem().jZH.jZJ;
      bp(paramString, i);
      AppMethodBeat.o(147002);
      return i * 1048576;
    }
  }
  
  public static void bo(String paramString, int paramInt)
  {
    AppMethodBeat.i(146999);
    jYt.put(paramString, paramInt);
    AppMethodBeat.o(146999);
  }
  
  public static void bp(String paramString, int paramInt)
  {
    AppMethodBeat.i(147001);
    jYu.put(paramString, paramInt);
    AppMethodBeat.o(147001);
  }
  
  static final class a
  {
    private final SparseIntArray jYw;
    
    private a()
    {
      AppMethodBeat.i(146994);
      this.jYw = new SparseIntArray();
      AppMethodBeat.o(146994);
    }
    
    public final int Nr(String paramString)
    {
      AppMethodBeat.i(146996);
      if (TextUtils.isEmpty(paramString))
      {
        AppMethodBeat.o(146996);
        return -1;
      }
      synchronized (this.jYw)
      {
        int i = this.jYw.get(paramString.hashCode(), -1);
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
      synchronized (this.jYw)
      {
        this.jYw.put(paramString.hashCode(), paramInt);
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