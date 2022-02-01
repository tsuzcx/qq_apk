package com.google.android.gms.auth.api.credentials;

import android.accounts.Account;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class IdentityProviders
{
  public static final String FACEBOOK = "https://www.facebook.com";
  public static final String GOOGLE = "https://accounts.google.com";
  public static final String LINKEDIN = "https://www.linkedin.com";
  public static final String MICROSOFT = "https://login.live.com";
  public static final String PAYPAL = "https://www.paypal.com";
  public static final String TWITTER = "https://twitter.com";
  public static final String YAHOO = "https://login.yahoo.com";
  
  public static final String getIdentityProviderForAccount(Account paramAccount)
  {
    AppMethodBeat.i(88249);
    Preconditions.checkNotNull(paramAccount, "account cannot be null");
    if ("com.google".equals(paramAccount.type))
    {
      AppMethodBeat.o(88249);
      return "https://accounts.google.com";
    }
    if ("com.facebook.auth.login".equals(paramAccount.type))
    {
      AppMethodBeat.o(88249);
      return "https://www.facebook.com";
    }
    AppMethodBeat.o(88249);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.IdentityProviders
 * JD-Core Version:    0.7.0.1
 */