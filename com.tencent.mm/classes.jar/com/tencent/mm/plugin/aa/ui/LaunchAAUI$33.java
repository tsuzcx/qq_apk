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
    AppMethodBeat.i(251308);
    Bitmap localBitmap = BitmapUtil.decodeFileWithSample(LaunchAAUI.p(this.mPg), LaunchAAUI.q(this.mPg).getWidth(), LaunchAAUI.q(this.mPg).getHeight());
    int i = Exif.fromFile(LaunchAAUI.p(this.mPg)).getOrientationInDegree();
    localBitmap = BitmapUtil.rotate(localBitmap, i);
    Log.i("MicroMsg.Aa.LaunchAAUI", "exifPath : %s degree : %d", new Object[] { LaunchAAUI.p(this.mPg), Integer.valueOf(i) });
    LaunchAAUI.q(this.mPg).setImageBitmap(localBitmap);
    AppMethodBeat.o(251308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.33
 * JD-Core Version:    0.7.0.1
 */