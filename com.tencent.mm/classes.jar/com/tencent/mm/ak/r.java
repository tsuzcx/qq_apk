package com.tencent.mm.ak;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.c;
import com.tencent.mm.network.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class r
  implements c
{
  private final d hRC;
  
  public r(d paramd)
  {
    this.hRC = paramd;
  }
  
  public final byte[] DO(String paramString)
  {
    AppMethodBeat.i(132369);
    try
    {
      paramString = this.hRC.DO(paramString);
      AppMethodBeat.o(132369);
      return paramString;
    }
    catch (RemoteException paramString)
    {
      ae.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bu.o(paramString) });
      AppMethodBeat.o(132369);
    }
    return null;
  }
  
  public final byte[] DP(String paramString)
  {
    AppMethodBeat.i(132379);
    try
    {
      paramString = this.hRC.DP(paramString);
      AppMethodBeat.o(132379);
      return paramString;
    }
    catch (Exception paramString)
    {
      ae.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bu.o(paramString) });
      AppMethodBeat.o(132379);
    }
    return null;
  }
  
  public final byte[] DQ(String paramString)
  {
    AppMethodBeat.i(132382);
    try
    {
      paramString = this.hRC.DQ(paramString);
      AppMethodBeat.o(132382);
      return paramString;
    }
    catch (Exception paramString)
    {
      ae.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bu.o(paramString) });
      AppMethodBeat.o(132382);
    }
    return null;
  }
  
  public final byte[] DR(String paramString)
  {
    AppMethodBeat.i(132383);
    try
    {
      paramString = this.hRC.DR(paramString);
      AppMethodBeat.o(132383);
      return paramString;
    }
    catch (Exception paramString)
    {
      ae.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bu.o(paramString) });
      AppMethodBeat.o(132383);
    }
    return null;
  }
  
  public final boolean DS(String paramString)
  {
    AppMethodBeat.i(132384);
    try
    {
      boolean bool = this.hRC.DS(paramString);
      AppMethodBeat.o(132384);
      return bool;
    }
    catch (Exception paramString)
    {
      ae.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bu.o(paramString) });
      AppMethodBeat.o(132384);
    }
    return false;
  }
  
  public final int X(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132375);
    try
    {
      int i = this.hRC.X(paramArrayOfByte);
      AppMethodBeat.o(132375);
      return i;
    }
    catch (Exception paramArrayOfByte)
    {
      ae.e("MicroMsg.RAccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[] { bu.o(paramArrayOfByte) });
      AppMethodBeat.o(132375);
    }
    return -6;
  }
  
  public final void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt)
  {
    AppMethodBeat.i(132365);
    try
    {
      this.hRC.a(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramInt);
      AppMethodBeat.o(132365);
      return;
    }
    catch (RemoteException paramArrayOfByte1)
    {
      ae.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bu.o(paramArrayOfByte1) });
      AppMethodBeat.o(132365);
    }
  }
  
  public final byte[] aFl()
  {
    AppMethodBeat.i(132359);
    try
    {
      byte[] arrayOfByte = this.hRC.aFl();
      AppMethodBeat.o(132359);
      return arrayOfByte;
    }
    catch (RemoteException localRemoteException)
    {
      ae.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bu.o(localRemoteException) });
      AppMethodBeat.o(132359);
    }
    return null;
  }
  
  public final boolean aFm()
  {
    AppMethodBeat.i(132363);
    try
    {
      boolean bool = this.hRC.aFm();
      AppMethodBeat.o(132363);
      return bool;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bu.o(localException) });
      AppMethodBeat.o(132363);
    }
    return false;
  }
  
  public final byte[] aFn()
  {
    AppMethodBeat.i(132370);
    try
    {
      byte[] arrayOfByte = this.hRC.aFn();
      AppMethodBeat.o(132370);
      return arrayOfByte;
    }
    catch (RemoteException localRemoteException)
    {
      ae.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bu.o(localRemoteException) });
      AppMethodBeat.o(132370);
    }
    return null;
  }
  
  public final String aFo()
  {
    AppMethodBeat.i(132373);
    try
    {
      String str = this.hRC.aFo();
      AppMethodBeat.o(132373);
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      ae.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bu.o(localRemoteException) });
      AppMethodBeat.o(132373);
    }
    return null;
  }
  
  public final byte[] aFp()
  {
    AppMethodBeat.i(132374);
    try
    {
      byte[] arrayOfByte = this.hRC.aFp();
      AppMethodBeat.o(132374);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.RAccInfo", "AccInfoCacheInWorker getCacheBuffer exception:%s", new Object[] { bu.o(localException) });
      AppMethodBeat.o(132374);
    }
    return null;
  }
  
  public final void aFq()
  {
    AppMethodBeat.i(132380);
    try
    {
      this.hRC.aFq();
      AppMethodBeat.o(132380);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bu.o(localException) });
      AppMethodBeat.o(132380);
    }
  }
  
  public final void aFr()
  {
    AppMethodBeat.i(132381);
    try
    {
      this.hRC.aFr();
      AppMethodBeat.o(132381);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bu.o(localException) });
      AppMethodBeat.o(132381);
    }
  }
  
  public final void b(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(132378);
    try
    {
      this.hRC.b(paramInt, paramArrayOfByte1, paramArrayOfByte2);
      AppMethodBeat.o(132378);
      return;
    }
    catch (Exception paramArrayOfByte1)
    {
      ae.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bu.o(paramArrayOfByte1) });
      AppMethodBeat.o(132378);
    }
  }
  
  public final void eG(boolean paramBoolean)
  {
    AppMethodBeat.i(132371);
    try
    {
      this.hRC.eG(paramBoolean);
      AppMethodBeat.o(132371);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ae.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bu.o(localRemoteException) });
      AppMethodBeat.o(132371);
    }
  }
  
  public final int getUin()
  {
    AppMethodBeat.i(132361);
    try
    {
      int i = this.hRC.getUin();
      AppMethodBeat.o(132361);
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      ae.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bu.o(localRemoteException) });
      AppMethodBeat.o(132361);
    }
    return 0;
  }
  
  public final String getUsername()
  {
    AppMethodBeat.i(132362);
    try
    {
      String str = this.hRC.getUsername();
      AppMethodBeat.o(132362);
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      ae.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bu.o(localRemoteException) });
      AppMethodBeat.o(132362);
    }
    return null;
  }
  
  public final void h(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132377);
    try
    {
      this.hRC.h(paramInt, paramArrayOfByte);
      AppMethodBeat.o(132377);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ae.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bu.o(paramArrayOfByte) });
      AppMethodBeat.o(132377);
    }
  }
  
  public final void i(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132368);
    try
    {
      this.hRC.i(paramString, paramArrayOfByte);
      AppMethodBeat.o(132368);
      return;
    }
    catch (RemoteException paramString)
    {
      ae.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bu.o(paramString) });
      AppMethodBeat.o(132368);
    }
  }
  
  public final boolean isForeground()
  {
    AppMethodBeat.i(132372);
    try
    {
      boolean bool = this.hRC.isForeground();
      AppMethodBeat.o(132372);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      ae.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bu.o(localRemoteException) });
      AppMethodBeat.o(132372);
    }
    return true;
  }
  
  public final byte[] mR(int paramInt)
  {
    AppMethodBeat.i(132360);
    try
    {
      byte[] arrayOfByte = this.hRC.mR(paramInt);
      AppMethodBeat.o(132360);
      return arrayOfByte;
    }
    catch (RemoteException localRemoteException)
    {
      ae.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bu.o(localRemoteException) });
      AppMethodBeat.o(132360);
    }
    return null;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(132366);
    try
    {
      this.hRC.reset();
      AppMethodBeat.o(132366);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ae.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bu.o(localRemoteException) });
      AppMethodBeat.o(132366);
    }
  }
  
  public final void setUin(int paramInt)
  {
    AppMethodBeat.i(132376);
    try
    {
      this.hRC.setUin(paramInt);
      AppMethodBeat.o(132376);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bu.o(localException) });
      AppMethodBeat.o(132376);
    }
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(132364);
    try
    {
      this.hRC.setUsername(paramString);
      AppMethodBeat.o(132364);
      return;
    }
    catch (RemoteException paramString)
    {
      ae.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bu.o(paramString) });
      AppMethodBeat.o(132364);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(132367);
    String str = "RAccInfo:\n" + "|-uin     =" + getUin() + "\n";
    str = str + "|-user    =" + getUsername() + "\n";
    str = str + "|-singlesession =" + bu.cE(mR(1)) + "\n";
    str = str + "|-clientsession =" + bu.cE(mR(2)) + "\n";
    str = str + "|-serversession =" + bu.cE(mR(3)) + "\n";
    str = str + "|-ecdhkey =" + bu.cE(aFn()) + "\n";
    str = str + "`-cookie  =" + bu.cE(aFl());
    AppMethodBeat.o(132367);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ak.r
 * JD-Core Version:    0.7.0.1
 */