package com.tencent.mm.plugin.appbrand.widget.d;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends FrameLayout
{
  public static final int mhj;
  public static final int mhk;
  public static final int mhu;
  private float anchorX;
  private float anchorY;
  private TextView mht;
  private int mhv;
  private int mhw;
  private int mhx;
  private int mhy;
  public int x;
  public int y;
  
  static
  {
    AppMethodBeat.i(146596);
    mhj = Color.parseColor("#000000");
    mhu = Color.parseColor("#000000");
    mhk = Color.parseColor("#000000");
    AppMethodBeat.o(146596);
  }
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(146587);
    this.x = 0;
    this.y = 0;
    this.anchorX = 0.0F;
    this.anchorY = 0.0F;
    setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    this.mht = new TextView(paramContext);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    this.mht.setLayoutParams(paramContext);
    addView(this.mht);
    AppMethodBeat.o(146587);
  }
  
  public final float getAnchorX()
  {
    return this.anchorX;
  }
  
  public final float getAnchorY()
  {
    return this.anchorY;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(146595);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)getChildAt(0).getLayoutParams();
    if ((this.x >= 0) && (this.y >= 0)) {
      localLayoutParams.gravity = 85;
    }
    for (;;)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(146595);
      return;
      if ((this.x >= 0) && (this.y <= 0)) {
        localLayoutParams.gravity = 53;
      } else if ((this.x <= 0) && (this.y >= 0)) {
        localLayoutParams.gravity = 83;
      } else if ((this.x <= 0) && (this.y <= 0)) {
        localLayoutParams.gravity = 51;
      }
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146594);
    super.onMeasure(paramInt1, paramInt2);
    this.mhv = getMeasuredWidth();
    this.mhw = getMeasuredHeight();
    if ((-this.mhv < this.x) && (this.x < 0))
    {
      this.mhx = this.mhv;
      this.anchorX = (Math.abs(this.x) / (this.mhv * 1.0F));
      if ((-this.mhw >= this.y) || (this.y >= 0)) {
        break label189;
      }
      this.mhy = this.mhw;
      this.anchorY = (Math.abs(this.y) / (this.mhw * 1.0F));
    }
    for (;;)
    {
      setMeasuredDimension(this.mhx, this.mhy);
      AppMethodBeat.o(146594);
      return;
      if (this.x >= 0)
      {
        this.mhx = (this.mhv + Math.abs(this.x));
        this.anchorX = 0.0F;
        break;
      }
      this.mhx = Math.abs(this.x);
      this.anchorX = 1.0F;
      break;
      label189:
      if (this.y >= 0)
      {
        this.mhy = (this.mhw + Math.abs(this.y));
        this.anchorY = 0.0F;
      }
      else
      {
        this.mhy = Math.abs(this.y);
        this.anchorY = 1.0F;
      }
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(182824);
    setText("");
    setTextSize(12);
    setTextColor(mhj);
    setTextPadding(0);
    setGravity("center");
    int i = mhk;
    z(0, 0, i, i);
    AppMethodBeat.o(182824);
  }
  
  public final void setGravity(String paramString)
  {
    AppMethodBeat.i(146593);
    if (paramString.equals("left"))
    {
      this.mht.setGravity(3);
      AppMethodBeat.o(146593);
      return;
    }
    if (paramString.equals("right"))
    {
      this.mht.setGravity(5);
      AppMethodBeat.o(146593);
      return;
    }
    paramString.equals("center");
    this.mht.setGravity(17);
    AppMethodBeat.o(146593);
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(146589);
    this.mht.setText(paramString);
    AppMethodBeat.o(146589);
  }
  
  public final void setTextColor(int paramInt)
  {
    AppMethodBeat.i(146591);
    this.mht.setTextColor(paramInt);
    AppMethodBeat.o(146591);
  }
  
  public final void setTextPadding(int paramInt)
  {
    AppMethodBeat.i(146592);
    this.mht.setPadding(paramInt, paramInt, paramInt, paramInt);
    AppMethodBeat.o(146592);
  }
  
  public final void setTextSize(int paramInt)
  {
    AppMethodBeat.i(146590);
    this.mht.setTextSize(paramInt);
    AppMethodBeat.o(146590);
  }
  
  public final void setX(int paramInt)
  {
    this.x = paramInt;
  }
  
  public final void setY(int paramInt)
  {
    this.y = paramInt;
  }
  
  public final void z(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(146588);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(paramInt1);
    localGradientDrawable.setStroke(paramInt2, paramInt3);
    localGradientDrawable.setColor(paramInt4);
    this.mht.setBackgroundDrawable(localGradientDrawable);
    AppMethodBeat.o(146588);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.d.d
 * JD-Core Version:    0.7.0.1
 */