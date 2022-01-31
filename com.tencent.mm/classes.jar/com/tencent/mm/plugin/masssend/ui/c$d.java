package com.tencent.mm.plugin.masssend.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class c$d
  implements View.OnClickListener
{
  private String id;
  
  public c$d(c paramc, String paramString)
  {
    this.id = paramString;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(22786);
    ab.v("MicroMsg.HistoryAdapter", "voice clicked:" + this.id);
    if (c.b(this.oBN) != null)
    {
      c.a(this.oBN, c.b(this.oBN).SH(this.id));
      this.oBN.notifyDataSetChanged();
    }
    AppMethodBeat.o(22786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.c.d
 * JD-Core Version:    0.7.0.1
 */