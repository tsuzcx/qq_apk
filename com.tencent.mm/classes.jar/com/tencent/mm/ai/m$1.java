package com.tencent.mm.ai;

import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class m$1
  implements Runnable
{
  m$1(String paramString1, String paramString2) {}
  
  public final void run()
  {
    m.a locala = z.MI();
    String str1 = this.egC;
    String str2 = this.egD;
    if ((bk.bl(str1)) || (bk.bl(str2)))
    {
      y.e("MicroMsg.BrandLogic", "pushing for brand " + str1 + ", url " + str2);
      return;
    }
    if (bk.cn(bk.g((Integer)locala.egF.get(str1))) < 300L)
    {
      y.i("MicroMsg.BrandLogic", "downloading interval less than 5 mins for " + str1);
      return;
    }
    locala.egF.put(str1, Integer.valueOf((int)bk.UX()));
    if ((locala.egH == null) || (locala.egH.crx())) {
      locala.egH = new av(1, "brand-logic");
    }
    str2 = m.an(str1, str2);
    locala.egH.c(new m.b(str1, str2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ai.m.1
 * JD-Core Version:    0.7.0.1
 */