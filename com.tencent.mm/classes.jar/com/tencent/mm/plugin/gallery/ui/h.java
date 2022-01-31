package com.tencent.mm.plugin.gallery.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class h
  extends Drawable
{
  private static final Paint feS;
  private static Rect rect;
  protected int cth;
  protected ImageView ioq;
  private Bitmap mBitmap;
  protected String mFilePath;
  private int mWidth;
  protected String ncH;
  protected long ncI;
  protected boolean nhj;
  public h.a nhk;
  long nhl;
  boolean nhm;
  private Rect nhn;
  
  static
  {
    AppMethodBeat.i(21619);
    feS = new Paint();
    rect = null;
    feS.setAntiAlias(true);
    feS.setFilterBitmap(true);
    AppMethodBeat.o(21619);
  }
  
  private h(ImageView paramImageView)
  {
    AppMethodBeat.i(21610);
    this.cth = 0;
    this.mFilePath = "";
    this.ncH = "";
    this.nhj = false;
    this.ncI = 0L;
    this.nhm = false;
    this.nhn = new Rect();
    this.ioq = paramImageView;
    this.mFilePath = "";
    AppMethodBeat.o(21610);
  }
  
  private static void a(Bitmap paramBitmap, Rect paramRect)
  {
    AppMethodBeat.i(21616);
    if (paramBitmap.getWidth() > paramBitmap.getHeight())
    {
      paramRect.top = 0;
      paramRect.bottom = paramBitmap.getHeight();
      paramRect.left = (paramBitmap.getWidth() - paramBitmap.getHeight() >> 1);
      paramRect.right = (paramRect.left + paramBitmap.getHeight());
      AppMethodBeat.o(21616);
      return;
    }
    paramRect.left = 0;
    paramRect.right = paramBitmap.getWidth();
    paramRect.top = (paramBitmap.getHeight() - paramBitmap.getWidth() >> 1);
    paramRect.bottom = (paramRect.top + paramBitmap.getWidth());
    AppMethodBeat.o(21616);
  }
  
  public static void a(ImageView paramImageView, int paramInt, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(21617);
    a(paramImageView, paramInt, paramString1, paramString2, paramLong, -1, null);
    AppMethodBeat.o(21617);
  }
  
  public static void a(ImageView paramImageView, int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2, h.a parama)
  {
    AppMethodBeat.i(21618);
    Object localObject = paramImageView.getDrawable();
    if ((localObject != null) && ((localObject instanceof h))) {}
    for (localObject = (h)localObject;; localObject = new h(paramImageView))
    {
      if (paramInt2 > 0) {
        ((h)localObject).mWidth = paramInt2;
      }
      ((h)localObject).nhk = parama;
      ((h)localObject).b(paramInt1, paramString1, paramString2, paramLong);
      paramImageView.setImageDrawable((Drawable)localObject);
      AppMethodBeat.o(21618);
      return;
    }
  }
  
  private void b(int paramInt, String paramString1, String paramString2, long paramLong)
  {
    boolean bool2 = false;
    AppMethodBeat.i(21611);
    if (bo.isNullOrNil(paramString1)) {}
    for (String str = paramString2; bo.isNullOrNil(str); str = paramString1)
    {
      ab.e("MicroMsg.ThumbDrawable", "filepath is null or nil");
      AppMethodBeat.o(21611);
      return;
    }
    if (!bo.isNullOrNil(paramString1))
    {
      this.nhj = true;
      e.bDP().a(new h.c(this.ioq));
      if ((this.mFilePath.equals(str)) && (this.mBitmap != null) && (!this.mBitmap.isRecycled())) {
        break label317;
      }
      this.mFilePath = str;
      this.ncH = paramString2;
      this.ncI = paramLong;
      this.cth = paramInt;
      this.mBitmap = e.bDP().Pz(this.mFilePath);
      if (this.mBitmap != null) {
        break label297;
      }
      bool1 = true;
      label151:
      if (this.mBitmap == null) {
        break label303;
      }
      bool2 = this.mBitmap.isRecycled();
      label167:
      ab.d("MicroMsg.ThumbDrawable", "setMediaFeature ok filePath:[%s] mBitmap:[%s], mBitmap.isRecycled():[%s]", new Object[] { str, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((this.mBitmap != null) && (!this.mBitmap.isRecycled())) {
        break label309;
      }
      this.nhm = true;
      this.nhl = 0L;
      this.mBitmap = e.bDP().b(str, paramInt, paramString2, paramLong);
    }
    for (;;)
    {
      if ((this.nhk != null) && (this.mBitmap != null) && (!this.mBitmap.isRecycled())) {
        this.nhk.bEo();
      }
      this.ioq.invalidate();
      AppMethodBeat.o(21611);
      return;
      this.nhj = false;
      break;
      label297:
      bool1 = false;
      break label151;
      label303:
      bool2 = false;
      break label167;
      label309:
      this.nhm = false;
    }
    label317:
    if (this.mBitmap == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (this.mBitmap != null) {
        bool2 = this.mBitmap.isRecycled();
      }
      ab.d("MicroMsg.ThumbDrawable", "setMediaFeature fuck filePath:[%s] mBitmap:[%s], mBitmap.isRecycled():[%s]", new Object[] { str, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      AppMethodBeat.o(21611);
      return;
    }
  }
  
  private boolean d(Canvas paramCanvas, int paramInt)
  {
    AppMethodBeat.i(21615);
    if ((this.mBitmap == null) || (this.mBitmap.isRecycled()))
    {
      ab.d("MicroMsg.ThumbDrawable", "[duanyi test] get bitmap is null: " + this.mFilePath);
      if ((this.mBitmap != null) && (this.mBitmap.isRecycled()))
      {
        this.nhm = true;
        this.nhl = 0L;
        this.mBitmap = e.bDP().b(this.mFilePath, this.cth, this.ncH, this.ncI);
        if ((this.nhk != null) && (this.mBitmap != null) && (!this.mBitmap.isRecycled())) {
          this.nhk.bEo();
        }
      }
      AppMethodBeat.o(21615);
      return false;
    }
    ab.d("MicroMsg.ThumbDrawable", "[duanyi test] get bitmap ok:" + this.mFilePath);
    a(this.mBitmap, this.nhn);
    feS.setAlpha(paramInt);
    paramCanvas.drawBitmap(this.mBitmap, this.nhn, getBounds(), feS);
    ab.v("MicroMsg.ThumbDrawable", "Bounts:%s", new Object[] { getBounds().toString() });
    AppMethodBeat.o(21615);
    return true;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(21614);
    float f = (float)(SystemClock.uptimeMillis() - this.nhl) / 200.0F;
    if (this.nhl == 0L)
    {
      ab.d("MicroMsg.ThumbDrawable", "[duanyi test]: draw:[%s] startTimeMillis is 0", new Object[] { this.mFilePath });
      f = 0.0F;
    }
    ab.d("MicroMsg.ThumbDrawable", "[duanyi test]: hash:[%s] draw:[%s] animating:[%s] normalized:[%s] alpha[%s]", new Object[] { Integer.valueOf(hashCode()), this.mFilePath, Boolean.valueOf(this.nhm), Float.valueOf(f), Integer.valueOf((int)(255.0F * f)) });
    if (!this.nhm)
    {
      d(paramCanvas, 255);
      setAlpha(255);
      AppMethodBeat.o(21614);
      return;
    }
    if (f >= 1.0F)
    {
      this.nhm = false;
      d(paramCanvas, 255);
      AppMethodBeat.o(21614);
      return;
    }
    if (d(paramCanvas, (int)(f * 255.0F))) {
      invalidateSelf();
    }
    AppMethodBeat.o(21614);
  }
  
  public final int getIntrinsicHeight()
  {
    return 400;
  }
  
  public final int getIntrinsicWidth()
  {
    return 400;
  }
  
  public final int getOpacity()
  {
    return 0;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(21612);
    ab.v("MicroMsg.ThumbDrawable", "setBountsLTRB:%d %d - %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(21612);
  }
  
  public final void setBounds(Rect paramRect)
  {
    AppMethodBeat.i(21613);
    ab.v("MicroMsg.ThumbDrawable", "setBountsRECT:%s", new Object[] { paramRect.toString() });
    super.setBounds(paramRect);
    AppMethodBeat.o(21613);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.h
 * JD-Core Version:    0.7.0.1
 */