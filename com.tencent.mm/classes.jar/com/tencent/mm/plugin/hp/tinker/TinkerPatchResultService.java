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
import com.tencent.mm.plugin.hp.d.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.service.DefaultTinkerResultService;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.Properties;

public class TinkerPatchResultService
  extends DefaultTinkerResultService
{
  private static com.tinkerboots.sdk.tinker.a.a uUM = null;
  boolean uUN = false;
  
  public static void a(com.tinkerboots.sdk.tinker.a.a parama)
  {
    uUM = parama;
  }
  
  public final void a(com.tencent.tinker.lib.service.a parama)
  {
    AppMethodBeat.i(117499);
    if (parama == null)
    {
      ae.e("Tinker.TinkerPatchResultService", "TinkerPatchResultService received null result!!!!");
      AppMethodBeat.o(117499);
      return;
    }
    ae.i("Tinker.TinkerPatchResultService", "TinkerPatchResultService receive result: %s", new Object[] { parama.toString() });
    ae.i("Tinker.TinkerPatchResultService", "onPatchResult on service");
    Object localObject2 = c.fastGetPatchPackageMeta(new File(parama.MDH));
    int i;
    if (localObject2 != null)
    {
      Object localObject1 = ((Properties)localObject2).getProperty("patch.client.ver");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        Object localObject3 = b.hA(com.tencent.mm.loader.j.a.hju, (String)localObject1);
        SharedPreferences localSharedPreferences = b.dfn();
        String str = ((b)localObject3).IT(2);
        if (localSharedPreferences.contains(str))
        {
          long l = localSharedPreferences.getLong(str, 0L);
          ((b)localObject3).ak(2, System.currentTimeMillis() - l);
          localSharedPreferences.edit().remove(str).remove(((b)localObject3).IT(3)).commit();
        }
        localObject3 = j.hju;
        localObject2 = ((Properties)localObject2).getProperty("NEW_TINKER_ID");
        int j = b.b.uTR.value;
        if (parama.drc)
        {
          i = b.a.uTP.value;
          com.tencent.mm.plugin.hp.b.b.e((String)localObject3, (String)localObject1, (String)localObject2, j, i);
          label222:
          new aq(Looper.getMainLooper()).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(117497);
              ae.w("Tinker.TinkerPatchResultService", "actually kill tinker patch service!");
              com.tencent.tinker.lib.util.b.lr(TinkerPatchResultService.this.getApplicationContext());
              AppMethodBeat.o(117497);
            }
          }, 10000L);
          if (parama.drc)
          {
            localObject1 = d.cTZ;
            if (!com.tencent.tinker.lib.e.b.c((ApplicationLike)localObject1)) {
              break label383;
            }
            localObject1 = com.tencent.tinker.lib.e.b.d((ApplicationLike)localObject1);
            if ((ShareTinkerInternals.isNullOrNil((String)localObject1)) || (parama.MDK == null) || (!parama.MDK.equals(localObject1))) {
              break label383;
            }
            i = 0;
            label303:
            if (i == 0) {
              break label388;
            }
            new m(ak.getContext(), new m.a()
            {
              public final void eR(boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(117498);
                boolean bool1 = TinkerPatchResultService.access$000();
                boolean bool2 = com.tencent.mm.r.a.adO();
                if ((!paramAnonymousBoolean) && (!bool1) && (!bool2))
                {
                  TinkerPatchResultService.a(TinkerPatchResultService.this);
                  AppMethodBeat.o(117498);
                  return;
                }
                ae.w("Tinker.TinkerPatchResultService", "not hit condition, skip suicide this time. cond: screenOn: %s, voip: %s, multiTalk: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                AppMethodBeat.o(117498);
              }
            });
          }
        }
      }
    }
    for (;;)
    {
      if ((uUM != null) && (parama != null)) {
        uUM.a(parama);
      }
      AppMethodBeat.o(117499);
      return;
      i = b.a.uTO.value;
      break;
      ae.e("Tinker.TinkerPatchResultService", "[-] Fail to get patch clientversion.");
      break label222;
      ae.i("Tinker.TinkerPatchResultService", "onPatchResult properties is null.");
      break label222;
      label383:
      i = 1;
      break label303;
      label388:
      ae.i("Tinker.TinkerPatchResultService", "I have already install the newly patch version!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.TinkerPatchResultService
 * JD-Core Version:    0.7.0.1
 */