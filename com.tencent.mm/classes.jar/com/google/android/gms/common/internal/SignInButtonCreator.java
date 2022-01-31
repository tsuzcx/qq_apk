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
    AppMethodBeat.i(61382);
    zzuz = new SignInButtonCreator();
    AppMethodBeat.o(61382);
  }
  
  private SignInButtonCreator()
  {
    super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
  }
  
  public static View createView(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(61378);
    paramContext = zzuz.zza(paramContext, paramInt1, paramInt2);
    AppMethodBeat.o(61378);
    return paramContext;
  }
  
  private final View zza(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(61379);
    try
    {
      SignInButtonConfig localSignInButtonConfig = new SignInButtonConfig(paramInt1, paramInt2, null);
      IObjectWrapper localIObjectWrapper = ObjectWrapper.wrap(paramContext);
      paramContext = (View)ObjectWrapper.unwrap(((ISignInButtonCreator)getRemoteCreatorInstance(paramContext)).newSignInButtonFromConfig(localIObjectWrapper, localSignInButtonConfig));
      AppMethodBeat.o(61379);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext = new RemoteCreator.RemoteCreatorException(64 + "Could not get button with size " + paramInt1 + " and color " + paramInt2, paramContext);
      AppMethodBeat.o(61379);
      throw paramContext;
    }
  }
  
  public final ISignInButtonCreator getRemoteCreator(IBinder paramIBinder)
  {
    AppMethodBeat.i(61380);
    paramIBinder = ISignInButtonCreator.Stub.asInterface(paramIBinder);
    AppMethodBeat.o(61380);
    return paramIBinder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.internal.SignInButtonCreator
 * JD-Core Version:    0.7.0.1
 */