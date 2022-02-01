package com.tencent.magicbrush.handler.glfont;

import android.graphics.Typeface;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
{
  public String cyI = "normal";
  public boolean cyJ;
  public a cyK;
  public float fontSize;
  public float strokeWidth;
  public Typeface sx = null;
  
  j(String paramString, a parama)
  {
    this.cyI = paramString;
    this.fontSize = 20.0F;
    this.cyJ = false;
    this.strokeWidth = 0.0F;
    this.cyK = parama;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(140053);
    String str = "MBFontStyle[" + this.cyI + "][" + this.fontSize + "][" + this.strokeWidth + "]";
    AppMethodBeat.o(140053);
    return str;
  }
  
  public static enum a
  {
    int cyP;
    
    static
    {
      AppMethodBeat.i(140052);
      cyL = new a("NORMAL", 0, 0);
      cyM = new a("BOLD", 1, 1);
      cyN = new a("ITALIC", 2, 2);
      cyO = new a("BOLD_ITALIC", 3, 3);
      cyQ = new a[] { cyL, cyM, cyN, cyO };
      AppMethodBeat.o(140052);
    }
    
    private a(int paramInt)
    {
      this.cyP = paramInt;
    }
    
    public static a j(boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((paramBoolean1) && (paramBoolean2)) {
        return cyO;
      }
      if (paramBoolean1) {
        return cyN;
      }
      if (paramBoolean2) {
        return cyM;
      }
      return cyL;
    }
    
    public final boolean isBold()
    {
      return (this == cyM) || (this == cyO);
    }
    
    public final boolean isItalic()
    {
      return (this == cyN) || (this == cyO);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.j
 * JD-Core Version:    0.7.0.1
 */