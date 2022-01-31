package com.tencent.mm.plugin.appbrand.widget.e;

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
  public static final int jrD;
  public static final int jrs;
  public static final int jrt;
  private float bna;
  private float bnb;
  private TextView jrC;
  private int jrE;
  private int jrF;
  private int jrG;
  private int jrH;
  public int x;
  public int y;
  
  static
  {
    AppMethodBeat.i(51274);
    jrs = Color.parseColor("#000000");
    jrD = Color.parseColor("#000000");
    jrt = Color.parseColor("#000000");
    AppMethodBeat.o(51274);
  }
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51265);
    this.x = 0;
    this.y = 0;
    this.bna = 0.0F;
    this.bnb = 0.0F;
    setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    this.jrC = new TextView(paramContext);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    this.jrC.setLayoutParams(paramContext);
    addView(this.jrC);
    AppMethodBeat.o(51265);
  }
  
  public final float getAnchorX()
  {
    return this.bna;
  }
  
  public final float getAnchorY()
  {
    return this.bnb;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(51273);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)getChildAt(0).getLayoutParams();
    if ((this.x >= 0) && (this.y >= 0)) {
      localLayoutParams.gravity = 85;
    }
    for (;;)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(51273);
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
    AppMethodBeat.i(51272);
    super.onMeasure(paramInt1, paramInt2);
    this.jrE = getMeasuredWidth();
    this.jrF = getMeasuredHeight();
    if ((-this.jrE < this.x) && (this.x < 0))
    {
      this.jrG = this.jrE;
      this.bna = (Math.abs(this.x) / (this.jrE * 1.0F));
      if ((-this.jrF >= this.y) || (this.y >= 0)) {
        break label189;
      }
      this.jrH = this.jrF;
      this.bnb = (Math.abs(this.y) / (this.jrF * 1.0F));
    }
    for (;;)
    {
      setMeasuredDimension(this.jrG, this.jrH);
      AppMethodBeat.o(51272);
      return;
      if (this.x >= 0)
      {
        this.jrG = (this.jrE + Math.abs(this.x));
        this.bna = 0.0F;
        break;
      }
      this.jrG = Math.abs(this.x);
      this.bna = 1.0F;
      break;
      label189:
      if (this.y >= 0)
      {
        this.jrH = (this.jrF + Math.abs(this.y));
        this.bnb = 0.0F;
      }
      else
      {
        this.jrH = Math.abs(this.y);
        this.bnb = 1.0F;
      }
    }
  }
  
  public final void setGravity(String paramString)
  {
    AppMethodBeat.i(51271);
    if (paramString.equals("left"))
    {
      this.jrC.setGravity(3);
      AppMethodBeat.o(51271);
      return;
    }
    if (paramString.equals("right"))
    {
      this.jrC.setGravity(5);
      AppMethodBeat.o(51271);
      return;
    }
    paramString.equals("center");
    this.jrC.setGravity(17);
    AppMethodBeat.o(51271);
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(51267);
    this.jrC.setText(paramString);
    AppMethodBeat.o(51267);
  }
  
  public final void setTextColor(int paramInt)
  {
    AppMethodBeat.i(51269);
    this.jrC.setTextColor(paramInt);
    AppMethodBeat.o(51269);
  }
  
  public final void setTextPadding(int paramInt)
  {
    AppMethodBeat.i(51270);
    this.jrC.setPadding(paramInt, paramInt, paramInt, paramInt);
    AppMethodBeat.o(51270);
  }
  
  public final void setTextSize(int paramInt)
  {
    AppMethodBeat.i(51268);
    this.jrC.setTextSize(paramInt);
    AppMethodBeat.o(51268);
  }
  
  public final void setX(int paramInt)
  {
    this.x = paramInt;
  }
  
  public final void setY(int paramInt)
  {
    this.y = paramInt;
  }
  
  public final void x(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(51266);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(paramInt1);
    localGradientDrawable.setStroke(paramInt2, paramInt3);
    localGradientDrawable.setColor(paramInt4);
    this.jrC.setBackgroundDrawable(localGradientDrawable);
    AppMethodBeat.o(51266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.e.d
 * JD-Core Version:    0.7.0.1
 */