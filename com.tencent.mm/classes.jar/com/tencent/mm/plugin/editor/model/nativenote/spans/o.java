package com.tencent.mm.plugin.editor.model.nativenote.spans;

import android.text.style.ParagraphStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum o
{
  public String mStartTag;
  public String pEc;
  public boolean pEd;
  public String pEe;
  public String pEf;
  public boolean pEg;
  public boolean pEh = false;
  
  static
  {
    AppMethodBeat.i(181956);
    pDY = new o("NONE", 0, "", "", "", "", false);
    pDZ = new o("NOTEUL", 1, "<wx-ul>", "</wx-ul>", "<wx-li>", "</wx-li>", true);
    pEa = new o("NOTEOL", 2, "<wx-ol>", "</wx-ol>", "<wx-li>", "</wx-li>", true);
    pEb = new o("NOTETODO", 3, "", "", "<wn-todo checked=\"1\" >", "</wn-todo>", true);
    pEi = new o[] { pDY, pDZ, pEa, pEb };
    AppMethodBeat.o(181956);
  }
  
  private o(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mStartTag = paramString1;
    this.pEc = paramString2;
    this.pEe = paramString3;
    this.pEf = paramString4;
    this.pEd = false;
    this.pEg = paramBoolean1;
  }
  
  public static o a(ParagraphStyle paramParagraphStyle)
  {
    if ((paramParagraphStyle instanceof d)) {
      return pDZ;
    }
    if ((paramParagraphStyle instanceof k)) {
      return pEa;
    }
    if ((paramParagraphStyle instanceof s)) {
      return pEb;
    }
    return null;
  }
  
  public final boolean cgJ()
  {
    return this == pDZ;
  }
  
  public final boolean cgK()
  {
    return this == pEa;
  }
  
  public final boolean cgL()
  {
    return this == pEb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.spans.o
 * JD-Core Version:    0.7.0.1
 */