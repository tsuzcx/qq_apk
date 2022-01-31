package com.tencent.kinda.framework.widget.base;

import android.app.Dialog;
import android.content.Context;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KProgressDialog;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.g;

public class MMKProgressDialogImpl
  implements KProgressDialog
{
  private Dialog mDialogImpl;
  private Dialog mPayProcessImpl;
  
  public void dismiss()
  {
    AppMethodBeat.i(144943);
    if (this.mDialogImpl != null) {
      this.mDialogImpl.dismiss();
    }
    if (this.mPayProcessImpl != null) {
      this.mPayProcessImpl.dismiss();
    }
    AppMethodBeat.o(144943);
  }
  
  public void showImpl(String paramString, boolean paramBoolean, VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(144941);
    paramString = KindaContext.get();
    if (paramString == null)
    {
      AppMethodBeat.o(144941);
      return;
    }
    this.mDialogImpl = g.a(paramString, paramBoolean, new MMKProgressDialogImpl.1(this, paramVoidCallback));
    AppMethodBeat.o(144941);
  }
  
  public void showPayProcessImpl(boolean paramBoolean, VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(144942);
    Context localContext = KindaContext.get();
    if (localContext == null)
    {
      AppMethodBeat.o(144942);
      return;
    }
    this.mPayProcessImpl = g.a(localContext, paramBoolean, new MMKProgressDialogImpl.2(this, paramVoidCallback));
    AppMethodBeat.o(144942);
  }
  
  public void showToast(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKProgressDialogImpl
 * JD-Core Version:    0.7.0.1
 */