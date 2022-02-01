package com.tencent.mm.graphics.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public enum a
{
  static
  {
    AppMethodBeat.i(136217);
    hks = new a("INSTANCE");
    hkt = new a[] { hks };
    AppMethodBeat.o(136217);
  }
  
  private a() {}
  
  private static void a(long paramLong, a parama)
  {
    AppMethodBeat.i(136215);
    if (parama == null)
    {
      AppMethodBeat.o(136215);
      return;
    }
    Log.i("MicroMsg.ImageReporter", "alvinluo reportImageDecodeInfo sessionId: %d, from: %s, imageType: %d, w: %d, h: %d, fileSize: %d, orientation: %d, decodeResult: %d, decodeTime: %d, fullSampleSzie: %d, onlyDecodeTime: %d", new Object[] { Long.valueOf(paramLong), parama.from, Integer.valueOf(parama.imageType), Integer.valueOf(parama.width), Integer.valueOf(parama.height), Integer.valueOf(parama.fileSize), Integer.valueOf(parama.orientation), Integer.valueOf(parama.hku), Integer.valueOf(parama.hkv), Integer.valueOf(parama.aXk), Integer.valueOf(parama.hkw) });
    h.CyF.a(15467, new Object[] { Long.valueOf(paramLong), parama.from, Integer.valueOf(parama.imageType), Integer.valueOf(parama.width), Integer.valueOf(parama.height), Integer.valueOf(parama.fileSize), Integer.valueOf(parama.orientation), Integer.valueOf(parama.hku), Integer.valueOf(parama.hkv), Integer.valueOf(parama.aXk), Integer.valueOf(parama.hkw) });
    AppMethodBeat.o(136215);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(136216);
    long l = System.currentTimeMillis();
    if (paramb != null)
    {
      Log.i("MicroMsg.ImageReporter", "alvinluo reportPerformance sessionId: %d, fps.maxFps: %f, fps.minFps: %f, fps.averageFps: %f, memory.memoryUsedWhenInit: %f, memory.currentMaxUsedMemory: %f, memory.currentMinUsedMemory: %f, memory.averUsed: %f, memory.currentVarianceSum: %f", new Object[] { Long.valueOf(l), Double.valueOf(0.0D), Double.valueOf(0.0D), Double.valueOf(0.0D), Double.valueOf(paramb.hjZ), Double.valueOf(paramb.hka), Double.valueOf(paramb.hkb), Double.valueOf(paramb.hkd), Double.valueOf(paramb.hkc) });
      h.CyF.a(15471, new Object[] { Long.valueOf(l), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf((int)paramb.hjZ), Integer.valueOf((int)paramb.hka), Integer.valueOf((int)paramb.hkd), Integer.valueOf((int)paramb.hkc), Integer.valueOf(1) });
    }
    AppMethodBeat.o(136216);
  }
  
  public static void a(a parama1, a parama2)
  {
    AppMethodBeat.i(136214);
    long l = System.currentTimeMillis();
    if (parama1 != null) {
      a(l, parama1);
    }
    if (parama2 != null) {
      a(l, parama2);
    }
    AppMethodBeat.o(136214);
  }
  
  public static final class a
  {
    public int aXk;
    public int fileSize;
    public String from;
    public int height;
    public int hku;
    public int hkv;
    public int hkw;
    public String imagePath;
    public int imageType;
    public int orientation;
    public int width;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.graphics.c.a
 * JD-Core Version:    0.7.0.1
 */