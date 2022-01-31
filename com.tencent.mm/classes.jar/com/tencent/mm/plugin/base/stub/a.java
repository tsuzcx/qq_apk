package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.game.a.a.a;
import com.tencent.mm.ui.base.h;

public final class a
  extends d
{
  public a(Context paramContext, String paramString1, String paramString2, d.a parama)
  {
    super(paramContext, paramString1, paramString2, parama);
  }
  
  protected final void UF()
  {
    h.a(this.context, R.l.game_openid_checker_fail_msg, R.l.app_tip, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface = a.a.aYi();
        if (paramAnonymousDialogInterface != null) {
          paramAnonymousDialogInterface.k(a.this.openId, q.Gm(), a.this.appId);
        }
        a.this.hRU.em(false);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.a
 * JD-Core Version:    0.7.0.1
 */