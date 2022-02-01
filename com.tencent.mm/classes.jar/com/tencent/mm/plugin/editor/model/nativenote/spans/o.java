package com.tencent.mm.plugin.editor.model.nativenote.spans;

import android.text.style.ParagraphStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum o
{
  public String mStartTag;
  public String oqo;
  public boolean oqp;
  public String oqq;
  public String oqr;
  public boolean oqs;
  public boolean oqt = false;
  
  static
  {
    AppMethodBeat.i(181956);
    oqk = new o("NONE", 0, "", "", "", "", false);
    oql = new o("NOTEUL", 1, "<wx-ul>", "</wx-ul>", "<wx-li>", "</wx-li>", true);
    oqm = new o("NOTEOL", 2, "<wx-ol>", "</wx-ol>", "<wx-li>", "</wx-li>", true);
    oqn = new o("NOTETODO", 3, "", "", "<wn-todo checked=\"1\" >", "</wn-todo>", true);
    oqu = new o[] { oqk, oql, oqm, oqn };
    AppMethodBeat.o(181956);
  }
  
  private o(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mStartTag = paramString1;
    this.oqo = paramString2;
    this.oqq = paramString3;
    this.oqr = paramString4;
    this.oqp = false;
    this.oqs = paramBoolean1;
  }
  
  public static o a(ParagraphStyle paramParagraphStyle)
  {
    if ((paramParagraphStyle instanceof d)) {
      return oql;
    }
    if ((paramParagraphStyle instanceof k)) {
      return oqm;
    }
    if ((paramParagraphStyle instanceof s)) {
      return oqn;
    }
    return null;
  }
  
  public final boolean bTB()
  {
    return this == oql;
  }
  
  public final boolean bTC()
  {
    return this == oqm;
  }
  
  public final boolean bTD()
  {
    return this == oqn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.spans.o
 * JD-Core Version:    0.7.0.1
 */