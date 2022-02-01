package com.tencent.mm.api;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class ab
{
  public static b fax;
  protected a faw;
  
  public abstract boolean YD();
  
  public abstract x YE();
  
  public void YF() {}
  
  public void a(a parama)
  {
    this.faw = parama;
  }
  
  public abstract void a(u paramu);
  
  public abstract e bA(Context paramContext);
  
  public abstract void onDestroy();
  
  public static class a
  {
    public int backgroundColor;
    public Rect byG;
    public boolean faA;
    public boolean faB;
    public Rect faC;
    public ab.c fay;
    public boolean faz;
    public String path;
    
    public a(String paramString, ab.c paramc, boolean paramBoolean1, boolean paramBoolean2, Rect paramRect1, boolean paramBoolean3, Rect paramRect2, int paramInt)
    {
      this.fay = paramc;
      this.path = paramString;
      this.faz = paramBoolean1;
      this.faA = paramBoolean2;
      this.byG = paramRect1;
      this.faB = paramBoolean3;
      this.faC = paramRect2;
      this.backgroundColor = paramInt;
    }
    
    public static final class a
    {
      int backgroundColor;
      boolean faB = false;
      Rect faC;
      public boolean faD = true;
      public Rect faE;
      public ab.c fay;
      public boolean faz;
      public String path;
      
      public final a a(ab.c paramc)
      {
        this.fay = paramc;
        return this;
      }
      
      public final a aac()
      {
        this.faD = false;
        return this;
      }
      
      public final a aad()
      {
        this.backgroundColor = 0;
        return this;
      }
      
      public final ab.a aae()
      {
        AppMethodBeat.i(149428);
        ab.a locala = new ab.a(this.path, this.fay, this.faz, this.faD, this.faE, this.faB, this.faC, this.backgroundColor);
        AppMethodBeat.o(149428);
        return locala;
      }
      
      public final a df(boolean paramBoolean)
      {
        this.faz = paramBoolean;
        return this;
      }
      
      public final a dg(boolean paramBoolean)
      {
        this.faB = paramBoolean;
        return this;
      }
      
      public final a gx(String paramString)
      {
        this.path = paramString;
        return this;
      }
      
      public final a n(Rect paramRect)
      {
        this.faC = paramRect;
        return this;
      }
      
      public final a o(Rect paramRect)
      {
        this.faE = paramRect;
        return this;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract ab YG();
  }
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(149431);
      faF = new c("VIDEO", 0);
      faG = new c("PHOTO", 1);
      faH = new c("SCREEN", 2);
      faI = new c[] { faF, faG, faH };
      AppMethodBeat.o(149431);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.api.ab
 * JD-Core Version:    0.7.0.1
 */