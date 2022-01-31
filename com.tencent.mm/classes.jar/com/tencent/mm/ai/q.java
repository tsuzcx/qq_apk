package com.tencent.mm.ai;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.c;
import com.tencent.mm.network.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class q
  implements c
{
  private final d ftQ;
  
  public q(d paramd)
  {
    this.ftQ = paramd;
  }
  
  public final int R(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(58226);
    try
    {
      int i = this.ftQ.R(paramArrayOfByte);
      AppMethodBeat.o(58226);
      return i;
    }
    catch (Exception paramArrayOfByte)
    {
      ab.e("MicroMsg.RAccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[] { bo.l(paramArrayOfByte) });
      AppMethodBeat.o(58226);
    }
    return -6;
  }
  
  public final void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt)
  {
    AppMethodBeat.i(58217);
    try
    {
      this.ftQ.a(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramInt);
      AppMethodBeat.o(58217);
      return;
    }
    catch (RemoteException paramArrayOfByte1)
    {
      ab.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bo.l(paramArrayOfByte1) });
      AppMethodBeat.o(58217);
    }
  }
  
  public final byte[] adB()
  {
    AppMethodBeat.i(58211);
    try
    {
      byte[] arrayOfByte = this.ftQ.adB();
      AppMethodBeat.o(58211);
      return arrayOfByte;
    }
    catch (RemoteException localRemoteException)
    {
      ab.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bo.l(localRemoteException) });
      AppMethodBeat.o(58211);
    }
    return null;
  }
  
  public final boolean adC()
  {
    AppMethodBeat.i(58215);
    try
    {
      boolean bool = this.ftQ.adC();
      AppMethodBeat.o(58215);
      return bool;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bo.l(localException) });
      AppMethodBeat.o(58215);
    }
    return false;
  }
  
  public final byte[] adD()
  {
    AppMethodBeat.i(58222);
    try
    {
      byte[] arrayOfByte = this.ftQ.adD();
      AppMethodBeat.o(58222);
      return arrayOfByte;
    }
    catch (RemoteException localRemoteException)
    {
      ab.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bo.l(localRemoteException) });
      AppMethodBeat.o(58222);
    }
    return null;
  }
  
  public final String adE()
  {
    AppMethodBeat.i(146121);
    try
    {
      String str = this.ftQ.adE();
      AppMethodBeat.o(146121);
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      ab.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bo.l(localRemoteException) });
      AppMethodBeat.o(146121);
    }
    return null;
  }
  
  public final byte[] adF()
  {
    AppMethodBeat.i(58225);
    try
    {
      byte[] arrayOfByte = this.ftQ.adF();
      AppMethodBeat.o(58225);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.RAccInfo", "AccInfoCacheInWorker getCacheBuffer exception:%s", new Object[] { bo.l(localException) });
      AppMethodBeat.o(58225);
    }
    return null;
  }
  
  public final void adG()
  {
    AppMethodBeat.i(154724);
    try
    {
      this.ftQ.adG();
      AppMethodBeat.o(154724);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bo.l(localException) });
      AppMethodBeat.o(154724);
    }
  }
  
  public final void adH()
  {
    AppMethodBeat.i(154725);
    try
    {
      this.ftQ.adH();
      AppMethodBeat.o(154725);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bo.l(localException) });
      AppMethodBeat.o(154725);
    }
  }
  
  public final void b(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(154722);
    try
    {
      this.ftQ.b(paramInt, paramArrayOfByte1, paramArrayOfByte2);
      AppMethodBeat.o(154722);
      return;
    }
    catch (Exception paramArrayOfByte1)
    {
      ab.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bo.l(paramArrayOfByte1) });
      AppMethodBeat.o(154722);
    }
  }
  
  public final void cP(boolean paramBoolean)
  {
    AppMethodBeat.i(58223);
    try
    {
      this.ftQ.cP(paramBoolean);
      AppMethodBeat.o(58223);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ab.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bo.l(localRemoteException) });
      AppMethodBeat.o(58223);
    }
  }
  
  public final void g(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(154721);
    try
    {
      this.ftQ.g(paramInt, paramArrayOfByte);
      AppMethodBeat.o(154721);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ab.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bo.l(paramArrayOfByte) });
      AppMethodBeat.o(154721);
    }
  }
  
  public final int getUin()
  {
    AppMethodBeat.i(58213);
    try
    {
      int i = this.ftQ.getUin();
      AppMethodBeat.o(58213);
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      ab.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bo.l(localRemoteException) });
      AppMethodBeat.o(58213);
    }
    return 0;
  }
  
  public final String getUsername()
  {
    AppMethodBeat.i(58214);
    try
    {
      String str = this.ftQ.getUsername();
      AppMethodBeat.o(58214);
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      ab.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bo.l(localRemoteException) });
      AppMethodBeat.o(58214);
    }
    return null;
  }
  
  public final boolean isForeground()
  {
    AppMethodBeat.i(58224);
    try
    {
      boolean bool = this.ftQ.isForeground();
      AppMethodBeat.o(58224);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      ab.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bo.l(localRemoteException) });
      AppMethodBeat.o(58224);
    }
    return true;
  }
  
  public final byte[] jN(int paramInt)
  {
    AppMethodBeat.i(58212);
    try
    {
      byte[] arrayOfByte = this.ftQ.jN(paramInt);
      AppMethodBeat.o(58212);
      return arrayOfByte;
    }
    catch (RemoteException localRemoteException)
    {
      ab.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bo.l(localRemoteException) });
      AppMethodBeat.o(58212);
    }
    return null;
  }
  
  public final void o(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(58220);
    try
    {
      this.ftQ.o(paramString, paramArrayOfByte);
      AppMethodBeat.o(58220);
      return;
    }
    catch (RemoteException paramString)
    {
      ab.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bo.l(paramString) });
      AppMethodBeat.o(58220);
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(58218);
    try
    {
      this.ftQ.reset();
      AppMethodBeat.o(58218);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ab.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bo.l(localRemoteException) });
      AppMethodBeat.o(58218);
    }
  }
  
  public final byte[] rm(String paramString)
  {
    AppMethodBeat.i(58221);
    try
    {
      paramString = this.ftQ.rm(paramString);
      AppMethodBeat.o(58221);
      return paramString;
    }
    catch (RemoteException paramString)
    {
      ab.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bo.l(paramString) });
      AppMethodBeat.o(58221);
    }
    return null;
  }
  
  public final byte[] rn(String paramString)
  {
    AppMethodBeat.i(154723);
    try
    {
      paramString = this.ftQ.rn(paramString);
      AppMethodBeat.o(154723);
      return paramString;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bo.l(paramString) });
      AppMethodBeat.o(154723);
    }
    return null;
  }
  
  public final byte[] ro(String paramString)
  {
    AppMethodBeat.i(154726);
    try
    {
      paramString = this.ftQ.ro(paramString);
      AppMethodBeat.o(154726);
      return paramString;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bo.l(paramString) });
      AppMethodBeat.o(154726);
    }
    return null;
  }
  
  public final byte[] rp(String paramString)
  {
    AppMethodBeat.i(154727);
    try
    {
      paramString = this.ftQ.rp(paramString);
      AppMethodBeat.o(154727);
      return paramString;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bo.l(paramString) });
      AppMethodBeat.o(154727);
    }
    return null;
  }
  
  public final boolean rq(String paramString)
  {
    AppMethodBeat.i(154728);
    try
    {
      boolean bool = this.ftQ.rq(paramString);
      AppMethodBeat.o(154728);
      return bool;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bo.l(paramString) });
      AppMethodBeat.o(154728);
    }
    return false;
  }
  
  public final void setUin(int paramInt)
  {
    AppMethodBeat.i(58227);
    try
    {
      this.ftQ.setUin(paramInt);
      AppMethodBeat.o(58227);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bo.l(localException) });
      AppMethodBeat.o(58227);
    }
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(58216);
    try
    {
      this.ftQ.setUsername(paramString);
      AppMethodBeat.o(58216);
      return;
    }
    catch (RemoteException paramString)
    {
      ab.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bo.l(paramString) });
      AppMethodBeat.o(58216);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(58219);
    String str = "RAccInfo:\n" + "|-uin     =" + getUin() + "\n";
    str = str + "|-user    =" + getUsername() + "\n";
    str = str + "|-singlesession =" + bo.cd(jN(1)) + "\n";
    str = str + "|-clientsession =" + bo.cd(jN(2)) + "\n";
    str = str + "|-serversession =" + bo.cd(jN(3)) + "\n";
    str = str + "|-ecdhkey =" + bo.cd(adD()) + "\n";
    str = str + "`-cookie  =" + bo.cd(adB());
    AppMethodBeat.o(58219);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ai.q
 * JD-Core Version:    0.7.0.1
 */