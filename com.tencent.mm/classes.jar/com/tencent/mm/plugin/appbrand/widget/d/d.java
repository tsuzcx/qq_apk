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
  public static final int noO;
  public static final int noP;
  public static final int noZ;
  private float anchorX;
  private float anchorY;
  private TextView noY;
  private int npa;
  private int npb;
  private int npc;
  private int npd;
  public int x;
  public int y;
  
  static
  {
    AppMethodBeat.i(146596);
    noO = Color.parseColor("#000000");
    noZ = Color.parseColor("#000000");
    noP = Color.parseColor("#000000");
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
    this.noY = new TextView(paramContext);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    this.noY.setLayoutParams(paramContext);
    addView(this.noY);
    AppMethodBeat.o(146587);
  }
  
  public final void A(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(146588);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(paramInt1);
    localGradientDrawable.setStroke(paramInt2, paramInt3);
    localGradientDrawable.setColor(paramInt4);
    this.noY.setBackgroundDrawable(localGradientDrawable);
    AppMethodBeat.o(146588);
  }
  
  public final void eA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(212602);
    if ((paramInt1 < 0) || (paramInt2 < 0))
    {
      AppMethodBeat.o(212602);
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.noY.getLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    this.noY.setLayoutParams(localLayoutParams);
    invalidate();
    AppMethodBeat.o(212602);
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
    this.npa = getMeasuredWidth();
    this.npb = getMeasuredHeight();
    if ((-this.npa < this.x) && (this.x < 0))
    {
      this.npc = this.npa;
      this.anchorX = (Math.abs(this.x) / (this.npa * 1.0F));
      if ((-this.npb >= this.y) || (this.y >= 0)) {
        break label189;
      }
      this.npd = this.npb;
      this.anchorY = (Math.abs(this.y) / (this.npb * 1.0F));
    }
    for (;;)
    {
      setMeasuredDimension(this.npc, this.npd);
      AppMethodBeat.o(146594);
      return;
      if (this.x >= 0)
      {
        this.npc = (this.npa + Math.abs(this.x));
        this.anchorX = 0.0F;
        break;
      }
      this.npc = Math.abs(this.x);
      this.anchorX = 1.0F;
      break;
      label189:
      if (this.y >= 0)
      {
        this.npd = (this.npb + Math.abs(this.y));
        this.anchorY = 0.0F;
      }
      else
      {
        this.npd = Math.abs(this.y);
        this.anchorY = 1.0F;
      }
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(182824);
    setText("");
    setTextSize(12);
    setTextColor(noO);
    setTextPadding(0);
    setGravity("center");
    int i = noP;
    A(0, 0, i, i);
    AppMethodBeat.o(182824);
  }
  
  public final void setGravity(String paramString)
  {
    AppMethodBeat.i(146593);
    this.noY.setGravity(17);
    AppMethodBeat.o(146593);
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(146589);
    this.noY.setText(paramString);
    AppMethodBeat.o(146589);
  }
  
  public final void setTextColor(int paramInt)
  {
    AppMethodBeat.i(146591);
    this.noY.setTextColor(paramInt);
    AppMethodBeat.o(146591);
  }
  
  public final void setTextPadding(int paramInt)
  {
    AppMethodBeat.i(146592);
    this.noY.setPadding(paramInt, paramInt, paramInt, paramInt);
    AppMethodBeat.o(146592);
  }
  
  public final void setTextSize(int paramInt)
  {
    AppMethodBeat.i(146590);
    this.noY.setTextSize(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.d.d
 * JD-Core Version:    0.7.0.1
 */