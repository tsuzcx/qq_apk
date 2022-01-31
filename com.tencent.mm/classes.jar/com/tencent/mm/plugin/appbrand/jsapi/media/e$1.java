package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.ae;

final class e$1
  implements Runnable
{
  e$1(e parame) {}
  
  public final void run()
  {
    Toast.makeText(ae.getContext(), ae.getContext().getString(y.j.cropimage_saved, new Object[] { q.UL() }), 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.e.1
 * JD-Core Version:    0.7.0.1
 */