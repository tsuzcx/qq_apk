package com.tencent.mm.plugin.fingerprint.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.d;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class FingerPrintEntranceUI
  extends WalletBaseUI
{
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int j = 1;
    AppMethodBeat.i(64554);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.FingerPrintEntranceUI", "onCreate");
    int i;
    if (d.dKk())
    {
      Log.i("MicroMsg.FingerPrintEntranceUI", "will call showSetFingerPrintGuide()");
      Log.i("MicroMsg.FingerPrintEntranceUI", "hy: has standard action starting to fingerprint setting");
      paramBundle = getResources().getString(2131766573);
      Resources localResources = getResources();
      if (((a)g.af(a.class)).dJW())
      {
        i = 2131756912;
        h.a(this, paramBundle, "", localResources.getString(i), getString(2131755761), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(64550);
            Log.i("MicroMsg.FingerPrintEntranceUI", "user click the button to set system fingerprint");
            FingerPrintEntranceUI.a(FingerPrintEntranceUI.this);
            FingerPrintEntranceUI.this.finish();
            AppMethodBeat.o(64550);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(64551);
            FingerPrintEntranceUI.this.finish();
            AppMethodBeat.o(64551);
          }
        });
        d.dKg();
        i = j;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        Log.e("MicroMsg.FingerPrintEntranceUI", "finish FingerPrintEntranceUI");
        finish();
      }
      AppMethodBeat.o(64554);
      return;
      i = 2131755921;
      break;
      if (!d.dKf())
      {
        Log.i("MicroMsg.FingerPrintEntranceUI", "will showOpenFingerPrintPayGuide()");
        h.a(this, getResources().getString(2131766572), "", getResources().getString(2131756910), getString(2131755761), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(64552);
            Log.i("MicroMsg.FingerPrintEntranceUI", "user click the button to open fingerprint pay");
            c.V(FingerPrintEntranceUI.this, "wallet", ".pwd.ui.WalletPasswordSettingUI");
            FingerPrintEntranceUI.this.finish();
            AppMethodBeat.o(64552);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(64553);
            FingerPrintEntranceUI.this.finish();
            AppMethodBeat.o(64553);
          }
        });
        d.dKe();
        i = j;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(64555);
    super.onResume();
    AppMethodBeat.o(64555);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintEntranceUI
 * JD-Core Version:    0.7.0.1
 */