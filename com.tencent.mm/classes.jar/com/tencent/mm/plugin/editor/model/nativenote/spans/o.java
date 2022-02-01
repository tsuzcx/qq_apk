package com.tencent.mm.plugin.editor.model.nativenote.spans;

import android.text.style.ParagraphStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum o
{
  public String mStartTag;
  public String qTt;
  public boolean qTu;
  public String qTv;
  public String qTw;
  public boolean qTx;
  public boolean qTy = false;
  
  static
  {
    AppMethodBeat.i(181956);
    qTp = new o("NONE", 0, "", "", "", "", false);
    qTq = new o("NOTEUL", 1, "<wx-ul>", "</wx-ul>", "<wx-li>", "</wx-li>", true);
    qTr = new o("NOTEOL", 2, "<wx-ol>", "</wx-ol>", "<wx-li>", "</wx-li>", true);
    qTs = new o("NOTETODO", 3, "", "", "<wn-todo checked=\"1\" >", "</wn-todo>", true);
    qTz = new o[] { qTp, qTq, qTr, qTs };
    AppMethodBeat.o(181956);
  }
  
  private o(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mStartTag = paramString1;
    this.qTt = paramString2;
    this.qTv = paramString3;
    this.qTw = paramString4;
    this.qTu = false;
    this.qTx = paramBoolean1;
  }
  
  public static o a(ParagraphStyle paramParagraphStyle)
  {
    if ((paramParagraphStyle instanceof d)) {
      return qTq;
    }
    if ((paramParagraphStyle instanceof k)) {
      return qTr;
    }
    if ((paramParagraphStyle instanceof s)) {
      return qTs;
    }
    return null;
  }
  
  public final boolean cEw()
  {
    return this == qTq;
  }
  
  public final boolean cEx()
  {
    return this == qTr;
  }
  
  public final boolean cEy()
  {
    return this == qTs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.spans.o
 * JD-Core Version:    0.7.0.1
 */