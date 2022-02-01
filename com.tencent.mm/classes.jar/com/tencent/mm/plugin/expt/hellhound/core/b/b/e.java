package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b.a;
import com.tencent.mm.plugin.expt.hellhound.core.a.b.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/FragmentLauncherUIMonitor;", "", "callback", "Lcom/tencent/mm/plugin/expt/hellhound/core/IFragmentLifecycleCallback;", "(Lcom/tencent/mm/plugin/expt/hellhound/core/IFragmentLifecycleCallback;)V", "launcherUIClass", "Ljava/lang/Class;", "mActivityRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/ui/MMFragmentActivity;", "mCallback", "mChatProxy", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/ChatUIFragmentProxy;", "mHasScrollChanged", "", "mLastFragmentIndex", "", "mListener", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "methodInfoMap", "Ljava/util/HashMap;", "", "", "", "Landroid/util/Pair;", "callbackMMFragmentActivityWhenResume", "", "mmfActivity", "timestamp", "", "doMonitor4MMFragmentActivity", "mmfa", "doMonitorViewPagerEvent", "fragmentPauseCallback", "fa", "Landroidx/fragment/app/FragmentActivity;", "monitor", "launcherUI", "onChatAction", "msgType", "onPageScrollStateChanged", "state", "onPageSelected", "position", "onSwipEvent", "lf", "Landroidx/fragment/app/Fragment;", "registerHellEventListener", "listener", "Lcom/tencent/mm/plugin/expt/api/IHellhoundService$IHellEventListener;", "unmonitor", "unregisterHellEventListener", "Companion", "MethodListener", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e.a zBU;
  WeakReference<MMFragmentActivity> mActivityRef;
  com.tencent.mm.plugin.expt.hellhound.core.d zBV;
  Class<?> zBW;
  b zBX;
  private int zBY;
  com.tencent.mm.hellhoundlib.a.d zBZ;
  final HashMap<String, Map<String, List<Pair<String, String>>>> zCa;
  private boolean zCb;
  
  static
  {
    AppMethodBeat.i(122562);
    zBU = new e.a((byte)0);
    AppMethodBeat.o(122562);
  }
  
  public e(com.tencent.mm.plugin.expt.hellhound.core.d paramd)
  {
    AppMethodBeat.i(122561);
    this.zCa = new HashMap();
    this.zBV = paramd;
    this.zBZ = ((com.tencent.mm.hellhoundlib.a.d)new b());
    try
    {
      paramd = a.zBn;
      this.zBW = a.a.getClass("com.tencent.mm.ui.LauncherUI");
      this.zBX = new b(this.zBV);
      paramd = new ArrayList();
      paramd.add(Pair.create("onPageSelected", "(I)V"));
      paramd.add(Pair.create("onPageScrollStateChanged", "(I)V"));
      HashMap localHashMap = new HashMap();
      ((Map)localHashMap).put("androidx/viewpager/widget/ViewPager$OnPageChangeListener", paramd);
      ((Map)this.zCa).put("com/tencent/mm/ui/MainTabUI$TabsAdapter", localHashMap);
      AppMethodBeat.o(122561);
      return;
    }
    catch (Exception paramd)
    {
      for (;;)
      {
        Log.printErrStackTrace("HABBYGE-MALI.FragmentLauncherUIMonitor", (Throwable)paramd, "FragmentLauncherUIMonitor", new Object[0]);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/FragmentLauncherUIMonitor$MethodListener;", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "(Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/FragmentLauncherUIMonitor;)V", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class b
    implements com.tencent.mm.hellhoundlib.a.d
  {
    public b()
    {
      AppMethodBeat.i(299976);
      AppMethodBeat.o(299976);
    }
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      int j = 1;
      AppMethodBeat.i(184272);
      if (paramArrayOfObject != null)
      {
        int i;
        if (paramArrayOfObject.length == 0)
        {
          i = 1;
          if (i != 0) {
            break label74;
          }
          i = j;
        }
        for (;;)
        {
          if (i != 0)
          {
            if (s.p(paramString2, "onPageSelected"))
            {
              e.a(this.zCc, ((Integer)paramArrayOfObject[0]).intValue());
              AppMethodBeat.o(184272);
              return;
              i = 0;
              break;
              label74:
              i = 0;
              continue;
            }
            if (s.p(paramString2, "onPageScrollStateChanged")) {
              e.b(this.zCc, ((Integer)paramArrayOfObject[0]).intValue());
            }
          }
        }
      }
      AppMethodBeat.o(184272);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.e
 * JD-Core Version:    0.7.0.1
 */