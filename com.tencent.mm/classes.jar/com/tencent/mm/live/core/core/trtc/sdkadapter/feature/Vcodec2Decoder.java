package com.tencent.mm.live.core.core.trtc.sdkadapter.feature;

import com.tencent.liteav.TXLiteAVExternalDecoderFactoryInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Vcodec2Decoder
  implements TXLiteAVExternalDecoderFactoryInterface
{
  static
  {
    AppMethodBeat.i(200248);
    System.loadLibrary("voipCodec");
    AppMethodBeat.o(200248);
  }
  
  private native long createDecoder();
  
  private native void destroyDecoder(long paramLong);
  
  public long CreateHevcDecoder()
  {
    AppMethodBeat.i(200246);
    long l = createDecoder();
    AppMethodBeat.o(200246);
    return l;
  }
  
  public void DestroyHevcDecoder(long paramLong)
  {
    AppMethodBeat.i(200247);
    destroyDecoder(paramLong);
    AppMethodBeat.o(200247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.sdkadapter.feature.Vcodec2Decoder
 * JD-Core Version:    0.7.0.1
 */