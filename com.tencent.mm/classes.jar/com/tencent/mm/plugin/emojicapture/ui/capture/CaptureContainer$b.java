package com.tencent.mm.plugin.emojicapture.ui.capture;

import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.tencent.mm.plugin.emojicapture.c.a.a;
import com.tencent.mm.plugin.emojicapture.model.c;
import com.tencent.mm.plugin.emojicapture.model.c.a;
import com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar.a;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.b;
import com.tencent.mm.sdk.platformtools.y;

public final class CaptureContainer$b
  implements MMSightRecordButton.b
{
  public final void aKO()
  {
    y.i(CaptureContainer.a(this.jpm), "onLongPressFinish");
    CaptureContainer.a(this.jpm, this.jpm.getPresenter().uh());
  }
  
  public final void aKP()
  {
    MMSightRecordButton localMMSightRecordButton = CaptureContainer.b(this.jpm);
    c.a locala = c.jko;
    localMMSightRecordButton.a(c.aKc() * 1000, (MMSightCircularProgressBar.a)new CaptureContainer.b.a(this));
    this.jpm.getPresenter().startRecord();
    CaptureContainer.c(this.jpm).setEnabled(false);
    CaptureContainer.c(this.jpm).animate().alpha(0.0F).start();
    CaptureContainer.d(this.jpm).setEnabled(false);
    CaptureContainer.d(this.jpm).animate().alpha(0.0F).start();
    CaptureContainer.e(this.jpm).animate().alpha(0.0F).start();
    CaptureContainer.f(this.jpm).setVisibility(8);
  }
  
  public final void aKQ()
  {
    y.i(CaptureContainer.a(this.jpm), "onPressDown");
    int[] arrayOfInt = new int[2];
    CaptureContainer.b(this.jpm).getLocationOnScreen(arrayOfInt);
    this.jpm.getPresenter().qg(arrayOfInt[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer.b
 * JD-Core Version:    0.7.0.1
 */