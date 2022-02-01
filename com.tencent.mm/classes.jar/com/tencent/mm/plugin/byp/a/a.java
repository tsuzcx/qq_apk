package com.tencent.mm.plugin.byp.a;

import com.tencent.mm.ak.e.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.cg;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.rp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class a
  implements b
{
  public final void M(LinkedList<rp> paramLinkedList)
  {
    ae.i("BaseBypSyncHandler", "[onReceive] size=%s", new Object[] { Integer.valueOf(paramLinkedList.size()) });
    com.tencent.mm.plugin.messenger.foundation.a.l locall = (com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    for (;;)
    {
      rp localrp;
      cg localcg;
      try
      {
        locall.doJ().aqX("BaseBypSyncHandler");
        Iterator localIterator = paramLinkedList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localrp = (rp)localIterator.next();
        if (localrp.oIw != 1) {
          continue;
        }
        localcg = new cg();
        localcg.parseFrom(localrp.oGT.zr);
        if (bu.isNullOrNil(localcg.FNg))
        {
          ae.e("BaseBypSyncHandler", "msg_session_id is null! FromUserName=%s ToUserName=%s", new Object[] { z.a(localcg.FNf.FNG), z.a(localcg.FNf.FNH) });
          continue;
        }
      }
      catch (IOException paramLinkedList)
      {
        ae.l("BaseBypSyncHandler", "", new Object[] { paramLinkedList });
        return;
        if (localcg.FNf.xrk == 0L)
        {
          ae.e("BaseBypSyncHandler", "NewMsgId is zero! FromUserName=%s ToUserName=%s", new Object[] { z.a(localcg.FNf.FNG), z.a(localcg.FNf.FNH) });
          continue;
        }
      }
      finally
      {
        locall.doJ().aqY("BaseBypSyncHandler");
      }
      if (!a(localcg))
      {
        ae.e("BaseBypSyncHandler", "[onReceive] ignore this msg %s", new Object[] { localcg.FNg });
      }
      else
      {
        if (localcg.FNi)
        {
          paramLinkedList = localcg.FNf.FNG;
          label302:
          paramLinkedList = z.a(paramLinkedList);
          String str = (String)g.ajR().ajA().get(2, "");
          if ((localcg.FNi) && (!paramLinkedList.equals(str))) {
            locall.azO().ev(paramLinkedList, bUe());
          }
          if (!localcg.FNi) {
            break label461;
          }
          localcg.FNf.FNH = z.Jw(localcg.FNg);
        }
        for (;;)
        {
          paramLinkedList = new e.a(localcg.FNf, false, false, false);
          paramLinkedList.hQS = new cg().parseFrom(localrp.oGT.zr);
          paramLinkedList.what = bUf();
          ((k)g.ab(k.class)).processAddMsg(paramLinkedList, bUg());
          break;
          paramLinkedList = localcg.FNf.FNH;
          break label302;
          label461:
          localcg.FNf.FNG = z.Jw(localcg.FNg);
        }
      }
    }
    locall.doJ().aqY("BaseBypSyncHandler");
  }
  
  protected boolean a(cg paramcg)
  {
    return true;
  }
  
  protected abstract int bUe();
  
  protected abstract int bUf();
  
  protected abstract aa bUg();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.a.a
 * JD-Core Version:    0.7.0.1
 */