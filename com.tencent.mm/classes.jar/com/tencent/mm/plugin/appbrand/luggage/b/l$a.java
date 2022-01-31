package com.tencent.mm.plugin.appbrand.luggage.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.c.a;
import com.tencent.mm.plugin.gif.MMAnimateView;

public final class l$a
  extends FrameLayout
  implements a
{
  private ImageView ioq;
  private MMAnimateView ior;
  private boolean ios;
  
  public l$a(l paraml, Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(132104);
    this.ior = new MMAnimateView(paramContext);
    addView(this.ior, new ViewGroup.LayoutParams(-1, -1));
    this.ior.setVisibility(8);
    this.ioq = new ImageView(paramContext);
    addView(this.ioq, new ViewGroup.LayoutParams(-1, -1));
    this.ioq.setVisibility(8);
    AppMethodBeat.o(132104);
  }
  
  public final boolean aCe()
  {
    return this.ios;
  }
  
  public final View getView()
  {
    return this;
  }
  
  public final void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(132107);
    this.ior.setVisibility(8);
    this.ioq.setVisibility(0);
    this.ioq.setImageBitmap(paramBitmap);
    AppMethodBeat.o(132107);
  }
  
  public final void setImageByteArray(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132106);
    this.ior.setVisibility(0);
    this.ioq.setVisibility(8);
    this.ior.f(paramArrayOfByte, "");
    AppMethodBeat.o(132106);
  }
  
  public final void setImageFilePath(String paramString)
  {
    AppMethodBeat.i(132105);
    this.ior.setVisibility(0);
    this.ioq.setVisibility(8);
    this.ior.setImageFilePath(paramString);
    AppMethodBeat.o(132105);
  }
  
  public final void setInterceptEvent(boolean paramBoolean)
  {
    this.ios = paramBoolean;
  }
  
  public final void setScaleType(ImageView.ScaleType paramScaleType)
  {
    AppMethodBeat.i(132108);
    this.ioq.setScaleType(paramScaleType);
    this.ior.setScaleType(paramScaleType);
    AppMethodBeat.o(132108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.l.a
 * JD-Core Version:    0.7.0.1
 */