package com.tencent.mm.plugin.game.luggage;

import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.plugin.webview.luggage.permission.LuggageGetA8Key.a;
import java.util.Map;

final class h$2
  extends LuggageGetA8Key.a
{
  h$2(h paramh, GameWebPerformanceInfo paramGameWebPerformanceInfo) {}
  
  public final void b(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    this.kMV.dCT = System.currentTimeMillis();
    l.m(new h.2.1(this, paramString2, paramMap));
  }
  
  public final void i(String paramString1, int paramInt1, int paramInt2, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.h.2
 * JD-Core Version:    0.7.0.1
 */