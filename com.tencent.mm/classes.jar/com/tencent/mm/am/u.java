package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.a.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.g;
import com.tencent.mm.network.h;
import com.tencent.mm.network.i;
import com.tencent.mm.network.j;
import com.tencent.mm.network.k;
import com.tencent.mm.network.n;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.ab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class u
  implements g
{
  public final h ouE;
  private t ouF;
  
  public u(h paramh)
  {
    this.ouE = paramh;
  }
  
  public final void Mb(String paramString)
  {
    AppMethodBeat.i(132397);
    try
    {
      this.ouE.Mb(paramString);
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
  
  public final void Mc(String paramString)
  {
    AppMethodBeat.i(132410);
    try
    {
      this.ouE.Mc(paramString);
      AppMethodBeat.o(132410);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(132410);
    }
  }
  
  public final void Md(String paramString)
  {
    AppMethodBeat.i(132417);
    try
    {
      this.ouE.Md(paramString);
      AppMethodBeat.o(132417);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(132417);
    }
  }
  
  public final String[] Me(String paramString)
  {
    AppMethodBeat.i(236828);
    try
    {
      paramString = this.ouE.Me(paramString);
      AppMethodBeat.o(236828);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(236828);
    }
    return null;
  }
  
  public final int a(com.tencent.mm.network.t paramt, n paramn)
  {
    AppMethodBeat.i(132385);
    try
    {
      int i = this.ouE.a(paramt, paramn);
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
  
  public final int a(String paramString1, int paramInt, long paramLong, String paramString2, String paramString3)
  {
    AppMethodBeat.i(236794);
    try
    {
      paramInt = this.ouE.a(paramString1, paramInt, paramLong, paramString2, paramString3);
      AppMethodBeat.o(236794);
      return paramInt;
    }
    catch (Exception paramString1)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(paramString1) });
      AppMethodBeat.o(236794);
    }
    return -1;
  }
  
  public final int a(String paramString, boolean paramBoolean, List<String> paramList)
  {
    AppMethodBeat.i(132399);
    try
    {
      int i = this.ouE.a(paramString, paramBoolean, paramList);
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
  
  public final int a(int[] paramArrayOfInt, boolean paramBoolean, long paramLong, String paramString)
  {
    AppMethodBeat.i(236795);
    try
    {
      int i = this.ouE.a(paramArrayOfInt, paramBoolean, paramLong, paramString);
      AppMethodBeat.o(236795);
      return i;
    }
    catch (Exception paramArrayOfInt)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(paramArrayOfInt) });
      AppMethodBeat.o(236795);
    }
    return -1;
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(132392);
    try
    {
      this.ouE.a(paramb);
      AppMethodBeat.o(132392);
      return;
    }
    catch (Exception paramb)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(paramb) });
      AppMethodBeat.o(132392);
    }
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(236800);
    try
    {
      this.ouE.a(parami);
      AppMethodBeat.o(236800);
      return;
    }
    catch (Exception parami)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(parami) });
      AppMethodBeat.o(236800);
    }
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(132415);
    try
    {
      this.ouE.a(paramj);
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
      this.ouE.a(paramq);
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
      this.ouE.a(paramab);
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
      this.ouE.a(paramBoolean, paramString1, paramString2, paramArrayOfInt1, paramArrayOfInt2, paramInt1, paramInt2, paramString3, paramString4);
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
  
  public final int ackActionNotify(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(236842);
    try
    {
      paramInt = this.ouE.ackActionNotify(paramString, paramLong, paramInt);
      AppMethodBeat.o(236842);
      return paramInt;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(236842);
    }
    return -1;
  }
  
  public final void addHostInfo(String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(132401);
    try
    {
      this.ouE.addHostInfo(paramArrayOfString1, paramArrayOfString2, paramArrayOfInt);
      AppMethodBeat.o(132401);
      return;
    }
    catch (Exception paramArrayOfString1)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(paramArrayOfString1) });
      AppMethodBeat.o(132401);
    }
  }
  
  public final void bFP()
  {
    AppMethodBeat.i(236797);
    try
    {
      this.ouE.bFP();
      AppMethodBeat.o(236797);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(236797);
    }
  }
  
  public final boolean bFR()
  {
    AppMethodBeat.i(132394);
    try
    {
      boolean bool = this.ouE.bFR();
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
  
  public final e bGg()
  {
    AppMethodBeat.i(132391);
    try
    {
      if (this.ouF == null) {
        this.ouF = new t(this.ouE.bQJ());
      }
      t localt = this.ouF;
      AppMethodBeat.o(132391);
      return localt;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "getAccInfo failed, core service down, %s", new Object[] { localException });
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132391);
    }
    return null;
  }
  
  public final k bGh()
  {
    AppMethodBeat.i(132395);
    try
    {
      k localk = this.ouE.bQL();
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
  
  public final void bGi()
  {
    AppMethodBeat.i(132414);
    try
    {
      this.ouE.bGi();
      AppMethodBeat.o(132414);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132414);
    }
  }
  
  public final void bGj()
  {
    AppMethodBeat.i(132416);
    try
    {
      this.ouE.bGj();
      AppMethodBeat.o(132416);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132416);
    }
  }
  
  public final String[] bGk()
  {
    AppMethodBeat.i(236827);
    try
    {
      String[] arrayOfString = this.ouE.bGk();
      AppMethodBeat.o(236827);
      return arrayOfString;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(236827);
    }
    return null;
  }
  
  public final void cancel(int paramInt)
  {
    AppMethodBeat.i(132388);
    try
    {
      this.ouE.cancel(paramInt);
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
    AppMethodBeat.i(236832);
    try
    {
      this.ouE.clearMMtlsForbidenHostAndPsk();
      AppMethodBeat.o(236832);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(236832);
    }
  }
  
  public final int doLiveSpeedTest(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, com.tencent.mm.network.u paramu)
  {
    AppMethodBeat.i(236843);
    try
    {
      paramInt1 = this.ouE.doLiveSpeedTest(paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfByte1, paramArrayOfByte2, paramu);
      AppMethodBeat.o(236843);
      return paramInt1;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(236843);
    }
    return -1;
  }
  
  public final void forceUseV6(boolean paramBoolean)
  {
    AppMethodBeat.i(176842);
    try
    {
      this.ouE.forceUseV6(paramBoolean);
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
      int i = this.ouE.getHostByName(paramString, paramList);
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
      String[] arrayOfString = this.ouE.getIPsString(paramBoolean);
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
      String str = this.ouE.getIspId();
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
    AppMethodBeat.i(236834);
    try
    {
      int i = this.ouE.getMMtlsRegion();
      AppMethodBeat.o(236834);
      return i;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(236834);
    }
    return 1;
  }
  
  public final long getMarsTimestamp()
  {
    AppMethodBeat.i(236841);
    try
    {
      long l = this.ouE.getMarsTimestamp();
      AppMethodBeat.o(236841);
      return l;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(236841);
    }
    return 0L;
  }
  
  public final String getNetworkServerIp()
  {
    AppMethodBeat.i(132386);
    try
    {
      String str = this.ouE.getNetworkServerIp();
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
  
  public final void ha(boolean paramBoolean)
  {
    AppMethodBeat.i(132393);
    try
    {
      this.ouE.ha(paramBoolean);
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
  
  public final void hb(boolean paramBoolean)
  {
    AppMethodBeat.i(132411);
    try
    {
      this.ouE.hb(paramBoolean);
      AppMethodBeat.o(132411);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132411);
    }
  }
  
  public final void hc(boolean paramBoolean)
  {
    AppMethodBeat.i(132412);
    try
    {
      this.ouE.hc(paramBoolean);
      AppMethodBeat.o(132412);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132412);
    }
  }
  
  public final void hd(boolean paramBoolean)
  {
    AppMethodBeat.i(132413);
    try
    {
      this.ouE.hd(paramBoolean);
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
      this.ouE.keepSignalling();
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
      this.ouE.reportFailIp(paramString);
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
      this.ouE.reportV6Status(paramBoolean);
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
      this.ouE.reset();
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
    AppMethodBeat.i(236823);
    try
    {
      this.ouE.setDebugHost(paramString);
      AppMethodBeat.o(236823);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(236823);
    }
  }
  
  public final void setHostInfo(String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(132400);
    try
    {
      this.ouE.setHostInfo(paramArrayOfString1, paramArrayOfString2, paramArrayOfInt);
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
    AppMethodBeat.i(236836);
    try
    {
      this.ouE.setMMtlsRegion(paramInt);
      AppMethodBeat.o(236836);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(236836);
    }
  }
  
  public final void setNetIdAndIsp(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(236838);
    try
    {
      this.ouE.setNetIdAndIsp(paramString1, paramString2, paramString3);
      AppMethodBeat.o(236838);
      return;
    }
    catch (Exception paramString1)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(paramString1) });
      AppMethodBeat.o(236838);
    }
  }
  
  public final void setSignallingStrategy(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(132405);
    try
    {
      this.ouE.setSignallingStrategy(paramLong1, paramLong2);
      AppMethodBeat.o(132405);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132405);
    }
  }
  
  public final void simpleTestCommand(String paramString)
  {
    AppMethodBeat.i(236840);
    try
    {
      this.ouE.simpleTestCommand(paramString);
      AppMethodBeat.o(236840);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(236840);
    }
  }
  
  public final void stopSignalling()
  {
    AppMethodBeat.i(132407);
    try
    {
      this.ouE.stopSignalling();
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
    AppMethodBeat.i(236819);
    try
    {
      this.ouE.switchProcessActiveState(paramBoolean);
      AppMethodBeat.o(236819);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(236819);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.am.u
 * JD-Core Version:    0.7.0.1
 */