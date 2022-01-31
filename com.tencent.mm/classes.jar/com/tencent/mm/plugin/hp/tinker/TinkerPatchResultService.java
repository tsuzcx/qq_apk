package com.tencent.mm.plugin.hp.tinker;

import android.os.Looper;
import com.tencent.mm.modelmulti.l;
import com.tencent.mm.plugin.hp.b.b.a;
import com.tencent.mm.plugin.hp.b.b.b;
import com.tencent.mm.plugin.hp.d.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tinker.lib.service.DefaultTinkerResultService;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.Properties;

public class TinkerPatchResultService
  extends DefaultTinkerResultService
{
  public final void a(com.tencent.tinker.lib.service.a parama)
  {
    if (parama == null) {
      com.tencent.tinker.lib.f.a.e("Tinker.TinkerPatchResultService", "TinkerPatchResultService received null result!!!!", new Object[0]);
    }
    label117:
    do
    {
      return;
      com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchResultService", "TinkerPatchResultService receive result: %s", new Object[] { parama.toString() });
      y.i("Tinker.TinkerPatchResultService", "onPatchResult on service");
      Object localObject2 = c.K(new File(parama.wWa));
      if (localObject2 == null) {
        break label233;
      }
      localObject1 = d.CLIENT_VERSION;
      String str = ((Properties)localObject2).getProperty("patch.client.ver");
      localObject2 = ((Properties)localObject2).getProperty("NEW_TINKER_ID");
      int j = b.b.lmI.value;
      if (!parama.bKQ) {
        break;
      }
      i = b.a.lmG.value;
      com.tencent.mm.plugin.hp.b.b.e((String)localObject1, str, (String)localObject2, j, i);
      new ah(Looper.getMainLooper()).postDelayed(new TinkerPatchResultService.1(this), 10000L);
    } while (!parama.bKQ);
    Object localObject1 = com.tencent.mm.app.b.applicationLike;
    if (com.tencent.tinker.lib.e.b.d((ApplicationLike)localObject1))
    {
      localObject1 = com.tencent.tinker.lib.e.b.e((ApplicationLike)localObject1);
      if ((ShareTinkerInternals.bl((String)localObject1)) || (parama.wWb == null) || (!parama.wWb.equals(localObject1))) {}
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        break label248;
      }
      new l(ae.getContext(), new TinkerPatchResultService.2(this), true);
      return;
      i = b.a.lmF.value;
      break;
      label233:
      y.i("Tinker.TinkerPatchResultService", "onPatchResult properties is null.");
      break label117;
    }
    label248:
    com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchResultService", "I have already install the newly patch version!", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.TinkerPatchResultService
 * JD-Core Version:    0.7.0.1
 */