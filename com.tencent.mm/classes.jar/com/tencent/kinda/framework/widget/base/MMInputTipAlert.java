package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KInputTipAlert;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.kinda.gen.VoidStringCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.view.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h.b;

public class MMInputTipAlert
  implements KInputTipAlert
{
  public String TAG = "MMInputTipAlert";
  
  public void showInputAlertImpl(String paramString1, String paramString2, String paramString3, final VoidStringCallback paramVoidStringCallback, final VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(18991);
    Log.i(this.TAG, "MMInputTipAlert");
    Context localContext = KindaContext.get();
    if (localContext == null)
    {
      Log.e(this.TAG, "MMInputTipAlert showInputAlertImpl() KindaContext.get() return null!");
      AppMethodBeat.o(18991);
      return;
    }
    a.a(localContext, paramString1, paramString2, paramString3, 100, new h.b()new DialogInterface.OnClickListener
    {
      public boolean onFinish(CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(18989);
        Log.i(MMInputTipAlert.this.TAG, "ok ".concat(String.valueOf(paramAnonymousCharSequence)));
        paramVoidStringCallback.call(String.valueOf(paramAnonymousCharSequence));
        AppMethodBeat.o(18989);
        return false;
      }
    }, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(18990);
        Log.i(MMInputTipAlert.this.TAG, "cancel " + paramVoidCallback);
        paramVoidCallback.call();
        AppMethodBeat.o(18990);
      }
    });
    AppMethodBeat.o(18991);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMInputTipAlert
 * JD-Core Version:    0.7.0.1
 */