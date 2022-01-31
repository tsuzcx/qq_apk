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
import com.tencent.mm.api.j;
import com.tencent.mm.b.c.1;
import com.tencent.mm.b.c.2;
import com.tencent.mm.bo.a.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.z.c.a;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;

public final class e
  extends b<com.tencent.mm.cache.c>
{
  private boolean bAX = false;
  private TimerTask bAY;
  private Rect bAZ = new Rect();
  private boolean bAz = false;
  private float bBa = 0.0F;
  private float bBb = 0.0F;
  private int bBc = 0;
  private int bBd = 0;
  private boolean bBe = false;
  private com.tencent.mm.b.c bBf = new com.tencent.mm.b.c(this);
  public com.tencent.mm.ad.a bBg;
  boolean bBh = false;
  private Timer mTimer = new Timer();
  Matrix mW = new Matrix();
  
  private com.tencent.mm.z.c C(float paramFloat1, float paramFloat2)
  {
    com.tencent.mm.z.c localc;
    if (tI() == null)
    {
      y.e("MicroMsg.EmojiAndTextArtist", "[isContainsItem] getCache is null!");
      localc = null;
      return localc;
    }
    ListIterator localListIterator = ((com.tencent.mm.cache.c)tI()).wS();
    for (;;)
    {
      localc = null;
      if (!localListIterator.hasPrevious()) {
        break;
      }
      localc = (com.tencent.mm.z.c)localListIterator.previous();
      Object localObject = A(paramFloat1, paramFloat2);
      float f1 = localObject[0];
      float f2 = localObject[1];
      localc.dHU.clear();
      localc.dHU.add(localc.aa(localc.dHV - 180.0F));
      localc.dHU.add(localc.aa(-localc.dHV));
      localc.dHU.add(localc.aa(localc.dHV));
      localc.dHU.add(localc.aa(-localc.dHV + 180.0F));
      localObject = new c.a(localc, localc.dHU);
      int i = 0;
      int m = ((c.a)localObject).dHZ - 1;
      int j = 0;
      if (i < ((c.a)localObject).dHZ)
      {
        int k;
        if ((localObject.dHY[i] >= f2) || (localObject.dHY[m] < f2))
        {
          k = j;
          if (localObject.dHY[m] < f2)
          {
            k = j;
            if (localObject.dHY[i] < f2) {}
          }
        }
        else
        {
          float f3 = localObject.dHX[i];
          float f4 = (f2 - localObject.dHY[i]) / (localObject.dHY[m] - localObject.dHY[i]);
          k = j;
          if ((localObject.dHX[m] - localObject.dHX[i]) * f4 + f3 < f1) {
            if (j != 0) {
              break label385;
            }
          }
        }
        label385:
        for (j = 1;; j = 0)
        {
          k = j;
          m = i;
          i += 1;
          j = k;
          break;
        }
      }
      if (j != 0) {
        break;
      }
    }
  }
  
  private com.tencent.mm.z.c tX()
  {
    Object localObject = null;
    ListIterator localListIterator = ((com.tencent.mm.cache.c)tI()).wS();
    while (localListIterator.hasPrevious())
    {
      com.tencent.mm.z.c localc = (com.tencent.mm.z.c)localListIterator.previous();
      if (localc.dpc) {
        localObject = localc;
      }
      localc.setSelected(false);
    }
    return localObject;
  }
  
  private void tY()
  {
    y.d("MicroMsg.EmojiAndTextArtist", "[registerFocusTask]");
    if (this.bAY != null) {
      this.bAY.cancel();
    }
    this.bAY = new a(this);
    this.mTimer.schedule(this.bAY, 1500L);
  }
  
  private void tZ()
  {
    y.d("MicroMsg.EmojiAndTextArtist", "[unRegisterFocusTask]");
    if (this.bAY != null) {
      this.bAY.cancel();
    }
  }
  
  public final void a(SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.EmojiAndTextArtist", "[addItem] text:%s", new Object[] { paramSpannableString });
    if (bk.L(paramSpannableString)) {
      return;
    }
    tZ();
    tX();
    aS(false);
    Object localObject = getBoardRect();
    paramSpannableString = new com.tencent.mm.z.e(ae.getContext(), getMainMatrix(), ((com.tencent.mm.cache.c)tI()).bg(true), (Rect)localObject, paramSpannableString, paramInt1, paramInt2);
    paramSpannableString.setSelected(true);
    paramSpannableString.dHT = true;
    localObject = A(((Rect)localObject).centerX(), ((Rect)localObject).centerY());
    paramSpannableString.a(localObject[0], localObject[1], this.bzV.getInitScale() / this.bzV.getCurScale(), (int)getRotation());
    ((com.tencent.mm.cache.c)tI()).a(paramSpannableString);
    tQ();
    tY();
  }
  
  public final void a(com.tencent.mm.z.e parame, SpannableString paramSpannableString, int paramInt1, int paramInt2)
  {
    Object localObject = (com.tencent.mm.cache.c)tI();
    String str = parame.dHK;
    y.i("MicroMsg.EmojiAndTextCache", "[delete] id:%s", new Object[] { str });
    com.tencent.mm.z.c localc;
    if ((((com.tencent.mm.cache.c)localObject).dkW != null) && (((com.tencent.mm.cache.c)localObject).dkW.size() > 0))
    {
      localc = (com.tencent.mm.z.c)((com.tencent.mm.cache.c)localObject).dkW.peek();
      if (!localc.dHK.equalsIgnoreCase(str)) {
        break label245;
      }
      ((com.tencent.mm.cache.c)localObject).dkW.pop();
    }
    for (;;)
    {
      parame.setSelected(true);
      parame.dHT = true;
      tZ();
      tX();
      aS(true);
      if (!bk.L(paramSpannableString))
      {
        localObject = getBoardRect();
        paramSpannableString = new com.tencent.mm.z.e(ae.getContext(), getMainMatrix(), ((com.tencent.mm.cache.c)tI()).bg(true), (Rect)localObject, paramSpannableString, paramInt1, paramInt2);
        paramSpannableString.setSelected(true);
        localObject = parame.dHN;
        paramSpannableString.a(((PointF)localObject).x, ((PointF)localObject).y, this.bzV.getInitScale() / this.bzV.getCurScale(), parame.dHO);
        paramSpannableString.mScale = parame.mScale;
        ((com.tencent.mm.cache.c)tI()).a(paramSpannableString);
      }
      tQ();
      tY();
      return;
      label245:
      y.e("MicroMsg.EmojiAndTextCache", "[delete] id:%s emojiItem:%s", new Object[] { str, localc });
    }
  }
  
  public final void b(j paramj)
  {
    y.i("MicroMsg.EmojiAndTextArtist", "[addEmojiItem] item:%s", new Object[] { paramj });
    tZ();
    tX();
    aS(false);
    Object localObject = getBoardRect();
    paramj = new com.tencent.mm.z.c(ae.getContext(), getMainMatrix(), ((com.tencent.mm.cache.c)tI()).bg(true), paramj, (Rect)localObject);
    paramj.setSelected(true);
    localObject = A(((Rect)localObject).centerX(), ((Rect)localObject).centerY());
    paramj.a(localObject[0], localObject[1], this.bzV.getInitScale() / this.bzV.getCurScale(), (int)getRotation());
    ((com.tencent.mm.cache.c)tI()).a(paramj);
    tQ();
    tY();
  }
  
  public final boolean m(MotionEvent paramMotionEvent)
  {
    Object localObject1;
    switch (paramMotionEvent.getActionMasked())
    {
    case 3: 
    case 4: 
    default: 
      super.m(paramMotionEvent);
      return this.bAX;
    case 0: 
      tZ();
      localObject1 = C(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (localObject1 == null)
      {
        this.bAX = false;
        localObject1 = ((com.tencent.mm.cache.c)tI()).wR();
        if (localObject1 == null) {
          break label1445;
        }
      }
      break;
    }
    label775:
    label920:
    label1445:
    for (boolean bool = ((com.tencent.mm.z.c)localObject1).dpc; bool; bool = false)
    {
      tX();
      aS(false);
      tQ();
      break;
      bool = ((com.tencent.mm.z.c)localObject1).dHT;
      tX();
      this.bAX = true;
      ((com.tencent.mm.z.c)localObject1).setSelected(true);
      ((com.tencent.mm.z.c)localObject1).dHT = bool;
      ((com.tencent.mm.z.c)localObject1).dHQ.set(((com.tencent.mm.z.c)localObject1).dHN);
      ((com.tencent.mm.cache.c)tI()).b((com.tencent.mm.z.c)localObject1);
      aS(true);
      tQ();
      break;
      if (this.bAX)
      {
        this.bBa = n(paramMotionEvent);
        this.bBc = ((int)Math.toDegrees(Math.atan2(o(paramMotionEvent)[0], o(paramMotionEvent)[1])));
        localObject1 = ((com.tencent.mm.cache.c)tI()).wR();
        if ((localObject1 == null) || (!((com.tencent.mm.z.c)localObject1).dpc)) {
          break;
        }
        this.bBd = ((com.tencent.mm.z.c)localObject1).dHO;
        this.bBb = ((com.tencent.mm.z.c)localObject1).mScale;
        break;
      }
      localObject1 = new int[2];
      if (paramMotionEvent.getPointerCount() > 1)
      {
        localObject1[0] = ((int)(paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2);
        localObject1[1] = ((int)(paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2);
      }
      localObject1 = C(localObject1[0], localObject1[1]);
      if (localObject1 == null) {
        break;
      }
      bool = ((com.tencent.mm.z.c)localObject1).dHT;
      tX();
      ((com.tencent.mm.z.c)localObject1).dHT = bool;
      this.bAX = true;
      ((com.tencent.mm.z.c)localObject1).setSelected(true);
      ((com.tencent.mm.cache.c)tI()).b((com.tencent.mm.z.c)localObject1);
      this.bBa = n(paramMotionEvent);
      this.bBc = ((int)Math.toDegrees(Math.atan2(o(paramMotionEvent)[0], o(paramMotionEvent)[1])));
      if ((localObject1 != null) && (((com.tencent.mm.z.c)localObject1).dpc))
      {
        this.bBd = ((com.tencent.mm.z.c)localObject1).dHO;
        this.bBb = ((com.tencent.mm.z.c)localObject1).mScale;
      }
      aS(true);
      tQ();
      break;
      this.bBe = true;
      break;
      if (this.bBe)
      {
        this.bBe = false;
        return true;
      }
      if ((!this.bAX) || (!q(paramMotionEvent))) {
        break;
      }
      if ((!this.bAz) && (this.bBg != null)) {
        this.bBg.onShow();
      }
      localObject1 = new int[2];
      localObject1[0] = ((int)(paramMotionEvent.getX(0) - this.bAd.x));
      localObject1[1] = ((int)(paramMotionEvent.getY(0) - this.bAd.y));
      float f1 = 1.0F;
      int i;
      if (paramMotionEvent.getPointerCount() > 1)
      {
        if (0.0F != this.bBa) {
          f1 = n(paramMotionEvent) / this.bBa;
        }
        i = this.bBc - (int)Math.toDegrees(Math.atan2(o(paramMotionEvent)[0], o(paramMotionEvent)[1]));
      }
      for (;;)
      {
        float f2 = localObject1[0];
        float f3 = localObject1[1];
        float f4 = this.bBb;
        int j = this.bBd;
        int k = paramMotionEvent.getPointerCount();
        localObject1 = ((com.tencent.mm.cache.c)tI()).wR();
        Object localObject3;
        Object localObject2;
        if (localObject1 != null)
        {
          this.mW.reset();
          this.mW.postRotate(-getRotation());
          localObject3 = this.mW;
          localObject2 = new Matrix();
          ((Matrix)localObject3).invert((Matrix)localObject2);
          localObject3 = new float[2];
          localObject3[0] = f2;
          localObject3[1] = f3;
          ((Matrix)localObject2).mapPoints((float[])localObject3);
          if (k <= 1) {
            break label888;
          }
          ((com.tencent.mm.z.c)localObject1).b(0.0F, 0.0F, f1 * f4, (i + j) % 360);
          ((com.tencent.mm.z.c)localObject1).Cm();
          localObject2 = ((com.tencent.mm.z.c)localObject1).dHN;
          localObject2 = B(((PointF)localObject2).x, ((PointF)localObject2).y);
          if (this.bAZ.top > localObject2[1]) {
            break label920;
          }
          if (this.bBg != null) {
            this.bBg.ac((localObject2[1] - this.bAZ.top) / this.bAZ.height());
          }
        }
        for (this.bBh = true;; this.bBh = false)
        {
          if ((localObject1 instanceof com.tencent.mm.z.e)) {
            ((com.tencent.mm.z.c)localObject1).dHT = false;
          }
          this.bAz = true;
          tQ();
          break;
          label888:
          ((com.tencent.mm.z.c)localObject1).b(localObject3[0] / getScale(), localObject3[1] / getScale(), 0.0F, ((com.tencent.mm.z.c)localObject1).dHO);
          break label775;
          if ((this.bBg != null) && (this.bBh)) {
            this.bBg.EN();
          }
        }
        if (!isAlive())
        {
          y.e("MicroMsg.EmojiAndTextArtist", "[ACTION_UP] is not alive!");
          return false;
        }
        localObject1 = ((com.tencent.mm.cache.c)tI()).wR();
        if (localObject1 != null)
        {
          if (!this.bzX.contains((int)((com.tencent.mm.z.c)localObject1).dHN.x, (int)((com.tencent.mm.z.c)localObject1).dHN.y))
          {
            this.bBf.bur = true;
            localObject2 = this.bBf;
            ((com.tencent.mm.b.c)localObject2).buu = ((com.tencent.mm.z.c)localObject1);
            ((com.tencent.mm.b.c)localObject2).bui = (((com.tencent.mm.z.c)localObject1).dHQ.x - ((com.tencent.mm.z.c)localObject1).dHN.x);
            ((com.tencent.mm.b.c)localObject2).buj = (((com.tencent.mm.z.c)localObject1).dHQ.y - ((com.tencent.mm.z.c)localObject1).dHN.y);
            ((com.tencent.mm.b.c)localObject2).buv = ((com.tencent.mm.z.c)localObject1).dHK;
            localObject2 = this.bBf;
            if (((com.tencent.mm.b.b)localObject2).bur)
            {
              ((com.tencent.mm.b.c)localObject2).jQ = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("deltaY", new float[] { 0.0F, ((com.tencent.mm.b.c)localObject2).buj }), PropertyValuesHolder.ofFloat("deltaX", new float[] { 0.0F, ((com.tencent.mm.b.c)localObject2).bui }) });
              ((com.tencent.mm.b.c)localObject2).jQ.addUpdateListener(new c.1((com.tencent.mm.b.c)localObject2));
              ((com.tencent.mm.b.c)localObject2).jQ.addListener(new c.2((com.tencent.mm.b.c)localObject2));
              ((com.tencent.mm.b.c)localObject2).jQ.setInterpolator(new LinearInterpolator());
              ((com.tencent.mm.b.c)localObject2).jQ.setDuration(100L);
              ((com.tencent.mm.b.c)localObject2).jQ.start();
            }
          }
          if ((localObject1 instanceof com.tencent.mm.z.e))
          {
            localObject2 = (com.tencent.mm.z.e)localObject1;
            if ((!((com.tencent.mm.z.c)localObject2).dpc) || (!((com.tencent.mm.z.c)localObject2).dHT)) {
              break label1420;
            }
            if (this.bBg != null) {
              this.bBg.a((com.tencent.mm.z.e)localObject2);
            }
          }
        }
        for (;;)
        {
          localObject2 = ((com.tencent.mm.z.c)localObject1).dHN;
          localObject2 = B(((PointF)localObject2).x, ((PointF)localObject2).y);
          y.i("MicroMsg.EmojiAndTextArtist", "mRubbishRect:%s pointF:%s", new Object[] { this.bAZ, Float.valueOf(localObject2[1]) });
          if ((((com.tencent.mm.z.c)localObject1).dpc) && (this.bAZ.top <= localObject2[1]) && (this.bAX) && (this.bBg != null))
          {
            ((com.tencent.mm.cache.c)tI()).wQ();
            tQ();
          }
          tY();
          if ((this.bAz) && (this.bBg != null)) {
            this.bBg.onHide();
          }
          this.bAz = false;
          break;
          if (((com.tencent.mm.z.c)localObject2).dpc) {
            ((com.tencent.mm.z.c)localObject2).dHT = true;
          }
        }
        i = 0;
        f1 = 1.0F;
      }
    }
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    tZ();
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    b(paramCanvas);
    com.tencent.mm.z.c localc = ((com.tencent.mm.cache.c)tI()).wR();
    if ((localc != null) && (localc.dpc)) {
      localc.draw(paramCanvas);
    }
  }
  
  public final a tG()
  {
    return a.bzR;
  }
  
  public final void tH() {}
  
  public final void tJ()
  {
    super.tJ();
    int i = (int)ae.getResources().getDimension(a.c.rubbish_layout_height);
    this.bAZ.set(0, getBoardRect().height() - i, getBoardRect().width(), getBoardRect().height());
  }
  
  final class a
    extends TimerTask
  {
    private b bBi;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    
    public a(b paramb)
    {
      this.bBi = paramb;
    }
    
    public final void run()
    {
      this.mHandler.post(new e.a.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.e.e
 * JD-Core Version:    0.7.0.1
 */