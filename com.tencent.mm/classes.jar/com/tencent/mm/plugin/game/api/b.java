package com.tencent.mm.plugin.game.api;

import android.content.Context;

public abstract interface b
{
  public abstract void NX(int paramInt);
  
  public abstract void O(long paramLong, int paramInt);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5, String paramString6);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2);
  
  public abstract void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3);
  
  public abstract void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, long paramLong, String paramString4, int paramInt3);
  
  public abstract void am(String paramString, int paramInt1, int paramInt2);
  
  public abstract void azk(String paramString);
  
  public abstract boolean dSE();
  
  public abstract String dSF();
  
  public abstract void fU(Context paramContext);
  
  public abstract void k(Context paramContext, String paramString1, String paramString2);
  
  public abstract void k(String paramString1, String paramString2, String paramString3);
  
  public abstract void pG(boolean paramBoolean);
  
  public static final class a
  {
    private static b xtY = null;
    
    public static void a(b paramb)
    {
      xtY = paramb;
    }
    
    public static b dSQ()
    {
      return xtY;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.api.b
 * JD-Core Version:    0.7.0.1
 */