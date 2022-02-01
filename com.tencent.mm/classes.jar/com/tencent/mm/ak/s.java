package com.tencent.mm.ak;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.a.b;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.f;
import com.tencent.mm.network.h;
import com.tencent.mm.network.i;
import com.tencent.mm.network.l;
import com.tencent.mm.network.o;
import com.tencent.mm.protocal.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.List;

public final class s
  implements e
{
  public final f hwv;
  private r hww;
  
  public s(f paramf)
  {
    this.hwv = paramf;
  }
  
  public final void As(String paramString)
  {
    AppMethodBeat.i(132397);
    try
    {
      this.hwv.As(paramString);
      AppMethodBeat.o(132397);
      return;
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.RDispatcher", "ipxxStatistics remote call error, %s", new Object[] { paramString });
      ac.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bs.m(paramString) });
      AppMethodBeat.o(132397);
    }
  }
  
  public final void At(String paramString)
  {
    AppMethodBeat.i(132410);
    try
    {
      this.hwv.At(paramString);
      AppMethodBeat.o(132410);
      return;
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bs.m(paramString) });
      AppMethodBeat.o(132410);
    }
  }
  
  public final void Au(String paramString)
  {
    AppMethodBeat.i(132417);
    try
    {
      this.hwv.Au(paramString);
      AppMethodBeat.o(132417);
      return;
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bs.m(paramString) });
      AppMethodBeat.o(132417);
    }
  }
  
  public final int a(com.tencent.mm.network.r paramr, l paraml)
  {
    AppMethodBeat.i(132385);
    try
    {
      int i = this.hwv.a(paramr, paraml);
      AppMethodBeat.o(132385);
      return i;
    }
    catch (Exception paramr)
    {
      ac.e("MicroMsg.RDispatcher", "remote dispatcher lost, send failed, %s", new Object[] { paramr });
      ac.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bs.m(paramr) });
      AppMethodBeat.o(132385);
    }
    return -1;
  }
  
  public final int a(String paramString, boolean paramBoolean, List<String> paramList)
  {
    AppMethodBeat.i(132399);
    try
    {
      int i = this.hwv.a(paramString, paramBoolean, paramList);
      AppMethodBeat.o(132399);
      return i;
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bs.m(paramString) });
      AppMethodBeat.o(132399);
    }
    return -1;
  }
  
  public final void a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(132402);
    try
    {
      this.hwv.a(paramInt1, paramString, paramInt2, paramBoolean);
      AppMethodBeat.o(132402);
      return;
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bs.m(paramString) });
      AppMethodBeat.o(132402);
    }
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(132392);
    try
    {
      this.hwv.a(paramb);
      AppMethodBeat.o(132392);
      return;
    }
    catch (Exception paramb)
    {
      ac.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bs.m(paramb) });
      AppMethodBeat.o(132392);
    }
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(132415);
    try
    {
      this.hwv.a(paramh);
      AppMethodBeat.o(132415);
      return;
    }
    catch (Exception paramh)
    {
      ac.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bs.m(paramh) });
      AppMethodBeat.o(132415);
    }
  }
  
  public final void a(o paramo)
  {
    AppMethodBeat.i(132408);
    try
    {
      this.hwv.a(paramo);
      AppMethodBeat.o(132408);
      return;
    }
    catch (Exception paramo)
    {
      ac.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bs.m(paramo) });
      AppMethodBeat.o(132408);
    }
  }
  
  public final void a(ab paramab)
  {
    AppMethodBeat.i(132396);
    try
    {
      this.hwv.a(paramab);
      AppMethodBeat.o(132396);
      return;
    }
    catch (Exception paramab)
    {
      ac.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bs.m(paramab) });
      AppMethodBeat.o(132396);
    }
  }
  
  public final void a(boolean paramBoolean, String paramString1, String paramString2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(132390);
    try
    {
      this.hwv.a(paramBoolean, paramString1, paramString2, paramArrayOfInt1, paramArrayOfInt2, paramInt1, paramInt2, paramString3, paramString4);
      AppMethodBeat.o(132390);
      return;
    }
    catch (Exception paramString1)
    {
      ac.e("MicroMsg.RDispatcher", "dkidc setIDCHostInfo ip failed, core service down, %s", new Object[] { paramString1 });
      ac.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bs.m(paramString1) });
      AppMethodBeat.o(132390);
    }
  }
  
  public final boolean aBL()
  {
    AppMethodBeat.i(132394);
    try
    {
      boolean bool = this.hwv.aBL();
      AppMethodBeat.o(132394);
      return bool;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.RDispatcher", "core service down, guess network stable, %s", new Object[] { localException });
      ac.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bs.m(localException) });
      AppMethodBeat.o(132394);
    }
    return true;
  }
  
  public final c aBZ()
  {
    AppMethodBeat.i(132391);
    try
    {
      if (this.hww == null) {
        this.hww = new r(this.hwv.aLx());
      }
      r localr = this.hww;
      AppMethodBeat.o(132391);
      return localr;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.RDispatcher", "getAccInfo failed, core service down, %s", new Object[] { localException });
      ac.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bs.m(localException) });
      AppMethodBeat.o(132391);
    }
    return null;
  }
  
  public final i aCa()
  {
    AppMethodBeat.i(132395);
    try
    {
      i locali = this.hwv.aLz();
      AppMethodBeat.o(132395);
      return locali;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bs.m(localException) });
      AppMethodBeat.o(132395);
    }
    return null;
  }
  
  public final void aCb()
  {
    AppMethodBeat.i(132414);
    try
    {
      this.hwv.aCb();
      AppMethodBeat.o(132414);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bs.m(localException) });
      AppMethodBeat.o(132414);
    }
  }
  
  public final void aCc()
  {
    AppMethodBeat.i(132416);
    try
    {
      this.hwv.aCc();
      AppMethodBeat.o(132416);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bs.m(localException) });
      AppMethodBeat.o(132416);
    }
  }
  
  public final void addHostInfo(String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(132401);
    try
    {
      this.hwv.addHostInfo(paramArrayOfString1, paramArrayOfString2, paramArrayOfInt);
      AppMethodBeat.o(132401);
      return;
    }
    catch (Exception paramArrayOfString1)
    {
      ac.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bs.m(paramArrayOfString1) });
      AppMethodBeat.o(132401);
    }
  }
  
  public final void cancel(int paramInt)
  {
    AppMethodBeat.i(132388);
    try
    {
      this.hwv.cancel(paramInt);
      AppMethodBeat.o(132388);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.RDispatcher", "cancel remote rr failed, netid=%d, %s", new Object[] { Integer.valueOf(paramInt), localException });
      ac.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bs.m(localException) });
      AppMethodBeat.o(132388);
    }
  }
  
  public final void d(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(132403);
    try
    {
      this.hwv.d(paramString1, paramLong, paramString2);
      AppMethodBeat.o(132403);
      return;
    }
    catch (Exception paramString1)
    {
      ac.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bs.m(paramString1) });
      AppMethodBeat.o(132403);
    }
  }
  
  public final void eD(boolean paramBoolean)
  {
    AppMethodBeat.i(132393);
    try
    {
      this.hwv.eD(paramBoolean);
      AppMethodBeat.o(132393);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.RDispatcher", "change active status failed, core service down, %s", new Object[] { localException });
      ac.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bs.m(localException) });
      AppMethodBeat.o(132393);
    }
  }
  
  public final void eE(boolean paramBoolean)
  {
    AppMethodBeat.i(132411);
    try
    {
      this.hwv.eE(paramBoolean);
      AppMethodBeat.o(132411);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bs.m(localException) });
      AppMethodBeat.o(132411);
    }
  }
  
  public final void eF(boolean paramBoolean)
  {
    AppMethodBeat.i(132412);
    try
    {
      this.hwv.eF(paramBoolean);
      AppMethodBeat.o(132412);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bs.m(localException) });
      AppMethodBeat.o(132412);
    }
  }
  
  public final void eG(boolean paramBoolean)
  {
    AppMethodBeat.i(132413);
    try
    {
      this.hwv.eG(paramBoolean);
      AppMethodBeat.o(132413);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bs.m(localException) });
      AppMethodBeat.o(132413);
    }
  }
  
  public final void forceUseV6(boolean paramBoolean)
  {
    AppMethodBeat.i(176842);
    try
    {
      this.hwv.forceUseV6(paramBoolean);
      AppMethodBeat.o(176842);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bs.m(localException) });
      AppMethodBeat.o(176842);
    }
  }
  
  public final int getHostByName(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(132398);
    try
    {
      int i = this.hwv.getHostByName(paramString, paramList);
      AppMethodBeat.o(132398);
      return i;
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bs.m(paramString) });
      AppMethodBeat.o(132398);
    }
    return -1;
  }
  
  public final String[] getIPsString(boolean paramBoolean)
  {
    AppMethodBeat.i(132387);
    try
    {
      String[] arrayOfString = this.hwv.getIPsString(paramBoolean);
      AppMethodBeat.o(132387);
      return arrayOfString;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.RDispatcher", "query remote network server ip failed, %s", new Object[] { localException });
      ac.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bs.m(localException) });
      AppMethodBeat.o(132387);
    }
    return null;
  }
  
  public final String getIspId()
  {
    AppMethodBeat.i(132404);
    try
    {
      String str = this.hwv.getIspId();
      AppMethodBeat.o(132404);
      return str;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bs.m(localException) });
      AppMethodBeat.o(132404);
    }
    return null;
  }
  
  public final String getNetworkServerIp()
  {
    AppMethodBeat.i(132386);
    try
    {
      String str = this.hwv.getNetworkServerIp();
      AppMethodBeat.o(132386);
      return str;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.RDispatcher", "query remote network server ip failed, %s", new Object[] { localException });
      ac.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bs.m(localException) });
      AppMethodBeat.o(132386);
    }
    return null;
  }
  
  public final void keepSignalling()
  {
    AppMethodBeat.i(132406);
    try
    {
      this.hwv.keepSignalling();
      AppMethodBeat.o(132406);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bs.m(localException) });
      AppMethodBeat.o(132406);
    }
  }
  
  public final void reportFailIp(String paramString)
  {
    AppMethodBeat.i(132409);
    try
    {
      this.hwv.reportFailIp(paramString);
      AppMethodBeat.o(132409);
      return;
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bs.m(paramString) });
      AppMethodBeat.o(132409);
    }
  }
  
  public final void reportV6Status(boolean paramBoolean)
  {
    AppMethodBeat.i(176841);
    try
    {
      this.hwv.reportV6Status(paramBoolean);
      AppMethodBeat.o(176841);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bs.m(localException) });
      AppMethodBeat.o(176841);
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(132389);
    try
    {
      this.hwv.reset();
      AppMethodBeat.o(132389);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.RDispatcher", "reset failed, core service down, %s", new Object[] { localException });
      ac.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bs.m(localException) });
      AppMethodBeat.o(132389);
    }
  }
  
  public final void setHostInfo(String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(132400);
    try
    {
      this.hwv.setHostInfo(paramArrayOfString1, paramArrayOfString2, paramArrayOfInt);
      AppMethodBeat.o(132400);
      return;
    }
    catch (Exception paramArrayOfString1)
    {
      ac.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bs.m(paramArrayOfString1) });
      AppMethodBeat.o(132400);
    }
  }
  
  public final void setSignallingStrategy(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(132405);
    try
    {
      this.hwv.setSignallingStrategy(paramLong1, paramLong2);
      AppMethodBeat.o(132405);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bs.m(localException) });
      AppMethodBeat.o(132405);
    }
  }
  
  public final void stopSignalling()
  {
    AppMethodBeat.i(132407);
    try
    {
      this.hwv.stopSignalling();
      AppMethodBeat.o(132407);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bs.m(localException) });
      AppMethodBeat.o(132407);
    }
  }
  
  public final void switchProcessActiveState(boolean paramBoolean)
  {
    AppMethodBeat.i(206883);
    try
    {
      this.hwv.switchProcessActiveState(paramBoolean);
      AppMethodBeat.o(206883);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bs.m(localException) });
      AppMethodBeat.o(206883);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ak.s
 * JD-Core Version:    0.7.0.1
 */