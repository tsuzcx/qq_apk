package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface IStatusCallback
  extends IInterface
{
  public abstract void onResult(Status paramStatus);
  
  public static abstract class Stub
    extends zzb
    implements IStatusCallback
  {
    public Stub()
    {
      super();
    }
    
    public static IStatusCallback asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.api.internal.IStatusCallback");
      if ((localIInterface instanceof IStatusCallback)) {
        return (IStatusCallback)localIInterface;
      }
      return new zza(paramIBinder);
    }
    
    public boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      if (paramInt1 == 1)
      {
        onResult((Status)zzc.zza(paramParcel1, Status.CREATOR));
        return true;
      }
      return false;
    }
    
    public static final class zza
      extends zza
      implements IStatusCallback
    {
      zza(IBinder paramIBinder)
      {
        super("com.google.android.gms.common.api.internal.IStatusCallback");
      }
      
      public final void onResult(Status paramStatus)
      {
        AppMethodBeat.i(11130);
        Parcel localParcel = obtainAndWriteInterfaceToken();
        zzc.zza(localParcel, paramStatus);
        transactOneway(1, localParcel);
        AppMethodBeat.o(11130);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.IStatusCallback
 * JD-Core Version:    0.7.0.1
 */