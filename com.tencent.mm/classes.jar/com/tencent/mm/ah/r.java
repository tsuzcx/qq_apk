package com.tencent.mm.ah;

import com.tencent.mm.network.a.b;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.f;
import com.tencent.mm.network.h;
import com.tencent.mm.network.i;
import com.tencent.mm.network.l;
import com.tencent.mm.network.o;
import com.tencent.mm.protocal.x;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

public final class r
  implements e
{
  public final f edO;
  private q edP;
  
  public r(f paramf)
  {
    this.edO = paramf;
  }
  
  public final boolean KH()
  {
    try
    {
      boolean bool = this.edO.KH();
      return bool;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.RDispatcher", "core service down, guess network stable, %s", new Object[] { localException });
      y.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bk.j(localException) });
    }
    return true;
  }
  
  public final c KR()
  {
    try
    {
      if (this.edP == null) {
        this.edP = new q(this.edO.TS());
      }
      q localq = this.edP;
      return localq;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.RDispatcher", "getAccInfo failed, core service down, %s", new Object[] { localException });
      y.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bk.j(localException) });
    }
    return null;
  }
  
  public final i KS()
  {
    try
    {
      i locali = this.edO.TU();
      return locali;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bk.j(localException) });
    }
    return null;
  }
  
  public final void KT()
  {
    try
    {
      this.edO.KT();
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bk.j(localException) });
    }
  }
  
  public final void KU()
  {
    try
    {
      this.edO.KU();
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bk.j(localException) });
    }
  }
  
  public final int a(com.tencent.mm.network.r paramr, l paraml)
  {
    try
    {
      int i = this.edO.a(paramr, paraml);
      return i;
    }
    catch (Exception paramr)
    {
      y.e("MicroMsg.RDispatcher", "remote dispatcher lost, send failed, %s", new Object[] { paramr });
      y.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bk.j(paramr) });
    }
    return -1;
  }
  
  public final int a(String paramString, boolean paramBoolean, List<String> paramList)
  {
    try
    {
      int i = this.edO.a(paramString, paramBoolean, paramList);
      return i;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bk.j(paramString) });
    }
    return -1;
  }
  
  public final void a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    try
    {
      this.edO.a(paramInt1, paramString, paramInt2, paramBoolean);
      return;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bk.j(paramString) });
    }
  }
  
  public final void a(b paramb)
  {
    try
    {
      this.edO.a(paramb);
      return;
    }
    catch (Exception paramb)
    {
      y.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bk.j(paramb) });
    }
  }
  
  public final void a(h paramh)
  {
    try
    {
      this.edO.a(paramh);
      return;
    }
    catch (Exception paramh)
    {
      y.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bk.j(paramh) });
    }
  }
  
  public final void a(o paramo)
  {
    try
    {
      this.edO.a(paramo);
      return;
    }
    catch (Exception paramo)
    {
      y.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bk.j(paramo) });
    }
  }
  
  public final void a(x paramx)
  {
    try
    {
      this.edO.a(paramx);
      return;
    }
    catch (Exception paramx)
    {
      y.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bk.j(paramx) });
    }
  }
  
  public final void a(boolean paramBoolean, String paramString1, String paramString2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, String paramString3, String paramString4)
  {
    try
    {
      this.edO.a(paramBoolean, paramString1, paramString2, paramArrayOfInt1, paramArrayOfInt2, paramInt1, paramInt2, paramString3, paramString4);
      return;
    }
    catch (Exception paramString1)
    {
      y.e("MicroMsg.RDispatcher", "dkidc setIDCHostInfo ip failed, core service down, %s", new Object[] { paramString1 });
      y.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bk.j(paramString1) });
    }
  }
  
  public final void bO(boolean paramBoolean)
  {
    try
    {
      this.edO.bO(paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.RDispatcher", "change active status failed, core service down, %s", new Object[] { localException });
      y.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bk.j(localException) });
    }
  }
  
  public final void bP(boolean paramBoolean)
  {
    try
    {
      this.edO.bP(paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bk.j(localException) });
    }
  }
  
  public final void bQ(boolean paramBoolean)
  {
    try
    {
      this.edO.bQ(paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bk.j(localException) });
    }
  }
  
  public final void bR(boolean paramBoolean)
  {
    try
    {
      this.edO.bR(paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bk.j(localException) });
    }
  }
  
  public final void cancel(int paramInt)
  {
    try
    {
      this.edO.cancel(paramInt);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.RDispatcher", "cancel remote rr failed, netid=%d, %s", new Object[] { Integer.valueOf(paramInt), localException });
      y.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bk.j(localException) });
    }
  }
  
  public final int getHostByName(String paramString, List<String> paramList)
  {
    try
    {
      int i = this.edO.getHostByName(paramString, paramList);
      return i;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bk.j(paramString) });
    }
    return -1;
  }
  
  public final String[] getIPsString(boolean paramBoolean)
  {
    try
    {
      String[] arrayOfString = this.edO.getIPsString(paramBoolean);
      return arrayOfString;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.RDispatcher", "query remote network server ip failed, %s", new Object[] { localException });
      y.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bk.j(localException) });
    }
    return null;
  }
  
  public final String getIspId()
  {
    try
    {
      String str = this.edO.getIspId();
      return str;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bk.j(localException) });
    }
    return null;
  }
  
  public final String getNetworkServerIp()
  {
    try
    {
      String str = this.edO.getNetworkServerIp();
      return str;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.RDispatcher", "query remote network server ip failed, %s", new Object[] { localException });
      y.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bk.j(localException) });
    }
    return null;
  }
  
  public final void keepSignalling()
  {
    try
    {
      this.edO.keepSignalling();
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bk.j(localException) });
    }
  }
  
  public final void kt(String paramString)
  {
    try
    {
      this.edO.kt(paramString);
      return;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.RDispatcher", "ipxxStatistics remote call error, %s", new Object[] { paramString });
      y.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bk.j(paramString) });
    }
  }
  
  public final void ku(String paramString)
  {
    try
    {
      this.edO.ku(paramString);
      return;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bk.j(paramString) });
    }
  }
  
  public final void reportFailIp(String paramString)
  {
    try
    {
      this.edO.reportFailIp(paramString);
      return;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bk.j(paramString) });
    }
  }
  
  public final void reset()
  {
    try
    {
      this.edO.reset();
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.RDispatcher", "reset failed, core service down, %s", new Object[] { localException });
      y.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bk.j(localException) });
    }
  }
  
  public final void setHostInfo(String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt)
  {
    try
    {
      this.edO.setHostInfo(paramArrayOfString1, paramArrayOfString2, paramArrayOfInt);
      return;
    }
    catch (Exception paramArrayOfString1)
    {
      y.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bk.j(paramArrayOfString1) });
    }
  }
  
  public final void setSignallingStrategy(long paramLong1, long paramLong2)
  {
    try
    {
      this.edO.setSignallingStrategy(paramLong1, paramLong2);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bk.j(localException) });
    }
  }
  
  public final void stopSignalling()
  {
    try
    {
      this.edO.stopSignalling();
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bk.j(localException) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ah.r
 * JD-Core Version:    0.7.0.1
 */