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
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GoogleApiActivity
  extends Activity
  implements DialogInterface.OnCancelListener
{
  @VisibleForTesting
  private int zzct = 0;
  
  public static PendingIntent zza(Context paramContext, PendingIntent paramPendingIntent, int paramInt)
  {
    AppMethodBeat.i(60528);
    paramContext = PendingIntent.getActivity(paramContext, 0, zza(paramContext, paramPendingIntent, paramInt, true), 134217728);
    AppMethodBeat.o(60528);
    return paramContext;
  }
  
  public static Intent zza(Context paramContext, PendingIntent paramPendingIntent, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(60529);
    paramContext = new Intent(paramContext, GoogleApiActivity.class);
    paramContext.putExtra("pending_intent", paramPendingIntent);
    paramContext.putExtra("failing_client_id", paramInt);
    paramContext.putExtra("notify_manager", paramBoolean);
    AppMethodBeat.o(60529);
    return paramContext;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(60531);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      boolean bool = getIntent().getBooleanExtra("notify_manager", true);
      this.zzct = 0;
      setResult(paramInt2, paramIntent);
      if (bool)
      {
        paramIntent = GoogleApiManager.zzb(this);
        switch (paramInt2)
        {
        }
      }
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(60531);
      return;
      paramIntent.zza(new ConnectionResult(13, null), getIntent().getIntExtra("failing_client_id", -1));
      continue;
      paramIntent.zzr();
      continue;
      if (paramInt1 == 2)
      {
        this.zzct = 0;
        setResult(paramInt2, paramIntent);
      }
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(60533);
    this.zzct = 0;
    setResult(0);
    finish();
    AppMethodBeat.o(60533);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(60530);
    super.onCreate(paramBundle);
    if (paramBundle != null) {
      this.zzct = paramBundle.getInt("resolution");
    }
    if (this.zzct != 1)
    {
      Object localObject = getIntent().getExtras();
      if (localObject == null)
      {
        finish();
        AppMethodBeat.o(60530);
        return;
      }
      paramBundle = (PendingIntent)((Bundle)localObject).get("pending_intent");
      localObject = (Integer)((Bundle)localObject).get("error_code");
      if ((paramBundle == null) && (localObject == null))
      {
        finish();
        AppMethodBeat.o(60530);
        return;
      }
      if (paramBundle != null) {
        try
        {
          startIntentSenderForResult(paramBundle.getIntentSender(), 1, null, 0, 0, 0);
          this.zzct = 1;
          AppMethodBeat.o(60530);
          return;
        }
        catch (IntentSender.SendIntentException paramBundle)
        {
          finish();
          AppMethodBeat.o(60530);
          return;
        }
      }
      GoogleApiAvailability.getInstance().showErrorDialogFragment(this, ((Integer)localObject).intValue(), 2, this);
      this.zzct = 1;
    }
    AppMethodBeat.o(60530);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(60532);
    paramBundle.putInt("resolution", this.zzct);
    super.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(60532);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.GoogleApiActivity
 * JD-Core Version:    0.7.0.1
 */