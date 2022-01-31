package com.tencent.mm.plugin.address.b.b;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashSet;

public final class a
  implements f
{
  private HashSet<m> gKK;
  private HashSet<m> gKL;
  private Dialog gKM;
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(16721);
    if (this.gKL.contains(paramm))
    {
      this.gKL.remove(paramm);
      ab.d("MicroMsg.InvoiceNetSceneMgr", "has find scene ");
    }
    for (;;)
    {
      if ((this.gKL.isEmpty()) && (this.gKK.isEmpty()) && (this.gKM != null))
      {
        this.gKM.dismiss();
        this.gKM = null;
      }
      AppMethodBeat.o(16721);
      return;
      if (this.gKK.contains(paramm))
      {
        this.gKK.remove(paramm);
        ab.d("MicroMsg.InvoiceNetSceneMgr", "has find forcescenes ");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.address.b.b.a
 * JD-Core Version:    0.7.0.1
 */