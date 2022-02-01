package com.tencent.mm.plugin.byp.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ck;
import com.tencent.mm.modelmulti.q.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.ae;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.protocal.protobuf.co;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.sl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public abstract class a
  implements b
{
  private c sWt = new c();
  private q.c sWu = new q.c()
  {
    public final boolean c(Queue<q.c> paramAnonymousQueue)
    {
      AppMethodBeat.i(247707);
      Log.i("BaseBypSyncHandler", "RUN... %s", new Object[] { Integer.valueOf(paramAnonymousQueue.size()) });
      AppMethodBeat.o(247707);
      return false;
    }
    
    public final String toString()
    {
      return "BaseBypSyncHandler";
    }
  };
  
  private void cFc()
  {
    this.sWt.dF(this.sWu);
    Log.i("BaseBypSyncHandler", "[finishReceive]");
  }
  
  protected boolean a(co paramco)
  {
    return true;
  }
  
  public final void b(LinkedList<sl> paramLinkedList, boolean paramBoolean)
  {
    Log.i("BaseBypSyncHandler", "[onReceive] size=%s", new Object[] { Integer.valueOf(paramLinkedList.size()) });
    n localn = (n)h.ae(n.class);
    label459:
    label619:
    do
    {
      for (;;)
      {
        sl localsl;
        co localco;
        try
        {
          this.sWt.dC(this.sWu);
          Iterator localIterator = paramLinkedList.iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localsl = (sl)localIterator.next();
          if (localsl.item_type != 1) {
            continue;
          }
          localco = new co();
          localco.parseFrom(localsl.tqA.UH);
          if ((Util.isNullOrNil(localco.RIf)) && ((localco.RIe.COi == 10002) || (localco.RIe.COi == 10001)))
          {
            Log.i("BaseBypSyncHandler", "dispatchToSysCmdMsgExtension, MsgType=%s isContinue=%s", new Object[] { Integer.valueOf(localco.RIe.COi), Boolean.valueOf(paramBoolean) });
            if (localco.RIe.RIH == null)
            {
              localco.RIe.RIH = new eae();
              Log.e("BaseBypSyncHandler", "[processToFunctionMsg] ImgBuf is null");
            }
            paramLinkedList = new h.a(localco.RIe, false, false, false);
            ((v)h.ag(v.class)).getSysCmdMsgExtension().b(paramLinkedList);
            continue;
          }
        }
        catch (Exception paramLinkedList)
        {
          Log.printErrStackTrace("BaseBypSyncHandler", paramLinkedList, "", new Object[0]);
          k(paramLinkedList);
          return;
          if (Util.isNullOrNil(localco.RIf))
          {
            Log.e("BaseBypSyncHandler", "msg_session_id is null! FromUserName=%s ToUserName=%s", new Object[] { z.a(localco.RIe.RID), z.a(localco.RIe.RIE) });
            continue;
          }
        }
        finally
        {
          this.sWt.dD(this.sWu);
          if (!paramBoolean) {
            cFc();
          }
        }
        if (localco.RIe.HlH == 0L)
        {
          Log.e("BaseBypSyncHandler", "NewMsgId is zero! FromUserName=%s ToUserName=%s", new Object[] { z.a(localco.RIe.RID), z.a(localco.RIe.RIE) });
        }
        else if (!a(localco))
        {
          Log.e("BaseBypSyncHandler", "[onReceive] ignore this msg %s", new Object[] { localco.RIf });
        }
        else
        {
          if (localco.RIh)
          {
            paramLinkedList = localco.RIe.RID;
            paramLinkedList = z.a(paramLinkedList);
            String str = (String)h.aHG().aHp().b(2, "");
            if ((localco.RIh) && (!paramLinkedList.equals(str))) {
              localn.bbU().fk(paramLinkedList, cEZ());
            }
            if (!localco.RIh) {
              break label619;
            }
            localco.RIe.RIE = z.ZW(localco.RIf);
          }
          for (;;)
          {
            paramLinkedList = new h.a(localco.RIe, false, false, false);
            paramLinkedList.lCh = new co().parseFrom(localsl.tqA.UH);
            paramLinkedList.what = cFa();
            ((m)h.ae(m.class)).processAddMsg(paramLinkedList, cFb());
            break;
            paramLinkedList = localco.RIe.RIE;
            break label459;
            localco.RIe.RID = z.ZW(localco.RIf);
          }
        }
      }
      this.sWt.dD(this.sWu);
    } while (paramBoolean);
    cFc();
  }
  
  protected abstract int cEZ();
  
  protected abstract int cFa();
  
  protected abstract ae cFb();
  
  protected boolean k(Exception paramException)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.a.a
 * JD-Core Version:    0.7.0.1
 */