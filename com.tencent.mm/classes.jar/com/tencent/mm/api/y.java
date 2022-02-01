package com.tencent.mm.api;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class y
{
  public static b cJB;
  protected a cJA;
  
  public abstract boolean IL();
  
  public abstract u IM();
  
  public void IN() {}
  
  public abstract void a(s params);
  
  public void a(a parama)
  {
    this.cJA = parama;
  }
  
  public abstract e bf(Context paramContext);
  
  public abstract void onDestroy();
  
  public static final class a
  {
    public y.c cJC;
    public boolean cJD;
    public boolean cJE;
    public boolean cJF;
    public String path;
    public Rect rect;
    
    public a(String paramString, y.c paramc, boolean paramBoolean1, boolean paramBoolean2, Rect paramRect, boolean paramBoolean3)
    {
      this.cJC = paramc;
      this.path = paramString;
      this.cJD = paramBoolean1;
      this.cJE = paramBoolean2;
      this.rect = paramRect;
      this.cJF = paramBoolean3;
    }
    
    public static final class a
    {
      public y.c cJC;
      public boolean cJD;
      boolean cJF = false;
      public boolean cJG = true;
      public Rect cJH;
      public String path;
      
      public final a Kd()
      {
        this.cJG = false;
        return this;
      }
      
      public final y.a Ke()
      {
        AppMethodBeat.i(149428);
        y.a locala = new y.a(this.path, this.cJC, this.cJD, this.cJG, this.cJH, this.cJF);
        AppMethodBeat.o(149428);
        return locala;
      }
      
      public final a a(y.c paramc)
      {
        this.cJC = paramc;
        return this;
      }
      
      public final a bX(boolean paramBoolean)
      {
        this.cJD = paramBoolean;
        return this;
      }
      
      public final a bY(boolean paramBoolean)
      {
        this.cJF = paramBoolean;
        return this;
      }
      
      public final a ek(String paramString)
      {
        this.path = paramString;
        return this;
      }
      
      public final a i(Rect paramRect)
      {
        this.cJH = paramRect;
        return this;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract y IO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.api.y
 * JD-Core Version:    0.7.0.1
 */