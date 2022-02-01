package com.tencent.mm.plugin.account.model;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class c
  implements i, j
{
  public Context context;
  public com.tencent.mm.ak.q dGJ;
  private MMHandler handler;
  public a kio;
  public com.tencent.mm.ui.base.q tipDialog;
  
  public c(Context paramContext, a parama)
  {
    AppMethodBeat.i(127826);
    this.handler = new MMHandler(Looper.getMainLooper());
    this.context = paramContext;
    this.kio = parama;
    AppMethodBeat.o(127826);
  }
  
  public final void a(final int paramInt1, int paramInt2, com.tencent.mm.ak.q paramq)
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
            c.this.tipDialog.setMessage(c.this.context.getString(2131755887) + paramInt1 + "%");
          }
          AppMethodBeat.o(127825);
        }
      });
      AppMethodBeat.o(127827);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(127828);
    if (paramq.getType() == 139)
    {
      g.azz().b(139, this);
      if ((paramInt2 != 0) || (paramInt1 != 0)) {
        break label87;
      }
      this.kio.boN();
    }
    for (;;)
    {
      if (this.tipDialog != null) {
        this.tipDialog.dismiss();
      }
      AppMethodBeat.o(127828);
      return;
      if (paramq.getType() != 138) {
        break;
      }
      g.azz().b(138, this);
      break;
      label87:
      Log.e("MicroMsg.DoInit", "do init failed, err=" + paramInt1 + "," + paramInt2);
      this.kio.boN();
    }
  }
  
  public static abstract interface a
  {
    public abstract void boN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.c
 * JD-Core Version:    0.7.0.1
 */