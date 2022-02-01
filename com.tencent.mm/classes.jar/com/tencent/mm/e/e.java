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
import com.tencent.mm.api.t;
import com.tencent.mm.bo.a.c;
import com.tencent.mm.c.c.1;
import com.tencent.mm.c.c.2;
import com.tencent.mm.cache.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bf;
import java.lang.ref.WeakReference;
import java.util.ListIterator;
import java.util.Stack;

public final class e
  extends b<d>
{
  Matrix ciC;
  private boolean hpV;
  private boolean hpW;
  private volatile boolean hpX;
  private Runnable hpY;
  private Rect hpZ;
  private float hqa;
  private float hqb;
  private int hqc;
  private int hqd;
  private boolean hqe;
  private com.tencent.mm.c.c hqf;
  public com.tencent.mm.ai.a hqg;
  boolean hqh;
  private final Handler mMainHandler;
  
  public e()
  {
    AppMethodBeat.i(9156);
    this.mMainHandler = new Handler(Looper.getMainLooper());
    this.hpX = false;
    this.hpZ = new Rect();
    this.hpV = false;
    this.hpW = false;
    this.hqa = 0.0F;
    this.hqb = 0.0F;
    this.hqc = 0;
    this.hqd = 0;
    this.hqe = false;
    this.hqf = new com.tencent.mm.c.c(this);
    this.ciC = new Matrix();
    this.hqh = false;
    AppMethodBeat.o(9156);
  }
  
  private com.tencent.mm.ab.c aEO()
  {
    Object localObject1 = null;
    AppMethodBeat.i(9162);
    Object localObject2 = (d)aEA();
    if (localObject2 == null)
    {
      AppMethodBeat.o(9162);
      return null;
    }
    ListIterator localListIterator = ((d)localObject2).aLE();
    while (localListIterator.hasPrevious())
    {
      localObject2 = (com.tencent.mm.ab.c)localListIterator.previous();
      if (((com.tencent.mm.ab.c)localObject2).lCv) {
        localObject1 = localObject2;
      }
      ((com.tencent.mm.ab.c)localObject2).setSelected(false);
    }
    AppMethodBeat.o(9162);
    return localObject1;
  }
  
  private void aEP()
  {
    AppMethodBeat.i(9163);
    Log.d("MicroMsg.EmojiAndTextArtist", "[registerFocusTask]");
    if (this.hpY != null) {
      this.mMainHandler.removeCallbacksAndMessages(null);
    }
    if (this.hpX)
    {
      Log.w("MicroMsg.EmojiAndTextArtist", "[registerFocusTask] isTimerCancel=true");
      AppMethodBeat.o(9163);
      return;
    }
    this.hpY = new a(this);
    this.mMainHandler.postDelayed(this.hpY, 1500L);
    AppMethodBeat.o(9163);
  }
  
  private void aEQ()
  {
    AppMethodBeat.i(9164);
    Log.d("MicroMsg.EmojiAndTextArtist", "[unRegisterFocusTask]");
    if (this.hpY != null)
    {
      this.mMainHandler.removeCallbacksAndMessages(null);
      this.hpY = null;
    }
    AppMethodBeat.o(9164);
  }
  
  private com.tencent.mm.ab.c af(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(9161);
    if (aEA() == null)
    {
      Log.e("MicroMsg.EmojiAndTextArtist", "[isContainsItem] getCache is null!");
      AppMethodBeat.o(9161);
      return null;
    }
    ListIterator localListIterator = ((d)aEA()).aLE();
    com.tencent.mm.ab.c localc;
    float[] arrayOfFloat;
    do
    {
      if (!localListIterator.hasPrevious()) {
        break;
      }
      localc = (com.tencent.mm.ab.c)localListIterator.previous();
      arrayOfFloat = ad(paramFloat1, paramFloat2);
    } while (!localc.ah(arrayOfFloat[0], arrayOfFloat[1]));
    for (;;)
    {
      AppMethodBeat.o(9161);
      return localc;
      localc = null;
    }
  }
  
  public final void a(SpannableString paramSpannableString, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(231884);
    Log.i("MicroMsg.EmojiAndTextArtist", "[addItem] text:%s", new Object[] { paramSpannableString });
    if (Util.isNullOrNil(paramSpannableString))
    {
      AppMethodBeat.o(231884);
      return;
    }
    d locald = (d)aEA();
    if (locald == null)
    {
      Log.w("MicroMsg.EmojiAndTextArtist", "cache is null!");
      AppMethodBeat.o(231884);
      return;
    }
    aEQ();
    aEO();
    ec(false);
    Rect localRect = getBoardRect();
    paramSpannableString = new f(MMApplicationContext.getContext(), getMainMatrix(), locald.aR(true), localRect, paramSpannableString, paramInt1, paramInt2, paramString);
    paramSpannableString.setSelected(true);
    paramSpannableString.mAj = true;
    paramString = ad(localRect.centerX(), localRect.centerY());
    paramSpannableString.a(paramString[0], paramString[1], this.hoR.getInitScale() / this.hoR.getCurScale(), (int)getRotation());
    locald.a(paramSpannableString);
    aEH();
    aEP();
    AppMethodBeat.o(231884);
  }
  
  public final void a(f paramf, SpannableString paramSpannableString, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(231890);
    d locald = (d)aEA();
    if (locald == null)
    {
      Log.w("MicroMsg.EmojiAndTextArtist", "cache is null!");
      AppMethodBeat.o(231890);
      return;
    }
    Object localObject = paramf.mAb;
    Log.i("MicroMsg.EmojiAndTextCache", "[delete] id:%s", new Object[] { localObject });
    com.tencent.mm.ab.c localc;
    if ((locald.lvL != null) && (locald.lvL.size() > 0))
    {
      localc = (com.tencent.mm.ab.c)locald.lvL.peek();
      if (!localc.mAb.equalsIgnoreCase((String)localObject)) {
        break label268;
      }
      locald.lvL.pop();
    }
    for (;;)
    {
      paramf.setSelected(true);
      paramf.mAj = true;
      aEQ();
      aEO();
      ec(true);
      if (!Util.isNullOrNil(paramSpannableString))
      {
        localObject = getBoardRect();
        paramSpannableString = new f(MMApplicationContext.getContext(), getMainMatrix(), locald.aR(true), (Rect)localObject, paramSpannableString, paramInt1, paramInt2, paramString);
        paramSpannableString.setSelected(true);
        paramString = paramf.mAe;
        paramSpannableString.a(paramString.x, paramString.y, this.hoR.getInitScale() / this.hoR.getCurScale(), paramf.mRotation);
        paramSpannableString.hco = paramf.hco;
        locald.a(paramSpannableString);
      }
      aEH();
      aEP();
      AppMethodBeat.o(231890);
      return;
      label268:
      Log.e("MicroMsg.EmojiAndTextCache", "[delete] id:%s emojiItem:%s", new Object[] { localObject, localc });
    }
  }
  
  public final a aEy()
  {
    return a.hoM;
  }
  
  public final void aEz() {}
  
  public final void b(t paramt)
  {
    AppMethodBeat.i(9166);
    Log.i("MicroMsg.EmojiAndTextArtist", "[addEmojiItem] item:%s", new Object[] { paramt });
    d locald = (d)aEA();
    if (locald == null)
    {
      Log.w("MicroMsg.EmojiAndTextArtist", "cache is null!");
      AppMethodBeat.o(9166);
      return;
    }
    aEQ();
    aEO();
    ec(false);
    Object localObject = getBoardRect();
    paramt = new com.tencent.mm.ab.c(MMApplicationContext.getContext(), getMainMatrix(), locald.aR(true), paramt, (Rect)localObject);
    paramt.setSelected(true);
    localObject = ad(((Rect)localObject).centerX(), ((Rect)localObject).centerY());
    paramt.a(localObject[0], localObject[1], this.hoR.getInitScale() / this.hoR.getCurScale(), (int)getRotation());
    locald.a(paramt);
    aEH();
    aEP();
    AppMethodBeat.o(9166);
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(9157);
    super.onAlive();
    int i = (int)MMApplicationContext.getResources().getDimension(a.c.rubbish_layout_height);
    int j = (int)MMApplicationContext.getResources().getDimension(a.c.rubbish_layout_width);
    int k = bf.bk(this.hoR.iPo().getContext());
    this.hpZ.set((getBoardRect().width() - j) / 2, getBoardRect().height() - i - k, getBoardRect().width() - k, (j + getBoardRect().width()) / 2);
    if (this.hpX)
    {
      Log.i("MicroMsg.EmojiAndTextArtist", "onAlive: isTimerCancel=%s", new Object[] { Boolean.valueOf(this.hpX) });
      this.mMainHandler.removeCallbacksAndMessages(null);
    }
    AppMethodBeat.o(9157);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9160);
    super.onDestroy();
    this.hpX = true;
    aEQ();
    this.mMainHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(9160);
  }
  
  public final boolean onDispatchTouch(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9159);
    boolean bool;
    Object localObject1;
    switch (paramMotionEvent.getActionMasked())
    {
    case 3: 
    case 4: 
    default: 
      super.onDispatchTouch(paramMotionEvent);
      bool = this.hpV;
      AppMethodBeat.o(9159);
      return bool;
    case 0: 
      aEQ();
      localObject1 = af(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (localObject1 == null)
      {
        this.hpV = false;
        if (aEA() == null) {
          bool = false;
        }
      }
      break;
    }
    while (bool)
    {
      aEO();
      ec(false);
      aEH();
      break;
      localObject1 = ((d)aEA()).aLD();
      if (localObject1 != null)
      {
        bool = ((com.tencent.mm.ab.c)localObject1).lCv;
        continue;
        bool = ((com.tencent.mm.ab.c)localObject1).mAj;
        aEO();
        this.hpV = true;
        ((com.tencent.mm.ab.c)localObject1).setSelected(true);
        ((com.tencent.mm.ab.c)localObject1).mAj = bool;
        ((com.tencent.mm.ab.c)localObject1).mAg.set(((com.tencent.mm.ab.c)localObject1).mAe);
        ((d)aEA()).b((com.tencent.mm.ab.c)localObject1);
        ec(true);
        aEH();
        break;
        if (this.hpV)
        {
          this.hqa = q(paramMotionEvent);
          this.hqc = ((int)Math.toDegrees(Math.atan2(r(paramMotionEvent)[0], r(paramMotionEvent)[1])));
          localObject1 = ((d)aEA()).aLD();
          if ((localObject1 == null) || (!((com.tencent.mm.ab.c)localObject1).lCv)) {
            break;
          }
          this.hqd = ((com.tencent.mm.ab.c)localObject1).mRotation;
          this.hqb = ((com.tencent.mm.ab.c)localObject1).hco;
          break;
        }
        localObject1 = new int[2];
        if (paramMotionEvent.getPointerCount() > 1)
        {
          localObject1[0] = ((int)(paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2);
          localObject1[1] = ((int)(paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2);
        }
        localObject1 = af(localObject1[0], localObject1[1]);
        if (localObject1 == null) {
          break;
        }
        bool = ((com.tencent.mm.ab.c)localObject1).mAj;
        aEO();
        ((com.tencent.mm.ab.c)localObject1).mAj = bool;
        this.hpV = true;
        ((com.tencent.mm.ab.c)localObject1).setSelected(true);
        ((d)aEA()).b((com.tencent.mm.ab.c)localObject1);
        this.hqa = q(paramMotionEvent);
        this.hqc = ((int)Math.toDegrees(Math.atan2(r(paramMotionEvent)[0], r(paramMotionEvent)[1])));
        if ((localObject1 != null) && (((com.tencent.mm.ab.c)localObject1).lCv))
        {
          this.hqd = ((com.tencent.mm.ab.c)localObject1).mRotation;
          this.hqb = ((com.tencent.mm.ab.c)localObject1).hco;
        }
        ec(true);
        aEH();
        break;
        this.hqe = true;
        break;
        if (this.hqe)
        {
          this.hqe = false;
          AppMethodBeat.o(9159);
          return true;
        }
        if ((!this.hpV) || (!u(paramMotionEvent))) {
          break;
        }
        if ((!this.hpW) && (this.hqg != null)) {
          this.hqg.onShow();
        }
        localObject1 = s(paramMotionEvent);
        float f1 = 1.0F;
        int i = 0;
        if (paramMotionEvent.getPointerCount() > 1)
        {
          if (0.0F != this.hqa) {
            f1 = q(paramMotionEvent) / this.hqa;
          }
          i = this.hqc - (int)Math.toDegrees(Math.atan2(r(paramMotionEvent)[0], r(paramMotionEvent)[1]));
        }
        for (;;)
        {
          float f2 = localObject1[0];
          float f3 = localObject1[1];
          float f4 = this.hqb;
          int j = this.hqd;
          int k = paramMotionEvent.getPointerCount();
          localObject1 = ((d)aEA()).aLD();
          Object localObject3;
          Object localObject2;
          if (localObject1 != null)
          {
            this.ciC.reset();
            this.ciC.postRotate(-getRotation());
            localObject3 = this.ciC;
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
            ((com.tencent.mm.ab.c)localObject1).aYR();
            localObject2 = ((com.tencent.mm.ab.c)localObject1).mAe;
            localObject2 = ae(((PointF)localObject2).x, ((PointF)localObject2).y);
            if (this.hpZ.top > localObject2[1]) {
              break label922;
            }
            if (this.hqg != null) {
              this.hqg.bo((localObject2[1] - this.hpZ.top) / this.hpZ.height());
            }
          }
          for (this.hqh = true;; this.hqh = false)
          {
            if ((localObject1 instanceof f)) {
              ((com.tencent.mm.ab.c)localObject1).mAj = false;
            }
            this.hpW = true;
            aEH();
            break;
            label890:
            ((com.tencent.mm.ab.c)localObject1).b(localObject3[0] / getScale(), localObject3[1] / getScale(), 0.0F, ((com.tencent.mm.ab.c)localObject1).mRotation);
            break label777;
            label922:
            if ((this.hqg != null) && (this.hqh)) {
              this.hqg.bcb();
            }
          }
          if (!isAlive())
          {
            Log.e("MicroMsg.EmojiAndTextArtist", "[ACTION_UP] is not alive!");
            AppMethodBeat.o(9159);
            return false;
          }
          if (aEA() == null)
          {
            Log.e("MicroMsg.EmojiAndTextArtist", "[getCache] is null!");
            AppMethodBeat.o(9159);
            return false;
          }
          localObject1 = ((d)aEA()).aLD();
          if (localObject1 != null)
          {
            if (!getAliveRect().contains((int)((com.tencent.mm.ab.c)localObject1).mAe.x, (int)((com.tencent.mm.ab.c)localObject1).mAe.y))
            {
              this.hqf.hcg = true;
              localObject2 = this.hqf;
              ((com.tencent.mm.c.c)localObject2).hci = ((com.tencent.mm.ab.c)localObject1);
              ((com.tencent.mm.c.c)localObject2).hbX = (((com.tencent.mm.ab.c)localObject1).mAg.x - ((com.tencent.mm.ab.c)localObject1).mAe.x);
              ((com.tencent.mm.c.c)localObject2).hbY = (((com.tencent.mm.ab.c)localObject1).mAg.y - ((com.tencent.mm.ab.c)localObject1).mAe.y);
              ((com.tencent.mm.c.c)localObject2).hcj = ((com.tencent.mm.ab.c)localObject1).mAb;
              localObject2 = this.hqf;
              if (((com.tencent.mm.c.b)localObject2).hcg)
              {
                ((com.tencent.mm.c.c)localObject2).hbU = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("deltaY", new float[] { 0.0F, ((com.tencent.mm.c.c)localObject2).hbY }), PropertyValuesHolder.ofFloat("deltaX", new float[] { 0.0F, ((com.tencent.mm.c.c)localObject2).hbX }) });
                ((com.tencent.mm.c.c)localObject2).hbU.addUpdateListener(new c.1((com.tencent.mm.c.c)localObject2));
                ((com.tencent.mm.c.c)localObject2).hbU.addListener(new c.2((com.tencent.mm.c.c)localObject2));
                ((com.tencent.mm.c.c)localObject2).hbU.setInterpolator(new LinearInterpolator());
                ((com.tencent.mm.c.c)localObject2).hbU.setDuration(100L);
                ((com.tencent.mm.c.c)localObject2).hbU.start();
              }
            }
            if ((localObject1 instanceof f))
            {
              localObject2 = (f)localObject1;
              if ((!((com.tencent.mm.ab.c)localObject2).lCv) || (!((com.tencent.mm.ab.c)localObject2).mAj)) {
                break label1451;
              }
              if (this.hqg != null) {
                this.hqg.a((f)localObject2);
              }
            }
          }
          for (;;)
          {
            localObject2 = ((com.tencent.mm.ab.c)localObject1).mAe;
            localObject2 = ae(((PointF)localObject2).x, ((PointF)localObject2).y);
            Log.i("MicroMsg.EmojiAndTextArtist", "mRubbishRect:%s pointF:%s", new Object[] { this.hpZ, Float.valueOf(localObject2[1]) });
            if ((((com.tencent.mm.ab.c)localObject1).lCv) && (this.hpZ.top <= localObject2[1]) && (this.hpV) && (this.hqg != null))
            {
              ((d)aEA()).aLC();
              aEH();
            }
            aEP();
            if ((this.hpW) && (this.hqg != null)) {
              this.hqg.onHide();
            }
            this.hpW = false;
            break;
            label1451:
            if (((com.tencent.mm.ab.c)localObject2).lCv) {
              ((com.tencent.mm.ab.c)localObject2).mAj = true;
            }
          }
          f1 = 1.0F;
        }
      }
      bool = false;
    }
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9158);
    h(paramCanvas);
    Object localObject = (d)aEA();
    if (localObject != null)
    {
      localObject = ((d)localObject).aLD();
      if ((localObject != null) && (((com.tencent.mm.ab.c)localObject).lCv)) {
        ((com.tencent.mm.ab.c)localObject).draw(paramCanvas);
      }
    }
    AppMethodBeat.o(9158);
  }
  
  static final class a
    implements Runnable
  {
    WeakReference<? extends e> hqi;
    
    public a(e parame)
    {
      AppMethodBeat.i(231838);
      this.hqi = new WeakReference(parame);
      AppMethodBeat.o(231838);
    }
    
    public final void run()
    {
      AppMethodBeat.i(231844);
      Log.d("MicroMsg.EmojiAndTextArtist", "cancel focus!");
      e locale = (e)this.hqi.get();
      if (locale == null)
      {
        AppMethodBeat.o(231844);
        return;
      }
      if (locale.aEA() == null)
      {
        AppMethodBeat.o(231844);
        return;
      }
      com.tencent.mm.ab.c localc = ((d)locale.aEA()).aLD();
      if ((localc != null) && (localc.lCv))
      {
        localc.setSelected(false);
        locale.ec(false);
        locale.aEH();
      }
      AppMethodBeat.o(231844);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.e.e
 * JD-Core Version:    0.7.0.1
 */