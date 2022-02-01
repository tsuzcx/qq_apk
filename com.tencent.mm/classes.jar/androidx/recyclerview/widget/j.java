package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class j
  extends RecyclerView.h
  implements RecyclerView.k
{
  private static final int[] ws = { 16842919 };
  private static final int[] ww = new int[0];
  private final int Bw;
  private int Rh;
  final int agS;
  final StateListDrawable agT;
  final Drawable agU;
  private final int agV;
  private final int agW;
  private final StateListDrawable agX;
  private final Drawable agY;
  private final int agZ;
  private final int aha;
  int ahb;
  int ahc;
  float ahd;
  int ahe;
  int ahf;
  float ahg;
  int ahh;
  int ahi;
  boolean ahj;
  boolean ahk;
  private final int[] ahl;
  private final int[] ahm;
  final ValueAnimator ahn;
  int aho;
  private final RecyclerView.l ahp;
  private final Runnable mHideRunnable;
  RecyclerView mRecyclerView;
  int mState;
  
  j(RecyclerView paramRecyclerView, StateListDrawable paramStateListDrawable1, Drawable paramDrawable1, StateListDrawable paramStateListDrawable2, Drawable paramDrawable2, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(261110);
    this.ahh = 0;
    this.ahi = 0;
    this.ahj = false;
    this.ahk = false;
    this.mState = 0;
    this.Rh = 0;
    this.ahl = new int[2];
    this.ahm = new int[2];
    this.ahn = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.aho = 0;
    this.mHideRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(261084);
        j localj = j.this;
        switch (localj.aho)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(261084);
          return;
          localj.ahn.cancel();
          localj.aho = 3;
          localj.ahn.setFloatValues(new float[] { ((Float)localj.ahn.getAnimatedValue()).floatValue(), 0.0F });
          localj.ahn.setDuration(500L);
          localj.ahn.start();
        }
      }
    };
    this.ahp = new RecyclerView.l()
    {
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(261094);
        j localj = j.this;
        paramAnonymousInt1 = paramAnonymousRecyclerView.computeHorizontalScrollOffset();
        paramAnonymousInt2 = paramAnonymousRecyclerView.computeVerticalScrollOffset();
        int i = localj.mRecyclerView.computeVerticalScrollRange();
        int j = localj.ahi;
        int k;
        int m;
        if ((i - j > 0) && (localj.ahi >= localj.agS))
        {
          bool = true;
          localj.ahj = bool;
          k = localj.mRecyclerView.computeHorizontalScrollRange();
          m = localj.ahh;
          if ((k - m <= 0) || (localj.ahh < localj.agS)) {
            break label159;
          }
        }
        label159:
        for (boolean bool = true;; bool = false)
        {
          localj.ahk = bool;
          if ((localj.ahj) || (localj.ahk)) {
            break label165;
          }
          if (localj.mState != 0) {
            localj.setState(0);
          }
          AppMethodBeat.o(261094);
          return;
          bool = false;
          break;
        }
        label165:
        if (localj.ahj)
        {
          localj.ahc = ((int)((paramAnonymousInt2 + j / 2.0F) * j / i));
          localj.ahb = Math.min(j, j * j / i);
        }
        if (localj.ahk)
        {
          localj.ahf = ((int)((paramAnonymousInt1 + m / 2.0F) * m / k));
          localj.ahe = Math.min(m, m * m / k);
        }
        if ((localj.mState == 0) || (localj.mState == 1)) {
          localj.setState(1);
        }
        AppMethodBeat.o(261094);
      }
    };
    this.agT = paramStateListDrawable1;
    this.agU = paramDrawable1;
    this.agX = paramStateListDrawable2;
    this.agY = paramDrawable2;
    this.agV = Math.max(paramInt1, paramStateListDrawable1.getIntrinsicWidth());
    this.agW = Math.max(paramInt1, paramDrawable1.getIntrinsicWidth());
    this.agZ = Math.max(paramInt1, paramStateListDrawable2.getIntrinsicWidth());
    this.aha = Math.max(paramInt1, paramDrawable2.getIntrinsicWidth());
    this.agS = paramInt2;
    this.Bw = paramInt3;
    this.agT.setAlpha(255);
    this.agU.setAlpha(255);
    this.ahn.addListener(new a());
    this.ahn.addUpdateListener(new b());
    if (this.mRecyclerView != paramRecyclerView)
    {
      if (this.mRecyclerView != null)
      {
        this.mRecyclerView.c(this);
        this.mRecyclerView.b(this);
        this.mRecyclerView.b(this.ahp);
        kq();
      }
      this.mRecyclerView = paramRecyclerView;
      if (this.mRecyclerView != null)
      {
        this.mRecyclerView.a(this);
        this.mRecyclerView.a(this);
        this.mRecyclerView.a(this.ahp);
      }
    }
    AppMethodBeat.o(261110);
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
  
  private void ct(int paramInt)
  {
    AppMethodBeat.i(261123);
    kq();
    this.mRecyclerView.postDelayed(this.mHideRunnable, paramInt);
    AppMethodBeat.o(261123);
  }
  
  private boolean f(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(261128);
    if (kp())
    {
      if (paramFloat1 > this.agV / 2) {}
    }
    else {
      while (paramFloat1 >= this.ahh - this.agV)
      {
        if ((paramFloat2 < this.ahc - this.ahb / 2) || (paramFloat2 > this.ahc + this.ahb / 2)) {
          break;
        }
        AppMethodBeat.o(261128);
        return true;
      }
    }
    AppMethodBeat.o(261128);
    return false;
  }
  
  private boolean g(float paramFloat1, float paramFloat2)
  {
    return (paramFloat2 >= this.ahi - this.agZ) && (paramFloat1 >= this.ahf - this.ahe / 2) && (paramFloat1 <= this.ahf + this.ahe / 2);
  }
  
  private boolean kp()
  {
    AppMethodBeat.i(261116);
    if (w.I(this.mRecyclerView) == 1)
    {
      AppMethodBeat.o(261116);
      return true;
    }
    AppMethodBeat.o(261116);
    return false;
  }
  
  private void kq()
  {
    AppMethodBeat.i(261120);
    this.mRecyclerView.removeCallbacks(this.mHideRunnable);
    AppMethodBeat.o(261120);
  }
  
  private void show()
  {
    AppMethodBeat.i(261117);
    switch (this.aho)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(261117);
      return;
      this.ahn.cancel();
      this.aho = 1;
      this.ahn.setFloatValues(new float[] { ((Float)this.ahn.getAnimatedValue()).floatValue(), 1.0F });
      this.ahn.setDuration(500L);
      this.ahn.setStartDelay(0L);
      this.ahn.start();
    }
  }
  
  public final boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    boolean bool1 = true;
    AppMethodBeat.i(261125);
    boolean bool2;
    if (this.mState == 1)
    {
      bool2 = f(paramMotionEvent.getX(), paramMotionEvent.getY());
      boolean bool3 = g(paramMotionEvent.getX(), paramMotionEvent.getY());
      if ((paramMotionEvent.getAction() == 0) && ((bool2) || (bool3))) {
        if (bool3)
        {
          this.Rh = 1;
          this.ahg = ((int)paramMotionEvent.getX());
          setState(2);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(261125);
      return bool1;
      if (!bool2) {
        break;
      }
      this.Rh = 2;
      this.ahd = ((int)paramMotionEvent.getY());
      break;
      bool1 = false;
      continue;
      if (this.mState != 2) {
        bool1 = false;
      }
    }
  }
  
  public final void ao(boolean paramBoolean) {}
  
  public final void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(261124);
    if ((this.ahh != this.mRecyclerView.getWidth()) || (this.ahi != this.mRecyclerView.getHeight()))
    {
      this.ahh = this.mRecyclerView.getWidth();
      this.ahi = this.mRecyclerView.getHeight();
      setState(0);
      AppMethodBeat.o(261124);
      return;
    }
    int i;
    int j;
    if (this.aho != 0) {
      if (this.ahj)
      {
        i = this.ahh - this.agV;
        j = this.ahc - this.ahb / 2;
        this.agT.setBounds(0, 0, this.agV, this.ahb);
        this.agU.setBounds(0, 0, this.agW, this.ahi);
        if (!kp()) {
          break label319;
        }
        this.agU.draw(paramCanvas);
        paramCanvas.translate(this.agV, j);
        paramCanvas.scale(-1.0F, 1.0F);
        this.agT.draw(paramCanvas);
        paramCanvas.scale(1.0F, 1.0F);
        paramCanvas.translate(-this.agV, -j);
      }
    }
    for (;;)
    {
      if (this.ahk)
      {
        i = this.ahi - this.agZ;
        j = this.ahf - this.ahe / 2;
        this.agX.setBounds(0, 0, this.ahe, this.agZ);
        this.agY.setBounds(0, 0, this.ahh, this.aha);
        paramCanvas.translate(0.0F, i);
        this.agY.draw(paramCanvas);
        paramCanvas.translate(j, 0.0F);
        this.agX.draw(paramCanvas);
        paramCanvas.translate(-j, -i);
      }
      AppMethodBeat.o(261124);
      return;
      label319:
      paramCanvas.translate(i, 0.0F);
      this.agU.draw(paramCanvas);
      paramCanvas.translate(0.0F, j);
      this.agT.draw(paramCanvas);
      paramCanvas.translate(-i, -j);
    }
  }
  
  public final void b(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(261127);
    if (this.mState == 0)
    {
      AppMethodBeat.o(261127);
      return;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      boolean bool1 = f(paramMotionEvent.getX(), paramMotionEvent.getY());
      boolean bool2 = g(paramMotionEvent.getX(), paramMotionEvent.getY());
      if ((bool1) || (bool2))
      {
        if (!bool2) {
          break label97;
        }
        this.Rh = 1;
        this.ahg = ((int)paramMotionEvent.getX());
      }
      for (;;)
      {
        setState(2);
        AppMethodBeat.o(261127);
        return;
        label97:
        if (bool1)
        {
          this.Rh = 2;
          this.ahd = ((int)paramMotionEvent.getY());
        }
      }
    }
    if ((paramMotionEvent.getAction() == 1) && (this.mState == 2))
    {
      this.ahd = 0.0F;
      this.ahg = 0.0F;
      setState(1);
      this.Rh = 0;
      AppMethodBeat.o(261127);
      return;
    }
    if ((paramMotionEvent.getAction() == 2) && (this.mState == 2))
    {
      show();
      float f;
      int i;
      if (this.Rh == 1)
      {
        f = paramMotionEvent.getX();
        this.ahm[0] = this.Bw;
        this.ahm[1] = (this.ahh - this.Bw);
        paramRecyclerView = this.ahm;
        f = Math.max(paramRecyclerView[0], Math.min(paramRecyclerView[1], f));
        if (Math.abs(this.ahf - f) >= 2.0F)
        {
          i = a(this.ahg, f, paramRecyclerView, this.mRecyclerView.computeHorizontalScrollRange(), this.mRecyclerView.computeHorizontalScrollOffset(), this.ahh);
          if (i != 0) {
            this.mRecyclerView.scrollBy(i, 0);
          }
          this.ahg = f;
        }
      }
      if (this.Rh == 2)
      {
        f = paramMotionEvent.getY();
        this.ahl[0] = this.Bw;
        this.ahl[1] = (this.ahi - this.Bw);
        paramRecyclerView = this.ahl;
        f = Math.max(paramRecyclerView[0], Math.min(paramRecyclerView[1], f));
        if (Math.abs(this.ahc - f) >= 2.0F)
        {
          i = a(this.ahd, f, paramRecyclerView, this.mRecyclerView.computeVerticalScrollRange(), this.mRecyclerView.computeVerticalScrollOffset(), this.ahi);
          if (i != 0) {
            this.mRecyclerView.scrollBy(0, i);
          }
          this.ahd = f;
        }
      }
    }
    AppMethodBeat.o(261127);
  }
  
  final void setState(int paramInt)
  {
    AppMethodBeat.i(261113);
    if ((paramInt == 2) && (this.mState != 2))
    {
      this.agT.setState(ws);
      kq();
    }
    if (paramInt == 0)
    {
      this.mRecyclerView.invalidate();
      if ((this.mState != 2) || (paramInt == 2)) {
        break label95;
      }
      this.agT.setState(ww);
      ct(1200);
    }
    for (;;)
    {
      this.mState = paramInt;
      AppMethodBeat.o(261113);
      return;
      show();
      break;
      label95:
      if (paramInt == 1) {
        ct(1500);
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
      AppMethodBeat.i(261100);
      if (this.mCanceled)
      {
        this.mCanceled = false;
        AppMethodBeat.o(261100);
        return;
      }
      if (((Float)j.this.ahn.getAnimatedValue()).floatValue() == 0.0F)
      {
        j.this.aho = 0;
        j.this.setState(0);
        AppMethodBeat.o(261100);
        return;
      }
      j.this.aho = 2;
      j.this.mRecyclerView.invalidate();
      AppMethodBeat.o(261100);
    }
  }
  
  final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b() {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(261101);
      int i = (int)(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * 255.0F);
      j.this.agT.setAlpha(i);
      j.this.agU.setAlpha(i);
      j.this.mRecyclerView.invalidate();
      AppMethodBeat.o(261101);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.recyclerview.widget.j
 * JD-Core Version:    0.7.0.1
 */