package com.tencent.mm.plugin.exdevice.g.a;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;

final class e$3
  implements n.d
{
  e$3(MMActivity paramMMActivity) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(23508);
    if (paramMenuItem.getItemId() == 0)
    {
      paramMenuItem = this.pBh;
      Intent localIntent = new Intent();
      localIntent.putExtra("query_source_type", 9);
      localIntent.putExtra("query_media_type", 1);
      localIntent.putExtra("max_select_count", 1);
      d.b(paramMenuItem, "gallery", ".ui.AlbumPreviewUI", localIntent, 1001);
    }
    AppMethodBeat.o(23508);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.e.3
 * JD-Core Version:    0.7.0.1
 */