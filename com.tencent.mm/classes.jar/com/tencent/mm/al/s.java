package com.tencent.mm.al;

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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;

public final class s
  implements e
{
  public final f gVW;
  private r gVX;
  
  public s(f paramf)
  {
    this.gVW = paramf;
  }
  
  public final int a(com.tencent.mm.network.r paramr, l paraml)
  {
    AppMethodBeat.i(132385);
    try
    {
      int i = this.gVW.a(paramr, paraml);
      AppMethodBeat.o(132385);
      return i;
    }
    catch (Exception paramr)
    {
      ad.e("MicroMsg.RDispatcher", "remote dispatcher lost, send failed, %s", new Object[] { paramr });
      ad.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bt.m(paramr) });
      AppMethodBeat.o(132385);
    }
    return -1;
  }
  
  public final int a(String paramString, boolean paramBoolean, List<String> paramList)
  {
    AppMethodBeat.i(132399);
    try
    {
      int i = this.gVW.a(paramString, paramBoolean, paramList);
      AppMethodBeat.o(132399);
      return i;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bt.m(paramString) });
      AppMethodBeat.o(132399);
    }
    return -1;
  }
  
  public final void a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(132402);
    try
    {
      this.gVW.a(paramInt1, paramString, paramInt2, paramBoolean);
      AppMethodBeat.o(132402);
      return;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bt.m(paramString) });
      AppMethodBeat.o(132402);
    }
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(132392);
    try
    {
      this.gVW.a(paramb);
      AppMethodBeat.o(132392);
      return;
    }
    catch (Exception paramb)
    {
      ad.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bt.m(paramb) });
      AppMethodBeat.o(132392);
    }
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(132415);
    try
    {
      this.gVW.a(paramh);
      AppMethodBeat.o(132415);
      return;
    }
    catch (Exception paramh)
    {
      ad.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bt.m(paramh) });
      AppMethodBeat.o(132415);
    }
  }
  
  public final void a(o paramo)
  {
    AppMethodBeat.i(132408);
    try
    {
      this.gVW.a(paramo);
      AppMethodBeat.o(132408);
      return;
    }
    catch (Exception paramo)
    {
      ad.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bt.m(paramo) });
      AppMethodBeat.o(132408);
    }
  }
  
  public final void a(ab paramab)
  {
    AppMethodBeat.i(132396);
    try
    {
      this.gVW.a(paramab);
      AppMethodBeat.o(132396);
      return;
    }
    catch (Exception paramab)
    {
      ad.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bt.m(paramab) });
      AppMethodBeat.o(132396);
    }
  }
  
  public final void a(boolean paramBoolean, String paramString1, String paramString2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(132390);
    try
    {
      this.gVW.a(paramBoolean, paramString1, paramString2, paramArrayOfInt1, paramArrayOfInt2, paramInt1, paramInt2, paramString3, paramString4);
      AppMethodBeat.o(132390);
      return;
    }
    catch (Exception paramString1)
    {
      ad.e("MicroMsg.RDispatcher", "dkidc setIDCHostInfo ip failed, core service down, %s", new Object[] { paramString1 });
      ad.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bt.m(paramString1) });
      AppMethodBeat.o(132390);
    }
  }
  
  public final void addHostInfo(String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(132401);
    try
    {
      this.gVW.addHostInfo(paramArrayOfString1, paramArrayOfString2, paramArrayOfInt);
      AppMethodBeat.o(132401);
      return;
    }
    catch (Exception paramArrayOfString1)
    {
      ad.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bt.m(paramArrayOfString1) });
      AppMethodBeat.o(132401);
    }
  }
  
  public final boolean auS()
  {
    AppMethodBeat.i(132394);
    try
    {
      boolean bool = this.gVW.auS();
      AppMethodBeat.o(132394);
      return bool;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.RDispatcher", "core service down, guess network stable, %s", new Object[] { localException });
      ad.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bt.m(localException) });
      AppMethodBeat.o(132394);
    }
    return true;
  }
  
  public final c avg()
  {
    AppMethodBeat.i(132391);
    try
    {
      if (this.gVX == null) {
        this.gVX = new r(this.gVW.aEG());
      }
      r localr = this.gVX;
      AppMethodBeat.o(132391);
      return localr;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.RDispatcher", "getAccInfo failed, core service down, %s", new Object[] { localException });
      ad.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bt.m(localException) });
      AppMethodBeat.o(132391);
    }
    return null;
  }
  
  public final i avh()
  {
    AppMethodBeat.i(132395);
    try
    {
      i locali = this.gVW.aEI();
      AppMethodBeat.o(132395);
      return locali;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bt.m(localException) });
      AppMethodBeat.o(132395);
    }
    return null;
  }
  
  public final void avi()
  {
    AppMethodBeat.i(132414);
    try
    {
      this.gVW.avi();
      AppMethodBeat.o(132414);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bt.m(localException) });
      AppMethodBeat.o(132414);
    }
  }
  
  public final void avj()
  {
    AppMethodBeat.i(132416);
    try
    {
      this.gVW.avj();
      AppMethodBeat.o(132416);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bt.m(localException) });
      AppMethodBeat.o(132416);
    }
  }
  
  public final void c(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(132403);
    try
    {
      this.gVW.c(paramString1, paramLong, paramString2);
      AppMethodBeat.o(132403);
      return;
    }
    catch (Exception paramString1)
    {
      ad.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bt.m(paramString1) });
      AppMethodBeat.o(132403);
    }
  }
  
  public final void cancel(int paramInt)
  {
    AppMethodBeat.i(132388);
    try
    {
      this.gVW.cancel(paramInt);
      AppMethodBeat.o(132388);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.RDispatcher", "cancel remote rr failed, netid=%d, %s", new Object[] { Integer.valueOf(paramInt), localException });
      ad.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bt.m(localException) });
      AppMethodBeat.o(132388);
    }
  }
  
  public final void ei(boolean paramBoolean)
  {
    AppMethodBeat.i(132393);
    try
    {
      this.gVW.ei(paramBoolean);
      AppMethodBeat.o(132393);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.RDispatcher", "change active status failed, core service down, %s", new Object[] { localException });
      ad.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bt.m(localException) });
      AppMethodBeat.o(132393);
    }
  }
  
  public final void ej(boolean paramBoolean)
  {
    AppMethodBeat.i(132411);
    try
    {
      this.gVW.ej(paramBoolean);
      AppMethodBeat.o(132411);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bt.m(localException) });
      AppMethodBeat.o(132411);
    }
  }
  
  public final void ek(boolean paramBoolean)
  {
    AppMethodBeat.i(132412);
    try
    {
      this.gVW.ek(paramBoolean);
      AppMethodBeat.o(132412);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bt.m(localException) });
      AppMethodBeat.o(132412);
    }
  }
  
  public final void el(boolean paramBoolean)
  {
    AppMethodBeat.i(132413);
    try
    {
      this.gVW.el(paramBoolean);
      AppMethodBeat.o(132413);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bt.m(localException) });
      AppMethodBeat.o(132413);
    }
  }
  
  public final void forceUseV6(boolean paramBoolean)
  {
    AppMethodBeat.i(176842);
    try
    {
      this.gVW.forceUseV6(paramBoolean);
      AppMethodBeat.o(176842);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bt.m(localException) });
      AppMethodBeat.o(176842);
    }
  }
  
  public final int getHostByName(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(132398);
    try
    {
      int i = this.gVW.getHostByName(paramString, paramList);
      AppMethodBeat.o(132398);
      return i;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bt.m(paramString) });
      AppMethodBeat.o(132398);
    }
    return -1;
  }
  
  public final String[] getIPsString(boolean paramBoolean)
  {
    AppMethodBeat.i(132387);
    try
    {
      String[] arrayOfString = this.gVW.getIPsString(paramBoolean);
      AppMethodBeat.o(132387);
      return arrayOfString;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.RDispatcher", "query remote network server ip failed, %s", new Object[] { localException });
      ad.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bt.m(localException) });
      AppMethodBeat.o(132387);
    }
    return null;
  }
  
  public final String getIspId()
  {
    AppMethodBeat.i(132404);
    try
    {
      String str = this.gVW.getIspId();
      AppMethodBeat.o(132404);
      return str;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bt.m(localException) });
      AppMethodBeat.o(132404);
    }
    return null;
  }
  
  public final String getNetworkServerIp()
  {
    AppMethodBeat.i(132386);
    try
    {
      String str = this.gVW.getNetworkServerIp();
      AppMethodBeat.o(132386);
      return str;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.RDispatcher", "query remote network server ip failed, %s", new Object[] { localException });
      ad.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bt.m(localException) });
      AppMethodBeat.o(132386);
    }
    return null;
  }
  
  public final void keepSignalling()
  {
    AppMethodBeat.i(132406);
    try
    {
      this.gVW.keepSignalling();
      AppMethodBeat.o(132406);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bt.m(localException) });
      AppMethodBeat.o(132406);
    }
  }
  
  public final void reportFailIp(String paramString)
  {
    AppMethodBeat.i(132409);
    try
    {
      this.gVW.reportFailIp(paramString);
      AppMethodBeat.o(132409);
      return;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bt.m(paramString) });
      AppMethodBeat.o(132409);
    }
  }
  
  public final void reportV6Status(boolean paramBoolean)
  {
    AppMethodBeat.i(176841);
    try
    {
      this.gVW.reportV6Status(paramBoolean);
      AppMethodBeat.o(176841);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bt.m(localException) });
      AppMethodBeat.o(176841);
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(132389);
    try
    {
      this.gVW.reset();
      AppMethodBeat.o(132389);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.RDispatcher", "reset failed, core service down, %s", new Object[] { localException });
      ad.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bt.m(localException) });
      AppMethodBeat.o(132389);
    }
  }
  
  public final void setHostInfo(String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(132400);
    try
    {
      this.gVW.setHostInfo(paramArrayOfString1, paramArrayOfString2, paramArrayOfInt);
      AppMethodBeat.o(132400);
      return;
    }
    catch (Exception paramArrayOfString1)
    {
      ad.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bt.m(paramArrayOfString1) });
      AppMethodBeat.o(132400);
    }
  }
  
  public final void setSignallingStrategy(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(132405);
    try
    {
      this.gVW.setSignallingStrategy(paramLong1, paramLong2);
      AppMethodBeat.o(132405);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bt.m(localException) });
      AppMethodBeat.o(132405);
    }
  }
  
  public final void stopSignalling()
  {
    AppMethodBeat.i(132407);
    try
    {
      this.gVW.stopSignalling();
      AppMethodBeat.o(132407);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bt.m(localException) });
      AppMethodBeat.o(132407);
    }
  }
  
  public final void switchProcessActiveState(boolean paramBoolean)
  {
    AppMethodBeat.i(192874);
    try
    {
      this.gVW.switchProcessActiveState(paramBoolean);
      AppMethodBeat.o(192874);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bt.m(localException) });
      AppMethodBeat.o(192874);
    }
  }
  
  public final void wm(String paramString)
  {
    AppMethodBeat.i(132397);
    try
    {
      this.gVW.wm(paramString);
      AppMethodBeat.o(132397);
      return;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.RDispatcher", "ipxxStatistics remote call error, %s", new Object[] { paramString });
      ad.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bt.m(paramString) });
      AppMethodBeat.o(132397);
    }
  }
  
  public final void wn(String paramString)
  {
    AppMethodBeat.i(132410);
    try
    {
      this.gVW.wn(paramString);
      AppMethodBeat.o(132410);
      return;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bt.m(paramString) });
      AppMethodBeat.o(132410);
    }
  }
  
  public final void wo(String paramString)
  {
    AppMethodBeat.i(132417);
    try
    {
      this.gVW.wo(paramString);
      AppMethodBeat.o(132417);
      return;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { bt.m(paramString) });
      AppMethodBeat.o(132417);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.al.s
 * JD-Core Version:    0.7.0.1
 */