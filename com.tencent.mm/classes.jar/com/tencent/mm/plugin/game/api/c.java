package com.tencent.mm.plugin.game.api;

import android.content.Context;
import com.tencent.mm.kernel.c.a;

public abstract interface c
  extends a
{
  public abstract int H(Context paramContext, String paramString1, String paramString2);
  
  public abstract int WY(int paramInt);
  
  public abstract String WZ(int paramInt);
  
  public abstract void a(a parama);
  
  public abstract void fCe();
  
  public abstract void hH(Context paramContext);
  
  public static abstract interface a
  {
    public abstract void invoke(c.b paramb);
  }
  
  public static final class b
  {
    public int IcA = 0;
    public boolean Icz = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.api.c
 * JD-Core Version:    0.7.0.1
 */