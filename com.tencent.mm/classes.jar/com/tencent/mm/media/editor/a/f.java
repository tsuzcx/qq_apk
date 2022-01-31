package com.tencent.mm.media.editor.a;

import a.f.b.j;
import a.l;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory.Companion;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.emotion.EmojiInfo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/editor/item/EmojiEditorItem;", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "matrix", "Landroid/graphics/Matrix;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/graphics/Matrix;)V", "TAG", "", "decoder", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "lastValidFrame", "Landroid/graphics/Bitmap;", "consumeTime", "", "lastFrameTime", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "init", "prepareNext", "plugin-mediaeditor_release"})
public final class f
  extends b
{
  private final String TAG;
  private final Matrix asO;
  private com.tencent.mm.emoji.decode.b eSI;
  private EmojiInfo evH;
  private Bitmap evb;
  
  public f(EmojiInfo paramEmojiInfo, Matrix paramMatrix)
  {
    AppMethodBeat.i(12888);
    this.evH = paramEmojiInfo;
    this.asO = paramMatrix;
    this.TAG = "MicroMsg.EmojiEditorItem";
    AppMethodBeat.o(12888);
  }
  
  public final long UG()
  {
    AppMethodBeat.i(12886);
    com.tencent.mm.emoji.decode.b localb = this.eSI;
    if (localb == null) {
      j.ays("decoder");
    }
    localb.Om();
    localb = this.eSI;
    if (localb == null) {
      j.ays("decoder");
    }
    this.evb = localb.On();
    localb = this.eSI;
    if (localb == null) {
      j.ays("decoder");
    }
    long l = localb.Op();
    AppMethodBeat.o(12886);
    return l;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(12887);
    com.tencent.mm.emoji.decode.b localb = this.eSI;
    if (localb == null) {
      j.ays("decoder");
    }
    localb.destroy();
    AppMethodBeat.o(12887);
  }
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(12884);
    j.q(paramCanvas, "canvas");
    j.q(paramPaint, "paint");
    paramCanvas.save();
    paramCanvas.concat(this.asO);
    if (this.evb != null)
    {
      Bitmap localBitmap = this.evb;
      if (localBitmap == null) {
        j.ebi();
      }
      paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, paramPaint);
    }
    paramCanvas.restore();
    AppMethodBeat.o(12884);
  }
  
  public final long gk(long paramLong)
  {
    AppMethodBeat.i(12885);
    ab.d(this.TAG, "request time is " + paramLong + ", curr frame is " + this.eSz);
    paramLong = super.gk(paramLong);
    AppMethodBeat.o(12885);
    return paramLong;
  }
  
  public final void init()
  {
    AppMethodBeat.i(12883);
    ab.d(this.TAG, "filepath is " + this.evH.dQB());
    this.eSI = MMGIFJNIFactory.Companion.getDecoder(this.evH);
    AppMethodBeat.o(12883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.media.editor.a.f
 * JD-Core Version:    0.7.0.1
 */