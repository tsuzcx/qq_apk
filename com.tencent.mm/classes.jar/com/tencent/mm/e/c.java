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
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.b.a.b;

public final class c
  extends b<com.tencent.mm.cache.a>
{
  public Rect dgS;
  float dsA;
  float dsB;
  float dsC;
  float dsD;
  public ValueAnimator dsE;
  public Rect dsF;
  public int dsG;
  public boolean dsH;
  private int dsd;
  private int dse;
  private int dsf;
  private Matrix dsg;
  RectF dsh;
  RectF dsi;
  RectF dsj;
  RectF dsk;
  public final Rect dsl;
  private com.tencent.mm.z.a dsm;
  boolean dsn;
  private boolean dso;
  public com.tencent.mm.c.a dsp;
  g dsq;
  boolean dsr;
  boolean dss;
  boolean dsu;
  boolean dsv;
  boolean dsw;
  public boolean dsx;
  float dsy;
  float dsz;
  
  public c()
  {
    AppMethodBeat.i(9136);
    this.dsd = ((int)MMApplicationContext.getResources().getDimension(2131165963));
    this.dse = ((int)MMApplicationContext.getResources().getDimension(2131166336));
    this.dsf = ((int)MMApplicationContext.getResources().getDimension(2131166124));
    this.dsg = new Matrix();
    this.dsl = new Rect();
    this.dsn = false;
    this.dso = false;
    this.dsr = false;
    this.dss = false;
    this.dsu = false;
    this.dsv = false;
    this.dsw = false;
    this.dsx = true;
    this.dsF = new Rect();
    this.dsG = 0;
    this.dsH = false;
    AppMethodBeat.o(9136);
  }
  
  private boolean Yd()
  {
    return (this.dsv) || (this.dss) || (this.dsu) || (this.dsw);
  }
  
  public final a XS()
  {
    return a.drO;
  }
  
  public final void XT() {}
  
  public final void XV()
  {
    AppMethodBeat.i(9139);
    super.XV();
    this.drS.gth().getActionBar().setVisibility(8);
    this.dsF.setEmpty();
    if (XU() == null)
    {
      Log.e("MicroMsg.CropArtist", "[onSelected] getCache is null!");
      AppMethodBeat.o(9139);
      return;
    }
    com.tencent.mm.z.a locala;
    if (((com.tencent.mm.cache.a)XU()).ai(true) <= 0)
    {
      locala = new com.tencent.mm.z.a();
      locala.mMatrix.set(getMainMatrix());
      ((com.tencent.mm.cache.a)XU()).a(locala);
      Yf();
      this.drS.gth().getBaseBoardView().u(this.dgS);
      this.drS.gth().getBaseBoardView().a(new a.b()
      {
        public final void Yh()
        {
          AppMethodBeat.i(9119);
          if (c.this.XU() == null)
          {
            AppMethodBeat.o(9119);
            return;
          }
          if (((com.tencent.mm.cache.a)c.this.XU()).gpz.isIdentity())
          {
            localObject = (com.tencent.mm.cache.a)c.this.XU();
            Matrix localMatrix = c.this.getMainMatrix();
            ((com.tencent.mm.cache.a)localObject).gpz.set(localMatrix);
          }
          Object localObject = new Rect();
          if (c.this.drS.gtm() == null) {
            ((Rect)localObject).set(0, 0, c.this.drS.gth().getBaseBoardView().getBoardRect().width(), c.this.drS.gth().getBaseBoardView().getBoardRect().height());
          }
          for (;;)
          {
            c.this.drS.gth().getBaseBoardView().v((Rect)localObject);
            c.a(c.this, 200L, true, false);
            c.a(c.this);
            c.this.Yc();
            AppMethodBeat.o(9119);
            return;
            ((Rect)localObject).set(0, 0, c.this.drS.gtm().getWidth(), c.this.drS.gtm().getHeight());
          }
        }
        
        public final void onStart()
        {
          AppMethodBeat.i(9120);
          c.this.dsn = false;
          c.this.dsx = false;
          AppMethodBeat.o(9120);
        }
      }, 0.0F, false);
    }
    for (;;)
    {
      setOneFingerMoveEnable(true);
      AppMethodBeat.o(9139);
      return;
      locala = ((com.tencent.mm.cache.a)XU()).alE();
      if (locala == null)
      {
        Log.e("MicroMsg.CropArtist", "item is null!!!");
        AppMethodBeat.o(9139);
        return;
      }
      this.dgS.set(new Rect(locala.dgS));
      this.drS.gth().getBaseBoardView().u(locala.dgS);
      try
      {
        ((com.tencent.mm.cache.a)XU()).a((com.tencent.mm.z.a)locala.clone());
        this.drS.gth().getBaseBoardView().a(new a.b()
        {
          public final void Yh()
          {
            AppMethodBeat.i(9121);
            c.this.dsx = true;
            Rect localRect;
            if (c.this.drS.gtm() == null)
            {
              localRect = new Rect();
              Log.e("MicroMsg.CropArtist", "getImageBitmap is null!");
            }
            for (;;)
            {
              c.this.drS.gth().getBaseBoardView().v(localRect);
              c.a(c.this, 200L, true, false);
              c.a(c.this);
              AppMethodBeat.o(9121);
              return;
              localRect = new Rect(0, 0, c.this.drS.gtm().getWidth(), c.this.drS.gtm().getHeight());
            }
          }
          
          public final void onStart()
          {
            AppMethodBeat.i(9122);
            c.this.dsn = false;
            c.this.dsx = false;
            c.b(c.this);
            com.tencent.mm.z.a.pO(282);
            AppMethodBeat.o(9122);
          }
        }, 0.0F, false);
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.CropArtist", localCloneNotSupportedException, "", new Object[0]);
        }
      }
    }
  }
  
  public final boolean XX()
  {
    AppMethodBeat.i(9140);
    if (XU() == null)
    {
      AppMethodBeat.o(9140);
      return false;
    }
    if (!((com.tencent.mm.cache.a)XU()).gpz.equals(getMainMatrix()))
    {
      AppMethodBeat.o(9140);
      return true;
    }
    AppMethodBeat.o(9140);
    return false;
  }
  
  public final void Ye()
  {
    AppMethodBeat.i(9143);
    this.dsi.set(this.dgS.left - this.dsd, this.dgS.bottom - this.dsd, this.dgS.right + this.dsd, this.dgS.bottom + this.dsd);
    this.dsh.set(this.dgS.left - this.dsd, this.dgS.top - this.dsd, this.dgS.right + this.dsd, this.dgS.top + this.dsd);
    this.dsj.set(this.dgS.left - this.dsd, this.dgS.top - this.dsd, this.dgS.left + this.dsd, this.dgS.bottom + this.dsd);
    this.dsk.set(this.dgS.right - this.dsd, this.dgS.top - this.dsd, this.dgS.right + this.dsd, this.dgS.bottom + this.dsd);
    AppMethodBeat.o(9143);
  }
  
  public final void Yf()
  {
    AppMethodBeat.i(9144);
    if (this.drS.gtm() == null)
    {
      Log.w("MicroMsg.CropArtist", "[resetBoxRect] getImageBitmap is null!");
      AppMethodBeat.o(9144);
      return;
    }
    float f1 = this.drS.gtm().getWidth() * 1.0F / this.drS.gtm().getHeight();
    int i;
    if (f1 < this.dsl.width() * 1.0F / this.dsl.height())
    {
      float f2 = this.dsl.height();
      i = (int)((this.dsl.width() - f1 * f2) / 2.0F);
      this.dgS.set(this.dsl.left + i, this.dsl.top, this.dsl.right - i, this.dsl.bottom);
    }
    for (;;)
    {
      Ye();
      AppMethodBeat.o(9144);
      return;
      f1 = this.dsl.width() / f1;
      i = (int)((this.dsl.height() - f1) / 2.0F);
      this.dgS.set(this.dsl.left, this.dsl.top + i, this.dsl.right, this.dsl.bottom - i);
    }
  }
  
  public final void Yg()
  {
    AppMethodBeat.i(9145);
    this.drS.gth().getBaseBoardView().u(this.drS.gth().getBaseBoardView().getRawBoardRect());
    Object localObject1 = new RectF(this.dgS);
    Object localObject2 = new Matrix();
    getMainMatrix().invert((Matrix)localObject2);
    ((Matrix)localObject2).mapRect((RectF)localObject1);
    localObject2 = new Rect();
    ((RectF)localObject1).round((Rect)localObject2);
    this.drS.gth().getBaseBoardView().v((Rect)localObject2);
    localObject1 = new com.tencent.mm.z.a();
    ((com.tencent.mm.z.a)localObject1).dgS = new Rect(this.dgS);
    ((com.tencent.mm.z.a)localObject1).hof.set((Rect)localObject2);
    if (this.dsq != null)
    {
      this.drS.gth().getBaseBoardView().hgc();
      ((com.tencent.mm.z.a)localObject1).setMatrix(getMainMatrix());
      if (XU() != null)
      {
        ((com.tencent.mm.cache.a)XU()).clear();
        ((com.tencent.mm.cache.a)XU()).a((com.tencent.mm.z.a)localObject1);
      }
    }
    for (;;)
    {
      this.drS.gth().getActionBar().setVisibility(0);
      AppMethodBeat.o(9145);
      return;
      this.drS.gth().getBaseBoardView().a(new a.b()
      {
        public final void Yh()
        {
          AppMethodBeat.i(9130);
          this.dsM.setMatrix(c.this.getMainMatrix());
          if (c.this.XU() != null)
          {
            ((com.tencent.mm.cache.a)c.this.XU()).clear();
            ((com.tencent.mm.cache.a)c.this.XU()).a(this.dsM);
          }
          AppMethodBeat.o(9130);
        }
        
        public final void onStart()
        {
          AppMethodBeat.i(9131);
          AppMethodBeat.o(9131);
        }
      }, 0.0F, true);
    }
  }
  
  public final void a(com.tencent.mm.bt.b paramb, Matrix paramMatrix, Rect paramRect)
  {
    AppMethodBeat.i(9137);
    super.a(paramb, paramMatrix, paramRect);
    this.dgS = new Rect();
    this.dsi = new RectF();
    this.dsh = new RectF();
    this.dsj = new RectF();
    this.dsk = new RectF();
    this.dsm = new com.tencent.mm.z.a(this.dgS);
    this.dsp = new com.tencent.mm.c.a(this);
    AppMethodBeat.o(9137);
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(9138);
    super.onAlive();
    if (this.dsl.isEmpty()) {
      this.dsl.set(this.dsd, this.dsd * 2, getBoardRect().width() - this.dsd, getBoardRect().height() - this.dse - this.dsf - this.dsd * 2);
    }
    Log.i("MicroMsg.CropArtist", "[onAlive] CROP_MAX_RECT:%s", new Object[] { this.dsl });
    if (XU() == null)
    {
      Log.i("MicroMsg.CropArtist", "[onAlive] getCache is null");
      AppMethodBeat.o(9138);
      return;
    }
    com.tencent.mm.z.a locala = ((com.tencent.mm.cache.a)XU()).alE();
    if ((locala != null) && (!locala.hof.isEmpty()))
    {
      this.drS.gth().getBaseBoardView().v(locala.hof);
      float f = b(locala.mMatrix);
      Log.i("MicroMsg.CropArtist", "[onAlive] rotation:%s", new Object[] { Float.valueOf(f) });
      getMainMatrix().postRotate(-f, locala.hof.centerX(), locala.hof.centerY());
    }
    if ((this.drS != null) && (this.drS.gtk() > 0.0F) && (this.dsq == null)) {
      this.dsq = new g(this, this.drS.gtk(), this.dgS);
    }
    AppMethodBeat.o(9138);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(204724);
    super.onDestroy();
    this.dsq = null;
    AppMethodBeat.o(204724);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9141);
    if (!this.dso) {
      paramCanvas.setMatrix(null);
    }
    com.tencent.mm.z.a locala;
    boolean bool1;
    boolean bool2;
    for (;;)
    {
      locala = this.dsm;
      bool1 = this.dsx;
      bool2 = this.dsn;
      if (locala.dgS != null) {
        break;
      }
      Log.e("MicroMsg.CropItem", "[draw] mBoxRect is null!");
      AppMethodBeat.o(9141);
      return;
      paramCanvas.setMatrix(this.dsg);
    }
    if (bool1)
    {
      paramCanvas.save();
      paramCanvas.clipRect(locala.dgS, Region.Op.DIFFERENCE);
      paramCanvas.drawPaint(com.tencent.mm.z.a.hob);
      paramCanvas.restore();
    }
    if (bool2)
    {
      if (!com.tencent.mm.z.a.Ui.equals(locala.dgS))
      {
        com.tencent.mm.z.a.hnY.reset();
        com.tencent.mm.z.a.hnY.moveTo(locala.dgS.left, locala.dgS.top);
        com.tencent.mm.z.a.hnY.lineTo(locala.dgS.right, locala.dgS.top);
        com.tencent.mm.z.a.hnY.lineTo(locala.dgS.right, locala.dgS.bottom);
        com.tencent.mm.z.a.hnY.lineTo(locala.dgS.left, locala.dgS.bottom);
        com.tencent.mm.z.a.hnY.close();
        com.tencent.mm.z.a.hnX.reset();
        int i = 1;
        while (i < 3)
        {
          com.tencent.mm.z.a.hnX.moveTo(locala.dgS.left + locala.dgS.width() / 3 * i, locala.dgS.top);
          com.tencent.mm.z.a.hnX.lineTo(locala.dgS.left + locala.dgS.width() / 3 * i, locala.dgS.bottom);
          com.tencent.mm.z.a.hnX.moveTo(locala.dgS.left, locala.dgS.top + locala.dgS.height() / 3 * i);
          com.tencent.mm.z.a.hnX.lineTo(locala.dgS.right, locala.dgS.top + locala.dgS.height() / 3 * i);
          i += 1;
        }
      }
      paramCanvas.drawRect(locala.dgS.left, locala.dgS.top, locala.dgS.right, locala.dgS.bottom, com.tencent.mm.z.a.hoa);
      paramCanvas.drawPath(com.tencent.mm.z.a.hnX, com.tencent.mm.z.a.hoc);
      paramCanvas.drawPath(com.tencent.mm.z.a.hnY, com.tencent.mm.z.a.hnZ);
      float f1 = locala.dgS.left;
      float f2 = com.tencent.mm.z.a.hnV;
      float f3 = locala.dgS.top;
      float f4 = com.tencent.mm.z.a.hnV / 2.0F;
      float f5 = locala.dgS.left;
      paramCanvas.drawLine(f1 - f2, f3 - f4, com.tencent.mm.z.a.hnW + f5, locala.dgS.top - com.tencent.mm.z.a.hnV / 2.0F, com.tencent.mm.z.a.hod);
      f1 = locala.dgS.right;
      f2 = com.tencent.mm.z.a.hnW;
      f3 = com.tencent.mm.z.a.hnV / 2.0F;
      f4 = locala.dgS.top;
      f5 = com.tencent.mm.z.a.hnV / 2.0F;
      float f6 = locala.dgS.right;
      paramCanvas.drawLine(f3 + (f1 - f2), f4 - f5, com.tencent.mm.z.a.hnV + f6, locala.dgS.top - com.tencent.mm.z.a.hnV / 2.0F, com.tencent.mm.z.a.hod);
      f1 = locala.dgS.left;
      f2 = com.tencent.mm.z.a.hnV / 2.0F;
      f3 = locala.dgS.top;
      f4 = com.tencent.mm.z.a.hnV / 2.0F;
      f5 = locala.dgS.left;
      f6 = com.tencent.mm.z.a.hnV / 2.0F;
      float f7 = locala.dgS.top;
      paramCanvas.drawLine(f1 - f2, f3 - f4, f5 - f6, com.tencent.mm.z.a.hnW + f7, com.tencent.mm.z.a.hod);
      f1 = locala.dgS.left;
      f2 = com.tencent.mm.z.a.hnV / 2.0F;
      f3 = locala.dgS.bottom;
      f4 = com.tencent.mm.z.a.hnW;
      f5 = com.tencent.mm.z.a.hnV / 2.0F;
      f6 = locala.dgS.left;
      f7 = com.tencent.mm.z.a.hnV / 2.0F;
      float f8 = locala.dgS.bottom;
      paramCanvas.drawLine(f1 - f2, f5 + (f3 - f4), f6 - f7, com.tencent.mm.z.a.hnV / 2.0F + f8, com.tencent.mm.z.a.hod);
      f1 = locala.dgS.right;
      f2 = com.tencent.mm.z.a.hnV / 2.0F;
      f3 = locala.dgS.top;
      f4 = locala.dgS.right;
      f5 = com.tencent.mm.z.a.hnV / 2.0F;
      f6 = locala.dgS.top;
      paramCanvas.drawLine(f2 + f1, f3, f5 + f4, com.tencent.mm.z.a.hnW + f6, com.tencent.mm.z.a.hod);
      f1 = locala.dgS.right;
      f2 = com.tencent.mm.z.a.hnV / 2.0F;
      f3 = locala.dgS.bottom;
      f4 = com.tencent.mm.z.a.hnW;
      f5 = com.tencent.mm.z.a.hnV / 2.0F;
      f6 = locala.dgS.right;
      f7 = com.tencent.mm.z.a.hnV / 2.0F;
      f8 = locala.dgS.bottom;
      paramCanvas.drawLine(f2 + f1, f5 + (f3 - f4), f7 + f6, com.tencent.mm.z.a.hnV / 2.0F + f8, com.tencent.mm.z.a.hod);
      f1 = locala.dgS.left;
      f2 = com.tencent.mm.z.a.hnV;
      f3 = locala.dgS.bottom;
      f4 = com.tencent.mm.z.a.hnV / 2.0F;
      f5 = locala.dgS.left;
      f6 = com.tencent.mm.z.a.hnW;
      f7 = locala.dgS.bottom;
      paramCanvas.drawLine(f1 - f2, f4 + f3, f6 + f5, com.tencent.mm.z.a.hnV / 2.0F + f7, com.tencent.mm.z.a.hod);
      f1 = locala.dgS.right;
      f2 = com.tencent.mm.z.a.hnW;
      f3 = locala.dgS.bottom;
      f4 = com.tencent.mm.z.a.hnV / 2.0F;
      f5 = locala.dgS.right;
      f6 = com.tencent.mm.z.a.hnV;
      f7 = locala.dgS.bottom;
      paramCanvas.drawLine(f1 - f2, f4 + f3, f6 + f5, com.tencent.mm.z.a.hnV / 2.0F + f7, com.tencent.mm.z.a.hod);
      if (!com.tencent.mm.z.a.Ui.equals(locala.dgS)) {
        com.tencent.mm.z.a.Ui.set(locala.dgS);
      }
    }
    AppMethodBeat.o(9141);
  }
  
  public final boolean q(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9142);
    if (!XZ())
    {
      AppMethodBeat.o(9142);
      return false;
    }
    boolean bool;
    if (this.dsq != null)
    {
      bool = this.dsq.v(paramMotionEvent);
      AppMethodBeat.o(9142);
      return bool;
    }
    Object localObject = this.drS.gth().getBaseBoardView().getCurImageRect();
    this.dsA = (((RectF)localObject).top - (((RectF)localObject).bottom - this.dgS.bottom));
    this.dsB = (((RectF)localObject).bottom + (this.dgS.top - ((RectF)localObject).top));
    this.dsC = (((RectF)localObject).left - (((RectF)localObject).right - this.dgS.right));
    this.dsD = (((RectF)localObject).right + (this.dgS.left - ((RectF)localObject).left));
    if (this.dsD > this.dsl.right) {
      this.dsD = this.dsl.right;
    }
    if (this.dsC < this.dsd) {
      this.dsC = this.dsd;
    }
    if (this.dsB > this.dsl.bottom) {
      this.dsB = this.dsl.bottom;
    }
    if (this.dsA < this.dsd) {
      this.dsA = this.dsd;
    }
    switch (paramMotionEvent.getActionMasked())
    {
    case 3: 
    case 4: 
    default: 
    case 5: 
    case 0: 
    case 2: 
      do
      {
        do
        {
          for (;;)
          {
            bool = this.dsr;
            AppMethodBeat.o(9142);
            return bool;
            this.dsv = false;
            this.dss = false;
            this.dsu = false;
            this.dsw = false;
            this.dsr = false;
          }
          this.dsr = false;
          if (this.dsp != null) {
            this.dsp.cancel();
          }
          if (this.dsi.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            this.dsv = true;
          }
          if (this.dsh.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            this.dsu = true;
          }
          if (this.dsj.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            this.dss = true;
          }
          if (this.dsk.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            this.dsw = true;
          }
          this.dsx = false;
        } while (!Yd());
        this.dsr = true;
        if ((this.dsv) && (this.dss))
        {
          this.dsv = true;
          this.dss = true;
          this.dsu = false;
          this.dsw = false;
        }
        for (;;)
        {
          this.dsy = paramMotionEvent.getX();
          this.dsz = paramMotionEvent.getY();
          break;
          if ((this.dsv) && (this.dsw))
          {
            this.dsv = true;
            this.dss = false;
            this.dsu = false;
            this.dsw = true;
          }
          else if ((this.dsu) && (this.dsw))
          {
            this.dsv = false;
            this.dss = false;
            this.dsu = true;
            this.dsw = true;
          }
          else if ((this.dsu) && (this.dsw))
          {
            this.dsv = false;
            this.dss = false;
            this.dsu = true;
            this.dsw = true;
          }
        }
      } while (!this.dsr);
      if ((paramMotionEvent.getPointerCount() == 1) && (Yd()))
      {
        if ((this.dsw) && (this.dgS.right >= this.dgS.left))
        {
          if (this.dgS.right <= this.dsl.right)
          {
            if (paramMotionEvent.getX() - this.dsy <= this.dsl.right - this.dgS.right) {
              break label1926;
            }
            this.dgS.right = this.dsl.right;
          }
          label745:
          if (this.dgS.right < this.dgS.left + this.dsd * 2) {
            this.dgS.right = (this.dgS.left + this.dsd * 2);
          }
          if (this.dgS.right > this.dsl.right) {
            this.dgS.right = this.dsl.right;
          }
          if (((int)((RectF)localObject).right <= (int)this.dsD) && ((int)((RectF)localObject).right <= this.dgS.right))
          {
            if (paramMotionEvent.getX() - this.dsy <= this.dsD - ((RectF)localObject).right) {
              break label1957;
            }
            getMainMatrix().postTranslate(this.dsD - ((RectF)localObject).right, 0.0F);
          }
          label893:
          if ((this.dgS.width() > ((RectF)localObject).width()) && (this.dgS.right < this.dsl.right))
          {
            f1 = this.dgS.width() / ((RectF)localObject).width();
            getMainMatrix().postScale(f1, f1, this.dgS.left, this.dgS.centerY());
          }
        }
        if ((this.dss) && (this.dgS.right >= this.dgS.left))
        {
          if (this.dgS.left >= this.dsl.left)
          {
            if (this.dsy - paramMotionEvent.getX() <= this.dgS.left - this.dsl.left) {
              break label1978;
            }
            this.dgS.left = this.dsl.left;
          }
          label1052:
          if (this.dgS.left > this.dgS.right - this.dsd * 2) {
            this.dgS.left = (this.dgS.right - this.dsd * 2);
          }
          if (this.dgS.left < this.dsl.left) {
            this.dgS.left = this.dsl.left;
          }
          if (((int)((RectF)localObject).left >= (int)this.dsC) && ((int)((RectF)localObject).left >= this.dgS.left))
          {
            if (this.dsy - paramMotionEvent.getX() <= ((RectF)localObject).left - this.dsC) {
              break label2009;
            }
            getMainMatrix().postTranslate(this.dsC - ((RectF)localObject).left, 0.0F);
          }
          label1200:
          if ((this.dgS.width() > ((RectF)localObject).width()) && (this.dgS.left > this.dsl.left))
          {
            f1 = this.dgS.width() / ((RectF)localObject).width();
            getMainMatrix().postScale(f1, f1, this.dgS.right, this.dgS.centerY());
          }
        }
        if ((this.dsu) && (this.dgS.bottom >= this.dgS.top))
        {
          if (this.dgS.top >= this.dsl.top)
          {
            if (this.dsz - paramMotionEvent.getY() <= this.dgS.top - this.dsl.top) {
              break label2030;
            }
            this.dgS.top = this.dsl.top;
          }
          label1359:
          if (this.dgS.top > this.dgS.bottom - this.dsd * 2) {
            this.dgS.top = (this.dgS.bottom - this.dsd * 2);
          }
          if (this.dgS.top < this.dsl.top) {
            this.dgS.top = this.dsl.top;
          }
          if (((int)((RectF)localObject).top >= (int)this.dsA) && ((int)((RectF)localObject).top >= this.dgS.top))
          {
            if (this.dsz - paramMotionEvent.getY() <= ((RectF)localObject).top - this.dsA) {
              break label2061;
            }
            getMainMatrix().postTranslate(0.0F, this.dsA - ((RectF)localObject).top);
          }
          label1507:
          if ((this.dgS.height() > ((RectF)localObject).height()) && (this.dgS.top > this.dsl.top))
          {
            f1 = this.dgS.height() / ((RectF)localObject).height();
            getMainMatrix().postScale(f1, f1, this.dgS.centerX(), this.dgS.bottom);
          }
        }
        if ((this.dsv) && (this.dgS.bottom >= this.dgS.top))
        {
          if (this.dgS.bottom <= this.dsl.bottom)
          {
            if (paramMotionEvent.getY() - this.dsz <= this.dsl.bottom - this.dgS.bottom) {
              break label2082;
            }
            this.dgS.bottom = this.dsl.bottom;
          }
          label1666:
          if (this.dgS.bottom < this.dgS.top + this.dsd * 2) {
            this.dgS.bottom = (this.dgS.top + this.dsd * 2);
          }
          if (this.dgS.bottom > this.dsl.bottom) {
            this.dgS.bottom = this.dsl.bottom;
          }
          if (((int)((RectF)localObject).bottom <= (int)this.dsB) && ((int)((RectF)localObject).bottom <= this.dgS.bottom))
          {
            if (paramMotionEvent.getY() - this.dsz <= this.dsB - ((RectF)localObject).bottom) {
              break label2113;
            }
            getMainMatrix().postTranslate(0.0F, this.dsB - ((RectF)localObject).bottom);
          }
          label1814:
          if ((this.dgS.height() > ((RectF)localObject).height()) && (this.dgS.bottom < this.dsl.bottom))
          {
            f1 = this.dgS.height() / ((RectF)localObject).height();
            getMainMatrix().postScale(f1, f1, this.dgS.centerX(), this.dgS.top);
          }
        }
        Ye();
        this.dsr = true;
        Yb();
        this.dsy = paramMotionEvent.getX();
        this.dsz = paramMotionEvent.getY();
      }
      for (;;)
      {
        t(paramMotionEvent);
        break;
        label1926:
        Rect localRect = this.dgS;
        localRect.right = ((int)(localRect.right + (paramMotionEvent.getX() - this.dsy)));
        break label745;
        label1957:
        getMainMatrix().postTranslate(paramMotionEvent.getX() - this.dsy, 0.0F);
        break label893;
        label1978:
        localRect = this.dgS;
        localRect.left = ((int)(localRect.left - (this.dsy - paramMotionEvent.getX())));
        break label1052;
        label2009:
        getMainMatrix().postTranslate(paramMotionEvent.getX() - this.dsy, 0.0F);
        break label1200;
        label2030:
        localRect = this.dgS;
        localRect.top = ((int)(localRect.top - (this.dsz - paramMotionEvent.getY())));
        break label1359;
        label2061:
        getMainMatrix().postTranslate(0.0F, paramMotionEvent.getY() - this.dsz);
        break label1507;
        label2082:
        localRect = this.dgS;
        localRect.bottom = ((int)(localRect.bottom + (paramMotionEvent.getY() - this.dsz)));
        break label1666;
        label2113:
        getMainMatrix().postTranslate(0.0F, paramMotionEvent.getY() - this.dsz);
        break label1814;
        this.dsr = false;
      }
    }
    final float f1 = this.dsl.width() * 1.0F / this.dgS.width();
    float f2 = this.dsl.height() * 1.0F / this.dgS.height();
    label2188:
    long l;
    if (f1 < f2)
    {
      f2 = this.dsl.centerX();
      float f3 = this.dsl.centerY();
      float f4 = this.dgS.centerX();
      float f5 = this.dgS.centerY();
      paramMotionEvent = h.RTc;
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(204718);
          c.this.dsp.dgV = 1000L;
          c.this.dsp.a(f1, c.this.dgS, this.dsK, this.dsL);
          c.this.dsp.play();
          AppMethodBeat.o(204718);
        }
      };
      if (!this.dsr) {
        break label2316;
      }
      l = 0L;
      label2261:
      paramMotionEvent.n((Runnable)localObject, l);
      if (!Yd()) {
        break label2324;
      }
    }
    label2316:
    label2324:
    for (this.dsr = true;; this.dsr = false)
    {
      this.dsv = false;
      this.dss = false;
      this.dsu = false;
      this.dsw = false;
      Yc();
      break;
      f1 = f2;
      break label2188;
      l = 100L;
      break label2261;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.e.c
 * JD-Core Version:    0.7.0.1
 */