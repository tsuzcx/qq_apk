package com.tencent.mm.app.plugin;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.protocal.protobuf.ecp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.w;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
  implements i
{
  String Ln;
  private a fgh;
  boolean fgi;
  Runnable fgj;
  Runnable fgk;
  private AtomicBoolean fgl;
  Context mContext;
  int mScene;
  private s tipDialog;
  
  public a(Context paramContext, int paramInt, String paramString, a parama)
  {
    AppMethodBeat.i(292335);
    this.fgl = new AtomicBoolean(false);
    this.mContext = paramContext;
    this.fgh = parama;
    this.tipDialog = null;
    this.mScene = paramInt;
    this.Ln = paramString;
    AppMethodBeat.o(292335);
  }
  
  private void a(ecp paramecp)
  {
    AppMethodBeat.i(292336);
    if (this.fgh != null) {
      this.fgh.a(this.mContext, paramecp);
    }
    AppMethodBeat.o(292336);
  }
  
  private void dismissDialog()
  {
    AppMethodBeat.i(292337);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    AppMethodBeat.o(292337);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(292338);
    Log.d("MicroMsg.AddContact", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2 + "," + paramString);
    if ((!(paramq instanceof com.tencent.mm.app.plugin.c.a)) || (paramq.getType() != 4790))
    {
      Log.w("MicroMsg.AddContact", "not expected scene,  type = " + paramq.getType());
      AppMethodBeat.o(292338);
      return;
    }
    if (this.fgi)
    {
      if (this.fgk != null) {
        MMHandlerThread.removeRunnable(this.fgk);
      }
      dismissDialog();
    }
    MMHandlerThread.removeRunnable(this.fgj);
    com.tencent.mm.kernel.h.aHF().kcd.b(4790, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      a((ecp)d.c.b(((com.tencent.mm.app.plugin.c.a)paramq).rr.lBS));
      AppMethodBeat.o(292338);
      return;
    }
    if (!Util.isNullOrNil(paramString)) {
      com.tencent.mm.ui.base.h.c(this.mContext, paramString, "", true);
    }
    a(null);
    AppMethodBeat.o(292338);
  }
  
  public static abstract interface a
  {
    public abstract void a(Context paramContext, ecp paramecp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.plugin.a
 * JD-Core Version:    0.7.0.1
 */