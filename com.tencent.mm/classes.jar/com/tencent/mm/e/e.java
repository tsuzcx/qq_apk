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
import com.tencent.mm.api.r;
import com.tencent.mm.c.c.1;
import com.tencent.mm.c.c.2;
import com.tencent.mm.cache.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import com.tencent.mm.z.f;
import java.util.ListIterator;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;

public final class e
  extends b<d>
{
  private boolean dsX;
  private boolean dsY;
  private volatile boolean dsZ;
  private TimerTask dta;
  private Rect dtb;
  private float dtc;
  private float dtd;
  private int dte;
  private int dtf;
  private boolean dtg;
  private com.tencent.mm.c.c dth;
  public com.tencent.mm.af.a dti;
  boolean dtj;
  private Timer mTimer;
  Matrix xt;
  
  public e()
  {
    AppMethodBeat.i(9156);
    this.mTimer = new Timer();
    this.dsZ = false;
    this.dtb = new Rect();
    this.dsX = false;
    this.dsY = false;
    this.dtc = 0.0F;
    this.dtd = 0.0F;
    this.dte = 0;
    this.dtf = 0;
    this.dtg = false;
    this.dth = new com.tencent.mm.c.c(this);
    this.xt = new Matrix();
    this.dtj = false;
    AppMethodBeat.o(9156);
  }
  
  private com.tencent.mm.z.c Yi()
  {
    Object localObject1 = null;
    AppMethodBeat.i(9162);
    Object localObject2 = (d)XU();
    if (localObject2 == null)
    {
      AppMethodBeat.o(9162);
      return null;
    }
    ListIterator localListIterator = ((d)localObject2).alJ();
    while (localListIterator.hasPrevious())
    {
      localObject2 = (com.tencent.mm.z.c)localListIterator.previous();
      if (((com.tencent.mm.z.c)localObject2).gwn) {
        localObject1 = localObject2;
      }
      ((com.tencent.mm.z.c)localObject2).setSelected(false);
    }
    AppMethodBeat.o(9162);
    return localObject1;
  }
  
  private void Yj()
  {
    AppMethodBeat.i(9163);
    Log.d("MicroMsg.EmojiAndTextArtist", "[registerFocusTask]");
    if (this.dta != null) {
      this.dta.cancel();
    }
    if (this.dsZ)
    {
      Log.w("MicroMsg.EmojiAndTextArtist", "[registerFocusTask] isTimerCancel=true");
      AppMethodBeat.o(9163);
      return;
    }
    this.dta = new a(this);
    this.mTimer.schedule(this.dta, 1500L);
    AppMethodBeat.o(9163);
  }
  
  private void Yk()
  {
    AppMethodBeat.i(9164);
    Log.d("MicroMsg.EmojiAndTextArtist", "[unRegisterFocusTask]");
    if (this.dta != null) {
      this.dta.cancel();
    }
    AppMethodBeat.o(9164);
  }
  
  private com.tencent.mm.z.c x(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(9161);
    if (XU() == null)
    {
      Log.e("MicroMsg.EmojiAndTextArtist", "[isContainsItem] getCache is null!");
      AppMethodBeat.o(9161);
      return null;
    }
    ListIterator localListIterator = ((d)XU()).alJ();
    com.tencent.mm.z.c localc;
    float[] arrayOfFloat;
    do
    {
      if (!localListIterator.hasPrevious()) {
        break;
      }
      localc = (com.tencent.mm.z.c)localListIterator.previous();
      arrayOfFloat = v(paramFloat1, paramFloat2);
    } while (!localc.z(arrayOfFloat[0], arrayOfFloat[1]));
    for (;;)
    {
      AppMethodBeat.o(9161);
      return localc;
      localc = null;
    }
  }
  
  public final a XS()
  {
    return a.drN;
  }
  
  public final void XT() {}
  
  public final void a(SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9165);
    Log.i("MicroMsg.EmojiAndTextArtist", "[addItem] text:%s", new Object[] { paramSpannableString });
    if (Util.isNullOrNil(paramSpannableString))
    {
      AppMethodBeat.o(9165);
      return;
    }
    d locald = (d)XU();
    if (locald == null)
    {
      Log.w("MicroMsg.EmojiAndTextArtist", "cache is null!");
      AppMethodBeat.o(9165);
      return;
    }
    Yk();
    Yi();
    cT(false);
    Object localObject = getBoardRect();
    paramSpannableString = new f(MMApplicationContext.getContext(), getMainMatrix(), locald.ai(true), (Rect)localObject, paramSpannableString, paramInt1, paramInt2);
    paramSpannableString.setSelected(true);
    paramSpannableString.hop = true;
    localObject = v(((Rect)localObject).centerX(), ((Rect)localObject).centerY());
    paramSpannableString.a(localObject[0], localObject[1], this.drS.getInitScale() / this.drS.getCurScale(), (int)getRotation());
    locald.a(paramSpannableString);
    Yb();
    Yj();
    AppMethodBeat.o(9165);
  }
  
  public final void a(f paramf, SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9167);
    d locald = (d)XU();
    if (locald == null)
    {
      Log.w("MicroMsg.EmojiAndTextArtist", "cache is null!");
      AppMethodBeat.o(9167);
      return;
    }
    Object localObject = paramf.hoh;
    Log.i("MicroMsg.EmojiAndTextCache", "[delete] id:%s", new Object[] { localObject });
    com.tencent.mm.z.c localc;
    if ((locald.gpx != null) && (locald.gpx.size() > 0))
    {
      localc = (com.tencent.mm.z.c)locald.gpx.peek();
      if (!localc.hoh.equalsIgnoreCase((String)localObject)) {
        break label266;
      }
      locald.gpx.pop();
    }
    for (;;)
    {
      paramf.setSelected(true);
      paramf.hop = true;
      Yk();
      Yi();
      cT(true);
      if (!Util.isNullOrNil(paramSpannableString))
      {
        localObject = getBoardRect();
        paramSpannableString = new f(MMApplicationContext.getContext(), getMainMatrix(), locald.ai(true), (Rect)localObject, paramSpannableString, paramInt1, paramInt2);
        paramSpannableString.setSelected(true);
        localObject = paramf.hok;
        paramSpannableString.a(((PointF)localObject).x, ((PointF)localObject).y, this.drS.getInitScale() / this.drS.getCurScale(), paramf.mRotation);
        paramSpannableString.dhh = paramf.dhh;
        locald.a(paramSpannableString);
      }
      Yb();
      Yj();
      AppMethodBeat.o(9167);
      return;
      label266:
      Log.e("MicroMsg.EmojiAndTextCache", "[delete] id:%s emojiItem:%s", new Object[] { localObject, localc });
    }
  }
  
  public final void b(r paramr)
  {
    AppMethodBeat.i(9166);
    Log.i("MicroMsg.EmojiAndTextArtist", "[addEmojiItem] item:%s", new Object[] { paramr });
    d locald = (d)XU();
    if (locald == null)
    {
      Log.w("MicroMsg.EmojiAndTextArtist", "cache is null!");
      AppMethodBeat.o(9166);
      return;
    }
    Yk();
    Yi();
    cT(false);
    Object localObject = getBoardRect();
    paramr = new com.tencent.mm.z.c(MMApplicationContext.getContext(), getMainMatrix(), locald.ai(true), paramr, (Rect)localObject);
    paramr.setSelected(true);
    localObject = v(((Rect)localObject).centerX(), ((Rect)localObject).centerY());
    paramr.a(localObject[0], localObject[1], this.drS.getInitScale() / this.drS.getCurScale(), (int)getRotation());
    locald.a(paramr);
    Yb();
    Yj();
    AppMethodBeat.o(9166);
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(9157);
    super.onAlive();
    int i = (int)MMApplicationContext.getResources().getDimension(2131166874);
    int j = (int)MMApplicationContext.getResources().getDimension(2131166875);
    int k = au.aD(this.drS.gth().getContext());
    this.dtb.set((getBoardRect().width() - j) / 2, getBoardRect().height() - i - k, getBoardRect().width() - k, (j + getBoardRect().width()) / 2);
    if (this.dsZ) {
      this.mTimer = new Timer();
    }
    AppMethodBeat.o(9157);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9160);
    super.onDestroy();
    this.dsZ = true;
    Yk();
    this.mTimer.cancel();
    AppMethodBeat.o(9160);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9158);
    d(paramCanvas);
    Object localObject = (d)XU();
    if (localObject != null)
    {
      localObject = ((d)localObject).alI();
      if ((localObject != null) && (((com.tencent.mm.z.c)localObject).gwn)) {
        ((com.tencent.mm.z.c)localObject).draw(paramCanvas);
      }
    }
    AppMethodBeat.o(9158);
  }
  
  public final boolean q(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9159);
    boolean bool;
    Object localObject1;
    switch (paramMotionEvent.getActionMasked())
    {
    case 3: 
    case 4: 
    default: 
      super.q(paramMotionEvent);
      bool = this.dsX;
      AppMethodBeat.o(9159);
      return bool;
    case 0: 
      Yk();
      localObject1 = x(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (localObject1 == null)
      {
        this.dsX = false;
        if (XU() == null) {
          bool = false;
        }
      }
      break;
    }
    while (bool)
    {
      Yi();
      cT(false);
      Yb();
      break;
      localObject1 = ((d)XU()).alI();
      if (localObject1 != null)
      {
        bool = ((com.tencent.mm.z.c)localObject1).gwn;
        continue;
        bool = ((com.tencent.mm.z.c)localObject1).hop;
        Yi();
        this.dsX = true;
        ((com.tencent.mm.z.c)localObject1).setSelected(true);
        ((com.tencent.mm.z.c)localObject1).hop = bool;
        ((com.tencent.mm.z.c)localObject1).hom.set(((com.tencent.mm.z.c)localObject1).hok);
        ((d)XU()).b((com.tencent.mm.z.c)localObject1);
        cT(true);
        Yb();
        break;
        if (this.dsX)
        {
          this.dtc = r(paramMotionEvent);
          this.dte = ((int)Math.toDegrees(Math.atan2(s(paramMotionEvent)[0], s(paramMotionEvent)[1])));
          localObject1 = ((d)XU()).alI();
          if ((localObject1 == null) || (!((com.tencent.mm.z.c)localObject1).gwn)) {
            break;
          }
          this.dtf = ((com.tencent.mm.z.c)localObject1).mRotation;
          this.dtd = ((com.tencent.mm.z.c)localObject1).dhh;
          break;
        }
        localObject1 = new int[2];
        if (paramMotionEvent.getPointerCount() > 1)
        {
          localObject1[0] = ((int)(paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2);
          localObject1[1] = ((int)(paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2);
        }
        localObject1 = x(localObject1[0], localObject1[1]);
        if (localObject1 == null) {
          break;
        }
        bool = ((com.tencent.mm.z.c)localObject1).hop;
        Yi();
        ((com.tencent.mm.z.c)localObject1).hop = bool;
        this.dsX = true;
        ((com.tencent.mm.z.c)localObject1).setSelected(true);
        ((d)XU()).b((com.tencent.mm.z.c)localObject1);
        this.dtc = r(paramMotionEvent);
        this.dte = ((int)Math.toDegrees(Math.atan2(s(paramMotionEvent)[0], s(paramMotionEvent)[1])));
        if ((localObject1 != null) && (((com.tencent.mm.z.c)localObject1).gwn))
        {
          this.dtf = ((com.tencent.mm.z.c)localObject1).mRotation;
          this.dtd = ((com.tencent.mm.z.c)localObject1).dhh;
        }
        cT(true);
        Yb();
        break;
        this.dtg = true;
        break;
        if (this.dtg)
        {
          this.dtg = false;
          AppMethodBeat.o(9159);
          return true;
        }
        if ((!this.dsX) || (!u(paramMotionEvent))) {
          break;
        }
        if ((!this.dsY) && (this.dti != null)) {
          this.dti.onShow();
        }
        localObject1 = new int[2];
        localObject1[0] = ((int)(paramMotionEvent.getX(0) - this.drZ.x));
        localObject1[1] = ((int)(paramMotionEvent.getY(0) - this.drZ.y));
        float f1 = 1.0F;
        int i = 0;
        if (paramMotionEvent.getPointerCount() > 1)
        {
          if (0.0F != this.dtc) {
            f1 = r(paramMotionEvent) / this.dtc;
          }
          i = this.dte - (int)Math.toDegrees(Math.atan2(s(paramMotionEvent)[0], s(paramMotionEvent)[1]));
        }
        for (;;)
        {
          float f2 = localObject1[0];
          float f3 = localObject1[1];
          float f4 = this.dtd;
          int j = this.dtf;
          int k = paramMotionEvent.getPointerCount();
          localObject1 = ((d)XU()).alI();
          Object localObject3;
          Object localObject2;
          if (localObject1 != null)
          {
            this.xt.reset();
            this.xt.postRotate(-getRotation());
            localObject3 = this.xt;
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
            ((com.tencent.mm.z.c)localObject1).ayy();
            localObject2 = ((com.tencent.mm.z.c)localObject1).hok;
            localObject2 = w(((PointF)localObject2).x, ((PointF)localObject2).y);
            if (this.dtb.top > localObject2[1]) {
              break label956;
            }
            if (this.dti != null) {
              this.dti.at((localObject2[1] - this.dtb.top) / this.dtb.height());
            }
          }
          for (this.dtj = true;; this.dtj = false)
          {
            if ((localObject1 instanceof f)) {
              ((com.tencent.mm.z.c)localObject1).hop = false;
            }
            this.dsY = true;
            Yb();
            break;
            label924:
            ((com.tencent.mm.z.c)localObject1).b(localObject3[0] / getScale(), localObject3[1] / getScale(), 0.0F, ((com.tencent.mm.z.c)localObject1).mRotation);
            break label811;
            label956:
            if ((this.dti != null) && (this.dtj)) {
              this.dti.aBB();
            }
          }
          if (!isAlive())
          {
            Log.e("MicroMsg.EmojiAndTextArtist", "[ACTION_UP] is not alive!");
            AppMethodBeat.o(9159);
            return false;
          }
          if (XU() == null)
          {
            Log.e("MicroMsg.EmojiAndTextArtist", "[getCache] is null!");
            AppMethodBeat.o(9159);
            return false;
          }
          localObject1 = ((d)XU()).alI();
          if (localObject1 != null)
          {
            if (!this.drU.contains((int)((com.tencent.mm.z.c)localObject1).hok.x, (int)((com.tencent.mm.z.c)localObject1).hok.y))
            {
              this.dth.dgZ = true;
              localObject2 = this.dth;
              ((com.tencent.mm.c.c)localObject2).dhb = ((com.tencent.mm.z.c)localObject1);
              ((com.tencent.mm.c.c)localObject2).dgQ = (((com.tencent.mm.z.c)localObject1).hom.x - ((com.tencent.mm.z.c)localObject1).hok.x);
              ((com.tencent.mm.c.c)localObject2).dgR = (((com.tencent.mm.z.c)localObject1).hom.y - ((com.tencent.mm.z.c)localObject1).hok.y);
              ((com.tencent.mm.c.c)localObject2).dhc = ((com.tencent.mm.z.c)localObject1).hoh;
              localObject2 = this.dth;
              if (((com.tencent.mm.c.b)localObject2).dgZ)
              {
                ((com.tencent.mm.c.c)localObject2).dgN = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("deltaY", new float[] { 0.0F, ((com.tencent.mm.c.c)localObject2).dgR }), PropertyValuesHolder.ofFloat("deltaX", new float[] { 0.0F, ((com.tencent.mm.c.c)localObject2).dgQ }) });
                ((com.tencent.mm.c.c)localObject2).dgN.addUpdateListener(new c.1((com.tencent.mm.c.c)localObject2));
                ((com.tencent.mm.c.c)localObject2).dgN.addListener(new c.2((com.tencent.mm.c.c)localObject2));
                ((com.tencent.mm.c.c)localObject2).dgN.setInterpolator(new LinearInterpolator());
                ((com.tencent.mm.c.c)localObject2).dgN.setDuration(100L);
                ((com.tencent.mm.c.c)localObject2).dgN.start();
              }
            }
            if ((localObject1 instanceof f))
            {
              localObject2 = (f)localObject1;
              if ((!((com.tencent.mm.z.c)localObject2).gwn) || (!((com.tencent.mm.z.c)localObject2).hop)) {
                break label1485;
              }
              if (this.dti != null) {
                this.dti.a((f)localObject2);
              }
            }
          }
          for (;;)
          {
            localObject2 = ((com.tencent.mm.z.c)localObject1).hok;
            localObject2 = w(((PointF)localObject2).x, ((PointF)localObject2).y);
            Log.i("MicroMsg.EmojiAndTextArtist", "mRubbishRect:%s pointF:%s", new Object[] { this.dtb, Float.valueOf(localObject2[1]) });
            if ((((com.tencent.mm.z.c)localObject1).gwn) && (this.dtb.top <= localObject2[1]) && (this.dsX) && (this.dti != null))
            {
              ((d)XU()).alH();
              Yb();
            }
            Yj();
            if ((this.dsY) && (this.dti != null)) {
              this.dti.onHide();
            }
            this.dsY = false;
            break;
            label1485:
            if (((com.tencent.mm.z.c)localObject2).gwn) {
              ((com.tencent.mm.z.c)localObject2).hop = true;
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
    private b dtk;
    private Handler mHandler;
    
    public a(b paramb)
    {
      AppMethodBeat.i(9154);
      this.mHandler = new Handler(Looper.getMainLooper());
      this.dtk = paramb;
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
          Log.d("MicroMsg.EmojiAndTextArtist", "cancel focus!");
          if (e.this.XU() == null)
          {
            AppMethodBeat.o(9153);
            return;
          }
          com.tencent.mm.z.c localc = ((d)e.this.XU()).alI();
          if ((localc != null) && (localc.gwn))
          {
            localc.setSelected(false);
            e.a.a(e.a.this).cT(false);
            e.a.a(e.a.this).Yb();
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