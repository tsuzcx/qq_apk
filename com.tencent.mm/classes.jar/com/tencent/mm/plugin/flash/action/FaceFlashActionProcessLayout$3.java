package com.tencent.mm.plugin.flash.action;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

final class FaceFlashActionProcessLayout$3
  implements View.OnClickListener
{
  FaceFlashActionProcessLayout$3(FaceFlashActionProcessLayout paramFaceFlashActionProcessLayout, boolean paramBoolean, JSONObject paramJSONObject, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(264742);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/flash/action/FaceFlashActionProcessLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.i(FaceFlashActionProcessLayout.access$000(), "click retry btn, canRetry：%s", new Object[] { Boolean.valueOf(this.HhX) });
    if (this.HhX) {
      FaceFlashActionProcessLayout.a(this.HiO).reset();
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/flash/action/FaceFlashActionProcessLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(264742);
      return;
      FaceFlashActionProcessLayout.a(this.HiO).bg(this.HhV);
      if (com.tencent.mm.plugin.flash.d.a.bi(this.HhV)) {
        if (!Util.isNullOrNil(this.HiP)) {
          h.OAn.b(23269, new Object[] { Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(1) });
        } else {
          h.OAn.b(23269, new Object[] { Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(0) });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.action.FaceFlashActionProcessLayout.3
 * JD-Core Version:    0.7.0.1
 */