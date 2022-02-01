package com.tencent.mm.plugin.emoji;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;

public final class c
{
  public static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, int paramInt4, String paramString3)
  {
    AppMethodBeat.i(104533);
    ac.i("MicroMsg.emoji.EmojiReportHepler", "report kv stat md5:%s, downType:%d donwloadResult:%d verifyResult:%d productID:%s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString2 });
    h.wUl.f(12007, new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString2, Integer.valueOf(paramInt4), paramString3 });
    AppMethodBeat.o(104533);
  }
  
  public static void sr(long paramLong)
  {
    AppMethodBeat.i(104532);
    ac.i("MicroMsg.emoji.EmojiReportHepler", "report id stat key:%d, value:%d", new Object[] { Long.valueOf(paramLong), Long.valueOf(1L) });
    h.wUl.idkeyStat(96L, paramLong, 1L, false);
    AppMethodBeat.o(104532);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.c
 * JD-Core Version:    0.7.0.1
 */