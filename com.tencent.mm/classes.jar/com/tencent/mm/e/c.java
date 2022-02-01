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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.view.b.a.b;
import java.util.Stack;

public final class c
  extends b<com.tencent.mm.cache.a>
{
  public Rect cQy;
  private Matrix dbA;
  private RectF dbB;
  private RectF dbC;
  private RectF dbD;
  private RectF dbE;
  public final Rect dbF;
  private com.tencent.mm.z.a dbG;
  private boolean dbH;
  private boolean dbI;
  public com.tencent.mm.c.a dbJ;
  boolean dbK;
  boolean dbL;
  boolean dbM;
  boolean dbN;
  boolean dbO;
  public boolean dbP;
  float dbQ;
  float dbR;
  float dbS;
  float dbT;
  float dbU;
  float dbV;
  public ValueAnimator dbW;
  public Rect dbX;
  public int dbY;
  public boolean dbZ;
  private int dbx;
  private int dby;
  private int dbz;
  
  public c()
  {
    AppMethodBeat.i(9136);
    this.dbx = ((int)ak.getResources().getDimension(2131165936));
    this.dby = ((int)ak.getResources().getDimension(2131166289));
    this.dbz = ((int)ak.getResources().getDimension(2131166083));
    this.dbA = new Matrix();
    this.dbF = new Rect();
    this.dbH = false;
    this.dbI = false;
    this.dbK = false;
    this.dbL = false;
    this.dbM = false;
    this.dbN = false;
    this.dbO = false;
    this.dbP = true;
    this.dbX = new Rect();
    this.dbY = 0;
    this.dbZ = false;
    AppMethodBeat.o(9136);
  }
  
  private boolean NR()
  {
    return (this.dbN) || (this.dbL) || (this.dbM) || (this.dbO);
  }
  
  public final a NG()
  {
    return a.dbi;
  }
  
  public final void NH() {}
  
  public final void NJ()
  {
    AppMethodBeat.i(9139);
    super.NJ();
    this.dbm.fjH().getActionBar().setVisibility(8);
    this.dbX.setEmpty();
    if (NI() == null)
    {
      ae.e("MicroMsg.CropArtist", "[onSelected] getCache is null!");
      AppMethodBeat.o(9139);
      return;
    }
    com.tencent.mm.z.a locala;
    if (((com.tencent.mm.cache.a)NI()).aj(true) <= 0)
    {
      locala = new com.tencent.mm.z.a();
      locala.mMatrix.set(getMainMatrix());
      ((com.tencent.mm.cache.a)NI()).a(locala);
      NT();
      this.dbm.fjH().getBaseBoardView().LPa = this.cQy;
      this.dbm.fjH().getBaseBoardView().a(new a.b()
      {
        public final void NV()
        {
          AppMethodBeat.i(9119);
          if (c.this.NI() == null)
          {
            AppMethodBeat.o(9119);
            return;
          }
          if (((com.tencent.mm.cache.a)c.this.NI()).fKk.isIdentity())
          {
            localObject = (com.tencent.mm.cache.a)c.this.NI();
            Matrix localMatrix = c.this.getMainMatrix();
            ((com.tencent.mm.cache.a)localObject).fKk.set(localMatrix);
          }
          Object localObject = new Rect();
          if (c.this.dbm.fjK() == null) {
            ((Rect)localObject).set(0, 0, c.this.dbm.fjH().getBaseBoardView().getBoardRect().width(), c.this.dbm.fjH().getBaseBoardView().getBoardRect().height());
          }
          for (;;)
          {
            c.this.dbm.fjH().getBaseBoardView().q((Rect)localObject);
            c.a(c.this, 200L, true, false);
            c.this.NQ();
            AppMethodBeat.o(9119);
            return;
            ((Rect)localObject).set(0, 0, c.this.dbm.fjK().getWidth(), c.this.dbm.fjK().getHeight());
          }
        }
        
        public final void onStart()
        {
          AppMethodBeat.i(9120);
          c.a(c.this, false);
          c.this.dbP = false;
          AppMethodBeat.o(9120);
        }
      }, 0.0F, false);
    }
    for (;;)
    {
      setOneFingerMoveEnable(true);
      AppMethodBeat.o(9139);
      return;
      locala = ((com.tencent.mm.cache.a)NI()).XR();
      if (locala == null)
      {
        ae.e("MicroMsg.CropArtist", "item is null!!!");
        AppMethodBeat.o(9139);
        return;
      }
      this.cQy.set(new Rect(locala.cQy));
      this.dbm.fjH().getBaseBoardView().LPa = locala.cQy;
      try
      {
        ((com.tencent.mm.cache.a)NI()).a((com.tencent.mm.z.a)locala.clone());
        this.dbm.fjH().getBaseBoardView().a(new a.b()
        {
          public final void NV()
          {
            AppMethodBeat.i(9121);
            c.this.dbP = true;
            Rect localRect;
            if (c.this.dbm.fjK() == null)
            {
              localRect = new Rect();
              ae.e("MicroMsg.CropArtist", "getImageBitmap is null!");
            }
            for (;;)
            {
              c.this.dbm.fjH().getBaseBoardView().q(localRect);
              c.a(c.this, 200L, true, false);
              AppMethodBeat.o(9121);
              return;
              localRect = new Rect(0, 0, c.this.dbm.fjK().getWidth(), c.this.dbm.fjK().getHeight());
            }
          }
          
          public final void onStart()
          {
            AppMethodBeat.i(9122);
            c.a(c.this, false);
            c.this.dbP = false;
            c.a(c.this);
            com.tencent.mm.z.a.mB(282);
            AppMethodBeat.o(9122);
          }
        }, 0.0F, false);
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.CropArtist", localCloneNotSupportedException, "", new Object[0]);
        }
      }
    }
  }
  
  public final boolean NL()
  {
    AppMethodBeat.i(9140);
    if (NI() == null)
    {
      AppMethodBeat.o(9140);
      return false;
    }
    if (!((com.tencent.mm.cache.a)NI()).fKk.equals(getMainMatrix()))
    {
      AppMethodBeat.o(9140);
      return true;
    }
    AppMethodBeat.o(9140);
    return false;
  }
  
  public final void NS()
  {
    AppMethodBeat.i(9143);
    this.dbC.set(this.cQy.left - this.dbx, this.cQy.bottom - this.dbx, this.cQy.right + this.dbx, this.cQy.bottom + this.dbx);
    this.dbB.set(this.cQy.left - this.dbx, this.cQy.top - this.dbx, this.cQy.right + this.dbx, this.cQy.top + this.dbx);
    this.dbD.set(this.cQy.left - this.dbx, this.cQy.top - this.dbx, this.cQy.left + this.dbx, this.cQy.bottom + this.dbx);
    this.dbE.set(this.cQy.right - this.dbx, this.cQy.top - this.dbx, this.cQy.right + this.dbx, this.cQy.bottom + this.dbx);
    AppMethodBeat.o(9143);
  }
  
  public final void NT()
  {
    AppMethodBeat.i(9144);
    if (this.dbm.fjK() == null)
    {
      ae.w("MicroMsg.CropArtist", "[resetBoxRect] getImageBitmap is null!");
      AppMethodBeat.o(9144);
      return;
    }
    float f1 = this.dbm.fjK().getWidth() * 1.0F / this.dbm.fjK().getHeight();
    int i;
    if (f1 < this.dbF.width() * 1.0F / this.dbF.height())
    {
      float f2 = this.dbF.height();
      i = (int)((this.dbF.width() - f1 * f2) / 2.0F);
      this.cQy.set(this.dbF.left + i, this.dbF.top, this.dbF.right - i, this.dbF.bottom);
    }
    for (;;)
    {
      NS();
      AppMethodBeat.o(9144);
      return;
      f1 = this.dbF.width() / f1;
      i = (int)((this.dbF.height() - f1) / 2.0F);
      this.cQy.set(this.dbF.left, this.dbF.top + i, this.dbF.right, this.dbF.bottom - i);
    }
  }
  
  public final void NU()
  {
    AppMethodBeat.i(9145);
    this.dbm.fjH().getBaseBoardView().LPa = this.dbm.fjH().getBaseBoardView().getRawBoardRect();
    Object localObject1 = new RectF(this.cQy);
    Object localObject2 = new Matrix();
    getMainMatrix().invert((Matrix)localObject2);
    ((Matrix)localObject2).mapRect((RectF)localObject1);
    localObject2 = new Rect();
    ((RectF)localObject1).round((Rect)localObject2);
    this.dbm.fjH().getBaseBoardView().q((Rect)localObject2);
    localObject1 = new com.tencent.mm.z.a();
    ((com.tencent.mm.z.a)localObject1).cQy = new Rect(this.cQy);
    ((com.tencent.mm.z.a)localObject1).gBq.set((Rect)localObject2);
    this.dbm.fjH().getBaseBoardView().a(new a.b()
    {
      public final void NV()
      {
        AppMethodBeat.i(9130);
        Object localObject = this.dce;
        Matrix localMatrix = c.this.getMainMatrix();
        ((com.tencent.mm.z.a)localObject).mMatrix.set(localMatrix);
        if (c.this.NI() != null)
        {
          localObject = (com.tencent.mm.cache.a)c.this.NI();
          if (((com.tencent.mm.cache.a)localObject).fKi != null) {
            ((com.tencent.mm.cache.a)localObject).fKi.clear();
          }
          ((com.tencent.mm.cache.a)c.this.NI()).a(this.dce);
        }
        AppMethodBeat.o(9130);
      }
      
      public final void onStart()
      {
        AppMethodBeat.i(9131);
        AppMethodBeat.o(9131);
      }
    }, 0.0F, true);
    this.dbm.fjH().getActionBar().setVisibility(0);
    AppMethodBeat.o(9145);
  }
  
  public final void a(com.tencent.mm.bt.b paramb, Matrix paramMatrix, Rect paramRect)
  {
    AppMethodBeat.i(9137);
    super.a(paramb, paramMatrix, paramRect);
    this.cQy = new Rect();
    this.dbC = new RectF();
    this.dbB = new RectF();
    this.dbD = new RectF();
    this.dbE = new RectF();
    this.dbG = new com.tencent.mm.z.a(this.cQy);
    this.dbJ = new com.tencent.mm.c.a(this);
    AppMethodBeat.o(9137);
  }
  
  public final boolean n(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9142);
    if (!NN())
    {
      AppMethodBeat.o(9142);
      return false;
    }
    Object localObject = this.dbm.fjH().getBaseBoardView().getCurImageRect();
    this.dbS = (((RectF)localObject).top - (((RectF)localObject).bottom - this.cQy.bottom));
    this.dbT = (((RectF)localObject).bottom + (this.cQy.top - ((RectF)localObject).top));
    this.dbU = (((RectF)localObject).left - (((RectF)localObject).right - this.cQy.right));
    this.dbV = (((RectF)localObject).right + (this.cQy.left - ((RectF)localObject).left));
    if (this.dbV > this.dbF.right) {
      this.dbV = this.dbF.right;
    }
    if (this.dbU < this.dbx) {
      this.dbU = this.dbx;
    }
    if (this.dbT > this.dbF.bottom) {
      this.dbT = this.dbF.bottom;
    }
    if (this.dbS < this.dbx) {
      this.dbS = this.dbx;
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
            boolean bool = this.dbK;
            AppMethodBeat.o(9142);
            return bool;
            this.dbN = false;
            this.dbL = false;
            this.dbM = false;
            this.dbO = false;
            this.dbK = false;
          }
          this.dbK = false;
          if (this.dbJ != null) {
            this.dbJ.cancel();
          }
          if (this.dbC.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            this.dbN = true;
          }
          if (this.dbB.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            this.dbM = true;
          }
          if (this.dbD.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            this.dbL = true;
          }
          if (this.dbE.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            this.dbO = true;
          }
          this.dbP = false;
        } while (!NR());
        this.dbK = true;
        if ((this.dbN) && (this.dbL))
        {
          this.dbN = true;
          this.dbL = true;
          this.dbM = false;
          this.dbO = false;
        }
        for (;;)
        {
          this.dbQ = paramMotionEvent.getX();
          this.dbR = paramMotionEvent.getY();
          break;
          if ((this.dbN) && (this.dbO))
          {
            this.dbN = true;
            this.dbL = false;
            this.dbM = false;
            this.dbO = true;
          }
          else if ((this.dbM) && (this.dbO))
          {
            this.dbN = false;
            this.dbL = false;
            this.dbM = true;
            this.dbO = true;
          }
          else if ((this.dbM) && (this.dbO))
          {
            this.dbN = false;
            this.dbL = false;
            this.dbM = true;
            this.dbO = true;
          }
        }
      } while (!this.dbK);
      if ((paramMotionEvent.getPointerCount() == 1) && (NR()))
      {
        if ((this.dbO) && (this.cQy.right >= this.cQy.left))
        {
          if (this.cQy.right <= this.dbF.right)
          {
            if (paramMotionEvent.getX() - this.dbQ <= this.dbF.right - this.cQy.right) {
              break label1898;
            }
            this.cQy.right = this.dbF.right;
          }
          label717:
          if (this.cQy.right < this.cQy.left + this.dbx * 2) {
            this.cQy.right = (this.cQy.left + this.dbx * 2);
          }
          if (this.cQy.right > this.dbF.right) {
            this.cQy.right = this.dbF.right;
          }
          if (((int)((RectF)localObject).right <= (int)this.dbV) && ((int)((RectF)localObject).right <= this.cQy.right))
          {
            if (paramMotionEvent.getX() - this.dbQ <= this.dbV - ((RectF)localObject).right) {
              break label1929;
            }
            getMainMatrix().postTranslate(this.dbV - ((RectF)localObject).right, 0.0F);
          }
          label865:
          if ((this.cQy.width() > ((RectF)localObject).width()) && (this.cQy.right < this.dbF.right))
          {
            f1 = this.cQy.width() / ((RectF)localObject).width();
            getMainMatrix().postScale(f1, f1, this.cQy.left, this.cQy.centerY());
          }
        }
        if ((this.dbL) && (this.cQy.right >= this.cQy.left))
        {
          if (this.cQy.left >= this.dbF.left)
          {
            if (this.dbQ - paramMotionEvent.getX() <= this.cQy.left - this.dbF.left) {
              break label1950;
            }
            this.cQy.left = this.dbF.left;
          }
          label1024:
          if (this.cQy.left > this.cQy.right - this.dbx * 2) {
            this.cQy.left = (this.cQy.right - this.dbx * 2);
          }
          if (this.cQy.left < this.dbF.left) {
            this.cQy.left = this.dbF.left;
          }
          if (((int)((RectF)localObject).left >= (int)this.dbU) && ((int)((RectF)localObject).left >= this.cQy.left))
          {
            if (this.dbQ - paramMotionEvent.getX() <= ((RectF)localObject).left - this.dbU) {
              break label1981;
            }
            getMainMatrix().postTranslate(this.dbU - ((RectF)localObject).left, 0.0F);
          }
          label1172:
          if ((this.cQy.width() > ((RectF)localObject).width()) && (this.cQy.left > this.dbF.left))
          {
            f1 = this.cQy.width() / ((RectF)localObject).width();
            getMainMatrix().postScale(f1, f1, this.cQy.right, this.cQy.centerY());
          }
        }
        if ((this.dbM) && (this.cQy.bottom >= this.cQy.top))
        {
          if (this.cQy.top >= this.dbF.top)
          {
            if (this.dbR - paramMotionEvent.getY() <= this.cQy.top - this.dbF.top) {
              break label2002;
            }
            this.cQy.top = this.dbF.top;
          }
          label1331:
          if (this.cQy.top > this.cQy.bottom - this.dbx * 2) {
            this.cQy.top = (this.cQy.bottom - this.dbx * 2);
          }
          if (this.cQy.top < this.dbF.top) {
            this.cQy.top = this.dbF.top;
          }
          if (((int)((RectF)localObject).top >= (int)this.dbS) && ((int)((RectF)localObject).top >= this.cQy.top))
          {
            if (this.dbR - paramMotionEvent.getY() <= ((RectF)localObject).top - this.dbS) {
              break label2033;
            }
            getMainMatrix().postTranslate(0.0F, this.dbS - ((RectF)localObject).top);
          }
          label1479:
          if ((this.cQy.height() > ((RectF)localObject).height()) && (this.cQy.top > this.dbF.top))
          {
            f1 = this.cQy.height() / ((RectF)localObject).height();
            getMainMatrix().postScale(f1, f1, this.cQy.centerX(), this.cQy.bottom);
          }
        }
        if ((this.dbN) && (this.cQy.bottom >= this.cQy.top))
        {
          if (this.cQy.bottom <= this.dbF.bottom)
          {
            if (paramMotionEvent.getY() - this.dbR <= this.dbF.bottom - this.cQy.bottom) {
              break label2054;
            }
            this.cQy.bottom = this.dbF.bottom;
          }
          label1638:
          if (this.cQy.bottom < this.cQy.top + this.dbx * 2) {
            this.cQy.bottom = (this.cQy.top + this.dbx * 2);
          }
          if (this.cQy.bottom > this.dbF.bottom) {
            this.cQy.bottom = this.dbF.bottom;
          }
          if (((int)((RectF)localObject).bottom <= (int)this.dbT) && ((int)((RectF)localObject).bottom <= this.cQy.bottom))
          {
            if (paramMotionEvent.getY() - this.dbR <= this.dbT - ((RectF)localObject).bottom) {
              break label2085;
            }
            getMainMatrix().postTranslate(0.0F, this.dbT - ((RectF)localObject).bottom);
          }
          label1786:
          if ((this.cQy.height() > ((RectF)localObject).height()) && (this.cQy.bottom < this.dbF.bottom))
          {
            f1 = this.cQy.height() / ((RectF)localObject).height();
            getMainMatrix().postScale(f1, f1, this.cQy.centerX(), this.cQy.top);
          }
        }
        NS();
        this.dbK = true;
        NP();
        this.dbQ = paramMotionEvent.getX();
        this.dbR = paramMotionEvent.getY();
      }
      for (;;)
      {
        q(paramMotionEvent);
        break;
        label1898:
        Rect localRect = this.cQy;
        localRect.right = ((int)(localRect.right + (paramMotionEvent.getX() - this.dbQ)));
        break label717;
        label1929:
        getMainMatrix().postTranslate(paramMotionEvent.getX() - this.dbQ, 0.0F);
        break label865;
        label1950:
        localRect = this.cQy;
        localRect.left = ((int)(localRect.left - (this.dbQ - paramMotionEvent.getX())));
        break label1024;
        label1981:
        getMainMatrix().postTranslate(paramMotionEvent.getX() - this.dbQ, 0.0F);
        break label1172;
        label2002:
        localRect = this.cQy;
        localRect.top = ((int)(localRect.top - (this.dbR - paramMotionEvent.getY())));
        break label1331;
        label2033:
        getMainMatrix().postTranslate(0.0F, paramMotionEvent.getY() - this.dbR);
        break label1479;
        label2054:
        localRect = this.cQy;
        localRect.bottom = ((int)(localRect.bottom + (paramMotionEvent.getY() - this.dbR)));
        break label1638;
        label2085:
        getMainMatrix().postTranslate(0.0F, paramMotionEvent.getY() - this.dbR);
        break label1786;
        this.dbK = false;
      }
    }
    final float f1 = this.dbF.width() * 1.0F / this.cQy.width();
    float f2 = this.dbF.height() * 1.0F / this.cQy.height();
    label2160:
    long l;
    if (f1 < f2)
    {
      f2 = this.dbF.centerX();
      float f3 = this.dbF.centerY();
      float f4 = this.cQy.centerX();
      float f5 = this.cQy.centerY();
      paramMotionEvent = h.MqF;
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(195410);
          c.b(c.this).cQB = 1000L;
          com.tencent.mm.c.a locala = c.b(c.this);
          float f1 = f1;
          Rect localRect = c.c(c.this);
          float f2 = this.dcc;
          float f3 = this.dcd;
          locala.cQw = f2;
          locala.cQx = f3;
          locala.cQy = localRect;
          locala.cQz.set(locala.cQy);
          locala.cQv = f1;
          c.b(c.this).play();
          AppMethodBeat.o(195410);
        }
      };
      if (!this.dbK) {
        break label2288;
      }
      l = 0L;
      label2233:
      paramMotionEvent.q((Runnable)localObject, l);
      if (!NR()) {
        break label2296;
      }
    }
    label2288:
    label2296:
    for (this.dbK = true;; this.dbK = false)
    {
      this.dbN = false;
      this.dbL = false;
      this.dbM = false;
      this.dbO = false;
      NQ();
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
    if (this.dbF.isEmpty()) {
      this.dbF.set(this.dbx, this.dbx * 2, getBoardRect().width() - this.dbx, getBoardRect().height() - this.dby - this.dbz - this.dbx * 2);
    }
    ae.i("MicroMsg.CropArtist", "[onAlive] CROP_MAX_RECT:%s", new Object[] { this.dbF });
    if (NI() == null)
    {
      ae.i("MicroMsg.CropArtist", "[onAlive] getCache is null");
      AppMethodBeat.o(9138);
      return;
    }
    com.tencent.mm.z.a locala = ((com.tencent.mm.cache.a)NI()).XR();
    if ((locala != null) && (!locala.gBq.isEmpty()))
    {
      this.dbm.fjH().getBaseBoardView().q(locala.gBq);
      float f = b(locala.mMatrix);
      ae.i("MicroMsg.CropArtist", "[onAlive] rotation:%s", new Object[] { Float.valueOf(f) });
      getMainMatrix().postRotate(-f, locala.gBq.centerX(), locala.gBq.centerY());
    }
    AppMethodBeat.o(9138);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9141);
    if (!this.dbI) {
      paramCanvas.setMatrix(null);
    }
    com.tencent.mm.z.a locala;
    boolean bool1;
    boolean bool2;
    for (;;)
    {
      locala = this.dbG;
      bool1 = this.dbP;
      bool2 = this.dbH;
      if (locala.cQy != null) {
        break;
      }
      ae.e("MicroMsg.CropItem", "[draw] mBoxRect is null!");
      AppMethodBeat.o(9141);
      return;
      paramCanvas.setMatrix(this.dbA);
    }
    if (bool1)
    {
      paramCanvas.save();
      paramCanvas.clipRect(locala.cQy, Region.Op.DIFFERENCE);
      paramCanvas.drawPaint(com.tencent.mm.z.a.gBm);
      paramCanvas.restore();
    }
    if (bool2)
    {
      if (!com.tencent.mm.z.a.TW.equals(locala.cQy))
      {
        com.tencent.mm.z.a.gBj.reset();
        com.tencent.mm.z.a.gBj.moveTo(locala.cQy.left, locala.cQy.top);
        com.tencent.mm.z.a.gBj.lineTo(locala.cQy.right, locala.cQy.top);
        com.tencent.mm.z.a.gBj.lineTo(locala.cQy.right, locala.cQy.bottom);
        com.tencent.mm.z.a.gBj.lineTo(locala.cQy.left, locala.cQy.bottom);
        com.tencent.mm.z.a.gBj.close();
        com.tencent.mm.z.a.gBi.reset();
        int i = 1;
        while (i < 3)
        {
          com.tencent.mm.z.a.gBi.moveTo(locala.cQy.left + locala.cQy.width() / 3 * i, locala.cQy.top);
          com.tencent.mm.z.a.gBi.lineTo(locala.cQy.left + locala.cQy.width() / 3 * i, locala.cQy.bottom);
          com.tencent.mm.z.a.gBi.moveTo(locala.cQy.left, locala.cQy.top + locala.cQy.height() / 3 * i);
          com.tencent.mm.z.a.gBi.lineTo(locala.cQy.right, locala.cQy.top + locala.cQy.height() / 3 * i);
          i += 1;
        }
      }
      paramCanvas.drawRect(locala.cQy.left, locala.cQy.top, locala.cQy.right, locala.cQy.bottom, com.tencent.mm.z.a.gBl);
      paramCanvas.drawPath(com.tencent.mm.z.a.gBi, com.tencent.mm.z.a.gBn);
      paramCanvas.drawPath(com.tencent.mm.z.a.gBj, com.tencent.mm.z.a.gBk);
      float f1 = locala.cQy.left;
      float f2 = com.tencent.mm.z.a.gBg;
      float f3 = locala.cQy.top;
      float f4 = com.tencent.mm.z.a.gBg / 2.0F;
      float f5 = locala.cQy.left;
      paramCanvas.drawLine(f1 - f2, f3 - f4, com.tencent.mm.z.a.gBh + f5, locala.cQy.top - com.tencent.mm.z.a.gBg / 2.0F, com.tencent.mm.z.a.gBo);
      f1 = locala.cQy.right;
      f2 = com.tencent.mm.z.a.gBh;
      f3 = com.tencent.mm.z.a.gBg / 2.0F;
      f4 = locala.cQy.top;
      f5 = com.tencent.mm.z.a.gBg / 2.0F;
      float f6 = locala.cQy.right;
      paramCanvas.drawLine(f3 + (f1 - f2), f4 - f5, com.tencent.mm.z.a.gBg + f6, locala.cQy.top - com.tencent.mm.z.a.gBg / 2.0F, com.tencent.mm.z.a.gBo);
      f1 = locala.cQy.left;
      f2 = com.tencent.mm.z.a.gBg / 2.0F;
      f3 = locala.cQy.top;
      f4 = com.tencent.mm.z.a.gBg / 2.0F;
      f5 = locala.cQy.left;
      f6 = com.tencent.mm.z.a.gBg / 2.0F;
      float f7 = locala.cQy.top;
      paramCanvas.drawLine(f1 - f2, f3 - f4, f5 - f6, com.tencent.mm.z.a.gBh + f7, com.tencent.mm.z.a.gBo);
      f1 = locala.cQy.left;
      f2 = com.tencent.mm.z.a.gBg / 2.0F;
      f3 = locala.cQy.bottom;
      f4 = com.tencent.mm.z.a.gBh;
      f5 = com.tencent.mm.z.a.gBg / 2.0F;
      f6 = locala.cQy.left;
      f7 = com.tencent.mm.z.a.gBg / 2.0F;
      float f8 = locala.cQy.bottom;
      paramCanvas.drawLine(f1 - f2, f5 + (f3 - f4), f6 - f7, com.tencent.mm.z.a.gBg / 2.0F + f8, com.tencent.mm.z.a.gBo);
      f1 = locala.cQy.right;
      f2 = com.tencent.mm.z.a.gBg / 2.0F;
      f3 = locala.cQy.top;
      f4 = locala.cQy.right;
      f5 = com.tencent.mm.z.a.gBg / 2.0F;
      f6 = locala.cQy.top;
      paramCanvas.drawLine(f2 + f1, f3, f5 + f4, com.tencent.mm.z.a.gBh + f6, com.tencent.mm.z.a.gBo);
      f1 = locala.cQy.right;
      f2 = com.tencent.mm.z.a.gBg / 2.0F;
      f3 = locala.cQy.bottom;
      f4 = com.tencent.mm.z.a.gBh;
      f5 = com.tencent.mm.z.a.gBg / 2.0F;
      f6 = locala.cQy.right;
      f7 = com.tencent.mm.z.a.gBg / 2.0F;
      f8 = locala.cQy.bottom;
      paramCanvas.drawLine(f2 + f1, f5 + (f3 - f4), f7 + f6, com.tencent.mm.z.a.gBg / 2.0F + f8, com.tencent.mm.z.a.gBo);
      f1 = locala.cQy.left;
      f2 = com.tencent.mm.z.a.gBg;
      f3 = locala.cQy.bottom;
      f4 = com.tencent.mm.z.a.gBg / 2.0F;
      f5 = locala.cQy.left;
      f6 = com.tencent.mm.z.a.gBh;
      f7 = locala.cQy.bottom;
      paramCanvas.drawLine(f1 - f2, f4 + f3, f6 + f5, com.tencent.mm.z.a.gBg / 2.0F + f7, com.tencent.mm.z.a.gBo);
      f1 = locala.cQy.right;
      f2 = com.tencent.mm.z.a.gBh;
      f3 = locala.cQy.bottom;
      f4 = com.tencent.mm.z.a.gBg / 2.0F;
      f5 = locala.cQy.right;
      f6 = com.tencent.mm.z.a.gBg;
      f7 = locala.cQy.bottom;
      paramCanvas.drawLine(f1 - f2, f4 + f3, f6 + f5, com.tencent.mm.z.a.gBg / 2.0F + f7, com.tencent.mm.z.a.gBo);
      if (!com.tencent.mm.z.a.TW.equals(locala.cQy)) {
        com.tencent.mm.z.a.TW.set(locala.cQy);
      }
    }
    AppMethodBeat.o(9141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.e.c
 * JD-Core Version:    0.7.0.1
 */