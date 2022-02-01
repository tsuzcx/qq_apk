package com.tencent.mm.plugin.expt.hellhound.a.f.g.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.expt.hellhound.core.b.c.d;
import com.tencent.mm.protocal.protobuf.dwx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.preference.Preference;
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/special/jd/FindMoreFriendUIMonitor;", "", "()V", "Companion", "FindMoreFriendUIListener", "plugin-expt_release"})
public final class a
{
  private static boolean rhE;
  private static boolean rhF;
  private static boolean rhG;
  private static final b rhH;
  public static final a.a rhI;
  
  static
  {
    AppMethodBeat.i(177420);
    rhI = new a.a((byte)0);
    rhH = new b();
    AppMethodBeat.o(177420);
  }
  
  public static final void cqn()
  {
    AppMethodBeat.i(177421);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z"));
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put("com/tencent/mm/ui/AbstractTabChildPreference", localArrayList);
    com.tencent.mm.hellhoundlib.a.ahD();
    com.tencent.mm.hellhoundlib.a.a((Map)localHashMap, (c)rhH);
    AppMethodBeat.o(177421);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/special/jd/FindMoreFriendUIMonitor$FindMoreFriendUIListener;", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "()V", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "viewCallback", "prefKey", "plugin-expt_release"})
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
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.rdE = false;
      paramString1 = paramArrayOfObject[1];
      if (paramString1 == null)
      {
        paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.Preference");
        AppMethodBeat.o(184285);
        throw paramString1;
      }
      paramString1 = (Preference)paramString1;
      paramString2 = a.rhI;
      a.ld(p.i("jd_market_entrance", paramString1.getKey()));
      paramString2 = a.rhI;
      a.le(p.i("find_friends_by_qrcode", paramString1.getKey()));
      paramString2 = a.rhI;
      a.lf(p.i("find_friends_by_finder", paramString1.getKey()));
      paramString2 = a.rhI;
      if (a.csj())
      {
        ae.i("HABBYGE-MALI.FindMoreFriendUIMonitor", "Finder, 19354, 1");
        com.tencent.mm.plugin.report.e.ywz.f(19354, new Object[] { Integer.valueOf(1) });
      }
      paramString1 = paramString1.getKey();
      p.g(paramString1, "pref.key");
      paramString2 = new dwx();
      paramString2.id = paramString1;
      paramString2.timestamp = System.currentTimeMillis();
      paramString2.Icn = paramString1;
      if (paramObject != null)
      {
        paramString1 = paramObject.getClass();
        if (paramString1 != null)
        {
          paramString1 = paramString1.getName();
          paramString2.duQ = b.aer(paramString1);
          if (paramObject == null) {
            break label281;
          }
        }
      }
      label281:
      for (int i = paramObject.hashCode();; i = -1)
      {
        paramString2.Icp = i;
        paramString2.Ico = paramString2.duQ;
        paramString2.duP = d.rao.value;
        paramString2.typeName = paramString2.duQ;
        paramString2.type = 0;
        paramString1 = com.tencent.mm.plugin.expt.hellhound.core.b.c.e.raD;
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