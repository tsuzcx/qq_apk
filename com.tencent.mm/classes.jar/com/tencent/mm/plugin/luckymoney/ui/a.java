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
  a urJ;
  
  public a(Context paramContext)
  {
    super(paramContext, 2131820861);
    AppMethodBeat.i(65412);
    gt();
    AppMethodBeat.o(65412);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(65414);
    if (this.urJ != null) {
      this.urJ.cZN();
    }
    AppMethodBeat.o(65414);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65413);
    super.onCreate(paramBundle);
    getWindow().setGravity(80);
    paramBundle = getWindow().getWindowManager().getDefaultDisplay();
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    localLayoutParams.width = paramBundle.getWidth();
    getWindow().setAttributes(localLayoutParams);
    AppMethodBeat.o(65413);
  }
  
  static abstract interface a
  {
    public abstract void cZN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.a
 * JD-Core Version:    0.7.0.1
 */