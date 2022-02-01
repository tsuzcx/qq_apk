package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.game.api.b;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.ui.base.h;

public final class a
  extends d
{
  public a(Context paramContext, String paramString1, String paramString2, d.a parama)
  {
    super(paramContext, paramString1, paramString2, parama);
  }
  
  protected final void cjQ()
  {
    AppMethodBeat.i(22165);
    h.a(this.context, 2131761321, 2131755998, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(22164);
        paramAnonymousDialogInterface = b.a.dSQ();
        if (paramAnonymousDialogInterface != null) {
          paramAnonymousDialogInterface.k(a.this.openId, z.aUb(), a.this.appId);
        }
        a.this.pdr.jZ(false);
        AppMethodBeat.o(22164);
      }
    });
    AppMethodBeat.o(22165);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.a
 * JD-Core Version:    0.7.0.1
 */