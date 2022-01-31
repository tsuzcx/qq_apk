package com.tencent.mm.plugin.emojicapture.ui.capture;

import a.f.a.b;
import a.l;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.c.a.a;
import com.tencent.mm.plugin.emojicapture.model.c;
import com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar.a;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.b;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$1", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton$LongPressCallback;", "onLongPress", "", "onLongPressFinish", "onPressDown", "plugin-emojicapture_release"})
public final class CaptureContainer$1
  implements MMSightRecordButton.b
{
  public final void boX()
  {
    AppMethodBeat.i(2947);
    ab.i(CaptureContainer.e(this.lyp), "onLongPressFinish");
    CaptureContainer.a(this.lyp, this.lyp.c((b)new CaptureContainer.1.b(this)));
    AppMethodBeat.o(2947);
  }
  
  public final void boY()
  {
    AppMethodBeat.i(2949);
    ab.i(CaptureContainer.e(this.lyp), "onPressDown");
    int[] arrayOfInt = new int[2];
    CaptureContainer.f(this.lyp).getLocationOnScreen(arrayOfInt);
    CaptureContainer.c(this.lyp).kk(arrayOfInt[1]);
    AppMethodBeat.o(2949);
  }
  
  public final void hH()
  {
    AppMethodBeat.i(2948);
    Object localObject1 = CaptureContainer.f(this.lyp);
    Object localObject2 = c.ltu;
    ((MMSightRecordButton)localObject1).a(c.bnO() * 1000, com.tencent.mm.plugin.emojicapture.ui.a.dk(this.lyp), (MMSightCircularProgressBar.a)new CaptureContainer.1.a(this));
    localObject1 = this.lyp;
    localObject2 = ((CaptureContainer)localObject1).lyl;
    if (localObject2 != null) {
      ((a.a)localObject2).aCJ();
    }
    if (!com.tencent.mm.media.widget.camerarecordview.a.a(((CaptureContainer)localObject1).lyn)) {
      EmojiCaptureReporter.uB(33);
    }
    CaptureContainer.g(this.lyp).setEnabled(false);
    CaptureContainer.g(this.lyp).animate().alpha(0.0F).start();
    CaptureContainer.a(this.lyp, false, 0);
    CaptureContainer.b(this.lyp).setVisibility(8);
    CaptureContainer.d(this.lyp).setShow(false);
    AppMethodBeat.o(2948);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer.1
 * JD-Core Version:    0.7.0.1
 */