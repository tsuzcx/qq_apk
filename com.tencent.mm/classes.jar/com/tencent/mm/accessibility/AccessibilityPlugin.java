package com.tencent.mm.accessibility;

import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.core.AccReporter;
import com.tencent.mm.accessibility.uitl.AccUtil;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.util.b.a;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/AccessibilityPlugin;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/kernel/plugin/IPlugin;", "Lcom/tencent/mm/kernel/api/bucket/ICoreAccountCallbackBucket;", "()V", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "Companion", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AccessibilityPlugin
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, d
{
  public static final String CLASS = "com.tencent.mm.accessibility.AccessibilityPlugin";
  public static final Companion Companion;
  public static final String TAG = "MicroMsg.Acc.AccessibilityPlugin";
  
  static
  {
    AppMethodBeat.i(234108);
    Companion = new Companion(null);
    AppMethodBeat.o(234108);
  }
  
  private static final void execute$lambda-0(boolean paramBoolean)
  {
    AppMethodBeat.i(234101);
    AccUtil.INSTANCE.setTouchExplorationEnable$plugin_autoaccessibility_release(paramBoolean);
    AppMethodBeat.o(234101);
  }
  
  private static final void onAccountInitialized$lambda-5()
  {
    AppMethodBeat.i(234107);
    String str = ((a)com.tencent.mm.kernel.h.ax(a.class)).aRC().getValue("_AutoAccessibility_WhiteList");
    if (str != null) {
      if (((CharSequence)str).length() <= 0) {
        break label74;
      }
    }
    label74:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        AccUtil.INSTANCE.setWhileList(n.a((CharSequence)str, new String[] { ";" }));
      }
      AppMethodBeat.o(234107);
      return;
    }
  }
  
  public final void execute(g paramg)
  {
    AppMethodBeat.i(234120);
    paramg = MMApplicationContext.getContext().getSystemService("accessibility");
    if ((paramg instanceof AccessibilityManager)) {}
    for (paramg = (AccessibilityManager)paramg; paramg == null; paramg = null)
    {
      AppMethodBeat.o(234120);
      return;
    }
    AccUtil.INSTANCE.setTouchExplorationEnable$plugin_autoaccessibility_release(paramg.isTouchExplorationEnabled());
    androidx.core.g.a.c.a(paramg, AccessibilityPlugin..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(234120);
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    boolean bool2 = true;
    AppMethodBeat.i(234129);
    paramc = AccUtil.INSTANCE;
    int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zwK, 0);
    Log.i("MicroMsg.Acc.AccessibilityPlugin", s.X("isGlobalDisableAcc = ", Integer.valueOf(i)));
    ah localah = ah.aiuX;
    if (i == 1)
    {
      bool1 = true;
      paramc.setGlobalDisableAcc(bool1);
      paramc = AccUtil.INSTANCE;
      i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zwM, b.a.agrr, 0);
      Log.i("MicroMsg.Acc.AccessibilityPlugin", s.X("isEnableAccEnableForced = ", Integer.valueOf(i)));
      localah = ah.aiuX;
      if (i != 1) {
        break label203;
      }
      bool1 = true;
      label112:
      paramc.setEnableAccEnableForced(bool1);
      paramc = AccUtil.INSTANCE;
      i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zwL, b.a.agrt, 1);
      Log.i("MicroMsg.Acc.AccessibilityPlugin", s.X("isEnableExpand = ", Integer.valueOf(i)));
      localah = ah.aiuX;
      if (i != 1) {
        break label208;
      }
    }
    label203:
    label208:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramc.setEnableExpand(bool1);
      com.tencent.threadpool.h.ahAA.bm(AccessibilityPlugin..ExternalSyntheticLambda1.INSTANCE);
      AccReporter.INSTANCE.initListener();
      AppMethodBeat.o(234129);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label112;
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(234133);
    AccReporter.INSTANCE.releaseListener();
    AppMethodBeat.o(234133);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/AccessibilityPlugin$Companion;", "", "()V", "CLASS", "", "TAG", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.accessibility.AccessibilityPlugin
 * JD-Core Version:    0.7.0.1
 */