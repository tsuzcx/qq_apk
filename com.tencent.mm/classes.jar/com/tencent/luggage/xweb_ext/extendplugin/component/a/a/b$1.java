package com.tencent.luggage.xweb_ext.extendplugin.component.a.a;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;

final class b$1
  implements TXLivePlayer.ITXSnapshotListener
{
  b$1(b paramb, TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener) {}
  
  public final void onSnapshot(Bitmap paramBitmap)
  {
    AppMethodBeat.i(139770);
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
        b.j(paramBitmap);
        AppMethodBeat.o(139770);
        return;
      }
      this.val$listener.onSnapshot(paramBitmap);
    }
    AppMethodBeat.o(139770);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a.a.b.1
 * JD-Core Version:    0.7.0.1
 */