package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.plugin.account.friend.model.ah;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.k;

public final class g
  implements com.tencent.mm.am.h
{
  private Context context;
  private ProgressDialog osY;
  private a pVN;
  private boolean pVO = true;
  String pVP = "";
  
  public g(Context paramContext, a parama)
  {
    this.context = paramContext;
    this.pVN = parama;
    this.pVO = true;
  }
  
  public g(Context paramContext, a parama, byte paramByte)
  {
    this.context = paramContext;
    this.pVN = parama;
    this.pVO = false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(131311);
    if (paramp.getType() != 116)
    {
      AppMethodBeat.o(131311);
      return;
    }
    if (this.osY != null)
    {
      this.osY.dismiss();
      this.osY = null;
    }
    com.tencent.mm.kernel.h.aZW().b(116, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Log.i("MicroMsg.SendInviteEmail", "dealSendInviteEmailSuccess");
      if (this.pVO)
      {
        k.a(this.context, a.g.inviteqqfriends_invite_success, a.g.app_tip, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(131309);
            g.b(g.this).y(true, g.a(g.this));
            AppMethodBeat.o(131309);
          }
        });
        AppMethodBeat.o(131311);
        return;
      }
      this.pVN.y(true, this.pVP);
      AppMethodBeat.o(131311);
      return;
    }
    Log.i("MicroMsg.SendInviteEmail", "dealSendInviteEmailFail");
    this.pVN.y(false, this.pVP);
    AppMethodBeat.o(131311);
  }
  
  public final void v(final int[] paramArrayOfInt)
  {
    AppMethodBeat.i(131310);
    com.tencent.mm.kernel.h.aZW().a(116, this);
    paramArrayOfInt = new ah(paramArrayOfInt);
    com.tencent.mm.kernel.h.aZW().a(paramArrayOfInt, 0);
    if (this.pVO)
    {
      Context localContext = this.context;
      this.context.getString(a.g.inviteqqfriends_title);
      this.osY = k.a(localContext, this.context.getString(a.g.inviteqqfriends_inviting), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(131308);
          com.tencent.mm.kernel.h.aZW().a(paramArrayOfInt);
          g.b(g.this).y(false, g.a(g.this));
          AppMethodBeat.o(131308);
        }
      });
    }
    AppMethodBeat.o(131310);
  }
  
  public static abstract interface a
  {
    public abstract void y(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.g
 * JD-Core Version:    0.7.0.1
 */