package com.tencent.mm.plugin.address.b.b;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashSet;

public final class a
  implements f
{
  private HashSet<n> juA;
  private HashSet<n> juz;
  private Dialog tipDialog;
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(20764);
    if (this.juA.contains(paramn))
    {
      this.juA.remove(paramn);
      ae.d("MicroMsg.InvoiceNetSceneMgr", "has find scene ");
    }
    for (;;)
    {
      if ((this.juA.isEmpty()) && (this.juz.isEmpty()) && (this.tipDialog != null))
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      AppMethodBeat.o(20764);
      return;
      if (this.juz.contains(paramn))
      {
        this.juz.remove(paramn);
        ae.d("MicroMsg.InvoiceNetSceneMgr", "has find forcescenes ");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.address.b.b.a
 * JD-Core Version:    0.7.0.1
 */