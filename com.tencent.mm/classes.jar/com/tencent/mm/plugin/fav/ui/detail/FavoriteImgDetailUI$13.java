package com.tencent.mm.plugin.fav.ui.detail;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cg;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.b.d;

final class FavoriteImgDetailUI$13
  implements View.OnClickListener
{
  FavoriteImgDetailUI$13(FavoriteImgDetailUI paramFavoriteImgDetailUI, FavoriteImgDetailUI.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(151532);
    ab.i("MicroMsg.FavoriteImgDetailUI", "request deal QBAR string");
    if (this.mAB.mAF.isShowing()) {
      this.mAB.mAF.cre();
    }
    paramView = new cg();
    paramView.cpD.activity = this.mAv;
    paramView.cpD.cnR = this.mAB.mAH;
    paramView.cpD.cpE = this.mAB.cpE;
    paramView.cpD.cpG = 7;
    if (this.mAB.cuL != null)
    {
      paramView.cpD.imagePath = this.mAB.cuL.wSC;
      paramView.cpD.cpI = this.mAB.cuL.wSE;
    }
    paramView.cpD.cpF = this.mAB.cpF;
    Bundle localBundle = new Bundle(1);
    localBundle.putInt("stat_scene", 5);
    paramView.cpD.cpJ = localBundle;
    a.ymk.l(paramView);
    AppMethodBeat.o(151532);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.13
 * JD-Core Version:    0.7.0.1
 */