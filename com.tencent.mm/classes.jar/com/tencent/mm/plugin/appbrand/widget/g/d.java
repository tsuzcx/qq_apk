package com.tencent.mm.plugin.appbrand.widget.g;

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
  public static final int uMD;
  public static final int uMs;
  public static final int uMt;
  private float anchorX;
  private float anchorY;
  private TextView uMC;
  private int uME;
  private int uMF;
  private int uMG;
  private int uMH;
  public int x;
  public int y;
  
  static
  {
    AppMethodBeat.i(146596);
    uMs = Color.parseColor("#000000");
    uMD = Color.parseColor("#000000");
    uMt = Color.parseColor("#000000");
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
    this.uMC = new TextView(paramContext);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    this.uMC.setLayoutParams(paramContext);
    addView(this.uMC);
    AppMethodBeat.o(146587);
  }
  
  public final void J(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(146588);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(paramInt1);
    localGradientDrawable.setStroke(paramInt2, paramInt3);
    localGradientDrawable.setColor(paramInt4);
    this.uMC.setBackgroundDrawable(localGradientDrawable);
    AppMethodBeat.o(146588);
  }
  
  public final float getAnchorX()
  {
    return this.anchorX;
  }
  
  public final float getAnchorY()
  {
    return this.anchorY;
  }
  
  public final void gf(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(324004);
    if ((paramInt1 < 0) || (paramInt2 < 0))
    {
      AppMethodBeat.o(324004);
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.uMC.getLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    this.uMC.setLayoutParams(localLayoutParams);
    invalidate();
    AppMethodBeat.o(324004);
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
    this.uME = getMeasuredWidth();
    this.uMF = getMeasuredHeight();
    if ((-this.uME < this.x) && (this.x < 0))
    {
      this.uMG = this.uME;
      this.anchorX = (Math.abs(this.x) / (this.uME * 1.0F));
      if ((-this.uMF >= this.y) || (this.y >= 0)) {
        break label189;
      }
      this.uMH = this.uMF;
      this.anchorY = (Math.abs(this.y) / (this.uMF * 1.0F));
    }
    for (;;)
    {
      setMeasuredDimension(this.uMG, this.uMH);
      AppMethodBeat.o(146594);
      return;
      if (this.x >= 0)
      {
        this.uMG = (this.uME + Math.abs(this.x));
        this.anchorX = 0.0F;
        break;
      }
      this.uMG = Math.abs(this.x);
      this.anchorX = 1.0F;
      break;
      label189:
      if (this.y >= 0)
      {
        this.uMH = (this.uMF + Math.abs(this.y));
        this.anchorY = 0.0F;
      }
      else
      {
        this.uMH = Math.abs(this.y);
        this.anchorY = 1.0F;
      }
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(182824);
    setText("");
    setTextSize(12);
    setTextColor(uMs);
    setTextPadding(0);
    setGravity("center");
    int i = uMt;
    J(0, 0, i, i);
    AppMethodBeat.o(182824);
  }
  
  public final void setGravity(String paramString)
  {
    AppMethodBeat.i(146593);
    this.uMC.setGravity(17);
    AppMethodBeat.o(146593);
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(146589);
    this.uMC.setText(paramString);
    AppMethodBeat.o(146589);
  }
  
  public final void setTextColor(int paramInt)
  {
    AppMethodBeat.i(146591);
    this.uMC.setTextColor(paramInt);
    AppMethodBeat.o(146591);
  }
  
  public final void setTextPadding(int paramInt)
  {
    AppMethodBeat.i(146592);
    this.uMC.setPadding(paramInt, paramInt, paramInt, paramInt);
    AppMethodBeat.o(146592);
  }
  
  public final void setTextSize(int paramInt)
  {
    AppMethodBeat.i(146590);
    this.uMC.setTextSize(paramInt);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.g.d
 * JD-Core Version:    0.7.0.1
 */