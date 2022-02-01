package com.tencent.mm.network;

import com.tencent.mars.magicbox.IPxxLogic.ICallBack;
import com.tencent.mars.mm.MMLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class r
  implements IPxxLogic.ICallBack
{
  private static long pnW = 0L;
  private static int pnX = 0;
  private final String TAG = "IPxxCallback";
  
  private static void eT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(241163);
    try
    {
      ag.bRx().eU(paramInt1, paramInt2);
      AppMethodBeat.o(241163);
      return;
    }
    catch (Exception localException)
    {
      Log.e("IPxxCallback", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(241163);
    }
  }
  
  public final String getCrashFilePath(int paramInt)
  {
    AppMethodBeat.i(132751);
    Object localObject = new Date(System.currentTimeMillis() - paramInt * 86400000L);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    localObject = b.bmB() + "crash_" + localSimpleDateFormat.format((Date)localObject) + ".txt";
    if (y.ZC((String)localObject))
    {
      AppMethodBeat.o(132751);
      return localObject;
    }
    AppMethodBeat.o(132751);
    return null;
  }
  
  public final String getUploadLogExtrasInfo(String paramString)
  {
    AppMethodBeat.i(132749);
    try
    {
      paramString = new StringBuffer();
      paramString.append("Device:").append(d.Yxb).append(" ").append(d.Yxc).append("\n");
      paramString = paramString.toString();
      AppMethodBeat.o(132749);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(132749);
    }
    return null;
  }
  
  public final void recoverLinkAddrs()
  {
    AppMethodBeat.i(132752);
    MMLogic.recoverLinkAddrs();
    AppMethodBeat.o(132752);
  }
  
  public final void setNewDnsDebugHostInfo(String paramString, int paramInt)
  {
    AppMethodBeat.i(132750);
    MMLogic.setNewDnsDebugHost(paramString, String.valueOf(paramInt));
    AppMethodBeat.o(132750);
  }
  
  public final void uploadLogFail(int paramInt)
  {
    AppMethodBeat.i(241167);
    pnX = 0;
    eT(paramInt, -1);
    AppMethodBeat.o(241167);
  }
  
  public final void uploadLogResponse(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(241166);
    Log.i("IPxxCallback", "ipxx progress totalSize:%d uploadSize:%d lastPercent:%d ", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(pnX) });
    long l = Util.nowSecond();
    if (l - 1L < pnW)
    {
      AppMethodBeat.o(241166);
      return;
    }
    pnW = l;
    int j = 0;
    int i = j;
    if (paramLong2 >= 0L)
    {
      i = j;
      if (paramLong1 > 0L)
      {
        i = j;
        if (paramLong2 < paramLong1) {
          i = (int)(100L * paramLong2 / paramLong1);
        }
      }
    }
    j = i;
    if (i > 100) {
      j = 100;
    }
    i = j;
    if (pnX > j) {
      i = pnX;
    }
    pnX = i;
    eT(paramInt, i);
    AppMethodBeat.o(241166);
  }
  
  public final void uploadLogSuccess(int paramInt)
  {
    AppMethodBeat.i(241169);
    pnX = 0;
    eT(paramInt, 100);
    AppMethodBeat.o(241169);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.network.r
 * JD-Core Version:    0.7.0.1
 */