package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.t;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;

@KeepName
public class SignInHubActivity
  extends FragmentActivity
{
  private zzn zzakI;
  private SignInConfiguration zzakJ;
  private boolean zzakK;
  private int zzakL;
  private Intent zzakM;
  
  private void zza(int paramInt, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      Object localObject = (SignInAccount)paramIntent.getParcelableExtra("signInAccount");
      if ((localObject != null) && (((SignInAccount)localObject).zzro() != null))
      {
        localObject = ((SignInAccount)localObject).zzro();
        this.zzakI.zzb((GoogleSignInAccount)localObject, this.zzakJ.zzrz());
        paramIntent.removeExtra("signInAccount");
        paramIntent.putExtra("googleSignInAccount", (Parcelable)localObject);
        this.zzakK = true;
        this.zzakL = paramInt;
        this.zzakM = paramIntent;
        zzrA();
        return;
      }
      if (paramIntent.hasExtra("errorCode"))
      {
        zzbq(paramIntent.getIntExtra("errorCode", 8));
        return;
      }
    }
    zzbq(8);
  }
  
  private void zzbq(int paramInt)
  {
    Status localStatus = new Status(paramInt);
    Intent localIntent = new Intent();
    localIntent.putExtra("googleSignInStatus", localStatus);
    setResult(0, localIntent);
    finish();
  }
  
  private void zzj(Intent paramIntent)
  {
    paramIntent.setPackage("com.google.android.gms");
    paramIntent.putExtra("config", this.zzakJ);
    try
    {
      startActivityForResult(paramIntent, 40962);
      return;
    }
    catch (ActivityNotFoundException paramIntent)
    {
      zzbq(8);
    }
  }
  
  private void zzrA()
  {
    getSupportLoaderManager().a(new SignInHubActivity.zza(this, null));
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    setResult(0);
    switch (paramInt1)
    {
    default: 
      return;
    }
    zza(paramInt2, paramIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.zzakI = zzn.zzas(this);
    Intent localIntent = getIntent();
    if (!"com.google.android.gms.auth.GOOGLE_SIGN_IN".equals(localIntent.getAction()))
    {
      String str = String.valueOf(localIntent.getAction());
      if (str.length() != 0)
      {
        "Unknown action: ".concat(str);
        finish();
      }
    }
    else
    {
      this.zzakJ = ((SignInConfiguration)localIntent.getParcelableExtra("config"));
      if (this.zzakJ != null) {
        break label99;
      }
      setResult(0);
      finish();
    }
    label99:
    do
    {
      return;
      new String("Unknown action: ");
      break;
      if (paramBundle == null)
      {
        zzj(new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN"));
        return;
      }
      this.zzakK = paramBundle.getBoolean("signingInGoogleApiClients");
    } while (!this.zzakK);
    this.zzakL = paramBundle.getInt("signInResultCode");
    this.zzakM = ((Intent)paramBundle.getParcelable("signInResultData"));
    zzrA();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("signingInGoogleApiClients", this.zzakK);
    if (this.zzakK)
    {
      paramBundle.putInt("signInResultCode", this.zzakL);
      paramBundle.putParcelable("signInResultData", this.zzakM);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.SignInHubActivity
 * JD-Core Version:    0.7.0.1
 */