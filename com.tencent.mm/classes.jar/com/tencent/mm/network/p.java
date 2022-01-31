package com.tencent.mm.network;

import android.os.RemoteException;
import com.tencent.mars.magicbox.IPxxLogic.ICallBack;
import com.tencent.mars.mm.MMLogic;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class p
  implements IPxxLogic.ICallBack
{
  private static long eNE = 0L;
  private static int eNF = 0;
  private final String TAG = "IPxxCallback";
  
  private static void jC(int paramInt)
  {
    try
    {
      t localt = aa.Uu();
      g localg = localt.eNS;
      if (localg != null) {}
      try
      {
        localt.eNS.eq(paramInt);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        y.e("MicroMsg.AutoAuth", "exception:%s", new Object[] { bk.j(localRemoteException) });
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("IPxxCallback", "exception:%s", new Object[] { bk.j(localException) });
    }
  }
  
  public final String getCrashFilePath(int paramInt)
  {
    Object localObject = new Date(System.currentTimeMillis() - paramInt * 86400000L);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    localObject = com.tencent.mm.compatible.util.e.dOR + "crash_" + localSimpleDateFormat.format((Date)localObject) + ".txt";
    if (com.tencent.mm.a.e.bK((String)localObject)) {
      return localObject;
    }
    return null;
  }
  
  public final String getUplodLogExtrasInfo()
  {
    try
    {
      Object localObject = new StringBuffer();
      ((StringBuffer)localObject).append("Device:").append(d.soV).append(" ").append(d.soW).append("\n");
      localObject = ((StringBuffer)localObject).toString();
      return localObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public final void recoverLinkAddrs() {}
  
  public final void setNewDnsDebugHostInfo(String paramString, int paramInt)
  {
    MMLogic.setNewDnsDebugHost(paramString, String.valueOf(paramInt));
  }
  
  public final void uploadLogFail()
  {
    eNF = 0;
    jC(-1);
  }
  
  public final void uploadLogResponse(long paramLong1, long paramLong2)
  {
    int j = 100;
    int k = 0;
    y.i("IPxxCallback", "ipxx progress totalSize:%d uploadSize:%d lastPercent:%d ", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(eNF) });
    long l = bk.UX();
    if (l - 1L < eNE) {
      return;
    }
    eNE = l;
    int i = k;
    if (paramLong2 >= 0L)
    {
      i = k;
      if (paramLong1 > 0L)
      {
        i = k;
        if (paramLong2 < paramLong1) {
          i = (int)(100L * paramLong2 / paramLong1);
        }
      }
    }
    if (i > 100) {
      i = j;
    }
    for (;;)
    {
      j = i;
      if (eNF > i) {
        j = eNF;
      }
      eNF = j;
      jC(j);
      return;
    }
  }
  
  public final void uploadLogSuccess()
  {
    eNF = 0;
    jC(100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.network.p
 * JD-Core Version:    0.7.0.1
 */