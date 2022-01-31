package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.ag.h;
import com.tencent.mm.ag.i;
import com.tencent.mm.ag.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.e;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;

public final class d
  extends e
{
  protected final bi a(cd paramcd, String paramString1, String paramString2, String paramString3)
  {
    Object localObject = aa.a(paramcd.svH);
    if ((localObject == null) || (((String)localObject).length() <= 0))
    {
      y.e("MicroMsg.CardMsgExtension", "possible friend msg : content is null");
      return null;
    }
    localObject = bi.a.abZ((String)localObject);
    if (paramcd.kSW == 66) {
      ((b)g.r(b.class)).oR(((bi.a)localObject).uCc);
    }
    if (bk.pm(((bi.a)localObject).pyp).length() > 0)
    {
      h localh = new h();
      localh.username = ((bi.a)localObject).pyp;
      localh.cCq = 3;
      localh.bK(true);
      localh.ebT = ((bi.a)localObject).uBY;
      localh.ebS = ((bi.a)localObject).uBZ;
      localh.bcw = -1;
      y.d("MicroMsg.CardMsgExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[] { ((bi.a)localObject).pyp, localh.JX(), localh.JY() });
      o.Kh().a(localh);
    }
    return super.a(paramcd, paramString1, paramString2, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.d
 * JD-Core Version:    0.7.0.1
 */