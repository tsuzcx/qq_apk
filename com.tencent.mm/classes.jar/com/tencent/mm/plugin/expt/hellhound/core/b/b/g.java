package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.d.b;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.k;
import com.tencent.mm.plugin.expt.hellhound.core.a.b.a.a;
import com.tencent.mm.protocal.protobuf.bl;
import com.tencent.mm.protocal.protobuf.bmn;
import com.tencent.mm.protocal.protobuf.bmo;
import com.tencent.mm.protocal.protobuf.esj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Map;

public final class g
  implements com.tencent.mm.plugin.expt.hellhound.core.d, com.tencent.mm.plugin.expt.hellhound.core.e
{
  final boolean wfC;
  private final f wgd;
  private d.b wge;
  private final com.tencent.mm.plugin.expt.hellhound.core.b.b.a.a wgf;
  
  public g()
  {
    AppMethodBeat.i(121997);
    this.wgf = new com.tencent.mm.plugin.expt.hellhound.core.b.b.a.a()
    {
      public final void Y(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(184317);
        Log.i("HABBYGE-MALI.FragmentMonitor", "mHijackCallback, event: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (g.this.wfC)
        {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().p(com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.KE(paramAnonymousInt), Long.valueOf(paramAnonymousLong));
          AppMethodBeat.o(184317);
          return;
        }
        g.this.X(paramAnonymousInt, paramAnonymousLong);
        AppMethodBeat.o(184317);
      }
    };
    this.wgd = new f(this);
    this.wfC = com.tencent.mm.plugin.expt.hellhound.a.dcl();
    AppMethodBeat.o(121997);
  }
  
  private void a(FragmentActivity paramFragmentActivity, Fragment paramFragment, String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(254966);
    if (paramFragment != null) {
      c.aa(paramFragment.getArguments());
    }
    b(paramFragmentActivity, paramFragment, paramString, paramInt, paramLong);
    AppMethodBeat.o(254966);
  }
  
  private void a(FragmentActivity paramFragmentActivity, String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(254978);
    if ((paramFragmentActivity == null) && (paramString == null))
    {
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcE();
      paramFragmentActivity = com.tencent.mm.plugin.expt.hellhound.core.stack.e.dcJ();
      if (paramFragmentActivity != null) {
        m(paramFragmentActivity.RGy.activityName, paramInt, paramLong);
      }
      AppMethodBeat.o(254978);
      return;
    }
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(254978);
      return;
    }
    String str = paramFragmentActivity.getClass().getCanonicalName();
    Log.i("HABBYGE-MALI.FragmentMonitor", "_onPause: %s, %s", new Object[] { str, paramString });
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcE();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.Q(str, paramString, paramInt);
    com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b localb;
    int i;
    if (paramString.equals(com.tencent.mm.plugin.expt.hellhound.core.b.weV))
    {
      Log.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, _onPause-2");
      localb = com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.ddd();
      localb.e(paramFragmentActivity);
      i = localb.pSh;
      if ((i != 1) && (i != -1)) {
        break label177;
      }
      Log.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, _onPause-2");
    }
    label177:
    while (i != 0)
    {
      if (this.wge != null) {
        this.wge.c(str, paramString, paramInt, paramLong);
      }
      AppMethodBeat.o(254978);
      return;
    }
    Log.i("HABBYGE-MALI.FragmentMonitor", "StoryGalleryView, _onPause");
    localb.pSh = -1;
    if (this.wge != null) {
      this.wge.T(3, paramLong);
    }
    AppMethodBeat.o(254978);
  }
  
  private static boolean a(FragmentActivity paramFragmentActivity, String paramString)
  {
    AppMethodBeat.i(254991);
    try
    {
      paramFragmentActivity = h.c(paramFragmentActivity, paramString);
      paramString = Class.forName(com.tencent.mm.plugin.expt.hellhound.core.b.weV).getDeclaredField("storyGallery");
      paramString.setAccessible(true);
      paramFragmentActivity = paramString.get(paramFragmentActivity);
      paramString = Class.forName("com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView").getDeclaredField("mIsActive");
      paramString.setAccessible(true);
      bool = ((Boolean)paramString.get(paramFragmentActivity)).booleanValue();
      Log.d("HABBYGE-MALI.FragmentMonitor", "isStoryGalleryActive: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(254991);
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
  
  private void b(FragmentActivity paramFragmentActivity, Fragment paramFragment, String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(254970);
    if ((paramFragmentActivity == null) && (paramFragment == null) && (paramString == null))
    {
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcE();
      paramFragmentActivity = com.tencent.mm.plugin.expt.hellhound.core.stack.e.dcJ();
      if (paramFragmentActivity != null)
      {
        Log.i("HABBYGE-MALI.FragmentMonitor", "onFragmentResume -> _onResumeForBiz --2");
        if (this.wge != null) {
          this.wge.b("Biz", paramFragmentActivity.RGy.activityName, paramInt, paramLong);
        }
      }
      AppMethodBeat.o(254970);
      return;
    }
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(254970);
      return;
    }
    paramFragment = paramFragmentActivity.getClass().getCanonicalName();
    Log.i("HABBYGE-MALI.FragmentMonitor", "_onFragmentResume: %s, %s", new Object[] { paramFragment, paramString });
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcE();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.P(paramFragment, paramString, paramInt);
    int i;
    if (paramString.equals(com.tencent.mm.plugin.expt.hellhound.core.b.weV))
    {
      Log.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, onResume-1");
      com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b localb = com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.ddd();
      localb.a(paramFragmentActivity, this.wgf);
      i = localb.pSh;
      if ((i != 1) && (i != -1)) {
        break label205;
      }
      Log.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, _onResume-2");
    }
    label205:
    while (i != 0)
    {
      if (this.wge != null) {
        this.wge.b(paramFragment, paramString, paramInt, paramLong);
      }
      AppMethodBeat.o(254970);
      return;
    }
    boolean bool = a(paramFragmentActivity, paramString);
    Log.i("HABBYGE-MALI.FragmentMonitor", "StoryGalleryView, _onResume: %b", new Object[] { Boolean.valueOf(bool) });
    if ((bool) && (this.wge != null)) {
      this.wge.S(2, paramLong);
    }
    AppMethodBeat.o(254970);
  }
  
  public static boolean b(FragmentActivity paramFragmentActivity, String paramString)
  {
    AppMethodBeat.i(254993);
    try
    {
      paramFragmentActivity = h.c(paramFragmentActivity, paramString);
      paramString = Class.forName(com.tencent.mm.plugin.expt.hellhound.core.b.weV).getDeclaredField("storyGallery");
      paramString.setAccessible(true);
      paramFragmentActivity = paramString.get(paramFragmentActivity);
      paramString = Class.forName("com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView").getDeclaredField("holderView");
      paramString.setAccessible(true);
      paramFragmentActivity = (View)paramString.get(paramFragmentActivity);
      if (paramFragmentActivity == null)
      {
        Log.i("HABBYGE-MALI.FragmentMonitor", "isStoryGalleryShow = NULL");
        AppMethodBeat.o(254993);
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
      Log.i("HABBYGE-MALI.FragmentMonitor", "isStoryGalleryShow: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(254993);
      return bool;
    }
  }
  
  private void m(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(254984);
    if (this.wge != null) {
      this.wge.c("Biz", paramString, paramInt, paramLong);
    }
    AppMethodBeat.o(254984);
  }
  
  public final void U(int paramInt, long paramLong)
  {
    AppMethodBeat.i(184327);
    b localb = this.wgd.wgc.wfV;
    if (localb != null)
    {
      localb.W(paramInt, paramLong);
      AppMethodBeat.o(184327);
      return;
    }
    AppMethodBeat.o(184327);
  }
  
  public final void V(int paramInt, long paramLong)
  {
    AppMethodBeat.i(184330);
    X(com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.KF(paramInt), paramLong);
    AppMethodBeat.o(184330);
  }
  
  final void X(int paramInt, long paramLong)
  {
    AppMethodBeat.i(184331);
    Log.i("HABBYGE-MALI.FragmentMonitor", "_onStoryCallback: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 0)
    {
      if (this.wge != null)
      {
        this.wge.S(0, paramLong);
        AppMethodBeat.o(184331);
      }
    }
    else if ((paramInt == 1) && (this.wge != null)) {
      this.wge.T(1, paramLong);
    }
    AppMethodBeat.o(184331);
  }
  
  public final void a(Activity paramActivity, long paramLong)
  {
    String str = null;
    AppMethodBeat.i(184318);
    if (!com.tencent.mm.plugin.expt.hellhound.a.dcg())
    {
      AppMethodBeat.o(184318);
      return;
    }
    Object localObject1;
    Object localObject2;
    if ((paramActivity instanceof FragmentActivity))
    {
      localObject1 = this.wgd;
      paramActivity = (FragmentActivity)paramActivity;
      localObject1 = ((f)localObject1).wgc;
      if (((e)localObject1).wfU != null)
      {
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.a.b.a.wfn;
        if (a.a.b(paramActivity, ((e)localObject1).wfU)) {}
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
    label393:
    for (;;)
    {
      localObject2 = (MMFragmentActivity)paramActivity;
      Fragment localFragment = h.ab((Activity)localObject2);
      int i;
      if (localFragment != null)
      {
        Log.i("HABBYGE-MALI.FragmentLauncherUIMonitor", "callbackMMFragmentActivityWhenResume: " + localFragment.getClass().getName());
        if (((e)localObject1).wfT != null)
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
          i = localFragment.hashCode();
          Log.i("HABBYGE-MALI.FragmentLauncherUIMonitor", "callbackMMFActivityWhenResume, %s, %s", new Object[] { paramActivity, str });
          if (!com.tencent.mm.plugin.expt.hellhound.core.b.awx(paramActivity))
          {
            paramActivity = ((e)localObject1).wfT;
            if (paramActivity != null) {
              paramActivity.a((FragmentActivity)localObject2, localFragment, str, i, paramLong, true);
            }
          }
        }
        if (localObject2 != null)
        {
          ((e)localObject1).mActivityRef = new WeakReference(localObject2);
          com.tencent.mm.hellhoundlib.a.aFg();
          com.tencent.mm.hellhoundlib.a.e((Map)((e)localObject1).wfY, ((e)localObject1).wfX);
        }
        paramActivity = ((e)localObject1).wfV;
        if (paramActivity != null)
        {
          a.wfP.a(paramActivity.wfR);
          AppMethodBeat.o(184318);
        }
      }
      else
      {
        Log.w("HABBYGE-MALI.FragmentLauncherUIMonitor", "callbackMMFragmentActivityWhenResume curFragment == null");
        paramActivity = h.c((FragmentActivity)localObject2, com.tencent.mm.plugin.expt.hellhound.core.b.weS);
        if (paramActivity != null) {}
        for (i = paramActivity.hashCode();; i = 0)
        {
          paramActivity = ((e)localObject1).wfT;
          if (paramActivity == null) {
            break;
          }
          paramActivity.a((FragmentActivity)localObject2, null, com.tencent.mm.plugin.expt.hellhound.core.b.weS, i, paramLong, true);
          break;
        }
      }
      AppMethodBeat.o(184318);
      return;
    }
  }
  
  public final void a(FragmentActivity paramFragmentActivity, long paramLong)
  {
    AppMethodBeat.i(254982);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcE();
    paramFragmentActivity = h.c(paramFragmentActivity, com.tencent.mm.plugin.expt.hellhound.core.b.weW);
    String str = com.tencent.mm.plugin.expt.hellhound.core.b.weW;
    if (paramFragmentActivity == null) {}
    for (int i = 0;; i = paramFragmentActivity.hashCode())
    {
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.Q("com.tencent.mm.ui.LauncherUI", str, i);
      Log.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor onChattingUIFragmentFinish");
      if (this.wge != null) {
        this.wge.JA(paramLong);
      }
      AppMethodBeat.o(254982);
      return;
    }
  }
  
  public final void a(FragmentActivity paramFragmentActivity, Fragment paramFragment, String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(254963);
    if (paramFragment != null) {
      com.tencent.mm.plugin.expt.hellhound.core.a.dcp().dc(paramFragment);
    }
    if (paramBoolean)
    {
      if (this.wfC)
      {
        bmo localbmo = new bmo();
        if (paramFragment != null)
        {
          paramFragment = paramFragment.getArguments();
          if (paramFragment != null) {
            localbmo.SXu = paramFragment.getString("Chat_User");
          }
        }
        localbmo.SXs = paramString;
        localbmo.SXt = paramInt;
        localbmo.SXv = true;
        localbmo.timestamp = paramLong;
        localbmo.SXr = new esj();
        if (paramFragmentActivity != null)
        {
          localbmo.SXr.activityName = paramFragmentActivity.getClass().getCanonicalName();
          localbmo.SXr.aNf = paramFragmentActivity.hashCode();
          localbmo.SXr.timestamp = paramLong;
        }
        if (paramFragmentActivity != null)
        {
          localbmo.SXw = a(paramFragmentActivity, paramString);
          if (com.tencent.mm.plugin.expt.hellhound.core.b.weV.equals(paramString)) {
            com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.ddd().a(paramFragmentActivity, this.wgf);
          }
        }
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().p(5, localbmo);
        AppMethodBeat.o(254963);
        return;
      }
      a(paramFragmentActivity, paramFragment, paramString, paramInt, paramLong);
      AppMethodBeat.o(254963);
      return;
    }
    a(paramFragmentActivity, paramFragment, paramString, paramInt, paramLong);
    AppMethodBeat.o(254963);
  }
  
  public final void a(FragmentActivity paramFragmentActivity, String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(254975);
    if (paramBoolean)
    {
      if (this.wfC)
      {
        bmn localbmn = new bmn();
        localbmn.SXr = new esj();
        if (paramFragmentActivity != null)
        {
          localbmn.SXr.activityName = paramFragmentActivity.getClass().getCanonicalName();
          localbmn.SXr.aNf = paramFragmentActivity.hashCode();
          localbmn.SXr.timestamp = paramLong;
        }
        localbmn.SXs = paramString;
        localbmn.SXt = paramInt;
        localbmn.timestamp = paramLong;
        if ((paramFragmentActivity != null) && (com.tencent.mm.plugin.expt.hellhound.core.b.weV.equals(paramString)))
        {
          Log.i("HABBYGE-MALI.FragmentMonitor", "stopStoryMonitor: %s", new Object[] { paramString });
          com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.ddd().e(paramFragmentActivity);
        }
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dcB().p(6, localbmn);
        AppMethodBeat.o(254975);
        return;
      }
      a(paramFragmentActivity, paramString, paramInt, paramLong);
      AppMethodBeat.o(254975);
      return;
    }
    a(paramFragmentActivity, paramString, paramInt, paramLong);
    AppMethodBeat.o(254975);
  }
  
  public final void a(bmn parambmn)
  {
    AppMethodBeat.i(184324);
    esj localesj = parambmn.SXr;
    String str = parambmn.SXs;
    int i = parambmn.SXt;
    long l = parambmn.timestamp;
    if ((localesj == null) || (TextUtils.isEmpty(localesj.activityName)))
    {
      Log.i("HABBYGE-MALI.FragmentMonitor", "_onFragmentPause, Biz");
      if (this.wge != null) {
        this.wge.c("Biz", str, i, l);
      }
      AppMethodBeat.o(184324);
      return;
    }
    Log.i("HABBYGE-MALI.FragmentMonitor", "_onPause: %s, %s", new Object[] { localesj.activityName, str });
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcE();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.Q(localesj.activityName, str, i);
    int j;
    if (str.equals(com.tencent.mm.plugin.expt.hellhound.core.b.weV))
    {
      Log.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, _onPause-1");
      parambmn = com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.ddd();
      j = parambmn.pSh;
      if ((j != 1) && (j != -1)) {
        break label200;
      }
      Log.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, _onPause-2");
    }
    label200:
    while (j != 0)
    {
      if (this.wge != null) {
        this.wge.c(localesj.activityName, str, i, l);
      }
      AppMethodBeat.o(184324);
      return;
    }
    Log.i("HABBYGE-MALI.FragmentMonitor", "StoryGalleryView, _onPause");
    parambmn.pSh = -1;
    if (this.wge != null) {
      this.wge.T(3, l);
    }
    AppMethodBeat.o(184324);
  }
  
  public final void a(bmo parambmo)
  {
    AppMethodBeat.i(184321);
    Object localObject = parambmo.SXu;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      c.gC("Chat_User", (String)localObject);
    }
    localObject = parambmo.SXr;
    String str = parambmo.SXs;
    int i = parambmo.SXt;
    boolean bool = parambmo.SXw;
    long l = parambmo.timestamp;
    if (localObject == null)
    {
      if (this.wge != null) {
        this.wge.b("Biz", str, i, l);
      }
      AppMethodBeat.o(184321);
      return;
    }
    int j;
    if (!TextUtils.isEmpty(((esj)localObject).activityName))
    {
      Log.i("HABBYGE-MALI.FragmentMonitor", "_onResume: %s, %s", new Object[] { ((esj)localObject).activityName, str });
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.dcE();
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.P(((esj)localObject).activityName, str, i);
      if (com.tencent.mm.plugin.expt.hellhound.core.b.weV.equals(str))
      {
        Log.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, onResume-1");
        j = com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.ddd().pSh;
        if ((j != 1) && (j != -1)) {
          break label218;
        }
        Log.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, _onResume-2");
      }
    }
    label218:
    while (j != 0)
    {
      if (this.wge != null) {
        this.wge.b(((esj)localObject).activityName, str, i, l);
      }
      AppMethodBeat.o(184321);
      return;
    }
    Log.i("HABBYGE-MALI.FragmentMonitor", "StoryGalleryView, _onResume: %b", new Object[] { Boolean.valueOf(bool) });
    if ((bool) && (this.wge != null)) {
      this.wge.S(2, l);
    }
    AppMethodBeat.o(184321);
  }
  
  public final void b(Activity paramActivity, long paramLong)
  {
    AppMethodBeat.i(184319);
    if ((paramActivity instanceof FragmentActivity))
    {
      Object localObject = this.wgd;
      paramActivity = (FragmentActivity)paramActivity;
      localObject = ((f)localObject).wgc;
      a.a locala = com.tencent.mm.plugin.expt.hellhound.core.a.b.a.wfn;
      if (a.a.b(paramActivity, ((e)localObject).wfU))
      {
        com.tencent.mm.hellhoundlib.a.aFg();
        com.tencent.mm.hellhoundlib.a.f((Map)((e)localObject).wfY, ((e)localObject).wfX);
        if (paramActivity != null) {
          try
          {
            if (com.tencent.mm.plugin.expt.hellhound.core.b.awx(paramActivity.getClass().getCanonicalName()))
            {
              AppMethodBeat.o(184319);
              return;
            }
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("HABBYGE-MALI.FragmentLauncherUIMonitor", (Throwable)localException, "fragmentGoneCallback", new Object[0]);
            Fragment localFragment = h.ab((Activity)paramActivity);
            if (localFragment != null)
            {
              String str = localFragment.getClass().getCanonicalName();
              Log.i("HABBYGE-MALI.FragmentLauncherUIMonitor", "fragmentPauseCallback: curFragment = ".concat(String.valueOf(str)));
              localObject = ((e)localObject).wfT;
              if (localObject != null)
              {
                ((com.tencent.mm.plugin.expt.hellhound.core.d)localObject).a(paramActivity, str, localFragment.hashCode(), paramLong, true);
                AppMethodBeat.o(184319);
                return;
              }
              AppMethodBeat.o(184319);
              return;
            }
            Log.i("HABBYGE-MALI.FragmentLauncherUIMonitor", "fragmentGoneCallback unmonitor: curFragment = null");
          }
        }
      }
    }
    AppMethodBeat.o(184319);
  }
  
  public final void b(d.b paramb)
  {
    AppMethodBeat.i(254958);
    this.wge = paramb;
    k.a(this);
    AppMethodBeat.o(254958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.g
 * JD-Core Version:    0.7.0.1
 */