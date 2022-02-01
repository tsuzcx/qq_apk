package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.account.friend.a.ak;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h;

public final class g
  implements com.tencent.mm.al.g
{
  private Context context;
  private ProgressDialog gUr;
  a inw;
  private boolean inx = true;
  String iny = "";
  
  public g(Context paramContext, a parama)
  {
    this.context = paramContext;
    this.inw = parama;
    this.inx = true;
  }
  
  public g(Context paramContext, a parama, byte paramByte)
  {
    this.context = paramContext;
    this.inw = parama;
    this.inx = false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(131311);
    if (paramn.getType() != 116)
    {
      AppMethodBeat.o(131311);
      return;
    }
    if (this.gUr != null)
    {
      this.gUr.dismiss();
      this.gUr = null;
    }
    com.tencent.mm.kernel.g.aeS().b(116, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ad.i("MicroMsg.SendInviteEmail", "dealSendInviteEmailSuccess");
      if (this.inx)
      {
        h.a(this.context, 2131760375, 2131755906, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(131309);
            g.this.inw.f(true, g.this.iny);
            AppMethodBeat.o(131309);
          }
        });
        AppMethodBeat.o(131311);
        return;
      }
      this.inw.f(true, this.iny);
      AppMethodBeat.o(131311);
      return;
    }
    ad.i("MicroMsg.SendInviteEmail", "dealSendInviteEmailFail");
    this.inw.f(false, this.iny);
    AppMethodBeat.o(131311);
  }
  
  public final void q(final int[] paramArrayOfInt)
  {
    AppMethodBeat.i(131310);
    com.tencent.mm.kernel.g.aeS().a(116, this);
    paramArrayOfInt = new ak(paramArrayOfInt);
    com.tencent.mm.kernel.g.aeS().a(paramArrayOfInt, 0);
    if (this.inx)
    {
      Context localContext = this.context;
      this.context.getString(2131760378);
      this.gUr = h.b(localContext, this.context.getString(2131760376), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(131308);
          com.tencent.mm.kernel.g.aeS().a(paramArrayOfInt);
          g.this.inw.f(false, g.this.iny);
          AppMethodBeat.o(131308);
        }
      });
    }
    AppMethodBeat.o(131310);
  }
  
  public static abstract interface a
  {
    public abstract void f(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.g
 * JD-Core Version:    0.7.0.1
 */