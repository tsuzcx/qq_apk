package com.tencent.mm.plugin.kidswatch.ui.reg;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class KidsWatchRegSuccessUI$c
  implements View.OnClickListener
{
  KidsWatchRegSuccessUI$c(KidsWatchRegSuccessUI paramKidsWatchRegSuccessUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(251387);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegSuccessUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    paramView = af.aaBG;
    paramView = String.format("/pages/home/home.html?scene=register&openid=%s", Arrays.copyOf(new Object[] { KidsWatchRegSuccessUI.b(this.Eda) }, 1));
    p.j(paramView, "java.lang.String.format(format, *args)");
    Log.i("MicroMsg.KidsWatchRegSuccessUI", "goWebUIBtn, path:".concat(String.valueOf(paramView)));
    localObject = com.tencent.mm.plugin.kidswatch.b.a.Edb;
    localObject = this.Eda.getContext();
    p.j(localObject, "context");
    com.tencent.mm.plugin.kidswatch.b.a.h((Context)localObject, "", true);
    localObject = com.tencent.mm.plugin.kidswatch.b.a.Edb;
    localObject = this.Eda.getContext();
    p.j(localObject, "context");
    com.tencent.mm.plugin.kidswatch.b.a.g((Context)localObject, "wxaaff6b96fc2cd3c6", paramView, "2");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/kidswatch/ui/reg/KidsWatchRegSuccessUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(251387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.reg.KidsWatchRegSuccessUI.c
 * JD-Core Version:    0.7.0.1
 */