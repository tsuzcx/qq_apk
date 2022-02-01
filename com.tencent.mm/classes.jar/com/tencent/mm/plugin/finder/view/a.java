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
import com.tencent.mm.plugin.finder.storage.t;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.plugin.i.a.f;
import com.tencent.mm.protocal.protobuf.amf;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import d.v;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/CommentMenu;", "", "()V", "BottomSheetMenuListener", "Companion", "MenuItemCreateListener", "MenuItemSelectListener", "plugin-finder_release"})
public final class a
{
  private static final int rVj = 0;
  private static final int rVk = 1;
  private static final int rVl = 2;
  private static final int rVm = 3;
  private static final int rVn = 999;
  public static final a.b rVo;
  
  static
  {
    AppMethodBeat.i(178469);
    rVo = new a.b((byte)0);
    rVk = 1;
    rVl = 2;
    rVm = 3;
    rVn = 999;
    AppMethodBeat.o(178469);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/CommentMenu$BottomSheetMenuListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "feedUsername", "", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;Ljava/lang/String;)V", "getFeedUsername", "()Ljava/lang/String;", "onCreateMMMenu", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "plugin-finder_release"})
  public static final class a
    implements n.c
  {
    private final String qXv;
    private com.tencent.mm.plugin.finder.model.l rVp;
    
    public a(com.tencent.mm.plugin.finder.model.l paraml, String paramString)
    {
      AppMethodBeat.i(204086);
      this.rVp = paraml;
      this.qXv = paramString;
      AppMethodBeat.o(204086);
    }
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(204085);
      d.g.b.k.h(paraml, "menu");
      Object localObject = n.rPN;
      if (n.aeD(this.qXv))
      {
        paraml.jw(a.cEy(), 2131755701);
        if (((d.g.b.k.g(this.rVp.ruO.getUsername(), u.axE()) ^ true)) && ((d.g.b.k.g(this.rVp.ruO.getUsername(), u.axw()) ^ true))) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            paraml.jw(a.cEz(), 2131755735);
          }
          paraml.jw(a.cEA(), 2131755707);
          if (i == 0) {
            break label175;
          }
          localObject = n.rPN;
          if (!n.aeD(this.qXv)) {
            break label175;
          }
          if (!this.rVp.ruO.cAW()) {
            break;
          }
          localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
          if (!com.tencent.mm.plugin.finder.storage.b.czD()) {
            break label175;
          }
          paraml.jw(a.cEB(), 2131759146);
          AppMethodBeat.o(204085);
          return;
        }
        paraml.jw(a.cEB(), 2131759146);
      }
      label175:
      AppMethodBeat.o(204085);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/CommentMenu$MenuItemCreateListener;", "Landroid/view/View$OnCreateContextMenuListener;", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "feedUsername", "", "isFinderScene", "", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;Ljava/lang/String;Z)V", "getFeedUsername", "()Ljava/lang/String;", "()Z", "onCreateContextMenu", "", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "plugin-finder_release"})
  public static final class c
    implements View.OnCreateContextMenuListener
  {
    private final String qXv;
    private com.tencent.mm.plugin.finder.model.l rVp;
    private final boolean rVq;
    
    public c(com.tencent.mm.plugin.finder.model.l paraml, String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(168213);
      this.rVp = paraml;
      this.qXv = paramString;
      this.rVq = paramBoolean;
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
        paramContextMenu.add(0, a.cEy(), 0, 2131755701);
        if ((!(d.g.b.k.g(this.rVp.ruO.getUsername(), u.axE()) ^ true)) || (!(d.g.b.k.g(this.rVp.ruO.getUsername(), u.axw()) ^ true))) {
          break label250;
        }
        i = 1;
        if (i != 0) {
          paramContextMenu.add(0, a.cEz(), 1, 2131755735);
        }
        paramView = this.rVp.ruO;
        j = k;
        if (!d.g.b.k.g(u.axE(), paramView.getUsername()))
        {
          if (!d.g.b.k.g(u.axw(), paramView.getUsername())) {
            break label256;
          }
          j = k;
        }
        label132:
        if (j == 0)
        {
          paramView = n.rPN;
          if (!n.aeD(this.qXv)) {}
        }
        else
        {
          paramContextMenu.add(0, a.cEA(), 2, 2131755707);
        }
        if (i != 0)
        {
          paramView = n.rPN;
          if (n.aeD(this.qXv))
          {
            if (!this.rVp.ruO.cAW()) {
              break label262;
            }
            paramView = com.tencent.mm.plugin.finder.storage.b.rCU;
            if (com.tencent.mm.plugin.finder.storage.b.czD()) {
              paramContextMenu.add(0, a.cEB(), 3, 2131759146);
            }
          }
        }
      }
      for (;;)
      {
        if (h.DEBUG) {
          paramContextMenu.add(0, a.cEC(), 4, (CharSequence)"debug");
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
        paramContextMenu.add(0, a.cEB(), 3, 2131759146);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/CommentMenu$MenuItemSelectListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "commentDelCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "comment", "", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;Lkotlin/jvm/functions/Function1;)V", "getCommentDelCallback", "()Lkotlin/jvm/functions/Function1;", "setCommentDelCallback", "(Lkotlin/jvm/functions/Function1;)V", "getCommentItem", "()Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "setCommentItem", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;)V", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", "index", "", "plugin-finder_release"})
  public static final class d
    implements n.d
  {
    private com.tencent.mm.plugin.finder.model.l rVp;
    private d.g.a.b<? super com.tencent.mm.plugin.finder.model.l, y> rVr;
    
    public d(com.tencent.mm.plugin.finder.model.l paraml, d.g.a.b<? super com.tencent.mm.plugin.finder.model.l, y> paramb)
    {
      AppMethodBeat.i(168216);
      this.rVp = paraml;
      this.rVr = paramb;
      AppMethodBeat.o(168216);
    }
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(168215);
      android.text.ClipboardManager localClipboardManager;
      if (paramMenuItem != null)
      {
        paramInt = paramMenuItem.getItemId();
        if (paramInt == a.cEy())
        {
          if (!bs.isNullOrNil(this.rVp.ruO.getContent()))
          {
            paramMenuItem = ai.getContext().getSystemService("clipboard");
            if (paramMenuItem == null)
            {
              paramMenuItem = new v("null cannot be cast to non-null type android.content.ClipboardManager");
              AppMethodBeat.o(168215);
              throw paramMenuItem;
            }
            ((android.content.ClipboardManager)paramMenuItem).setPrimaryClip(ClipData.newPlainText((CharSequence)this.rVp.ruO.getContent(), (CharSequence)this.rVp.ruO.getContent()));
            Toast.makeText(ai.getContext(), 2131755702, 0).show();
            AppMethodBeat.o(168215);
            return;
          }
          AppMethodBeat.o(168215);
          return;
        }
        if (paramInt == a.cEA())
        {
          paramMenuItem = this.rVr;
          if (paramMenuItem != null)
          {
            paramMenuItem.ay(this.rVp);
            AppMethodBeat.o(168215);
            return;
          }
          AppMethodBeat.o(168215);
          return;
        }
        if (paramInt == a.cEz())
        {
          paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.a.rml;
          paramMenuItem = ai.getContext();
          d.g.b.k.g(paramMenuItem, "MMApplicationContext.getContext()");
          com.tencent.mm.plugin.finder.feed.logic.a.b(paramMenuItem, this.rVp.ruO.field_feedId, this.rVp.ruO.cAK());
          AppMethodBeat.o(168215);
          return;
        }
        if (paramInt == a.cEB())
        {
          ((f)g.ab(f.class)).a(this.rVp.lx(), this.rVp.ruO.field_feedId, this.rVp.ruO.getObjectNonceId(), (com.tencent.mm.plugin.i.a.k)new a());
          AppMethodBeat.o(168215);
          return;
        }
        if (paramInt == a.cEC())
        {
          paramMenuItem = ai.getContext().getSystemService("clipboard");
          if (paramMenuItem == null)
          {
            paramMenuItem = new v("null cannot be cast to non-null type android.text.ClipboardManager");
            AppMethodBeat.o(168215);
            throw paramMenuItem;
          }
          localClipboardManager = (android.text.ClipboardManager)paramMenuItem;
          paramMenuItem = this.rVp;
          if (paramMenuItem == null) {
            break label361;
          }
          paramMenuItem = paramMenuItem.ruO;
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
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/view/CommentMenu$MenuItemSelectListener$onMMMenuItemSelected$1$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
    public static final class a
      implements com.tencent.mm.plugin.i.a.k<amf>
    {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.a
 * JD-Core Version:    0.7.0.1
 */