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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.view.b.a.b;
import java.util.Stack;

public final class c
  extends b<com.tencent.mm.cache.a>
{
  public Rect cEJ;
  float cPA;
  float cPB;
  float cPC;
  float cPD;
  public ValueAnimator cPE;
  public Rect cPF;
  public int cPG;
  public boolean cPH;
  private int cPf;
  private int cPg;
  private int cPh;
  private Matrix cPi;
  private RectF cPj;
  private RectF cPk;
  private RectF cPl;
  private RectF cPm;
  public final Rect cPn;
  private com.tencent.mm.z.a cPo;
  private boolean cPp;
  private boolean cPq;
  public com.tencent.mm.c.a cPr;
  boolean cPs;
  boolean cPt;
  boolean cPu;
  boolean cPv;
  boolean cPw;
  public boolean cPx;
  float cPy;
  float cPz;
  
  public c()
  {
    AppMethodBeat.i(9136);
    this.cPf = ((int)ai.getResources().getDimension(2131165936));
    this.cPg = ((int)ai.getResources().getDimension(2131166289));
    this.cPh = ((int)ai.getResources().getDimension(2131166083));
    this.cPi = new Matrix();
    this.cPn = new Rect();
    this.cPp = false;
    this.cPq = false;
    this.cPs = false;
    this.cPt = false;
    this.cPu = false;
    this.cPv = false;
    this.cPw = false;
    this.cPx = true;
    this.cPF = new Rect();
    this.cPG = 0;
    this.cPH = false;
    AppMethodBeat.o(9136);
  }
  
  private boolean Mk()
  {
    return (this.cPv) || (this.cPt) || (this.cPu) || (this.cPw);
  }
  
  public final a LZ()
  {
    return a.cOQ;
  }
  
  public final void Ma() {}
  
  public final void Mc()
  {
    AppMethodBeat.i(9139);
    super.Mc();
    this.cOU.eQN().getActionBar().setVisibility(8);
    this.cPF.setEmpty();
    if (Mb() == null)
    {
      ac.e("MicroMsg.CropArtist", "[onSelected] getCache is null!");
      AppMethodBeat.o(9139);
      return;
    }
    com.tencent.mm.z.a locala;
    if (((com.tencent.mm.cache.a)Mb()).aj(true) <= 0)
    {
      locala = new com.tencent.mm.z.a();
      locala.mMatrix.set(getMainMatrix());
      ((com.tencent.mm.cache.a)Mb()).a(locala);
      Mm();
      this.cOU.eQN().getBaseBoardView().Jzg = this.cEJ;
      this.cOU.eQN().getBaseBoardView().a(new a.b()
      {
        public final void Mo()
        {
          AppMethodBeat.i(9119);
          if (c.this.Mb() == null)
          {
            AppMethodBeat.o(9119);
            return;
          }
          if (((com.tencent.mm.cache.a)c.this.Mb()).fpZ.isIdentity())
          {
            localObject = (com.tencent.mm.cache.a)c.this.Mb();
            Matrix localMatrix = c.this.getMainMatrix();
            ((com.tencent.mm.cache.a)localObject).fpZ.set(localMatrix);
          }
          Object localObject = new Rect();
          if (c.this.cOU.eQQ() == null) {
            ((Rect)localObject).set(0, 0, c.this.cOU.eQN().getBaseBoardView().getBoardRect().width(), c.this.cOU.eQN().getBaseBoardView().getBoardRect().height());
          }
          for (;;)
          {
            c.this.cOU.eQN().getBaseBoardView().r((Rect)localObject);
            c.a(c.this, 200L, true, false);
            c.this.Mj();
            AppMethodBeat.o(9119);
            return;
            ((Rect)localObject).set(0, 0, c.this.cOU.eQQ().getWidth(), c.this.cOU.eQQ().getHeight());
          }
        }
        
        public final void onStart()
        {
          AppMethodBeat.i(9120);
          c.a(c.this, false);
          c.this.cPx = false;
          AppMethodBeat.o(9120);
        }
      }, 0.0F, false);
    }
    for (;;)
    {
      setOneFingerMoveEnable(true);
      AppMethodBeat.o(9139);
      return;
      locala = ((com.tencent.mm.cache.a)Mb()).Vq();
      if (locala == null)
      {
        ac.e("MicroMsg.CropArtist", "item is null!!!");
        AppMethodBeat.o(9139);
        return;
      }
      this.cEJ.set(new Rect(locala.cEJ));
      this.cOU.eQN().getBaseBoardView().Jzg = locala.cEJ;
      try
      {
        ((com.tencent.mm.cache.a)Mb()).a((com.tencent.mm.z.a)locala.clone());
        this.cOU.eQN().getBaseBoardView().a(new a.b()
        {
          public final void Mo()
          {
            AppMethodBeat.i(9121);
            c.this.cPx = true;
            Rect localRect;
            if (c.this.cOU.eQQ() == null)
            {
              localRect = new Rect();
              ac.e("MicroMsg.CropArtist", "getImageBitmap is null!");
            }
            for (;;)
            {
              c.this.cOU.eQN().getBaseBoardView().r(localRect);
              c.a(c.this, 200L, true, false);
              AppMethodBeat.o(9121);
              return;
              localRect = new Rect(0, 0, c.this.cOU.eQQ().getWidth(), c.this.cOU.eQQ().getHeight());
            }
          }
          
          public final void onStart()
          {
            AppMethodBeat.i(9122);
            c.a(c.this, false);
            c.this.cPx = false;
            c.a(c.this);
            com.tencent.mm.z.a.lZ(282);
            AppMethodBeat.o(9122);
          }
        }, 0.0F, false);
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.CropArtist", localCloneNotSupportedException, "", new Object[0]);
        }
      }
    }
  }
  
  public final boolean Me()
  {
    AppMethodBeat.i(9140);
    if (Mb() == null)
    {
      AppMethodBeat.o(9140);
      return false;
    }
    if (!((com.tencent.mm.cache.a)Mb()).fpZ.equals(getMainMatrix()))
    {
      AppMethodBeat.o(9140);
      return true;
    }
    AppMethodBeat.o(9140);
    return false;
  }
  
  public final void Ml()
  {
    AppMethodBeat.i(9143);
    this.cPk.set(this.cEJ.left - this.cPf, this.cEJ.bottom - this.cPf, this.cEJ.right + this.cPf, this.cEJ.bottom + this.cPf);
    this.cPj.set(this.cEJ.left - this.cPf, this.cEJ.top - this.cPf, this.cEJ.right + this.cPf, this.cEJ.top + this.cPf);
    this.cPl.set(this.cEJ.left - this.cPf, this.cEJ.top - this.cPf, this.cEJ.left + this.cPf, this.cEJ.bottom + this.cPf);
    this.cPm.set(this.cEJ.right - this.cPf, this.cEJ.top - this.cPf, this.cEJ.right + this.cPf, this.cEJ.bottom + this.cPf);
    AppMethodBeat.o(9143);
  }
  
  public final void Mm()
  {
    AppMethodBeat.i(9144);
    if (this.cOU.eQQ() == null)
    {
      ac.w("MicroMsg.CropArtist", "[resetBoxRect] getImageBitmap is null!");
      AppMethodBeat.o(9144);
      return;
    }
    float f1 = this.cOU.eQQ().getWidth() * 1.0F / this.cOU.eQQ().getHeight();
    int i;
    if (f1 < this.cPn.width() * 1.0F / this.cPn.height())
    {
      float f2 = this.cPn.height();
      i = (int)((this.cPn.width() - f1 * f2) / 2.0F);
      this.cEJ.set(this.cPn.left + i, this.cPn.top, this.cPn.right - i, this.cPn.bottom);
    }
    for (;;)
    {
      Ml();
      AppMethodBeat.o(9144);
      return;
      f1 = this.cPn.width() / f1;
      i = (int)((this.cPn.height() - f1) / 2.0F);
      this.cEJ.set(this.cPn.left, this.cPn.top + i, this.cPn.right, this.cPn.bottom - i);
    }
  }
  
  public final void Mn()
  {
    AppMethodBeat.i(9145);
    this.cOU.eQN().getBaseBoardView().Jzg = this.cOU.eQN().getBaseBoardView().getRawBoardRect();
    Object localObject1 = new RectF(this.cEJ);
    Object localObject2 = new Matrix();
    getMainMatrix().invert((Matrix)localObject2);
    ((Matrix)localObject2).mapRect((RectF)localObject1);
    localObject2 = new Rect();
    ((RectF)localObject1).round((Rect)localObject2);
    this.cOU.eQN().getBaseBoardView().r((Rect)localObject2);
    localObject1 = new com.tencent.mm.z.a();
    ((com.tencent.mm.z.a)localObject1).cEJ = new Rect(this.cEJ);
    ((com.tencent.mm.z.a)localObject1).geZ.set((Rect)localObject2);
    this.cOU.eQN().getBaseBoardView().a(new a.b()
    {
      public final void Mo()
      {
        AppMethodBeat.i(9130);
        Object localObject = this.cPM;
        Matrix localMatrix = c.this.getMainMatrix();
        ((com.tencent.mm.z.a)localObject).mMatrix.set(localMatrix);
        if (c.this.Mb() != null)
        {
          localObject = (com.tencent.mm.cache.a)c.this.Mb();
          if (((com.tencent.mm.cache.a)localObject).fpX != null) {
            ((com.tencent.mm.cache.a)localObject).fpX.clear();
          }
          ((com.tencent.mm.cache.a)c.this.Mb()).a(this.cPM);
        }
        AppMethodBeat.o(9130);
      }
      
      public final void onStart()
      {
        AppMethodBeat.i(9131);
        AppMethodBeat.o(9131);
      }
    }, 0.0F, true);
    this.cOU.eQN().getActionBar().setVisibility(0);
    AppMethodBeat.o(9145);
  }
  
  public final void a(com.tencent.mm.bt.b paramb, Matrix paramMatrix, Rect paramRect)
  {
    AppMethodBeat.i(9137);
    super.a(paramb, paramMatrix, paramRect);
    this.cEJ = new Rect();
    this.cPk = new RectF();
    this.cPj = new RectF();
    this.cPl = new RectF();
    this.cPm = new RectF();
    this.cPo = new com.tencent.mm.z.a(this.cEJ);
    this.cPr = new com.tencent.mm.c.a(this);
    AppMethodBeat.o(9137);
  }
  
  public final boolean n(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9142);
    if (!Mg())
    {
      AppMethodBeat.o(9142);
      return false;
    }
    Object localObject = this.cOU.eQN().getBaseBoardView().getCurImageRect();
    this.cPA = (((RectF)localObject).top - (((RectF)localObject).bottom - this.cEJ.bottom));
    this.cPB = (((RectF)localObject).bottom + (this.cEJ.top - ((RectF)localObject).top));
    this.cPC = (((RectF)localObject).left - (((RectF)localObject).right - this.cEJ.right));
    this.cPD = (((RectF)localObject).right + (this.cEJ.left - ((RectF)localObject).left));
    if (this.cPD > this.cPn.right) {
      this.cPD = this.cPn.right;
    }
    if (this.cPC < this.cPf) {
      this.cPC = this.cPf;
    }
    if (this.cPB > this.cPn.bottom) {
      this.cPB = this.cPn.bottom;
    }
    if (this.cPA < this.cPf) {
      this.cPA = this.cPf;
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
            boolean bool = this.cPs;
            AppMethodBeat.o(9142);
            return bool;
            this.cPv = false;
            this.cPt = false;
            this.cPu = false;
            this.cPw = false;
            this.cPs = false;
          }
          this.cPs = false;
          if (this.cPr != null) {
            this.cPr.cancel();
          }
          if (this.cPk.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            this.cPv = true;
          }
          if (this.cPj.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            this.cPu = true;
          }
          if (this.cPl.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            this.cPt = true;
          }
          if (this.cPm.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
            this.cPw = true;
          }
          this.cPx = false;
        } while (!Mk());
        this.cPs = true;
        if ((this.cPv) && (this.cPt))
        {
          this.cPv = true;
          this.cPt = true;
          this.cPu = false;
          this.cPw = false;
        }
        for (;;)
        {
          this.cPy = paramMotionEvent.getX();
          this.cPz = paramMotionEvent.getY();
          break;
          if ((this.cPv) && (this.cPw))
          {
            this.cPv = true;
            this.cPt = false;
            this.cPu = false;
            this.cPw = true;
          }
          else if ((this.cPu) && (this.cPw))
          {
            this.cPv = false;
            this.cPt = false;
            this.cPu = true;
            this.cPw = true;
          }
          else if ((this.cPu) && (this.cPw))
          {
            this.cPv = false;
            this.cPt = false;
            this.cPu = true;
            this.cPw = true;
          }
        }
      } while (!this.cPs);
      if ((paramMotionEvent.getPointerCount() == 1) && (Mk()))
      {
        if ((this.cPw) && (this.cEJ.right >= this.cEJ.left))
        {
          if (this.cEJ.right <= this.cPn.right)
          {
            if (paramMotionEvent.getX() - this.cPy <= this.cPn.right - this.cEJ.right) {
              break label1898;
            }
            this.cEJ.right = this.cPn.right;
          }
          label717:
          if (this.cEJ.right < this.cEJ.left + this.cPf * 2) {
            this.cEJ.right = (this.cEJ.left + this.cPf * 2);
          }
          if (this.cEJ.right > this.cPn.right) {
            this.cEJ.right = this.cPn.right;
          }
          if (((int)((RectF)localObject).right <= (int)this.cPD) && ((int)((RectF)localObject).right <= this.cEJ.right))
          {
            if (paramMotionEvent.getX() - this.cPy <= this.cPD - ((RectF)localObject).right) {
              break label1929;
            }
            getMainMatrix().postTranslate(this.cPD - ((RectF)localObject).right, 0.0F);
          }
          label865:
          if ((this.cEJ.width() > ((RectF)localObject).width()) && (this.cEJ.right < this.cPn.right))
          {
            f1 = this.cEJ.width() / ((RectF)localObject).width();
            getMainMatrix().postScale(f1, f1, this.cEJ.left, this.cEJ.centerY());
          }
        }
        if ((this.cPt) && (this.cEJ.right >= this.cEJ.left))
        {
          if (this.cEJ.left >= this.cPn.left)
          {
            if (this.cPy - paramMotionEvent.getX() <= this.cEJ.left - this.cPn.left) {
              break label1950;
            }
            this.cEJ.left = this.cPn.left;
          }
          label1024:
          if (this.cEJ.left > this.cEJ.right - this.cPf * 2) {
            this.cEJ.left = (this.cEJ.right - this.cPf * 2);
          }
          if (this.cEJ.left < this.cPn.left) {
            this.cEJ.left = this.cPn.left;
          }
          if (((int)((RectF)localObject).left >= (int)this.cPC) && ((int)((RectF)localObject).left >= this.cEJ.left))
          {
            if (this.cPy - paramMotionEvent.getX() <= ((RectF)localObject).left - this.cPC) {
              break label1981;
            }
            getMainMatrix().postTranslate(this.cPC - ((RectF)localObject).left, 0.0F);
          }
          label1172:
          if ((this.cEJ.width() > ((RectF)localObject).width()) && (this.cEJ.left > this.cPn.left))
          {
            f1 = this.cEJ.width() / ((RectF)localObject).width();
            getMainMatrix().postScale(f1, f1, this.cEJ.right, this.cEJ.centerY());
          }
        }
        if ((this.cPu) && (this.cEJ.bottom >= this.cEJ.top))
        {
          if (this.cEJ.top >= this.cPn.top)
          {
            if (this.cPz - paramMotionEvent.getY() <= this.cEJ.top - this.cPn.top) {
              break label2002;
            }
            this.cEJ.top = this.cPn.top;
          }
          label1331:
          if (this.cEJ.top > this.cEJ.bottom - this.cPf * 2) {
            this.cEJ.top = (this.cEJ.bottom - this.cPf * 2);
          }
          if (this.cEJ.top < this.cPn.top) {
            this.cEJ.top = this.cPn.top;
          }
          if (((int)((RectF)localObject).top >= (int)this.cPA) && ((int)((RectF)localObject).top >= this.cEJ.top))
          {
            if (this.cPz - paramMotionEvent.getY() <= ((RectF)localObject).top - this.cPA) {
              break label2033;
            }
            getMainMatrix().postTranslate(0.0F, this.cPA - ((RectF)localObject).top);
          }
          label1479:
          if ((this.cEJ.height() > ((RectF)localObject).height()) && (this.cEJ.top > this.cPn.top))
          {
            f1 = this.cEJ.height() / ((RectF)localObject).height();
            getMainMatrix().postScale(f1, f1, this.cEJ.centerX(), this.cEJ.bottom);
          }
        }
        if ((this.cPv) && (this.cEJ.bottom >= this.cEJ.top))
        {
          if (this.cEJ.bottom <= this.cPn.bottom)
          {
            if (paramMotionEvent.getY() - this.cPz <= this.cPn.bottom - this.cEJ.bottom) {
              break label2054;
            }
            this.cEJ.bottom = this.cPn.bottom;
          }
          label1638:
          if (this.cEJ.bottom < this.cEJ.top + this.cPf * 2) {
            this.cEJ.bottom = (this.cEJ.top + this.cPf * 2);
          }
          if (this.cEJ.bottom > this.cPn.bottom) {
            this.cEJ.bottom = this.cPn.bottom;
          }
          if (((int)((RectF)localObject).bottom <= (int)this.cPB) && ((int)((RectF)localObject).bottom <= this.cEJ.bottom))
          {
            if (paramMotionEvent.getY() - this.cPz <= this.cPB - ((RectF)localObject).bottom) {
              break label2085;
            }
            getMainMatrix().postTranslate(0.0F, this.cPB - ((RectF)localObject).bottom);
          }
          label1786:
          if ((this.cEJ.height() > ((RectF)localObject).height()) && (this.cEJ.bottom < this.cPn.bottom))
          {
            f1 = this.cEJ.height() / ((RectF)localObject).height();
            getMainMatrix().postScale(f1, f1, this.cEJ.centerX(), this.cEJ.top);
          }
        }
        Ml();
        this.cPs = true;
        Mi();
        this.cPy = paramMotionEvent.getX();
        this.cPz = paramMotionEvent.getY();
      }
      for (;;)
      {
        q(paramMotionEvent);
        break;
        label1898:
        Rect localRect = this.cEJ;
        localRect.right = ((int)(localRect.right + (paramMotionEvent.getX() - this.cPy)));
        break label717;
        label1929:
        getMainMatrix().postTranslate(paramMotionEvent.getX() - this.cPy, 0.0F);
        break label865;
        label1950:
        localRect = this.cEJ;
        localRect.left = ((int)(localRect.left - (this.cPy - paramMotionEvent.getX())));
        break label1024;
        label1981:
        getMainMatrix().postTranslate(paramMotionEvent.getX() - this.cPy, 0.0F);
        break label1172;
        label2002:
        localRect = this.cEJ;
        localRect.top = ((int)(localRect.top - (this.cPz - paramMotionEvent.getY())));
        break label1331;
        label2033:
        getMainMatrix().postTranslate(0.0F, paramMotionEvent.getY() - this.cPz);
        break label1479;
        label2054:
        localRect = this.cEJ;
        localRect.bottom = ((int)(localRect.bottom + (paramMotionEvent.getY() - this.cPz)));
        break label1638;
        label2085:
        getMainMatrix().postTranslate(0.0F, paramMotionEvent.getY() - this.cPz);
        break label1786;
        this.cPs = false;
      }
    }
    final float f1 = this.cPn.width() * 1.0F / this.cEJ.width();
    float f2 = this.cPn.height() * 1.0F / this.cEJ.height();
    label2160:
    long l;
    if (f1 < f2)
    {
      f2 = this.cPn.centerX();
      float f3 = this.cPn.centerY();
      float f4 = this.cEJ.centerX();
      float f5 = this.cEJ.centerY();
      paramMotionEvent = h.JZN;
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(199913);
          c.b(c.this).cEM = 1000L;
          com.tencent.mm.c.a locala = c.b(c.this);
          float f1 = f1;
          Rect localRect = c.c(c.this);
          float f2 = this.cPK;
          float f3 = this.cPL;
          locala.cEH = f2;
          locala.cEI = f3;
          locala.cEJ = localRect;
          locala.cEK.set(locala.cEJ);
          locala.cEG = f1;
          c.b(c.this).play();
          AppMethodBeat.o(199913);
        }
      };
      if (!this.cPs) {
        break label2288;
      }
      l = 0L;
      label2233:
      paramMotionEvent.p((Runnable)localObject, l);
      if (!Mk()) {
        break label2296;
      }
    }
    label2288:
    label2296:
    for (this.cPs = true;; this.cPs = false)
    {
      this.cPv = false;
      this.cPt = false;
      this.cPu = false;
      this.cPw = false;
      Mj();
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
    if (this.cPn.isEmpty()) {
      this.cPn.set(this.cPf, this.cPf * 2, getBoardRect().width() - this.cPf, getBoardRect().height() - this.cPg - this.cPh - this.cPf * 2);
    }
    ac.i("MicroMsg.CropArtist", "[onAlive] CROP_MAX_RECT:%s", new Object[] { this.cPn });
    if (Mb() == null)
    {
      ac.i("MicroMsg.CropArtist", "[onAlive] getCache is null");
      AppMethodBeat.o(9138);
      return;
    }
    com.tencent.mm.z.a locala = ((com.tencent.mm.cache.a)Mb()).Vq();
    if ((locala != null) && (!locala.geZ.isEmpty()))
    {
      this.cOU.eQN().getBaseBoardView().r(locala.geZ);
      float f = b(locala.mMatrix);
      ac.i("MicroMsg.CropArtist", "[onAlive] rotation:%s", new Object[] { Float.valueOf(f) });
      getMainMatrix().postRotate(-f, locala.geZ.centerX(), locala.geZ.centerY());
    }
    AppMethodBeat.o(9138);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9141);
    if (!this.cPq) {
      paramCanvas.setMatrix(null);
    }
    com.tencent.mm.z.a locala;
    boolean bool1;
    boolean bool2;
    for (;;)
    {
      locala = this.cPo;
      bool1 = this.cPx;
      bool2 = this.cPp;
      if (locala.cEJ != null) {
        break;
      }
      ac.e("MicroMsg.CropItem", "[draw] mBoxRect is null!");
      AppMethodBeat.o(9141);
      return;
      paramCanvas.setMatrix(this.cPi);
    }
    if (bool1)
    {
      paramCanvas.save();
      paramCanvas.clipRect(locala.cEJ, Region.Op.DIFFERENCE);
      paramCanvas.drawPaint(com.tencent.mm.z.a.geV);
      paramCanvas.restore();
    }
    if (bool2)
    {
      if (!com.tencent.mm.z.a.Sh.equals(locala.cEJ))
      {
        com.tencent.mm.z.a.geS.reset();
        com.tencent.mm.z.a.geS.moveTo(locala.cEJ.left, locala.cEJ.top);
        com.tencent.mm.z.a.geS.lineTo(locala.cEJ.right, locala.cEJ.top);
        com.tencent.mm.z.a.geS.lineTo(locala.cEJ.right, locala.cEJ.bottom);
        com.tencent.mm.z.a.geS.lineTo(locala.cEJ.left, locala.cEJ.bottom);
        com.tencent.mm.z.a.geS.close();
        com.tencent.mm.z.a.geR.reset();
        int i = 1;
        while (i < 3)
        {
          com.tencent.mm.z.a.geR.moveTo(locala.cEJ.left + locala.cEJ.width() / 3 * i, locala.cEJ.top);
          com.tencent.mm.z.a.geR.lineTo(locala.cEJ.left + locala.cEJ.width() / 3 * i, locala.cEJ.bottom);
          com.tencent.mm.z.a.geR.moveTo(locala.cEJ.left, locala.cEJ.top + locala.cEJ.height() / 3 * i);
          com.tencent.mm.z.a.geR.lineTo(locala.cEJ.right, locala.cEJ.top + locala.cEJ.height() / 3 * i);
          i += 1;
        }
      }
      paramCanvas.drawRect(locala.cEJ.left, locala.cEJ.top, locala.cEJ.right, locala.cEJ.bottom, com.tencent.mm.z.a.geU);
      paramCanvas.drawPath(com.tencent.mm.z.a.geR, com.tencent.mm.z.a.geW);
      paramCanvas.drawPath(com.tencent.mm.z.a.geS, com.tencent.mm.z.a.geT);
      float f1 = locala.cEJ.left;
      float f2 = com.tencent.mm.z.a.geP;
      float f3 = locala.cEJ.top;
      float f4 = com.tencent.mm.z.a.geP / 2.0F;
      float f5 = locala.cEJ.left;
      paramCanvas.drawLine(f1 - f2, f3 - f4, com.tencent.mm.z.a.geQ + f5, locala.cEJ.top - com.tencent.mm.z.a.geP / 2.0F, com.tencent.mm.z.a.geX);
      f1 = locala.cEJ.right;
      f2 = com.tencent.mm.z.a.geQ;
      f3 = com.tencent.mm.z.a.geP / 2.0F;
      f4 = locala.cEJ.top;
      f5 = com.tencent.mm.z.a.geP / 2.0F;
      float f6 = locala.cEJ.right;
      paramCanvas.drawLine(f3 + (f1 - f2), f4 - f5, com.tencent.mm.z.a.geP + f6, locala.cEJ.top - com.tencent.mm.z.a.geP / 2.0F, com.tencent.mm.z.a.geX);
      f1 = locala.cEJ.left;
      f2 = com.tencent.mm.z.a.geP / 2.0F;
      f3 = locala.cEJ.top;
      f4 = com.tencent.mm.z.a.geP / 2.0F;
      f5 = locala.cEJ.left;
      f6 = com.tencent.mm.z.a.geP / 2.0F;
      float f7 = locala.cEJ.top;
      paramCanvas.drawLine(f1 - f2, f3 - f4, f5 - f6, com.tencent.mm.z.a.geQ + f7, com.tencent.mm.z.a.geX);
      f1 = locala.cEJ.left;
      f2 = com.tencent.mm.z.a.geP / 2.0F;
      f3 = locala.cEJ.bottom;
      f4 = com.tencent.mm.z.a.geQ;
      f5 = com.tencent.mm.z.a.geP / 2.0F;
      f6 = locala.cEJ.left;
      f7 = com.tencent.mm.z.a.geP / 2.0F;
      float f8 = locala.cEJ.bottom;
      paramCanvas.drawLine(f1 - f2, f5 + (f3 - f4), f6 - f7, com.tencent.mm.z.a.geP / 2.0F + f8, com.tencent.mm.z.a.geX);
      f1 = locala.cEJ.right;
      f2 = com.tencent.mm.z.a.geP / 2.0F;
      f3 = locala.cEJ.top;
      f4 = locala.cEJ.right;
      f5 = com.tencent.mm.z.a.geP / 2.0F;
      f6 = locala.cEJ.top;
      paramCanvas.drawLine(f2 + f1, f3, f5 + f4, com.tencent.mm.z.a.geQ + f6, com.tencent.mm.z.a.geX);
      f1 = locala.cEJ.right;
      f2 = com.tencent.mm.z.a.geP / 2.0F;
      f3 = locala.cEJ.bottom;
      f4 = com.tencent.mm.z.a.geQ;
      f5 = com.tencent.mm.z.a.geP / 2.0F;
      f6 = locala.cEJ.right;
      f7 = com.tencent.mm.z.a.geP / 2.0F;
      f8 = locala.cEJ.bottom;
      paramCanvas.drawLine(f2 + f1, f5 + (f3 - f4), f7 + f6, com.tencent.mm.z.a.geP / 2.0F + f8, com.tencent.mm.z.a.geX);
      f1 = locala.cEJ.left;
      f2 = com.tencent.mm.z.a.geP;
      f3 = locala.cEJ.bottom;
      f4 = com.tencent.mm.z.a.geP / 2.0F;
      f5 = locala.cEJ.left;
      f6 = com.tencent.mm.z.a.geQ;
      f7 = locala.cEJ.bottom;
      paramCanvas.drawLine(f1 - f2, f4 + f3, f6 + f5, com.tencent.mm.z.a.geP / 2.0F + f7, com.tencent.mm.z.a.geX);
      f1 = locala.cEJ.right;
      f2 = com.tencent.mm.z.a.geQ;
      f3 = locala.cEJ.bottom;
      f4 = com.tencent.mm.z.a.geP / 2.0F;
      f5 = locala.cEJ.right;
      f6 = com.tencent.mm.z.a.geP;
      f7 = locala.cEJ.bottom;
      paramCanvas.drawLine(f1 - f2, f4 + f3, f6 + f5, com.tencent.mm.z.a.geP / 2.0F + f7, com.tencent.mm.z.a.geX);
      if (!com.tencent.mm.z.a.Sh.equals(locala.cEJ)) {
        com.tencent.mm.z.a.Sh.set(locala.cEJ);
      }
    }
    AppMethodBeat.o(9141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.e.c
 * JD-Core Version:    0.7.0.1
 */