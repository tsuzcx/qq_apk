package com.tencent.mm.plugin.appbrand.appcache;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;

final class ap$b$1
  implements Runnable
{
  ap$b$1(ap.b paramb, String paramString1, int paramInt, String paramString2) {}
  
  public final void run()
  {
    g.aZ(this.val$appId, this.fEs);
    Toast.makeText(ae.getContext(), ae.getContext().getString(y.j.app_brand_pkg_updated_should_reboot, new Object[] { bk.aM(this.fEt, this.val$appId) }), 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ap.b.1
 * JD-Core Version:    0.7.0.1
 */