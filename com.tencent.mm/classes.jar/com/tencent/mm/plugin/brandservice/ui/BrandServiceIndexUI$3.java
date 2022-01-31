package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class BrandServiceIndexUI$3
  implements MenuItem.OnMenuItemClickListener
{
  BrandServiceIndexUI$3(BrandServiceIndexUI paramBrandServiceIndexUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(13916);
    ab.v("MicroMsg.BrandService.BrandServiceIndexUI", "search btn was clicked.");
    paramMenuItem = new Intent(this.jTX, BrandServiceLocalSearchUI.class);
    paramMenuItem.putExtra("is_return_result", BrandServiceIndexUI.a(this.jTX));
    paramMenuItem.addFlags(67108864);
    this.jTX.startActivityForResult(paramMenuItem, 1);
    AppMethodBeat.o(13916);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.BrandServiceIndexUI.3
 * JD-Core Version:    0.7.0.1
 */