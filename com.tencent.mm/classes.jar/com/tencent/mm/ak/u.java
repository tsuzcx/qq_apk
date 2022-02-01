package com.tencent.mm.ak;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.e;
import com.tencent.mm.network.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class u
  implements e
{
  private final f iMK;
  
  public u(f paramf)
  {
    this.iMK = paramf;
  }
  
  public final byte[] MC(String paramString)
  {
    AppMethodBeat.i(132369);
    try
    {
      paramString = this.iMK.MC(paramString);
      AppMethodBeat.o(132369);
      return paramString;
    }
    catch (RemoteException paramString)
    {
      Log.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(132369);
    }
    return null;
  }
  
  public final byte[] MD(String paramString)
  {
    AppMethodBeat.i(132379);
    try
    {
      paramString = this.iMK.MD(paramString);
      AppMethodBeat.o(132379);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(132379);
    }
    return null;
  }
  
  public final byte[] ME(String paramString)
  {
    AppMethodBeat.i(132382);
    try
    {
      paramString = this.iMK.ME(paramString);
      AppMethodBeat.o(132382);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(132382);
    }
    return null;
  }
  
  public final byte[] MF(String paramString)
  {
    AppMethodBeat.i(132383);
    try
    {
      paramString = this.iMK.MF(paramString);
      AppMethodBeat.o(132383);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(132383);
    }
    return null;
  }
  
  public final boolean MG(String paramString)
  {
    AppMethodBeat.i(132384);
    try
    {
      boolean bool = this.iMK.MG(paramString);
      AppMethodBeat.o(132384);
      return bool;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(132384);
    }
    return false;
  }
  
  public final void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt)
  {
    AppMethodBeat.i(132365);
    try
    {
      this.iMK.a(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramInt);
      AppMethodBeat.o(132365);
      return;
    }
    catch (RemoteException paramArrayOfByte1)
    {
      Log.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { Util.stackTraceToString(paramArrayOfByte1) });
      AppMethodBeat.o(132365);
    }
  }
  
  public final byte[] aZa()
  {
    AppMethodBeat.i(132359);
    try
    {
      byte[] arrayOfByte = this.iMK.aZa();
      AppMethodBeat.o(132359);
      return arrayOfByte;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { Util.stackTraceToString(localRemoteException) });
      AppMethodBeat.o(132359);
    }
    return null;
  }
  
  public final boolean aZb()
  {
    AppMethodBeat.i(132363);
    try
    {
      boolean bool = this.iMK.aZb();
      AppMethodBeat.o(132363);
      return bool;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132363);
    }
    return false;
  }
  
  public final byte[] aZc()
  {
    AppMethodBeat.i(132370);
    try
    {
      byte[] arrayOfByte = this.iMK.aZc();
      AppMethodBeat.o(132370);
      return arrayOfByte;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { Util.stackTraceToString(localRemoteException) });
      AppMethodBeat.o(132370);
    }
    return null;
  }
  
  public final String aZd()
  {
    AppMethodBeat.i(132373);
    try
    {
      String str = this.iMK.aZd();
      AppMethodBeat.o(132373);
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { Util.stackTraceToString(localRemoteException) });
      AppMethodBeat.o(132373);
    }
    return null;
  }
  
  public final byte[] aZe()
  {
    AppMethodBeat.i(132374);
    try
    {
      byte[] arrayOfByte = this.iMK.aZe();
      AppMethodBeat.o(132374);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RAccInfo", "AccInfoCacheInWorker getCacheBuffer exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132374);
    }
    return null;
  }
  
  public final void aZf()
  {
    AppMethodBeat.i(132380);
    try
    {
      this.iMK.aZf();
      AppMethodBeat.o(132380);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132380);
    }
  }
  
  public final void aZg()
  {
    AppMethodBeat.i(132381);
    try
    {
      this.iMK.aZg();
      AppMethodBeat.o(132381);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132381);
    }
  }
  
  public final int al(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132375);
    try
    {
      int i = this.iMK.al(paramArrayOfByte);
      AppMethodBeat.o(132375);
      return i;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e("MicroMsg.RAccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[] { Util.stackTraceToString(paramArrayOfByte) });
      AppMethodBeat.o(132375);
    }
    return -6;
  }
  
  public final int am(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(197062);
    try
    {
      int i = this.iMK.am(paramArrayOfByte);
      AppMethodBeat.o(197062);
      return i;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { Util.stackTraceToString(paramArrayOfByte) });
      AppMethodBeat.o(197062);
    }
    return -1;
  }
  
  public final void b(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(132378);
    try
    {
      this.iMK.b(paramInt, paramArrayOfByte1, paramArrayOfByte2);
      AppMethodBeat.o(132378);
      return;
    }
    catch (Exception paramArrayOfByte1)
    {
      Log.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { Util.stackTraceToString(paramArrayOfByte1) });
      AppMethodBeat.o(132378);
    }
  }
  
  public final int getUin()
  {
    AppMethodBeat.i(132361);
    try
    {
      int i = this.iMK.getUin();
      AppMethodBeat.o(132361);
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { Util.stackTraceToString(localRemoteException) });
      AppMethodBeat.o(132361);
    }
    return 0;
  }
  
  public final String getUsername()
  {
    AppMethodBeat.i(132362);
    try
    {
      String str = this.iMK.getUsername();
      AppMethodBeat.o(132362);
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { Util.stackTraceToString(localRemoteException) });
      AppMethodBeat.o(132362);
    }
    return null;
  }
  
  public final void h(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132377);
    try
    {
      this.iMK.h(paramInt, paramArrayOfByte);
      AppMethodBeat.o(132377);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { Util.stackTraceToString(paramArrayOfByte) });
      AppMethodBeat.o(132377);
    }
  }
  
  public final void i(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132368);
    try
    {
      this.iMK.i(paramString, paramArrayOfByte);
      AppMethodBeat.o(132368);
      return;
    }
    catch (RemoteException paramString)
    {
      Log.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(132368);
    }
  }
  
  public final boolean isForeground()
  {
    AppMethodBeat.i(132372);
    try
    {
      boolean bool = this.iMK.isForeground();
      AppMethodBeat.o(132372);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { Util.stackTraceToString(localRemoteException) });
      AppMethodBeat.o(132372);
    }
    return true;
  }
  
  public final byte[] qe(int paramInt)
  {
    AppMethodBeat.i(132360);
    try
    {
      byte[] arrayOfByte = this.iMK.qe(paramInt);
      AppMethodBeat.o(132360);
      return arrayOfByte;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { Util.stackTraceToString(localRemoteException) });
      AppMethodBeat.o(132360);
    }
    return null;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(132366);
    try
    {
      this.iMK.reset();
      AppMethodBeat.o(132366);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { Util.stackTraceToString(localRemoteException) });
      AppMethodBeat.o(132366);
    }
  }
  
  public final void setForeground(boolean paramBoolean)
  {
    AppMethodBeat.i(132371);
    try
    {
      this.iMK.setForeground(paramBoolean);
      AppMethodBeat.o(132371);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { Util.stackTraceToString(localRemoteException) });
      AppMethodBeat.o(132371);
    }
  }
  
  public final void setUin(int paramInt)
  {
    AppMethodBeat.i(132376);
    try
    {
      this.iMK.setUin(paramInt);
      AppMethodBeat.o(132376);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132376);
    }
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(132364);
    try
    {
      this.iMK.setUsername(paramString);
      AppMethodBeat.o(132364);
      return;
    }
    catch (RemoteException paramString)
    {
      Log.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(132364);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(132367);
    String str = "RAccInfo:\n" + "|-uin     =" + getUin() + "\n";
    str = str + "|-user    =" + getUsername() + "\n";
    str = str + "|-singlesession =" + Util.dumpHex(qe(1)) + "\n";
    str = str + "|-clientsession =" + Util.dumpHex(qe(2)) + "\n";
    str = str + "|-serversession =" + Util.dumpHex(qe(3)) + "\n";
    str = str + "|-ecdhkey =" + Util.dumpHex(aZc()) + "\n";
    str = str + "`-cookie  =" + Util.dumpHex(aZa());
    AppMethodBeat.o(132367);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ak.u
 * JD-Core Version:    0.7.0.1
 */