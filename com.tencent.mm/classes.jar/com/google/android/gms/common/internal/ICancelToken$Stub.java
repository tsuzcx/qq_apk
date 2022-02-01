package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class ICancelToken$Stub
  extends zzb
  implements ICancelToken
{
  public ICancelToken$Stub()
  {
    super("com.google.android.gms.common.internal.ICancelToken");
  }
  
  public static ICancelToken asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.ICancelToken");
    if ((localIInterface instanceof ICancelToken)) {
      return (ICancelToken)localIInterface;
    }
    return new Proxy(paramIBinder);
  }
  
  public boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 == 2)
    {
      cancel();
      return true;
    }
    return false;
  }
  
  public static class Proxy
    extends zza
    implements ICancelToken
  {
    Proxy(IBinder paramIBinder)
    {
      super("com.google.android.gms.common.internal.ICancelToken");
    }
    
    public void cancel()
    {
      AppMethodBeat.i(4689);
      transactOneway(2, obtainAndWriteInterfaceToken());
      AppMethodBeat.o(4689);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.internal.ICancelToken.Stub
 * JD-Core Version:    0.7.0.1
 */