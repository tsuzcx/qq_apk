package com.tencent.mm.plugin.aa.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.h;

final class LaunchAAUI$34
  implements Runnable
{
  LaunchAAUI$34(LaunchAAUI paramLaunchAAUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(224228);
    Bitmap localBitmap = h.aP(LaunchAAUI.l(this.jab), LaunchAAUI.m(this.jab).getWidth(), LaunchAAUI.m(this.jab).getHeight());
    int i = Exif.fromFile(LaunchAAUI.l(this.jab)).getOrientationInDegree();
    localBitmap = h.a(localBitmap, i);
    ae.i("MicroMsg.Aa.LaunchAAUI", "exifPath : %s degree : %d", new Object[] { LaunchAAUI.l(this.jab), Integer.valueOf(i) });
    LaunchAAUI.m(this.jab).setImageBitmap(localBitmap);
    AppMethodBeat.o(224228);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.34
 * JD-Core Version:    0.7.0.1
 */