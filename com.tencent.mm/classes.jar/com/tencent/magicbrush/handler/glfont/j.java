package com.tencent.magicbrush.handler.glfont;

import android.graphics.Typeface;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
{
  public Typeface bbO = null;
  public String eJF = "normal";
  public boolean eJG;
  public a eJH;
  public float fontSize;
  public float strokeWidth;
  
  j(String paramString, a parama)
  {
    this.eJF = paramString;
    this.fontSize = 20.0F;
    this.eJG = false;
    this.strokeWidth = 0.0F;
    this.eJH = parama;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(140053);
    String str = "MBFontStyle[" + this.eJF + "][" + this.fontSize + "][" + this.strokeWidth + "]";
    AppMethodBeat.o(140053);
    return str;
  }
  
  public static enum a
  {
    int eJM;
    
    static
    {
      AppMethodBeat.i(140052);
      eJI = new a("NORMAL", 0, 0);
      eJJ = new a("BOLD", 1, 1);
      eJK = new a("ITALIC", 2, 2);
      eJL = new a("BOLD_ITALIC", 3, 3);
      eJN = new a[] { eJI, eJJ, eJK, eJL };
      AppMethodBeat.o(140052);
    }
    
    private a(int paramInt)
    {
      this.eJM = paramInt;
    }
    
    public static a o(boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((paramBoolean1) && (paramBoolean2)) {
        return eJL;
      }
      if (paramBoolean1) {
        return eJK;
      }
      if (paramBoolean2) {
        return eJJ;
      }
      return eJI;
    }
    
    public final boolean avO()
    {
      return (this == eJJ) || (this == eJL);
    }
    
    public final boolean avP()
    {
      return (this == eJK) || (this == eJL);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.j
 * JD-Core Version:    0.7.0.1
 */