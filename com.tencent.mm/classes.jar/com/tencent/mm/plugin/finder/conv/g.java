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
import com.tencent.mm.model.br;
import com.tencent.mm.model.br.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.report.ba;
import com.tencent.mm.plugin.finder.report.f;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.TouchableLayout.a;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationLongClickListener;", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter$OnItemLongClickListener;", "Landroid/view/View$OnCreateContextMenuListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "Landroid/widget/PopupWindow$OnDismissListener;", "callBack", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "focusedConversation", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "onCreateContextMenu", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onDismiss", "onItemLongClick", "view", "position", "", "conv", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", "index", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  implements View.OnCreateContextMenuListener, PopupWindow.OnDismissListener, c.b, u.i
{
  public static final a AFO;
  private kotlin.g.a.a<ah> AFP;
  private b AFQ;
  
  static
  {
    AppMethodBeat.i(336018);
    AFO = new a((byte)0);
    AppMethodBeat.o(336018);
  }
  
  public g(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(336013);
    this.AFP = parama;
    AppMethodBeat.o(336013);
  }
  
  public final void a(View paramView, int paramInt, b paramb)
  {
    AppMethodBeat.i(336057);
    s.u(paramView, "view");
    s.u(paramb, "conv");
    this.AFQ = paramb;
    paramb = new com.tencent.mm.ui.widget.b.a(paramView.getContext());
    paramb.afLp = ((PopupWindow.OnDismissListener)this);
    View.OnCreateContextMenuListener localOnCreateContextMenuListener = (View.OnCreateContextMenuListener)this;
    u.i locali = (u.i)this;
    TouchableLayout.a locala = TouchableLayout.agKp;
    int i = TouchableLayout.jMn();
    locala = TouchableLayout.agKp;
    paramb.a(paramView, paramInt, 0L, localOnCreateContextMenuListener, locali, i, TouchableLayout.jMo());
    paramb.cMz();
    AppMethodBeat.o(336057);
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    Object localObject = null;
    AppMethodBeat.i(336030);
    s.u(paramContextMenu, "menu");
    s.u(paramView, "v");
    s.u(paramContextMenuInfo, "menuInfo");
    paramView = this.AFQ;
    if (paramView == null)
    {
      paramView = null;
      if (!s.p(paramView, "findersayhisessionholder"))
      {
        paramView = this.AFQ;
        if (paramView != null) {
          break label166;
        }
        paramView = null;
        label57:
        if (!s.p(paramView, "finder_system_message"))
        {
          paramView = this.AFQ;
          if (paramView != null) {
            break label174;
          }
          paramView = null;
          label77:
          if (!s.p(paramView, "finderaliassessionholder")) {
            paramContextMenu.add(0, 2, 0, e.h.main_delete);
          }
        }
      }
      paramView = this.AFQ;
      if (paramView != null) {
        break label182;
      }
      paramView = "";
      label111:
      if (!au.bwU(paramView))
      {
        paramView = this.AFQ;
        if (paramView != null) {
          break label199;
        }
      }
    }
    label166:
    label174:
    label182:
    label199:
    for (paramView = localObject;; paramView = paramView.field_sessionId)
    {
      if (s.p(paramView, "finderaliassessionholder")) {
        paramContextMenu.add(0, 4, 0, e.h.dimiss_conversation);
      }
      AppMethodBeat.o(336030);
      return;
      paramView = paramView.field_sessionId;
      break;
      paramView = paramView.field_sessionId;
      break label57;
      paramView = paramView.field_sessionId;
      break label77;
      paramContextMenuInfo = paramView.field_senderUserName;
      paramView = paramContextMenuInfo;
      if (paramContextMenuInfo != null) {
        break label111;
      }
      paramView = "";
      break label111;
    }
  }
  
  public final void onDismiss()
  {
    this.AFQ = null;
  }
  
  public final void onMMMenuItemSelected(final MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(336047);
    s.u(paramMenuItem, "menuItem");
    b localb = this.AFQ;
    if (localb != null) {
      switch (paramMenuItem.getItemId())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(336047);
      return;
      paramMenuItem = paramMenuItem.getMenuInfo();
      if (paramMenuItem == null)
      {
        paramMenuItem = new NullPointerException("null cannot be cast to non-null type android.widget.AdapterView.AdapterContextMenuInfo");
        AppMethodBeat.o(336047);
        throw paramMenuItem;
      }
      paramMenuItem = (AdapterView.AdapterContextMenuInfo)paramMenuItem;
      boolean bool = ((PluginFinder)h.az(PluginFinder.class)).getConversationStorage().deleteNotify(localb.systemRowid, false);
      if (bool)
      {
        Object localObject = ((PluginFinder)h.az(PluginFinder.class)).getSessionInfoStorage();
        String str = localb.field_sessionId;
        s.s(str, "focused.field_sessionId");
        ((ak)localObject).aAJ(str);
        ((PluginFinder)h.az(PluginFinder.class)).getConversationStorage().doNotify(localb.field_sessionId, 6, localb);
        localObject = this.AFP;
        if (localObject != null) {
          ((kotlin.g.a.a)localObject).invoke();
        }
      }
      br.a(localb.field_sessionId, (br.a)new b(bool, paramMenuItem));
      AppMethodBeat.o(336047);
      return;
      ((PluginFinder)h.az(PluginFinder.class)).getConversationStorage().deleteNotify(localb.systemRowid, false);
      ((PluginFinder)h.az(PluginFinder.class)).getConversationStorage().doNotify(localb.field_sessionId, 6, localb);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationLongClickListener$Companion;", "", "()V", "CONTEXT_MENU_LONG_CLICK_DELETE", "", "CONTEXT_MENU_LONG_CLICK_DISMISS", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/conv/FinderConversationLongClickListener$onMMMenuItemSelected$1$1", "Lcom/tencent/mm/model/MsgInfoStorageLogic$IDeleteMsg;", "finishCallback", "", "isCancel", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements br.a
  {
    b(boolean paramBoolean, AdapterView.AdapterContextMenuInfo paramAdapterContextMenuInfo) {}
    
    public final boolean aMJ()
    {
      return false;
    }
    
    public final void aMK()
    {
      AppMethodBeat.i(336094);
      Log.i("Finder.ConversationOnLongClickListener", "longclick delete msg finish");
      Log.i("Finder.ConversationOnLongClickListener", "[CONTEXT_MENU_LONG_CLICK_DELETE] ret" + this.AFR + " position=" + paramMenuItem.position);
      Object localObject = f.FnM;
      localObject = f.eMi();
      ((ba)localObject).FuI += 1L;
      AppMethodBeat.o(336094);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.g
 * JD-Core Version:    0.7.0.1
 */