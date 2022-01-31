package com.a.a;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ServiceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private c blA;
  private b blB;
  a.a blC;
  private int blD;
  a.b blE;
  int blF;
  private IBinder.DeathRecipient blG;
  
  private a(c paramc, Looper paramLooper)
  {
    AppMethodBeat.i(118219);
    this.blF = -1;
    this.blG = new a.1(this);
    this.blA = paramc;
    paramLooper = new a.a(this, paramLooper);
    this.blD = 1;
    this.blB = new a.2(this);
    if (!this.blA.a(this.blB, 1))
    {
      paramc = new RuntimeException();
      AppMethodBeat.o(118219);
      throw paramc;
    }
    this.blC = paramLooper;
    paramc.asBinder().linkToDeath(this.blG, 0);
    AppMethodBeat.o(118219);
  }
  
  public static a sV()
  {
    AppMethodBeat.i(118218);
    Object localObject = sY();
    if (localObject == null)
    {
      AppMethodBeat.o(118218);
      return null;
    }
    Looper localLooper = Looper.getMainLooper();
    try
    {
      localObject = new a((c)localObject, localLooper);
      AppMethodBeat.o(118218);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(118218);
    }
    return null;
  }
  
  public static int[] sX()
  {
    AppMethodBeat.i(118224);
    Object localObject = sY();
    if (localObject == null)
    {
      AppMethodBeat.o(118224);
      return new int[0];
    }
    try
    {
      localObject = ((c)localObject).ta();
      AppMethodBeat.o(118224);
      return localObject;
    }
    catch (RemoteException localRemoteException)
    {
      AppMethodBeat.o(118224);
    }
    return new int[0];
  }
  
  private static c sY()
  {
    AppMethodBeat.i(118225);
    c localc = c.a.i(ServiceManager.getService("authentication_service"));
    AppMethodBeat.o(118225);
    return localc;
  }
  
  public final int a(a.b paramb, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(118222);
    if ((paramArrayOfInt == null) || (paramb == null))
    {
      AppMethodBeat.o(118222);
      return -1;
    }
    this.blE = paramb;
    this.blF = 0;
    try
    {
      int i = this.blA.a(this.blB, paramArrayOfInt, null);
      AppMethodBeat.o(118222);
      return i;
    }
    catch (RemoteException paramb)
    {
      AppMethodBeat.o(118222);
    }
    return -1;
  }
  
  public final void abort()
  {
    AppMethodBeat.i(118223);
    if (this.blC != null) {
      this.blC.removeMessages(8);
    }
    try
    {
      this.blA.a(this.blB);
      AppMethodBeat.o(118223);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      AppMethodBeat.o(118223);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(118220);
    if (this.blC != null) {
      this.blC.removeMessages(8);
    }
    try
    {
      this.blA.b(this.blB);
      this.blA.asBinder().unlinkToDeath(this.blG, 0);
      AppMethodBeat.o(118220);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      AppMethodBeat.o(118220);
    }
  }
  
  public final int[] sW()
  {
    AppMethodBeat.i(118221);
    try
    {
      int[] arrayOfInt = this.blA.c(this.blB);
      AppMethodBeat.o(118221);
      return arrayOfInt;
    }
    catch (RemoteException localRemoteException)
    {
      AppMethodBeat.o(118221);
    }
    return new int[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.a.a.a
 * JD-Core Version:    0.7.0.1
 */