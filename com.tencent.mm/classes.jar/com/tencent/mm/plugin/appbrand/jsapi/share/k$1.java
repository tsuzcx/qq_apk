package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.page.s;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

final class k$1
  extends g.b
{
  k$1(String paramString1, q paramq, String paramString2) {}
  
  public final void a(g.c paramc)
  {
    g.b(this.val$appId, this);
    paramc = new Bundle();
    paramc.putInt("action", 1);
    f.a("com.tencent.mm", paramc, a.class, null);
    long l = System.currentTimeMillis();
    paramc = this.gjp;
    if ((paramc != null) && ((paramc instanceof s))) {}
    for (paramc = ((s)paramc).ahe();; paramc = null)
    {
      y.i("MicroMsg.ShareHelper", "cropCover(appId : %s, pageView : %s, cropCost : %sms)", new Object[] { this.gjp.mAppId, Integer.valueOf(this.gjp.hashCode()), Long.valueOf(System.currentTimeMillis() - l) });
      if (paramc != null) {}
      try
      {
        if (!paramc.isRecycled())
        {
          l = System.currentTimeMillis();
          c.a(paramc, 100, Bitmap.CompressFormat.JPEG, this.gBs, true);
          y.i("MicroMsg.ShareHelper", "saveFile(appId : %s, pageView : %s, saveFileCost : %sms)", new Object[] { this.gjp.mAppId, Integer.valueOf(this.gjp.hashCode()), Long.valueOf(System.currentTimeMillis() - l) });
          Bundle localBundle = new Bundle();
          localBundle.putString("delay_load_img_path", "file://" + this.gBs);
          com.tencent.mm.cg.a.post(new k.1.1(this, l, localBundle));
        }
        return;
      }
      catch (IOException localIOException)
      {
        y.w("MicroMsg.ShareHelper", "save temp bitmap to file failed, . exception : %s", new Object[] { localIOException });
        return;
      }
      catch (Exception localException)
      {
        y.w("MicroMsg.ShareHelper", "save temp bitmap to file failed, . exception : %s", new Object[] { localException });
        return;
      }
      finally
      {
        if ((paramc == null) || (paramc.isRecycled())) {
          break;
        }
        paramc.recycle();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.k.1
 * JD-Core Version:    0.7.0.1
 */