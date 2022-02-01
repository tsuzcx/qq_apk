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
import com.tencent.mm.ab.f;
import com.tencent.mm.api.r;
import com.tencent.mm.bv.a.c;
import com.tencent.mm.c.c.1;
import com.tencent.mm.c.c.2;
import com.tencent.mm.cache.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ax;
import java.lang.ref.WeakReference;
import java.util.ListIterator;
import java.util.Stack;

public final class e
  extends b<d>
{
  Matrix auf;
  private boolean flI;
  private boolean flJ;
  private volatile boolean flK;
  private Runnable flL;
  private Rect flM;
  private float flN;
  private float flO;
  private int flP;
  private int flQ;
  private boolean flR;
  private com.tencent.mm.c.c flS;
  public com.tencent.mm.ai.a flT;
  boolean flU;
  private final Handler mMainHandler;
  
  public e()
  {
    AppMethodBeat.i(9156);
    this.mMainHandler = new Handler(Looper.getMainLooper());
    this.flK = false;
    this.flM = new Rect();
    this.flI = false;
    this.flJ = false;
    this.flN = 0.0F;
    this.flO = 0.0F;
    this.flP = 0;
    this.flQ = 0;
    this.flR = false;
    this.flS = new com.tencent.mm.c.c(this);
    this.auf = new Matrix();
    this.flU = false;
    AppMethodBeat.o(9156);
  }
  
  private com.tencent.mm.ab.c acO()
  {
    Object localObject1 = null;
    AppMethodBeat.i(9162);
    Object localObject2 = (d)acA();
    if (localObject2 == null)
    {
      AppMethodBeat.o(9162);
      return null;
    }
    ListIterator localListIterator = ((d)localObject2).arI();
    while (localListIterator.hasPrevious())
    {
      localObject2 = (com.tencent.mm.ab.c)localListIterator.previous();
      if (((com.tencent.mm.ab.c)localObject2).jaA) {
        localObject1 = localObject2;
      }
      ((com.tencent.mm.ab.c)localObject2).setSelected(false);
    }
    AppMethodBeat.o(9162);
    return localObject1;
  }
  
  private void acP()
  {
    AppMethodBeat.i(9163);
    Log.d("MicroMsg.EmojiAndTextArtist", "[registerFocusTask]");
    if (this.flL != null) {
      this.mMainHandler.removeCallbacksAndMessages(null);
    }
    if (this.flK)
    {
      Log.w("MicroMsg.EmojiAndTextArtist", "[registerFocusTask] isTimerCancel=true");
      AppMethodBeat.o(9163);
      return;
    }
    this.flL = new a(this);
    this.mMainHandler.postDelayed(this.flL, 1500L);
    AppMethodBeat.o(9163);
  }
  
  private void acQ()
  {
    AppMethodBeat.i(9164);
    Log.d("MicroMsg.EmojiAndTextArtist", "[unRegisterFocusTask]");
    if (this.flL != null)
    {
      this.mMainHandler.removeCallbacksAndMessages(null);
      this.flL = null;
    }
    AppMethodBeat.o(9164);
  }
  
  private com.tencent.mm.ab.c z(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(9161);
    if (acA() == null)
    {
      Log.e("MicroMsg.EmojiAndTextArtist", "[isContainsItem] getCache is null!");
      AppMethodBeat.o(9161);
      return null;
    }
    ListIterator localListIterator = ((d)acA()).arI();
    com.tencent.mm.ab.c localc;
    float[] arrayOfFloat;
    do
    {
      if (!localListIterator.hasPrevious()) {
        break;
      }
      localc = (com.tencent.mm.ab.c)localListIterator.previous();
      arrayOfFloat = x(paramFloat1, paramFloat2);
    } while (!localc.B(arrayOfFloat[0], arrayOfFloat[1]));
    for (;;)
    {
      AppMethodBeat.o(9161);
      return localc;
      localc = null;
    }
  }
  
  public final void a(SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9165);
    Log.i("MicroMsg.EmojiAndTextArtist", "[addItem] text:%s", new Object[] { paramSpannableString });
    if (Util.isNullOrNil(paramSpannableString))
    {
      AppMethodBeat.o(9165);
      return;
    }
    d locald = (d)acA();
    if (locald == null)
    {
      Log.w("MicroMsg.EmojiAndTextArtist", "cache is null!");
      AppMethodBeat.o(9165);
      return;
    }
    acQ();
    acO();
    dq(false);
    Object localObject = getBoardRect();
    paramSpannableString = new f(MMApplicationContext.getContext(), getMainMatrix(), locald.ai(true), (Rect)localObject, paramSpannableString, paramInt1, paramInt2);
    paramSpannableString.setSelected(true);
    paramSpannableString.kag = true;
    localObject = x(((Rect)localObject).centerX(), ((Rect)localObject).centerY());
    paramSpannableString.a(localObject[0], localObject[1], this.fkE.getInitScale() / this.fkE.getCurScale(), (int)getRotation());
    locald.a(paramSpannableString);
    acH();
    acP();
    AppMethodBeat.o(9165);
  }
  
  public final void a(f paramf, SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9167);
    d locald = (d)acA();
    if (locald == null)
    {
      Log.w("MicroMsg.EmojiAndTextArtist", "cache is null!");
      AppMethodBeat.o(9167);
      return;
    }
    Object localObject = paramf.jZY;
    Log.i("MicroMsg.EmojiAndTextCache", "[delete] id:%s", new Object[] { localObject });
    com.tencent.mm.ab.c localc;
    if ((locald.iTF != null) && (locald.iTF.size() > 0))
    {
      localc = (com.tencent.mm.ab.c)locald.iTF.peek();
      if (!localc.jZY.equalsIgnoreCase((String)localObject)) {
        break label266;
      }
      locald.iTF.pop();
    }
    for (;;)
    {
      paramf.setSelected(true);
      paramf.kag = true;
      acQ();
      acO();
      dq(true);
      if (!Util.isNullOrNil(paramSpannableString))
      {
        localObject = getBoardRect();
        paramSpannableString = new f(MMApplicationContext.getContext(), getMainMatrix(), locald.ai(true), (Rect)localObject, paramSpannableString, paramInt1, paramInt2);
        paramSpannableString.setSelected(true);
        localObject = paramf.kab;
        paramSpannableString.a(((PointF)localObject).x, ((PointF)localObject).y, this.fkE.getInitScale() / this.fkE.getCurScale(), paramf.mRotation);
        paramSpannableString.eYO = paramf.eYO;
        locald.a(paramSpannableString);
      }
      acH();
      acP();
      AppMethodBeat.o(9167);
      return;
      label266:
      Log.e("MicroMsg.EmojiAndTextCache", "[delete] id:%s emojiItem:%s", new Object[] { localObject, localc });
    }
  }
  
  public final a acy()
  {
    return a.fkz;
  }
  
  public final void acz() {}
  
  public final void b(r paramr)
  {
    AppMethodBeat.i(9166);
    Log.i("MicroMsg.EmojiAndTextArtist", "[addEmojiItem] item:%s", new Object[] { paramr });
    d locald = (d)acA();
    if (locald == null)
    {
      Log.w("MicroMsg.EmojiAndTextArtist", "cache is null!");
      AppMethodBeat.o(9166);
      return;
    }
    acQ();
    acO();
    dq(false);
    Object localObject = getBoardRect();
    paramr = new com.tencent.mm.ab.c(MMApplicationContext.getContext(), getMainMatrix(), locald.ai(true), paramr, (Rect)localObject);
    paramr.setSelected(true);
    localObject = x(((Rect)localObject).centerX(), ((Rect)localObject).centerY());
    paramr.a(localObject[0], localObject[1], this.fkE.getInitScale() / this.fkE.getCurScale(), (int)getRotation());
    locald.a(paramr);
    acH();
    acP();
    AppMethodBeat.o(9166);
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(9157);
    super.onAlive();
    int i = (int)MMApplicationContext.getResources().getDimension(a.c.rubbish_layout_height);
    int j = (int)MMApplicationContext.getResources().getDimension(a.c.rubbish_layout_width);
    int k = ax.aB(this.fkE.hou().getContext());
    this.flM.set((getBoardRect().width() - j) / 2, getBoardRect().height() - i - k, getBoardRect().width() - k, (j + getBoardRect().width()) / 2);
    if (this.flK)
    {
      Log.i("MicroMsg.EmojiAndTextArtist", "onAlive: isTimerCancel=%s", new Object[] { Boolean.valueOf(this.flK) });
      this.mMainHandler.removeCallbacksAndMessages(null);
    }
    AppMethodBeat.o(9157);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9160);
    super.onDestroy();
    this.flK = true;
    acQ();
    this.mMainHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(9160);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9158);
    e(paramCanvas);
    Object localObject = (d)acA();
    if (localObject != null)
    {
      localObject = ((d)localObject).arH();
      if ((localObject != null) && (((com.tencent.mm.ab.c)localObject).jaA)) {
        ((com.tencent.mm.ab.c)localObject).draw(paramCanvas);
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
      bool = this.flI;
      AppMethodBeat.o(9159);
      return bool;
    case 0: 
      acQ();
      localObject1 = z(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (localObject1 == null)
      {
        this.flI = false;
        if (acA() == null) {
          bool = false;
        }
      }
      break;
    }
    while (bool)
    {
      acO();
      dq(false);
      acH();
      break;
      localObject1 = ((d)acA()).arH();
      if (localObject1 != null)
      {
        bool = ((com.tencent.mm.ab.c)localObject1).jaA;
        continue;
        bool = ((com.tencent.mm.ab.c)localObject1).kag;
        acO();
        this.flI = true;
        ((com.tencent.mm.ab.c)localObject1).setSelected(true);
        ((com.tencent.mm.ab.c)localObject1).kag = bool;
        ((com.tencent.mm.ab.c)localObject1).kad.set(((com.tencent.mm.ab.c)localObject1).kab);
        ((d)acA()).b((com.tencent.mm.ab.c)localObject1);
        dq(true);
        acH();
        break;
        if (this.flI)
        {
          this.flN = r(paramMotionEvent);
          this.flP = ((int)Math.toDegrees(Math.atan2(s(paramMotionEvent)[0], s(paramMotionEvent)[1])));
          localObject1 = ((d)acA()).arH();
          if ((localObject1 == null) || (!((com.tencent.mm.ab.c)localObject1).jaA)) {
            break;
          }
          this.flQ = ((com.tencent.mm.ab.c)localObject1).mRotation;
          this.flO = ((com.tencent.mm.ab.c)localObject1).eYO;
          break;
        }
        localObject1 = new int[2];
        if (paramMotionEvent.getPointerCount() > 1)
        {
          localObject1[0] = ((int)(paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2);
          localObject1[1] = ((int)(paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2);
        }
        localObject1 = z(localObject1[0], localObject1[1]);
        if (localObject1 == null) {
          break;
        }
        bool = ((com.tencent.mm.ab.c)localObject1).kag;
        acO();
        ((com.tencent.mm.ab.c)localObject1).kag = bool;
        this.flI = true;
        ((com.tencent.mm.ab.c)localObject1).setSelected(true);
        ((d)acA()).b((com.tencent.mm.ab.c)localObject1);
        this.flN = r(paramMotionEvent);
        this.flP = ((int)Math.toDegrees(Math.atan2(s(paramMotionEvent)[0], s(paramMotionEvent)[1])));
        if ((localObject1 != null) && (((com.tencent.mm.ab.c)localObject1).jaA))
        {
          this.flQ = ((com.tencent.mm.ab.c)localObject1).mRotation;
          this.flO = ((com.tencent.mm.ab.c)localObject1).eYO;
        }
        dq(true);
        acH();
        break;
        this.flR = true;
        break;
        if (this.flR)
        {
          this.flR = false;
          AppMethodBeat.o(9159);
          return true;
        }
        if ((!this.flI) || (!v(paramMotionEvent))) {
          break;
        }
        if ((!this.flJ) && (this.flT != null)) {
          this.flT.onShow();
        }
        localObject1 = t(paramMotionEvent);
        float f1 = 1.0F;
        int i = 0;
        if (paramMotionEvent.getPointerCount() > 1)
        {
          if (0.0F != this.flN) {
            f1 = r(paramMotionEvent) / this.flN;
          }
          i = this.flP - (int)Math.toDegrees(Math.atan2(s(paramMotionEvent)[0], s(paramMotionEvent)[1]));
        }
        for (;;)
        {
          float f2 = localObject1[0];
          float f3 = localObject1[1];
          float f4 = this.flO;
          int j = this.flQ;
          int k = paramMotionEvent.getPointerCount();
          localObject1 = ((d)acA()).arH();
          Object localObject3;
          Object localObject2;
          if (localObject1 != null)
          {
            this.auf.reset();
            this.auf.postRotate(-getRotation());
            localObject3 = this.auf;
            localObject2 = new Matrix();
            ((Matrix)localObject3).invert((Matrix)localObject2);
            localObject3 = new float[2];
            localObject3[0] = f2;
            localObject3[1] = f3;
            ((Matrix)localObject2).mapPoints((float[])localObject3);
            if (k <= 1) {
              break label890;
            }
            ((com.tencent.mm.ab.c)localObject1).b(0.0F, 0.0F, f1 * f4, (i + j) % 360);
            label777:
            ((com.tencent.mm.ab.c)localObject1).aFR();
            localObject2 = ((com.tencent.mm.ab.c)localObject1).kab;
            localObject2 = y(((PointF)localObject2).x, ((PointF)localObject2).y);
            if (this.flM.top > localObject2[1]) {
              break label922;
            }
            if (this.flT != null) {
              this.flT.at((localObject2[1] - this.flM.top) / this.flM.height());
            }
          }
          for (this.flU = true;; this.flU = false)
          {
            if ((localObject1 instanceof f)) {
              ((com.tencent.mm.ab.c)localObject1).kag = false;
            }
            this.flJ = true;
            acH();
            break;
            label890:
            ((com.tencent.mm.ab.c)localObject1).b(localObject3[0] / getScale(), localObject3[1] / getScale(), 0.0F, ((com.tencent.mm.ab.c)localObject1).mRotation);
            break label777;
            label922:
            if ((this.flT != null) && (this.flU)) {
              this.flT.aJe();
            }
          }
          if (!isAlive())
          {
            Log.e("MicroMsg.EmojiAndTextArtist", "[ACTION_UP] is not alive!");
            AppMethodBeat.o(9159);
            return false;
          }
          if (acA() == null)
          {
            Log.e("MicroMsg.EmojiAndTextArtist", "[getCache] is null!");
            AppMethodBeat.o(9159);
            return false;
          }
          localObject1 = ((d)acA()).arH();
          if (localObject1 != null)
          {
            if (!getAliveRect().contains((int)((com.tencent.mm.ab.c)localObject1).kab.x, (int)((com.tencent.mm.ab.c)localObject1).kab.y))
            {
              this.flS.eYG = true;
              localObject2 = this.flS;
              ((com.tencent.mm.c.c)localObject2).eYI = ((com.tencent.mm.ab.c)localObject1);
              ((com.tencent.mm.c.c)localObject2).eYx = (((com.tencent.mm.ab.c)localObject1).kad.x - ((com.tencent.mm.ab.c)localObject1).kab.x);
              ((com.tencent.mm.c.c)localObject2).eYy = (((com.tencent.mm.ab.c)localObject1).kad.y - ((com.tencent.mm.ab.c)localObject1).kab.y);
              ((com.tencent.mm.c.c)localObject2).eYJ = ((com.tencent.mm.ab.c)localObject1).jZY;
              localObject2 = this.flS;
              if (((com.tencent.mm.c.b)localObject2).eYG)
              {
                ((com.tencent.mm.c.c)localObject2).eYu = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("deltaY", new float[] { 0.0F, ((com.tencent.mm.c.c)localObject2).eYy }), PropertyValuesHolder.ofFloat("deltaX", new float[] { 0.0F, ((com.tencent.mm.c.c)localObject2).eYx }) });
                ((com.tencent.mm.c.c)localObject2).eYu.addUpdateListener(new c.1((com.tencent.mm.c.c)localObject2));
                ((com.tencent.mm.c.c)localObject2).eYu.addListener(new c.2((com.tencent.mm.c.c)localObject2));
                ((com.tencent.mm.c.c)localObject2).eYu.setInterpolator(new LinearInterpolator());
                ((com.tencent.mm.c.c)localObject2).eYu.setDuration(100L);
                ((com.tencent.mm.c.c)localObject2).eYu.start();
              }
            }
            if ((localObject1 instanceof f))
            {
              localObject2 = (f)localObject1;
              if ((!((com.tencent.mm.ab.c)localObject2).jaA) || (!((com.tencent.mm.ab.c)localObject2).kag)) {
                break label1451;
              }
              if (this.flT != null) {
                this.flT.a((f)localObject2);
              }
            }
          }
          for (;;)
          {
            localObject2 = ((com.tencent.mm.ab.c)localObject1).kab;
            localObject2 = y(((PointF)localObject2).x, ((PointF)localObject2).y);
            Log.i("MicroMsg.EmojiAndTextArtist", "mRubbishRect:%s pointF:%s", new Object[] { this.flM, Float.valueOf(localObject2[1]) });
            if ((((com.tencent.mm.ab.c)localObject1).jaA) && (this.flM.top <= localObject2[1]) && (this.flI) && (this.flT != null))
            {
              ((d)acA()).arG();
              acH();
            }
            acP();
            if ((this.flJ) && (this.flT != null)) {
              this.flT.onHide();
            }
            this.flJ = false;
            break;
            label1451:
            if (((com.tencent.mm.ab.c)localObject2).jaA) {
              ((com.tencent.mm.ab.c)localObject2).kag = true;
            }
          }
          f1 = 1.0F;
        }
      }
      bool = false;
    }
  }
  
  static final class a
    implements Runnable
  {
    WeakReference<? extends e> flV;
    
    public a(e parame)
    {
      AppMethodBeat.i(259752);
      this.flV = new WeakReference(parame);
      AppMethodBeat.o(259752);
    }
    
    public final void run()
    {
      AppMethodBeat.i(259753);
      Log.d("MicroMsg.EmojiAndTextArtist", "cancel focus!");
      e locale = (e)this.flV.get();
      if (locale == null)
      {
        AppMethodBeat.o(259753);
        return;
      }
      if (locale.acA() == null)
      {
        AppMethodBeat.o(259753);
        return;
      }
      com.tencent.mm.ab.c localc = ((d)locale.acA()).arH();
      if ((localc != null) && (localc.jaA))
      {
        localc.setSelected(false);
        locale.dq(false);
        locale.acH();
      }
      AppMethodBeat.o(259753);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.e.e
 * JD-Core Version:    0.7.0.1
 */