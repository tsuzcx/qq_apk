package com.tencent.mm.plugin.game.api;

import android.content.Context;
import com.tencent.mm.kernel.c.a;

public abstract interface c
  extends a
{
  public abstract int A(Context paramContext, String paramString1, String paramString2);
  
  public abstract int Hy(int paramInt);
  
  public abstract String Hz(int paramInt);
  
  public abstract void a(a parama);
  
  public abstract void cWD();
  
  public abstract boolean cWE();
  
  public abstract void fl(Context paramContext);
  
  public static abstract interface a
  {
    public abstract void a(c.b paramb);
  }
  
  public static final class b
  {
    public boolean tRR = false;
    public int tRS = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.api.c
 * JD-Core Version:    0.7.0.1
 */