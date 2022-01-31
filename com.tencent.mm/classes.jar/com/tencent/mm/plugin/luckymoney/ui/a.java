package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.e;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends e
{
  a.a oqT;
  
  public a(Context paramContext)
  {
    super(paramContext, 2131493185);
    AppMethodBeat.i(42555);
    eS();
    AppMethodBeat.o(42555);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(42557);
    if (this.oqT != null) {
      this.oqT.bNL();
    }
    AppMethodBeat.o(42557);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42556);
    super.onCreate(paramBundle);
    getWindow().setGravity(80);
    paramBundle = getWindow().getWindowManager().getDefaultDisplay();
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    localLayoutParams.width = paramBundle.getWidth();
    getWindow().setAttributes(localLayoutParams);
    AppMethodBeat.o(42556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.a
 * JD-Core Version:    0.7.0.1
 */