package com.tencent.mm.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class ac
{
  public static ac.b hdY;
  protected a hdX;
  
  public void a(a parama)
  {
    this.hdX = parama;
  }
  
  public abstract void a(w paramw);
  
  public abstract boolean aAx();
  
  public abstract y aAy();
  
  public void aAz() {}
  
  public abstract f cn(Context paramContext);
  
  public abstract void onDestroy();
  
  public static class a
  {
    public int backgroundColor;
    public Bitmap bitmap;
    public ac.c hdZ;
    public boolean hea;
    public boolean heb;
    public boolean hec;
    public Rect hed;
    public String path;
    public Rect rect;
    
    public static final class a
    {
      public ac.a hee;
      
      public a()
      {
        AppMethodBeat.i(236246);
        this.hee = new ac.a();
        AppMethodBeat.o(236246);
      }
      
      public final a a(ac.c paramc)
      {
        this.hee.hdZ = paramc;
        return this;
      }
      
      public final a dQ(boolean paramBoolean)
      {
        this.hee.heb = paramBoolean;
        return this;
      }
      
      public final a dR(boolean paramBoolean)
      {
        this.hee.hea = paramBoolean;
        return this;
      }
      
      public final a dS(boolean paramBoolean)
      {
        this.hee.hec = paramBoolean;
        return this;
      }
      
      public final a hX(String paramString)
      {
        this.hee.path = paramString;
        return this;
      }
      
      public final a t(Rect paramRect)
      {
        this.hee.rect = paramRect;
        return this;
      }
      
      public final a z(Bitmap paramBitmap)
      {
        this.hee.bitmap = paramBitmap;
        return this;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.api.ac
 * JD-Core Version:    0.7.0.1
 */