package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.masssend.a;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.e;

final class c$a
  implements View.OnClickListener
{
  private String fileName;
  private int oBj;
  
  public c$a(c paramc, String paramString, int paramInt)
  {
    this.fileName = paramString;
    this.oBj = paramInt;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(22783);
    ab.v("MicroMsg.HistoryAdapter", "image clicked:" + this.fileName);
    aw.aaz();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      t.ii(c.a(this.oBN));
      AppMethodBeat.o(22783);
      return;
    }
    paramView = new StringBuilder();
    aw.aaz();
    paramView = com.tencent.mm.model.c.YK() + this.fileName;
    if ((paramView == null) || (paramView.equals("")) || (!e.cN(paramView)))
    {
      ab.d("MicroMsg.HistoryAdapter", "showImg : imgPath is null");
      AppMethodBeat.o(22783);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_compress_type", this.oBj);
    localIntent.putExtra("key_favorite", false);
    localIntent.putExtra("key_image_path", paramView);
    a.gmO.d(c.a(this.oBN), localIntent);
    AppMethodBeat.o(22783);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.c.a
 * JD-Core Version:    0.7.0.1
 */