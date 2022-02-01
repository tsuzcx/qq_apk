package com.tencent.mm.plugin.aa.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;

final class LaunchAAUI$33
  implements Runnable
{
  LaunchAAUI$33(LaunchAAUI paramLaunchAAUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(213062);
    Bitmap localBitmap = BitmapUtil.decodeFileWithSample(LaunchAAUI.o(this.jXQ), LaunchAAUI.p(this.jXQ).getWidth(), LaunchAAUI.p(this.jXQ).getHeight());
    int i = Exif.fromFile(LaunchAAUI.o(this.jXQ)).getOrientationInDegree();
    localBitmap = BitmapUtil.rotate(localBitmap, i);
    Log.i("MicroMsg.Aa.LaunchAAUI", "exifPath : %s degree : %d", new Object[] { LaunchAAUI.o(this.jXQ), Integer.valueOf(i) });
    LaunchAAUI.p(this.jXQ).setImageBitmap(localBitmap);
    AppMethodBeat.o(213062);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.33
 * JD-Core Version:    0.7.0.1
 */