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
import com.tencent.mm.sdk.platformtools.ak;

public class a
  extends Drawable
  implements i
{
  boolean DEBUG;
  protected final Paint feS;
  private final ak feT;
  protected n feU;
  private Runnable feV;
  protected String tag;
  
  public a(String paramString, n paramn)
  {
    AppMethodBeat.i(115476);
    this.feS = new Paint();
    this.DEBUG = false;
    this.feV = new a.1(this);
    this.tag = paramString;
    this.feU = paramn;
    this.feS.setAntiAlias(true);
    this.feS.setFilterBitmap(false);
    this.feS.setColor(-1118482);
    this.feT = new ak(Looper.getMainLooper());
    AppMethodBeat.o(115476);
  }
  
  public final void XO()
  {
    AppMethodBeat.i(115478);
    if (this.feU != null) {
      this.feU.XO();
    }
    AppMethodBeat.o(115478);
  }
  
  public final void XP()
  {
    AppMethodBeat.i(115479);
    if (this.feU != null) {
      this.feU.XP();
    }
    AppMethodBeat.o(115479);
  }
  
  public final n Yi()
  {
    if (this.feU != null) {
      return this.feU;
    }
    return null;
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(115477);
    Rect localRect = getBounds();
    n localn = this.feU;
    if ((localn == null) || (localn.isRecycled()))
    {
      paramCanvas.drawColor(-1118482);
      AppMethodBeat.o(115477);
      return;
    }
    Paint localPaint = this.feS;
    paramCanvas.drawBitmap(localn.bitmap, null, localRect, localPaint);
    AppMethodBeat.o(115477);
  }
  
  public int getIntrinsicHeight()
  {
    AppMethodBeat.i(115481);
    if (this.feU == null)
    {
      AppMethodBeat.o(115481);
      return 0;
    }
    n localn = this.feU;
    if ((localn != null) && (!localn.isRecycled()))
    {
      int i = localn.bitmap.getHeight();
      AppMethodBeat.o(115481);
      return i;
    }
    AppMethodBeat.o(115481);
    return 0;
  }
  
  public int getIntrinsicWidth()
  {
    AppMethodBeat.i(115480);
    if (this.feU == null)
    {
      AppMethodBeat.o(115480);
      return 0;
    }
    n localn = this.feU;
    if ((localn != null) && (!localn.isRecycled()))
    {
      int i = localn.bitmap.getWidth();
      AppMethodBeat.o(115480);
      return i;
    }
    AppMethodBeat.o(115480);
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
    AppMethodBeat.i(115482);
    if (this.DEBUG)
    {
      String str2 = super.toString() + " code: " + hashCode();
      str1 = str2;
      if (this.feU != null) {
        str1 = str2 + this.feU;
      }
      AppMethodBeat.o(115482);
      return str1;
    }
    String str1 = super.toString();
    AppMethodBeat.o(115482);
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.memory.b.a
 * JD-Core Version:    0.7.0.1
 */