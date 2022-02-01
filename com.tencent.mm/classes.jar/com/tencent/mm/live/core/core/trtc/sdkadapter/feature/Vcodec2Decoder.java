package com.tencent.mm.live.core.core.trtc.sdkadapter.feature;

import com.tencent.liteav.TXLiteAVExternalDecoderFactoryInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Vcodec2Decoder
  implements TXLiteAVExternalDecoderFactoryInterface
{
  static
  {
    AppMethodBeat.i(248289);
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG("voipCodec");
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/live/core/core/trtc/sdkadapter/feature/Vcodec2Decoder", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/live/core/core/trtc/sdkadapter/feature/Vcodec2Decoder", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    AppMethodBeat.o(248289);
  }
  
  private native long createDecoder();
  
  private native void destroyDecoder(long paramLong);
  
  public long CreateHevcDecoder()
  {
    AppMethodBeat.i(248295);
    long l = createDecoder();
    AppMethodBeat.o(248295);
    return l;
  }
  
  public void DestroyHevcDecoder(long paramLong)
  {
    AppMethodBeat.i(248303);
    destroyDecoder(paramLong);
    AppMethodBeat.o(248303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.sdkadapter.feature.Vcodec2Decoder
 * JD-Core Version:    0.7.0.1
 */