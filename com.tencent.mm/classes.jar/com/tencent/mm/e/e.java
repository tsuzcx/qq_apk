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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.ap;
import com.tencent.mm.z.f;
import java.util.ListIterator;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;

public final class e
  extends b<d>
{
  private boolean cPX;
  private boolean cPY;
  private volatile boolean cPZ;
  private TimerTask cQa;
  private Rect cQb;
  private float cQc;
  private float cQd;
  private int cQe;
  private int cQf;
  private boolean cQg;
  private com.tencent.mm.c.c cQh;
  public com.tencent.mm.af.a cQi;
  boolean cQj;
  private Timer mTimer;
  Matrix vt;
  
  public e()
  {
    AppMethodBeat.i(9156);
    this.mTimer = new Timer();
    this.cPZ = false;
    this.cQb = new Rect();
    this.cPX = false;
    this.cPY = false;
    this.cQc = 0.0F;
    this.cQd = 0.0F;
    this.cQe = 0;
    this.cQf = 0;
    this.cQg = false;
    this.cQh = new com.tencent.mm.c.c(this);
    this.vt = new Matrix();
    this.cQj = false;
    AppMethodBeat.o(9156);
  }
  
  private com.tencent.mm.z.c Mp()
  {
    Object localObject1 = null;
    AppMethodBeat.i(9162);
    Object localObject2 = (d)Mb();
    if (localObject2 == null)
    {
      AppMethodBeat.o(9162);
      return null;
    }
    ListIterator localListIterator = ((d)localObject2).Vv();
    while (localListIterator.hasPrevious())
    {
      localObject2 = (com.tencent.mm.z.c)localListIterator.previous();
      if (((com.tencent.mm.z.c)localObject2).fvR) {
        localObject1 = localObject2;
      }
      ((com.tencent.mm.z.c)localObject2).setSelected(false);
    }
    AppMethodBeat.o(9162);
    return localObject1;
  }
  
  private void Mq()
  {
    AppMethodBeat.i(9163);
    ac.d("MicroMsg.EmojiAndTextArtist", "[registerFocusTask]");
    if (this.cQa != null) {
      this.cQa.cancel();
    }
    if (this.cPZ)
    {
      ac.w("MicroMsg.EmojiAndTextArtist", "[registerFocusTask] isTimerCancel=true");
      AppMethodBeat.o(9163);
      return;
    }
    this.cQa = new a(this);
    this.mTimer.schedule(this.cQa, 1500L);
    AppMethodBeat.o(9163);
  }
  
  private void Mr()
  {
    AppMethodBeat.i(9164);
    ac.d("MicroMsg.EmojiAndTextArtist", "[unRegisterFocusTask]");
    if (this.cQa != null) {
      this.cQa.cancel();
    }
    AppMethodBeat.o(9164);
  }
  
  private com.tencent.mm.z.c u(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(9161);
    if (Mb() == null)
    {
      ac.e("MicroMsg.EmojiAndTextArtist", "[isContainsItem] getCache is null!");
      AppMethodBeat.o(9161);
      return null;
    }
    ListIterator localListIterator = ((d)Mb()).Vv();
    com.tencent.mm.z.c localc;
    float[] arrayOfFloat;
    do
    {
      if (!localListIterator.hasPrevious()) {
        break;
      }
      localc = (com.tencent.mm.z.c)localListIterator.previous();
      arrayOfFloat = s(paramFloat1, paramFloat2);
    } while (!localc.v(arrayOfFloat[0], arrayOfFloat[1]));
    for (;;)
    {
      AppMethodBeat.o(9161);
      return localc;
      localc = null;
    }
  }
  
  public final a LZ()
  {
    return a.cOP;
  }
  
  public final void Ma() {}
  
  public final void a(SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9165);
    ac.i("MicroMsg.EmojiAndTextArtist", "[addItem] text:%s", new Object[] { paramSpannableString });
    if (bs.aj(paramSpannableString))
    {
      AppMethodBeat.o(9165);
      return;
    }
    d locald = (d)Mb();
    if (locald == null)
    {
      ac.w("MicroMsg.EmojiAndTextArtist", "cache is null!");
      AppMethodBeat.o(9165);
      return;
    }
    Mr();
    Mp();
    ck(false);
    Object localObject = getBoardRect();
    paramSpannableString = new f(ai.getContext(), getMainMatrix(), locald.aj(true), (Rect)localObject, paramSpannableString, paramInt1, paramInt2);
    paramSpannableString.setSelected(true);
    paramSpannableString.gfj = true;
    localObject = s(((Rect)localObject).centerX(), ((Rect)localObject).centerY());
    paramSpannableString.a(localObject[0], localObject[1], this.cOU.getInitScale() / this.cOU.getCurScale(), (int)getRotation());
    locald.a(paramSpannableString);
    Mi();
    Mq();
    AppMethodBeat.o(9165);
  }
  
  public final void a(f paramf, SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9167);
    d locald = (d)Mb();
    if (locald == null)
    {
      ac.w("MicroMsg.EmojiAndTextArtist", "cache is null!");
      AppMethodBeat.o(9167);
      return;
    }
    Object localObject = paramf.gfb;
    ac.i("MicroMsg.EmojiAndTextCache", "[delete] id:%s", new Object[] { localObject });
    com.tencent.mm.z.c localc;
    if ((locald.fpX != null) && (locald.fpX.size() > 0))
    {
      localc = (com.tencent.mm.z.c)locald.fpX.peek();
      if (!localc.gfb.equalsIgnoreCase((String)localObject)) {
        break label266;
      }
      locald.fpX.pop();
    }
    for (;;)
    {
      paramf.setSelected(true);
      paramf.gfj = true;
      Mr();
      Mp();
      ck(true);
      if (!bs.aj(paramSpannableString))
      {
        localObject = getBoardRect();
        paramSpannableString = new f(ai.getContext(), getMainMatrix(), locald.aj(true), (Rect)localObject, paramSpannableString, paramInt1, paramInt2);
        paramSpannableString.setSelected(true);
        localObject = paramf.gfe;
        paramSpannableString.a(((PointF)localObject).x, ((PointF)localObject).y, this.cOU.getInitScale() / this.cOU.getCurScale(), paramf.mRotation);
        paramSpannableString.cEY = paramf.cEY;
        locald.a(paramSpannableString);
      }
      Mi();
      Mq();
      AppMethodBeat.o(9167);
      return;
      label266:
      ac.e("MicroMsg.EmojiAndTextCache", "[delete] id:%s emojiItem:%s", new Object[] { localObject, localc });
    }
  }
  
  public final void b(p paramp)
  {
    AppMethodBeat.i(9166);
    ac.i("MicroMsg.EmojiAndTextArtist", "[addEmojiItem] item:%s", new Object[] { paramp });
    d locald = (d)Mb();
    if (locald == null)
    {
      ac.w("MicroMsg.EmojiAndTextArtist", "cache is null!");
      AppMethodBeat.o(9166);
      return;
    }
    Mr();
    Mp();
    ck(false);
    Object localObject = getBoardRect();
    paramp = new com.tencent.mm.z.c(ai.getContext(), getMainMatrix(), locald.aj(true), paramp, (Rect)localObject);
    paramp.setSelected(true);
    localObject = s(((Rect)localObject).centerX(), ((Rect)localObject).centerY());
    paramp.a(localObject[0], localObject[1], this.cOU.getInitScale() / this.cOU.getCurScale(), (int)getRotation());
    locald.a(paramp);
    Mi();
    Mq();
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
      bool = this.cPX;
      AppMethodBeat.o(9159);
      return bool;
    case 0: 
      Mr();
      localObject1 = u(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (localObject1 == null)
      {
        this.cPX = false;
        if (Mb() == null) {
          bool = false;
        }
      }
      break;
    }
    while (bool)
    {
      Mp();
      ck(false);
      Mi();
      break;
      localObject1 = ((d)Mb()).Vu();
      if (localObject1 != null)
      {
        bool = ((com.tencent.mm.z.c)localObject1).fvR;
        continue;
        bool = ((com.tencent.mm.z.c)localObject1).gfj;
        Mp();
        this.cPX = true;
        ((com.tencent.mm.z.c)localObject1).setSelected(true);
        ((com.tencent.mm.z.c)localObject1).gfj = bool;
        ((com.tencent.mm.z.c)localObject1).gfg.set(((com.tencent.mm.z.c)localObject1).gfe);
        ((d)Mb()).b((com.tencent.mm.z.c)localObject1);
        ck(true);
        Mi();
        break;
        if (this.cPX)
        {
          this.cQc = o(paramMotionEvent);
          this.cQe = ((int)Math.toDegrees(Math.atan2(p(paramMotionEvent)[0], p(paramMotionEvent)[1])));
          localObject1 = ((d)Mb()).Vu();
          if ((localObject1 == null) || (!((com.tencent.mm.z.c)localObject1).fvR)) {
            break;
          }
          this.cQf = ((com.tencent.mm.z.c)localObject1).mRotation;
          this.cQd = ((com.tencent.mm.z.c)localObject1).cEY;
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
        bool = ((com.tencent.mm.z.c)localObject1).gfj;
        Mp();
        ((com.tencent.mm.z.c)localObject1).gfj = bool;
        this.cPX = true;
        ((com.tencent.mm.z.c)localObject1).setSelected(true);
        ((d)Mb()).b((com.tencent.mm.z.c)localObject1);
        this.cQc = o(paramMotionEvent);
        this.cQe = ((int)Math.toDegrees(Math.atan2(p(paramMotionEvent)[0], p(paramMotionEvent)[1])));
        if ((localObject1 != null) && (((com.tencent.mm.z.c)localObject1).fvR))
        {
          this.cQf = ((com.tencent.mm.z.c)localObject1).mRotation;
          this.cQd = ((com.tencent.mm.z.c)localObject1).cEY;
        }
        ck(true);
        Mi();
        break;
        this.cQg = true;
        break;
        if (this.cQg)
        {
          this.cQg = false;
          AppMethodBeat.o(9159);
          return true;
        }
        if ((!this.cPX) || (!r(paramMotionEvent))) {
          break;
        }
        if ((!this.cPY) && (this.cQi != null)) {
          this.cQi.onShow();
        }
        localObject1 = new int[2];
        localObject1[0] = ((int)(paramMotionEvent.getX(0) - this.cPb.x));
        localObject1[1] = ((int)(paramMotionEvent.getY(0) - this.cPb.y));
        float f1 = 1.0F;
        int i = 0;
        if (paramMotionEvent.getPointerCount() > 1)
        {
          if (0.0F != this.cQc) {
            f1 = o(paramMotionEvent) / this.cQc;
          }
          i = this.cQe - (int)Math.toDegrees(Math.atan2(p(paramMotionEvent)[0], p(paramMotionEvent)[1]));
        }
        for (;;)
        {
          float f2 = localObject1[0];
          float f3 = localObject1[1];
          float f4 = this.cQd;
          int j = this.cQf;
          int k = paramMotionEvent.getPointerCount();
          localObject1 = ((d)Mb()).Vu();
          Object localObject3;
          Object localObject2;
          if (localObject1 != null)
          {
            this.vt.reset();
            this.vt.postRotate(-getRotation());
            localObject3 = this.vt;
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
            ((com.tencent.mm.z.c)localObject1).afh();
            localObject2 = ((com.tencent.mm.z.c)localObject1).gfe;
            localObject2 = t(((PointF)localObject2).x, ((PointF)localObject2).y);
            if (this.cQb.top > localObject2[1]) {
              break label956;
            }
            if (this.cQi != null) {
              this.cQi.ah((localObject2[1] - this.cQb.top) / this.cQb.height());
            }
          }
          for (this.cQj = true;; this.cQj = false)
          {
            if ((localObject1 instanceof f)) {
              ((com.tencent.mm.z.c)localObject1).gfj = false;
            }
            this.cPY = true;
            Mi();
            break;
            label924:
            ((com.tencent.mm.z.c)localObject1).b(localObject3[0] / getScale(), localObject3[1] / getScale(), 0.0F, ((com.tencent.mm.z.c)localObject1).mRotation);
            break label811;
            label956:
            if ((this.cQi != null) && (this.cQj)) {
              this.cQi.aih();
            }
          }
          if (!isAlive())
          {
            ac.e("MicroMsg.EmojiAndTextArtist", "[ACTION_UP] is not alive!");
            AppMethodBeat.o(9159);
            return false;
          }
          if (Mb() == null)
          {
            ac.e("MicroMsg.EmojiAndTextArtist", "[getCache] is null!");
            AppMethodBeat.o(9159);
            return false;
          }
          localObject1 = ((d)Mb()).Vu();
          if (localObject1 != null)
          {
            if (!this.cOW.contains((int)((com.tencent.mm.z.c)localObject1).gfe.x, (int)((com.tencent.mm.z.c)localObject1).gfe.y))
            {
              this.cQh.cEQ = true;
              localObject2 = this.cQh;
              ((com.tencent.mm.c.c)localObject2).cES = ((com.tencent.mm.z.c)localObject1);
              ((com.tencent.mm.c.c)localObject2).cEH = (((com.tencent.mm.z.c)localObject1).gfg.x - ((com.tencent.mm.z.c)localObject1).gfe.x);
              ((com.tencent.mm.c.c)localObject2).cEI = (((com.tencent.mm.z.c)localObject1).gfg.y - ((com.tencent.mm.z.c)localObject1).gfe.y);
              ((com.tencent.mm.c.c)localObject2).cET = ((com.tencent.mm.z.c)localObject1).gfb;
              localObject2 = this.cQh;
              if (((com.tencent.mm.c.b)localObject2).cEQ)
              {
                ((com.tencent.mm.c.c)localObject2).cEE = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("deltaY", new float[] { 0.0F, ((com.tencent.mm.c.c)localObject2).cEI }), PropertyValuesHolder.ofFloat("deltaX", new float[] { 0.0F, ((com.tencent.mm.c.c)localObject2).cEH }) });
                ((com.tencent.mm.c.c)localObject2).cEE.addUpdateListener(new c.1((com.tencent.mm.c.c)localObject2));
                ((com.tencent.mm.c.c)localObject2).cEE.addListener(new c.2((com.tencent.mm.c.c)localObject2));
                ((com.tencent.mm.c.c)localObject2).cEE.setInterpolator(new LinearInterpolator());
                ((com.tencent.mm.c.c)localObject2).cEE.setDuration(100L);
                ((com.tencent.mm.c.c)localObject2).cEE.start();
              }
            }
            if ((localObject1 instanceof f))
            {
              localObject2 = (f)localObject1;
              if ((!((com.tencent.mm.z.c)localObject2).fvR) || (!((com.tencent.mm.z.c)localObject2).gfj)) {
                break label1485;
              }
              if (this.cQi != null) {
                this.cQi.a((f)localObject2);
              }
            }
          }
          for (;;)
          {
            localObject2 = ((com.tencent.mm.z.c)localObject1).gfe;
            localObject2 = t(((PointF)localObject2).x, ((PointF)localObject2).y);
            ac.i("MicroMsg.EmojiAndTextArtist", "mRubbishRect:%s pointF:%s", new Object[] { this.cQb, Float.valueOf(localObject2[1]) });
            if ((((com.tencent.mm.z.c)localObject1).fvR) && (this.cQb.top <= localObject2[1]) && (this.cPX) && (this.cQi != null))
            {
              ((d)Mb()).Vt();
              Mi();
            }
            Mq();
            if ((this.cPY) && (this.cQi != null)) {
              this.cQi.onHide();
            }
            this.cPY = false;
            break;
            label1485:
            if (((com.tencent.mm.z.c)localObject2).fvR) {
              ((com.tencent.mm.z.c)localObject2).gfj = true;
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
    int i = (int)ai.getResources().getDimension(2131166754);
    int j = (int)ai.getResources().getDimension(2131166755);
    int k = ap.ej(this.cOU.eQN().getContext());
    this.cQb.set((getBoardRect().width() - j) / 2, getBoardRect().height() - i - k, getBoardRect().width() - k, (j + getBoardRect().width()) / 2);
    if (this.cPZ) {
      this.mTimer = new Timer();
    }
    AppMethodBeat.o(9157);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9160);
    super.onDestroy();
    this.cPZ = true;
    Mr();
    this.mTimer.cancel();
    AppMethodBeat.o(9160);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9158);
    d(paramCanvas);
    Object localObject = (d)Mb();
    if (localObject != null)
    {
      localObject = ((d)localObject).Vu();
      if ((localObject != null) && (((com.tencent.mm.z.c)localObject).fvR)) {
        ((com.tencent.mm.z.c)localObject).draw(paramCanvas);
      }
    }
    AppMethodBeat.o(9158);
  }
  
  final class a
    extends TimerTask
  {
    private b cQk;
    private Handler mHandler;
    
    public a(b paramb)
    {
      AppMethodBeat.i(9154);
      this.mHandler = new Handler(Looper.getMainLooper());
      this.cQk = paramb;
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
          ac.d("MicroMsg.EmojiAndTextArtist", "cancel focus!");
          if (e.this.Mb() == null)
          {
            AppMethodBeat.o(9153);
            return;
          }
          com.tencent.mm.z.c localc = ((d)e.this.Mb()).Vu();
          if ((localc != null) && (localc.fvR))
          {
            localc.setSelected(false);
            e.a.a(e.a.this).ck(false);
            e.a.a(e.a.this).Mi();
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