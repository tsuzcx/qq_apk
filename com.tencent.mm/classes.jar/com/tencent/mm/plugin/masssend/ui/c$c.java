package com.tencent.mm.plugin.masssend.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.masssend.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.s;

final class c$c
  implements View.OnClickListener
{
  private String fileName;
  private int length;
  private int size;
  private int videoSource;
  
  public c$c(c paramc, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.fileName = paramString;
    this.videoSource = paramInt1;
    this.length = paramInt3;
    this.size = paramInt2;
  }
  
  public final void onClick(View paramView)
  {
    au.Hx();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      s.gM(c.a(this.mbl));
      return;
    }
    if (this.videoSource == 2) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      o.Sr();
      boolean bool2 = r.nL(t.nS(this.fileName));
      y.i("MicroMsg.HistoryAdapter", "video clicked, path:%s, isExport:%b, typeQt:%b", new Object[] { this.fileName, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      a.eUR.a(bool1, bool2, c.a(this.mbl), this.fileName, this.length, this.size);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.c.c
 * JD-Core Version:    0.7.0.1
 */