package com.tencent.mm.aq;

import com.tencent.mm.model.am.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Map;

final class c$7$1
  implements Runnable
{
  c$7$1(c.7 param7, String paramString1, String paramString2, boolean paramBoolean) {}
  
  public final void run()
  {
    am.b.a locala2 = (am.b.a)this.emD.emx.emp.remove(this.byr);
    if (bk.bl(this.emB)) {}
    for (am.b.a locala1 = null;; locala1 = (am.b.a)this.emD.emx.emp.remove(this.emB))
    {
      if (locala2 != null) {
        locala2.m(this.byr, this.emC);
      }
      if ((locala1 != null) && (!bk.bl(this.emB))) {
        locala1.m(this.emB, this.emC);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aq.c.7.1
 * JD-Core Version:    0.7.0.1
 */