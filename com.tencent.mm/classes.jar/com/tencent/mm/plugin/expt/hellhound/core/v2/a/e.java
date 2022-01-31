package com.tencent.mm.plugin.expt.hellhound.core.v2.a;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.b.b;
import com.tencent.mm.plugin.expt.hellhound.core.a.a.a.a;
import com.tencent.mm.plugin.expt.hellhound.core.stack.g;
import com.tencent.mm.protocal.protobuf.bd;
import com.tencent.mm.protocal.protobuf.be;
import com.tencent.mm.protocal.protobuf.bf;
import com.tencent.mm.protocal.protobuf.cjr;
import com.tencent.mm.protocal.protobuf.ckn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMFragmentActivity;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.LinkedList;
import java.util.List;

public final class e
  implements com.tencent.mm.plugin.expt.hellhound.core.d, com.tencent.mm.plugin.expt.hellhound.core.e
{
  private d mat;
  b.b mau;
  private final com.tencent.mm.plugin.expt.hellhound.core.v2.a.a.a mav;
  
  public e()
  {
    AppMethodBeat.i(152298);
    this.mav = new e.1(this);
    this.mat = new d(this);
    AppMethodBeat.o(152298);
  }
  
  private static boolean c(FragmentActivity paramFragmentActivity, String paramString)
  {
    AppMethodBeat.i(156190);
    try
    {
      paramFragmentActivity = f.e(paramFragmentActivity, paramString);
      paramString = Class.forName("com.tencent.mm.ui.MoreTabUI").getDeclaredField("storyGallery");
      paramString.setAccessible(true);
      paramFragmentActivity = paramString.get(paramFragmentActivity);
      paramString = Class.forName("com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView").getDeclaredField("mIsActive");
      paramString.setAccessible(true);
      bool = ((Boolean)paramString.get(paramFragmentActivity)).booleanValue();
      ab.i("FragmentMonitor", "HABBYGE-MALI, isStoryGalleryActive = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(156190);
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
  
  public static boolean d(FragmentActivity paramFragmentActivity, String paramString)
  {
    AppMethodBeat.i(156191);
    try
    {
      paramFragmentActivity = f.e(paramFragmentActivity, paramString);
      paramString = Class.forName("com.tencent.mm.ui.MoreTabUI").getDeclaredField("storyGallery");
      paramString.setAccessible(true);
      paramFragmentActivity = paramString.get(paramFragmentActivity);
      paramString = Class.forName("com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView").getDeclaredField("holderView");
      paramString.setAccessible(true);
      paramFragmentActivity = (View)paramString.get(paramFragmentActivity);
      if (paramFragmentActivity == null)
      {
        ab.i("FragmentMonitor", "HABBYGE-MALI, isStoryGalleryShow = NULL");
        AppMethodBeat.o(156191);
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
      ab.i("FragmentMonitor", "HABBYGE-MALI, isStoryGalleryShow = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(156191);
      return bool;
    }
  }
  
  public final void J(Activity paramActivity)
  {
    String str = null;
    AppMethodBeat.i(152299);
    Object localObject2;
    Object localObject1;
    int i;
    if ((paramActivity instanceof FragmentActivity))
    {
      localObject2 = this.mat;
      localObject1 = (FragmentActivity)paramActivity;
      localObject2 = ((d)localObject2).mas;
      if (((c)localObject2).mal != null)
      {
        paramActivity = com.tencent.mm.plugin.expt.hellhound.core.a.a.a.lZH;
        if (a.a.b(localObject1, ((c)localObject2).mal)) {
          break label77;
        }
      }
      i = 0;
      if (i == 0) {
        ab.i("FragmentLifecycle", "habbyge-mali, FragmentLifecycle illegal Activity !!!");
      }
    }
    AppMethodBeat.o(152299);
    return;
    label77:
    Object localObject3 = new StringBuilder("habbyge-mali, FragmentLauncherUIMonitor monitor, ");
    if (localObject1 != null)
    {
      paramActivity = localObject1.getClass();
      if (paramActivity != null)
      {
        paramActivity = paramActivity.getCanonicalName();
        label108:
        ab.i("FragmentLauncherUIMonitor", paramActivity);
        ((c)localObject2).man = ((FragmentActivity)localObject1);
        if ((localObject1 instanceof MMFragmentActivity)) {
          break label370;
        }
      }
    }
    label271:
    label349:
    label370:
    for (paramActivity = null;; paramActivity = (Activity)localObject1)
    {
      localObject3 = (MMFragmentActivity)paramActivity;
      localObject1 = f.b((FragmentActivity)localObject3);
      if (localObject1 != null)
      {
        ab.i("FragmentLauncherUIMonitor", "HABBYGE-MALI, callbackMMFragmentActivityWhenResume: " + localObject1.getClass().getName());
        if (((c)localObject2).mai != null)
        {
          paramActivity = str;
          if (localObject3 != null)
          {
            localObject3 = localObject3.getClass();
            paramActivity = str;
            if (localObject3 != null) {
              paramActivity = ((Class)localObject3).getCanonicalName();
            }
          }
          str = localObject1.getClass().getCanonicalName();
          if (!"com.tencent.mm.ui.chatting.ChattingUI".equals(paramActivity))
          {
            b.Q(((Fragment)localObject1).getArguments());
            paramActivity = ((c)localObject2).mai;
            if (paramActivity != null) {
              paramActivity.a(((c)localObject2).man, str);
            }
          }
        }
        ((c)localObject2).brR();
        paramActivity = ((c)localObject2).mam;
        if (paramActivity != null)
        {
          if (!com.tencent.mm.sdk.b.a.ymk.e(paramActivity.maj)) {
            break label349;
          }
          ab.i("ChatUIFragmentProxy", "habbyge-mali, ChatUIFragmentProxy, startMonitor-1");
        }
      }
      for (;;)
      {
        i = 1;
        break;
        paramActivity = null;
        break label108;
        ab.e("FragmentLauncherUIMonitor", "habbyge-mali, callbackMMFragmentActivityWhenResume curFragment == null");
        paramActivity = ((c)localObject2).mai;
        if (paramActivity == null) {
          break label271;
        }
        paramActivity.a((FragmentActivity)localObject3, "com.tencent.mm.ui.conversation.MainUI");
        break label271;
        ab.i("ChatUIFragmentProxy", "habbyge-mali, ChatUIFragmentProxy, startMonitor-2");
        com.tencent.mm.sdk.b.a.ymk.b(paramActivity.maj);
      }
    }
  }
  
  public final void K(Activity paramActivity)
  {
    AppMethodBeat.i(152300);
    if ((paramActivity instanceof FragmentActivity))
    {
      Object localObject2 = this.mat;
      localObject1 = (FragmentActivity)paramActivity;
      paramActivity = ((d)localObject2).mas;
      localObject2 = com.tencent.mm.plugin.expt.hellhound.core.a.a.a.lZH;
      if (a.a.b(localObject1, paramActivity.mal))
      {
        ab.i("FragmentLauncherUIMonitor", "habbyge-mali, unmonitor !!!");
        if (localObject1 != null) {
          ab.w("FragmentLauncherUIMonitor", "habbyge-mali, fragmentPauseCallback: " + localObject1.getClass().getCanonicalName());
        }
      }
    }
    try
    {
      boolean bool = "com.tencent.mm.ui.chatting.ChattingUI".equals(localObject1.getClass().getCanonicalName());
      if (!bool) {
        break label147;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("FragmentLauncherUIMonitor", (Throwable)localException, "habbyge-mali, fragmentGoneCallback", new Object[0]);
        localObject1 = f.b((FragmentActivity)localObject1);
        if (localObject1 != null)
        {
          localObject1 = localObject1.getClass().getCanonicalName();
          ab.i("FragmentLauncherUIMonitor", "habbyge-mali, fragmentPauseCallback: curFragment = ".concat(String.valueOf(localObject1)));
          com.tencent.mm.plugin.expt.hellhound.core.d locald = paramActivity.mai;
          if (locald != null) {
            locald.b(paramActivity.man, (String)localObject1);
          }
        }
        else
        {
          ab.i("FragmentLauncherUIMonitor", "habbyge-mali, fragmentGoneCallback unmonitor: curFragment = null");
        }
      }
    }
    if (paramActivity.mam != null) {
      ab.i("ChatUIFragmentProxy", "habbyge-mali, ChatUIFragmentProxy, stopMonitor");
    }
    paramActivity.man = null;
    AppMethodBeat.o(152300);
  }
  
  public final void a(FragmentActivity paramFragmentActivity, String paramString)
  {
    AppMethodBeat.i(152301);
    Object localObject1 = f.brS();
    if ((paramFragmentActivity == null) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (com.tencent.mm.plugin.expt.hellhound.a.b.a.b.Mz((String)localObject1)))
    {
      ab.i("FragmentMonitor", "habbyge-mali, FragmentMonitor _onResumeForBiz");
      if (this.mau != null) {
        this.mau.ec("Biz", paramString);
      }
      AppMethodBeat.o(152301);
      return;
    }
    ab.i("FragmentMonitor", "habbyge-mali, FragmentMonitor _onResume");
    String str;
    Object localObject2;
    Object localObject3;
    int i;
    if (paramFragmentActivity != null)
    {
      str = paramFragmentActivity.getClass().getCanonicalName();
      ab.i("FragmentMonitor", "habbyge-mali, FragmentMonitor, _onResume: " + str + ", " + paramString);
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.brC();
      if ((str != null) && (paramString != null)) {
        break label249;
      }
      if (paramString.equals("com.tencent.mm.ui.MoreTabUI"))
      {
        ab.i("FragmentMonitor", "habbyge-mali, FragmentMonitor, MoreTabUI, onResume-1");
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.v2.a.a.c.brT();
        localObject1 = this.mav;
        localObject3 = ((com.tencent.mm.plugin.expt.hellhound.core.v2.a.a.c)localObject2).maB;
        if ((((com.tencent.mm.plugin.expt.hellhound.core.v2.a.a.b)localObject3).may == null) || (((com.tencent.mm.plugin.expt.hellhound.core.v2.a.a.b)localObject3).maz == null)) {
          break label422;
        }
        i = 1;
        label186:
        if (i == 0) {
          break label427;
        }
        ab.w("StoryGalleryMonitor", "habbyge-mali, StoryGalleryMonitor, isHookValidate TRUE");
      }
    }
    for (;;)
    {
      i = ((com.tencent.mm.plugin.expt.hellhound.core.v2.a.a.c)localObject2).ikr;
      label223:
      label249:
      Object localObject4;
      if ((i == 1) || (i == -1))
      {
        ab.i("FragmentMonitor", "habbyge-mali, FragmentMonitor, MoreTabUI, _onResume-2");
        if (this.mau != null) {
          this.mau.ec(str, paramString);
        }
        AppMethodBeat.o(152301);
        return;
        ab.i("ActivityStackSupervisor", "HABBYGE-MALI, setFragmentOnFragmentResume: " + str + " | " + paramString);
        localObject1 = com.tencent.mm.plugin.expt.hellhound.core.stack.c.brA();
        if ((((bf)localObject1).wnw != null) && (((bf)localObject1).wnw.wnn != null) && (str.equals(((bf)localObject1).wnw.wnn.wnr.activityName))) {
          ((bf)localObject1).wnw.wnn.wns = paramString;
        }
        localObject2 = g.b((bf)localObject1, str, null);
        i = ((Integer)((com.tencent.mm.vending.j.b)localObject2).get(0)).intValue();
        int j = ((Integer)((com.tencent.mm.vending.j.c)localObject2).get(1)).intValue();
        if ((i < 0) || (j < 0)) {
          break;
        }
        ((be)((cjr)((bf)localObject1).wnv.get(i)).xTI.get(j)).wns = paramString;
        com.tencent.mm.plugin.expt.hellhound.core.stack.c.a((bf)localObject1);
        break;
        label422:
        i = 0;
        break label186;
        label427:
        ab.i("StoryGalleryMonitor", "habbyge-mali, StoryGalleryMonitor startHook");
        localObject3 = f.e(paramFragmentActivity, "com.tencent.mm.ui.MoreTabUI");
        if (localObject3 == null)
        {
          ab.e("StoryGalleryMonitor", "habbyge-mali, StoryGalleryMonitor startHook: curFragment == null");
          continue;
        }
        localObject4 = localObject3.getClass().getName();
        if (!((String)localObject4).equals("com.tencent.mm.ui.MoreTabUI"))
        {
          ab.i("StoryGalleryMonitor", "habbyge-mali, StoryGalleryMonitor startHook Fail: ".concat(String.valueOf(localObject4)));
          continue;
        }
        ((com.tencent.mm.plugin.expt.hellhound.core.v2.a.a.c)localObject2).maC = ((com.tencent.mm.plugin.expt.hellhound.core.v2.a.a.a)localObject1);
        ab.i("StoryGalleryMonitor", "habbyge-mali, StoryGalleryMonitor startHook real: ".concat(String.valueOf(localObject4)));
        localObject4 = ((com.tencent.mm.plugin.expt.hellhound.core.v2.a.a.c)localObject2).maB;
      }
      try
      {
        ((com.tencent.mm.plugin.expt.hellhound.core.v2.a.a.b)localObject4).maz = Class.forName("com.tencent.mm.ui.MoreTabUI").getDeclaredField("mPullDownCallback");
        ((com.tencent.mm.plugin.expt.hellhound.core.v2.a.a.b)localObject4).maz.setAccessible(true);
        ((com.tencent.mm.plugin.expt.hellhound.core.v2.a.a.b)localObject4).may = ((com.tencent.mm.plugin.expt.hellhound.core.v2.a.a.b)localObject4).maz.get(localObject3);
        localObject1 = ((com.tencent.mm.plugin.expt.hellhound.core.v2.a.a.b)localObject4).may.getClass().getName();
        if (((String)localObject1).startsWith("com.tencent.mm.ui.MoreTabUI"))
        {
          ab.i("StoryGalleryHijack", "habbyge-mali, StoryGalleryHijack, doHook: mPullDownCallback_Old: ".concat(String.valueOf(localObject1)));
          Class localClass = ((com.tencent.mm.plugin.expt.hellhound.core.v2.a.a.b)localObject4).may.getClass();
          localObject1 = com.tencent.mm.plugin.expt.hellhound.core.a.a.a.ak(localClass);
          if ((localObject1 != null) && (((List)localObject1).size() > 0)) {}
          for (localObject1 = (Class[])((List)localObject1).toArray(new Class[((List)localObject1).size()]);; localObject1 = new Class[0])
          {
            localObject1 = Proxy.newProxyInstance(localClass.getClassLoader(), (Class[])localObject1, (InvocationHandler)localObject4);
            ((com.tencent.mm.plugin.expt.hellhound.core.v2.a.a.b)localObject4).maz.set(localObject3, localObject1);
            break;
          }
          if (i != 0) {
            break label223;
          }
          boolean bool = c(paramFragmentActivity, paramString);
          ab.i("FragmentMonitor", "habbyge-mali, FragmentMonitor, StoryGalleryView, _onResume: ".concat(String.valueOf(bool)));
          if ((bool) && (this.mau != null)) {
            this.mau.vi(2);
          }
          AppMethodBeat.o(152301);
          return;
        }
      }
      catch (Exception localException) {}
    }
  }
  
  public final void b(FragmentActivity paramFragmentActivity, String paramString)
  {
    AppMethodBeat.i(152302);
    String str1 = f.brS();
    if ((paramFragmentActivity == null) && (!TextUtils.isEmpty(str1)) && (com.tencent.mm.plugin.expt.hellhound.a.b.a.b.Mz(str1)))
    {
      ab.i("FragmentMonitor", "habbyge-mali, FragmentMonitor _onPauseForBiz");
      if (this.mau != null) {
        this.mau.ed("Biz", paramString);
      }
      AppMethodBeat.o(152302);
      return;
    }
    ab.i("FragmentMonitor", "habbyge-mali, FragmentMonitor _onPause");
    Object localObject;
    if (paramFragmentActivity != null)
    {
      str1 = paramFragmentActivity.getClass().getCanonicalName();
      ab.i("FragmentMonitor", "habbyge-mali, FragmentMonitor, _onPause: " + str1 + ", " + paramString);
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.brC();
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.eg(str1, paramString);
      if (paramString.equals("com.tencent.mm.ui.MoreTabUI"))
      {
        ab.i("FragmentMonitor", "habbyge-mali, FragmentMonitor, MoreTabUI, _onPause-1");
        localObject = com.tencent.mm.plugin.expt.hellhound.core.v2.a.a.c.brT();
        ab.i("StoryGalleryMonitor", "habbyge-mali, StoryGalleryMonitor, endHook");
        paramFragmentActivity = f.e(paramFragmentActivity, "com.tencent.mm.ui.MoreTabUI");
        if (paramFragmentActivity != null)
        {
          String str2 = paramFragmentActivity.getClass().getName();
          ab.i("StoryGalleryMonitor", "habbyge-mali, StoryGalleryMonitor endHook real: ".concat(String.valueOf(str2)));
          if (str2.equals("com.tencent.mm.ui.MoreTabUI"))
          {
            localObject = ((com.tencent.mm.plugin.expt.hellhound.core.v2.a.a.c)localObject).maB;
            if ((paramFragmentActivity == null) || (((com.tencent.mm.plugin.expt.hellhound.core.v2.a.a.b)localObject).maz == null) || (((com.tencent.mm.plugin.expt.hellhound.core.v2.a.a.b)localObject).may == null)) {}
          }
        }
      }
    }
    try
    {
      ab.i("StoryGalleryHijack", "habbyge-mali, StoryGalleryHijack, mPullDownCallback_Old: " + ((com.tencent.mm.plugin.expt.hellhound.core.v2.a.a.b)localObject).may.getClass().getName());
      ((com.tencent.mm.plugin.expt.hellhound.core.v2.a.a.b)localObject).maz.set(paramFragmentActivity, ((com.tencent.mm.plugin.expt.hellhound.core.v2.a.a.b)localObject).may);
      ((com.tencent.mm.plugin.expt.hellhound.core.v2.a.a.b)localObject).may = null;
      ((com.tencent.mm.plugin.expt.hellhound.core.v2.a.a.b)localObject).maz = null;
      i = com.tencent.mm.plugin.expt.hellhound.core.v2.a.a.c.brT().ikr;
      if ((i == 1) || (i == -1))
      {
        ab.i("FragmentMonitor", "habbyge-mali, FragmentMonitor, MoreTabUI, _onPause-2");
        if (this.mau != null) {
          this.mau.ed(str1, paramString);
        }
        AppMethodBeat.o(152302);
        return;
      }
    }
    catch (Exception paramFragmentActivity)
    {
      int i;
      do
      {
        for (;;)
        {
          ab.printErrStackTrace("StoryGalleryHijack", paramFragmentActivity, "habbyge-mali, StoryGalleryHijack, endHook Crash", new Object[0]);
        }
      } while (i != 0);
      ab.i("FragmentMonitor", "habbyge-mali, FragmentMonitor, StoryGalleryView, _onPause");
      if (this.mau != null) {
        this.mau.vj(3);
      }
      AppMethodBeat.o(152302);
    }
  }
  
  public final void b(b.b paramb)
  {
    this.mau = paramb;
  }
  
  public final void brv()
  {
    AppMethodBeat.i(152303);
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.brC();
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.eg("com.tencent.mm.ui.LauncherUI", "com.tencent.mm.ui.chatting.ChattingUIFragment");
    ab.i("FragmentMonitor", "habbyge-mali, FragmentMonitor onChattingUIFragmentFinish");
    if (this.mau != null) {
      this.mau.brm();
    }
    AppMethodBeat.o(152303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.v2.a.e
 * JD-Core Version:    0.7.0.1
 */