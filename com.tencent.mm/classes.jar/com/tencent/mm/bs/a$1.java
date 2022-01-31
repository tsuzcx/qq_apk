package com.tencent.mm.bs;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.e;
import com.tencent.mm.api.r;
import com.tencent.mm.e.c;
import com.tencent.mm.e.c.5;
import com.tencent.mm.e.c.7;
import com.tencent.mm.e.c.8;
import com.tencent.mm.e.c.9;
import com.tencent.mm.e.d;
import com.tencent.mm.e.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.y.d.a;
import java.util.HashMap;

final class a$1
  implements r
{
  a$1(a parama) {}
  
  public final void a(e parame)
  {
    AppMethodBeat.i(116303);
    ab.i("MicroMsg.DrawingPresenter", "[onSelectedFeature] features:%s", new Object[] { parame });
    if (parame == e.bVV) {
      this.whn.whc.getBaseFooterView().setCurFeatureType(parame);
    }
    this.whn.whc.getBaseFooterView().dQZ();
    if (this.whn.whc.getSelectedFeatureListener() != null) {
      this.whn.whc.getSelectedFeatureListener().a(parame);
    }
    if (parame == e.bWb) {
      this.whn.whc.getFooterBg().setVisibility(8);
    }
    com.tencent.mm.e.b localb = (com.tencent.mm.e.b)this.whn.whd.get(parame);
    if (localb == null)
    {
      AppMethodBeat.o(116303);
      return;
    }
    if ((localb.bRJ) && (!localb.isAlive())) {
      localb.zy();
    }
    if (localb.Cz() != com.tencent.mm.e.a.ccL) {
      localb.setOneFingerMoveEnable(false);
    }
    localb.CC();
    this.whn.whm = localb;
    switch (a.7.whp[parame.ordinal()])
    {
    default: 
      this.whn.whk = parame;
    }
    for (;;)
    {
      this.whn.whc.getBaseFooterView().setCurFeatureType(parame);
      AppMethodBeat.o(116303);
      return;
      if (!this.whn.whc.getBaseFooterView().dQU())
      {
        ((EditText)this.whn.whc.getTextEditView().findViewById(2131823497)).setTextColor(com.tencent.mm.view.footer.a.ATm[0]);
        this.whn.px(true);
        this.whn.whc.setFooterVisible(false);
      }
      this.whn.whk = parame;
      continue;
      this.whn.whc.setActionBarVisible(false);
      this.whn.whc.setFooterVisible(false);
      this.whn.whc.rN(false);
      break;
      this.whn.whj = this.whn.whk;
    }
  }
  
  public final void a(e parame, int paramInt)
  {
    AppMethodBeat.i(116304);
    ab.i("MicroMsg.DrawingPresenter", "[onSelectedDetailFeature] features:%s index:%s", new Object[] { parame, Integer.valueOf(paramInt) });
    if (this.whn.whc.getSelectedFeatureListener() != null) {
      this.whn.whc.getSelectedFeatureListener().a(parame, paramInt);
    }
    this.whn.whm = ((com.tencent.mm.e.b)this.whn.whd.get(parame));
    if (this.whn.dqd().Cz() == com.tencent.mm.e.a.ccL)
    {
      AppMethodBeat.o(116304);
      return;
    }
    if (this.whn.whc.getFooterBg().getVisibility() == 8) {
      this.whn.whc.getFooterBg().setVisibility(0);
    }
    switch (a.7.whp[parame.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(116304);
      return;
      parame = (d)this.whn.dqd();
      if (paramInt != -1)
      {
        this.whn.whc.getBaseFooterView();
        parame.mColor = com.tencent.mm.view.footer.a.getColor(paramInt);
        AppMethodBeat.o(116304);
        return;
      }
      parame.CH();
      AppMethodBeat.o(116304);
      return;
      parame = (f)this.whn.dqd();
      if (paramInt == 0)
      {
        parame.cek = d.a.eFI;
        AppMethodBeat.o(116304);
        return;
      }
      if (1 == paramInt)
      {
        parame.cek = d.a.eFJ;
        AppMethodBeat.o(116304);
        return;
      }
      parame.CH();
      AppMethodBeat.o(116304);
      return;
      parame = (c)this.whn.dqd();
      Object localObject;
      float f1;
      if (paramInt == 0)
      {
        parame.cdF += 1;
        parame.cdp.cancel();
        if (parame.cdD != null) {
          parame.cdD.cancel();
        }
        localObject = new Matrix();
        ((Matrix)localObject).postRotate(-90.0F, parame.bVv.centerX(), parame.bVv.centerY());
        if (parame.cdE.isEmpty()) {
          parame.cdE.set(parame.bVv);
        }
        RectF localRectF = new RectF(parame.cdE);
        ((Matrix)localObject).mapRect(localRectF);
        f1 = 1.0F * parame.cdl.width() / localRectF.width();
        float f2 = 1.0F * parame.cdl.height() / localRectF.height();
        if (f1 < f2) {}
        for (;;)
        {
          ((Matrix)localObject).postScale(f1, f1, parame.bVv.centerX(), parame.bVv.centerY());
          localRectF.set(parame.cdE);
          ((Matrix)localObject).mapRect(localRectF);
          parame.cdE.set((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom);
          f2 = parame.bVv.centerX();
          float f3 = parame.bVv.centerY();
          localObject = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofInt("rotation", new int[] { 0, -90 }), PropertyValuesHolder.ofInt("deltaX", new int[] { 0, parame.cdl.centerX() - (int)f2 }), PropertyValuesHolder.ofInt("deltaY", new int[] { 0, parame.cdl.centerY() - (int)f3 }) });
          ((ValueAnimator)localObject).addUpdateListener(new c.8(parame, f2, f3, f1));
          ((ValueAnimator)localObject).addListener(new c.9(parame));
          ((ValueAnimator)localObject).setDuration(200L);
          ((ValueAnimator)localObject).start();
          AppMethodBeat.o(116304);
          return;
          f1 = f2;
        }
      }
      if (1 == paramInt)
      {
        ab.i("MicroMsg.CropArtist", "[cancel]");
        parame.cdp.cancel();
        if (parame.cdD != null) {
          parame.cdD.cancel();
        }
        parame.ccS.dqc().getBaseBoardView().ASC = parame.ccS.dqc().getBaseBoardView().getRawBoardRect();
        localObject = ((com.tencent.mm.cache.a)parame.CB()).Je();
        f1 = 0.0F;
        if (localObject != null) {
          f1 = parame.getRotation() - parame.b(((com.tencent.mm.y.a)localObject).mMatrix);
        }
        if ((localObject != null) && (!((com.tencent.mm.y.a)localObject).eFn.isEmpty())) {
          parame.ccS.dqc().getBaseBoardView().p(((com.tencent.mm.y.a)localObject).eFn);
        }
        parame.ccS.dqc().getBaseBoardView().a(null, f1, true);
        parame.ccS.dqc().getActionBar().setVisibility(0);
        this.whn.whm = ((com.tencent.mm.e.b)this.whn.whd.get(this.whn.whj));
        this.whn.whc.getBaseFooterView().setCurFeatureType(this.whn.whj);
        AppMethodBeat.o(116304);
        return;
      }
      if (2 == paramInt)
      {
        ab.i("MicroMsg.CropArtist", "[doCrop]");
        if (parame.cdD != null) {
          parame.cdD.cancel();
        }
        if (!parame.cdp.bVC)
        {
          if (!parame.cdp.bVD)
          {
            parame.cdp.cancel();
            parame.cdp.play();
          }
          parame.cdp.nx = new c.5(parame);
        }
        for (;;)
        {
          this.whn.whm = ((com.tencent.mm.e.b)this.whn.whd.get(this.whn.whj));
          this.whn.whc.getBaseFooterView().setCurFeatureType(this.whn.whj);
          AppMethodBeat.o(116304);
          return;
          parame.cdp.nx = null;
          parame.CN();
        }
      }
      if (3 == paramInt)
      {
        ab.i("MicroMsg.CropArtist", "[reset]");
        parame.cdG = true;
        parame.cdp.cancel();
        if (parame.cdD != null) {
          parame.cdD.cancel();
        }
        parame.cdE.setEmpty();
        parame.CM();
        parame.cdv = false;
        parame.ccS.dqc().getBaseBoardView().ASC = parame.bVv;
        parame.ccS.dqc().getBaseBoardView().a(new c.7(parame), parame.getRotation(), true);
      }
    }
  }
  
  public final void bk(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.bs.a.1
 * JD-Core Version:    0.7.0.1
 */