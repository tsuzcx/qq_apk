package com.tencent.mm.plugin.expt.hellhound.a.f.g.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.expt.hellhound.core.b.c.e;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.fbo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/special/jd/FindMoreFriendUIMonitor;", "", "()V", "Companion", "FindMoreFriendUIListener", "plugin-expt_release"})
public final class a
{
  private static boolean woX;
  private static boolean woY;
  private static boolean woZ;
  private static final b wpa;
  public static final a.a wpb;
  
  static
  {
    AppMethodBeat.i(177420);
    wpb = new a.a((byte)0);
    wpa = new b();
    AppMethodBeat.o(177420);
  }
  
  public static final void startMonitor()
  {
    AppMethodBeat.i(177421);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z"));
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put("com/tencent/mm/ui/AbstractTabChildPreference", localArrayList);
    com.tencent.mm.hellhoundlib.a.aFg();
    com.tencent.mm.hellhoundlib.a.a((Map)localHashMap, (com.tencent.mm.hellhoundlib.a.d)wpa);
    AppMethodBeat.o(177421);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/special/jd/FindMoreFriendUIMonitor$FindMoreFriendUIListener;", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "()V", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "viewCallback", "prefKey", "plugin-expt_release"})
  static final class b
    implements com.tencent.mm.hellhoundlib.a.d
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
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
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkg = false;
      paramString1 = paramArrayOfObject[1];
      if (paramString1 == null)
      {
        paramString1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.Preference");
        AppMethodBeat.o(184285);
        throw paramString1;
      }
      paramString1 = (Preference)paramString1;
      paramString2 = a.wpb;
      a.ny(p.h("jd_market_entrance", paramString1.getKey()));
      paramString2 = a.wpb;
      a.nz(p.h("find_friends_by_qrcode", paramString1.getKey()));
      paramString2 = a.wpb;
      a.nA(p.h("find_friends_by_finder", paramString1.getKey()));
      paramString2 = a.wpb;
      if (a.dfM())
      {
        Log.i("HABBYGE-MALI.FindMoreFriendUIMonitor", "Finder, 19354, 1");
        f.Iyx.a(19354, new Object[] { Integer.valueOf(1) });
      }
      paramString1 = paramString1.getKey();
      p.j(paramString1, "pref.key");
      paramString2 = new fbo();
      paramString2.id = paramString1;
      paramString2.timestamp = System.currentTimeMillis();
      paramString2.UBI = paramString1;
      if (paramObject != null)
      {
        paramString1 = paramObject.getClass();
        if (paramString1 != null)
        {
          paramString1 = paramString1.getName();
          paramString2.fFe = b.awD(paramString1);
          if (paramObject == null) {
            break label281;
          }
        }
      }
      label281:
      for (int i = paramObject.hashCode();; i = -1)
      {
        paramString2.GcW = i;
        paramString2.UBJ = paramString2.fFe;
        paramString2.eventId = com.tencent.mm.plugin.expt.hellhound.core.b.c.d.wgz.value;
        paramString2.typeName = paramString2.fFe;
        paramString2.type = 0;
        paramString1 = e.wgO;
        e.a(paramString2);
        AppMethodBeat.o(184285);
        return;
        paramString1 = null;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a
 * JD-Core Version:    0.7.0.1
 */