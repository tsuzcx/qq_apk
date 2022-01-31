package com.tencent.mm.plugin.emojicapture.ui.capture;

import a.l;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureBeautySettingUI;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class CaptureContainer$7
  implements View.OnClickListener
{
  CaptureContainer$7(Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(2959);
    paramView = new Intent(this.hEq, EmojiCaptureBeautySettingUI.class);
    this.hEq.startActivity(paramView);
    AppMethodBeat.o(2959);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer.7
 * JD-Core Version:    0.7.0.1
 */