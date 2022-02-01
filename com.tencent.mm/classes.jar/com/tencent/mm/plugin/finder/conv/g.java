package com.tencent.mm.plugin.finder.conv;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bj.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.b;
import com.tencent.mm.plugin.finder.report.x;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.storage.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.TouchableLayout.a;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.concurrent.ConcurrentHashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationLongClickListener;", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter$OnItemLongClickListener;", "Landroid/view/View$OnCreateContextMenuListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "Landroid/widget/PopupWindow$OnDismissListener;", "callBack", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "focusedConversation", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "onCreateContextMenu", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onDismiss", "onItemLongClick", "view", "position", "", "conv", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", "index", "Companion", "plugin-finder_release"})
public final class g
  implements View.OnCreateContextMenuListener, PopupWindow.OnDismissListener, d.b, n.e
{
  public static final a rLE;
  private c rLC;
  private d.g.a.a<z> rLD;
  
  static
  {
    AppMethodBeat.i(201286);
    rLE = new a((byte)0);
    AppMethodBeat.o(201286);
  }
  
  public g(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(201285);
    this.rLD = parama;
    AppMethodBeat.o(201285);
  }
  
  public final void a(View paramView, int paramInt, c paramc)
  {
    AppMethodBeat.i(201284);
    p.h(paramView, "view");
    p.h(paramc, "conv");
    this.rLC = paramc;
    paramc = new com.tencent.mm.ui.widget.b.a(paramView.getContext());
    paramc.setOnDismissListener((PopupWindow.OnDismissListener)this);
    View.OnCreateContextMenuListener localOnCreateContextMenuListener = (View.OnCreateContextMenuListener)this;
    n.e locale = (n.e)this;
    TouchableLayout.a locala = TouchableLayout.LrZ;
    int i = TouchableLayout.fQh();
    locala = TouchableLayout.LrZ;
    paramc.a(paramView, paramInt, 0L, localOnCreateContextMenuListener, locale, i, TouchableLayout.fQi());
    paramc.fGP();
    AppMethodBeat.o(201284);
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(201282);
    p.h(paramContextMenu, "menu");
    p.h(paramView, "v");
    p.h(paramContextMenuInfo, "menuInfo");
    paramView = this.rLC;
    if (paramView != null) {}
    for (paramView = paramView.field_sessionId;; paramView = null)
    {
      if ((p.i(paramView, "findersayhisessionholder") ^ true)) {
        paramContextMenu.add(0, 2, 0, 2131761057);
      }
      AppMethodBeat.o(201282);
      return;
    }
  }
  
  public final void onDismiss()
  {
    this.rLC = null;
  }
  
  public final void onMMMenuItemSelected(final MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(201283);
    p.h(paramMenuItem, "menuItem");
    c localc = this.rLC;
    if (localc != null)
    {
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(201283);
        return;
        paramMenuItem = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getConversationStorage();
        Object localObject = localc.field_sessionId;
        p.g(localObject, "focused.field_sessionId");
        if (paramMenuItem.be((String)localObject, true))
        {
          paramMenuItem = this.rLD;
          if (paramMenuItem != null)
          {
            paramMenuItem.invoke();
            AppMethodBeat.o(201283);
            return;
          }
          AppMethodBeat.o(201283);
          return;
        }
        ad.e("Finder.ConversationOnLongClickListener", "setTopPlace failed. sessionId=" + localc.field_sessionId);
        AppMethodBeat.o(201283);
        return;
        paramMenuItem = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getConversationStorage();
        localObject = localc.field_sessionId;
        p.g(localObject, "focused.field_sessionId");
        if (paramMenuItem.be((String)localObject, false))
        {
          paramMenuItem = this.rLD;
          if (paramMenuItem != null)
          {
            paramMenuItem.invoke();
            AppMethodBeat.o(201283);
            return;
          }
          AppMethodBeat.o(201283);
          return;
        }
        ad.e("Finder.ConversationOnLongClickListener", "setUnTopPlace failed. sessionId=" + localc.field_sessionId);
        AppMethodBeat.o(201283);
        return;
        paramMenuItem = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getConversationStorage();
        localObject = localc.field_sessionId;
        p.g(localObject, "focused.field_sessionId");
        if (paramMenuItem.ais((String)localObject))
        {
          paramMenuItem = this.rLD;
          if (paramMenuItem != null)
          {
            paramMenuItem.invoke();
            AppMethodBeat.o(201283);
            return;
          }
          AppMethodBeat.o(201283);
          return;
        }
        ad.e("Finder.ConversationOnLongClickListener", "clearUnreadCount failed. sessionId=" + localc.field_sessionId);
        AppMethodBeat.o(201283);
        return;
        localObject = paramMenuItem.getMenuInfo();
        if (localObject == null)
        {
          paramMenuItem = new v("null cannot be cast to non-null type android.widget.AdapterView.AdapterContextMenuInfo");
          AppMethodBeat.o(201283);
          throw paramMenuItem;
        }
        localObject = (AdapterView.AdapterContextMenuInfo)localObject;
        bj.a(localc.field_sessionId, (bj.a)new b(localc, (AdapterView.AdapterContextMenuInfo)localObject, this, paramMenuItem));
      }
    }
    AppMethodBeat.o(201283);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationLongClickListener$Companion;", "", "()V", "CONTEXT_MENU_LONG_CLICK_DELETE", "", "CONTEXT_MENU_LONG_CLICK_MARK_READ", "CONTEXT_MENU_LONG_CLICK_PLACED_TOP", "CONTEXT_MENU_LONG_CLICK_UN_PLACED_TOP", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/conv/FinderConversationLongClickListener$onMMMenuItemSelected$1$1", "Lcom/tencent/mm/model/MsgInfoStorageLogic$IDeleteMsg;", "finishCallback", "", "isCancel", "", "plugin-finder_release"})
  public static final class b
    implements bj.a
  {
    b(c paramc, AdapterView.AdapterContextMenuInfo paramAdapterContextMenuInfo, g paramg, MenuItem paramMenuItem) {}
    
    public final boolean YK()
    {
      return false;
    }
    
    public final void YL()
    {
      AppMethodBeat.i(201281);
      ad.i("Finder.ConversationOnLongClickListener", "longclick delete msg finish");
      boolean bool = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getConversationStorage().deleteNotify(this.rLF.systemRowid, false);
      if (bool)
      {
        localObject = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getSessionInfoStorage();
        String str = this.rLF.field_sessionId;
        p.g(str, "focused.field_sessionId");
        p.h(str, "sessionId");
        j localj = ((w)localObject).aiw(str);
        ((w)localObject).szf.remove(str);
        ((w)localObject).sze.remove(localj.field_talker);
        ((w)localObject).delete((com.tencent.mm.sdk.e.c)localj, false, new String[] { "sessionId" });
        ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getConversationStorage().doNotify(this.rLF.field_sessionId, 6, this.rLF);
        localObject = g.a(jdField_this);
        if (localObject != null) {
          ((d.g.a.a)localObject).invoke();
        }
      }
      ad.i("Finder.ConversationOnLongClickListener", "[CONTEXT_MENU_LONG_CLICK_DELETE] ret" + bool + " position=" + this.rLG.position);
      Object localObject = b.snk;
      localObject = b.cDj();
      ((x)localObject).ssD += 1L;
      AppMethodBeat.o(201281);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.g
 * JD-Core Version:    0.7.0.1
 */