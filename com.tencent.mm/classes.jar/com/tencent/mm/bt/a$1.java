package com.tencent.mm.bt;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.widget.EditText;
import com.tencent.mm.api.p;
import com.tencent.mm.bo.a.e;
import com.tencent.mm.e.c;
import com.tencent.mm.e.c.5;
import com.tencent.mm.e.c.7;
import com.tencent.mm.e.c.8;
import com.tencent.mm.e.c.9;
import com.tencent.mm.e.f;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.z.d.a;
import java.util.HashMap;

final class a$1
  implements p
{
  a$1(a parama) {}
  
  public final void a(com.tencent.mm.api.d paramd)
  {
    y.i("MicroMsg.DrawingPresenter", "[onSelectedFeature] features:%s", new Object[] { paramd });
    if (this.soH.soy.getSelectedFeatureListener() != null) {
      this.soH.soy.getSelectedFeatureListener().a(paramd);
    }
    if (paramd == com.tencent.mm.api.d.buQ) {
      this.soH.soy.getFooterBg().setVisibility(8);
    }
    com.tencent.mm.e.b localb = (com.tencent.mm.e.b)this.soH.soz.get(paramd);
    if (localb == null) {
      return;
    }
    if ((localb.isCreated) && (!localb.isAlive())) {
      localb.tJ();
    }
    if (localb.tG() != com.tencent.mm.e.a.bzO) {
      localb.setOneFingerMoveEnable(false);
    }
    localb.tK();
    this.soH.soG = localb;
    switch (a.7.soJ[paramd.ordinal()])
    {
    default: 
    case 1: 
    case 2: 
      for (;;)
      {
        this.soH.soF = paramd;
        return;
        ((EditText)this.soH.soy.getTextEditView().findViewById(a.e.text_edit)).setTextColor(com.tencent.mm.view.footer.a.wxV[0]);
        this.soH.mi(true);
        this.soH.soy.setFooterVisible(false);
        continue;
        this.soH.soy.setActionBarVisible(false);
        this.soH.soy.setFooterVisible(false);
        this.soH.soy.od(false);
      }
    }
    this.soH.soE = this.soH.soF;
  }
  
  public final void a(com.tencent.mm.api.d paramd, int paramInt)
  {
    y.i("MicroMsg.DrawingPresenter", "[onSelectedDetailFeature] features:%s index:%s", new Object[] { paramd, Integer.valueOf(paramInt) });
    if (this.soH.soy.getSelectedFeatureListener() != null) {
      this.soH.soy.getSelectedFeatureListener().a(paramd, paramInt);
    }
    this.soH.soG = ((com.tencent.mm.e.b)this.soH.soz.get(paramd));
    if (this.soH.coI().tG() == com.tencent.mm.e.a.bzO) {}
    label636:
    do
    {
      return;
      if (this.soH.soy.getFooterBg().getVisibility() == 8) {
        this.soH.soy.getFooterBg().setVisibility(0);
      }
      Object localObject;
      RectF localRectF;
      float f1;
      float f2;
      switch (a.7.soJ[paramd.ordinal()])
      {
      default: 
        return;
      case 3: 
        paramd = (c)this.soH.coI();
        if (paramInt != 0) {
          break label636;
        }
        paramd.bAI += 1;
        paramd.bAs.cancel();
        if (paramd.bAG != null) {
          paramd.bAG.cancel();
        }
        localObject = new Matrix();
        ((Matrix)localObject).postRotate(-90.0F, paramd.buk.centerX(), paramd.buk.centerY());
        if (paramd.bAH.isEmpty()) {
          paramd.bAH.set(paramd.buk);
        }
        localRectF = new RectF(paramd.bAH);
        ((Matrix)localObject).mapRect(localRectF);
        f1 = 1.0F * paramd.bAo.width() / localRectF.width();
        f2 = 1.0F * paramd.bAo.height() / localRectF.height();
        if (f1 >= f2) {
          break;
        }
      }
      for (;;)
      {
        ((Matrix)localObject).postScale(f1, f1, paramd.buk.centerX(), paramd.buk.centerY());
        localRectF.set(paramd.bAH);
        ((Matrix)localObject).mapRect(localRectF);
        paramd.bAH.set((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom);
        f2 = paramd.buk.centerX();
        float f3 = paramd.buk.centerY();
        localObject = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofInt("rotation", new int[] { 0, -90 }), PropertyValuesHolder.ofInt("deltaX", new int[] { 0, paramd.bAo.centerX() - (int)f2 }), PropertyValuesHolder.ofInt("deltaY", new int[] { 0, paramd.bAo.centerY() - (int)f3 }) });
        ((ValueAnimator)localObject).addUpdateListener(new c.8(paramd, f2, f3, f1));
        ((ValueAnimator)localObject).addListener(new c.9(paramd));
        ((ValueAnimator)localObject).setDuration(200L);
        ((ValueAnimator)localObject).start();
        return;
        paramd = (com.tencent.mm.e.d)this.soH.coI();
        if (paramInt != -1)
        {
          this.soH.soy.getBaseFooterView();
          paramd.mColor = com.tencent.mm.view.footer.a.getColor(paramInt);
          return;
        }
        paramd.tP();
        return;
        paramd = (f)this.soH.coI();
        if (paramInt == 0)
        {
          paramd.bBn = d.a.dIe;
          return;
        }
        if (1 == paramInt)
        {
          paramd.bBn = d.a.dIf;
          return;
        }
        paramd.tP();
        return;
        f1 = f2;
      }
      if (1 == paramInt)
      {
        y.i("MicroMsg.CropArtist", "[cancel]");
        paramd.bAs.cancel();
        if (paramd.bAG != null) {
          paramd.bAG.cancel();
        }
        paramd.bzV.coH().getBaseBoardView().wxl = paramd.bzV.coH().getBaseBoardView().getRawBoardRect();
        localObject = ((com.tencent.mm.cache.a)paramd.tI()).wO();
        f1 = 0.0F;
        if (localObject != null) {
          f1 = paramd.getRotation() - paramd.b(((com.tencent.mm.z.a)localObject).mMatrix);
        }
        if ((localObject != null) && (!((com.tencent.mm.z.a)localObject).dHI.isEmpty())) {
          paramd.bzV.coH().getBaseBoardView().m(((com.tencent.mm.z.a)localObject).dHI);
        }
        paramd.bzV.coH().getBaseBoardView().a(null, f1, true);
        paramd.bzV.coH().getActionBar().setVisibility(0);
        this.soH.soG = ((com.tencent.mm.e.b)this.soH.soz.get(this.soH.soE));
        this.soH.soy.getBaseFooterView().setCurFeatureType(this.soH.soE);
        return;
      }
      if (2 == paramInt)
      {
        y.i("MicroMsg.CropArtist", "[doCrop]");
        if (paramd.bAG != null) {
          paramd.bAG.cancel();
        }
        if (!paramd.bAs.bur)
        {
          if (!paramd.bAs.bus)
          {
            paramd.bAs.cancel();
            paramd.bAs.play();
          }
          paramd.bAs.mA = new c.5(paramd);
        }
        for (;;)
        {
          this.soH.soG = ((com.tencent.mm.e.b)this.soH.soz.get(this.soH.soE));
          this.soH.soy.getBaseFooterView().setCurFeatureType(this.soH.soE);
          return;
          paramd.bAs.mA = null;
          paramd.tV();
        }
      }
    } while (3 != paramInt);
    y.i("MicroMsg.CropArtist", "[reset]");
    paramd.bAJ = true;
    paramd.bAs.cancel();
    if (paramd.bAG != null) {
      paramd.bAG.cancel();
    }
    paramd.bAH.setEmpty();
    paramd.tU();
    paramd.bAy = false;
    paramd.bzV.coH().getBaseBoardView().wxl = paramd.buk;
    paramd.bzV.coH().getBaseBoardView().a(new c.7(paramd), paramd.getRotation(), true);
  }
  
  public final void aL(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.bt.a.1
 * JD-Core Version:    0.7.0.1
 */