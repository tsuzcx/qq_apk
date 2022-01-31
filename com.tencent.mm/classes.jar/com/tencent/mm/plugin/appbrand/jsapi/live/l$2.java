package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;

final class l$2
  implements TXLivePusher.ITXSnapshotListener
{
  l$2(l paraml, TXLivePusher.ITXSnapshotListener paramITXSnapshotListener) {}
  
  public final void onSnapshot(Bitmap paramBitmap)
  {
    AppMethodBeat.i(96142);
    if (this.val$listener != null)
    {
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      if ((i >= 1000) && (j >= 1000))
      {
        Object localObject = new Matrix();
        ((Matrix)localObject).setScale(0.5F, 0.5F);
        localObject = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, (Matrix)localObject, false);
        this.val$listener.onSnapshot((Bitmap)localObject);
        l.F(paramBitmap);
        AppMethodBeat.o(96142);
        return;
      }
      this.val$listener.onSnapshot(paramBitmap);
    }
    AppMethodBeat.o(96142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.l.2
 * JD-Core Version:    0.7.0.1
 */