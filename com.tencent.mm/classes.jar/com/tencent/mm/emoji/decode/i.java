package com.tencent.mm.emoji.decode;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.xeffect.effect.IStickerDecoder;
import com.tencent.mm.xeffect.effect.IStickerDecoderFactory;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/decode/WXGifBitmapProviderFactory;", "Lcom/tencent/mm/xeffect/effect/IStickerDecoderFactory;", "()V", "getDecoder", "Lcom/tencent/mm/xeffect/effect/IStickerDecoder;", "bytes", "", "path", "", "plugin-xlabeffect_release"})
public final class i
  implements IStickerDecoderFactory
{
  public final IStickerDecoder getDecoder(String paramString)
  {
    AppMethodBeat.i(215214);
    p.h(paramString, "path");
    paramString = (IStickerDecoder)new h(paramString);
    AppMethodBeat.o(215214);
    return paramString;
  }
  
  public final IStickerDecoder getDecoder(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(215213);
    p.h(paramArrayOfByte, "bytes");
    paramArrayOfByte = (IStickerDecoder)new h(paramArrayOfByte);
    AppMethodBeat.o(215213);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.i
 * JD-Core Version:    0.7.0.1
 */