package com.tencent.mm.plugin.expt.hellhound.a.f.g.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.preference.Preference;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/special/jd/FindMoreFriendUIMonitor;", "", "()V", "Companion", "FindMoreFriendUIListener", "plugin-expt_release"})
public final class a
{
  private static boolean pHM;
  private static boolean pHN;
  private static boolean pHO;
  private static final b pHP;
  public static final a.a pHQ;
  
  static
  {
    AppMethodBeat.i(177420);
    pHQ = new a.a((byte)0);
    pHP = new b();
    AppMethodBeat.o(177420);
  }
  
  public static final void cdL()
  {
    AppMethodBeat.i(177421);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z"));
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put("com/tencent/mm/ui/FindMoreFriendsUI", localArrayList);
    com.tencent.mm.hellhoundlib.a.adm();
    com.tencent.mm.hellhoundlib.a.a((Map)localHashMap, (c)pHP);
    AppMethodBeat.o(177421);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/special/jd/FindMoreFriendUIMonitor$FindMoreFriendUIListener;", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "()V", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  static final class b
    implements c
  {
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
      paramString1 = paramArrayOfObject[1];
      if (paramString1 == null)
      {
        paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.Preference");
        AppMethodBeat.o(184285);
        throw paramString1;
      }
      paramString1 = (Preference)paramString1;
      paramString2 = a.pHQ;
      a.kh(k.g("jd_market_entrance", paramString1.getKey()));
      paramString2 = a.pHQ;
      a.ki(k.g("find_friends_by_qrcode", paramString1.getKey()));
      paramString2 = a.pHQ;
      a.kj(k.g("find_friends_by_finder", paramString1.getKey()));
      paramString1 = paramString1.getKey();
      paramString2 = a.pHQ;
      boolean bool1 = a.cdI();
      paramString2 = a.pHQ;
      boolean bool2 = a.cdJ();
      paramString2 = a.pHQ;
      ad.i("FindMoreFriendUIMonitor", "HABBYGE-MALI, FindMoreFriendUIMonitor, runOnEnter: %s, %b, %b, %b", new Object[] { paramString1, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(a.cdK()) });
      paramString1 = a.pHQ;
      if (a.cdK())
      {
        ad.i("FindMoreFriendUIMonitor", "HABBYGE-MALI, Finder, 19354, 1");
        e.vIY.f(19354, new Object[] { Integer.valueOf(1) });
      }
      AppMethodBeat.o(184285);
    }
    
    public final void g(String paramString, Object paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a
 * JD-Core Version:    0.7.0.1
 */