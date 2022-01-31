package com.tencent.mm.plugin.emojicapture.model.a;

import a.d.b.g;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.mm.plugin.emojicapture.model.gif.MMGIFJNIFactory;
import com.tencent.mm.plugin.emojicapture.model.gif.MMGIFJNIFactory.Companion;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class c
  extends a
{
  private final String TAG;
  private final Matrix aqv;
  private EmojiInfo hNs;
  private com.tencent.mm.plugin.emojicapture.model.gif.a jkv;
  private Bitmap jkw;
  
  public c(EmojiInfo paramEmojiInfo, Matrix paramMatrix)
  {
    super(paramMatrix);
    this.hNs = paramEmojiInfo;
    this.aqv = paramMatrix;
    this.TAG = "MicroMsg.EmojiEditorItem";
  }
  
  public final long aKf()
  {
    com.tencent.mm.plugin.emojicapture.model.gif.a locala = this.jkv;
    if (locala == null) {
      g.ahh("decoder");
    }
    locala.x(this.jkw);
    locala = this.jkv;
    if (locala == null) {
      g.ahh("decoder");
    }
    return locala.aKg();
  }
  
  public final void destroy()
  {
    com.tencent.mm.plugin.emojicapture.model.gif.a locala = this.jkv;
    if (locala == null) {
      g.ahh("decoder");
    }
    locala.destroy();
  }
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    g.k(paramCanvas, "canvas");
    g.k(paramPaint, "paint");
    paramCanvas.save();
    paramCanvas.concat(this.aqv);
    paramCanvas.drawBitmap(this.jkw, 0.0F, 0.0F, paramPaint);
    paramCanvas.restore();
  }
  
  public final long du(long paramLong)
  {
    y.d(this.TAG, "request time is " + paramLong + ", curr frame is " + this.jku);
    return super.du(paramLong);
  }
  
  public final void init()
  {
    y.d(this.TAG, "filepath is " + this.hNs.cwL());
    this.jkv = MMGIFJNIFactory.Companion.getDecoder(this.hNs);
    com.tencent.mm.plugin.emojicapture.model.gif.a locala = this.jkv;
    if (locala == null) {
      g.ahh("decoder");
    }
    int i = locala.aKh();
    locala = this.jkv;
    if (locala == null) {
      g.ahh("decoder");
    }
    this.jkw = Bitmap.createBitmap(i, locala.aKi(), Bitmap.Config.ARGB_8888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a.c
 * JD-Core Version:    0.7.0.1
 */