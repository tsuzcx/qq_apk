package com.tencent.kinda.framework.widget.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.kinda.framework.app.MainFragment;
import com.tencent.kinda.framework.app.ModalFragment;
import com.tencent.kinda.framework.app.UIPageFragmentActivity;
import com.tencent.kinda.framework.widget.base.BaseFragment;
import com.tencent.kinda.framework.widget.base.IEventFragment;
import com.tencent.kinda.gen.IUIModal;
import com.tencent.kinda.gen.IUIPage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ActivityController
{
  public static final String TAG = "MicroMsg.ActivityController";
  private static boolean activityCreating;
  private static WeakReference<Activity> currentActivity;
  private static HashMap<Integer, BaseFragment> fragmentPond;
  private static List<Integer> pendingList;
  
  static
  {
    AppMethodBeat.i(145146);
    fragmentPond = new HashMap();
    activityCreating = false;
    pendingList = new ArrayList();
    AppMethodBeat.o(145146);
  }
  
  public static void attach(Activity paramActivity)
  {
    AppMethodBeat.i(145141);
    ab.i("MicroMsg.ActivityController", "attach %s", new Object[] { paramActivity });
    try
    {
      currentActivity = new WeakReference(paramActivity);
      if (pendingList.size() > 0)
      {
        paramActivity = (IEventFragment)currentActivity.get();
        Iterator localIterator = pendingList.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (Integer)localIterator.next();
          localObject = (BaseFragment)fragmentPond.get(localObject);
          if (localObject != null) {
            paramActivity.addFragment((BaseFragment)localObject);
          }
        }
        pendingList.clear();
      }
    }
    finally
    {
      AppMethodBeat.o(145141);
    }
    activityCreating = false;
    AppMethodBeat.o(145141);
  }
  
  public static void remove(IUIModal paramIUIModal)
  {
    AppMethodBeat.i(145145);
    try
    {
      Activity localActivity = (Activity)currentActivity.get();
      paramIUIModal = (BaseFragment)fragmentPond.remove(Integer.valueOf(paramIUIModal.hashCode()));
      if (((localActivity instanceof IEventFragment)) && (paramIUIModal != null)) {
        ((IEventFragment)localActivity).removeModal(paramIUIModal);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(145145);
    }
  }
  
  public static BaseFragment resolveFragment(Bundle paramBundle)
  {
    AppMethodBeat.i(145142);
    int i = paramBundle.getInt("intent_target", 0);
    if (fragmentPond.containsKey(Integer.valueOf(i)))
    {
      paramBundle = (BaseFragment)fragmentPond.remove(Integer.valueOf(i));
      AppMethodBeat.o(145142);
      return paramBundle;
    }
    AppMethodBeat.o(145142);
    return null;
  }
  
  public static void startNewUIModal(IUIModal paramIUIModal)
  {
    AppMethodBeat.i(145144);
    try
    {
      int i = paramIUIModal.hashCode();
      if (!fragmentPond.containsKey(Integer.valueOf(i)))
      {
        localObject = new ModalFragment();
        ((ModalFragment)localObject).attachModal(paramIUIModal);
        fragmentPond.put(Integer.valueOf(i), localObject);
      }
      for (paramIUIModal = (IUIModal)localObject; (currentActivity != null) && (currentActivity.get() != null); paramIUIModal = (BaseFragment)fragmentPond.get(Integer.valueOf(i)))
      {
        ((IEventFragment)currentActivity.get()).addFragment(paramIUIModal);
        return;
      }
      pendingList.add(Integer.valueOf(i));
      if (activityCreating) {
        return;
      }
      activityCreating = true;
      paramIUIModal = KindaContext.get();
      Object localObject = new Intent(paramIUIModal, UIPageFragmentActivity.class);
      if ((paramIUIModal instanceof Activity)) {
        ((Activity)paramIUIModal).getIntent().putExtra("extra_use_system_default_enter_exit_anim", true);
      }
      ((Intent)localObject).putExtra("key_support_swipe_back", false);
      paramIUIModal.startActivity((Intent)localObject);
      return;
    }
    finally
    {
      AppMethodBeat.o(145144);
    }
  }
  
  public static void startNewUIPage(IUIPage paramIUIPage)
  {
    AppMethodBeat.i(145143);
    Object localObject = new MainFragment();
    ((MainFragment)localObject).attachPage(paramIUIPage);
    fragmentPond.put(Integer.valueOf(paramIUIPage.hashCode()), localObject);
    Intent localIntent;
    if ((currentActivity != null) && (currentActivity.get() != null))
    {
      localObject = (Context)currentActivity.get();
      localIntent = new Intent((Context)localObject, UIPageFragmentActivity.class);
      localIntent.addFlags(67108864);
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("intent_target", paramIUIPage.hashCode());
      localIntent.putExtra("intent_bundle", localBundle);
      if ((currentActivity == null) || (!(currentActivity.get() instanceof UIPageFragmentActivity))) {
        break;
      }
      ((UIPageFragmentActivity)currentActivity.get()).onNewIntent(localIntent);
      AppMethodBeat.o(145143);
      return;
      localObject = KindaContext.get();
      localIntent = new Intent((Context)localObject, UIPageFragmentActivity.class);
    }
    ((Context)localObject).startActivity(localIntent);
    AppMethodBeat.o(145143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.tools.ActivityController
 * JD-Core Version:    0.7.0.1
 */