package com.tencent.mm.plugin.gamelife.ui;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.model.bl.a;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.b.a;
import com.tencent.mm.plugin.gamelife.e.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.TouchableLayout.a;
import d.g.b.p;
import d.l;
import d.v;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationLongClickListener;", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;", "Landroid/view/View$OnCreateContextMenuListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "Landroid/widget/PopupWindow$OnDismissListener;", "callBack", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "focusedConversation", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "focusedPos", "", "totalDataNum", "onCreateContextMenu", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onDismiss", "onItemLongClick", "view", "position", "conv", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", "index", "Companion", "plugin-gamelife_release"})
public final class c
  implements View.OnCreateContextMenuListener, PopupWindow.OnDismissListener, b.d, n.e
{
  public static final c.a uKt;
  private d.g.a.a<z> rTQ;
  private com.tencent.mm.plugin.gamelife.e.a uKq;
  private int uKr;
  private int uKs;
  
  static
  {
    AppMethodBeat.i(212219);
    uKt = new c.a((byte)0);
    AppMethodBeat.o(212219);
  }
  
  public c(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(212218);
    this.rTQ = parama;
    AppMethodBeat.o(212218);
  }
  
  public final void a(View paramView, int paramInt1, com.tencent.mm.plugin.gamelife.e.a parama, int paramInt2)
  {
    AppMethodBeat.i(212217);
    p.h(paramView, "view");
    p.h(parama, "conv");
    this.uKq = parama;
    this.uKr = paramInt1;
    this.uKs = paramInt2;
    parama = new com.tencent.mm.ui.widget.b.a(paramView.getContext());
    parama.setOnDismissListener((PopupWindow.OnDismissListener)this);
    View.OnCreateContextMenuListener localOnCreateContextMenuListener = (View.OnCreateContextMenuListener)this;
    n.e locale = (n.e)this;
    TouchableLayout.a locala = TouchableLayout.LOL;
    paramInt2 = TouchableLayout.fUD();
    locala = TouchableLayout.LOL;
    parama.a(paramView, paramInt1, 0L, localOnCreateContextMenuListener, locale, paramInt2, TouchableLayout.fUE());
    parama.fLf();
    AppMethodBeat.o(212217);
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(212215);
    p.h(paramContextMenu, "menu");
    p.h(paramView, "v");
    p.h(paramContextMenuInfo, "menuInfo");
    paramView = this.uKq;
    if (paramView != null) {}
    for (paramView = Boolean.valueOf(paramView.ddy()); paramView != null; paramView = null)
    {
      paramView = this.uKq;
      if ((paramView == null) || (paramView.ddy() != true)) {
        break;
      }
      paramContextMenu.add(0, 3, 0, 2131766499);
      AppMethodBeat.o(212215);
      return;
    }
    paramView = this.uKq;
    if ((paramView == null) || (paramView.field_unReadCount != 0)) {
      paramContextMenu.add(0, 0, 0, 2131766512);
    }
    for (;;)
    {
      paramContextMenu.add(0, 3, 0, 2131766499);
      AppMethodBeat.o(212215);
      return;
      paramContextMenu.add(0, 1, 0, 2131766925);
    }
  }
  
  public final void onDismiss()
  {
    this.uKq = null;
  }
  
  public final void onMMMenuItemSelected(final MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(212216);
    p.h(paramMenuItem, "menuItem");
    paramInt = paramMenuItem.getItemId();
    Object localObject1 = this.uKq;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_sessionId;
      ae.i("GameLife.ConversationOnLongClickListener", "menuItem.itemId:%d,sessionId:%s", new Object[] { Integer.valueOf(paramInt), localObject1 });
      localObject1 = this.uKq;
      if (localObject1 == null) {
        break label773;
      }
      switch (paramMenuItem.getItemId())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(212216);
      return;
      localObject1 = null;
      break;
      paramMenuItem = ((PluginGameLife)com.tencent.mm.kernel.g.ad(PluginGameLife.class)).getConversationStorage();
      Object localObject2 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_sessionId;
      p.g(localObject2, "focused.field_sessionId");
      if (paramMenuItem.ajp((String)localObject2))
      {
        paramMenuItem = this.rTQ;
        if (paramMenuItem != null)
        {
          paramMenuItem.invoke();
          AppMethodBeat.o(212216);
          return;
        }
        AppMethodBeat.o(212216);
        return;
      }
      ae.e("GameLife.ConversationOnLongClickListener", "clearUnreadCount failed. sessionId=" + ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_sessionId);
      AppMethodBeat.o(212216);
      return;
      paramMenuItem = ((PluginGameLife)com.tencent.mm.kernel.g.ad(PluginGameLife.class)).getConversationStorage();
      localObject2 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_sessionId;
      p.g(localObject2, "focused.field_sessionId");
      p.h(localObject2, "sessionId");
      Object localObject3 = com.tencent.mm.plugin.gamelife.b.uHN;
      if (!b.a.anx((String)localObject2)) {
        bool = false;
      }
      while (bool)
      {
        paramMenuItem = this.rTQ;
        if (paramMenuItem != null)
        {
          paramMenuItem.invoke();
          AppMethodBeat.o(212216);
          return;
          localObject3 = paramMenuItem.anH((String)localObject2);
          ((com.tencent.mm.plugin.gamelife.e.a)localObject3).field_unReadCount = 1;
          bool = paramMenuItem.update(((com.tencent.mm.plugin.gamelife.e.a)localObject3).systemRowid, (com.tencent.mm.sdk.e.c)localObject3, false);
          paramMenuItem.doNotify("single", 5, localObject3);
          ae.i("GameLife.ConversationStorage", "[addUnreadCount] ret=" + bool + " sessionId=" + (String)localObject2);
        }
        else
        {
          AppMethodBeat.o(212216);
          return;
        }
      }
      ae.e("GameLife.ConversationOnLongClickListener", "markUnread failed. sessionId=" + ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_sessionId);
      AppMethodBeat.o(212216);
      return;
      int i;
      long l1;
      if (!((com.tencent.mm.plugin.gamelife.e.a)localObject1).ddy())
      {
        localObject3 = ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).any(((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_selfUserName);
        if (localObject3 != null)
        {
          localObject2 = com.tencent.mm.game.report.c.guw;
          paramInt = this.uKr;
          i = this.uKs;
          localObject2 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_sessionId;
          p.g(localObject2, "focused.field_sessionId");
          l1 = ((com.tencent.mm.plugin.gamelife.a.a)localObject3).ddo();
          localObject3 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_selfUserName;
          p.g(localObject3, "focused.field_selfUserName");
          Object localObject4 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).uJE;
          if (localObject4 == null) {
            p.gkB();
          }
          long l2 = ((com.tencent.mm.plugin.gamelife.d.a)localObject4).field_accountType;
          localObject4 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_talker;
          p.g(localObject4, "focused.field_talker");
          long l3 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).ddx();
          com.tencent.mm.plugin.gamelife.i.a locala = com.tencent.mm.plugin.gamelife.i.a.uJX;
          com.tencent.mm.game.report.c.a.a(paramInt - 2 + 1, 92L, i, (String)localObject2, l1, (String)localObject3, l2, (String)localObject4, l3, com.tencent.mm.plugin.gamelife.i.a.ddC());
        }
      }
      for (;;)
      {
        paramMenuItem = paramMenuItem.getMenuInfo();
        if (paramMenuItem != null) {
          break;
        }
        paramMenuItem = new v("null cannot be cast to non-null type android.widget.AdapterView.AdapterContextMenuInfo");
        AppMethodBeat.o(212216);
        throw paramMenuItem;
        localObject2 = com.tencent.mm.game.report.c.guw;
        paramInt = this.uKr;
        i = this.uKs;
        localObject2 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_sessionId;
        p.g(localObject2, "focused.field_sessionId");
        l1 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).ddx();
        localObject3 = com.tencent.mm.plugin.gamelife.i.a.uJX;
        com.tencent.mm.game.report.c.a.a(paramInt - 2 + 1, 1L, i, (String)localObject2, 0L, "", 0L, "", l1, com.tencent.mm.plugin.gamelife.i.a.ddC());
      }
      paramMenuItem = (AdapterView.AdapterContextMenuInfo)paramMenuItem;
      final boolean bool = ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.c.class)).anA(((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_sessionId);
      if (bool)
      {
        if (!((com.tencent.mm.plugin.gamelife.e.a)localObject1).ddy())
        {
          com.tencent.mm.cm.g.fWL().i((com.tencent.mm.vending.c.a)new b((com.tencent.mm.plugin.gamelife.e.a)localObject1, bool, paramMenuItem)).fSw();
          AppMethodBeat.o(212216);
          return;
        }
        com.tencent.mm.cm.g.fWL().i((com.tencent.mm.vending.c.a)c.uKx).fSw();
        AppMethodBeat.o(212216);
        return;
      }
      ae.e("GameLife.ConversationOnLongClickListener", "longclick delete conversation fail");
    }
    label773:
    AppMethodBeat.o(212216);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(com.tencent.mm.plugin.gamelife.e.a parama, boolean paramBoolean, AdapterView.AdapterContextMenuInfo paramAdapterContextMenuInfo) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    public static final c uKx;
    
    static
    {
      AppMethodBeat.i(212214);
      uKx = new c();
      AppMethodBeat.o(212214);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.c
 * JD-Core Version:    0.7.0.1
 */