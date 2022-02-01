package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.d.b;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.k;
import com.tencent.mm.plugin.expt.hellhound.core.a.b.a.a;
import com.tencent.mm.protocal.protobuf.bfj;
import com.tencent.mm.protocal.protobuf.bfk;
import com.tencent.mm.protocal.protobuf.bn;
import com.tencent.mm.protocal.protobuf.eih;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Map;

public final class g
  implements com.tencent.mm.plugin.expt.hellhound.core.d, com.tencent.mm.plugin.expt.hellhound.core.e
{
  private final f sAj;
  private d.b sAk;
  private final com.tencent.mm.plugin.expt.hellhound.core.b.b.a.a sAl;
  final boolean szI;
  
  public g()
  {
    AppMethodBeat.i(121997);
    this.sAl = new com.tencent.mm.plugin.expt.hellhound.core.b.b.a.a()
    {
      public final void X(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(184317);
        Log.i("HABBYGE-MALI.FragmentMonitor", "mHijackCallback, event: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (g.this.szI)
        {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.GU(paramAnonymousInt), Long.valueOf(paramAnonymousLong));
          AppMethodBeat.o(184317);
          return;
        }
        g.this.W(paramAnonymousInt, paramAnonymousLong);
        AppMethodBeat.o(184317);
      }
    };
    this.sAj = new f(this);
    this.szI = com.tencent.mm.plugin.expt.hellhound.a.cNt();
    AppMethodBeat.o(121997);
  }
  
  private void a(FragmentActivity paramFragmentActivity, Fragment paramFragment, String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(220438);
    if (paramFragment != null) {
      c.ah(paramFragment.getArguments());
    }
    b(paramFragmentActivity, paramFragment, paramString, paramInt, paramLong);
    AppMethodBeat.o(220438);
  }
  
  private void a(FragmentActivity paramFragmentActivity, String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(220441);
    if ((paramFragmentActivity == null) && (paramString == null))
    {
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
      paramFragmentActivity = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cNR();
      if (paramFragmentActivity != null) {
        l(paramFragmentActivity.KFh.activityName, paramInt, paramLong);
      }
      AppMethodBeat.o(220441);
      return;
    }
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(220441);
      return;
    }
    String str = paramFragmentActivity.getClass().getCanonicalName();
    Log.i("HABBYGE-MALI.FragmentMonitor", "_onPause: %s, %s", new Object[] { str, paramString });
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.M(str, paramString, paramInt);
    com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b localb;
    int i;
    if (paramString.equals(com.tencent.mm.plugin.expt.hellhound.core.b.syZ))
    {
      Log.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, _onPause-2");
      localb = com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.cOl();
      localb.e(paramFragmentActivity);
      i = localb.mRl;
      if ((i != 1) && (i != -1)) {
        break label177;
      }
      Log.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, _onPause-2");
    }
    label177:
    while (i != 0)
    {
      if (this.sAk != null) {
        this.sAk.c(str, paramString, paramInt, paramLong);
      }
      AppMethodBeat.o(220441);
      return;
    }
    Log.i("HABBYGE-MALI.FragmentMonitor", "StoryGalleryView, _onPause");
    localb.mRl = -1;
    if (this.sAk != null) {
      this.sAk.S(3, paramLong);
    }
    AppMethodBeat.o(220441);
  }
  
  private static boolean a(FragmentActivity paramFragmentActivity, String paramString)
  {
    AppMethodBeat.i(122012);
    try
    {
      paramFragmentActivity = h.c(paramFragmentActivity, paramString);
      paramString = Class.forName(com.tencent.mm.plugin.expt.hellhound.core.b.syZ).getDeclaredField("storyGallery");
      paramString.setAccessible(true);
      paramFragmentActivity = paramString.get(paramFragmentActivity);
      paramString = Class.forName("com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView").getDeclaredField("mIsActive");
      paramString.setAccessible(true);
      bool = ((Boolean)paramString.get(paramFragmentActivity)).booleanValue();
      Log.d("HABBYGE-MALI.FragmentMonitor", "isStoryGalleryActive: %b", new Object[] { Boolean.valueOf(bool) });
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
  
  private void b(FragmentActivity paramFragmentActivity, Fragment paramFragment, String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(220439);
    if ((paramFragmentActivity == null) && (paramFragment == null) && (paramString == null))
    {
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
      paramFragmentActivity = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cNR();
      if (paramFragmentActivity != null)
      {
        Log.i("HABBYGE-MALI.FragmentMonitor", "onFragmentResume -> _onResumeForBiz --2");
        if (this.sAk != null) {
          this.sAk.b("Biz", paramFragmentActivity.KFh.activityName, paramInt, paramLong);
        }
      }
      AppMethodBeat.o(220439);
      return;
    }
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(220439);
      return;
    }
    paramFragment = paramFragmentActivity.getClass().getCanonicalName();
    Log.i("HABBYGE-MALI.FragmentMonitor", "_onFragmentResume: %s, %s", new Object[] { paramFragment, paramString });
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.L(paramFragment, paramString, paramInt);
    int i;
    if (paramString.equals(com.tencent.mm.plugin.expt.hellhound.core.b.syZ))
    {
      Log.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, onResume-1");
      com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b localb = com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.cOl();
      localb.a(paramFragmentActivity, this.sAl);
      i = localb.mRl;
      if ((i != 1) && (i != -1)) {
        break label205;
      }
      Log.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, _onResume-2");
    }
    label205:
    while (i != 0)
    {
      if (this.sAk != null) {
        this.sAk.b(paramFragment, paramString, paramInt, paramLong);
      }
      AppMethodBeat.o(220439);
      return;
    }
    boolean bool = a(paramFragmentActivity, paramString);
    Log.i("HABBYGE-MALI.FragmentMonitor", "StoryGalleryView, _onResume: %b", new Object[] { Boolean.valueOf(bool) });
    if ((bool) && (this.sAk != null)) {
      this.sAk.R(2, paramLong);
    }
    AppMethodBeat.o(220439);
  }
  
  public static boolean b(FragmentActivity paramFragmentActivity, String paramString)
  {
    AppMethodBeat.i(122013);
    try
    {
      paramFragmentActivity = h.c(paramFragmentActivity, paramString);
      paramString = Class.forName(com.tencent.mm.plugin.expt.hellhound.core.b.syZ).getDeclaredField("storyGallery");
      paramString.setAccessible(true);
      paramFragmentActivity = paramString.get(paramFragmentActivity);
      paramString = Class.forName("com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView").getDeclaredField("holderView");
      paramString.setAccessible(true);
      paramFragmentActivity = (View)paramString.get(paramFragmentActivity);
      if (paramFragmentActivity == null)
      {
        Log.i("HABBYGE-MALI.FragmentMonitor", "isStoryGalleryShow = NULL");
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
      Log.i("HABBYGE-MALI.FragmentMonitor", "isStoryGalleryShow: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(122013);
      return bool;
    }
  }
  
  private void l(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(220443);
    if (this.sAk != null) {
      this.sAk.c("Biz", paramString, paramInt, paramLong);
    }
    AppMethodBeat.o(220443);
  }
  
  public final void T(int paramInt, long paramLong)
  {
    AppMethodBeat.i(184327);
    b localb = this.sAj.sAi.sAb;
    if (localb != null)
    {
      localb.V(paramInt, paramLong);
      AppMethodBeat.o(184327);
      return;
    }
    AppMethodBeat.o(184327);
  }
  
  public final void U(int paramInt, long paramLong)
  {
    AppMethodBeat.i(184330);
    W(com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.GV(paramInt), paramLong);
    AppMethodBeat.o(184330);
  }
  
  final void W(int paramInt, long paramLong)
  {
    AppMethodBeat.i(184331);
    Log.i("HABBYGE-MALI.FragmentMonitor", "_onStoryCallback: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 0)
    {
      if (this.sAk != null)
      {
        this.sAk.R(0, paramLong);
        AppMethodBeat.o(184331);
      }
    }
    else if ((paramInt == 1) && (this.sAk != null)) {
      this.sAk.S(1, paramLong);
    }
    AppMethodBeat.o(184331);
  }
  
  public final void a(Activity paramActivity, long paramLong)
  {
    String str = null;
    AppMethodBeat.i(184318);
    if (!com.tencent.mm.plugin.expt.hellhound.a.cNo())
    {
      AppMethodBeat.o(184318);
      return;
    }
    Object localObject1;
    Object localObject2;
    if ((paramActivity instanceof FragmentActivity))
    {
      localObject1 = this.sAj;
      paramActivity = (FragmentActivity)paramActivity;
      localObject1 = ((f)localObject1).sAi;
      if (((e)localObject1).sAa != null)
      {
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.a.b.a.szr;
        if (a.a.b(paramActivity, ((e)localObject1).sAa)) {}
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
      Fragment localFragment = h.aa((Activity)localObject2);
      int i;
      if (localFragment != null)
      {
        Log.i("HABBYGE-MALI.FragmentLauncherUIMonitor", "callbackMMFragmentActivityWhenResume: " + localFragment.getClass().getName());
        if (((e)localObject1).szZ != null)
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
          if (!com.tencent.mm.plugin.expt.hellhound.core.b.aoy(paramActivity))
          {
            paramActivity = ((e)localObject1).szZ;
            if (paramActivity != null) {
              paramActivity.a((FragmentActivity)localObject2, localFragment, str, i, paramLong, true);
            }
          }
        }
        if (localObject2 != null)
        {
          ((e)localObject1).mActivityRef = new WeakReference(localObject2);
          com.tencent.mm.hellhoundlib.a.axP();
          com.tencent.mm.hellhoundlib.a.e((Map)((e)localObject1).sAe, ((e)localObject1).sAd);
        }
        paramActivity = ((e)localObject1).sAb;
        if (paramActivity != null)
        {
          a.szV.a(paramActivity.szX);
          AppMethodBeat.o(184318);
        }
      }
      else
      {
        Log.w("HABBYGE-MALI.FragmentLauncherUIMonitor", "callbackMMFragmentActivityWhenResume curFragment == null");
        paramActivity = h.c((FragmentActivity)localObject2, com.tencent.mm.plugin.expt.hellhound.core.b.syW);
        if (paramActivity != null) {}
        for (i = paramActivity.hashCode();; i = 0)
        {
          paramActivity = ((e)localObject1).szZ;
          if (paramActivity == null) {
            break;
          }
          paramActivity.a((FragmentActivity)localObject2, null, com.tencent.mm.plugin.expt.hellhound.core.b.syW, i, paramLong, true);
          break;
        }
      }
      AppMethodBeat.o(184318);
      return;
    }
  }
  
  public final void a(FragmentActivity paramFragmentActivity, long paramLong)
  {
    AppMethodBeat.i(220442);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
    paramFragmentActivity = h.c(paramFragmentActivity, com.tencent.mm.plugin.expt.hellhound.core.b.sza);
    String str = com.tencent.mm.plugin.expt.hellhound.core.b.sza;
    if (paramFragmentActivity == null) {}
    for (int i = 0;; i = paramFragmentActivity.hashCode())
    {
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.M("com.tencent.mm.ui.LauncherUI", str, i);
      Log.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor onChattingUIFragmentFinish");
      if (this.sAk != null) {
        this.sAk.Dm(paramLong);
      }
      AppMethodBeat.o(220442);
      return;
    }
  }
  
  public final void a(FragmentActivity paramFragmentActivity, Fragment paramFragment, String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(220437);
    if (paramFragment != null) {
      com.tencent.mm.plugin.expt.hellhound.core.a.cNx().df(paramFragment);
    }
    if (paramBoolean)
    {
      if (this.szI)
      {
        bfk localbfk = new bfk();
        if (paramFragment != null)
        {
          paramFragment = paramFragment.getArguments();
          if (paramFragment != null) {
            localbfk.LPa = paramFragment.getString("Chat_User");
          }
        }
        localbfk.LOY = paramString;
        localbfk.LOZ = paramInt;
        localbfk.LPb = true;
        localbfk.timestamp = paramLong;
        localbfk.LOX = new eih();
        if (paramFragmentActivity != null)
        {
          localbfk.LOX.activityName = paramFragmentActivity.getClass().getCanonicalName();
          localbfk.LOX.aHK = paramFragmentActivity.hashCode();
          localbfk.LOX.timestamp = paramLong;
        }
        if (paramFragmentActivity != null)
        {
          localbfk.LPc = a(paramFragmentActivity, paramString);
          if (com.tencent.mm.plugin.expt.hellhound.core.b.syZ.equals(paramString)) {
            com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.cOl().a(paramFragmentActivity, this.sAl);
          }
        }
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(5, localbfk);
        AppMethodBeat.o(220437);
        return;
      }
      a(paramFragmentActivity, paramFragment, paramString, paramInt, paramLong);
      AppMethodBeat.o(220437);
      return;
    }
    a(paramFragmentActivity, paramFragment, paramString, paramInt, paramLong);
    AppMethodBeat.o(220437);
  }
  
  public final void a(FragmentActivity paramFragmentActivity, String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(220440);
    if (paramBoolean)
    {
      if (this.szI)
      {
        bfj localbfj = new bfj();
        localbfj.LOX = new eih();
        if (paramFragmentActivity != null)
        {
          localbfj.LOX.activityName = paramFragmentActivity.getClass().getCanonicalName();
          localbfj.LOX.aHK = paramFragmentActivity.hashCode();
          localbfj.LOX.timestamp = paramLong;
        }
        localbfj.LOY = paramString;
        localbfj.LOZ = paramInt;
        localbfj.timestamp = paramLong;
        if ((paramFragmentActivity != null) && (com.tencent.mm.plugin.expt.hellhound.core.b.syZ.equals(paramString)))
        {
          Log.i("HABBYGE-MALI.FragmentMonitor", "stopStoryMonitor: %s", new Object[] { paramString });
          com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.cOl().e(paramFragmentActivity);
        }
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(6, localbfj);
        AppMethodBeat.o(220440);
        return;
      }
      a(paramFragmentActivity, paramString, paramInt, paramLong);
      AppMethodBeat.o(220440);
      return;
    }
    a(paramFragmentActivity, paramString, paramInt, paramLong);
    AppMethodBeat.o(220440);
  }
  
  public final void a(bfj parambfj)
  {
    AppMethodBeat.i(184324);
    eih localeih = parambfj.LOX;
    String str = parambfj.LOY;
    int i = parambfj.LOZ;
    long l = parambfj.timestamp;
    if ((localeih == null) || (TextUtils.isEmpty(localeih.activityName)))
    {
      Log.i("HABBYGE-MALI.FragmentMonitor", "_onFragmentPause, Biz");
      if (this.sAk != null) {
        this.sAk.c("Biz", str, i, l);
      }
      AppMethodBeat.o(184324);
      return;
    }
    Log.i("HABBYGE-MALI.FragmentMonitor", "_onPause: %s, %s", new Object[] { localeih.activityName, str });
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.M(localeih.activityName, str, i);
    int j;
    if (str.equals(com.tencent.mm.plugin.expt.hellhound.core.b.syZ))
    {
      Log.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, _onPause-1");
      parambfj = com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.cOl();
      j = parambfj.mRl;
      if ((j != 1) && (j != -1)) {
        break label200;
      }
      Log.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, _onPause-2");
    }
    label200:
    while (j != 0)
    {
      if (this.sAk != null) {
        this.sAk.c(localeih.activityName, str, i, l);
      }
      AppMethodBeat.o(184324);
      return;
    }
    Log.i("HABBYGE-MALI.FragmentMonitor", "StoryGalleryView, _onPause");
    parambfj.mRl = -1;
    if (this.sAk != null) {
      this.sAk.S(3, l);
    }
    AppMethodBeat.o(184324);
  }
  
  public final void a(bfk parambfk)
  {
    AppMethodBeat.i(184321);
    Object localObject = parambfk.LPa;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      c.go("Chat_User", (String)localObject);
    }
    localObject = parambfk.LOX;
    String str = parambfk.LOY;
    int i = parambfk.LOZ;
    boolean bool = parambfk.LPc;
    long l = parambfk.timestamp;
    if (localObject == null)
    {
      if (this.sAk != null) {
        this.sAk.b("Biz", str, i, l);
      }
      AppMethodBeat.o(184321);
      return;
    }
    int j;
    if (!TextUtils.isEmpty(((eih)localObject).activityName))
    {
      Log.i("HABBYGE-MALI.FragmentMonitor", "_onResume: %s, %s", new Object[] { ((eih)localObject).activityName, str });
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.L(((eih)localObject).activityName, str, i);
      if (com.tencent.mm.plugin.expt.hellhound.core.b.syZ.equals(str))
      {
        Log.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, onResume-1");
        j = com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.cOl().mRl;
        if ((j != 1) && (j != -1)) {
          break label218;
        }
        Log.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, _onResume-2");
      }
    }
    label218:
    while (j != 0)
    {
      if (this.sAk != null) {
        this.sAk.b(((eih)localObject).activityName, str, i, l);
      }
      AppMethodBeat.o(184321);
      return;
    }
    Log.i("HABBYGE-MALI.FragmentMonitor", "StoryGalleryView, _onResume: %b", new Object[] { Boolean.valueOf(bool) });
    if ((bool) && (this.sAk != null)) {
      this.sAk.R(2, l);
    }
    AppMethodBeat.o(184321);
  }
  
  public final void b(Activity paramActivity, long paramLong)
  {
    AppMethodBeat.i(184319);
    if ((paramActivity instanceof FragmentActivity))
    {
      Object localObject = this.sAj;
      paramActivity = (FragmentActivity)paramActivity;
      localObject = ((f)localObject).sAi;
      a.a locala = com.tencent.mm.plugin.expt.hellhound.core.a.b.a.szr;
      if (a.a.b(paramActivity, ((e)localObject).sAa))
      {
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.f((Map)((e)localObject).sAe, ((e)localObject).sAd);
        if (paramActivity != null) {
          try
          {
            if (com.tencent.mm.plugin.expt.hellhound.core.b.aoy(paramActivity.getClass().getCanonicalName()))
            {
              AppMethodBeat.o(184319);
              return;
            }
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("HABBYGE-MALI.FragmentLauncherUIMonitor", (Throwable)localException, "fragmentGoneCallback", new Object[0]);
            Fragment localFragment = h.aa((Activity)paramActivity);
            if (localFragment != null)
            {
              String str = localFragment.getClass().getCanonicalName();
              Log.i("HABBYGE-MALI.FragmentLauncherUIMonitor", "fragmentPauseCallback: curFragment = ".concat(String.valueOf(str)));
              localObject = ((e)localObject).szZ;
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
    AppMethodBeat.i(220436);
    this.sAk = paramb;
    k.a(this);
    AppMethodBeat.o(220436);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.g
 * JD-Core Version:    0.7.0.1
 */