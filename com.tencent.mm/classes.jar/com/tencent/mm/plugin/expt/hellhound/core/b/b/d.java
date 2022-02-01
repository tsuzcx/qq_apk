package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import com.tencent.mm.plugin.expt.hellhound.core.a.b.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMFragmentActivity;
import d.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/FragmentLauncherUIMonitor;", "", "callback", "Lcom/tencent/mm/plugin/expt/hellhound/core/IFragmentLifecycleCallback;", "(Lcom/tencent/mm/plugin/expt/hellhound/core/IFragmentLifecycleCallback;)V", "launcherUIClass", "Ljava/lang/Class;", "mActivityRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/ui/MMFragmentActivity;", "mCallback", "mChatProxy", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/ChatUIFragmentProxy;", "mLastFragmentIndex", "", "mListener", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "methodInfoMap", "Ljava/util/HashMap;", "", "", "", "Landroid/util/Pair;", "callbackMMFragmentActivityWhenResume", "", "mmfActivity", "timestamp", "", "doMonitor4MMFragmentActivity", "mmfa", "doMonitorViewPagerEvent", "fragmentPauseCallback", "fa", "Landroid/support/v4/app/FragmentActivity;", "monitor", "", "launcherUI", "onChatAction", "msgType", "onPageSelected", "position", "unmonitor", "Companion", "MethodListener", "plugin-expt_release"})
public final class d
{
  public static final d.a qjK;
  WeakReference<MMFragmentActivity> mActivityRef;
  com.tencent.mm.plugin.expt.hellhound.core.d qjC;
  Class<?> qjF;
  a qjG;
  private int qjH;
  c qjI;
  final HashMap<String, Map<String, List<Pair<String, String>>>> qjJ;
  
  static
  {
    AppMethodBeat.i(122562);
    qjK = new d.a((byte)0);
    AppMethodBeat.o(122562);
  }
  
  public d(com.tencent.mm.plugin.expt.hellhound.core.d paramd)
  {
    AppMethodBeat.i(122561);
    this.qjJ = new HashMap();
    this.qjC = paramd;
    this.qjI = ((c)new d.b(this));
    try
    {
      paramd = com.tencent.mm.plugin.expt.hellhound.core.a.b.a.qjc;
      this.qjF = a.a.getClass("com.tencent.mm.ui.LauncherUI");
      this.qjG = new a(this.qjC);
      paramd = new ArrayList();
      paramd.add(Pair.create("onPageSelected", "(I)V"));
      HashMap localHashMap = new HashMap();
      ((Map)localHashMap).put("android/support/v4/view/ViewPager$OnPageChangeListener", paramd);
      ((Map)this.qjJ).put("com/tencent/mm/ui/MainTabUI$TabsAdapter", localHashMap);
      AppMethodBeat.o(122561);
      return;
    }
    catch (Exception paramd)
    {
      for (;;)
      {
        ac.printErrStackTrace("HABBYGE-MALI.FragmentLauncherUIMonitor", (Throwable)paramd, "FragmentLauncherUIMonitor", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.d
 * JD-Core Version:    0.7.0.1
 */