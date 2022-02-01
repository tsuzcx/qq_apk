package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.e.b;
import com.tencent.mm.plugin.expt.b.e.d;
import com.tencent.mm.plugin.expt.hellhound.core.a.b.a.a;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.k;
import com.tencent.mm.protocal.protobuf.bt;
import com.tencent.mm.protocal.protobuf.cag;
import com.tencent.mm.protocal.protobuf.cah;
import com.tencent.mm.protocal.protobuf.fns;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.g.b.s;

public final class g
  implements com.tencent.mm.plugin.expt.hellhound.core.d, com.tencent.mm.plugin.expt.hellhound.core.e
{
  private List<e.d> zBA;
  final boolean zBD;
  private final f zCe;
  private e.b zCf;
  private final com.tencent.mm.plugin.expt.hellhound.core.b.b.a.a zCg;
  
  public g()
  {
    AppMethodBeat.i(121997);
    this.zCg = new com.tencent.mm.plugin.expt.hellhound.core.b.b.a.a()
    {
      public final void ac(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(184317);
        Log.i("HABBYGE-MALI.FragmentMonitor", "mHijackCallback, event: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (g.this.zBD)
        {
          com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().I(com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.LD(paramAnonymousInt), Long.valueOf(paramAnonymousLong));
          AppMethodBeat.o(184317);
          return;
        }
        g.this.ab(paramAnonymousInt, paramAnonymousLong);
        AppMethodBeat.o(184317);
      }
    };
    this.zBA = new CopyOnWriteArrayList();
    this.zCe = new f(this);
    this.zBD = com.tencent.mm.plugin.expt.hellhound.a.dIP();
    AppMethodBeat.o(121997);
  }
  
  private void a(FragmentActivity paramFragmentActivity, Fragment paramFragment, String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(299949);
    if (paramFragment != null) {
      c.al(paramFragment.getArguments());
    }
    b(paramFragmentActivity, paramFragment, paramString, paramInt, paramLong);
    AppMethodBeat.o(299949);
  }
  
  private void a(FragmentActivity paramFragmentActivity, String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(299968);
    if ((paramFragmentActivity == null) && (paramString == null))
    {
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.dJg();
      paramFragmentActivity = com.tencent.mm.plugin.expt.hellhound.core.stack.e.dJl();
      if (paramFragmentActivity != null) {
        m(paramFragmentActivity.YDs.AtM, paramInt, paramLong);
      }
      AppMethodBeat.o(299968);
      return;
    }
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(299968);
      return;
    }
    String str = paramFragmentActivity.getClass().getCanonicalName();
    Log.i("HABBYGE-MALI.FragmentMonitor", "_onPause: %s, %s", new Object[] { str, paramString });
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.dJg();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.X(str, paramString, paramInt);
    com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b localb;
    int i;
    if (paramString.equals(com.tencent.mm.plugin.expt.hellhound.core.b.zAU))
    {
      Log.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, _onPause-2");
      localb = com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.dJJ();
      localb.e(paramFragmentActivity);
      i = localb.zCk;
      if ((i != 1) && (i != -1)) {
        break label177;
      }
      Log.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, _onPause-2");
    }
    label177:
    while (i != 0)
    {
      if (this.zCf != null) {
        this.zCf.c(str, paramString, paramInt, paramLong);
      }
      AppMethodBeat.o(299968);
      return;
    }
    Log.i("HABBYGE-MALI.FragmentMonitor", "StoryGalleryView, _onPause");
    localb.zCk = -1;
    if (this.zCf != null) {
      this.zCf.X(3, paramLong);
    }
    AppMethodBeat.o(299968);
  }
  
  private static boolean a(FragmentActivity paramFragmentActivity, String paramString)
  {
    AppMethodBeat.i(299978);
    try
    {
      paramFragmentActivity = h.c(paramFragmentActivity, paramString);
      paramString = Class.forName(com.tencent.mm.plugin.expt.hellhound.core.b.zAU).getDeclaredField("storyGallery");
      paramString.setAccessible(true);
      paramFragmentActivity = paramString.get(paramFragmentActivity);
      paramString = Class.forName("com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView").getDeclaredField("mIsActive");
      paramString.setAccessible(true);
      bool = ((Boolean)paramString.get(paramFragmentActivity)).booleanValue();
      Log.d("HABBYGE-MALI.FragmentMonitor", "isStoryGalleryActive: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(299978);
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
    AppMethodBeat.i(299958);
    if ((paramFragmentActivity == null) && (paramFragment == null) && (paramString == null))
    {
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.dJg();
      paramFragmentActivity = com.tencent.mm.plugin.expt.hellhound.core.stack.e.dJl();
      if (paramFragmentActivity != null)
      {
        Log.i("HABBYGE-MALI.FragmentMonitor", "onFragmentResume -> _onResumeForBiz --2");
        if (this.zCf != null) {
          this.zCf.b("Biz", paramFragmentActivity.YDs.AtM, paramInt, paramLong);
        }
      }
      AppMethodBeat.o(299958);
      return;
    }
    if (paramFragmentActivity == null)
    {
      AppMethodBeat.o(299958);
      return;
    }
    paramFragment = paramFragmentActivity.getClass().getCanonicalName();
    Log.i("HABBYGE-MALI.FragmentMonitor", "_onFragmentResume: %s, %s", new Object[] { paramFragment, paramString });
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.dJg();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.W(paramFragment, paramString, paramInt);
    int i;
    if (paramString.equals(com.tencent.mm.plugin.expt.hellhound.core.b.zAU))
    {
      Log.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, onResume-1");
      com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b localb = com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.dJJ();
      localb.a(paramFragmentActivity, this.zCg);
      i = localb.zCk;
      if ((i != 1) && (i != -1)) {
        break label205;
      }
      Log.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, _onResume-2");
    }
    label205:
    while (i != 0)
    {
      if (this.zCf != null) {
        this.zCf.b(paramFragment, paramString, paramInt, paramLong);
      }
      AppMethodBeat.o(299958);
      return;
    }
    boolean bool = a(paramFragmentActivity, paramString);
    Log.i("HABBYGE-MALI.FragmentMonitor", "StoryGalleryView, _onResume: %b", new Object[] { Boolean.valueOf(bool) });
    if ((bool) && (this.zCf != null)) {
      this.zCf.W(2, paramLong);
    }
    AppMethodBeat.o(299958);
  }
  
  public static boolean b(FragmentActivity paramFragmentActivity, String paramString)
  {
    AppMethodBeat.i(299981);
    try
    {
      paramFragmentActivity = h.c(paramFragmentActivity, paramString);
      paramString = Class.forName(com.tencent.mm.plugin.expt.hellhound.core.b.zAU).getDeclaredField("storyGallery");
      paramString.setAccessible(true);
      paramFragmentActivity = paramString.get(paramFragmentActivity);
      paramString = Class.forName("com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView").getDeclaredField("holderView");
      paramString.setAccessible(true);
      paramFragmentActivity = (View)paramString.get(paramFragmentActivity);
      if (paramFragmentActivity == null)
      {
        Log.i("HABBYGE-MALI.FragmentMonitor", "isStoryGalleryShow = NULL");
        AppMethodBeat.o(299981);
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
      AppMethodBeat.o(299981);
      return bool;
    }
  }
  
  private void m(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(299972);
    if (this.zCf != null) {
      this.zCf.c("Biz", paramString, paramInt, paramLong);
    }
    AppMethodBeat.o(299972);
  }
  
  public final void Y(int paramInt, long paramLong)
  {
    AppMethodBeat.i(184327);
    b localb = this.zCe.zCd.zBX;
    if (localb != null) {
      localb.aa(paramInt, paramLong);
    }
    AppMethodBeat.o(184327);
  }
  
  public final void Z(int paramInt, long paramLong)
  {
    AppMethodBeat.i(184330);
    ab(com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.LE(paramInt), paramLong);
    AppMethodBeat.o(184330);
  }
  
  public final void a(Activity paramActivity, long paramLong)
  {
    Object localObject1 = null;
    AppMethodBeat.i(184318);
    if (!com.tencent.mm.plugin.expt.hellhound.a.dIK())
    {
      AppMethodBeat.o(184318);
      return;
    }
    e locale;
    if ((paramActivity instanceof FragmentActivity))
    {
      localObject2 = this.zCe;
      paramActivity = (FragmentActivity)paramActivity;
      locale = ((f)localObject2).zCd;
      if (locale.zBW != null)
      {
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.a.b.a.zBn;
        if (a.a.c(paramActivity, locale.zBW)) {}
      }
      else
      {
        AppMethodBeat.o(184318);
        return;
      }
      if (!(paramActivity instanceof MMFragmentActivity)) {
        break label280;
      }
      paramActivity = (MMFragmentActivity)paramActivity;
      localObject2 = h.ak((Activity)paramActivity);
      if (localObject2 == null) {
        break label306;
      }
      Log.i("HABBYGE-MALI.FragmentLauncherUIMonitor", s.X("callbackMMFragmentActivityWhenResume: ", localObject2.getClass().getName()));
      if (locale.zBV != null) {
        if (paramActivity != null) {
          break label285;
        }
      }
    }
    for (;;)
    {
      Object localObject3 = localObject2.getClass().getCanonicalName();
      i = ((Fragment)localObject2).hashCode();
      Log.i("HABBYGE-MALI.FragmentLauncherUIMonitor", "callbackMMFActivityWhenResume, %s, %s", new Object[] { localObject1, localObject3 });
      if (!com.tencent.mm.plugin.expt.hellhound.core.b.aqA((String)localObject1))
      {
        localObject1 = locale.zBV;
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.expt.hellhound.core.d)localObject1).a((FragmentActivity)paramActivity, (Fragment)localObject2, (String)localObject3, i, paramLong, true);
        }
      }
      if (paramActivity != null)
      {
        locale.mActivityRef = new WeakReference(paramActivity);
        com.tencent.mm.hellhoundlib.a.aYh();
        com.tencent.mm.hellhoundlib.a.e((Map)locale.zCa, locale.zBZ);
      }
      paramActivity = locale.zBX;
      if (paramActivity != null) {
        a.zBM.a(paramActivity.zBS);
      }
      AppMethodBeat.o(184318);
      return;
      label280:
      paramActivity = null;
      break;
      label285:
      localObject3 = paramActivity.getClass();
      if (localObject3 != null) {
        localObject1 = ((Class)localObject3).getCanonicalName();
      }
    }
    label306:
    Log.w("HABBYGE-MALI.FragmentLauncherUIMonitor", "callbackMMFragmentActivityWhenResume curFragment == null");
    Object localObject2 = h.c((FragmentActivity)paramActivity, com.tencent.mm.plugin.expt.hellhound.core.b.zAQ);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = h.d((FragmentActivity)paramActivity);
    }
    if (localObject1 == null) {}
    for (int i = 0;; i = ((Fragment)localObject1).hashCode())
    {
      localObject2 = locale.zBV;
      if (localObject2 == null) {
        break;
      }
      ((com.tencent.mm.plugin.expt.hellhound.core.d)localObject2).a((FragmentActivity)paramActivity, (Fragment)localObject1, com.tencent.mm.plugin.expt.hellhound.core.b.zAQ, i, paramLong, true);
      break;
    }
  }
  
  public final void a(FragmentActivity paramFragmentActivity, long paramLong)
  {
    AppMethodBeat.i(300024);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.dJg();
    paramFragmentActivity = h.c(paramFragmentActivity, com.tencent.mm.plugin.expt.hellhound.core.b.zAV);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.zAV;
    label76:
    e.d locald;
    if (paramFragmentActivity == null)
    {
      i = 0;
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.X("com.tencent.mm.ui.LauncherUI", (String)localObject, i);
      Log.i("HABBYGE-MALI.FragmentMonitor", "FragmentMonitor onChattingUIFragmentFinish");
      if (this.zCf != null) {
        this.zCf.lR(paramLong);
      }
      localObject = this.zBA.iterator();
      if (!((Iterator)localObject).hasNext()) {
        break label151;
      }
      locald = (e.d)((Iterator)localObject).next();
      if (paramFragmentActivity == null) {
        break label145;
      }
    }
    label145:
    for (int i = paramFragmentActivity.hashCode();; i = 0)
    {
      locald.Jv(i);
      if (paramFragmentActivity != null) {
        paramFragmentActivity.hashCode();
      }
      locald.dtx();
      break label76;
      i = paramFragmentActivity.hashCode();
      break;
    }
    label151:
    AppMethodBeat.o(300024);
  }
  
  public final void a(FragmentActivity paramFragmentActivity, Fragment paramFragment, String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(300006);
    if (paramFragment != null) {
      com.tencent.mm.plugin.expt.hellhound.core.a.dIT().fa(paramFragment);
    }
    if (paramBoolean) {
      if (this.zBD)
      {
        cah localcah = new cah();
        if (paramFragment != null)
        {
          Bundle localBundle = paramFragment.getArguments();
          if (localBundle != null) {
            localcah.aajm = localBundle.getString("Chat_User");
          }
        }
        localcah.aajk = paramString;
        localcah.aajl = paramInt;
        localcah.aajn = true;
        localcah.timestamp = paramLong;
        localcah.aajj = new fns();
        if (paramFragmentActivity != null)
        {
          localcah.aajj.AtM = paramFragmentActivity.getClass().getCanonicalName();
          localcah.aajj.cHb = paramFragmentActivity.hashCode();
          localcah.aajj.timestamp = paramLong;
        }
        if (paramFragmentActivity != null)
        {
          localcah.aajo = a(paramFragmentActivity, paramString);
          if (com.tencent.mm.plugin.expt.hellhound.core.b.zAU.equals(paramString)) {
            com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.dJJ().a(paramFragmentActivity, this.zCg);
          }
        }
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().I(5, localcah);
      }
    }
    for (;;)
    {
      paramFragmentActivity = this.zBA.iterator();
      while (paramFragmentActivity.hasNext()) {
        ((e.d)paramFragmentActivity.next()).eV(paramFragment);
      }
      a(paramFragmentActivity, paramFragment, paramString, paramInt, paramLong);
      continue;
      a(paramFragmentActivity, paramFragment, paramString, paramInt, paramLong);
    }
    AppMethodBeat.o(300006);
  }
  
  public final void a(FragmentActivity paramFragmentActivity, String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(300017);
    if (paramBoolean) {
      if (this.zBD)
      {
        cag localcag = new cag();
        localcag.aajj = new fns();
        if (paramFragmentActivity != null)
        {
          localcag.aajj.AtM = paramFragmentActivity.getClass().getCanonicalName();
          localcag.aajj.cHb = paramFragmentActivity.hashCode();
          localcag.aajj.timestamp = paramLong;
        }
        localcag.aajk = paramString;
        localcag.aajl = paramInt;
        localcag.timestamp = paramLong;
        if ((paramFragmentActivity != null) && (com.tencent.mm.plugin.expt.hellhound.core.b.zAU.equals(paramString)))
        {
          Log.i("HABBYGE-MALI.FragmentMonitor", "stopStoryMonitor: %s", new Object[] { paramString });
          com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.dJJ().e(paramFragmentActivity);
        }
        com.tencent.mm.plugin.expt.hellhound.core.a.a.c.dJd().I(6, localcag);
      }
    }
    for (;;)
    {
      paramFragmentActivity = this.zBA.iterator();
      while (paramFragmentActivity.hasNext()) {
        ((e.d)paramFragmentActivity.next()).Jv(paramInt);
      }
      a(paramFragmentActivity, paramString, paramInt, paramLong);
      continue;
      a(paramFragmentActivity, paramString, paramInt, paramLong);
    }
    AppMethodBeat.o(300017);
  }
  
  public final void a(e.d paramd)
  {
    AppMethodBeat.i(299987);
    if (paramd == null)
    {
      AppMethodBeat.o(299987);
      return;
    }
    this.zBA.add(paramd);
    Object localObject = this.zCe;
    if (paramd != null)
    {
      localObject = ((f)localObject).zCd;
      if (paramd != null)
      {
        localObject = ((e)localObject).zBX;
        if ((localObject != null) && (paramd != null))
        {
          ((b)localObject).zBA.add(paramd);
          localObject = a.zBM;
          a.a(paramd);
        }
      }
    }
    AppMethodBeat.o(299987);
  }
  
  public final void a(cag paramcag)
  {
    AppMethodBeat.i(184324);
    fns localfns = paramcag.aajj;
    String str = paramcag.aajk;
    int i = paramcag.aajl;
    long l = paramcag.timestamp;
    if ((localfns == null) || (TextUtils.isEmpty(localfns.AtM)))
    {
      Log.i("HABBYGE-MALI.FragmentMonitor", "_onFragmentPause, Biz");
      if (this.zCf != null) {
        this.zCf.c("Biz", str, i, l);
      }
      AppMethodBeat.o(184324);
      return;
    }
    Log.i("HABBYGE-MALI.FragmentMonitor", "_onPause: %s, %s", new Object[] { localfns.AtM, str });
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.dJg();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.X(localfns.AtM, str, i);
    int j;
    if (str.equals(com.tencent.mm.plugin.expt.hellhound.core.b.zAU))
    {
      Log.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, _onPause-1");
      paramcag = com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.dJJ();
      j = paramcag.zCk;
      if ((j != 1) && (j != -1)) {
        break label200;
      }
      Log.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, _onPause-2");
    }
    label200:
    while (j != 0)
    {
      if (this.zCf != null) {
        this.zCf.c(localfns.AtM, str, i, l);
      }
      AppMethodBeat.o(184324);
      return;
    }
    Log.i("HABBYGE-MALI.FragmentMonitor", "StoryGalleryView, _onPause");
    paramcag.zCk = -1;
    if (this.zCf != null) {
      this.zCf.X(3, l);
    }
    AppMethodBeat.o(184324);
  }
  
  public final void a(cah paramcah)
  {
    AppMethodBeat.i(184321);
    Object localObject = paramcah.aajm;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      c.hj("Chat_User", (String)localObject);
    }
    localObject = paramcah.aajj;
    String str = paramcah.aajk;
    int i = paramcah.aajl;
    boolean bool = paramcah.aajo;
    long l = paramcah.timestamp;
    if (localObject == null)
    {
      if (this.zCf != null) {
        this.zCf.b("Biz", str, i, l);
      }
      AppMethodBeat.o(184321);
      return;
    }
    int j;
    if (!TextUtils.isEmpty(((fns)localObject).AtM))
    {
      Log.i("HABBYGE-MALI.FragmentMonitor", "_onResume: %s, %s", new Object[] { ((fns)localObject).AtM, str });
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.dJg();
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.W(((fns)localObject).AtM, str, i);
      if (com.tencent.mm.plugin.expt.hellhound.core.b.zAU.equals(str))
      {
        Log.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, onResume-1");
        j = com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.dJJ().zCk;
        if ((j != 1) && (j != -1)) {
          break label218;
        }
        Log.i("HABBYGE-MALI.FragmentMonitor", "MoreTabUI, _onResume-2");
      }
    }
    label218:
    while (j != 0)
    {
      if (this.zCf != null) {
        this.zCf.b(((fns)localObject).AtM, str, i, l);
      }
      AppMethodBeat.o(184321);
      return;
    }
    Log.i("HABBYGE-MALI.FragmentMonitor", "StoryGalleryView, _onResume: %b", new Object[] { Boolean.valueOf(bool) });
    if ((bool) && (this.zCf != null)) {
      this.zCf.W(2, l);
    }
    AppMethodBeat.o(184321);
  }
  
  final void ab(int paramInt, long paramLong)
  {
    AppMethodBeat.i(184331);
    Log.i("HABBYGE-MALI.FragmentMonitor", "_onStoryCallback: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 0)
    {
      if (this.zCf != null)
      {
        this.zCf.W(0, paramLong);
        AppMethodBeat.o(184331);
      }
    }
    else if ((paramInt == 1) && (this.zCf != null)) {
      this.zCf.X(1, paramLong);
    }
    AppMethodBeat.o(184331);
  }
  
  public final void b(Activity paramActivity, long paramLong)
  {
    AppMethodBeat.i(184319);
    if ((paramActivity instanceof FragmentActivity))
    {
      Object localObject = this.zCe;
      paramActivity = (FragmentActivity)paramActivity;
      localObject = ((f)localObject).zCd;
      a.a locala = com.tencent.mm.plugin.expt.hellhound.core.a.b.a.zBn;
      if (a.a.c(paramActivity, ((e)localObject).zBW))
      {
        com.tencent.mm.hellhoundlib.a.aYh();
        com.tencent.mm.hellhoundlib.a.f((Map)((e)localObject).zCa, ((e)localObject).zBZ);
        if (paramActivity != null) {
          try
          {
            if (com.tencent.mm.plugin.expt.hellhound.core.b.aqA(paramActivity.getClass().getCanonicalName()))
            {
              AppMethodBeat.o(184319);
              return;
            }
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("HABBYGE-MALI.FragmentLauncherUIMonitor", (Throwable)localException, "fragmentGoneCallback", new Object[0]);
            Fragment localFragment = h.ak((Activity)paramActivity);
            if (localFragment != null)
            {
              String str = localFragment.getClass().getCanonicalName();
              Log.i("HABBYGE-MALI.FragmentLauncherUIMonitor", s.X("fragmentPauseCallback: curFragment = ", str));
              localObject = ((e)localObject).zBV;
              if (localObject != null)
              {
                ((com.tencent.mm.plugin.expt.hellhound.core.d)localObject).a(paramActivity, str, localFragment.hashCode(), paramLong, true);
                AppMethodBeat.o(184319);
              }
            }
            else
            {
              Log.i("HABBYGE-MALI.FragmentLauncherUIMonitor", "fragmentGoneCallback unmonitor: curFragment = null");
            }
          }
        }
      }
    }
    AppMethodBeat.o(184319);
  }
  
  public final void b(e.b paramb)
  {
    AppMethodBeat.i(299984);
    this.zCf = paramb;
    k.a(this);
    AppMethodBeat.o(299984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.g
 * JD-Core Version:    0.7.0.1
 */