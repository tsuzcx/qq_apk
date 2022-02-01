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
import androidx.core.g.w;
import com.google.android.material.a.f;
import com.google.android.material.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
  extends e
{
  private BottomSheetBehavior<FrameLayout> bxN;
  boolean bxO;
  boolean bxP;
  boolean bxQ;
  private BottomSheetBehavior.a bxR;
  
  public a(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public a(Context paramContext, int paramInt) {}
  
  private View a(int paramInt, View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(235474);
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
    this.bxN = BottomSheetBehavior.cg(paramView);
    this.bxN.bxG = this.bxR;
    this.bxN.bxz = this.bxO;
    if (paramLayoutParams == null) {
      paramView.addView(localView);
    }
    for (;;)
    {
      localCoordinatorLayout.findViewById(a.f.touch_outside).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(235429);
          if ((a.this.bxO) && (a.this.isShowing()))
          {
            paramAnonymousView = a.this;
            if (!paramAnonymousView.bxQ)
            {
              TypedArray localTypedArray = paramAnonymousView.getContext().obtainStyledAttributes(new int[] { 16843611 });
              paramAnonymousView.bxP = localTypedArray.getBoolean(0, true);
              localTypedArray.recycle();
              paramAnonymousView.bxQ = true;
            }
            if (paramAnonymousView.bxP) {
              a.this.cancel();
            }
          }
          AppMethodBeat.o(235429);
        }
      });
      w.a(paramView, new androidx.core.g.a()
      {
        public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, d paramAnonymousd)
        {
          AppMethodBeat.i(235433);
          super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousd);
          if (a.this.bxO)
          {
            paramAnonymousd.bA(1048576);
            paramAnonymousd.ac(true);
            AppMethodBeat.o(235433);
            return;
          }
          paramAnonymousd.ac(false);
          AppMethodBeat.o(235433);
        }
        
        public final boolean performAccessibilityAction(View paramAnonymousView, int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(235435);
          if ((paramAnonymousInt == 1048576) && (a.this.bxO))
          {
            a.this.cancel();
            AppMethodBeat.o(235435);
            return true;
          }
          boolean bool = super.performAccessibilityAction(paramAnonymousView, paramAnonymousInt, paramAnonymousBundle);
          AppMethodBeat.o(235435);
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
      AppMethodBeat.o(235474);
      return localFrameLayout;
      paramView.addView(localView, paramLayoutParams);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(235458);
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
    AppMethodBeat.o(235458);
  }
  
  protected void onStart()
  {
    AppMethodBeat.i(235469);
    super.onStart();
    if ((this.bxN != null) && (this.bxN.state == 5)) {
      this.bxN.setState(4);
    }
    AppMethodBeat.o(235469);
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(235467);
    super.setCancelable(paramBoolean);
    if (this.bxO != paramBoolean)
    {
      this.bxO = paramBoolean;
      if (this.bxN != null) {
        this.bxN.bxz = paramBoolean;
      }
    }
    AppMethodBeat.o(235467);
  }
  
  public void setCanceledOnTouchOutside(boolean paramBoolean)
  {
    AppMethodBeat.i(235471);
    super.setCanceledOnTouchOutside(paramBoolean);
    if ((paramBoolean) && (!this.bxO)) {
      this.bxO = true;
    }
    this.bxP = paramBoolean;
    this.bxQ = true;
    AppMethodBeat.o(235471);
  }
  
  public void setContentView(int paramInt)
  {
    AppMethodBeat.i(235457);
    super.setContentView(a(paramInt, null, null));
    AppMethodBeat.o(235457);
  }
  
  public void setContentView(View paramView)
  {
    AppMethodBeat.i(235461);
    super.setContentView(a(0, paramView, null));
    AppMethodBeat.o(235461);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(235464);
    super.setContentView(a(0, paramView, paramLayoutParams));
    AppMethodBeat.o(235464);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.bottomsheet.a
 * JD-Core Version:    0.7.0.1
 */