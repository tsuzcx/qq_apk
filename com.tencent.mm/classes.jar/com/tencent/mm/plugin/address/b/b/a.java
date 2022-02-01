package com.tencent.mm.plugin.address.b.b;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashSet;

public final class a
  implements g
{
  private HashSet<n> iYx;
  private HashSet<n> iYy;
  private Dialog tipDialog;
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(20764);
    if (this.iYy.contains(paramn))
    {
      this.iYy.remove(paramn);
      ac.d("MicroMsg.InvoiceNetSceneMgr", "has find scene ");
    }
    for (;;)
    {
      if ((this.iYy.isEmpty()) && (this.iYx.isEmpty()) && (this.tipDialog != null))
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      AppMethodBeat.o(20764);
      return;
      if (this.iYx.contains(paramn))
      {
        this.iYx.remove(paramn);
        ac.d("MicroMsg.InvoiceNetSceneMgr", "has find forcescenes ");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.address.b.b.a
 * JD-Core Version:    0.7.0.1
 */