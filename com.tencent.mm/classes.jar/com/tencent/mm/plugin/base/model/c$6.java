package com.tencent.mm.plugin.base.model;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class c$6
  implements View.OnClickListener
{
  c$6(Context paramContext, String paramString, boolean paramBoolean) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(151459);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/base/model/ShortcutUtil$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    c.a(this.val$context, false, this.tkb, this.etl, this.vqY);
    a.a(this, "com/tencent/mm/plugin/base/model/ShortcutUtil$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(151459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.base.model.c.6
 * JD-Core Version:    0.7.0.1
 */