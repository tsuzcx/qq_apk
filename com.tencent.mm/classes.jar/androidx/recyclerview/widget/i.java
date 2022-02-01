package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i
  extends RecyclerView.h
  implements RecyclerView.k
{
  private static final int[] xo = { 16842919 };
  private static final int[] xr = new int[0];
  final Drawable bVA;
  private final int bVB;
  private final int bVC;
  private final StateListDrawable bVD;
  private final Drawable bVE;
  private final int bVF;
  private final int bVG;
  int bVH;
  int bVI;
  float bVJ;
  int bVK;
  int bVL;
  float bVM;
  int bVN;
  int bVO;
  boolean bVP;
  boolean bVQ;
  private final int[] bVR;
  private final int[] bVS;
  final ValueAnimator bVT;
  int bVU;
  private final RecyclerView.l bVV;
  final int bVy;
  final StateListDrawable bVz;
  private final int bhE;
  private int bxy;
  private final Runnable mHideRunnable;
  RecyclerView mRecyclerView;
  int mState;
  
  i(RecyclerView paramRecyclerView, StateListDrawable paramStateListDrawable1, Drawable paramDrawable1, StateListDrawable paramStateListDrawable2, Drawable paramDrawable2, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(194801);
    this.bVN = 0;
    this.bVO = 0;
    this.bVP = false;
    this.bVQ = false;
    this.mState = 0;
    this.bxy = 0;
    this.bVR = new int[2];
    this.bVS = new int[2];
    this.bVT = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.bVU = 0;
    this.mHideRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195038);
        i locali = i.this;
        switch (locali.bVU)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(195038);
          return;
          locali.bVT.cancel();
          locali.bVU = 3;
          locali.bVT.setFloatValues(new float[] { ((Float)locali.bVT.getAnimatedValue()).floatValue(), 0.0F });
          locali.bVT.setDuration(500L);
          locali.bVT.start();
        }
      }
    };
    this.bVV = new RecyclerView.l()
    {
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(195032);
        i locali = i.this;
        paramAnonymousInt1 = paramAnonymousRecyclerView.computeHorizontalScrollOffset();
        paramAnonymousInt2 = paramAnonymousRecyclerView.computeVerticalScrollOffset();
        int i = locali.mRecyclerView.computeVerticalScrollRange();
        int j = locali.bVO;
        int k;
        int m;
        if ((i - j > 0) && (locali.bVO >= locali.bVy))
        {
          bool = true;
          locali.bVP = bool;
          k = locali.mRecyclerView.computeHorizontalScrollRange();
          m = locali.bVN;
          if ((k - m <= 0) || (locali.bVN < locali.bVy)) {
            break label159;
          }
        }
        label159:
        for (boolean bool = true;; bool = false)
        {
          locali.bVQ = bool;
          if ((locali.bVP) || (locali.bVQ)) {
            break label165;
          }
          if (locali.mState != 0) {
            locali.setState(0);
          }
          AppMethodBeat.o(195032);
          return;
          bool = false;
          break;
        }
        label165:
        if (locali.bVP)
        {
          locali.bVI = ((int)((paramAnonymousInt2 + j / 2.0F) * j / i));
          locali.bVH = Math.min(j, j * j / i);
        }
        if (locali.bVQ)
        {
          locali.bVL = ((int)((paramAnonymousInt1 + m / 2.0F) * m / k));
          locali.bVK = Math.min(m, m * m / k);
        }
        if ((locali.mState == 0) || (locali.mState == 1)) {
          locali.setState(1);
        }
        AppMethodBeat.o(195032);
      }
    };
    this.bVz = paramStateListDrawable1;
    this.bVA = paramDrawable1;
    this.bVD = paramStateListDrawable2;
    this.bVE = paramDrawable2;
    this.bVB = Math.max(paramInt1, paramStateListDrawable1.getIntrinsicWidth());
    this.bVC = Math.max(paramInt1, paramDrawable1.getIntrinsicWidth());
    this.bVF = Math.max(paramInt1, paramStateListDrawable2.getIntrinsicWidth());
    this.bVG = Math.max(paramInt1, paramDrawable2.getIntrinsicWidth());
    this.bVy = paramInt2;
    this.bhE = paramInt3;
    this.bVz.setAlpha(255);
    this.bVA.setAlpha(255);
    this.bVT.addListener(new a());
    this.bVT.addUpdateListener(new b());
    if (this.mRecyclerView != paramRecyclerView)
    {
      if (this.mRecyclerView != null)
      {
        this.mRecyclerView.b(this);
        this.mRecyclerView.b(this);
        this.mRecyclerView.b(this.bVV);
        Jb();
      }
      this.mRecyclerView = paramRecyclerView;
      if (this.mRecyclerView != null)
      {
        this.mRecyclerView.a(this);
        this.mRecyclerView.a(this);
        this.mRecyclerView.a(this.bVV);
      }
    }
    AppMethodBeat.o(194801);
  }
  
  private boolean Ja()
  {
    AppMethodBeat.i(194812);
    if (z.U(this.mRecyclerView) == 1)
    {
      AppMethodBeat.o(194812);
      return true;
    }
    AppMethodBeat.o(194812);
    return false;
  }
  
  private void Jb()
  {
    AppMethodBeat.i(194833);
    this.mRecyclerView.removeCallbacks(this.mHideRunnable);
    AppMethodBeat.o(194833);
  }
  
  private boolean O(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(194856);
    if (Ja())
    {
      if (paramFloat1 > this.bVB / 2) {}
    }
    else {
      while (paramFloat1 >= this.bVN - this.bVB)
      {
        if ((paramFloat2 < this.bVI - this.bVH / 2) || (paramFloat2 > this.bVI + this.bVH / 2)) {
          break;
        }
        AppMethodBeat.o(194856);
        return true;
      }
    }
    AppMethodBeat.o(194856);
    return false;
  }
  
  private boolean P(float paramFloat1, float paramFloat2)
  {
    return (paramFloat2 >= this.bVO - this.bVF) && (paramFloat1 >= this.bVL - this.bVK / 2) && (paramFloat1 <= this.bVL + this.bVK / 2);
  }
  
  private static int a(float paramFloat1, float paramFloat2, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramArrayOfInt[1] - paramArrayOfInt[0];
    if (i == 0) {}
    do
    {
      return 0;
      paramFloat1 = (paramFloat2 - paramFloat1) / i;
      paramInt1 -= paramInt3;
      paramInt3 = (int)(paramFloat1 * paramInt1);
      paramInt2 += paramInt3;
    } while ((paramInt2 >= paramInt1) || (paramInt2 < 0));
    return paramInt3;
  }
  
  private void fF(int paramInt)
  {
    AppMethodBeat.i(194841);
    Jb();
    this.mRecyclerView.postDelayed(this.mHideRunnable, paramInt);
    AppMethodBeat.o(194841);
  }
  
  private void show()
  {
    AppMethodBeat.i(194826);
    switch (this.bVU)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(194826);
      return;
      this.bVT.cancel();
      this.bVU = 1;
      this.bVT.setFloatValues(new float[] { ((Float)this.bVT.getAnimatedValue()).floatValue(), 1.0F });
      this.bVT.setDuration(500L);
      this.bVT.setStartDelay(0L);
      this.bVT.start();
    }
  }
  
  public final boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    boolean bool1 = true;
    AppMethodBeat.i(194896);
    boolean bool2;
    if (this.mState == 1)
    {
      bool2 = O(paramMotionEvent.getX(), paramMotionEvent.getY());
      boolean bool3 = P(paramMotionEvent.getX(), paramMotionEvent.getY());
      if ((paramMotionEvent.getAction() == 0) && ((bool2) || (bool3))) {
        if (bool3)
        {
          this.bxy = 1;
          this.bVM = ((int)paramMotionEvent.getX());
          setState(2);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(194896);
      return bool1;
      if (!bool2) {
        break;
      }
      this.bxy = 2;
      this.bVJ = ((int)paramMotionEvent.getY());
      break;
      bool1 = false;
      continue;
      if (this.mState != 2) {
        bool1 = false;
      }
    }
  }
  
  public final void aX(boolean paramBoolean) {}
  
  public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(194888);
    if ((this.bVN != this.mRecyclerView.getWidth()) || (this.bVO != this.mRecyclerView.getHeight()))
    {
      this.bVN = this.mRecyclerView.getWidth();
      this.bVO = this.mRecyclerView.getHeight();
      setState(0);
      AppMethodBeat.o(194888);
      return;
    }
    int i;
    int j;
    if (this.bVU != 0) {
      if (this.bVP)
      {
        i = this.bVN - this.bVB;
        j = this.bVI - this.bVH / 2;
        this.bVz.setBounds(0, 0, this.bVB, this.bVH);
        this.bVA.setBounds(0, 0, this.bVC, this.bVO);
        if (!Ja()) {
          break label319;
        }
        this.bVA.draw(paramCanvas);
        paramCanvas.translate(this.bVB, j);
        paramCanvas.scale(-1.0F, 1.0F);
        this.bVz.draw(paramCanvas);
        paramCanvas.scale(1.0F, 1.0F);
        paramCanvas.translate(-this.bVB, -j);
      }
    }
    for (;;)
    {
      if (this.bVQ)
      {
        i = this.bVO - this.bVF;
        j = this.bVL - this.bVK / 2;
        this.bVD.setBounds(0, 0, this.bVK, this.bVF);
        this.bVE.setBounds(0, 0, this.bVN, this.bVG);
        paramCanvas.translate(0.0F, i);
        this.bVE.draw(paramCanvas);
        paramCanvas.translate(j, 0.0F);
        this.bVD.draw(paramCanvas);
        paramCanvas.translate(-j, -i);
      }
      AppMethodBeat.o(194888);
      return;
      label319:
      paramCanvas.translate(i, 0.0F);
      this.bVA.draw(paramCanvas);
      paramCanvas.translate(0.0F, j);
      this.bVz.draw(paramCanvas);
      paramCanvas.translate(-i, -j);
    }
  }
  
  public final void b(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(194910);
    if (this.mState == 0)
    {
      AppMethodBeat.o(194910);
      return;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      boolean bool1 = O(paramMotionEvent.getX(), paramMotionEvent.getY());
      boolean bool2 = P(paramMotionEvent.getX(), paramMotionEvent.getY());
      if ((bool1) || (bool2))
      {
        if (!bool2) {
          break label97;
        }
        this.bxy = 1;
        this.bVM = ((int)paramMotionEvent.getX());
      }
      for (;;)
      {
        setState(2);
        AppMethodBeat.o(194910);
        return;
        label97:
        if (bool1)
        {
          this.bxy = 2;
          this.bVJ = ((int)paramMotionEvent.getY());
        }
      }
    }
    if ((paramMotionEvent.getAction() == 1) && (this.mState == 2))
    {
      this.bVJ = 0.0F;
      this.bVM = 0.0F;
      setState(1);
      this.bxy = 0;
      AppMethodBeat.o(194910);
      return;
    }
    if ((paramMotionEvent.getAction() == 2) && (this.mState == 2))
    {
      show();
      float f;
      int i;
      if (this.bxy == 1)
      {
        f = paramMotionEvent.getX();
        this.bVS[0] = this.bhE;
        this.bVS[1] = (this.bVN - this.bhE);
        paramRecyclerView = this.bVS;
        f = Math.max(paramRecyclerView[0], Math.min(paramRecyclerView[1], f));
        if (Math.abs(this.bVL - f) >= 2.0F)
        {
          i = a(this.bVM, f, paramRecyclerView, this.mRecyclerView.computeHorizontalScrollRange(), this.mRecyclerView.computeHorizontalScrollOffset(), this.bVN);
          if (i != 0) {
            this.mRecyclerView.scrollBy(i, 0);
          }
          this.bVM = f;
        }
      }
      if (this.bxy == 2)
      {
        f = paramMotionEvent.getY();
        this.bVR[0] = this.bhE;
        this.bVR[1] = (this.bVO - this.bhE);
        paramRecyclerView = this.bVR;
        f = Math.max(paramRecyclerView[0], Math.min(paramRecyclerView[1], f));
        if (Math.abs(this.bVI - f) >= 2.0F)
        {
          i = a(this.bVJ, f, paramRecyclerView, this.mRecyclerView.computeVerticalScrollRange(), this.mRecyclerView.computeVerticalScrollOffset(), this.bVO);
          if (i != 0) {
            this.mRecyclerView.scrollBy(0, i);
          }
          this.bVJ = f;
        }
      }
    }
    AppMethodBeat.o(194910);
  }
  
  final void setState(int paramInt)
  {
    AppMethodBeat.i(194880);
    if ((paramInt == 2) && (this.mState != 2))
    {
      this.bVz.setState(xo);
      Jb();
    }
    if (paramInt == 0)
    {
      this.mRecyclerView.invalidate();
      if ((this.mState != 2) || (paramInt == 2)) {
        break label95;
      }
      this.bVz.setState(xr);
      fF(1200);
    }
    for (;;)
    {
      this.mState = paramInt;
      AppMethodBeat.o(194880);
      return;
      show();
      break;
      label95:
      if (paramInt == 1) {
        fF(1500);
      }
    }
  }
  
  final class a
    extends AnimatorListenerAdapter
  {
    private boolean mCanceled = false;
    
    a() {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      this.mCanceled = true;
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(194816);
      if (this.mCanceled)
      {
        this.mCanceled = false;
        AppMethodBeat.o(194816);
        return;
      }
      if (((Float)i.this.bVT.getAnimatedValue()).floatValue() == 0.0F)
      {
        i.this.bVU = 0;
        i.this.setState(0);
        AppMethodBeat.o(194816);
        return;
      }
      i.this.bVU = 2;
      i.this.mRecyclerView.invalidate();
      AppMethodBeat.o(194816);
    }
  }
  
  final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b() {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(194834);
      int i = (int)(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * 255.0F);
      i.this.bVz.setAlpha(i);
      i.this.bVA.setAlpha(i);
      i.this.mRecyclerView.invalidate();
      AppMethodBeat.o(194834);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.recyclerview.widget.i
 * JD-Core Version:    0.7.0.1
 */