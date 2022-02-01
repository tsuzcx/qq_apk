package com.tencent.mm.plugin.byp.a;

import com.tencent.mm.ak.h.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.cp;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.ss;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class a
  implements b
{
  public final void O(LinkedList<ss> paramLinkedList)
  {
    Log.i("BaseBypSyncHandler", "[onReceive] size=%s", new Object[] { Integer.valueOf(paramLinkedList.size()) });
    com.tencent.mm.plugin.messenger.foundation.a.l locall = (com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    for (;;)
    {
      ss localss;
      cp localcp;
      try
      {
        locall.eiy().aEs("BaseBypSyncHandler");
        Iterator localIterator = paramLinkedList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localss = (ss)localIterator.next();
        if (localss.pWk != 1) {
          continue;
        }
        localcp = new cp();
        localcp.parseFrom(localss.pUz.zy);
        if (Util.isNullOrNil(localcp.KGL))
        {
          Log.e("BaseBypSyncHandler", "msg_session_id is null! FromUserName=%s ToUserName=%s", new Object[] { z.a(localcp.KGK.KHl), z.a(localcp.KGK.KHm) });
          continue;
        }
      }
      catch (IOException paramLinkedList)
      {
        Log.printDebugStack("BaseBypSyncHandler", "", new Object[] { paramLinkedList });
        return;
        if (localcp.KGK.Brn == 0L)
        {
          Log.e("BaseBypSyncHandler", "NewMsgId is zero! FromUserName=%s ToUserName=%s", new Object[] { z.a(localcp.KGK.KHl), z.a(localcp.KGK.KHm) });
          continue;
        }
      }
      finally
      {
        locall.eiy().aEt("BaseBypSyncHandler");
      }
      if (!a(localcp))
      {
        Log.e("BaseBypSyncHandler", "[onReceive] ignore this msg %s", new Object[] { localcp.KGL });
      }
      else
      {
        if (localcp.KGN)
        {
          paramLinkedList = localcp.KGK.KHl;
          label302:
          paramLinkedList = z.a(paramLinkedList);
          String str = (String)g.aAh().azQ().get(2, "");
          if ((localcp.KGN) && (!paramLinkedList.equals(str))) {
            locall.aSW().eJ(paramLinkedList, crR());
          }
          if (!localcp.KGN) {
            break label461;
          }
          localcp.KGK.KHm = z.Su(localcp.KGL);
        }
        for (;;)
        {
          paramLinkedList = new h.a(localcp.KGK, false, false, false);
          paramLinkedList.iMa = new cp().parseFrom(localss.pUz.zy);
          paramLinkedList.what = crS();
          ((k)g.af(k.class)).processAddMsg(paramLinkedList, crT());
          break;
          paramLinkedList = localcp.KGK.KHm;
          break label302;
          label461:
          localcp.KGK.KHl = z.Su(localcp.KGL);
        }
      }
    }
    locall.eiy().aEt("BaseBypSyncHandler");
  }
  
  protected boolean a(cp paramcp)
  {
    return true;
  }
  
  protected abstract int crR();
  
  protected abstract int crS();
  
  protected abstract aa crT();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.a.a
 * JD-Core Version:    0.7.0.1
 */