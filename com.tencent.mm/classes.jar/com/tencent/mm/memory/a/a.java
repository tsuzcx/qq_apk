package com.tencent.mm.memory.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import com.tencent.mm.memory.i;
import com.tencent.mm.memory.n;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public class a
  extends Drawable
  implements i
{
  public static final Paint dPt;
  private static final ah dPu = new ah(Looper.getMainLooper());
  boolean DEBUG = false;
  public n dPv;
  private Runnable dPw = new Runnable()
  {
    public final void run()
    {
      y.d("MicroMsg.MaskBitmapDrawable", "refresh tag=%s", new Object[] { a.this.tag });
      a.this.invalidateSelf();
    }
  };
  protected String tag;
  
  static
  {
    Paint localPaint = new Paint();
    dPt = localPaint;
    localPaint.setAntiAlias(true);
    dPt.setFilterBitmap(false);
    dPt.setColor(-1118482);
  }
  
  public a(String paramString, n paramn)
  {
    this.tag = paramString;
    this.dPv = paramn;
  }
  
  public final void EZ()
  {
    if (this.dPv != null) {
      this.dPv.EZ();
    }
  }
  
  public final void Fa()
  {
    if (this.dPv != null) {
      this.dPv.Fa();
    }
  }
  
  public final n Fi()
  {
    if (this.dPv != null) {
      return this.dPv;
    }
    return null;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    n localn = this.dPv;
    if ((localn == null) || (localn.isRecycled()))
    {
      paramCanvas.drawColor(-1118482);
      return;
    }
    Paint localPaint = dPt;
    paramCanvas.drawBitmap(localn.bitmap, null, localRect, localPaint);
  }
  
  public int getIntrinsicHeight()
  {
    if (this.dPv == null) {}
    n localn;
    do
    {
      return 0;
      localn = this.dPv;
    } while ((localn == null) || (localn.isRecycled()));
    return localn.bitmap.getHeight();
  }
  
  public int getIntrinsicWidth()
  {
    if (this.dPv == null) {}
    n localn;
    do
    {
      return 0;
      localn = this.dPv;
    } while ((localn == null) || (localn.isRecycled()));
    return localn.bitmap.getWidth();
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public String toString()
  {
    if (this.DEBUG)
    {
      String str2 = super.toString() + " code: " + hashCode();
      String str1 = str2;
      if (this.dPv != null) {
        str1 = str2 + this.dPv;
      }
      return str1;
    }
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.memory.a.a
 * JD-Core Version:    0.7.0.1
 */