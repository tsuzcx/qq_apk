package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import com.tencent.mm.plugin.expt.hellhound.core.a.b.a;
import com.tencent.mm.plugin.expt.hellhound.core.a.b.a.a;
import com.tencent.mm.plugin.expt.hellhound.core.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMFragmentActivity;
import d.g.b.p;
import d.l;
import d.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/FragmentLauncherUIMonitor;", "", "callback", "Lcom/tencent/mm/plugin/expt/hellhound/core/IFragmentLifecycleCallback;", "(Lcom/tencent/mm/plugin/expt/hellhound/core/IFragmentLifecycleCallback;)V", "launcherUIClass", "Ljava/lang/Class;", "mActivityRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/ui/MMFragmentActivity;", "mCallback", "mChatProxy", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/ChatUIFragmentProxy;", "mHasScrollChanged", "", "mLastFragmentIndex", "", "mListener", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "methodInfoMap", "Ljava/util/HashMap;", "", "", "", "Landroid/util/Pair;", "callbackMMFragmentActivityWhenResume", "", "mmfActivity", "timestamp", "", "doMonitor4MMFragmentActivity", "mmfa", "doMonitorViewPagerEvent", "fragmentPauseCallback", "fa", "Landroid/support/v4/app/FragmentActivity;", "monitor", "launcherUI", "onChatAction", "msgType", "onPageScrollStateChanged", "state", "onPageSelected", "position", "onSwipEvent", "lf", "Landroid/support/v4/app/Fragment;", "unmonitor", "Companion", "MethodListener", "plugin-expt_release"})
public final class e
{
  public static final e.a qZP;
  WeakReference<MMFragmentActivity> mActivityRef;
  d qZI;
  Class<?> qZJ;
  b qZK;
  private int qZL;
  c qZM;
  final HashMap<String, Map<String, List<Pair<String, String>>>> qZN;
  private boolean qZO;
  
  static
  {
    AppMethodBeat.i(122562);
    qZP = new e.a((byte)0);
    AppMethodBeat.o(122562);
  }
  
  public e(d paramd)
  {
    AppMethodBeat.i(122561);
    this.qZN = new HashMap();
    this.qZI = paramd;
    this.qZM = ((c)new b());
    try
    {
      paramd = a.qZa;
      this.qZJ = a.a.getClass("com.tencent.mm.ui.LauncherUI");
      this.qZK = new b(this.qZI);
      paramd = new ArrayList();
      paramd.add(Pair.create("onPageSelected", "(I)V"));
      paramd.add(Pair.create("onPageScrollStateChanged", "(I)V"));
      HashMap localHashMap = new HashMap();
      ((Map)localHashMap).put("android/support/v4/view/ViewPager$OnPageChangeListener", paramd);
      ((Map)this.qZN).put("com/tencent/mm/ui/MainTabUI$TabsAdapter", localHashMap);
      AppMethodBeat.o(122561);
      return;
    }
    catch (Exception paramd)
    {
      for (;;)
      {
        ae.printErrStackTrace("HABBYGE-MALI.FragmentLauncherUIMonitor", (Throwable)paramd, "FragmentLauncherUIMonitor", new Object[0]);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/FragmentLauncherUIMonitor$MethodListener;", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "(Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/FragmentLauncherUIMonitor;)V", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  final class b
    implements c
  {
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
            break label82;
          }
          i = j;
        }
        for (;;)
        {
          if (i != 0)
          {
            if (p.i(paramString2, "onPageSelected"))
            {
              paramString1 = this.qZQ;
              paramString2 = paramArrayOfObject[0];
              if (paramString2 == null)
              {
                paramString1 = new v("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(184272);
                throw paramString1;
                i = 0;
                break;
                label82:
                i = 0;
                continue;
              }
              e.a(paramString1, ((Integer)paramString2).intValue());
              AppMethodBeat.o(184272);
              return;
            }
            if (p.i(paramString2, "onPageScrollStateChanged"))
            {
              paramString1 = this.qZQ;
              paramString2 = paramArrayOfObject[0];
              if (paramString2 == null)
              {
                paramString1 = new v("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(184272);
                throw paramString1;
              }
              e.b(paramString1, ((Integer)paramString2).intValue());
            }
          }
        }
      }
      AppMethodBeat.o(184272);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.e
 * JD-Core Version:    0.7.0.1
 */