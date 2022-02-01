package com.tencent.mm.api;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class y
{
  public static y.b cRM;
  protected a cRL;
  
  public abstract boolean JU();
  
  public abstract u JV();
  
  public void JW() {}
  
  public abstract void a(s params);
  
  public void a(a parama)
  {
    this.cRL = parama;
  }
  
  public abstract e bg(Context paramContext);
  
  public abstract void onDestroy();
  
  public static final class a
  {
    public y.c cRN;
    public boolean cRO;
    public boolean cRP;
    public boolean cRQ;
    public String path;
    public Rect rect;
    
    public a(String paramString, y.c paramc, boolean paramBoolean1, boolean paramBoolean2, Rect paramRect, boolean paramBoolean3)
    {
      this.cRN = paramc;
      this.path = paramString;
      this.cRO = paramBoolean1;
      this.cRP = paramBoolean2;
      this.rect = paramRect;
      this.cRQ = paramBoolean3;
    }
    
    public static final class a
    {
      public y.c cRN;
      public boolean cRO;
      boolean cRQ = false;
      public boolean cRR = true;
      public Rect cRS;
      public String path;
      
      public final a Lm()
      {
        this.cRR = false;
        return this;
      }
      
      public final y.a Ln()
      {
        AppMethodBeat.i(149428);
        y.a locala = new y.a(this.path, this.cRN, this.cRO, this.cRR, this.cRS, this.cRQ);
        AppMethodBeat.o(149428);
        return locala;
      }
      
      public final a a(y.c paramc)
      {
        this.cRN = paramc;
        return this;
      }
      
      public final a ca(boolean paramBoolean)
      {
        this.cRO = paramBoolean;
        return this;
      }
      
      public final a cb(boolean paramBoolean)
      {
        this.cRQ = paramBoolean;
        return this;
      }
      
      public final a eU(String paramString)
      {
        this.path = paramString;
        return this;
      }
      
      public final a i(Rect paramRect)
      {
        this.cRS = paramRect;
        return this;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.api.y
 * JD-Core Version:    0.7.0.1
 */