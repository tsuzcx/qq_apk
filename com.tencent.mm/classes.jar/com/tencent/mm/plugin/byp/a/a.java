package com.tencent.mm.plugin.byp.a;

import com.tencent.mm.al.e.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.cg;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.rn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class a
  implements b
{
  public final void M(LinkedList<rn> paramLinkedList)
  {
    ad.i("BaseBypSyncHandler", "[onReceive] size=%s", new Object[] { Integer.valueOf(paramLinkedList.size()) });
    com.tencent.mm.plugin.messenger.foundation.a.l locall = (com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    for (;;)
    {
      rn localrn;
      cg localcg;
      try
      {
        locall.dlK().apS("BaseBypSyncHandler");
        Iterator localIterator = paramLinkedList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localrn = (rn)localIterator.next();
        if (localrn.oBU != 1) {
          continue;
        }
        localcg = new cg();
        localcg.parseFrom(localrn.oAr.zr);
        if (bt.isNullOrNil(localcg.FuI))
        {
          ad.e("BaseBypSyncHandler", "msg_session_id is null! FromUserName=%s ToUserName=%s", new Object[] { com.tencent.mm.platformtools.z.a(localcg.FuH.Fvi), com.tencent.mm.platformtools.z.a(localcg.FuH.Fvj) });
          continue;
        }
      }
      catch (IOException paramLinkedList)
      {
        ad.l("BaseBypSyncHandler", "", new Object[] { paramLinkedList });
        return;
        if (localcg.FuH.xbt == 0L)
        {
          ad.e("BaseBypSyncHandler", "NewMsgId is zero! FromUserName=%s ToUserName=%s", new Object[] { com.tencent.mm.platformtools.z.a(localcg.FuH.Fvi), com.tencent.mm.platformtools.z.a(localcg.FuH.Fvj) });
          continue;
        }
      }
      finally
      {
        locall.dlK().apT("BaseBypSyncHandler");
      }
      if (!a(localcg))
      {
        ad.e("BaseBypSyncHandler", "[onReceive] ignore this msg %s", new Object[] { localcg.FuI });
      }
      else
      {
        if (localcg.FuK)
        {
          paramLinkedList = localcg.FuH.Fvi;
          label302:
          paramLinkedList = com.tencent.mm.platformtools.z.a(paramLinkedList);
          String str = (String)g.ajC().ajl().get(2, "");
          if ((localcg.FuK) && (!paramLinkedList.equals(str))) {
            locall.azy().eo(paramLinkedList, bSR());
          }
          if (!localcg.FuK) {
            break label461;
          }
          localcg.FuH.Fvj = com.tencent.mm.platformtools.z.IX(localcg.FuI);
        }
        for (;;)
        {
          paramLinkedList = new e.a(localcg.FuH, false, false, false);
          paramLinkedList.hNZ = new cg().parseFrom(localrn.oAr.zr);
          paramLinkedList.what = bSS();
          ((k)g.ab(k.class)).processAddMsg(paramLinkedList, bST());
          break;
          paramLinkedList = localcg.FuH.Fvj;
          break label302;
          label461:
          localcg.FuH.Fvi = com.tencent.mm.platformtools.z.IX(localcg.FuI);
        }
      }
    }
    locall.dlK().apT("BaseBypSyncHandler");
  }
  
  protected boolean a(cg paramcg)
  {
    return true;
  }
  
  protected abstract int bSR();
  
  protected abstract int bSS();
  
  protected abstract com.tencent.mm.plugin.messenger.foundation.a.z bST();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.a.a
 * JD-Core Version:    0.7.0.1
 */