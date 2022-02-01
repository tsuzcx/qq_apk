package com.tencent.mm.plugin.game.api;

import android.content.Context;

public abstract interface b
{
  public abstract void HU(int paramInt);
  
  public abstract void P(long paramLong, int paramInt);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5, String paramString6);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2);
  
  public abstract void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3);
  
  public abstract void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, long paramLong, String paramString4, int paramInt3);
  
  public abstract void aj(String paramString, int paramInt1, int paramInt2);
  
  public abstract boolean cZf();
  
  public abstract String cZg();
  
  public abstract void fo(Context paramContext);
  
  public abstract void j(Context paramContext, String paramString1, String paramString2);
  
  public abstract void k(String paramString1, String paramString2, String paramString3);
  
  public abstract void mZ(boolean paramBoolean);
  
  public static final class a
  {
    private static b ucH = null;
    
    public static void a(b paramb)
    {
      ucH = paramb;
    }
    
    public static b cZq()
    {
      return ucH;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.api.b
 * JD-Core Version:    0.7.0.1
 */