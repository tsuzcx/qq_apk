package com.tencent.mm.plugin.game.luggage;

import android.content.Context;
import com.tencent.luggage.e.k;
import com.tencent.luggage.webview.a;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.plugin.webview.luggage.permission.LuggageGetA8Key;
import com.tencent.mm.plugin.webview.luggage.permission.b;

public final class h
  extends k
{
  boolean kMS;
  String kMT;
  private boolean kMt;
  boolean kMz;
  
  public h(Context paramContext, Class<? extends a> paramClass)
  {
    super(paramContext, paramClass);
  }
  
  public final void aG(String paramString, boolean paramBoolean)
  {
    GameWebPerformanceInfo localGameWebPerformanceInfo = GameWebPerformanceInfo.fv(paramString);
    localGameWebPerformanceInfo.dCS = System.currentTimeMillis();
    LuggageGetA8Key localLuggageGetA8Key = new LuggageGetA8Key();
    localLuggageGetA8Key.a(paramString, new h.2(this, localGameWebPerformanceInfo));
    if (paramBoolean) {
      b.a(hashCode(), localLuggageGetA8Key);
    }
  }
  
  final void aYH()
  {
    if ((!this.kMt) || (!this.kMS)) {
      return;
    }
    a(new h.3(this));
  }
  
  public final void bc(String paramString)
  {
    super.bc(paramString);
    l.m(new h.1(this));
  }
  
  public final void bd(String paramString)
  {
    super.bd(paramString);
    this.kMt = true;
    aYH();
  }
  
  public final void loadUrl(String paramString)
  {
    super.loadUrl(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.h
 * JD-Core Version:    0.7.0.1
 */