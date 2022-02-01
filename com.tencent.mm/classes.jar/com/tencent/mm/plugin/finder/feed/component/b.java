package com.tencent.mm.plugin.finder.feed.component;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.service.j;
import com.tencent.mm.plugin.findersdk.a.aj;
import com.tencent.mm.protocal.protobuf.aqu;
import com.tencent.mm.protocal.protobuf.bfa;
import com.tencent.mm.ui.base.w.b;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/component/StickyFeedComponent;", "", "()V", "MMFinder_ModSticky_Err_Private_NotAllow_Sticky", "", "getMMFinder_ModSticky_Err_Private_NotAllow_Sticky", "()I", "MMFinder_ModSticky_Err_Sticky_Num_Limit", "getMMFinder_ModSticky_Err_Sticky_Num_Limit", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModProfileStickySetting;", "getCallback", "()Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "requesting", "", "getRequesting", "()Z", "setRequesting", "(Z)V", "succCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "req", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "ret", "", "getSuccCallback", "()Lkotlin/jvm/functions/Function2;", "setSuccCallback", "(Lkotlin/jvm/functions/Function2;)V", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "addStickyMenuItem", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "context", "Landroid/content/Context;", "CANCEL_STICKY_ID", "STICKY_ID", "ifSticky", "makeFeedSticky", "feedId", "", "sticky", "nonceId", "", "plugin-finder_release"})
public final class b
{
  Dialog tipDialog;
  final int xFh;
  final int xFi;
  private final aj<bfa> xFj;
  m<? super bfa, ? super aqu, x> xFk;
  boolean xFl;
  
  public b()
  {
    AppMethodBeat.i(291018);
    this.xFh = -4051;
    this.xFi = -4053;
    this.xFj = ((aj)new a(this));
    AppMethodBeat.o(291018);
  }
  
  public final void a(final Context paramContext, long paramLong, boolean paramBoolean, String paramString, m<? super bfa, ? super aqu, x> paramm)
  {
    int i = 1;
    AppMethodBeat.i(291017);
    p.k(paramContext, "context");
    p.k(paramString, "nonceId");
    p.k(paramm, "succCallback");
    this.xFk = paramm;
    this.xFl = true;
    d.a(500L, (a)new b(this, paramContext));
    paramContext = (j)h.ae(j.class);
    if (paramBoolean) {
      i = 0;
    }
    paramContext.a(paramLong, i, paramString, this.xFj);
    AppMethodBeat.o(291017);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/component/StickyFeedComponent$callback$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModProfileStickySetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class a
    implements aj<bfa>
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
    static final class a
      implements w.b
    {
      public static final a xFn;
      
      static
      {
        AppMethodBeat.i(282048);
        xFn = new a();
        AppMethodBeat.o(282048);
      }
      
      public final void eu(View paramView)
      {
        AppMethodBeat.i(282047);
        if (paramView != null)
        {
          paramView = (TextView)paramView.findViewById(b.f.toast_text);
          if (paramView != null)
          {
            paramView.setTextSize(1, 14.0F);
            AppMethodBeat.o(282047);
            return;
          }
        }
        AppMethodBeat.o(282047);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    b(b paramb, Context paramContext)
    {
      super();
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class a
      implements DialogInterface.OnCancelListener
    {
      public static final a xFo;
      
      static
      {
        AppMethodBeat.i(286917);
        xFo = new a();
        AppMethodBeat.o(286917);
      }
      
      public final void onCancel(DialogInterface paramDialogInterface) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.component.b
 * JD-Core Version:    0.7.0.1
 */