package com.tencent.mm.plugin.account.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Looper;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  implements f, com.tencent.mm.ah.g
{
  public m bJk;
  public Context context;
  public c.a fjr;
  private ah handler = new ah(Looper.getMainLooper());
  public com.tencent.mm.ui.base.p tipDialog;
  
  public c(Context paramContext, c.a parama)
  {
    this.context = paramContext;
    this.fjr = parama;
  }
  
  public final void a(int paramInt1, int paramInt2, m paramm)
  {
    if (paramInt2 != 0) {}
    for (paramInt1 = (int)(paramInt1 * 100L / paramInt2);; paramInt1 = 0)
    {
      this.handler.post(new c.2(this, paramInt1));
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (paramm.getType() == 139)
    {
      com.tencent.mm.kernel.g.Dk().b(139, this);
      if ((paramInt2 != 0) || (paramInt1 != 0)) {
        break label77;
      }
      this.fjr.Xw();
    }
    for (;;)
    {
      if (this.tipDialog != null) {
        this.tipDialog.dismiss();
      }
      return;
      if (paramm.getType() != 138) {
        break;
      }
      com.tencent.mm.kernel.g.Dk().b(138, this);
      break;
      label77:
      y.e("MicroMsg.DoInit", "do init failed, err=" + paramInt1 + "," + paramInt2);
      this.fjr.Xw();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.c
 * JD-Core Version:    0.7.0.1
 */