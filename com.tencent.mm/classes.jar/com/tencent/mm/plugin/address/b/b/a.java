package com.tencent.mm.plugin.address.b.b;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;

public final class a
  implements i
{
  private HashSet<q> ksO;
  private HashSet<q> ksP;
  private Dialog tipDialog;
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(20764);
    if (this.ksP.contains(paramq))
    {
      this.ksP.remove(paramq);
      Log.d("MicroMsg.InvoiceNetSceneMgr", "has find scene ");
    }
    for (;;)
    {
      if ((this.ksP.isEmpty()) && (this.ksO.isEmpty()) && (this.tipDialog != null))
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      AppMethodBeat.o(20764);
      return;
      if (this.ksO.contains(paramq))
      {
        this.ksO.remove(paramq);
        Log.d("MicroMsg.InvoiceNetSceneMgr", "has find forcescenes ");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.b.b.a
 * JD-Core Version:    0.7.0.1
 */