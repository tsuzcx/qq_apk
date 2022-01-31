package com.tencent.mm.plugin.gwallet;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gwallet.a.b;
import com.tencent.mm.plugin.gwallet.a.b.3;
import com.tencent.mm.plugin.gwallet.a.b.b;
import com.tencent.mm.plugin.gwallet.a.c;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

@JgClassChecked(author=31, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.ACTIVITYCHECK, com.jg.EType.RECEIVERCHECK})
public class GWalletUI
  extends Activity
{
  BroadcastReceiver jQN;
  private b nGa;
  
  public GWalletUI()
  {
    AppMethodBeat.i(41679);
    this.nGa = null;
    this.jQN = new GWalletUI.3(this);
    AppMethodBeat.o(41679);
  }
  
  public final void io(boolean paramBoolean)
  {
    AppMethodBeat.i(41681);
    b localb = this.nGa;
    GWalletUI.4 local4 = new GWalletUI.4(this, paramBoolean);
    ak localak = new ak();
    localb.QI("queryInventory");
    d.post(new b.3(localb, "inapp", localak, local4), "IabHelper_queryInventoryAsync");
    AppMethodBeat.o(41681);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(41685);
    b localb = this.nGa;
    Object localObject;
    if (paramInt1 == localb.cun)
    {
      localb.QI("handleActivityResult");
      if (paramIntent == null)
      {
        b.QJ("Null data in IAB activity result.");
        paramIntent = new c(-1002, "Null data in IAB result");
        if (localb.nGr != null) {
          localb.nGr.b(paramIntent, null);
        }
        AppMethodBeat.o(41685);
        return;
      }
      localObject = paramIntent.getExtras().get("RESPONSE_CODE");
      if (localObject != null) {
        break label247;
      }
      b.QJ("Intent with no response code, assuming OK (known issue)");
      paramInt1 = 0;
    }
    for (;;)
    {
      localObject = paramIntent.getStringExtra("INAPP_PURCHASE_DATA");
      String str = paramIntent.getStringExtra("INAPP_DATA_SIGNATURE");
      ab.d("MicroMsg.IabHelper", "Purchase data: ".concat(String.valueOf(localObject)));
      ab.d("MicroMsg.IabHelper", "Data signature: ".concat(String.valueOf(str)));
      ab.d("MicroMsg.IabHelper", "Extras: " + paramIntent.getExtras());
      ab.d("MicroMsg.IabHelper", "Expected item type: " + localb.nGs);
      localObject = new c(paramInt1, "Null data in IAB result");
      if (localb.nGr != null) {
        localb.nGr.b((c)localObject, paramIntent);
      }
      AppMethodBeat.o(41685);
      return;
      label247:
      if ((localObject instanceof Integer))
      {
        paramInt1 = ((Integer)localObject).intValue();
      }
      else
      {
        if (!(localObject instanceof Long)) {
          break;
        }
        paramInt1 = (int)((Long)localObject).longValue();
      }
    }
    b.QJ("Unexpected type for intent response code.");
    b.QJ(localObject.getClass().getName());
    paramIntent = new RuntimeException("Unexpected type for intent response code: " + localObject.getClass().getName());
    AppMethodBeat.o(41685);
    throw paramIntent;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41680);
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    ab.d("MicroMsg.GWalletUI", "Creating IAB helper.");
    this.nGa = new b(this);
    ab.d("MicroMsg.GWalletUI", "Starting setup.");
    this.nGa.a(new GWalletUI.1(this));
    AppMethodBeat.o(41680);
  }
  
  protected void onDestroy()
  {
    AppMethodBeat.i(41686);
    ab.d("MicroMsg.GWalletUI", "Destroying helper.");
    if (this.nGa != null) {
      this.nGa.dispose();
    }
    this.nGa = null;
    super.onDestroy();
    AppMethodBeat.o(41686);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(41682);
    if ("com.tencent.mm.gwallet.ACTION_QUERY_REQUEST".equals(paramIntent.getAction())) {
      io(paramIntent.getBooleanExtra("is_direct", true));
    }
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(41682);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(41683);
    super.onStart();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mm.gwallet.ACTION_CONSUME_REQUEST");
    registerReceiver(this.jQN, localIntentFilter);
    AppMethodBeat.o(41683);
  }
  
  protected void onStop()
  {
    AppMethodBeat.i(41684);
    super.onStop();
    unregisterReceiver(this.jQN);
    AppMethodBeat.o(41684);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gwallet.GWalletUI
 * JD-Core Version:    0.7.0.1
 */