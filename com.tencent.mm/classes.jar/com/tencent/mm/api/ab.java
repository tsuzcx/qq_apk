package com.tencent.mm.api;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class ab
{
  public static ab.b diQ;
  protected a diP;
  
  public abstract boolean Ul();
  
  public abstract x Um();
  
  public void Un() {}
  
  public void a(a parama)
  {
    this.diP = parama;
  }
  
  public abstract void a(u paramu);
  
  public abstract e bB(Context paramContext);
  
  public abstract void onDestroy();
  
  public static final class a
  {
    public int backgroundColor;
    public ab.c diR;
    public boolean diS;
    public boolean diT;
    public boolean diU;
    public Rect diV;
    public String path;
    public Rect rect;
    
    public a(String paramString, ab.c paramc, boolean paramBoolean1, boolean paramBoolean2, Rect paramRect1, boolean paramBoolean3, Rect paramRect2, int paramInt)
    {
      this.diR = paramc;
      this.path = paramString;
      this.diS = paramBoolean1;
      this.diT = paramBoolean2;
      this.rect = paramRect1;
      this.diU = paramBoolean3;
      this.diV = paramRect2;
      this.backgroundColor = paramInt;
    }
    
    public static final class a
    {
      int backgroundColor;
      public ab.c diR;
      public boolean diS;
      boolean diU = false;
      Rect diV;
      public boolean diW = true;
      public Rect diX;
      public String path;
      
      public final a VH()
      {
        this.diW = false;
        return this;
      }
      
      public final a VI()
      {
        this.backgroundColor = 0;
        return this;
      }
      
      public final ab.a VJ()
      {
        AppMethodBeat.i(149428);
        ab.a locala = new ab.a(this.path, this.diR, this.diS, this.diW, this.diX, this.diU, this.diV, this.backgroundColor);
        AppMethodBeat.o(149428);
        return locala;
      }
      
      public final a a(ab.c paramc)
      {
        this.diR = paramc;
        return this;
      }
      
      public final a cJ(boolean paramBoolean)
      {
        this.diS = paramBoolean;
        return this;
      }
      
      public final a cK(boolean paramBoolean)
      {
        this.diU = paramBoolean;
        return this;
      }
      
      public final a fN(String paramString)
      {
        this.path = paramString;
        return this;
      }
      
      public final a i(Rect paramRect)
      {
        this.diV = paramRect;
        return this;
      }
      
      public final a j(Rect paramRect)
      {
        this.diX = paramRect;
        return this;
      }
    }
  }
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(149431);
      diY = new c("VIDEO", 0);
      diZ = new c("PHOTO", 1);
      dja = new c("SCREEN", 2);
      djb = new c[] { diY, diZ, dja };
      AppMethodBeat.o(149431);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.api.ab
 * JD-Core Version:    0.7.0.1
 */