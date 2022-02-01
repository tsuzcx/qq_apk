package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.account.friend.a.ak;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.h;

public final class g
  implements f
{
  private Context context;
  private ProgressDialog hQb;
  a jjE;
  private boolean jjF = true;
  String jjG = "";
  
  public g(Context paramContext, a parama)
  {
    this.context = paramContext;
    this.jjE = parama;
    this.jjF = true;
  }
  
  public g(Context paramContext, a parama, byte paramByte)
  {
    this.context = paramContext;
    this.jjE = parama;
    this.jjF = false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(131311);
    if (paramn.getType() != 116)
    {
      AppMethodBeat.o(131311);
      return;
    }
    if (this.hQb != null)
    {
      this.hQb.dismiss();
      this.hQb = null;
    }
    com.tencent.mm.kernel.g.ajj().b(116, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ae.i("MicroMsg.SendInviteEmail", "dealSendInviteEmailSuccess");
      if (this.jjF)
      {
        h.a(this.context, 2131760375, 2131755906, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(131309);
            g.this.jjE.h(true, g.this.jjG);
            AppMethodBeat.o(131309);
          }
        });
        AppMethodBeat.o(131311);
        return;
      }
      this.jjE.h(true, this.jjG);
      AppMethodBeat.o(131311);
      return;
    }
    ae.i("MicroMsg.SendInviteEmail", "dealSendInviteEmailFail");
    this.jjE.h(false, this.jjG);
    AppMethodBeat.o(131311);
  }
  
  public final void r(final int[] paramArrayOfInt)
  {
    AppMethodBeat.i(131310);
    com.tencent.mm.kernel.g.ajj().a(116, this);
    paramArrayOfInt = new ak(paramArrayOfInt);
    com.tencent.mm.kernel.g.ajj().a(paramArrayOfInt, 0);
    if (this.jjF)
    {
      Context localContext = this.context;
      this.context.getString(2131760378);
      this.hQb = h.b(localContext, this.context.getString(2131760376), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(131308);
          com.tencent.mm.kernel.g.ajj().a(paramArrayOfInt);
          g.this.jjE.h(false, g.this.jjG);
          AppMethodBeat.o(131308);
        }
      });
    }
    AppMethodBeat.o(131310);
  }
  
  public static abstract interface a
  {
    public abstract void h(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.g
 * JD-Core Version:    0.7.0.1
 */