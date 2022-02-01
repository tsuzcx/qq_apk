package com.tencent.mm.plugin.gamelife.ui;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cw.f;
import com.tencent.mm.cw.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.b.a;
import com.tencent.mm.plugin.gamelife.d.f;
import com.tencent.mm.plugin.gamelife.e.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.TouchableLayout.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationLongClickListener;", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;", "Landroid/view/View$OnCreateContextMenuListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "Landroid/widget/PopupWindow$OnDismissListener;", "callBack", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "focusedConversation", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "focusedPos", "", "totalDataNum", "onCreateContextMenu", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onDismiss", "onItemLongClick", "view", "position", "conv", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", "index", "Companion", "plugin-gamelife_release"})
public final class c
  implements View.OnCreateContextMenuListener, PopupWindow.OnDismissListener, b.d, q.g
{
  public static final c.a Dit;
  private com.tencent.mm.plugin.gamelife.e.a Diq;
  private int Dir;
  private int Dis;
  private kotlin.g.a.a<x> xgx;
  
  static
  {
    AppMethodBeat.i(202735);
    Dit = new c.a((byte)0);
    AppMethodBeat.o(202735);
  }
  
  public c(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(202733);
    this.xgx = parama;
    AppMethodBeat.o(202733);
  }
  
  public final void a(View paramView, int paramInt1, com.tencent.mm.plugin.gamelife.e.a parama, int paramInt2)
  {
    AppMethodBeat.i(202731);
    p.k(paramView, "view");
    p.k(parama, "conv");
    this.Diq = parama;
    this.Dir = paramInt1;
    this.Dis = paramInt2;
    parama = new com.tencent.mm.ui.widget.b.a(paramView.getContext());
    parama.setOnDismissListener((PopupWindow.OnDismissListener)this);
    View.OnCreateContextMenuListener localOnCreateContextMenuListener = (View.OnCreateContextMenuListener)this;
    q.g localg = (q.g)this;
    TouchableLayout.a locala = TouchableLayout.YOD;
    paramInt2 = TouchableLayout.igZ();
    locala = TouchableLayout.YOD;
    parama.a(paramView, paramInt1, 0L, localOnCreateContextMenuListener, localg, paramInt2, TouchableLayout.iha());
    parama.hTd();
    AppMethodBeat.o(202731);
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(202725);
    p.k(paramContextMenu, "menu");
    p.k(paramView, "v");
    p.k(paramContextMenuInfo, "menuInfo");
    paramView = this.Diq;
    if (paramView != null) {}
    for (paramView = Boolean.valueOf(paramView.eAs()); paramView != null; paramView = null)
    {
      paramView = this.Diq;
      if ((paramView == null) || (paramView.eAs() != true)) {
        break;
      }
      paramContextMenu.add(0, 3, 0, d.f.Dgj);
      AppMethodBeat.o(202725);
      return;
    }
    paramView = this.Diq;
    if ((paramView == null) || (paramView.field_unReadCount != 0)) {
      paramContextMenu.add(0, 0, 0, d.f.Dgk);
    }
    for (;;)
    {
      paramContextMenu.add(0, 3, 0, d.f.Dgj);
      AppMethodBeat.o(202725);
      return;
      paramContextMenu.add(0, 1, 0, d.f.Dgl);
    }
  }
  
  public final void onDismiss()
  {
    this.Diq = null;
  }
  
  public final void onMMMenuItemSelected(final MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(202730);
    p.k(paramMenuItem, "menuItem");
    paramInt = paramMenuItem.getItemId();
    Object localObject1 = this.Diq;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_sessionId;
      Log.i("GameLife.ConversationOnLongClickListener", "menuItem.itemId:%d,sessionId:%s", new Object[] { Integer.valueOf(paramInt), localObject1 });
      localObject1 = this.Diq;
      if (localObject1 == null) {
        break label774;
      }
      switch (paramMenuItem.getItemId())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(202730);
      return;
      localObject1 = null;
      break;
      paramMenuItem = ((PluginGameLife)h.ag(PluginGameLife.class)).getConversationStorage();
      Object localObject2 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_sessionId;
      p.j(localObject2, "focused.field_sessionId");
      if (paramMenuItem.aEI((String)localObject2))
      {
        paramMenuItem = this.xgx;
        if (paramMenuItem != null)
        {
          paramMenuItem.invoke();
          AppMethodBeat.o(202730);
          return;
        }
        AppMethodBeat.o(202730);
        return;
      }
      Log.e("GameLife.ConversationOnLongClickListener", "clearUnreadCount failed. sessionId=" + ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_sessionId);
      AppMethodBeat.o(202730);
      return;
      paramMenuItem = ((PluginGameLife)h.ag(PluginGameLife.class)).getConversationStorage();
      localObject2 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_sessionId;
      p.j(localObject2, "focused.field_sessionId");
      p.k(localObject2, "sessionId");
      Object localObject3 = com.tencent.mm.plugin.gamelife.b.DeG;
      if (!b.a.aKC((String)localObject2)) {
        bool = false;
      }
      while (bool)
      {
        paramMenuItem = this.xgx;
        if (paramMenuItem != null)
        {
          paramMenuItem.invoke();
          AppMethodBeat.o(202730);
          return;
          localObject3 = paramMenuItem.aKN((String)localObject2);
          ((com.tencent.mm.plugin.gamelife.e.a)localObject3).field_unReadCount = 1;
          bool = paramMenuItem.update(((com.tencent.mm.plugin.gamelife.e.a)localObject3).systemRowid, (IAutoDBItem)localObject3, false);
          paramMenuItem.doNotify("single", 5, localObject3);
          Log.i("GameLife.ConversationStorage", "[addUnreadCount] ret=" + bool + " sessionId=" + (String)localObject2);
        }
        else
        {
          AppMethodBeat.o(202730);
          return;
        }
      }
      Log.e("GameLife.ConversationOnLongClickListener", "markUnread failed. sessionId=" + ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_sessionId);
      AppMethodBeat.o(202730);
      return;
      int i;
      long l1;
      if (!((com.tencent.mm.plugin.gamelife.e.a)localObject1).eAs())
      {
        localObject3 = ((com.tencent.mm.plugin.gamelife.a.b)h.ae(com.tencent.mm.plugin.gamelife.a.b.class)).aKE(((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_selfUserName);
        if (localObject3 != null)
        {
          localObject2 = com.tencent.mm.game.report.c.jTf;
          paramInt = this.Dir;
          i = this.Dis;
          localObject2 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_sessionId;
          p.j(localObject2, "focused.field_sessionId");
          l1 = ((com.tencent.mm.plugin.gamelife.a.a)localObject3).eAh();
          localObject3 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_selfUserName;
          p.j(localObject3, "focused.field_selfUserName");
          Object localObject4 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).DhA;
          if (localObject4 == null) {
            p.iCn();
          }
          long l2 = ((com.tencent.mm.plugin.gamelife.d.a)localObject4).field_accountType;
          localObject4 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_talker;
          p.j(localObject4, "focused.field_talker");
          long l3 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).eAr();
          com.tencent.mm.plugin.gamelife.i.a locala = com.tencent.mm.plugin.gamelife.i.a.DhX;
          com.tencent.mm.game.report.c.a.a(paramInt - 2 + 1, 92L, i, (String)localObject2, l1, (String)localObject3, l2, (String)localObject4, l3, com.tencent.mm.plugin.gamelife.i.a.eAv());
        }
      }
      for (;;)
      {
        paramMenuItem = paramMenuItem.getMenuInfo();
        if (paramMenuItem != null) {
          break;
        }
        paramMenuItem = new t("null cannot be cast to non-null type android.widget.AdapterView.AdapterContextMenuInfo");
        AppMethodBeat.o(202730);
        throw paramMenuItem;
        localObject2 = com.tencent.mm.game.report.c.jTf;
        paramInt = this.Dir;
        i = this.Dis;
        localObject2 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_sessionId;
        p.j(localObject2, "focused.field_sessionId");
        l1 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).eAr();
        localObject3 = com.tencent.mm.plugin.gamelife.i.a.DhX;
        com.tencent.mm.game.report.c.a.a(paramInt - 2 + 1, 1L, i, (String)localObject2, 0L, "", 0L, "", l1, com.tencent.mm.plugin.gamelife.i.a.eAv());
      }
      paramMenuItem = (AdapterView.AdapterContextMenuInfo)paramMenuItem;
      final boolean bool = ((com.tencent.mm.plugin.gamelife.a.c)h.ae(com.tencent.mm.plugin.gamelife.a.c.class)).aKG(((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_sessionId);
      if (bool)
      {
        if (!((com.tencent.mm.plugin.gamelife.e.a)localObject1).eAs())
        {
          g.ijP().i((com.tencent.mm.vending.c.a)new b((com.tencent.mm.plugin.gamelife.e.a)localObject1, bool, paramMenuItem)).ieF();
          AppMethodBeat.o(202730);
          return;
        }
        g.ijP().i((com.tencent.mm.vending.c.a)c.Diw).ieF();
        AppMethodBeat.o(202730);
        return;
      }
      Log.e("GameLife.ConversationOnLongClickListener", "longclick delete conversation fail");
    }
    label774:
    AppMethodBeat.o(202730);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(com.tencent.mm.plugin.gamelife.e.a parama, boolean paramBoolean, AdapterView.AdapterContextMenuInfo paramAdapterContextMenuInfo) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    public static final c Diw;
    
    static
    {
      AppMethodBeat.i(203565);
      Diw = new c();
      AppMethodBeat.o(203565);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.c
 * JD-Core Version:    0.7.0.1
 */