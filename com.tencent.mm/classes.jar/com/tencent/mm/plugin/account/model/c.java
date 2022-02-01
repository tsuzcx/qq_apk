package com.tencent.mm.plugin.account.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.base.p;

public final class c
  implements f, com.tencent.mm.al.g
{
  public Context context;
  public n dor;
  private ap handler;
  public a jht;
  public p tipDialog;
  
  public c(Context paramContext, a parama)
  {
    AppMethodBeat.i(127826);
    this.handler = new ap(Looper.getMainLooper());
    this.context = paramContext;
    this.jht = parama;
    AppMethodBeat.o(127826);
  }
  
  public final void a(final int paramInt1, int paramInt2, n paramn)
  {
    AppMethodBeat.i(127827);
    if (paramInt2 != 0) {}
    for (paramInt1 = (int)(paramInt1 * 100L / paramInt2);; paramInt1 = 0)
    {
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(127825);
          if (c.this.tipDialog != null) {
            c.this.tipDialog.setMessage(c.this.context.getString(2131755805) + paramInt1 + "%");
          }
          AppMethodBeat.o(127825);
        }
      });
      AppMethodBeat.o(127827);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(127828);
    if (paramn.getType() == 139)
    {
      com.tencent.mm.kernel.g.aiU().b(139, this);
      if ((paramInt2 != 0) || (paramInt1 != 0)) {
        break label87;
      }
      this.jht.aTC();
    }
    for (;;)
    {
      if (this.tipDialog != null) {
        this.tipDialog.dismiss();
      }
      AppMethodBeat.o(127828);
      return;
      if (paramn.getType() != 138) {
        break;
      }
      com.tencent.mm.kernel.g.aiU().b(138, this);
      break;
      label87:
      ad.e("MicroMsg.DoInit", "do init failed, err=" + paramInt1 + "," + paramInt2);
      this.jht.aTC();
    }
  }
  
  public static abstract interface a
  {
    public abstract void aTC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.c
 * JD-Core Version:    0.7.0.1
 */