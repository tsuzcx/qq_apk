package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class IStatusCallback$Stub
  extends zzb
  implements IStatusCallback
{
  public IStatusCallback$Stub()
  {
    super("com.google.android.gms.common.api.internal.IStatusCallback");
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
      AppMethodBeat.i(60638);
      Parcel localParcel = obtainAndWriteInterfaceToken();
      zzc.zza(localParcel, paramStatus);
      transactOneway(1, localParcel);
      AppMethodBeat.o(60638);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.IStatusCallback.Stub
 * JD-Core Version:    0.7.0.1
 */