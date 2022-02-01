package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.core.g.z;
import androidx.customview.a.c;
import androidx.customview.a.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SwipeDismissBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  c dpd;
  private boolean dpe;
  private float dpf;
  private boolean dpg;
  public int dph;
  float dpi;
  public float dpj;
  public float dpk;
  private final c.a dpl;
  
  public SwipeDismissBehavior()
  {
    AppMethodBeat.i(209910);
    this.dpf = 0.0F;
    this.dph = 2;
    this.dpi = 0.5F;
    this.dpj = 0.0F;
    this.dpk = 0.5F;
    this.dpl = new c.a()
    {
      private int doI = -1;
      private int dpm;
      
      public final void D(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(209934);
        this.doI = paramAnonymousInt;
        this.dpm = paramAnonymousView.getLeft();
        paramAnonymousView = paramAnonymousView.getParent();
        if (paramAnonymousView != null) {
          paramAnonymousView.requestDisallowInterceptTouchEvent(true);
        }
        AppMethodBeat.o(209934);
      }
      
      public final void F(int paramAnonymousInt) {}
      
      public final void a(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(209976);
        float f1 = this.dpm + paramAnonymousView.getWidth() * SwipeDismissBehavior.this.dpj;
        float f2 = this.dpm + paramAnonymousView.getWidth() * SwipeDismissBehavior.this.dpk;
        if (paramAnonymousInt1 <= f1)
        {
          paramAnonymousView.setAlpha(1.0F);
          AppMethodBeat.o(209976);
          return;
        }
        if (paramAnonymousInt1 >= f2)
        {
          paramAnonymousView.setAlpha(0.0F);
          AppMethodBeat.o(209976);
          return;
        }
        paramAnonymousView.setAlpha(SwipeDismissBehavior.aQ(1.0F - SwipeDismissBehavior.m(f1, f2, paramAnonymousInt1)));
        AppMethodBeat.o(209976);
      }
      
      public final int aQ(View paramAnonymousView)
      {
        AppMethodBeat.i(209957);
        int i = paramAnonymousView.getWidth();
        AppMethodBeat.o(209957);
        return i;
      }
      
      public final void b(View paramAnonymousView, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        boolean bool = true;
        AppMethodBeat.i(209951);
        this.doI = -1;
        int j = paramAnonymousView.getWidth();
        int i;
        if (paramAnonymousFloat1 != 0.0F) {
          if (z.U(paramAnonymousView) == 1)
          {
            i = 1;
            if (SwipeDismissBehavior.this.dph != 2) {
              break label124;
            }
            i = 1;
            label50:
            if (i == 0) {
              break label300;
            }
            if (paramAnonymousView.getLeft() >= this.dpm) {
              break label288;
            }
            i = this.dpm - j;
          }
        }
        for (;;)
        {
          if (!SwipeDismissBehavior.this.dpd.aD(i, paramAnonymousView.getTop())) {
            break label312;
          }
          z.b(paramAnonymousView, new SwipeDismissBehavior.a(SwipeDismissBehavior.this, paramAnonymousView, bool));
          AppMethodBeat.o(209951);
          return;
          i = 0;
          break;
          label124:
          if (SwipeDismissBehavior.this.dph == 0)
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
          if (SwipeDismissBehavior.this.dph == 1)
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
            int k = this.dpm;
            int m = Math.round(paramAnonymousView.getWidth() * SwipeDismissBehavior.this.dpi);
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
          i = this.dpm + j;
          continue;
          label300:
          i = this.dpm;
          bool = false;
        }
        label312:
        AppMethodBeat.o(209951);
      }
      
      public final boolean b(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(209928);
        if ((this.doI == -1) && (SwipeDismissBehavior.this.cB(paramAnonymousView)))
        {
          AppMethodBeat.o(209928);
          return true;
        }
        AppMethodBeat.o(209928);
        return false;
      }
      
      public final int c(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(209968);
        paramAnonymousInt = paramAnonymousView.getTop();
        AppMethodBeat.o(209968);
        return paramAnonymousInt;
      }
      
      public final int d(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(209964);
        int i;
        int j;
        if (z.U(paramAnonymousView) == 1)
        {
          i = 1;
          if (SwipeDismissBehavior.this.dph != 0) {
            break label84;
          }
          if (i == 0) {
            break label65;
          }
          i = this.dpm - paramAnonymousView.getWidth();
          j = this.dpm;
        }
        for (;;)
        {
          paramAnonymousInt = SwipeDismissBehavior.clamp(i, paramAnonymousInt, j);
          AppMethodBeat.o(209964);
          return paramAnonymousInt;
          i = 0;
          break;
          label65:
          i = this.dpm;
          j = this.dpm + paramAnonymousView.getWidth();
          continue;
          label84:
          if (SwipeDismissBehavior.this.dph == 1)
          {
            if (i != 0)
            {
              i = this.dpm;
              j = this.dpm + paramAnonymousView.getWidth();
            }
            else
            {
              i = this.dpm - paramAnonymousView.getWidth();
              j = this.dpm;
            }
          }
          else
          {
            i = this.dpm - paramAnonymousView.getWidth();
            j = this.dpm + paramAnonymousView.getWidth();
          }
        }
      }
    };
    AppMethodBeat.o(209910);
  }
  
  public static float aQ(float paramFloat)
  {
    AppMethodBeat.i(209917);
    paramFloat = Math.min(Math.max(0.0F, paramFloat), 1.0F);
    AppMethodBeat.o(209917);
    return paramFloat;
  }
  
  static int clamp(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(209922);
    paramInt1 = Math.min(Math.max(paramInt1, paramInt2), paramInt3);
    AppMethodBeat.o(209922);
    return paramInt1;
  }
  
  static float m(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1);
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(209937);
    boolean bool2 = this.dpe;
    boolean bool1 = bool2;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      bool1 = bool2;
    case 2: 
      if (!bool1) {
        break label159;
      }
      if (this.dpd == null) {
        if (!this.dpg) {
          break label147;
        }
      }
      break;
    }
    label147:
    for (paramCoordinatorLayout = c.a(paramCoordinatorLayout, this.dpf, this.dpl);; paramCoordinatorLayout = c.a(paramCoordinatorLayout, this.dpl))
    {
      this.dpd = paramCoordinatorLayout;
      bool1 = this.dpd.i(paramMotionEvent);
      AppMethodBeat.o(209937);
      return bool1;
      this.dpe = paramCoordinatorLayout.d(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      bool1 = this.dpe;
      break;
      this.dpe = false;
      bool1 = bool2;
      break;
    }
    label159:
    AppMethodBeat.o(209937);
    return false;
  }
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(209946);
    if (this.dpd != null)
    {
      this.dpd.j(paramMotionEvent);
      AppMethodBeat.o(209946);
      return true;
    }
    AppMethodBeat.o(209946);
    return false;
  }
  
  public boolean cB(View paramView)
  {
    return true;
  }
  
  final class a
    implements Runnable
  {
    private final boolean cDH;
    private final View view;
    
    a(View paramView, boolean paramBoolean)
    {
      this.view = paramView;
      this.cDH = paramBoolean;
    }
    
    public final void run()
    {
      AppMethodBeat.i(209908);
      if ((SwipeDismissBehavior.this.dpd != null) && (SwipeDismissBehavior.this.dpd.Fx()))
      {
        z.b(this.view, this);
        AppMethodBeat.o(209908);
        return;
      }
      AppMethodBeat.o(209908);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.behavior.SwipeDismissBehavior
 * JD-Core Version:    0.7.0.1
 */