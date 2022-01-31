package com.tencent.mm.e;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.k;
import com.tencent.mm.b.c.1;
import com.tencent.mm.b.c.2;
import com.tencent.mm.cache.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.am;
import java.util.ListIterator;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;

public final class e
  extends b<d>
{
  private boolean cdU;
  private TimerTask cdV;
  private Rect cdW;
  private float cdX;
  private float cdY;
  private int cdZ;
  private boolean cdw;
  private int cea;
  private boolean ceb;
  private com.tencent.mm.b.c cec;
  public com.tencent.mm.ae.a ced;
  boolean cee;
  private Timer mTimer;
  Matrix nT;
  
  public e()
  {
    AppMethodBeat.i(116186);
    this.mTimer = new Timer();
    this.cdW = new Rect();
    this.cdU = false;
    this.cdw = false;
    this.cdX = 0.0F;
    this.cdY = 0.0F;
    this.cdZ = 0;
    this.cea = 0;
    this.ceb = false;
    this.cec = new com.tencent.mm.b.c(this);
    this.nT = new Matrix();
    this.cee = false;
    AppMethodBeat.o(116186);
  }
  
  private com.tencent.mm.y.c CP()
  {
    Object localObject1 = null;
    AppMethodBeat.i(116192);
    Object localObject2 = (d)CB();
    if (localObject2 == null)
    {
      AppMethodBeat.o(116192);
      return null;
    }
    ListIterator localListIterator = ((d)localObject2).Jk();
    while (localListIterator.hasPrevious())
    {
      localObject2 = (com.tencent.mm.y.c)localListIterator.previous();
      if (((com.tencent.mm.y.c)localObject2).egy) {
        localObject1 = localObject2;
      }
      ((com.tencent.mm.y.c)localObject2).setSelected(false);
    }
    AppMethodBeat.o(116192);
    return localObject1;
  }
  
  private void CQ()
  {
    AppMethodBeat.i(116193);
    ab.d("MicroMsg.EmojiAndTextArtist", "[registerFocusTask]");
    if (this.cdV != null) {
      this.cdV.cancel();
    }
    this.cdV = new a(this);
    this.mTimer.schedule(this.cdV, 1500L);
    AppMethodBeat.o(116193);
  }
  
  private void CR()
  {
    AppMethodBeat.i(116194);
    ab.d("MicroMsg.EmojiAndTextArtist", "[unRegisterFocusTask]");
    if (this.cdV != null) {
      this.cdV.cancel();
    }
    AppMethodBeat.o(116194);
  }
  
  private com.tencent.mm.y.c D(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(116191);
    if (CB() == null)
    {
      ab.e("MicroMsg.EmojiAndTextArtist", "[isContainsItem] getCache is null!");
      AppMethodBeat.o(116191);
      return null;
    }
    ListIterator localListIterator = ((d)CB()).Jk();
    com.tencent.mm.y.c localc;
    float[] arrayOfFloat;
    do
    {
      if (!localListIterator.hasPrevious()) {
        break;
      }
      localc = (com.tencent.mm.y.c)localListIterator.previous();
      arrayOfFloat = B(paramFloat1, paramFloat2);
    } while (!localc.E(arrayOfFloat[0], arrayOfFloat[1]));
    for (;;)
    {
      AppMethodBeat.o(116191);
      return localc;
      localc = null;
    }
  }
  
  public final void CA() {}
  
  public final a Cz()
  {
    return a.ccO;
  }
  
  public final void a(SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(116195);
    ab.i("MicroMsg.EmojiAndTextArtist", "[addItem] text:%s", new Object[] { paramSpannableString });
    if (bo.aa(paramSpannableString))
    {
      AppMethodBeat.o(116195);
      return;
    }
    d locald = (d)CB();
    if (locald == null)
    {
      ab.w("MicroMsg.EmojiAndTextArtist", "cache is null!");
      AppMethodBeat.o(116195);
      return;
    }
    CR();
    CP();
    bt(false);
    Object localObject = getBoardRect();
    paramSpannableString = new com.tencent.mm.y.e(ah.getContext(), getMainMatrix(), locald.ad(true), (Rect)localObject, paramSpannableString, paramInt1, paramInt2);
    paramSpannableString.setSelected(true);
    paramSpannableString.eFx = true;
    localObject = B(((Rect)localObject).centerX(), ((Rect)localObject).centerY());
    paramSpannableString.a(localObject[0], localObject[1], this.ccS.getInitScale() / this.ccS.getCurScale(), (int)getRotation());
    locald.a(paramSpannableString);
    CI();
    CQ();
    AppMethodBeat.o(116195);
  }
  
  public final void a(com.tencent.mm.y.e parame, SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(116197);
    d locald = (d)CB();
    if (locald == null)
    {
      ab.w("MicroMsg.EmojiAndTextArtist", "cache is null!");
      AppMethodBeat.o(116197);
      return;
    }
    Object localObject = parame.eFp;
    ab.i("MicroMsg.EmojiAndTextCache", "[delete] id:%s", new Object[] { localObject });
    com.tencent.mm.y.c localc;
    if ((locald.ecq != null) && (locald.ecq.size() > 0))
    {
      localc = (com.tencent.mm.y.c)locald.ecq.peek();
      if (!localc.eFp.equalsIgnoreCase((String)localObject)) {
        break label266;
      }
      locald.ecq.pop();
    }
    for (;;)
    {
      parame.setSelected(true);
      parame.eFx = true;
      CR();
      CP();
      bt(true);
      if (!bo.aa(paramSpannableString))
      {
        localObject = getBoardRect();
        paramSpannableString = new com.tencent.mm.y.e(ah.getContext(), getMainMatrix(), locald.ad(true), (Rect)localObject, paramSpannableString, paramInt1, paramInt2);
        paramSpannableString.setSelected(true);
        localObject = parame.eFs;
        paramSpannableString.a(((PointF)localObject).x, ((PointF)localObject).y, this.ccS.getInitScale() / this.ccS.getCurScale(), parame.mRotation);
        paramSpannableString.mScale = parame.mScale;
        locald.a(paramSpannableString);
      }
      CI();
      CQ();
      AppMethodBeat.o(116197);
      return;
      label266:
      ab.e("MicroMsg.EmojiAndTextCache", "[delete] id:%s emojiItem:%s", new Object[] { localObject, localc });
    }
  }
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(116196);
    ab.i("MicroMsg.EmojiAndTextArtist", "[addEmojiItem] item:%s", new Object[] { paramk });
    d locald = (d)CB();
    if (locald == null)
    {
      ab.w("MicroMsg.EmojiAndTextArtist", "cache is null!");
      AppMethodBeat.o(116196);
      return;
    }
    CR();
    CP();
    bt(false);
    Object localObject = getBoardRect();
    paramk = new com.tencent.mm.y.c(ah.getContext(), getMainMatrix(), locald.ad(true), paramk, (Rect)localObject);
    paramk.setSelected(true);
    localObject = B(((Rect)localObject).centerX(), ((Rect)localObject).centerY());
    paramk.a(localObject[0], localObject[1], this.ccS.getInitScale() / this.ccS.getCurScale(), (int)getRotation());
    locald.a(paramk);
    CI();
    CQ();
    AppMethodBeat.o(116196);
  }
  
  public final boolean o(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(116189);
    boolean bool;
    Object localObject1;
    switch (paramMotionEvent.getActionMasked())
    {
    case 3: 
    case 4: 
    default: 
      super.o(paramMotionEvent);
      bool = this.cdU;
      AppMethodBeat.o(116189);
      return bool;
    case 0: 
      CR();
      localObject1 = D(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (localObject1 == null)
      {
        this.cdU = false;
        if (CB() == null) {
          bool = false;
        }
      }
      break;
    }
    while (bool)
    {
      CP();
      bt(false);
      CI();
      break;
      localObject1 = ((d)CB()).Jj();
      if (localObject1 != null)
      {
        bool = ((com.tencent.mm.y.c)localObject1).egy;
        continue;
        bool = ((com.tencent.mm.y.c)localObject1).eFx;
        CP();
        this.cdU = true;
        ((com.tencent.mm.y.c)localObject1).setSelected(true);
        ((com.tencent.mm.y.c)localObject1).eFx = bool;
        ((com.tencent.mm.y.c)localObject1).eFu.set(((com.tencent.mm.y.c)localObject1).eFs);
        ((d)CB()).b((com.tencent.mm.y.c)localObject1);
        bt(true);
        CI();
        break;
        if (this.cdU)
        {
          this.cdX = p(paramMotionEvent);
          this.cdZ = ((int)Math.toDegrees(Math.atan2(q(paramMotionEvent)[0], q(paramMotionEvent)[1])));
          localObject1 = ((d)CB()).Jj();
          if ((localObject1 == null) || (!((com.tencent.mm.y.c)localObject1).egy)) {
            break;
          }
          this.cea = ((com.tencent.mm.y.c)localObject1).mRotation;
          this.cdY = ((com.tencent.mm.y.c)localObject1).mScale;
          break;
        }
        localObject1 = new int[2];
        if (paramMotionEvent.getPointerCount() > 1)
        {
          localObject1[0] = ((int)(paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2);
          localObject1[1] = ((int)(paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2);
        }
        localObject1 = D(localObject1[0], localObject1[1]);
        if (localObject1 == null) {
          break;
        }
        bool = ((com.tencent.mm.y.c)localObject1).eFx;
        CP();
        ((com.tencent.mm.y.c)localObject1).eFx = bool;
        this.cdU = true;
        ((com.tencent.mm.y.c)localObject1).setSelected(true);
        ((d)CB()).b((com.tencent.mm.y.c)localObject1);
        this.cdX = p(paramMotionEvent);
        this.cdZ = ((int)Math.toDegrees(Math.atan2(q(paramMotionEvent)[0], q(paramMotionEvent)[1])));
        if ((localObject1 != null) && (((com.tencent.mm.y.c)localObject1).egy))
        {
          this.cea = ((com.tencent.mm.y.c)localObject1).mRotation;
          this.cdY = ((com.tencent.mm.y.c)localObject1).mScale;
        }
        bt(true);
        CI();
        break;
        this.ceb = true;
        break;
        if (this.ceb)
        {
          this.ceb = false;
          AppMethodBeat.o(116189);
          return true;
        }
        if ((!this.cdU) || (!s(paramMotionEvent))) {
          break;
        }
        if ((!this.cdw) && (this.ced != null)) {
          this.ced.onShow();
        }
        localObject1 = new int[2];
        localObject1[0] = ((int)(paramMotionEvent.getX(0) - this.ccZ.x));
        localObject1[1] = ((int)(paramMotionEvent.getY(0) - this.ccZ.y));
        float f1 = 1.0F;
        int i = 0;
        if (paramMotionEvent.getPointerCount() > 1)
        {
          if (0.0F != this.cdX) {
            f1 = p(paramMotionEvent) / this.cdX;
          }
          i = this.cdZ - (int)Math.toDegrees(Math.atan2(q(paramMotionEvent)[0], q(paramMotionEvent)[1]));
        }
        for (;;)
        {
          float f2 = localObject1[0];
          float f3 = localObject1[1];
          float f4 = this.cdY;
          int j = this.cea;
          int k = paramMotionEvent.getPointerCount();
          localObject1 = ((d)CB()).Jj();
          Object localObject3;
          Object localObject2;
          if (localObject1 != null)
          {
            this.nT.reset();
            this.nT.postRotate(-getRotation());
            localObject3 = this.nT;
            localObject2 = new Matrix();
            ((Matrix)localObject3).invert((Matrix)localObject2);
            localObject3 = new float[2];
            localObject3[0] = f2;
            localObject3[1] = f3;
            ((Matrix)localObject2).mapPoints((float[])localObject3);
            if (k <= 1) {
              break label924;
            }
            ((com.tencent.mm.y.c)localObject1).b(0.0F, 0.0F, f1 * f4, (i + j) % 360);
            label811:
            ((com.tencent.mm.y.c)localObject1).Qf();
            localObject2 = ((com.tencent.mm.y.c)localObject1).eFs;
            localObject2 = C(((PointF)localObject2).x, ((PointF)localObject2).y);
            if (this.cdW.top > localObject2[1]) {
              break label956;
            }
            if (this.ced != null) {
              this.ced.af((localObject2[1] - this.cdW.top) / this.cdW.height());
            }
          }
          for (this.cee = true;; this.cee = false)
          {
            if ((localObject1 instanceof com.tencent.mm.y.e)) {
              ((com.tencent.mm.y.c)localObject1).eFx = false;
            }
            this.cdw = true;
            CI();
            break;
            label924:
            ((com.tencent.mm.y.c)localObject1).b(localObject3[0] / getScale(), localObject3[1] / getScale(), 0.0F, ((com.tencent.mm.y.c)localObject1).mRotation);
            break label811;
            label956:
            if ((this.ced != null) && (this.cee)) {
              this.ced.SW();
            }
          }
          if (!isAlive())
          {
            ab.e("MicroMsg.EmojiAndTextArtist", "[ACTION_UP] is not alive!");
            AppMethodBeat.o(116189);
            return false;
          }
          if (CB() == null)
          {
            ab.e("MicroMsg.EmojiAndTextArtist", "[getCache] is null!");
            AppMethodBeat.o(116189);
            return false;
          }
          localObject1 = ((d)CB()).Jj();
          if (localObject1 != null)
          {
            if (!this.ccU.contains((int)((com.tencent.mm.y.c)localObject1).eFs.x, (int)((com.tencent.mm.y.c)localObject1).eFs.y))
            {
              this.cec.bVC = true;
              localObject2 = this.cec;
              ((com.tencent.mm.b.c)localObject2).bVF = ((com.tencent.mm.y.c)localObject1);
              ((com.tencent.mm.b.c)localObject2).bVt = (((com.tencent.mm.y.c)localObject1).eFu.x - ((com.tencent.mm.y.c)localObject1).eFs.x);
              ((com.tencent.mm.b.c)localObject2).bVu = (((com.tencent.mm.y.c)localObject1).eFu.y - ((com.tencent.mm.y.c)localObject1).eFs.y);
              ((com.tencent.mm.b.c)localObject2).bVG = ((com.tencent.mm.y.c)localObject1).eFp;
              localObject2 = this.cec;
              if (((com.tencent.mm.b.b)localObject2).bVC)
              {
                ((com.tencent.mm.b.c)localObject2).kO = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("deltaY", new float[] { 0.0F, ((com.tencent.mm.b.c)localObject2).bVu }), PropertyValuesHolder.ofFloat("deltaX", new float[] { 0.0F, ((com.tencent.mm.b.c)localObject2).bVt }) });
                ((com.tencent.mm.b.c)localObject2).kO.addUpdateListener(new c.1((com.tencent.mm.b.c)localObject2));
                ((com.tencent.mm.b.c)localObject2).kO.addListener(new c.2((com.tencent.mm.b.c)localObject2));
                ((com.tencent.mm.b.c)localObject2).kO.setInterpolator(new LinearInterpolator());
                ((com.tencent.mm.b.c)localObject2).kO.setDuration(100L);
                ((com.tencent.mm.b.c)localObject2).kO.start();
              }
            }
            if ((localObject1 instanceof com.tencent.mm.y.e))
            {
              localObject2 = (com.tencent.mm.y.e)localObject1;
              if ((!((com.tencent.mm.y.c)localObject2).egy) || (!((com.tencent.mm.y.c)localObject2).eFx)) {
                break label1485;
              }
              if (this.ced != null) {
                this.ced.a((com.tencent.mm.y.e)localObject2);
              }
            }
          }
          for (;;)
          {
            localObject2 = ((com.tencent.mm.y.c)localObject1).eFs;
            localObject2 = C(((PointF)localObject2).x, ((PointF)localObject2).y);
            ab.i("MicroMsg.EmojiAndTextArtist", "mRubbishRect:%s pointF:%s", new Object[] { this.cdW, Float.valueOf(localObject2[1]) });
            if ((((com.tencent.mm.y.c)localObject1).egy) && (this.cdW.top <= localObject2[1]) && (this.cdU) && (this.ced != null))
            {
              ((d)CB()).Ji();
              CI();
            }
            CQ();
            if ((this.cdw) && (this.ced != null)) {
              this.ced.onHide();
            }
            this.cdw = false;
            break;
            label1485:
            if (((com.tencent.mm.y.c)localObject2).egy) {
              ((com.tencent.mm.y.c)localObject2).eFx = true;
            }
          }
          f1 = 1.0F;
        }
      }
      bool = false;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(116190);
    super.onDestroy();
    CR();
    AppMethodBeat.o(116190);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(116188);
    b(paramCanvas);
    Object localObject = (d)CB();
    if (localObject != null)
    {
      localObject = ((d)localObject).Jj();
      if ((localObject != null) && (((com.tencent.mm.y.c)localObject).egy)) {
        ((com.tencent.mm.y.c)localObject).draw(paramCanvas);
      }
    }
    AppMethodBeat.o(116188);
  }
  
  public final void zy()
  {
    AppMethodBeat.i(116187);
    super.zy();
    int i = (int)ah.getResources().getDimension(2131428644);
    int j = (int)ah.getResources().getDimension(2131428645);
    int k = am.fx(this.ccS.dqc().getContext());
    this.cdW.set((getBoardRect().width() - j) / 2, getBoardRect().height() - i - k, getBoardRect().width() - k, (j + getBoardRect().width()) / 2);
    AppMethodBeat.o(116187);
  }
  
  final class a
    extends TimerTask
  {
    private b cef;
    private Handler mHandler;
    
    public a(b paramb)
    {
      AppMethodBeat.i(116184);
      this.mHandler = new Handler(Looper.getMainLooper());
      this.cef = paramb;
      AppMethodBeat.o(116184);
    }
    
    public final void run()
    {
      AppMethodBeat.i(116185);
      this.mHandler.post(new e.a.1(this));
      AppMethodBeat.o(116185);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.e.e
 * JD-Core Version:    0.7.0.1
 */