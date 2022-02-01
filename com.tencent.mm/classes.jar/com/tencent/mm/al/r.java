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
  private final d gVV;
  
  public r(d paramd)
  {
    this.gVV = paramd;
  }
  
  public final int Z(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132375);
    try
    {
      int i = this.gVV.Z(paramArrayOfByte);
      AppMethodBeat.o(132375);
      return i;
    }
    catch (Exception paramArrayOfByte)
    {
      ad.e("MicroMsg.RAccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[] { bt.m(paramArrayOfByte) });
      AppMethodBeat.o(132375);
    }
    return -6;
  }
  
  public final void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt)
  {
    AppMethodBeat.i(132365);
    try
    {
      this.gVV.a(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramInt);
      AppMethodBeat.o(132365);
      return;
    }
    catch (RemoteException paramArrayOfByte1)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.m(paramArrayOfByte1) });
      AppMethodBeat.o(132365);
    }
  }
  
  public final byte[] auZ()
  {
    AppMethodBeat.i(132359);
    try
    {
      byte[] arrayOfByte = this.gVV.auZ();
      AppMethodBeat.o(132359);
      return arrayOfByte;
    }
    catch (RemoteException localRemoteException)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.m(localRemoteException) });
      AppMethodBeat.o(132359);
    }
    return null;
  }
  
  public final boolean ava()
  {
    AppMethodBeat.i(132363);
    try
    {
      boolean bool = this.gVV.ava();
      AppMethodBeat.o(132363);
      return bool;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.m(localException) });
      AppMethodBeat.o(132363);
    }
    return false;
  }
  
  public final byte[] avb()
  {
    AppMethodBeat.i(132370);
    try
    {
      byte[] arrayOfByte = this.gVV.avb();
      AppMethodBeat.o(132370);
      return arrayOfByte;
    }
    catch (RemoteException localRemoteException)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.m(localRemoteException) });
      AppMethodBeat.o(132370);
    }
    return null;
  }
  
  public final String avc()
  {
    AppMethodBeat.i(132373);
    try
    {
      String str = this.gVV.avc();
      AppMethodBeat.o(132373);
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.m(localRemoteException) });
      AppMethodBeat.o(132373);
    }
    return null;
  }
  
  public final byte[] avd()
  {
    AppMethodBeat.i(132374);
    try
    {
      byte[] arrayOfByte = this.gVV.avd();
      AppMethodBeat.o(132374);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.RAccInfo", "AccInfoCacheInWorker getCacheBuffer exception:%s", new Object[] { bt.m(localException) });
      AppMethodBeat.o(132374);
    }
    return null;
  }
  
  public final void ave()
  {
    AppMethodBeat.i(132380);
    try
    {
      this.gVV.ave();
      AppMethodBeat.o(132380);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.m(localException) });
      AppMethodBeat.o(132380);
    }
  }
  
  public final void avf()
  {
    AppMethodBeat.i(132381);
    try
    {
      this.gVV.avf();
      AppMethodBeat.o(132381);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.m(localException) });
      AppMethodBeat.o(132381);
    }
  }
  
  public final void b(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(132378);
    try
    {
      this.gVV.b(paramInt, paramArrayOfByte1, paramArrayOfByte2);
      AppMethodBeat.o(132378);
      return;
    }
    catch (Exception paramArrayOfByte1)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.m(paramArrayOfByte1) });
      AppMethodBeat.o(132378);
    }
  }
  
  public final void eh(boolean paramBoolean)
  {
    AppMethodBeat.i(132371);
    try
    {
      this.gVV.eh(paramBoolean);
      AppMethodBeat.o(132371);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.m(localRemoteException) });
      AppMethodBeat.o(132371);
    }
  }
  
  public final int getUin()
  {
    AppMethodBeat.i(132361);
    try
    {
      int i = this.gVV.getUin();
      AppMethodBeat.o(132361);
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.m(localRemoteException) });
      AppMethodBeat.o(132361);
    }
    return 0;
  }
  
  public final String getUsername()
  {
    AppMethodBeat.i(132362);
    try
    {
      String str = this.gVV.getUsername();
      AppMethodBeat.o(132362);
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.m(localRemoteException) });
      AppMethodBeat.o(132362);
    }
    return null;
  }
  
  public final void h(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132377);
    try
    {
      this.gVV.h(paramInt, paramArrayOfByte);
      AppMethodBeat.o(132377);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.m(paramArrayOfByte) });
      AppMethodBeat.o(132377);
    }
  }
  
  public final void i(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132368);
    try
    {
      this.gVV.i(paramString, paramArrayOfByte);
      AppMethodBeat.o(132368);
      return;
    }
    catch (RemoteException paramString)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.m(paramString) });
      AppMethodBeat.o(132368);
    }
  }
  
  public final boolean isForeground()
  {
    AppMethodBeat.i(132372);
    try
    {
      boolean bool = this.gVV.isForeground();
      AppMethodBeat.o(132372);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.m(localRemoteException) });
      AppMethodBeat.o(132372);
    }
    return true;
  }
  
  public final byte[] mq(int paramInt)
  {
    AppMethodBeat.i(132360);
    try
    {
      byte[] arrayOfByte = this.gVV.mq(paramInt);
      AppMethodBeat.o(132360);
      return arrayOfByte;
    }
    catch (RemoteException localRemoteException)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.m(localRemoteException) });
      AppMethodBeat.o(132360);
    }
    return null;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(132366);
    try
    {
      this.gVV.reset();
      AppMethodBeat.o(132366);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.m(localRemoteException) });
      AppMethodBeat.o(132366);
    }
  }
  
  public final void setUin(int paramInt)
  {
    AppMethodBeat.i(132376);
    try
    {
      this.gVV.setUin(paramInt);
      AppMethodBeat.o(132376);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.m(localException) });
      AppMethodBeat.o(132376);
    }
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(132364);
    try
    {
      this.gVV.setUsername(paramString);
      AppMethodBeat.o(132364);
      return;
    }
    catch (RemoteException paramString)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.m(paramString) });
      AppMethodBeat.o(132364);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(132367);
    String str = "RAccInfo:\n" + "|-uin     =" + getUin() + "\n";
    str = str + "|-user    =" + getUsername() + "\n";
    str = str + "|-singlesession =" + bt.cv(mq(1)) + "\n";
    str = str + "|-clientsession =" + bt.cv(mq(2)) + "\n";
    str = str + "|-serversession =" + bt.cv(mq(3)) + "\n";
    str = str + "|-ecdhkey =" + bt.cv(avb()) + "\n";
    str = str + "`-cookie  =" + bt.cv(auZ());
    AppMethodBeat.o(132367);
    return str;
  }
  
  public final byte[] wh(String paramString)
  {
    AppMethodBeat.i(132369);
    try
    {
      paramString = this.gVV.wh(paramString);
      AppMethodBeat.o(132369);
      return paramString;
    }
    catch (RemoteException paramString)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.m(paramString) });
      AppMethodBeat.o(132369);
    }
    return null;
  }
  
  public final byte[] wi(String paramString)
  {
    AppMethodBeat.i(132379);
    try
    {
      paramString = this.gVV.wi(paramString);
      AppMethodBeat.o(132379);
      return paramString;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.m(paramString) });
      AppMethodBeat.o(132379);
    }
    return null;
  }
  
  public final byte[] wj(String paramString)
  {
    AppMethodBeat.i(132382);
    try
    {
      paramString = this.gVV.wj(paramString);
      AppMethodBeat.o(132382);
      return paramString;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.m(paramString) });
      AppMethodBeat.o(132382);
    }
    return null;
  }
  
  public final byte[] wk(String paramString)
  {
    AppMethodBeat.i(132383);
    try
    {
      paramString = this.gVV.wk(paramString);
      AppMethodBeat.o(132383);
      return paramString;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.m(paramString) });
      AppMethodBeat.o(132383);
    }
    return null;
  }
  
  public final boolean wl(String paramString)
  {
    AppMethodBeat.i(132384);
    try
    {
      boolean bool = this.gVV.wl(paramString);
      AppMethodBeat.o(132384);
      return bool;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bt.m(paramString) });
      AppMethodBeat.o(132384);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.al.r
 * JD-Core Version:    0.7.0.1
 */