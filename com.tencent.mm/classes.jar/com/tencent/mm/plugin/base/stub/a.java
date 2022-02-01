package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.game.api.b;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.ui.base.k;

public final class a
  extends d
{
  public a(Context paramContext, String paramString1, String paramString2, d.a parama)
  {
    super(paramContext, paramString1, paramString2, parama);
  }
  
  protected final void cZS()
  {
    AppMethodBeat.i(22165);
    k.a(this.context, R.l.gJa, R.l.app_tip, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(22164);
        paramAnonymousDialogInterface = b.a.fCn();
        if (paramAnonymousDialogInterface != null) {
          paramAnonymousDialogInterface.p(a.this.openId, z.bAP(), a.this.appId);
        }
        a.this.vrh.mC(false);
        AppMethodBeat.o(22164);
      }
    });
    AppMethodBeat.o(22165);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.a
 * JD-Core Version:    0.7.0.1
 */