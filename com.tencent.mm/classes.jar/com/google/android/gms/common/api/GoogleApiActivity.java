package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.internal.zzaax;

public class GoogleApiActivity
  extends Activity
  implements DialogInterface.OnCancelListener
{
  protected int zzazb = 0;
  
  public static PendingIntent zza(Context paramContext, PendingIntent paramPendingIntent, int paramInt)
  {
    return zza(paramContext, paramPendingIntent, paramInt, true);
  }
  
  public static PendingIntent zza(Context paramContext, PendingIntent paramPendingIntent, int paramInt, boolean paramBoolean)
  {
    return PendingIntent.getActivity(paramContext, 0, zzb(paramContext, paramPendingIntent, paramInt, paramBoolean), 134217728);
  }
  
  private void zza(int paramInt, zzaax paramzzaax)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramzzaax.zza(new ConnectionResult(13, null), getIntent().getIntExtra("failing_client_id", -1));
      return;
    }
    paramzzaax.zzvx();
  }
  
  public static Intent zzb(Context paramContext, PendingIntent paramPendingIntent, int paramInt, boolean paramBoolean)
  {
    paramContext = new Intent(paramContext, GoogleApiActivity.class);
    paramContext.putExtra("pending_intent", paramPendingIntent);
    paramContext.putExtra("failing_client_id", paramInt);
    paramContext.putExtra("notify_manager", paramBoolean);
    return paramContext;
  }
  
  private void zzvl()
  {
    Object localObject = getIntent().getExtras();
    if (localObject == null)
    {
      finish();
      return;
    }
    PendingIntent localPendingIntent = (PendingIntent)((Bundle)localObject).get("pending_intent");
    localObject = (Integer)((Bundle)localObject).get("error_code");
    if ((localPendingIntent == null) && (localObject == null))
    {
      finish();
      return;
    }
    if (localPendingIntent != null) {
      try
      {
        startIntentSenderForResult(localPendingIntent.getIntentSender(), 1, null, 0, 0, 0);
        this.zzazb = 1;
        return;
      }
      catch (IntentSender.SendIntentException localSendIntentException)
      {
        finish();
        return;
      }
    }
    GoogleApiAvailability.getInstance().showErrorDialogFragment(this, ((Integer)localObject).intValue(), 2, this);
    this.zzazb = 1;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      boolean bool = getIntent().getBooleanExtra("notify_manager", true);
      this.zzazb = 0;
      setResultCode(paramInt2);
      if (bool) {
        zza(paramInt2, zzaax.zzaP(this));
      }
    }
    for (;;)
    {
      finish();
      return;
      if (paramInt1 == 2)
      {
        this.zzazb = 0;
        setResultCode(paramInt2);
      }
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.zzazb = 0;
    setResult(0);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null) {
      this.zzazb = paramBundle.getInt("resolution");
    }
    if (this.zzazb != 1) {
      zzvl();
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putInt("resolution", this.zzazb);
    super.onSaveInstanceState(paramBundle);
  }
  
  protected void setResultCode(int paramInt)
  {
    setResult(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.common.api.GoogleApiActivity
 * JD-Core Version:    0.7.0.1
 */