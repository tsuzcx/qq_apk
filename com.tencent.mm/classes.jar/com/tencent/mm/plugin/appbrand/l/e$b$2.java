package com.tencent.mm.plugin.appbrand.l;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.protocal.c.alj;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class e$b$2
  implements w.a
{
  e$b$2(e.b paramb) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    paramString = (alj)paramb.ecF.ecN;
    y.i("MicroMsg.WxaUpdateableMsgService", "getUpdateableMsg errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString.tho != null) && (paramString.tho.size() > 0))
    {
      y.i("MicroMsg.WxaUpdateableMsgService", "getUpdateableMsg response.updatable_msg_list.size:%d", new Object[] { Integer.valueOf(paramString.tho.size()) });
      e.b.a(this.gPY, paramString);
      e.b.b(this.gPY, paramString);
      e.b.a(paramString);
      e.b.b(this.gPY);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.l.e.b.2
 * JD-Core Version:    0.7.0.1
 */