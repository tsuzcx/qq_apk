package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;

public final class a
{
  public static int QL(int paramInt)
  {
    switch (paramInt)
    {
    case 16000: 
    default: 
      return 8;
    case 96000: 
      return 0;
    case 88200: 
      return 1;
    case 64000: 
      return 2;
    case 48000: 
      return 3;
    case 44100: 
      return 4;
    case 32000: 
      return 5;
    case 24000: 
      return 6;
    case 22050: 
      return 7;
    case 12000: 
      return 9;
    case 11025: 
      return 10;
    case 8000: 
      return 11;
    }
    return 12;
  }
  
  public static void a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(241180);
    Log.d("MicroMsg.ADTSUtils", "addADTStoPacket params: %d, %d, %d, %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5) });
    paramInt4 = QL(paramInt4);
    paramByteBuffer.put(paramInt1, (byte)-1);
    paramByteBuffer.put(paramInt1 + 1, (byte)-7);
    paramByteBuffer.put(paramInt1 + 2, (byte)((paramInt4 << 2) + (paramInt3 - 1 << 6) + (paramInt5 >> 2)));
    paramByteBuffer.put(paramInt1 + 3, (byte)(((paramInt5 & 0x3) << 6) + (paramInt2 >> 11)));
    paramByteBuffer.put(paramInt1 + 4, (byte)((paramInt2 & 0x7FF) >> 3));
    paramByteBuffer.put(paramInt1 + 5, (byte)(((paramInt2 & 0x7) << 5) + 31));
    paramByteBuffer.put(paramInt1 + 6, (byte)-4);
    AppMethodBeat.o(241180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a
 * JD-Core Version:    0.7.0.1
 */