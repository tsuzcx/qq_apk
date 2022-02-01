package com.tencent.mm.plugin.game.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.kernel.c.a;

public abstract interface g
  extends a
{
  public abstract void a(Context paramContext, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, Bundle paramBundle, int paramInt3);
  
  public abstract void a(Context paramContext, String paramString, int paramInt1, Bundle paramBundle, int paramInt2);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, Bundle paramBundle);
  
  public abstract void ap(String paramString1, String paramString2, String paramString3);
  
  public static abstract interface a
  {
    public abstract void an(String paramString, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.api.g
 * JD-Core Version:    0.7.0.1
 */