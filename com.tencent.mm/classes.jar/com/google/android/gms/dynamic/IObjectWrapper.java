package com.google.android.gms.dynamic;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface IObjectWrapper
  extends IInterface
{
  public static class Stub
    extends zzb
    implements IObjectWrapper
  {
    public Stub()
    {
      super();
    }
    
    public static IObjectWrapper asInterface(IBinder paramIBinder)
    {
      AppMethodBeat.i(5416);
      if (paramIBinder == null)
      {
        AppMethodBeat.o(5416);
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
      if ((localIInterface instanceof IObjectWrapper))
      {
        paramIBinder = (IObjectWrapper)localIInterface;
        AppMethodBeat.o(5416);
        return paramIBinder;
      }
      paramIBinder = new Proxy(paramIBinder);
      AppMethodBeat.o(5416);
      return paramIBinder;
    }
    
    public static class Proxy
      extends zza
      implements IObjectWrapper
    {
      Proxy(IBinder paramIBinder)
      {
        super("com.google.android.gms.dynamic.IObjectWrapper");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.dynamic.IObjectWrapper
 * JD-Core Version:    0.7.0.1
 */