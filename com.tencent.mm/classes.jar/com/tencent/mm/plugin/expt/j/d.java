package com.tencent.mm.plugin.expt.j;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.vendor.MIUI;
import java.util.Map;

public final class d
  implements b
{
  private static void a(SharedPreferences paramSharedPreferences, boolean paramBoolean)
  {
    AppMethodBeat.i(255405);
    paramSharedPreferences = paramSharedPreferences.edit();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramSharedPreferences.putInt("special_scene_enable", i).commit();
      Log.i("MicroMsg.NotificationSpecialSingleton", "setSpecialSceneEnable() enable: %s", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(255405);
      return;
    }
  }
  
  public final void aEW()
  {
    boolean bool2 = false;
    AppMethodBeat.i(255403);
    SharedPreferences localSharedPreferences = com.tencent.mm.kernel.b.awd();
    localSharedPreferences.edit().putBoolean("keepaliveserviceswitch", ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vxL, false)).commit();
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vxJ, -1);
    Log.i("MicroMsg.NotificationSpecialSingleton", "iniNotificationSpecialSceneSwitchEnable() enable:%s", new Object[] { Integer.valueOf(i) });
    Object localObject;
    boolean bool1;
    if (Util.isEqual(i, 1))
    {
      localObject = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vxK, "");
      Log.i("MicroMsg.NotificationSpecialSingleton", "specialSceneDetail %s", new Object[] { localObject });
      bool1 = bool2;
      if (!Util.isNullOrNil((String)localObject))
      {
        localObject = XmlParser.parseXml((String)localObject, "manufacturerlist", null);
        bool1 = bool2;
        if (localObject != null) {
          if (!((Map)localObject).containsKey(".manufacturerlist.size")) {
            break label504;
          }
        }
      }
    }
    label300:
    label457:
    label504:
    for (i = Util.getInt((String)((Map)localObject).get(".manufacturerlist.size"), 0);; i = 0)
    {
      int k = Build.VERSION.SDK_INT;
      int j = 0;
      for (;;)
      {
        bool1 = bool2;
        if (j < i)
        {
          if (j != 0) {
            break label300;
          }
          if (!String.valueOf(Util.nullAsNil((String)((Map)localObject).get(".manufacturerlist.manufacturer.name"))).equalsIgnoreCase(Build.MANUFACTURER)) {
            break label457;
          }
        }
        for (bool1 = MIUI.ifInMinAndMax(k, Util.nullAsNil((String)((Map)localObject).get(".manufacturerlist.manufacturer.sdkversionmin")), Util.nullAsNil((String)((Map)localObject).get(".manufacturerlist.manufacturer.sdkversionmax")), Util.nullAsNil((String)((Map)localObject).get(".manufacturerlist.manufacturer.versintime")));; bool1 = MIUI.ifInMinAndMax(k, Util.nullAsNil((String)((Map)localObject).get(".manufacturerlist.manufacturer" + j + ".sdkversionmin")), Util.nullAsNil((String)((Map)localObject).get(".manufacturerlist.manufacturer" + j + ".sdkversionmax")), Util.nullAsNil((String)((Map)localObject).get(".manufacturerlist.manufacturer" + j + ".versintime"))))
        {
          a(localSharedPreferences, bool1);
          AppMethodBeat.o(255403);
          return;
          if (!String.valueOf(Util.nullAsNil((String)((Map)localObject).get(".manufacturerlist.manufacturer" + j + ".name"))).equalsIgnoreCase(Build.MANUFACTURER)) {
            break;
          }
        }
        j += 1;
      }
      if (Util.isEqual(i, 0))
      {
        a(localSharedPreferences, false);
        AppMethodBeat.o(255403);
        return;
      }
      if (Util.isEqual(i, 2)) {
        a(localSharedPreferences, true);
      }
      AppMethodBeat.o(255403);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.j.d
 * JD-Core Version:    0.7.0.1
 */