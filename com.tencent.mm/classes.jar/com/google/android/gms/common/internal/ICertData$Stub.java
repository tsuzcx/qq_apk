package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class ICertData$Stub
  extends zzb
  implements ICertData
{
  public ICertData$Stub()
  {
    super("com.google.android.gms.common.internal.ICertData");
  }
  
  public static ICertData asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
    if ((localIInterface instanceof ICertData)) {
      return (ICertData)localIInterface;
    }
    return new Proxy(paramIBinder);
  }
  
  public boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return false;
    case 1: 
      paramParcel1 = getBytesWrapped();
      paramParcel2.writeNoException();
      zzc.zza(paramParcel2, paramParcel1);
    }
    for (;;)
    {
      return true;
      paramInt1 = getHashCode();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
    }
  }
  
  public static class Proxy
    extends zza
    implements ICertData
  {
    Proxy(IBinder paramIBinder)
    {
      super("com.google.android.gms.common.internal.ICertData");
    }
    
    public IObjectWrapper getBytesWrapped()
    {
      AppMethodBeat.i(4690);
      Parcel localParcel = transactAndReadException(1, obtainAndWriteInterfaceToken());
      IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel.readStrongBinder());
      localParcel.recycle();
      AppMethodBeat.o(4690);
      return localIObjectWrapper;
    }
    
    public int getHashCode()
    {
      AppMethodBeat.i(4691);
      Parcel localParcel = transactAndReadException(2, obtainAndWriteInterfaceToken());
      int i = localParcel.readInt();
      localParcel.recycle();
      AppMethodBeat.o(4691);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.internal.ICertData.Stub
 * JD-Core Version:    0.7.0.1
 */