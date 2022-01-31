package com.c.a;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ServiceManager;

public final class a
{
  public c aUQ;
  public b aUR;
  public a.a aUS;
  private int aUT;
  b aUU;
  int aUV = -1;
  public IBinder.DeathRecipient aUW = new a.1(this);
  
  private a(c paramc, Looper paramLooper)
  {
    this.aUQ = paramc;
    paramLooper = new a.a(this, paramLooper);
    this.aUT = 1;
    this.aUR = new a.2(this);
    if (!this.aUQ.a(this.aUR, 1)) {
      throw new RuntimeException();
    }
    this.aUS = paramLooper;
    paramc.asBinder().linkToDeath(this.aUW, 0);
  }
  
  public static a oR()
  {
    Object localObject = oU();
    if (localObject == null) {
      return null;
    }
    Looper localLooper = Looper.getMainLooper();
    try
    {
      localObject = new a((c)localObject, localLooper);
      return localObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static int[] oT()
  {
    Object localObject = oU();
    if (localObject == null) {
      return new int[0];
    }
    try
    {
      localObject = ((c)localObject).oV();
      return localObject;
    }
    catch (RemoteException localRemoteException) {}
    return new int[0];
  }
  
  private static c oU()
  {
    return c.a.h(ServiceManager.getService("authentication_service"));
  }
  
  public final int a(b paramb, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramb == null)) {
      return -1;
    }
    this.aUU = paramb;
    this.aUV = 0;
    try
    {
      int i = this.aUQ.a(this.aUR, paramArrayOfInt, null);
      return i;
    }
    catch (RemoteException paramb) {}
    return -1;
  }
  
  public final void abort()
  {
    if (this.aUS != null) {
      this.aUS.removeMessages(8);
    }
    try
    {
      this.aUQ.a(this.aUR);
      return;
    }
    catch (RemoteException localRemoteException) {}
  }
  
  public final int[] oS()
  {
    try
    {
      int[] arrayOfInt = this.aUQ.c(this.aUR);
      return arrayOfInt;
    }
    catch (RemoteException localRemoteException) {}
    return new int[0];
  }
  
  public static abstract interface b
  {
    public abstract void aR(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.c.a.a
 * JD-Core Version:    0.7.0.1
 */