package com.tencent.mm.plugin.editor.model.nativenote.spans;

import android.text.style.ParagraphStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum o
{
  public String mStartTag;
  public boolean uvA;
  public String uvB;
  public String uvC;
  public boolean uvD;
  public boolean uvE = false;
  public String uvz;
  
  static
  {
    AppMethodBeat.i(181956);
    uvv = new o("NONE", 0, "", "", "", "", false);
    uvw = new o("NOTEUL", 1, "<wx-ul>", "</wx-ul>", "<wx-li>", "</wx-li>", true);
    uvx = new o("NOTEOL", 2, "<wx-ol>", "</wx-ol>", "<wx-li>", "</wx-li>", true);
    uvy = new o("NOTETODO", 3, "", "", "<wn-todo checked=\"1\" >", "</wn-todo>", true);
    uvF = new o[] { uvv, uvw, uvx, uvy };
    AppMethodBeat.o(181956);
  }
  
  private o(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    this.mStartTag = paramString1;
    this.uvz = paramString2;
    this.uvB = paramString3;
    this.uvC = paramString4;
    this.uvA = false;
    this.uvD = paramBoolean;
  }
  
  public static o a(ParagraphStyle paramParagraphStyle)
  {
    if ((paramParagraphStyle instanceof d)) {
      return uvw;
    }
    if ((paramParagraphStyle instanceof k)) {
      return uvx;
    }
    if ((paramParagraphStyle instanceof s)) {
      return uvy;
    }
    return null;
  }
  
  public final boolean cTc()
  {
    return this == uvw;
  }
  
  public final boolean cTd()
  {
    return this == uvx;
  }
  
  public final boolean cTe()
  {
    return this == uvy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.spans.o
 * JD-Core Version:    0.7.0.1
 */