package com.tencent.mm.plugin.hp.tinker;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.d;
import com.tencent.mm.modelmulti.m;
import com.tencent.mm.modelmulti.m.a;
import com.tencent.mm.plugin.hp.b.b.a;
import com.tencent.mm.plugin.hp.b.b.b;
import com.tencent.mm.plugin.hp.c.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.service.DefaultTinkerResultService;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.Properties;

public class TinkerPatchResultService
  extends DefaultTinkerResultService
{
  boolean syx = false;
  
  public final void a(com.tencent.tinker.lib.service.a parama)
  {
    AppMethodBeat.i(117499);
    if (parama == null)
    {
      com.tencent.tinker.lib.f.a.e("Tinker.TinkerPatchResultService", "TinkerPatchResultService received null result!!!!", new Object[0]);
      AppMethodBeat.o(117499);
      return;
    }
    com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchResultService", "TinkerPatchResultService receive result: %s", new Object[] { parama.toString() });
    ad.i("Tinker.TinkerPatchResultService", "onPatchResult on service");
    Object localObject2 = c.fastGetPatchPackageMeta(new File(parama.IEC));
    if (localObject2 != null)
    {
      Object localObject1 = ((Properties)localObject2).getProperty("patch.client.ver");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        Object localObject3 = b.gQ(com.tencent.mm.loader.j.a.glW, (String)localObject1);
        SharedPreferences localSharedPreferences = b.cGd();
        String str = ((b)localObject3).Fe(2);
        if (localSharedPreferences.contains(str))
        {
          long l = localSharedPreferences.getLong(str, 0L);
          ((b)localObject3).ai(2, System.currentTimeMillis() - l);
          localSharedPreferences.edit().remove(str).remove(((b)localObject3).Fe(3)).commit();
        }
        localObject3 = h.glW;
        localObject2 = ((Properties)localObject2).getProperty("NEW_TINKER_ID");
        int j = b.b.sxG.value;
        if (parama.dhg)
        {
          i = b.a.sxE.value;
          com.tencent.mm.plugin.hp.b.b.e((String)localObject3, (String)localObject1, (String)localObject2, j, i);
          label226:
          new ap(Looper.getMainLooper()).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(117497);
              com.tencent.tinker.lib.f.a.w("Tinker.TinkerPatchResultService", "actually kill tinker patch service!", new Object[0]);
              com.tencent.tinker.lib.f.b.kJ(TinkerPatchResultService.this.getApplicationContext());
              AppMethodBeat.o(117497);
            }
          }, 10000L);
          if (!parama.dhg) {
            break label385;
          }
          localObject1 = d.cKY;
          if (!com.tencent.tinker.lib.e.b.c((ApplicationLike)localObject1)) {
            break label368;
          }
          localObject1 = com.tencent.tinker.lib.e.b.d((ApplicationLike)localObject1);
          if ((ShareTinkerInternals.isNullOrNil((String)localObject1)) || (parama.IED == null) || (!parama.IED.equals(localObject1))) {
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
      new m(aj.getContext(), new m.a()
      {
        public final void es(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(117498);
          boolean bool1 = TinkerPatchResultService.access$000();
          boolean bool2 = com.tencent.mm.r.a.aad();
          if ((!paramAnonymousBoolean) && (!bool1) && (!bool2))
          {
            TinkerPatchResultService.a(TinkerPatchResultService.this);
            AppMethodBeat.o(117498);
            return;
          }
          com.tencent.tinker.lib.f.a.w("Tinker.TinkerPatchResultService", "not hit condition, skip suicide this time. cond: screenOn: %s, voip: %s, multiTalk: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          AppMethodBeat.o(117498);
        }
      });
      AppMethodBeat.o(117499);
      return;
      i = b.a.sxD.value;
      break;
      ad.e("Tinker.TinkerPatchResultService", "[-] Fail to get patch clientversion.");
      break label226;
      ad.i("Tinker.TinkerPatchResultService", "onPatchResult properties is null.");
      break label226;
    }
    label373:
    com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchResultService", "I have already install the newly patch version!", new Object[0]);
    label385:
    AppMethodBeat.o(117499);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.TinkerPatchResultService
 * JD-Core Version:    0.7.0.1
 */