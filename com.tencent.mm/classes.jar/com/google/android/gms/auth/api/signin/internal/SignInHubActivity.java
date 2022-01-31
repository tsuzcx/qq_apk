package com.google.android.gms.auth.api.signin.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.p;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepName
public class SignInHubActivity
  extends FragmentActivity
{
  private static boolean zzfg = false;
  private boolean zzfh = false;
  private SignInConfiguration zzfi;
  private boolean zzfj;
  private int zzfk;
  private Intent zzfl;
  
  private final void zzd(int paramInt)
  {
    AppMethodBeat.i(50413);
    Status localStatus = new Status(paramInt);
    Intent localIntent = new Intent();
    localIntent.putExtra("googleSignInStatus", localStatus);
    setResult(0, localIntent);
    finish();
    zzfg = false;
    AppMethodBeat.o(50413);
  }
  
  private final void zzu()
  {
    AppMethodBeat.i(50412);
    getSupportLoaderManager().a(new SignInHubActivity.zzd(this, null));
    zzfg = false;
    AppMethodBeat.o(50412);
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(50411);
    if (this.zzfh)
    {
      AppMethodBeat.o(50411);
      return;
    }
    setResult(0);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(50411);
      return;
      if (paramIntent != null)
      {
        Object localObject = (SignInAccount)paramIntent.getParcelableExtra("signInAccount");
        if ((localObject != null) && (((SignInAccount)localObject).getGoogleSignInAccount() != null))
        {
          localObject = ((SignInAccount)localObject).getGoogleSignInAccount();
          zzq.zze(this).zzd(this.zzfi.zzt(), (GoogleSignInAccount)localObject);
          paramIntent.removeExtra("signInAccount");
          paramIntent.putExtra("googleSignInAccount", (Parcelable)localObject);
          this.zzfj = true;
          this.zzfk = paramInt2;
          this.zzfl = paramIntent;
          zzu();
          AppMethodBeat.o(50411);
          return;
        }
        if (paramIntent.hasExtra("errorCode"))
        {
          zzd(paramIntent.getIntExtra("errorCode", 8));
          AppMethodBeat.o(50411);
          return;
        }
      }
      zzd(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(50409);
    super.onCreate(paramBundle);
    Intent localIntent = getIntent();
    String str = localIntent.getAction();
    if ("com.google.android.gms.auth.NO_IMPL".equals(str))
    {
      zzd(12500);
      AppMethodBeat.o(50409);
      return;
    }
    if ((!str.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) && (!str.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")))
    {
      paramBundle = String.valueOf(localIntent.getAction());
      if (paramBundle.length() != 0) {
        "Unknown action: ".concat(paramBundle);
      }
      for (;;)
      {
        finish();
        AppMethodBeat.o(50409);
        return;
        new String("Unknown action: ");
      }
    }
    this.zzfi = ((SignInConfiguration)localIntent.getBundleExtra("config").getParcelable("config"));
    if (this.zzfi == null)
    {
      setResult(0);
      finish();
      AppMethodBeat.o(50409);
      return;
    }
    int i;
    if (paramBundle == null) {
      i = 1;
    }
    while (i != 0) {
      if (zzfg)
      {
        setResult(0);
        zzd(12502);
        AppMethodBeat.o(50409);
        return;
        i = 0;
      }
      else
      {
        zzfg = true;
        paramBundle = new Intent(str);
        if (str.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) {
          paramBundle.setPackage("com.google.android.gms");
        }
        for (;;)
        {
          paramBundle.putExtra("config", this.zzfi);
          try
          {
            startActivityForResult(paramBundle, 40962);
            AppMethodBeat.o(50409);
            return;
          }
          catch (ActivityNotFoundException paramBundle)
          {
            this.zzfh = true;
            zzd(17);
            AppMethodBeat.o(50409);
            return;
          }
          paramBundle.setPackage(getPackageName());
        }
      }
    }
    this.zzfj = paramBundle.getBoolean("signingInGoogleApiClients");
    if (this.zzfj)
    {
      this.zzfk = paramBundle.getInt("signInResultCode");
      this.zzfl = ((Intent)paramBundle.getParcelable("signInResultData"));
      zzu();
    }
    AppMethodBeat.o(50409);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(50410);
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("signingInGoogleApiClients", this.zzfj);
    if (this.zzfj)
    {
      paramBundle.putInt("signInResultCode", this.zzfk);
      paramBundle.putParcelable("signInResultData", this.zzfl);
    }
    AppMethodBeat.o(50410);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.SignInHubActivity
 * JD-Core Version:    0.7.0.1
 */