package com.tencent.mm.media.editor.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory.Companion;
import com.tencent.mm.emoji.decode.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/editor/item/EmojiEditorItem;", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "matrix", "Landroid/graphics/Matrix;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/graphics/Matrix;)V", "TAG", "", "decoder", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "lastValidFrame", "Landroid/graphics/Bitmap;", "consumeTime", "", "lastFrameTime", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "init", "prepareNext", "seekTo", "timeMs", "plugin-mediaeditor_release"})
public final class f
  extends b
{
  private final String TAG;
  private Bitmap fOF;
  private EmojiInfo fPB;
  private d gPu;
  
  public f(EmojiInfo paramEmojiInfo, Matrix paramMatrix)
  {
    super(paramMatrix);
    AppMethodBeat.i(93572);
    this.fPB = paramEmojiInfo;
    this.TAG = "MicroMsg.EmojiEditorItem";
    AppMethodBeat.o(93572);
  }
  
  public final long aqx()
  {
    AppMethodBeat.i(93570);
    d locald = this.gPu;
    if (locald == null) {
      k.aVY("decoder");
    }
    locald.abQ();
    locald = this.gPu;
    if (locald == null) {
      k.aVY("decoder");
    }
    this.fOF = locald.abR();
    locald = this.gPu;
    if (locald == null) {
      k.aVY("decoder");
    }
    long l = locald.abT();
    AppMethodBeat.o(93570);
    return l;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(93571);
    d locald = this.gPu;
    if (locald == null) {
      k.aVY("decoder");
    }
    locald.destroy();
    AppMethodBeat.o(93571);
  }
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(93568);
    k.h(paramCanvas, "canvas");
    k.h(paramPaint, "paint");
    paramCanvas.save();
    paramCanvas.concat(this.eY);
    if (this.fOF != null)
    {
      Bitmap localBitmap = this.fOF;
      if (localBitmap == null) {
        k.fOy();
      }
      paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, paramPaint);
    }
    paramCanvas.restore();
    AppMethodBeat.o(93568);
  }
  
  public final void init()
  {
    AppMethodBeat.i(93567);
    ac.d(this.TAG, "filepath is " + this.fPB.ghd());
    this.gPu = MMGIFJNIFactory.Companion.getDecoder(this.fPB);
    AppMethodBeat.o(93567);
  }
  
  public final long pn(long paramLong)
  {
    AppMethodBeat.i(93569);
    ac.d(this.TAG, "request time is " + paramLong + ", curr frame is " + this.gPk);
    paramLong = super.pn(paramLong);
    AppMethodBeat.o(93569);
    return paramLong;
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(209904);
    d locald = this.gPu;
    if (locald == null) {
      k.aVY("decoder");
    }
    locald.seekTo(paramLong);
    locald = this.gPu;
    if (locald == null) {
      k.aVY("decoder");
    }
    this.fOF = locald.abR();
    AppMethodBeat.o(209904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.editor.a.f
 * JD-Core Version:    0.7.0.1
 */