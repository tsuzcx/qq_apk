package com.tencent.mm.plugin.fingerprint.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.e;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ab;
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
    AppMethodBeat.i(41659);
    super.onCreate(paramBundle);
    ab.i("MicroMsg.FingerPrintEntranceUI", "onCreate");
    int i;
    if (e.bzw())
    {
      ab.i("MicroMsg.FingerPrintEntranceUI", "will call showSetFingerPrintGuide()");
      ab.i("MicroMsg.FingerPrintEntranceUI", "hy: has standard action starting to fingerprint setting");
      paramBundle = getResources().getString(2131304202);
      Resources localResources = getResources();
      if (((l)g.E(l.class)).bze())
      {
        i = 2131297824;
        h.a(this, paramBundle, "", localResources.getString(i), getString(2131296888), true, new FingerPrintEntranceUI.1(this), new FingerPrintEntranceUI.2(this));
        e.bzs();
        i = j;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        ab.e("MicroMsg.FingerPrintEntranceUI", "finish FingerPrintEntranceUI");
        finish();
      }
      AppMethodBeat.o(41659);
      return;
      i = 2131297018;
      break;
      if (!e.bzr())
      {
        ab.i("MicroMsg.FingerPrintEntranceUI", "will showOpenFingerPrintPayGuide()");
        h.a(this, getResources().getString(2131304201), "", getResources().getString(2131297822), getString(2131296888), true, new FingerPrintEntranceUI.3(this), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(41658);
            FingerPrintEntranceUI.this.finish();
            AppMethodBeat.o(41658);
          }
        });
        e.bzq();
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
    AppMethodBeat.i(41660);
    super.onResume();
    AppMethodBeat.o(41660);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintEntranceUI
 * JD-Core Version:    0.7.0.1
 */