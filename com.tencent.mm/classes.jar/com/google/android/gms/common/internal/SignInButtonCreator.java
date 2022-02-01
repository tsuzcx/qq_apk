package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SignInButtonCreator
  extends RemoteCreator<ISignInButtonCreator>
{
  private static final SignInButtonCreator zzuz;
  
  static
  {
    AppMethodBeat.i(11874);
    zzuz = new SignInButtonCreator();
    AppMethodBeat.o(11874);
  }
  
  private SignInButtonCreator()
  {
    super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
  }
  
  public static View createView(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(11870);
    paramContext = zzuz.zza(paramContext, paramInt1, paramInt2);
    AppMethodBeat.o(11870);
    return paramContext;
  }
  
  private final View zza(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(11871);
    try
    {
      SignInButtonConfig localSignInButtonConfig = new SignInButtonConfig(paramInt1, paramInt2, null);
      IObjectWrapper localIObjectWrapper = ObjectWrapper.wrap(paramContext);
      paramContext = (View)ObjectWrapper.unwrap(((ISignInButtonCreator)getRemoteCreatorInstance(paramContext)).newSignInButtonFromConfig(localIObjectWrapper, localSignInButtonConfig));
      AppMethodBeat.o(11871);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext = new RemoteCreator.RemoteCreatorException(64 + "Could not get button with size " + paramInt1 + " and color " + paramInt2, paramContext);
      AppMethodBeat.o(11871);
      throw paramContext;
    }
  }
  
  public final ISignInButtonCreator getRemoteCreator(IBinder paramIBinder)
  {
    AppMethodBeat.i(11872);
    paramIBinder = ISignInButtonCreator.Stub.asInterface(paramIBinder);
    AppMethodBeat.o(11872);
    return paramIBinder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.internal.SignInButtonCreator
 * JD-Core Version:    0.7.0.1
 */