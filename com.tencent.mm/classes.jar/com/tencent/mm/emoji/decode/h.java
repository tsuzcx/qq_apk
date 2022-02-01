package com.tencent.mm.emoji.decode;

import android.graphics.Bitmap;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.xeffect.effect.IStickerDecoder;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/decode/WXGifBitmapDecoder;", "Lcom/tencent/mm/xeffect/effect/IStickerDecoder;", "bytes", "", "([B)V", "path", "", "(Ljava/lang/String;)V", "decoder", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "destroy", "", "duration", "", "getFrame", "Landroid/graphics/Bitmap;", "seekTo", "time", "size", "Landroid/util/Size;", "plugin-xlabeffect_release"})
public final class h
  implements IStickerDecoder
{
  private final d gUS;
  
  public h(String paramString)
  {
    AppMethodBeat.i(215212);
    this.gUS = MMGIFJNIFactory.Companion.getDecoder(paramString);
    AppMethodBeat.o(215212);
  }
  
  public h(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(215211);
    this.gUS = MMGIFJNIFactory.Companion.getDecoder(paramArrayOfByte);
    AppMethodBeat.o(215211);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(215206);
    this.gUS.destroy();
    AppMethodBeat.o(215206);
  }
  
  public final long duration()
  {
    AppMethodBeat.i(215207);
    long l = this.gUS.aup() * this.gUS.auq();
    AppMethodBeat.o(215207);
    return l;
  }
  
  public final Bitmap getFrame()
  {
    AppMethodBeat.i(215208);
    Bitmap localBitmap = this.gUS.getFrame();
    AppMethodBeat.o(215208);
    return localBitmap;
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(215209);
    this.gUS.seekTo(paramLong);
    AppMethodBeat.o(215209);
  }
  
  public final Size size()
  {
    AppMethodBeat.i(215210);
    Size localSize = new Size(this.gUS.aur(), this.gUS.aus());
    AppMethodBeat.o(215210);
    return localSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.h
 * JD-Core Version:    0.7.0.1
 */