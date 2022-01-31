package com.tencent.luggage.xweb_ext.extendplugin.component.a.b;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;

final class a$7
  implements TXLivePusher.ITXSnapshotListener
{
  a$7(a parama, com.tencent.luggage.xweb_ext.extendplugin.a parama1) {}
  
  public final void onSnapshot(Bitmap paramBitmap)
  {
    AppMethodBeat.i(154399);
    if (this.bGh == null)
    {
      ab.e("MicroMsg.SameLayer.LivePusherPluginHandler", "operateSnapshot, invokeContext is null");
      AppMethodBeat.o(154399);
      return;
    }
    if (this.bGK.bGC != null) {
      this.bGK.bGC.a(this.bGh, paramBitmap);
    }
    AppMethodBeat.o(154399);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a.7
 * JD-Core Version:    0.7.0.1
 */