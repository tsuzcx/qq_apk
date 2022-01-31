package com.tencent.mm.plugin.game;

import android.os.Bundle;
import com.tencent.luggage.e.g;
import com.tencent.luggage.e.k;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.plugin.game.luggage.d;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

public final class f
  extends d
{
  public f(g paramg, k paramk, Bundle paramBundle)
  {
    super(paramg, paramk, paramBundle);
    l.post(new f.1(this));
    l.e(new f.2(this), 100L);
  }
  
  protected final void Ex(String paramString)
  {
    if (!paramString.equals(caV())) {
      super.Ex(paramString);
    }
  }
  
  protected final void b(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    y.i("MicroMsg.PreloadGameWebPage", "onUrlRedirect, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
  }
  
  public final void c(String paramString, Bundle paramBundle)
  {
    super.c(paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f
 * JD-Core Version:    0.7.0.1
 */