package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.a.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.g;
import com.tencent.mm.network.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.k;
import com.tencent.mm.network.n;
import com.tencent.mm.network.q;
import com.tencent.mm.network.t;
import com.tencent.mm.protocal.ab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class v
  implements g
{
  public final h lCT;
  private u lCU;
  
  public v(h paramh)
  {
    this.lCT = paramh;
  }
  
  public final void Uc(String paramString)
  {
    AppMethodBeat.i(132397);
    try
    {
      this.lCT.Uc(paramString);
      AppMethodBeat.o(132397);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.RDispatcher", "ipxxStatistics remote call error, %s", new Object[] { paramString });
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(132397);
    }
  }
  
  public final void Ud(String paramString)
  {
    AppMethodBeat.i(132410);
    try
    {
      this.lCT.Ud(paramString);
      AppMethodBeat.o(132410);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(132410);
    }
  }
  
  public final void Ue(String paramString)
  {
    AppMethodBeat.i(132417);
    try
    {
      this.lCT.Ue(paramString);
      AppMethodBeat.o(132417);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(132417);
    }
  }
  
  public final String[] Uf(String paramString)
  {
    AppMethodBeat.i(195300);
    try
    {
      paramString = this.lCT.Uf(paramString);
      AppMethodBeat.o(195300);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(195300);
    }
    return null;
  }
  
  public final int a(t paramt, n paramn)
  {
    AppMethodBeat.i(132385);
    try
    {
      int i = this.lCT.a(paramt, paramn);
      AppMethodBeat.o(132385);
      return i;
    }
    catch (Exception paramt)
    {
      Log.e("MicroMsg.RDispatcher", "remote dispatcher lost, send failed, %s", new Object[] { paramt });
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(paramt) });
      AppMethodBeat.o(132385);
    }
    return -1;
  }
  
  public final int a(String paramString, boolean paramBoolean, List<String> paramList)
  {
    AppMethodBeat.i(132399);
    try
    {
      int i = this.lCT.a(paramString, paramBoolean, paramList);
      AppMethodBeat.o(132399);
      return i;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(132399);
    }
    return -1;
  }
  
  public final void a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(132402);
    try
    {
      this.lCT.a(paramInt1, paramString, paramInt2, paramBoolean);
      AppMethodBeat.o(132402);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(132402);
    }
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(132392);
    try
    {
      this.lCT.a(paramb);
      AppMethodBeat.o(132392);
      return;
    }
    catch (Exception paramb)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(paramb) });
      AppMethodBeat.o(132392);
    }
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(132415);
    try
    {
      this.lCT.a(paramj);
      AppMethodBeat.o(132415);
      return;
    }
    catch (Exception paramj)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(paramj) });
      AppMethodBeat.o(132415);
    }
  }
  
  public final void a(q paramq)
  {
    AppMethodBeat.i(132408);
    try
    {
      this.lCT.a(paramq);
      AppMethodBeat.o(132408);
      return;
    }
    catch (Exception paramq)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(paramq) });
      AppMethodBeat.o(132408);
    }
  }
  
  public final void a(ab paramab)
  {
    AppMethodBeat.i(132396);
    try
    {
      this.lCT.a(paramab);
      AppMethodBeat.o(132396);
      return;
    }
    catch (Exception paramab)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(paramab) });
      AppMethodBeat.o(132396);
    }
  }
  
  public final void a(boolean paramBoolean, String paramString1, String paramString2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(132390);
    try
    {
      this.lCT.a(paramBoolean, paramString1, paramString2, paramArrayOfInt1, paramArrayOfInt2, paramInt1, paramInt2, paramString3, paramString4);
      AppMethodBeat.o(132390);
      return;
    }
    catch (Exception paramString1)
    {
      Log.e("MicroMsg.RDispatcher", "dkidc setIDCHostInfo ip failed, core service down, %s", new Object[] { paramString1 });
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(paramString1) });
      AppMethodBeat.o(132390);
    }
  }
  
  public final void addHostInfo(String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(132401);
    try
    {
      this.lCT.addHostInfo(paramArrayOfString1, paramArrayOfString2, paramArrayOfInt);
      AppMethodBeat.o(132401);
      return;
    }
    catch (Exception paramArrayOfString1)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(paramArrayOfString1) });
      AppMethodBeat.o(132401);
    }
  }
  
  public final void b(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(132403);
    try
    {
      this.lCT.b(paramString1, paramLong, paramString2);
      AppMethodBeat.o(132403);
      return;
    }
    catch (Exception paramString1)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(paramString1) });
      AppMethodBeat.o(132403);
    }
  }
  
  public final String[] biA()
  {
    AppMethodBeat.i(195299);
    try
    {
      String[] arrayOfString = this.lCT.biA();
      AppMethodBeat.o(195299);
      return arrayOfString;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(195299);
    }
    return null;
  }
  
  public final boolean bii()
  {
    AppMethodBeat.i(132394);
    try
    {
      boolean bool = this.lCT.bii();
      AppMethodBeat.o(132394);
      return bool;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "core service down, guess network stable, %s", new Object[] { localException });
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132394);
    }
    return true;
  }
  
  public final e biw()
  {
    AppMethodBeat.i(132391);
    try
    {
      if (this.lCU == null) {
        this.lCU = new u(this.lCT.bta());
      }
      u localu = this.lCU;
      AppMethodBeat.o(132391);
      return localu;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "getAccInfo failed, core service down, %s", new Object[] { localException });
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132391);
    }
    return null;
  }
  
  public final k bix()
  {
    AppMethodBeat.i(132395);
    try
    {
      k localk = this.lCT.btc();
      AppMethodBeat.o(132395);
      return localk;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132395);
    }
    return null;
  }
  
  public final void biy()
  {
    AppMethodBeat.i(132414);
    try
    {
      this.lCT.biy();
      AppMethodBeat.o(132414);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132414);
    }
  }
  
  public final void biz()
  {
    AppMethodBeat.i(132416);
    try
    {
      this.lCT.biz();
      AppMethodBeat.o(132416);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132416);
    }
  }
  
  public final void cancel(int paramInt)
  {
    AppMethodBeat.i(132388);
    try
    {
      this.lCT.cancel(paramInt);
      AppMethodBeat.o(132388);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "cancel remote rr failed, netid=%d, %s", new Object[] { Integer.valueOf(paramInt), localException });
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132388);
    }
  }
  
  public final void clearMMtlsForbidenHostAndPsk()
  {
    AppMethodBeat.i(195302);
    try
    {
      this.lCT.clearMMtlsForbidenHostAndPsk();
      AppMethodBeat.o(195302);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(195302);
    }
  }
  
  public final void forceUseV6(boolean paramBoolean)
  {
    AppMethodBeat.i(176842);
    try
    {
      this.lCT.forceUseV6(paramBoolean);
      AppMethodBeat.o(176842);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(176842);
    }
  }
  
  public final int getHostByName(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(132398);
    try
    {
      int i = this.lCT.getHostByName(paramString, paramList);
      AppMethodBeat.o(132398);
      return i;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(132398);
    }
    return -1;
  }
  
  public final String[] getIPsString(boolean paramBoolean)
  {
    AppMethodBeat.i(132387);
    try
    {
      String[] arrayOfString = this.lCT.getIPsString(paramBoolean);
      AppMethodBeat.o(132387);
      return arrayOfString;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "query remote network server ip failed, %s", new Object[] { localException });
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132387);
    }
    return null;
  }
  
  public final String getIspId()
  {
    AppMethodBeat.i(132404);
    try
    {
      String str = this.lCT.getIspId();
      AppMethodBeat.o(132404);
      return str;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132404);
    }
    return null;
  }
  
  public final int getMMtlsRegion()
  {
    AppMethodBeat.i(195305);
    try
    {
      int i = this.lCT.getMMtlsRegion();
      AppMethodBeat.o(195305);
      return i;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(195305);
    }
    return 1;
  }
  
  public final String getNetworkServerIp()
  {
    AppMethodBeat.i(132386);
    try
    {
      String str = this.lCT.getNetworkServerIp();
      AppMethodBeat.o(132386);
      return str;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "query remote network server ip failed, %s", new Object[] { localException });
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132386);
    }
    return null;
  }
  
  public final void gj(boolean paramBoolean)
  {
    AppMethodBeat.i(132393);
    try
    {
      this.lCT.gj(paramBoolean);
      AppMethodBeat.o(132393);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "change active status failed, core service down, %s", new Object[] { localException });
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132393);
    }
  }
  
  public final void gk(boolean paramBoolean)
  {
    AppMethodBeat.i(132411);
    try
    {
      this.lCT.gk(paramBoolean);
      AppMethodBeat.o(132411);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132411);
    }
  }
  
  public final void gl(boolean paramBoolean)
  {
    AppMethodBeat.i(132412);
    try
    {
      this.lCT.gl(paramBoolean);
      AppMethodBeat.o(132412);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132412);
    }
  }
  
  public final void gm(boolean paramBoolean)
  {
    AppMethodBeat.i(132413);
    try
    {
      this.lCT.gm(paramBoolean);
      AppMethodBeat.o(132413);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132413);
    }
  }
  
  public final void keepSignalling()
  {
    AppMethodBeat.i(132406);
    try
    {
      this.lCT.keepSignalling();
      AppMethodBeat.o(132406);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132406);
    }
  }
  
  public final void reportFailIp(String paramString)
  {
    AppMethodBeat.i(132409);
    try
    {
      this.lCT.reportFailIp(paramString);
      AppMethodBeat.o(132409);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(132409);
    }
  }
  
  public final void reportV6Status(boolean paramBoolean)
  {
    AppMethodBeat.i(176841);
    try
    {
      this.lCT.reportV6Status(paramBoolean);
      AppMethodBeat.o(176841);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(176841);
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(132389);
    try
    {
      this.lCT.reset();
      AppMethodBeat.o(132389);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "reset failed, core service down, %s", new Object[] { localException });
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132389);
    }
  }
  
  public final void setDebugHost(String paramString)
  {
    AppMethodBeat.i(195298);
    try
    {
      this.lCT.setDebugHost(paramString);
      AppMethodBeat.o(195298);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(195298);
    }
  }
  
  public final void setHostInfo(String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(132400);
    try
    {
      this.lCT.setHostInfo(paramArrayOfString1, paramArrayOfString2, paramArrayOfInt);
      AppMethodBeat.o(132400);
      return;
    }
    catch (Exception paramArrayOfString1)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(paramArrayOfString1) });
      AppMethodBeat.o(132400);
    }
  }
  
  public final void setMMtlsRegion(int paramInt)
  {
    AppMethodBeat.i(195307);
    try
    {
      this.lCT.setMMtlsRegion(paramInt);
      AppMethodBeat.o(195307);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(195307);
    }
  }
  
  public final void setNetIdAndIsp(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(195310);
    try
    {
      this.lCT.setNetIdAndIsp(paramString1, paramString2, paramString3);
      AppMethodBeat.o(195310);
      return;
    }
    catch (Exception paramString1)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(paramString1) });
      AppMethodBeat.o(195310);
    }
  }
  
  public final void setSignallingStrategy(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(132405);
    try
    {
      this.lCT.setSignallingStrategy(paramLong1, paramLong2);
      AppMethodBeat.o(132405);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132405);
    }
  }
  
  public final void stopSignalling()
  {
    AppMethodBeat.i(132407);
    try
    {
      this.lCT.stopSignalling();
      AppMethodBeat.o(132407);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132407);
    }
  }
  
  public final void switchProcessActiveState(boolean paramBoolean)
  {
    AppMethodBeat.i(195294);
    try
    {
      this.lCT.switchProcessActiveState(paramBoolean);
      AppMethodBeat.o(195294);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(195294);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.an.v
 * JD-Core Version:    0.7.0.1
 */