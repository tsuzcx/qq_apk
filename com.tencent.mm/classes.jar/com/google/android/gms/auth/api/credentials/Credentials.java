package com.google.android.gms.auth.api.credentials;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Credentials
{
  public static CredentialsClient getClient(Activity paramActivity)
  {
    AppMethodBeat.i(50329);
    paramActivity = new CredentialsClient(paramActivity, CredentialsOptions.DEFAULT);
    AppMethodBeat.o(50329);
    return paramActivity;
  }
  
  public static CredentialsClient getClient(Activity paramActivity, CredentialsOptions paramCredentialsOptions)
  {
    AppMethodBeat.i(50330);
    paramActivity = new CredentialsClient(paramActivity, paramCredentialsOptions);
    AppMethodBeat.o(50330);
    return paramActivity;
  }
  
  public static CredentialsClient getClient(Context paramContext)
  {
    AppMethodBeat.i(50331);
    paramContext = new CredentialsClient(paramContext, CredentialsOptions.DEFAULT);
    AppMethodBeat.o(50331);
    return paramContext;
  }
  
  public static CredentialsClient getClient(Context paramContext, CredentialsOptions paramCredentialsOptions)
  {
    AppMethodBeat.i(50332);
    paramContext = new CredentialsClient(paramContext, paramCredentialsOptions);
    AppMethodBeat.o(50332);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.Credentials
 * JD-Core Version:    0.7.0.1
 */