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
import com.tencent.mm.plugin.i.a.e;
import com.tencent.mm.protocal.protobuf.ajw;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.n.d;
import d.l;
import d.v;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/CommentMenu;", "", "()V", "BottomSheetMenuListener", "Companion", "MenuItemCreateListener", "MenuItemSelectListener", "plugin-finder_release"})
public final class a
{
  private static final int qVc = 0;
  private static final int qVd = 1;
  private static final int qVe = 2;
  private static final int qVf = 3;
  private static final int qVg = 999;
  public static final a qVh;
  
  static
  {
    AppMethodBeat.i(178469);
    qVh = new a((byte)0);
    qVd = 1;
    qVe = 2;
    qVf = 3;
    qVg = 999;
    AppMethodBeat.o(178469);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/CommentMenu$Companion;", "", "()V", "MENU_BAN", "", "MENU_COPY", "MENU_DEBUG", "MENU_DEL", "MENU_EXPOSE", "plugin-finder_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/CommentMenu$MenuItemCreateListener;", "Landroid/view/View$OnCreateContextMenuListener;", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "feedUsername", "", "isFinderScene", "", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;Ljava/lang/String;Z)V", "getFeedUsername", "()Ljava/lang/String;", "()Z", "onCreateContextMenu", "", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "plugin-finder_release"})
  public static final class b
    implements View.OnCreateContextMenuListener
  {
    private com.tencent.mm.plugin.finder.model.h qVi;
    private final String qVj;
    private final boolean qVk;
    
    public b(com.tencent.mm.plugin.finder.model.h paramh, String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(168213);
      this.qVi = paramh;
      this.qVj = paramString;
      this.qVk = paramBoolean;
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
        paramContextMenu.add(0, a.csB(), 0, 2131755701);
        if ((!(d.g.b.k.g(this.qVi.qDA.getUsername(), u.aqO()) ^ true)) || (!(d.g.b.k.g(this.qVi.qDA.getUsername(), u.aqG()) ^ true))) {
          break label250;
        }
        i = 1;
        if (i != 0) {
          paramContextMenu.add(0, a.csC(), 1, 2131755735);
        }
        paramView = this.qVi.qDA;
        j = k;
        if (!d.g.b.k.g(u.aqO(), paramView.getUsername()))
        {
          if (!d.g.b.k.g(u.aqG(), paramView.getUsername())) {
            break label256;
          }
          j = k;
        }
        label132:
        if (j == 0)
        {
          paramView = com.tencent.mm.plugin.finder.utils.i.qTa;
          if (!com.tencent.mm.plugin.finder.utils.i.ZR(this.qVj)) {}
        }
        else
        {
          paramContextMenu.add(0, a.csD(), 2, 2131755707);
        }
        if (i != 0)
        {
          paramView = com.tencent.mm.plugin.finder.utils.i.qTa;
          if (com.tencent.mm.plugin.finder.utils.i.ZR(this.qVj))
          {
            if (!this.qVi.qDA.cqB()) {
              break label262;
            }
            paramView = com.tencent.mm.plugin.finder.storage.b.qJA;
            if (com.tencent.mm.plugin.finder.storage.b.cqc()) {
              paramContextMenu.add(0, a.csE(), 3, 2131759146);
            }
          }
        }
      }
      for (;;)
      {
        if (com.tencent.mm.sdk.platformtools.h.DEBUG) {
          paramContextMenu.add(0, a.csF(), 4, (CharSequence)"debug");
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
        paramContextMenu.add(0, a.csE(), 3, 2131759146);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/CommentMenu$MenuItemSelectListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "commentDelCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "comment", "", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;Lkotlin/jvm/functions/Function1;)V", "getCommentDelCallback", "()Lkotlin/jvm/functions/Function1;", "setCommentDelCallback", "(Lkotlin/jvm/functions/Function1;)V", "getCommentItem", "()Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "setCommentItem", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;)V", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", "index", "", "plugin-finder_release"})
  public static final class c
    implements n.d
  {
    private com.tencent.mm.plugin.finder.model.h qVi;
    private d.g.a.b<? super com.tencent.mm.plugin.finder.model.h, y> qVl;
    
    public c(com.tencent.mm.plugin.finder.model.h paramh, d.g.a.b<? super com.tencent.mm.plugin.finder.model.h, y> paramb)
    {
      AppMethodBeat.i(168216);
      this.qVi = paramh;
      this.qVl = paramb;
      AppMethodBeat.o(168216);
    }
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(168215);
      android.text.ClipboardManager localClipboardManager;
      if (paramMenuItem != null)
      {
        paramInt = paramMenuItem.getItemId();
        if (paramInt == a.csB())
        {
          if (!bt.isNullOrNil(this.qVi.qDA.getContent()))
          {
            paramMenuItem = aj.getContext().getSystemService("clipboard");
            if (paramMenuItem == null)
            {
              paramMenuItem = new v("null cannot be cast to non-null type android.content.ClipboardManager");
              AppMethodBeat.o(168215);
              throw paramMenuItem;
            }
            ((android.content.ClipboardManager)paramMenuItem).setPrimaryClip(ClipData.newPlainText((CharSequence)this.qVi.qDA.getContent(), (CharSequence)this.qVi.qDA.getContent()));
            Toast.makeText(aj.getContext(), 2131755702, 0).show();
            AppMethodBeat.o(168215);
            return;
          }
          AppMethodBeat.o(168215);
          return;
        }
        if (paramInt == a.csD())
        {
          paramMenuItem = this.qVl;
          if (paramMenuItem != null)
          {
            paramMenuItem.aA(this.qVi);
            AppMethodBeat.o(168215);
            return;
          }
          AppMethodBeat.o(168215);
          return;
        }
        if (paramInt == a.csC())
        {
          paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.a.qxZ;
          paramMenuItem = aj.getContext();
          d.g.b.k.g(paramMenuItem, "MMApplicationContext.getContext()");
          com.tencent.mm.plugin.finder.feed.logic.a.b(paramMenuItem, this.qVi.qDA.field_feedId, this.qVi.qDA.cqr());
          AppMethodBeat.o(168215);
          return;
        }
        if (paramInt == a.csE())
        {
          ((e)g.ab(e.class)).a(this.qVi.bMs(), this.qVi.qDA.field_feedId, this.qVi.qDA.getObjectNonceId(), (com.tencent.mm.plugin.i.a.i)new a());
          AppMethodBeat.o(168215);
          return;
        }
        if (paramInt == a.csF())
        {
          paramMenuItem = aj.getContext().getSystemService("clipboard");
          if (paramMenuItem == null)
          {
            paramMenuItem = new v("null cannot be cast to non-null type android.text.ClipboardManager");
            AppMethodBeat.o(168215);
            throw paramMenuItem;
          }
          localClipboardManager = (android.text.ClipboardManager)paramMenuItem;
          paramMenuItem = this.qVi;
          if (paramMenuItem == null) {
            break label361;
          }
          paramMenuItem = paramMenuItem.qDA;
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
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/view/CommentMenu$MenuItemSelectListener$onMMMenuItemSelected$1$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
    public static final class a
      implements com.tencent.mm.plugin.i.a.i<ajw>
    {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.a
 * JD-Core Version:    0.7.0.1
 */