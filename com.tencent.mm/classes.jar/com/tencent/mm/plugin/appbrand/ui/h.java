package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.statusbar.b;

@SuppressLint({"ViewConstructor"})
public final class h
  extends b
  implements r
{
  private final Bitmap iOx;
  
  public h(Context paramContext, Bitmap paramBitmap)
  {
    super(paramContext);
    AppMethodBeat.i(143611);
    this.iOx = paramBitmap;
    rq(true);
    setBackground(new BitmapDrawable(getResources(), paramBitmap));
    paramContext = LayoutInflater.from(paramContext).inflate(2130968739, this, true);
    ((TextView)paramContext.findViewById(2131820680)).setText(2131296709);
    paramContext.findViewById(2131821405).setVisibility(8);
    AppMethodBeat.o(143611);
  }
  
  public final void aHA()
  {
    AppMethodBeat.i(133092);
    post(new h.1(this));
    AppMethodBeat.o(133092);
  }
  
  public final void aHB() {}
  
  public final void cD(String paramString1, String paramString2) {}
  
  public final View getView()
  {
    return this;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(133093);
    super.onDetachedFromWindow();
    this.iOx.recycle();
    AppMethodBeat.o(133093);
  }
  
  public final void setProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.h
 * JD-Core Version:    0.7.0.1
 */