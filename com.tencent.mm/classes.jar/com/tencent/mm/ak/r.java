package com.tencent.mm.ak;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.c;
import com.tencent.mm.network.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class r
  implements c
{
  private final d hwu;
  
  public r(d paramd)
  {
    this.hwu = paramd;
  }
  
  public final byte[] An(String paramString)
  {
    AppMethodBeat.i(132369);
    try
    {
      paramString = this.hwu.An(paramString);
      AppMethodBeat.o(132369);
      return paramString;
    }
    catch (RemoteException paramString)
    {
      ac.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bs.m(paramString) });
      AppMethodBeat.o(132369);
    }
    return null;
  }
  
  public final byte[] Ao(String paramString)
  {
    AppMethodBeat.i(132379);
    try
    {
      paramString = this.hwu.Ao(paramString);
      AppMethodBeat.o(132379);
      return paramString;
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bs.m(paramString) });
      AppMethodBeat.o(132379);
    }
    return null;
  }
  
  public final byte[] Ap(String paramString)
  {
    AppMethodBeat.i(132382);
    try
    {
      paramString = this.hwu.Ap(paramString);
      AppMethodBeat.o(132382);
      return paramString;
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bs.m(paramString) });
      AppMethodBeat.o(132382);
    }
    return null;
  }
  
  public final byte[] Aq(String paramString)
  {
    AppMethodBeat.i(132383);
    try
    {
      paramString = this.hwu.Aq(paramString);
      AppMethodBeat.o(132383);
      return paramString;
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bs.m(paramString) });
      AppMethodBeat.o(132383);
    }
    return null;
  }
  
  public final boolean Ar(String paramString)
  {
    AppMethodBeat.i(132384);
    try
    {
      boolean bool = this.hwu.Ar(paramString);
      AppMethodBeat.o(132384);
      return bool;
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bs.m(paramString) });
      AppMethodBeat.o(132384);
    }
    return false;
  }
  
  public final int Y(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132375);
    try
    {
      int i = this.hwu.Y(paramArrayOfByte);
      AppMethodBeat.o(132375);
      return i;
    }
    catch (Exception paramArrayOfByte)
    {
      ac.e("MicroMsg.RAccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[] { bs.m(paramArrayOfByte) });
      AppMethodBeat.o(132375);
    }
    return -6;
  }
  
  public final void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt)
  {
    AppMethodBeat.i(132365);
    try
    {
      this.hwu.a(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramInt);
      AppMethodBeat.o(132365);
      return;
    }
    catch (RemoteException paramArrayOfByte1)
    {
      ac.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bs.m(paramArrayOfByte1) });
      AppMethodBeat.o(132365);
    }
  }
  
  public final byte[] aBS()
  {
    AppMethodBeat.i(132359);
    try
    {
      byte[] arrayOfByte = this.hwu.aBS();
      AppMethodBeat.o(132359);
      return arrayOfByte;
    }
    catch (RemoteException localRemoteException)
    {
      ac.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bs.m(localRemoteException) });
      AppMethodBeat.o(132359);
    }
    return null;
  }
  
  public final boolean aBT()
  {
    AppMethodBeat.i(132363);
    try
    {
      boolean bool = this.hwu.aBT();
      AppMethodBeat.o(132363);
      return bool;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bs.m(localException) });
      AppMethodBeat.o(132363);
    }
    return false;
  }
  
  public final byte[] aBU()
  {
    AppMethodBeat.i(132370);
    try
    {
      byte[] arrayOfByte = this.hwu.aBU();
      AppMethodBeat.o(132370);
      return arrayOfByte;
    }
    catch (RemoteException localRemoteException)
    {
      ac.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bs.m(localRemoteException) });
      AppMethodBeat.o(132370);
    }
    return null;
  }
  
  public final String aBV()
  {
    AppMethodBeat.i(132373);
    try
    {
      String str = this.hwu.aBV();
      AppMethodBeat.o(132373);
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      ac.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bs.m(localRemoteException) });
      AppMethodBeat.o(132373);
    }
    return null;
  }
  
  public final byte[] aBW()
  {
    AppMethodBeat.i(132374);
    try
    {
      byte[] arrayOfByte = this.hwu.aBW();
      AppMethodBeat.o(132374);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.RAccInfo", "AccInfoCacheInWorker getCacheBuffer exception:%s", new Object[] { bs.m(localException) });
      AppMethodBeat.o(132374);
    }
    return null;
  }
  
  public final void aBX()
  {
    AppMethodBeat.i(132380);
    try
    {
      this.hwu.aBX();
      AppMethodBeat.o(132380);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bs.m(localException) });
      AppMethodBeat.o(132380);
    }
  }
  
  public final void aBY()
  {
    AppMethodBeat.i(132381);
    try
    {
      this.hwu.aBY();
      AppMethodBeat.o(132381);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bs.m(localException) });
      AppMethodBeat.o(132381);
    }
  }
  
  public final void b(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(132378);
    try
    {
      this.hwu.b(paramInt, paramArrayOfByte1, paramArrayOfByte2);
      AppMethodBeat.o(132378);
      return;
    }
    catch (Exception paramArrayOfByte1)
    {
      ac.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bs.m(paramArrayOfByte1) });
      AppMethodBeat.o(132378);
    }
  }
  
  public final void eC(boolean paramBoolean)
  {
    AppMethodBeat.i(132371);
    try
    {
      this.hwu.eC(paramBoolean);
      AppMethodBeat.o(132371);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ac.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bs.m(localRemoteException) });
      AppMethodBeat.o(132371);
    }
  }
  
  public final int getUin()
  {
    AppMethodBeat.i(132361);
    try
    {
      int i = this.hwu.getUin();
      AppMethodBeat.o(132361);
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      ac.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bs.m(localRemoteException) });
      AppMethodBeat.o(132361);
    }
    return 0;
  }
  
  public final String getUsername()
  {
    AppMethodBeat.i(132362);
    try
    {
      String str = this.hwu.getUsername();
      AppMethodBeat.o(132362);
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      ac.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bs.m(localRemoteException) });
      AppMethodBeat.o(132362);
    }
    return null;
  }
  
  public final void h(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132377);
    try
    {
      this.hwu.h(paramInt, paramArrayOfByte);
      AppMethodBeat.o(132377);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ac.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bs.m(paramArrayOfByte) });
      AppMethodBeat.o(132377);
    }
  }
  
  public final void i(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132368);
    try
    {
      this.hwu.i(paramString, paramArrayOfByte);
      AppMethodBeat.o(132368);
      return;
    }
    catch (RemoteException paramString)
    {
      ac.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bs.m(paramString) });
      AppMethodBeat.o(132368);
    }
  }
  
  public final boolean isForeground()
  {
    AppMethodBeat.i(132372);
    try
    {
      boolean bool = this.hwu.isForeground();
      AppMethodBeat.o(132372);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      ac.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bs.m(localRemoteException) });
      AppMethodBeat.o(132372);
    }
    return true;
  }
  
  public final byte[] mp(int paramInt)
  {
    AppMethodBeat.i(132360);
    try
    {
      byte[] arrayOfByte = this.hwu.mp(paramInt);
      AppMethodBeat.o(132360);
      return arrayOfByte;
    }
    catch (RemoteException localRemoteException)
    {
      ac.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bs.m(localRemoteException) });
      AppMethodBeat.o(132360);
    }
    return null;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(132366);
    try
    {
      this.hwu.reset();
      AppMethodBeat.o(132366);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ac.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bs.m(localRemoteException) });
      AppMethodBeat.o(132366);
    }
  }
  
  public final void setUin(int paramInt)
  {
    AppMethodBeat.i(132376);
    try
    {
      this.hwu.setUin(paramInt);
      AppMethodBeat.o(132376);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bs.m(localException) });
      AppMethodBeat.o(132376);
    }
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(132364);
    try
    {
      this.hwu.setUsername(paramString);
      AppMethodBeat.o(132364);
      return;
    }
    catch (RemoteException paramString)
    {
      ac.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bs.m(paramString) });
      AppMethodBeat.o(132364);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(132367);
    String str = "RAccInfo:\n" + "|-uin     =" + getUin() + "\n";
    str = str + "|-user    =" + getUsername() + "\n";
    str = str + "|-singlesession =" + bs.cu(mp(1)) + "\n";
    str = str + "|-clientsession =" + bs.cu(mp(2)) + "\n";
    str = str + "|-serversession =" + bs.cu(mp(3)) + "\n";
    str = str + "|-ecdhkey =" + bs.cu(aBU()) + "\n";
    str = str + "`-cookie  =" + bs.cu(aBS());
    AppMethodBeat.o(132367);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ak.r
 * JD-Core Version:    0.7.0.1
 */