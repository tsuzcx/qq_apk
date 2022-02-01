package com.tencent.mm.api;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class y
{
  public static b cGI;
  protected a cGH;
  
  public abstract boolean Iu();
  
  public abstract u Iv();
  
  public void Iw() {}
  
  public abstract void a(s params);
  
  public void a(a parama)
  {
    this.cGH = parama;
  }
  
  public abstract e bg(Context paramContext);
  
  public abstract void onDestroy();
  
  public static final class a
  {
    public y.c cGJ;
    public boolean cGK;
    public boolean cGL;
    public boolean cGM;
    public String path;
    public Rect rect;
    
    public a(String paramString, y.c paramc, boolean paramBoolean1, boolean paramBoolean2, Rect paramRect, boolean paramBoolean3)
    {
      this.cGJ = paramc;
      this.path = paramString;
      this.cGK = paramBoolean1;
      this.cGL = paramBoolean2;
      this.rect = paramRect;
      this.cGM = paramBoolean3;
    }
    
    public static final class a
    {
      public y.c cGJ;
      public boolean cGK;
      boolean cGM = false;
      public boolean cGN = true;
      public Rect cGO;
      public String path;
      
      public final a JN()
      {
        this.cGN = false;
        return this;
      }
      
      public final y.a JO()
      {
        AppMethodBeat.i(149428);
        y.a locala = new y.a(this.path, this.cGJ, this.cGK, this.cGN, this.cGO, this.cGM);
        AppMethodBeat.o(149428);
        return locala;
      }
      
      public final a a(y.c paramc)
      {
        this.cGJ = paramc;
        return this;
      }
      
      public final a bY(boolean paramBoolean)
      {
        this.cGK = paramBoolean;
        return this;
      }
      
      public final a bZ(boolean paramBoolean)
      {
        this.cGM = paramBoolean;
        return this;
      }
      
      public final a dZ(String paramString)
      {
        this.path = paramString;
        return this;
      }
      
      public final a i(Rect paramRect)
      {
        this.cGO = paramRect;
        return this;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract y Ix();
  }
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(149431);
      cGP = new c("VIDEO", 0);
      cGQ = new c("PHOTO", 1);
      cGR = new c[] { cGP, cGQ };
      AppMethodBeat.o(149431);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.api.y
 * JD-Core Version:    0.7.0.1
 */