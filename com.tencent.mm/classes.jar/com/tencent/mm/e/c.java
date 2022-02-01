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
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.b.a.b;

public final class c
  extends b<com.tencent.mm.cache.a>
{
  public Rect eYz;
  private int fkQ;
  private int fkR;
  private int fkS;
  private Matrix fkT;
  RectF fkU;
  RectF fkV;
  RectF fkW;
  RectF fkX;
  public final Rect fkY;
  public com.tencent.mm.ab.a fkZ;
  boolean fla;
  private boolean flb;
  public com.tencent.mm.c.a flc;
  g fld;
  boolean fle;
  boolean flf;
  boolean flg;
  boolean flh;
  boolean fli;
  public boolean flj;
  float flk;
  float fll;
  float flm;
  float fln;
  float flo;
  float flp;
  public ValueAnimator flq;
  public Rect flr;
  public int fls;
  public boolean flt;
  
  public c()
  {
    AppMethodBeat.i(9136);
    this.fkQ = ((int)MMApplicationContext.getResources().getDimension(a.c.box_padding));
    this.fkR = ((int)MMApplicationContext.getResources().getDimension(a.c.feature_select_layout_height));
    this.fkS = ((int)MMApplicationContext.getResources().getDimension(a.c.crop_rotation_layout_height));
    this.fkT = new Matrix();
    this.fkY = new Rect();
    this.fla = false;
    this.flb = false;
    this.fle = false;
    this.flf = false;
    this.flg = false;
    this.flh = false;
    this.fli = false;
    this.flj = true;
    this.flr = new Rect();
    this.fls = 0;
    this.flt = false;
    AppMethodBeat.o(9136);
  }
  
  private boolean acJ()
  {
    return (this.flh) || (this.flf) || (this.flg) || (this.fli);
  }
  
  public final void a(com.tencent.mm.ca.b paramb, Matrix paramMatrix, Rect paramRect)
  {
    AppMethodBeat.i(9137);
    super.a(paramb, paramMatrix, paramRect);
    this.eYz = new Rect();
    this.fkV = new RectF();
    this.fkU = new RectF();
    this.fkW = new RectF();
    this.fkX = new RectF();
    this.fkZ = new com.tencent.mm.ab.a(this.eYz);
    this.flc = new com.tencent.mm.c.a(this);
    AppMethodBeat.o(9137);
  }
  
  public final void acB()
  {
    AppMethodBeat.i(9139);
    super.acB();
    this.fkE.hou().getActionBar().setVisibility(8);
    this.flr.setEmpty();
    if (acA() == null)
    {
      Log.e("MicroMsg.CropArtist", "[onSelected] getCache is null!");
      AppMethodBeat.o(9139);
      return;
    }
    com.tencent.mm.ab.a locala;
    if (((com.tencent.mm.cache.a)acA()).ai(true) <= 0)
    {
      locala = new com.tencent.mm.ab.a();
      locala.aqj.set(getMainMatrix());
      ((com.tencent.mm.cache.a)acA()).a(locala);
      acL();
      this.fkE.hou().getBaseBoardView().E(this.eYz);
      this.fkE.hou().getBaseBoardView().a(new a.b()
      {
        public final void acN()
        {
          AppMethodBeat.i(9119);
          if (c.this.acA() == null)
          {
            AppMethodBeat.o(9119);
            return;
          }
          if (((com.tencent.mm.cache.a)c.this.acA()).iTH.isIdentity())
          {
            localObject = (com.tencent.mm.cache.a)c.this.acA();
            Matrix localMatrix = c.this.getMainMatrix();
            ((com.tencent.mm.cache.a)localObject).iTH.set(localMatrix);
          }
          Object localObject = new Rect();
          if (c.this.fkE.hoy() == null) {
            ((Rect)localObject).set(0, 0, c.this.fkE.hou().getBaseBoardView().getBoardRect().width(), c.this.fkE.hou().getBaseBoardView().getBoardRect().height());
          }
          for (;;)
          {
            c.this.fkE.hou().getBaseBoardView().F((Rect)localObject);
            c.a(c.this, 200L, true, false);
            c.a(c.this);
            c.this.acI();
            AppMethodBeat.o(9119);
            return;
            ((Rect)localObject).set(0, 0, c.this.fkE.hoy().getWidth(), c.this.fkE.hoy().getHeight());
          }
        }
        
        public final void onStart()
        {
          AppMethodBeat.i(9120);
          c.this.fla = false;
          c.this.flj = false;
          AppMethodBeat.o(9120);
        }
      }, 0.0F, false);
    }
    for (;;)
    {
      setOneFingerMoveEnable(true);
      AppMethodBeat.o(9139);
      return;
      locala = ((com.tencent.mm.cache.a)acA()).arD();
      if (locala == null)
      {
        Log.e("MicroMsg.CropArtist", "item is null!!!");
        AppMethodBeat.o(9139);
        return;
      }
      this.eYz.set(new Rect(locala.eYz));
      this.fkE.hou().getBaseBoardView().E(locala.eYz);
      try
      {
        ((com.tencent.mm.cache.a)acA()).a((com.tencent.mm.ab.a)locala.clone());
        this.fkE.hou().getBaseBoardView().a(new a.b()
        {
          public final void acN()
          {
            AppMethodBeat.i(9121);
            c.this.flj = true;
            Rect localRect;
            if (c.this.fkE.hoy() == null)
            {
              localRect = new Rect();
              Log.e("MicroMsg.CropArtist", "getImageBitmap is null!");
            }
            for (;;)
            {
              c.this.fkE.hou().getBaseBoardView().F(localRect);
              c.a(c.this, 200L, true, false);
              c.a(c.this);
              AppMethodBeat.o(9121);
              return;
              localRect = new Rect(0, 0, c.this.fkE.hoy().getWidth(), c.this.fkE.hoy().getHeight());
            }
          }
          
          public final void onStart()
          {
            AppMethodBeat.i(9122);
            c.this.fla = false;
            c.this.flj = false;
            c.b(c.this);
            com.tencent.mm.ab.a.sn(282);
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
  
  public final boolean acD()
  {
    AppMethodBeat.i(9140);
    if (acA() == null)
    {
      AppMethodBeat.o(9140);
      return false;
    }
    if (!((com.tencent.mm.cache.a)acA()).iTH.equals(getMainMatrix()))
    {
      AppMethodBeat.o(9140);
      return true;
    }
    AppMethodBeat.o(9140);
    return false;
  }
  
  public final void acK()
  {
    AppMethodBeat.i(9143);
    int i = this.fkQ * 2;
    this.fkW.set(this.eYz.left - i, this.eYz.top - i, this.eYz.left + i, this.eYz.bottom + i);
    this.fkU.set(this.eYz.left - i, this.eYz.top - i, this.eYz.right + i, this.eYz.top + i);
    this.fkX.set(this.eYz.right - i, this.eYz.top - i, this.eYz.right + i, this.eYz.bottom + i);
    this.fkV.set(this.eYz.left - i, this.eYz.bottom - i, this.eYz.right + i, i + this.eYz.bottom);
    AppMethodBeat.o(9143);
  }
  
  public final void acL()
  {
    AppMethodBeat.i(9144);
    if (this.fkE.hoy() == null)
    {
      Log.w("MicroMsg.CropArtist", "[resetBoxRect] getImageBitmap is null!");
      AppMethodBeat.o(9144);
      return;
    }
    float f1 = this.fkE.hoy().getWidth() * 1.0F / this.fkE.hoy().getHeight();
    int i;
    if (f1 < this.fkY.width() * 1.0F / this.fkY.height())
    {
      float f2 = this.fkY.height();
      i = (int)((this.fkY.width() - f1 * f2) / 2.0F);
      this.eYz.set(this.fkY.left + i, this.fkY.top, this.fkY.right - i, this.fkY.bottom);
    }
    for (;;)
    {
      acK();
      AppMethodBeat.o(9144);
      return;
      f1 = this.fkY.width() / f1;
      i = (int)((this.fkY.height() - f1) / 2.0F);
      this.eYz.set(this.fkY.left, this.fkY.top + i, this.fkY.right, this.fkY.bottom - i);
    }
  }
  
  public final void acM()
  {
    AppMethodBeat.i(9145);
    this.fkE.hou().getBaseBoardView().E(this.fkE.hou().getBaseBoardView().getRawBoardRect());
    Object localObject1 = new RectF(this.eYz);
    Object localObject2 = new Matrix();
    getMainMatrix().invert((Matrix)localObject2);
    ((Matrix)localObject2).mapRect((RectF)localObject1);
    localObject2 = new Rect();
    ((RectF)localObject1).round((Rect)localObject2);
    this.fkE.hou().getBaseBoardView().F((Rect)localObject2);
    localObject1 = new com.tencent.mm.ab.a();
    ((com.tencent.mm.ab.a)localObject1).eYz = new Rect(this.eYz);
    ((com.tencent.mm.ab.a)localObject1).jZW.set((Rect)localObject2);
    if (this.fld != null)
    {
      this.fkE.hou().getBaseBoardView().ihC();
      ((com.tencent.mm.ab.a)localObject1).setMatrix(getMainMatrix());
      if (acA() != null)
      {
        ((com.tencent.mm.cache.a)acA()).clear();
        ((com.tencent.mm.cache.a)acA()).a((com.tencent.mm.ab.a)localObject1);
      }
    }
    for (;;)
    {
      this.fkE.hou().getActionBar().setVisibility(0);
      AppMethodBeat.o(9145);
      return;
      this.fkE.hou().getBaseBoardView().a(new a.b()
      {
        public final void acN()
        {
          AppMethodBeat.i(9130);
          this.flx.setMatrix(c.this.getMainMatrix());
          if (c.this.acA() != null)
          {
            ((com.tencent.mm.cache.a)c.this.acA()).clear();
            ((com.tencent.mm.cache.a)c.this.acA()).a(this.flx);
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
  
  public final a acy()
  {
    return a.fkA;
  }
  
  public final void acz() {}
  
  public final void onAlive()
  {
    AppMethodBeat.i(9138);
    super.onAlive();
    if (this.fkY.isEmpty()) {
      this.fkY.set(this.fkQ, this.fkQ * 2, getBoardRect().width() - this.fkQ, getBoardRect().height() - this.fkR - this.fkS - this.fkQ * 2);
    }
    Log.i("MicroMsg.CropArtist", "[onAlive] CROP_MAX_RECT:%s", new Object[] { this.fkY });
    if (acA() == null)
    {
      Log.i("MicroMsg.CropArtist", "[onAlive] getCache is null");
      AppMethodBeat.o(9138);
      return;
    }
    com.tencent.mm.ab.a locala = ((com.tencent.mm.cache.a)acA()).arD();
    if ((locala != null) && (!locala.jZW.isEmpty()))
    {
      this.fkE.hou().getBaseBoardView().F(locala.jZW);
      float f = b(locala.aqj);
      Log.i("MicroMsg.CropArtist", "[onAlive] rotation:%s", new Object[] { Float.valueOf(f) });
      getMainMatrix().postRotate(-f, locala.jZW.centerX(), locala.jZW.centerY());
    }
    if ((this.fkE != null) && (this.fkE.how() > 0.0F) && (this.fld == null)) {
      this.fld = new g(this, this.fkE.how(), this.eYz);
    }
    AppMethodBeat.o(9138);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(259936);
    super.onDestroy();
    this.fld = null;
    AppMethodBeat.o(259936);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9141);
    if (!this.flb) {
      paramCanvas.setMatrix(null);
    }
    com.tencent.mm.ab.a locala;
    boolean bool1;
    boolean bool2;
    for (;;)
    {
      locala = this.fkZ;
      bool1 = this.flj;
      bool2 = this.fla;
      if (locala.eYz != null) {
        break;
      }
      Log.e("MicroMsg.CropItem", "[draw] mBoxRect is null!");
      AppMethodBeat.o(9141);
      return;
      paramCanvas.setMatrix(this.fkT);
    }
    if (bool1)
    {
      paramCanvas.save();
      paramCanvas.clipRect(locala.eYz, Region.Op.DIFFERENCE);
      paramCanvas.drawPaint(com.tencent.mm.ab.a.jZS);
      paramCanvas.restore();
    }
    if (bool2)
    {
      if (!com.tencent.mm.ab.a.Si.equals(locala.eYz))
      {
        com.tencent.mm.ab.a.jZP.reset();
        com.tencent.mm.ab.a.jZP.moveTo(locala.eYz.left, locala.eYz.top);
        com.tencent.mm.ab.a.jZP.lineTo(locala.eYz.right, locala.eYz.top);
        com.tencent.mm.ab.a.jZP.lineTo(locala.eYz.right, locala.eYz.bottom);
        com.tencent.mm.ab.a.jZP.lineTo(locala.eYz.left, locala.eYz.bottom);
        com.tencent.mm.ab.a.jZP.close();
        com.tencent.mm.ab.a.jZO.reset();
        int i = 1;
        while (i < 3)
        {
          com.tencent.mm.ab.a.jZO.moveTo(locala.eYz.left + locala.eYz.width() / 3 * i, locala.eYz.top);
          com.tencent.mm.ab.a.jZO.lineTo(locala.eYz.left + locala.eYz.width() / 3 * i, locala.eYz.bottom);
          com.tencent.mm.ab.a.jZO.moveTo(locala.eYz.left, locala.eYz.top + locala.eYz.height() / 3 * i);
          com.tencent.mm.ab.a.jZO.lineTo(locala.eYz.right, locala.eYz.top + locala.eYz.height() / 3 * i);
          i += 1;
        }
      }
      paramCanvas.drawRect(locala.eYz.left, locala.eYz.top, locala.eYz.right, locala.eYz.bottom, com.tencent.mm.ab.a.jZR);
      paramCanvas.drawPath(com.tencent.mm.ab.a.jZO, com.tencent.mm.ab.a.jZT);
      paramCanvas.drawPath(com.tencent.mm.ab.a.jZP, com.tencent.mm.ab.a.jZQ);
      float f1 = locala.eYz.left;
      float f2 = com.tencent.mm.ab.a.jZM;
      float f3 = locala.eYz.top;
      float f4 = com.tencent.mm.ab.a.jZM / 2.0F;
      float f5 = locala.eYz.left;
      paramCanvas.drawLine(f1 - f2, f3 - f4, com.tencent.mm.ab.a.jZN + f5, locala.eYz.top - com.tencent.mm.ab.a.jZM / 2.0F, com.tencent.mm.ab.a.jZU);
      f1 = locala.eYz.right;
      f2 = com.tencent.mm.ab.a.jZN;
      f3 = com.tencent.mm.ab.a.jZM / 2.0F;
      f4 = locala.eYz.top;
      f5 = com.tencent.mm.ab.a.jZM / 2.0F;
      float f6 = locala.eYz.right;
      paramCanvas.drawLine(f3 + (f1 - f2), f4 - f5, com.tencent.mm.ab.a.jZM + f6, locala.eYz.top - com.tencent.mm.ab.a.jZM / 2.0F, com.tencent.mm.ab.a.jZU);
      f1 = locala.eYz.left;
      f2 = com.tencent.mm.ab.a.jZM / 2.0F;
      f3 = locala.eYz.top;
      f4 = com.tencent.mm.ab.a.jZM / 2.0F;
      f5 = locala.eYz.left;
      f6 = com.tencent.mm.ab.a.jZM / 2.0F;
      float f7 = locala.eYz.top;
      paramCanvas.drawLine(f1 - f2, f3 - f4, f5 - f6, com.tencent.mm.ab.a.jZN + f7, com.tencent.mm.ab.a.jZU);
      f1 = locala.eYz.left;
      f2 = com.tencent.mm.ab.a.jZM / 2.0F;
      f3 = locala.eYz.bottom;
      f4 = com.tencent.mm.ab.a.jZN;
      f5 = com.tencent.mm.ab.a.jZM / 2.0F;
      f6 = locala.eYz.left;
      f7 = com.tencent.mm.ab.a.jZM / 2.0F;
      float f8 = locala.eYz.bottom;
      paramCanvas.drawLine(f1 - f2, f5 + (f3 - f4), f6 - f7, com.tencent.mm.ab.a.jZM / 2.0F + f8, com.tencent.mm.ab.a.jZU);
      f1 = locala.eYz.right;
      f2 = com.tencent.mm.ab.a.jZM / 2.0F;
      f3 = locala.eYz.top;
      f4 = locala.eYz.right;
      f5 = com.tencent.mm.ab.a.jZM / 2.0F;
      f6 = locala.eYz.top;
      paramCanvas.drawLine(f2 + f1, f3, f5 + f4, com.tencent.mm.ab.a.jZN + f6, com.tencent.mm.ab.a.jZU);
      f1 = locala.eYz.right;
      f2 = com.tencent.mm.ab.a.jZM / 2.0F;
      f3 = locala.eYz.bottom;
      f4 = com.tencent.mm.ab.a.jZN;
      f5 = com.tencent.mm.ab.a.jZM / 2.0F;
      f6 = locala.eYz.right;
      f7 = com.tencent.mm.ab.a.jZM / 2.0F;
      f8 = locala.eYz.bottom;
      paramCanvas.drawLine(f2 + f1, f5 + (f3 - f4), f7 + f6, com.tencent.mm.ab.a.jZM / 2.0F + f8, com.tencent.mm.ab.a.jZU);
      f1 = locala.eYz.left;
      f2 = com.tencent.mm.ab.a.jZM;
      f3 = locala.eYz.bottom;
      f4 = com.tencent.mm.ab.a.jZM / 2.0F;
      f5 = locala.eYz.left;
      f6 = com.tencent.mm.ab.a.jZN;
      f7 = locala.eYz.bottom;
      paramCanvas.drawLine(f1 - f2, f4 + f3, f6 + f5, com.tencent.mm.ab.a.jZM / 2.0F + f7, com.tencent.mm.ab.a.jZU);
      f1 = locala.eYz.right;
      f2 = com.tencent.mm.ab.a.jZN;
      f3 = locala.eYz.bottom;
      f4 = com.tencent.mm.ab.a.jZM / 2.0F;
      f5 = locala.eYz.right;
      f6 = com.tencent.mm.ab.a.jZM;
      f7 = locala.eYz.bottom;
      paramCanvas.drawLine(f1 - f2, f4 + f3, f6 + f5, com.tencent.mm.ab.a.jZM / 2.0F + f7, com.tencent.mm.ab.a.jZU);
      if (!com.tencent.mm.ab.a.Si.equals(locala.eYz)) {
        com.tencent.mm.ab.a.Si.set(locala.eYz);
      }
    }
    AppMethodBeat.o(9141);
  }
  
  public final boolean q(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9142);
    if (!acF())
    {
      AppMethodBeat.o(9142);
      return false;
    }
    boolean bool;
    if (this.fld != null)
    {
      bool = this.fld.w(paramMotionEvent);
      AppMethodBeat.o(9142);
      return bool;
    }
    Object localObject = this.fkE.hou().getBaseBoardView().getCurImageRect();
    this.flm = (((RectF)localObject).top - (((RectF)localObject).bottom - this.eYz.bottom));
    this.fln = (((RectF)localObject).bottom + (this.eYz.top - ((RectF)localObject).top));
    this.flo = (((RectF)localObject).left - (((RectF)localObject).right - this.eYz.right));
    this.flp = (((RectF)localObject).right + (this.eYz.left - ((RectF)localObject).left));
    if (this.flp > this.fkY.right) {
      this.flp = this.fkY.right;
    }
    if (this.flo < this.fkQ) {
      this.flo = this.fkQ;
    }
    if (this.fln > this.fkY.bottom) {
      this.fln = this.fkY.bottom;
    }
    if (this.flm < this.fkQ) {
      this.flm = this.fkQ;
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
            bool = this.fle;
            AppMethodBeat.o(9142);
            return bool;
            this.flh = false;
            this.flf = false;
            this.flg = false;
            this.fli = false;
            this.fle = false;
          }
          this.fle = false;
          if (this.flc != null) {
            this.flc.cancel();
          }
          if (this.fkV.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            this.flh = true;
          }
          if (this.fkU.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            this.flg = true;
          }
          if (this.fkW.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            this.flf = true;
          }
          if (this.fkX.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            this.fli = true;
          }
          this.flj = false;
        } while (!acJ());
        this.fle = true;
        if ((this.flh) && (this.flf))
        {
          this.flh = true;
          this.flf = true;
          this.flg = false;
          this.fli = false;
        }
        for (;;)
        {
          this.flk = paramMotionEvent.getX();
          this.fll = paramMotionEvent.getY();
          break;
          if ((this.flh) && (this.fli))
          {
            this.flh = true;
            this.flf = false;
            this.flg = false;
            this.fli = true;
          }
          else if ((this.flg) && (this.fli))
          {
            this.flh = false;
            this.flf = false;
            this.flg = true;
            this.fli = true;
          }
          else if ((this.flg) && (this.fli))
          {
            this.flh = false;
            this.flf = false;
            this.flg = true;
            this.fli = true;
          }
        }
      } while (!this.fle);
      if ((paramMotionEvent.getPointerCount() == 1) && (acJ()))
      {
        if ((this.fli) && (this.eYz.right >= this.eYz.left))
        {
          if (this.eYz.right <= this.fkY.right)
          {
            if (paramMotionEvent.getX() - this.flk <= this.fkY.right - this.eYz.right) {
              break label1926;
            }
            this.eYz.right = this.fkY.right;
          }
          label745:
          if (this.eYz.right < this.eYz.left + this.fkQ * 2) {
            this.eYz.right = (this.eYz.left + this.fkQ * 2);
          }
          if (this.eYz.right > this.fkY.right) {
            this.eYz.right = this.fkY.right;
          }
          if (((int)((RectF)localObject).right <= (int)this.flp) && ((int)((RectF)localObject).right <= this.eYz.right))
          {
            if (paramMotionEvent.getX() - this.flk <= this.flp - ((RectF)localObject).right) {
              break label1957;
            }
            getMainMatrix().postTranslate(this.flp - ((RectF)localObject).right, 0.0F);
          }
          label893:
          if ((this.eYz.width() > ((RectF)localObject).width()) && (this.eYz.right < this.fkY.right))
          {
            f1 = this.eYz.width() / ((RectF)localObject).width();
            getMainMatrix().postScale(f1, f1, this.eYz.left, this.eYz.centerY());
          }
        }
        if ((this.flf) && (this.eYz.right >= this.eYz.left))
        {
          if (this.eYz.left >= this.fkY.left)
          {
            if (this.flk - paramMotionEvent.getX() <= this.eYz.left - this.fkY.left) {
              break label1978;
            }
            this.eYz.left = this.fkY.left;
          }
          label1052:
          if (this.eYz.left > this.eYz.right - this.fkQ * 2) {
            this.eYz.left = (this.eYz.right - this.fkQ * 2);
          }
          if (this.eYz.left < this.fkY.left) {
            this.eYz.left = this.fkY.left;
          }
          if (((int)((RectF)localObject).left >= (int)this.flo) && ((int)((RectF)localObject).left >= this.eYz.left))
          {
            if (this.flk - paramMotionEvent.getX() <= ((RectF)localObject).left - this.flo) {
              break label2009;
            }
            getMainMatrix().postTranslate(this.flo - ((RectF)localObject).left, 0.0F);
          }
          label1200:
          if ((this.eYz.width() > ((RectF)localObject).width()) && (this.eYz.left > this.fkY.left))
          {
            f1 = this.eYz.width() / ((RectF)localObject).width();
            getMainMatrix().postScale(f1, f1, this.eYz.right, this.eYz.centerY());
          }
        }
        if ((this.flg) && (this.eYz.bottom >= this.eYz.top))
        {
          if (this.eYz.top >= this.fkY.top)
          {
            if (this.fll - paramMotionEvent.getY() <= this.eYz.top - this.fkY.top) {
              break label2030;
            }
            this.eYz.top = this.fkY.top;
          }
          label1359:
          if (this.eYz.top > this.eYz.bottom - this.fkQ * 2) {
            this.eYz.top = (this.eYz.bottom - this.fkQ * 2);
          }
          if (this.eYz.top < this.fkY.top) {
            this.eYz.top = this.fkY.top;
          }
          if (((int)((RectF)localObject).top >= (int)this.flm) && ((int)((RectF)localObject).top >= this.eYz.top))
          {
            if (this.fll - paramMotionEvent.getY() <= ((RectF)localObject).top - this.flm) {
              break label2061;
            }
            getMainMatrix().postTranslate(0.0F, this.flm - ((RectF)localObject).top);
          }
          label1507:
          if ((this.eYz.height() > ((RectF)localObject).height()) && (this.eYz.top > this.fkY.top))
          {
            f1 = this.eYz.height() / ((RectF)localObject).height();
            getMainMatrix().postScale(f1, f1, this.eYz.centerX(), this.eYz.bottom);
          }
        }
        if ((this.flh) && (this.eYz.bottom >= this.eYz.top))
        {
          if (this.eYz.bottom <= this.fkY.bottom)
          {
            if (paramMotionEvent.getY() - this.fll <= this.fkY.bottom - this.eYz.bottom) {
              break label2082;
            }
            this.eYz.bottom = this.fkY.bottom;
          }
          label1666:
          if (this.eYz.bottom < this.eYz.top + this.fkQ * 2) {
            this.eYz.bottom = (this.eYz.top + this.fkQ * 2);
          }
          if (this.eYz.bottom > this.fkY.bottom) {
            this.eYz.bottom = this.fkY.bottom;
          }
          if (((int)((RectF)localObject).bottom <= (int)this.fln) && ((int)((RectF)localObject).bottom <= this.eYz.bottom))
          {
            if (paramMotionEvent.getY() - this.fll <= this.fln - ((RectF)localObject).bottom) {
              break label2113;
            }
            getMainMatrix().postTranslate(0.0F, this.fln - ((RectF)localObject).bottom);
          }
          label1814:
          if ((this.eYz.height() > ((RectF)localObject).height()) && (this.eYz.bottom < this.fkY.bottom))
          {
            f1 = this.eYz.height() / ((RectF)localObject).height();
            getMainMatrix().postScale(f1, f1, this.eYz.centerX(), this.eYz.top);
          }
        }
        acK();
        this.fle = true;
        acH();
        this.flk = paramMotionEvent.getX();
        this.fll = paramMotionEvent.getY();
      }
      for (;;)
      {
        u(paramMotionEvent);
        break;
        label1926:
        Rect localRect = this.eYz;
        localRect.right = ((int)(localRect.right + (paramMotionEvent.getX() - this.flk)));
        break label745;
        label1957:
        getMainMatrix().postTranslate(paramMotionEvent.getX() - this.flk, 0.0F);
        break label893;
        label1978:
        localRect = this.eYz;
        localRect.left = ((int)(localRect.left - (this.flk - paramMotionEvent.getX())));
        break label1052;
        label2009:
        getMainMatrix().postTranslate(paramMotionEvent.getX() - this.flk, 0.0F);
        break label1200;
        label2030:
        localRect = this.eYz;
        localRect.top = ((int)(localRect.top - (this.fll - paramMotionEvent.getY())));
        break label1359;
        label2061:
        getMainMatrix().postTranslate(0.0F, paramMotionEvent.getY() - this.fll);
        break label1507;
        label2082:
        localRect = this.eYz;
        localRect.bottom = ((int)(localRect.bottom + (paramMotionEvent.getY() - this.fll)));
        break label1666;
        label2113:
        getMainMatrix().postTranslate(0.0F, paramMotionEvent.getY() - this.fll);
        break label1814;
        this.fle = false;
      }
    }
    final float f1 = this.fkY.width() * 1.0F / this.eYz.width();
    float f2 = this.fkY.height() * 1.0F / this.eYz.height();
    label2188:
    long l;
    if (f1 < f2)
    {
      f2 = this.fkY.centerX();
      float f3 = this.fkY.centerY();
      float f4 = this.eYz.centerX();
      float f5 = this.eYz.centerY();
      paramMotionEvent = h.ZvG;
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(259733);
          c.this.flc.eYC = 1000L;
          c.this.flc.a(f1, c.this.eYz, this.flv, this.flw);
          c.this.flc.play();
          AppMethodBeat.o(259733);
        }
      };
      if (!this.fle) {
        break label2316;
      }
      l = 0L;
      label2261:
      paramMotionEvent.n((Runnable)localObject, l);
      if (!acJ()) {
        break label2324;
      }
    }
    label2316:
    label2324:
    for (this.fle = true;; this.fle = false)
    {
      this.flh = false;
      this.flf = false;
      this.flg = false;
      this.fli = false;
      acI();
      break;
      f1 = f2;
      break label2188;
      l = 100L;
      break label2261;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.e.c
 * JD-Core Version:    0.7.0.1
 */