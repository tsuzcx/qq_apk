package com.tencent.mm.plugin.account.model;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.ui.base.p;

public final class c
  implements com.tencent.mm.ak.g, h
{
  public Context context;
  public n dcV;
  private ao handler;
  public a iOk;
  public p tipDialog;
  
  public c(Context paramContext, a parama)
  {
    AppMethodBeat.i(127826);
    this.handler = new ao(Looper.getMainLooper());
    this.context = paramContext;
    this.iOk = parama;
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
      com.tencent.mm.kernel.g.agi().b(139, this);
      if ((paramInt2 != 0) || (paramInt1 != 0)) {
        break label87;
      }
      this.iOk.aQq();
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
      com.tencent.mm.kernel.g.agi().b(138, this);
      break;
      label87:
      ac.e("MicroMsg.DoInit", "do init failed, err=" + paramInt1 + "," + paramInt2);
      this.iOk.aQq();
    }
  }
  
  public static abstract interface a
  {
    public abstract void aQq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.c
 * JD-Core Version:    0.7.0.1
 */