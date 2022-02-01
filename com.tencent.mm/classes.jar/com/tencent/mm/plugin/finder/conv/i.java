package com.tencent.mm.plugin.finder.conv;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.report.al;
import com.tencent.mm.plugin.finder.storage.af;
import com.tencent.mm.plugin.finder.storage.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.TouchableLayout.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationLongClickListener;", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter$OnItemLongClickListener;", "Landroid/view/View$OnCreateContextMenuListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "Landroid/widget/PopupWindow$OnDismissListener;", "callBack", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "focusedConversation", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "onCreateContextMenu", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onDismiss", "onItemLongClick", "view", "position", "", "conv", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", "index", "Companion", "plugin-finder_release"})
public final class i
  implements View.OnCreateContextMenuListener, PopupWindow.OnDismissListener, e.b, q.g
{
  public static final a xgy;
  private d xgw;
  private kotlin.g.a.a<x> xgx;
  
  static
  {
    AppMethodBeat.i(267364);
    xgy = new a((byte)0);
    AppMethodBeat.o(267364);
  }
  
  public i(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(267363);
    this.xgx = parama;
    AppMethodBeat.o(267363);
  }
  
  public final void a(View paramView, int paramInt, d paramd)
  {
    AppMethodBeat.i(267362);
    p.k(paramView, "view");
    p.k(paramd, "conv");
    this.xgw = paramd;
    paramd = new com.tencent.mm.ui.widget.b.a(paramView.getContext());
    paramd.setOnDismissListener((PopupWindow.OnDismissListener)this);
    View.OnCreateContextMenuListener localOnCreateContextMenuListener = (View.OnCreateContextMenuListener)this;
    q.g localg = (q.g)this;
    TouchableLayout.a locala = TouchableLayout.YOD;
    int i = TouchableLayout.igZ();
    locala = TouchableLayout.YOD;
    paramd.a(paramView, paramInt, 0L, localOnCreateContextMenuListener, localg, i, TouchableLayout.iha());
    paramd.hTd();
    AppMethodBeat.o(267362);
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    Object localObject = null;
    AppMethodBeat.i(267360);
    p.k(paramContextMenu, "menu");
    p.k(paramView, "v");
    p.k(paramContextMenuInfo, "menuInfo");
    paramView = this.xgw;
    if (paramView != null)
    {
      paramView = paramView.field_sessionId;
      if ((p.h(paramView, "findersayhisessionholder") ^ true))
      {
        paramView = this.xgw;
        if (paramView == null) {
          break label194;
        }
        paramView = paramView.field_sessionId;
        label65:
        if ((p.h(paramView, "finder_system_message") ^ true))
        {
          paramView = this.xgw;
          if (paramView == null) {
            break label199;
          }
        }
      }
    }
    label194:
    label199:
    for (paramView = paramView.field_sessionId;; paramView = null)
    {
      if ((p.h(paramView, "finderaliassessionholder") ^ true)) {
        paramContextMenu.add(0, 2, 0, b.j.main_delete);
      }
      paramView = this.xgw;
      if (paramView != null)
      {
        paramContextMenuInfo = paramView.field_senderUserName;
        paramView = paramContextMenuInfo;
        if (paramContextMenuInfo != null) {}
      }
      else
      {
        paramView = "";
      }
      if (!as.bvO(paramView))
      {
        paramContextMenuInfo = this.xgw;
        paramView = localObject;
        if (paramContextMenuInfo != null) {
          paramView = paramContextMenuInfo.field_sessionId;
        }
        if (!p.h(paramView, "finderaliassessionholder")) {}
      }
      else
      {
        paramContextMenu.add(0, 4, 0, b.j.dimiss_conversation);
      }
      AppMethodBeat.o(267360);
      return;
      paramView = null;
      break;
      paramView = null;
      break label65;
    }
  }
  
  public final void onDismiss()
  {
    this.xgw = null;
  }
  
  public final void onMMMenuItemSelected(final MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(267361);
    p.k(paramMenuItem, "menuItem");
    d locald = this.xgw;
    if (locald != null)
    {
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(267361);
        return;
        paramMenuItem = ((PluginFinder)h.ag(PluginFinder.class)).getConversationStorage();
        Object localObject = locald.field_sessionId;
        p.j(localObject, "focused.field_sessionId");
        if (paramMenuItem.by((String)localObject, true))
        {
          paramMenuItem = this.xgx;
          if (paramMenuItem != null)
          {
            paramMenuItem.invoke();
            AppMethodBeat.o(267361);
            return;
          }
          AppMethodBeat.o(267361);
          return;
        }
        Log.e("Finder.ConversationOnLongClickListener", "setTopPlace failed. sessionId=" + locald.field_sessionId);
        AppMethodBeat.o(267361);
        return;
        paramMenuItem = ((PluginFinder)h.ag(PluginFinder.class)).getConversationStorage();
        localObject = locald.field_sessionId;
        p.j(localObject, "focused.field_sessionId");
        if (paramMenuItem.by((String)localObject, false))
        {
          paramMenuItem = this.xgx;
          if (paramMenuItem != null)
          {
            paramMenuItem.invoke();
            AppMethodBeat.o(267361);
            return;
          }
          AppMethodBeat.o(267361);
          return;
        }
        Log.e("Finder.ConversationOnLongClickListener", "setUnTopPlace failed. sessionId=" + locald.field_sessionId);
        AppMethodBeat.o(267361);
        return;
        paramMenuItem = ((PluginFinder)h.ag(PluginFinder.class)).getConversationStorage();
        localObject = locald.field_sessionId;
        p.j(localObject, "focused.field_sessionId");
        if (paramMenuItem.aEI((String)localObject))
        {
          paramMenuItem = this.xgx;
          if (paramMenuItem != null)
          {
            paramMenuItem.invoke();
            AppMethodBeat.o(267361);
            return;
          }
          AppMethodBeat.o(267361);
          return;
        }
        Log.e("Finder.ConversationOnLongClickListener", "clearUnreadCount failed. sessionId=" + locald.field_sessionId);
        AppMethodBeat.o(267361);
        return;
        paramMenuItem = paramMenuItem.getMenuInfo();
        if (paramMenuItem == null)
        {
          paramMenuItem = new t("null cannot be cast to non-null type android.widget.AdapterView.AdapterContextMenuInfo");
          AppMethodBeat.o(267361);
          throw paramMenuItem;
        }
        paramMenuItem = (AdapterView.AdapterContextMenuInfo)paramMenuItem;
        boolean bool = ((PluginFinder)h.ag(PluginFinder.class)).getConversationStorage().deleteNotify(locald.systemRowid, false);
        if (bool)
        {
          localObject = ((PluginFinder)h.ag(PluginFinder.class)).getSessionInfoStorage();
          String str = locald.field_sessionId;
          p.j(str, "focused.field_sessionId");
          ((af)localObject).aEQ(str);
          ((PluginFinder)h.ag(PluginFinder.class)).getConversationStorage().doNotify(locald.field_sessionId, 6, locald);
          localObject = this.xgx;
          if (localObject != null) {
            ((kotlin.g.a.a)localObject).invoke();
          }
        }
        bq.a(locald.field_sessionId, (bq.a)new b(bool, paramMenuItem));
        AppMethodBeat.o(267361);
        return;
        ((PluginFinder)h.ag(PluginFinder.class)).getConversationStorage().deleteNotify(locald.systemRowid, false);
        ((PluginFinder)h.ag(PluginFinder.class)).getConversationStorage().doNotify(locald.field_sessionId, 6, locald);
      }
    }
    AppMethodBeat.o(267361);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationLongClickListener$Companion;", "", "()V", "CONTEXT_MENU_LONG_CLICK_DELETE", "", "CONTEXT_MENU_LONG_CLICK_DISMISS", "CONTEXT_MENU_LONG_CLICK_MARK_READ", "CONTEXT_MENU_LONG_CLICK_PLACED_TOP", "CONTEXT_MENU_LONG_CLICK_UN_PLACED_TOP", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/conv/FinderConversationLongClickListener$onMMMenuItemSelected$1$1", "Lcom/tencent/mm/model/MsgInfoStorageLogic$IDeleteMsg;", "finishCallback", "", "isCancel", "", "plugin-finder_release"})
  public static final class b
    implements bq.a
  {
    b(boolean paramBoolean, AdapterView.AdapterContextMenuInfo paramAdapterContextMenuInfo) {}
    
    public final boolean asH()
    {
      return false;
    }
    
    public final void asI()
    {
      AppMethodBeat.i(271302);
      Log.i("Finder.ConversationOnLongClickListener", "longclick delete msg finish");
      Log.i("Finder.ConversationOnLongClickListener", "[CONTEXT_MENU_LONG_CLICK_DELETE] ret" + this.xgz + " position=" + paramMenuItem.position);
      Object localObject = com.tencent.mm.plugin.finder.report.d.zUg;
      localObject = com.tencent.mm.plugin.finder.report.d.dPc();
      ((al)localObject).zZL += 1L;
      AppMethodBeat.o(271302);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.i
 * JD-Core Version:    0.7.0.1
 */