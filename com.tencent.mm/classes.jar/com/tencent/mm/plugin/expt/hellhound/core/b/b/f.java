package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.d.b;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.j;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.c;
import com.tencent.mm.plugin.expt.hellhound.core.a.b.a.a;
import com.tencent.mm.protocal.protobuf.apq;
import com.tencent.mm.protocal.protobuf.apr;
import com.tencent.mm.protocal.protobuf.bj;
import com.tencent.mm.protocal.protobuf.dhz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMFragmentActivity;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Map;

public final class f
  implements com.tencent.mm.plugin.expt.hellhound.core.d, com.tencent.mm.plugin.expt.hellhound.core.e
{
  private e qjN;
  private d.b qjO;
  private final com.tencent.mm.plugin.expt.hellhound.core.b.b.a.a qjP;
  boolean qjt;
  
  public f()
  {
    AppMethodBeat.i(121997);
    this.qjP = new com.tencent.mm.plugin.expt.hellhound.core.b.b.a.a()
    {
      public final void T(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(184317);
        ac.i("HABBYGE-MALI.FragmentMonitor", "mHijackCallback, event: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (f.this.qjt)
        {
          c.ciO().l(com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.Ck(paramAnonymousInt), Long.valueOf(paramAnonymousLong));
          AppMethodBeat.o(184317);
          return;
        }
        f.this.S(paramAnonymousInt, paramAnonymousLong);
        AppMethodBeat.o(184317);
      }
    };
    this.qjN = new e(this);
    this.qjt = com.tencent.mm.plugin.expt.hellhound.a.ciB();
    AppMethodBeat.o(121997);
  }
  
  private void Z(String paramString, long paramLong)
  {
    AppMethodBeat.i(184329);
    if (this.qjO != null) {
      this.qjO.m("Biz", paramString, paramLong);
    }
    AppMethodBeat.o(184329);
  }
  
  private void a(FragmentActivity paramFragmentActivity, Fragment paramFragment, String paramString, long paramLong)
  {
    AppMethodBeat.i(184322);
    if (paramFragment != null) {
      b.Y(paramFragment.getArguments());
    }
    b(paramFragmentActivity, paramFragment, paramString, paramLong);
    AppMethodBeat.o(184322);
  }
  
  private void a(FragmentActivity paramFragmentActivity, String paramString, long paramLong)
  {
    AppMethodBeat.i(184326);
    if ((paramFragmentActivity == null) && (paramString == null))
    {
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciR();
      paramFragmentActivity = com.tencent.mm.plugin.expt.hellhound.core.stack.e.ciW();
      if (paramFragmentActivity != null) {
        Z(paramFragmentActivity.DOc.activityName, paramLong);
      }
      AppMethodBeat.o(184326);
      return;
    }
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(184326);
      return;
    }
    String str = paramFragmentActivity.getClass().getCanonicalName();
    ac.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor, _onPause: %s, %s", new Object[] { str, paramString });
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciR();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.fG(str, paramString);
    com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b localb;
    int i;
    if (paramString.equals(com.tencent.mm.plugin.expt.hellhound.core.b.qiK))
    {
      ac.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor, MoreTabUI, _onPause-2");
      localb = com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.cjj();
      localb.e(paramFragmentActivity);
      i = localb.iie;
      if ((i != 1) && (i != -1)) {
        break label172;
      }
      ac.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor, MoreTabUI, _onPause-2");
    }
    label172:
    while (i != 0)
    {
      if (this.qjO != null) {
        this.qjO.m(str, paramString, paramLong);
      }
      AppMethodBeat.o(184326);
      return;
    }
    ac.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor, StoryGalleryView, _onPause");
    localb.iie = -1;
    if (this.qjO != null) {
      this.qjO.O(3, paramLong);
    }
    AppMethodBeat.o(184326);
  }
  
  private static boolean a(FragmentActivity paramFragmentActivity, String paramString)
  {
    AppMethodBeat.i(122012);
    try
    {
      paramFragmentActivity = g.c(paramFragmentActivity, paramString);
      paramString = Class.forName(com.tencent.mm.plugin.expt.hellhound.core.b.qiK).getDeclaredField("storyGallery");
      paramString.setAccessible(true);
      paramFragmentActivity = paramString.get(paramFragmentActivity);
      paramString = Class.forName("com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView").getDeclaredField("mIsActive");
      paramString.setAccessible(true);
      bool = ((Boolean)paramString.get(paramFragmentActivity)).booleanValue();
      ac.d("HABBYGE-MALI.FragmentMonitor", "isStoryGalleryActive: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(122012);
      return bool;
    }
    catch (Exception paramFragmentActivity)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
  }
  
  private void b(FragmentActivity paramFragmentActivity, Fragment paramFragment, String paramString, long paramLong)
  {
    AppMethodBeat.i(184323);
    if ((paramFragmentActivity == null) && (paramFragment == null) && (paramString == null))
    {
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciR();
      paramFragmentActivity = com.tencent.mm.plugin.expt.hellhound.core.stack.e.ciW();
      if (paramFragmentActivity != null)
      {
        ac.i("HABBYGE-MALI.FragmentMonitor", "onFragmentResume -> _onResumeForBiz --2");
        if (this.qjO != null) {
          this.qjO.l("Biz", paramFragmentActivity.DOc.activityName, paramLong);
        }
      }
      AppMethodBeat.o(184323);
      return;
    }
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(184323);
      return;
    }
    paramFragment = paramFragmentActivity.getClass().getCanonicalName();
    ac.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor, _onResume: %s, %s", new Object[] { paramFragment, paramString });
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciR();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.fF(paramFragment, paramString);
    int i;
    if (paramString.equals(com.tencent.mm.plugin.expt.hellhound.core.b.qiK))
    {
      ac.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor, MoreTabUI, onResume-1");
      com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b localb = com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.cjj();
      localb.a(paramFragmentActivity, this.qjP);
      i = localb.iie;
      if ((i != 1) && (i != -1)) {
        break label199;
      }
      ac.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor, MoreTabUI, _onResume-2");
    }
    label199:
    while (i != 0)
    {
      if (this.qjO != null) {
        this.qjO.l(paramFragment, paramString, paramLong);
      }
      AppMethodBeat.o(184323);
      return;
    }
    boolean bool = a(paramFragmentActivity, paramString);
    ac.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor, StoryGalleryView, _onResume: %b", new Object[] { Boolean.valueOf(bool) });
    if ((bool) && (this.qjO != null)) {
      this.qjO.N(2, paramLong);
    }
    AppMethodBeat.o(184323);
  }
  
  public static boolean b(FragmentActivity paramFragmentActivity, String paramString)
  {
    AppMethodBeat.i(122013);
    try
    {
      paramFragmentActivity = g.c(paramFragmentActivity, paramString);
      paramString = Class.forName(com.tencent.mm.plugin.expt.hellhound.core.b.qiK).getDeclaredField("storyGallery");
      paramString.setAccessible(true);
      paramFragmentActivity = paramString.get(paramFragmentActivity);
      paramString = Class.forName("com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView").getDeclaredField("holderView");
      paramString.setAccessible(true);
      paramFragmentActivity = (View)paramString.get(paramFragmentActivity);
      if (paramFragmentActivity == null)
      {
        ac.i("HABBYGE-MALI.FragmentMonitor", "isStoryGalleryShow = NULL");
        AppMethodBeat.o(122013);
        return false;
      }
    }
    catch (Exception paramFragmentActivity)
    {
      for (;;)
      {
        paramFragmentActivity = null;
      }
    }
    if (paramFragmentActivity.getVisibility() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("HABBYGE-MALI.FragmentMonitor", "isStoryGalleryShow: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(122013);
      return bool;
    }
  }
  
  public final void P(int paramInt, long paramLong)
  {
    AppMethodBeat.i(184327);
    a locala = this.qjN.qjM.qjG;
    if (locala != null)
    {
      locala.R(paramInt, paramLong);
      AppMethodBeat.o(184327);
      return;
    }
    AppMethodBeat.o(184327);
  }
  
  public final void Q(int paramInt, long paramLong)
  {
    AppMethodBeat.i(184330);
    S(com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.Cl(paramInt), paramLong);
    AppMethodBeat.o(184330);
  }
  
  final void S(int paramInt, long paramLong)
  {
    AppMethodBeat.i(184331);
    ac.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor, _onStoryCallback: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 0)
    {
      if (this.qjO != null)
      {
        this.qjO.N(0, paramLong);
        AppMethodBeat.o(184331);
      }
    }
    else if ((paramInt == 1) && (this.qjO != null)) {
      this.qjO.O(1, paramLong);
    }
    AppMethodBeat.o(184331);
  }
  
  public final void a(Activity paramActivity, long paramLong)
  {
    String str = null;
    AppMethodBeat.i(184318);
    if (!com.tencent.mm.plugin.expt.hellhound.a.ciw())
    {
      AppMethodBeat.o(184318);
      return;
    }
    Object localObject1;
    Object localObject2;
    if ((paramActivity instanceof FragmentActivity))
    {
      localObject1 = this.qjN;
      paramActivity = (FragmentActivity)paramActivity;
      localObject1 = ((e)localObject1).qjM;
      if (((d)localObject1).qjF != null)
      {
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.a.b.a.qjc;
        if (a.a.c(paramActivity, ((d)localObject1).qjF)) {}
      }
      else
      {
        AppMethodBeat.o(184318);
        return;
      }
      if ((paramActivity instanceof MMFragmentActivity)) {
        break label393;
      }
      paramActivity = null;
    }
    label386:
    label393:
    for (;;)
    {
      localObject2 = (MMFragmentActivity)paramActivity;
      Fragment localFragment = g.ab((Activity)localObject2);
      if (localFragment != null)
      {
        ac.i("HABBYGE-MALI.FragmentLauncherUIMonitor", "callbackMMFragmentActivityWhenResume: " + localFragment.getClass().getName());
        if (((d)localObject1).qjC != null)
        {
          paramActivity = str;
          if (localObject2 != null)
          {
            Class localClass = localObject2.getClass();
            paramActivity = str;
            if (localClass != null) {
              paramActivity = localClass.getCanonicalName();
            }
          }
          str = localFragment.getClass().getCanonicalName();
          ac.i("HABBYGE-MALI.FragmentLauncherUIMonitor", "callbackMMFActivityWhenResume, %s, %s", new Object[] { paramActivity, str });
          if (!com.tencent.mm.plugin.expt.hellhound.core.b.ZE(paramActivity))
          {
            paramActivity = ((d)localObject1).qjC;
            if (paramActivity != null) {
              paramActivity.a((FragmentActivity)localObject2, localFragment, str, paramLong, true);
            }
          }
        }
      }
      for (;;)
      {
        if (localObject2 != null)
        {
          ((d)localObject1).mActivityRef = new WeakReference(localObject2);
          com.tencent.mm.hellhoundlib.a.aeC();
          com.tencent.mm.hellhoundlib.a.e((Map)((d)localObject1).qjJ, ((d)localObject1).qjI);
        }
        paramActivity = ((d)localObject1).qjG;
        if (paramActivity == null) {
          break label386;
        }
        if (!com.tencent.mm.sdk.b.a.GpY.e(paramActivity.qjD)) {
          break;
        }
        ac.i("HABBYGE-MALI.ChatUIFragmentProxy", "ChatUIFragmentProxy, startMonitor-1");
        AppMethodBeat.o(184318);
        return;
        ac.w("HABBYGE-MALI.FragmentLauncherUIMonitor", "callbackMMFragmentActivityWhenResume curFragment == null");
        paramActivity = ((d)localObject1).qjC;
        if (paramActivity != null) {
          paramActivity.a((FragmentActivity)localObject2, null, com.tencent.mm.plugin.expt.hellhound.core.b.qiH, paramLong, true);
        }
      }
      ac.i("HABBYGE-MALI.ChatUIFragmentProxy", "ChatUIFragmentProxy, startMonitor-2");
      com.tencent.mm.sdk.b.a.GpY.b(paramActivity.qjD);
      AppMethodBeat.o(184318);
      return;
      AppMethodBeat.o(184318);
      return;
    }
  }
  
  public final void a(FragmentActivity paramFragmentActivity, Fragment paramFragment, String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(184320);
    if (paramBoolean)
    {
      if (this.qjt)
      {
        apr localapr = new apr();
        if (paramFragment != null)
        {
          paramFragment = paramFragment.getArguments();
          if (paramFragment != null) {
            localapr.EIG = paramFragment.getString("Chat_User");
          }
        }
        localapr.EIF = paramString;
        localapr.EIH = true;
        localapr.timestamp = paramLong;
        localapr.EIE = new dhz();
        if (paramFragmentActivity != null)
        {
          localapr.EIE.activityName = paramFragmentActivity.getClass().getCanonicalName();
          localapr.EIE.EIR = String.valueOf(paramFragmentActivity.hashCode());
          localapr.EIE.timestamp = paramLong;
        }
        if (paramFragmentActivity != null)
        {
          localapr.EII = a(paramFragmentActivity, paramString);
          if (com.tencent.mm.plugin.expt.hellhound.core.b.qiK.equals(paramString)) {
            com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.cjj().a(paramFragmentActivity, this.qjP);
          }
        }
        c.ciO().l(5, localapr);
        AppMethodBeat.o(184320);
        return;
      }
      a(paramFragmentActivity, paramFragment, paramString, paramLong);
      AppMethodBeat.o(184320);
      return;
    }
    a(paramFragmentActivity, paramFragment, paramString, paramLong);
    AppMethodBeat.o(184320);
  }
  
  public final void a(FragmentActivity paramFragmentActivity, String paramString, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(184325);
    if (paramBoolean)
    {
      if (this.qjt)
      {
        apq localapq = new apq();
        localapq.EIE = new dhz();
        if (paramFragmentActivity != null)
        {
          localapq.EIE.activityName = paramFragmentActivity.getClass().getCanonicalName();
          localapq.EIE.EIR = String.valueOf(paramFragmentActivity.hashCode());
          localapq.EIE.timestamp = paramLong;
        }
        localapq.EIF = paramString;
        localapq.timestamp = paramLong;
        if ((paramFragmentActivity != null) && (com.tencent.mm.plugin.expt.hellhound.core.b.qiK.equals(paramString)))
        {
          ac.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor, stopStoryMonitor: %s", new Object[] { paramString });
          com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.cjj().e(paramFragmentActivity);
        }
        c.ciO().l(6, localapq);
        AppMethodBeat.o(184325);
        return;
      }
      a(paramFragmentActivity, paramString, paramLong);
      AppMethodBeat.o(184325);
      return;
    }
    a(paramFragmentActivity, paramString, paramLong);
    AppMethodBeat.o(184325);
  }
  
  public final void a(apq paramapq)
  {
    AppMethodBeat.i(184324);
    dhz localdhz = paramapq.EIE;
    String str = paramapq.EIF;
    long l = paramapq.timestamp;
    if ((localdhz == null) || (TextUtils.isEmpty(localdhz.activityName)))
    {
      ac.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor _onFragmentPause, Biz");
      if (this.qjO != null) {
        this.qjO.m("Biz", str, l);
      }
      AppMethodBeat.o(184324);
      return;
    }
    ac.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor, _onPause: %s, %s", new Object[] { localdhz.activityName, str });
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciR();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.fG(localdhz.activityName, str);
    int i;
    if (str.equals(com.tencent.mm.plugin.expt.hellhound.core.b.qiK))
    {
      ac.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor, MoreTabUI, _onPause-1");
      paramapq = com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.cjj();
      i = paramapq.iie;
      if ((i != 1) && (i != -1)) {
        break label189;
      }
      ac.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor, MoreTabUI, _onPause-2");
    }
    label189:
    while (i != 0)
    {
      if (this.qjO != null) {
        this.qjO.m(localdhz.activityName, str, l);
      }
      AppMethodBeat.o(184324);
      return;
    }
    ac.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor, StoryGalleryView, _onPause");
    paramapq.iie = -1;
    if (this.qjO != null) {
      this.qjO.O(3, l);
    }
    AppMethodBeat.o(184324);
  }
  
  public final void a(apr paramapr)
  {
    AppMethodBeat.i(184321);
    Object localObject = paramapr.EIG;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      b.fH("Chat_User", (String)localObject);
    }
    localObject = paramapr.EIE;
    String str = paramapr.EIF;
    boolean bool = paramapr.EII;
    long l = paramapr.timestamp;
    if (localObject == null)
    {
      if (this.qjO != null) {
        this.qjO.l("Biz", str, l);
      }
      AppMethodBeat.o(184321);
      return;
    }
    int i;
    if (!TextUtils.isEmpty(((dhz)localObject).activityName))
    {
      ac.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor, _onResume: %s, %s", new Object[] { ((dhz)localObject).activityName, str });
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciR();
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.fF(((dhz)localObject).activityName, str);
      if (com.tencent.mm.plugin.expt.hellhound.core.b.qiK.equals(str))
      {
        ac.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor, MoreTabUI, onResume-1");
        i = com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.cjj().iie;
        if ((i != 1) && (i != -1)) {
          break label208;
        }
        ac.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor, MoreTabUI, _onResume-2");
      }
    }
    label208:
    while (i != 0)
    {
      if (this.qjO != null) {
        this.qjO.l(((dhz)localObject).activityName, str, l);
      }
      AppMethodBeat.o(184321);
      return;
    }
    ac.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor, StoryGalleryView, _onResume: %b", new Object[] { Boolean.valueOf(bool) });
    if ((bool) && (this.qjO != null)) {
      this.qjO.N(2, l);
    }
    AppMethodBeat.o(184321);
  }
  
  public final void b(Activity paramActivity, long paramLong)
  {
    AppMethodBeat.i(184319);
    if ((paramActivity instanceof FragmentActivity))
    {
      localObject1 = this.qjN;
      paramActivity = (FragmentActivity)paramActivity;
      localObject1 = ((e)localObject1).qjM;
      a.a locala = com.tencent.mm.plugin.expt.hellhound.core.a.b.a.qjc;
      if (a.a.c(paramActivity, ((d)localObject1).qjF))
      {
        com.tencent.mm.hellhoundlib.a.aeC();
        com.tencent.mm.hellhoundlib.a.f((Map)((d)localObject1).qjJ, ((d)localObject1).qjI);
        ac.i("HABBYGE-MALI.FragmentLauncherUIMonitor", "unmonitor !!!");
        if (paramActivity == null) {}
      }
    }
    try
    {
      boolean bool = com.tencent.mm.plugin.expt.hellhound.core.b.ZE(paramActivity.getClass().getCanonicalName());
      if (!bool) {
        break label142;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("HABBYGE-MALI.FragmentLauncherUIMonitor", (Throwable)localException, "fragmentGoneCallback", new Object[0]);
        Object localObject2 = g.ab((Activity)paramActivity);
        if (localObject2 != null)
        {
          localObject2 = localObject2.getClass().getCanonicalName();
          ac.i("HABBYGE-MALI.FragmentLauncherUIMonitor", "fragmentPauseCallback: curFragment = ".concat(String.valueOf(localObject2)));
          com.tencent.mm.plugin.expt.hellhound.core.d locald = ((d)localObject1).qjC;
          if (locald != null) {
            locald.a(paramActivity, (String)localObject2, paramLong, true);
          }
        }
        else
        {
          ac.i("HABBYGE-MALI.FragmentLauncherUIMonitor", "fragmentGoneCallback unmonitor: curFragment = null");
        }
      }
    }
    if (((d)localObject1).qjG != null) {
      ac.i("HABBYGE-MALI.ChatUIFragmentProxy", "ChatUIFragmentProxy, stopMonitor");
    }
    AppMethodBeat.o(184319);
  }
  
  public final void b(d.b paramb)
  {
    AppMethodBeat.i(195208);
    this.qjO = paramb;
    j.a(this);
    AppMethodBeat.o(195208);
  }
  
  public final void sT(long paramLong)
  {
    AppMethodBeat.i(184328);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.ciR();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.fG("com.tencent.mm.ui.LauncherUI", com.tencent.mm.plugin.expt.hellhound.core.b.qiL);
    ac.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor onChattingUIFragmentFinish");
    if (this.qjO != null) {
      this.qjO.sS(paramLong);
    }
    AppMethodBeat.o(184328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.f
 * JD-Core Version:    0.7.0.1
 */