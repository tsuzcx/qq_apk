package com.tencent.mm.plugin.finder.view;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.feed.logic.a;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.service.k;
import com.tencent.mm.plugin.finder.storage.am;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.beo;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/CommentMenu;", "", "()V", "BottomSheetMenuListener", "Companion", "MenuItemCreateListener", "MenuItemSelectListener", "plugin-finder_release"})
public final class b
{
  private static final int AUd = 0;
  private static final int AUe = 1;
  private static final int AUf = 2;
  private static final int AUg = 3;
  private static final int AUh = 999;
  public static final b AUi;
  
  static
  {
    AppMethodBeat.i(178469);
    AUi = new b((byte)0);
    AUe = 1;
    AUf = 2;
    AUg = 3;
    AUh = 999;
    AppMethodBeat.o(178469);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/CommentMenu$BottomSheetMenuListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "feedUsername", "", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;Ljava/lang/String;)V", "getFeedUsername", "()Ljava/lang/String;", "onCreateMMMenu", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "plugin-finder_release"})
  public static final class a
    implements q.f
  {
    private s AUj;
    private final String xbQ;
    
    public a(s params, String paramString)
    {
      AppMethodBeat.i(258302);
      this.AUj = params;
      this.xbQ = paramString;
      AppMethodBeat.o(258302);
    }
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(258301);
      p.k(paramo, "menu");
      Object localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if (com.tencent.mm.plugin.finder.utils.aj.PE(this.xbQ))
      {
        paramo.mn(b.eie(), b.j.app_copy);
        if (((p.h(this.AUj.zAt.getUsername(), com.tencent.mm.model.z.bdh()) ^ true)) && ((p.h(this.AUj.zAt.getUsername(), com.tencent.mm.model.z.bcZ()) ^ true))) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            paramo.mn(b.eif(), b.j.app_expose);
          }
          paramo.mn(b.eig(), b.j.app_delete);
          if (i == 0) {
            break label180;
          }
          localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
          if (!com.tencent.mm.plugin.finder.utils.aj.PE(this.xbQ)) {
            break label180;
          }
          if (!this.AUj.zAt.dZh()) {
            break;
          }
          localObject = d.AjH;
          if (!d.dTk()) {
            break label180;
          }
          paramo.mn(b.eih(), b.j.finder_add_comment_to_banlist);
          AppMethodBeat.o(258301);
          return;
        }
        paramo.mn(b.eih(), b.j.finder_add_comment_to_banlist);
      }
      label180:
      AppMethodBeat.o(258301);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/CommentMenu$Companion;", "", "()V", "MENU_BAN", "", "MENU_COPY", "MENU_DEBUG", "MENU_DEL", "MENU_EXPOSE", "plugin-finder_release"})
  public static final class b {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/CommentMenu$MenuItemCreateListener;", "Landroid/view/View$OnCreateContextMenuListener;", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "feedUsername", "", "isFinderScene", "", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;Ljava/lang/String;Z)V", "getFeedUsername", "()Ljava/lang/String;", "()Z", "onCreateContextMenu", "", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "plugin-finder_release"})
  public static final class c
    implements View.OnCreateContextMenuListener
  {
    private s AUj;
    private final boolean AUk;
    private final String xbQ;
    
    public c(s params, String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(168213);
      this.AUj = params;
      this.xbQ = paramString;
      this.AUk = paramBoolean;
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
        paramContextMenu.add(0, b.eie(), 0, b.j.app_copy);
        if ((!(p.h(this.AUj.zAt.getUsername(), com.tencent.mm.model.z.bdh()) ^ true)) || (!(p.h(this.AUj.zAt.getUsername(), com.tencent.mm.model.z.bcZ()) ^ true))) {
          break label254;
        }
        i = 1;
        if (i != 0) {
          paramContextMenu.add(0, b.eif(), 1, b.j.app_expose);
        }
        paramView = this.AUj.zAt;
        j = k;
        if (!p.h(com.tencent.mm.model.z.bdh(), paramView.getUsername()))
        {
          if (!p.h(com.tencent.mm.model.z.bcZ(), paramView.getUsername())) {
            break label260;
          }
          j = k;
        }
        label134:
        if (j == 0)
        {
          paramView = com.tencent.mm.plugin.finder.utils.aj.AGc;
          if (!com.tencent.mm.plugin.finder.utils.aj.PE(this.xbQ)) {}
        }
        else
        {
          paramContextMenu.add(0, b.eig(), 2, b.j.app_delete);
        }
        if (i != 0)
        {
          paramView = com.tencent.mm.plugin.finder.utils.aj.AGc;
          if (com.tencent.mm.plugin.finder.utils.aj.PE(this.xbQ))
          {
            if (!this.AUj.zAt.dZh()) {
              break label266;
            }
            paramView = d.AjH;
            if (d.dTk()) {
              paramContextMenu.add(0, b.eih(), 3, b.j.finder_add_comment_to_banlist);
            }
          }
        }
      }
      for (;;)
      {
        if (BuildInfo.DEBUG) {
          paramContextMenu.add(0, b.eii(), 4, (CharSequence)"debug");
        }
        AppMethodBeat.o(168212);
        return;
        label254:
        i = 0;
        break;
        label260:
        j = 0;
        break label134;
        label266:
        paramContextMenu.add(0, b.eih(), 3, b.j.finder_add_comment_to_banlist);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/CommentMenu$MenuItemSelectListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "exposeScene", "", "commentDelCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "comment", "", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;ILkotlin/jvm/functions/Function1;)V", "getCommentDelCallback", "()Lkotlin/jvm/functions/Function1;", "setCommentDelCallback", "(Lkotlin/jvm/functions/Function1;)V", "getCommentItem", "()Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "setCommentItem", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;)V", "getExposeScene", "()I", "setExposeScene", "(I)V", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", "index", "plugin-finder_release"})
  public static final class d
    implements q.g
  {
    private s AUj;
    private kotlin.g.a.b<? super s, x> AUl;
    private int xwD;
    
    public d(s params, int paramInt, kotlin.g.a.b<? super s, x> paramb)
    {
      AppMethodBeat.i(288605);
      this.AUj = params;
      this.xwD = paramInt;
      this.AUl = paramb;
      AppMethodBeat.o(288605);
    }
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(168215);
      if (paramMenuItem != null)
      {
        paramInt = paramMenuItem.getItemId();
        if (paramInt == b.eie())
        {
          if (!Util.isNullOrNil(this.AUj.zAt.getContent()))
          {
            ClipboardHelper.setText((CharSequence)this.AUj.zAt.getContent());
            Toast.makeText(MMApplicationContext.getContext(), b.j.app_copy_ok, 0).show();
            paramMenuItem = com.tencent.mm.plugin.finder.utils.z.AEm;
            com.tencent.mm.plugin.finder.utils.z.ap(5, this.AUj.zAt.dYY().commentId);
            AppMethodBeat.o(168215);
          }
        }
        else
        {
          if (paramInt == b.eig())
          {
            paramMenuItem = this.AUl;
            if (paramMenuItem != null) {
              paramMenuItem.invoke(this.AUj);
            }
            paramMenuItem = com.tencent.mm.plugin.finder.utils.z.AEm;
            com.tencent.mm.plugin.finder.utils.z.ap(4, this.AUj.zAt.dYY().commentId);
            AppMethodBeat.o(168215);
            return;
          }
          if (paramInt == b.eif())
          {
            paramMenuItem = a.xFq;
            paramMenuItem = MMApplicationContext.getContext();
            p.j(paramMenuItem, "MMApplicationContext.getContext()");
            a.a(paramMenuItem, this.AUj.zAt.field_feedId, this.AUj.zAt.dYY().commentId, this.xwD);
            paramMenuItem = com.tencent.mm.plugin.finder.utils.z.AEm;
            com.tencent.mm.plugin.finder.utils.z.ap(6, this.AUj.zAt.dYY().commentId);
            AppMethodBeat.o(168215);
            return;
          }
          if (paramInt == b.eih())
          {
            paramMenuItem = n.zWF;
            paramMenuItem = MMApplicationContext.getContext();
            p.j(paramMenuItem, "MMApplicationContext.getContext()");
            n.b(paramMenuItem, 11L, 4L);
            ((k)h.ae(k.class)).a(this.AUj.mf(), this.AUj.zAt.field_feedId, this.AUj.zAt.getObjectNonceId(), (com.tencent.mm.plugin.findersdk.a.aj)new a());
            AppMethodBeat.o(168215);
            return;
          }
          if (paramInt == b.eii())
          {
            paramMenuItem = this.AUj;
            if (paramMenuItem == null) {
              break label359;
            }
            paramMenuItem = paramMenuItem.zAt;
            if (paramMenuItem == null) {
              break label359;
            }
          }
        }
      }
      label359:
      for (paramMenuItem = paramMenuItem.toString();; paramMenuItem = null)
      {
        ClipboardHelper.setText((CharSequence)paramMenuItem);
        AppMethodBeat.o(168215);
        return;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/CommentMenu$MenuItemSelectListener$onMMMenuItemSelected$1$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
    public static final class a
      implements com.tencent.mm.plugin.findersdk.a.aj<beo>
    {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.b
 * JD-Core Version:    0.7.0.1
 */