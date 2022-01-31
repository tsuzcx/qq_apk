package com.tencent.mm.plugin.masssend.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.plugin.masssend.a;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;

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
    AppMethodBeat.i(22785);
    aw.aaz();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.t.ii(c.a(this.oBN));
      AppMethodBeat.o(22785);
      return;
    }
    if (this.videoSource == 2) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      o.alE();
      boolean bool2 = r.uY(com.tencent.mm.modelvideo.t.vf(this.fileName));
      ab.i("MicroMsg.HistoryAdapter", "video clicked, path:%s, isExport:%b, typeQt:%b", new Object[] { this.fileName, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      a.gmO.a(bool1, bool2, c.a(this.oBN), this.fileName, this.length, this.size);
      AppMethodBeat.o(22785);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.c.c
 * JD-Core Version:    0.7.0.1
 */