package com.samsung.android.sdk.look;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.view.PointerIcon;
import android.view.View;

public class SlookPointerIcon
{
  private static final String TAG = "SlookPointerIcon";
  private Drawable mDrawable;
  private Slook mSlook = new Slook();
  
  private boolean isSupport(int paramInt)
  {
    return this.mSlook.isFeatureEnabled(4);
  }
  
  public void setHoverIcon(View paramView, Drawable paramDrawable)
  {
    if (!isSupport(1)) {
      return;
    }
    if (paramView == null) {
      throw new IllegalArgumentException("view is null.");
    }
    if (paramDrawable == null)
    {
      paramView.setOnHoverListener(null);
      try
      {
        PointerIcon.setHoveringSpenIcon(1, -1);
        return;
      }
      catch (RemoteException paramView)
      {
        return;
      }
    }
    this.mDrawable = paramDrawable;
    paramView.setOnHoverListener(new SlookPointerIcon.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.samsung.android.sdk.look.SlookPointerIcon
 * JD-Core Version:    0.7.0.1
 */