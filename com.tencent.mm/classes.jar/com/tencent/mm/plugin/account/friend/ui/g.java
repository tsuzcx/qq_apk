package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.plugin.account.friend.a.h;
import com.tencent.mm.plugin.account.friend.a.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;

public final class g
  implements f
{
  private Context context;
  private ProgressDialog ecf;
  g.a fiC;
  private boolean fiD = true;
  String fiE = "";
  
  public g(Context paramContext, g.a parama)
  {
    this.context = paramContext;
    this.fiC = parama;
    this.fiD = true;
  }
  
  public g(Context paramContext, g.a parama, byte paramByte)
  {
    this.context = paramContext;
    this.fiC = parama;
    this.fiD = false;
  }
  
  public final void g(final int[] paramArrayOfInt)
  {
    com.tencent.mm.kernel.g.Dk().a(116, this);
    paramArrayOfInt = new ah(paramArrayOfInt);
    com.tencent.mm.kernel.g.Dk().a(paramArrayOfInt, 0);
    if (this.fiD)
    {
      Context localContext = this.context;
      this.context.getString(a.h.inviteqqfriends_title);
      this.ecf = h.b(localContext, this.context.getString(a.h.inviteqqfriends_inviting), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          com.tencent.mm.kernel.g.Dk().c(paramArrayOfInt);
          g.this.fiC.c(false, g.this.fiE);
        }
      });
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (paramm.getType() != 116) {
      return;
    }
    if (this.ecf != null)
    {
      this.ecf.dismiss();
      this.ecf = null;
    }
    com.tencent.mm.kernel.g.Dk().b(116, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      y.i("MicroMsg.SendInviteEmail", "dealSendInviteEmailSuccess");
      if (this.fiD)
      {
        h.a(this.context, a.h.inviteqqfriends_invite_success, a.h.app_tip, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            g.this.fiC.c(true, g.this.fiE);
          }
        });
        return;
      }
      this.fiC.c(true, this.fiE);
      return;
    }
    y.i("MicroMsg.SendInviteEmail", "dealSendInviteEmailFail");
    this.fiC.c(false, this.fiE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.g
 * JD-Core Version:    0.7.0.1
 */