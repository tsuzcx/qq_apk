package com.tencent.mm.am;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.e;
import com.tencent.mm.network.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class t
  implements e
{
  private final f ouD;
  
  public t(f paramf)
  {
    this.ouD = paramf;
  }
  
  public final byte[] LW(String paramString)
  {
    AppMethodBeat.i(132369);
    try
    {
      paramString = this.ouD.LW(paramString);
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
  
  public final byte[] LX(String paramString)
  {
    AppMethodBeat.i(132379);
    try
    {
      paramString = this.ouD.LX(paramString);
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
  
  public final byte[] LY(String paramString)
  {
    AppMethodBeat.i(132382);
    try
    {
      paramString = this.ouD.LY(paramString);
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
  
  public final byte[] LZ(String paramString)
  {
    AppMethodBeat.i(132383);
    try
    {
      paramString = this.ouD.LZ(paramString);
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
  
  public final boolean Ma(String paramString)
  {
    AppMethodBeat.i(132384);
    try
    {
      boolean bool = this.ouD.Ma(paramString);
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
      this.ouD.a(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramInt);
      AppMethodBeat.o(132365);
      return;
    }
    catch (RemoteException paramArrayOfByte1)
    {
      Log.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { Util.stackTraceToString(paramArrayOfByte1) });
      AppMethodBeat.o(132365);
    }
  }
  
  public final int av(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132375);
    try
    {
      int i = this.ouD.av(paramArrayOfByte);
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
  
  public final int aw(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(236844);
    try
    {
      int i = this.ouD.aw(paramArrayOfByte);
      AppMethodBeat.o(236844);
      return i;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { Util.stackTraceToString(paramArrayOfByte) });
      AppMethodBeat.o(236844);
    }
    return -1;
  }
  
  public final void b(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(132378);
    try
    {
      this.ouD.b(paramInt, paramArrayOfByte1, paramArrayOfByte2);
      AppMethodBeat.o(132378);
      return;
    }
    catch (Exception paramArrayOfByte1)
    {
      Log.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { Util.stackTraceToString(paramArrayOfByte1) });
      AppMethodBeat.o(132378);
    }
  }
  
  public final byte[] bFZ()
  {
    AppMethodBeat.i(132359);
    try
    {
      byte[] arrayOfByte = this.ouD.bFZ();
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
  
  public final boolean bGa()
  {
    AppMethodBeat.i(132363);
    try
    {
      boolean bool = this.ouD.bGa();
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
  
  public final byte[] bGb()
  {
    AppMethodBeat.i(132370);
    try
    {
      byte[] arrayOfByte = this.ouD.bGb();
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
  
  public final String bGc()
  {
    AppMethodBeat.i(132373);
    try
    {
      String str = this.ouD.bGc();
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
  
  public final byte[] bGd()
  {
    AppMethodBeat.i(132374);
    try
    {
      byte[] arrayOfByte = this.ouD.bGd();
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
  
  public final void bGe()
  {
    AppMethodBeat.i(132380);
    try
    {
      this.ouD.bGe();
      AppMethodBeat.o(132380);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132380);
    }
  }
  
  public final void bGf()
  {
    AppMethodBeat.i(132381);
    try
    {
      this.ouD.bGf();
      AppMethodBeat.o(132381);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132381);
    }
  }
  
  public final int getUin()
  {
    AppMethodBeat.i(132361);
    try
    {
      int i = this.ouD.getUin();
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
      String str = this.ouD.getUsername();
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
  
  public final void i(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132377);
    try
    {
      this.ouD.i(paramInt, paramArrayOfByte);
      AppMethodBeat.o(132377);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { Util.stackTraceToString(paramArrayOfByte) });
      AppMethodBeat.o(132377);
    }
  }
  
  public final boolean isForeground()
  {
    AppMethodBeat.i(132372);
    try
    {
      boolean bool = this.ouD.isForeground();
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
  
  public final void k(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132368);
    try
    {
      this.ouD.k(paramString, paramArrayOfByte);
      AppMethodBeat.o(132368);
      return;
    }
    catch (RemoteException paramString)
    {
      Log.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
      AppMethodBeat.o(132368);
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(132366);
    try
    {
      this.ouD.reset();
      AppMethodBeat.o(132366);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { Util.stackTraceToString(localRemoteException) });
      AppMethodBeat.o(132366);
    }
  }
  
  public final byte[] sA(int paramInt)
  {
    AppMethodBeat.i(132360);
    try
    {
      byte[] arrayOfByte = this.ouD.sA(paramInt);
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
  
  public final void setForeground(boolean paramBoolean)
  {
    AppMethodBeat.i(132371);
    try
    {
      this.ouD.setForeground(paramBoolean);
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
      this.ouD.setUin(paramInt);
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
      this.ouD.setUsername(paramString);
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
    str = str + "|-singlesession =" + Util.dumpHex(sA(1)) + "\n";
    str = str + "|-clientsession =" + Util.dumpHex(sA(2)) + "\n";
    str = str + "|-serversession =" + Util.dumpHex(sA(3)) + "\n";
    str = str + "|-ecdhkey =" + Util.dumpHex(bGb()) + "\n";
    str = str + "`-cookie  =" + Util.dumpHex(bFZ());
    AppMethodBeat.o(132367);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.am.t
 * JD-Core Version:    0.7.0.1
 */