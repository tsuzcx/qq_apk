package com.tencent.mm.plugin.game.api;

import android.content.Context;

public abstract interface b
{
  public abstract void Tm(int paramInt);
  
  public abstract void V(long paramLong, int paramInt);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5, String paramString6);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2);
  
  public abstract void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3);
  
  public abstract void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, long paramLong, String paramString4, int paramInt3);
  
  public abstract void aIK(String paramString);
  
  public abstract void ao(String paramString, int paramInt1, int paramInt2);
  
  public abstract boolean evh();
  
  public abstract String evi();
  
  public abstract void gn(Context paramContext);
  
  public abstract void k(Context paramContext, String paramString1, String paramString2);
  
  public abstract void k(String paramString1, String paramString2, String paramString3);
  
  public abstract void sb(boolean paramBoolean);
  
  public static final class a
  {
    private static b Cqp = null;
    
    public static void a(b paramb)
    {
      Cqp = paramb;
    }
    
    public static b evu()
    {
      return Cqp;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.api.b
 * JD-Core Version:    0.7.0.1
 */