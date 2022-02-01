package com.tencent.magicbrush.handler.glfont;

import android.graphics.Typeface;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
{
  public String czp = "normal";
  public boolean czq;
  public a czr;
  public float fontSize;
  public float strokeWidth;
  public Typeface sx = null;
  
  j(String paramString, a parama)
  {
    this.czp = paramString;
    this.fontSize = 20.0F;
    this.czq = false;
    this.strokeWidth = 0.0F;
    this.czr = parama;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(140053);
    String str = "MBFontStyle[" + this.czp + "][" + this.fontSize + "][" + this.strokeWidth + "]";
    AppMethodBeat.o(140053);
    return str;
  }
  
  public static enum a
  {
    int czw;
    
    static
    {
      AppMethodBeat.i(140052);
      czs = new a("NORMAL", 0, 0);
      czt = new a("BOLD", 1, 1);
      czu = new a("ITALIC", 2, 2);
      czv = new a("BOLD_ITALIC", 3, 3);
      czx = new a[] { czs, czt, czu, czv };
      AppMethodBeat.o(140052);
    }
    
    private a(int paramInt)
    {
      this.czw = paramInt;
    }
    
    public static a j(boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((paramBoolean1) && (paramBoolean2)) {
        return czv;
      }
      if (paramBoolean1) {
        return czu;
      }
      if (paramBoolean2) {
        return czt;
      }
      return czs;
    }
    
    public final boolean isBold()
    {
      return (this == czt) || (this == czv);
    }
    
    public final boolean isItalic()
    {
      return (this == czu) || (this == czv);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.j
 * JD-Core Version:    0.7.0.1
 */