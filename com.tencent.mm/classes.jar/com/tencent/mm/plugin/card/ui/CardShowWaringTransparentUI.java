package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(7)
public class CardShowWaringTransparentUI
  extends MMActivity
{
  public int getLayoutId()
  {
    return 2131493443;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113579);
    super.onCreate(paramBundle);
    h.a(this, getString(2131757183, new Object[] { getIntent().getStringExtra("KEY_BRAND_NAME") }), getString(2131757184), getString(2131757064), new DialogInterface.OnClickListener()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardShowWaringTransparentUI
 * JD-Core Version:    0.7.0.1
 */