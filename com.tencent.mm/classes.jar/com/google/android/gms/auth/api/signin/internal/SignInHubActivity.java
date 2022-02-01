package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.accessibility.AccessibilityEvent;
import androidx.fragment.app.FragmentActivity;
import androidx.h.a.a;
import androidx.h.a.a.a;
import androidx.h.b.b;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

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
    AppMethodBeat.i(88308);
    Status localStatus = new Status(paramInt);
    Intent localIntent = new Intent();
    localIntent.putExtra("googleSignInStatus", localStatus);
    setResult(0, localIntent);
    finish();
    zzfg = false;
    AppMethodBeat.o(88308);
  }
  
  private final void zzu()
  {
    AppMethodBeat.i(88307);
    getSupportLoaderManager().a(new zzd(null));
    zzfg = false;
    AppMethodBeat.o(88307);
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(88306);
    if (this.zzfh)
    {
      AppMethodBeat.o(88306);
      return;
    }
    setResult(0);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(88306);
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
          AppMethodBeat.o(88306);
          return;
        }
        if (paramIntent.hasExtra("errorCode"))
        {
          zzd(paramIntent.getIntExtra("errorCode", 8));
          AppMethodBeat.o(88306);
          return;
        }
      }
      zzd(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(88304);
    super.onCreate(paramBundle);
    Intent localIntent = getIntent();
    String str = localIntent.getAction();
    if ("com.google.android.gms.auth.NO_IMPL".equals(str))
    {
      zzd(12500);
      AppMethodBeat.o(88304);
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
        AppMethodBeat.o(88304);
        return;
        new String("Unknown action: ");
      }
    }
    this.zzfi = ((SignInConfiguration)localIntent.getBundleExtra("config").getParcelable("config"));
    if (this.zzfi == null)
    {
      setResult(0);
      finish();
      AppMethodBeat.o(88304);
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
        AppMethodBeat.o(88304);
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
            AppMethodBeat.o(88304);
            return;
          }
          catch (ActivityNotFoundException paramBundle)
          {
            this.zzfh = true;
            zzd(17);
            AppMethodBeat.o(88304);
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
    AppMethodBeat.o(88304);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(88305);
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("signingInGoogleApiClients", this.zzfj);
    if (this.zzfj)
    {
      paramBundle.putInt("signInResultCode", this.zzfk);
      paramBundle.putParcelable("signInResultData", this.zzfl);
    }
    AppMethodBeat.o(88305);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class zzd
    implements a.a<Void>
  {
    private zzd() {}
    
    public final b<Void> onCreateLoader(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(210371);
      paramBundle = new zzf(SignInHubActivity.this, GoogleApiClient.getAllClients());
      AppMethodBeat.o(210371);
      return paramBundle;
    }
    
    public final void onLoaderReset(b<Void> paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.SignInHubActivity
 * JD-Core Version:    0.7.0.1
 */