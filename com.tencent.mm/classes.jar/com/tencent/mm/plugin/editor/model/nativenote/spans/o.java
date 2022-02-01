package com.tencent.mm.plugin.editor.model.nativenote.spans;

import android.text.style.ParagraphStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum o
{
  public String mStartTag;
  public String pxA;
  public String pxB;
  public boolean pxC;
  public boolean pxD = false;
  public String pxy;
  public boolean pxz;
  
  static
  {
    AppMethodBeat.i(181956);
    pxu = new o("NONE", 0, "", "", "", "", false);
    pxv = new o("NOTEUL", 1, "<wx-ul>", "</wx-ul>", "<wx-li>", "</wx-li>", true);
    pxw = new o("NOTEOL", 2, "<wx-ol>", "</wx-ol>", "<wx-li>", "</wx-li>", true);
    pxx = new o("NOTETODO", 3, "", "", "<wn-todo checked=\"1\" >", "</wn-todo>", true);
    pxE = new o[] { pxu, pxv, pxw, pxx };
    AppMethodBeat.o(181956);
  }
  
  private o(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mStartTag = paramString1;
    this.pxy = paramString2;
    this.pxA = paramString3;
    this.pxB = paramString4;
    this.pxz = false;
    this.pxC = paramBoolean1;
  }
  
  public static o a(ParagraphStyle paramParagraphStyle)
  {
    if ((paramParagraphStyle instanceof d)) {
      return pxv;
    }
    if ((paramParagraphStyle instanceof k)) {
      return pxw;
    }
    if ((paramParagraphStyle instanceof s)) {
      return pxx;
    }
    return null;
  }
  
  public final boolean cft()
  {
    return this == pxv;
  }
  
  public final boolean cfu()
  {
    return this == pxw;
  }
  
  public final boolean cfv()
  {
    return this == pxx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.spans.o
 * JD-Core Version:    0.7.0.1
 */