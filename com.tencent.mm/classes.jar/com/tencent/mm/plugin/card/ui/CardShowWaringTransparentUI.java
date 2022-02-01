package com.tencent.mm.plugin.card.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.k;

@a(7)
public class CardShowWaringTransparentUI
  extends MMActivity
{
  public int getLayoutId()
  {
    return a.e.wnJ;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113579);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("KEY_BRAND_NAME");
    k.a(this, getString(a.g.wqA, new Object[] { paramBundle }), getString(a.g.wqB), getString(a.g.woZ), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(113578);
        paramAnonymousDialogInterface.dismiss();
        CardShowWaringTransparentUI.this.finish();
        AppMethodBeat.o(113578);
      }
    });
    AppMethodBeat.o(113579);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113580);
    if (paramInt == 4) {
      finish();
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(113580);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardShowWaringTransparentUI
 * JD-Core Version:    0.7.0.1
 */