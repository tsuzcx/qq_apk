package com.tencent.mm.plugin.finder.conv;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.bp.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.ai;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.plugin.finder.storage.ag;
import com.tencent.mm.plugin.finder.storage.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.TouchableLayout.a;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationLongClickListener;", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter$OnItemLongClickListener;", "Landroid/view/View$OnCreateContextMenuListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "Landroid/widget/PopupWindow$OnDismissListener;", "callBack", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "focusedConversation", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "onCreateContextMenu", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onDismiss", "onItemLongClick", "view", "position", "", "conv", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", "index", "Companion", "plugin-finder_release"})
public final class h
  implements View.OnCreateContextMenuListener, PopupWindow.OnDismissListener, d.b, o.g
{
  public static final a tyM;
  private c tyK;
  private kotlin.g.a.a<x> tyL;
  
  static
  {
    AppMethodBeat.i(242747);
    tyM = new a((byte)0);
    AppMethodBeat.o(242747);
  }
  
  public h(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(242746);
    this.tyL = parama;
    AppMethodBeat.o(242746);
  }
  
  public final void a(View paramView, int paramInt, c paramc)
  {
    AppMethodBeat.i(242745);
    p.h(paramView, "view");
    p.h(paramc, "conv");
    this.tyK = paramc;
    paramc = new com.tencent.mm.ui.widget.b.a(paramView.getContext());
    paramc.setOnDismissListener((PopupWindow.OnDismissListener)this);
    View.OnCreateContextMenuListener localOnCreateContextMenuListener = (View.OnCreateContextMenuListener)this;
    o.g localg = (o.g)this;
    TouchableLayout.a locala = TouchableLayout.Rni;
    int i = TouchableLayout.hfC();
    locala = TouchableLayout.Rni;
    paramc.a(paramView, paramInt, 0L, localOnCreateContextMenuListener, localg, i, TouchableLayout.hfD());
    paramc.gTx();
    AppMethodBeat.o(242745);
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    Object localObject = null;
    AppMethodBeat.i(242743);
    p.h(paramContextMenu, "menu");
    p.h(paramView, "v");
    p.h(paramContextMenuInfo, "menuInfo");
    paramView = this.tyK;
    if (paramView != null) {}
    for (paramView = paramView.field_sessionId;; paramView = null)
    {
      if ((p.j(paramView, "findersayhisessionholder") ^ true))
      {
        paramContextMenuInfo = this.tyK;
        paramView = localObject;
        if (paramContextMenuInfo != null) {
          paramView = paramContextMenuInfo.field_sessionId;
        }
        if ((p.j(paramView, "finder_system_message") ^ true)) {
          paramContextMenu.add(0, 2, 0, 2131762843);
        }
      }
      AppMethodBeat.o(242743);
      return;
    }
  }
  
  public final void onDismiss()
  {
    this.tyK = null;
  }
  
  public final void onMMMenuItemSelected(final MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(242744);
    p.h(paramMenuItem, "menuItem");
    c localc = this.tyK;
    if (localc != null)
    {
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(242744);
        return;
        paramMenuItem = ((PluginFinder)g.ah(PluginFinder.class)).getConversationStorage();
        Object localObject = localc.field_sessionId;
        p.g(localObject, "focused.field_sessionId");
        if (paramMenuItem.bt((String)localObject, true))
        {
          paramMenuItem = this.tyL;
          if (paramMenuItem != null)
          {
            paramMenuItem.invoke();
            AppMethodBeat.o(242744);
            return;
          }
          AppMethodBeat.o(242744);
          return;
        }
        Log.e("Finder.ConversationOnLongClickListener", "setTopPlace failed. sessionId=" + localc.field_sessionId);
        AppMethodBeat.o(242744);
        return;
        paramMenuItem = ((PluginFinder)g.ah(PluginFinder.class)).getConversationStorage();
        localObject = localc.field_sessionId;
        p.g(localObject, "focused.field_sessionId");
        if (paramMenuItem.bt((String)localObject, false))
        {
          paramMenuItem = this.tyL;
          if (paramMenuItem != null)
          {
            paramMenuItem.invoke();
            AppMethodBeat.o(242744);
            return;
          }
          AppMethodBeat.o(242744);
          return;
        }
        Log.e("Finder.ConversationOnLongClickListener", "setUnTopPlace failed. sessionId=" + localc.field_sessionId);
        AppMethodBeat.o(242744);
        return;
        paramMenuItem = ((PluginFinder)g.ah(PluginFinder.class)).getConversationStorage();
        localObject = localc.field_sessionId;
        p.g(localObject, "focused.field_sessionId");
        if (paramMenuItem.avs((String)localObject))
        {
          paramMenuItem = this.tyL;
          if (paramMenuItem != null)
          {
            paramMenuItem.invoke();
            AppMethodBeat.o(242744);
            return;
          }
          AppMethodBeat.o(242744);
          return;
        }
        Log.e("Finder.ConversationOnLongClickListener", "clearUnreadCount failed. sessionId=" + localc.field_sessionId);
        AppMethodBeat.o(242744);
        return;
        localObject = paramMenuItem.getMenuInfo();
        if (localObject == null)
        {
          paramMenuItem = new t("null cannot be cast to non-null type android.widget.AdapterView.AdapterContextMenuInfo");
          AppMethodBeat.o(242744);
          throw paramMenuItem;
        }
        localObject = (AdapterView.AdapterContextMenuInfo)localObject;
        bp.a(localc.field_sessionId, (bp.a)new b(localc, (AdapterView.AdapterContextMenuInfo)localObject, this, paramMenuItem));
      }
    }
    AppMethodBeat.o(242744);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationLongClickListener$Companion;", "", "()V", "CONTEXT_MENU_LONG_CLICK_DELETE", "", "CONTEXT_MENU_LONG_CLICK_MARK_READ", "CONTEXT_MENU_LONG_CLICK_PLACED_TOP", "CONTEXT_MENU_LONG_CLICK_UN_PLACED_TOP", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/conv/FinderConversationLongClickListener$onMMMenuItemSelected$1$1", "Lcom/tencent/mm/model/MsgInfoStorageLogic$IDeleteMsg;", "finishCallback", "", "isCancel", "", "plugin-finder_release"})
  public static final class b
    implements bp.a
  {
    b(c paramc, AdapterView.AdapterContextMenuInfo paramAdapterContextMenuInfo, h paramh, MenuItem paramMenuItem) {}
    
    public final boolean amG()
    {
      return false;
    }
    
    public final void amH()
    {
      AppMethodBeat.i(242742);
      Log.i("Finder.ConversationOnLongClickListener", "longclick delete msg finish");
      boolean bool = ((PluginFinder)g.ah(PluginFinder.class)).getConversationStorage().deleteNotify(this.tyN.systemRowid, false);
      if (bool)
      {
        localObject = ((PluginFinder)g.ah(PluginFinder.class)).getSessionInfoStorage();
        String str = this.tyN.field_sessionId;
        p.g(str, "focused.field_sessionId");
        p.h(str, "sessionId");
        k localk = ((ag)localObject).avz(str);
        ((ag)localObject).vFb.remove(str);
        ((ag)localObject).vFa.remove(localk.field_talker);
        ((ag)localObject).delete((IAutoDBItem)localk, false, new String[] { "sessionId" });
        ((PluginFinder)g.ah(PluginFinder.class)).getConversationStorage().doNotify(this.tyN.field_sessionId, 6, this.tyN);
        localObject = h.a(jdField_this);
        if (localObject != null) {
          ((kotlin.g.a.a)localObject).invoke();
        }
      }
      Log.i("Finder.ConversationOnLongClickListener", "[CONTEXT_MENU_LONG_CLICK_DELETE] ret" + bool + " position=" + this.tyO.position);
      Object localObject = d.vdp;
      localObject = d.dnF();
      ((ai)localObject).viS += 1L;
      AppMethodBeat.o(242742);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.h
 * JD-Core Version:    0.7.0.1
 */