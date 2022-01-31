package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.jsapi.base.g;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

final class c$1
  implements TXLivePlayer.ITXSnapshotListener
{
  c$1(c paramc, g paramg, com.tencent.mm.plugin.appbrand.jsapi.e parame) {}
  
  public final void onSnapshot(Bitmap paramBitmap)
  {
    AppMethodBeat.i(96109);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      ab.e("MicroMsg.JsApiOperateLivePlayer", "onSnapshot: bitmap nil");
      this.hEM.BS(this.hNN.j("fail:snapshot error", null));
      AppMethodBeat.o(96109);
      return;
    }
    String str = com.tencent.mm.compatible.util.e.esr + String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" });
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    com.tencent.mm.plugin.appbrand.s.j localj;
    try
    {
      d.a(paramBitmap, 90, Bitmap.CompressFormat.JPEG, str, true);
      localj = new com.tencent.mm.plugin.appbrand.s.j();
      if (this.hNM.wX().a(new File(str), "jpg", true, localj) != com.tencent.mm.plugin.appbrand.appstorage.j.gZA)
      {
        this.hEM.BS(this.hNN.j("fail:snapshot error", null));
        AppMethodBeat.o(96109);
        return;
      }
    }
    catch (IOException paramBitmap)
    {
      ab.e("MicroMsg.JsApiOperateLivePlayer", "onSnapshot: exception %s", new Object[] { paramBitmap.getMessage() });
      this.hEM.BS(this.hNN.j("fail:snapshot error", null));
      AppMethodBeat.o(96109);
      return;
    }
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      ab.i("MicroMsg.JsApiOperateLivePlayer", "bitmap recycle " + paramBitmap.toString());
      paramBitmap.recycle();
    }
    ab.i("MicroMsg.JsApiOperateLivePlayer", "onSnapshot: actualPath:%s path:%s", new Object[] { str, localj.value });
    paramBitmap = new HashMap();
    paramBitmap.put("tempImagePath", localj.value);
    paramBitmap.put("width", Integer.valueOf(i));
    paramBitmap.put("height", Integer.valueOf(j));
    this.hEM.BS(this.hNN.j("ok", paramBitmap));
    AppMethodBeat.o(96109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.c.1
 * JD-Core Version:    0.7.0.1
 */