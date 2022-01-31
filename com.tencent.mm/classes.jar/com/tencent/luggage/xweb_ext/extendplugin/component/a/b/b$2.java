package com.tencent.luggage.xweb_ext.extendplugin.component.a.b;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;

final class b$2
  implements TXLivePusher.ITXSnapshotListener
{
  b$2(b paramb, TXLivePusher.ITXSnapshotListener paramITXSnapshotListener) {}
  
  public final void onSnapshot(Bitmap paramBitmap)
  {
    AppMethodBeat.i(139821);
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
        b.k(paramBitmap);
        AppMethodBeat.o(139821);
        return;
      }
      this.val$listener.onSnapshot(paramBitmap);
    }
    AppMethodBeat.o(139821);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a.b.b.2
 * JD-Core Version:    0.7.0.1
 */