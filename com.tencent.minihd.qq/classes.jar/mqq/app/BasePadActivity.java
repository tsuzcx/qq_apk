package mqq.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@SuppressLint({"NewApi", "ValidFragment"})
public class BasePadActivity
  extends Activity
{
  public static final String ACTION_NOTIFY_FINISH = "action_notify_finish";
  public static final String CLEAR_FRAGMENT_STACK = "clear_fragment_stack";
  public static final String DIALOG_FULL_SCREEN = "dialog_full_screen";
  public static final String DISPLAY_LIKE_DIALOG = "display_like_dialog";
  public static final String FORCE_NOT_MODAL = "force_not_modal";
  public static final String FRAGMENT_NO_ANIM = "fragment_no_anim";
  public static final String FROM_ACTIVITY = "from_activity";
  public static final String FULL_SCREEN_WINDOW = "full_screen_window";
  public static final String HAS_BASE_FRAGMENT = "has_base_fragment";
  public static final String IS_ACTIVITY_TO_FRAGMENT = "is_activity_to_fragment";
  public static final String IS_BASE_FRAGMENT = "is_base_fragment";
  public static final String IS_FIRST_WINOW = "is_first_window";
  public static final String KEY_REQUEST_CODE = "pad_request_code";
  public static final String MY_FILE_FULLSCREEN = "my_file_fullscreen";
  public static final String NEW_TASK_FULLSCREEN = "new_task_fullscreen";
  public static final String NEW_TASK_SHOW_RIGHT_BELONG_TAB = "new_task_show_right_belong_tab";
  public static final String NOTIFY_WHEN_DESTORY = "notify_activity_finish";
  public static final String NO_ANIM_ONECE = "open_fragment_no_anim_once";
  public static final String NO_COVER_ANIM = "no_cover_anim";
  public static final String REPLACE_STACK = "replace_stack";
  static final String TAG_BASE_FRAGMENT = "base_fragment";
  public static final String TARGET_ACTIVITY = "target_activity";
  private static int mContainerViewId = -10000;
  public static boolean sFragmentAnimating;
  static SparseIntArray tabTagMap = new SparseIntArray();
  private final String TAG = "ArchitectureDebug";
  public boolean bActivityToFragment;
  public final boolean bArchitectureDebug = true;
  boolean beginCallBackEvent;
  boolean calledFinish;
  private Window customWindow;
  boolean finished;
  boolean forceFinish;
  int fragmentContainerID;
  private Activity mActivity;
  private ComponentName mComponent;
  private Context mContext;
  private NewTaskHandler mTaskHandler;
  private ModalWindow mw;
  private MyFragment myFragment;
  boolean notifyWhenDestory;
  boolean replaceFragmentByActivity;
  int requestCode = -1;
  private Bundle waitBulde;
  private Intent waitIntent;
  private int waitRequestCode;
  
  private final String Indentity()
  {
    return getComponentName().getClassName() + "@" + hashCode();
  }
  
  private final void LOG(String paramString)
  {
    Log.d("ArchitectureDebug", "---------BasePadActivity :" + paramString);
  }
  
  private MyFragment addBaseFragment(boolean paramBoolean)
  {
    this.myFragment = new MyFragment(this);
    try
    {
      if (mContainerViewId == -10000) {
        mContainerViewId = 16908290;
      }
      View localView = getActivity().findViewById(mContainerViewId);
      if (localView != null)
      {
        localView.setVisibility(0);
        FragmentTransaction localFragmentTransaction = getActivity().getFragmentManager().beginTransaction();
        this.myFragment.isBaseFragment = true;
        this.myFragment.noAnim = true;
        if (((ViewGroup)localView).getChildCount() > 0) {
          localFragmentTransaction.add(((ViewGroup)localView).getChildAt(0).getId(), this.myFragment, "base_fragment");
        }
        localFragmentTransaction.commitAllowingStateLoss();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LOG("addBaseFragment error=" + localException.toString());
      }
    }
    return this.myFragment;
  }
  
  private MyFragment addMyFragment(boolean paramBoolean)
  {
    this.myFragment = new MyFragment(this);
    for (;;)
    {
      try
      {
        if (mContainerViewId == -10000) {
          mContainerViewId = 16908290;
        }
        localView = getActivity().findViewById(mContainerViewId);
        if (localView == null) {
          return null;
        }
        localFragmentTransaction = getActivity().getFragmentManager().beginTransaction();
        localView.setVisibility(0);
        if (!paramBoolean) {
          continue;
        }
        if (!signFragmentsAnim()) {
          continue;
        }
        this.myFragment.replaceStack = true;
        clearTabTagCount();
      }
      catch (Exception localException)
      {
        View localView;
        FragmentTransaction localFragmentTransaction;
        LOG("addMyFragment   error" + localException);
        continue;
        this.myFragment.replaceStack = true;
        continue;
        this.myFragment.fromUser = true;
        continue;
        localFragmentTransaction.replace(mContainerViewId, this.myFragment, createTagByCount());
        continue;
      }
      setIntentAnimState(getIntent(), false, this.myFragment);
      clearIntentAnimState();
      noAnimWhenNoContent(this.myFragment);
      increaseTagCount();
      if ((paramBoolean) || ((hasContentView()) && (getFragmentCount((ViewGroup)localView) <= 1))) {
        continue;
      }
      localFragmentTransaction.add(mContainerViewId, this.myFragment, createTagByCount());
      if (!paramBoolean) {
        localFragmentTransaction.addToBackStack(null);
      }
      localFragmentTransaction.commitAllowingStateLoss();
      if (paramBoolean) {
        clearFragmentStack();
      }
      return this.myFragment;
      if (!isActivityResumed()) {
        continue;
      }
      this.myFragment.fromUser = true;
    }
  }
  
  private void addNotifyFinishParam(Intent paramIntent)
  {
    if ((getParent() != null) || ((this.notifyWhenDestory) && (!hasContentView())))
    {
      this.notifyWhenDestory = false;
      paramIntent.putExtra("notify_activity_finish", true);
    }
  }
  
  private void callActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  private void clearFragmentStack()
  {
    final Fragment localFragment = getFragmentManager().findFragmentById(mContainerViewId);
    getActivity().runOnUiThread(new Runnable()
    {
      public void run()
      {
        do
        {
          try
          {
            BasePadActivity.this.runOnUiThread(new Runnable()
            {
              public void run()
              {
                BasePadActivity.this.clearTabTask(BasePadActivity.this.mActivity, false);
              }
            });
            FragmentManager localFragmentManager = BasePadActivity.this.getActivity().getFragmentManager();
            int k = 1;
            int i = 0;
            BasePadActivity.invoke(localFragmentManager, localFragmentManager.getClass(), "noteStateNotSaved", null, null);
            while (k != 0)
            {
              boolean bool = localFragmentManager.popBackStackImmediate();
              int j = i;
              if (bool) {
                j = 1;
              }
              BasePadActivity.this.LOG("popBackStackImmediate success=" + bool);
              k = bool;
              i = j;
              if (!bool)
              {
                k = bool;
                i = j;
                if (j != 0)
                {
                  BasePadActivity.this.removeLastFragment();
                  k = bool;
                  i = j;
                }
              }
            }
            while (i != 0) {}
          }
          catch (Exception localException)
          {
            BasePadActivity.this.LOG("clearFragmentStack error=" + localException.toString());
            return;
          }
        } while ((localFragment == null) || (!(BasePadActivity.this.getActivity() instanceof BasePadActivity)));
        ((BasePadActivity)BasePadActivity.this.getActivity()).doWhenFragmentReplace(localFragment, BasePadActivity.this.myFragment);
      }
    });
  }
  
  private void clearIntentAnimState()
  {
    if (getIntent() != null)
    {
      Intent localIntent = getIntent();
      localIntent.removeExtra("open_fragment_no_anim_once");
      localIntent.removeExtra("fragment_no_anim");
      localIntent.removeExtra("no_cover_anim");
    }
  }
  
  private static void clearTabTagCount()
  {
    tabTagMap.put(mContainerViewId, 0);
  }
  
  private void clearTabTask(Activity paramActivity, boolean paramBoolean)
  {
    if ((paramActivity == null) || (paramActivity.getParent() == null) || ((paramBoolean) && (hasContentView()))) {}
    try
    {
      signFragmentsAnim();
      localObject = getActivity().getFragmentManager();
      invoke(localObject, localObject.getClass(), "noteStateNotSaved", null, null);
      for (paramBoolean = true; paramBoolean; paramBoolean = ((FragmentManager)localObject).popBackStackImmediate()) {}
      this.replaceFragmentByActivity = true;
      removeLastFragment();
      this.replaceFragmentByActivity = false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        int i;
        Log.e("ArchitectureDebug", "clearTabTask error this=" + this, localException);
      }
    }
    i = getTabIndex();
    if (i >= 0)
    {
      localObject = new Intent("finish_all_activity_in_task");
      ((Intent)localObject).putExtra("cur_Tab_Id", i);
      ((Intent)localObject).putExtra("notify_activity_finish", false);
      paramActivity.sendBroadcast((Intent)localObject);
    }
  }
  
  public static String createTagByCount()
  {
    return String.valueOf(tabTagMap.get(mContainerViewId));
  }
  
  private MyFragment findSecondTopFragment()
  {
    int i = tabTagMap.get(mContainerViewId);
    FragmentManager localFragmentManager = getFragmentManager();
    Object localObject1 = null;
    Object localObject4 = null;
    Object localObject2 = localObject4;
    if (i > 0)
    {
      localObject2 = (MyFragment)localFragmentManager.findFragmentByTag(String.valueOf(i));
      Object localObject3 = localObject1;
      if (localObject2 != null)
      {
        if (localObject1 != null) {
          break label65;
        }
        localObject3 = localObject2;
      }
      label65:
      do
      {
        i -= 1;
        localObject1 = localObject3;
        break;
        localObject3 = localObject1;
      } while (0 != 0);
    }
    return localObject2;
  }
  
  private boolean finishTopFragment()
  {
    Object localObject = getTopFragment();
    if ((localObject instanceof MyFragment))
    {
      localObject = ((MyFragment)localObject).getBasePadAct();
      ((BasePadActivity)localObject).finish();
      return ((BasePadActivity)localObject).finished;
    }
    return removeTopFragment();
  }
  
  public static int getContaierViewId()
  {
    return mContainerViewId;
  }
  
  private boolean getDisplayLikeDialogParam(Intent paramIntent)
  {
    boolean bool = paramIntent.getBooleanExtra("display_like_dialog", false);
    paramIntent = paramIntent.getBundleExtra("pluginsdk_inner_intent_extras");
    if ((paramIntent != null) && (!bool)) {
      return paramIntent.getBoolean("display_like_dialog", false);
    }
    return bool;
  }
  
  private static Object getPrivateFiledValue(Object paramObject, Class<?> paramClass, String paramString)
  {
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      paramClass.setAccessible(true);
      paramObject = paramClass.get(paramObject);
      return paramObject;
    }
    catch (NoSuchFieldException paramObject)
    {
      Log.e("app2", "getPrivateFiledValue NoSuchFieldException =", paramObject);
      return null;
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        Log.e("app", "field-->fieldName=" + paramString, paramObject);
      }
    }
  }
  
  private boolean handleFragmentBackEvent()
  {
    Fragment localFragment = getFragmentManager().findFragmentById(mContainerViewId);
    LOG("handleFragmentBackEvent--》topFragment=" + localFragment);
    return ((localFragment instanceof MyFragment)) && (((MyFragment)localFragment).onBackEvent());
  }
  
  private void handleSetResult(int paramInt, boolean paramBoolean)
  {
    if ((this.bActivityToFragment) && (paramInt < 0)) {}
    int i;
    Object localObject;
    do
    {
      return;
      i = 0;
      localObject = getPrivateFiledValue(this, Activity.class, "mResultCode");
      if (localObject != null) {
        i = ((Integer)localObject).intValue();
      }
      localObject = (Intent)getPrivateFiledValue(this, Activity.class, "mResultData");
      if (paramBoolean) {
        break;
      }
      localFragment = getFragmentManager().findFragmentById(mContainerViewId);
      LOG("handleSetResult--》topFragment=" + localFragment);
      if ((localFragment instanceof MyFragment))
      {
        ((MyFragment)localFragment).onActivityResult(paramInt, i, (Intent)localObject);
        return;
      }
      localFragment = getFragmentManager().findFragmentByTag("base_fragment");
    } while (!(localFragment instanceof MyFragment));
    ((MyFragment)localFragment).onActivityResult(paramInt, i, (Intent)localObject);
    return;
    LOG("handleSetResult--》getActivity()=" + getActivity());
    Fragment localFragment = getFragmentManager().findFragmentByTag("base_fragment");
    if ((localFragment instanceof MyFragment))
    {
      ((MyFragment)localFragment).onActivityResult(paramInt, i, (Intent)localObject);
      return;
    }
    callActivityResult(paramInt, i, (Intent)localObject);
  }
  
  private static void increaseTagCount()
  {
    int i = tabTagMap.get(mContainerViewId);
    tabTagMap.put(mContainerViewId, i + 1);
  }
  
  private boolean interceptClearTopFlag(Intent paramIntent)
  {
    int i = paramIntent.getFlags();
    String str;
    if ((hasFlagClearTop(i)) && (paramIntent.getComponent() != null) && (getParent() == null))
    {
      str = paramIntent.getComponent().getClassName();
      if ((str.endsWith("FriendProfileCardActivity")) || (str.endsWith("SpecailCareListActivity"))) {}
    }
    else
    {
      return false;
    }
    int j = getTabIndex();
    if (j >= 0)
    {
      localIntent = new Intent("finish_all_activity_in_task");
      localIntent.putExtra("cur_Tab_Id", j);
      sendBroadcast(localIntent);
    }
    Intent localIntent = new Intent("activty_clear_top");
    localIntent.putExtras(paramIntent.getExtras());
    localIntent.putExtra("class_name", str);
    localIntent.putExtra("flags", i);
    sendBroadcast(localIntent);
    return true;
  }
  
  public static Object invoke(Object paramObject, Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    Object localObject = paramClass;
    if (paramClass == null) {}
    try
    {
      localObject = paramObject.getClass();
      paramClass = ((Class)localObject).getDeclaredMethod(paramString, paramArrayOfClass);
      paramClass.setAccessible(true);
      paramObject = paramClass.invoke(paramObject, paramArrayOfObject);
      return paramObject;
    }
    catch (Exception paramObject)
    {
      Log.e("app2", "invoke-->methodName=" + paramString, paramObject);
    }
    return null;
  }
  
  private boolean isActivityResumed()
  {
    Object localObject = getActivity().getParent();
    if (localObject != null)
    {
      localObject = invoke(localObject, Activity.class, "isResumed", null, null);
      if ((localObject != null) && (((Boolean)localObject).booleanValue())) {
        return true;
      }
    }
    return false;
  }
  
  private boolean isCurActOpendInRight(Intent paramIntent)
  {
    boolean bool2 = false;
    ComponentName localComponentName = paramIntent.getComponent();
    Object localObject = getFragmentManager().findFragmentById(mContainerViewId);
    boolean bool3 = paramIntent.getBooleanExtra("fouce_close", false);
    boolean bool1 = bool2;
    if ((localObject instanceof MyFragment))
    {
      bool1 = bool2;
      if (!bool3)
      {
        localObject = ((MyFragment)localObject).getBasePadAct();
        LOG("isCurActOpendInRight--》rightOpenedAct=" + localObject);
        bool1 = bool2;
        if (localComponentName != null)
        {
          bool1 = bool2;
          if (localComponentName.equals(((BasePadActivity)localObject).mComponent))
          {
            bool1 = bool2;
            if (((BasePadActivity)localObject).dataEquals(paramIntent))
            {
              ((BasePadActivity)localObject).onNewIntent(paramIntent);
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean isLansacpe()
  {
    return getActivity().getResources().getConfiguration().orientation == 2;
  }
  
  private void noAnimWhenNoContent(MyFragment paramMyFragment)
  {
    if (!hasContentView())
    {
      MyFragment localMyFragment = (MyFragment)getFragmentManager().findFragmentById(mContainerViewId);
      paramMyFragment.noAnim = true;
      if (localMyFragment != null) {
        localMyFragment.noAnimForOnce = true;
      }
    }
  }
  
  private boolean parse()
  {
    try
    {
      Object localObject1 = getComponentName();
      LOG("parse() componentName:" + localObject1);
      localObject1 = getPackageManager().getActivityInfo((ComponentName)localObject1, 0).processName;
      LOG("parse() processName:" + (String)localObject1);
      if (((String)localObject1).contains(":")) {
        this.bActivityToFragment = false;
      }
      LOG("parse() bActivityToFragment:" + this.bActivityToFragment);
      return this.bActivityToFragment;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localNameNotFoundException = localNameNotFoundException;
        localNameNotFoundException.printStackTrace();
      }
    }
    finally {}
  }
  
  private void recycleTextLinesCache()
  {
    try
    {
      Class localClass = Class.forName("android.text.TextLine");
      Object localObject = localClass.getDeclaredConstructor(new Class[0]);
      ((Constructor)localObject).setAccessible(true);
      localObject = ((Constructor)localObject).newInstance(null);
      if (localObject != null)
      {
        Method localMethod = localObject.getClass().getDeclaredMethod("obtain", null);
        localMethod.setAccessible(true);
        localObject.getClass().getDeclaredMethod("recycle", new Class[] { localClass }).setAccessible(true);
        localMethod.invoke(localObject, null);
        localMethod.invoke(localObject, null);
        localMethod.invoke(localObject, null);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private boolean removeLastFragment()
  {
    MyFragment localMyFragment = (MyFragment)getFragmentManager().findFragmentById(mContainerViewId);
    LOG("removeLastFragment--》lastFragment=" + localMyFragment);
    if ((localMyFragment != null) && (!localMyFragment.isBaseFragment))
    {
      int j = 1;
      int i = j;
      if (localMyFragment.getView() != null)
      {
        localObject = (ViewGroup)localMyFragment.getView().getParent();
        i = j;
        if (localObject != null)
        {
          j = getFragmentCount((ViewGroup)localObject);
          i = j;
          if (goneFragmentContainer((ViewGroup)localObject)) {
            if (!localMyFragment.noAnim)
            {
              i = j;
              if (!localMyFragment.noAnimForOnce) {}
            }
            else
            {
              ((ViewGroup)localObject).setVisibility(8);
              i = j;
            }
          }
        }
      }
      Object localObject = getFragmentManager().beginTransaction();
      localMyFragment.fromUser = true;
      ((FragmentTransaction)localObject).remove(localMyFragment);
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
      if ((getActivity() instanceof BasePadActivity))
      {
        if (i != 1) {
          break label205;
        }
        ((BasePadActivity)getActivity()).doWhenFragmentReplace(localMyFragment, null);
        if ((localMyFragment.getBasePadAct().hasContentView()) && (!this.replaceFragmentByActivity)) {
          ((BasePadActivity)getActivity()).rightPanelEmpty();
        }
      }
      for (;;)
      {
        return true;
        label205:
        if (i > 1) {
          ((BasePadActivity)getActivity()).doWhenFragmentReplace(localMyFragment, this.myFragment);
        }
      }
    }
    return false;
  }
  
  private boolean removeTopFragment()
  {
    try
    {
      hideSoftPanel();
      int i = -1;
      Fragment localFragment = getFragmentManager().findFragmentById(mContainerViewId);
      if ((localFragment instanceof MyFragment)) {
        if (!this.bActivityToFragment) {
          break label112;
        }
      }
      label112:
      for (i = this.requestCode;; i = ((MyFragment)localFragment).getBasePadAct().requestCode)
      {
        ((MyFragment)localFragment).fromUser = true;
        FragmentManager localFragmentManager = getActivity().getFragmentManager();
        invoke(localFragmentManager, localFragmentManager.getClass(), "noteStateNotSaved", null, null);
        if (localFragmentManager.popBackStackImmediate()) {
          break;
        }
        if ((localFragment instanceof MyFragment)) {
          ((MyFragment)localFragment).fromUser = false;
        }
        if (!willRemoveLast()) {
          break label143;
        }
        boolean bool = removeLastFragment();
        handleSetResult(i, true);
        return bool;
      }
      handleSetResult(i, false);
      return true;
    }
    catch (Exception localException)
    {
      LOG(localException.toString());
    }
    label143:
    return false;
  }
  
  private boolean sameFragment(MyFragment paramMyFragment1, MyFragment paramMyFragment2)
  {
    if ((paramMyFragment1 == null) || (paramMyFragment2 == null)) {}
    do
    {
      return false;
      paramMyFragment1 = paramMyFragment1.getBasePadAct();
      paramMyFragment2 = paramMyFragment2.getBasePadAct();
      paramMyFragment1 = paramMyFragment1.mComponent;
    } while ((paramMyFragment1 == null) || (!paramMyFragment1.equals(paramMyFragment2.mComponent)));
    return true;
  }
  
  public static void setContaierViewId(int paramInt)
  {
    mContainerViewId = paramInt;
  }
  
  private void setIntentAnimState(Intent paramIntent, boolean paramBoolean, MyFragment paramMyFragment)
  {
    boolean bool1;
    boolean bool2;
    if (paramIntent != null)
    {
      bool1 = paramIntent.getBooleanExtra("fragment_no_anim", false);
      bool2 = paramIntent.getBooleanExtra("open_fragment_no_anim_once", false);
      if (paramBoolean) {
        break label59;
      }
      paramMyFragment.noAnim = bool1;
      if (bool2)
      {
        paramMyFragment.noAnimForOnce = true;
        paramMyFragment.fromUser = false;
      }
      paramMyFragment.noCoverAnim = paramIntent.getBooleanExtra("no_cover_anim", false);
    }
    label59:
    do
    {
      return;
      paramMyFragment.noAnimForOnce = bool2;
      if (bool1)
      {
        paramMyFragment.noAnimForOnce = true;
        paramMyFragment.twice = true;
        paramMyFragment.fromUser = false;
        return;
      }
    } while (!paramMyFragment.noAnim);
    paramIntent.putExtra("no_cover_anim", true);
  }
  
  static void setPrivateFiledValue(Object paramObject1, Class<?> paramClass, String paramString, Object paramObject2)
  {
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      paramClass.setAccessible(true);
      paramClass.set(paramObject1, paramObject2);
      return;
    }
    catch (NoSuchFieldException paramObject1)
    {
      Log.e("app2", "setPrivateFiledValue NoSuchFieldException =", paramObject1);
      return;
    }
    catch (Exception paramObject1)
    {
      Log.e("app", "setPrivateFiledValue field-->fieldName=" + paramString, paramObject1);
    }
  }
  
  private boolean signFragmentsAnim()
  {
    int i = tabTagMap.get(mContainerViewId);
    boolean bool = false;
    Object localObject1 = null;
    FragmentManager localFragmentManager = getFragmentManager();
    if (i > 0)
    {
      MyFragment localMyFragment = (MyFragment)localFragmentManager.findFragmentByTag(String.valueOf(i));
      Object localObject2 = localObject1;
      if (localMyFragment != null)
      {
        if (localObject1 != null) {
          break label74;
        }
        localObject1 = localMyFragment;
        localMyFragment.replaceStack = true;
      }
      for (;;)
      {
        bool = true;
        localObject2 = localObject1;
        i -= 1;
        localObject1 = localObject2;
        break;
        label74:
        localMyFragment.noAnim = true;
      }
    }
    return bool;
  }
  
  private void startActivityImmediateOrDelay(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    Object localObject1 = getActivity();
    Object localObject2 = ((Activity)localObject1).getParent();
    if (localObject2 == null) {
      doStartActivityForResult(paramIntent, paramInt, paramBundle);
    }
    do
    {
      return;
      localObject2 = invoke(localObject2, Activity.class, "isResumed", null, null);
      if ((localObject2 != null) && (((Boolean)localObject2).booleanValue()))
      {
        doStartActivityForResult(paramIntent, paramInt, paramBundle);
        return;
      }
    } while (!(localObject1 instanceof BasePadActivity));
    localObject1 = (BasePadActivity)localObject1;
    ((BasePadActivity)localObject1).waitIntent = paramIntent;
    ((BasePadActivity)localObject1).waitRequestCode = paramInt;
    ((BasePadActivity)localObject1).waitBulde = paramBundle;
  }
  
  private void triggerActivityResult()
  {
    Object localObject = getIntent();
    int i;
    if (localObject != null) {
      i = ((Intent)localObject).getFlags();
    }
    try
    {
      int j = ((Intent)localObject).getIntExtra("pad_request_code", 0);
      if ((j > 0) && (hasFlagNewTask(i)))
      {
        i = 0;
        localObject = getPrivateFiledValue(this, Activity.class, "mResultCode");
        if (localObject != null) {
          i = ((Integer)localObject).intValue();
        }
        Intent localIntent = (Intent)getPrivateFiledValue(this, Activity.class, "mResultData");
        localObject = localIntent;
        if (localIntent == null) {
          localObject = new Intent();
        }
        localObject = new Intent((Intent)localObject);
        ((Intent)localObject).setAction("new_task_activity_result");
        ((Intent)localObject).putExtra("resultCode", i);
        ((Intent)localObject).putExtra("requestCode", j);
        sendBroadcast((Intent)localObject);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private boolean willRemoveLast()
  {
    boolean bool = true;
    if ((getActivity() instanceof BasePadActivity)) {
      bool = ((BasePadActivity)getActivity()).willRemoveLastFragment();
    }
    return (bool) || (this.forceFinish);
  }
  
  protected void allowContainerNotRemove(View paramView, boolean paramBoolean) {}
  
  protected boolean alwaysShowRightView()
  {
    return false;
  }
  
  protected void broadcastRecieve(Intent paramIntent) {}
  
  public void clearTabStack()
  {
    Activity localActivity = getActivity();
    if ((localActivity != null) && (localActivity.getParent() != null))
    {
      signFragmentsAnim();
      Object localObject1 = getActivity().getFragmentManager();
      invoke(localObject1, localObject1.getClass(), "noteStateNotSaved", null, null);
      for (boolean bool = true; bool; bool = ((FragmentManager)localObject1).popBackStackImmediate()) {}
      localObject1 = getFragmentManager().findFragmentById(((BasePadActivity)getActivity()).fragmentContainerID);
      if (localObject1 != null)
      {
        if (((Fragment)localObject1).getView() != null)
        {
          ((Fragment)localObject1).getView().setVisibility(8);
          localObject2 = (ViewGroup)((Fragment)localObject1).getView().getParent();
          if ((localObject2 != null) && (getFragmentCount((ViewGroup)localObject2) <= 1) && (getResources().getConfiguration().orientation == 1) && (!((BasePadActivity)getActivity()).alwaysShowRightView())) {
            ((ViewGroup)localObject2).setVisibility(8);
          }
        }
        Object localObject2 = getFragmentManager().beginTransaction();
        ((FragmentTransaction)localObject2).remove((Fragment)localObject1);
        ((FragmentTransaction)localObject2).commitAllowingStateLoss();
      }
      int i = getTabIndex();
      if (i >= 0)
      {
        localObject1 = new Intent("finish_all_activity_in_task");
        ((Intent)localObject1).putExtra("cur_Tab_Id", i);
        localActivity.sendBroadcast((Intent)localObject1);
      }
      ((BasePadActivity)localActivity).rightPanelEmpty();
    }
  }
  
  public void clearTop(Intent paramIntent)
  {
    boolean bool2;
    String str;
    int i;
    boolean bool1;
    MyFragment localMyFragment;
    BasePadActivity localBasePadActivity;
    if (getActivity().getParent() != null)
    {
      bool2 = hasFlagSingleTop(paramIntent.getIntExtra("flags", 0));
      str = paramIntent.getStringExtra("class_name");
      i = 0;
      paramIntent.putExtra("fouce_close", true);
      localObject = getActivity().getFragmentManager();
      invoke(localObject, localObject.getClass(), "noteStateNotSaved", null, null);
      bool1 = true;
      if (!bool1) {
        break label178;
      }
      localMyFragment = (MyFragment)getFragmentManager().findFragmentById(mContainerViewId);
      j = i;
      if (localMyFragment == null) {
        break label142;
      }
      localBasePadActivity = localMyFragment.getBasePadAct();
      if (!localBasePadActivity.getClass().getName().equals(str)) {
        break label154;
      }
      if (bool2) {
        localBasePadActivity.onNewIntent(paramIntent);
      }
    }
    else
    {
      return;
    }
    int j = 1;
    label142:
    label154:
    do
    {
      localMyFragment.noAnimForOnce = true;
      bool1 = ((FragmentManager)localObject).popBackStackImmediate();
      i = j;
      break;
      j = i;
    } while (i == 0);
    paramIntent.setClassName(getPackageName(), str);
    localBasePadActivity.startActivity(paramIntent);
    return;
    label178:
    Object localObject = (MyFragment)getFragmentManager().findFragmentById(mContainerViewId);
    if (localObject != null)
    {
      localObject = ((MyFragment)localObject).getBasePadAct();
      if (localObject.getClass().getName().equals(str))
      {
        if (bool2)
        {
          ((BasePadActivity)localObject).onNewIntent(paramIntent);
          return;
        }
        ((BasePadActivity)localObject).forceFinish = true;
        ((BasePadActivity)localObject).finish();
      }
    }
    paramIntent.setClassName(getPackageName(), str);
    startActivity(paramIntent);
  }
  
  public void closeModalWindow()
  {
    closeModalWindow(true);
  }
  
  public void closeModalWindow(boolean paramBoolean)
  {
    if ((this.mw != null) && (this.mw.displayLikeDialog)) {
      this.mw.closeModelWindow(paramBoolean);
    }
  }
  
  protected boolean dataEquals(Intent paramIntent)
  {
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (sFragmentAnimating) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void doOnRecieve(Intent paramIntent)
  {
    if ((getParent() != null) && (paramIntent != null))
    {
      paramIntent.getStringExtra("request_class_name");
      Object localObject = getFragmentManager().findFragmentById(mContainerViewId);
      if (localObject != null)
      {
        localObject = ((MyFragment)localObject).getBasePadAct();
        paramIntent.setAction(null);
        ((BasePadActivity)localObject).broadcastRecieve(paramIntent);
      }
    }
  }
  
  public void doStartActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (this.bActivityToFragment)
    {
      Activity localActivity = getMainActivity();
      if ((localActivity instanceof BasePadActivity))
      {
        ((BasePadActivity)localActivity).doStartActivityForResult(paramIntent, paramInt, paramBundle);
        return;
      }
      localActivity.startActivityForResult(paramIntent, paramInt, paramBundle);
      return;
    }
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
  
  public void doSuperFinish()
  {
    triggerActivityResult();
    notifyFinish();
    hideSoftPanel();
    super.finish();
  }
  
  public void doSuperOverridePendingTransition(int paramInt1, int paramInt2)
  {
    super.overridePendingTransition(paramInt1, paramInt2);
  }
  
  protected void doWhenFragmentReplace(Fragment paramFragment1, Fragment paramFragment2) {}
  
  public boolean exitByTip()
  {
    return true;
  }
  
  protected void finalize()
    throws Throwable
  {
    if (!this.bActivityToFragment) {}
    for (;;)
    {
      super.finalize();
      return;
      LOG("finalize: " + Indentity());
    }
  }
  
  public void finish()
  {
    if (!this.bActivityToFragment) {
      if ((this.mw != null) && (this.mw.displayLikeDialog)) {
        this.mw.doFinish();
      }
    }
    do
    {
      do
      {
        return;
        if ((this.mTaskHandler != null) && (this.mTaskHandler.resizeWindow))
        {
          this.mTaskHandler.doFinish();
          return;
        }
        doSuperFinish();
        return;
      } while (this.finished);
      if (this.beginCallBackEvent) {
        this.calledFinish = true;
      }
    } while (!removeTopFragment());
    this.finished = true;
  }
  
  public Activity getActivity()
  {
    if (!this.bActivityToFragment) {
      return this;
    }
    return ((BasePadActivity)this.mActivity).getActivity();
  }
  
  public Context getApplicationContext()
  {
    if (!this.bActivityToFragment) {
      return super.getApplicationContext();
    }
    return this.mContext.getApplicationContext();
  }
  
  public AssetManager getAssets()
  {
    if (!this.bActivityToFragment) {
      return super.getAssets();
    }
    return this.mContext.getAssets();
  }
  
  public Context getBaseContext()
  {
    if (!this.bActivityToFragment) {
      return super.getBaseContext();
    }
    return this.mContext;
  }
  
  public ComponentName getComponentName()
  {
    if (!this.bActivityToFragment) {
      return super.getComponentName();
    }
    return this.mComponent;
  }
  
  public int getFragmentCount(ViewGroup paramViewGroup)
  {
    int j = 0;
    int i = 0;
    while (i < paramViewGroup.getChildCount())
    {
      Object localObject = paramViewGroup.getChildAt(i).getTag();
      int k = j;
      if ((localObject instanceof String))
      {
        k = j;
        if (Fragment.class.getName().equals(localObject)) {
          k = j + 1;
        }
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  public FragmentManager getFragmentManager()
  {
    if (this.bActivityToFragment) {
      return getActivity().getFragmentManager();
    }
    return super.getFragmentManager();
  }
  
  public int getLefPanelWidth()
  {
    return -1;
  }
  
  public String getLocalClassName()
  {
    String str2 = getPackageName();
    if (this.mComponent == null) {}
    int i;
    for (String str1 = "";; str1 = this.mComponent.getClassName())
    {
      i = str2.length();
      if ((str1.startsWith(str2)) && (str1.length() > i) && (str1.charAt(i) == '.')) {
        break;
      }
      return str1;
    }
    return str1.substring(i + 1);
  }
  
  public Activity getMainActivity()
  {
    if (!this.bActivityToFragment)
    {
      if (getParent() == null) {
        return this;
      }
      return getParent();
    }
    return getActivity().getParent();
  }
  
  protected int getModalWindowFinishAnim()
  {
    return 0;
  }
  
  protected int getModalWindowOpenAnim()
  {
    return 0;
  }
  
  public final Application getMyApplication()
  {
    if (!this.bActivityToFragment) {
      return getApplication();
    }
    return getActivity().getApplication();
  }
  
  public int getRealFragmentCount()
  {
    int i = tabTagMap.get(mContainerViewId);
    int j = 0;
    FragmentManager localFragmentManager = getFragmentManager();
    while (i > 0)
    {
      int k = j;
      if (localFragmentManager.findFragmentByTag(String.valueOf(i)) != null) {
        k = j + 1;
      }
      i -= 1;
      j = k;
    }
    return j;
  }
  
  public Resources getResources()
  {
    if (!this.bActivityToFragment) {
      return super.getResources();
    }
    return this.mContext.getResources();
  }
  
  protected int getRightPanelWidth()
  {
    return -1;
  }
  
  public Object getSystemService(String paramString)
  {
    if (!this.bActivityToFragment) {
      return super.getSystemService(paramString);
    }
    return this.mActivity.getSystemService(paramString);
  }
  
  protected int getTabIndex()
  {
    if ((this.mTaskHandler != null) && (this.mTaskHandler.resizeWindow)) {
      return this.mTaskHandler.tabIndex;
    }
    return -1;
  }
  
  public Fragment getTopFragment()
  {
    return getFragmentManager().findFragmentById(mContainerViewId);
  }
  
  public Window getWindow()
  {
    if (!this.bActivityToFragment)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArchitectureDebug", 2, "BasePadActivity getWindow call super," + getClass().getSimpleName());
      }
      return super.getWindow();
    }
    if (this.customWindow == null) {
      this.customWindow = new Window4FragmentTitle(this.mContext);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArchitectureDebug", 2, "BasePadActivity getWindow customWindow = " + this.customWindow + "," + getClass().getSimpleName());
    }
    return this.customWindow;
  }
  
  public WindowManager getWindowManager()
  {
    if (!this.bActivityToFragment) {
      return super.getWindowManager();
    }
    return this.mActivity.getWindowManager();
  }
  
  public boolean goneFragmentContainer(ViewGroup paramViewGroup)
  {
    return (getFragmentCount(paramViewGroup) <= 1) && (getResources().getConfiguration().orientation == 1) && (!((BasePadActivity)getActivity()).alwaysShowRightView());
  }
  
  public void hanldeActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (!this.bActivityToFragment)
    {
      setResult(paramInt2, paramIntent);
      handleSetResult(paramInt1, false);
      handleSetResult(paramInt1, true);
      setResult(0, null);
    }
  }
  
  protected boolean hasContentView()
  {
    boolean bool2 = true;
    Object localObject = getWindow();
    boolean bool1;
    if ((localObject instanceof Window4FragmentTitle)) {
      bool1 = ((Window4FragmentTitle)localObject).hasContentView();
    }
    do
    {
      do
      {
        return bool1;
        localObject = (ViewGroup)((Window)localObject).getDecorView().findViewById(16908290);
        bool1 = bool2;
      } while (localObject == null);
      bool1 = bool2;
    } while (((ViewGroup)localObject).getChildCount() > 0);
    return false;
  }
  
  public boolean hasFlagClearTop(int paramInt)
  {
    return (0x4000000 & paramInt) != 0;
  }
  
  public boolean hasFlagNewTask(int paramInt)
  {
    return (0x10000000 & paramInt) != 0;
  }
  
  public boolean hasFlagSingleTop(int paramInt)
  {
    return (0x20000000 & paramInt) != 0;
  }
  
  public boolean hasFragment()
  {
    return getRealFragmentCount() > 0;
  }
  
  public void hideSoftPanel()
  {
    try
    {
      ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean isBaseFragment()
  {
    if (this.myFragment != null) {
      return this.myFragment.isBaseFragment;
    }
    return false;
  }
  
  public boolean isModeleWindow()
  {
    if (this.mw != null) {
      return this.mw.displayLikeDialog;
    }
    return false;
  }
  
  public boolean isNewTaskActivity()
  {
    if (this.mTaskHandler != null) {
      return this.mTaskHandler.resizeWindow;
    }
    return false;
  }
  
  public boolean isNewTaskFullScreen()
  {
    if (this.mTaskHandler != null) {
      return this.mTaskHandler.isFullScreen;
    }
    return false;
  }
  
  protected boolean matchModalWhenPortrait()
  {
    return false;
  }
  
  public void noFinishAnim()
  {
    if ((this.mw != null) && (this.mw.displayLikeDialog)) {
      this.mw.noAnim = true;
    }
    if ((this.bActivityToFragment) && (this.myFragment != null))
    {
      this.myFragment.noAnim = true;
      MyFragment localMyFragment = findSecondTopFragment();
      if (localMyFragment != null) {
        localMyFragment.noAnimForOnce = true;
      }
    }
  }
  
  protected void notAnim(boolean paramBoolean) {}
  
  public void notifyFinish()
  {
    if ((this.notifyWhenDestory) && (!this.bActivityToFragment))
    {
      Intent localIntent = new Intent("Common_BroadcastReceiver");
      localIntent.putExtra("action_notify_finish", true);
      sendBroadcast(localIntent);
      this.notifyWhenDestory = false;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected void onAlphaAnimEnd() {}
  
  protected void onAlphaAnimStart() {}
  
  protected void onAnimEnd(boolean paramBoolean)
  {
    sFragmentAnimating = false;
  }
  
  protected void onAnimStart(boolean paramBoolean)
  {
    sFragmentAnimating = true;
  }
  
  public void onAttachedToWindow()
  {
    if (this.mTaskHandler != null) {
      this.mTaskHandler.onAttachedToWindow();
    }
    if (this.mw != null) {
      this.mw.onAttachedToWindow();
    }
    super.onAttachedToWindow();
  }
  
  protected boolean onBackEvent()
  {
    return false;
  }
  
  public void onBackPressed()
  {
    if ((getParent() == null) || ((!handleFragmentBackEvent()) && (!finishTopFragment()))) {}
    try
    {
      if (exitByTip()) {
        getParent().moveTaskToBack(true);
      }
      return;
    }
    catch (Throwable localThrowable) {}
    super.onBackPressed();
    return;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (!this.bActivityToFragment)
    {
      if (this.mw != null) {
        this.mw.doConfigChange(paramConfiguration);
      }
      if (this.mTaskHandler != null) {
        this.mTaskHandler.doConfigChange(paramConfiguration);
      }
      super.onConfigurationChanged(paramConfiguration);
    }
    sendBroadcast(new Intent("action_on_configuration_changed"));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Log.d("app2", "onCreate: [" + hashCode() + "]" + getClass().getSimpleName() + " process id =" + Process.myPid() + " onCreate task : " + getTaskId());
    if (!this.bActivityToFragment)
    {
      super.onCreate(paramBundle);
      this.mTaskHandler = new NewTaskHandler(this);
      this.mTaskHandler.onCreate(getIntent());
      this.mw = new ModalWindow(this);
      this.mw.onCreate(getIntent());
      this.notifyWhenDestory = getIntent().getBooleanExtra("notify_activity_finish", false);
      getIntent().removeExtra("notify_activity_finish");
    }
    do
    {
      return;
      LOG("onCreate: " + Indentity());
    } while ((!(this.mActivity instanceof BasePadActivity)) || (this.mActivity.getParent() == null));
    ((BasePadActivity)this.mActivity).fragmentContainerID = mContainerViewId;
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    if (!this.bActivityToFragment) {
      super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    }
  }
  
  protected void onDestroy()
  {
    if (!this.bActivityToFragment)
    {
      notifyFinish();
      if (this.mw != null) {
        this.mw.destory();
      }
      if (this.mTaskHandler != null) {
        this.mTaskHandler.destory();
      }
      super.onDestroy();
      return;
    }
    LOG("onDestroy: " + Indentity());
    recycleTextLinesCache();
  }
  
  public void onInit(Activity paramActivity, Intent paramIntent)
  {
    this.mActivity = paramActivity;
    this.mContext = paramActivity.getBaseContext();
    this.mComponent = paramIntent.getComponent();
    attachBaseContext(this.mContext);
    setIntent(paramIntent);
    this.bActivityToFragment = true;
    if (Build.VERSION.SDK_INT >= 26)
    {
      setPrivateFiledValue(this, Activity.class, "mWindow", getWindow());
      LOG("onInit() setPrivateFiledValue");
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (sFragmentAnimating) {}
    while (this.bActivityToFragment) {
      return false;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (sFragmentAnimating) {}
    while (this.bActivityToFragment) {
      return false;
    }
    boolean bool2 = false;
    Object localObject = getFragmentManager().findFragmentById(mContainerViewId);
    boolean bool1 = false;
    if ((localObject instanceof MyFragment))
    {
      localObject = ((MyFragment)localObject).getBasePadAct();
      ((BasePadActivity)localObject).beginCallBackEvent = true;
      bool2 = ((BasePadActivity)localObject).onKeyDown(paramInt, paramKeyEvent);
      ((BasePadActivity)localObject).beginCallBackEvent = false;
      bool1 = ((BasePadActivity)localObject).calledFinish;
      ((BasePadActivity)localObject).calledFinish = false;
    }
    if ((bool2) || (bool1)) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    if (!this.bActivityToFragment)
    {
      if (this.mw != null) {
        this.mw.pause();
      }
      if (this.mTaskHandler != null) {
        this.mTaskHandler.pause();
      }
      super.onPause();
    }
  }
  
  protected void onPostCreate(Bundle paramBundle)
  {
    if (!this.bActivityToFragment) {
      super.onPostCreate(paramBundle);
    }
  }
  
  protected void onRestart()
  {
    if (!this.bActivityToFragment) {
      super.onRestart();
    }
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    if (!this.bActivityToFragment) {
      super.onRestoreInstanceState(paramBundle);
    }
  }
  
  protected void onResume()
  {
    if (this.waitIntent != null)
    {
      doStartActivityForResult(this.waitIntent, this.waitRequestCode, this.waitBulde);
      this.waitIntent = null;
    }
    if (!this.bActivityToFragment)
    {
      if (this.mw != null) {
        this.mw.resume();
      }
      if (this.mTaskHandler != null) {
        this.mTaskHandler.resume();
      }
      super.onResume();
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {}
  
  protected void onStart()
  {
    if (!this.bActivityToFragment) {
      super.onStart();
    }
  }
  
  protected void onStop()
  {
    if (!this.bActivityToFragment)
    {
      if (this.mTaskHandler != null) {
        this.mTaskHandler.stop();
      }
      if (this.mw != null) {
        this.mw.stop();
      }
      super.onStop();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.mw != null) && (this.mw.doOnTouchEvent(paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (this.mTaskHandler != null) {
      this.mTaskHandler.onWindowFocusChanged(paramBoolean);
    }
    if (this.mw != null) {
      this.mw.onWindowFocusChanged(paramBoolean);
    }
    if (!this.bActivityToFragment) {
      super.onWindowFocusChanged(paramBoolean);
    }
  }
  
  public void overridePendingTransition(int paramInt1, int paramInt2)
  {
    if ((this.mw != null) && (this.mw.displayLikeDialog) && (!this.mw.baseWindow) && (!this.mw.noAnim)) {}
    while ((this.mTaskHandler != null) && (this.mTaskHandler.resizeWindow)) {
      return;
    }
    super.overridePendingTransition(paramInt1, paramInt2);
  }
  
  protected boolean popStack()
  {
    return true;
  }
  
  protected void redirectNewTaskActivity(Intent paramIntent) {}
  
  public void rightPanelEmpty() {}
  
  public void setActivityToFragment(boolean paramBoolean)
  {
    this.bActivityToFragment = paramBoolean;
  }
  
  public void setContentView(int paramInt)
  {
    getWindow().setBackgroundDrawableResource(17170445);
    super.setContentView(paramInt);
  }
  
  public void setNewTaskFullScreen(boolean paramBoolean)
  {
    if (this.mTaskHandler != null) {
      this.mTaskHandler.setFullScreen(paramBoolean);
    }
  }
  
  public void setTheme(int paramInt)
  {
    if (!this.bActivityToFragment) {
      super.setTheme(paramInt);
    }
  }
  
  public void startActivityForResult(final Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    boolean bool1 = getDisplayLikeDialogParam(paramIntent);
    if (!bool1) {
      redirectNewTaskActivity(paramIntent);
    }
    if (this.mw != null) {
      this.mw.addParamDisplayLikeDialog(paramIntent);
    }
    if (this.mTaskHandler != null) {
      this.mTaskHandler.addParam(paramIntent);
    }
    boolean bool3 = paramIntent.getBooleanExtra("is_activity_to_fragment", false);
    final boolean bool2 = paramIntent.getBooleanExtra("clear_fragment_stack", false);
    boolean bool4 = paramIntent.getBooleanExtra("is_base_fragment", false);
    paramIntent.removeExtra("is_activity_to_fragment");
    paramIntent.removeExtra("clear_fragment_stack");
    paramIntent.removeExtra("has_base_fragment");
    paramIntent.removeExtra("is_base_fragment");
    if (paramInt > 0) {
      paramIntent.putExtra("pad_request_code", paramInt);
    }
    if (interceptClearTopFlag(paramIntent)) {}
    do
    {
      return;
      if ((this.bActivityToFragment) && (this.myFragment != null)) {
        setIntentAnimState(paramIntent, true, this.myFragment);
      }
      if ((!bool3) || (bool1)) {
        break;
      }
    } while (isCurActOpendInRight(paramIntent));
    Object localObject1 = paramIntent.getComponent();
    Object localObject2;
    for (;;)
    {
      try
      {
        localObject2 = Class.forName(((ComponentName)localObject1).getClassName());
        LOG("activityClazz: " + localObject2 + " clearStatck=" + bool2 + " requestCode=" + paramInt);
        QLog.d("ArchitectureDebug", 1, "BasePadActivity startActivityForResult ," + getClass().getSimpleName() + ",activityClazz: " + localObject2 + " clearStatck=" + bool2 + " requestCode=" + paramInt);
        if (!BasePadActivity.class.isAssignableFrom((Class)localObject2)) {
          break label600;
        }
        localObject2 = (BasePadActivity)((Class)localObject2).newInstance();
        ((BasePadActivity)localObject2).onInit(this, paramIntent);
        LOG("activity.bActivityToFragment: " + ((BasePadActivity)localObject2).bActivityToFragment);
        QLog.d("ArchitectureDebug", 1, "BasePadActivity startActivityForResult ," + getClass().getSimpleName() + ",activity.bActivityToFragment: " + ((BasePadActivity)localObject2).bActivityToFragment);
        if (!((BasePadActivity)localObject2).parse()) {
          break;
        }
        hideSoftPanel();
        ((BasePadActivity)localObject2).onCreate(paramIntent.getExtras());
        if (bool4)
        {
          ((BasePadActivity)localObject2).addBaseFragment(bool4);
          ((BasePadActivity)localObject2).requestCode = paramInt;
          return;
        }
      }
      catch (Exception paramIntent)
      {
        Log.e("ArchitectureDebug", "open " + localObject1 + "error", paramIntent);
        QLog.d("ArchitectureDebug", 1, "BasePadActivity startActivityForResult error," + getClass().getSimpleName(), paramIntent);
        return;
      }
      getWindow().getDecorView().post(new Runnable()
      {
        public void run()
        {
          if (!BasePadActivity.this.interceptClearTopFlag(paramIntent)) {
            this.val$activity.addMyFragment(bool2);
          }
        }
      });
    }
    addNotifyFinishParam(paramIntent);
    if (isLansacpe())
    {
      if (!hasFragment())
      {
        if (isActivityResumed()) {
          break label746;
        }
        break label735;
        paramIntent.putExtra("replace_stack", bool1);
      }
    }
    else
    {
      localObject2 = getActivity();
      if ((!bool2) || (!popStack())) {
        break label752;
      }
    }
    label600:
    label735:
    label746:
    label752:
    for (bool1 = true;; bool1 = false)
    {
      clearTabTask((Activity)localObject2, bool1);
      startActivityImmediateOrDelay(paramIntent, paramInt, paramBundle);
      return;
      doStartActivityForResult(paramIntent, paramInt, paramBundle);
      return;
      if (!bool1)
      {
        addNotifyFinishParam(paramIntent);
        if (isLansacpe())
        {
          if (((hasFragment()) || (!isActivityResumed())) && (bool2))
          {
            bool1 = true;
            paramIntent.putExtra("replace_stack", bool1);
          }
        }
        else
        {
          localObject1 = getActivity();
          if ((!bool2) || (!popStack())) {
            break label699;
          }
        }
        for (bool1 = true;; bool1 = false)
        {
          clearTabTask((Activity)localObject1, bool1);
          startActivityImmediateOrDelay(paramIntent, paramInt, paramBundle);
          return;
          bool1 = false;
          break;
        }
      }
      if ((getParent() != null) && (!isActivityResumed())) {
        paramIntent.addFlags(268435456);
      }
      doStartActivityForResult(paramIntent, paramInt, paramBundle);
      return;
      if (bool2)
      {
        bool1 = true;
        break;
      }
      bool1 = false;
      break;
    }
  }
  
  public void startTopFragmentEnterAnim(boolean paramBoolean)
  {
    Fragment localFragment = getFragmentManager().findFragmentById(mContainerViewId);
    if ((localFragment instanceof MyFragment))
    {
      if (paramBoolean) {
        ((MyFragment)localFragment).startLeftEnterAnim();
      }
    }
    else {
      return;
    }
    ((MyFragment)localFragment).startLeftExistAnim();
  }
  
  protected boolean willRemoveLastFragment()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     mqq.app.BasePadActivity
 * JD-Core Version:    0.7.0.1
 */