package com.tencent.mm.plugin.editor.model.nativenote.spans;

import android.text.style.ParagraphStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum o
{
  public String mStartTag;
  public String oTO;
  public boolean oTP;
  public String oTQ;
  public String oTR;
  public boolean oTS;
  public boolean oTT = false;
  
  static
  {
    AppMethodBeat.i(181956);
    oTK = new o("NONE", 0, "", "", "", "", false);
    oTL = new o("NOTEUL", 1, "<wx-ul>", "</wx-ul>", "<wx-li>", "</wx-li>", true);
    oTM = new o("NOTEOL", 2, "<wx-ol>", "</wx-ol>", "<wx-li>", "</wx-li>", true);
    oTN = new o("NOTETODO", 3, "", "", "<wn-todo checked=\"1\" >", "</wn-todo>", true);
    oTU = new o[] { oTK, oTL, oTM, oTN };
    AppMethodBeat.o(181956);
  }
  
  private o(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mStartTag = paramString1;
    this.oTO = paramString2;
    this.oTQ = paramString3;
    this.oTR = paramString4;
    this.oTP = false;
    this.oTS = paramBoolean1;
  }
  
  public static o a(ParagraphStyle paramParagraphStyle)
  {
    if ((paramParagraphStyle instanceof d)) {
      return oTL;
    }
    if ((paramParagraphStyle instanceof k)) {
      return oTM;
    }
    if ((paramParagraphStyle instanceof s)) {
      return oTN;
    }
    return null;
  }
  
  public final boolean caP()
  {
    return this == oTL;
  }
  
  public final boolean caQ()
  {
    return this == oTM;
  }
  
  public final boolean caR()
  {
    return this == oTN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.spans.o
 * JD-Core Version:    0.7.0.1
 */