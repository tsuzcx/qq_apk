package com.tencent.mm.media.editor.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory.Companion;
import com.tencent.mm.emoji.decode.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/editor/item/EmojiEditorItem;", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "matrix", "Landroid/graphics/Matrix;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/graphics/Matrix;)V", "TAG", "", "decoder", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "lastValidFrame", "Landroid/graphics/Bitmap;", "consumeTime", "", "lastFrameTime", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "init", "prepareNext", "seekTo", "timeMs", "plugin-mediaeditor_release"})
public final class f
  extends b
{
  private final String TAG;
  private Bitmap fKU;
  private EmojiInfo fLP;
  private c goM;
  
  public f(EmojiInfo paramEmojiInfo, Matrix paramMatrix)
  {
    super(paramMatrix);
    AppMethodBeat.i(93572);
    this.fLP = paramEmojiInfo;
    this.TAG = "MicroMsg.EmojiEditorItem";
    AppMethodBeat.o(93572);
  }
  
  public final long ajy()
  {
    AppMethodBeat.i(93570);
    c localc = this.goM;
    if (localc == null) {
      k.aPZ("decoder");
    }
    localc.aaR();
    localc = this.goM;
    if (localc == null) {
      k.aPZ("decoder");
    }
    this.fKU = localc.aaS();
    localc = this.goM;
    if (localc == null) {
      k.aPZ("decoder");
    }
    long l = localc.aaU();
    AppMethodBeat.o(93570);
    return l;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(93571);
    c localc = this.goM;
    if (localc == null) {
      k.aPZ("decoder");
    }
    localc.destroy();
    AppMethodBeat.o(93571);
  }
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(93568);
    k.h(paramCanvas, "canvas");
    k.h(paramPaint, "paint");
    paramCanvas.save();
    paramCanvas.concat(this.dY);
    if (this.fKU != null)
    {
      Bitmap localBitmap = this.fKU;
      if (localBitmap == null) {
        k.fvU();
      }
      paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, paramPaint);
    }
    paramCanvas.restore();
    AppMethodBeat.o(93568);
  }
  
  public final void init()
  {
    AppMethodBeat.i(93567);
    ad.d(this.TAG, "filepath is " + this.fLP.gaa());
    this.goM = MMGIFJNIFactory.Companion.getDecoder(this.fLP);
    AppMethodBeat.o(93567);
  }
  
  public final long lz(long paramLong)
  {
    AppMethodBeat.i(93569);
    ad.d(this.TAG, "request time is " + paramLong + ", curr frame is " + this.goC);
    paramLong = super.lz(paramLong);
    AppMethodBeat.o(93569);
    return paramLong;
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(205871);
    c localc = this.goM;
    if (localc == null) {
      k.aPZ("decoder");
    }
    localc.seekTo(paramLong);
    localc = this.goM;
    if (localc == null) {
      k.aPZ("decoder");
    }
    this.fKU = localc.aaS();
    AppMethodBeat.o(205871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.editor.a.f
 * JD-Core Version:    0.7.0.1
 */