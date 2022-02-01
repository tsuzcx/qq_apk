package com.tencent.mm.plugin.appbrand.ui.privacy;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.widget.pulldown.f;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"INTENT_KEY_MM_FRAGMENT_CLASS_NAME", "", "TAG", "getMMActivity", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/ui/MMFragment;", "getMMFragment", "Landroid/content/Intent;", "hideActionbarLine", "", "(Lcom/tencent/mm/ui/MMFragment;)Lkotlin/Unit;", "putMMFragment", "clazz", "Ljava/lang/Class;", "requireMMContext", "Landroid/content/Context;", "setActionbarColor", "color", "", "setNavigationbarColor", "showActionbarLine", "plugin-appbrand-integration_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final MMFragment U(Intent paramIntent)
  {
    AppMethodBeat.i(322739);
    s.u(paramIntent, "<this>");
    paramIntent = paramIntent.getStringExtra("MMFragment_ClassName");
    Log.i("MicroMsg.AppBrand.Privacy.MMFragmentExt", s.X("getMMFragment, className: ", paramIntent));
    if (paramIntent == null)
    {
      AppMethodBeat.o(322739);
      return null;
    }
    try
    {
      paramIntent = Class.forName(paramIntent).newInstance();
      if ((paramIntent instanceof MMFragment)) {}
      for (paramIntent = (MMFragment)paramIntent;; paramIntent = null)
      {
        AppMethodBeat.o(322739);
        return paramIntent;
      }
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        Log.w("MicroMsg.AppBrand.Privacy.MMFragmentExt", s.X("getMMFragment, newInstance fail since ", paramIntent));
        paramIntent = null;
      }
    }
  }
  
  public static final MMActivity a(MMFragment paramMMFragment)
  {
    AppMethodBeat.i(322745);
    s.u(paramMMFragment, "<this>");
    paramMMFragment = paramMMFragment.thisActivity();
    if ((paramMMFragment instanceof MMActivity))
    {
      paramMMFragment = (MMActivity)paramMMFragment;
      AppMethodBeat.o(322745);
      return paramMMFragment;
    }
    AppMethodBeat.o(322745);
    return null;
  }
  
  public static final void a(Intent paramIntent, Class<? extends MMFragment> paramClass)
  {
    AppMethodBeat.i(322731);
    s.u(paramIntent, "<this>");
    s.u(paramClass, "clazz");
    paramClass = paramClass.getName();
    Log.i("MicroMsg.AppBrand.Privacy.MMFragmentExt", s.X("putMMFragment, className: ", paramClass));
    paramIntent.putExtra("MMFragment_ClassName", paramClass);
    AppMethodBeat.o(322731);
  }
  
  public static final void a(MMFragment paramMMFragment, int paramInt)
  {
    AppMethodBeat.i(322755);
    s.u(paramMMFragment, "<this>");
    Object localObject = a(paramMMFragment);
    if (localObject != null)
    {
      ((MMActivity)localObject).setNavigationbarColor(paramInt);
      localObject = ah.aiuX;
      if (-1 == paramMMFragment.getCustomBounceId())
      {
        paramMMFragment = paramMMFragment.getBounceView();
        if (paramMMFragment != null) {
          paramMMFragment.setEnd2StartBgColorByNavigationBar(paramInt);
        }
      }
    }
    AppMethodBeat.o(322755);
  }
  
  public static final Context b(MMFragment paramMMFragment)
  {
    AppMethodBeat.i(322751);
    s.u(paramMMFragment, "<this>");
    paramMMFragment = a(paramMMFragment);
    if (paramMMFragment == null)
    {
      paramMMFragment = MMApplicationContext.getContext();
      s.s(paramMMFragment, "getContext()");
      AppMethodBeat.o(322751);
      return paramMMFragment;
    }
    paramMMFragment = (Context)paramMMFragment;
    AppMethodBeat.o(322751);
    return paramMMFragment;
  }
  
  public static final void b(MMFragment paramMMFragment, int paramInt)
  {
    AppMethodBeat.i(322771);
    s.u(paramMMFragment, "<this>");
    Object localObject = a(paramMMFragment);
    if (localObject != null)
    {
      ((MMActivity)localObject).setActionbarColor(paramInt);
      localObject = ah.aiuX;
      if (-1 == paramMMFragment.getCustomBounceId())
      {
        paramMMFragment = paramMMFragment.getBounceView();
        if (paramMMFragment != null) {
          paramMMFragment.setStart2EndBgColorByActionBar(paramInt);
        }
      }
    }
    AppMethodBeat.o(322771);
  }
  
  public static final ah c(MMFragment paramMMFragment)
  {
    AppMethodBeat.i(322763);
    s.u(paramMMFragment, "<this>");
    paramMMFragment = a(paramMMFragment);
    if (paramMMFragment == null)
    {
      AppMethodBeat.o(322763);
      return null;
    }
    paramMMFragment.hideActionbarLine();
    paramMMFragment = ah.aiuX;
    AppMethodBeat.o(322763);
    return paramMMFragment;
  }
  
  public static final ah d(MMFragment paramMMFragment)
  {
    AppMethodBeat.i(322766);
    s.u(paramMMFragment, "<this>");
    paramMMFragment = a(paramMMFragment);
    if (paramMMFragment == null)
    {
      AppMethodBeat.o(322766);
      return null;
    }
    paramMMFragment.showActionbarLine();
    paramMMFragment = ah.aiuX;
    AppMethodBeat.o(322766);
    return paramMMFragment;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.privacy.d
 * JD-Core Version:    0.7.0.1
 */