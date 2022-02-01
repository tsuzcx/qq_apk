package com.tencent.mm.plugin.gwallet;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.jg.JgClassChecked;
import com.jg.JgMethodChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.plugin.gwallet.a.b.2;
import com.tencent.mm.plugin.gwallet.a.b.3;
import com.tencent.mm.plugin.gwallet.a.b.a;
import com.tencent.mm.plugin.gwallet.a.b.b;
import com.tencent.mm.plugin.gwallet.a.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.ArrayList;

@JgClassChecked(author=31, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.ACTIVITYCHECK, com.jg.EType.RECEIVERCHECK})
public class GWalletUI
  extends HellActivity
{
  BroadcastReceiver mReceiver;
  private com.tencent.mm.plugin.gwallet.a.b tAo;
  
  public GWalletUI()
  {
    AppMethodBeat.i(64575);
    this.tAo = null;
    this.mReceiver = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(64573);
        if ("com.tencent.mm.gwallet.ACTION_CONSUME_REQUEST".equals(paramAnonymousIntent.getAction()))
        {
          paramAnonymousContext = paramAnonymousIntent.getStringArrayListExtra("tokens");
          final boolean bool = paramAnonymousIntent.getBooleanExtra("IS_FAILED_CONSUME", false);
          if ((paramAnonymousContext == null) || (paramAnonymousContext.size() == 0))
          {
            GWalletUI.a(GWalletUI.this, 0, null);
            AppMethodBeat.o(64573);
            return;
          }
          com.tencent.mm.sdk.g.b.c(new b.2(GWalletUI.b(GWalletUI.this), paramAnonymousContext, new b.b()new ao
          {
            public final void b(c paramAnonymous2c, Intent paramAnonymous2Intent)
            {
              AppMethodBeat.i(64572);
              ac.d("MicroMsg.GWalletUI", "Purchase finished: " + paramAnonymous2c + ", purchase: " + paramAnonymous2Intent);
              paramAnonymous2c = new Intent("com.tencent.mm.gwallet.ACTION_CONSUME_RESPONSE");
              if (bool) {
                paramAnonymous2c.putExtra("RESPONSE_CODE", 100000001);
              }
              for (;;)
              {
                GWalletUI.a(GWalletUI.this, -1, paramAnonymous2c);
                AppMethodBeat.o(64572);
                return;
                paramAnonymous2c.putExtra("RESPONSE_CODE", 0);
              }
            }
          }, new ao()), "IabHelper_consumeAsync");
        }
        AppMethodBeat.o(64573);
      }
    };
    AppMethodBeat.o(64575);
  }
  
  public final void mW(final boolean paramBoolean)
  {
    AppMethodBeat.i(64577);
    com.tencent.mm.plugin.gwallet.a.b localb = this.tAo;
    b.b local4 = new b.b()
    {
      @JgMethodChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.INTENTCHECK})
      public final void b(c paramAnonymousc, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(64574);
        ac.d("MicroMsg.GWalletUI", "Query inventory finished. data : ".concat(String.valueOf(paramAnonymousIntent)));
        if (paramAnonymousIntent == null)
        {
          paramAnonymousIntent = new Intent("com.tencent.mm.gwallet.ACTION_QUERY_RESPONSE");
          paramAnonymousIntent.putExtra("RESPONSE_CODE", paramAnonymousc.cSB());
        }
        for (;;)
        {
          if (!paramBoolean) {
            paramAnonymousIntent.putExtra("is_direct", false);
          }
          GWalletUI.this.sendBroadcast(paramAnonymousIntent);
          AppMethodBeat.o(64574);
          return;
          paramAnonymousIntent.setAction("com.tencent.mm.gwallet.ACTION_QUERY_RESPONSE");
        }
      }
    };
    ao localao = new ao();
    localb.ain("queryInventory");
    com.tencent.mm.sdk.g.b.c(new b.3(localb, "inapp", localao, local4), "IabHelper_queryInventoryAsync");
    AppMethodBeat.o(64577);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(64581);
    com.tencent.mm.plugin.gwallet.a.b localb = this.tAo;
    Object localObject;
    if (paramInt1 == localb.mRequestCode)
    {
      localb.ain("handleActivityResult");
      if (paramIntent == null)
      {
        com.tencent.mm.plugin.gwallet.a.b.aio("Null data in IAB activity result.");
        paramIntent = new c(-1002, "Null data in IAB result");
        if (localb.tAF != null) {
          localb.tAF.b(paramIntent, null);
        }
        AppMethodBeat.o(64581);
        return;
      }
      localObject = paramIntent.getExtras().get("RESPONSE_CODE");
      if (localObject != null) {
        break label247;
      }
      com.tencent.mm.plugin.gwallet.a.b.aio("Intent with no response code, assuming OK (known issue)");
      paramInt1 = 0;
    }
    for (;;)
    {
      localObject = paramIntent.getStringExtra("INAPP_PURCHASE_DATA");
      String str = paramIntent.getStringExtra("INAPP_DATA_SIGNATURE");
      ac.d("MicroMsg.IabHelper", "Purchase data: ".concat(String.valueOf(localObject)));
      ac.d("MicroMsg.IabHelper", "Data signature: ".concat(String.valueOf(str)));
      ac.d("MicroMsg.IabHelper", "Extras: " + paramIntent.getExtras());
      ac.d("MicroMsg.IabHelper", "Expected item type: " + localb.tAG);
      localObject = new c(paramInt1, "Null data in IAB result");
      if (localb.tAF != null) {
        localb.tAF.b((c)localObject, paramIntent);
      }
      AppMethodBeat.o(64581);
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
    com.tencent.mm.plugin.gwallet.a.b.aio("Unexpected type for intent response code.");
    com.tencent.mm.plugin.gwallet.a.b.aio(localObject.getClass().getName());
    paramIntent = new RuntimeException("Unexpected type for intent response code: " + localObject.getClass().getName());
    AppMethodBeat.o(64581);
    throw paramIntent;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64576);
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    ac.d("MicroMsg.GWalletUI", "Creating IAB helper.");
    this.tAo = new com.tencent.mm.plugin.gwallet.a.b(this);
    ac.d("MicroMsg.GWalletUI", "Starting setup.");
    this.tAo.a(new b.a()
    {
      public final void a(c paramAnonymousc)
      {
        AppMethodBeat.i(64570);
        ac.d("MicroMsg.GWalletUI", "Setup finished.");
        if (!paramAnonymousc.isSuccess())
        {
          ac.e("MicroMsg.GWalletUI", "Problem setting up in-app billing: ".concat(String.valueOf(paramAnonymousc)));
          Intent localIntent = new Intent();
          localIntent.putExtra("RESPONSE_CODE", paramAnonymousc.cSB());
          GWalletUI.a(GWalletUI.this, -1, localIntent);
          AppMethodBeat.o(64570);
          return;
        }
        if ("com.tencent.mm.gwallet.ACTION_PAY_REQUEST".equals(GWalletUI.this.getIntent().getAction()))
        {
          GWalletUI.a(GWalletUI.this);
          AppMethodBeat.o(64570);
          return;
        }
        GWalletUI.this.mW(GWalletUI.this.getIntent().getBooleanExtra("is_direct", true));
        AppMethodBeat.o(64570);
      }
    });
    AppMethodBeat.o(64576);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64582);
    ac.d("MicroMsg.GWalletUI", "Destroying helper.");
    if (this.tAo != null) {
      this.tAo.dispose();
    }
    this.tAo = null;
    super.onDestroy();
    AppMethodBeat.o(64582);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(64578);
    if ("com.tencent.mm.gwallet.ACTION_QUERY_REQUEST".equals(paramIntent.getAction())) {
      mW(paramIntent.getBooleanExtra("is_direct", true));
    }
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(64578);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(64579);
    super.onStart();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mm.gwallet.ACTION_CONSUME_REQUEST");
    registerReceiver(this.mReceiver, localIntentFilter);
    AppMethodBeat.o(64579);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(64580);
    super.onStop();
    unregisterReceiver(this.mReceiver);
    AppMethodBeat.o(64580);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gwallet.GWalletUI
 * JD-Core Version:    0.7.0.1
 */