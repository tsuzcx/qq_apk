package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.d.b;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.j;
import com.tencent.mm.plugin.expt.hellhound.core.a.b.a.a;
import com.tencent.mm.protocal.protobuf.atk;
import com.tencent.mm.protocal.protobuf.atl;
import com.tencent.mm.protocal.protobuf.bj;
import com.tencent.mm.protocal.protobuf.dno;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMFragmentActivity;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Map;

public final class g
  implements com.tencent.mm.plugin.expt.hellhound.core.d, com.tencent.mm.plugin.expt.hellhound.core.e
{
  private final f qRU;
  private d.b qRV;
  private final com.tencent.mm.plugin.expt.hellhound.core.b.b.a.a qRW;
  final boolean qRt;
  
  public g()
  {
    AppMethodBeat.i(121997);
    this.qRW = new com.tencent.mm.plugin.expt.hellhound.core.b.b.a.a()
    {
      public final void V(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(184317);
        ad.i("HABBYGE-MALI.FragmentMonitor", "mHijackCallback, event: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (g.this.qRt)
        {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().l(com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.CW(paramAnonymousInt), Long.valueOf(paramAnonymousLong));
          AppMethodBeat.o(184317);
          return;
        }
        g.this.U(paramAnonymousInt, paramAnonymousLong);
        AppMethodBeat.o(184317);
      }
    };
    this.qRU = new f(this);
    this.qRt = com.tencent.mm.plugin.expt.hellhound.a.cny();
    AppMethodBeat.o(121997);
  }
  
  private void a(FragmentActivity paramFragmentActivity, Fragment paramFragment, String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(210348);
    if (paramFragment != null) {
      c.aa(paramFragment.getArguments());
    }
    b(paramFragmentActivity, paramFragment, paramString, paramInt, paramLong);
    AppMethodBeat.o(210348);
  }
  
  private void a(FragmentActivity paramFragmentActivity, String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(210351);
    if ((paramFragmentActivity == null) && (paramString == null))
    {
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnR();
      paramFragmentActivity = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cnW();
      if (paramFragmentActivity != null) {
        m(paramFragmentActivity.Fti.activityName, paramInt, paramLong);
      }
      AppMethodBeat.o(210351);
      return;
    }
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(210351);
      return;
    }
    String str = paramFragmentActivity.getClass().getCanonicalName();
    ad.i("HABBYGE-MALI.FragmentMonitor", "_onPause: %s, %s", new Object[] { str, paramString });
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnR();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.N(str, paramString, paramInt);
    com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b localb;
    int i;
    if (paramString.equals(com.tencent.mm.plugin.expt.hellhound.core.b.qQK))
    {
      ad.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, _onPause-2");
      localb = com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.coq();
      localb.e(paramFragmentActivity);
      i = localb.iBy;
      if ((i != 1) && (i != -1)) {
        break label177;
      }
      ad.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, _onPause-2");
    }
    label177:
    while (i != 0)
    {
      if (this.qRV != null) {
        this.qRV.c(str, paramString, paramInt, paramLong);
      }
      AppMethodBeat.o(210351);
      return;
    }
    ad.i("HABBYGE-MALI.FragmentMonitor", "StoryGalleryView, _onPause");
    localb.iBy = -1;
    if (this.qRV != null) {
      this.qRV.Q(3, paramLong);
    }
    AppMethodBeat.o(210351);
  }
  
  private static boolean a(FragmentActivity paramFragmentActivity, String paramString)
  {
    AppMethodBeat.i(122012);
    try
    {
      paramFragmentActivity = h.c(paramFragmentActivity, paramString);
      paramString = Class.forName(com.tencent.mm.plugin.expt.hellhound.core.b.qQK).getDeclaredField("storyGallery");
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
  
  private void b(FragmentActivity paramFragmentActivity, Fragment paramFragment, String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(210349);
    if ((paramFragmentActivity == null) && (paramFragment == null) && (paramString == null))
    {
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnR();
      paramFragmentActivity = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cnW();
      if (paramFragmentActivity != null)
      {
        ad.i("HABBYGE-MALI.FragmentMonitor", "onFragmentResume -> _onResumeForBiz --2");
        if (this.qRV != null) {
          this.qRV.b("Biz", paramFragmentActivity.Fti.activityName, paramInt, paramLong);
        }
      }
      AppMethodBeat.o(210349);
      return;
    }
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(210349);
      return;
    }
    paramFragment = paramFragmentActivity.getClass().getCanonicalName();
    ad.i("HABBYGE-MALI.FragmentMonitor", "_onFragmentResume: %s, %s", new Object[] { paramFragment, paramString });
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnR();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.M(paramFragment, paramString, paramInt);
    int i;
    if (paramString.equals(com.tencent.mm.plugin.expt.hellhound.core.b.qQK))
    {
      ad.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, onResume-1");
      com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b localb = com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.coq();
      localb.a(paramFragmentActivity, this.qRW);
      i = localb.iBy;
      if ((i != 1) && (i != -1)) {
        break label205;
      }
      ad.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, _onResume-2");
    }
    label205:
    while (i != 0)
    {
      if (this.qRV != null) {
        this.qRV.b(paramFragment, paramString, paramInt, paramLong);
      }
      AppMethodBeat.o(210349);
      return;
    }
    boolean bool = a(paramFragmentActivity, paramString);
    ad.i("HABBYGE-MALI.FragmentMonitor", "StoryGalleryView, _onResume: %b", new Object[] { Boolean.valueOf(bool) });
    if ((bool) && (this.qRV != null)) {
      this.qRV.P(2, paramLong);
    }
    AppMethodBeat.o(210349);
  }
  
  public static boolean b(FragmentActivity paramFragmentActivity, String paramString)
  {
    AppMethodBeat.i(122013);
    try
    {
      paramFragmentActivity = h.c(paramFragmentActivity, paramString);
      paramString = Class.forName(com.tencent.mm.plugin.expt.hellhound.core.b.qQK).getDeclaredField("storyGallery");
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
  
  private void m(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(210353);
    if (this.qRV != null) {
      this.qRV.c("Biz", paramString, paramInt, paramLong);
    }
    AppMethodBeat.o(210353);
  }
  
  public final void R(int paramInt, long paramLong)
  {
    AppMethodBeat.i(184327);
    b localb = this.qRU.qRT.qRM;
    if (localb != null)
    {
      localb.T(paramInt, paramLong);
      AppMethodBeat.o(184327);
      return;
    }
    AppMethodBeat.o(184327);
  }
  
  public final void S(int paramInt, long paramLong)
  {
    AppMethodBeat.i(184330);
    U(com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.CX(paramInt), paramLong);
    AppMethodBeat.o(184330);
  }
  
  final void U(int paramInt, long paramLong)
  {
    AppMethodBeat.i(184331);
    ad.i("HABBYGE-MALI.FragmentMonitor", "_onStoryCallback: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 0)
    {
      if (this.qRV != null)
      {
        this.qRV.P(0, paramLong);
        AppMethodBeat.o(184331);
      }
    }
    else if ((paramInt == 1) && (this.qRV != null)) {
      this.qRV.Q(1, paramLong);
    }
    AppMethodBeat.o(184331);
  }
  
  public final void a(Activity paramActivity, long paramLong)
  {
    String str = null;
    AppMethodBeat.i(184318);
    if (!com.tencent.mm.plugin.expt.hellhound.a.cnt())
    {
      AppMethodBeat.o(184318);
      return;
    }
    Object localObject1;
    Object localObject2;
    if ((paramActivity instanceof FragmentActivity))
    {
      localObject1 = this.qRU;
      paramActivity = (FragmentActivity)paramActivity;
      localObject1 = ((f)localObject1).qRT;
      if (((e)localObject1).qRL != null)
      {
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.a.b.a.qRc;
        if (a.a.c(paramActivity, ((e)localObject1).qRL)) {}
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
        ad.i("HABBYGE-MALI.FragmentLauncherUIMonitor", "callbackMMFragmentActivityWhenResume: " + localFragment.getClass().getName());
        if (((e)localObject1).qRK != null)
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
          ad.i("HABBYGE-MALI.FragmentLauncherUIMonitor", "callbackMMFActivityWhenResume, %s, %s", new Object[] { paramActivity, str });
          if (!com.tencent.mm.plugin.expt.hellhound.core.b.adr(paramActivity))
          {
            paramActivity = ((e)localObject1).qRK;
            if (paramActivity != null) {
              paramActivity.a((FragmentActivity)localObject2, localFragment, str, i, paramLong, true);
            }
          }
        }
        if (localObject2 != null)
        {
          ((e)localObject1).mActivityRef = new WeakReference(localObject2);
          com.tencent.mm.hellhoundlib.a.aho();
          com.tencent.mm.hellhoundlib.a.e((Map)((e)localObject1).qRP, ((e)localObject1).qRO);
        }
        paramActivity = ((e)localObject1).qRM;
        if (paramActivity != null)
        {
          a.qRG.a(paramActivity.qRI);
          AppMethodBeat.o(184318);
        }
      }
      else
      {
        ad.w("HABBYGE-MALI.FragmentLauncherUIMonitor", "callbackMMFragmentActivityWhenResume curFragment == null");
        paramActivity = h.c((FragmentActivity)localObject2, com.tencent.mm.plugin.expt.hellhound.core.b.qQH);
        if (paramActivity != null) {}
        for (i = paramActivity.hashCode();; i = 0)
        {
          paramActivity = ((e)localObject1).qRK;
          if (paramActivity == null) {
            break;
          }
          paramActivity.a((FragmentActivity)localObject2, null, com.tencent.mm.plugin.expt.hellhound.core.b.qQH, i, paramLong, true);
          break;
        }
      }
      AppMethodBeat.o(184318);
      return;
    }
  }
  
  public final void a(FragmentActivity paramFragmentActivity, long paramLong)
  {
    AppMethodBeat.i(210352);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnR();
    paramFragmentActivity = h.c(paramFragmentActivity, com.tencent.mm.plugin.expt.hellhound.core.b.qQL);
    String str = com.tencent.mm.plugin.expt.hellhound.core.b.qQL;
    if (paramFragmentActivity == null) {}
    for (int i = 0;; i = paramFragmentActivity.hashCode())
    {
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.N("com.tencent.mm.ui.LauncherUI", str, i);
      ad.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor onChattingUIFragmentFinish");
      if (this.qRV != null) {
        this.qRV.uR(paramLong);
      }
      AppMethodBeat.o(210352);
      return;
    }
  }
  
  public final void a(FragmentActivity paramFragmentActivity, Fragment paramFragment, String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(210347);
    if (paramFragment != null) {
      com.tencent.mm.plugin.expt.hellhound.core.a.cnB().cX(paramFragment);
    }
    if (paramBoolean)
    {
      if (this.qRt)
      {
        atl localatl = new atl();
        if (paramFragment != null)
        {
          paramFragment = paramFragment.getArguments();
          if (paramFragment != null) {
            localatl.Gry = paramFragment.getString("Chat_User");
          }
        }
        localatl.Grw = paramString;
        localatl.Grx = paramInt;
        localatl.Grz = true;
        localatl.timestamp = paramLong;
        localatl.Grv = new dno();
        if (paramFragmentActivity != null)
        {
          localatl.Grv.activityName = paramFragmentActivity.getClass().getCanonicalName();
          localatl.Grv.aHQ = paramFragmentActivity.hashCode();
          localatl.Grv.timestamp = paramLong;
        }
        if (paramFragmentActivity != null)
        {
          localatl.GrA = a(paramFragmentActivity, paramString);
          if (com.tencent.mm.plugin.expt.hellhound.core.b.qQK.equals(paramString)) {
            com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.coq().a(paramFragmentActivity, this.qRW);
          }
        }
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().l(5, localatl);
        AppMethodBeat.o(210347);
        return;
      }
      a(paramFragmentActivity, paramFragment, paramString, paramInt, paramLong);
      AppMethodBeat.o(210347);
      return;
    }
    a(paramFragmentActivity, paramFragment, paramString, paramInt, paramLong);
    AppMethodBeat.o(210347);
  }
  
  public final void a(FragmentActivity paramFragmentActivity, String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(210350);
    if (paramBoolean)
    {
      if (this.qRt)
      {
        atk localatk = new atk();
        localatk.Grv = new dno();
        if (paramFragmentActivity != null)
        {
          localatk.Grv.activityName = paramFragmentActivity.getClass().getCanonicalName();
          localatk.Grv.aHQ = paramFragmentActivity.hashCode();
          localatk.Grv.timestamp = paramLong;
        }
        localatk.Grw = paramString;
        localatk.Grx = paramInt;
        localatk.timestamp = paramLong;
        if ((paramFragmentActivity != null) && (com.tencent.mm.plugin.expt.hellhound.core.b.qQK.equals(paramString)))
        {
          ad.i("HABBYGE-MALI.FragmentMonitor", "stopStoryMonitor: %s", new Object[] { paramString });
          com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.coq().e(paramFragmentActivity);
        }
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cnO().l(6, localatk);
        AppMethodBeat.o(210350);
        return;
      }
      a(paramFragmentActivity, paramString, paramInt, paramLong);
      AppMethodBeat.o(210350);
      return;
    }
    a(paramFragmentActivity, paramString, paramInt, paramLong);
    AppMethodBeat.o(210350);
  }
  
  public final void a(atk paramatk)
  {
    AppMethodBeat.i(184324);
    dno localdno = paramatk.Grv;
    String str = paramatk.Grw;
    int i = paramatk.Grx;
    long l = paramatk.timestamp;
    if ((localdno == null) || (TextUtils.isEmpty(localdno.activityName)))
    {
      ad.i("HABBYGE-MALI.FragmentMonitor", "_onFragmentPause, Biz");
      if (this.qRV != null) {
        this.qRV.c("Biz", str, i, l);
      }
      AppMethodBeat.o(184324);
      return;
    }
    ad.i("HABBYGE-MALI.FragmentMonitor", "_onPause: %s, %s", new Object[] { localdno.activityName, str });
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnR();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.N(localdno.activityName, str, i);
    int j;
    if (str.equals(com.tencent.mm.plugin.expt.hellhound.core.b.qQK))
    {
      ad.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, _onPause-1");
      paramatk = com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.coq();
      j = paramatk.iBy;
      if ((j != 1) && (j != -1)) {
        break label200;
      }
      ad.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, _onPause-2");
    }
    label200:
    while (j != 0)
    {
      if (this.qRV != null) {
        this.qRV.c(localdno.activityName, str, i, l);
      }
      AppMethodBeat.o(184324);
      return;
    }
    ad.i("HABBYGE-MALI.FragmentMonitor", "StoryGalleryView, _onPause");
    paramatk.iBy = -1;
    if (this.qRV != null) {
      this.qRV.Q(3, l);
    }
    AppMethodBeat.o(184324);
  }
  
  public final void a(atl paramatl)
  {
    AppMethodBeat.i(184321);
    Object localObject = paramatl.Gry;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      c.fQ("Chat_User", (String)localObject);
    }
    localObject = paramatl.Grv;
    String str = paramatl.Grw;
    int i = paramatl.Grx;
    boolean bool = paramatl.GrA;
    long l = paramatl.timestamp;
    if (localObject == null)
    {
      if (this.qRV != null) {
        this.qRV.b("Biz", str, i, l);
      }
      AppMethodBeat.o(184321);
      return;
    }
    int j;
    if (!TextUtils.isEmpty(((dno)localObject).activityName))
    {
      ad.i("HABBYGE-MALI.FragmentMonitor", "_onResume: %s, %s", new Object[] { ((dno)localObject).activityName, str });
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.cnR();
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.M(((dno)localObject).activityName, str, i);
      if (com.tencent.mm.plugin.expt.hellhound.core.b.qQK.equals(str))
      {
        ad.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, onResume-1");
        j = com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.coq().iBy;
        if ((j != 1) && (j != -1)) {
          break label218;
        }
        ad.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, _onResume-2");
      }
    }
    label218:
    while (j != 0)
    {
      if (this.qRV != null) {
        this.qRV.b(((dno)localObject).activityName, str, i, l);
      }
      AppMethodBeat.o(184321);
      return;
    }
    ad.i("HABBYGE-MALI.FragmentMonitor", "StoryGalleryView, _onResume: %b", new Object[] { Boolean.valueOf(bool) });
    if ((bool) && (this.qRV != null)) {
      this.qRV.P(2, l);
    }
    AppMethodBeat.o(184321);
  }
  
  public final void b(Activity paramActivity, long paramLong)
  {
    AppMethodBeat.i(184319);
    if ((paramActivity instanceof FragmentActivity))
    {
      Object localObject = this.qRU;
      paramActivity = (FragmentActivity)paramActivity;
      localObject = ((f)localObject).qRT;
      a.a locala = com.tencent.mm.plugin.expt.hellhound.core.a.b.a.qRc;
      if (a.a.c(paramActivity, ((e)localObject).qRL))
      {
        com.tencent.mm.hellhoundlib.a.aho();
        com.tencent.mm.hellhoundlib.a.f((Map)((e)localObject).qRP, ((e)localObject).qRO);
        if (paramActivity != null) {
          try
          {
            if (com.tencent.mm.plugin.expt.hellhound.core.b.adr(paramActivity.getClass().getCanonicalName()))
            {
              AppMethodBeat.o(184319);
              return;
            }
          }
          catch (Exception localException)
          {
            ad.printErrStackTrace("HABBYGE-MALI.FragmentLauncherUIMonitor", (Throwable)localException, "fragmentGoneCallback", new Object[0]);
            Fragment localFragment = h.ab((Activity)paramActivity);
            if (localFragment != null)
            {
              String str = localFragment.getClass().getCanonicalName();
              ad.i("HABBYGE-MALI.FragmentLauncherUIMonitor", "fragmentPauseCallback: curFragment = ".concat(String.valueOf(str)));
              localObject = ((e)localObject).qRK;
              if (localObject != null)
              {
                ((com.tencent.mm.plugin.expt.hellhound.core.d)localObject).a(paramActivity, str, localFragment.hashCode(), paramLong, true);
                AppMethodBeat.o(184319);
                return;
              }
              AppMethodBeat.o(184319);
              return;
            }
            ad.i("HABBYGE-MALI.FragmentLauncherUIMonitor", "fragmentGoneCallback unmonitor: curFragment = null");
          }
        }
      }
    }
    AppMethodBeat.o(184319);
  }
  
  public final void b(d.b paramb)
  {
    AppMethodBeat.i(210346);
    this.qRV = paramb;
    j.a(this);
    AppMethodBeat.o(210346);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.g
 * JD-Core Version:    0.7.0.1
 */