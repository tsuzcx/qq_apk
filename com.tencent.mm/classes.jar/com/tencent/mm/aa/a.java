package com.tencent.mm.aa;

import com.tencent.mm.aa.b.d;
import com.tencent.mm.sdk.platformtools.bk;

public final class a
{
  public static void a(d paramd, String paramString, a parama)
  {
    if (bk.bl(paramString))
    {
      parama.fM("");
      return;
    }
    paramd.evaluateJavascript(paramString + String.format(";var ___result_return = function(){return %d;};___result_return();", new Object[] { Integer.valueOf(11111) }), new a.1(parama));
  }
  
  public static abstract interface a
  {
    public abstract void Cu();
    
    public abstract void fM(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.aa.a
 * JD-Core Version:    0.7.0.1
 */