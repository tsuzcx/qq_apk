package com.google.android.gms.internal.measurement;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zzo
  extends Binder
  implements IInterface
{
  private static zzq zzqk = null;
  
  protected zzo(String paramString)
  {
    AppMethodBeat.i(40316);
    attachInterface(this, paramString);
    AppMethodBeat.o(40316);
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
    AppMethodBeat.i(40317);
    if (paramInt1 > 16777215) {}
    for (boolean bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2); bool; bool = false)
    {
      AppMethodBeat.o(40317);
      return true;
      paramParcel1.enforceInterface(getInterfaceDescriptor());
    }
    bool = dispatchTransaction(paramInt1, paramParcel1, paramParcel2, paramInt2);
    AppMethodBeat.o(40317);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzo
 * JD-Core Version:    0.7.0.1
 */