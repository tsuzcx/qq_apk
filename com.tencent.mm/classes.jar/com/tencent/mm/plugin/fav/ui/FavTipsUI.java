package com.tencent.mm.plugin.fav.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.ui.widget.b.c.a;

public class FavTipsUI
  extends MMBaseActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74167);
    super.onCreate(paramBundle);
    paramBundle = new c.a(this);
    paramBundle.avm(getString(2131299744));
    paramBundle.avn(getString(2131299742) + "\n\n" + getString(2131299743));
    paramBundle.Ri(2131299741).a(new FavTipsUI.1(this));
    paramBundle.e(new FavTipsUI.2(this));
    paramBundle.aLZ().show();
    AppMethodBeat.o(74167);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavTipsUI
 * JD-Core Version:    0.7.0.1
 */