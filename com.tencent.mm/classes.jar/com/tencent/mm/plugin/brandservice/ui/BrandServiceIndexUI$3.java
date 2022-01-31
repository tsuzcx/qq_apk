package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class BrandServiceIndexUI$3
  implements MenuItem.OnMenuItemClickListener
{
  BrandServiceIndexUI$3(BrandServiceIndexUI paramBrandServiceIndexUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    y.v("MicroMsg.BrandService.BrandServiceIndexUI", "search btn was clicked.");
    paramMenuItem = new Intent(this.idj, BrandServiceLocalSearchUI.class);
    paramMenuItem.putExtra("is_return_result", BrandServiceIndexUI.a(this.idj));
    paramMenuItem.addFlags(67108864);
    this.idj.startActivityForResult(paramMenuItem, 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.BrandServiceIndexUI.3
 * JD-Core Version:    0.7.0.1
 */