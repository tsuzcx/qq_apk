package com.tencent.mm.plugin.flash;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.base.aa;

final class FaceFlashProcessLayout$1
  implements View.OnLongClickListener
{
  FaceFlashProcessLayout$1(FaceFlashProcessLayout paramFaceFlashProcessLayout) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(264606);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/flash/FaceFlashProcessLayout$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
    MultiProcessMMKV.getMMKV("face-flash").encode("show-dialog", 0L);
    aa.makeText(this.HhU.getContext(), "ok", 1).show();
    a.a(true, this, "com/tencent/mm/plugin/flash/FaceFlashProcessLayout$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(264606);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.FaceFlashProcessLayout.1
 * JD-Core Version:    0.7.0.1
 */