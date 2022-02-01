package com.tencent.mm.plugin.game.api;

import android.content.Context;
import com.tencent.mm.kernel.c.a;

public abstract interface c
  extends a
{
  public abstract int C(Context paramContext, String paramString1, String paramString2);
  
  public abstract int NY(int paramInt);
  
  public abstract String NZ(int paramInt);
  
  public abstract void a(a parama);
  
  public abstract void dSH();
  
  public abstract void fV(Context paramContext);
  
  public static abstract interface a
  {
    public abstract void a(c.b paramb);
  }
  
  public static final class b
  {
    public boolean xtZ = false;
    public int xua = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.api.c
 * JD-Core Version:    0.7.0.1
 */