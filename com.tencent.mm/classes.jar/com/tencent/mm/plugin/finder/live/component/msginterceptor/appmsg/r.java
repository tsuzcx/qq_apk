package com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bez;
import com.tencent.mm.protocal.protobuf.dij;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.bdm;>;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/appmsg/LiveUpdateFinderObjectInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IFinderLiveAppMsgInterceptor;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "dealWithMsgList", "", "msgList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "legalMsgType", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
  extends f
{
  public r(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(353267);
    AppMethodBeat.o(353267);
  }
  
  public final void ap(LinkedList<bdm> paramLinkedList)
  {
    AppMethodBeat.i(353288);
    s.u(paramLinkedList, "msgList");
    e locale = (e)eji().business(e.class);
    Object localObject2;
    long l1;
    Object localObject1;
    if (locale != null)
    {
      s.u(paramLinkedList, "remoteLiveAppMsg");
      localObject2 = ((Iterable)paramLinkedList).iterator();
      if (!((Iterator)localObject2).hasNext())
      {
        paramLinkedList = null;
        paramLinkedList = (bdm)paramLinkedList;
        if (paramLinkedList != null) {
          break label539;
        }
        l1 = 0L;
        if (l1 < locale.EeL) {
          break label612;
        }
        if (paramLinkedList == null) {
          break label668;
        }
        localObject2 = paramLinkedList.ZNY;
        if (localObject2 == null) {
          break label668;
        }
        locale.EeL = paramLinkedList.seq;
        localObject1 = new bez();
        paramLinkedList = (com.tencent.mm.bx.a)localObject1;
        localObject2 = ((b)localObject2).toByteArray();
      }
    }
    label539:
    label668:
    label682:
    label685:
    for (;;)
    {
      try
      {
        paramLinkedList.parseFrom((byte[])localObject2);
        Log.i(locale.TAG, s.X("updateCoverInfo updateFinderInfo.cover_img:", ((bez)localObject1).ZPi));
        dij localdij = ((bez)localObject1).ZPi;
        if (localdij != null)
        {
          String str = localdij.DUR;
          paramLinkedList = ((bez)localObject1).ZPj;
          localObject2 = ((bez)localObject1).description;
          Log.i(locale.TAG, "updateCoverInfo url:" + str + " token:" + paramLinkedList + " desc:" + localObject2);
          CharSequence localCharSequence = (CharSequence)str;
          if ((localCharSequence == null) || (localCharSequence.length() == 0))
          {
            i = 1;
            if (i == 0)
            {
              if (paramLinkedList != null) {
                continue;
              }
              paramLinkedList = "";
              str = s.X(str, paramLinkedList);
              locale.ayk(str);
              paramLinkedList = locale.Eco;
              if (paramLinkedList != null) {
                continue;
              }
              paramLinkedList = null;
              if (paramLinkedList != null) {
                paramLinkedList.EcY = str;
              }
              paramLinkedList = locale.Eco;
              if (paramLinkedList != null)
              {
                paramLinkedList = paramLinkedList.objectDesc;
                if (paramLinkedList != null)
                {
                  paramLinkedList = paramLinkedList.media;
                  if (paramLinkedList != null)
                  {
                    paramLinkedList = (FinderMedia)p.oL((List)paramLinkedList);
                    if (paramLinkedList != null)
                    {
                      paramLinkedList.thumbUrl = str;
                      paramLinkedList.width = localdij.width;
                      paramLinkedList.height = localdij.height;
                    }
                  }
                }
              }
            }
            paramLinkedList = locale.Eco;
            if (paramLinkedList != null) {
              continue;
            }
            paramLinkedList = null;
            if (paramLinkedList != null) {
              paramLinkedList.description = ((String)localObject2);
            }
            locale.desc = ((String)localObject2);
          }
        }
        else
        {
          if (!Util.isNullOrNil(((bez)localObject1).description))
          {
            ((e)locale.business(e.class)).desc = ((bez)localObject1).description;
            paramLinkedList = ((e)locale.business(e.class)).Eco;
            if (paramLinkedList != null) {
              continue;
            }
            paramLinkedList = null;
            if (paramLinkedList != null) {
              paramLinkedList.description = ((bez)localObject1).description;
            }
          }
          AppMethodBeat.o(353288);
          return;
          paramLinkedList = ((Iterator)localObject2).next();
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          l1 = ((bdm)paramLinkedList).seq;
          localObject1 = ((Iterator)localObject2).next();
          long l2 = ((bdm)localObject1).seq;
          if (l1 >= l2) {
            break label685;
          }
          l1 = l2;
          paramLinkedList = (LinkedList<bdm>)localObject1;
          if (((Iterator)localObject2).hasNext()) {
            break label682;
          }
          break;
          l1 = paramLinkedList.seq;
        }
      }
      catch (Exception paramLinkedList)
      {
        Log.printDebugStack("safeParser", "", new Object[] { paramLinkedList });
        continue;
        int i = 0;
        continue;
        continue;
        paramLinkedList = paramLinkedList.objectDesc;
        if (paramLinkedList == null)
        {
          paramLinkedList = null;
          continue;
        }
        paramLinkedList = paramLinkedList.liveDesc;
        continue;
        paramLinkedList = paramLinkedList.objectDesc;
        continue;
        paramLinkedList = paramLinkedList.objectDesc;
        continue;
      }
      label612:
      localObject1 = locale.TAG;
      localObject2 = new StringBuilder("skip this updateFinderObject by invalid seq. [");
      if (paramLinkedList == null) {}
      for (l1 = 0L;; l1 = paramLinkedList.seq)
      {
        Log.i((String)localObject1, l1 + " : " + locale.EeL + ']');
        AppMethodBeat.o(353288);
        return;
      }
    }
  }
  
  public final int[] ejj()
  {
    return new int[] { 20036 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.r
 * JD-Core Version:    0.7.0.1
 */