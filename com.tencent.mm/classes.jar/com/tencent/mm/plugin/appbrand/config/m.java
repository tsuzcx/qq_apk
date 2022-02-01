package com.tencent.mm.plugin.appbrand.config;

import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public enum m
{
  private static final a jed;
  private static final a jee;
  
  static
  {
    AppMethodBeat.i(147003);
    jef = new m[0];
    jed = new a((byte)0);
    jee = new a((byte)0);
    AppMethodBeat.o(147003);
  }
  
  public static int FS(String paramString)
  {
    AppMethodBeat.i(147000);
    int j = jed.FU(paramString);
    i = j;
    if (j <= 0) {
      localObject = null;
    }
    try
    {
      x.aTU();
      WxaAttributes localWxaAttributes = x.e(paramString, new String[] { "dynamicInfo" });
      localObject = localWxaAttributes;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.AppServiceSettingsResolver", localException, "queryWithAppId(%s)", new Object[] { paramString });
        continue;
        i = localObject.aTO().jfn.cfO;
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
      i = localObject.aTO().jfn.cfO;
      bi(paramString, i);
      AppMethodBeat.o(147000);
      return i * 1048576;
    }
  }
  
  public static int FT(String paramString)
  {
    AppMethodBeat.i(147002);
    int j = jee.FU(paramString);
    i = j;
    if (j <= 0) {
      localObject = null;
    }
    try
    {
      x.aTU();
      WxaAttributes localWxaAttributes = x.e(paramString, new String[] { "dynamicInfo" });
      localObject = localWxaAttributes;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.AppServiceSettingsResolver", localException, "queryWithAppId(%s)", new Object[] { paramString });
        continue;
        i = localObject.aTO().jfn.jfp;
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
      i = localObject.aTO().jfn.jfp;
      bj(paramString, i);
      AppMethodBeat.o(147002);
      return i * 1048576;
    }
  }
  
  public static void bi(String paramString, int paramInt)
  {
    AppMethodBeat.i(146999);
    jed.put(paramString, paramInt);
    AppMethodBeat.o(146999);
  }
  
  public static void bj(String paramString, int paramInt)
  {
    AppMethodBeat.i(147001);
    jee.put(paramString, paramInt);
    AppMethodBeat.o(147001);
  }
  
  static final class a
  {
    private final SparseIntArray jeg;
    
    private a()
    {
      AppMethodBeat.i(146994);
      this.jeg = new SparseIntArray();
      AppMethodBeat.o(146994);
    }
    
    public final int FU(String paramString)
    {
      AppMethodBeat.i(146996);
      if (TextUtils.isEmpty(paramString))
      {
        AppMethodBeat.o(146996);
        return -1;
      }
      synchronized (this.jeg)
      {
        int i = this.jeg.get(paramString.hashCode(), -1);
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
      synchronized (this.jeg)
      {
        this.jeg.put(paramString.hashCode(), paramInt);
        AppMethodBeat.o(146995);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.m
 * JD-Core Version:    0.7.0.1
 */