package com.tencent.mm.plugin.ext.provider;

import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.network.e;
import com.tencent.mm.pluginsdk.d.a.b;
import com.tencent.mm.sdk.platformtools.y;

final class ExtContentProviderBase$1
  implements Runnable
{
  ExtContentProviderBase$1(ExtContentProviderBase paramExtContentProviderBase, b paramb) {}
  
  public final void run()
  {
    try
    {
      if (!au.DK()) {
        return;
      }
      au.Dk().a(new bi(new bi.a()
      {
        public final void a(e paramAnonymouse)
        {
          y.i("MicroMsg.ExtContentProviderBase", "checkIsLogin() onSceneEnd()");
          ExtContentProviderBase.1.this.hSx.countDown();
        }
      }), 0);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.ExtContentProviderBase", "exception in NetSceneLocalProxy");
      this.hSx.countDown();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtContentProviderBase.1
 * JD-Core Version:    0.7.0.1
 */