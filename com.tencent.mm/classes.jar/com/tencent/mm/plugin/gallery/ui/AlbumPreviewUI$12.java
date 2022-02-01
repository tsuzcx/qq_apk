package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.a.a;
import com.tencent.mm.plugin.gallery.model.s;
import com.tencent.mm.sdk.platformtools.ad;

final class AlbumPreviewUI$12
  implements MenuItem.OnMenuItemClickListener
{
  AlbumPreviewUI$12(AlbumPreviewUI paramAlbumPreviewUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(164796);
    int i = paramMenuItem.getItemId();
    ad.d("MicroMsg.AlbumPreviewUI", "mId: %d.", new Object[] { Integer.valueOf(i) });
    if (1 == i)
    {
      ad.i("MicroMsg.AlbumPreviewUI", "go smart gallery.");
      a.a.rzX.rzK = 1;
      s.czT().dL(this.rIn.rHw.rGV);
      paramMenuItem = new Intent(this.rIn, SmartGalleryUI.class);
      paramMenuItem.putExtra("select_type_tag", 2);
      paramMenuItem.putExtras(this.rIn.getIntent());
      paramMenuItem.putExtra("send_raw_img", this.rIn.nMQ);
      this.rIn.startActivityForResult(paramMenuItem, 4382);
      AppMethodBeat.o(164796);
      return true;
    }
    boolean bool = this.rIn.cqQ();
    AppMethodBeat.o(164796);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.12
 * JD-Core Version:    0.7.0.1
 */