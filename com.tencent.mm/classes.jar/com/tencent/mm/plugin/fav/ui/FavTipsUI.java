package com.tencent.mm.plugin.fav.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;

public class FavTipsUI
  extends MMBaseActivity
{
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(106939);
    super.onCreate(paramBundle);
    paramBundle = new d.a(this);
    paramBundle.bon(getString(2131759240));
    paramBundle.boo(getString(2131759238) + "\n\n" + getString(2131759239));
    paramBundle.aoV(2131759237).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(106937);
        FavTipsUI.this.finish();
        AppMethodBeat.o(106937);
      }
    });
    paramBundle.f(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(106938);
        FavTipsUI.this.finish();
        AppMethodBeat.o(106938);
      }
    });
    paramBundle.hbn().show();
    AppMethodBeat.o(106939);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavTipsUI
 * JD-Core Version:    0.7.0.1
 */