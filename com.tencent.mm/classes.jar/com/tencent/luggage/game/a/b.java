package com.tencent.luggage.game.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.BufferURLManager;
import com.tencent.mm.plugin.appbrand.jsruntime.y;
import d.l;
import java.nio.ByteBuffer;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/luggage/game/boot/BufferURLManagerDelegate;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/IBufferURLManager;", "impl", "Lcom/tencent/mm/appbrand/v8/BufferURLManager;", "(Lcom/tencent/mm/appbrand/v8/BufferURLManager;)V", "getImpl", "()Lcom/tencent/mm/appbrand/v8/BufferURLManager;", "createBufferURL", "", "byteBuffer", "Ljava/nio/ByteBuffer;", "getBuffer", "url", "revokeBufferURL", "", "luggage-wxa-game-ext_release"})
final class b
  implements y
{
  private final BufferURLManager cij;
  
  public b(BufferURLManager paramBufferURLManager)
  {
    AppMethodBeat.i(220741);
    this.cij = paramBufferURLManager;
    AppMethodBeat.o(220741);
  }
  
  public final ByteBuffer cK(String paramString)
  {
    AppMethodBeat.i(220740);
    paramString = this.cij.cK(paramString);
    AppMethodBeat.o(220740);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.a.b
 * JD-Core Version:    0.7.0.1
 */