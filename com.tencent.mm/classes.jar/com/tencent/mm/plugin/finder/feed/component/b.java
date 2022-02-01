package com.tencent.mm.plugin.finder.feed.component;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.s;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.aze;
import com.tencent.mm.ui.base.u.b;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/component/StickyFeedComponent;", "", "()V", "MMFinder_ModSticky_Err_Private_NotAllow_Sticky", "", "getMMFinder_ModSticky_Err_Private_NotAllow_Sticky", "()I", "MMFinder_ModSticky_Err_Sticky_Num_Limit", "getMMFinder_ModSticky_Err_Sticky_Num_Limit", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModProfileStickySetting;", "getCallback", "()Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "requesting", "", "getRequesting", "()Z", "setRequesting", "(Z)V", "succCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "req", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "ret", "", "getSuccCallback", "()Lkotlin/jvm/functions/Function2;", "setSuccCallback", "(Lkotlin/jvm/functions/Function2;)V", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "addStickyMenuItem", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "context", "Landroid/content/Context;", "CANCEL_STICKY_ID", "STICKY_ID", "ifSticky", "makeFeedSticky", "feedId", "", "sticky", "nonceId", "", "plugin-finder_release"})
public final class b
{
  final int tUm;
  final int tUn;
  private final ai<aze> tUo;
  m<? super aze, ? super apg, x> tUp;
  boolean tUq;
  Dialog tipDialog;
  
  public b()
  {
    AppMethodBeat.i(244530);
    this.tUm = -4051;
    this.tUn = -4053;
    this.tUo = ((ai)new a(this));
    AppMethodBeat.o(244530);
  }
  
  public final void a(final Context paramContext, long paramLong, boolean paramBoolean, String paramString, m<? super aze, ? super apg, x> paramm)
  {
    int i = 1;
    AppMethodBeat.i(244529);
    p.h(paramContext, "context");
    p.h(paramString, "nonceId");
    p.h(paramm, "succCallback");
    this.tUp = paramm;
    this.tUq = true;
    d.a(500L, (a)new b(this, paramContext));
    paramContext = (s)g.af(s.class);
    if (paramBoolean) {
      i = 0;
    }
    paramContext.a(paramLong, i, paramString, this.tUo);
    AppMethodBeat.o(244529);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/component/StickyFeedComponent$callback$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModProfileStickySetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class a
    implements ai<aze>
  {
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
    static final class a
      implements u.b
    {
      public static final a tUs;
      
      static
      {
        AppMethodBeat.i(244525);
        tUs = new a();
        AppMethodBeat.o(244525);
      }
      
      public final void dU(View paramView)
      {
        AppMethodBeat.i(244524);
        if (paramView != null)
        {
          paramView = (TextView)paramView.findViewById(2131309260);
          if (paramView != null)
          {
            paramView.setTextSize(1, 14.0F);
            AppMethodBeat.o(244524);
            return;
          }
        }
        AppMethodBeat.o(244524);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    b(b paramb, Context paramContext)
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class a
      implements DialogInterface.OnCancelListener
    {
      public static final a tUt;
      
      static
      {
        AppMethodBeat.i(244527);
        tUt = new a();
        AppMethodBeat.o(244527);
      }
      
      public final void onCancel(DialogInterface paramDialogInterface) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.component.b
 * JD-Core Version:    0.7.0.1
 */