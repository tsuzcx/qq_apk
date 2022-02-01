package com.tencent.mm.plugin.finder.view;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.logic.a;
import com.tencent.mm.plugin.finder.model.t;
import com.tencent.mm.plugin.finder.service.p;
import com.tencent.mm.plugin.finder.storage.au;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.utils.ak;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.bpp;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/CommentMenu;", "", "()V", "BottomSheetMenuListener", "Companion", "MenuItemCreateListener", "MenuItemSelectListener", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final int FZF = 0;
  private static final int FZG;
  private static final int FZH;
  private static final int FZI;
  private static final int FZJ;
  public static final b GwC;
  
  static
  {
    AppMethodBeat.i(178469);
    GwC = new b((byte)0);
    FZG = 1;
    FZH = 2;
    FZI = 3;
    FZJ = 999;
    AppMethodBeat.o(178469);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/CommentMenu$BottomSheetMenuListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "feedUsername", "", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;Ljava/lang/String;)V", "getFeedUsername", "()Ljava/lang/String;", "onCreateMMMenu", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements u.g
  {
    private final String AAT;
    private t GwD;
    
    public a(t paramt, String paramString)
    {
      AppMethodBeat.i(345904);
      this.GwD = paramt;
      this.AAT = paramString;
      AppMethodBeat.o(345904);
    }
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.s params)
    {
      AppMethodBeat.i(345915);
      kotlin.g.b.s.u(params, "menu");
      Object localObject = av.GiL;
      if (av.Iz(this.AAT))
      {
        params.oh(b.fdo(), e.h.app_copy);
        if ((!kotlin.g.b.s.p(this.GwD.ECu.getUsername(), com.tencent.mm.model.z.bAW())) && (!kotlin.g.b.s.p(this.GwD.ECu.getUsername(), com.tencent.mm.model.z.bAM()))) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            params.oh(b.fdp(), e.h.app_expose);
          }
          params.oh(b.fdq(), e.h.app_delete);
          if (i == 0) {
            break label176;
          }
          localObject = av.GiL;
          if (!av.Iz(this.AAT)) {
            break label176;
          }
          if (!this.GwD.ECu.eZQ()) {
            break;
          }
          localObject = d.FAy;
          if (!d.eRz()) {
            break label176;
          }
          params.oh(b.fdr(), e.h.finder_add_comment_to_banlist);
          AppMethodBeat.o(345915);
          return;
        }
        params.oh(b.fdr(), e.h.finder_add_comment_to_banlist);
      }
      label176:
      AppMethodBeat.o(345915);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/CommentMenu$Companion;", "", "()V", "MENU_BAN", "", "MENU_COPY", "MENU_DEBUG", "MENU_DEL", "MENU_EXPOSE", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/CommentMenu$MenuItemCreateListener;", "Landroid/view/View$OnCreateContextMenuListener;", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "feedUsername", "", "isFinderScene", "", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;Ljava/lang/String;Z)V", "getFeedUsername", "()Ljava/lang/String;", "()Z", "onCreateContextMenu", "", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements View.OnCreateContextMenuListener
  {
    private final String AAT;
    private final boolean FZL;
    private t GwD;
    
    public c(t paramt, String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(168213);
      this.GwD = paramt;
      this.AAT = paramString;
      this.FZL = paramBoolean;
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
        paramContextMenu.add(0, b.fdo(), 0, e.h.app_copy);
        if ((kotlin.g.b.s.p(this.GwD.ECu.getUsername(), com.tencent.mm.model.z.bAW())) || (kotlin.g.b.s.p(this.GwD.ECu.getUsername(), com.tencent.mm.model.z.bAM()))) {
          break label250;
        }
        i = 1;
        if (i != 0) {
          paramContextMenu.add(0, b.fdp(), 1, e.h.app_expose);
        }
        paramView = this.GwD.ECu;
        j = k;
        if (!kotlin.g.b.s.p(com.tencent.mm.model.z.bAW(), paramView.getUsername()))
        {
          if (!kotlin.g.b.s.p(com.tencent.mm.model.z.bAM(), paramView.getUsername())) {
            break label256;
          }
          j = k;
        }
        label130:
        if (j == 0)
        {
          paramView = av.GiL;
          if (!av.Iz(this.AAT)) {}
        }
        else
        {
          paramContextMenu.add(0, b.fdq(), 2, e.h.app_delete);
        }
        if (i != 0)
        {
          paramView = av.GiL;
          if (av.Iz(this.AAT))
          {
            if (!this.GwD.ECu.eZQ()) {
              break label262;
            }
            paramView = d.FAy;
            if (d.eRz()) {
              paramContextMenu.add(0, b.fdr(), 3, e.h.finder_add_comment_to_banlist);
            }
          }
        }
      }
      for (;;)
      {
        if (BuildInfo.DEBUG) {
          paramContextMenu.add(0, b.fds(), 4, (CharSequence)"debug");
        }
        AppMethodBeat.o(168212);
        return;
        label250:
        i = 0;
        break;
        label256:
        j = 0;
        break label130;
        label262:
        paramContextMenu.add(0, b.fdr(), 3, e.h.finder_add_comment_to_banlist);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/CommentMenu$MenuItemSelectListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "exposeScene", "", "commentDelCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "comment", "", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;ILkotlin/jvm/functions/Function1;)V", "getCommentDelCallback", "()Lkotlin/jvm/functions/Function1;", "setCommentDelCallback", "(Lkotlin/jvm/functions/Function1;)V", "getCommentItem", "()Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "setCommentItem", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;)V", "getExposeScene", "()I", "setExposeScene", "(I)V", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", "index", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements u.i
  {
    private int AUh;
    private kotlin.g.a.b<? super t, ah> FZM;
    private t GwD;
    
    public d(t paramt, int paramInt, kotlin.g.a.b<? super t, ah> paramb)
    {
      AppMethodBeat.i(345424);
      this.GwD = paramt;
      this.AUh = paramInt;
      this.FZM = paramb;
      AppMethodBeat.o(345424);
    }
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      Object localObject = null;
      AppMethodBeat.i(168215);
      if (paramMenuItem != null)
      {
        paramInt = paramMenuItem.getItemId();
        if (paramInt == b.fdo())
        {
          if (!Util.isNullOrNil(this.GwD.ECu.getContent()))
          {
            ClipboardHelper.setText((CharSequence)this.GwD.ECu.getContent());
            Toast.makeText(MMApplicationContext.getContext(), e.h.app_copy_ok, 0).show();
            paramMenuItem = ak.GhA;
            ak.av(5, this.GwD.ECu.eZI().commentId);
            AppMethodBeat.o(168215);
          }
        }
        else
        {
          if (paramInt == b.fdq())
          {
            paramMenuItem = this.FZM;
            if (paramMenuItem != null) {
              paramMenuItem.invoke(this.GwD);
            }
            paramMenuItem = ak.GhA;
            ak.av(4, this.GwD.ECu.eZI().commentId);
            AppMethodBeat.o(168215);
            return;
          }
          if (paramInt == b.fdp())
          {
            paramMenuItem = a.Bem;
            paramMenuItem = MMApplicationContext.getContext();
            kotlin.g.b.s.s(paramMenuItem, "getContext()");
            a.a(paramMenuItem, this.GwD.ECu.field_feedId, this.GwD.ECu.eZI().commentId, this.AUh, 0, 16);
            paramMenuItem = ak.GhA;
            ak.av(6, this.GwD.ECu.eZI().commentId);
            AppMethodBeat.o(168215);
            return;
          }
          if (paramInt == b.fdr())
          {
            paramMenuItem = com.tencent.mm.plugin.finder.report.z.FrZ;
            paramMenuItem = MMApplicationContext.getContext();
            kotlin.g.b.s.s(paramMenuItem, "getContext()");
            com.tencent.mm.plugin.finder.report.z.b(paramMenuItem, 11L, 4L);
            ((p)h.ax(p.class)).a(this.GwD.bZA(), this.GwD.ECu.field_feedId, this.GwD.ECu.getObjectNonceId(), (ck)new a());
            AppMethodBeat.o(168215);
            return;
          }
          if (paramInt == b.fds())
          {
            paramMenuItem = this.GwD;
            if (paramMenuItem != null) {
              break label352;
            }
            paramMenuItem = localObject;
          }
        }
      }
      for (;;)
      {
        ClipboardHelper.setText((CharSequence)paramMenuItem);
        AppMethodBeat.o(168215);
        return;
        label352:
        au localau = paramMenuItem.ECu;
        paramMenuItem = localObject;
        if (localau != null) {
          paramMenuItem = localau.toString();
        }
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/CommentMenu$MenuItemSelectListener$onMMMenuItemSelected$1$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements ck<bpp>
    {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.b
 * JD-Core Version:    0.7.0.1
 */