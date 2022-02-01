package com.tencent.mm.plugin.eggspring.a;

import android.content.Context;
import com.tencent.mm.modelpackage.g;

public abstract interface a
  extends com.tencent.mm.kernel.b.a
{
  public abstract void cleanPrefetch();
  
  public abstract boolean enablePlayLuckyEffect();
  
  public abstract void filterOutInvalidAppId(g paramg);
  
  public abstract void goMiniApp(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3);
  
  public abstract void prefetch(String paramString);
  
  public abstract void preloadMiniProgram(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.a.a
 * JD-Core Version:    0.7.0.1
 */