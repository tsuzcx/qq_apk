package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.masssend.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.vfs.e;

final class c$a
  implements View.OnClickListener
{
  private String fileName;
  private int maK;
  
  public c$a(c paramc, String paramString, int paramInt)
  {
    this.fileName = paramString;
    this.maK = paramInt;
  }
  
  public final void onClick(View paramView)
  {
    y.v("MicroMsg.HistoryAdapter", "image clicked:" + this.fileName);
    au.Hx();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      s.gM(c.a(this.mbl));
      return;
    }
    paramView = new StringBuilder();
    au.Hx();
    paramView = com.tencent.mm.model.c.FG() + this.fileName;
    if ((paramView == null) || (paramView.equals("")) || (!e.bK(paramView)))
    {
      y.d("MicroMsg.HistoryAdapter", "showImg : imgPath is null");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_compress_type", this.maK);
    localIntent.putExtra("key_favorite", false);
    localIntent.putExtra("key_image_path", paramView);
    a.eUR.b(c.a(this.mbl), localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.c.a
 * JD-Core Version:    0.7.0.1
 */