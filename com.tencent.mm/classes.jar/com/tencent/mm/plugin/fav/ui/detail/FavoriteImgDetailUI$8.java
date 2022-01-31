package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.protocal.protobuf.aca;

final class FavoriteImgDetailUI$8
  implements View.OnClickListener
{
  FavoriteImgDetailUI$8(FavoriteImgDetailUI paramFavoriteImgDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(74385);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_detail_info_id", FavoriteImgDetailUI.b(this.mAv).field_localId);
    localIntent.putExtra("key_detail_data_id", ((aca)paramView.getTag()).mBq);
    b.b(this.mAv.getContext(), ".ui.FavImgGalleryUI", localIntent);
    paramView = this.mAv.mzH;
    paramView.mte += 1;
    AppMethodBeat.o(74385);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.8
 * JD-Core Version:    0.7.0.1
 */