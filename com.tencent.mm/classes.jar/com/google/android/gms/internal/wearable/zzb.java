package com.google.android.gms.internal.wearable;

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
    AppMethodBeat.i(100651);
    attachInterface(this, paramString);
    AppMethodBeat.o(100651);
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
    AppMethodBeat.i(100652);
    if (paramInt1 > 16777215) {}
    for (boolean bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2); bool; bool = false)
    {
      AppMethodBeat.o(100652);
      return true;
      paramParcel1.enforceInterface(getInterfaceDescriptor());
    }
    bool = dispatchTransaction(paramInt1, paramParcel1, paramParcel2, paramInt2);
    AppMethodBeat.o(100652);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.wearable.zzb
 * JD-Core Version:    0.7.0.1
 */