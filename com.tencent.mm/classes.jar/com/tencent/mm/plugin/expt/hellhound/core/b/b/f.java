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
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.amo;
import com.tencent.mm.protocal.protobuf.bh;
import com.tencent.mm.protocal.protobuf.dcm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMFragmentActivity;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Map;

public final class f
  implements com.tencent.mm.plugin.expt.hellhound.core.d, com.tencent.mm.plugin.expt.hellhound.core.e
{
  boolean pEG;
  private e pEZ;
  private d.b pFa;
  private final com.tencent.mm.plugin.expt.hellhound.core.b.b.a.a pFb;
  
  public f()
  {
    AppMethodBeat.i(121997);
    this.pFb = new com.tencent.mm.plugin.expt.hellhound.core.b.b.a.a()
    {
      public final void U(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(184317);
        ad.i("HABBYGE-MALI.FragmentMonitor", "mHijackCallback, event: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (f.this.pEG)
        {
          c.cbD().l(com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.Bs(paramAnonymousInt), Long.valueOf(paramAnonymousLong));
          AppMethodBeat.o(184317);
          return;
        }
        f.this.T(paramAnonymousInt, paramAnonymousLong);
        AppMethodBeat.o(184317);
      }
    };
    this.pEZ = new e(this);
    this.pEG = com.tencent.mm.plugin.expt.hellhound.a.cbs();
    AppMethodBeat.o(121997);
  }
  
  private void Y(String paramString, long paramLong)
  {
    AppMethodBeat.i(184329);
    if (this.pFa != null) {
      this.pFa.m("Biz", paramString, paramLong);
    }
    AppMethodBeat.o(184329);
  }
  
  private void a(FragmentActivity paramFragmentActivity, Fragment paramFragment, String paramString, long paramLong)
  {
    AppMethodBeat.i(184322);
    if (paramFragment != null) {
      b.X(paramFragment.getArguments());
    }
    b(paramFragmentActivity, paramFragment, paramString, paramLong);
    AppMethodBeat.o(184322);
  }
  
  private void a(FragmentActivity paramFragmentActivity, String paramString, long paramLong)
  {
    AppMethodBeat.i(184326);
    if ((paramFragmentActivity == null) && (paramString == null))
    {
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
      paramFragmentActivity = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cbL();
      if (paramFragmentActivity != null) {
        Y(paramFragmentActivity.CvH.activityName, paramLong);
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
    ad.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor, _onPause: %s, %s", new Object[] { str, paramString });
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.ft(str, paramString);
    com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b localb;
    int i;
    if (paramString.equals(com.tencent.mm.plugin.expt.hellhound.core.b.pDX))
    {
      ad.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor, MoreTabUI, _onPause-2");
      localb = com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.cbX();
      localb.d(paramFragmentActivity);
      i = localb.hHC;
      if ((i != 1) && (i != -1)) {
        break label172;
      }
      ad.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor, MoreTabUI, _onPause-2");
    }
    label172:
    while (i != 0)
    {
      if (this.pFa != null) {
        this.pFa.m(str, paramString, paramLong);
      }
      AppMethodBeat.o(184326);
      return;
    }
    ad.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor, StoryGalleryView, _onPause");
    localb.hHC = -1;
    if (this.pFa != null) {
      this.pFa.P(3, paramLong);
    }
    AppMethodBeat.o(184326);
  }
  
  private static boolean a(FragmentActivity paramFragmentActivity, String paramString)
  {
    AppMethodBeat.i(122012);
    try
    {
      paramFragmentActivity = g.c(paramFragmentActivity, paramString);
      paramString = Class.forName(com.tencent.mm.plugin.expt.hellhound.core.b.pDX).getDeclaredField("storyGallery");
      paramString.setAccessible(true);
      paramFragmentActivity = paramString.get(paramFragmentActivity);
      paramString = Class.forName("com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView").getDeclaredField("mIsActive");
      paramString.setAccessible(true);
      bool = ((Boolean)paramString.get(paramFragmentActivity)).booleanValue();
      ad.d("HABBYGE-MALI.FragmentMonitor", "isStoryGalleryActive: %b", new Object[] { Boolean.valueOf(bool) });
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
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
      paramFragmentActivity = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cbL();
      if (paramFragmentActivity != null)
      {
        ad.i("HABBYGE-MALI.FragmentMonitor", "onFragmentResume -> _onResumeForBiz --2");
        if (this.pFa != null) {
          this.pFa.l("Biz", paramFragmentActivity.CvH.activityName, paramLong);
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
    ad.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor, _onResume: %s, %s", new Object[] { paramFragment, paramString });
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.fs(paramFragment, paramString);
    int i;
    if (paramString.equals(com.tencent.mm.plugin.expt.hellhound.core.b.pDX))
    {
      ad.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor, MoreTabUI, onResume-1");
      com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b localb = com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.cbX();
      localb.a(paramFragmentActivity, this.pFb);
      i = localb.hHC;
      if ((i != 1) && (i != -1)) {
        break label199;
      }
      ad.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor, MoreTabUI, _onResume-2");
    }
    label199:
    while (i != 0)
    {
      if (this.pFa != null) {
        this.pFa.l(paramFragment, paramString, paramLong);
      }
      AppMethodBeat.o(184323);
      return;
    }
    boolean bool = a(paramFragmentActivity, paramString);
    ad.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor, StoryGalleryView, _onResume: %b", new Object[] { Boolean.valueOf(bool) });
    if ((bool) && (this.pFa != null)) {
      this.pFa.O(2, paramLong);
    }
    AppMethodBeat.o(184323);
  }
  
  public static boolean b(FragmentActivity paramFragmentActivity, String paramString)
  {
    AppMethodBeat.i(122013);
    try
    {
      paramFragmentActivity = g.c(paramFragmentActivity, paramString);
      paramString = Class.forName(com.tencent.mm.plugin.expt.hellhound.core.b.pDX).getDeclaredField("storyGallery");
      paramString.setAccessible(true);
      paramFragmentActivity = paramString.get(paramFragmentActivity);
      paramString = Class.forName("com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView").getDeclaredField("holderView");
      paramString.setAccessible(true);
      paramFragmentActivity = (View)paramString.get(paramFragmentActivity);
      if (paramFragmentActivity == null)
      {
        ad.i("HABBYGE-MALI.FragmentMonitor", "isStoryGalleryShow = NULL");
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
      ad.i("HABBYGE-MALI.FragmentMonitor", "isStoryGalleryShow: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(122013);
      return bool;
    }
  }
  
  public final void Q(int paramInt, long paramLong)
  {
    AppMethodBeat.i(184327);
    a locala = this.pEZ.pEY.pET;
    if (locala != null)
    {
      locala.S(paramInt, paramLong);
      AppMethodBeat.o(184327);
      return;
    }
    AppMethodBeat.o(184327);
  }
  
  public final void R(int paramInt, long paramLong)
  {
    AppMethodBeat.i(184330);
    T(com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.Bt(paramInt), paramLong);
    AppMethodBeat.o(184330);
  }
  
  final void T(int paramInt, long paramLong)
  {
    AppMethodBeat.i(184331);
    ad.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor, _onStoryCallback: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 0)
    {
      if (this.pFa != null)
      {
        this.pFa.O(0, paramLong);
        AppMethodBeat.o(184331);
      }
    }
    else if ((paramInt == 1) && (this.pFa != null)) {
      this.pFa.P(1, paramLong);
    }
    AppMethodBeat.o(184331);
  }
  
  public final void a(Activity paramActivity, long paramLong)
  {
    String str = null;
    AppMethodBeat.i(184318);
    if (!com.tencent.mm.plugin.expt.hellhound.a.cbn())
    {
      AppMethodBeat.o(184318);
      return;
    }
    Object localObject1;
    Object localObject2;
    if ((paramActivity instanceof FragmentActivity))
    {
      localObject1 = this.pEZ;
      paramActivity = (FragmentActivity)paramActivity;
      localObject1 = ((e)localObject1).pEY;
      if (((d)localObject1).pES != null)
      {
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.a.b.a.pEp;
        if (a.a.c(paramActivity, ((d)localObject1).pES)) {}
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
      Fragment localFragment = g.aa((Activity)localObject2);
      if (localFragment != null)
      {
        ad.i("HABBYGE-MALI.FragmentLauncherUIMonitor", "callbackMMFragmentActivityWhenResume: " + localFragment.getClass().getName());
        if (((d)localObject1).pEP != null)
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
          ad.i("HABBYGE-MALI.FragmentLauncherUIMonitor", "callbackMMFActivityWhenResume, %s, %s", new Object[] { paramActivity, str });
          if (!com.tencent.mm.plugin.expt.hellhound.core.b.Vs(paramActivity))
          {
            paramActivity = ((d)localObject1).pEP;
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
          com.tencent.mm.hellhoundlib.a.adm();
          com.tencent.mm.hellhoundlib.a.e((Map)((d)localObject1).pEW, ((d)localObject1).pEV);
        }
        paramActivity = ((d)localObject1).pET;
        if (paramActivity == null) {
          break label386;
        }
        if (!com.tencent.mm.sdk.b.a.ESL.e(paramActivity.pEQ)) {
          break;
        }
        ad.i("HABBYGE-MALI.ChatUIFragmentProxy", "ChatUIFragmentProxy, startMonitor-1");
        AppMethodBeat.o(184318);
        return;
        ad.w("HABBYGE-MALI.FragmentLauncherUIMonitor", "callbackMMFragmentActivityWhenResume curFragment == null");
        paramActivity = ((d)localObject1).pEP;
        if (paramActivity != null) {
          paramActivity.a((FragmentActivity)localObject2, null, com.tencent.mm.plugin.expt.hellhound.core.b.pDU, paramLong, true);
        }
      }
      ad.i("HABBYGE-MALI.ChatUIFragmentProxy", "ChatUIFragmentProxy, startMonitor-2");
      com.tencent.mm.sdk.b.a.ESL.b(paramActivity.pEQ);
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
      if (this.pEG)
      {
        amo localamo = new amo();
        if (paramFragment != null)
        {
          paramFragment = paramFragment.getArguments();
          if (paramFragment != null) {
            localamo.DnG = paramFragment.getString("Chat_User");
          }
        }
        localamo.DnF = paramString;
        localamo.DnH = true;
        localamo.timestamp = paramLong;
        localamo.DnE = new dcm();
        if (paramFragmentActivity != null)
        {
          localamo.DnE.activityName = paramFragmentActivity.getClass().getCanonicalName();
          localamo.DnE.DnR = String.valueOf(paramFragmentActivity.hashCode());
          localamo.DnE.timestamp = paramLong;
        }
        if (paramFragmentActivity != null)
        {
          localamo.DnI = a(paramFragmentActivity, paramString);
          if (com.tencent.mm.plugin.expt.hellhound.core.b.pDX.equals(paramString)) {
            com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.cbX().a(paramFragmentActivity, this.pFb);
          }
        }
        c.cbD().l(5, localamo);
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
      if (this.pEG)
      {
        amn localamn = new amn();
        localamn.DnE = new dcm();
        if (paramFragmentActivity != null)
        {
          localamn.DnE.activityName = paramFragmentActivity.getClass().getCanonicalName();
          localamn.DnE.DnR = String.valueOf(paramFragmentActivity.hashCode());
          localamn.DnE.timestamp = paramLong;
        }
        localamn.DnF = paramString;
        localamn.timestamp = paramLong;
        if ((paramFragmentActivity != null) && (com.tencent.mm.plugin.expt.hellhound.core.b.pDX.equals(paramString)))
        {
          ad.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor, stopStoryMonitor: %s", new Object[] { paramString });
          com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.cbX().d(paramFragmentActivity);
        }
        c.cbD().l(6, localamn);
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
  
  public final void a(amn paramamn)
  {
    AppMethodBeat.i(184324);
    dcm localdcm = paramamn.DnE;
    String str = paramamn.DnF;
    long l = paramamn.timestamp;
    if ((localdcm == null) || (TextUtils.isEmpty(localdcm.activityName)))
    {
      ad.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor _onFragmentPause, Biz");
      if (this.pFa != null) {
        this.pFa.m("Biz", str, l);
      }
      AppMethodBeat.o(184324);
      return;
    }
    ad.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor, _onPause: %s, %s", new Object[] { localdcm.activityName, str });
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.ft(localdcm.activityName, str);
    int i;
    if (str.equals(com.tencent.mm.plugin.expt.hellhound.core.b.pDX))
    {
      ad.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor, MoreTabUI, _onPause-1");
      paramamn = com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.cbX();
      i = paramamn.hHC;
      if ((i != 1) && (i != -1)) {
        break label189;
      }
      ad.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor, MoreTabUI, _onPause-2");
    }
    label189:
    while (i != 0)
    {
      if (this.pFa != null) {
        this.pFa.m(localdcm.activityName, str, l);
      }
      AppMethodBeat.o(184324);
      return;
    }
    ad.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor, StoryGalleryView, _onPause");
    paramamn.hHC = -1;
    if (this.pFa != null) {
      this.pFa.P(3, l);
    }
    AppMethodBeat.o(184324);
  }
  
  public final void a(amo paramamo)
  {
    AppMethodBeat.i(184321);
    Object localObject = paramamo.DnG;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      b.fu("Chat_User", (String)localObject);
    }
    localObject = paramamo.DnE;
    String str = paramamo.DnF;
    boolean bool = paramamo.DnI;
    long l = paramamo.timestamp;
    if (localObject == null)
    {
      if (this.pFa != null) {
        this.pFa.l("Biz", str, l);
      }
      AppMethodBeat.o(184321);
      return;
    }
    int i;
    if (!TextUtils.isEmpty(((dcm)localObject).activityName))
    {
      ad.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor, _onResume: %s, %s", new Object[] { ((dcm)localObject).activityName, str });
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.fs(((dcm)localObject).activityName, str);
      if (com.tencent.mm.plugin.expt.hellhound.core.b.pDX.equals(str))
      {
        ad.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor, MoreTabUI, onResume-1");
        i = com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.cbX().hHC;
        if ((i != 1) && (i != -1)) {
          break label208;
        }
        ad.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor, MoreTabUI, _onResume-2");
      }
    }
    label208:
    while (i != 0)
    {
      if (this.pFa != null) {
        this.pFa.l(((dcm)localObject).activityName, str, l);
      }
      AppMethodBeat.o(184321);
      return;
    }
    ad.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor, StoryGalleryView, _onResume: %b", new Object[] { Boolean.valueOf(bool) });
    if ((bool) && (this.pFa != null)) {
      this.pFa.O(2, l);
    }
    AppMethodBeat.o(184321);
  }
  
  public final void b(Activity paramActivity, long paramLong)
  {
    AppMethodBeat.i(184319);
    if ((paramActivity instanceof FragmentActivity))
    {
      localObject1 = this.pEZ;
      paramActivity = (FragmentActivity)paramActivity;
      localObject1 = ((e)localObject1).pEY;
      a.a locala = com.tencent.mm.plugin.expt.hellhound.core.a.b.a.pEp;
      if (a.a.c(paramActivity, ((d)localObject1).pES))
      {
        com.tencent.mm.hellhoundlib.a.adm();
        com.tencent.mm.hellhoundlib.a.f((Map)((d)localObject1).pEW, ((d)localObject1).pEV);
        ad.i("HABBYGE-MALI.FragmentLauncherUIMonitor", "unmonitor !!!");
        if (paramActivity == null) {}
      }
    }
    try
    {
      boolean bool = com.tencent.mm.plugin.expt.hellhound.core.b.Vs(paramActivity.getClass().getCanonicalName());
      if (!bool) {
        break label142;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("HABBYGE-MALI.FragmentLauncherUIMonitor", (Throwable)localException, "fragmentGoneCallback", new Object[0]);
        Object localObject2 = g.aa((Activity)paramActivity);
        if (localObject2 != null)
        {
          localObject2 = localObject2.getClass().getCanonicalName();
          ad.i("HABBYGE-MALI.FragmentLauncherUIMonitor", "fragmentPauseCallback: curFragment = ".concat(String.valueOf(localObject2)));
          com.tencent.mm.plugin.expt.hellhound.core.d locald = ((d)localObject1).pEP;
          if (locald != null) {
            locald.a(paramActivity, (String)localObject2, paramLong, true);
          }
        }
        else
        {
          ad.i("HABBYGE-MALI.FragmentLauncherUIMonitor", "fragmentGoneCallback unmonitor: curFragment = null");
        }
      }
    }
    if (((d)localObject1).pET != null) {
      ad.i("HABBYGE-MALI.ChatUIFragmentProxy", "ChatUIFragmentProxy, stopMonitor");
    }
    AppMethodBeat.o(184319);
  }
  
  public final void b(d.b paramb)
  {
    AppMethodBeat.i(205375);
    this.pFa = paramb;
    j.a(this);
    AppMethodBeat.o(205375);
  }
  
  public final void ph(long paramLong)
  {
    AppMethodBeat.i(184328);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.ft("com.tencent.mm.ui.LauncherUI", com.tencent.mm.plugin.expt.hellhound.core.b.pDY);
    ad.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor onChattingUIFragmentFinish");
    if (this.pFa != null) {
      this.pFa.pg(paramLong);
    }
    AppMethodBeat.o(184328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.f
 * JD-Core Version:    0.7.0.1
 */