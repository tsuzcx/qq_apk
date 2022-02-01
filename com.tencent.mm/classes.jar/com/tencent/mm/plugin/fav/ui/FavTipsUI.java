package com.tencent.mm.plugin.fav.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;

public class FavTipsUI
  extends MMBaseActivity
{
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(106939);
    super.onCreate(paramBundle);
    paramBundle = new e.a(this);
    paramBundle.bDv(getString(q.i.favorite_intro_title));
    paramBundle.bDw(getString(q.i.favorite_intro_p_1) + "\n\n" + getString(q.i.favorite_intro_p_2));
    paramBundle.aER(q.i.favorite_intro_btn).c(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(106937);
        FavTipsUI.this.finish();
        AppMethodBeat.o(106937);
      }
    });
    paramBundle.e(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(106938);
        FavTipsUI.this.finish();
        AppMethodBeat.o(106938);
      }
    });
    paramBundle.jHH().show();
    AppMethodBeat.o(106939);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavTipsUI
 * JD-Core Version:    0.7.0.1
 */