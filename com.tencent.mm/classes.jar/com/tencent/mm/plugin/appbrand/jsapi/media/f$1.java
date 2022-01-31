package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.ae;

final class f$1
  implements Runnable
{
  f$1(f paramf, String paramString) {}
  
  public final void run()
  {
    Toast.makeText(ae.getContext(), ae.getContext().getString(y.j.video_file_saved, new Object[] { this.gwq }), 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.f.1
 * JD-Core Version:    0.7.0.1
 */