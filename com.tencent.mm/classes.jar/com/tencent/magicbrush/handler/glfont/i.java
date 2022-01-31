package com.tencent.magicbrush.handler.glfont;

import android.graphics.Typeface;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
{
  public Typeface bKi = null;
  public boolean bKj = false;
  public a bKk;
  public float fontSize = 14.0F;
  public float strokeWidth = 0.0F;
  
  i(a parama)
  {
    this.bKk = parama;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(115952);
    String str = "MBFontStyle[" + this.fontSize + "][" + this.strokeWidth + "]";
    AppMethodBeat.o(115952);
    return str;
  }
  
  public static enum a
  {
    int bKp;
    
    static
    {
      AppMethodBeat.i(115951);
      bKl = new a("NORMAL", 0, 0);
      bKm = new a("BOLD", 1, 1);
      bKn = new a("ITALIC", 2, 2);
      bKo = new a("BOLD_ITALIC", 3, 3);
      bKq = new a[] { bKl, bKm, bKn, bKo };
      AppMethodBeat.o(115951);
    }
    
    private a(int paramInt)
    {
      this.bKp = paramInt;
    }
    
    public static a i(boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((paramBoolean1) && (paramBoolean2)) {
        return bKo;
      }
      if (paramBoolean1) {
        return bKn;
      }
      if (paramBoolean2) {
        return bKm;
      }
      return bKl;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.i
 * JD-Core Version:    0.7.0.1
 */