package com.tencent.mm.plugin.mmsight.a;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  public static void a(a.a parama)
  {
    y.i("MicroMsg.VideoEditReporter", "[report-VideoEditCountData] %s", new Object[] { parama.toString() });
    h.nFQ.f(14529, new Object[] { Integer.valueOf(parama.scene), Integer.valueOf(parama.source) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.a.a
 * JD-Core Version:    0.7.0.1
 */