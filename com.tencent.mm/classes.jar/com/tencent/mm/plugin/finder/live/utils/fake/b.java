package com.tencent.mm.plugin.finder.live.utils.fake;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/utils/fake/FinderLiveGiftMockDebug;", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "MOCK_GIFT_1", "", "getMOCK_GIFT_1", "()I", "MOCK_GIFT_2", "getMOCK_GIFT_2", "MOCK_GIFT_3", "getMOCK_GIFT_3", "MOCK_GIFT_4", "getMOCK_GIFT_4", "MOCK_GIFT_5", "getMOCK_GIFT_5", "MOCK_GIFT_6", "getMOCK_GIFT_6", "MOCK_GIFT_7", "getMOCK_GIFT_7", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "commandList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/live/utils/fake/FinderLiveGiftMockUtil$MockCommand;", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "comboAtTheSameTime", "", "createDefault", "giftType", "Lcom/tencent/mm/plugin/finder/live/utils/fake/GiftType;", "count", "duplicatedMsgId", "preciousGiftDelayOut", "relaunchAndOnAnimationEndCurrentCase", "relaunchFailCase", "replaceBulletCase", "sendGiftToLinkMicUser", "show", "Companion", "plugin-finder_release"})
public final class b
{
  private static final String TAG = "MicroMsg.FinderLiveGiftMockDebug";
  public static final a yRQ;
  public final MMActivity activity;
  private final a xYp;
  final int yRI;
  final int yRJ;
  final int yRK;
  final int yRL;
  final int yRM;
  final int yRN;
  final int yRO;
  private final LinkedList<c.d> yRP;
  
  static
  {
    AppMethodBeat.i(281303);
    yRQ = new a((byte)0);
    TAG = "MicroMsg.FinderLiveGiftMockDebug";
    AppMethodBeat.o(281303);
  }
  
  public b(MMActivity paramMMActivity, a parama)
  {
    AppMethodBeat.i(281302);
    this.activity = paramMMActivity;
    this.xYp = parama;
    this.yRI = 1;
    this.yRJ = 2;
    this.yRK = 3;
    this.yRL = 4;
    this.yRM = 5;
    this.yRN = 6;
    this.yRO = 7;
    this.yRP = new LinkedList();
    AppMethodBeat.o(281302);
  }
  
  private final c.d a(e parame, int paramInt)
  {
    AppMethodBeat.i(281301);
    c localc = c.yRV;
    parame = (c.c)c.dES().get(parame);
    if (parame != null)
    {
      parame = parame.NL(paramInt).aCS(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYp.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig);
      AppMethodBeat.o(281301);
      return parame;
    }
    AppMethodBeat.o(281301);
    return null;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/utils/fake/FinderLiveGiftMockDebug$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  public static final class b
    implements q.f
  {
    public b(b paramb) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(271985);
      p.j(paramo, "it");
      if (paramo.hJO())
      {
        paramo.d(this.yRR.yRI, (CharSequence)"爱心1+爱心5延迟4秒(小礼物不消失case)");
        paramo.d(this.yRR.yRJ, (CharSequence)"全自己火箭5+牛气冲天1+爱心连击20（连击聚合失效case）");
        paramo.d(this.yRR.yRK, (CharSequence)"火箭1+自己牛气冲天1延迟1秒（大礼物循环播放case）");
        paramo.d(this.yRR.yRL, (CharSequence)"给连麦小主播送礼(大礼物强制替换)");
        paramo.d(this.yRR.yRM, (CharSequence)"大礼物通知条延迟退场状态下relaunch");
        paramo.d(this.yRR.yRN, (CharSequence)"连击消息同时到，拆到了不同槽位");
        paramo.d(this.yRR.yRO, (CharSequence)"消息去重");
      }
      AppMethodBeat.o(271985);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  public static final class c
    implements q.g
  {
    public c(b paramb) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(284958);
      p.j(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == this.yRR.yRI)
      {
        b.a(this.yRR);
        AppMethodBeat.o(284958);
        return;
      }
      if (paramMenuItem.getItemId() == this.yRR.yRJ)
      {
        b.b(this.yRR);
        AppMethodBeat.o(284958);
        return;
      }
      if (paramMenuItem.getItemId() == this.yRR.yRK)
      {
        b.c(this.yRR);
        AppMethodBeat.o(284958);
        return;
      }
      if (paramMenuItem.getItemId() == this.yRR.yRL)
      {
        b.d(this.yRR);
        AppMethodBeat.o(284958);
        return;
      }
      if (paramMenuItem.getItemId() == this.yRR.yRM)
      {
        b.e(this.yRR);
        AppMethodBeat.o(284958);
        return;
      }
      if (paramMenuItem.getItemId() == this.yRR.yRN)
      {
        b.f(this.yRR);
        AppMethodBeat.o(284958);
        return;
      }
      if (paramMenuItem.getItemId() == this.yRR.yRO) {
        b.g(this.yRR);
      }
      AppMethodBeat.o(284958);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.utils.fake.b
 * JD-Core Version:    0.7.0.1
 */