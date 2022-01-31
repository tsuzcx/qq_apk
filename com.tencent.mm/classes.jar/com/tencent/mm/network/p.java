package com.tencent.mm.network;

import com.tencent.mars.magicbox.IPxxLogic.ICallBack;
import com.tencent.mars.mm.MMLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bo;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class p
  implements IPxxLogic.ICallBack
{
  private static long gds = 0L;
  private static int gdt = 0;
  private final String TAG = "IPxxCallback";
  
  private static void mv(int paramInt)
  {
    AppMethodBeat.i(58535);
    try
    {
      ab.anF().mw(paramInt);
      AppMethodBeat.o(58535);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ab.e("IPxxCallback", "exception:%s", new Object[] { bo.l(localException) });
      AppMethodBeat.o(58535);
    }
  }
  
  public final String getCrashFilePath(int paramInt)
  {
    AppMethodBeat.i(58530);
    Object localObject = new Date(System.currentTimeMillis() - paramInt * 86400000L);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    localObject = com.tencent.mm.compatible.util.e.eQA + "crash_" + localSimpleDateFormat.format((Date)localObject) + ".txt";
    if (com.tencent.mm.a.e.cN((String)localObject))
    {
      AppMethodBeat.o(58530);
      return localObject;
    }
    AppMethodBeat.o(58530);
    return null;
  }
  
  public final String getUplodLogExtrasInfo()
  {
    AppMethodBeat.i(58528);
    try
    {
      Object localObject = new StringBuffer();
      ((StringBuffer)localObject).append("Device:").append(d.whC).append(" ").append(d.whD).append("\n");
      localObject = ((StringBuffer)localObject).toString();
      AppMethodBeat.o(58528);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(58528);
    }
    return null;
  }
  
  public final void recoverLinkAddrs()
  {
    AppMethodBeat.i(58531);
    MMLogic.recoverLinkAddrs();
    AppMethodBeat.o(58531);
  }
  
  public final void setNewDnsDebugHostInfo(String paramString, int paramInt)
  {
    AppMethodBeat.i(58529);
    MMLogic.setNewDnsDebugHost(paramString, String.valueOf(paramInt));
    AppMethodBeat.o(58529);
  }
  
  public final void uploadLogFail()
  {
    AppMethodBeat.i(58533);
    gdt = 0;
    mv(-1);
    AppMethodBeat.o(58533);
  }
  
  public final void uploadLogResponse(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(58532);
    com.tencent.mm.sdk.platformtools.ab.i("IPxxCallback", "ipxx progress totalSize:%d uploadSize:%d lastPercent:%d ", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(gdt) });
    long l = bo.aox();
    if (l - 1L < gds)
    {
      AppMethodBeat.o(58532);
      return;
    }
    gds = l;
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
    if (gdt > j) {
      i = gdt;
    }
    gdt = i;
    mv(i);
    AppMethodBeat.o(58532);
  }
  
  public final void uploadLogSuccess()
  {
    AppMethodBeat.i(58534);
    gdt = 0;
    mv(100);
    AppMethodBeat.o(58534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.network.p
 * JD-Core Version:    0.7.0.1
 */