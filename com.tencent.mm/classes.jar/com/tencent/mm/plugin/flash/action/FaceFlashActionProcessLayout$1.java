package com.tencent.mm.plugin.flash.action;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

final class FaceFlashActionProcessLayout$1
  implements View.OnClickListener
{
  FaceFlashActionProcessLayout$1(FaceFlashActionProcessLayout paramFaceFlashActionProcessLayout, JSONObject paramJSONObject) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(264728);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/flash/action/FaceFlashActionProcessLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.i(FaceFlashActionProcessLayout.access$000(), "click customBtn");
    try
    {
      this.HhV.put("click_other_verify_btn", "yes");
      FaceFlashActionProcessLayout.a(this.HiO).bg(this.HhV);
      if (com.tencent.mm.plugin.flash.d.a.bi(this.HhV)) {
        h.OAn.b(23269, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1) });
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/flash/action/FaceFlashActionProcessLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(264728);
      return;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        Log.printErrStackTrace(FaceFlashActionProcessLayout.access$200(), paramView, "face start feedback webview exception", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.action.FaceFlashActionProcessLayout.1
 * JD-Core Version:    0.7.0.1
 */