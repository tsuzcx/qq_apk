package com.tencent.mm.plugin.emojicapture.ui.capture;

import com.tencent.mm.plugin.emojicapture.c.a.a;
import com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureTextureView;
import com.tencent.mm.plugin.mmsight.ui.CameraFrontSightView;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.a;

public final class CaptureContainer$e
  implements MMSightCaptureTouchView.a
{
  public final void O(float paramFloat1, float paramFloat2)
  {
    this.jpm.getPresenter().b(paramFloat1, paramFloat2, CaptureContainer.g(this.jpm).getWidth(), CaptureContainer.g(this.jpm).getHeight());
    CaptureContainer.h(this.jpm).W(paramFloat1, paramFloat2);
  }
  
  public final void Zh()
  {
    this.jpm.getPresenter().b(true, false, 1);
  }
  
  public final void Zi()
  {
    this.jpm.getPresenter().b(false, false, 1);
  }
  
  public final void aKT()
  {
    this.jpm.getPresenter().aJP();
    this.jpm.getPresenter().aJO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer.e
 * JD-Core Version:    0.7.0.1
 */