package com.tencent.mm.memory.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.h;
import com.tencent.mm.memory.m;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class a
  extends Drawable
  implements h
{
  boolean DEBUG;
  protected final Paint nOA;
  private final MMHandler nOB;
  protected m nOC;
  private Runnable nOD;
  protected String tag;
  
  public a(String paramString, m paramm)
  {
    AppMethodBeat.i(156523);
    this.nOA = new Paint();
    this.DEBUG = false;
    this.nOD = new a.1(this);
    this.tag = paramString;
    this.nOC = paramm;
    this.nOA.setAntiAlias(true);
    this.nOA.setFilterBitmap(false);
    this.nOA.setColor(-1118482);
    this.nOB = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(156523);
  }
  
  public final void bvM()
  {
    AppMethodBeat.i(156525);
    if (this.nOC != null) {
      this.nOC.bvM();
    }
    AppMethodBeat.o(156525);
  }
  
  public final void bvN()
  {
    AppMethodBeat.i(156526);
    if (this.nOC != null) {
      this.nOC.bvN();
    }
    AppMethodBeat.o(156526);
  }
  
  public final m bwj()
  {
    if (this.nOC != null) {
      return this.nOC;
    }
    return null;
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(156524);
    Rect localRect = getBounds();
    m localm = this.nOC;
    if ((localm == null) || (localm.bvS()))
    {
      paramCanvas.drawColor(-1118482);
      AppMethodBeat.o(156524);
      return;
    }
    Paint localPaint = this.nOA;
    paramCanvas.drawBitmap(localm.bitmap, null, localRect, localPaint);
    AppMethodBeat.o(156524);
  }
  
  public int getIntrinsicHeight()
  {
    AppMethodBeat.i(156528);
    if (this.nOC == null)
    {
      AppMethodBeat.o(156528);
      return 0;
    }
    m localm = this.nOC;
    if ((localm != null) && (!localm.bvS()))
    {
      int i = localm.bitmap.getHeight();
      AppMethodBeat.o(156528);
      return i;
    }
    AppMethodBeat.o(156528);
    return 0;
  }
  
  public int getIntrinsicWidth()
  {
    AppMethodBeat.i(156527);
    if (this.nOC == null)
    {
      AppMethodBeat.o(156527);
      return 0;
    }
    m localm = this.nOC;
    if ((localm != null) && (!localm.bvS()))
    {
      int i = localm.bitmap.getWidth();
      AppMethodBeat.o(156527);
      return i;
    }
    AppMethodBeat.o(156527);
    return 0;
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public String toString()
  {
    AppMethodBeat.i(156529);
    if (this.DEBUG)
    {
      String str2 = super.toString() + " code: " + hashCode();
      str1 = str2;
      if (this.nOC != null) {
        str1 = str2 + this.nOC;
      }
      AppMethodBeat.o(156529);
      return str1;
    }
    String str1 = super.toString();
    AppMethodBeat.o(156529);
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.memory.b.a
 * JD-Core Version:    0.7.0.1
 */