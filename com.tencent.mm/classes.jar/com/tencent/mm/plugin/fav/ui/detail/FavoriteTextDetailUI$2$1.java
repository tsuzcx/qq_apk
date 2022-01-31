package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class FavoriteTextDetailUI$2$1
  implements n.c
{
  FavoriteTextDetailUI$2$1(FavoriteTextDetailUI.2 param2) {}
  
  public final void a(l paraml)
  {
    if (this.kgr.kgq.getIntent().getBooleanExtra("key_detail_can_share_to_friend", true)) {
      paraml.e(2, this.kgr.kgq.getString(n.i.favorite_share_with_friend));
    }
    paraml.e(0, this.kgr.kgq.getString(n.i.favorite_edit_menu));
    paraml.e(1, this.kgr.kgq.getString(n.i.favorite_save_as_note));
    paraml.e(3, this.kgr.kgq.getString(n.i.favorite_edit_tag_tips));
    paraml.e(4, this.kgr.kgq.getString(n.i.app_delete));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteTextDetailUI.2.1
 * JD-Core Version:    0.7.0.1
 */