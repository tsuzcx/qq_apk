package com.tencent.mm.network;

import com.tencent.mars.magicbox.IPxxLogic.ICallBack;
import com.tencent.mars.mm.MMLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class p
  implements IPxxLogic.ICallBack
{
  private static long hKR = 0L;
  private static int hKS = 0;
  private final String TAG = "IPxxCallback";
  
  private static void pk(int paramInt)
  {
    AppMethodBeat.i(132756);
    try
    {
      ad.aFo().pl(paramInt);
      AppMethodBeat.o(132756);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.e("IPxxCallback", "exception:%s", new Object[] { bt.m(localException) });
      AppMethodBeat.o(132756);
    }
  }
  
  public final String getCrashFilePath(int paramInt)
  {
    AppMethodBeat.i(132751);
    Object localObject = new Date(System.currentTimeMillis() - paramInt * 86400000L);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    localObject = b.aii() + "crash_" + localSimpleDateFormat.format((Date)localObject) + ".txt";
    if (i.eK((String)localObject))
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
      paramString.append("Device:").append(d.CpF).append(" ").append(d.CpG).append("\n");
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
  
  public final void uploadLogFail()
  {
    AppMethodBeat.i(132754);
    hKS = 0;
    pk(-1);
    AppMethodBeat.o(132754);
  }
  
  public final void uploadLogResponse(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(132753);
    com.tencent.mm.sdk.platformtools.ad.i("IPxxCallback", "ipxx progress totalSize:%d uploadSize:%d lastPercent:%d ", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(hKS) });
    long l = bt.aGK();
    if (l - 1L < hKR)
    {
      AppMethodBeat.o(132753);
      return;
    }
    hKR = l;
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
    if (hKS > j) {
      i = hKS;
    }
    hKS = i;
    pk(i);
    AppMethodBeat.o(132753);
  }
  
  public final void uploadLogSuccess()
  {
    AppMethodBeat.i(132755);
    hKS = 0;
    pk(100);
    AppMethodBeat.o(132755);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.network.p
 * JD-Core Version:    0.7.0.1
 */