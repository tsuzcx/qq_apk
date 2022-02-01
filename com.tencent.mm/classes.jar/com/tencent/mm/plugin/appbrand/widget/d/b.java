package com.tencent.mm.plugin.appbrand.widget.d;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends LinearLayout
{
  public static final int njG;
  public static final int njH;
  private TextView gnM;
  
  static
  {
    AppMethodBeat.i(146580);
    njG = Color.parseColor("#000000");
    njH = Color.parseColor("#000000");
    AppMethodBeat.o(146580);
  }
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(146572);
    setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    setOrientation(1);
    setGravity(17);
    this.gnM = new TextView(paramContext);
    this.gnM.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    addView(this.gnM);
    AppMethodBeat.o(146572);
  }
  
  private void wD(int paramInt)
  {
    AppMethodBeat.i(146579);
    setPadding(paramInt, paramInt, paramInt, paramInt);
    AppMethodBeat.o(146579);
  }
  
  public final void A(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(146578);
    wD(paramInt2);
    a locala = new a();
    locala.borderRadius = paramInt1;
    locala.setColor(paramInt4);
    locala.setStroke(paramInt2, paramInt3);
    setBackgroundDrawable(locala);
    AppMethodBeat.o(146578);
  }
  
  public final void setGravity(String paramString)
  {
    AppMethodBeat.i(146577);
    if (paramString.equals("left"))
    {
      this.gnM.setGravity(3);
      AppMethodBeat.o(146577);
      return;
    }
    if (paramString.equals("right"))
    {
      this.gnM.setGravity(5);
      AppMethodBeat.o(146577);
      return;
    }
    paramString.equals("center");
    this.gnM.setGravity(17);
    AppMethodBeat.o(146577);
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(146573);
    this.gnM.setText(paramString);
    AppMethodBeat.o(146573);
  }
  
  public final void setTextColor(int paramInt)
  {
    AppMethodBeat.i(146575);
    this.gnM.setTextColor(paramInt);
    AppMethodBeat.o(146575);
  }
  
  public final void setTextSize(int paramInt)
  {
    AppMethodBeat.i(146574);
    this.gnM.setTextSize(paramInt);
    AppMethodBeat.o(146574);
  }
  
  public final void setTitlePadding(int paramInt)
  {
    AppMethodBeat.i(146576);
    this.gnM.setPadding(paramInt, paramInt, paramInt, paramInt);
    AppMethodBeat.o(146576);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.d.b
 * JD-Core Version:    0.7.0.1
 */