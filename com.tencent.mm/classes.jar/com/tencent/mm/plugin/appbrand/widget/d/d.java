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
  public static final int mJk;
  public static final int mJl;
  public static final int mJv;
  private float anchorX;
  private float anchorY;
  private TextView mJu;
  private int mJw;
  private int mJx;
  private int mJy;
  private int mJz;
  public int x;
  public int y;
  
  static
  {
    AppMethodBeat.i(146596);
    mJk = Color.parseColor("#000000");
    mJv = Color.parseColor("#000000");
    mJl = Color.parseColor("#000000");
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
    this.mJu = new TextView(paramContext);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    this.mJu.setLayoutParams(paramContext);
    addView(this.mJu);
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
    this.mJw = getMeasuredWidth();
    this.mJx = getMeasuredHeight();
    if ((-this.mJw < this.x) && (this.x < 0))
    {
      this.mJy = this.mJw;
      this.anchorX = (Math.abs(this.x) / (this.mJw * 1.0F));
      if ((-this.mJx >= this.y) || (this.y >= 0)) {
        break label189;
      }
      this.mJz = this.mJx;
      this.anchorY = (Math.abs(this.y) / (this.mJx * 1.0F));
    }
    for (;;)
    {
      setMeasuredDimension(this.mJy, this.mJz);
      AppMethodBeat.o(146594);
      return;
      if (this.x >= 0)
      {
        this.mJy = (this.mJw + Math.abs(this.x));
        this.anchorX = 0.0F;
        break;
      }
      this.mJy = Math.abs(this.x);
      this.anchorX = 1.0F;
      break;
      label189:
      if (this.y >= 0)
      {
        this.mJz = (this.mJx + Math.abs(this.y));
        this.anchorY = 0.0F;
      }
      else
      {
        this.mJz = Math.abs(this.y);
        this.anchorY = 1.0F;
      }
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(182824);
    setText("");
    setTextSize(12);
    setTextColor(mJk);
    setTextPadding(0);
    setGravity("center");
    int i = mJl;
    z(0, 0, i, i);
    AppMethodBeat.o(182824);
  }
  
  public final void setGravity(String paramString)
  {
    AppMethodBeat.i(146593);
    if (paramString.equals("left"))
    {
      this.mJu.setGravity(3);
      AppMethodBeat.o(146593);
      return;
    }
    if (paramString.equals("right"))
    {
      this.mJu.setGravity(5);
      AppMethodBeat.o(146593);
      return;
    }
    paramString.equals("center");
    this.mJu.setGravity(17);
    AppMethodBeat.o(146593);
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(146589);
    this.mJu.setText(paramString);
    AppMethodBeat.o(146589);
  }
  
  public final void setTextColor(int paramInt)
  {
    AppMethodBeat.i(146591);
    this.mJu.setTextColor(paramInt);
    AppMethodBeat.o(146591);
  }
  
  public final void setTextPadding(int paramInt)
  {
    AppMethodBeat.i(146592);
    this.mJu.setPadding(paramInt, paramInt, paramInt, paramInt);
    AppMethodBeat.o(146592);
  }
  
  public final void setTextSize(int paramInt)
  {
    AppMethodBeat.i(146590);
    this.mJu.setTextSize(paramInt);
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
    this.mJu.setBackgroundDrawable(localGradientDrawable);
    AppMethodBeat.o(146588);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.d.d
 * JD-Core Version:    0.7.0.1
 */