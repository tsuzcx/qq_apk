package com.tencent.magicbrush.handler.glfont;

import android.graphics.Typeface;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
{
  public Typeface bGp = null;
  public String cOk = "normal";
  public boolean cOl;
  public a cOm;
  public float fontSize;
  public float strokeWidth;
  
  j(String paramString, a parama)
  {
    this.cOk = paramString;
    this.fontSize = 20.0F;
    this.cOl = false;
    this.strokeWidth = 0.0F;
    this.cOm = parama;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(140053);
    String str = "MBFontStyle[" + this.cOk + "][" + this.fontSize + "][" + this.strokeWidth + "]";
    AppMethodBeat.o(140053);
    return str;
  }
  
  public static enum a
  {
    int cOr;
    
    static
    {
      AppMethodBeat.i(140052);
      cOn = new a("NORMAL", 0, 0);
      cOo = new a("BOLD", 1, 1);
      cOp = new a("ITALIC", 2, 2);
      cOq = new a("BOLD_ITALIC", 3, 3);
      cOs = new a[] { cOn, cOo, cOp, cOq };
      AppMethodBeat.o(140052);
    }
    
    private a(int paramInt)
    {
      this.cOr = paramInt;
    }
    
    public static a m(boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((paramBoolean1) && (paramBoolean2)) {
        return cOq;
      }
      if (paramBoolean1) {
        return cOp;
      }
      if (paramBoolean2) {
        return cOo;
      }
      return cOn;
    }
    
    public final boolean Vl()
    {
      return (this == cOo) || (this == cOq);
    }
    
    public final boolean Vm()
    {
      return (this == cOp) || (this == cOq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.j
 * JD-Core Version:    0.7.0.1
 */