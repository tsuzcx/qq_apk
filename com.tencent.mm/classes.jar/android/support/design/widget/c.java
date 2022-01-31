package android.support.design.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.a.f;
import android.support.design.a.h;
import android.support.v4.view.q;
import android.support.v7.app.i;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;

public final class c
  extends i
{
  private BottomSheetBehavior<FrameLayout> fK;
  boolean fL;
  boolean fM;
  private BottomSheetBehavior.a fN;
  boolean mCancelable;
  
  public c(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private c(Context paramContext, byte paramByte) {}
  
  private View a(int paramInt, View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
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
    this.fK = BottomSheetBehavior.i(paramView);
    this.fK.fA = this.fN;
    this.fK.fq = this.mCancelable;
    if (paramLayoutParams == null) {
      paramView.addView(localView);
    }
    for (;;)
    {
      localCoordinatorLayout.findViewById(a.f.touch_outside).setOnClickListener(new c.1(this));
      q.a(paramView, new android.support.v4.view.a()
      {
        public final void a(View paramAnonymousView, android.support.v4.view.a.a paramAnonymousa)
        {
          super.a(paramAnonymousView, paramAnonymousa);
          if (c.this.mCancelable)
          {
            paramAnonymousa.addAction(1048576);
            paramAnonymousa.setDismissable(true);
            return;
          }
          paramAnonymousa.setDismissable(false);
        }
        
        public final boolean performAccessibilityAction(View paramAnonymousView, int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          if ((paramAnonymousInt == 1048576) && (c.this.mCancelable))
          {
            c.this.cancel();
            return true;
          }
          return super.performAccessibilityAction(paramAnonymousView, paramAnonymousInt, paramAnonymousBundle);
        }
      });
      paramView.setOnTouchListener(new c.3(this));
      return localFrameLayout;
      paramView.addView(localView, paramLayoutParams);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
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
  }
  
  protected final void onStart()
  {
    super.onStart();
    if (this.fK != null) {
      this.fK.setState(4);
    }
  }
  
  public final void setCancelable(boolean paramBoolean)
  {
    super.setCancelable(paramBoolean);
    if (this.mCancelable != paramBoolean)
    {
      this.mCancelable = paramBoolean;
      if (this.fK != null) {
        this.fK.fq = paramBoolean;
      }
    }
  }
  
  public final void setCanceledOnTouchOutside(boolean paramBoolean)
  {
    super.setCanceledOnTouchOutside(paramBoolean);
    if ((paramBoolean) && (!this.mCancelable)) {
      this.mCancelable = true;
    }
    this.fL = paramBoolean;
    this.fM = true;
  }
  
  public final void setContentView(int paramInt)
  {
    super.setContentView(a(paramInt, null, null));
  }
  
  public final void setContentView(View paramView)
  {
    super.setContentView(a(0, paramView, null));
  }
  
  public final void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.setContentView(a(0, paramView, paramLayoutParams));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.design.widget.c
 * JD-Core Version:    0.7.0.1
 */