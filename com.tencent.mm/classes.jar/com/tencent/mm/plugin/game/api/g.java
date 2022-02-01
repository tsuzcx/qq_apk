package com.tencent.mm.plugin.game.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.kernel.c.a;

public abstract interface g
  extends a
{
  public abstract void a(Context paramContext, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, Bundle paramBundle);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, Bundle paramBundle);
  
  public abstract void ag(String paramString1, String paramString2, String paramString3);
  
  public abstract void i(Context paramContext, String paramString, int paramInt);
  
  public static abstract interface a
  {
    public abstract void ak(String paramString, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.api.g
 * JD-Core Version:    0.7.0.1
 */