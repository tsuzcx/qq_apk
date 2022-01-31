package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.ui.base.h;

final class f$1
  implements DialogInterface.OnClickListener
{
  f$1(f paramf, EditText paramEditText) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(13750);
    this.gwn.gwf = null;
    paramDialogInterface = this.gwn;
    Object localObject = this.gwm.getText().toString().trim();
    paramDialogInterface.Yj();
    paramDialogInterface.gwh = ((String)localObject);
    localObject = paramDialogInterface.context;
    paramDialogInterface.context.getString(2131297087);
    paramDialogInterface.gwe = h.b((Context)localObject, paramDialogInterface.context.getString(2131303128), true, new f.3(paramDialogInterface));
    g.Rc().a(new ac(5, paramDialogInterface.gwh, "", "", "", false, 1), 0);
    AppMethodBeat.o(13750);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.f.1
 * JD-Core Version:    0.7.0.1
 */