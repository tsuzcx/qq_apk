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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.view.b.a.b;
import java.util.Stack;

public final class c
  extends b<com.tencent.mm.cache.a>
{
  public Rect bVv;
  float cdA;
  float cdB;
  float cdC;
  public ValueAnimator cdD;
  public Rect cdE;
  public int cdF;
  public boolean cdG;
  private int cdd;
  private int cde;
  private int cdf;
  private Matrix cdg;
  private RectF cdh;
  private RectF cdi;
  private RectF cdj;
  private RectF cdk;
  public final Rect cdl;
  private com.tencent.mm.y.a cdm;
  private boolean cdn;
  private boolean cdo;
  public com.tencent.mm.b.a cdp;
  boolean cdq;
  boolean cdr;
  boolean cds;
  boolean cdt;
  boolean cdu;
  public boolean cdv;
  boolean cdw;
  float cdx;
  float cdy;
  float cdz;
  
  public c()
  {
    AppMethodBeat.i(116166);
    this.cdd = ((int)ah.getResources().getDimension(2131428146));
    this.cde = ((int)ah.getResources().getDimension(2131428423));
    this.cdf = ((int)ah.getResources().getDimension(2131428268));
    this.cdg = new Matrix();
    this.cdl = new Rect();
    this.cdn = false;
    this.cdo = false;
    this.cdq = false;
    this.cdr = false;
    this.cds = false;
    this.cdt = false;
    this.cdu = false;
    this.cdv = true;
    this.cdw = false;
    this.cdE = new Rect();
    this.cdF = 0;
    this.cdG = false;
    AppMethodBeat.o(116166);
  }
  
  private boolean CK()
  {
    return (this.cdt) || (this.cdr) || (this.cds) || (this.cdu);
  }
  
  public final void CA() {}
  
  public final void CC()
  {
    AppMethodBeat.i(116169);
    super.CC();
    this.ccS.dqc().getActionBar().setVisibility(8);
    this.cdE.setEmpty();
    com.tencent.mm.y.a locala;
    if (((com.tencent.mm.cache.a)CB()).ad(true) <= 0)
    {
      locala = new com.tencent.mm.y.a();
      locala.mMatrix.set(getMainMatrix());
      ((com.tencent.mm.cache.a)CB()).a(locala);
      CM();
      this.ccS.dqc().getBaseBoardView().ASC = this.bVv;
      this.ccS.dqc().getBaseBoardView().a(new a.b()
      {
        public final void CO()
        {
          AppMethodBeat.i(116149);
          if (((com.tencent.mm.cache.a)c.this.CB()).ecs.isIdentity())
          {
            localObject = (com.tencent.mm.cache.a)c.this.CB();
            Matrix localMatrix = c.this.getMainMatrix();
            ((com.tencent.mm.cache.a)localObject).ecs.set(localMatrix);
          }
          Object localObject = new Rect();
          if (c.this.ccS.dqf() == null) {
            ((Rect)localObject).set(0, 0, c.this.ccS.dqc().getBaseBoardView().getBoardRect().width(), c.this.ccS.dqc().getBaseBoardView().getBoardRect().height());
          }
          for (;;)
          {
            c.this.ccS.dqc().getBaseBoardView().p((Rect)localObject);
            c.a(c.this, 200L, true, false);
            c.this.CJ();
            AppMethodBeat.o(116149);
            return;
            ((Rect)localObject).set(0, 0, c.this.ccS.dqf().getWidth(), c.this.ccS.dqf().getHeight());
          }
        }
        
        public final void onStart()
        {
          AppMethodBeat.i(116150);
          c.a(c.this, false);
          c.this.cdv = false;
          AppMethodBeat.o(116150);
        }
      }, 0.0F, false);
    }
    for (;;)
    {
      setOneFingerMoveEnable(true);
      AppMethodBeat.o(116169);
      return;
      locala = ((com.tencent.mm.cache.a)CB()).Jf();
      if (locala == null)
      {
        ab.e("MicroMsg.CropArtist", "item is null!!!");
        AppMethodBeat.o(116169);
        return;
      }
      this.bVv.set(new Rect(locala.bVv));
      this.ccS.dqc().getBaseBoardView().ASC = locala.bVv;
      try
      {
        ((com.tencent.mm.cache.a)CB()).a((com.tencent.mm.y.a)locala.clone());
        this.ccS.dqc().getBaseBoardView().a(new c.2(this), 0.0F, false);
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.CropArtist", localCloneNotSupportedException, "", new Object[0]);
        }
      }
    }
  }
  
  public final boolean CE()
  {
    AppMethodBeat.i(116170);
    if (CB() == null)
    {
      AppMethodBeat.o(116170);
      return false;
    }
    if (!((com.tencent.mm.cache.a)CB()).ecs.equals(getMainMatrix()))
    {
      AppMethodBeat.o(116170);
      return true;
    }
    AppMethodBeat.o(116170);
    return false;
  }
  
  public final void CL()
  {
    AppMethodBeat.i(116173);
    this.cdi.set(this.bVv.left - this.cdd, this.bVv.bottom - this.cdd, this.bVv.right + this.cdd, this.bVv.bottom + this.cdd);
    this.cdh.set(this.bVv.left - this.cdd, this.bVv.top - this.cdd, this.bVv.right + this.cdd, this.bVv.top + this.cdd);
    this.cdj.set(this.bVv.left - this.cdd, this.bVv.top - this.cdd, this.bVv.left + this.cdd, this.bVv.bottom + this.cdd);
    this.cdk.set(this.bVv.right - this.cdd, this.bVv.top - this.cdd, this.bVv.right + this.cdd, this.bVv.bottom + this.cdd);
    AppMethodBeat.o(116173);
  }
  
  public final void CM()
  {
    AppMethodBeat.i(116174);
    if (this.ccS.dqf() == null)
    {
      ab.w("MicroMsg.CropArtist", "[resetBoxRect] getImageBitmap is null!");
      AppMethodBeat.o(116174);
      return;
    }
    float f1 = this.ccS.dqf().getWidth() * 1.0F / this.ccS.dqf().getHeight();
    int i;
    if (f1 < this.cdl.width() * 1.0F / this.cdl.height())
    {
      float f2 = this.cdl.height();
      i = (int)((this.cdl.width() - f1 * f2) / 2.0F);
      this.bVv.set(this.cdl.left + i, this.cdl.top, this.cdl.right - i, this.cdl.bottom);
    }
    for (;;)
    {
      CL();
      AppMethodBeat.o(116174);
      return;
      f1 = this.cdl.width() / f1;
      i = (int)((this.cdl.height() - f1) / 2.0F);
      this.bVv.set(this.cdl.left, this.cdl.top + i, this.cdl.right, this.cdl.bottom - i);
    }
  }
  
  public final void CN()
  {
    AppMethodBeat.i(116175);
    this.ccS.dqc().getBaseBoardView().ASC = this.ccS.dqc().getBaseBoardView().getRawBoardRect();
    Object localObject1 = new RectF(this.bVv);
    Object localObject2 = new Matrix();
    getMainMatrix().invert((Matrix)localObject2);
    ((Matrix)localObject2).mapRect((RectF)localObject1);
    localObject2 = new Rect();
    ((RectF)localObject1).round((Rect)localObject2);
    this.ccS.dqc().getBaseBoardView().p((Rect)localObject2);
    localObject1 = new com.tencent.mm.y.a();
    ((com.tencent.mm.y.a)localObject1).bVv = new Rect(this.bVv);
    ((com.tencent.mm.y.a)localObject1).eFn.set((Rect)localObject2);
    this.ccS.dqc().getBaseBoardView().a(new a.b()
    {
      public final void CO()
      {
        AppMethodBeat.i(116159);
        Object localObject = this.cdI;
        Matrix localMatrix = c.this.getMainMatrix();
        ((com.tencent.mm.y.a)localObject).mMatrix.set(localMatrix);
        localObject = (com.tencent.mm.cache.a)c.this.CB();
        if (((com.tencent.mm.cache.a)localObject).ecq != null) {
          ((com.tencent.mm.cache.a)localObject).ecq.clear();
        }
        ((com.tencent.mm.cache.a)c.this.CB()).a(this.cdI);
        AppMethodBeat.o(116159);
      }
      
      public final void onStart() {}
    }, 0.0F, true);
    this.ccS.dqc().getActionBar().setVisibility(0);
    AppMethodBeat.o(116175);
  }
  
  public final a Cz()
  {
    return a.ccP;
  }
  
  public final void a(com.tencent.mm.bs.b paramb, Matrix paramMatrix, Rect paramRect)
  {
    AppMethodBeat.i(116167);
    super.a(paramb, paramMatrix, paramRect);
    this.bVv = new Rect();
    this.cdi = new RectF();
    this.cdh = new RectF();
    this.cdj = new RectF();
    this.cdk = new RectF();
    this.cdm = new com.tencent.mm.y.a(this.bVv);
    this.cdp = new com.tencent.mm.b.a(this);
    AppMethodBeat.o(116167);
  }
  
  public final boolean o(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(116172);
    if (!CG())
    {
      AppMethodBeat.o(116172);
      return false;
    }
    Object localObject = this.ccS.dqc().getBaseBoardView().getCurImageRect();
    this.cdz = (((RectF)localObject).top - (((RectF)localObject).bottom - this.bVv.bottom));
    this.cdA = (((RectF)localObject).bottom + (this.bVv.top - ((RectF)localObject).top));
    this.cdB = (((RectF)localObject).left - (((RectF)localObject).right - this.bVv.right));
    this.cdC = (((RectF)localObject).right + (this.bVv.left - ((RectF)localObject).left));
    if (this.cdC > this.cdl.right) {
      this.cdC = this.cdl.right;
    }
    if (this.cdB < this.cdd) {
      this.cdB = this.cdd;
    }
    if (this.cdA > this.cdl.bottom) {
      this.cdA = this.cdl.bottom;
    }
    if (this.cdz < this.cdd) {
      this.cdz = this.cdd;
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
          boolean bool = this.cdq;
          AppMethodBeat.o(116172);
          return bool;
          this.cdt = false;
          this.cdr = false;
          this.cds = false;
          this.cdu = false;
          this.cdq = false;
        }
        this.cdw = false;
        if (this.cdp != null) {
          this.cdp.cancel();
        }
        if (this.cdi.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
          this.cdt = true;
        }
        if (this.cdh.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
          this.cds = true;
        }
        if (this.cdj.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
          this.cdr = true;
        }
        if (this.cdk.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
          this.cdu = true;
        }
        this.cdv = false;
      } while (!CK());
      if ((this.cdt) && (this.cdr))
      {
        this.cdt = true;
        this.cdr = true;
        this.cds = false;
        this.cdu = false;
      }
      for (;;)
      {
        this.cdx = paramMotionEvent.getX();
        this.cdy = paramMotionEvent.getY();
        break;
        if ((this.cdt) && (this.cdu))
        {
          this.cdt = true;
          this.cdr = false;
          this.cds = false;
          this.cdu = true;
        }
        else if ((this.cds) && (this.cdu))
        {
          this.cdt = false;
          this.cdr = false;
          this.cds = true;
          this.cdu = true;
        }
        else if ((this.cds) && (this.cdu))
        {
          this.cdt = false;
          this.cdr = false;
          this.cds = true;
          this.cdu = true;
        }
      }
    case 2: 
      this.cdw = true;
      if ((paramMotionEvent.getPointerCount() == 1) && (CK()))
      {
        if ((this.cdu) && (this.bVv.right >= this.bVv.left))
        {
          if (this.bVv.right <= this.cdl.right)
          {
            if (paramMotionEvent.getX() - this.cdx <= this.cdl.right - this.bVv.right) {
              break label1891;
            }
            this.bVv.right = this.cdl.right;
          }
          label710:
          if (this.bVv.right < this.bVv.left + this.cdd * 2) {
            this.bVv.right = (this.bVv.left + this.cdd * 2);
          }
          if (this.bVv.right > this.cdl.right) {
            this.bVv.right = this.cdl.right;
          }
          if (((int)((RectF)localObject).right <= (int)this.cdC) && ((int)((RectF)localObject).right <= this.bVv.right))
          {
            if (paramMotionEvent.getX() - this.cdx <= this.cdC - ((RectF)localObject).right) {
              break label1922;
            }
            getMainMatrix().postTranslate(this.cdC - ((RectF)localObject).right, 0.0F);
          }
          label858:
          if ((this.bVv.width() > ((RectF)localObject).width()) && (this.bVv.right < this.cdl.right))
          {
            f1 = this.bVv.width() / ((RectF)localObject).width();
            getMainMatrix().postScale(f1, f1, this.bVv.left, this.bVv.centerY());
          }
        }
        if ((this.cdr) && (this.bVv.right >= this.bVv.left))
        {
          if (this.bVv.left >= this.cdl.left)
          {
            if (this.cdx - paramMotionEvent.getX() <= this.bVv.left - this.cdl.left) {
              break label1943;
            }
            this.bVv.left = this.cdl.left;
          }
          label1017:
          if (this.bVv.left > this.bVv.right - this.cdd * 2) {
            this.bVv.left = (this.bVv.right - this.cdd * 2);
          }
          if (this.bVv.left < this.cdl.left) {
            this.bVv.left = this.cdl.left;
          }
          if (((int)((RectF)localObject).left >= (int)this.cdB) && ((int)((RectF)localObject).left >= this.bVv.left))
          {
            if (this.cdx - paramMotionEvent.getX() <= ((RectF)localObject).left - this.cdB) {
              break label1974;
            }
            getMainMatrix().postTranslate(this.cdB - ((RectF)localObject).left, 0.0F);
          }
          label1165:
          if ((this.bVv.width() > ((RectF)localObject).width()) && (this.bVv.left > this.cdl.left))
          {
            f1 = this.bVv.width() / ((RectF)localObject).width();
            getMainMatrix().postScale(f1, f1, this.bVv.right, this.bVv.centerY());
          }
        }
        if ((this.cds) && (this.bVv.bottom >= this.bVv.top))
        {
          if (this.bVv.top >= this.cdl.top)
          {
            if (this.cdy - paramMotionEvent.getY() <= this.bVv.top - this.cdl.top) {
              break label1995;
            }
            this.bVv.top = this.cdl.top;
          }
          label1324:
          if (this.bVv.top > this.bVv.bottom - this.cdd * 2) {
            this.bVv.top = (this.bVv.bottom - this.cdd * 2);
          }
          if (this.bVv.top < this.cdl.top) {
            this.bVv.top = this.cdl.top;
          }
          if (((int)((RectF)localObject).top >= (int)this.cdz) && ((int)((RectF)localObject).top >= this.bVv.top))
          {
            if (this.cdy - paramMotionEvent.getY() <= ((RectF)localObject).top - this.cdz) {
              break label2026;
            }
            getMainMatrix().postTranslate(0.0F, this.cdz - ((RectF)localObject).top);
          }
          label1472:
          if ((this.bVv.height() > ((RectF)localObject).height()) && (this.bVv.top > this.cdl.top))
          {
            f1 = this.bVv.height() / ((RectF)localObject).height();
            getMainMatrix().postScale(f1, f1, this.bVv.centerX(), this.bVv.bottom);
          }
        }
        if ((this.cdt) && (this.bVv.bottom >= this.bVv.top))
        {
          if (this.bVv.bottom <= this.cdl.bottom)
          {
            if (paramMotionEvent.getY() - this.cdy <= this.cdl.bottom - this.bVv.bottom) {
              break label2047;
            }
            this.bVv.bottom = this.cdl.bottom;
          }
          label1631:
          if (this.bVv.bottom < this.bVv.top + this.cdd * 2) {
            this.bVv.bottom = (this.bVv.top + this.cdd * 2);
          }
          if (this.bVv.bottom > this.cdl.bottom) {
            this.bVv.bottom = this.cdl.bottom;
          }
          if (((int)((RectF)localObject).bottom <= (int)this.cdA) && ((int)((RectF)localObject).bottom <= this.bVv.bottom))
          {
            if (paramMotionEvent.getY() - this.cdy <= this.cdA - ((RectF)localObject).bottom) {
              break label2078;
            }
            getMainMatrix().postTranslate(0.0F, this.cdA - ((RectF)localObject).bottom);
          }
          label1779:
          if ((this.bVv.height() > ((RectF)localObject).height()) && (this.bVv.bottom < this.cdl.bottom))
          {
            f1 = this.bVv.height() / ((RectF)localObject).height();
            getMainMatrix().postScale(f1, f1, this.bVv.centerX(), this.bVv.top);
          }
        }
        CL();
        this.cdq = true;
        CI();
        this.cdx = paramMotionEvent.getX();
        this.cdy = paramMotionEvent.getY();
      }
      for (;;)
      {
        r(paramMotionEvent);
        break;
        label1891:
        Rect localRect = this.bVv;
        localRect.right = ((int)(localRect.right + (paramMotionEvent.getX() - this.cdx)));
        break label710;
        label1922:
        getMainMatrix().postTranslate(paramMotionEvent.getX() - this.cdx, 0.0F);
        break label858;
        label1943:
        localRect = this.bVv;
        localRect.left = ((int)(localRect.left - (this.cdx - paramMotionEvent.getX())));
        break label1017;
        label1974:
        getMainMatrix().postTranslate(paramMotionEvent.getX() - this.cdx, 0.0F);
        break label1165;
        label1995:
        localRect = this.bVv;
        localRect.top = ((int)(localRect.top - (this.cdy - paramMotionEvent.getY())));
        break label1324;
        label2026:
        getMainMatrix().postTranslate(0.0F, paramMotionEvent.getY() - this.cdy);
        break label1472;
        label2047:
        localRect = this.bVv;
        localRect.bottom = ((int)(localRect.bottom + (paramMotionEvent.getY() - this.cdy)));
        break label1631;
        label2078:
        getMainMatrix().postTranslate(0.0F, paramMotionEvent.getY() - this.cdy);
        break label1779;
        this.cdq = false;
      }
    }
    float f1 = this.cdl.width() * 1.0F / this.bVv.width();
    float f2 = this.cdl.height() * 1.0F / this.bVv.height();
    if (f1 < f2)
    {
      label2153:
      f2 = this.cdl.centerX();
      float f3 = this.cdl.centerY();
      float f4 = this.bVv.centerX();
      float f5 = this.bVv.centerY();
      if (this.cdw)
      {
        this.cdp.bVy = 1000L;
        paramMotionEvent = this.cdp;
        localObject = this.bVv;
        paramMotionEvent.bVt = (f2 - f4);
        paramMotionEvent.bVu = (f3 - f5);
        paramMotionEvent.bVv = ((Rect)localObject);
        paramMotionEvent.bVw.set(paramMotionEvent.bVv);
        paramMotionEvent.bVs = f1;
        this.cdp.play();
      }
      if (!CK()) {
        break label2310;
      }
    }
    label2310:
    for (this.cdq = true;; this.cdq = false)
    {
      this.cdt = false;
      this.cdr = false;
      this.cds = false;
      this.cdu = false;
      CJ();
      break;
      f1 = f2;
      break label2153;
    }
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(116171);
    if (!this.cdo) {
      paramCanvas.setMatrix(null);
    }
    com.tencent.mm.y.a locala;
    boolean bool1;
    boolean bool2;
    for (;;)
    {
      locala = this.cdm;
      bool1 = this.cdv;
      bool2 = this.cdn;
      if (locala.bVv != null) {
        break;
      }
      ab.e("MicroMsg.CropItem", "[draw] mBoxRect is null!");
      AppMethodBeat.o(116171);
      return;
      paramCanvas.setMatrix(this.cdg);
    }
    if (bool1)
    {
      paramCanvas.save();
      paramCanvas.clipRect(locala.bVv, Region.Op.DIFFERENCE);
      paramCanvas.drawPaint(com.tencent.mm.y.a.eFj);
      paramCanvas.restore();
    }
    if (bool2)
    {
      if (!com.tencent.mm.y.a.hV.equals(locala.bVv))
      {
        com.tencent.mm.y.a.eFg.reset();
        com.tencent.mm.y.a.eFg.moveTo(locala.bVv.left, locala.bVv.top);
        com.tencent.mm.y.a.eFg.lineTo(locala.bVv.right, locala.bVv.top);
        com.tencent.mm.y.a.eFg.lineTo(locala.bVv.right, locala.bVv.bottom);
        com.tencent.mm.y.a.eFg.lineTo(locala.bVv.left, locala.bVv.bottom);
        com.tencent.mm.y.a.eFg.close();
        com.tencent.mm.y.a.eFf.reset();
        int i = 1;
        while (i < 3)
        {
          com.tencent.mm.y.a.eFf.moveTo(locala.bVv.left + locala.bVv.width() / 3 * i, locala.bVv.top);
          com.tencent.mm.y.a.eFf.lineTo(locala.bVv.left + locala.bVv.width() / 3 * i, locala.bVv.bottom);
          com.tencent.mm.y.a.eFf.moveTo(locala.bVv.left, locala.bVv.top + locala.bVv.height() / 3 * i);
          com.tencent.mm.y.a.eFf.lineTo(locala.bVv.right, locala.bVv.top + locala.bVv.height() / 3 * i);
          i += 1;
        }
      }
      paramCanvas.drawRect(locala.bVv.left, locala.bVv.top, locala.bVv.right, locala.bVv.bottom, com.tencent.mm.y.a.eFi);
      paramCanvas.drawPath(com.tencent.mm.y.a.eFf, com.tencent.mm.y.a.eFk);
      paramCanvas.drawPath(com.tencent.mm.y.a.eFg, com.tencent.mm.y.a.eFh);
      float f1 = locala.bVv.left;
      float f2 = com.tencent.mm.y.a.eFd;
      float f3 = locala.bVv.top;
      float f4 = com.tencent.mm.y.a.eFd / 2.0F;
      float f5 = locala.bVv.left;
      paramCanvas.drawLine(f1 - f2, f3 - f4, com.tencent.mm.y.a.eFe + f5, locala.bVv.top - com.tencent.mm.y.a.eFd / 2.0F, com.tencent.mm.y.a.eFl);
      f1 = locala.bVv.right;
      f2 = com.tencent.mm.y.a.eFe;
      f3 = com.tencent.mm.y.a.eFd / 2.0F;
      f4 = locala.bVv.top;
      f5 = com.tencent.mm.y.a.eFd / 2.0F;
      float f6 = locala.bVv.right;
      paramCanvas.drawLine(f3 + (f1 - f2), f4 - f5, com.tencent.mm.y.a.eFd + f6, locala.bVv.top - com.tencent.mm.y.a.eFd / 2.0F, com.tencent.mm.y.a.eFl);
      f1 = locala.bVv.left;
      f2 = com.tencent.mm.y.a.eFd / 2.0F;
      f3 = locala.bVv.top;
      f4 = com.tencent.mm.y.a.eFd / 2.0F;
      f5 = locala.bVv.left;
      f6 = com.tencent.mm.y.a.eFd / 2.0F;
      float f7 = locala.bVv.top;
      paramCanvas.drawLine(f1 - f2, f3 - f4, f5 - f6, com.tencent.mm.y.a.eFe + f7, com.tencent.mm.y.a.eFl);
      f1 = locala.bVv.left;
      f2 = com.tencent.mm.y.a.eFd / 2.0F;
      f3 = locala.bVv.bottom;
      f4 = com.tencent.mm.y.a.eFe;
      f5 = com.tencent.mm.y.a.eFd / 2.0F;
      f6 = locala.bVv.left;
      f7 = com.tencent.mm.y.a.eFd / 2.0F;
      float f8 = locala.bVv.bottom;
      paramCanvas.drawLine(f1 - f2, f5 + (f3 - f4), f6 - f7, com.tencent.mm.y.a.eFd / 2.0F + f8, com.tencent.mm.y.a.eFl);
      f1 = locala.bVv.right;
      f2 = com.tencent.mm.y.a.eFd / 2.0F;
      f3 = locala.bVv.top;
      f4 = locala.bVv.right;
      f5 = com.tencent.mm.y.a.eFd / 2.0F;
      f6 = locala.bVv.top;
      paramCanvas.drawLine(f2 + f1, f3, f5 + f4, com.tencent.mm.y.a.eFe + f6, com.tencent.mm.y.a.eFl);
      f1 = locala.bVv.right;
      f2 = com.tencent.mm.y.a.eFd / 2.0F;
      f3 = locala.bVv.bottom;
      f4 = com.tencent.mm.y.a.eFe;
      f5 = com.tencent.mm.y.a.eFd / 2.0F;
      f6 = locala.bVv.right;
      f7 = com.tencent.mm.y.a.eFd / 2.0F;
      f8 = locala.bVv.bottom;
      paramCanvas.drawLine(f2 + f1, f5 + (f3 - f4), f7 + f6, com.tencent.mm.y.a.eFd / 2.0F + f8, com.tencent.mm.y.a.eFl);
      f1 = locala.bVv.left;
      f2 = com.tencent.mm.y.a.eFd;
      f3 = locala.bVv.bottom;
      f4 = com.tencent.mm.y.a.eFd / 2.0F;
      f5 = locala.bVv.left;
      f6 = com.tencent.mm.y.a.eFe;
      f7 = locala.bVv.bottom;
      paramCanvas.drawLine(f1 - f2, f4 + f3, f6 + f5, com.tencent.mm.y.a.eFd / 2.0F + f7, com.tencent.mm.y.a.eFl);
      f1 = locala.bVv.right;
      f2 = com.tencent.mm.y.a.eFe;
      f3 = locala.bVv.bottom;
      f4 = com.tencent.mm.y.a.eFd / 2.0F;
      f5 = locala.bVv.right;
      f6 = com.tencent.mm.y.a.eFd;
      f7 = locala.bVv.bottom;
      paramCanvas.drawLine(f1 - f2, f4 + f3, f6 + f5, com.tencent.mm.y.a.eFd / 2.0F + f7, com.tencent.mm.y.a.eFl);
      if (!com.tencent.mm.y.a.hV.equals(locala.bVv)) {
        com.tencent.mm.y.a.hV.set(locala.bVv);
      }
    }
    AppMethodBeat.o(116171);
  }
  
  public final void zy()
  {
    AppMethodBeat.i(116168);
    super.zy();
    if (this.cdl.isEmpty()) {
      this.cdl.set(this.cdd, this.cdd * 2, getBoardRect().width() - this.cdd, getBoardRect().height() - this.cde - this.cdf - this.cdd * 2);
    }
    ab.i("MicroMsg.CropArtist", "[onAlive] CROP_MAX_RECT:%s", new Object[] { this.cdl });
    if (CB() == null)
    {
      ab.i("MicroMsg.CropArtist", "[onAlive] getCache is null");
      AppMethodBeat.o(116168);
      return;
    }
    com.tencent.mm.y.a locala = ((com.tencent.mm.cache.a)CB()).Jf();
    if ((locala != null) && (!locala.eFn.isEmpty()))
    {
      this.ccS.dqc().getBaseBoardView().p(locala.eFn);
      float f = b(locala.mMatrix);
      ab.i("MicroMsg.CropArtist", "[onAlive] rotation:%s", new Object[] { Float.valueOf(f) });
      getMainMatrix().postRotate(-f, locala.eFn.centerX(), locala.eFn.centerY());
    }
    AppMethodBeat.o(116168);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.e.c
 * JD-Core Version:    0.7.0.1
 */