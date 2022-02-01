package com.tencent.mm.plugin.gamelife.ui;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cp.f;
import com.tencent.mm.cp.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.br;
import com.tencent.mm.model.br.a;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.b.a;
import com.tencent.mm.plugin.gamelife.d.f;
import com.tencent.mm.plugin.gamelife.f.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.TouchableLayout.a;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationLongClickListener;", "Lcom/tencent/mm/plugin/gamelife/ui/GameLifeConversationAdapter$OnItemLongClickListener;", "Landroid/view/View$OnCreateContextMenuListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "Landroid/widget/PopupWindow$OnDismissListener;", "callBack", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "focusedConversation", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversation;", "focusedPos", "", "totalDataNum", "onCreateContextMenu", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onDismiss", "onItemLongClick", "view", "position", "conv", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", "index", "Companion", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements View.OnCreateContextMenuListener, PopupWindow.OnDismissListener, b.d, u.i
{
  public static final c.a Jcg;
  private kotlin.g.a.a<ah> AFP;
  private com.tencent.mm.plugin.gamelife.f.a Jch;
  private int Jci;
  private int Jcj;
  
  static
  {
    AppMethodBeat.i(267918);
    Jcg = new c.a((byte)0);
    AppMethodBeat.o(267918);
  }
  
  public c(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(267891);
    this.AFP = parama;
    AppMethodBeat.o(267891);
  }
  
  private static final Void a(com.tencent.mm.plugin.gamelife.f.a parama, boolean paramBoolean, AdapterView.AdapterContextMenuInfo paramAdapterContextMenuInfo, Void paramVoid)
  {
    AppMethodBeat.i(267900);
    s.u(parama, "$focused");
    s.u(paramAdapterContextMenuInfo, "$menuInfo");
    br.a(parama.field_sessionId, (br.a)new c.b(paramBoolean, paramAdapterContextMenuInfo));
    AppMethodBeat.o(267900);
    return null;
  }
  
  private static final Void j(Void paramVoid)
  {
    AppMethodBeat.i(267909);
    ((com.tencent.mm.plugin.game.api.c)h.ax(com.tencent.mm.plugin.game.api.c.class)).fCe();
    AppMethodBeat.o(267909);
    return null;
  }
  
  public final void a(View paramView, int paramInt1, com.tencent.mm.plugin.gamelife.f.a parama, int paramInt2)
  {
    AppMethodBeat.i(267976);
    s.u(paramView, "view");
    s.u(parama, "conv");
    this.Jch = parama;
    this.Jci = paramInt1;
    this.Jcj = paramInt2;
    parama = new com.tencent.mm.ui.widget.b.a(paramView.getContext());
    parama.afLp = ((PopupWindow.OnDismissListener)this);
    View.OnCreateContextMenuListener localOnCreateContextMenuListener = (View.OnCreateContextMenuListener)this;
    u.i locali = (u.i)this;
    TouchableLayout.a locala = TouchableLayout.agKp;
    paramInt2 = TouchableLayout.jMn();
    locala = TouchableLayout.agKp;
    parama.a(paramView, paramInt1, 0L, localOnCreateContextMenuListener, locali, paramInt2, TouchableLayout.jMo());
    parama.cMz();
    AppMethodBeat.o(267976);
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(267948);
    s.u(paramContextMenu, "menu");
    s.u(paramView, "v");
    s.u(paramContextMenuInfo, "menuInfo");
    paramView = this.Jch;
    if (paramView == null)
    {
      paramView = null;
      if (paramView == null) {
        break label99;
      }
      paramView = this.Jch;
      if ((paramView == null) || (paramView.fIs() != true)) {
        break label93;
      }
    }
    label93:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label99;
      }
      paramContextMenu.add(0, 3, 0, d.f.gDv);
      AppMethodBeat.o(267948);
      return;
      paramView = Boolean.valueOf(paramView.fIs());
      break;
    }
    label99:
    paramView = this.Jch;
    if ((paramView != null) && (paramView.field_unReadCount == 0))
    {
      i = 1;
      if (i != 0) {
        break label161;
      }
      paramContextMenu.add(0, 0, 0, d.f.Jae);
    }
    for (;;)
    {
      paramContextMenu.add(0, 3, 0, d.f.gDv);
      AppMethodBeat.o(267948);
      return;
      i = 0;
      break;
      label161:
      paramContextMenu.add(0, 1, 0, d.f.Jaf);
    }
  }
  
  public final void onDismiss()
  {
    this.Jch = null;
  }
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(267969);
    s.u(paramMenuItem, "menuItem");
    paramInt = paramMenuItem.getItemId();
    Object localObject1 = this.Jch;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i("GameLife.ConversationOnLongClickListener", "menuItem.itemId:%d,sessionId:%s", new Object[] { Integer.valueOf(paramInt), localObject1 });
      localObject1 = this.Jch;
      if (localObject1 != null) {
        switch (paramMenuItem.getItemId())
        {
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(267969);
      return;
      localObject1 = ((com.tencent.mm.plugin.gamelife.f.a)localObject1).field_sessionId;
      break;
      paramMenuItem = ((PluginGameLife)h.az(PluginGameLife.class)).getConversationStorage();
      Object localObject2 = ((com.tencent.mm.plugin.gamelife.f.a)localObject1).field_sessionId;
      s.s(localObject2, "focused.field_sessionId");
      if (paramMenuItem.aAB((String)localObject2))
      {
        paramMenuItem = this.AFP;
        if (paramMenuItem != null)
        {
          paramMenuItem.invoke();
          AppMethodBeat.o(267969);
        }
      }
      else
      {
        Log.e("GameLife.ConversationOnLongClickListener", s.X("clearUnreadCount failed. sessionId=", ((com.tencent.mm.plugin.gamelife.f.a)localObject1).field_sessionId));
        AppMethodBeat.o(267969);
        return;
        paramMenuItem = ((PluginGameLife)h.az(PluginGameLife.class)).getConversationStorage();
        localObject2 = ((com.tencent.mm.plugin.gamelife.f.a)localObject1).field_sessionId;
        s.s(localObject2, "focused.field_sessionId");
        s.u(localObject2, "sessionId");
        Object localObject3 = com.tencent.mm.plugin.gamelife.b.IYX;
        if (!b.a.aHt((String)localObject2)) {
          bool = false;
        }
        for (;;)
        {
          if (!bool) {
            break label357;
          }
          paramMenuItem = this.AFP;
          if (paramMenuItem == null) {
            break;
          }
          paramMenuItem.invoke();
          AppMethodBeat.o(267969);
          return;
          localObject3 = paramMenuItem.aHD((String)localObject2);
          ((com.tencent.mm.plugin.gamelife.f.a)localObject3).field_unReadCount = 1;
          bool = paramMenuItem.update(((com.tencent.mm.plugin.gamelife.f.a)localObject3).systemRowid, (IAutoDBItem)localObject3, false);
          paramMenuItem.doNotify("single", 5, localObject3);
          Log.i("GameLife.ConversationStorage", "[addUnreadCount] ret=" + bool + " sessionId=" + (String)localObject2);
        }
        label357:
        Log.e("GameLife.ConversationOnLongClickListener", s.X("markUnread failed. sessionId=", ((com.tencent.mm.plugin.gamelife.f.a)localObject1).field_sessionId));
        AppMethodBeat.o(267969);
        return;
        Object localObject4;
        int i;
        long l1;
        if (!((com.tencent.mm.plugin.gamelife.f.a)localObject1).fIs())
        {
          localObject4 = ((com.tencent.mm.plugin.gamelife.a.b)h.ax(com.tencent.mm.plugin.gamelife.a.b.class)).aHu(((com.tencent.mm.plugin.gamelife.f.a)localObject1).field_selfUserName);
          if (localObject4 != null)
          {
            localObject2 = com.tencent.mm.game.report.c.mtx;
            paramInt = this.Jci;
            i = this.Jcj;
            localObject3 = ((com.tencent.mm.plugin.gamelife.f.a)localObject1).field_sessionId;
            s.s(localObject3, "focused.field_sessionId");
            l1 = ((com.tencent.mm.plugin.gamelife.a.a)localObject4).fIh();
            localObject4 = ((com.tencent.mm.plugin.gamelife.f.a)localObject1).field_selfUserName;
            s.s(localObject4, "focused.field_selfUserName");
            Object localObject5 = ((com.tencent.mm.plugin.gamelife.f.a)localObject1).Jbs;
            s.checkNotNull(localObject5);
            long l2 = ((com.tencent.mm.plugin.gamelife.e.a)localObject5).field_accountType;
            localObject5 = ((com.tencent.mm.plugin.gamelife.f.a)localObject1).field_talker;
            s.s(localObject5, "focused.field_talker");
            long l3 = ((com.tencent.mm.plugin.gamelife.f.a)localObject1).fIr();
            com.tencent.mm.plugin.gamelife.j.a locala = com.tencent.mm.plugin.gamelife.j.a.JbN;
            com.tencent.mm.game.report.c.a.a((com.tencent.mm.game.report.c.a)localObject2, paramInt - 2 + 1, 92L, i, (String)localObject3, l1, (String)localObject4, l2, (String)localObject5, l3, com.tencent.mm.plugin.gamelife.j.a.fIw());
          }
        }
        for (;;)
        {
          paramMenuItem = paramMenuItem.getMenuInfo();
          if (paramMenuItem != null) {
            break;
          }
          paramMenuItem = new NullPointerException("null cannot be cast to non-null type android.widget.AdapterView.AdapterContextMenuInfo");
          AppMethodBeat.o(267969);
          throw paramMenuItem;
          localObject2 = com.tencent.mm.game.report.c.mtx;
          paramInt = this.Jci;
          i = this.Jcj;
          localObject3 = ((com.tencent.mm.plugin.gamelife.f.a)localObject1).field_sessionId;
          s.s(localObject3, "focused.field_sessionId");
          l1 = ((com.tencent.mm.plugin.gamelife.f.a)localObject1).fIr();
          localObject4 = com.tencent.mm.plugin.gamelife.j.a.JbN;
          com.tencent.mm.game.report.c.a.a((com.tencent.mm.game.report.c.a)localObject2, paramInt - 2 + 1, 1L, i, (String)localObject3, 0L, "", 0L, "", l1, com.tencent.mm.plugin.gamelife.j.a.fIw());
        }
        paramMenuItem = (AdapterView.AdapterContextMenuInfo)paramMenuItem;
        boolean bool = ((com.tencent.mm.plugin.gamelife.a.c)h.ax(com.tencent.mm.plugin.gamelife.a.c.class)).aHw(((com.tencent.mm.plugin.gamelife.f.a)localObject1).field_sessionId);
        if (bool)
        {
          if (!((com.tencent.mm.plugin.gamelife.f.a)localObject1).fIs())
          {
            g.jPX().i(new c..ExternalSyntheticLambda0((com.tencent.mm.plugin.gamelife.f.a)localObject1, bool, paramMenuItem)).jJM();
            AppMethodBeat.o(267969);
            return;
          }
          g.jPX().i(c..ExternalSyntheticLambda1.INSTANCE).jJM();
          AppMethodBeat.o(267969);
          return;
        }
        Log.e("GameLife.ConversationOnLongClickListener", "longclick delete conversation fail");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.ui.c
 * JD-Core Version:    0.7.0.1
 */