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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class a
  extends Drawable
  implements i
{
  boolean DEBUG;
  protected final Paint iuG;
  private final MMHandler iuH;
  protected n iuI;
  private Runnable iuJ;
  protected String tag;
  
  public a(String paramString, n paramn)
  {
    AppMethodBeat.i(156523);
    this.iuG = new Paint();
    this.DEBUG = false;
    this.iuJ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(156522);
        Log.d("MicroMsg.MaskBitmapDrawable", "refresh tag=%s", new Object[] { a.this.tag });
        a.this.invalidateSelf();
        AppMethodBeat.o(156522);
      }
    };
    this.tag = paramString;
    this.iuI = paramn;
    this.iuG.setAntiAlias(true);
    this.iuG.setFilterBitmap(false);
    this.iuG.setColor(-1118482);
    this.iuH = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(156523);
  }
  
  public final void aRW()
  {
    AppMethodBeat.i(156525);
    if (this.iuI != null) {
      this.iuI.aRW();
    }
    AppMethodBeat.o(156525);
  }
  
  public final void aRX()
  {
    AppMethodBeat.i(156526);
    if (this.iuI != null) {
      this.iuI.aRX();
    }
    AppMethodBeat.o(156526);
  }
  
  public final n aSr()
  {
    if (this.iuI != null) {
      return this.iuI;
    }
    return null;
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(156524);
    Rect localRect = getBounds();
    n localn = this.iuI;
    if ((localn == null) || (localn.isRecycled()))
    {
      paramCanvas.drawColor(-1118482);
      AppMethodBeat.o(156524);
      return;
    }
    Paint localPaint = this.iuG;
    paramCanvas.drawBitmap(localn.bitmap, null, localRect, localPaint);
    AppMethodBeat.o(156524);
  }
  
  public int getIntrinsicHeight()
  {
    AppMethodBeat.i(156528);
    if (this.iuI == null)
    {
      AppMethodBeat.o(156528);
      return 0;
    }
    n localn = this.iuI;
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
    if (this.iuI == null)
    {
      AppMethodBeat.o(156527);
      return 0;
    }
    n localn = this.iuI;
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
      if (this.iuI != null) {
        str1 = str2 + this.iuI;
      }
      AppMethodBeat.o(156529);
      return str1;
    }
    String str1 = super.toString();
    AppMethodBeat.o(156529);
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.memory.b.a
 * JD-Core Version:    0.7.0.1
 */