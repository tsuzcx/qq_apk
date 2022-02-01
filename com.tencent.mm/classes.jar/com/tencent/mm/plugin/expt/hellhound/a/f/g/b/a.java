package com.tencent.mm.plugin.expt.hellhound.a.f.g.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.expt.hellhound.core.b.c.d;
import com.tencent.mm.protocal.protobuf.erd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/special/jd/FindMoreFriendUIMonitor;", "", "()V", "Companion", "FindMoreFriendUIListener", "plugin-expt_release"})
public final class a
{
  private static boolean sJa;
  private static boolean sJb;
  private static boolean sJc;
  private static final b sJd;
  public static final a.a sJe;
  
  static
  {
    AppMethodBeat.i(177420);
    sJe = new a.a((byte)0);
    sJd = new b();
    AppMethodBeat.o(177420);
  }
  
  public static final void startMonitor()
  {
    AppMethodBeat.i(177421);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z"));
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put("com/tencent/mm/ui/AbstractTabChildPreference", localArrayList);
    com.tencent.mm.hellhoundlib.a.axP();
    com.tencent.mm.hellhoundlib.a.a((Map)localHashMap, (c)sJd);
    AppMethodBeat.o(177421);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/special/jd/FindMoreFriendUIMonitor$FindMoreFriendUIListener;", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "()V", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "viewCallback", "prefKey", "plugin-expt_release"})
  static final class b
    implements c
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(184285);
      if (paramArrayOfObject == null)
      {
        AppMethodBeat.o(184285);
        return;
      }
      if (paramArrayOfObject.length < 2)
      {
        AppMethodBeat.o(184285);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEl = false;
      paramString1 = paramArrayOfObject[1];
      if (paramString1 == null)
      {
        paramString1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.Preference");
        AppMethodBeat.o(184285);
        throw paramString1;
      }
      paramString1 = (Preference)paramString1;
      paramString2 = a.sJe;
      a.ml(p.j("jd_market_entrance", paramString1.getKey()));
      paramString2 = a.sJe;
      a.mm(p.j("find_friends_by_qrcode", paramString1.getKey()));
      paramString2 = a.sJe;
      a.mn(p.j("find_friends_by_finder", paramString1.getKey()));
      paramString2 = a.sJe;
      if (a.cQR())
      {
        Log.i("HABBYGE-MALI.FindMoreFriendUIMonitor", "Finder, 19354, 1");
        com.tencent.mm.plugin.report.e.Cxv.a(19354, new Object[] { Integer.valueOf(1) });
      }
      paramString1 = paramString1.getKey();
      p.g(paramString1, "pref.key");
      paramString2 = new erd();
      paramString2.id = paramString1;
      paramString2.timestamp = System.currentTimeMillis();
      paramString2.NoL = paramString1;
      if (paramObject != null)
      {
        paramString1 = paramObject.getClass();
        if (paramString1 != null)
        {
          paramString1 = paramString1.getName();
          paramString2.dMl = b.aoE(paramString1);
          if (paramObject == null) {
            break label281;
          }
        }
      }
      label281:
      for (int i = paramObject.hashCode();; i = -1)
      {
        paramString2.NoN = i;
        paramString2.NoM = paramString2.dMl;
        paramString2.eventId = d.sAF.value;
        paramString2.typeName = paramString2.dMl;
        paramString2.type = 0;
        paramString1 = com.tencent.mm.plugin.expt.hellhound.core.b.c.e.sAU;
        com.tencent.mm.plugin.expt.hellhound.core.b.c.e.a(paramString2);
        AppMethodBeat.o(184285);
        return;
        paramString1 = null;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a
 * JD-Core Version:    0.7.0.1
 */