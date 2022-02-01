package com.tencent.mm.plugin.finder.uniComments;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.service.p;
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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/UniCommentMenu;", "", "()V", "BottomSheetMenuListener", "Companion", "MenuItemCreateListener", "MenuItemSelectListener", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final b FZE;
  private static final int FZF = 0;
  private static final int FZG;
  private static final int FZH;
  private static final int FZI;
  private static final int FZJ;
  
  static
  {
    AppMethodBeat.i(341424);
    FZE = new b((byte)0);
    FZG = 1;
    FZH = 2;
    FZI = 3;
    FZJ = 999;
    AppMethodBeat.o(341424);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/UniCommentMenu$BottomSheetMenuListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "commentItem", "Lcom/tencent/mm/plugin/finder/uniComments/storge/UniFeedComment;", "feedUsername", "", "(Lcom/tencent/mm/plugin/finder/uniComments/storge/UniFeedComment;Ljava/lang/String;)V", "getFeedUsername", "()Ljava/lang/String;", "onCreateMMMenu", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements u.g
  {
    private final String AAT;
    private com.tencent.mm.plugin.finder.uniComments.storge.d FZK;
    
    public a(com.tencent.mm.plugin.finder.uniComments.storge.d paramd, String paramString)
    {
      AppMethodBeat.i(341522);
      this.FZK = paramd;
      this.AAT = paramString;
      AppMethodBeat.o(341522);
    }
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.s params)
    {
      AppMethodBeat.i(341533);
      kotlin.g.b.s.u(params, "menu");
      Object localObject = av.GiL;
      if (av.Iz(this.AAT))
      {
        params.oh(h.fdo(), e.h.app_copy);
        if ((!kotlin.g.b.s.p(this.FZK.Gbp.getUsername(), z.bAW())) && (!kotlin.g.b.s.p(this.FZK.Gbp.getUsername(), z.bAM()))) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            params.oh(h.fdp(), e.h.app_expose);
          }
          params.oh(h.fdq(), e.h.app_delete);
          if (i == 0) {
            break label176;
          }
          localObject = av.GiL;
          if (!av.Iz(this.AAT)) {
            break label176;
          }
          if (!this.FZK.Gbp.eZQ()) {
            break;
          }
          localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (!com.tencent.mm.plugin.finder.storage.d.eRz()) {
            break label176;
          }
          params.oh(h.fdr(), e.h.finder_add_comment_to_banlist);
          AppMethodBeat.o(341533);
          return;
        }
        params.oh(h.fdr(), e.h.finder_add_comment_to_banlist);
      }
      label176:
      AppMethodBeat.o(341533);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/UniCommentMenu$Companion;", "", "()V", "MENU_BAN", "", "MENU_COPY", "MENU_DEBUG", "MENU_DEL", "MENU_EXPOSE", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/UniCommentMenu$MenuItemCreateListener;", "Landroid/view/View$OnCreateContextMenuListener;", "commentItem", "Lcom/tencent/mm/plugin/finder/uniComments/storge/UniFeedComment;", "feedUsername", "", "isFinderScene", "", "(Lcom/tencent/mm/plugin/finder/uniComments/storge/UniFeedComment;Ljava/lang/String;Z)V", "getFeedUsername", "()Ljava/lang/String;", "()Z", "onCreateContextMenu", "", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements View.OnCreateContextMenuListener
  {
    private final String AAT;
    private com.tencent.mm.plugin.finder.uniComments.storge.d FZK;
    private final boolean FZL;
    
    public c(com.tencent.mm.plugin.finder.uniComments.storge.d paramd, String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(341548);
      this.FZK = paramd;
      this.AAT = paramString;
      this.FZL = paramBoolean;
      AppMethodBeat.o(341548);
    }
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      int k = 1;
      AppMethodBeat.i(341558);
      int i;
      int j;
      if (paramContextMenu != null)
      {
        paramContextMenu.add(0, h.fdo(), 0, e.h.app_copy);
        if ((kotlin.g.b.s.p(this.FZK.Gbp.getUsername(), z.bAW())) || (kotlin.g.b.s.p(this.FZK.Gbp.getUsername(), z.bAM()))) {
          break label250;
        }
        i = 1;
        if (i != 0) {
          paramContextMenu.add(0, h.fdp(), 1, e.h.app_expose);
        }
        paramView = this.FZK.Gbp;
        j = k;
        if (!kotlin.g.b.s.p(z.bAW(), paramView.getUsername()))
        {
          if (!kotlin.g.b.s.p(z.bAM(), paramView.getUsername())) {
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
          paramContextMenu.add(0, h.fdq(), 2, e.h.app_delete);
        }
        if (i != 0)
        {
          paramView = av.GiL;
          if (av.Iz(this.AAT))
          {
            if (!this.FZK.Gbp.eZQ()) {
              break label262;
            }
            paramView = com.tencent.mm.plugin.finder.storage.d.FAy;
            if (com.tencent.mm.plugin.finder.storage.d.eRz()) {
              paramContextMenu.add(0, h.fdr(), 3, e.h.finder_add_comment_to_banlist);
            }
          }
        }
      }
      for (;;)
      {
        if (BuildInfo.DEBUG) {
          paramContextMenu.add(0, h.fds(), 4, (CharSequence)"debug");
        }
        AppMethodBeat.o(341558);
        return;
        label250:
        i = 0;
        break;
        label256:
        j = 0;
        break label130;
        label262:
        paramContextMenu.add(0, h.fdr(), 3, e.h.finder_add_comment_to_banlist);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/UniCommentMenu$MenuItemSelectListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "commentItem", "Lcom/tencent/mm/plugin/finder/uniComments/storge/UniFeedComment;", "exposeScene", "", "commentDelCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "comment", "", "(Lcom/tencent/mm/plugin/finder/uniComments/storge/UniFeedComment;ILkotlin/jvm/functions/Function1;)V", "getCommentDelCallback", "()Lkotlin/jvm/functions/Function1;", "setCommentDelCallback", "(Lkotlin/jvm/functions/Function1;)V", "getCommentItem", "()Lcom/tencent/mm/plugin/finder/uniComments/storge/UniFeedComment;", "setCommentItem", "(Lcom/tencent/mm/plugin/finder/uniComments/storge/UniFeedComment;)V", "getExposeScene", "()I", "setExposeScene", "(I)V", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", "index", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements u.i
  {
    private int AUh;
    private com.tencent.mm.plugin.finder.uniComments.storge.d FZK;
    private kotlin.g.a.b<? super com.tencent.mm.plugin.finder.uniComments.storge.d, ah> FZM;
    
    public d(com.tencent.mm.plugin.finder.uniComments.storge.d paramd, int paramInt, kotlin.g.a.b<? super com.tencent.mm.plugin.finder.uniComments.storge.d, ah> paramb)
    {
      AppMethodBeat.i(341543);
      this.FZK = paramd;
      this.AUh = paramInt;
      this.FZM = paramb;
      AppMethodBeat.o(341543);
    }
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      String str = null;
      AppMethodBeat.i(341555);
      Object localObject;
      if (paramMenuItem != null)
      {
        paramInt = paramMenuItem.getItemId();
        if (paramInt == h.fdo())
        {
          if (!Util.isNullOrNil(this.FZK.Gbp.getContent()))
          {
            ClipboardHelper.setText((CharSequence)this.FZK.Gbp.getContent());
            Toast.makeText(MMApplicationContext.getContext(), e.h.app_copy_ok, 0).show();
            AppMethodBeat.o(341555);
          }
        }
        else if (paramInt == h.fdq())
        {
          paramMenuItem = this.FZM;
          if (paramMenuItem != null)
          {
            paramMenuItem.invoke(this.FZK);
            AppMethodBeat.o(341555);
          }
        }
        else
        {
          if (paramInt == h.fdp())
          {
            paramMenuItem = com.tencent.mm.plugin.finder.uniComments.logic.b.GaN;
            paramMenuItem = MMApplicationContext.getContext();
            kotlin.g.b.s.s(paramMenuItem, "getContext()");
            com.tencent.mm.plugin.finder.uniComments.logic.b.c(paramMenuItem, this.FZK.Gbp.field_feedId, this.FZK.Gbp.eZI().commentId);
            AppMethodBeat.o(341555);
            return;
          }
          if (paramInt == h.fdr())
          {
            localObject = (p)com.tencent.mm.kernel.h.ax(p.class);
            long l1 = this.FZK.Gbp.eZI().commentId;
            long l2 = this.FZK.Gbp.field_feedId;
            str = this.FZK.Gbp.field_objectNonceId;
            paramMenuItem = str;
            if (str == null) {
              paramMenuItem = "";
            }
            ((p)localObject).a(l1, l2, paramMenuItem, (ck)new a());
            AppMethodBeat.o(341555);
            return;
          }
          if (paramInt == h.fds())
          {
            paramMenuItem = this.FZK;
            if (paramMenuItem != null) {
              break label289;
            }
            paramMenuItem = str;
          }
        }
      }
      for (;;)
      {
        ClipboardHelper.setText((CharSequence)paramMenuItem);
        AppMethodBeat.o(341555);
        return;
        label289:
        localObject = paramMenuItem.Gbp;
        paramMenuItem = str;
        if (localObject != null) {
          paramMenuItem = ((com.tencent.mm.plugin.finder.uniComments.storge.b)localObject).toString();
        }
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/uniComments/UniCommentMenu$MenuItemSelectListener$onMMMenuItemSelected$1$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements ck<bpp>
    {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.uniComments.h
 * JD-Core Version:    0.7.0.1
 */