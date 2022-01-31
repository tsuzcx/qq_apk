package com.tencent.mm.plugin.fav.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cg;
import com.tencent.mm.g.a.ny;
import com.tencent.mm.g.a.ny.a;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.b.d;
import java.util.Map;

final class FavImgGalleryUI$10
  implements View.OnClickListener
{
  FavImgGalleryUI$10(FavImgGalleryUI paramFavImgGalleryUI, ny paramny) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(151524);
    ab.i("MicroMsg.FavImgGalleryUI", "request deal QBAR string");
    if (FavImgGalleryUI.c(this.mwu).isShowing()) {
      FavImgGalleryUI.c(this.mwu).cre();
    }
    if (this.mww == null)
    {
      AppMethodBeat.o(151524);
      return;
    }
    paramView = FavImgGalleryUI.f(this.mwu).vX(FavImgGalleryUI.e(this.mwu));
    Object localObject = com.tencent.mm.plugin.fav.a.b.b(paramView.cuL);
    localObject = (FavImgGalleryUI.b)FavImgGalleryUI.h(this.mwu).get(localObject);
    if ((localObject != null) && (((FavImgGalleryUI.b)localObject).mwA != null))
    {
      localObject = new cg();
      ((cg)localObject).cpD.activity = this.mwu;
      ((cg)localObject).cpD.cnR = this.mww.cEy.result;
      ((cg)localObject).cpD.cpE = this.mww.cEy.cpE;
      ((cg)localObject).cpD.cpG = 7;
      if ((paramView != null) && (paramView.cuL != null))
      {
        ((cg)localObject).cpD.imagePath = paramView.cuL.wSC;
        ((cg)localObject).cpD.cpI = paramView.cuL.wSE;
      }
      ((cg)localObject).cpD.cpF = this.mww.cEy.cpF;
      paramView = new Bundle(1);
      paramView.putInt("stat_scene", 5);
      ((cg)localObject).cpD.cpJ = paramView;
      a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    }
    AppMethodBeat.o(151524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavImgGalleryUI.10
 * JD-Core Version:    0.7.0.1
 */