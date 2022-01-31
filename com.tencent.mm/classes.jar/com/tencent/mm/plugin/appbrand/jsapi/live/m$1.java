package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;

final class m$1
  implements TXLivePusher.ITXSnapshotListener
{
  m$1(m paramm, TXLivePusher.ITXSnapshotListener paramITXSnapshotListener) {}
  
  public final void onSnapshot(Bitmap paramBitmap)
  {
    if (this.val$listener != null)
    {
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      if ((i < 1000) || (j < 1000)) {
        break label78;
      }
      Object localObject = new Matrix();
      ((Matrix)localObject).setScale(0.5F, 0.5F);
      localObject = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, (Matrix)localObject, false);
      this.val$listener.onSnapshot((Bitmap)localObject);
    }
    for (;;)
    {
      paramBitmap.recycle();
      return;
      label78:
      this.val$listener.onSnapshot(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.m.1
 * JD-Core Version:    0.7.0.1
 */