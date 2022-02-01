package com.google.android.gms.signin;

import android.os.Bundle;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SignIn$SignInOptionsInternal
  implements Api.ApiOptions.HasOptions
{
  private final Bundle zzada;
  
  private SignIn$SignInOptionsInternal(Bundle paramBundle)
  {
    AppMethodBeat.i(12135);
    if (paramBundle != null) {}
    for (;;)
    {
      this.zzada = paramBundle;
      AppMethodBeat.o(12135);
      return;
      paramBundle = new Bundle();
    }
  }
  
  public static SignInOptionsInternal create(Bundle paramBundle)
  {
    AppMethodBeat.i(12134);
    paramBundle = new SignInOptionsInternal(paramBundle);
    AppMethodBeat.o(12134);
    return paramBundle;
  }
  
  public Bundle getSignInOptionsBundle()
  {
    return this.zzada;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.signin.SignIn.SignInOptionsInternal
 * JD-Core Version:    0.7.0.1
 */