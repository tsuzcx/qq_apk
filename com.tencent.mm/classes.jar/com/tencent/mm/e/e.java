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
import com.tencent.mm.aa.f;
import com.tencent.mm.api.p;
import com.tencent.mm.c.c.1;
import com.tencent.mm.c.c.2;
import com.tencent.mm.cache.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ap;
import java.util.ListIterator;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;

public final class e
  extends b<d>
{
  private boolean cSB;
  private volatile boolean cSC;
  private TimerTask cSD;
  private Rect cSE;
  private float cSF;
  private float cSG;
  private int cSH;
  private int cSI;
  private boolean cSJ;
  private com.tencent.mm.c.c cSK;
  public com.tencent.mm.ag.a cSL;
  boolean cSM;
  private boolean cSd;
  private Timer mTimer;
  Matrix uv;
  
  public e()
  {
    AppMethodBeat.i(9156);
    this.mTimer = new Timer();
    this.cSC = false;
    this.cSE = new Rect();
    this.cSB = false;
    this.cSd = false;
    this.cSF = 0.0F;
    this.cSG = 0.0F;
    this.cSH = 0;
    this.cSI = 0;
    this.cSJ = false;
    this.cSK = new com.tencent.mm.c.c(this);
    this.uv = new Matrix();
    this.cSM = false;
    AppMethodBeat.o(9156);
  }
  
  private com.tencent.mm.aa.c Mr()
  {
    Object localObject1 = null;
    AppMethodBeat.i(9162);
    Object localObject2 = (d)Md();
    if (localObject2 == null)
    {
      AppMethodBeat.o(9162);
      return null;
    }
    ListIterator localListIterator = ((d)localObject2).UA();
    while (localListIterator.hasPrevious())
    {
      localObject2 = (com.tencent.mm.aa.c)localListIterator.previous();
      if (((com.tencent.mm.aa.c)localObject2).fsk) {
        localObject1 = localObject2;
      }
      ((com.tencent.mm.aa.c)localObject2).setSelected(false);
    }
    AppMethodBeat.o(9162);
    return localObject1;
  }
  
  private void Ms()
  {
    AppMethodBeat.i(9163);
    ad.d("MicroMsg.EmojiAndTextArtist", "[registerFocusTask]");
    if (this.cSD != null) {
      this.cSD.cancel();
    }
    if (this.cSC)
    {
      ad.w("MicroMsg.EmojiAndTextArtist", "[registerFocusTask] isTimerCancel=true");
      AppMethodBeat.o(9163);
      return;
    }
    this.cSD = new a(this);
    this.mTimer.schedule(this.cSD, 1500L);
    AppMethodBeat.o(9163);
  }
  
  private void Mt()
  {
    AppMethodBeat.i(9164);
    ad.d("MicroMsg.EmojiAndTextArtist", "[unRegisterFocusTask]");
    if (this.cSD != null) {
      this.cSD.cancel();
    }
    AppMethodBeat.o(9164);
  }
  
  private com.tencent.mm.aa.c u(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(9161);
    if (Md() == null)
    {
      ad.e("MicroMsg.EmojiAndTextArtist", "[isContainsItem] getCache is null!");
      AppMethodBeat.o(9161);
      return null;
    }
    ListIterator localListIterator = ((d)Md()).UA();
    com.tencent.mm.aa.c localc;
    float[] arrayOfFloat;
    do
    {
      if (!localListIterator.hasPrevious()) {
        break;
      }
      localc = (com.tencent.mm.aa.c)localListIterator.previous();
      arrayOfFloat = s(paramFloat1, paramFloat2);
    } while (!localc.v(arrayOfFloat[0], arrayOfFloat[1]));
    for (;;)
    {
      AppMethodBeat.o(9161);
      return localc;
      localc = null;
    }
  }
  
  public final a Mb()
  {
    return a.cRu;
  }
  
  public final void Mc() {}
  
  public final void a(SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9165);
    ad.i("MicroMsg.EmojiAndTextArtist", "[addItem] text:%s", new Object[] { paramSpannableString });
    if (bt.ai(paramSpannableString))
    {
      AppMethodBeat.o(9165);
      return;
    }
    d locald = (d)Md();
    if (locald == null)
    {
      ad.w("MicroMsg.EmojiAndTextArtist", "cache is null!");
      AppMethodBeat.o(9165);
      return;
    }
    Mt();
    Mr();
    ci(false);
    Object localObject = getBoardRect();
    paramSpannableString = new f(aj.getContext(), getMainMatrix(), locald.aj(true), (Rect)localObject, paramSpannableString, paramInt1, paramInt2);
    paramSpannableString.setSelected(true);
    paramSpannableString.gaD = true;
    localObject = s(((Rect)localObject).centerX(), ((Rect)localObject).centerY());
    paramSpannableString.a(localObject[0], localObject[1], this.cRz.getInitScale() / this.cRz.getCurScale(), (int)getRotation());
    locald.a(paramSpannableString);
    Mk();
    Ms();
    AppMethodBeat.o(9165);
  }
  
  public final void a(f paramf, SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9167);
    d locald = (d)Md();
    if (locald == null)
    {
      ad.w("MicroMsg.EmojiAndTextArtist", "cache is null!");
      AppMethodBeat.o(9167);
      return;
    }
    Object localObject = paramf.gav;
    ad.i("MicroMsg.EmojiAndTextCache", "[delete] id:%s", new Object[] { localObject });
    com.tencent.mm.aa.c localc;
    if ((locald.fmC != null) && (locald.fmC.size() > 0))
    {
      localc = (com.tencent.mm.aa.c)locald.fmC.peek();
      if (!localc.gav.equalsIgnoreCase((String)localObject)) {
        break label266;
      }
      locald.fmC.pop();
    }
    for (;;)
    {
      paramf.setSelected(true);
      paramf.gaD = true;
      Mt();
      Mr();
      ci(true);
      if (!bt.ai(paramSpannableString))
      {
        localObject = getBoardRect();
        paramSpannableString = new f(aj.getContext(), getMainMatrix(), locald.aj(true), (Rect)localObject, paramSpannableString, paramInt1, paramInt2);
        paramSpannableString.setSelected(true);
        localObject = paramf.gay;
        paramSpannableString.a(((PointF)localObject).x, ((PointF)localObject).y, this.cRz.getInitScale() / this.cRz.getCurScale(), paramf.mRotation);
        paramSpannableString.cHQ = paramf.cHQ;
        locald.a(paramSpannableString);
      }
      Mk();
      Ms();
      AppMethodBeat.o(9167);
      return;
      label266:
      ad.e("MicroMsg.EmojiAndTextCache", "[delete] id:%s emojiItem:%s", new Object[] { localObject, localc });
    }
  }
  
  public final void b(p paramp)
  {
    AppMethodBeat.i(9166);
    ad.i("MicroMsg.EmojiAndTextArtist", "[addEmojiItem] item:%s", new Object[] { paramp });
    d locald = (d)Md();
    if (locald == null)
    {
      ad.w("MicroMsg.EmojiAndTextArtist", "cache is null!");
      AppMethodBeat.o(9166);
      return;
    }
    Mt();
    Mr();
    ci(false);
    Object localObject = getBoardRect();
    paramp = new com.tencent.mm.aa.c(aj.getContext(), getMainMatrix(), locald.aj(true), paramp, (Rect)localObject);
    paramp.setSelected(true);
    localObject = s(((Rect)localObject).centerX(), ((Rect)localObject).centerY());
    paramp.a(localObject[0], localObject[1], this.cRz.getInitScale() / this.cRz.getCurScale(), (int)getRotation());
    locald.a(paramp);
    Mk();
    Ms();
    AppMethodBeat.o(9166);
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(9157);
    super.onAlive();
    int i = (int)aj.getResources().getDimension(2131166754);
    int j = (int)aj.getResources().getDimension(2131166755);
    int k = ap.eb(this.cRz.eBt().getContext());
    this.cSE.set((getBoardRect().width() - j) / 2, getBoardRect().height() - i - k, getBoardRect().width() - k, (j + getBoardRect().width()) / 2);
    if (this.cSC) {
      this.mTimer = new Timer();
    }
    AppMethodBeat.o(9157);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9160);
    super.onDestroy();
    this.cSC = true;
    Mt();
    this.mTimer.cancel();
    AppMethodBeat.o(9160);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9158);
    d(paramCanvas);
    Object localObject = (d)Md();
    if (localObject != null)
    {
      localObject = ((d)localObject).Uz();
      if ((localObject != null) && (((com.tencent.mm.aa.c)localObject).fsk)) {
        ((com.tencent.mm.aa.c)localObject).draw(paramCanvas);
      }
    }
    AppMethodBeat.o(9158);
  }
  
  public final boolean p(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9159);
    boolean bool;
    Object localObject1;
    switch (paramMotionEvent.getActionMasked())
    {
    case 3: 
    case 4: 
    default: 
      super.p(paramMotionEvent);
      bool = this.cSB;
      AppMethodBeat.o(9159);
      return bool;
    case 0: 
      Mt();
      localObject1 = u(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (localObject1 == null)
      {
        this.cSB = false;
        if (Md() == null) {
          bool = false;
        }
      }
      break;
    }
    while (bool)
    {
      Mr();
      ci(false);
      Mk();
      break;
      localObject1 = ((d)Md()).Uz();
      if (localObject1 != null)
      {
        bool = ((com.tencent.mm.aa.c)localObject1).fsk;
        continue;
        bool = ((com.tencent.mm.aa.c)localObject1).gaD;
        Mr();
        this.cSB = true;
        ((com.tencent.mm.aa.c)localObject1).setSelected(true);
        ((com.tencent.mm.aa.c)localObject1).gaD = bool;
        ((com.tencent.mm.aa.c)localObject1).gaA.set(((com.tencent.mm.aa.c)localObject1).gay);
        ((d)Md()).b((com.tencent.mm.aa.c)localObject1);
        ci(true);
        Mk();
        break;
        if (this.cSB)
        {
          this.cSF = q(paramMotionEvent);
          this.cSH = ((int)Math.toDegrees(Math.atan2(r(paramMotionEvent)[0], r(paramMotionEvent)[1])));
          localObject1 = ((d)Md()).Uz();
          if ((localObject1 == null) || (!((com.tencent.mm.aa.c)localObject1).fsk)) {
            break;
          }
          this.cSI = ((com.tencent.mm.aa.c)localObject1).mRotation;
          this.cSG = ((com.tencent.mm.aa.c)localObject1).cHQ;
          break;
        }
        localObject1 = new int[2];
        if (paramMotionEvent.getPointerCount() > 1)
        {
          localObject1[0] = ((int)(paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2);
          localObject1[1] = ((int)(paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2);
        }
        localObject1 = u(localObject1[0], localObject1[1]);
        if (localObject1 == null) {
          break;
        }
        bool = ((com.tencent.mm.aa.c)localObject1).gaD;
        Mr();
        ((com.tencent.mm.aa.c)localObject1).gaD = bool;
        this.cSB = true;
        ((com.tencent.mm.aa.c)localObject1).setSelected(true);
        ((d)Md()).b((com.tencent.mm.aa.c)localObject1);
        this.cSF = q(paramMotionEvent);
        this.cSH = ((int)Math.toDegrees(Math.atan2(r(paramMotionEvent)[0], r(paramMotionEvent)[1])));
        if ((localObject1 != null) && (((com.tencent.mm.aa.c)localObject1).fsk))
        {
          this.cSI = ((com.tencent.mm.aa.c)localObject1).mRotation;
          this.cSG = ((com.tencent.mm.aa.c)localObject1).cHQ;
        }
        ci(true);
        Mk();
        break;
        this.cSJ = true;
        break;
        if (this.cSJ)
        {
          this.cSJ = false;
          AppMethodBeat.o(9159);
          return true;
        }
        if ((!this.cSB) || (!t(paramMotionEvent))) {
          break;
        }
        if ((!this.cSd) && (this.cSL != null)) {
          this.cSL.onShow();
        }
        localObject1 = new int[2];
        localObject1[0] = ((int)(paramMotionEvent.getX(0) - this.cRG.x));
        localObject1[1] = ((int)(paramMotionEvent.getY(0) - this.cRG.y));
        float f1 = 1.0F;
        int i = 0;
        if (paramMotionEvent.getPointerCount() > 1)
        {
          if (0.0F != this.cSF) {
            f1 = q(paramMotionEvent) / this.cSF;
          }
          i = this.cSH - (int)Math.toDegrees(Math.atan2(r(paramMotionEvent)[0], r(paramMotionEvent)[1]));
        }
        for (;;)
        {
          float f2 = localObject1[0];
          float f3 = localObject1[1];
          float f4 = this.cSG;
          int j = this.cSI;
          int k = paramMotionEvent.getPointerCount();
          localObject1 = ((d)Md()).Uz();
          Object localObject3;
          Object localObject2;
          if (localObject1 != null)
          {
            this.uv.reset();
            this.uv.postRotate(-getRotation());
            localObject3 = this.uv;
            localObject2 = new Matrix();
            ((Matrix)localObject3).invert((Matrix)localObject2);
            localObject3 = new float[2];
            localObject3[0] = f2;
            localObject3[1] = f3;
            ((Matrix)localObject2).mapPoints((float[])localObject3);
            if (k <= 1) {
              break label924;
            }
            ((com.tencent.mm.aa.c)localObject1).b(0.0F, 0.0F, f1 * f4, (i + j) % 360);
            label811:
            ((com.tencent.mm.aa.c)localObject1).adR();
            localObject2 = ((com.tencent.mm.aa.c)localObject1).gay;
            localObject2 = t(((PointF)localObject2).x, ((PointF)localObject2).y);
            if (this.cSE.top > localObject2[1]) {
              break label956;
            }
            if (this.cSL != null) {
              this.cSL.ad((localObject2[1] - this.cSE.top) / this.cSE.height());
            }
          }
          for (this.cSM = true;; this.cSM = false)
          {
            if ((localObject1 instanceof f)) {
              ((com.tencent.mm.aa.c)localObject1).gaD = false;
            }
            this.cSd = true;
            Mk();
            break;
            label924:
            ((com.tencent.mm.aa.c)localObject1).b(localObject3[0] / getScale(), localObject3[1] / getScale(), 0.0F, ((com.tencent.mm.aa.c)localObject1).mRotation);
            break label811;
            label956:
            if ((this.cSL != null) && (this.cSM)) {
              this.cSL.agQ();
            }
          }
          if (!isAlive())
          {
            ad.e("MicroMsg.EmojiAndTextArtist", "[ACTION_UP] is not alive!");
            AppMethodBeat.o(9159);
            return false;
          }
          if (Md() == null)
          {
            ad.e("MicroMsg.EmojiAndTextArtist", "[getCache] is null!");
            AppMethodBeat.o(9159);
            return false;
          }
          localObject1 = ((d)Md()).Uz();
          if (localObject1 != null)
          {
            if (!this.cRB.contains((int)((com.tencent.mm.aa.c)localObject1).gay.x, (int)((com.tencent.mm.aa.c)localObject1).gay.y))
            {
              this.cSK.cHI = true;
              localObject2 = this.cSK;
              ((com.tencent.mm.c.c)localObject2).cHK = ((com.tencent.mm.aa.c)localObject1);
              ((com.tencent.mm.c.c)localObject2).cHz = (((com.tencent.mm.aa.c)localObject1).gaA.x - ((com.tencent.mm.aa.c)localObject1).gay.x);
              ((com.tencent.mm.c.c)localObject2).cHA = (((com.tencent.mm.aa.c)localObject1).gaA.y - ((com.tencent.mm.aa.c)localObject1).gay.y);
              ((com.tencent.mm.c.c)localObject2).cHL = ((com.tencent.mm.aa.c)localObject1).gav;
              localObject2 = this.cSK;
              if (((com.tencent.mm.c.b)localObject2).cHI)
              {
                ((com.tencent.mm.c.c)localObject2).cHw = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("deltaY", new float[] { 0.0F, ((com.tencent.mm.c.c)localObject2).cHA }), PropertyValuesHolder.ofFloat("deltaX", new float[] { 0.0F, ((com.tencent.mm.c.c)localObject2).cHz }) });
                ((com.tencent.mm.c.c)localObject2).cHw.addUpdateListener(new c.1((com.tencent.mm.c.c)localObject2));
                ((com.tencent.mm.c.c)localObject2).cHw.addListener(new c.2((com.tencent.mm.c.c)localObject2));
                ((com.tencent.mm.c.c)localObject2).cHw.setInterpolator(new LinearInterpolator());
                ((com.tencent.mm.c.c)localObject2).cHw.setDuration(100L);
                ((com.tencent.mm.c.c)localObject2).cHw.start();
              }
            }
            if ((localObject1 instanceof f))
            {
              localObject2 = (f)localObject1;
              if ((!((com.tencent.mm.aa.c)localObject2).fsk) || (!((com.tencent.mm.aa.c)localObject2).gaD)) {
                break label1485;
              }
              if (this.cSL != null) {
                this.cSL.a((f)localObject2);
              }
            }
          }
          for (;;)
          {
            localObject2 = ((com.tencent.mm.aa.c)localObject1).gay;
            localObject2 = t(((PointF)localObject2).x, ((PointF)localObject2).y);
            ad.i("MicroMsg.EmojiAndTextArtist", "mRubbishRect:%s pointF:%s", new Object[] { this.cSE, Float.valueOf(localObject2[1]) });
            if ((((com.tencent.mm.aa.c)localObject1).fsk) && (this.cSE.top <= localObject2[1]) && (this.cSB) && (this.cSL != null))
            {
              ((d)Md()).Uy();
              Mk();
            }
            Ms();
            if ((this.cSd) && (this.cSL != null)) {
              this.cSL.onHide();
            }
            this.cSd = false;
            break;
            label1485:
            if (((com.tencent.mm.aa.c)localObject2).fsk) {
              ((com.tencent.mm.aa.c)localObject2).gaD = true;
            }
          }
          f1 = 1.0F;
        }
      }
      bool = false;
    }
  }
  
  final class a
    extends TimerTask
  {
    private b cSN;
    private Handler mHandler;
    
    public a(b paramb)
    {
      AppMethodBeat.i(9154);
      this.mHandler = new Handler(Looper.getMainLooper());
      this.cSN = paramb;
      AppMethodBeat.o(9154);
    }
    
    public final void run()
    {
      AppMethodBeat.i(9155);
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(9153);
          ad.d("MicroMsg.EmojiAndTextArtist", "cancel focus!");
          if (e.this.Md() == null)
          {
            AppMethodBeat.o(9153);
            return;
          }
          com.tencent.mm.aa.c localc = ((d)e.this.Md()).Uz();
          if ((localc != null) && (localc.fsk))
          {
            localc.setSelected(false);
            e.a.a(e.a.this).ci(false);
            e.a.a(e.a.this).Mk();
          }
          AppMethodBeat.o(9153);
        }
      });
      AppMethodBeat.o(9155);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.e.e
 * JD-Core Version:    0.7.0.1
 */