package com.tencent.mm.ah;

import android.os.RemoteException;
import com.tencent.mm.network.c;
import com.tencent.mm.network.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class q
  implements c
{
  private final d edN;
  
  public q(d paramd)
  {
    this.edN = paramd;
  }
  
  private String getUsername()
  {
    try
    {
      String str = this.edN.getUsername();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      y.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bk.j(localRemoteException) });
    }
    return null;
  }
  
  public final int C(byte[] paramArrayOfByte)
  {
    try
    {
      int i = this.edN.C(paramArrayOfByte);
      return i;
    }
    catch (Exception paramArrayOfByte)
    {
      y.e("MicroMsg.RAccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[] { bk.j(paramArrayOfByte) });
    }
    return -6;
  }
  
  public final int CK()
  {
    try
    {
      int i = this.edN.CK();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      y.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bk.j(localRemoteException) });
    }
    return 0;
  }
  
  public final byte[] Dj()
  {
    try
    {
      byte[] arrayOfByte = this.edN.Dj();
      return arrayOfByte;
    }
    catch (RemoteException localRemoteException)
    {
      y.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bk.j(localRemoteException) });
    }
    return null;
  }
  
  public final byte[] KM()
  {
    try
    {
      byte[] arrayOfByte = this.edN.KM();
      return arrayOfByte;
    }
    catch (RemoteException localRemoteException)
    {
      y.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bk.j(localRemoteException) });
    }
    return null;
  }
  
  public final boolean KN()
  {
    try
    {
      boolean bool = this.edN.KN();
      return bool;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bk.j(localException) });
    }
    return false;
  }
  
  public final byte[] KO()
  {
    try
    {
      byte[] arrayOfByte = this.edN.KO();
      return arrayOfByte;
    }
    catch (RemoteException localRemoteException)
    {
      y.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bk.j(localRemoteException) });
    }
    return null;
  }
  
  public final boolean KP()
  {
    try
    {
      boolean bool = this.edN.KP();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      y.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bk.j(localRemoteException) });
    }
    return true;
  }
  
  public final byte[] KQ()
  {
    try
    {
      byte[] arrayOfByte = this.edN.KQ();
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.RAccInfo", "AccInfoCacheInWorker getCacheBuffer exception:%s", new Object[] { bk.j(localException) });
    }
    return null;
  }
  
  public final void bN(boolean paramBoolean)
  {
    try
    {
      this.edN.bN(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      y.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bk.j(localRemoteException) });
    }
  }
  
  public final void fn(int paramInt)
  {
    try
    {
      this.edN.fn(paramInt);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bk.j(localException) });
    }
  }
  
  public final void i(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      this.edN.i(paramString, paramArrayOfByte);
      return;
    }
    catch (RemoteException paramString)
    {
      y.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bk.j(paramString) });
    }
  }
  
  public final byte[] ks(String paramString)
  {
    try
    {
      paramString = this.edN.ks(paramString);
      return paramString;
    }
    catch (RemoteException paramString)
    {
      y.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bk.j(paramString) });
    }
    return null;
  }
  
  public final void reset()
  {
    try
    {
      this.edN.reset();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      y.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bk.j(localRemoteException) });
    }
  }
  
  public final void setUsername(String paramString)
  {
    try
    {
      this.edN.setUsername(paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      y.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bk.j(paramString) });
    }
  }
  
  public final String toString()
  {
    String str = "RAccInfo:\n" + "|-uin     =" + CK() + "\n";
    str = str + "|-user    =" + getUsername() + "\n";
    str = str + "|-session =" + Dj() + "\n";
    str = str + "|-ecdhkey =" + bk.bD(KO()) + "\n";
    return str + "`-cookie  =" + bk.bD(KM());
  }
  
  public final void w(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      this.edN.w(paramArrayOfByte, paramInt);
      return;
    }
    catch (RemoteException paramArrayOfByte)
    {
      y.e("MicroMsg.RAccInfo", "exception:%s", new Object[] { bk.j(paramArrayOfByte) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ah.q
 * JD-Core Version:    0.7.0.1
 */