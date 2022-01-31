package android.support.design.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.t;
import android.support.v7.app.e;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;

public class c
  extends e
{
  private BottomSheetBehavior<FrameLayout> gE;
  boolean gF;
  boolean gG;
  private BottomSheetBehavior.a gH;
  boolean mCancelable;
  
  public c(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public c(Context paramContext, int paramInt) {}
  
  private View a(int paramInt, View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    FrameLayout localFrameLayout = (FrameLayout)View.inflate(getContext(), 2130969305, null);
    CoordinatorLayout localCoordinatorLayout = (CoordinatorLayout)localFrameLayout.findViewById(2131823373);
    View localView = paramView;
    if (paramInt != 0)
    {
      localView = paramView;
      if (paramView == null) {
        localView = getLayoutInflater().inflate(paramInt, localCoordinatorLayout, false);
      }
    }
    paramView = (FrameLayout)localCoordinatorLayout.findViewById(2131823375);
    this.gE = BottomSheetBehavior.i(paramView);
    this.gE.gw = this.gH;
    this.gE.go = this.mCancelable;
    if (paramLayoutParams == null) {
      paramView.addView(localView);
    }
    for (;;)
    {
      localCoordinatorLayout.findViewById(2131823374).setOnClickListener(new c.1(this));
      t.a(paramView, new c.2(this));
      paramView.setOnTouchListener(new c.3(this));
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
    if (this.gE != null) {
      this.gE.setState(4);
    }
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    super.setCancelable(paramBoolean);
    if (this.mCancelable != paramBoolean)
    {
      this.mCancelable = paramBoolean;
      if (this.gE != null) {
        this.gE.go = paramBoolean;
      }
    }
  }
  
  public void setCanceledOnTouchOutside(boolean paramBoolean)
  {
    super.setCanceledOnTouchOutside(paramBoolean);
    if ((paramBoolean) && (!this.mCancelable)) {
      this.mCancelable = true;
    }
    this.gF = paramBoolean;
    this.gG = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.design.widget.c
 * JD-Core Version:    0.7.0.1
 */