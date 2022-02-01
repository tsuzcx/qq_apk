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
import com.tencent.mm.ui.ar;
import java.util.ListIterator;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;

public final class e
  extends b<d>
{
  private boolean dbn;
  private boolean dbo;
  private volatile boolean dbp;
  private TimerTask dbq;
  private Rect dbr;
  private float dbs;
  private float dbt;
  private int dbu;
  private int dbv;
  private boolean dbw;
  private com.tencent.mm.c.c dbx;
  public com.tencent.mm.ag.a dby;
  boolean dbz;
  private Timer mTimer;
  Matrix xm;
  
  public e()
  {
    AppMethodBeat.i(9156);
    this.mTimer = new Timer();
    this.dbp = false;
    this.dbr = new Rect();
    this.dbn = false;
    this.dbo = false;
    this.dbs = 0.0F;
    this.dbt = 0.0F;
    this.dbu = 0;
    this.dbv = 0;
    this.dbw = false;
    this.dbx = new com.tencent.mm.c.c(this);
    this.xm = new Matrix();
    this.dbz = false;
    AppMethodBeat.o(9156);
  }
  
  private com.tencent.mm.aa.c NY()
  {
    Object localObject1 = null;
    AppMethodBeat.i(9162);
    Object localObject2 = (d)NK();
    if (localObject2 == null)
    {
      AppMethodBeat.o(9162);
      return null;
    }
    ListIterator localListIterator = ((d)localObject2).XM();
    while (localListIterator.hasPrevious())
    {
      localObject2 = (com.tencent.mm.aa.c)localListIterator.previous();
      if (((com.tencent.mm.aa.c)localObject2).fOY) {
        localObject1 = localObject2;
      }
      ((com.tencent.mm.aa.c)localObject2).setSelected(false);
    }
    AppMethodBeat.o(9162);
    return localObject1;
  }
  
  private void NZ()
  {
    AppMethodBeat.i(9163);
    ad.d("MicroMsg.EmojiAndTextArtist", "[registerFocusTask]");
    if (this.dbq != null) {
      this.dbq.cancel();
    }
    if (this.dbp)
    {
      ad.w("MicroMsg.EmojiAndTextArtist", "[registerFocusTask] isTimerCancel=true");
      AppMethodBeat.o(9163);
      return;
    }
    this.dbq = new a(this);
    this.mTimer.schedule(this.dbq, 1500L);
    AppMethodBeat.o(9163);
  }
  
  private void Oa()
  {
    AppMethodBeat.i(9164);
    ad.d("MicroMsg.EmojiAndTextArtist", "[unRegisterFocusTask]");
    if (this.dbq != null) {
      this.dbq.cancel();
    }
    AppMethodBeat.o(9164);
  }
  
  private com.tencent.mm.aa.c w(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(9161);
    if (NK() == null)
    {
      ad.e("MicroMsg.EmojiAndTextArtist", "[isContainsItem] getCache is null!");
      AppMethodBeat.o(9161);
      return null;
    }
    ListIterator localListIterator = ((d)NK()).XM();
    com.tencent.mm.aa.c localc;
    float[] arrayOfFloat;
    do
    {
      if (!localListIterator.hasPrevious()) {
        break;
      }
      localc = (com.tencent.mm.aa.c)localListIterator.previous();
      arrayOfFloat = u(paramFloat1, paramFloat2);
    } while (!localc.x(arrayOfFloat[0], arrayOfFloat[1]));
    for (;;)
    {
      AppMethodBeat.o(9161);
      return localc;
      localc = null;
    }
  }
  
  public final a NI()
  {
    return a.daf;
  }
  
  public final void NJ() {}
  
  public final void a(SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9165);
    ad.i("MicroMsg.EmojiAndTextArtist", "[addItem] text:%s", new Object[] { paramSpannableString });
    if (bt.ai(paramSpannableString))
    {
      AppMethodBeat.o(9165);
      return;
    }
    d locald = (d)NK();
    if (locald == null)
    {
      ad.w("MicroMsg.EmojiAndTextArtist", "cache is null!");
      AppMethodBeat.o(9165);
      return;
    }
    Oa();
    NY();
    cl(false);
    Object localObject = getBoardRect();
    paramSpannableString = new f(aj.getContext(), getMainMatrix(), locald.aj(true), (Rect)localObject, paramSpannableString, paramInt1, paramInt2);
    paramSpannableString.setSelected(true);
    paramSpannableString.gyT = true;
    localObject = u(((Rect)localObject).centerX(), ((Rect)localObject).centerY());
    paramSpannableString.a(localObject[0], localObject[1], this.dak.getInitScale() / this.dak.getCurScale(), (int)getRotation());
    locald.a(paramSpannableString);
    NR();
    NZ();
    AppMethodBeat.o(9165);
  }
  
  public final void a(f paramf, SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9167);
    d locald = (d)NK();
    if (locald == null)
    {
      ad.w("MicroMsg.EmojiAndTextArtist", "cache is null!");
      AppMethodBeat.o(9167);
      return;
    }
    Object localObject = paramf.gyL;
    ad.i("MicroMsg.EmojiAndTextCache", "[delete] id:%s", new Object[] { localObject });
    com.tencent.mm.aa.c localc;
    if ((locald.fIe != null) && (locald.fIe.size() > 0))
    {
      localc = (com.tencent.mm.aa.c)locald.fIe.peek();
      if (!localc.gyL.equalsIgnoreCase((String)localObject)) {
        break label266;
      }
      locald.fIe.pop();
    }
    for (;;)
    {
      paramf.setSelected(true);
      paramf.gyT = true;
      Oa();
      NY();
      cl(true);
      if (!bt.ai(paramSpannableString))
      {
        localObject = getBoardRect();
        paramSpannableString = new f(aj.getContext(), getMainMatrix(), locald.aj(true), (Rect)localObject, paramSpannableString, paramInt1, paramInt2);
        paramSpannableString.setSelected(true);
        localObject = paramf.gyO;
        paramSpannableString.a(((PointF)localObject).x, ((PointF)localObject).y, this.dak.getInitScale() / this.dak.getCurScale(), paramf.mRotation);
        paramSpannableString.cQd = paramf.cQd;
        locald.a(paramSpannableString);
      }
      NR();
      NZ();
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
    d locald = (d)NK();
    if (locald == null)
    {
      ad.w("MicroMsg.EmojiAndTextArtist", "cache is null!");
      AppMethodBeat.o(9166);
      return;
    }
    Oa();
    NY();
    cl(false);
    Object localObject = getBoardRect();
    paramp = new com.tencent.mm.aa.c(aj.getContext(), getMainMatrix(), locald.aj(true), paramp, (Rect)localObject);
    paramp.setSelected(true);
    localObject = u(((Rect)localObject).centerX(), ((Rect)localObject).centerY());
    paramp.a(localObject[0], localObject[1], this.dak.getInitScale() / this.dak.getCurScale(), (int)getRotation());
    locald.a(paramp);
    NR();
    NZ();
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
      bool = this.dbn;
      AppMethodBeat.o(9159);
      return bool;
    case 0: 
      Oa();
      localObject1 = w(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (localObject1 == null)
      {
        this.dbn = false;
        if (NK() == null) {
          bool = false;
        }
      }
      break;
    }
    while (bool)
    {
      NY();
      cl(false);
      NR();
      break;
      localObject1 = ((d)NK()).XL();
      if (localObject1 != null)
      {
        bool = ((com.tencent.mm.aa.c)localObject1).fOY;
        continue;
        bool = ((com.tencent.mm.aa.c)localObject1).gyT;
        NY();
        this.dbn = true;
        ((com.tencent.mm.aa.c)localObject1).setSelected(true);
        ((com.tencent.mm.aa.c)localObject1).gyT = bool;
        ((com.tencent.mm.aa.c)localObject1).gyQ.set(((com.tencent.mm.aa.c)localObject1).gyO);
        ((d)NK()).b((com.tencent.mm.aa.c)localObject1);
        cl(true);
        NR();
        break;
        if (this.dbn)
        {
          this.dbs = o(paramMotionEvent);
          this.dbu = ((int)Math.toDegrees(Math.atan2(p(paramMotionEvent)[0], p(paramMotionEvent)[1])));
          localObject1 = ((d)NK()).XL();
          if ((localObject1 == null) || (!((com.tencent.mm.aa.c)localObject1).fOY)) {
            break;
          }
          this.dbv = ((com.tencent.mm.aa.c)localObject1).mRotation;
          this.dbt = ((com.tencent.mm.aa.c)localObject1).cQd;
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
        bool = ((com.tencent.mm.aa.c)localObject1).gyT;
        NY();
        ((com.tencent.mm.aa.c)localObject1).gyT = bool;
        this.dbn = true;
        ((com.tencent.mm.aa.c)localObject1).setSelected(true);
        ((d)NK()).b((com.tencent.mm.aa.c)localObject1);
        this.dbs = o(paramMotionEvent);
        this.dbu = ((int)Math.toDegrees(Math.atan2(p(paramMotionEvent)[0], p(paramMotionEvent)[1])));
        if ((localObject1 != null) && (((com.tencent.mm.aa.c)localObject1).fOY))
        {
          this.dbv = ((com.tencent.mm.aa.c)localObject1).mRotation;
          this.dbt = ((com.tencent.mm.aa.c)localObject1).cQd;
        }
        cl(true);
        NR();
        break;
        this.dbw = true;
        break;
        if (this.dbw)
        {
          this.dbw = false;
          AppMethodBeat.o(9159);
          return true;
        }
        if ((!this.dbn) || (!r(paramMotionEvent))) {
          break;
        }
        if ((!this.dbo) && (this.dby != null)) {
          this.dby.onShow();
        }
        localObject1 = new int[2];
        localObject1[0] = ((int)(paramMotionEvent.getX(0) - this.dar.x));
        localObject1[1] = ((int)(paramMotionEvent.getY(0) - this.dar.y));
        float f1 = 1.0F;
        int i = 0;
        if (paramMotionEvent.getPointerCount() > 1)
        {
          if (0.0F != this.dbs) {
            f1 = o(paramMotionEvent) / this.dbs;
          }
          i = this.dbu - (int)Math.toDegrees(Math.atan2(p(paramMotionEvent)[0], p(paramMotionEvent)[1]));
        }
        for (;;)
        {
          float f2 = localObject1[0];
          float f3 = localObject1[1];
          float f4 = this.dbt;
          int j = this.dbv;
          int k = paramMotionEvent.getPointerCount();
          localObject1 = ((d)NK()).XL();
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
            ((com.tencent.mm.aa.c)localObject1).b(0.0F, 0.0F, f1 * f4, (i + j) % 360);
            label811:
            ((com.tencent.mm.aa.c)localObject1).ahT();
            localObject2 = ((com.tencent.mm.aa.c)localObject1).gyO;
            localObject2 = v(((PointF)localObject2).x, ((PointF)localObject2).y);
            if (this.dbr.top > localObject2[1]) {
              break label956;
            }
            if (this.dby != null) {
              this.dby.ak((localObject2[1] - this.dbr.top) / this.dbr.height());
            }
          }
          for (this.dbz = true;; this.dbz = false)
          {
            if ((localObject1 instanceof f)) {
              ((com.tencent.mm.aa.c)localObject1).gyT = false;
            }
            this.dbo = true;
            NR();
            break;
            label924:
            ((com.tencent.mm.aa.c)localObject1).b(localObject3[0] / getScale(), localObject3[1] / getScale(), 0.0F, ((com.tencent.mm.aa.c)localObject1).mRotation);
            break label811;
            label956:
            if ((this.dby != null) && (this.dbz)) {
              this.dby.akT();
            }
          }
          if (!isAlive())
          {
            ad.e("MicroMsg.EmojiAndTextArtist", "[ACTION_UP] is not alive!");
            AppMethodBeat.o(9159);
            return false;
          }
          if (NK() == null)
          {
            ad.e("MicroMsg.EmojiAndTextArtist", "[getCache] is null!");
            AppMethodBeat.o(9159);
            return false;
          }
          localObject1 = ((d)NK()).XL();
          if (localObject1 != null)
          {
            if (!this.dam.contains((int)((com.tencent.mm.aa.c)localObject1).gyO.x, (int)((com.tencent.mm.aa.c)localObject1).gyO.y))
            {
              this.dbx.cPV = true;
              localObject2 = this.dbx;
              ((com.tencent.mm.c.c)localObject2).cPX = ((com.tencent.mm.aa.c)localObject1);
              ((com.tencent.mm.c.c)localObject2).cPM = (((com.tencent.mm.aa.c)localObject1).gyQ.x - ((com.tencent.mm.aa.c)localObject1).gyO.x);
              ((com.tencent.mm.c.c)localObject2).cPN = (((com.tencent.mm.aa.c)localObject1).gyQ.y - ((com.tencent.mm.aa.c)localObject1).gyO.y);
              ((com.tencent.mm.c.c)localObject2).cPY = ((com.tencent.mm.aa.c)localObject1).gyL;
              localObject2 = this.dbx;
              if (((com.tencent.mm.c.b)localObject2).cPV)
              {
                ((com.tencent.mm.c.c)localObject2).cPJ = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("deltaY", new float[] { 0.0F, ((com.tencent.mm.c.c)localObject2).cPN }), PropertyValuesHolder.ofFloat("deltaX", new float[] { 0.0F, ((com.tencent.mm.c.c)localObject2).cPM }) });
                ((com.tencent.mm.c.c)localObject2).cPJ.addUpdateListener(new c.1((com.tencent.mm.c.c)localObject2));
                ((com.tencent.mm.c.c)localObject2).cPJ.addListener(new c.2((com.tencent.mm.c.c)localObject2));
                ((com.tencent.mm.c.c)localObject2).cPJ.setInterpolator(new LinearInterpolator());
                ((com.tencent.mm.c.c)localObject2).cPJ.setDuration(100L);
                ((com.tencent.mm.c.c)localObject2).cPJ.start();
              }
            }
            if ((localObject1 instanceof f))
            {
              localObject2 = (f)localObject1;
              if ((!((com.tencent.mm.aa.c)localObject2).fOY) || (!((com.tencent.mm.aa.c)localObject2).gyT)) {
                break label1485;
              }
              if (this.dby != null) {
                this.dby.a((f)localObject2);
              }
            }
          }
          for (;;)
          {
            localObject2 = ((com.tencent.mm.aa.c)localObject1).gyO;
            localObject2 = v(((PointF)localObject2).x, ((PointF)localObject2).y);
            ad.i("MicroMsg.EmojiAndTextArtist", "mRubbishRect:%s pointF:%s", new Object[] { this.dbr, Float.valueOf(localObject2[1]) });
            if ((((com.tencent.mm.aa.c)localObject1).fOY) && (this.dbr.top <= localObject2[1]) && (this.dbn) && (this.dby != null))
            {
              ((d)NK()).XK();
              NR();
            }
            NZ();
            if ((this.dbo) && (this.dby != null)) {
              this.dby.onHide();
            }
            this.dbo = false;
            break;
            label1485:
            if (((com.tencent.mm.aa.c)localObject2).fOY) {
              ((com.tencent.mm.aa.c)localObject2).gyT = true;
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
    int i = (int)aj.getResources().getDimension(2131166754);
    int j = (int)aj.getResources().getDimension(2131166755);
    int k = ar.ej(this.dak.ffR().getContext());
    this.dbr.set((getBoardRect().width() - j) / 2, getBoardRect().height() - i - k, getBoardRect().width() - k, (j + getBoardRect().width()) / 2);
    if (this.dbp) {
      this.mTimer = new Timer();
    }
    AppMethodBeat.o(9157);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9160);
    super.onDestroy();
    this.dbp = true;
    Oa();
    this.mTimer.cancel();
    AppMethodBeat.o(9160);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9158);
    d(paramCanvas);
    Object localObject = (d)NK();
    if (localObject != null)
    {
      localObject = ((d)localObject).XL();
      if ((localObject != null) && (((com.tencent.mm.aa.c)localObject).fOY)) {
        ((com.tencent.mm.aa.c)localObject).draw(paramCanvas);
      }
    }
    AppMethodBeat.o(9158);
  }
  
  final class a
    extends TimerTask
  {
    private b dbA;
    private Handler mHandler;
    
    public a(b paramb)
    {
      AppMethodBeat.i(9154);
      this.mHandler = new Handler(Looper.getMainLooper());
      this.dbA = paramb;
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
          if (e.this.NK() == null)
          {
            AppMethodBeat.o(9153);
            return;
          }
          com.tencent.mm.aa.c localc = ((d)e.this.NK()).XL();
          if ((localc != null) && (localc.fOY))
          {
            localc.setSelected(false);
            e.a.a(e.a.this).cl(false);
            e.a.a(e.a.this).NR();
          }
          AppMethodBeat.o(9153);
        }
      });
      AppMethodBeat.o(9155);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.e.e
 * JD-Core Version:    0.7.0.1
 */