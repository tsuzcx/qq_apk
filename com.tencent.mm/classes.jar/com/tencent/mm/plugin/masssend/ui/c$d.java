package com.tencent.mm.plugin.masssend.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;

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
    y.v("MicroMsg.HistoryAdapter", "voice clicked:" + this.id);
    if (c.b(this.mbl) != null)
    {
      c.a(this.mbl, c.b(this.mbl).GW(this.id));
      this.mbl.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.c.d
 * JD-Core Version:    0.7.0.1
 */