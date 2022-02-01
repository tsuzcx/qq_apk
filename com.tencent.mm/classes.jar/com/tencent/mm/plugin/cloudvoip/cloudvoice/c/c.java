package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.service.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Log.LogImp;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class c
{
  public static void au(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(268375);
    int i = 2;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
      localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      localByteBuffer.put((byte)paramInt);
      q localq = q.wVc;
      q.e(21, localByteBuffer.array(), 4);
      AppMethodBeat.o(268375);
      return;
      paramInt += 1;
      continue;
      if (paramBoolean) {
        paramInt = (paramInt + 1) % 4;
      } else {
        paramInt -= 1;
      }
    }
  }
  
  public static int dqY()
  {
    AppMethodBeat.i(90787);
    if (Log.getImpl() != null)
    {
      int i = Log.getImpl().getLogLevel(0L);
      AppMethodBeat.o(90787);
      return i;
    }
    AppMethodBeat.o(90787);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.c
 * JD-Core Version:    0.7.0.1
 */