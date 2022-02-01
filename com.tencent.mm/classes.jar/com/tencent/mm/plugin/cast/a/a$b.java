package com.tencent.mm.plugin.cast.a;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class a$b
  implements View.OnClickListener
{
  public static final b tIK;
  
  static
  {
    AppMethodBeat.i(190379);
    tIK = new b();
    AppMethodBeat.o(190379);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(190376);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/cast/banner/ScreenCastBanner$initialize$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = new Intent();
    c.b(MMApplicationContext.getContext(), "cast", ".ui.ScreenCastActivity", paramView);
    a.a(this, "com/tencent/mm/plugin/cast/banner/ScreenCastBanner$initialize$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(190376);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.a.a.b
 * JD-Core Version:    0.7.0.1
 */