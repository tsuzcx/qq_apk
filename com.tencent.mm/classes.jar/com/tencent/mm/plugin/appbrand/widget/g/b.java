package com.tencent.mm.plugin.appbrand.widget.g;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends LinearLayout
{
  public static final int uMs;
  public static final int uMt;
  private TextView mll;
  
  static
  {
    AppMethodBeat.i(146580);
    uMs = Color.parseColor("#000000");
    uMt = Color.parseColor("#000000");
    AppMethodBeat.o(146580);
  }
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(146572);
    setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    setOrientation(1);
    setGravity(17);
    this.mll = new TextView(paramContext);
    this.mll.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    addView(this.mll);
    AppMethodBeat.o(146572);
  }
  
  private void Ex(int paramInt)
  {
    AppMethodBeat.i(146579);
    setPadding(paramInt, paramInt, paramInt, paramInt);
    AppMethodBeat.o(146579);
  }
  
  public final void J(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(146578);
    Ex(paramInt2);
    a locala = new a();
    locala.borderRadius = paramInt1;
    locala.setColor(paramInt4);
    locala.ge(paramInt2, paramInt3);
    setBackgroundDrawable(locala);
    AppMethodBeat.o(146578);
  }
  
  public final void setGravity(String paramString)
  {
    AppMethodBeat.i(146577);
    if (paramString.equals("left"))
    {
      this.mll.setGravity(3);
      AppMethodBeat.o(146577);
      return;
    }
    if (paramString.equals("right"))
    {
      this.mll.setGravity(5);
      AppMethodBeat.o(146577);
      return;
    }
    paramString.equals("center");
    this.mll.setGravity(17);
    AppMethodBeat.o(146577);
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(146573);
    this.mll.setText(paramString);
    AppMethodBeat.o(146573);
  }
  
  public final void setTextColor(int paramInt)
  {
    AppMethodBeat.i(146575);
    this.mll.setTextColor(paramInt);
    AppMethodBeat.o(146575);
  }
  
  public final void setTextSize(int paramInt)
  {
    AppMethodBeat.i(146574);
    this.mll.setTextSize(paramInt);
    AppMethodBeat.o(146574);
  }
  
  public final void setTitlePadding(int paramInt)
  {
    AppMethodBeat.i(146576);
    this.mll.setPadding(paramInt, paramInt, paramInt, paramInt);
    AppMethodBeat.o(146576);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.g.b
 * JD-Core Version:    0.7.0.1
 */