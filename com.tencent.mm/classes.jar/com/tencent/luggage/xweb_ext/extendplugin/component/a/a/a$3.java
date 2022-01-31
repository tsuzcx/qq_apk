package com.tencent.luggage.xweb_ext.extendplugin.component.a.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;

final class a$3
  implements TXLivePlayer.ITXSnapshotListener
{
  a$3(a parama, com.tencent.luggage.xweb_ext.extendplugin.a parama1) {}
  
  public final void onSnapshot(Bitmap paramBitmap)
  {
    AppMethodBeat.i(154389);
    if (this.bGh == null)
    {
      ab.e("MicroMsg.SameLayer.LivePlayerPluginHandler", "operateSnapshot, invokeContext is null");
      AppMethodBeat.o(154389);
      return;
    }
    if (this.bGg.bFY != null) {
      this.bGg.bFY.a(this.bGh, paramBitmap);
    }
    AppMethodBeat.o(154389);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a.3
 * JD-Core Version:    0.7.0.1
 */