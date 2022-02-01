package com.tencent.mm.an;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.e;
import com.tencent.mm.network.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class u
  implements e
{
  private final f lCS;
  
  public u(f paramf)
  {
    this.lCS = paramf;
  }
  
  public final byte[] TX(String paramString)
  {
    AppMethodBeat.i(132369);
    try
    {
      paramString = this.lCS.TX(paramString);
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
  
  public final byte[] TY(String paramString)
  {
    AppMethodBeat.i(132379);
    try
    {
      paramString = this.lCS.TY(paramString);
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
  
  public final byte[] TZ(String paramString)
  {
    AppMethodBeat.i(132382);
    try
    {
      paramString = this.lCS.TZ(paramString);
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
  
  public final byte[] Ua(String paramString)
  {
    AppMethodBeat.i(132383);
    try
    {
      paramString = this.lCS.Ua(paramString);
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
  
  public final boolean Ub(String paramString)
  {
    AppMethodBeat.i(132384);
    try
    {
      boolean bool = this.lCS.Ub(paramString);
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
      this.lCS.a(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramInt);
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
      int i = this.lCS.av(paramArrayOfByte);
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
    AppMethodBeat.i(200163);
    try
    {
      int i = this.lCS.aw(paramArrayOfByte);
      AppMethodBeat.o(200163);
      return i;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { Util.stackTraceToString(paramArrayOfByte) });
      AppMethodBeat.o(200163);
    }
    return -1;
  }
  
  public final void b(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(132378);
    try
    {
      this.lCS.b(paramInt, paramArrayOfByte1, paramArrayOfByte2);
      AppMethodBeat.o(132378);
      return;
    }
    catch (Exception paramArrayOfByte1)
    {
      Log.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { Util.stackTraceToString(paramArrayOfByte1) });
      AppMethodBeat.o(132378);
    }
  }
  
  public final byte[] bip()
  {
    AppMethodBeat.i(132359);
    try
    {
      byte[] arrayOfByte = this.lCS.bip();
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
  
  public final boolean biq()
  {
    AppMethodBeat.i(132363);
    try
    {
      boolean bool = this.lCS.biq();
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
  
  public final byte[] bir()
  {
    AppMethodBeat.i(132370);
    try
    {
      byte[] arrayOfByte = this.lCS.bir();
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
  
  public final String bis()
  {
    AppMethodBeat.i(132373);
    try
    {
      String str = this.lCS.bis();
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
  
  public final byte[] bit()
  {
    AppMethodBeat.i(132374);
    try
    {
      byte[] arrayOfByte = this.lCS.bit();
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
  
  public final void biu()
  {
    AppMethodBeat.i(132380);
    try
    {
      this.lCS.biu();
      AppMethodBeat.o(132380);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132380);
    }
  }
  
  public final void biv()
  {
    AppMethodBeat.i(132381);
    try
    {
      this.lCS.biv();
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
      int i = this.lCS.getUin();
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
      String str = this.lCS.getUsername();
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
      this.lCS.i(paramInt, paramArrayOfByte);
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
      this.lCS.i(paramString, paramArrayOfByte);
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
      boolean bool = this.lCS.isForeground();
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
  
  public final void reset()
  {
    AppMethodBeat.i(132366);
    try
    {
      this.lCS.reset();
      AppMethodBeat.o(132366);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { Util.stackTraceToString(localRemoteException) });
      AppMethodBeat.o(132366);
    }
  }
  
  public final byte[] sE(int paramInt)
  {
    AppMethodBeat.i(132360);
    try
    {
      byte[] arrayOfByte = this.lCS.sE(paramInt);
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
      this.lCS.setForeground(paramBoolean);
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
      this.lCS.setUin(paramInt);
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
      this.lCS.setUsername(paramString);
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
    str = str + "|-singlesession =" + Util.dumpHex(sE(1)) + "\n";
    str = str + "|-clientsession =" + Util.dumpHex(sE(2)) + "\n";
    str = str + "|-serversession =" + Util.dumpHex(sE(3)) + "\n";
    str = str + "|-ecdhkey =" + Util.dumpHex(bir()) + "\n";
    str = str + "`-cookie  =" + Util.dumpHex(bip());
    AppMethodBeat.o(132367);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.an.u
 * JD-Core Version:    0.7.0.1
 */