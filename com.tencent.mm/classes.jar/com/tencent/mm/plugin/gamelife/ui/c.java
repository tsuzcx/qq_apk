package com.tencent.mm.plugin.gamelife.ui;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.model.bp.a;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.b.a;
import com.tencent.mm.plugin.gamelife.e.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.TouchableLayout.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationLongClickListener;", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;", "Landroid/view/View$OnCreateContextMenuListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "Landroid/widget/PopupWindow$OnDismissListener;", "callBack", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "focusedConversation", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "focusedPos", "", "totalDataNum", "onCreateContextMenu", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onDismiss", "onItemLongClick", "view", "position", "conv", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", "index", "Companion", "plugin-gamelife_release"})
public final class c
  implements View.OnCreateContextMenuListener, PopupWindow.OnDismissListener, b.d, o.g
{
  public static final c.a ycO;
  private kotlin.g.a.a<x> tyL;
  private com.tencent.mm.plugin.gamelife.e.a ycL;
  private int ycM;
  private int ycN;
  
  static
  {
    AppMethodBeat.i(241462);
    ycO = new c.a((byte)0);
    AppMethodBeat.o(241462);
  }
  
  public c(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(241461);
    this.tyL = parama;
    AppMethodBeat.o(241461);
  }
  
  public final void a(View paramView, int paramInt1, com.tencent.mm.plugin.gamelife.e.a parama, int paramInt2)
  {
    AppMethodBeat.i(241460);
    p.h(paramView, "view");
    p.h(parama, "conv");
    this.ycL = parama;
    this.ycM = paramInt1;
    this.ycN = paramInt2;
    parama = new com.tencent.mm.ui.widget.b.a(paramView.getContext());
    parama.setOnDismissListener((PopupWindow.OnDismissListener)this);
    View.OnCreateContextMenuListener localOnCreateContextMenuListener = (View.OnCreateContextMenuListener)this;
    o.g localg = (o.g)this;
    TouchableLayout.a locala = TouchableLayout.Rni;
    paramInt2 = TouchableLayout.hfC();
    locala = TouchableLayout.Rni;
    parama.a(paramView, paramInt1, 0L, localOnCreateContextMenuListener, localg, paramInt2, TouchableLayout.hfD());
    parama.gTx();
    AppMethodBeat.o(241460);
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(241458);
    p.h(paramContextMenu, "menu");
    p.h(paramView, "v");
    p.h(paramContextMenuInfo, "menuInfo");
    paramView = this.ycL;
    if (paramView != null) {}
    for (paramView = Boolean.valueOf(paramView.dXj()); paramView != null; paramView = null)
    {
      paramView = this.ycL;
      if ((paramView == null) || (paramView.dXj() != true)) {
        break;
      }
      paramContextMenu.add(0, 3, 0, 2131758189);
      AppMethodBeat.o(241458);
      return;
    }
    paramView = this.ycL;
    if ((paramView == null) || (paramView.field_unReadCount != 0)) {
      paramContextMenu.add(0, 0, 0, 2131758190);
    }
    for (;;)
    {
      paramContextMenu.add(0, 3, 0, 2131758189);
      AppMethodBeat.o(241458);
      return;
      paramContextMenu.add(0, 1, 0, 2131758191);
    }
  }
  
  public final void onDismiss()
  {
    this.ycL = null;
  }
  
  public final void onMMMenuItemSelected(final MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(241459);
    p.h(paramMenuItem, "menuItem");
    paramInt = paramMenuItem.getItemId();
    Object localObject1 = this.ycL;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_sessionId;
      Log.i("GameLife.ConversationOnLongClickListener", "menuItem.itemId:%d,sessionId:%s", new Object[] { Integer.valueOf(paramInt), localObject1 });
      localObject1 = this.ycL;
      if (localObject1 == null) {
        break label773;
      }
      switch (paramMenuItem.getItemId())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(241459);
      return;
      localObject1 = null;
      break;
      paramMenuItem = ((PluginGameLife)com.tencent.mm.kernel.g.ah(PluginGameLife.class)).getConversationStorage();
      Object localObject2 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_sessionId;
      p.g(localObject2, "focused.field_sessionId");
      if (paramMenuItem.avs((String)localObject2))
      {
        paramMenuItem = this.tyL;
        if (paramMenuItem != null)
        {
          paramMenuItem.invoke();
          AppMethodBeat.o(241459);
          return;
        }
        AppMethodBeat.o(241459);
        return;
      }
      Log.e("GameLife.ConversationOnLongClickListener", "clearUnreadCount failed. sessionId=" + ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_sessionId);
      AppMethodBeat.o(241459);
      return;
      paramMenuItem = ((PluginGameLife)com.tencent.mm.kernel.g.ah(PluginGameLife.class)).getConversationStorage();
      localObject2 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_sessionId;
      p.g(localObject2, "focused.field_sessionId");
      p.h(localObject2, "sessionId");
      Object localObject3 = com.tencent.mm.plugin.gamelife.b.xZZ;
      if (!b.a.aAQ((String)localObject2)) {
        bool = false;
      }
      while (bool)
      {
        paramMenuItem = this.tyL;
        if (paramMenuItem != null)
        {
          paramMenuItem.invoke();
          AppMethodBeat.o(241459);
          return;
          localObject3 = paramMenuItem.aBa((String)localObject2);
          ((com.tencent.mm.plugin.gamelife.e.a)localObject3).field_unReadCount = 1;
          bool = paramMenuItem.update(((com.tencent.mm.plugin.gamelife.e.a)localObject3).systemRowid, (IAutoDBItem)localObject3, false);
          paramMenuItem.doNotify("single", 5, localObject3);
          Log.i("GameLife.ConversationStorage", "[addUnreadCount] ret=" + bool + " sessionId=" + (String)localObject2);
        }
        else
        {
          AppMethodBeat.o(241459);
          return;
        }
      }
      Log.e("GameLife.ConversationOnLongClickListener", "markUnread failed. sessionId=" + ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_sessionId);
      AppMethodBeat.o(241459);
      return;
      int i;
      long l1;
      if (!((com.tencent.mm.plugin.gamelife.e.a)localObject1).dXj())
      {
        localObject3 = ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.b.class)).aAR(((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_selfUserName);
        if (localObject3 != null)
        {
          localObject2 = com.tencent.mm.game.report.c.hhl;
          paramInt = this.ycM;
          i = this.ycN;
          localObject2 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_sessionId;
          p.g(localObject2, "focused.field_sessionId");
          l1 = ((com.tencent.mm.plugin.gamelife.a.a)localObject3).dWY();
          localObject3 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_selfUserName;
          p.g(localObject3, "focused.field_selfUserName");
          Object localObject4 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).ybV;
          if (localObject4 == null) {
            p.hyc();
          }
          long l2 = ((com.tencent.mm.plugin.gamelife.d.a)localObject4).field_accountType;
          localObject4 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_talker;
          p.g(localObject4, "focused.field_talker");
          long l3 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).dXi();
          com.tencent.mm.plugin.gamelife.i.a locala = com.tencent.mm.plugin.gamelife.i.a.ycs;
          com.tencent.mm.game.report.c.a.a(paramInt - 2 + 1, 92L, i, (String)localObject2, l1, (String)localObject3, l2, (String)localObject4, l3, com.tencent.mm.plugin.gamelife.i.a.dXm());
        }
      }
      for (;;)
      {
        paramMenuItem = paramMenuItem.getMenuInfo();
        if (paramMenuItem != null) {
          break;
        }
        paramMenuItem = new t("null cannot be cast to non-null type android.widget.AdapterView.AdapterContextMenuInfo");
        AppMethodBeat.o(241459);
        throw paramMenuItem;
        localObject2 = com.tencent.mm.game.report.c.hhl;
        paramInt = this.ycM;
        i = this.ycN;
        localObject2 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_sessionId;
        p.g(localObject2, "focused.field_sessionId");
        l1 = ((com.tencent.mm.plugin.gamelife.e.a)localObject1).dXi();
        localObject3 = com.tencent.mm.plugin.gamelife.i.a.ycs;
        com.tencent.mm.game.report.c.a.a(paramInt - 2 + 1, 1L, i, (String)localObject2, 0L, "", 0L, "", l1, com.tencent.mm.plugin.gamelife.i.a.dXm());
      }
      paramMenuItem = (AdapterView.AdapterContextMenuInfo)paramMenuItem;
      final boolean bool = ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.c.class)).aAT(((com.tencent.mm.plugin.gamelife.e.a)localObject1).field_sessionId);
      if (bool)
      {
        if (!((com.tencent.mm.plugin.gamelife.e.a)localObject1).dXj())
        {
          com.tencent.mm.co.g.hio().i((com.tencent.mm.vending.c.a)new b((com.tencent.mm.plugin.gamelife.e.a)localObject1, bool, paramMenuItem)).hdy();
          AppMethodBeat.o(241459);
          return;
        }
        com.tencent.mm.co.g.hio().i((com.tencent.mm.vending.c.a)c.ycS).hdy();
        AppMethodBeat.o(241459);
        return;
      }
      Log.e("GameLife.ConversationOnLongClickListener", "longclick delete conversation fail");
    }
    label773:
    AppMethodBeat.o(241459);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(com.tencent.mm.plugin.gamelife.e.a parama, boolean paramBoolean, AdapterView.AdapterContextMenuInfo paramAdapterContextMenuInfo) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    public static final c ycS;
    
    static
    {
      AppMethodBeat.i(241457);
      ycS = new c();
      AppMethodBeat.o(241457);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.c
 * JD-Core Version:    0.7.0.1
 */