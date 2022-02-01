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
import com.tencent.mm.bo.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.b.a.b;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

public final class c
  extends b<com.tencent.mm.cache.a>
{
  public Rect hbZ;
  float hpA;
  float hpB;
  float hpC;
  public ValueAnimator hpD;
  public Rect hpE;
  public int hpF;
  public boolean hpG;
  private int hpd;
  private int hpe;
  private int hpf;
  private Matrix hpg;
  RectF hph;
  RectF hpi;
  RectF hpj;
  RectF hpk;
  public final Rect hpl;
  public com.tencent.mm.ab.a hpm;
  boolean hpn;
  private boolean hpo;
  public com.tencent.mm.c.a hpp;
  g hpq;
  boolean hpr;
  boolean hps;
  boolean hpt;
  boolean hpu;
  boolean hpv;
  public boolean hpw;
  float hpx;
  float hpy;
  float hpz;
  
  public c()
  {
    AppMethodBeat.i(9136);
    this.hpd = ((int)MMApplicationContext.getResources().getDimension(a.c.box_padding));
    this.hpe = ((int)MMApplicationContext.getResources().getDimension(a.c.feature_select_layout_height));
    this.hpf = ((int)MMApplicationContext.getResources().getDimension(a.c.crop_rotation_layout_height));
    this.hpg = new Matrix();
    this.hpl = new Rect();
    this.hpn = false;
    this.hpo = false;
    this.hpr = false;
    this.hps = false;
    this.hpt = false;
    this.hpu = false;
    this.hpv = false;
    this.hpw = true;
    this.hpE = new Rect();
    this.hpF = 0;
    this.hpG = false;
    AppMethodBeat.o(9136);
  }
  
  private boolean aEJ()
  {
    return (this.hpu) || (this.hps) || (this.hpt) || (this.hpv);
  }
  
  public final void a(com.tencent.mm.bt.b paramb, Matrix paramMatrix, Rect paramRect)
  {
    AppMethodBeat.i(9137);
    super.a(paramb, paramMatrix, paramRect);
    this.hbZ = new Rect();
    this.hpi = new RectF();
    this.hph = new RectF();
    this.hpj = new RectF();
    this.hpk = new RectF();
    this.hpm = new com.tencent.mm.ab.a(this.hbZ);
    this.hpp = new com.tencent.mm.c.a(this);
    AppMethodBeat.o(9137);
  }
  
  public final void aEB()
  {
    AppMethodBeat.i(9139);
    super.aEB();
    this.hoR.iPo().getActionBar().setVisibility(8);
    this.hpE.setEmpty();
    if (aEA() == null)
    {
      Log.e("MicroMsg.CropArtist", "[onSelected] getCache is null!");
      AppMethodBeat.o(9139);
      return;
    }
    com.tencent.mm.ab.a locala;
    if (((com.tencent.mm.cache.a)aEA()).aR(true) <= 0)
    {
      locala = new com.tencent.mm.ab.a();
      locala.avQ.set(getMainMatrix());
      ((com.tencent.mm.cache.a)aEA()).a(locala);
      aEL();
      this.hoR.iPo().getBaseBoardView().M(this.hbZ);
      this.hoR.iPo().getBaseBoardView().a(new a.b()
      {
        public final void aEN()
        {
          AppMethodBeat.i(9119);
          if (c.this.aEA() == null)
          {
            AppMethodBeat.o(9119);
            return;
          }
          if (((com.tencent.mm.cache.a)c.this.aEA()).lvN.isIdentity())
          {
            localObject = (com.tencent.mm.cache.a)c.this.aEA();
            Matrix localMatrix = c.this.getMainMatrix();
            ((com.tencent.mm.cache.a)localObject).lvN.set(localMatrix);
          }
          Object localObject = new Rect();
          if (c.this.hoR.iPu() == null) {
            ((Rect)localObject).set(0, 0, c.this.hoR.iPo().getBaseBoardView().getBoardRect().width(), c.this.hoR.iPo().getBaseBoardView().getBoardRect().height());
          }
          for (;;)
          {
            c.this.hoR.iPo().getBaseBoardView().N((Rect)localObject);
            c.a(c.this, 200L, true, false);
            c.a(c.this);
            c.this.aEI();
            AppMethodBeat.o(9119);
            return;
            ((Rect)localObject).set(0, 0, c.this.hoR.iPu().getWidth(), c.this.hoR.iPu().getHeight());
          }
        }
        
        public final void onStart()
        {
          AppMethodBeat.i(9120);
          c.this.hpn = false;
          c.this.hpw = false;
          AppMethodBeat.o(9120);
        }
      }, 0.0F, false);
    }
    for (;;)
    {
      setOneFingerMoveEnable(true);
      AppMethodBeat.o(9139);
      return;
      locala = ((com.tencent.mm.cache.a)aEA()).aLz();
      if (locala == null)
      {
        Log.e("MicroMsg.CropArtist", "item is null!!!");
        AppMethodBeat.o(9139);
        return;
      }
      this.hbZ.set(new Rect(locala.hbZ));
      this.hoR.iPo().getBaseBoardView().M(locala.hbZ);
      try
      {
        ((com.tencent.mm.cache.a)aEA()).a((com.tencent.mm.ab.a)locala.clone());
        this.hoR.iPo().getBaseBoardView().a(new a.b()
        {
          public final void aEN()
          {
            AppMethodBeat.i(9121);
            c.this.hpw = true;
            Rect localRect;
            if (c.this.hoR.iPu() == null)
            {
              localRect = new Rect();
              Log.e("MicroMsg.CropArtist", "getImageBitmap is null!");
            }
            for (;;)
            {
              c.this.hoR.iPo().getBaseBoardView().N(localRect);
              c.a(c.this, 200L, true, false);
              c.a(c.this);
              AppMethodBeat.o(9121);
              return;
              localRect = new Rect(0, 0, c.this.hoR.iPu().getWidth(), c.this.hoR.iPu().getHeight());
            }
          }
          
          public final void onStart()
          {
            AppMethodBeat.i(9122);
            c.this.hpn = false;
            c.this.hpw = false;
            c.b(c.this);
            com.tencent.mm.ab.a.sj(282);
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
  
  public final boolean aED()
  {
    AppMethodBeat.i(9140);
    if (aEA() == null)
    {
      AppMethodBeat.o(9140);
      return false;
    }
    if (!((com.tencent.mm.cache.a)aEA()).lvN.equals(getMainMatrix()))
    {
      AppMethodBeat.o(9140);
      return true;
    }
    AppMethodBeat.o(9140);
    return false;
  }
  
  public final void aEK()
  {
    AppMethodBeat.i(9143);
    int i = this.hpd * 2;
    this.hpj.set(this.hbZ.left - i, this.hbZ.top - i, this.hbZ.left + i, this.hbZ.bottom + i);
    this.hph.set(this.hbZ.left - i, this.hbZ.top - i, this.hbZ.right + i, this.hbZ.top + i);
    this.hpk.set(this.hbZ.right - i, this.hbZ.top - i, this.hbZ.right + i, this.hbZ.bottom + i);
    this.hpi.set(this.hbZ.left - i, this.hbZ.bottom - i, this.hbZ.right + i, i + this.hbZ.bottom);
    AppMethodBeat.o(9143);
  }
  
  public final void aEL()
  {
    AppMethodBeat.i(9144);
    if (this.hoR.iPu() == null)
    {
      Log.w("MicroMsg.CropArtist", "[resetBoxRect] getImageBitmap is null!");
      AppMethodBeat.o(9144);
      return;
    }
    float f1 = this.hoR.iPu().getWidth() * 1.0F / this.hoR.iPu().getHeight();
    int i;
    if (f1 < this.hpl.width() * 1.0F / this.hpl.height())
    {
      float f2 = this.hpl.height();
      i = (int)((this.hpl.width() - f1 * f2) / 2.0F);
      this.hbZ.set(this.hpl.left + i, this.hpl.top, this.hpl.right - i, this.hpl.bottom);
    }
    for (;;)
    {
      aEK();
      AppMethodBeat.o(9144);
      return;
      f1 = this.hpl.width() / f1;
      i = (int)((this.hpl.height() - f1) / 2.0F);
      this.hbZ.set(this.hpl.left, this.hpl.top + i, this.hpl.right, this.hpl.bottom - i);
    }
  }
  
  public final void aEM()
  {
    AppMethodBeat.i(9145);
    this.hoR.iPo().getBaseBoardView().M(this.hoR.iPo().getBaseBoardView().getRawBoardRect());
    Object localObject1 = new RectF(this.hbZ);
    Object localObject2 = new Matrix();
    getMainMatrix().invert((Matrix)localObject2);
    ((Matrix)localObject2).mapRect((RectF)localObject1);
    localObject2 = new Rect();
    ((RectF)localObject1).round((Rect)localObject2);
    this.hoR.iPo().getBaseBoardView().N((Rect)localObject2);
    localObject1 = new com.tencent.mm.ab.a();
    ((com.tencent.mm.ab.a)localObject1).hbZ = new Rect(this.hbZ);
    ((com.tencent.mm.ab.a)localObject1).Qv.set((Rect)localObject2);
    if (this.hpq != null)
    {
      this.hoR.iPo().getBaseBoardView().jMP();
      ((com.tencent.mm.ab.a)localObject1).setMatrix(getMainMatrix());
      if (aEA() != null)
      {
        ((com.tencent.mm.cache.a)aEA()).clear();
        ((com.tencent.mm.cache.a)aEA()).a((com.tencent.mm.ab.a)localObject1);
      }
    }
    for (;;)
    {
      this.hoR.iPo().getActionBar().setVisibility(0);
      AppMethodBeat.o(9145);
      return;
      this.hoR.iPo().getBaseBoardView().a(new a.b()
      {
        public final void aEN()
        {
          AppMethodBeat.i(9130);
          this.hpK.setMatrix(c.this.getMainMatrix());
          if (c.this.aEA() != null)
          {
            ((com.tencent.mm.cache.a)c.this.aEA()).clear();
            ((com.tencent.mm.cache.a)c.this.aEA()).a(this.hpK);
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
  
  public final a aEy()
  {
    return a.hoN;
  }
  
  public final void aEz() {}
  
  public final void onAlive()
  {
    AppMethodBeat.i(9138);
    super.onAlive();
    if (this.hpl.isEmpty()) {
      this.hpl.set(this.hpd, this.hpd * 2, getBoardRect().width() - this.hpd, getBoardRect().height() - this.hpe - this.hpf - this.hpd * 2);
    }
    Log.i("MicroMsg.CropArtist", "[onAlive] CROP_MAX_RECT:%s", new Object[] { this.hpl });
    if (aEA() == null)
    {
      Log.i("MicroMsg.CropArtist", "[onAlive] getCache is null");
      AppMethodBeat.o(9138);
      return;
    }
    com.tencent.mm.ab.a locala = ((com.tencent.mm.cache.a)aEA()).aLz();
    if ((locala != null) && (!locala.Qv.isEmpty()))
    {
      this.hoR.iPo().getBaseBoardView().N(locala.Qv);
      float f = d(locala.avQ);
      Log.i("MicroMsg.CropArtist", "[onAlive] rotation:%s", new Object[] { Float.valueOf(f) });
      getMainMatrix().postRotate(-f, locala.Qv.centerX(), locala.Qv.centerY());
    }
    if ((this.hoR != null) && (this.hoR.iPq() > 0.0F) && (this.hpq == null)) {
      this.hpq = new g(this, this.hoR.iPq(), this.hbZ);
    }
    AppMethodBeat.o(9138);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(231877);
    super.onDestroy();
    this.hpq = null;
    AppMethodBeat.o(231877);
  }
  
  public final boolean onDispatchTouch(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9142);
    if (!aEF())
    {
      AppMethodBeat.o(9142);
      return false;
    }
    boolean bool;
    if (this.hpq != null)
    {
      bool = this.hpq.v(paramMotionEvent);
      AppMethodBeat.o(9142);
      return bool;
    }
    Object localObject = this.hoR.iPo().getBaseBoardView().getCurImageRect();
    this.hpz = (((RectF)localObject).top - (((RectF)localObject).bottom - this.hbZ.bottom));
    this.hpA = (((RectF)localObject).bottom + (this.hbZ.top - ((RectF)localObject).top));
    this.hpB = (((RectF)localObject).left - (((RectF)localObject).right - this.hbZ.right));
    this.hpC = (((RectF)localObject).right + (this.hbZ.left - ((RectF)localObject).left));
    if (this.hpC > this.hpl.right) {
      this.hpC = this.hpl.right;
    }
    if (this.hpB < this.hpd) {
      this.hpB = this.hpd;
    }
    if (this.hpA > this.hpl.bottom) {
      this.hpA = this.hpl.bottom;
    }
    if (this.hpz < this.hpd) {
      this.hpz = this.hpd;
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
            bool = this.hpr;
            AppMethodBeat.o(9142);
            return bool;
            this.hpu = false;
            this.hps = false;
            this.hpt = false;
            this.hpv = false;
            this.hpr = false;
          }
          this.hpr = false;
          if (this.hpp != null) {
            this.hpp.cancel();
          }
          if (this.hpi.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            this.hpu = true;
          }
          if (this.hph.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            this.hpt = true;
          }
          if (this.hpj.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            this.hps = true;
          }
          if (this.hpk.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            this.hpv = true;
          }
          this.hpw = false;
        } while (!aEJ());
        this.hpr = true;
        if ((this.hpu) && (this.hps))
        {
          this.hpu = true;
          this.hps = true;
          this.hpt = false;
          this.hpv = false;
        }
        for (;;)
        {
          this.hpx = paramMotionEvent.getX();
          this.hpy = paramMotionEvent.getY();
          break;
          if ((this.hpu) && (this.hpv))
          {
            this.hpu = true;
            this.hps = false;
            this.hpt = false;
            this.hpv = true;
          }
          else if ((this.hpt) && (this.hpv))
          {
            this.hpu = false;
            this.hps = false;
            this.hpt = true;
            this.hpv = true;
          }
          else if ((this.hpt) && (this.hpv))
          {
            this.hpu = false;
            this.hps = false;
            this.hpt = true;
            this.hpv = true;
          }
        }
      } while (!this.hpr);
      if ((paramMotionEvent.getPointerCount() == 1) && (aEJ()))
      {
        if ((this.hpv) && (this.hbZ.right >= this.hbZ.left))
        {
          if (this.hbZ.right <= this.hpl.right)
          {
            if (paramMotionEvent.getX() - this.hpx <= this.hpl.right - this.hbZ.right) {
              break label1926;
            }
            this.hbZ.right = this.hpl.right;
          }
          label745:
          if (this.hbZ.right < this.hbZ.left + this.hpd * 2) {
            this.hbZ.right = (this.hbZ.left + this.hpd * 2);
          }
          if (this.hbZ.right > this.hpl.right) {
            this.hbZ.right = this.hpl.right;
          }
          if (((int)((RectF)localObject).right <= (int)this.hpC) && ((int)((RectF)localObject).right <= this.hbZ.right))
          {
            if (paramMotionEvent.getX() - this.hpx <= this.hpC - ((RectF)localObject).right) {
              break label1957;
            }
            getMainMatrix().postTranslate(this.hpC - ((RectF)localObject).right, 0.0F);
          }
          label893:
          if ((this.hbZ.width() > ((RectF)localObject).width()) && (this.hbZ.right < this.hpl.right))
          {
            f1 = this.hbZ.width() / ((RectF)localObject).width();
            getMainMatrix().postScale(f1, f1, this.hbZ.left, this.hbZ.centerY());
          }
        }
        if ((this.hps) && (this.hbZ.right >= this.hbZ.left))
        {
          if (this.hbZ.left >= this.hpl.left)
          {
            if (this.hpx - paramMotionEvent.getX() <= this.hbZ.left - this.hpl.left) {
              break label1978;
            }
            this.hbZ.left = this.hpl.left;
          }
          label1052:
          if (this.hbZ.left > this.hbZ.right - this.hpd * 2) {
            this.hbZ.left = (this.hbZ.right - this.hpd * 2);
          }
          if (this.hbZ.left < this.hpl.left) {
            this.hbZ.left = this.hpl.left;
          }
          if (((int)((RectF)localObject).left >= (int)this.hpB) && ((int)((RectF)localObject).left >= this.hbZ.left))
          {
            if (this.hpx - paramMotionEvent.getX() <= ((RectF)localObject).left - this.hpB) {
              break label2009;
            }
            getMainMatrix().postTranslate(this.hpB - ((RectF)localObject).left, 0.0F);
          }
          label1200:
          if ((this.hbZ.width() > ((RectF)localObject).width()) && (this.hbZ.left > this.hpl.left))
          {
            f1 = this.hbZ.width() / ((RectF)localObject).width();
            getMainMatrix().postScale(f1, f1, this.hbZ.right, this.hbZ.centerY());
          }
        }
        if ((this.hpt) && (this.hbZ.bottom >= this.hbZ.top))
        {
          if (this.hbZ.top >= this.hpl.top)
          {
            if (this.hpy - paramMotionEvent.getY() <= this.hbZ.top - this.hpl.top) {
              break label2030;
            }
            this.hbZ.top = this.hpl.top;
          }
          label1359:
          if (this.hbZ.top > this.hbZ.bottom - this.hpd * 2) {
            this.hbZ.top = (this.hbZ.bottom - this.hpd * 2);
          }
          if (this.hbZ.top < this.hpl.top) {
            this.hbZ.top = this.hpl.top;
          }
          if (((int)((RectF)localObject).top >= (int)this.hpz) && ((int)((RectF)localObject).top >= this.hbZ.top))
          {
            if (this.hpy - paramMotionEvent.getY() <= ((RectF)localObject).top - this.hpz) {
              break label2061;
            }
            getMainMatrix().postTranslate(0.0F, this.hpz - ((RectF)localObject).top);
          }
          label1507:
          if ((this.hbZ.height() > ((RectF)localObject).height()) && (this.hbZ.top > this.hpl.top))
          {
            f1 = this.hbZ.height() / ((RectF)localObject).height();
            getMainMatrix().postScale(f1, f1, this.hbZ.centerX(), this.hbZ.bottom);
          }
        }
        if ((this.hpu) && (this.hbZ.bottom >= this.hbZ.top))
        {
          if (this.hbZ.bottom <= this.hpl.bottom)
          {
            if (paramMotionEvent.getY() - this.hpy <= this.hpl.bottom - this.hbZ.bottom) {
              break label2082;
            }
            this.hbZ.bottom = this.hpl.bottom;
          }
          label1666:
          if (this.hbZ.bottom < this.hbZ.top + this.hpd * 2) {
            this.hbZ.bottom = (this.hbZ.top + this.hpd * 2);
          }
          if (this.hbZ.bottom > this.hpl.bottom) {
            this.hbZ.bottom = this.hpl.bottom;
          }
          if (((int)((RectF)localObject).bottom <= (int)this.hpA) && ((int)((RectF)localObject).bottom <= this.hbZ.bottom))
          {
            if (paramMotionEvent.getY() - this.hpy <= this.hpA - ((RectF)localObject).bottom) {
              break label2113;
            }
            getMainMatrix().postTranslate(0.0F, this.hpA - ((RectF)localObject).bottom);
          }
          label1814:
          if ((this.hbZ.height() > ((RectF)localObject).height()) && (this.hbZ.bottom < this.hpl.bottom))
          {
            f1 = this.hbZ.height() / ((RectF)localObject).height();
            getMainMatrix().postScale(f1, f1, this.hbZ.centerX(), this.hbZ.top);
          }
        }
        aEK();
        this.hpr = true;
        aEH();
        this.hpx = paramMotionEvent.getX();
        this.hpy = paramMotionEvent.getY();
      }
      for (;;)
      {
        t(paramMotionEvent);
        break;
        label1926:
        Rect localRect = this.hbZ;
        localRect.right = ((int)(localRect.right + (paramMotionEvent.getX() - this.hpx)));
        break label745;
        label1957:
        getMainMatrix().postTranslate(paramMotionEvent.getX() - this.hpx, 0.0F);
        break label893;
        label1978:
        localRect = this.hbZ;
        localRect.left = ((int)(localRect.left - (this.hpx - paramMotionEvent.getX())));
        break label1052;
        label2009:
        getMainMatrix().postTranslate(paramMotionEvent.getX() - this.hpx, 0.0F);
        break label1200;
        label2030:
        localRect = this.hbZ;
        localRect.top = ((int)(localRect.top - (this.hpy - paramMotionEvent.getY())));
        break label1359;
        label2061:
        getMainMatrix().postTranslate(0.0F, paramMotionEvent.getY() - this.hpy);
        break label1507;
        label2082:
        localRect = this.hbZ;
        localRect.bottom = ((int)(localRect.bottom + (paramMotionEvent.getY() - this.hpy)));
        break label1666;
        label2113:
        getMainMatrix().postTranslate(0.0F, paramMotionEvent.getY() - this.hpy);
        break label1814;
        this.hpr = false;
      }
    }
    final float f1 = this.hpl.width() * 1.0F / this.hbZ.width();
    float f2 = this.hpl.height() * 1.0F / this.hbZ.height();
    label2188:
    long l;
    if (f1 < f2)
    {
      f2 = this.hpl.centerX();
      float f3 = this.hpl.centerY();
      float f4 = this.hbZ.centerX();
      float f5 = this.hbZ.centerY();
      paramMotionEvent = h.ahAA;
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(231847);
          c.this.hpp.hcc = 1000L;
          c.this.hpp.a(f1, c.this.hbZ, this.hpI, this.hpJ);
          c.this.hpp.play();
          AppMethodBeat.o(231847);
        }
      };
      if (!this.hpr) {
        break label2316;
      }
      l = 0L;
      label2261:
      paramMotionEvent.o((Runnable)localObject, l);
      if (!aEJ()) {
        break label2324;
      }
    }
    label2316:
    label2324:
    for (this.hpr = true;; this.hpr = false)
    {
      this.hpu = false;
      this.hps = false;
      this.hpt = false;
      this.hpv = false;
      aEI();
      break;
      f1 = f2;
      break label2188;
      l = 100L;
      break label2261;
    }
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9141);
    if (!this.hpo) {
      paramCanvas.setMatrix(null);
    }
    com.tencent.mm.ab.a locala;
    boolean bool1;
    boolean bool2;
    for (;;)
    {
      locala = this.hpm;
      bool1 = this.hpw;
      bool2 = this.hpn;
      if (locala.hbZ != null) {
        break;
      }
      Log.e("MicroMsg.CropItem", "[draw] mBoxRect is null!");
      AppMethodBeat.o(9141);
      return;
      paramCanvas.setMatrix(this.hpg);
    }
    if (bool1)
    {
      paramCanvas.save();
      paramCanvas.clipRect(locala.hbZ, Region.Op.DIFFERENCE);
      paramCanvas.drawPaint(com.tencent.mm.ab.a.mzW);
      paramCanvas.restore();
    }
    if (bool2)
    {
      if (!com.tencent.mm.ab.a.byy.equals(locala.hbZ))
      {
        com.tencent.mm.ab.a.mzT.reset();
        com.tencent.mm.ab.a.mzT.moveTo(locala.hbZ.left, locala.hbZ.top);
        com.tencent.mm.ab.a.mzT.lineTo(locala.hbZ.right, locala.hbZ.top);
        com.tencent.mm.ab.a.mzT.lineTo(locala.hbZ.right, locala.hbZ.bottom);
        com.tencent.mm.ab.a.mzT.lineTo(locala.hbZ.left, locala.hbZ.bottom);
        com.tencent.mm.ab.a.mzT.close();
        com.tencent.mm.ab.a.mzS.reset();
        int i = 1;
        while (i < 3)
        {
          com.tencent.mm.ab.a.mzS.moveTo(locala.hbZ.left + locala.hbZ.width() / 3 * i, locala.hbZ.top);
          com.tencent.mm.ab.a.mzS.lineTo(locala.hbZ.left + locala.hbZ.width() / 3 * i, locala.hbZ.bottom);
          com.tencent.mm.ab.a.mzS.moveTo(locala.hbZ.left, locala.hbZ.top + locala.hbZ.height() / 3 * i);
          com.tencent.mm.ab.a.mzS.lineTo(locala.hbZ.right, locala.hbZ.top + locala.hbZ.height() / 3 * i);
          i += 1;
        }
      }
      paramCanvas.drawRect(locala.hbZ.left, locala.hbZ.top, locala.hbZ.right, locala.hbZ.bottom, com.tencent.mm.ab.a.mzV);
      paramCanvas.drawPath(com.tencent.mm.ab.a.mzS, com.tencent.mm.ab.a.mzX);
      paramCanvas.drawPath(com.tencent.mm.ab.a.mzT, com.tencent.mm.ab.a.mzU);
      float f1 = locala.hbZ.left;
      float f2 = com.tencent.mm.ab.a.mzQ;
      float f3 = locala.hbZ.top;
      float f4 = com.tencent.mm.ab.a.mzQ / 2.0F;
      float f5 = locala.hbZ.left;
      paramCanvas.drawLine(f1 - f2, f3 - f4, com.tencent.mm.ab.a.mzR + f5, locala.hbZ.top - com.tencent.mm.ab.a.mzQ / 2.0F, com.tencent.mm.ab.a.mzY);
      f1 = locala.hbZ.right;
      f2 = com.tencent.mm.ab.a.mzR;
      f3 = com.tencent.mm.ab.a.mzQ / 2.0F;
      f4 = locala.hbZ.top;
      f5 = com.tencent.mm.ab.a.mzQ / 2.0F;
      float f6 = locala.hbZ.right;
      paramCanvas.drawLine(f3 + (f1 - f2), f4 - f5, com.tencent.mm.ab.a.mzQ + f6, locala.hbZ.top - com.tencent.mm.ab.a.mzQ / 2.0F, com.tencent.mm.ab.a.mzY);
      f1 = locala.hbZ.left;
      f2 = com.tencent.mm.ab.a.mzQ / 2.0F;
      f3 = locala.hbZ.top;
      f4 = com.tencent.mm.ab.a.mzQ / 2.0F;
      f5 = locala.hbZ.left;
      f6 = com.tencent.mm.ab.a.mzQ / 2.0F;
      float f7 = locala.hbZ.top;
      paramCanvas.drawLine(f1 - f2, f3 - f4, f5 - f6, com.tencent.mm.ab.a.mzR + f7, com.tencent.mm.ab.a.mzY);
      f1 = locala.hbZ.left;
      f2 = com.tencent.mm.ab.a.mzQ / 2.0F;
      f3 = locala.hbZ.bottom;
      f4 = com.tencent.mm.ab.a.mzR;
      f5 = com.tencent.mm.ab.a.mzQ / 2.0F;
      f6 = locala.hbZ.left;
      f7 = com.tencent.mm.ab.a.mzQ / 2.0F;
      float f8 = locala.hbZ.bottom;
      paramCanvas.drawLine(f1 - f2, f5 + (f3 - f4), f6 - f7, com.tencent.mm.ab.a.mzQ / 2.0F + f8, com.tencent.mm.ab.a.mzY);
      f1 = locala.hbZ.right;
      f2 = com.tencent.mm.ab.a.mzQ / 2.0F;
      f3 = locala.hbZ.top;
      f4 = locala.hbZ.right;
      f5 = com.tencent.mm.ab.a.mzQ / 2.0F;
      f6 = locala.hbZ.top;
      paramCanvas.drawLine(f2 + f1, f3, f5 + f4, com.tencent.mm.ab.a.mzR + f6, com.tencent.mm.ab.a.mzY);
      f1 = locala.hbZ.right;
      f2 = com.tencent.mm.ab.a.mzQ / 2.0F;
      f3 = locala.hbZ.bottom;
      f4 = com.tencent.mm.ab.a.mzR;
      f5 = com.tencent.mm.ab.a.mzQ / 2.0F;
      f6 = locala.hbZ.right;
      f7 = com.tencent.mm.ab.a.mzQ / 2.0F;
      f8 = locala.hbZ.bottom;
      paramCanvas.drawLine(f2 + f1, f5 + (f3 - f4), f7 + f6, com.tencent.mm.ab.a.mzQ / 2.0F + f8, com.tencent.mm.ab.a.mzY);
      f1 = locala.hbZ.left;
      f2 = com.tencent.mm.ab.a.mzQ;
      f3 = locala.hbZ.bottom;
      f4 = com.tencent.mm.ab.a.mzQ / 2.0F;
      f5 = locala.hbZ.left;
      f6 = com.tencent.mm.ab.a.mzR;
      f7 = locala.hbZ.bottom;
      paramCanvas.drawLine(f1 - f2, f4 + f3, f6 + f5, com.tencent.mm.ab.a.mzQ / 2.0F + f7, com.tencent.mm.ab.a.mzY);
      f1 = locala.hbZ.right;
      f2 = com.tencent.mm.ab.a.mzR;
      f3 = locala.hbZ.bottom;
      f4 = com.tencent.mm.ab.a.mzQ / 2.0F;
      f5 = locala.hbZ.right;
      f6 = com.tencent.mm.ab.a.mzQ;
      f7 = locala.hbZ.bottom;
      paramCanvas.drawLine(f1 - f2, f4 + f3, f6 + f5, com.tencent.mm.ab.a.mzQ / 2.0F + f7, com.tencent.mm.ab.a.mzY);
      if (!com.tencent.mm.ab.a.byy.equals(locala.hbZ)) {
        com.tencent.mm.ab.a.byy.set(locala.hbZ);
      }
    }
    AppMethodBeat.o(9141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.e.c
 * JD-Core Version:    0.7.0.1
 */