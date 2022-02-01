package com.tencent.mm.plugin.expt.hellhound.ext.session.f.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.expt.hellhound.core.b.c.e;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.fxz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/special/jd/FindMoreFriendUIMonitor;", "", "()V", "Companion", "FindMoreFriendUIListener", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a zLc;
  private static boolean zLd;
  private static boolean zLe;
  private static boolean zLf;
  private static final b zLg;
  
  static
  {
    AppMethodBeat.i(177420);
    zLc = new a.a((byte)0);
    zLg = new b();
    AppMethodBeat.o(177420);
  }
  
  public static final void startMonitor()
  {
    AppMethodBeat.i(177421);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z"));
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put("com/tencent/mm/ui/AbstractTabChildPreference", localArrayList);
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.a((Map)localHashMap, (com.tencent.mm.hellhoundlib.a.d)zLg);
    AppMethodBeat.o(177421);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/special/jd/FindMoreFriendUIMonitor$FindMoreFriendUIListener;", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "()V", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "viewCallback", "prefKey", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
    implements com.tencent.mm.hellhoundlib.a.d
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
      paramString1 = c.zGj;
      c.zGl = false;
      paramString1 = (Preference)paramArrayOfObject[1];
      paramString2 = a.zLc;
      a.oY(s.p("jd_market_entrance", paramString1.mKey));
      paramString2 = a.zLc;
      a.oZ(s.p("find_friends_by_qrcode", paramString1.mKey));
      paramString2 = a.zLc;
      a.pa(s.p("find_friends_by_finder", paramString1.mKey));
      paramString2 = a.zLc;
      if (a.dMA())
      {
        Log.i("HABBYGE-MALI.FindMoreFriendUIMonitor", "Finder, 19354, 1");
        f.Ozc.b(19354, new Object[] { Integer.valueOf(1) });
      }
      paramString1 = paramString1.mKey;
      s.s(paramString1, "pref.key");
      paramString2 = new fxz();
      paramString2.id = paramString1;
      paramString2.timestamp = System.currentTimeMillis();
      paramString2.abVR = paramString1;
      if (paramObject == null)
      {
        paramString1 = null;
        paramString2.hJW = b.aqH(paramString1);
        if (paramObject != null) {
          break label263;
        }
      }
      label263:
      for (int i = -1;; i = paramObject.hashCode())
      {
        paramString2.LYA = i;
        paramString2.abVS = paramString2.hJW;
        paramString2.eventId = com.tencent.mm.plugin.expt.hellhound.core.b.c.d.zCB.value;
        paramString2.typeName = paramString2.hJW;
        paramString2.type = 0;
        paramString1 = e.zCM;
        e.a(paramString2);
        AppMethodBeat.o(184285);
        return;
        paramString1 = paramObject.getClass();
        if (paramString1 == null)
        {
          paramString1 = null;
          break;
        }
        paramString1 = paramString1.getName();
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.f.b.a
 * JD-Core Version:    0.7.0.1
 */