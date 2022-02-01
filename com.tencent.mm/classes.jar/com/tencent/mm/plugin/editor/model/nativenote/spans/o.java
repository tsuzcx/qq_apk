package com.tencent.mm.plugin.editor.model.nativenote.spans;

import android.text.style.ParagraphStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum o
{
  public String xBX;
  public String xBY;
  public boolean xBZ;
  public String xCa;
  public String xCb;
  public boolean xCc;
  public boolean xCd = false;
  
  static
  {
    AppMethodBeat.i(181956);
    xBT = new o("NONE", 0, "", "", "", "", false);
    xBU = new o("NOTEUL", 1, "<wx-ul>", "</wx-ul>", "<wx-li>", "</wx-li>", true);
    xBV = new o("NOTEOL", 2, "<wx-ol>", "</wx-ol>", "<wx-li>", "</wx-li>", true);
    xBW = new o("NOTETODO", 3, "", "", "<wn-todo checked=\"1\" >", "</wn-todo>", true);
    xCe = new o[] { xBT, xBU, xBV, xBW };
    AppMethodBeat.o(181956);
  }
  
  private o(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    this.xBX = paramString1;
    this.xBY = paramString2;
    this.xCa = paramString3;
    this.xCb = paramString4;
    this.xBZ = false;
    this.xCc = paramBoolean;
  }
  
  public static o a(ParagraphStyle paramParagraphStyle)
  {
    if ((paramParagraphStyle instanceof d)) {
      return xBU;
    }
    if ((paramParagraphStyle instanceof k)) {
      return xBV;
    }
    if ((paramParagraphStyle instanceof s)) {
      return xBW;
    }
    return null;
  }
  
  public final boolean dxv()
  {
    return this == xBU;
  }
  
  public final boolean dxw()
  {
    return this == xBV;
  }
  
  public final boolean dxx()
  {
    return this == xBW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.spans.o
 * JD-Core Version:    0.7.0.1
 */