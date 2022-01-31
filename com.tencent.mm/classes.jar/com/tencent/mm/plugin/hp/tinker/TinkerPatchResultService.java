package com.tencent.mm.plugin.hp.tinker;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelmulti.l;
import com.tencent.mm.plugin.hp.b.b.a;
import com.tencent.mm.plugin.hp.b.b.b;
import com.tencent.mm.plugin.hp.d.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.service.DefaultTinkerResultService;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.Properties;

public class TinkerPatchResultService
  extends DefaultTinkerResultService
{
  public final void a(com.tencent.tinker.lib.service.a parama)
  {
    AppMethodBeat.i(90663);
    if (parama == null)
    {
      com.tencent.tinker.lib.f.a.e("Tinker.TinkerPatchResultService", "TinkerPatchResultService received null result!!!!", new Object[0]);
      AppMethodBeat.o(90663);
      return;
    }
    com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchResultService", "TinkerPatchResultService receive result: %s", new Object[] { parama.toString() });
    ab.i("Tinker.TinkerPatchResultService", "onPatchResult on service");
    Object localObject2 = c.S(new File(parama.BsF));
    if (localObject2 != null)
    {
      Object localObject1 = ((Properties)localObject2).getProperty("patch.client.ver");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        Object localObject3 = b.eP(com.tencent.mm.loader.j.a.CLIENT_VERSION, (String)localObject1);
        SharedPreferences localSharedPreferences = b.bIl();
        String str = ((b)localObject3).xC(2);
        if (localSharedPreferences.contains(str))
        {
          long l = localSharedPreferences.getLong(str, 0L);
          ((b)localObject3).T(2, System.currentTimeMillis() - l);
          localSharedPreferences.edit().remove(str).remove(((b)localObject3).xC(3)).commit();
        }
        localObject3 = f.CLIENT_VERSION;
        localObject2 = ((Properties)localObject2).getProperty("NEW_TINKER_ID");
        int j = b.b.nKa.value;
        if (parama.csk)
        {
          i = b.a.nJY.value;
          com.tencent.mm.plugin.hp.b.b.e((String)localObject3, (String)localObject1, (String)localObject2, j, i);
          label226:
          new ak(Looper.getMainLooper()).postDelayed(new TinkerPatchResultService.1(this), 10000L);
          if (!parama.csk) {
            break label385;
          }
          localObject1 = com.tencent.mm.app.b.bXD;
          if (!com.tencent.tinker.lib.e.b.c((ApplicationLike)localObject1)) {
            break label368;
          }
          localObject1 = com.tencent.tinker.lib.e.b.d((ApplicationLike)localObject1);
          if ((ShareTinkerInternals.isNullOrNil((String)localObject1)) || (parama.BsG == null) || (!parama.BsG.equals(localObject1))) {
            break label368;
          }
        }
      }
    }
    label368:
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        break label373;
      }
      new l(ah.getContext(), new TinkerPatchResultService.2(this));
      AppMethodBeat.o(90663);
      return;
      i = b.a.nJX.value;
      break;
      ab.e("Tinker.TinkerPatchResultService", "[-] Fail to get patch clientversion.");
      break label226;
      ab.i("Tinker.TinkerPatchResultService", "onPatchResult properties is null.");
      break label226;
    }
    label373:
    com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchResultService", "I have already install the newly patch version!", new Object[0]);
    label385:
    AppMethodBeat.o(90663);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.TinkerPatchResultService
 * JD-Core Version:    0.7.0.1
 */