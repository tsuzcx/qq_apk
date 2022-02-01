package com.tencent.mm.plugin.address.b.b;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashSet;

public final class a
  implements f
{
  private HashSet<n> jrG;
  private HashSet<n> jrH;
  private Dialog tipDialog;
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(20764);
    if (this.jrH.contains(paramn))
    {
      this.jrH.remove(paramn);
      ad.d("MicroMsg.InvoiceNetSceneMgr", "has find scene ");
    }
    for (;;)
    {
      if ((this.jrH.isEmpty()) && (this.jrG.isEmpty()) && (this.tipDialog != null))
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      AppMethodBeat.o(20764);
      return;
      if (this.jrG.contains(paramn))
      {
        this.jrG.remove(paramn);
        ad.d("MicroMsg.InvoiceNetSceneMgr", "has find forcescenes ");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.address.b.b.a
 * JD-Core Version:    0.7.0.1
 */