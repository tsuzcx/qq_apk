package com.tencent.magicbrush.handler.glfont;

import android.graphics.Typeface;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
{
  public float buK = 20.0F;
  public boolean cqS = false;
  public a cqT;
  public Typeface pC = null;
  public float strokeWidth = 0.0F;
  
  i(a parama)
  {
    this.cqT = parama;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(140053);
    String str = "MBFontStyle[" + this.buK + "][" + this.strokeWidth + "]";
    AppMethodBeat.o(140053);
    return str;
  }
  
  public static enum a
  {
    int cqY;
    
    static
    {
      AppMethodBeat.i(140052);
      cqU = new a("NORMAL", 0, 0);
      cqV = new a("BOLD", 1, 1);
      cqW = new a("ITALIC", 2, 2);
      cqX = new a("BOLD_ITALIC", 3, 3);
      cqZ = new a[] { cqU, cqV, cqW, cqX };
      AppMethodBeat.o(140052);
    }
    
    private a(int paramInt)
    {
      this.cqY = paramInt;
    }
    
    public static a j(boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((paramBoolean1) && (paramBoolean2)) {
        return cqX;
      }
      if (paramBoolean1) {
        return cqW;
      }
      if (paramBoolean2) {
        return cqV;
      }
      return cqU;
    }
    
    public final boolean isBold()
    {
      return (this == cqV) || (this == cqX);
    }
    
    public final boolean isItalic()
    {
      return (this == cqW) || (this == cqX);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.i
 * JD-Core Version:    0.7.0.1
 */