package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzq
{
  private static zzq zzfa = null;
  @VisibleForTesting
  private Storage zzfb;
  @VisibleForTesting
  private GoogleSignInAccount zzfc;
  @VisibleForTesting
  private GoogleSignInOptions zzfd;
  
  private zzq(Context paramContext)
  {
    AppMethodBeat.i(88346);
    this.zzfb = Storage.getInstance(paramContext);
    this.zzfc = this.zzfb.getSavedDefaultGoogleSignInAccount();
    this.zzfd = this.zzfb.getSavedDefaultGoogleSignInOptions();
    AppMethodBeat.o(88346);
  }
  
  public static zzq zze(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(88347);
      paramContext = zzf(paramContext.getApplicationContext());
      AppMethodBeat.o(88347);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private static zzq zzf(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(88348);
      if (zzfa == null) {
        zzfa = new zzq(paramContext);
      }
      paramContext = zzfa;
      AppMethodBeat.o(88348);
      return paramContext;
    }
    finally {}
  }
  
  public final void clear()
  {
    try
    {
      AppMethodBeat.i(88349);
      this.zzfb.clear();
      this.zzfc = null;
      this.zzfd = null;
      AppMethodBeat.o(88349);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void zzd(GoogleSignInOptions paramGoogleSignInOptions, GoogleSignInAccount paramGoogleSignInAccount)
  {
    try
    {
      AppMethodBeat.i(88350);
      this.zzfb.saveDefaultGoogleSignInAccount(paramGoogleSignInAccount, paramGoogleSignInOptions);
      this.zzfc = paramGoogleSignInAccount;
      this.zzfd = paramGoogleSignInOptions;
      AppMethodBeat.o(88350);
      return;
    }
    finally
    {
      paramGoogleSignInOptions = finally;
      throw paramGoogleSignInOptions;
    }
  }
  
  public final GoogleSignInAccount zzo()
  {
    try
    {
      GoogleSignInAccount localGoogleSignInAccount = this.zzfc;
      return localGoogleSignInAccount;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final GoogleSignInOptions zzp()
  {
    try
    {
      GoogleSignInOptions localGoogleSignInOptions = this.zzfd;
      return localGoogleSignInOptions;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzq
 * JD-Core Version:    0.7.0.1
 */