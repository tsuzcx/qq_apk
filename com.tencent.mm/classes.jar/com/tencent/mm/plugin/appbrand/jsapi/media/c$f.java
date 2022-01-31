package com.tencent.mm.plugin.appbrand.jsapi.media;

import a.l;
import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult$CANCELED;", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Boolean;)Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult$CANCELED;"})
final class c$f<_Ret, _Var>
  implements a<_Ret, _Var>
{
  c$f(c paramc) {}
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/View;", "<anonymous parameter 2>", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu", "com/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaWorkFlow$startChoose$2$2$2"})
  static final class b
    implements View.OnCreateContextMenuListener
  {
    b(c.f paramf, b paramb) {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(143798);
      paramContextMenu.add(0, 1, 0, (CharSequence)c.a(this.hQv.hQs).getContext().getString(2131296938));
      paramContextMenu.add(0, 2, 1, (CharSequence)c.a(this.hQv.hQs).getContext().getString(2131296945));
      AppMethodBeat.o(143798);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.c.f
 * JD-Core Version:    0.7.0.1
 */