package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.e;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.g.a.d;
import androidx.core.g.z;
import com.google.android.material.a.f;
import com.google.android.material.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
  extends e
{
  private BottomSheetBehavior<FrameLayout> dqQ;
  boolean dqR;
  boolean dqS;
  boolean dqT;
  private BottomSheetBehavior.a dqU;
  
  public a(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public a(Context paramContext, int paramInt) {}
  
  private View a(int paramInt, View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(209519);
    FrameLayout localFrameLayout = (FrameLayout)View.inflate(getContext(), a.h.design_bottom_sheet_dialog, null);
    CoordinatorLayout localCoordinatorLayout = (CoordinatorLayout)localFrameLayout.findViewById(a.f.coordinator);
    View localView = paramView;
    if (paramInt != 0)
    {
      localView = paramView;
      if (paramView == null) {
        localView = getLayoutInflater().inflate(paramInt, localCoordinatorLayout, false);
      }
    }
    paramView = (FrameLayout)localCoordinatorLayout.findViewById(a.f.design_bottom_sheet);
    this.dqQ = BottomSheetBehavior.cC(paramView);
    this.dqQ.dqJ = this.dqU;
    this.dqQ.dqC = this.dqR;
    if (paramLayoutParams == null) {
      paramView.addView(localView);
    }
    for (;;)
    {
      localCoordinatorLayout.findViewById(a.f.touch_outside).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(209498);
          if ((a.this.dqR) && (a.this.isShowing()))
          {
            paramAnonymousView = a.this;
            if (!paramAnonymousView.dqT)
            {
              TypedArray localTypedArray = paramAnonymousView.getContext().obtainStyledAttributes(new int[] { 16843611 });
              paramAnonymousView.dqS = localTypedArray.getBoolean(0, true);
              localTypedArray.recycle();
              paramAnonymousView.dqT = true;
            }
            if (paramAnonymousView.dqS) {
              a.this.cancel();
            }
          }
          AppMethodBeat.o(209498);
        }
      });
      z.a(paramView, new androidx.core.g.a()
      {
        public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, d paramAnonymousd)
        {
          AppMethodBeat.i(209492);
          super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousd);
          if (a.this.dqR)
          {
            paramAnonymousd.eu(1048576);
            paramAnonymousd.aI(true);
            AppMethodBeat.o(209492);
            return;
          }
          paramAnonymousd.aI(false);
          AppMethodBeat.o(209492);
        }
        
        public final boolean performAccessibilityAction(View paramAnonymousView, int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(209499);
          if ((paramAnonymousInt == 1048576) && (a.this.dqR))
          {
            a.this.cancel();
            AppMethodBeat.o(209499);
            return true;
          }
          boolean bool = super.performAccessibilityAction(paramAnonymousView, paramAnonymousInt, paramAnonymousBundle);
          AppMethodBeat.o(209499);
          return bool;
        }
      });
      paramView.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return true;
        }
      });
      AppMethodBeat.o(209519);
      return localFrameLayout;
      paramView.addView(localView, paramLayoutParams);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(209543);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null)
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramBundle.clearFlags(67108864);
        paramBundle.addFlags(-2147483648);
      }
      paramBundle.setLayout(-1, -1);
    }
    AppMethodBeat.o(209543);
  }
  
  protected void onStart()
  {
    AppMethodBeat.i(209591);
    super.onStart();
    if ((this.dqQ != null) && (this.dqQ.state == 5)) {
      this.dqQ.setState(4);
    }
    AppMethodBeat.o(209591);
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(209578);
    super.setCancelable(paramBoolean);
    if (this.dqR != paramBoolean)
    {
      this.dqR = paramBoolean;
      if (this.dqQ != null) {
        this.dqQ.dqC = paramBoolean;
      }
    }
    AppMethodBeat.o(209578);
  }
  
  public void setCanceledOnTouchOutside(boolean paramBoolean)
  {
    AppMethodBeat.i(209601);
    super.setCanceledOnTouchOutside(paramBoolean);
    if ((paramBoolean) && (!this.dqR)) {
      this.dqR = true;
    }
    this.dqS = paramBoolean;
    this.dqT = true;
    AppMethodBeat.o(209601);
  }
  
  public void setContentView(int paramInt)
  {
    AppMethodBeat.i(209533);
    super.setContentView(a(paramInt, null, null));
    AppMethodBeat.o(209533);
  }
  
  public void setContentView(View paramView)
  {
    AppMethodBeat.i(209556);
    super.setContentView(a(0, paramView, null));
    AppMethodBeat.o(209556);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(209567);
    super.setContentView(a(0, paramView, paramLayoutParams));
    AppMethodBeat.o(209567);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.material.bottomsheet.a
 * JD-Core Version:    0.7.0.1
 */