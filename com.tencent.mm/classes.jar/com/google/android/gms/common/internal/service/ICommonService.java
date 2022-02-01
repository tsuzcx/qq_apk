package com.google.android.gms.common.internal.service;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface ICommonService
  extends IInterface
{
  public abstract void clearDefaultAccount(ICommonCallbacks paramICommonCallbacks);
  
  public static abstract class Stub
    extends zzb
    implements ICommonService
  {
    public Stub()
    {
      super();
    }
    
    public static ICommonService asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonService");
      if ((localIInterface instanceof ICommonService)) {
        return (ICommonService)localIInterface;
      }
      return new Proxy(paramIBinder);
    }
    
    public boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      if (paramInt1 == 1)
      {
        clearDefaultAccount(ICommonCallbacks.Stub.asInterface(paramParcel1.readStrongBinder()));
        return true;
      }
      return false;
    }
    
    public static class Proxy
      extends zza
      implements ICommonService
    {
      Proxy(IBinder paramIBinder)
      {
        super("com.google.android.gms.common.internal.service.ICommonService");
      }
      
      public void clearDefaultAccount(ICommonCallbacks paramICommonCallbacks)
      {
        AppMethodBeat.i(11890);
        Parcel localParcel = obtainAndWriteInterfaceToken();
        zzc.zza(localParcel, paramICommonCallbacks);
        transactOneway(1, localParcel);
        AppMethodBeat.o(11890);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.internal.service.ICommonService
 * JD-Core Version:    0.7.0.1
 */