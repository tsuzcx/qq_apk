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
import com.tencent.mm.plugin.finder.model.n;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.plugin.i.a.s;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import d.z;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/CommentMenu;", "", "()V", "BottomSheetMenuListener", "Companion", "MenuItemCreateListener", "MenuItemSelectListener", "plugin-finder_release"})
public final class a
{
  private static final int tdc = 0;
  private static final int tdd = 1;
  private static final int tde = 2;
  private static final int tdf = 3;
  private static final int tdg = 999;
  public static final a.b tdh;
  
  static
  {
    AppMethodBeat.i(178469);
    tdh = new a.b((byte)0);
    tdd = 1;
    tde = 2;
    tdf = 3;
    tdg = 999;
    AppMethodBeat.o(178469);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/CommentMenu$BottomSheetMenuListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "feedUsername", "", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;Ljava/lang/String;)V", "getFeedUsername", "()Ljava/lang/String;", "onCreateMMMenu", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "plugin-finder_release"})
  public static final class a
    implements n.d
  {
    private final String rQO;
    private n tdi;
    
    public a(n paramn, String paramString)
    {
      AppMethodBeat.i(205665);
      this.tdi = paramn;
      this.rQO = paramString;
      AppMethodBeat.o(205665);
    }
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(205664);
      d.g.b.p.h(paraml, "menu");
      Object localObject = com.tencent.mm.plugin.finder.utils.p.sXz;
      if (com.tencent.mm.plugin.finder.utils.p.ajU(this.rQO))
      {
        paraml.jM(a.cPA(), 2131755701);
        if (((d.g.b.p.i(this.tdi.ste.getUsername(), com.tencent.mm.model.v.aAK()) ^ true)) && ((d.g.b.p.i(this.tdi.ste.getUsername(), com.tencent.mm.model.v.aAC()) ^ true))) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            paraml.jM(a.cPB(), 2131755735);
          }
          paraml.jM(a.cPC(), 2131755707);
          if (i == 0) {
            break label175;
          }
          localObject = com.tencent.mm.plugin.finder.utils.p.sXz;
          if (!com.tencent.mm.plugin.finder.utils.p.ajU(this.rQO)) {
            break label175;
          }
          if (!this.tdi.ste.cLu()) {
            break;
          }
          localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
          if (!com.tencent.mm.plugin.finder.storage.b.cIk()) {
            break label175;
          }
          paraml.jM(a.cPD(), 2131759146);
          AppMethodBeat.o(205664);
          return;
        }
        paraml.jM(a.cPD(), 2131759146);
      }
      label175:
      AppMethodBeat.o(205664);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/CommentMenu$MenuItemCreateListener;", "Landroid/view/View$OnCreateContextMenuListener;", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "feedUsername", "", "isFinderScene", "", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;Ljava/lang/String;Z)V", "getFeedUsername", "()Ljava/lang/String;", "()Z", "onCreateContextMenu", "", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "plugin-finder_release"})
  public static final class c
    implements View.OnCreateContextMenuListener
  {
    private final String rQO;
    private n tdi;
    private final boolean tdj;
    
    public c(n paramn, String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(168213);
      this.tdi = paramn;
      this.rQO = paramString;
      this.tdj = paramBoolean;
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
        paramContextMenu.add(0, a.cPA(), 0, 2131755701);
        if ((!(d.g.b.p.i(this.tdi.ste.getUsername(), com.tencent.mm.model.v.aAK()) ^ true)) || (!(d.g.b.p.i(this.tdi.ste.getUsername(), com.tencent.mm.model.v.aAC()) ^ true))) {
          break label250;
        }
        i = 1;
        if (i != 0) {
          paramContextMenu.add(0, a.cPB(), 1, 2131755735);
        }
        paramView = this.tdi.ste;
        j = k;
        if (!d.g.b.p.i(com.tencent.mm.model.v.aAK(), paramView.getUsername()))
        {
          if (!d.g.b.p.i(com.tencent.mm.model.v.aAC(), paramView.getUsername())) {
            break label256;
          }
          j = k;
        }
        label132:
        if (j == 0)
        {
          paramView = com.tencent.mm.plugin.finder.utils.p.sXz;
          if (!com.tencent.mm.plugin.finder.utils.p.ajU(this.rQO)) {}
        }
        else
        {
          paramContextMenu.add(0, a.cPC(), 2, 2131755707);
        }
        if (i != 0)
        {
          paramView = com.tencent.mm.plugin.finder.utils.p.sXz;
          if (com.tencent.mm.plugin.finder.utils.p.ajU(this.rQO))
          {
            if (!this.tdi.ste.cLu()) {
              break label262;
            }
            paramView = com.tencent.mm.plugin.finder.storage.b.sHP;
            if (com.tencent.mm.plugin.finder.storage.b.cIk()) {
              paramContextMenu.add(0, a.cPD(), 3, 2131759146);
            }
          }
        }
      }
      for (;;)
      {
        if (com.tencent.mm.sdk.platformtools.j.DEBUG) {
          paramContextMenu.add(0, a.cPE(), 4, (CharSequence)"debug");
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
        paramContextMenu.add(0, a.cPD(), 3, 2131759146);
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/CommentMenu$MenuItemSelectListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "commentDelCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "comment", "", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;Lkotlin/jvm/functions/Function1;)V", "getCommentDelCallback", "()Lkotlin/jvm/functions/Function1;", "setCommentDelCallback", "(Lkotlin/jvm/functions/Function1;)V", "getCommentItem", "()Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "setCommentItem", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;)V", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", "index", "", "plugin-finder_release"})
  public static final class d
    implements n.e
  {
    private n tdi;
    private d.g.a.b<? super n, z> tdk;
    
    public d(n paramn, d.g.a.b<? super n, z> paramb)
    {
      AppMethodBeat.i(168216);
      this.tdi = paramn;
      this.tdk = paramb;
      AppMethodBeat.o(168216);
    }
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(168215);
      android.text.ClipboardManager localClipboardManager;
      if (paramMenuItem != null)
      {
        paramInt = paramMenuItem.getItemId();
        if (paramInt == a.cPA())
        {
          if (!bu.isNullOrNil(this.tdi.ste.getContent()))
          {
            paramMenuItem = ak.getContext().getSystemService("clipboard");
            if (paramMenuItem == null)
            {
              paramMenuItem = new d.v("null cannot be cast to non-null type android.content.ClipboardManager");
              AppMethodBeat.o(168215);
              throw paramMenuItem;
            }
            ((android.content.ClipboardManager)paramMenuItem).setPrimaryClip(ClipData.newPlainText((CharSequence)this.tdi.ste.getContent(), (CharSequence)this.tdi.ste.getContent()));
            Toast.makeText(ak.getContext(), 2131755702, 0).show();
            AppMethodBeat.o(168215);
            return;
          }
          AppMethodBeat.o(168215);
          return;
        }
        if (paramInt == a.cPC())
        {
          paramMenuItem = this.tdk;
          if (paramMenuItem != null)
          {
            paramMenuItem.invoke(this.tdi);
            AppMethodBeat.o(168215);
            return;
          }
          AppMethodBeat.o(168215);
          return;
        }
        if (paramInt == a.cPB())
        {
          paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.a.sjE;
          paramMenuItem = ak.getContext();
          d.g.b.p.g(paramMenuItem, "MMApplicationContext.getContext()");
          com.tencent.mm.plugin.finder.feed.logic.a.b(paramMenuItem, this.tdi.ste.field_feedId, this.tdi.ste.cLl().commentId);
          AppMethodBeat.o(168215);
          return;
        }
        if (paramInt == a.cPD())
        {
          ((com.tencent.mm.plugin.i.a.j)g.ab(com.tencent.mm.plugin.i.a.j.class)).a(this.tdi.lP(), this.tdi.ste.field_feedId, this.tdi.ste.getObjectNonceId(), (s)new a.d.a());
          AppMethodBeat.o(168215);
          return;
        }
        if (paramInt == a.cPE())
        {
          paramMenuItem = ak.getContext().getSystemService("clipboard");
          if (paramMenuItem == null)
          {
            paramMenuItem = new d.v("null cannot be cast to non-null type android.text.ClipboardManager");
            AppMethodBeat.o(168215);
            throw paramMenuItem;
          }
          localClipboardManager = (android.text.ClipboardManager)paramMenuItem;
          paramMenuItem = this.tdi;
          if (paramMenuItem == null) {
            break label364;
          }
          paramMenuItem = paramMenuItem.ste;
          if (paramMenuItem == null) {
            break label364;
          }
        }
      }
      label364:
      for (paramMenuItem = paramMenuItem.toString();; paramMenuItem = null)
      {
        localClipboardManager.setText((CharSequence)paramMenuItem);
        AppMethodBeat.o(168215);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.a
 * JD-Core Version:    0.7.0.1
 */