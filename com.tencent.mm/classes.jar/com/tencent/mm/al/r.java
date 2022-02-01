package com.tencent.mm.al;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.c;
import com.tencent.mm.network.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class r
  implements c
{
  private final d hOJ;
  
  public r(d paramd)
  {
    this.hOJ = paramd;
  }
  
  public final byte[] Dm(String paramString)
  {
    AppMethodBeat.i(132369);
    try
    {
      paramString = this.hOJ.Dm(paramString);
      AppMethodBeat.o(132369);
      return paramString;
    }
    catch (RemoteException paramString)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.n(paramString) });
      AppMethodBeat.o(132369);
    }
    return null;
  }
  
  public final byte[] Dn(String paramString)
  {
    AppMethodBeat.i(132379);
    try
    {
      paramString = this.hOJ.Dn(paramString);
      AppMethodBeat.o(132379);
      return paramString;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.n(paramString) });
      AppMethodBeat.o(132379);
    }
    return null;
  }
  
  public final byte[] Do(String paramString)
  {
    AppMethodBeat.i(132382);
    try
    {
      paramString = this.hOJ.Do(paramString);
      AppMethodBeat.o(132382);
      return paramString;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.n(paramString) });
      AppMethodBeat.o(132382);
    }
    return null;
  }
  
  public final byte[] Dp(String paramString)
  {
    AppMethodBeat.i(132383);
    try
    {
      paramString = this.hOJ.Dp(paramString);
      AppMethodBeat.o(132383);
      return paramString;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.n(paramString) });
      AppMethodBeat.o(132383);
    }
    return null;
  }
  
  public final boolean Dq(String paramString)
  {
    AppMethodBeat.i(132384);
    try
    {
      boolean bool = this.hOJ.Dq(paramString);
      AppMethodBeat.o(132384);
      return bool;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.n(paramString) });
      AppMethodBeat.o(132384);
    }
    return false;
  }
  
  public final int X(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132375);
    try
    {
      int i = this.hOJ.X(paramArrayOfByte);
      AppMethodBeat.o(132375);
      return i;
    }
    catch (Exception paramArrayOfByte)
    {
      ad.e("MicroMsg.RAccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[] { bt.n(paramArrayOfByte) });
      AppMethodBeat.o(132375);
    }
    return -6;
  }
  
  public final void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt)
  {
    AppMethodBeat.i(132365);
    try
    {
      this.hOJ.a(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramInt);
      AppMethodBeat.o(132365);
      return;
    }
    catch (RemoteException paramArrayOfByte1)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.n(paramArrayOfByte1) });
      AppMethodBeat.o(132365);
    }
  }
  
  public final byte[] aEV()
  {
    AppMethodBeat.i(132359);
    try
    {
      byte[] arrayOfByte = this.hOJ.aEV();
      AppMethodBeat.o(132359);
      return arrayOfByte;
    }
    catch (RemoteException localRemoteException)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.n(localRemoteException) });
      AppMethodBeat.o(132359);
    }
    return null;
  }
  
  public final boolean aEW()
  {
    AppMethodBeat.i(132363);
    try
    {
      boolean bool = this.hOJ.aEW();
      AppMethodBeat.o(132363);
      return bool;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.n(localException) });
      AppMethodBeat.o(132363);
    }
    return false;
  }
  
  public final byte[] aEX()
  {
    AppMethodBeat.i(132370);
    try
    {
      byte[] arrayOfByte = this.hOJ.aEX();
      AppMethodBeat.o(132370);
      return arrayOfByte;
    }
    catch (RemoteException localRemoteException)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.n(localRemoteException) });
      AppMethodBeat.o(132370);
    }
    return null;
  }
  
  public final String aEY()
  {
    AppMethodBeat.i(132373);
    try
    {
      String str = this.hOJ.aEY();
      AppMethodBeat.o(132373);
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.n(localRemoteException) });
      AppMethodBeat.o(132373);
    }
    return null;
  }
  
  public final byte[] aEZ()
  {
    AppMethodBeat.i(132374);
    try
    {
      byte[] arrayOfByte = this.hOJ.aEZ();
      AppMethodBeat.o(132374);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.RAccInfo", "AccInfoCacheInWorker getCacheBuffer exception:%s", new Object[] { bt.n(localException) });
      AppMethodBeat.o(132374);
    }
    return null;
  }
  
  public final void aFa()
  {
    AppMethodBeat.i(132380);
    try
    {
      this.hOJ.aFa();
      AppMethodBeat.o(132380);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.n(localException) });
      AppMethodBeat.o(132380);
    }
  }
  
  public final void aFb()
  {
    AppMethodBeat.i(132381);
    try
    {
      this.hOJ.aFb();
      AppMethodBeat.o(132381);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.n(localException) });
      AppMethodBeat.o(132381);
    }
  }
  
  public final void b(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(132378);
    try
    {
      this.hOJ.b(paramInt, paramArrayOfByte1, paramArrayOfByte2);
      AppMethodBeat.o(132378);
      return;
    }
    catch (Exception paramArrayOfByte1)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.n(paramArrayOfByte1) });
      AppMethodBeat.o(132378);
    }
  }
  
  public final void eE(boolean paramBoolean)
  {
    AppMethodBeat.i(132371);
    try
    {
      this.hOJ.eE(paramBoolean);
      AppMethodBeat.o(132371);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.n(localRemoteException) });
      AppMethodBeat.o(132371);
    }
  }
  
  public final int getUin()
  {
    AppMethodBeat.i(132361);
    try
    {
      int i = this.hOJ.getUin();
      AppMethodBeat.o(132361);
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.n(localRemoteException) });
      AppMethodBeat.o(132361);
    }
    return 0;
  }
  
  public final String getUsername()
  {
    AppMethodBeat.i(132362);
    try
    {
      String str = this.hOJ.getUsername();
      AppMethodBeat.o(132362);
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.n(localRemoteException) });
      AppMethodBeat.o(132362);
    }
    return null;
  }
  
  public final void h(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132377);
    try
    {
      this.hOJ.h(paramInt, paramArrayOfByte);
      AppMethodBeat.o(132377);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.n(paramArrayOfByte) });
      AppMethodBeat.o(132377);
    }
  }
  
  public final void i(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132368);
    try
    {
      this.hOJ.i(paramString, paramArrayOfByte);
      AppMethodBeat.o(132368);
      return;
    }
    catch (RemoteException paramString)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.n(paramString) });
      AppMethodBeat.o(132368);
    }
  }
  
  public final boolean isForeground()
  {
    AppMethodBeat.i(132372);
    try
    {
      boolean bool = this.hOJ.isForeground();
      AppMethodBeat.o(132372);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.n(localRemoteException) });
      AppMethodBeat.o(132372);
    }
    return true;
  }
  
  public final byte[] mO(int paramInt)
  {
    AppMethodBeat.i(132360);
    try
    {
      byte[] arrayOfByte = this.hOJ.mO(paramInt);
      AppMethodBeat.o(132360);
      return arrayOfByte;
    }
    catch (RemoteException localRemoteException)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.n(localRemoteException) });
      AppMethodBeat.o(132360);
    }
    return null;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(132366);
    try
    {
      this.hOJ.reset();
      AppMethodBeat.o(132366);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.n(localRemoteException) });
      AppMethodBeat.o(132366);
    }
  }
  
  public final void setUin(int paramInt)
  {
    AppMethodBeat.i(132376);
    try
    {
      this.hOJ.setUin(paramInt);
      AppMethodBeat.o(132376);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.n(localException) });
      AppMethodBeat.o(132376);
    }
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(132364);
    try
    {
      this.hOJ.setUsername(paramString);
      AppMethodBeat.o(132364);
      return;
    }
    catch (RemoteException paramString)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.n(paramString) });
      AppMethodBeat.o(132364);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(132367);
    String str = "RAccInfo:\n" + "|-uin     =" + getUin() + "\n";
    str = str + "|-user    =" + getUsername() + "\n";
    str = str + "|-singlesession =" + bt.cB(mO(1)) + "\n";
    str = str + "|-clientsession =" + bt.cB(mO(2)) + "\n";
    str = str + "|-serversession =" + bt.cB(mO(3)) + "\n";
    str = str + "|-ecdhkey =" + bt.cB(aEX()) + "\n";
    str = str + "`-cookie  =" + bt.cB(aEV());
    AppMethodBeat.o(132367);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.al.r
 * JD-Core Version:    0.7.0.1
 */