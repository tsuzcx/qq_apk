package com.tencent.mm.plugin.address.b.b;

import android.app.Dialog;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;

public final class a
  implements f
{
  private HashSet<m> fti;
  private HashSet<m> ftj;
  private Dialog ftk;
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (this.ftj.contains(paramm))
    {
      this.ftj.remove(paramm);
      y.d("MicroMsg.InvoiceNetSceneMgr", "has find scene ");
    }
    for (;;)
    {
      if ((this.ftj.isEmpty()) && (this.fti.isEmpty()) && (this.ftk != null))
      {
        this.ftk.dismiss();
        this.ftk = null;
      }
      return;
      if (this.fti.contains(paramm))
      {
        this.fti.remove(paramm);
        y.d("MicroMsg.InvoiceNetSceneMgr", "has find forcescenes ");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.address.b.b.a
 * JD-Core Version:    0.7.0.1
 */