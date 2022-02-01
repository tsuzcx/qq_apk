package mqq.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import java.util.Iterator;
import java.util.List;

public class NewTaskHandler
{
  public static final String BROADCAST_ACTIVITY_FINISH = "com.tencent.qq.new.task.activity.finish";
  public static final String BROADCAST_ACTIVITY_PAUSE_ANIM = "broadcast_activity_pause_anim";
  public static final String BROADCAST_FOLD_FULLSCREEN = "broadcast_fold_fullscreen";
  public static final String BROADCAST_SHOW_OR_HIDE_TASK = "broadcast_show_or_hide_task";
  public static final String CUR_TAB_ID = "cur_Tab_Id";
  public static final String FINISH_ALL_ACTIVITY_IN_TASK = "finish_all_activity_in_task";
  private static final String KEY_RESIZE_WINDOW_ONLY = "key_resize_window_only";
  public static final String PREVIOUS_ACT_STR = "previous_new_task_act_str";
  public static final String PREVIOUS_CLOSE_BY_DRAG = "previous_close_by_drag";
  public static final String REMOVE_TASK = "remove_owner_task";
  public static final String TASK_BELONG_TAB_ID = "task_belong_tab_id";
  boolean autoOpenHb;
  DecelerateInterpolator di = new DecelerateInterpolator(1.5F);
  private boolean displayLikeDialog;
  private int duration = 300;
  boolean fileFullScreen;
  boolean finished;
  boolean first = true;
  private boolean firstHasFocus = true;
  private boolean firstPause = false;
  private boolean firstResume = true;
  boolean fromFloatAio;
  boolean isFullScreen;
  BasePadActivity mActivity;
  private Handler mHandler = new Handler();
  boolean newTaskInRight;
  boolean noAnim;
  boolean noAnimForOnce;
  private String previousActStr;
  boolean replaceStack;
  boolean resizeWindow;
  boolean startFromSplash;
  private boolean stop;
  int tabIndex;
  private BroadcastReceiver taskVisibleBroadcastReceiver;
  int windowWidth = -1;
  
  public NewTaskHandler(BasePadActivity paramBasePadActivity)
  {
    this.mActivity = paramBasePadActivity;
  }
  
  private void bringModelWindowToFrontIfNecessary()
  {
    Intent localIntent = new Intent("broadcast_bring_to_front");
    this.mActivity.sendBroadcast(localIntent);
  }
  
  private void clearIntentAnimState(Intent paramIntent)
  {
    paramIntent.removeExtra("open_fragment_no_anim_once");
    paramIntent.removeExtra("fragment_no_anim");
    paramIntent.removeExtra("replace_stack");
  }
  
  private void doSuperFinish()
  {
    this.mActivity.doSuperFinish();
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    return ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
  }
  
  private void hideWindow()
  {
    Window localWindow = this.mActivity.getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = 10;
    localLayoutParams.height = 10;
    localLayoutParams.gravity = 83;
    localLayoutParams.alpha = 0.02F;
    localLayoutParams.flags = 32;
    localLayoutParams.windowAnimations = 0;
    localWindow.setAttributes(localLayoutParams);
  }
  
