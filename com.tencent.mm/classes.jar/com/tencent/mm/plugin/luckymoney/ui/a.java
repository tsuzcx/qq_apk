package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import androidx.appcompat.app.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.j;

public final class a
  extends e
{
  a.a KyS;
  
  public a(Context paramContext)
  {
    super(paramContext, a.j.CustomSheetStyle);
    AppMethodBeat.i(65412);
    bU();
    AppMethodBeat.o(65412);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(65414);
    if (this.KyS != null) {
      this.KyS.fXZ();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.a
 * JD-Core Version:    0.7.0.1
 */