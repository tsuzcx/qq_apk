package com.tencent.mm.plugin.hp.tinker;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.e;
import com.tencent.mm.modelmulti.r;
import com.tencent.mm.modelmulti.r.a;
import com.tencent.mm.plugin.hp.model.c.a;
import com.tencent.mm.plugin.hp.model.c.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.service.DefaultTinkerResultService;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.Properties;

public class TinkerPatchResultService
  extends DefaultTinkerResultService
{
  private static com.tinkerboots.sdk.tinker.a.a JED = null;
  boolean JEE = false;
  
  public static void a(com.tinkerboots.sdk.tinker.a.a parama)
  {
    JED = parama;
  }
  
  public final void onPatchResult(com.tencent.tinker.lib.service.a parama)
  {
    AppMethodBeat.i(117499);
    if (parama == null)
    {
      Log.e("Tinker.TinkerPatchResultService", "TinkerPatchResultService received null result!!!!");
      AppMethodBeat.o(117499);
      return;
    }
    Log.i("Tinker.TinkerPatchResultService", "TinkerPatchResultService receive result: %s", new Object[] { parama.toString() });
    Log.i("Tinker.TinkerPatchResultService", "onPatchResult on service");
    Object localObject2 = com.tencent.mm.plugin.hp.b.c.fastGetPatchPackageMeta(new File(parama.ahRw));
    int i;
    if (localObject2 != null)
    {
      Object localObject1 = ((Properties)localObject2).getProperty("patch.client.ver");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        Object localObject3 = b.jF(com.tencent.mm.loader.i.a.CLIENT_VERSION, (String)localObject1);
        SharedPreferences localSharedPreferences = b.fPX();
        String str = ((b)localObject3).YZ(2);
        if (localSharedPreferences.contains(str))
        {
          long l = localSharedPreferences.getLong(str, 0L);
          ((b)localObject3).aF(2, System.currentTimeMillis() - l);
          localSharedPreferences.edit().remove(str).remove(((b)localObject3).YZ(3)).commit();
        }
        localObject3 = BuildInfo.CLIENT_VERSION;
        localObject2 = ((Properties)localObject2).getProperty("NEW_TINKER_ID");
        int j = c.b.JDI.value;
        if (parama.isSuccess)
        {
          i = c.a.JDG.value;
          com.tencent.mm.plugin.hp.model.c.g((String)localObject3, (String)localObject1, (String)localObject2, j, i);
          label222:
          new MMHandler(Looper.getMainLooper()).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(117497);
              Log.w("Tinker.TinkerPatchResultService", "actually kill tinker patch service!");
              com.tencent.tinker.lib.f.c.oz(TinkerPatchResultService.this.getApplicationContext());
              AppMethodBeat.o(117497);
            }
          }, 10000L);
          if (parama.isSuccess)
          {
            localObject1 = e.hfI;
            if (!com.tencent.tinker.lib.e.b.c((ApplicationLike)localObject1)) {
              break label383;
            }
            localObject1 = com.tencent.tinker.lib.e.b.d((ApplicationLike)localObject1);
            if ((ShareTinkerInternals.isNullOrNil((String)localObject1)) || (parama.ahRz == null) || (!parama.ahRz.equals(localObject1))) {
              break label383;
            }
            i = 0;
            label303:
            if (i == 0) {
              break label388;
            }
            new r(MMApplicationContext.getContext(), new r.a()
            {
              public final void onScreenStateChange(boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(117498);
                boolean bool1 = TinkerPatchResultService.access$000();
                boolean bool2 = com.tencent.mm.n.a.aTe();
                if ((!paramAnonymousBoolean) && (!bool1) && (!bool2))
                {
                  TinkerPatchResultService.a(TinkerPatchResultService.this);
                  AppMethodBeat.o(117498);
                  return;
                }
                Log.w("Tinker.TinkerPatchResultService", "not hit condition, skip suicide this time. cond: screenOn: %s, voip: %s, multiTalk: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                AppMethodBeat.o(117498);
              }
            });
          }
        }
      }
    }
    for (;;)
    {
      if ((JED != null) && (parama != null)) {
        JED.onPatchResult(parama);
      }
      AppMethodBeat.o(117499);
      return;
      i = c.a.JDF.value;
      break;
      Log.e("Tinker.TinkerPatchResultService", "[-] Fail to get patch clientversion.");
      break label222;
      Log.i("Tinker.TinkerPatchResultService", "onPatchResult properties is null.");
      break label222;
      label383:
      i = 1;
      break label303;
      label388:
      Log.i("Tinker.TinkerPatchResultService", "I have already install the newly patch version!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.TinkerPatchResultService
 * JD-Core Version:    0.7.0.1
 */