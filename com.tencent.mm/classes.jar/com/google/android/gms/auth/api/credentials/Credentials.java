package com.google.android.gms.auth.api.credentials;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Credentials
{
  public static CredentialsClient getClient(Activity paramActivity)
  {
    AppMethodBeat.i(88224);
    paramActivity = new CredentialsClient(paramActivity, CredentialsOptions.DEFAULT);
    AppMethodBeat.o(88224);
    return paramActivity;
  }
  
  public static CredentialsClient getClient(Activity paramActivity, CredentialsOptions paramCredentialsOptions)
  {
    AppMethodBeat.i(88225);
    paramActivity = new CredentialsClient(paramActivity, paramCredentialsOptions);
    AppMethodBeat.o(88225);
    return paramActivity;
  }
  
  public static CredentialsClient getClient(Context paramContext)
  {
    AppMethodBeat.i(88226);
    paramContext = new CredentialsClient(paramContext, CredentialsOptions.DEFAULT);
    AppMethodBeat.o(88226);
    return paramContext;
  }
  
  public static CredentialsClient getClient(Context paramContext, CredentialsOptions paramCredentialsOptions)
  {
    AppMethodBeat.i(88227);
    paramContext = new CredentialsClient(paramContext, paramCredentialsOptions);
    AppMethodBeat.o(88227);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.Credentials
 * JD-Core Version:    0.7.0.1
 */