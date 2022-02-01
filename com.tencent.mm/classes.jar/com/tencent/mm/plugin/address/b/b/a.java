package com.tencent.mm.plugin.address.b.b;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashSet;

public final class a
  implements g
{
  private HashSet<n> iyu;
  private HashSet<n> iyv;
  private Dialog tipDialog;
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(20764);
    if (this.iyv.contains(paramn))
    {
      this.iyv.remove(paramn);
      ad.d("MicroMsg.InvoiceNetSceneMgr", "has find scene ");
    }
    for (;;)
    {
      if ((this.iyv.isEmpty()) && (this.iyu.isEmpty()) && (this.tipDialog != null))
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      AppMethodBeat.o(20764);
      return;
      if (this.iyu.contains(paramn))
      {
        this.iyu.remove(paramn);
        ad.d("MicroMsg.InvoiceNetSceneMgr", "has find forcescenes ");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.address.b.b.a
 * JD-Core Version:    0.7.0.1
 */