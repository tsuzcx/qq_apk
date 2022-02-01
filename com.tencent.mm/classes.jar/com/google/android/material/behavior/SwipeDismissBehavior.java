package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.core.g.w;
import androidx.customview.a.c;
import androidx.customview.a.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SwipeDismissBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  c bwa;
  private boolean bwb;
  private float bwc;
  private boolean bwd;
  public int bwe;
  float bwf;
  public float bwg;
  public float bwh;
  private final c.a bwi;
  
  public SwipeDismissBehavior()
  {
    AppMethodBeat.i(234892);
    this.bwc = 0.0F;
    this.bwe = 2;
    this.bwf = 0.5F;
    this.bwg = 0.0F;
    this.bwh = 0.5F;
    this.bwi = new c.a()
    {
      private int bvF = -1;
      private int bwj;
      
      public final void G(int paramAnonymousInt) {}
      
      public final void a(View paramAnonymousView, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        boolean bool = true;
        AppMethodBeat.i(234882);
        this.bvF = -1;
        int j = paramAnonymousView.getWidth();
        int i;
        if (paramAnonymousFloat1 != 0.0F) {
          if (w.I(paramAnonymousView) == 1)
          {
            i = 1;
            if (SwipeDismissBehavior.this.bwe != 2) {
              break label124;
            }
            i = 1;
            label50:
            if (i == 0) {
              break label300;
            }
            if (paramAnonymousView.getLeft() >= this.bwj) {
              break label288;
            }
            i = this.bwj - j;
          }
        }
        for (;;)
        {
          if (!SwipeDismissBehavior.this.bwa.I(i, paramAnonymousView.getTop())) {
            break label312;
          }
          w.a(paramAnonymousView, new SwipeDismissBehavior.a(SwipeDismissBehavior.this, paramAnonymousView, bool));
          AppMethodBeat.o(234882);
          return;
          i = 0;
          break;
          label124:
          if (SwipeDismissBehavior.this.bwe == 0)
          {
            if (i != 0)
            {
              if (paramAnonymousFloat1 < 0.0F)
              {
                i = 1;
                break label50;
              }
              i = 0;
              break label50;
            }
            if (paramAnonymousFloat1 > 0.0F)
            {
              i = 1;
              break label50;
            }
            i = 0;
            break label50;
          }
          if (SwipeDismissBehavior.this.bwe == 1)
          {
            if (i != 0)
            {
              if (paramAnonymousFloat1 > 0.0F)
              {
                i = 1;
                break label50;
              }
              i = 0;
              break label50;
            }
            if (paramAnonymousFloat1 < 0.0F)
            {
              i = 1;
              break label50;
            }
            i = 0;
            break label50;
            i = paramAnonymousView.getLeft();
            int k = this.bwj;
            int m = Math.round(paramAnonymousView.getWidth() * SwipeDismissBehavior.this.bwf);
            if (Math.abs(i - k) >= m)
            {
              i = 1;
              break label50;
            }
            i = 0;
            break label50;
          }
          i = 0;
          break label50;
          label288:
          i = this.bwj + j;
          continue;
          label300:
          i = this.bwj;
          bool = false;
        }
        label312:
        AppMethodBeat.o(234882);
      }
      
      public final void a(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(234886);
        float f1 = this.bwj + paramAnonymousView.getWidth() * SwipeDismissBehavior.this.bwg;
        float f2 = this.bwj + paramAnonymousView.getWidth() * SwipeDismissBehavior.this.bwh;
        if (paramAnonymousInt1 <= f1)
        {
          paramAnonymousView.setAlpha(1.0F);
          AppMethodBeat.o(234886);
          return;
        }
        if (paramAnonymousInt1 >= f2)
        {
          paramAnonymousView.setAlpha(0.0F);
          AppMethodBeat.o(234886);
          return;
        }
        paramAnonymousView.setAlpha(SwipeDismissBehavior.P(1.0F - SwipeDismissBehavior.j(f1, f2, paramAnonymousInt1)));
        AppMethodBeat.o(234886);
      }
      
      public final int aC(View paramAnonymousView)
      {
        AppMethodBeat.i(234883);
        int i = paramAnonymousView.getWidth();
        AppMethodBeat.o(234883);
        return i;
      }
      
      public final boolean b(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(234876);
        if ((this.bvF == -1) && (SwipeDismissBehavior.this.cf(paramAnonymousView)))
        {
          AppMethodBeat.o(234876);
          return true;
        }
        AppMethodBeat.o(234876);
        return false;
      }
      
      public final int c(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(234885);
        paramAnonymousInt = paramAnonymousView.getTop();
        AppMethodBeat.o(234885);
        return paramAnonymousInt;
      }
      
      public final int d(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(234884);
        int i;
        int j;
        if (w.I(paramAnonymousView) == 1)
        {
          i = 1;
          if (SwipeDismissBehavior.this.bwe != 0) {
            break label84;
          }
          if (i == 0) {
            break label65;
          }
          i = this.bwj - paramAnonymousView.getWidth();
          j = this.bwj;
        }
        for (;;)
        {
          paramAnonymousInt = SwipeDismissBehavior.clamp(i, paramAnonymousInt, j);
          AppMethodBeat.o(234884);
          return paramAnonymousInt;
          i = 0;
          break;
          label65:
          i = this.bwj;
          j = this.bwj + paramAnonymousView.getWidth();
          continue;
          label84:
          if (SwipeDismissBehavior.this.bwe == 1)
          {
            if (i != 0)
            {
              i = this.bwj;
              j = this.bwj + paramAnonymousView.getWidth();
            }
            else
            {
              i = this.bwj - paramAnonymousView.getWidth();
              j = this.bwj;
            }
          }
          else
          {
            i = this.bwj - paramAnonymousView.getWidth();
            j = this.bwj + paramAnonymousView.getWidth();
          }
        }
      }
      
      public final void z(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(234878);
        this.bvF = paramAnonymousInt;
        this.bwj = paramAnonymousView.getLeft();
        paramAnonymousView = paramAnonymousView.getParent();
        if (paramAnonymousView != null) {
          paramAnonymousView.requestDisallowInterceptTouchEvent(true);
        }
        AppMethodBeat.o(234878);
      }
    };
    AppMethodBeat.o(234892);
  }
  
  public static float P(float paramFloat)
  {
    AppMethodBeat.i(234896);
    paramFloat = Math.min(Math.max(0.0F, paramFloat), 1.0F);
    AppMethodBeat.o(234896);
    return paramFloat;
  }
  
  static int clamp(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(234898);
    paramInt1 = Math.min(Math.max(paramInt1, paramInt2), paramInt3);
    AppMethodBeat.o(234898);
    return paramInt1;
  }
  
  static float j(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1);
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(234894);
    boolean bool2 = this.bwb;
    boolean bool1 = bool2;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      bool1 = bool2;
    case 2: 
      if (!bool1) {
        break label159;
      }
      if (this.bwa == null) {
        if (!this.bwd) {
          break label147;
        }
      }
      break;
    }
    label147:
    for (paramCoordinatorLayout = c.a(paramCoordinatorLayout, this.bwc, this.bwi);; paramCoordinatorLayout = c.a(paramCoordinatorLayout, this.bwi))
    {
      this.bwa = paramCoordinatorLayout;
      bool1 = this.bwa.i(paramMotionEvent);
      AppMethodBeat.o(234894);
      return bool1;
      this.bwb = paramCoordinatorLayout.d(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      bool1 = this.bwb;
      break;
      this.bwb = false;
      bool1 = bool2;
      break;
    }
    label159:
    AppMethodBeat.o(234894);
    return false;
  }
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(234895);
    if (this.bwa != null)
    {
      this.bwa.j(paramMotionEvent);
      AppMethodBeat.o(234895);
      return true;
    }
    AppMethodBeat.o(234895);
    return false;
  }
  
  public boolean cf(View paramView)
  {
    return true;
  }
  
  final class a
    implements Runnable
  {
    private final boolean aJK;
    private final View view;
    
    a(View paramView, boolean paramBoolean)
    {
      this.view = paramView;
      this.aJK = paramBoolean;
    }
    
    public final void run()
    {
      AppMethodBeat.i(234889);
      if ((SwipeDismissBehavior.this.bwa != null) && (SwipeDismissBehavior.this.bwa.hM()))
      {
        w.a(this.view, this);
        AppMethodBeat.o(234889);
        return;
      }
      AppMethodBeat.o(234889);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.behavior.SwipeDismissBehavior
 * JD-Core Version:    0.7.0.1
 */