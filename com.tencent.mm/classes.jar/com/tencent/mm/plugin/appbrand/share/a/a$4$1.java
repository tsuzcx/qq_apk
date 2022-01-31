package com.tencent.mm.plugin.appbrand.share.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.share.widget.WxaShareMessagePage;
import com.tencent.mm.sdk.platformtools.ab;

final class a$4$1
  implements Runnable
{
  a$4$1(a.4 param4, Bundle paramBundle) {}
  
  public final void run()
  {
    AppMethodBeat.i(143569);
    String str = this.cax.getString("delay_load_img_path");
    this.iJF.iJD.setImageUrl(str);
    ab.i("MicroMsg.WxaShareMessageService", "onLoadImageFinishedAction(%s)", new Object[] { str });
    a.a(this.iJF.iJE);
    AppMethodBeat.o(143569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.share.a.a.4.1
 * JD-Core Version:    0.7.0.1
 */