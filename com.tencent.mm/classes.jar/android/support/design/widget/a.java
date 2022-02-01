package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.u;
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
  private BottomSheetBehavior.a oA;
  private BottomSheetBehavior<FrameLayout> ow;
  boolean ox;
  boolean oy;
  boolean oz;
  
  public a(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public a(Context paramContext, int paramInt) {}
  
  private View a(int paramInt, View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    FrameLayout localFrameLayout = (FrameLayout)View.inflate(getContext(), 2131493824, null);
    CoordinatorLayout localCoordinatorLayout = (CoordinatorLayout)localFrameLayout.findViewById(2131299248);
    View localView = paramView;
    if (paramInt != 0)
    {
      localView = paramView;
      if (paramView == null) {
        localView = getLayoutInflater().inflate(paramInt, localCoordinatorLayout, false);
      }
    }
    paramView = (FrameLayout)localCoordinatorLayout.findViewById(2131299514);
    this.ow = BottomSheetBehavior.l(paramView);
    this.ow.ok = this.oA;
    this.ow.ob = this.ox;
    if (paramLayoutParams == null) {
      paramView.addView(localView);
    }
    for (;;)
    {
      localCoordinatorLayout.findViewById(2131309368).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          if ((a.this.ox) && (a.this.isShowing()))
          {
            paramAnonymousView = a.this;
            if (!paramAnonymousView.oz)
            {
              TypedArray localTypedArray = paramAnonymousView.getContext().obtainStyledAttributes(new int[] { 16843611 });
              paramAnonymousView.oy = localTypedArray.getBoolean(0, true);
              localTypedArray.recycle();
              paramAnonymousView.oz = true;
            }
            if (paramAnonymousView.oy) {
              a.this.cancel();
            }
          }
        }
      });
      u.a(paramView, new a.2(this));
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
    if ((this.ow != null) && (this.ow.state == 5)) {
      this.ow.setState(4);
    }
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    super.setCancelable(paramBoolean);
    if (this.ox != paramBoolean)
    {
      this.ox = paramBoolean;
      if (this.ow != null) {
        this.ow.ob = paramBoolean;
      }
    }
  }
  
  public void setCanceledOnTouchOutside(boolean paramBoolean)
  {
    super.setCanceledOnTouchOutside(paramBoolean);
    if ((paramBoolean) && (!this.ox)) {
      this.ox = true;
    }
    this.oy = paramBoolean;
    this.oz = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.design.widget.a
 * JD-Core Version:    0.7.0.1
 */