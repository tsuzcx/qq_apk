package com.tencent.mm.model;

import com.tencent.mm.ah.e.b;
import com.tencent.mm.ah.e.c;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;

public class e
  implements com.tencent.mm.ah.e
{
  private static final a dUw = new a((byte)0);
  
  public static void a(com.tencent.mm.plugin.messenger.foundation.a.a parama)
  {
    dUw.aj(parama);
  }
  
  public bi a(cd paramcd, String paramString1, String paramString2, String paramString3)
  {
    if (paramString3.equals(paramString1)) {}
    for (paramString3 = paramString2;; paramString3 = paramString1)
    {
      bi localbi = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().O(paramString3, paramcd.ndp);
      y.i("MicroMsg.BaseMsgExtension", "summerbadcr dkmsgid prepareMsgInfo svrid:%d localid:%d  from:%s to:%s talker:%s", new Object[] { Long.valueOf(paramcd.ndp), Long.valueOf(localbi.field_msgId), paramString1, paramString2, paramString3 });
      if ((localbi.field_msgId != 0L) && (localbi.field_createTime + 604800000L < bd.o(paramString3, paramcd.mPL)))
      {
        y.w("MicroMsg.BaseMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(paramcd.ndp), Long.valueOf(localbi.field_msgId) });
        bd.bC(localbi.field_msgId);
        localbi.setMsgId(0L);
      }
      paramString1 = localbi;
      if (localbi.field_msgId == 0L)
      {
        paramString1 = new bi();
        paramString1.bf(paramcd.ndp);
        paramString1.bg(bd.o(paramString3, paramcd.mPL));
        paramString1.setType(paramcd.kSW);
        paramString1.setContent(bk.aah(bk.pm(aa.a(paramcd.svH))));
      }
      return paramString1;
    }
  }
  
  public void a(e.c paramc) {}
  
  public e.b b(com.tencent.mm.ah.e.a parama)
  {
    Object localObject1 = parama.dBs;
    Object localObject2 = (String)com.tencent.mm.kernel.g.DP().Dz().get(2, "");
    if (((String)localObject2).length() <= 0) {
      return null;
    }
    String str1 = aa.a(((cd)localObject1).svF);
    String str2 = aa.a(((cd)localObject1).svG);
    if ((bk.pm(str1).length() <= 0) || (bk.pm(str2).length() <= 0))
    {
      y.e("MicroMsg.BaseMsgExtension", "neither from-user nor to-user can be empty");
      return null;
    }
    bi localbi = a((cd)localObject1, str1, str2, (String)localObject2);
    if (localbi == null) {
      return null;
    }
    boolean bool;
    int i;
    if ((((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FE().has(str1)) || (((String)localObject2).equals(str1)))
    {
      bool = true;
      if (!bool) {
        break label350;
      }
      localbi.fA(1);
      localbi.ec(str2);
      i = ((cd)localObject1).hQq;
      label163:
      localbi.setStatus(i);
      if (((cd)localObject1).kSW == 10000) {
        localbi.setStatus(4);
      }
      localbi.cY(((cd)localObject1).svK);
      if (localbi.abY(q.Gj()))
      {
        localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().abv(localbi.field_talker);
        if (localObject2 != null)
        {
          ((ak)localObject2).gU(16777216);
          ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().a((ak)localObject2, localbi.field_talker);
        }
      }
      dUw.a(parama, localbi, str1, str2, bool);
      if (localbi.field_msgId != 0L) {
        break label386;
      }
      localbi.fJ(2);
      bd.a(localbi, parama);
      localbi.setMsgId(bd.h(localbi));
    }
    for (localObject1 = new e.b(localbi, true);; localObject1 = new e.b(localbi, false))
    {
      dUw.b(parama, localbi, str1, str2, bool);
      return localObject1;
      bool = false;
      break;
      label350:
      localbi.fA(0);
      localbi.ec(str1);
      if (((cd)localObject1).hQq > 3)
      {
        i = ((cd)localObject1).hQq;
        break label163;
      }
      i = 3;
      break label163;
      label386:
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().b(((cd)localObject1).ndp, localbi);
    }
  }
  
  private static final class a
    extends com.tencent.mm.ck.a<com.tencent.mm.plugin.messenger.foundation.a.a>
    implements com.tencent.mm.plugin.messenger.foundation.a.a
  {
    public final void a(com.tencent.mm.ah.e.a parama, bi parambi, String paramString1, String paramString2, boolean paramBoolean)
    {
      a(new e.a.1(this, parama, parambi, paramString1, paramString2, paramBoolean));
    }
    
    public final void b(com.tencent.mm.ah.e.a parama, bi parambi, String paramString1, String paramString2, boolean paramBoolean)
    {
      a(new e.a.2(this, parama, parambi, paramString1, paramString2, paramBoolean));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.model.e
 * JD-Core Version:    0.7.0.1
 */