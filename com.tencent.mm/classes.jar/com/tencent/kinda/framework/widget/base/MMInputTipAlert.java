package com.tencent.kinda.framework.widget.base;

import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KInputTipAlert;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.kinda.gen.VoidStringCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.view.a;
import com.tencent.mm.sdk.platformtools.ab;

public class MMInputTipAlert
  implements KInputTipAlert
{
  public String TAG = "MMInputTipAlert";
  
  public void showInputAlertImpl(String paramString1, String paramString2, String paramString3, VoidStringCallback paramVoidStringCallback, VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(144840);
    ab.i(this.TAG, "MMInputTipAlert");
    a.a(KindaContext.get(), paramString1, paramString2, paramString3, 100, new MMInputTipAlert.1(this, paramVoidStringCallback), new MMInputTipAlert.2(this, paramVoidCallback));
    AppMethodBeat.o(144840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMInputTipAlert
 * JD-Core Version:    0.7.0.1
 */