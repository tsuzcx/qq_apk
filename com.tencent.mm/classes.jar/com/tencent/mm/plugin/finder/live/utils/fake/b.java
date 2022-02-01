package com.tencent.mm.plugin.finder.live.utils.fake;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j;
import com.tencent.mm.plugin.finder.live.viewmodel.data.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/utils/fake/FinderLiveGiftMockDebug;", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "commandList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/live/utils/fake/FinderLiveGiftMockUtil$MockCommand;", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "comboAtTheSameTime", "", "createDefault", "giftType", "Lcom/tencent/mm/plugin/finder/live/utils/fake/GiftType;", "count", "", "duplicatedMsgId", "preciousGiftDelayOut", "preciousGiftHandlerDuplicateInvoke", "relaunchAndOnAnimationEndCurrentCase", "relaunchFailCase", "replaceBulletCase", "sendGiftToLinkMicUser", "show", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final a DKh;
  private final a CvU;
  private final LinkedList<c.d> DKi;
  private final MMActivity activity;
  
  static
  {
    AppMethodBeat.i(351129);
    DKh = new a((byte)0);
    AppMethodBeat.o(351129);
  }
  
  public b(MMActivity paramMMActivity, a parama)
  {
    AppMethodBeat.i(351083);
    this.activity = paramMMActivity;
    this.CvU = parama;
    this.DKi = new LinkedList();
    AppMethodBeat.o(351083);
  }
  
  private final c.d a(e parame, int paramInt)
  {
    AppMethodBeat.i(351089);
    c localc = c.DKj;
    parame = (c.c)c.euW().get(parame);
    if (parame == null)
    {
      AppMethodBeat.o(351089);
      return null;
    }
    parame = parame.Pv(paramInt);
    if (parame == null)
    {
      AppMethodBeat.o(351089);
      return null;
    }
    parame = parame.axT(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CvU.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).mIC);
    AppMethodBeat.o(351089);
    return parame;
  }
  
  private static final void a(b paramb, MenuItem paramMenuItem, int paramInt)
  {
    Object localObject5 = null;
    LinkedList localLinkedList = null;
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject4 = null;
    AppMethodBeat.i(351123);
    kotlin.g.b.s.u(paramb, "this$0");
    if (paramMenuItem.getItemId() == 1)
    {
      paramb.DKi.clear();
      localObject1 = paramb.DKi;
      paramMenuItem = paramb.a(e.DKw, 1);
      if (paramMenuItem == null)
      {
        paramMenuItem = null;
        ((LinkedList)localObject1).offerLast(paramMenuItem);
        localObject1 = paramb.DKi;
        localObject2 = paramb.a(e.DKw, 5);
        if (localObject2 != null) {
          break label135;
        }
        paramMenuItem = localObject4;
      }
      for (;;)
      {
        ((LinkedList)localObject1).offerLast(paramMenuItem);
        paramMenuItem = c.DKj;
        c.gH((List)paramb.DKi);
        AppMethodBeat.o(351123);
        return;
        paramMenuItem = paramMenuItem.axS("1");
        break;
        label135:
        ((c.d)localObject2).DKr = 4000L;
        paramMenuItem = localObject4;
        if (localObject2 != null) {
          paramMenuItem = ((c.d)localObject2).axS("1");
        }
      }
    }
    if (paramMenuItem.getItemId() == 2)
    {
      paramb.DKi.clear();
      localObject1 = paramb.DKi;
      paramMenuItem = paramb.a(e.DKB, 5);
      if (paramMenuItem == null)
      {
        paramMenuItem = null;
        ((LinkedList)localObject1).offerLast(paramMenuItem);
        localObject1 = paramb.DKi;
        paramMenuItem = paramb.a(e.DKA, 1);
        if (paramMenuItem != null) {
          break label305;
        }
        paramMenuItem = null;
        label228:
        ((LinkedList)localObject1).offerLast(paramMenuItem);
      }
    }
    int i;
    label643:
    label1179:
    label1694:
    for (paramInt = 0;; paramInt = i)
    {
      i = paramInt + 1;
      localObject1 = paramb.DKi;
      paramMenuItem = paramb.a(e.DKw, 1);
      if (paramMenuItem == null) {
        paramMenuItem = null;
      }
      for (;;)
      {
        ((LinkedList)localObject1).offerLast(paramMenuItem);
        if (i <= 19) {
          break label1694;
        }
        paramMenuItem = c.DKj;
        c.gH((List)paramb.DKi);
        AppMethodBeat.o(351123);
        return;
        paramMenuItem.DKr = 150L;
        break;
        label305:
        paramMenuItem.DKr = 250L;
        break label228;
        paramMenuItem.DKr = (100L * paramInt);
        if (paramMenuItem == null) {
          paramMenuItem = null;
        } else {
          paramMenuItem = paramMenuItem.axS("1");
        }
      }
      if (paramMenuItem.getItemId() == 3)
      {
        paramb.DKi.clear();
        paramb.DKi.offerLast(paramb.a(e.DKB, 1));
        localObject1 = paramb.DKi;
        localObject2 = paramb.a(e.DKA, 1);
        if (localObject2 == null) {
          paramMenuItem = localObject5;
        }
        for (;;)
        {
          ((LinkedList)localObject1).offerLast(paramMenuItem);
          paramMenuItem = c.DKj;
          c.gH((List)paramb.DKi);
          AppMethodBeat.o(351123);
          return;
          ((c.d)localObject2).DKr = 1000L;
          paramMenuItem = localObject5;
          if (localObject2 != null) {
            paramMenuItem = ((c.d)localObject2).euX();
          }
        }
      }
      if (paramMenuItem.getItemId() == 4)
      {
        paramb.DKi.clear();
        paramMenuItem = a.CMm;
        paramMenuItem = a.emY();
        if (paramMenuItem != null)
        {
          paramMenuItem = (j)paramMenuItem.business(j.class);
          if (paramMenuItem != null)
          {
            paramMenuItem = paramMenuItem.Efw;
            if (paramMenuItem != null)
            {
              localObject1 = ((Iterable)paramMenuItem).iterator();
              if (((Iterator)localObject1).hasNext())
              {
                localObject2 = (h)((Iterator)localObject1).next();
                localLinkedList = paramb.DKi;
                paramMenuItem = c.DKj;
                paramMenuItem = (c.c)c.euW().get(e.DKw);
                if (paramMenuItem == null)
                {
                  paramMenuItem = null;
                  label567:
                  localLinkedList.offerLast(paramMenuItem);
                  localLinkedList = paramb.DKi;
                  paramMenuItem = c.DKj;
                  paramMenuItem = (c.c)c.euW().get(e.DKC);
                  if (paramMenuItem != null) {
                    break label643;
                  }
                  paramMenuItem = null;
                }
                for (;;)
                {
                  localLinkedList.offerLast(paramMenuItem);
                  break;
                  paramMenuItem = paramMenuItem.Pv(1);
                  if (paramMenuItem == null)
                  {
                    paramMenuItem = null;
                    break label567;
                  }
                  paramMenuItem = paramMenuItem.axT(((h)localObject2).username);
                  break label567;
                  paramMenuItem = paramMenuItem.Pv(1);
                  if (paramMenuItem == null)
                  {
                    paramMenuItem = null;
                  }
                  else
                  {
                    paramMenuItem.DKr = 1500L;
                    if (paramMenuItem == null) {
                      paramMenuItem = null;
                    } else {
                      paramMenuItem = paramMenuItem.axT(((h)localObject2).username);
                    }
                  }
                }
              }
            }
          }
        }
        paramMenuItem = c.DKj;
        c.gH((List)paramb.DKi);
        AppMethodBeat.o(351123);
        return;
      }
      if (paramMenuItem.getItemId() == 5)
      {
        paramb.DKi.clear();
        localObject1 = paramb.DKi;
        paramMenuItem = paramb.a(e.DKA, 1);
        if (paramMenuItem == null)
        {
          paramMenuItem = null;
          ((LinkedList)localObject1).offerLast(paramMenuItem);
          localObject2 = paramb.DKi;
          paramMenuItem = paramb.a(e.DKA, 1);
          if (paramMenuItem != null) {
            break label813;
          }
          paramMenuItem = localLinkedList;
        }
        for (;;)
        {
          ((LinkedList)localObject2).offerLast(paramMenuItem);
          paramMenuItem = c.DKj;
          c.gH((List)paramb.DKi);
          AppMethodBeat.o(351123);
          return;
          paramMenuItem = paramMenuItem.axS("1");
          break;
          label813:
          localObject1 = paramMenuItem.axS("1");
          paramMenuItem = localLinkedList;
          if (localObject1 != null)
          {
            ((c.d)localObject1).DKr = 6000L;
            paramMenuItem = (MenuItem)localObject1;
          }
        }
      }
      if (paramMenuItem.getItemId() == 6)
      {
        paramb.DKi.clear();
        localObject1 = UUID.randomUUID().toString();
        kotlin.g.b.s.s(localObject1, "randomUUID().toString()");
        localObject2 = paramb.DKi;
        paramMenuItem = paramb.a(e.DKw, 1);
        if (paramMenuItem == null)
        {
          paramMenuItem = null;
          ((LinkedList)localObject2).offerLast(paramMenuItem);
          localObject2 = paramb.DKi;
          paramMenuItem = paramb.a(e.DKw, 1);
          if (paramMenuItem != null) {
            break label965;
          }
        }
        label965:
        for (paramMenuItem = localObject3;; paramMenuItem = paramMenuItem.axS((String)localObject1))
        {
          ((LinkedList)localObject2).offerLast(paramMenuItem);
          paramMenuItem = c.DKj;
          c.k((List)paramb.DKi, true);
          AppMethodBeat.o(351123);
          return;
          paramMenuItem = paramMenuItem.axS((String)localObject1);
          break;
        }
      }
      if (paramMenuItem.getItemId() == 7)
      {
        paramb.DKi.clear();
        localObject2 = UUID.randomUUID().toString();
        kotlin.g.b.s.s(localObject2, "randomUUID().toString()");
        localLinkedList = paramb.DKi;
        paramMenuItem = paramb.a(e.DKw, 1);
        if (paramMenuItem == null)
        {
          paramMenuItem = null;
          localLinkedList.offerLast(paramMenuItem);
          localLinkedList = paramb.DKi;
          paramMenuItem = paramb.a(e.DKw, 1);
          if (paramMenuItem != null) {
            break label1262;
          }
          paramMenuItem = null;
          label1058:
          localLinkedList.offerLast(paramMenuItem);
          localLinkedList = paramb.DKi;
          paramMenuItem = paramb.a(e.DKw, 1);
          if (paramMenuItem != null) {
            break label1288;
          }
          paramMenuItem = null;
          label1086:
          localLinkedList.offerLast(paramMenuItem);
          paramMenuItem = c.DKj;
          c.gH((List)paramb.DKi);
          paramb.DKi.clear();
          localObject2 = UUID.randomUUID().toString();
          kotlin.g.b.s.s(localObject2, "randomUUID().toString()");
          localLinkedList = paramb.DKi;
          paramMenuItem = paramb.a(e.DKx, 1);
          if (paramMenuItem != null) {
            break label1315;
          }
          paramMenuItem = null;
          label1151:
          localLinkedList.offerLast(paramMenuItem);
          localLinkedList = paramb.DKi;
          paramMenuItem = paramb.a(e.DKx, 1);
          if (paramMenuItem != null) {
            break label1341;
          }
          paramMenuItem = null;
          localLinkedList.offerLast(paramMenuItem);
          localLinkedList = paramb.DKi;
          paramMenuItem = paramb.a(e.DKx, 1);
          if (paramMenuItem != null) {
            break label1367;
          }
          paramMenuItem = (MenuItem)localObject1;
        }
        for (;;)
        {
          localLinkedList.offerLast(paramMenuItem);
          paramMenuItem = c.DKj;
          c.k((List)paramb.DKi, true);
          AppMethodBeat.o(351123);
          return;
          paramMenuItem = paramMenuItem.axS((String)localObject2);
          if (paramMenuItem == null)
          {
            paramMenuItem = null;
            break;
          }
          paramMenuItem = paramMenuItem.axU((String)localObject2);
          break;
          label1262:
          paramMenuItem = paramMenuItem.axS((String)localObject2);
          if (paramMenuItem == null)
          {
            paramMenuItem = null;
            break label1058;
          }
          paramMenuItem = paramMenuItem.axU((String)localObject2);
          break label1058;
          paramMenuItem = paramMenuItem.axS((String)localObject2);
          if (paramMenuItem == null)
          {
            paramMenuItem = null;
            break label1086;
          }
          paramMenuItem = paramMenuItem.axU("");
          break label1086;
          label1315:
          paramMenuItem = paramMenuItem.axS((String)localObject2);
          if (paramMenuItem == null)
          {
            paramMenuItem = null;
            break label1151;
          }
          paramMenuItem = paramMenuItem.axU((String)localObject2);
          break label1151;
          label1341:
          paramMenuItem = paramMenuItem.axS((String)localObject2);
          if (paramMenuItem == null)
          {
            paramMenuItem = null;
            break label1179;
          }
          paramMenuItem = paramMenuItem.axU((String)localObject2);
          break label1179;
          label1367:
          localObject2 = paramMenuItem.axS((String)localObject2);
          paramMenuItem = (MenuItem)localObject1;
          if (localObject2 != null) {
            paramMenuItem = ((c.d)localObject2).axU("");
          }
        }
      }
      if (paramMenuItem.getItemId() == 8)
      {
        paramb.DKi.clear();
        paramb.DKi.offerLast(paramb.a(e.DKw, 1));
        paramb.DKi.offerLast(paramb.a(e.DKw, 1));
        localObject1 = paramb.DKi;
        paramMenuItem = paramb.a(e.DKx, 1);
        if (paramMenuItem != null) {
          break label1634;
        }
        paramMenuItem = null;
        ((LinkedList)localObject1).offerLast(paramMenuItem);
        localObject1 = paramb.DKi;
        paramMenuItem = paramb.a(e.DKx, 1);
        if (paramMenuItem != null) {
          break label1644;
        }
        paramMenuItem = null;
        label1494:
        ((LinkedList)localObject1).offerLast(paramMenuItem);
        localObject1 = paramb.DKi;
        paramMenuItem = paramb.a(e.DKw, 1);
        if (paramMenuItem != null) {
          break label1654;
        }
        paramMenuItem = null;
        label1522:
        ((LinkedList)localObject1).offerLast(paramMenuItem);
        localObject1 = paramb.DKi;
        paramMenuItem = paramb.a(e.DKw, 1);
        if (paramMenuItem != null) {
          break label1664;
        }
        paramMenuItem = null;
        ((LinkedList)localObject1).offerLast(paramMenuItem);
        localObject1 = paramb.DKi;
        paramMenuItem = paramb.a(e.DKF, 1);
        if (paramMenuItem != null) {
          break label1674;
        }
        paramMenuItem = null;
        label1578:
        ((LinkedList)localObject1).offerLast(paramMenuItem);
        localObject1 = paramb.DKi;
        paramMenuItem = paramb.a(e.DKA, 1);
        if (paramMenuItem != null) {
          break label1684;
        }
        paramMenuItem = (MenuItem)localObject2;
      }
      for (;;)
      {
        ((LinkedList)localObject1).offerLast(paramMenuItem);
        paramMenuItem = c.DKj;
        c.gH((List)paramb.DKi);
        AppMethodBeat.o(351123);
        return;
        label1634:
        paramMenuItem.DKr = 3900L;
        break;
        label1644:
        paramMenuItem.DKr = 3900L;
        break label1494;
        label1654:
        paramMenuItem.DKr = 7900L;
        break label1522;
        paramMenuItem.DKr = 7900L;
        break label1550;
        paramMenuItem.DKr = 1000L;
        break label1578;
        paramMenuItem.DKr = 7000L;
      }
    }
  }
  
  private static final void g(com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(351095);
    if (params.jmw())
    {
      params.c(1, (CharSequence)"爱心1+爱心5延迟4秒(小礼物不消失case)");
      params.c(2, (CharSequence)"全自己火箭5+牛气冲天1+爱心连击20（连击聚合失效case）");
      params.c(3, (CharSequence)"火箭1+自己牛气冲天1延迟1秒（大礼物循环播放case）");
      params.c(4, (CharSequence)"给连麦小主播送礼(大礼物强制替换)");
      params.c(5, (CharSequence)"大礼物通知条延迟退场状态下relaunch");
      params.c(6, (CharSequence)"连击消息同时到，拆到了不同槽位");
      params.c(7, (CharSequence)"消息去重");
      params.c(8, (CharSequence)"大礼物通知条延迟退场handler重复触发(大礼物循环)");
    }
    AppMethodBeat.o(351095);
  }
  
  public final void show()
  {
    AppMethodBeat.i(351144);
    f localf = new f((Context)this.activity, 1, false);
    localf.Vtg = b..ExternalSyntheticLambda0.INSTANCE;
    localf.GAC = new b..ExternalSyntheticLambda1(this);
    localf.dDn();
    AppMethodBeat.o(351144);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/utils/fake/FinderLiveGiftMockDebug$Companion;", "", "()V", "MOCK_GIFT_1", "", "MOCK_GIFT_2", "MOCK_GIFT_3", "MOCK_GIFT_4", "MOCK_GIFT_5", "MOCK_GIFT_6", "MOCK_GIFT_7", "MOCK_GIFT_8", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.utils.fake.b
 * JD-Core Version:    0.7.0.1
 */