package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.plugin.account.friend.a.ak;
import com.tencent.mm.sdk.platformtools.Log;

public final class g
  implements i
{
  private Context context;
  private ProgressDialog lBo;
  private a mZf;
  private boolean mZg = true;
  String mZh = "";
  
  public g(Context paramContext, a parama)
  {
    this.context = paramContext;
    this.mZf = parama;
    this.mZg = true;
  }
  
  public g(Context paramContext, a parama, byte paramByte)
  {
    this.context = paramContext;
    this.mZf = parama;
    this.mZg = false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(131311);
    if (paramq.getType() != 116)
    {
      AppMethodBeat.o(131311);
      return;
    }
    if (this.lBo != null)
    {
      this.lBo.dismiss();
      this.lBo = null;
    }
    com.tencent.mm.kernel.h.aGY().b(116, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Log.i("MicroMsg.SendInviteEmail", "dealSendInviteEmailSuccess");
      if (this.mZg)
      {
        com.tencent.mm.ui.base.h.a(this.context, a.g.inviteqqfriends_invite_success, a.g.app_tip, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(131309);
            g.b(g.this).l(true, g.a(g.this));
            AppMethodBeat.o(131309);
          }
        });
        AppMethodBeat.o(131311);
        return;
      }
      this.mZf.l(true, this.mZh);
      AppMethodBeat.o(131311);
      return;
    }
    Log.i("MicroMsg.SendInviteEmail", "dealSendInviteEmailFail");
    this.mZf.l(false, this.mZh);
    AppMethodBeat.o(131311);
  }
  
  public final void t(final int[] paramArrayOfInt)
  {
    AppMethodBeat.i(131310);
    com.tencent.mm.kernel.h.aGY().a(116, this);
    paramArrayOfInt = new ak(paramArrayOfInt);
    com.tencent.mm.kernel.h.aGY().a(paramArrayOfInt, 0);
    if (this.mZg)
    {
      Context localContext = this.context;
      this.context.getString(a.g.inviteqqfriends_title);
      this.lBo = com.tencent.mm.ui.base.h.a(localContext, this.context.getString(a.g.inviteqqfriends_inviting), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(131308);
          com.tencent.mm.kernel.h.aGY().a(paramArrayOfInt);
          g.b(g.this).l(false, g.a(g.this));
          AppMethodBeat.o(131308);
        }
      });
    }
    AppMethodBeat.o(131310);
  }
  
  public static abstract interface a
  {
    public abstract void l(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.g
 * JD-Core Version:    0.7.0.1
 */