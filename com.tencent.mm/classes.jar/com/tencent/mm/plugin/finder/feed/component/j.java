package com.tencent.mm.plugin.finder.feed.component;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.service.o;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.protocal.protobuf.aux;
import com.tencent.mm.protocal.protobuf.bqb;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/component/StickyFeedComponent;", "", "()V", "MMFinder_ModSticky_Err_Private_NotAllow_Sticky", "", "getMMFinder_ModSticky_Err_Private_NotAllow_Sticky", "()I", "MMFinder_ModSticky_Err_Sticky_Num_Limit", "getMMFinder_ModSticky_Err_Sticky_Num_Limit", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModProfileStickySetting;", "getCallback", "()Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "requesting", "", "getRequesting", "()Z", "setRequesting", "(Z)V", "succCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "req", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "ret", "", "getSuccCallback", "()Lkotlin/jvm/functions/Function2;", "setSuccCallback", "(Lkotlin/jvm/functions/Function2;)V", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "addStickyMenuItem", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "context", "Landroid/content/Context;", "CANCEL_STICKY_ID", "STICKY_ID", "ifSticky", "makeFeedSticky", "feedId", "", "sticky", "nonceId", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  final int Bcv;
  final int Bcw;
  private final ck<bqb> Bcx;
  m<? super bqb, ? super aux, ah> Bcy;
  boolean Bcz;
  Dialog tipDialog;
  
  public j()
  {
    AppMethodBeat.i(364046);
    this.Bcv = -4051;
    this.Bcw = -4053;
    this.Bcx = ((ck)new a(this));
    AppMethodBeat.o(364046);
  }
  
  public final void a(final Context paramContext, long paramLong, boolean paramBoolean, String paramString, m<? super bqb, ? super aux, ah> paramm)
  {
    int i = 1;
    AppMethodBeat.i(364053);
    s.u(paramContext, "context");
    s.u(paramString, "nonceId");
    s.u(paramm, "succCallback");
    this.Bcy = paramm;
    this.Bcz = true;
    d.a(500L, (a)new b(this, paramContext));
    paramContext = (o)h.ax(o.class);
    if (paramBoolean) {
      i = 0;
    }
    paramContext.a(paramLong, i, paramString, this.Bcx);
    AppMethodBeat.o(364053);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/component/StickyFeedComponent$callback$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModProfileStickySetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements ck<bqb>
  {
    a(j paramj) {}
    
    private static final void fG(View paramView)
    {
      AppMethodBeat.i(364017);
      if (paramView != null)
      {
        paramView = (TextView)paramView.findViewById(e.e.toast_text);
        if (paramView != null) {
          paramView.setTextSize(1, 14.0F);
        }
      }
      AppMethodBeat.o(364017);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    b(j paramj, Context paramContext)
    {
      super();
    }
    
    private static final void k(DialogInterface paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.component.j
 * JD-Core Version:    0.7.0.1
 */