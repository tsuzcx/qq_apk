package com.tencent.mm.plugin.gwallet;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.jg.JgClassChecked;
import com.tencent.mm.plugin.gwallet.a.b;
import com.tencent.mm.plugin.gwallet.a.b.3;
import com.tencent.mm.plugin.gwallet.a.b.b;
import com.tencent.mm.plugin.gwallet.a.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

@JgClassChecked(author=31, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.ACTIVITYCHECK, com.jg.EType.RECEIVERCHECK})
public class GWalletUI
  extends Activity
{
  BroadcastReceiver hWU = new GWalletUI.3(this);
  private b liL = null;
  
  public final void gE(boolean paramBoolean)
  {
    b localb = this.liL;
    GWalletUI.4 local4 = new GWalletUI.4(this, paramBoolean);
    ah localah = new ah();
    localb.Fk("queryInventory");
    e.post(new b.3(localb, "inapp", localah, local4), "IabHelper_queryInventoryAsync");
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    b localb = this.liL;
    if (paramInt1 == localb.bMT)
    {
      localb.Fk("handleActivityResult");
      if (paramIntent != null) {
        break label65;
      }
      b.Fl("Null data in IAB activity result.");
      paramIntent = new c(-1002, "Null data in IAB result");
      if (localb.ljc != null) {
        localb.ljc.b(paramIntent, null);
      }
    }
    return;
    label65:
    Object localObject = paramIntent.getExtras().get("RESPONSE_CODE");
    if (localObject == null)
    {
      b.Fl("Intent with no response code, assuming OK (known issue)");
      paramInt1 = 0;
    }
    for (;;)
    {
      localObject = paramIntent.getStringExtra("INAPP_PURCHASE_DATA");
      String str = paramIntent.getStringExtra("INAPP_DATA_SIGNATURE");
      y.d("MicroMsg.IabHelper", "Purchase data: " + (String)localObject);
      y.d("MicroMsg.IabHelper", "Data signature: " + str);
      y.d("MicroMsg.IabHelper", "Extras: " + paramIntent.getExtras());
      y.d("MicroMsg.IabHelper", "Expected item type: " + localb.ljd);
      localObject = new c(paramInt1, "Null data in IAB result");
      if (localb.ljc == null) {
        break;
      }
      localb.ljc.b((c)localObject, paramIntent);
      return;
      if ((localObject instanceof Integer))
      {
        paramInt1 = ((Integer)localObject).intValue();
      }
      else
      {
        if (!(localObject instanceof Long)) {
          break label280;
        }
        paramInt1 = (int)((Long)localObject).longValue();
      }
    }
    label280:
    b.Fl("Unexpected type for intent response code.");
    b.Fl(localObject.getClass().getName());
    throw new RuntimeException("Unexpected type for intent response code: " + localObject.getClass().getName());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    y.d("MicroMsg.GWalletUI", "Creating IAB helper.");
    this.liL = new b(this);
    y.d("MicroMsg.GWalletUI", "Starting setup.");
    this.liL.a(new GWalletUI.1(this));
  }
  
  protected void onDestroy()
  {
    y.d("MicroMsg.GWalletUI", "Destroying helper.");
    if (this.liL != null) {
      this.liL.dispose();
    }
    this.liL = null;
    super.onDestroy();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    if ("com.tencent.mm.gwallet.ACTION_QUERY_REQUEST".equals(paramIntent.getAction())) {
      gE(paramIntent.getBooleanExtra("is_direct", true));
    }
    super.onNewIntent(paramIntent);
  }
  
  public void onStart()
  {
    super.onStart();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mm.gwallet.ACTION_CONSUME_REQUEST");
    registerReceiver(this.hWU, localIntentFilter);
  }
  
  protected void onStop()
  {
    super.onStop();
    unregisterReceiver(this.hWU);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gwallet.GWalletUI
 * JD-Core Version:    0.7.0.1
 */