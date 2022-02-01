package com.tencent.mm.e;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.view.b.a.b;
import java.util.Stack;

public final class c
  extends b<com.tencent.mm.cache.a>
{
  public Rect cHB;
  private int cRK;
  private int cRL;
  private int cRM;
  private Matrix cRN;
  private RectF cRO;
  private RectF cRP;
  private RectF cRQ;
  private RectF cRR;
  public final Rect cRS;
  private com.tencent.mm.aa.a cRT;
  private boolean cRU;
  private boolean cRV;
  public com.tencent.mm.c.a cRW;
  boolean cRX;
  boolean cRY;
  boolean cRZ;
  boolean cSa;
  boolean cSb;
  public boolean cSc;
  boolean cSd;
  float cSe;
  float cSf;
  float cSg;
  float cSh;
  float cSi;
  float cSj;
  public ValueAnimator cSk;
  public Rect cSl;
  public int cSm;
  public boolean cSn;
  
  public c()
  {
    AppMethodBeat.i(9136);
    this.cRK = ((int)aj.getResources().getDimension(2131165936));
    this.cRL = ((int)aj.getResources().getDimension(2131166289));
    this.cRM = ((int)aj.getResources().getDimension(2131166083));
    this.cRN = new Matrix();
    this.cRS = new Rect();
    this.cRU = false;
    this.cRV = false;
    this.cRX = false;
    this.cRY = false;
    this.cRZ = false;
    this.cSa = false;
    this.cSb = false;
    this.cSc = true;
    this.cSd = false;
    this.cSl = new Rect();
    this.cSm = 0;
    this.cSn = false;
    AppMethodBeat.o(9136);
  }
  
  private boolean Mm()
  {
    return (this.cSa) || (this.cRY) || (this.cRZ) || (this.cSb);
  }
  
  public final a Mb()
  {
    return a.cRv;
  }
  
  public final void Mc() {}
  
  public final void Me()
  {
    AppMethodBeat.i(9139);
    super.Me();
    this.cRz.eBt().getActionBar().setVisibility(8);
    this.cSl.setEmpty();
    if (Md() == null)
    {
      ad.e("MicroMsg.CropArtist", "[onSelected] getCache is null!");
      AppMethodBeat.o(9139);
      return;
    }
    com.tencent.mm.aa.a locala;
    if (((com.tencent.mm.cache.a)Md()).aj(true) <= 0)
    {
      locala = new com.tencent.mm.aa.a();
      locala.mMatrix.set(getMainMatrix());
      ((com.tencent.mm.cache.a)Md()).a(locala);
      Mo();
      this.cRz.eBt().getBaseBoardView().HYs = this.cHB;
      this.cRz.eBt().getBaseBoardView().a(new a.b()
      {
        public final void Mq()
        {
          AppMethodBeat.i(9119);
          if (c.this.Md() == null)
          {
            AppMethodBeat.o(9119);
            return;
          }
          if (((com.tencent.mm.cache.a)c.this.Md()).fmE.isIdentity())
          {
            localObject = (com.tencent.mm.cache.a)c.this.Md();
            Matrix localMatrix = c.this.getMainMatrix();
            ((com.tencent.mm.cache.a)localObject).fmE.set(localMatrix);
          }
          Object localObject = new Rect();
          if (c.this.cRz.eBw() == null) {
            ((Rect)localObject).set(0, 0, c.this.cRz.eBt().getBaseBoardView().getBoardRect().width(), c.this.cRz.eBt().getBaseBoardView().getBoardRect().height());
          }
          for (;;)
          {
            c.this.cRz.eBt().getBaseBoardView().s((Rect)localObject);
            c.a(c.this, 200L, true, false);
            c.this.Ml();
            AppMethodBeat.o(9119);
            return;
            ((Rect)localObject).set(0, 0, c.this.cRz.eBw().getWidth(), c.this.cRz.eBw().getHeight());
          }
        }
        
        public final void onStart()
        {
          AppMethodBeat.i(9120);
          c.a(c.this, false);
          c.this.cSc = false;
          AppMethodBeat.o(9120);
        }
      }, 0.0F, false);
    }
    for (;;)
    {
      setOneFingerMoveEnable(true);
      AppMethodBeat.o(9139);
      return;
      locala = ((com.tencent.mm.cache.a)Md()).Uv();
      if (locala == null)
      {
        ad.e("MicroMsg.CropArtist", "item is null!!!");
        AppMethodBeat.o(9139);
        return;
      }
      this.cHB.set(new Rect(locala.cHB));
      this.cRz.eBt().getBaseBoardView().HYs = locala.cHB;
      try
      {
        ((com.tencent.mm.cache.a)Md()).a((com.tencent.mm.aa.a)locala.clone());
        this.cRz.eBt().getBaseBoardView().a(new a.b()
        {
          public final void Mq()
          {
            AppMethodBeat.i(9121);
            c.this.cSc = true;
            Rect localRect;
            if (c.this.cRz.eBw() == null)
            {
              localRect = new Rect();
              ad.e("MicroMsg.CropArtist", "getImageBitmap is null!");
            }
            for (;;)
            {
              c.this.cRz.eBt().getBaseBoardView().s(localRect);
              c.a(c.this, 200L, true, false);
              AppMethodBeat.o(9121);
              return;
              localRect = new Rect(0, 0, c.this.cRz.eBw().getWidth(), c.this.cRz.eBw().getHeight());
            }
          }
          
          public final void onStart()
          {
            AppMethodBeat.i(9122);
            c.a(c.this, false);
            c.this.cSc = false;
            c.a(c.this);
            com.tencent.mm.aa.a.ma(282);
            AppMethodBeat.o(9122);
          }
        }, 0.0F, false);
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.CropArtist", localCloneNotSupportedException, "", new Object[0]);
        }
      }
    }
  }
  
  public final boolean Mg()
  {
    AppMethodBeat.i(9140);
    if (Md() == null)
    {
      AppMethodBeat.o(9140);
      return false;
    }
    if (!((com.tencent.mm.cache.a)Md()).fmE.equals(getMainMatrix()))
    {
      AppMethodBeat.o(9140);
      return true;
    }
    AppMethodBeat.o(9140);
    return false;
  }
  
  public final void Mn()
  {
    AppMethodBeat.i(9143);
    this.cRP.set(this.cHB.left - this.cRK, this.cHB.bottom - this.cRK, this.cHB.right + this.cRK, this.cHB.bottom + this.cRK);
    this.cRO.set(this.cHB.left - this.cRK, this.cHB.top - this.cRK, this.cHB.right + this.cRK, this.cHB.top + this.cRK);
    this.cRQ.set(this.cHB.left - this.cRK, this.cHB.top - this.cRK, this.cHB.left + this.cRK, this.cHB.bottom + this.cRK);
    this.cRR.set(this.cHB.right - this.cRK, this.cHB.top - this.cRK, this.cHB.right + this.cRK, this.cHB.bottom + this.cRK);
    AppMethodBeat.o(9143);
  }
  
  public final void Mo()
  {
    AppMethodBeat.i(9144);
    if (this.cRz.eBw() == null)
    {
      ad.w("MicroMsg.CropArtist", "[resetBoxRect] getImageBitmap is null!");
      AppMethodBeat.o(9144);
      return;
    }
    float f1 = this.cRz.eBw().getWidth() * 1.0F / this.cRz.eBw().getHeight();
    int i;
    if (f1 < this.cRS.width() * 1.0F / this.cRS.height())
    {
      float f2 = this.cRS.height();
      i = (int)((this.cRS.width() - f1 * f2) / 2.0F);
      this.cHB.set(this.cRS.left + i, this.cRS.top, this.cRS.right - i, this.cRS.bottom);
    }
    for (;;)
    {
      Mn();
      AppMethodBeat.o(9144);
      return;
      f1 = this.cRS.width() / f1;
      i = (int)((this.cRS.height() - f1) / 2.0F);
      this.cHB.set(this.cRS.left, this.cRS.top + i, this.cRS.right, this.cRS.bottom - i);
    }
  }
  
  public final void Mp()
  {
    AppMethodBeat.i(9145);
    this.cRz.eBt().getBaseBoardView().HYs = this.cRz.eBt().getBaseBoardView().getRawBoardRect();
    Object localObject1 = new RectF(this.cHB);
    Object localObject2 = new Matrix();
    getMainMatrix().invert((Matrix)localObject2);
    ((Matrix)localObject2).mapRect((RectF)localObject1);
    localObject2 = new Rect();
    ((RectF)localObject1).round((Rect)localObject2);
    this.cRz.eBt().getBaseBoardView().s((Rect)localObject2);
    localObject1 = new com.tencent.mm.aa.a();
    ((com.tencent.mm.aa.a)localObject1).cHB = new Rect(this.cHB);
    ((com.tencent.mm.aa.a)localObject1).gat.set((Rect)localObject2);
    this.cRz.eBt().getBaseBoardView().a(new a.b()
    {
      public final void Mq()
      {
        AppMethodBeat.i(9129);
        Object localObject = this.cSp;
        Matrix localMatrix = c.this.getMainMatrix();
        ((com.tencent.mm.aa.a)localObject).mMatrix.set(localMatrix);
        if (c.this.Md() != null)
        {
          localObject = (com.tencent.mm.cache.a)c.this.Md();
          if (((com.tencent.mm.cache.a)localObject).fmC != null) {
            ((com.tencent.mm.cache.a)localObject).fmC.clear();
          }
          ((com.tencent.mm.cache.a)c.this.Md()).a(this.cSp);
        }
        AppMethodBeat.o(9129);
      }
      
      public final void onStart() {}
    }, 0.0F, true);
    this.cRz.eBt().getActionBar().setVisibility(0);
    AppMethodBeat.o(9145);
  }
  
  public final void a(com.tencent.mm.bu.b paramb, Matrix paramMatrix, Rect paramRect)
  {
    AppMethodBeat.i(9137);
    super.a(paramb, paramMatrix, paramRect);
    this.cHB = new Rect();
    this.cRP = new RectF();
    this.cRO = new RectF();
    this.cRQ = new RectF();
    this.cRR = new RectF();
    this.cRT = new com.tencent.mm.aa.a(this.cHB);
    this.cRW = new com.tencent.mm.c.a(this);
    AppMethodBeat.o(9137);
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(9138);
    super.onAlive();
    if (this.cRS.isEmpty()) {
      this.cRS.set(this.cRK, this.cRK * 2, getBoardRect().width() - this.cRK, getBoardRect().height() - this.cRL - this.cRM - this.cRK * 2);
    }
    ad.i("MicroMsg.CropArtist", "[onAlive] CROP_MAX_RECT:%s", new Object[] { this.cRS });
    if (Md() == null)
    {
      ad.i("MicroMsg.CropArtist", "[onAlive] getCache is null");
      AppMethodBeat.o(9138);
      return;
    }
    com.tencent.mm.aa.a locala = ((com.tencent.mm.cache.a)Md()).Uv();
    if ((locala != null) && (!locala.gat.isEmpty()))
    {
      this.cRz.eBt().getBaseBoardView().s(locala.gat);
      float f = b(locala.mMatrix);
      ad.i("MicroMsg.CropArtist", "[onAlive] rotation:%s", new Object[] { Float.valueOf(f) });
      getMainMatrix().postRotate(-f, locala.gat.centerX(), locala.gat.centerY());
    }
    AppMethodBeat.o(9138);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9141);
    if (!this.cRV) {
      paramCanvas.setMatrix(null);
    }
    com.tencent.mm.aa.a locala;
    boolean bool1;
    boolean bool2;
    for (;;)
    {
      locala = this.cRT;
      bool1 = this.cSc;
      bool2 = this.cRU;
      if (locala.cHB != null) {
        break;
      }
      ad.e("MicroMsg.CropItem", "[draw] mBoxRect is null!");
      AppMethodBeat.o(9141);
      return;
      paramCanvas.setMatrix(this.cRN);
    }
    if (bool1)
    {
      paramCanvas.save();
      paramCanvas.clipRect(locala.cHB, Region.Op.DIFFERENCE);
      paramCanvas.drawPaint(com.tencent.mm.aa.a.gao);
      paramCanvas.restore();
    }
    if (bool2)
    {
      if (!com.tencent.mm.aa.a.Rm.equals(locala.cHB))
      {
        com.tencent.mm.aa.a.gal.reset();
        com.tencent.mm.aa.a.gal.moveTo(locala.cHB.left, locala.cHB.top);
        com.tencent.mm.aa.a.gal.lineTo(locala.cHB.right, locala.cHB.top);
        com.tencent.mm.aa.a.gal.lineTo(locala.cHB.right, locala.cHB.bottom);
        com.tencent.mm.aa.a.gal.lineTo(locala.cHB.left, locala.cHB.bottom);
        com.tencent.mm.aa.a.gal.close();
        com.tencent.mm.aa.a.gak.reset();
        int i = 1;
        while (i < 3)
        {
          com.tencent.mm.aa.a.gak.moveTo(locala.cHB.left + locala.cHB.width() / 3 * i, locala.cHB.top);
          com.tencent.mm.aa.a.gak.lineTo(locala.cHB.left + locala.cHB.width() / 3 * i, locala.cHB.bottom);
          com.tencent.mm.aa.a.gak.moveTo(locala.cHB.left, locala.cHB.top + locala.cHB.height() / 3 * i);
          com.tencent.mm.aa.a.gak.lineTo(locala.cHB.right, locala.cHB.top + locala.cHB.height() / 3 * i);
          i += 1;
        }
      }
      paramCanvas.drawRect(locala.cHB.left, locala.cHB.top, locala.cHB.right, locala.cHB.bottom, com.tencent.mm.aa.a.gan);
      paramCanvas.drawPath(com.tencent.mm.aa.a.gak, com.tencent.mm.aa.a.gaq);
      paramCanvas.drawPath(com.tencent.mm.aa.a.gal, com.tencent.mm.aa.a.gam);
      float f1 = locala.cHB.left;
      float f2 = com.tencent.mm.aa.a.gai;
      float f3 = locala.cHB.top;
      float f4 = com.tencent.mm.aa.a.gai / 2.0F;
      float f5 = locala.cHB.left;
      paramCanvas.drawLine(f1 - f2, f3 - f4, com.tencent.mm.aa.a.gaj + f5, locala.cHB.top - com.tencent.mm.aa.a.gai / 2.0F, com.tencent.mm.aa.a.gar);
      f1 = locala.cHB.right;
      f2 = com.tencent.mm.aa.a.gaj;
      f3 = com.tencent.mm.aa.a.gai / 2.0F;
      f4 = locala.cHB.top;
      f5 = com.tencent.mm.aa.a.gai / 2.0F;
      float f6 = locala.cHB.right;
      paramCanvas.drawLine(f3 + (f1 - f2), f4 - f5, com.tencent.mm.aa.a.gai + f6, locala.cHB.top - com.tencent.mm.aa.a.gai / 2.0F, com.tencent.mm.aa.a.gar);
      f1 = locala.cHB.left;
      f2 = com.tencent.mm.aa.a.gai / 2.0F;
      f3 = locala.cHB.top;
      f4 = com.tencent.mm.aa.a.gai / 2.0F;
      f5 = locala.cHB.left;
      f6 = com.tencent.mm.aa.a.gai / 2.0F;
      float f7 = locala.cHB.top;
      paramCanvas.drawLine(f1 - f2, f3 - f4, f5 - f6, com.tencent.mm.aa.a.gaj + f7, com.tencent.mm.aa.a.gar);
      f1 = locala.cHB.left;
      f2 = com.tencent.mm.aa.a.gai / 2.0F;
      f3 = locala.cHB.bottom;
      f4 = com.tencent.mm.aa.a.gaj;
      f5 = com.tencent.mm.aa.a.gai / 2.0F;
      f6 = locala.cHB.left;
      f7 = com.tencent.mm.aa.a.gai / 2.0F;
      float f8 = locala.cHB.bottom;
      paramCanvas.drawLine(f1 - f2, f5 + (f3 - f4), f6 - f7, com.tencent.mm.aa.a.gai / 2.0F + f8, com.tencent.mm.aa.a.gar);
      f1 = locala.cHB.right;
      f2 = com.tencent.mm.aa.a.gai / 2.0F;
      f3 = locala.cHB.top;
      f4 = locala.cHB.right;
      f5 = com.tencent.mm.aa.a.gai / 2.0F;
      f6 = locala.cHB.top;
      paramCanvas.drawLine(f2 + f1, f3, f5 + f4, com.tencent.mm.aa.a.gaj + f6, com.tencent.mm.aa.a.gar);
      f1 = locala.cHB.right;
      f2 = com.tencent.mm.aa.a.gai / 2.0F;
      f3 = locala.cHB.bottom;
      f4 = com.tencent.mm.aa.a.gaj;
      f5 = com.tencent.mm.aa.a.gai / 2.0F;
      f6 = locala.cHB.right;
      f7 = com.tencent.mm.aa.a.gai / 2.0F;
      f8 = locala.cHB.bottom;
      paramCanvas.drawLine(f2 + f1, f5 + (f3 - f4), f7 + f6, com.tencent.mm.aa.a.gai / 2.0F + f8, com.tencent.mm.aa.a.gar);
      f1 = locala.cHB.left;
      f2 = com.tencent.mm.aa.a.gai;
      f3 = locala.cHB.bottom;
      f4 = com.tencent.mm.aa.a.gai / 2.0F;
      f5 = locala.cHB.left;
      f6 = com.tencent.mm.aa.a.gaj;
      f7 = locala.cHB.bottom;
      paramCanvas.drawLine(f1 - f2, f4 + f3, f6 + f5, com.tencent.mm.aa.a.gai / 2.0F + f7, com.tencent.mm.aa.a.gar);
      f1 = locala.cHB.right;
      f2 = com.tencent.mm.aa.a.gaj;
      f3 = locala.cHB.bottom;
      f4 = com.tencent.mm.aa.a.gai / 2.0F;
      f5 = locala.cHB.right;
      f6 = com.tencent.mm.aa.a.gai;
      f7 = locala.cHB.bottom;
      paramCanvas.drawLine(f1 - f2, f4 + f3, f6 + f5, com.tencent.mm.aa.a.gai / 2.0F + f7, com.tencent.mm.aa.a.gar);
      if (!com.tencent.mm.aa.a.Rm.equals(locala.cHB)) {
        com.tencent.mm.aa.a.Rm.set(locala.cHB);
      }
    }
    AppMethodBeat.o(9141);
  }
  
  public final boolean p(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9142);
    if (!Mi())
    {
      AppMethodBeat.o(9142);
      return false;
    }
    Object localObject = this.cRz.eBt().getBaseBoardView().getCurImageRect();
    this.cSg = (((RectF)localObject).top - (((RectF)localObject).bottom - this.cHB.bottom));
    this.cSh = (((RectF)localObject).bottom + (this.cHB.top - ((RectF)localObject).top));
    this.cSi = (((RectF)localObject).left - (((RectF)localObject).right - this.cHB.right));
    this.cSj = (((RectF)localObject).right + (this.cHB.left - ((RectF)localObject).left));
    if (this.cSj > this.cRS.right) {
      this.cSj = this.cRS.right;
    }
    if (this.cSi < this.cRK) {
      this.cSi = this.cRK;
    }
    if (this.cSh > this.cRS.bottom) {
      this.cSh = this.cRS.bottom;
    }
    if (this.cSg < this.cRK) {
      this.cSg = this.cRK;
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
          boolean bool = this.cRX;
          AppMethodBeat.o(9142);
          return bool;
          this.cSa = false;
          this.cRY = false;
          this.cRZ = false;
          this.cSb = false;
          this.cRX = false;
        }
        this.cSd = false;
        if (this.cRW != null) {
          this.cRW.cancel();
        }
        if (this.cRP.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
          this.cSa = true;
        }
        if (this.cRO.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
          this.cRZ = true;
        }
        if (this.cRQ.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
          this.cRY = true;
        }
        if (this.cRR.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
          this.cSb = true;
        }
        this.cSc = false;
      } while (!Mm());
      if ((this.cSa) && (this.cRY))
      {
        this.cSa = true;
        this.cRY = true;
        this.cRZ = false;
        this.cSb = false;
      }
      for (;;)
      {
        this.cSe = paramMotionEvent.getX();
        this.cSf = paramMotionEvent.getY();
        break;
        if ((this.cSa) && (this.cSb))
        {
          this.cSa = true;
          this.cRY = false;
          this.cRZ = false;
          this.cSb = true;
        }
        else if ((this.cRZ) && (this.cSb))
        {
          this.cSa = false;
          this.cRY = false;
          this.cRZ = true;
          this.cSb = true;
        }
        else if ((this.cRZ) && (this.cSb))
        {
          this.cSa = false;
          this.cRY = false;
          this.cRZ = true;
          this.cSb = true;
        }
      }
    case 2: 
      this.cSd = true;
      if ((paramMotionEvent.getPointerCount() == 1) && (Mm()))
      {
        if ((this.cSb) && (this.cHB.right >= this.cHB.left))
        {
          if (this.cHB.right <= this.cRS.right)
          {
            if (paramMotionEvent.getX() - this.cSe <= this.cRS.right - this.cHB.right) {
              break label1891;
            }
            this.cHB.right = this.cRS.right;
          }
          label710:
          if (this.cHB.right < this.cHB.left + this.cRK * 2) {
            this.cHB.right = (this.cHB.left + this.cRK * 2);
          }
          if (this.cHB.right > this.cRS.right) {
            this.cHB.right = this.cRS.right;
          }
          if (((int)((RectF)localObject).right <= (int)this.cSj) && ((int)((RectF)localObject).right <= this.cHB.right))
          {
            if (paramMotionEvent.getX() - this.cSe <= this.cSj - ((RectF)localObject).right) {
              break label1922;
            }
            getMainMatrix().postTranslate(this.cSj - ((RectF)localObject).right, 0.0F);
          }
          label858:
          if ((this.cHB.width() > ((RectF)localObject).width()) && (this.cHB.right < this.cRS.right))
          {
            f1 = this.cHB.width() / ((RectF)localObject).width();
            getMainMatrix().postScale(f1, f1, this.cHB.left, this.cHB.centerY());
          }
        }
        if ((this.cRY) && (this.cHB.right >= this.cHB.left))
        {
          if (this.cHB.left >= this.cRS.left)
          {
            if (this.cSe - paramMotionEvent.getX() <= this.cHB.left - this.cRS.left) {
              break label1943;
            }
            this.cHB.left = this.cRS.left;
          }
          label1017:
          if (this.cHB.left > this.cHB.right - this.cRK * 2) {
            this.cHB.left = (this.cHB.right - this.cRK * 2);
          }
          if (this.cHB.left < this.cRS.left) {
            this.cHB.left = this.cRS.left;
          }
          if (((int)((RectF)localObject).left >= (int)this.cSi) && ((int)((RectF)localObject).left >= this.cHB.left))
          {
            if (this.cSe - paramMotionEvent.getX() <= ((RectF)localObject).left - this.cSi) {
              break label1974;
            }
            getMainMatrix().postTranslate(this.cSi - ((RectF)localObject).left, 0.0F);
          }
          label1165:
          if ((this.cHB.width() > ((RectF)localObject).width()) && (this.cHB.left > this.cRS.left))
          {
            f1 = this.cHB.width() / ((RectF)localObject).width();
            getMainMatrix().postScale(f1, f1, this.cHB.right, this.cHB.centerY());
          }
        }
        if ((this.cRZ) && (this.cHB.bottom >= this.cHB.top))
        {
          if (this.cHB.top >= this.cRS.top)
          {
            if (this.cSf - paramMotionEvent.getY() <= this.cHB.top - this.cRS.top) {
              break label1995;
            }
            this.cHB.top = this.cRS.top;
          }
          label1324:
          if (this.cHB.top > this.cHB.bottom - this.cRK * 2) {
            this.cHB.top = (this.cHB.bottom - this.cRK * 2);
          }
          if (this.cHB.top < this.cRS.top) {
            this.cHB.top = this.cRS.top;
          }
          if (((int)((RectF)localObject).top >= (int)this.cSg) && ((int)((RectF)localObject).top >= this.cHB.top))
          {
            if (this.cSf - paramMotionEvent.getY() <= ((RectF)localObject).top - this.cSg) {
              break label2026;
            }
            getMainMatrix().postTranslate(0.0F, this.cSg - ((RectF)localObject).top);
          }
          label1472:
          if ((this.cHB.height() > ((RectF)localObject).height()) && (this.cHB.top > this.cRS.top))
          {
            f1 = this.cHB.height() / ((RectF)localObject).height();
            getMainMatrix().postScale(f1, f1, this.cHB.centerX(), this.cHB.bottom);
          }
        }
        if ((this.cSa) && (this.cHB.bottom >= this.cHB.top))
        {
          if (this.cHB.bottom <= this.cRS.bottom)
          {
            if (paramMotionEvent.getY() - this.cSf <= this.cRS.bottom - this.cHB.bottom) {
              break label2047;
            }
            this.cHB.bottom = this.cRS.bottom;
          }
          label1631:
          if (this.cHB.bottom < this.cHB.top + this.cRK * 2) {
            this.cHB.bottom = (this.cHB.top + this.cRK * 2);
          }
          if (this.cHB.bottom > this.cRS.bottom) {
            this.cHB.bottom = this.cRS.bottom;
          }
          if (((int)((RectF)localObject).bottom <= (int)this.cSh) && ((int)((RectF)localObject).bottom <= this.cHB.bottom))
          {
            if (paramMotionEvent.getY() - this.cSf <= this.cSh - ((RectF)localObject).bottom) {
              break label2078;
            }
            getMainMatrix().postTranslate(0.0F, this.cSh - ((RectF)localObject).bottom);
          }
          label1779:
          if ((this.cHB.height() > ((RectF)localObject).height()) && (this.cHB.bottom < this.cRS.bottom))
          {
            f1 = this.cHB.height() / ((RectF)localObject).height();
            getMainMatrix().postScale(f1, f1, this.cHB.centerX(), this.cHB.top);
          }
        }
        Mn();
        this.cRX = true;
        Mk();
        this.cSe = paramMotionEvent.getX();
        this.cSf = paramMotionEvent.getY();
      }
      for (;;)
      {
        s(paramMotionEvent);
        break;
        label1891:
        Rect localRect = this.cHB;
        localRect.right = ((int)(localRect.right + (paramMotionEvent.getX() - this.cSe)));
        break label710;
        label1922:
        getMainMatrix().postTranslate(paramMotionEvent.getX() - this.cSe, 0.0F);
        break label858;
        label1943:
        localRect = this.cHB;
        localRect.left = ((int)(localRect.left - (this.cSe - paramMotionEvent.getX())));
        break label1017;
        label1974:
        getMainMatrix().postTranslate(paramMotionEvent.getX() - this.cSe, 0.0F);
        break label1165;
        label1995:
        localRect = this.cHB;
        localRect.top = ((int)(localRect.top - (this.cSf - paramMotionEvent.getY())));
        break label1324;
        label2026:
        getMainMatrix().postTranslate(0.0F, paramMotionEvent.getY() - this.cSf);
        break label1472;
        label2047:
        localRect = this.cHB;
        localRect.bottom = ((int)(localRect.bottom + (paramMotionEvent.getY() - this.cSf)));
        break label1631;
        label2078:
        getMainMatrix().postTranslate(0.0F, paramMotionEvent.getY() - this.cSf);
        break label1779;
        this.cRX = false;
      }
    }
    float f1 = this.cRS.width() * 1.0F / this.cHB.width();
    float f2 = this.cRS.height() * 1.0F / this.cHB.height();
    if (f1 < f2)
    {
      label2153:
      f2 = this.cRS.centerX();
      float f3 = this.cRS.centerY();
      float f4 = this.cHB.centerX();
      float f5 = this.cHB.centerY();
      if (this.cSd)
      {
        this.cRW.cHE = 1000L;
        paramMotionEvent = this.cRW;
        localObject = this.cHB;
        paramMotionEvent.cHz = (f2 - f4);
        paramMotionEvent.cHA = (f3 - f5);
        paramMotionEvent.cHB = ((Rect)localObject);
        paramMotionEvent.cHC.set(paramMotionEvent.cHB);
        paramMotionEvent.cHy = f1;
        this.cRW.play();
      }
      if (!Mm()) {
        break label2310;
      }
    }
    label2310:
    for (this.cRX = true;; this.cRX = false)
    {
      this.cSa = false;
      this.cRY = false;
      this.cRZ = false;
      this.cSb = false;
      Ml();
      break;
      f1 = f2;
      break label2153;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.e.c
 * JD-Core Version:    0.7.0.1
 */