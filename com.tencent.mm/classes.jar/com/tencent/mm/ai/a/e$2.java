package com.tencent.mm.ai.a;

import com.tencent.mm.ai.z;
import com.tencent.mm.sdk.platformtools.bk;

final class e$2
  implements Runnable
{
  e$2(String paramString1, String paramString2, String paramString3) {}
  
  public final void run()
  {
    c localc = z.MA().lp(this.ehC);
    if (localc == null) {
      return;
    }
    if (localc.field_chatVersion < bk.getInt(this.ehD, 2147483647))
    {
      localc.field_needToUpdate = true;
      z.MA().b(localc);
    }
    if (localc.isGroup())
    {
      z.MG().ao(localc.field_bizChatServId, this.ehz);
      return;
    }
    z.MG().ap(localc.field_bizChatServId, this.ehz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ai.a.e.2
 * JD-Core Version:    0.7.0.1
 */