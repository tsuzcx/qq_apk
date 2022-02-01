package com.tencent.mm.plugin.flash.guide;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import androidx.appcompat.app.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.j;

public final class a
  extends e
{
  public a(Context paramContext)
  {
    super(paramContext, a.j.CustomSheetStyle);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(193618);
    super.onCreate(paramBundle);
    setContentView(a.g.face_flash_reset_tip_dialog);
    getWindow().setLayout(-1, -2);
    getWindow().setGravity(80);
    findViewById(a.e.face_flash_reset_tip_btn).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(195615);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/flash/guide/FaceFlashResetTipDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        a.this.dismiss();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/flash/guide/FaceFlashResetTipDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(195615);
      }
    });
    AppMethodBeat.o(193618);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.guide.a
 * JD-Core Version:    0.7.0.1
 */