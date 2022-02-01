package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.plugin.account.friend.a.ak;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;

public final class g
  implements i
{
  private Context context;
  private ProgressDialog iLh;
  a khG;
  private boolean khH = true;
  String khI = "";
  
  public g(Context paramContext, a parama)
  {
    this.context = paramContext;
    this.khG = parama;
    this.khH = true;
  }
  
  public g(Context paramContext, a parama, byte paramByte)
  {
    this.context = paramContext;
    this.khG = parama;
    this.khH = false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(131311);
    if (paramq.getType() != 116)
    {
      AppMethodBeat.o(131311);
      return;
    }
    if (this.iLh != null)
    {
      this.iLh.dismiss();
      this.iLh = null;
    }
    com.tencent.mm.kernel.g.azz().b(116, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Log.i("MicroMsg.SendInviteEmail", "dealSendInviteEmailSuccess");
      if (this.khH)
      {
        h.a(this.context, 2131761820, 2131755998, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(131309);
            g.this.khG.i(true, g.this.khI);
            AppMethodBeat.o(131309);
          }
        });
        AppMethodBeat.o(131311);
        return;
      }
      this.khG.i(true, this.khI);
      AppMethodBeat.o(131311);
      return;
    }
    Log.i("MicroMsg.SendInviteEmail", "dealSendInviteEmailFail");
    this.khG.i(false, this.khI);
    AppMethodBeat.o(131311);
  }
  
  public final void t(final int[] paramArrayOfInt)
  {
    AppMethodBeat.i(131310);
    com.tencent.mm.kernel.g.azz().a(116, this);
    paramArrayOfInt = new ak(paramArrayOfInt);
    com.tencent.mm.kernel.g.azz().a(paramArrayOfInt, 0);
    if (this.khH)
    {
      Context localContext = this.context;
      this.context.getString(2131761823);
      this.iLh = h.a(localContext, this.context.getString(2131761821), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(131308);
          com.tencent.mm.kernel.g.azz().a(paramArrayOfInt);
          g.this.khG.i(false, g.this.khI);
          AppMethodBeat.o(131308);
        }
      });
    }
    AppMethodBeat.o(131310);
  }
  
  public static abstract interface a
  {
    public abstract void i(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.g
 * JD-Core Version:    0.7.0.1
 */