package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.i.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.mmfb.sdk.f;

public class CustomTabActivity
  extends HellActivity
{
  public static final String pZP;
  public static final String pZQ;
  private BroadcastReceiver pZR;
  
  static
  {
    AppMethodBeat.i(305189);
    pZP = f.afyV;
    pZQ = CustomTabActivity.class.getSimpleName() + ".action_destroy";
    AppMethodBeat.o(305189);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(305202);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("MicroMsg.fb.CustomTabActivity", "CustomTabActivity, onActivityResult， resultCode = ".concat(String.valueOf(paramInt2)));
    if (paramInt2 == 0)
    {
      paramIntent = new Intent(pZP);
      paramIntent.putExtra(f.afyP, getIntent().getDataString());
      a.al(this).d(paramIntent);
      this.pZR = new BroadcastReceiver()
      {
        public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(304907);
          paramAnonymousContext = new Intent(f.afyV);
          paramAnonymousContext.putExtra(f.afyP, CustomTabActivity.this.getIntent().getDataString());
          a.al(CustomTabActivity.this).d(paramAnonymousContext);
          CustomTabActivity.this.finish();
          AppMethodBeat.o(304907);
        }
      };
      a.al(this).a(this.pZR, new IntentFilter(pZQ));
    }
    AppMethodBeat.o(305202);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(305196);
    super.onCreate(paramBundle);
    paramBundle = new Intent(this, CustomTabMainActivity.class);
    paramBundle.setAction(pZP);
    paramBundle.putExtra(f.afyP, getIntent().getDataString());
    startActivityForResult(paramBundle, 2);
    AppMethodBeat.o(305196);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(305205);
    Log.i("MicroMsg.fb.CustomTabActivity", "CustomTabActivity, onDestroy.");
    a.al(this).unregisterReceiver(this.pZR);
    super.onDestroy();
    AppMethodBeat.o(305205);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.CustomTabActivity
 * JD-Core Version:    0.7.0.1
 */