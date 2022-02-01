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
import com.tencent.mm.api.p;
import com.tencent.mm.c.c.1;
import com.tencent.mm.c.c.2;
import com.tencent.mm.cache.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.ar;
import com.tencent.mm.z.f;
import java.util.ListIterator;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;

public final class e
  extends b<d>
{
  public com.tencent.mm.af.a dcA;
  boolean dcB;
  private boolean dcp;
  private boolean dcq;
  private volatile boolean dcr;
  private TimerTask dcs;
  private Rect dct;
  private float dcu;
  private float dcv;
  private int dcw;
  private int dcx;
  private boolean dcy;
  private com.tencent.mm.c.c dcz;
  private Timer mTimer;
  Matrix xm;
  
  public e()
  {
    AppMethodBeat.i(9156);
    this.mTimer = new Timer();
    this.dcr = false;
    this.dct = new Rect();
    this.dcp = false;
    this.dcq = false;
    this.dcu = 0.0F;
    this.dcv = 0.0F;
    this.dcw = 0;
    this.dcx = 0;
    this.dcy = false;
    this.dcz = new com.tencent.mm.c.c(this);
    this.xm = new Matrix();
    this.dcB = false;
    AppMethodBeat.o(9156);
  }
  
  private com.tencent.mm.z.c NW()
  {
    Object localObject1 = null;
    AppMethodBeat.i(9162);
    Object localObject2 = (d)NI();
    if (localObject2 == null)
    {
      AppMethodBeat.o(9162);
      return null;
    }
    ListIterator localListIterator = ((d)localObject2).XW();
    while (localListIterator.hasPrevious())
    {
      localObject2 = (com.tencent.mm.z.c)localListIterator.previous();
      if (((com.tencent.mm.z.c)localObject2).fRe) {
        localObject1 = localObject2;
      }
      ((com.tencent.mm.z.c)localObject2).setSelected(false);
    }
    AppMethodBeat.o(9162);
    return localObject1;
  }
  
  private void NX()
  {
    AppMethodBeat.i(9163);
    ae.d("MicroMsg.EmojiAndTextArtist", "[registerFocusTask]");
    if (this.dcs != null) {
      this.dcs.cancel();
    }
    if (this.dcr)
    {
      ae.w("MicroMsg.EmojiAndTextArtist", "[registerFocusTask] isTimerCancel=true");
      AppMethodBeat.o(9163);
      return;
    }
    this.dcs = new a(this);
    this.mTimer.schedule(this.dcs, 1500L);
    AppMethodBeat.o(9163);
  }
  
  private void NY()
  {
    AppMethodBeat.i(9164);
    ae.d("MicroMsg.EmojiAndTextArtist", "[unRegisterFocusTask]");
    if (this.dcs != null) {
      this.dcs.cancel();
    }
    AppMethodBeat.o(9164);
  }
  
  private com.tencent.mm.z.c w(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(9161);
    if (NI() == null)
    {
      ae.e("MicroMsg.EmojiAndTextArtist", "[isContainsItem] getCache is null!");
      AppMethodBeat.o(9161);
      return null;
    }
    ListIterator localListIterator = ((d)NI()).XW();
    com.tencent.mm.z.c localc;
    float[] arrayOfFloat;
    do
    {
      if (!localListIterator.hasPrevious()) {
        break;
      }
      localc = (com.tencent.mm.z.c)localListIterator.previous();
      arrayOfFloat = u(paramFloat1, paramFloat2);
    } while (!localc.x(arrayOfFloat[0], arrayOfFloat[1]));
    for (;;)
    {
      AppMethodBeat.o(9161);
      return localc;
      localc = null;
    }
  }
  
  public final a NG()
  {
    return a.dbh;
  }
  
  public final void NH() {}
  
  public final void a(SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9165);
    ae.i("MicroMsg.EmojiAndTextArtist", "[addItem] text:%s", new Object[] { paramSpannableString });
    if (bu.ah(paramSpannableString))
    {
      AppMethodBeat.o(9165);
      return;
    }
    d locald = (d)NI();
    if (locald == null)
    {
      ae.w("MicroMsg.EmojiAndTextArtist", "cache is null!");
      AppMethodBeat.o(9165);
      return;
    }
    NY();
    NW();
    cl(false);
    Object localObject = getBoardRect();
    paramSpannableString = new f(ak.getContext(), getMainMatrix(), locald.aj(true), (Rect)localObject, paramSpannableString, paramInt1, paramInt2);
    paramSpannableString.setSelected(true);
    paramSpannableString.gBA = true;
    localObject = u(((Rect)localObject).centerX(), ((Rect)localObject).centerY());
    paramSpannableString.a(localObject[0], localObject[1], this.dbm.getInitScale() / this.dbm.getCurScale(), (int)getRotation());
    locald.a(paramSpannableString);
    NP();
    NX();
    AppMethodBeat.o(9165);
  }
  
  public final void a(f paramf, SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9167);
    d locald = (d)NI();
    if (locald == null)
    {
      ae.w("MicroMsg.EmojiAndTextArtist", "cache is null!");
      AppMethodBeat.o(9167);
      return;
    }
    Object localObject = paramf.gBs;
    ae.i("MicroMsg.EmojiAndTextCache", "[delete] id:%s", new Object[] { localObject });
    com.tencent.mm.z.c localc;
    if ((locald.fKi != null) && (locald.fKi.size() > 0))
    {
      localc = (com.tencent.mm.z.c)locald.fKi.peek();
      if (!localc.gBs.equalsIgnoreCase((String)localObject)) {
        break label266;
      }
      locald.fKi.pop();
    }
    for (;;)
    {
      paramf.setSelected(true);
      paramf.gBA = true;
      NY();
      NW();
      cl(true);
      if (!bu.ah(paramSpannableString))
      {
        localObject = getBoardRect();
        paramSpannableString = new f(ak.getContext(), getMainMatrix(), locald.aj(true), (Rect)localObject, paramSpannableString, paramInt1, paramInt2);
        paramSpannableString.setSelected(true);
        localObject = paramf.gBv;
        paramSpannableString.a(((PointF)localObject).x, ((PointF)localObject).y, this.dbm.getInitScale() / this.dbm.getCurScale(), paramf.mRotation);
        paramSpannableString.cQN = paramf.cQN;
        locald.a(paramSpannableString);
      }
      NP();
      NX();
      AppMethodBeat.o(9167);
      return;
      label266:
      ae.e("MicroMsg.EmojiAndTextCache", "[delete] id:%s emojiItem:%s", new Object[] { localObject, localc });
    }
  }
  
  public final void b(p paramp)
  {
    AppMethodBeat.i(9166);
    ae.i("MicroMsg.EmojiAndTextArtist", "[addEmojiItem] item:%s", new Object[] { paramp });
    d locald = (d)NI();
    if (locald == null)
    {
      ae.w("MicroMsg.EmojiAndTextArtist", "cache is null!");
      AppMethodBeat.o(9166);
      return;
    }
    NY();
    NW();
    cl(false);
    Object localObject = getBoardRect();
    paramp = new com.tencent.mm.z.c(ak.getContext(), getMainMatrix(), locald.aj(true), paramp, (Rect)localObject);
    paramp.setSelected(true);
    localObject = u(((Rect)localObject).centerX(), ((Rect)localObject).centerY());
    paramp.a(localObject[0], localObject[1], this.dbm.getInitScale() / this.dbm.getCurScale(), (int)getRotation());
    locald.a(paramp);
    NP();
    NX();
    AppMethodBeat.o(9166);
  }
  
  public final boolean n(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9159);
    boolean bool;
    Object localObject1;
    switch (paramMotionEvent.getActionMasked())
    {
    case 3: 
    case 4: 
    default: 
      super.n(paramMotionEvent);
      bool = this.dcp;
      AppMethodBeat.o(9159);
      return bool;
    case 0: 
      NY();
      localObject1 = w(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (localObject1 == null)
      {
        this.dcp = false;
        if (NI() == null) {
          bool = false;
        }
      }
      break;
    }
    while (bool)
    {
      NW();
      cl(false);
      NP();
      break;
      localObject1 = ((d)NI()).XV();
      if (localObject1 != null)
      {
        bool = ((com.tencent.mm.z.c)localObject1).fRe;
        continue;
        bool = ((com.tencent.mm.z.c)localObject1).gBA;
        NW();
        this.dcp = true;
        ((com.tencent.mm.z.c)localObject1).setSelected(true);
        ((com.tencent.mm.z.c)localObject1).gBA = bool;
        ((com.tencent.mm.z.c)localObject1).gBx.set(((com.tencent.mm.z.c)localObject1).gBv);
        ((d)NI()).b((com.tencent.mm.z.c)localObject1);
        cl(true);
        NP();
        break;
        if (this.dcp)
        {
          this.dcu = o(paramMotionEvent);
          this.dcw = ((int)Math.toDegrees(Math.atan2(p(paramMotionEvent)[0], p(paramMotionEvent)[1])));
          localObject1 = ((d)NI()).XV();
          if ((localObject1 == null) || (!((com.tencent.mm.z.c)localObject1).fRe)) {
            break;
          }
          this.dcx = ((com.tencent.mm.z.c)localObject1).mRotation;
          this.dcv = ((com.tencent.mm.z.c)localObject1).cQN;
          break;
        }
        localObject1 = new int[2];
        if (paramMotionEvent.getPointerCount() > 1)
        {
          localObject1[0] = ((int)(paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2);
          localObject1[1] = ((int)(paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2);
        }
        localObject1 = w(localObject1[0], localObject1[1]);
        if (localObject1 == null) {
          break;
        }
        bool = ((com.tencent.mm.z.c)localObject1).gBA;
        NW();
        ((com.tencent.mm.z.c)localObject1).gBA = bool;
        this.dcp = true;
        ((com.tencent.mm.z.c)localObject1).setSelected(true);
        ((d)NI()).b((com.tencent.mm.z.c)localObject1);
        this.dcu = o(paramMotionEvent);
        this.dcw = ((int)Math.toDegrees(Math.atan2(p(paramMotionEvent)[0], p(paramMotionEvent)[1])));
        if ((localObject1 != null) && (((com.tencent.mm.z.c)localObject1).fRe))
        {
          this.dcx = ((com.tencent.mm.z.c)localObject1).mRotation;
          this.dcv = ((com.tencent.mm.z.c)localObject1).cQN;
        }
        cl(true);
        NP();
        break;
        this.dcy = true;
        break;
        if (this.dcy)
        {
          this.dcy = false;
          AppMethodBeat.o(9159);
          return true;
        }
        if ((!this.dcp) || (!r(paramMotionEvent))) {
          break;
        }
        if ((!this.dcq) && (this.dcA != null)) {
          this.dcA.onShow();
        }
        localObject1 = new int[2];
        localObject1[0] = ((int)(paramMotionEvent.getX(0) - this.dbt.x));
        localObject1[1] = ((int)(paramMotionEvent.getY(0) - this.dbt.y));
        float f1 = 1.0F;
        int i = 0;
        if (paramMotionEvent.getPointerCount() > 1)
        {
          if (0.0F != this.dcu) {
            f1 = o(paramMotionEvent) / this.dcu;
          }
          i = this.dcw - (int)Math.toDegrees(Math.atan2(p(paramMotionEvent)[0], p(paramMotionEvent)[1]));
        }
        for (;;)
        {
          float f2 = localObject1[0];
          float f3 = localObject1[1];
          float f4 = this.dcv;
          int j = this.dcx;
          int k = paramMotionEvent.getPointerCount();
          localObject1 = ((d)NI()).XV();
          Object localObject3;
          Object localObject2;
          if (localObject1 != null)
          {
            this.xm.reset();
            this.xm.postRotate(-getRotation());
            localObject3 = this.xm;
            localObject2 = new Matrix();
            ((Matrix)localObject3).invert((Matrix)localObject2);
            localObject3 = new float[2];
            localObject3[0] = f2;
            localObject3[1] = f3;
            ((Matrix)localObject2).mapPoints((float[])localObject3);
            if (k <= 1) {
              break label924;
            }
            ((com.tencent.mm.z.c)localObject1).b(0.0F, 0.0F, f1 * f4, (i + j) % 360);
            label811:
            ((com.tencent.mm.z.c)localObject1).aii();
            localObject2 = ((com.tencent.mm.z.c)localObject1).gBv;
            localObject2 = v(((PointF)localObject2).x, ((PointF)localObject2).y);
            if (this.dct.top > localObject2[1]) {
              break label956;
            }
            if (this.dcA != null) {
              this.dcA.ak((localObject2[1] - this.dct.top) / this.dct.height());
            }
          }
          for (this.dcB = true;; this.dcB = false)
          {
            if ((localObject1 instanceof f)) {
              ((com.tencent.mm.z.c)localObject1).gBA = false;
            }
            this.dcq = true;
            NP();
            break;
            label924:
            ((com.tencent.mm.z.c)localObject1).b(localObject3[0] / getScale(), localObject3[1] / getScale(), 0.0F, ((com.tencent.mm.z.c)localObject1).mRotation);
            break label811;
            label956:
            if ((this.dcA != null) && (this.dcB)) {
              this.dcA.ali();
            }
          }
          if (!isAlive())
          {
            ae.e("MicroMsg.EmojiAndTextArtist", "[ACTION_UP] is not alive!");
            AppMethodBeat.o(9159);
            return false;
          }
          if (NI() == null)
          {
            ae.e("MicroMsg.EmojiAndTextArtist", "[getCache] is null!");
            AppMethodBeat.o(9159);
            return false;
          }
          localObject1 = ((d)NI()).XV();
          if (localObject1 != null)
          {
            if (!this.dbo.contains((int)((com.tencent.mm.z.c)localObject1).gBv.x, (int)((com.tencent.mm.z.c)localObject1).gBv.y))
            {
              this.dcz.cQF = true;
              localObject2 = this.dcz;
              ((com.tencent.mm.c.c)localObject2).cQH = ((com.tencent.mm.z.c)localObject1);
              ((com.tencent.mm.c.c)localObject2).cQw = (((com.tencent.mm.z.c)localObject1).gBx.x - ((com.tencent.mm.z.c)localObject1).gBv.x);
              ((com.tencent.mm.c.c)localObject2).cQx = (((com.tencent.mm.z.c)localObject1).gBx.y - ((com.tencent.mm.z.c)localObject1).gBv.y);
              ((com.tencent.mm.c.c)localObject2).cQI = ((com.tencent.mm.z.c)localObject1).gBs;
              localObject2 = this.dcz;
              if (((com.tencent.mm.c.b)localObject2).cQF)
              {
                ((com.tencent.mm.c.c)localObject2).cQt = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("deltaY", new float[] { 0.0F, ((com.tencent.mm.c.c)localObject2).cQx }), PropertyValuesHolder.ofFloat("deltaX", new float[] { 0.0F, ((com.tencent.mm.c.c)localObject2).cQw }) });
                ((com.tencent.mm.c.c)localObject2).cQt.addUpdateListener(new c.1((com.tencent.mm.c.c)localObject2));
                ((com.tencent.mm.c.c)localObject2).cQt.addListener(new c.2((com.tencent.mm.c.c)localObject2));
                ((com.tencent.mm.c.c)localObject2).cQt.setInterpolator(new LinearInterpolator());
                ((com.tencent.mm.c.c)localObject2).cQt.setDuration(100L);
                ((com.tencent.mm.c.c)localObject2).cQt.start();
              }
            }
            if ((localObject1 instanceof f))
            {
              localObject2 = (f)localObject1;
              if ((!((com.tencent.mm.z.c)localObject2).fRe) || (!((com.tencent.mm.z.c)localObject2).gBA)) {
                break label1485;
              }
              if (this.dcA != null) {
                this.dcA.a((f)localObject2);
              }
            }
          }
          for (;;)
          {
            localObject2 = ((com.tencent.mm.z.c)localObject1).gBv;
            localObject2 = v(((PointF)localObject2).x, ((PointF)localObject2).y);
            ae.i("MicroMsg.EmojiAndTextArtist", "mRubbishRect:%s pointF:%s", new Object[] { this.dct, Float.valueOf(localObject2[1]) });
            if ((((com.tencent.mm.z.c)localObject1).fRe) && (this.dct.top <= localObject2[1]) && (this.dcp) && (this.dcA != null))
            {
              ((d)NI()).XU();
              NP();
            }
            NX();
            if ((this.dcq) && (this.dcA != null)) {
              this.dcA.onHide();
            }
            this.dcq = false;
            break;
            label1485:
            if (((com.tencent.mm.z.c)localObject2).fRe) {
              ((com.tencent.mm.z.c)localObject2).gBA = true;
            }
          }
          f1 = 1.0F;
        }
      }
      bool = false;
    }
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(9157);
    super.onAlive();
    int i = (int)ak.getResources().getDimension(2131166754);
    int j = (int)ak.getResources().getDimension(2131166755);
    int k = ar.en(this.dbm.fjH().getContext());
    this.dct.set((getBoardRect().width() - j) / 2, getBoardRect().height() - i - k, getBoardRect().width() - k, (j + getBoardRect().width()) / 2);
    if (this.dcr) {
      this.mTimer = new Timer();
    }
    AppMethodBeat.o(9157);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9160);
    super.onDestroy();
    this.dcr = true;
    NY();
    this.mTimer.cancel();
    AppMethodBeat.o(9160);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9158);
    d(paramCanvas);
    Object localObject = (d)NI();
    if (localObject != null)
    {
      localObject = ((d)localObject).XV();
      if ((localObject != null) && (((com.tencent.mm.z.c)localObject).fRe)) {
        ((com.tencent.mm.z.c)localObject).draw(paramCanvas);
      }
    }
    AppMethodBeat.o(9158);
  }
  
  final class a
    extends TimerTask
  {
    private b dcC;
    private Handler mHandler;
    
    public a(b paramb)
    {
      AppMethodBeat.i(9154);
      this.mHandler = new Handler(Looper.getMainLooper());
      this.dcC = paramb;
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
          ae.d("MicroMsg.EmojiAndTextArtist", "cancel focus!");
          if (e.this.NI() == null)
          {
            AppMethodBeat.o(9153);
            return;
          }
          com.tencent.mm.z.c localc = ((d)e.this.NI()).XV();
          if ((localc != null) && (localc.fRe))
          {
            localc.setSelected(false);
            e.a.a(e.a.this).cl(false);
            e.a.a(e.a.this).NP();
          }
          AppMethodBeat.o(9153);
        }
      });
      AppMethodBeat.o(9155);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.e.e
 * JD-Core Version:    0.7.0.1
 */