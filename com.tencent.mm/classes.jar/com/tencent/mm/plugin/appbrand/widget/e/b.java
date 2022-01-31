package com.tencent.mm.plugin.appbrand.widget.e;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends LinearLayout
{
  public static final int jrs;
  public static final int jrt;
  private TextView gui;
  
  static
  {
    AppMethodBeat.i(51259);
    jrs = Color.parseColor("#000000");
    jrt = Color.parseColor("#000000");
    AppMethodBeat.o(51259);
  }
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51251);
    setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    setOrientation(1);
    setGravity(17);
    this.gui = new TextView(paramContext);
    this.gui.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    addView(this.gui);
    AppMethodBeat.o(51251);
  }
  
  private void qF(int paramInt)
  {
    AppMethodBeat.i(51258);
    setPadding(paramInt, paramInt, paramInt, paramInt);
    AppMethodBeat.o(51258);
  }
  
  public final void setGravity(String paramString)
  {
    AppMethodBeat.i(51256);
    if (paramString.equals("left"))
    {
      this.gui.setGravity(3);
      AppMethodBeat.o(51256);
      return;
    }
    if (paramString.equals("right"))
    {
      this.gui.setGravity(5);
      AppMethodBeat.o(51256);
      return;
    }
    paramString.equals("center");
    this.gui.setGravity(17);
    AppMethodBeat.o(51256);
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(51252);
    this.gui.setText(paramString);
    AppMethodBeat.o(51252);
  }
  
  public final void setTextColor(int paramInt)
  {
    AppMethodBeat.i(51254);
    this.gui.setTextColor(paramInt);
    AppMethodBeat.o(51254);
  }
  
  public final void setTextSize(int paramInt)
  {
    AppMethodBeat.i(51253);
    this.gui.setTextSize(paramInt);
    AppMethodBeat.o(51253);
  }
  
  public final void setTitlePadding(int paramInt)
  {
    AppMethodBeat.i(51255);
    this.gui.setPadding(paramInt, paramInt, paramInt, paramInt);
    AppMethodBeat.o(51255);
  }
  
  public final void x(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(51257);
    qF(paramInt2);
    a locala = new a();
    locala.borderRadius = paramInt1;
    locala.setColor(paramInt4);
    locala.setStroke(paramInt2, paramInt3);
    setBackgroundDrawable(locala);
    AppMethodBeat.o(51257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.e.b
 * JD-Core Version:    0.7.0.1
 */