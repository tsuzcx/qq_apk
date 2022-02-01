package com.tencent.mm.plugin.appbrand.config;

import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public enum m
{
  private static final a jEr;
  private static final a jEs;
  
  static
  {
    AppMethodBeat.i(147003);
    jEt = new m[0];
    jEr = new a((byte)0);
    jEs = new a((byte)0);
    AppMethodBeat.o(147003);
  }
  
  public static int JW(String paramString)
  {
    AppMethodBeat.i(147000);
    int j = jEr.JY(paramString);
    i = j;
    if (j <= 0) {
      localObject = null;
    }
    try
    {
      x.baS();
      WxaAttributes localWxaAttributes = x.e(paramString, new String[] { "dynamicInfo" });
      localObject = localWxaAttributes;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.AppServiceSettingsResolver", localException, "queryWithAppId(%s)", new Object[] { paramString });
        continue;
        i = localObject.baM().jFC.ccL;
        continue;
        i = 5;
      }
    }
    if (localObject == null)
    {
      i = -1;
      ac.i("MicroMsg.AppServiceSettingsResolver", "readAppFileStorageMaxSizeInBytes, appId = %s, MaxLocalstorageSize = %d", new Object[] { paramString, Integer.valueOf(i) });
      if (localObject == null) {
        break label137;
      }
      i = localObject.baM().jFC.ccL;
      bm(paramString, i);
      AppMethodBeat.o(147000);
      return i * 1048576;
    }
  }
  
  public static int JX(String paramString)
  {
    AppMethodBeat.i(147002);
    int j = jEs.JY(paramString);
    i = j;
    if (j <= 0) {
      localObject = null;
    }
    try
    {
      x.baS();
      WxaAttributes localWxaAttributes = x.e(paramString, new String[] { "dynamicInfo" });
      localObject = localWxaAttributes;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.AppServiceSettingsResolver", localException, "queryWithAppId(%s)", new Object[] { paramString });
        continue;
        i = localObject.baM().jFC.jFE;
        continue;
        i = 5;
      }
    }
    if (localObject == null)
    {
      i = -1;
      ac.i("MicroMsg.AppServiceSettingsResolver", "readAppOpendataLocalStorageMaxSizeInBytes, appId = %s, MaxLocalstorageSize = %d", new Object[] { paramString, Integer.valueOf(i) });
      if (localObject == null) {
        break label137;
      }
      i = localObject.baM().jFC.jFE;
      bn(paramString, i);
      AppMethodBeat.o(147002);
      return i * 1048576;
    }
  }
  
  public static void bm(String paramString, int paramInt)
  {
    AppMethodBeat.i(146999);
    jEr.put(paramString, paramInt);
    AppMethodBeat.o(146999);
  }
  
  public static void bn(String paramString, int paramInt)
  {
    AppMethodBeat.i(147001);
    jEs.put(paramString, paramInt);
    AppMethodBeat.o(147001);
  }
  
  static final class a
  {
    private final SparseIntArray jEu;
    
    private a()
    {
      AppMethodBeat.i(146994);
      this.jEu = new SparseIntArray();
      AppMethodBeat.o(146994);
    }
    
    public final int JY(String paramString)
    {
      AppMethodBeat.i(146996);
      if (TextUtils.isEmpty(paramString))
      {
        AppMethodBeat.o(146996);
        return -1;
      }
      synchronized (this.jEu)
      {
        int i = this.jEu.get(paramString.hashCode(), -1);
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
      synchronized (this.jEu)
      {
        this.jEu.put(paramString.hashCode(), paramInt);
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