  private void initTaskVisibleBroadcastReceiver()
  {
    IntentFilter localIntentFilter;
    if (this.taskVisibleBroadcastReceiver == null)
    {
      this.taskVisibleBroadcastReceiver = new BroadcastReceiver()
      {
        public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          paramAnonymousContext = paramAnonymousIntent.getAction();
          int i;
          if (paramAnonymousContext.equals("broadcast_show_or_hide_task"))
          {
            i = paramAnonymousIntent.getIntExtra("cur_Tab_Id", -1);
            if ((NewTaskHandler.this.tabIndex >= 0) && (NewTaskHandler.this.tabIndex == i))
            {
              NewTaskHandler.this.startFromSplash = paramAnonymousIntent.getBooleanExtra("start_from_splash", false);
              Log.i("app2", "newTaskHandler onReceive BROADCAST_SHOW_OR_HIDE_TASK and act=" + NewTaskHandler.this.mActivity);
              paramAnonymousContext = (ActivityManager)NewTaskHandler.this.mActivity.getSystemService("activity");
            }
          }
          do
          {
            do
            {
              boolean bool1;
              boolean bool2;
              do
              {
                do
                {
                  do
                  {
                    try
                    {
                      paramAnonymousContext.moveTaskToFront(NewTaskHandler.this.mActivity.getTaskId(), 0);
                      NewTaskHandler.this.bringModelWindowToFrontIfNecessary();
                      return;
                    }
                    catch (Exception paramAnonymousContext)
                    {
                      Log.i("app2", "moveTaskToFront error ", paramAnonymousContext);
                      return;
                    }
                    paramAnonymousContext = NewTaskHandler.this.mHandler;
                    paramAnonymousIntent = new Runnable()
                    {
                      public void run()
                      {
                        NewTaskHandler.this.first = false;
                        NewTaskHandler.this.mActivity.moveTaskToBack(true);
                      }
                    };
                    if (NewTaskHandler.this.first) {}
                    for (long l = 100L;; l = 50L)
                    {
                      paramAnonymousContext.postDelayed(paramAnonymousIntent, l);
                      return;
                    }
                    if (!paramAnonymousContext.equals("finish_all_activity_in_task")) {
                      break;
                    }
                    i = paramAnonymousIntent.getIntExtra("cur_Tab_Id", -1);
                  } while ((NewTaskHandler.this.tabIndex < 0) || (i != NewTaskHandler.this.tabIndex));
                  if (!paramAnonymousIntent.getBooleanExtra("notify_activity_finish", true)) {
                    NewTaskHandler.this.mActivity.notifyWhenDestory = false;
                  }
                  NewTaskHandler.this.mActivity.doSuperFinish();
                  return;
                  if (paramAnonymousContext.equals("remove_owner_task"))
                  {
                    Log.i("app2", "newTaskHandler onReceive REMOVE_TASK act=" + NewTaskHandler.this.mActivity);
                    NewTaskHandler.this.removeTask();
                    return;
                  }
                  if (!paramAnonymousContext.equals("com.tencent.qq.new.task.activity.finish")) {
                    break;
                  }
                  paramAnonymousContext = paramAnonymousIntent.getStringExtra("previous_new_task_act_str");
                } while (!NewTaskHandler.this.mActivity.toString().equals(paramAnonymousContext));
                bool1 = paramAnonymousIntent.getBooleanExtra("open_fragment_no_anim_once", false);
                bool2 = paramAnonymousIntent.getBooleanExtra("previous_close_by_drag", false);
              } while ((bool1) || (bool2));
              NewTaskHandler.this.doCloseEnterAnim();
              return;
              if (!"broadcast_activity_pause_anim".equals(paramAnonymousContext)) {
                break;
              }
              paramAnonymousContext = paramAnonymousIntent.getStringExtra("previous_new_task_act_str");
            } while ((!NewTaskHandler.this.mActivity.toString().equals(paramAnonymousContext)) || (NewTaskHandler.this.noAnim) || (NewTaskHandler.this.noAnimForOnce) || (paramAnonymousIntent.getBooleanExtra("open_fragment_no_anim_once", false)));
            NewTaskHandler.this.doOpenExitAnim();
            return;
          } while ((!"broadcast_fold_fullscreen".equals(paramAnonymousContext)) || (!NewTaskHandler.this.isFullScreen));
          NewTaskHandler.this.setFullScreen(false);
        }
      };
      if (!this.newTaskInRight) {
        break label80;
      }
      localIntentFilter = new IntentFilter("broadcast_show_or_hide_task");
      localIntentFilter.addAction("finish_all_activity_in_task");
      localIntentFilter.addAction("remove_owner_task");
    }
    for (;;)
    {
      localIntentFilter.addAction("com.tencent.qq.new.task.activity.finish");
      localIntentFilter.addAction("broadcast_activity_pause_anim");
      localIntentFilter.addAction("broadcast_fold_fullscreen");
      this.mActivity.registerReceiver(this.taskVisibleBroadcastReceiver, localIntentFilter);
      return;
      label80:
      localIntentFilter = new IntentFilter("finish_all_activity_in_task");
    }
  }
  
  private boolean isDisplayLikeDialog(Intent paramIntent)
  {
    boolean bool2 = paramIntent.getBooleanExtra("display_like_dialog", false);
    paramIntent = paramIntent.getBundleExtra("pluginsdk_inner_intent_extras");
    boolean bool1 = bool2;
    if (paramIntent != null)
    {
      bool1 = bool2;
      if (!bool2) {
        bool1 = paramIntent.getBoolean("display_like_dialog", false);
      }
    }
    return bool1;
  }
  
  private boolean isFileFullscreen(Intent paramIntent)
  {
    boolean bool2 = paramIntent.getBooleanExtra("my_file_fullscreen", false);
    paramIntent = paramIntent.getBundleExtra("pluginsdk_inner_intent_extras");
    boolean bool1 = bool2;
    if (paramIntent != null)
    {
      bool1 = bool2;
      if (!bool2) {
        bool1 = paramIntent.getBoolean("my_file_fullscreen", false);
      }
    }
    return bool1;
  }
  
  private boolean isQQProcessExist()
  {
    Log.i("app2", "isQQProcessExist packageName = " + this.mActivity.getPackageName());
    Iterator localIterator = ((ActivityManager)this.mActivity.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (localIterator.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
      if (localRunningAppProcessInfo.processName.equals(this.mActivity.getPackageName()))
      {
        Log.i("app2", "process = " + localRunningAppProcessInfo.processName);
        return true;
      }
    }
    return false;
  }
  
  private boolean noResizeWindow(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getComponent() != null))
    {
      paramIntent = paramIntent.getComponent().getClassName();
      if (((paramIntent != null) && (paramIntent.endsWith("GesturePWDUnlockActivity"))) || (paramIntent.endsWith("VideoRecordActivity")) || (paramIntent.endsWith("ShortVideoPreviewActivity")) || (paramIntent.endsWith("QzonePicturePluginProxyActivity")) || (paramIntent.endsWith("QzonePictureExtPluginProxyActivity")) || (paramIntent.endsWith("$ImageViewer")) || (paramIntent.endsWith("TroopAvatarWallPreviewActivity"))) {
        return true;
      }
    }
    return false;
  }
  
  private boolean openNewProcess(Intent paramIntent)
  {
    boolean bool2 = false;
    paramIntent = paramIntent.getComponent();
    boolean bool1 = bool2;
    if (paramIntent != null) {}
    try
    {
      boolean bool3 = this.mActivity.getPackageManager().getActivityInfo(paramIntent, 0).processName.contains(":");
      bool1 = bool2;
      if (bool3) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramIntent) {}
    return false;
  }
  
  private void removeTask() {}
  
  private void resizeWindow()
  {
    if (this.displayLikeDialog) {}
    while ((this.autoOpenHb) || (this.fromFloatAio)) {
      return;
    }
    Window localWindow = this.mActivity.getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.gravity = 53;
    if ((this.isFullScreen) || (this.fileFullScreen))
    {
      localLayoutParams.width = getScreenWidth(this.mActivity);
      localLayoutParams.height = -1;
      localLayoutParams.flags = 32;
      if (!this.fileFullScreen) {
        break label123;
      }
    }
    label123:
    for (localLayoutParams.windowAnimations = this.mActivity.getModalWindowOpenAnim();; localLayoutParams.windowAnimations = 0)
    {
      localWindow.setAttributes(localLayoutParams);
      this.windowWidth = localLayoutParams.width;
      return;
      localLayoutParams.width = this.mActivity.getRightPanelWidth();
      break;
    }
  }
  
  private void setIntentAnimState(boolean paramBoolean, Intent paramIntent)
  {
    boolean bool1 = paramIntent.getBooleanExtra("fragment_no_anim", false);
    boolean bool2 = paramIntent.getBooleanExtra("open_fragment_no_anim_once", false);
    if (paramBoolean)
    {
      this.noAnimForOnce = bool2;
      if (bool1) {
        this.noAnimForOnce = true;
      }
      return;
    }
    this.noAnimForOnce = bool2;
    this.noAnim = bool1;
  }
  
  private void startSplashActivity()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.MAIN");
    localIntent.addCategory("android.intent.category.LAUNCHER");
    localIntent.setPackage(this.mActivity.getPackageName());
    localIntent.setFlags(268435456);
    this.mActivity.startActivity(localIntent);
  }
  
  public void addParam(Intent paramIntent)
  {
    if (this.resizeWindow)
    {
      paramIntent.putExtra("key_resize_window_only", true);
      paramIntent.putExtra("new_task_fullscreen", this.isFullScreen);
      paramIntent.putExtra("task_belong_tab_id", this.tabIndex);
      paramIntent.putExtra("previous_new_task_act_str", this.mActivity.toString());
      this.firstPause = true;
      setIntentAnimState(true, paramIntent);
    }
  }
  
  public void destory()
  {
    if (this.taskVisibleBroadcastReceiver != null)
    {
      this.mActivity.unregisterReceiver(this.taskVisibleBroadcastReceiver);
      this.taskVisibleBroadcastReceiver = null;
    }
  }
  
  public void doCloseEnterAnim()
  {
    final int i = (int)(this.windowWidth / 6.0F);
    final View localView = this.mActivity.getWindow().getDecorView();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, i });
    int j = this.duration;
    localValueAnimator.setInterpolator(this.di);
    localValueAnimator.setDuration(j - 30);
    this.mActivity.onAnimStart(true);
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        localView.setTranslationX(i - i);
      }
    });
    localValueAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        localView.post(new Runnable()
        {
          public void run()
          {
            NewTaskHandler.13.this.val$v.setTranslationX(0.0F);
          }
        });
        NewTaskHandler.this.mActivity.onAnimEnd(true);
      }
    });
    localValueAnimator.start();
  }
  
  public void doCloseExitAnim()
  {
    final View localView = this.mActivity.getWindow().getDecorView();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { (int)localView.getTranslationX(), this.windowWidth });
    localValueAnimator.setDuration(this.duration);
    localValueAnimator.setInterpolator(this.di);
    localValueAnimator.setStartDelay(50L);
    this.mActivity.onAnimStart(false);
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        localView.setTranslationX(i);
      }
    });
    localValueAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        localView.setVisibility(8);
        NewTaskHandler.this.mActivity.onAnimEnd(false);
        NewTaskHandler.this.doSuperFinish();
      }
    });
    localValueAnimator.start();
  }
  
  public void doConfigChange(Configuration paramConfiguration)
  {
    if (this.resizeWindow) {
      resizeWindow();
    }
  }
  
  public void doFinish()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if ((this.resizeWindow) && (!this.displayLikeDialog))
    {
      if (this.finished) {
        return;
      }
      this.finished = true;
      boolean bool3 = hasContentView();
      Intent localIntent;
      if ((!this.noAnimForOnce) && (!this.noAnim)) {
        if (this.previousActStr == null)
        {
          localIntent = new Intent("top_fragment_anim");
          localIntent.putExtra("enter", true);
          if (!bool3)
          {
            localIntent.putExtra("open_fragment_no_anim_once", bool1);
            this.mActivity.sendBroadcast(localIntent);
            if (!bool3) {
              break label222;
            }
            this.mActivity.notifyFinish();
            doCloseExitAnim();
          }
        }
      }
      for (;;)
      {
        this.noAnimForOnce = false;
        return;
        bool1 = false;
        break;
        localIntent = new Intent("com.tencent.qq.new.task.activity.finish");
        if (this.mActivity.getWindow().getDecorView().getTranslationX() >= this.windowWidth / 5)
        {
          bool1 = true;
          label164:
          localIntent.putExtra("previous_close_by_drag", bool1);
          localIntent.putExtra("previous_new_task_act_str", this.previousActStr);
          if (bool3) {
            break label217;
          }
        }
        label217:
        for (bool1 = bool2;; bool1 = false)
        {
          localIntent.putExtra("open_fragment_no_anim_once", bool1);
          this.mActivity.sendBroadcast(localIntent);
          break;
          bool1 = false;
          break label164;
        }
        label222:
        doSuperFinish();
        continue;
        doSuperFinish();
        if (this.fileFullScreen) {
          this.mActivity.doSuperOverridePendingTransition(0, this.mActivity.getModalWindowFinishAnim());
        }
      }
    }
    doSuperFinish();
  }
  
  public void doOpenEnterAlphaAnim()
  {
    final View localView = this.mActivity.getWindow().getDecorView();
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(this.duration);
    localValueAnimator.setInterpolator(this.di);
    this.mActivity.onAnimStart(true);
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        localView.setAlpha(f);
      }
    });
    localValueAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        NewTaskHandler.this.mActivity.onAnimEnd(true);
      }
    });
    localValueAnimator.start();
  }
  
  public void doOpenEnterAnim()
  {
    final View localView = this.mActivity.getWindow().getDecorView();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, this.windowWidth });
    localValueAnimator.setDuration(this.duration);
    localValueAnimator.setInterpolator(this.di);
    this.mActivity.onAnimStart(true);
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        localView.setTranslationX(NewTaskHandler.this.windowWidth - i);
      }
    });
    localValueAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        localView.post(new Runnable()
        {
          public void run()
          {
            NewTaskHandler.7.this.val$v.setTranslationX(0.0F);
          }
        });
        NewTaskHandler.this.mActivity.onAnimEnd(true);
      }
    });
    localValueAnimator.start();
  }
  
  public void doOpenExitAnim()
  {
    final View localView = this.mActivity.getWindow().getDecorView();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, (int)(this.windowWidth / 6.0F) });
    int i = this.duration;
    localValueAnimator.setStartDelay(50L);
    localValueAnimator.setDuration(i);
    localValueAnimator.setInterpolator(this.di);
    this.mActivity.onAnimStart(false);
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        localView.setTranslationX(-i);
      }
    });
    localValueAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        localView.post(new Runnable()
        {
          public void run()
          {
            NewTaskHandler.11.this.val$v.setTranslationX(0.0F);
          }
        });
        NewTaskHandler.this.mActivity.onAnimEnd(false);
      }
    });
    localValueAnimator.start();
  }
  
  public void handleIntent(Intent paramIntent)
  {
    try
    {
      this.tabIndex = paramIntent.getIntExtra("new_task_show_right_belong_tab", -1);
      this.previousActStr = paramIntent.getStringExtra("previous_new_task_act_str");
      if (this.tabIndex >= 0) {
        if (1 != 0) {
          this.newTaskInRight = true;
        }
      }
      for (;;)
      {
        this.resizeWindow = paramIntent.getBooleanExtra("key_resize_window_only", false);
        if (this.newTaskInRight) {
          this.resizeWindow = true;
        }
        if (noResizeWindow(paramIntent)) {
          this.resizeWindow = false;
        }
        if (this.resizeWindow)
        {
          this.replaceStack = paramIntent.getBooleanExtra("replace_stack", false);
          this.displayLikeDialog = isDisplayLikeDialog(paramIntent);
          this.fileFullScreen = isFileFullscreen(paramIntent);
          setIntentAnimState(false, paramIntent);
          clearIntentAnimState(paramIntent);
          this.isFullScreen = paramIntent.getBooleanExtra("new_task_fullscreen", false);
        }
        this.fromFloatAio = paramIntent.getBooleanExtra("from_float_aio", false);
        this.autoOpenHb = paramIntent.getBooleanExtra("open_hb_detail", false);
        return;
        this.tabIndex = paramIntent.getIntExtra("task_belong_tab_id", -1);
      }
      return;
    }
    catch (Exception paramIntent) {}
  }
  
  public boolean hasContentView()
  {
    boolean bool2 = false;
    FrameLayout localFrameLayout = (FrameLayout)this.mActivity.findViewById(16908290);
    boolean bool1 = bool2;
    if (localFrameLayout != null)
    {
      bool1 = bool2;
      if (localFrameLayout.getChildCount() > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void onAttachedToWindow()
  {
    if ((!this.resizeWindow) || (this.displayLikeDialog)) {
      return;
    }
    if (this.firstResume)
    {
      if ((this.noAnimForOnce) || (this.noAnim)) {
        break label72;
      }
      if (hasContentView())
      {
        if (!this.replaceStack) {
          break label65;
        }
        doOpenEnterAlphaAnim();
      }
    }
    for (;;)
    {
      this.firstResume = false;
      this.replaceStack = false;
      return;
      label65:
      doOpenEnterAnim();
      continue;
      label72:
      this.mActivity.notAnim(true);
    }
  }
  
  public void onCreate(Intent paramIntent)
  {
    handleIntent(paramIntent);
    if (this.resizeWindow)
    {
      resizeWindow();
      initTaskVisibleBroadcastReceiver();
    }
    if ((this.autoOpenHb) || (this.fromFloatAio)) {
      hideWindow();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if ((!this.resizeWindow) || (this.displayLikeDialog)) {}
    while (!paramBoolean) {
      return;
    }
    if ((this.firstHasFocus) && (!this.noAnimForOnce) && (!this.noAnim))
    {
      if (this.previousActStr != null) {
        break label116;
      }
      localIntent = new Intent("top_fragment_anim");
      localIntent.putExtra("enter", false);
      if (hasContentView()) {
        break label111;
      }
    }
    label111:
    for (paramBoolean = bool1;; paramBoolean = false)
    {
      localIntent.putExtra("open_fragment_no_anim_once", paramBoolean);
      this.mActivity.sendBroadcast(localIntent);
      this.firstHasFocus = false;
      this.noAnimForOnce = false;
      return;
    }
    label116:
    Intent localIntent = new Intent("broadcast_activity_pause_anim");
    localIntent.putExtra("previous_new_task_act_str", this.previousActStr);
    if (!hasContentView()) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      localIntent.putExtra("open_fragment_no_anim_once", paramBoolean);
      this.mActivity.sendBroadcast(localIntent);
      break;
    }
  }
  
  public void pause() {}
  
  public void resume()
  {
    if (this.resizeWindow)
    {
      if ((Build.VERSION.SDK_INT > 20) && (this.stop) && (!this.startFromSplash)) {
        this.mActivity.runOnUiThread(new Runnable()
        {
          public void run()
          {
            Intent localIntent = new Intent("splash_task_show");
            NewTaskHandler.this.mActivity.sendBroadcast(localIntent);
          }
        });
      }
      this.stop = false;
      this.startFromSplash = false;
    }
  }
  
  public void setFullScreen(boolean paramBoolean)
  {
    if ((this.resizeWindow) && (!this.displayLikeDialog))
    {
      this.isFullScreen = paramBoolean;
      if (!this.isFullScreen)
      {
        Intent localIntent = new Intent("broadcast_fold_fullscreen");
        this.mActivity.sendBroadcast(localIntent);
      }
      this.mHandler.postDelayed(new Runnable()
      {
        public void run()
        {
          NewTaskHandler.this.resizeWindow();
        }
      }, 100L);
    }
  }
  
  public void stop()
  {
    if (this.resizeWindow) {
      this.stop = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     mqq.app.NewTaskHandler
 * JD-Core Version:    0.7.0.1
 */