package com.tencent.mm.network;

import android.os.RemoteCallbackList;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class ac
  extends i.a
{
  private int eOZ = 4;
  private long ePa;
  private int ePb = 0;
  private final RemoteCallbackList<n> ePc = new RemoteCallbackList();
  private am ebj = new am(new ac.1(this), false);
  
  public final int TV()
  {
    if (0L > bk.cn(this.ePa)) {}
    for (int i = 5;; i = this.eOZ)
    {
      y.i("MicroMsg.NetworkEvent", "getNowStatus = %d", new Object[] { Integer.valueOf(i) });
      return i;
    }
  }
  
  public final void TW()
  {
    this.ePc.kill();
  }
  
  public final long TX()
  {
    return this.ePa;
  }
  
  public final boolean c(n paramn)
  {
    try
    {
      this.ePc.register(paramn);
      return true;
    }
    catch (Exception paramn)
    {
      y.e("MicroMsg.NetworkEvent", "addListener %s", new Object[] { paramn });
      y.e("MicroMsg.NetworkEvent", "exception:%s", new Object[] { bk.j(paramn) });
    }
    return true;
  }
  
  public final boolean d(n paramn)
  {
    try
    {
      boolean bool = this.ePc.unregister(paramn);
      return bool;
    }
    catch (Exception paramn)
    {
      y.e("MicroMsg.NetworkEvent", "removeListener %s", new Object[] { paramn });
      y.e("MicroMsg.NetworkEvent", "exception:%s", new Object[] { bk.j(paramn) });
    }
    return false;
  }
  
  public final void jG(int paramInt)
  {
    int j = 0;
    y.i("MicroMsg.NetworkEvent", "networkChange : %d", new Object[] { Integer.valueOf(paramInt) });
    int i;
    if (paramInt == this.eOZ)
    {
      i = j;
      if (i != 0) {
        break label141;
      }
    }
    label131:
    label141:
    while ((paramInt != 0) && (paramInt != 4) && (paramInt != 6))
    {
      return;
      if (3 == paramInt)
      {
        i = j;
        if (this.eOZ != 2) {
          break;
        }
        this.eOZ = paramInt;
        i = 1;
        break;
      }
      if (2 == paramInt)
      {
        i = j;
        if (this.eOZ == 0) {
          break;
        }
        i = j;
        if (this.eOZ == 1) {
          break;
        }
        this.ePb += 1;
        if (this.ePb <= 0) {
          break label131;
        }
        this.eOZ = 2;
        i = 1;
        break;
      }
      if (4 == paramInt)
      {
        this.ePb = 0;
        this.eOZ = 4;
        i = 1;
        break;
      }
      this.eOZ = paramInt;
      i = 1;
      break;
    }
    this.ebj.S(1000L, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.network.ac
 * JD-Core Version:    0.7.0.1
 */