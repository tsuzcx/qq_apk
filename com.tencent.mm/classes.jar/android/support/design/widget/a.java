package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.a.c;
import android.support.v4.view.t;
import android.support.v7.app.e;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;

public class a
  extends e
{
  boolean lA;
  boolean lB;
  boolean lC;
  private BottomSheetBehavior.a lD;
  private BottomSheetBehavior<FrameLayout> lz;
  
  public a(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public a(Context paramContext, int paramInt) {}
  
  private View a(int paramInt, View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    FrameLayout localFrameLayout = (FrameLayout)View.inflate(getContext(), 2131493693, null);
    CoordinatorLayout localCoordinatorLayout = (CoordinatorLayout)localFrameLayout.findViewById(2131298793);
    View localView = paramView;
    if (paramInt != 0)
    {
      localView = paramView;
      if (paramView == null) {
        localView = getLayoutInflater().inflate(paramInt, localCoordinatorLayout, false);
      }
    }
    paramView = (FrameLayout)localCoordinatorLayout.findViewById(2131299011);
    this.lz = BottomSheetBehavior.l(paramView);
    this.lz.lq = this.lD;
    this.lz.lh = this.lA;
    if (paramLayoutParams == null) {
      paramView.addView(localView);
    }
    for (;;)
    {
      localCoordinatorLayout.findViewById(2131306045).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          if ((a.this.lA) && (a.this.isShowing()))
          {
            paramAnonymousView = a.this;
            if (!paramAnonymousView.lC)
            {
              TypedArray localTypedArray = paramAnonymousView.getContext().obtainStyledAttributes(new int[] { 16843611 });
              paramAnonymousView.lB = localTypedArray.getBoolean(0, true);
              localTypedArray.recycle();
              paramAnonymousView.lC = true;
            }
            if (paramAnonymousView.lB) {
              a.this.cancel();
            }
          }
        }
      });
      t.a(paramView, new android.support.v4.view.a()
      {
        public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, c paramAnonymousc)
        {
          super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousc);
          if (a.this.lA)
          {
            paramAnonymousc.addAction(1048576);
            paramAnonymousc.setDismissable(true);
            return;
          }
          paramAnonymousc.setDismissable(false);
        }
        
        public final boolean performAccessibilityAction(View paramAnonymousView, int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          if ((paramAnonymousInt == 1048576) && (a.this.lA))
          {
            a.this.cancel();
            return true;
          }
          return super.performAccessibilityAction(paramAnonymousView, paramAnonymousInt, paramAnonymousBundle);
        }
      });
      paramView.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return true;
        }
      });
      return localFrameLayout;
      paramView.addView(localView, paramLayoutParams);
    }
  }
  
  public void onCreate(Bundle paramBundle)
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
  
  protected void onStart()
  {
    super.onStart();
    if ((this.lz != null) && (this.lz.state == 5)) {
      this.lz.setState(4);
    }
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    super.setCancelable(paramBoolean);
    if (this.lA != paramBoolean)
    {
      this.lA = paramBoolean;
      if (this.lz != null) {
        this.lz.lh = paramBoolean;
      }
    }
  }
  
  public void setCanceledOnTouchOutside(boolean paramBoolean)
  {
    super.setCanceledOnTouchOutside(paramBoolean);
    if ((paramBoolean) && (!this.lA)) {
      this.lA = true;
    }
    this.lB = paramBoolean;
    this.lC = true;
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(a(paramInt, null, null));
  }
  
  public void setContentView(View paramView)
  {
    super.setContentView(a(0, paramView, null));
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.setContentView(a(0, paramView, paramLayoutParams));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.widget.a
 * JD-Core Version:    0.7.0.1
 */