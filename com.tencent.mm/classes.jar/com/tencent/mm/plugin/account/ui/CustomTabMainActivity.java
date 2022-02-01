package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.ui.mmfb.sdk.f;
import com.tencent.mm.ui.mmfb.sdk.l;

public class CustomTabMainActivity
  extends HellActivity
{
  private boolean pZT = true;
  private BroadcastReceiver pZU;
  
  private static Bundle Tr(String paramString)
  {
    AppMethodBeat.i(305200);
    paramString = Uri.parse(paramString);
    Bundle localBundle = f.bCm(paramString.getQuery());
    localBundle.putAll(f.bCm(paramString.getFragment()));
    AppMethodBeat.o(305200);
    return localBundle;
  }
  
  private void d(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(305190);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.fb.CustomTabMainActivity", "sendResult = ".concat(String.valueOf(paramIntent)));
    androidx.i.a.a.al(this).unregisterReceiver(this.pZU);
    Object localObject;
    if (paramIntent != null)
    {
      localObject = paramIntent.getStringExtra(f.afyP);
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.fb.CustomTabMainActivity", "sendResult, responseURL = ".concat(String.valueOf(localObject)));
      if (localObject != null)
      {
        localObject = Tr((String)localObject);
        localObject = l.d(getIntent(), (Bundle)localObject);
        if (localObject != null) {
          paramIntent = (Intent)localObject;
        }
        setResult(paramInt, paramIntent);
      }
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(305190);
      return;
      localObject = new Bundle();
      break;
      setResult(paramInt, l.d(getIntent(), null));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(305209);
    super.onCreate(paramBundle);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.fb.CustomTabMainActivity", "onCreate, getIntent().getAction() = " + getIntent().getAction());
    if (CustomTabActivity.pZP.equals(getIntent().getAction()))
    {
      setResult(0);
      finish();
      AppMethodBeat.o(305209);
      return;
    }
    if (paramBundle == null)
    {
      paramBundle = getIntent().getStringExtra(f.afyQ);
      Bundle localBundle = getIntent().getBundleExtra(f.afyR);
      String str = getIntent().getStringExtra(f.afyS);
      boolean bool = new com.tencent.mm.ui.mmfb.sdk.b(paramBundle, localBundle).t(this, str);
      this.pZT = false;
      if (!bool)
      {
        setResult(0, getIntent().putExtra(f.afyU, true));
        finish();
        AppMethodBeat.o(305209);
        return;
      }
      this.pZU = new BroadcastReceiver()
      {
        public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(305225);
          paramAnonymousContext = new Intent(CustomTabMainActivity.this, CustomTabMainActivity.class);
          paramAnonymousContext.setAction(f.afyT);
          paramAnonymousContext.putExtra(f.afyP, paramAnonymousIntent.getStringExtra(f.afyP));
          paramAnonymousContext.addFlags(603979776);
          paramAnonymousIntent = CustomTabMainActivity.this;
          paramAnonymousContext = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousContext);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousIntent, paramAnonymousContext.aYi(), "com/tencent/mm/plugin/account/ui/CustomTabMainActivity$1", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousIntent.startActivity((Intent)paramAnonymousContext.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousIntent, "com/tencent/mm/plugin/account/ui/CustomTabMainActivity$1", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(305225);
        }
      };
      androidx.i.a.a.al(this).a(this.pZU, new IntentFilter(CustomTabActivity.pZP));
    }
    AppMethodBeat.o(305209);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(305211);
    super.onNewIntent(paramIntent);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.fb.CustomTabMainActivity", "CustomTabMainActivity, intent.getAction() = " + paramIntent.getAction());
    if (f.afyT.equals(paramIntent.getAction()))
    {
      Intent localIntent = new Intent(CustomTabActivity.pZQ);
      androidx.i.a.a.al(this).d(localIntent);
      d(-1, paramIntent);
      AppMethodBeat.o(305211);
      return;
    }
    if (CustomTabActivity.pZP.equals(paramIntent.getAction())) {
      d(-1, paramIntent);
    }
    AppMethodBeat.o(305211);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(305215);
    super.onResume();
    if (this.pZT) {
      d(0, null);
    }
    this.pZT = true;
    AppMethodBeat.o(305215);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.CustomTabMainActivity
 * JD-Core Version:    0.7.0.1
 */