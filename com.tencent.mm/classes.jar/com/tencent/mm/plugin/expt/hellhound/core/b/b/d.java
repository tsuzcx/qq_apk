package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import com.tencent.mm.plugin.expt.hellhound.core.a.b.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMFragmentActivity;
import d.l;
import d.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/FragmentLauncherUIMonitor;", "", "callback", "Lcom/tencent/mm/plugin/expt/hellhound/core/IFragmentLifecycleCallback;", "(Lcom/tencent/mm/plugin/expt/hellhound/core/IFragmentLifecycleCallback;)V", "launcherUIClass", "Ljava/lang/Class;", "mActivityRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/ui/MMFragmentActivity;", "mCallback", "mChatProxy", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/ChatUIFragmentProxy;", "mLastFragmentIndex", "", "mListener", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "methodInfoMap", "Ljava/util/HashMap;", "", "", "", "Landroid/util/Pair;", "callbackMMFragmentActivityWhenResume", "", "mmfActivity", "timestamp", "", "doMonitor4MMFragmentActivity", "mmfa", "doMonitorViewPagerEvent", "fragmentPauseCallback", "fa", "Landroid/support/v4/app/FragmentActivity;", "monitor", "", "launcherUI", "onChatAction", "msgType", "onPageSelected", "position", "unmonitor", "Companion", "MethodListener", "plugin-expt_release"})
public final class d
{
  public static final d.b KEH;
  WeakReference<MMFragmentActivity> mActivityRef;
  com.tencent.mm.plugin.expt.hellhound.core.d pEP;
  Class<?> pES;
  a pET;
  private int pEU;
  c pEV;
  final HashMap<String, Map<String, List<Pair<String, String>>>> pEW;
  
  static
  {
    AppMethodBeat.i(122562);
    KEH = new d.b((byte)0);
    AppMethodBeat.o(122562);
  }
  
  public d(com.tencent.mm.plugin.expt.hellhound.core.d paramd)
  {
    AppMethodBeat.i(122561);
    this.pEW = new HashMap();
    this.pEP = paramd;
    this.pEV = ((c)new a());
    try
    {
      paramd = com.tencent.mm.plugin.expt.hellhound.core.a.b.a.pEp;
      this.pES = a.a.getClass("com.tencent.mm.ui.LauncherUI");
      this.pET = new a(this.pEP);
      paramd = new ArrayList();
      paramd.add(Pair.create("onPageSelected", "(I)V"));
      HashMap localHashMap = new HashMap();
      ((Map)localHashMap).put("android/support/v4/view/ViewPager$OnPageChangeListener", paramd);
      ((Map)this.pEW).put("com/tencent/mm/ui/MainTabUI$TabsAdapter", localHashMap);
      AppMethodBeat.o(122561);
      return;
    }
    catch (Exception paramd)
    {
      for (;;)
      {
        ad.printErrStackTrace("HABBYGE-MALI.FragmentLauncherUIMonitor", (Throwable)paramd, "FragmentLauncherUIMonitor", new Object[0]);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/FragmentLauncherUIMonitor$MethodListener;", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "(Lcom/tencent/mm/plugin/expt/hellhound/core/v2/fragment/FragmentLauncherUIMonitor;)V", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  final class a
    implements c
  {
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
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
            break label73;
          }
          i = j;
        }
        for (;;)
        {
          if (i != 0)
          {
            paramString1 = this.pEX;
            paramString2 = paramArrayOfObject[0];
            if (paramString2 == null)
            {
              paramString1 = new v("null cannot be cast to non-null type kotlin.Int");
              AppMethodBeat.o(184272);
              throw paramString1;
              i = 0;
              break;
              label73:
              i = 0;
              continue;
            }
            d.a(paramString1, ((Integer)paramString2).intValue());
          }
        }
      }
      AppMethodBeat.o(184272);
    }
    
    public final void g(String paramString, Object paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.d
 * JD-Core Version:    0.7.0.1
 */