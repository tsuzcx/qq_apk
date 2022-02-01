package com.tencent.mm.plugin.finder.view;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.utils.ao;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/CommentMenu;", "", "()V", "BottomSheetMenuListener", "Companion", "MenuItemCreateListener", "MenuItemSelectListener", "plugin-finder_release"})
public final class a
{
  private static final int wjA = 0;
  private static final int wjB = 1;
  private static final int wjC = 2;
  private static final int wjD = 3;
  private static final int wjE = 999;
  public static final b wjF;
  
  static
  {
    AppMethodBeat.i(178469);
    wjF = new b((byte)0);
    wjB = 1;
    wjC = 2;
    wjD = 3;
    wjE = 999;
    AppMethodBeat.o(178469);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/CommentMenu$BottomSheetMenuListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "feedUsername", "", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;Ljava/lang/String;)V", "getFeedUsername", "()Ljava/lang/String;", "onCreateMMMenu", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "plugin-finder_release"})
  public static final class a
    implements o.f
  {
    private final String tug;
    private s wjG;
    
    public a(s params, String paramString)
    {
      AppMethodBeat.i(254617);
      this.wjG = params;
      this.tug = paramString;
      AppMethodBeat.o(254617);
    }
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(254616);
      p.h(paramm, "menu");
      Object localObject = y.vXH;
      if (y.In(this.tug))
      {
        paramm.kV(a.dGh(), 2131755772);
        if (((p.j(this.wjG.uOf.getUsername(), z.aUg()) ^ true)) && ((p.j(this.wjG.uOf.getUsername(), z.aTY()) ^ true))) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            paramm.kV(a.dGi(), 2131755806);
          }
          paramm.kV(a.dGj(), 2131755778);
          if (i == 0) {
            break label175;
          }
          localObject = y.vXH;
          if (!y.In(this.tug)) {
            break label175;
          }
          if (!this.wjG.uOf.dyk()) {
            break;
          }
          localObject = c.vCb;
          if (!c.drU()) {
            break label175;
          }
          paramm.kV(a.dGk(), 2131759530);
          AppMethodBeat.o(254616);
          return;
        }
        paramm.kV(a.dGk(), 2131759530);
      }
      label175:
      AppMethodBeat.o(254616);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/CommentMenu$Companion;", "", "()V", "MENU_BAN", "", "MENU_COPY", "MENU_DEBUG", "MENU_DEL", "MENU_EXPOSE", "plugin-finder_release"})
  public static final class b {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/CommentMenu$MenuItemCreateListener;", "Landroid/view/View$OnCreateContextMenuListener;", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "feedUsername", "", "isFinderScene", "", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;Ljava/lang/String;Z)V", "getFeedUsername", "()Ljava/lang/String;", "()Z", "onCreateContextMenu", "", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "plugin-finder_release"})
  public static final class c
    implements View.OnCreateContextMenuListener
  {
    private final String tug;
    private s wjG;
    private final boolean wjH;
    
    public c(s params, String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(168213);
      this.wjG = params;
      this.tug = paramString;
      this.wjH = paramBoolean;
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
        paramContextMenu.add(0, a.dGh(), 0, 2131755772);
        if ((!(p.j(this.wjG.uOf.getUsername(), z.aUg()) ^ true)) || (!(p.j(this.wjG.uOf.getUsername(), z.aTY()) ^ true))) {
          break label250;
        }
        i = 1;
        if (i != 0) {
          paramContextMenu.add(0, a.dGi(), 1, 2131755806);
        }
        paramView = this.wjG.uOf;
        j = k;
        if (!p.j(z.aUg(), paramView.getUsername()))
        {
          if (!p.j(z.aTY(), paramView.getUsername())) {
            break label256;
          }
          j = k;
        }
        label132:
        if (j == 0)
        {
          paramView = y.vXH;
          if (!y.In(this.tug)) {}
        }
        else
        {
          paramContextMenu.add(0, a.dGj(), 2, 2131755778);
        }
        if (i != 0)
        {
          paramView = y.vXH;
          if (y.In(this.tug))
          {
            if (!this.wjG.uOf.dyk()) {
              break label262;
            }
            paramView = c.vCb;
            if (c.drU()) {
              paramContextMenu.add(0, a.dGk(), 3, 2131759530);
            }
          }
        }
      }
      for (;;)
      {
        if (BuildInfo.DEBUG) {
          paramContextMenu.add(0, a.dGl(), 4, (CharSequence)"debug");
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
        paramContextMenu.add(0, a.dGk(), 3, 2131759530);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/CommentMenu$MenuItemSelectListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "exposeScene", "", "commentDelCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "comment", "", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;ILkotlin/jvm/functions/Function1;)V", "getCommentDelCallback", "()Lkotlin/jvm/functions/Function1;", "setCommentDelCallback", "(Lkotlin/jvm/functions/Function1;)V", "getCommentItem", "()Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "setCommentItem", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;)V", "getExposeScene", "()I", "setExposeScene", "(I)V", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", "index", "plugin-finder_release"})
  public static final class d
    implements o.g
  {
    private int tMM;
    private s wjG;
    private b<? super s, x> wjI;
    
    public d(s params, int paramInt, b<? super s, x> paramb)
    {
      AppMethodBeat.i(254618);
      this.wjG = params;
      this.tMM = paramInt;
      this.wjI = paramb;
      AppMethodBeat.o(254618);
    }
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(168215);
      if (paramMenuItem != null)
      {
        paramInt = paramMenuItem.getItemId();
        if (paramInt == a.dGh())
        {
          if (!Util.isNullOrNil(this.wjG.uOf.getContent()))
          {
            ClipboardHelper.setText((CharSequence)this.wjG.uOf.getContent());
            Toast.makeText(MMApplicationContext.getContext(), 2131755773, 0).show();
            paramMenuItem = ao.UpX;
            ao.bc(5, this.wjG.uOf.dyb().commentId);
            AppMethodBeat.o(168215);
          }
        }
        else
        {
          if (paramInt == a.dGj())
          {
            paramMenuItem = this.wjI;
            if (paramMenuItem != null) {
              paramMenuItem.invoke(this.wjG);
            }
            paramMenuItem = ao.UpX;
            ao.bc(4, this.wjG.uOf.dyb().commentId);
            AppMethodBeat.o(168215);
            return;
          }
          if (paramInt == a.dGi())
          {
            paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.a.tUv;
            paramMenuItem = MMApplicationContext.getContext();
            p.g(paramMenuItem, "MMApplicationContext.getContext()");
            com.tencent.mm.plugin.finder.feed.logic.a.a(paramMenuItem, this.wjG.uOf.field_feedId, this.wjG.uOf.dyb().commentId, this.tMM);
            paramMenuItem = ao.UpX;
            ao.bc(6, this.wjG.uOf.dyb().commentId);
            AppMethodBeat.o(168215);
            return;
          }
          if (paramInt == a.dGk())
          {
            paramMenuItem = k.vfA;
            paramMenuItem = MMApplicationContext.getContext();
            p.g(paramMenuItem, "MMApplicationContext.getContext()");
            k.b(paramMenuItem, 11L, 4L);
            ((t)g.af(t.class)).a(this.wjG.lT(), this.wjG.uOf.field_feedId, this.wjG.uOf.getObjectNonceId(), (ai)new a());
            AppMethodBeat.o(168215);
            return;
          }
          if (paramInt == a.dGl())
          {
            paramMenuItem = this.wjG;
            if (paramMenuItem == null) {
              break label358;
            }
            paramMenuItem = paramMenuItem.uOf;
            if (paramMenuItem == null) {
              break label358;
            }
          }
        }
      }
      label358:
      for (paramMenuItem = paramMenuItem.toString();; paramMenuItem = null)
      {
        ClipboardHelper.setText((CharSequence)paramMenuItem);
        AppMethodBeat.o(168215);
        return;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/CommentMenu$MenuItemSelectListener$onMMMenuItemSelected$1$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
    public static final class a
      implements ai<ayt>
    {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.a
 * JD-Core Version:    0.7.0.1
 */