package com.tencent.mm.ak;

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
  public final h iML;
  private u iMM;
  
  public v(h paramh)
  {
    this.iML = paramh;
  }
  
  public final void MH(String paramString)
  {
    AppMethodBeat.i(132397);
    try
    {
      this.iML.MH(paramString);
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
  
  public final void MI(String paramString)
  {
    AppMethodBeat.i(132410);
    try
    {
      this.iML.MI(paramString);
      AppMethodBeat.o(132410);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(132410);
    }
  }
  
  public final void MJ(String paramString)
  {
    AppMethodBeat.i(132417);
    try
    {
      this.iML.MJ(paramString);
      AppMethodBeat.o(132417);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(132417);
    }
  }
  
  public final int a(t paramt, n paramn)
  {
    AppMethodBeat.i(132385);
    try
    {
      int i = this.iML.a(paramt, paramn);
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
      int i = this.iML.a(paramString, paramBoolean, paramList);
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
      this.iML.a(paramInt1, paramString, paramInt2, paramBoolean);
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
      this.iML.a(paramb);
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
      this.iML.a(paramj);
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
      this.iML.a(paramq);
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
      this.iML.a(paramab);
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
      this.iML.a(paramBoolean, paramString1, paramString2, paramArrayOfInt1, paramArrayOfInt2, paramInt1, paramInt2, paramString3, paramString4);
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
  
  public final boolean aYT()
  {
    AppMethodBeat.i(132394);
    try
    {
      boolean bool = this.iML.aYT();
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
  
  public final e aZh()
  {
    AppMethodBeat.i(132391);
    try
    {
      if (this.iMM == null) {
        this.iMM = new u(this.iML.bjw());
      }
      u localu = this.iMM;
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
  
  public final k aZi()
  {
    AppMethodBeat.i(132395);
    try
    {
      k localk = this.iML.bjy();
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
  
  public final void aZj()
  {
    AppMethodBeat.i(132414);
    try
    {
      this.iML.aZj();
      AppMethodBeat.o(132414);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132414);
    }
  }
  
  public final void aZk()
  {
    AppMethodBeat.i(132416);
    try
    {
      this.iML.aZk();
      AppMethodBeat.o(132416);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132416);
    }
  }
  
  public final String[] aZl()
  {
    AppMethodBeat.i(197065);
    try
    {
      String[] arrayOfString = this.iML.aZl();
      AppMethodBeat.o(197065);
      return arrayOfString;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(197065);
    }
    return null;
  }
  
  public final void addHostInfo(String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(132401);
    try
    {
      this.iML.addHostInfo(paramArrayOfString1, paramArrayOfString2, paramArrayOfInt);
      AppMethodBeat.o(132401);
      return;
    }
    catch (Exception paramArrayOfString1)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(paramArrayOfString1) });
      AppMethodBeat.o(132401);
    }
  }
  
  public final void cancel(int paramInt)
  {
    AppMethodBeat.i(132388);
    try
    {
      this.iML.cancel(paramInt);
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
  
  public final void d(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(132403);
    try
    {
      this.iML.d(paramString1, paramLong, paramString2);
      AppMethodBeat.o(132403);
      return;
    }
    catch (Exception paramString1)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(paramString1) });
      AppMethodBeat.o(132403);
    }
  }
  
  public final void fA(boolean paramBoolean)
  {
    AppMethodBeat.i(132412);
    try
    {
      this.iML.fA(paramBoolean);
      AppMethodBeat.o(132412);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132412);
    }
  }
  
  public final void fB(boolean paramBoolean)
  {
    AppMethodBeat.i(132413);
    try
    {
      this.iML.fB(paramBoolean);
      AppMethodBeat.o(132413);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132413);
    }
  }
  
  public final void forceUseV6(boolean paramBoolean)
  {
    AppMethodBeat.i(176842);
    try
    {
      this.iML.forceUseV6(paramBoolean);
      AppMethodBeat.o(176842);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(176842);
    }
  }
  
  public final void fy(boolean paramBoolean)
  {
    AppMethodBeat.i(132393);
    try
    {
      this.iML.fy(paramBoolean);
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
  
  public final void fz(boolean paramBoolean)
  {
    AppMethodBeat.i(132411);
    try
    {
      this.iML.fz(paramBoolean);
      AppMethodBeat.o(132411);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132411);
    }
  }
  
  public final int getHostByName(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(132398);
    try
    {
      int i = this.iML.getHostByName(paramString, paramList);
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
      String[] arrayOfString = this.iML.getIPsString(paramBoolean);
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
      String str = this.iML.getIspId();
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
  
  public final String getNetworkServerIp()
  {
    AppMethodBeat.i(132386);
    try
    {
      String str = this.iML.getNetworkServerIp();
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
  
  public final void keepSignalling()
  {
    AppMethodBeat.i(132406);
    try
    {
      this.iML.keepSignalling();
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
      this.iML.reportFailIp(paramString);
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
      this.iML.reportV6Status(paramBoolean);
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
      this.iML.reset();
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
    AppMethodBeat.i(197064);
    try
    {
      this.iML.setDebugHost(paramString);
      AppMethodBeat.o(197064);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(197064);
    }
  }
  
  public final void setHostInfo(String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(132400);
    try
    {
      this.iML.setHostInfo(paramArrayOfString1, paramArrayOfString2, paramArrayOfInt);
      AppMethodBeat.o(132400);
      return;
    }
    catch (Exception paramArrayOfString1)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(paramArrayOfString1) });
      AppMethodBeat.o(132400);
    }
  }
  
  public final void setSignallingStrategy(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(132405);
    try
    {
      this.iML.setSignallingStrategy(paramLong1, paramLong2);
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
      this.iML.stopSignalling();
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
    AppMethodBeat.i(197063);
    try
    {
      this.iML.switchProcessActiveState(paramBoolean);
      AppMethodBeat.o(197063);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RDispatcher", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(197063);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ak.v
 * JD-Core Version:    0.7.0.1
 */