package com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.f;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bdq;
import com.tencent.mm.protocal.protobuf.bex;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.bkf;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.bdm;>;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/appmsg/LiveAlertMsgInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IFinderLiveAppMsgInterceptor;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "TAG", "", "chooseAlertInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsgBoxInfo;", "info1", "info2", "dealWithMsgList", "", "msgList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "handleAlertMsg", "roomData", "appMsgList", "legalMsgType", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.finder.live.component.msginterceptor.f
{
  private final String TAG;
  
  public a(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(353302);
    this.TAG = "LiveAlertMsgInterceptor";
    AppMethodBeat.o(353302);
  }
  
  private static bkf a(bkf parambkf1, bkf parambkf2)
  {
    switch (parambkf1.type)
    {
    }
    do
    {
      do
      {
        return parambkf1;
      } while ((parambkf2.type != 20011) && (parambkf2.type != 20007));
      return parambkf2;
    } while (parambkf2.type != 20007);
    return parambkf2;
  }
  
  public final void ap(LinkedList<bdm> paramLinkedList)
  {
    AppMethodBeat.i(353325);
    s.u(paramLinkedList, "msgList");
    com.tencent.mm.plugin.finder.live.model.context.a locala = eji();
    StringBuilder localStringBuilder = new StringBuilder("handleAlertMsg:");
    Iterator localIterator = ((Iterable)paramLinkedList).iterator();
    int i = 0;
    paramLinkedList = null;
    label513:
    if (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      int j = i + 1;
      if (i < 0) {
        p.kkW();
      }
      Object localObject4 = (bdm)localObject1;
      Object localObject3 = new StringBuilder("(").append(i).append(")[msgType:");
      label108:
      boolean bool;
      if (localObject4 == null)
      {
        localObject1 = null;
        localObject3 = ((StringBuilder)localObject3).append(localObject1).append(",payload is empty:");
        if (localObject4 != null) {
          break label258;
        }
        localObject1 = null;
        label130:
        if (localObject1 != null) {
          break label268;
        }
        bool = true;
        label138:
        localObject3 = ((StringBuilder)localObject3).append(bool).append(",fromUser:");
        if (localObject4 != null) {
          break label274;
        }
        localObject1 = null;
        label160:
        localObject3 = ((StringBuilder)localObject3).append(localObject1).append(",toUser:");
        if (localObject4 != null) {
          break label320;
        }
        localObject1 = null;
        label182:
        localStringBuilder.append(localObject1 + "] ");
        if (localObject4 != null) {
          switch (((bdm)localObject4).msg_type)
          {
          }
        }
      }
      label258:
      label268:
      label274:
      label660:
      label670:
      label677:
      for (;;)
      {
        i = j;
        break;
        localObject1 = Integer.valueOf(((bdm)localObject4).msg_type);
        break label108;
        localObject1 = ((bdm)localObject4).ZNY;
        break label130;
        bool = false;
        break label138;
        localObject1 = ((bdm)localObject4).ZOb;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label160;
        }
        localObject1 = ((bgh)localObject1).contact;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label160;
        }
        localObject1 = ((FinderContact)localObject1).nickname;
        break label160;
        label320:
        localObject1 = ((bdm)localObject4).ZNW;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label182;
        }
        localObject1 = ((bgh)localObject1).contact;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label182;
        }
        localObject1 = ((FinderContact)localObject1).nickname;
        break label182;
        localObject3 = (com.tencent.mm.bx.a)new bex();
        localObject1 = ((bdm)localObject4).ZNY;
        if (localObject1 == null) {}
        for (localObject1 = null;; localObject1 = ((b)localObject1).toByteArray())
        {
          try
          {
            ((com.tencent.mm.bx.a)localObject3).parseFrom((byte[])localObject1);
            localObject1 = localObject3;
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              Log.printDebugStack("safeParser", "", new Object[] { localException1 });
              localObject2 = null;
              continue;
              localObject2 = ((bex)localObject2).ZOs;
              continue;
              localObject3 = localObject2;
            }
          }
          localObject1 = (bex)localObject1;
          if (localObject1 != null) {
            break label496;
          }
          localObject1 = null;
          localObject4 = this.TAG;
          if (localObject1 != null) {
            break label506;
          }
          localObject3 = "";
          Log.i((String)localObject4, s.X("parseMsgBoxInfo:", com.tencent.mm.ae.f.dg(localObject3)));
          if (paramLinkedList != null) {
            break label513;
          }
          i = j;
          paramLinkedList = (LinkedList<bdm>)localObject1;
          break;
        }
        Object localObject2;
        label496:
        label506:
        if (localObject2 != null)
        {
          paramLinkedList = a(paramLinkedList, (bkf)localObject2);
          i = j;
          break;
          localObject3 = (com.tencent.mm.bx.a)new bdq();
          localObject2 = ((bdm)localObject4).ZNY;
          if (localObject2 == null) {}
          for (localObject2 = null;; localObject2 = ((b)localObject2).toByteArray())
          {
            try
            {
              ((com.tencent.mm.bx.a)localObject3).parseFrom((byte[])localObject2);
              localObject2 = localObject3;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                Log.printDebugStack("safeParser", "", new Object[] { localException2 });
                localbkf = null;
                continue;
                localbkf = localbkf.ZOs;
                continue;
                localObject3 = localbkf;
              }
            }
            localObject2 = (bdq)localObject2;
            if (localObject2 != null) {
              break label660;
            }
            localObject2 = null;
            localObject4 = this.TAG;
            if (localObject2 != null) {
              break label670;
            }
            localObject3 = "";
            Log.i((String)localObject4, s.X("parseMsgBoxInfo:", com.tencent.mm.ae.f.dg(localObject3)));
            if (paramLinkedList != null) {
              break label677;
            }
            i = j;
            paramLinkedList = (LinkedList<bdm>)localObject2;
            break;
          }
          bkf localbkf;
          if (localbkf != null) {
            paramLinkedList = a(paramLinkedList, localbkf);
          }
        }
      }
    }
    if (paramLinkedList != null) {
      d.uiThread((kotlin.g.a.a)new e.f((e)locala.business(e.class), paramLinkedList));
    }
    Log.i(this.TAG, localStringBuilder.toString());
    AppMethodBeat.o(353325);
  }
  
  public final int[] ejj()
  {
    return new int[] { 20011, 20007 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.a
 * JD-Core Version:    0.7.0.1
 */