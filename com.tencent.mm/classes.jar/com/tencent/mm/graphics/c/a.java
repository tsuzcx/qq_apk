package com.tencent.mm.graphics.c;

import com.tencent.mm.graphics.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

public enum a
{
  private a() {}
  
  public static void a(long paramLong, a.a parama)
  {
    if (parama == null) {
      return;
    }
    y.i("MicroMsg.ImageReporter", "alvinluo reportImageDecodeInfo sessionId: %d, from: %s, imageType: %d, w: %d, h: %d, fileSize: %d, orientation: %d, decodeResult: %d, decodeTime: %d, fullSampleSzie: %d, onlyDecodeTime: %d", new Object[] { Long.valueOf(paramLong), parama.bWQ, Integer.valueOf(parama.dDC), Integer.valueOf(parama.width), Integer.valueOf(parama.height), Integer.valueOf(parama.fileSize), Integer.valueOf(parama.orientation), Integer.valueOf(parama.dDD), Integer.valueOf(parama.dDE), Integer.valueOf(parama.api), Integer.valueOf(parama.dDF) });
    h.nFQ.f(15467, new Object[] { Long.valueOf(paramLong), parama.bWQ, Integer.valueOf(parama.dDC), Integer.valueOf(parama.width), Integer.valueOf(parama.height), Integer.valueOf(parama.fileSize), Integer.valueOf(parama.orientation), Integer.valueOf(parama.dDD), Integer.valueOf(parama.dDE), Integer.valueOf(parama.api), Integer.valueOf(parama.dDF) });
  }
  
  public static void a(b paramb)
  {
    long l = System.currentTimeMillis();
    if (paramb != null)
    {
      y.i("MicroMsg.ImageReporter", "alvinluo reportPerformance sessionId: %d, fps.maxFps: %f, fps.minFps: %f, fps.averageFps: %f, memory.memoryUsedWhenInit: %f, memory.currentMaxUsedMemory: %f, memory.currentMinUsedMemory: %f, memory.averUsed: %f, memory.currentVarianceSum: %f", new Object[] { Long.valueOf(l), Double.valueOf(0.0D), Double.valueOf(0.0D), Double.valueOf(0.0D), Double.valueOf(paramb.dDj), Double.valueOf(paramb.dDk), Double.valueOf(paramb.dDl), Double.valueOf(paramb.dDn), Double.valueOf(paramb.dDm) });
      h.nFQ.f(15471, new Object[] { Long.valueOf(l), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf((int)paramb.dDj), Integer.valueOf((int)paramb.dDk), Integer.valueOf((int)paramb.dDn), Integer.valueOf((int)paramb.dDm), Integer.valueOf(1) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.graphics.c.a
 * JD-Core Version:    0.7.0.1
 */