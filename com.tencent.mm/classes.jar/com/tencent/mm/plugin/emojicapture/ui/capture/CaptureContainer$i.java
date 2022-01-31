package com.tencent.mm.plugin.emojicapture.ui.capture;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureBeautySettingUI;

final class CaptureContainer$i
  implements View.OnClickListener
{
  CaptureContainer$i(CaptureContainer paramCaptureContainer) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.jpm.getContext(), EmojiCaptureBeautySettingUI.class);
    this.jpm.getContext().startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer.i
 * JD-Core Version:    0.7.0.1
 */