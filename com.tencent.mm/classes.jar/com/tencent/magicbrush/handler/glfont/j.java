package com.tencent.magicbrush.handler.glfont;

import android.graphics.Typeface;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
{
  public String cNw = "normal";
  public boolean cNx;
  public a cNy;
  public float fontSize;
  public Typeface sB = null;
  public float strokeWidth;
  
  j(String paramString, a parama)
  {
    this.cNw = paramString;
    this.fontSize = 20.0F;
    this.cNx = false;
    this.strokeWidth = 0.0F;
    this.cNy = parama;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(140053);
    String str = "MBFontStyle[" + this.cNw + "][" + this.fontSize + "][" + this.strokeWidth + "]";
    AppMethodBeat.o(140053);
    return str;
  }
  
  public static enum a
  {
    int cND;
    
    static
    {
      AppMethodBeat.i(140052);
      cNz = new a("NORMAL", 0, 0);
      cNA = new a("BOLD", 1, 1);
      cNB = new a("ITALIC", 2, 2);
      cNC = new a("BOLD_ITALIC", 3, 3);
      cNE = new a[] { cNz, cNA, cNB, cNC };
      AppMethodBeat.o(140052);
    }
    
    private a(int paramInt)
    {
      this.cND = paramInt;
    }
    
    public static a j(boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((paramBoolean1) && (paramBoolean2)) {
        return cNC;
      }
      if (paramBoolean1) {
        return cNB;
      }
      if (paramBoolean2) {
        return cNA;
      }
      return cNz;
    }
    
    public final boolean isBold()
    {
      return (this == cNA) || (this == cNC);
    }
    
    public final boolean isItalic()
    {
      return (this == cNB) || (this == cNC);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.j
 * JD-Core Version:    0.7.0.1
 */