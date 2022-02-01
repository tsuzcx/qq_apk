package com.tencent.magicbrush.handler.glfont;

import android.graphics.Typeface;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
{
  public float bsJ = 20.0F;
  public boolean cnZ = false;
  public a coa;
  public Typeface qC = null;
  public float strokeWidth = 0.0F;
  
  i(a parama)
  {
    this.coa = parama;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(140053);
    String str = "MBFontStyle[" + this.bsJ + "][" + this.strokeWidth + "]";
    AppMethodBeat.o(140053);
    return str;
  }
  
  public static enum a
  {
    int cof;
    
    static
    {
      AppMethodBeat.i(140052);
      cob = new a("NORMAL", 0, 0);
      coc = new a("BOLD", 1, 1);
      cod = new a("ITALIC", 2, 2);
      coe = new a("BOLD_ITALIC", 3, 3);
      cog = new a[] { cob, coc, cod, coe };
      AppMethodBeat.o(140052);
    }
    
    private a(int paramInt)
    {
      this.cof = paramInt;
    }
    
    public static a j(boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((paramBoolean1) && (paramBoolean2)) {
        return coe;
      }
      if (paramBoolean1) {
        return cod;
      }
      if (paramBoolean2) {
        return coc;
      }
      return cob;
    }
    
    public final boolean isBold()
    {
      return (this == coc) || (this == coe);
    }
    
    public final boolean isItalic()
    {
      return (this == cod) || (this == coe);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.i
 * JD-Core Version:    0.7.0.1
 */