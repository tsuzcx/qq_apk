package com.tencent.mm.api;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class y
{
  public static b cSw;
  protected a cSv;
  
  public abstract boolean Kc();
  
  public abstract u Kd();
  
  public void Ke() {}
  
  public abstract void a(s params);
  
  public void a(a parama)
  {
    this.cSv = parama;
  }
  
  public abstract e bh(Context paramContext);
  
  public abstract void onDestroy();
  
  public static final class a
  {
    public boolean cSA;
    public y.c cSx;
    public boolean cSy;
    public boolean cSz;
    public String path;
    public Rect rect;
    
    public a(String paramString, y.c paramc, boolean paramBoolean1, boolean paramBoolean2, Rect paramRect, boolean paramBoolean3)
    {
      this.cSx = paramc;
      this.path = paramString;
      this.cSy = paramBoolean1;
      this.cSz = paramBoolean2;
      this.rect = paramRect;
      this.cSA = paramBoolean3;
    }
    
    public static final class a
    {
      boolean cSA = false;
      public boolean cSB = true;
      public Rect cSC;
      public y.c cSx;
      public boolean cSy;
      public String path;
      
      public final a Lu()
      {
        this.cSB = false;
        return this;
      }
      
      public final y.a Lv()
      {
        AppMethodBeat.i(149428);
        y.a locala = new y.a(this.path, this.cSx, this.cSy, this.cSB, this.cSC, this.cSA);
        AppMethodBeat.o(149428);
        return locala;
      }
      
      public final a a(y.c paramc)
      {
        this.cSx = paramc;
        return this;
      }
      
      public final a ca(boolean paramBoolean)
      {
        this.cSy = paramBoolean;
        return this;
      }
      
      public final a cb(boolean paramBoolean)
      {
        this.cSA = paramBoolean;
        return this;
      }
      
      public final a eZ(String paramString)
      {
        this.path = paramString;
        return this;
      }
      
      public final a i(Rect paramRect)
      {
        this.cSC = paramRect;
        return this;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract y Kf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.api.y
 * JD-Core Version:    0.7.0.1
 */