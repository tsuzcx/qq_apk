package com.tencent.mm.plugin.fav.ui.detail;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aca;
import java.util.HashMap;

final class FavoriteImgDetailUI$9
  implements View.OnLongClickListener
{
  FavoriteImgDetailUI$9(FavoriteImgDetailUI paramFavoriteImgDetailUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(74386);
    paramView = (aca)paramView.getTag();
    paramView = (FavoriteImgDetailUI.a)FavoriteImgDetailUI.c(this.mAv).get(paramView.mBq);
    FavoriteImgDetailUI.a(this.mAv, paramView);
    if (!paramView.mAG) {
      FavoriteImgDetailUI.b(paramView);
    }
    AppMethodBeat.o(74386);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.9
 * JD-Core Version:    0.7.0.1
 */