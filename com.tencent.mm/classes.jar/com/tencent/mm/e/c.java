package com.tencent.mm.e;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.bo.a.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.view.b.a.b;
import java.util.Stack;

public final class c
  extends b<com.tencent.mm.cache.a>
{
  float bAA;
  float bAB;
  float bAC;
  float bAD;
  float bAE;
  float bAF;
  public ValueAnimator bAG;
  public Rect bAH = new Rect();
  public int bAI = 0;
  public boolean bAJ = false;
  private int bAg = (int)ae.getResources().getDimension(a.c.box_padding);
  private int bAh = (int)ae.getResources().getDimension(a.c.feature_select_layout_height);
  private int bAi = (int)ae.getResources().getDimension(a.c.crop_rotation_layout_height);
  private Matrix bAj = new Matrix();
  private RectF bAk;
  private RectF bAl;
  private RectF bAm;
  private RectF bAn;
  public final Rect bAo = new Rect();
  public com.tencent.mm.z.a bAp;
  private boolean bAq = false;
  private boolean bAr = false;
  public com.tencent.mm.b.a bAs;
  boolean bAt = false;
  boolean bAu = false;
  boolean bAv = false;
  boolean bAw = false;
  boolean bAx = false;
  public boolean bAy = true;
  boolean bAz = false;
  public Rect buk;
  
  private boolean tS()
  {
    return (this.bAw) || (this.bAu) || (this.bAv) || (this.bAx);
  }
  
  public final void a(com.tencent.mm.bt.b paramb, Matrix paramMatrix, Rect paramRect)
  {
    super.a(paramb, paramMatrix, paramRect);
    this.buk = new Rect();
    this.bAl = new RectF();
    this.bAk = new RectF();
    this.bAm = new RectF();
    this.bAn = new RectF();
    this.bAp = new com.tencent.mm.z.a(this.buk);
    this.bAs = new com.tencent.mm.b.a(this);
  }
  
  public final boolean m(MotionEvent paramMotionEvent)
  {
    if (!tO()) {
      return false;
    }
    Object localObject = this.bzV.coH().getBaseBoardView().getCurImageRect();
    this.bAC = (((RectF)localObject).top - (((RectF)localObject).bottom - this.buk.bottom));
    this.bAD = (((RectF)localObject).bottom + (this.buk.top - ((RectF)localObject).top));
    this.bAE = (((RectF)localObject).left - (((RectF)localObject).right - this.buk.right));
    this.bAF = (((RectF)localObject).right + (this.buk.left - ((RectF)localObject).left));
    if (this.bAF > this.bAo.right) {
      this.bAF = this.bAo.right;
    }
    if (this.bAE < this.bAg) {
      this.bAE = this.bAg;
    }
    if (this.bAD > this.bAo.bottom) {
      this.bAD = this.bAo.bottom;
    }
    if (this.bAC < this.bAg) {
      this.bAC = this.bAg;
    }
    switch (paramMotionEvent.getActionMasked())
    {
    case 3: 
    case 4: 
    default: 
    case 5: 
    case 0: 
      do
      {
        for (;;)
        {
          return this.bAt;
          this.bAw = false;
          this.bAu = false;
          this.bAv = false;
          this.bAx = false;
          this.bAt = false;
        }
        this.bAz = false;
        if (this.bAs != null) {
          this.bAs.cancel();
        }
        if (this.bAl.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
          this.bAw = true;
        }
        if (this.bAk.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
          this.bAv = true;
        }
        if (this.bAm.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
          this.bAu = true;
        }
        if (this.bAn.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
          this.bAx = true;
        }
        this.bAy = false;
      } while (!tS());
      if ((this.bAw) && (this.bAu))
      {
        this.bAw = true;
        this.bAu = true;
        this.bAv = false;
        this.bAx = false;
      }
      for (;;)
      {
        this.bAA = paramMotionEvent.getX();
        this.bAB = paramMotionEvent.getY();
        break;
        if ((this.bAw) && (this.bAx))
        {
          this.bAw = true;
          this.bAu = false;
          this.bAv = false;
          this.bAx = true;
        }
        else if ((this.bAv) && (this.bAx))
        {
          this.bAw = false;
          this.bAu = false;
          this.bAv = true;
          this.bAx = true;
        }
        else if ((this.bAv) && (this.bAx))
        {
          this.bAw = false;
          this.bAu = false;
          this.bAv = true;
          this.bAx = true;
        }
      }
    case 2: 
      this.bAz = true;
      if ((paramMotionEvent.getPointerCount() == 1) && (tS()))
      {
        if ((this.bAx) && (this.buk.right >= this.buk.left))
        {
          if (this.buk.right <= this.bAo.right)
          {
            if (paramMotionEvent.getX() - this.bAA <= this.bAo.right - this.buk.right) {
              break label1869;
            }
            this.buk.right = this.bAo.right;
          }
          label688:
          if (this.buk.right < this.buk.left + this.bAg * 2) {
            this.buk.right = (this.buk.left + this.bAg * 2);
          }
          if (this.buk.right > this.bAo.right) {
            this.buk.right = this.bAo.right;
          }
          if (((int)((RectF)localObject).right <= (int)this.bAF) && ((int)((RectF)localObject).right <= this.buk.right))
          {
            if (paramMotionEvent.getX() - this.bAA <= this.bAF - ((RectF)localObject).right) {
              break label1900;
            }
            getMainMatrix().postTranslate(this.bAF - ((RectF)localObject).right, 0.0F);
          }
          label836:
          if ((this.buk.width() > ((RectF)localObject).width()) && (this.buk.right < this.bAo.right))
          {
            f1 = this.buk.width() / ((RectF)localObject).width();
            getMainMatrix().postScale(f1, f1, this.buk.left, this.buk.centerY());
          }
        }
        if ((this.bAu) && (this.buk.right >= this.buk.left))
        {
          if (this.buk.left >= this.bAo.left)
          {
            if (this.bAA - paramMotionEvent.getX() <= this.buk.left - this.bAo.left) {
              break label1921;
            }
            this.buk.left = this.bAo.left;
          }
          label995:
          if (this.buk.left > this.buk.right - this.bAg * 2) {
            this.buk.left = (this.buk.right - this.bAg * 2);
          }
          if (this.buk.left < this.bAo.left) {
            this.buk.left = this.bAo.left;
          }
          if (((int)((RectF)localObject).left >= (int)this.bAE) && ((int)((RectF)localObject).left >= this.buk.left))
          {
            if (this.bAA - paramMotionEvent.getX() <= ((RectF)localObject).left - this.bAE) {
              break label1952;
            }
            getMainMatrix().postTranslate(this.bAE - ((RectF)localObject).left, 0.0F);
          }
          label1143:
          if ((this.buk.width() > ((RectF)localObject).width()) && (this.buk.left > this.bAo.left))
          {
            f1 = this.buk.width() / ((RectF)localObject).width();
            getMainMatrix().postScale(f1, f1, this.buk.right, this.buk.centerY());
          }
        }
        if ((this.bAv) && (this.buk.bottom >= this.buk.top))
        {
          if (this.buk.top >= this.bAo.top)
          {
            if (this.bAB - paramMotionEvent.getY() <= this.buk.top - this.bAo.top) {
              break label1973;
            }
            this.buk.top = this.bAo.top;
          }
          label1302:
          if (this.buk.top > this.buk.bottom - this.bAg * 2) {
            this.buk.top = (this.buk.bottom - this.bAg * 2);
          }
          if (this.buk.top < this.bAo.top) {
            this.buk.top = this.bAo.top;
          }
          if (((int)((RectF)localObject).top >= (int)this.bAC) && ((int)((RectF)localObject).top >= this.buk.top))
          {
            if (this.bAB - paramMotionEvent.getY() <= ((RectF)localObject).top - this.bAC) {
              break label2004;
            }
            getMainMatrix().postTranslate(0.0F, this.bAC - ((RectF)localObject).top);
          }
          label1450:
          if ((this.buk.height() > ((RectF)localObject).height()) && (this.buk.top > this.bAo.top))
          {
            f1 = this.buk.height() / ((RectF)localObject).height();
            getMainMatrix().postScale(f1, f1, this.buk.centerX(), this.buk.bottom);
          }
        }
        if ((this.bAw) && (this.buk.bottom >= this.buk.top))
        {
          if (this.buk.bottom <= this.bAo.bottom)
          {
            if (paramMotionEvent.getY() - this.bAB <= this.bAo.bottom - this.buk.bottom) {
              break label2025;
            }
            this.buk.bottom = this.bAo.bottom;
          }
          label1609:
          if (this.buk.bottom < this.buk.top + this.bAg * 2) {
            this.buk.bottom = (this.buk.top + this.bAg * 2);
          }
          if (this.buk.bottom > this.bAo.bottom) {
            this.buk.bottom = this.bAo.bottom;
          }
          if (((int)((RectF)localObject).bottom <= (int)this.bAD) && ((int)((RectF)localObject).bottom <= this.buk.bottom))
          {
            if (paramMotionEvent.getY() - this.bAB <= this.bAD - ((RectF)localObject).bottom) {
              break label2056;
            }
            getMainMatrix().postTranslate(0.0F, this.bAD - ((RectF)localObject).bottom);
          }
          label1757:
          if ((this.buk.height() > ((RectF)localObject).height()) && (this.buk.bottom < this.bAo.bottom))
          {
            f1 = this.buk.height() / ((RectF)localObject).height();
            getMainMatrix().postScale(f1, f1, this.buk.centerX(), this.buk.top);
          }
        }
        tT();
        this.bAt = true;
        tQ();
        this.bAA = paramMotionEvent.getX();
        this.bAB = paramMotionEvent.getY();
      }
      for (;;)
      {
        p(paramMotionEvent);
        break;
        label1869:
        Rect localRect = this.buk;
        localRect.right = ((int)(localRect.right + (paramMotionEvent.getX() - this.bAA)));
        break label688;
        label1900:
        getMainMatrix().postTranslate(paramMotionEvent.getX() - this.bAA, 0.0F);
        break label836;
        label1921:
        localRect = this.buk;
        localRect.left = ((int)(localRect.left - (this.bAA - paramMotionEvent.getX())));
        break label995;
        label1952:
        getMainMatrix().postTranslate(paramMotionEvent.getX() - this.bAA, 0.0F);
        break label1143;
        label1973:
        localRect = this.buk;
        localRect.top = ((int)(localRect.top - (this.bAB - paramMotionEvent.getY())));
        break label1302;
        label2004:
        getMainMatrix().postTranslate(0.0F, paramMotionEvent.getY() - this.bAB);
        break label1450;
        label2025:
        localRect = this.buk;
        localRect.bottom = ((int)(localRect.bottom + (paramMotionEvent.getY() - this.bAB)));
        break label1609;
        label2056:
        getMainMatrix().postTranslate(0.0F, paramMotionEvent.getY() - this.bAB);
        break label1757;
        this.bAt = false;
      }
    }
    float f1 = this.bAo.width() * 1.0F / this.buk.width();
    float f2 = this.bAo.height() * 1.0F / this.buk.height();
    if (f1 < f2)
    {
      label2131:
      f2 = this.bAo.centerX();
      float f3 = this.bAo.centerY();
      float f4 = this.buk.centerX();
      float f5 = this.buk.centerY();
      if (this.bAz)
      {
        this.bAs.bun = 1000L;
        paramMotionEvent = this.bAs;
        localObject = this.buk;
        paramMotionEvent.bui = (f2 - f4);
        paramMotionEvent.buj = (f3 - f5);
        paramMotionEvent.buk = ((Rect)localObject);
        paramMotionEvent.bul.set(paramMotionEvent.buk);
        paramMotionEvent.buh = f1;
        this.bAs.play();
      }
      if (!tS()) {
        break label2288;
      }
    }
    label2288:
    for (this.bAt = true;; this.bAt = false)
    {
      this.bAw = false;
      this.bAu = false;
      this.bAv = false;
      this.bAx = false;
      tR();
      break;
      f1 = f2;
      break label2131;
    }
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    com.tencent.mm.z.a locala;
    boolean bool1;
    boolean bool2;
    if (!this.bAr)
    {
      paramCanvas.setMatrix(null);
      locala = this.bAp;
      bool1 = this.bAy;
      bool2 = this.bAq;
      if (locala.buk != null) {
        break label59;
      }
      y.e("MicroMsg.CropItem", "[draw] mBoxRect is null!");
    }
    label59:
    do
    {
      do
      {
        return;
        paramCanvas.setMatrix(this.bAj);
        break;
        if (bool1)
        {
          paramCanvas.save();
          paramCanvas.clipRect(locala.buk, Region.Op.DIFFERENCE);
          paramCanvas.drawPaint(com.tencent.mm.z.a.dHE);
          paramCanvas.restore();
        }
      } while (!bool2);
      if (!com.tencent.mm.z.a.hc.equals(locala.buk))
      {
        com.tencent.mm.z.a.dHB.reset();
        com.tencent.mm.z.a.dHB.moveTo(locala.buk.left, locala.buk.top);
        com.tencent.mm.z.a.dHB.lineTo(locala.buk.right, locala.buk.top);
        com.tencent.mm.z.a.dHB.lineTo(locala.buk.right, locala.buk.bottom);
        com.tencent.mm.z.a.dHB.lineTo(locala.buk.left, locala.buk.bottom);
        com.tencent.mm.z.a.dHB.close();
        com.tencent.mm.z.a.dHA.reset();
        int i = 1;
        while (i < 3)
        {
          com.tencent.mm.z.a.dHA.moveTo(locala.buk.left + locala.buk.width() / 3 * i, locala.buk.top);
          com.tencent.mm.z.a.dHA.lineTo(locala.buk.left + locala.buk.width() / 3 * i, locala.buk.bottom);
          com.tencent.mm.z.a.dHA.moveTo(locala.buk.left, locala.buk.top + locala.buk.height() / 3 * i);
          com.tencent.mm.z.a.dHA.lineTo(locala.buk.right, locala.buk.top + locala.buk.height() / 3 * i);
          i += 1;
        }
      }
      paramCanvas.drawRect(locala.buk.left, locala.buk.top, locala.buk.right, locala.buk.bottom, com.tencent.mm.z.a.dHD);
      paramCanvas.drawPath(com.tencent.mm.z.a.dHA, com.tencent.mm.z.a.dHF);
      paramCanvas.drawPath(com.tencent.mm.z.a.dHB, com.tencent.mm.z.a.dHC);
      float f1 = locala.buk.left;
      float f2 = com.tencent.mm.z.a.dHy;
      float f3 = locala.buk.top;
      float f4 = com.tencent.mm.z.a.dHy / 2.0F;
      float f5 = locala.buk.left;
      paramCanvas.drawLine(f1 - f2, f3 - f4, com.tencent.mm.z.a.dHz + f5, locala.buk.top - com.tencent.mm.z.a.dHy / 2.0F, com.tencent.mm.z.a.dHG);
      f1 = locala.buk.right;
      f2 = com.tencent.mm.z.a.dHz;
      f3 = com.tencent.mm.z.a.dHy / 2.0F;
      f4 = locala.buk.top;
      f5 = com.tencent.mm.z.a.dHy / 2.0F;
      float f6 = locala.buk.right;
      paramCanvas.drawLine(f3 + (f1 - f2), f4 - f5, com.tencent.mm.z.a.dHy + f6, locala.buk.top - com.tencent.mm.z.a.dHy / 2.0F, com.tencent.mm.z.a.dHG);
      f1 = locala.buk.left;
      f2 = com.tencent.mm.z.a.dHy / 2.0F;
      f3 = locala.buk.top;
      f4 = com.tencent.mm.z.a.dHy / 2.0F;
      f5 = locala.buk.left;
      f6 = com.tencent.mm.z.a.dHy / 2.0F;
      float f7 = locala.buk.top;
      paramCanvas.drawLine(f1 - f2, f3 - f4, f5 - f6, com.tencent.mm.z.a.dHz + f7, com.tencent.mm.z.a.dHG);
      f1 = locala.buk.left;
      f2 = com.tencent.mm.z.a.dHy / 2.0F;
      f3 = locala.buk.bottom;
      f4 = com.tencent.mm.z.a.dHz;
      f5 = com.tencent.mm.z.a.dHy / 2.0F;
      f6 = locala.buk.left;
      f7 = com.tencent.mm.z.a.dHy / 2.0F;
      float f8 = locala.buk.bottom;
      paramCanvas.drawLine(f1 - f2, f5 + (f3 - f4), f6 - f7, com.tencent.mm.z.a.dHy / 2.0F + f8, com.tencent.mm.z.a.dHG);
      f1 = locala.buk.right;
      f2 = com.tencent.mm.z.a.dHy / 2.0F;
      f3 = locala.buk.top;
      f4 = locala.buk.right;
      f5 = com.tencent.mm.z.a.dHy / 2.0F;
      f6 = locala.buk.top;
      paramCanvas.drawLine(f2 + f1, f3, f5 + f4, com.tencent.mm.z.a.dHz + f6, com.tencent.mm.z.a.dHG);
      f1 = locala.buk.right;
      f2 = com.tencent.mm.z.a.dHy / 2.0F;
      f3 = locala.buk.bottom;
      f4 = com.tencent.mm.z.a.dHz;
      f5 = com.tencent.mm.z.a.dHy / 2.0F;
      f6 = locala.buk.right;
      f7 = com.tencent.mm.z.a.dHy / 2.0F;
      f8 = locala.buk.bottom;
      paramCanvas.drawLine(f2 + f1, f5 + (f3 - f4), f7 + f6, com.tencent.mm.z.a.dHy / 2.0F + f8, com.tencent.mm.z.a.dHG);
      f1 = locala.buk.left;
      f2 = com.tencent.mm.z.a.dHy;
      f3 = locala.buk.bottom;
      f4 = com.tencent.mm.z.a.dHy / 2.0F;
      f5 = locala.buk.left;
      f6 = com.tencent.mm.z.a.dHz;
      f7 = locala.buk.bottom;
      paramCanvas.drawLine(f1 - f2, f4 + f3, f6 + f5, com.tencent.mm.z.a.dHy / 2.0F + f7, com.tencent.mm.z.a.dHG);
      f1 = locala.buk.right;
      f2 = com.tencent.mm.z.a.dHz;
      f3 = locala.buk.bottom;
      f4 = com.tencent.mm.z.a.dHy / 2.0F;
      f5 = locala.buk.right;
      f6 = com.tencent.mm.z.a.dHy;
      f7 = locala.buk.bottom;
      paramCanvas.drawLine(f1 - f2, f4 + f3, f6 + f5, com.tencent.mm.z.a.dHy / 2.0F + f7, com.tencent.mm.z.a.dHG);
    } while (com.tencent.mm.z.a.hc.equals(locala.buk));
    com.tencent.mm.z.a.hc.set(locala.buk);
  }
  
  public final a tG()
  {
    return a.bzS;
  }
  
  public final void tH() {}
  
  public final void tJ()
  {
    super.tJ();
    if (this.bAo.isEmpty()) {
      this.bAo.set(this.bAg, this.bAg * 2, getBoardRect().width() - this.bAg, getBoardRect().height() - this.bAh - this.bAi - this.bAg * 2);
    }
    y.i("MicroMsg.CropArtist", "[onAlive] CROP_MAX_RECT:%s", new Object[] { this.bAo });
    com.tencent.mm.z.a locala = ((com.tencent.mm.cache.a)tI()).wP();
    if ((locala != null) && (!locala.dHI.isEmpty()))
    {
      this.bzV.coH().getBaseBoardView().m(locala.dHI);
      float f = b(locala.mMatrix);
      y.i("MicroMsg.CropArtist", "[onAlive] rotation:%s", new Object[] { Float.valueOf(f) });
      getMainMatrix().postRotate(-f, locala.dHI.centerX(), locala.dHI.centerY());
    }
  }
  
  public final void tK()
  {
    super.tK();
    this.bzV.coH().getActionBar().setVisibility(8);
    this.bAH.setEmpty();
    com.tencent.mm.z.a locala;
    if (((com.tencent.mm.cache.a)tI()).bg(true) <= 0)
    {
      locala = new com.tencent.mm.z.a();
      locala.mMatrix.set(getMainMatrix());
      ((com.tencent.mm.cache.a)tI()).a(locala);
      tU();
      this.bzV.coH().getBaseBoardView().wxl = this.buk;
      this.bzV.coH().getBaseBoardView().a(new a.b()
      {
        public final void onStart()
        {
          c.a(c.this, false);
          c.this.bAy = false;
        }
        
        public final void tW()
        {
          if (((com.tencent.mm.cache.a)c.this.tI()).dkY.isIdentity())
          {
            localObject = (com.tencent.mm.cache.a)c.this.tI();
            Matrix localMatrix = c.this.getMainMatrix();
            ((com.tencent.mm.cache.a)localObject).dkY.set(localMatrix);
          }
          Object localObject = new Rect();
          if (c.this.bzV.coJ() == null) {
            ((Rect)localObject).set(0, 0, c.this.bzV.coH().getBaseBoardView().getBoardRect().width(), c.this.bzV.coH().getBaseBoardView().getBoardRect().height());
          }
          for (;;)
          {
            c.this.bzV.coH().getBaseBoardView().m((Rect)localObject);
            c.a(c.this, 200L, true, false);
            c.this.tR();
            return;
            ((Rect)localObject).set(0, 0, c.this.bzV.coJ().getWidth(), c.this.bzV.coJ().getHeight());
          }
        }
      }, 0.0F, false);
    }
    for (;;)
    {
      setOneFingerMoveEnable(true);
      return;
      locala = ((com.tencent.mm.cache.a)tI()).wP();
      if (locala == null)
      {
        y.e("MicroMsg.CropArtist", "item is null!!!");
        return;
      }
      this.buk.set(new Rect(locala.buk));
      this.bzV.coH().getBaseBoardView().wxl = locala.buk;
      try
      {
        ((com.tencent.mm.cache.a)tI()).a((com.tencent.mm.z.a)locala.clone());
        this.bzV.coH().getBaseBoardView().a(new c.2(this), 0.0F, false);
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.CropArtist", localCloneNotSupportedException, "", new Object[0]);
        }
      }
    }
  }
  
  public final boolean tM()
  {
    return !((com.tencent.mm.cache.a)tI()).dkY.equals(getMainMatrix());
  }
  
  public final void tT()
  {
    this.bAl.set(this.buk.left - this.bAg, this.buk.bottom - this.bAg, this.buk.right + this.bAg, this.buk.bottom + this.bAg);
    this.bAk.set(this.buk.left - this.bAg, this.buk.top - this.bAg, this.buk.right + this.bAg, this.buk.top + this.bAg);
    this.bAm.set(this.buk.left - this.bAg, this.buk.top - this.bAg, this.buk.left + this.bAg, this.buk.bottom + this.bAg);
    this.bAn.set(this.buk.right - this.bAg, this.buk.top - this.bAg, this.buk.right + this.bAg, this.buk.bottom + this.bAg);
  }
  
  public final void tU()
  {
    float f1 = this.bzV.coJ().getWidth() * 1.0F / this.bzV.coJ().getHeight();
    int i;
    if (f1 < this.bAo.width() * 1.0F / this.bAo.height())
    {
      float f2 = this.bAo.height();
      i = (int)((this.bAo.width() - f1 * f2) / 2.0F);
      this.buk.set(this.bAo.left + i, this.bAo.top, this.bAo.right - i, this.bAo.bottom);
    }
    for (;;)
    {
      tT();
      return;
      f1 = this.bAo.width() / f1;
      i = (int)((this.bAo.height() - f1) / 2.0F);
      this.buk.set(this.bAo.left, this.bAo.top + i, this.bAo.right, this.bAo.bottom - i);
    }
  }
  
  public final void tV()
  {
    this.bzV.coH().getBaseBoardView().wxl = this.bzV.coH().getBaseBoardView().getRawBoardRect();
    Object localObject1 = new RectF(this.buk);
    Object localObject2 = new Matrix();
    getMainMatrix().invert((Matrix)localObject2);
    ((Matrix)localObject2).mapRect((RectF)localObject1);
    localObject2 = new Rect();
    ((RectF)localObject1).round((Rect)localObject2);
    this.bzV.coH().getBaseBoardView().m((Rect)localObject2);
    localObject1 = new com.tencent.mm.z.a();
    ((com.tencent.mm.z.a)localObject1).buk = new Rect(this.buk);
    ((com.tencent.mm.z.a)localObject1).dHI.set((Rect)localObject2);
    this.bzV.coH().getBaseBoardView().a(new a.b()
    {
      public final void onStart() {}
      
      public final void tW()
      {
        Object localObject = this.bAL;
        Matrix localMatrix = c.this.getMainMatrix();
        ((com.tencent.mm.z.a)localObject).mMatrix.set(localMatrix);
        localObject = (com.tencent.mm.cache.a)c.this.tI();
        if (((com.tencent.mm.cache.a)localObject).dkW != null) {
          ((com.tencent.mm.cache.a)localObject).dkW.clear();
        }
        ((com.tencent.mm.cache.a)c.this.tI()).a(this.bAL);
      }
    }, 0.0F, true);
    this.bzV.coH().getActionBar().setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.e.c
 * JD-Core Version:    0.7.0.1
 */