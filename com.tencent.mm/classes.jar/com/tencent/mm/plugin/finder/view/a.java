package com.tencent.mm.plugin.finder.view;

import android.content.ClipData;
import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.model.m;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.plugin.i.a.j;
import com.tencent.mm.plugin.i.a.s;
import com.tencent.mm.protocal.protobuf.apl;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import d.v;
import d.z;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/CommentMenu;", "", "()V", "BottomSheetMenuListener", "Companion", "MenuItemCreateListener", "MenuItemSelectListener", "plugin-finder_release"})
public final class a
{
  private static final int sRR = 0;
  private static final int sRS = 1;
  private static final int sRT = 2;
  private static final int sRU = 3;
  private static final int sRV = 999;
  public static final b sRW;
  
  static
  {
    AppMethodBeat.i(178469);
    sRW = new b((byte)0);
    sRS = 1;
    sRT = 2;
    sRU = 3;
    sRV = 999;
    AppMethodBeat.o(178469);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/CommentMenu$BottomSheetMenuListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "feedUsername", "", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;Ljava/lang/String;)V", "getFeedUsername", "()Ljava/lang/String;", "onCreateMMMenu", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "plugin-finder_release"})
  public static final class a
    implements n.d
  {
    private final String rIE;
    private m sRX;
    
    public a(m paramm, String paramString)
    {
      AppMethodBeat.i(205040);
      this.sRX = paramm;
      this.rIE = paramString;
      AppMethodBeat.o(205040);
    }
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(205039);
      d.g.b.p.h(paraml, "menu");
      Object localObject = com.tencent.mm.plugin.finder.utils.p.sMo;
      if (com.tencent.mm.plugin.finder.utils.p.aiX(this.rIE))
      {
        paraml.jI(a.cMR(), 2131755701);
        if (((d.g.b.p.i(this.sRX.skh.getUsername(), u.aAu()) ^ true)) && ((d.g.b.p.i(this.sRX.skh.getUsername(), u.aAm()) ^ true))) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            paraml.jI(a.cMS(), 2131755735);
          }
          paraml.jI(a.cMT(), 2131755707);
          if (i == 0) {
            break label175;
          }
          localObject = com.tencent.mm.plugin.finder.utils.p.sMo;
          if (!com.tencent.mm.plugin.finder.utils.p.aiX(this.rIE)) {
            break label175;
          }
          if (!this.sRX.skh.cIS()) {
            break;
          }
          localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
          if (!com.tencent.mm.plugin.finder.storage.b.cGn()) {
            break label175;
          }
          paraml.jI(a.cMU(), 2131759146);
          AppMethodBeat.o(205039);
          return;
        }
        paraml.jI(a.cMU(), 2131759146);
      }
      label175:
      AppMethodBeat.o(205039);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/CommentMenu$Companion;", "", "()V", "MENU_BAN", "", "MENU_COPY", "MENU_DEBUG", "MENU_DEL", "MENU_EXPOSE", "plugin-finder_release"})
  public static final class b {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/CommentMenu$MenuItemCreateListener;", "Landroid/view/View$OnCreateContextMenuListener;", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "feedUsername", "", "isFinderScene", "", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;Ljava/lang/String;Z)V", "getFeedUsername", "()Ljava/lang/String;", "()Z", "onCreateContextMenu", "", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "plugin-finder_release"})
  public static final class c
    implements View.OnCreateContextMenuListener
  {
    private final String rIE;
    private m sRX;
    private final boolean sRY;
    
    public c(m paramm, String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(168213);
      this.sRX = paramm;
      this.rIE = paramString;
      this.sRY = paramBoolean;
      AppMethodBeat.o(168213);
    }
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      int k = 1;
      AppMethodBeat.i(168212);
      int i;
      int j;
      if (paramContextMenu != null)
      {
        paramContextMenu.add(0, a.cMR(), 0, 2131755701);
        if ((!(d.g.b.p.i(this.sRX.skh.getUsername(), u.aAu()) ^ true)) || (!(d.g.b.p.i(this.sRX.skh.getUsername(), u.aAm()) ^ true))) {
          break label250;
        }
        i = 1;
        if (i != 0) {
          paramContextMenu.add(0, a.cMS(), 1, 2131755735);
        }
        paramView = this.sRX.skh;
        j = k;
        if (!d.g.b.p.i(u.aAu(), paramView.getUsername()))
        {
          if (!d.g.b.p.i(u.aAm(), paramView.getUsername())) {
            break label256;
          }
          j = k;
        }
        label132:
        if (j == 0)
        {
          paramView = com.tencent.mm.plugin.finder.utils.p.sMo;
          if (!com.tencent.mm.plugin.finder.utils.p.aiX(this.rIE)) {}
        }
        else
        {
          paramContextMenu.add(0, a.cMT(), 2, 2131755707);
        }
        if (i != 0)
        {
          paramView = com.tencent.mm.plugin.finder.utils.p.sMo;
          if (com.tencent.mm.plugin.finder.utils.p.aiX(this.rIE))
          {
            if (!this.sRX.skh.cIS()) {
              break label262;
            }
            paramView = com.tencent.mm.plugin.finder.storage.b.sxa;
            if (com.tencent.mm.plugin.finder.storage.b.cGn()) {
              paramContextMenu.add(0, a.cMU(), 3, 2131759146);
            }
          }
        }
      }
      for (;;)
      {
        if (i.DEBUG) {
          paramContextMenu.add(0, a.cMV(), 4, (CharSequence)"debug");
        }
        AppMethodBeat.o(168212);
        return;
        label250:
        i = 0;
        break;
        label256:
        j = 0;
        break label132;
        label262:
        paramContextMenu.add(0, a.cMU(), 3, 2131759146);
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/CommentMenu$MenuItemSelectListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "commentDelCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "comment", "", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;Lkotlin/jvm/functions/Function1;)V", "getCommentDelCallback", "()Lkotlin/jvm/functions/Function1;", "setCommentDelCallback", "(Lkotlin/jvm/functions/Function1;)V", "getCommentItem", "()Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "setCommentItem", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;)V", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", "index", "", "plugin-finder_release"})
  public static final class d
    implements n.e
  {
    private m sRX;
    private d.g.a.b<? super m, z> sRZ;
    
    public d(m paramm, d.g.a.b<? super m, z> paramb)
    {
      AppMethodBeat.i(168216);
      this.sRX = paramm;
      this.sRZ = paramb;
      AppMethodBeat.o(168216);
    }
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(168215);
      android.text.ClipboardManager localClipboardManager;
      if (paramMenuItem != null)
      {
        paramInt = paramMenuItem.getItemId();
        if (paramInt == a.cMR())
        {
          if (!bt.isNullOrNil(this.sRX.skh.getContent()))
          {
            paramMenuItem = aj.getContext().getSystemService("clipboard");
            if (paramMenuItem == null)
            {
              paramMenuItem = new v("null cannot be cast to non-null type android.content.ClipboardManager");
              AppMethodBeat.o(168215);
              throw paramMenuItem;
            }
            ((android.content.ClipboardManager)paramMenuItem).setPrimaryClip(ClipData.newPlainText((CharSequence)this.sRX.skh.getContent(), (CharSequence)this.sRX.skh.getContent()));
            Toast.makeText(aj.getContext(), 2131755702, 0).show();
            AppMethodBeat.o(168215);
            return;
          }
          AppMethodBeat.o(168215);
          return;
        }
        if (paramInt == a.cMT())
        {
          paramMenuItem = this.sRZ;
          if (paramMenuItem != null)
          {
            paramMenuItem.invoke(this.sRX);
            AppMethodBeat.o(168215);
            return;
          }
          AppMethodBeat.o(168215);
          return;
        }
        if (paramInt == a.cMS())
        {
          paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.a.saO;
          paramMenuItem = aj.getContext();
          d.g.b.p.g(paramMenuItem, "MMApplicationContext.getContext()");
          com.tencent.mm.plugin.finder.feed.logic.a.b(paramMenuItem, this.sRX.skh.field_feedId, this.sRX.skh.cIG());
          AppMethodBeat.o(168215);
          return;
        }
        if (paramInt == a.cMU())
        {
          ((j)g.ab(j.class)).a(this.sRX.lP(), this.sRX.skh.field_feedId, this.sRX.skh.getObjectNonceId(), (s)new a());
          AppMethodBeat.o(168215);
          return;
        }
        if (paramInt == a.cMV())
        {
          paramMenuItem = aj.getContext().getSystemService("clipboard");
          if (paramMenuItem == null)
          {
            paramMenuItem = new v("null cannot be cast to non-null type android.text.ClipboardManager");
            AppMethodBeat.o(168215);
            throw paramMenuItem;
          }
          localClipboardManager = (android.text.ClipboardManager)paramMenuItem;
          paramMenuItem = this.sRX;
          if (paramMenuItem == null) {
            break label361;
          }
          paramMenuItem = paramMenuItem.skh;
          if (paramMenuItem == null) {
            break label361;
          }
        }
      }
      label361:
      for (paramMenuItem = paramMenuItem.toString();; paramMenuItem = null)
      {
        localClipboardManager.setText((CharSequence)paramMenuItem);
        AppMethodBeat.o(168215);
        return;
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/view/CommentMenu$MenuItemSelectListener$onMMMenuItemSelected$1$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
    public static final class a
      implements s<apl>
    {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.a
 * JD-Core Version:    0.7.0.1
 */