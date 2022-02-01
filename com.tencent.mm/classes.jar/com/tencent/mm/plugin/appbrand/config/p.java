package com.tencent.mm.plugin.appbrand.config;

import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public enum p
{
  private static final a qZk;
  private static final a qZl;
  
  static
  {
    AppMethodBeat.i(147003);
    qZm = new p[0];
    qZk = new a((byte)0);
    qZl = new a((byte)0);
    AppMethodBeat.o(147003);
  }
  
  public static int Xu(String paramString)
  {
    AppMethodBeat.i(147000);
    int j = qZk.Xw(paramString);
    i = j;
    if (j <= 0) {
      localObject = null;
    }
    try
    {
      ai.clk();
      WxaAttributes localWxaAttributes = ai.e(paramString, new String[] { "dynamicInfo" });
      localObject = localWxaAttributes;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.AppServiceSettingsResolver", localException, "queryWithAppId(%s)", new Object[] { paramString });
        continue;
        i = localObject.cle().rbR.eqc;
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
      i = localObject.cle().rbR.eqc;
      ch(paramString, i);
      AppMethodBeat.o(147000);
      return i * 1048576;
    }
  }
  
  public static int Xv(String paramString)
  {
    AppMethodBeat.i(147002);
    int j = qZl.Xw(paramString);
    i = j;
    if (j <= 0) {
      localObject = null;
    }
    try
    {
      ai.clk();
      WxaAttributes localWxaAttributes = ai.e(paramString, new String[] { "dynamicInfo" });
      localObject = localWxaAttributes;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.AppServiceSettingsResolver", localException, "queryWithAppId(%s)", new Object[] { paramString });
        continue;
        i = localObject.cle().rbR.rbT;
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
      i = localObject.cle().rbR.rbT;
      ci(paramString, i);
      AppMethodBeat.o(147002);
      return i * 1048576;
    }
  }
  
  public static void ch(String paramString, int paramInt)
  {
    AppMethodBeat.i(146999);
    qZk.cj(paramString, paramInt);
    AppMethodBeat.o(146999);
  }
  
  public static void ci(String paramString, int paramInt)
  {
    AppMethodBeat.i(147001);
    qZl.cj(paramString, paramInt);
    AppMethodBeat.o(147001);
  }
  
  static final class a
  {
    private final SparseIntArray qZn;
    
    private a()
    {
      AppMethodBeat.i(146994);
      this.qZn = new SparseIntArray();
      AppMethodBeat.o(146994);
    }
    
    public final int Xw(String paramString)
    {
      AppMethodBeat.i(146996);
      if (TextUtils.isEmpty(paramString))
      {
        AppMethodBeat.o(146996);
        return -1;
      }
      synchronized (this.qZn)
      {
        int i = this.qZn.get(paramString.hashCode(), -1);
        AppMethodBeat.o(146996);
        return i;
      }
    }
    
    public final void cj(String paramString, int paramInt)
    {
      AppMethodBeat.i(146995);
      if (TextUtils.isEmpty(paramString))
      {
        AppMethodBeat.o(146995);
        return;
      }
      synchronized (this.qZn)
      {
        this.qZn.put(paramString.hashCode(), paramInt);
        AppMethodBeat.o(146995);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.p
 * JD-Core Version:    0.7.0.1
 */