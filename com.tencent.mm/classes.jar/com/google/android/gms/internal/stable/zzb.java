package com.google.android.gms.internal.stable;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zzb
  extends Binder
  implements IInterface
{
  private static zzd zzc = null;
  
  protected zzb(String paramString)
  {
    AppMethodBeat.i(90461);
    attachInterface(this, paramString);
    AppMethodBeat.o(90461);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  protected boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    return false;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    AppMethodBeat.i(90463);
    if (routeToSuperOrEnforceInterface(paramInt1, paramParcel1, paramParcel2, paramInt2))
    {
      AppMethodBeat.o(90463);
      return true;
    }
    boolean bool = dispatchTransaction(paramInt1, paramParcel1, paramParcel2, paramInt2);
    AppMethodBeat.o(90463);
    return bool;
  }
  
  protected boolean routeToSuperOrEnforceInterface(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    AppMethodBeat.i(90462);
    if (paramInt1 > 16777215)
    {
      boolean bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      AppMethodBeat.o(90462);
      return bool;
    }
    paramParcel1.enforceInterface(getInterfaceDescriptor());
    AppMethodBeat.o(90462);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.internal.stable.zzb
 * JD-Core Version:    0.7.0.1
 */