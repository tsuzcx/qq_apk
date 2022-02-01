package com.tencent.mm.memory.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.i;
import com.tencent.mm.memory.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;

public class a
  extends Drawable
  implements i
{
  boolean DEBUG;
  protected final Paint hxL;
  private final ap hxM;
  protected n hxN;
  private Runnable hxO;
  protected String tag;
  
  public a(String paramString, n paramn)
  {
    AppMethodBeat.i(156523);
    this.hxL = new Paint();
    this.DEBUG = false;
    this.hxO = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(156522);
        ad.d("MicroMsg.MaskBitmapDrawable", "refresh tag=%s", new Object[] { a.this.tag });
        a.this.invalidateSelf();
        AppMethodBeat.o(156522);
      }
    };
    this.tag = paramString;
    this.hxN = paramn;
    this.hxL.setAntiAlias(true);
    this.hxL.setFilterBitmap(false);
    this.hxL.setColor(-1118482);
    this.hxM = new ap(Looper.getMainLooper());
    AppMethodBeat.o(156523);
  }
  
  public final void ayB()
  {
    AppMethodBeat.i(156525);
    if (this.hxN != null) {
      this.hxN.ayB();
    }
    AppMethodBeat.o(156525);
  }
  
  public final void ayC()
  {
    AppMethodBeat.i(156526);
    if (this.hxN != null) {
      this.hxN.ayC();
    }
    AppMethodBeat.o(156526);
  }
  
  public final n ayW()
  {
    if (this.hxN != null) {
      return this.hxN;
    }
    return null;
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(156524);
    Rect localRect = getBounds();
    n localn = this.hxN;
    if ((localn == null) || (localn.isRecycled()))
    {
      paramCanvas.drawColor(-1118482);
      AppMethodBeat.o(156524);
      return;
    }
    Paint localPaint = this.hxL;
    paramCanvas.drawBitmap(localn.bitmap, null, localRect, localPaint);
    AppMethodBeat.o(156524);
  }
  
  public int getIntrinsicHeight()
  {
    AppMethodBeat.i(156528);
    if (this.hxN == null)
    {
      AppMethodBeat.o(156528);
      return 0;
    }
    n localn = this.hxN;
    if ((localn != null) && (!localn.isRecycled()))
    {
      int i = localn.bitmap.getHeight();
      AppMethodBeat.o(156528);
      return i;
    }
    AppMethodBeat.o(156528);
    return 0;
  }
  
  public int getIntrinsicWidth()
  {
    AppMethodBeat.i(156527);
    if (this.hxN == null)
    {
      AppMethodBeat.o(156527);
      return 0;
    }
    n localn = this.hxN;
    if ((localn != null) && (!localn.isRecycled()))
    {
      int i = localn.bitmap.getWidth();
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
      if (this.hxN != null) {
        str1 = str2 + this.hxN;
      }
      AppMethodBeat.o(156529);
      return str1;
    }
    String str1 = super.toString();
    AppMethodBeat.o(156529);
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.memory.b.a
 * JD-Core Version:    0.7.0.1
 */