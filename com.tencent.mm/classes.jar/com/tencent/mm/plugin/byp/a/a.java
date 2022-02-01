package com.tencent.mm.plugin.byp.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelmulti.e;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.ae;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.protocal.protobuf.cy;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.ub;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public abstract class a
  implements b
{
  private c waD = new c();
  private e waE = new e()
  {
    public final boolean d(Queue<e> paramAnonymousQueue)
    {
      AppMethodBeat.i(271953);
      Log.i("BaseBypSyncHandler", "RUN... %s", new Object[] { Integer.valueOf(paramAnonymousQueue.size()) });
      AppMethodBeat.o(271953);
      return false;
    }
    
    public final String toString()
    {
      return "BaseBypSyncHandler";
    }
  };
  
  private void dim()
  {
    this.waD.fW(this.waE);
    Log.i("BaseBypSyncHandler", "[finishReceive]");
  }
  
  protected boolean a(cy paramcy)
  {
    return true;
  }
  
  public final void b(LinkedList<ub> paramLinkedList, boolean paramBoolean)
  {
    Log.i("BaseBypSyncHandler", "[onReceive] size=%s", new Object[] { Integer.valueOf(paramLinkedList.size()) });
    n localn = (n)h.ax(n.class);
    ub localub;
    cy localcy;
    for (;;)
    {
      try
      {
        this.waD.fT(this.waE);
        Iterator localIterator = paramLinkedList.iterator();
        if (!localIterator.hasNext()) {
          break label629;
        }
        localub = (ub)localIterator.next();
        if (localub.item_type != 1) {
          continue;
        }
        localcy = new cy();
        localcy.parseFrom(localub.wuZ.Op);
        if ((Util.isNullOrNil(localcy.YFh)) && ((localcy.YFg.IIs == 10002) || (localcy.YFg.IIs == 10001)))
        {
          Log.i("BaseBypSyncHandler", "dispatchToSysCmdMsgExtension, MsgType=%s isContinue=%s", new Object[] { Integer.valueOf(localcy.YFg.IIs), Boolean.valueOf(paramBoolean) });
          if (localcy.YFg.YFI == null)
          {
            localcy.YFg.YFI = new gol();
            Log.e("BaseBypSyncHandler", "[processToFunctionMsg] ImgBuf is null");
          }
          paramLinkedList = new g.a(localcy.YFg, false, false, false);
          ((v)h.az(v.class)).getSysCmdMsgExtension().b(paramLinkedList);
          continue;
        }
        if (!Util.isNullOrNil(localcy.YFh)) {
          break label347;
        }
      }
      catch (Exception paramLinkedList)
      {
        Log.printErrStackTrace("BaseBypSyncHandler", paramLinkedList, "", new Object[0]);
        if (!l(paramLinkedList)) {
          break label649;
        }
        throw new RuntimeException(paramLinkedList);
      }
      finally
      {
        this.waD.fU(this.waE);
        if (!paramBoolean) {
          dim();
        }
      }
      Log.e("BaseBypSyncHandler", "msg_session_id is null! FromUserName=%s ToUserName=%s", new Object[] { w.a(localcy.YFg.YFE), w.a(localcy.YFg.YFF) });
      continue;
      label347:
      if (localcy.YFg.Njv == 0L)
      {
        Log.e("BaseBypSyncHandler", "NewMsgId is zero! FromUserName=%s ToUserName=%s", new Object[] { w.a(localcy.YFg.YFE), w.a(localcy.YFg.YFF) });
      }
      else
      {
        if (a(localcy)) {
          break;
        }
        Log.e("BaseBypSyncHandler", "[onReceive] ignore this msg %s", new Object[] { localcy.YFh });
      }
    }
    if (localcy.YFj)
    {
      paramLinkedList = localcy.YFg.YFE;
      label450:
      paramLinkedList = w.a(paramLinkedList);
      String str = (String)h.baE().ban().d(2, "");
      if ((localcy.YFj) && (!paramLinkedList.equals(str))) {
        localn.bzJ().gd(paramLinkedList, dij());
      }
      if (!localcy.YFj) {
        break label610;
      }
      localcy.YFg.YFF = w.Sk(localcy.YFh);
    }
    for (;;)
    {
      paramLinkedList = new g.a(localcy.YFg, false, false, false);
      paramLinkedList.extra = new cy().parseFrom(localub.wuZ.Op);
      paramLinkedList.what = dik();
      ((m)h.ax(m.class)).processAddMsg(paramLinkedList, dil());
      break;
      paramLinkedList = localcy.YFg.YFF;
      break label450;
      label610:
      localcy.YFg.YFE = w.Sk(localcy.YFh);
    }
    label629:
    this.waD.fU(this.waE);
    if (!paramBoolean) {
      dim();
    }
    label649:
    do
    {
      return;
      this.waD.fU(this.waE);
    } while (paramBoolean);
    dim();
  }
  
  protected abstract int dij();
  
  public abstract int dik();
  
  protected abstract ae dil();
  
  protected boolean l(Exception paramException)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.a.a
 * JD-Core Version:    0.7.0.1
 */