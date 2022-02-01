package com.tencent.mm.plugin.fingerprint.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.sdk.platformtools.ad;
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
    ad.i("MicroMsg.FingerPrintEntranceUI", "onCreate");
    int i;
    if (com.tencent.mm.plugin.fingerprint.b.d.cuj())
    {
      ad.i("MicroMsg.FingerPrintEntranceUI", "will call showSetFingerPrintGuide()");
      ad.i("MicroMsg.FingerPrintEntranceUI", "hy: has standard action starting to fingerprint setting");
      paramBundle = getResources().getString(2131764315);
      Resources localResources = getResources();
      if (((a)g.ab(a.class)).ctV())
      {
        i = 2131756750;
        h.a(this, paramBundle, "", localResources.getString(i), getString(2131755691), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(64550);
            ad.i("MicroMsg.FingerPrintEntranceUI", "user click the button to set system fingerprint");
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
        com.tencent.mm.plugin.fingerprint.b.d.cuf();
        i = j;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        ad.e("MicroMsg.FingerPrintEntranceUI", "finish FingerPrintEntranceUI");
        finish();
      }
      AppMethodBeat.o(64554);
      return;
      i = 2131755835;
      break;
      if (!com.tencent.mm.plugin.fingerprint.b.d.cue())
      {
        ad.i("MicroMsg.FingerPrintEntranceUI", "will showOpenFingerPrintPayGuide()");
        h.a(this, getResources().getString(2131764314), "", getResources().getString(2131756748), getString(2131755691), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(64552);
            ad.i("MicroMsg.FingerPrintEntranceUI", "user click the button to open fingerprint pay");
            com.tencent.mm.bs.d.O(FingerPrintEntranceUI.this, "wallet", ".pwd.ui.WalletPasswordSettingUI");
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
        com.tencent.mm.plugin.fingerprint.b.d.cud();
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
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