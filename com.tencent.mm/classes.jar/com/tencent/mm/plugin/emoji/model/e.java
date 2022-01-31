package com.tencent.mm.plugin.emoji.model;

import com.tencent.mm.h.a.cy;
import com.tencent.mm.sdk.b.a;
import java.util.HashMap;
import java.util.Map;

public final class e
{
  private cy iYe = new cy();
  public final Map<String, Integer> iYf = new HashMap();
  
  public final void g(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.iYe.bJc.bJd = paramString1;
    this.iYe.bJc.status = paramInt1;
    this.iYe.bJc.progress = paramInt2;
    this.iYe.bJc.bJe = paramString2;
    a.udP.m(this.iYe);
    if (paramInt1 == 6)
    {
      if ((paramInt2 < 0) || (paramInt2 >= 100))
      {
        this.iYf.remove(paramString1);
        return;
      }
      this.iYf.put(paramString1, Integer.valueOf(paramInt2));
      return;
    }
    this.iYf.remove(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.model.e
 * JD-Core Version:    0.7.0.1
 */