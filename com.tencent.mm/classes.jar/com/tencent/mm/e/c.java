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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.view.b.a.b;
import java.util.Stack;

public final class c
  extends b<com.tencent.mm.cache.a>
{
  public Rect cPO;
  private RectF daA;
  private RectF daB;
  private RectF daC;
  public final Rect daD;
  private com.tencent.mm.aa.a daE;
  private boolean daF;
  private boolean daG;
  public com.tencent.mm.c.a daH;
  boolean daI;
  boolean daJ;
  boolean daK;
  boolean daL;
  boolean daM;
  public boolean daN;
  float daO;
  float daP;
  float daQ;
  float daR;
  float daS;
  float daT;
  public ValueAnimator daU;
  public Rect daV;
  public int daW;
  public boolean daX;
  private int dav;
  private int daw;
  private int dax;
  private Matrix day;
  private RectF daz;
  
  public c()
  {
    AppMethodBeat.i(9136);
    this.dav = ((int)aj.getResources().getDimension(2131165936));
    this.daw = ((int)aj.getResources().getDimension(2131166289));
    this.dax = ((int)aj.getResources().getDimension(2131166083));
    this.day = new Matrix();
    this.daD = new Rect();
    this.daF = false;
    this.daG = false;
    this.daI = false;
    this.daJ = false;
    this.daK = false;
    this.daL = false;
    this.daM = false;
    this.daN = true;
    this.daV = new Rect();
    this.daW = 0;
    this.daX = false;
    AppMethodBeat.o(9136);
  }
  
  private boolean NT()
  {
    return (this.daL) || (this.daJ) || (this.daK) || (this.daM);
  }
  
  public final a NI()
  {
    return a.dag;
  }
  
  public final void NJ() {}
  
  public final void NL()
  {
    AppMethodBeat.i(9139);
    super.NL();
    this.dak.ffR().getActionBar().setVisibility(8);
    this.daV.setEmpty();
    if (NK() == null)
    {
      ad.e("MicroMsg.CropArtist", "[onSelected] getCache is null!");
      AppMethodBeat.o(9139);
      return;
    }
    com.tencent.mm.aa.a locala;
    if (((com.tencent.mm.cache.a)NK()).aj(true) <= 0)
    {
      locala = new com.tencent.mm.aa.a();
      locala.mMatrix.set(getMainMatrix());
      ((com.tencent.mm.cache.a)NK()).a(locala);
      NV();
      this.dak.ffR().getBaseBoardView().Lsn = this.cPO;
      this.dak.ffR().getBaseBoardView().a(new a.b()
      {
        public final void NX()
        {
          AppMethodBeat.i(9119);
          if (c.this.NK() == null)
          {
            AppMethodBeat.o(9119);
            return;
          }
          if (((com.tencent.mm.cache.a)c.this.NK()).fIg.isIdentity())
          {
            localObject = (com.tencent.mm.cache.a)c.this.NK();
            Matrix localMatrix = c.this.getMainMatrix();
            ((com.tencent.mm.cache.a)localObject).fIg.set(localMatrix);
          }
          Object localObject = new Rect();
          if (c.this.dak.ffU() == null) {
            ((Rect)localObject).set(0, 0, c.this.dak.ffR().getBaseBoardView().getBoardRect().width(), c.this.dak.ffR().getBaseBoardView().getBoardRect().height());
          }
          for (;;)
          {
            c.this.dak.ffR().getBaseBoardView().q((Rect)localObject);
            c.a(c.this, 200L, true, false);
            c.this.NS();
            AppMethodBeat.o(9119);
            return;
            ((Rect)localObject).set(0, 0, c.this.dak.ffU().getWidth(), c.this.dak.ffU().getHeight());
          }
        }
        
        public final void onStart()
        {
          AppMethodBeat.i(9120);
          c.a(c.this, false);
          c.this.daN = false;
          AppMethodBeat.o(9120);
        }
      }, 0.0F, false);
    }
    for (;;)
    {
      setOneFingerMoveEnable(true);
      AppMethodBeat.o(9139);
      return;
      locala = ((com.tencent.mm.cache.a)NK()).XH();
      if (locala == null)
      {
        ad.e("MicroMsg.CropArtist", "item is null!!!");
        AppMethodBeat.o(9139);
        return;
      }
      this.cPO.set(new Rect(locala.cPO));
      this.dak.ffR().getBaseBoardView().Lsn = locala.cPO;
      try
      {
        ((com.tencent.mm.cache.a)NK()).a((com.tencent.mm.aa.a)locala.clone());
        this.dak.ffR().getBaseBoardView().a(new a.b()
        {
          public final void NX()
          {
            AppMethodBeat.i(9121);
            c.this.daN = true;
            Rect localRect;
            if (c.this.dak.ffU() == null)
            {
              localRect = new Rect();
              ad.e("MicroMsg.CropArtist", "getImageBitmap is null!");
            }
            for (;;)
            {
              c.this.dak.ffR().getBaseBoardView().q(localRect);
              c.a(c.this, 200L, true, false);
              AppMethodBeat.o(9121);
              return;
              localRect = new Rect(0, 0, c.this.dak.ffU().getWidth(), c.this.dak.ffU().getHeight());
            }
          }
          
          public final void onStart()
          {
            AppMethodBeat.i(9122);
            c.a(c.this, false);
            c.this.daN = false;
            c.a(c.this);
            com.tencent.mm.aa.a.my(282);
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
  
  public final boolean NN()
  {
    AppMethodBeat.i(9140);
    if (NK() == null)
    {
      AppMethodBeat.o(9140);
      return false;
    }
    if (!((com.tencent.mm.cache.a)NK()).fIg.equals(getMainMatrix()))
    {
      AppMethodBeat.o(9140);
      return true;
    }
    AppMethodBeat.o(9140);
    return false;
  }
  
  public final void NU()
  {
    AppMethodBeat.i(9143);
    this.daA.set(this.cPO.left - this.dav, this.cPO.bottom - this.dav, this.cPO.right + this.dav, this.cPO.bottom + this.dav);
    this.daz.set(this.cPO.left - this.dav, this.cPO.top - this.dav, this.cPO.right + this.dav, this.cPO.top + this.dav);
    this.daB.set(this.cPO.left - this.dav, this.cPO.top - this.dav, this.cPO.left + this.dav, this.cPO.bottom + this.dav);
    this.daC.set(this.cPO.right - this.dav, this.cPO.top - this.dav, this.cPO.right + this.dav, this.cPO.bottom + this.dav);
    AppMethodBeat.o(9143);
  }
  
  public final void NV()
  {
    AppMethodBeat.i(9144);
    if (this.dak.ffU() == null)
    {
      ad.w("MicroMsg.CropArtist", "[resetBoxRect] getImageBitmap is null!");
      AppMethodBeat.o(9144);
      return;
    }
    float f1 = this.dak.ffU().getWidth() * 1.0F / this.dak.ffU().getHeight();
    int i;
    if (f1 < this.daD.width() * 1.0F / this.daD.height())
    {
      float f2 = this.daD.height();
      i = (int)((this.daD.width() - f1 * f2) / 2.0F);
      this.cPO.set(this.daD.left + i, this.daD.top, this.daD.right - i, this.daD.bottom);
    }
    for (;;)
    {
      NU();
      AppMethodBeat.o(9144);
      return;
      f1 = this.daD.width() / f1;
      i = (int)((this.daD.height() - f1) / 2.0F);
      this.cPO.set(this.daD.left, this.daD.top + i, this.daD.right, this.daD.bottom - i);
    }
  }
  
  public final void NW()
  {
    AppMethodBeat.i(9145);
    this.dak.ffR().getBaseBoardView().Lsn = this.dak.ffR().getBaseBoardView().getRawBoardRect();
    Object localObject1 = new RectF(this.cPO);
    Object localObject2 = new Matrix();
    getMainMatrix().invert((Matrix)localObject2);
    ((Matrix)localObject2).mapRect((RectF)localObject1);
    localObject2 = new Rect();
    ((RectF)localObject1).round((Rect)localObject2);
    this.dak.ffR().getBaseBoardView().q((Rect)localObject2);
    localObject1 = new com.tencent.mm.aa.a();
    ((com.tencent.mm.aa.a)localObject1).cPO = new Rect(this.cPO);
    ((com.tencent.mm.aa.a)localObject1).gyJ.set((Rect)localObject2);
    this.dak.ffR().getBaseBoardView().a(new a.b()
    {
      public final void NX()
      {
        AppMethodBeat.i(9130);
        Object localObject = this.dbc;
        Matrix localMatrix = c.this.getMainMatrix();
        ((com.tencent.mm.aa.a)localObject).mMatrix.set(localMatrix);
        if (c.this.NK() != null)
        {
          localObject = (com.tencent.mm.cache.a)c.this.NK();
          if (((com.tencent.mm.cache.a)localObject).fIe != null) {
            ((com.tencent.mm.cache.a)localObject).fIe.clear();
          }
          ((com.tencent.mm.cache.a)c.this.NK()).a(this.dbc);
        }
        AppMethodBeat.o(9130);
      }
      
      public final void onStart()
      {
        AppMethodBeat.i(9131);
        AppMethodBeat.o(9131);
      }
    }, 0.0F, true);
    this.dak.ffR().getActionBar().setVisibility(0);
    AppMethodBeat.o(9145);
  }
  
  public final void a(com.tencent.mm.bu.b paramb, Matrix paramMatrix, Rect paramRect)
  {
    AppMethodBeat.i(9137);
    super.a(paramb, paramMatrix, paramRect);
    this.cPO = new Rect();
    this.daA = new RectF();
    this.daz = new RectF();
    this.daB = new RectF();
    this.daC = new RectF();
    this.daE = new com.tencent.mm.aa.a(this.cPO);
    this.daH = new com.tencent.mm.c.a(this);
    AppMethodBeat.o(9137);
  }
  
  public final boolean n(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9142);
    if (!NP())
    {
      AppMethodBeat.o(9142);
      return false;
    }
    Object localObject = this.dak.ffR().getBaseBoardView().getCurImageRect();
    this.daQ = (((RectF)localObject).top - (((RectF)localObject).bottom - this.cPO.bottom));
    this.daR = (((RectF)localObject).bottom + (this.cPO.top - ((RectF)localObject).top));
    this.daS = (((RectF)localObject).left - (((RectF)localObject).right - this.cPO.right));
    this.daT = (((RectF)localObject).right + (this.cPO.left - ((RectF)localObject).left));
    if (this.daT > this.daD.right) {
      this.daT = this.daD.right;
    }
    if (this.daS < this.dav) {
      this.daS = this.dav;
    }
    if (this.daR > this.daD.bottom) {
      this.daR = this.daD.bottom;
    }
    if (this.daQ < this.dav) {
      this.daQ = this.dav;
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
            boolean bool = this.daI;
            AppMethodBeat.o(9142);
            return bool;
            this.daL = false;
            this.daJ = false;
            this.daK = false;
            this.daM = false;
            this.daI = false;
          }
          this.daI = false;
          if (this.daH != null) {
            this.daH.cancel();
          }
          if (this.daA.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            this.daL = true;
          }
          if (this.daz.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            this.daK = true;
          }
          if (this.daB.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            this.daJ = true;
          }
          if (this.daC.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            this.daM = true;
          }
          this.daN = false;
        } while (!NT());
        this.daI = true;
        if ((this.daL) && (this.daJ))
        {
          this.daL = true;
          this.daJ = true;
          this.daK = false;
          this.daM = false;
        }
        for (;;)
        {
          this.daO = paramMotionEvent.getX();
          this.daP = paramMotionEvent.getY();
          break;
          if ((this.daL) && (this.daM))
          {
            this.daL = true;
            this.daJ = false;
            this.daK = false;
            this.daM = true;
          }
          else if ((this.daK) && (this.daM))
          {
            this.daL = false;
            this.daJ = false;
            this.daK = true;
            this.daM = true;
          }
          else if ((this.daK) && (this.daM))
          {
            this.daL = false;
            this.daJ = false;
            this.daK = true;
            this.daM = true;
          }
        }
      } while (!this.daI);
      if ((paramMotionEvent.getPointerCount() == 1) && (NT()))
      {
        if ((this.daM) && (this.cPO.right >= this.cPO.left))
        {
          if (this.cPO.right <= this.daD.right)
          {
            if (paramMotionEvent.getX() - this.daO <= this.daD.right - this.cPO.right) {
              break label1898;
            }
            this.cPO.right = this.daD.right;
          }
          label717:
          if (this.cPO.right < this.cPO.left + this.dav * 2) {
            this.cPO.right = (this.cPO.left + this.dav * 2);
          }
          if (this.cPO.right > this.daD.right) {
            this.cPO.right = this.daD.right;
          }
          if (((int)((RectF)localObject).right <= (int)this.daT) && ((int)((RectF)localObject).right <= this.cPO.right))
          {
            if (paramMotionEvent.getX() - this.daO <= this.daT - ((RectF)localObject).right) {
              break label1929;
            }
            getMainMatrix().postTranslate(this.daT - ((RectF)localObject).right, 0.0F);
          }
          label865:
          if ((this.cPO.width() > ((RectF)localObject).width()) && (this.cPO.right < this.daD.right))
          {
            f1 = this.cPO.width() / ((RectF)localObject).width();
            getMainMatrix().postScale(f1, f1, this.cPO.left, this.cPO.centerY());
          }
        }
        if ((this.daJ) && (this.cPO.right >= this.cPO.left))
        {
          if (this.cPO.left >= this.daD.left)
          {
            if (this.daO - paramMotionEvent.getX() <= this.cPO.left - this.daD.left) {
              break label1950;
            }
            this.cPO.left = this.daD.left;
          }
          label1024:
          if (this.cPO.left > this.cPO.right - this.dav * 2) {
            this.cPO.left = (this.cPO.right - this.dav * 2);
          }
          if (this.cPO.left < this.daD.left) {
            this.cPO.left = this.daD.left;
          }
          if (((int)((RectF)localObject).left >= (int)this.daS) && ((int)((RectF)localObject).left >= this.cPO.left))
          {
            if (this.daO - paramMotionEvent.getX() <= ((RectF)localObject).left - this.daS) {
              break label1981;
            }
            getMainMatrix().postTranslate(this.daS - ((RectF)localObject).left, 0.0F);
          }
          label1172:
          if ((this.cPO.width() > ((RectF)localObject).width()) && (this.cPO.left > this.daD.left))
          {
            f1 = this.cPO.width() / ((RectF)localObject).width();
            getMainMatrix().postScale(f1, f1, this.cPO.right, this.cPO.centerY());
          }
        }
        if ((this.daK) && (this.cPO.bottom >= this.cPO.top))
        {
          if (this.cPO.top >= this.daD.top)
          {
            if (this.daP - paramMotionEvent.getY() <= this.cPO.top - this.daD.top) {
              break label2002;
            }
            this.cPO.top = this.daD.top;
          }
          label1331:
          if (this.cPO.top > this.cPO.bottom - this.dav * 2) {
            this.cPO.top = (this.cPO.bottom - this.dav * 2);
          }
          if (this.cPO.top < this.daD.top) {
            this.cPO.top = this.daD.top;
          }
          if (((int)((RectF)localObject).top >= (int)this.daQ) && ((int)((RectF)localObject).top >= this.cPO.top))
          {
            if (this.daP - paramMotionEvent.getY() <= ((RectF)localObject).top - this.daQ) {
              break label2033;
            }
            getMainMatrix().postTranslate(0.0F, this.daQ - ((RectF)localObject).top);
          }
          label1479:
          if ((this.cPO.height() > ((RectF)localObject).height()) && (this.cPO.top > this.daD.top))
          {
            f1 = this.cPO.height() / ((RectF)localObject).height();
            getMainMatrix().postScale(f1, f1, this.cPO.centerX(), this.cPO.bottom);
          }
        }
        if ((this.daL) && (this.cPO.bottom >= this.cPO.top))
        {
          if (this.cPO.bottom <= this.daD.bottom)
          {
            if (paramMotionEvent.getY() - this.daP <= this.daD.bottom - this.cPO.bottom) {
              break label2054;
            }
            this.cPO.bottom = this.daD.bottom;
          }
          label1638:
          if (this.cPO.bottom < this.cPO.top + this.dav * 2) {
            this.cPO.bottom = (this.cPO.top + this.dav * 2);
          }
          if (this.cPO.bottom > this.daD.bottom) {
            this.cPO.bottom = this.daD.bottom;
          }
          if (((int)((RectF)localObject).bottom <= (int)this.daR) && ((int)((RectF)localObject).bottom <= this.cPO.bottom))
          {
            if (paramMotionEvent.getY() - this.daP <= this.daR - ((RectF)localObject).bottom) {
              break label2085;
            }
            getMainMatrix().postTranslate(0.0F, this.daR - ((RectF)localObject).bottom);
          }
          label1786:
          if ((this.cPO.height() > ((RectF)localObject).height()) && (this.cPO.bottom < this.daD.bottom))
          {
            f1 = this.cPO.height() / ((RectF)localObject).height();
            getMainMatrix().postScale(f1, f1, this.cPO.centerX(), this.cPO.top);
          }
        }
        NU();
        this.daI = true;
        NR();
        this.daO = paramMotionEvent.getX();
        this.daP = paramMotionEvent.getY();
      }
      for (;;)
      {
        q(paramMotionEvent);
        break;
        label1898:
        Rect localRect = this.cPO;
        localRect.right = ((int)(localRect.right + (paramMotionEvent.getX() - this.daO)));
        break label717;
        label1929:
        getMainMatrix().postTranslate(paramMotionEvent.getX() - this.daO, 0.0F);
        break label865;
        label1950:
        localRect = this.cPO;
        localRect.left = ((int)(localRect.left - (this.daO - paramMotionEvent.getX())));
        break label1024;
        label1981:
        getMainMatrix().postTranslate(paramMotionEvent.getX() - this.daO, 0.0F);
        break label1172;
        label2002:
        localRect = this.cPO;
        localRect.top = ((int)(localRect.top - (this.daP - paramMotionEvent.getY())));
        break label1331;
        label2033:
        getMainMatrix().postTranslate(0.0F, paramMotionEvent.getY() - this.daP);
        break label1479;
        label2054:
        localRect = this.cPO;
        localRect.bottom = ((int)(localRect.bottom + (paramMotionEvent.getY() - this.daP)));
        break label1638;
        label2085:
        getMainMatrix().postTranslate(0.0F, paramMotionEvent.getY() - this.daP);
        break label1786;
        this.daI = false;
      }
    }
    final float f1 = this.daD.width() * 1.0F / this.cPO.width();
    float f2 = this.daD.height() * 1.0F / this.cPO.height();
    label2160:
    long l;
    if (f1 < f2)
    {
      f2 = this.daD.centerX();
      float f3 = this.daD.centerY();
      float f4 = this.cPO.centerX();
      float f5 = this.cPO.centerY();
      paramMotionEvent = h.LTJ;
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(221084);
          c.b(c.this).cPR = 1000L;
          com.tencent.mm.c.a locala = c.b(c.this);
          float f1 = f1;
          Rect localRect = c.c(c.this);
          float f2 = this.dba;
          float f3 = this.dbb;
          locala.cPM = f2;
          locala.cPN = f3;
          locala.cPO = localRect;
          locala.cPP.set(locala.cPO);
          locala.cPL = f1;
          c.b(c.this).play();
          AppMethodBeat.o(221084);
        }
      };
      if (!this.daI) {
        break label2288;
      }
      l = 0L;
      label2233:
      paramMotionEvent.q((Runnable)localObject, l);
      if (!NT()) {
        break label2296;
      }
    }
    label2288:
    label2296:
    for (this.daI = true;; this.daI = false)
    {
      this.daL = false;
      this.daJ = false;
      this.daK = false;
      this.daM = false;
      NS();
      break;
      f1 = f2;
      break label2160;
      l = 100L;
      break label2233;
    }
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(9138);
    super.onAlive();
    if (this.daD.isEmpty()) {
      this.daD.set(this.dav, this.dav * 2, getBoardRect().width() - this.dav, getBoardRect().height() - this.daw - this.dax - this.dav * 2);
    }
    ad.i("MicroMsg.CropArtist", "[onAlive] CROP_MAX_RECT:%s", new Object[] { this.daD });
    if (NK() == null)
    {
      ad.i("MicroMsg.CropArtist", "[onAlive] getCache is null");
      AppMethodBeat.o(9138);
      return;
    }
    com.tencent.mm.aa.a locala = ((com.tencent.mm.cache.a)NK()).XH();
    if ((locala != null) && (!locala.gyJ.isEmpty()))
    {
      this.dak.ffR().getBaseBoardView().q(locala.gyJ);
      float f = b(locala.mMatrix);
      ad.i("MicroMsg.CropArtist", "[onAlive] rotation:%s", new Object[] { Float.valueOf(f) });
      getMainMatrix().postRotate(-f, locala.gyJ.centerX(), locala.gyJ.centerY());
    }
    AppMethodBeat.o(9138);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9141);
    if (!this.daG) {
      paramCanvas.setMatrix(null);
    }
    com.tencent.mm.aa.a locala;
    boolean bool1;
    boolean bool2;
    for (;;)
    {
      locala = this.daE;
      bool1 = this.daN;
      bool2 = this.daF;
      if (locala.cPO != null) {
        break;
      }
      ad.e("MicroMsg.CropItem", "[draw] mBoxRect is null!");
      AppMethodBeat.o(9141);
      return;
      paramCanvas.setMatrix(this.day);
    }
    if (bool1)
    {
      paramCanvas.save();
      paramCanvas.clipRect(locala.cPO, Region.Op.DIFFERENCE);
      paramCanvas.drawPaint(com.tencent.mm.aa.a.gyF);
      paramCanvas.restore();
    }
    if (bool2)
    {
      if (!com.tencent.mm.aa.a.TW.equals(locala.cPO))
      {
        com.tencent.mm.aa.a.gyC.reset();
        com.tencent.mm.aa.a.gyC.moveTo(locala.cPO.left, locala.cPO.top);
        com.tencent.mm.aa.a.gyC.lineTo(locala.cPO.right, locala.cPO.top);
        com.tencent.mm.aa.a.gyC.lineTo(locala.cPO.right, locala.cPO.bottom);
        com.tencent.mm.aa.a.gyC.lineTo(locala.cPO.left, locala.cPO.bottom);
        com.tencent.mm.aa.a.gyC.close();
        com.tencent.mm.aa.a.gyB.reset();
        int i = 1;
        while (i < 3)
        {
          com.tencent.mm.aa.a.gyB.moveTo(locala.cPO.left + locala.cPO.width() / 3 * i, locala.cPO.top);
          com.tencent.mm.aa.a.gyB.lineTo(locala.cPO.left + locala.cPO.width() / 3 * i, locala.cPO.bottom);
          com.tencent.mm.aa.a.gyB.moveTo(locala.cPO.left, locala.cPO.top + locala.cPO.height() / 3 * i);
          com.tencent.mm.aa.a.gyB.lineTo(locala.cPO.right, locala.cPO.top + locala.cPO.height() / 3 * i);
          i += 1;
        }
      }
      paramCanvas.drawRect(locala.cPO.left, locala.cPO.top, locala.cPO.right, locala.cPO.bottom, com.tencent.mm.aa.a.gyE);
      paramCanvas.drawPath(com.tencent.mm.aa.a.gyB, com.tencent.mm.aa.a.gyG);
      paramCanvas.drawPath(com.tencent.mm.aa.a.gyC, com.tencent.mm.aa.a.gyD);
      float f1 = locala.cPO.left;
      float f2 = com.tencent.mm.aa.a.gyz;
      float f3 = locala.cPO.top;
      float f4 = com.tencent.mm.aa.a.gyz / 2.0F;
      float f5 = locala.cPO.left;
      paramCanvas.drawLine(f1 - f2, f3 - f4, com.tencent.mm.aa.a.gyA + f5, locala.cPO.top - com.tencent.mm.aa.a.gyz / 2.0F, com.tencent.mm.aa.a.gyH);
      f1 = locala.cPO.right;
      f2 = com.tencent.mm.aa.a.gyA;
      f3 = com.tencent.mm.aa.a.gyz / 2.0F;
      f4 = locala.cPO.top;
      f5 = com.tencent.mm.aa.a.gyz / 2.0F;
      float f6 = locala.cPO.right;
      paramCanvas.drawLine(f3 + (f1 - f2), f4 - f5, com.tencent.mm.aa.a.gyz + f6, locala.cPO.top - com.tencent.mm.aa.a.gyz / 2.0F, com.tencent.mm.aa.a.gyH);
      f1 = locala.cPO.left;
      f2 = com.tencent.mm.aa.a.gyz / 2.0F;
      f3 = locala.cPO.top;
      f4 = com.tencent.mm.aa.a.gyz / 2.0F;
      f5 = locala.cPO.left;
      f6 = com.tencent.mm.aa.a.gyz / 2.0F;
      float f7 = locala.cPO.top;
      paramCanvas.drawLine(f1 - f2, f3 - f4, f5 - f6, com.tencent.mm.aa.a.gyA + f7, com.tencent.mm.aa.a.gyH);
      f1 = locala.cPO.left;
      f2 = com.tencent.mm.aa.a.gyz / 2.0F;
      f3 = locala.cPO.bottom;
      f4 = com.tencent.mm.aa.a.gyA;
      f5 = com.tencent.mm.aa.a.gyz / 2.0F;
      f6 = locala.cPO.left;
      f7 = com.tencent.mm.aa.a.gyz / 2.0F;
      float f8 = locala.cPO.bottom;
      paramCanvas.drawLine(f1 - f2, f5 + (f3 - f4), f6 - f7, com.tencent.mm.aa.a.gyz / 2.0F + f8, com.tencent.mm.aa.a.gyH);
      f1 = locala.cPO.right;
      f2 = com.tencent.mm.aa.a.gyz / 2.0F;
      f3 = locala.cPO.top;
      f4 = locala.cPO.right;
      f5 = com.tencent.mm.aa.a.gyz / 2.0F;
      f6 = locala.cPO.top;
      paramCanvas.drawLine(f2 + f1, f3, f5 + f4, com.tencent.mm.aa.a.gyA + f6, com.tencent.mm.aa.a.gyH);
      f1 = locala.cPO.right;
      f2 = com.tencent.mm.aa.a.gyz / 2.0F;
      f3 = locala.cPO.bottom;
      f4 = com.tencent.mm.aa.a.gyA;
      f5 = com.tencent.mm.aa.a.gyz / 2.0F;
      f6 = locala.cPO.right;
      f7 = com.tencent.mm.aa.a.gyz / 2.0F;
      f8 = locala.cPO.bottom;
      paramCanvas.drawLine(f2 + f1, f5 + (f3 - f4), f7 + f6, com.tencent.mm.aa.a.gyz / 2.0F + f8, com.tencent.mm.aa.a.gyH);
      f1 = locala.cPO.left;
      f2 = com.tencent.mm.aa.a.gyz;
      f3 = locala.cPO.bottom;
      f4 = com.tencent.mm.aa.a.gyz / 2.0F;
      f5 = locala.cPO.left;
      f6 = com.tencent.mm.aa.a.gyA;
      f7 = locala.cPO.bottom;
      paramCanvas.drawLine(f1 - f2, f4 + f3, f6 + f5, com.tencent.mm.aa.a.gyz / 2.0F + f7, com.tencent.mm.aa.a.gyH);
      f1 = locala.cPO.right;
      f2 = com.tencent.mm.aa.a.gyA;
      f3 = locala.cPO.bottom;
      f4 = com.tencent.mm.aa.a.gyz / 2.0F;
      f5 = locala.cPO.right;
      f6 = com.tencent.mm.aa.a.gyz;
      f7 = locala.cPO.bottom;
      paramCanvas.drawLine(f1 - f2, f4 + f3, f6 + f5, com.tencent.mm.aa.a.gyz / 2.0F + f7, com.tencent.mm.aa.a.gyH);
      if (!com.tencent.mm.aa.a.TW.equals(locala.cPO)) {
        com.tencent.mm.aa.a.TW.set(locala.cPO);
      }
    }
    AppMethodBeat.o(9141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.e.c
 * JD-Core Version:    0.7.0.1
 */