package com.tencent.mm.plugin.gamelife.ui;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.model.bj.a;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.b.a;
import com.tencent.mm.plugin.gamelife.e.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.TouchableLayout.a;
import d.g.b.p;
import d.l;
import d.v;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationLongClickListener;", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;", "Landroid/view/View$OnCreateContextMenuListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "Landroid/widget/PopupWindow$OnDismissListener;", "callBack", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "focusedConversation", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "focusedPos", "", "totalDataNum", "onCreateContextMenu", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onDismiss", "onItemLongClick", "view", "position", "conv", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", "index", "Companion", "plugin-gamelife_release"})
public final class c
  implements View.OnCreateContextMenuListener, PopupWindow.OnDismissListener, b.d, n.e
{
  public static final a uyQ;
  private d.g.a.a<z> rLD;
  private com.tencent.mm.plugin.gamelife.e.a uyN;
  private int uyO;
  private int uyP;
  
  static
  {
    AppMethodBeat.i(211440);
    uyQ = new a((byte)0);
    AppMethodBeat.o(211440);
  }
  
  public c(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(211439);
    this.rLD = parama;
    AppMethodBeat.o(211439);
  }
  
  public final void a(View paramView, int paramInt1, com.tencent.mm.plugin.gamelife.e.a parama, int paramInt2)
  {
    AppMethodBeat.i(211438);
    p.h(paramView, "view");
    p.h(parama, "conv");
    this.uyN = parama;
    this.uyO = paramInt1;
    this.uyP = paramInt2;
    parama = new com.tencent.mm.ui.widget.b.a(paramView.getContext());
    parama.setOnDismissListener((PopupWindow.OnDismissListener)this);
    View.OnCreateContextMenuListener localOnCreateContextMenuListener = (View.OnCreateContextMenuListener)this;
    n.e locale = (n.e)this;
    TouchableLayout.a locala = TouchableLayout.LrZ;
    paramInt2 = TouchableLayout.fQh();
    locala = TouchableLayout.LrZ;
    parama.a(paramView, paramInt1, 0L, localOnCreateContextMenuListener, locale, paramInt2, TouchableLayout.fQi());
    parama.fGP();
    AppMethodBeat.o(211438);
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(211436);
    p.h(paramContextMenu, "menu");
    p.h(paramView, "v");
    p.h(paramContextMenuInfo, "menuInfo");
    paramView = this.uyN;
    if (paramView != null) {}
    for (paramView = Boolean.valueOf(paramView.daI()); paramView != null; paramView = null)
    {
      paramView = this.uyN;
      if ((paramView == null) || (paramView.daI() != true)) {
        break;
      }
      paramContextMenu.add(0, 3, 0, 2131766499);
      AppMethodBeat.o(211436);
      return;
    }
    paramView = this.uyN;
    if ((paramView == null) || (paramView.field_unReadCount != 0)) {
      paramContextMenu.add(0, 0, 0, 2131766512);
    }
    for (;;)
    {
      paramContextMenu.add(0, 3, 0, 2131766499);
      AppMethodBeat.o(211436);
      return;
      paramContextMenu.add(0, 1, 0, 2131766925);
    }
  }
  
  public final void onDismiss()
  {
    this.uyN = null;
  }
  
  public final void onMMMenuItemSelected(final MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(211437);
    p.h(paramMenuItem, "menuItem");
    paramInt = paramMenuItem.getItemId();
    Object localObject1 = this.uyN;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_sessionId;
      ad.i("GameLife.ConversationOnLongClickListener", "menuItem.itemId:%d,sessionId:%s", new Object[] { Integer.valueOf(paramInt), localObject1 });
      localObject1 = this.uyN;
      if (localObject1 == null) {
        break label773;
      }
      switch (paramMenuItem.getItemId())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(211437);
      return;
      localObject1 = null;
      break;
      paramMenuItem = ((PluginGameLife)com.tencent.mm.kernel.g.ad(PluginGameLife.class)).getConversationStorage();
      Object localObject2 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_sessionId;
      p.g(localObject2, "focused.field_sessionId");
      if (paramMenuItem.ais((String)localObject2))
      {
        paramMenuItem = this.rLD;
        if (paramMenuItem != null)
        {
          paramMenuItem.invoke();
          AppMethodBeat.o(211437);
          return;
        }
        AppMethodBeat.o(211437);
        return;
      }
      ad.e("GameLife.ConversationOnLongClickListener", "clearUnreadCount failed. sessionId=" + ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_sessionId);
      AppMethodBeat.o(211437);
      return;
      paramMenuItem = ((PluginGameLife)com.tencent.mm.kernel.g.ad(PluginGameLife.class)).getConversationStorage();
      localObject2 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_sessionId;
      p.g(localObject2, "focused.field_sessionId");
      p.h(localObject2, "sessionId");
      Object localObject3 = com.tencent.mm.plugin.gamelife.b.uwo;
      if (!b.a.amz((String)localObject2)) {
        bool = false;
      }
      while (bool)
      {
        paramMenuItem = this.rLD;
        if (paramMenuItem != null)
        {
          paramMenuItem.invoke();
          AppMethodBeat.o(211437);
          return;
          localObject3 = paramMenuItem.amG((String)localObject2);
          ((com.tencent.mm.plugin.gamelife.e.a)localObject3).field_unReadCount = 1;
          bool = paramMenuItem.update(((com.tencent.mm.plugin.gamelife.e.a)localObject3).systemRowid, (com.tencent.mm.sdk.e.c)localObject3, false);
          paramMenuItem.doNotify("single", 5, localObject3);
          ad.i("GameLife.ConversationStorage", "[addUnreadCount] ret=" + bool + " sessionId=" + (String)localObject2);
        }
        else
        {
          AppMethodBeat.o(211437);
          return;
        }
      }
      ad.e("GameLife.ConversationOnLongClickListener", "markUnread failed. sessionId=" + ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_sessionId);
      AppMethodBeat.o(211437);
      return;
      int i;
      long l1;
      if (!((com.tencent.mm.plugin.gamelife.e.a)localObject1).daI())
      {
        localObject3 = ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).amA(((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_selfUserName);
        if (localObject3 != null)
        {
          localObject2 = com.tencent.mm.game.report.c.grV;
          paramInt = this.uyO;
          i = this.uyP;
          localObject2 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_sessionId;
          p.g(localObject2, "focused.field_sessionId");
          l1 = ((com.tencent.mm.plugin.gamelife.a.a)localObject3).daC();
          localObject3 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_selfUserName;
          p.g(localObject3, "focused.field_selfUserName");
          Object localObject4 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).uyb;
          if (localObject4 == null) {
            p.gfZ();
          }
          long l2 = ((com.tencent.mm.plugin.gamelife.d.a)localObject4).field_accountType;
          localObject4 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_talker;
          p.g(localObject4, "focused.field_talker");
          long l3 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).daH();
          com.tencent.mm.plugin.gamelife.h.a locala = com.tencent.mm.plugin.gamelife.h.a.uyu;
          com.tencent.mm.game.report.c.a.a(paramInt - 2 + 1, 92L, i, (String)localObject2, l1, (String)localObject3, l2, (String)localObject4, l3, com.tencent.mm.plugin.gamelife.h.a.daL());
        }
      }
      for (;;)
      {
        paramMenuItem = paramMenuItem.getMenuInfo();
        if (paramMenuItem != null) {
          break;
        }
        paramMenuItem = new v("null cannot be cast to non-null type android.widget.AdapterView.AdapterContextMenuInfo");
        AppMethodBeat.o(211437);
        throw paramMenuItem;
        localObject2 = com.tencent.mm.game.report.c.grV;
        paramInt = this.uyO;
        i = this.uyP;
        localObject2 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_sessionId;
        p.g(localObject2, "focused.field_sessionId");
        l1 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).daH();
        localObject3 = com.tencent.mm.plugin.gamelife.h.a.uyu;
        com.tencent.mm.game.report.c.a.a(paramInt - 2 + 1, 1L, i, (String)localObject2, 0L, "", 0L, "", l1, com.tencent.mm.plugin.gamelife.h.a.daL());
      }
      paramMenuItem = (AdapterView.AdapterContextMenuInfo)paramMenuItem;
      final boolean bool = ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.c.class)).amB(((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_sessionId);
      if (bool)
      {
        if (!((com.tencent.mm.plugin.gamelife.e.a)localObject1).daI())
        {
          com.tencent.mm.cn.g.fSm().i((com.tencent.mm.vending.c.a)new b((com.tencent.mm.plugin.gamelife.e.a)localObject1, bool, paramMenuItem)).fOb();
          AppMethodBeat.o(211437);
          return;
        }
        com.tencent.mm.cn.g.fSm().i((com.tencent.mm.vending.c.a)c.uyU).fOb();
        AppMethodBeat.o(211437);
        return;
      }
      ad.e("GameLife.ConversationOnLongClickListener", "longclick delete conversation fail");
    }
    label773:
    AppMethodBeat.o(211437);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationLongClickListener$Companion;", "", "()V", "CONTEXT_MENU_LONG_CLICK_DELETE", "", "CONTEXT_MENU_LONG_CLICK_MARK_READ", "CONTEXT_MENU_LONG_CLICK_MARK_UNREAD", "CONTEXT_MENU_LONG_CLICK_PLACED_TOP", "CONTEXT_MENU_LONG_CLICK_UN_PLACED_TOP", "TAG", "", "plugin-gamelife_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(com.tencent.mm.plugin.gamelife.e.a parama, boolean paramBoolean, AdapterView.AdapterContextMenuInfo paramAdapterContextMenuInfo) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    public static final c uyU;
    
    static
    {
      AppMethodBeat.i(211435);
      uyU = new c();
      AppMethodBeat.o(211435);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.c
 * JD-Core Version:    0.7.0.1
 */