package mqq.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import com.tencent.qphone.base.util.QLog;

public class ModalWindow
{
  public static final String BROADCAST_ACTIVITY_FINISH = "com.tencent.qq.activity.finish";
  public static final String BROADCAST_ACTIVITY_FINISH_ALL = "com.tencent.qq.activity.finish.all";
  public static final String BROADCAST_ACTIVITY_PAUSE_ANIM = "broadcast_pre_activity_pause_anim";
  public static final String BROADCAST_BRING_TO_FRONT = "broadcast_bring_to_front";
  public static final String PREVIOUS_ACT_STR = "previous_act_str";
  private BroadcastReceiver activityFinishReceiver;
  boolean baseWindow;
  DecelerateInterpolator di = new DecelerateInterpolator(1.5F);
  boolean displayLikeDialog;
  private int duration = 300;
  boolean finished;
  private boolean firstHasFocus = true;
  private boolean firstResume = true;
  boolean fullScreenWindow;
  private BasePadActivity mActivity;
  private float mDensity;
  boolean noAnim;
  boolean noAnimForOnce;
  private String previousActStr;
  boolean sendFinish;
  boolean startNewActivity = false;
  boolean startWindowAnim;
  boolean windowAnim;
  int windowWidth = -1;
  
  public ModalWindow(BasePadActivity paramBasePadActivity)
  {
    this.mActivity = paramBasePadActivity;
    this.mDensity = paramBasePadActivity.getResources().getDisplayMetrics().density;
  }
  
  private void doSuperFinish()
  {
    this.mActivity.doSuperFinish();
  }
  
  private void initActivityFinishReceiver()
  {
    if (this.activityFinishReceiver == null)
    {
      this.activityFinishReceiver = new BroadcastReceiver()
      {
        public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          paramAnonymousContext = paramAnonymousIntent.getAction();
          Log.i("app2", "ModelWindow onReceive action=" + paramAnonymousContext + " act=" + ModalWindow.this.mActivity);
          if (paramAnonymousContext.equals("com.tencent.qq.activity.finish"))
          {
            paramAnonymousContext = paramAnonymousIntent.getStringExtra("previous_act_str");
            if (ModalWindow.this.mActivity.toString().equals(paramAnonymousContext)) {
              ModalWindow.this.doCloseEnterAnim();
            }
          }
          do
          {
            do
            {
              do
              {
                return;
                if (!paramAnonymousContext.equals("com.tencent.qq.activity.finish.all")) {
                  break;
                }
              } while (ModalWindow.this.sendFinish);
              if ((ModalWindow.this.baseWindow) && (!ModalWindow.this.windowAnim)) {
                ModalWindow.this.setDimAmount(0.0F);
              }
              ModalWindow.this.doSuperFinish();
              return;
              if (!"broadcast_pre_activity_pause_anim".equals(paramAnonymousContext)) {
                break;
              }
              paramAnonymousContext = paramAnonymousIntent.getStringExtra("previous_act_str");
            } while (!ModalWindow.this.mActivity.toString().equals(paramAnonymousContext));
            ModalWindow.this.doOpenExitAnim();
            return;
          } while (!"broadcast_bring_to_front".equals(paramAnonymousContext));
          ((ActivityManager)ModalWindow.this.mActivity.getSystemService("activity")).moveTaskToFront(ModalWindow.this.mActivity.getTaskId(), 0);
        }
      };
      IntentFilter localIntentFilter = new IntentFilter("com.tencent.qq.activity.finish");
      localIntentFilter.addAction("com.tencent.qq.activity.finish.all");
      localIntentFilter.addAction("broadcast_pre_activity_pause_anim");
      if (this.baseWindow) {
        localIntentFilter.addAction("broadcast_bring_to_front");
      }
      this.mActivity.registerReceiver(this.activityFinishReceiver, localIntentFilter);
    }
  }
  
  private boolean isOutOfBounds(Activity paramActivity, MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    int k = ViewConfiguration.get(paramActivity).getScaledWindowTouchSlop();
    paramActivity = paramActivity.getWindow().getDecorView();
    return (i < -k) || (j < -k) || (i > paramActivity.getWidth() + k) || (j > paramActivity.getHeight() + k);
  }
  
  private boolean noResizeWindow(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getComponent() != null))
    {
      paramIntent = paramIntent.getComponent().getClassName();
      if ((paramIntent != null) && (paramIntent.endsWith("AVActivity"))) {
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
  
  private void resizeWindow()
  {
    BasePadActivity localBasePadActivity = this.mActivity;
    Object localObject = (WindowManager)this.mActivity.getSystemService("window");
    int i = ((WindowManager)localObject).getDefaultDisplay().getWidth();
    int j = ((WindowManager)localObject).getDefaultDisplay().getHeight();
    localObject = localBasePadActivity.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject).gravity = 17;
    if (this.baseWindow) {
      ((WindowManager.LayoutParams)localObject).dimAmount = 0.4F;
    }
    for (((WindowManager.LayoutParams)localObject).windowAnimations = this.mActivity.getModalWindowOpenAnim(); (i > j) && (!this.fullScreenWindow); ((WindowManager.LayoutParams)localObject).windowAnimations = 0)
    {
      ((WindowManager.LayoutParams)localObject).width = ((int)(0.585938F * i));
      ((WindowManager.LayoutParams)localObject).height = j;
      this.windowWidth = ((WindowManager.LayoutParams)localObject).width;
      localBasePadActivity.getWindow().setAttributes((WindowManager.LayoutParams)localObject);
      if (this.baseWindow) {
        localBasePadActivity.getWindow().addFlags(2);
      }
      return;
    }
    if (this.mActivity.matchModalWhenPortrait()) {}
    for (((WindowManager.LayoutParams)localObject).width = -1;; ((WindowManager.LayoutParams)localObject).width = (i - 1))
    {
      ((WindowManager.LayoutParams)localObject).height = -1;
      break;
    }
  }
  
  private void setDimAmount(float paramFloat)
  {
    WindowManager.LayoutParams localLayoutParams = this.mActivity.getWindow().getAttributes();
    localLayoutParams.dimAmount = paramFloat;
    this.mActivity.getWindow().setAttributes(localLayoutParams);
    this.mActivity.getWindow().addFlags(2);
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
  
  public void addParamDisplayLikeDialog(Intent paramIntent)
  {
    if ((this.displayLikeDialog) && (!paramIntent.getBooleanExtra("force_not_modal", false)))
    {
      paramIntent.putExtra("display_like_dialog", true);
      paramIntent.putExtra("previous_act_str", this.mActivity.toString());
      if ((!paramIntent.hasExtra("full_screen_window")) && (this.fullScreenWindow)) {
        paramIntent.putExtra("full_screen_window", this.fullScreenWindow);
      }
      this.startNewActivity = true;
      setIntentAnimState(true, paramIntent);
    }
  }
  
  public void closeModelWindow(boolean paramBoolean)
  {
    Intent localIntent = new Intent("com.tencent.qq.activity.finish.all");
    this.sendFinish = true;
    this.mActivity.sendBroadcast(localIntent);
    this.displayLikeDialog = false;
    if (paramBoolean)
    {
      if (this.windowAnim)
      {
        doSuperFinish();
        this.mActivity.doSuperOverridePendingTransition(0, this.mActivity.getModalWindowFinishAnim());
        return;
      }
      doWindowFinishAnim();
      return;
    }
    doSuperFinish();
  }
  
  public void destory()
  {
    if (this.activityFinishReceiver != null)
    {
      this.mActivity.unregisterReceiver(this.activityFinishReceiver);
      this.activityFinishReceiver = null;
    }
  }
  
  public void doCloseEnterAnim()
  {
    final int i = (int)(this.windowWidth / 6.0F);
    final View localView = this.mActivity.getWindow().getDecorView();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, i });
    int j = this.duration;
    localValueAnimator.setInterpolator(this.di);
    localValueAnimator.setDuration(j - 40);
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        localView.setTranslationX(i - i);
      }
    });
    localValueAnimator.start();
  }
  
  public void doCloseExitAnim()
  {
    final View localView = this.mActivity.getWindow().getDecorView();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, this.windowWidth });
    localValueAnimator.setDuration(this.duration);
    localValueAnimator.setInterpolator(this.di);
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
        ModalWindow.this.doSuperFinish();
      }
    });
    localValueAnimator.start();
  }
  
  public void doConfigChange(Configuration paramConfiguration)
  {
    if (!this.displayLikeDialog) {
      return;
    }
    resizeWindow();
  }
  
  public void doFinish()
  {
    if (this.displayLikeDialog)
    {
      if (this.finished) {
        return;
      }
      this.finished = true;
      if (this.baseWindow)
      {
        if (this.windowAnim)
        {
          doSuperFinish();
          this.mActivity.doSuperOverridePendingTransition(0, this.mActivity.getModalWindowFinishAnim());
          return;
        }
        doWindowFinishAnim();
        return;
      }
      if ((!this.noAnimForOnce) && (!this.noAnim) && (this.mActivity.hasContentView()))
      {
        Intent localIntent = new Intent("com.tencent.qq.activity.finish");
        localIntent.putExtra("previous_act_str", this.previousActStr);
        this.mActivity.sendBroadcast(localIntent);
        doCloseExitAnim();
      }
      for (;;)
      {
        this.noAnimForOnce = false;
        return;
        doSuperFinish();
      }
    }
    doSuperFinish();
  }
  
  public boolean doOnTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.displayLikeDialog) && (paramMotionEvent.getAction() == 0) && (isOutOfBounds(this.mActivity, paramMotionEvent)))
    {
      closeModelWindow(true);
      return true;
    }
    return false;
  }
  
  public void doOpenEnterAnim()
  {
    final View localView = this.mActivity.getWindow().getDecorView();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, this.windowWidth });
    localValueAnimator.setDuration(this.duration);
    localValueAnimator.setInterpolator(this.di);
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        localView.setTranslationX(ModalWindow.this.windowWidth - i);
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
            ModalWindow.7.this.val$v.setTranslationX(0.0F);
          }
        });
      }
    });
    localValueAnimator.start();
  }
  
  public void doWindowFinishAnim()
  {
    final View localView = this.mActivity.getWindow().getDecorView();
    if (this.startWindowAnim) {
      return;
    }
    this.startWindowAnim = true;
    localView.postDelayed(new Runnable()
    {
      public void run()
      {
        if (ModalWindow.this.baseWindow) {
          ModalWindow.this.setDimAmount(0.0F);
        }
        ModalWindow.this.startWindowAnim = false;
        ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, localView.getHeight() });
        localValueAnimator.setDuration(ModalWindow.this.duration);
        localValueAnimator.setInterpolator(ModalWindow.this.di);
        localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
          {
            int i = ((Integer)paramAnonymous2ValueAnimator.getAnimatedValue()).intValue();
            ModalWindow.2.this.val$v.setTranslationY(i);
          }
        });
        BasePadActivity.sFragmentAnimating = true;
        localValueAnimator.addListener(new AnimatorListenerAdapter()
        {
          public void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            BasePadActivity.sFragmentAnimating = false;
            ModalWindow.this.doSuperFinish();
          }
        });
        localValueAnimator.start();
      }
    }, 250L);
  }
  
  public void hanldeIntent(Intent paramIntent)
  {
    boolean bool2 = true;
    if (noResizeWindow(paramIntent)) {
      return;
    }
    for (;;)
    {
      try
      {
        this.baseWindow = paramIntent.getBooleanExtra("is_first_window", false);
        if ((!paramIntent.getBooleanExtra("display_like_dialog", false)) || (paramIntent.getBooleanExtra("force_not_modal", false))) {
          continue;
        }
        bool1 = true;
        this.displayLikeDialog = bool1;
        this.previousActStr = paramIntent.getStringExtra("previous_act_str");
        this.fullScreenWindow = paramIntent.getBooleanExtra("full_screen_window", false);
        Bundle localBundle = paramIntent.getBundleExtra("pluginsdk_inner_intent_extras");
        if ((localBundle != null) && (!this.displayLikeDialog))
        {
          this.baseWindow = localBundle.getBoolean("is_first_window", false);
          if ((!localBundle.getBoolean("display_like_dialog", false)) || (paramIntent.getBooleanExtra("force_not_modal", false))) {
            continue;
          }
          bool1 = bool2;
          this.displayLikeDialog = bool1;
          this.previousActStr = localBundle.getString("previous_act_str");
        }
        if (localBundle != null)
        {
          this.fullScreenWindow = localBundle.getBoolean("full_screen_window", false);
          localBundle.remove("full_screen_window");
        }
        if (this.previousActStr == null) {
          this.baseWindow = true;
        }
      }
      catch (Exception localException)
      {
        boolean bool1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ModalWindow", 2, "handleIntent exception!");
        continue;
      }
      paramIntent.removeExtra("is_first_window");
      paramIntent.removeExtra("display_like_dialog");
      paramIntent.removeExtra("full_screen_window");
      if (!this.displayLikeDialog) {
        break;
      }
      setIntentAnimState(false, paramIntent);
      return;
      bool1 = false;
      continue;
      bool1 = false;
    }
  }
  
  public boolean isBaseWindow()
  {
    return this.baseWindow;
  }
  
  public void onAttachedToWindow()
  {
    if (!this.displayLikeDialog) {
      return;
    }
    if ((this.firstResume) && (!this.baseWindow) && (!this.noAnimForOnce) && (!this.noAnim) && (this.mActivity.hasContentView())) {
      doOpenEnterAnim();
    }
    this.noAnimForOnce = false;
    this.firstResume = false;
  }
  
  public void onCreate(Intent paramIntent)
  {
    hanldeIntent(paramIntent);
    if (this.displayLikeDialog)
    {
      resizeWindow();
      initActivityFinishReceiver();
    }
    if ("SM-T705C".equalsIgnoreCase(Build.MODEL)) {}
    for (boolean bool = false;; bool = true)
    {
      this.windowAnim = bool;
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (!this.displayLikeDialog) {
      return;
    }
    if ((this.firstHasFocus) && (!this.noAnimForOnce) && (!this.noAnim) && (this.mActivity.hasContentView()))
    {
      Intent localIntent = new Intent("broadcast_pre_activity_pause_anim");
      localIntent.putExtra("previous_act_str", this.previousActStr);
      this.mActivity.sendBroadcast(localIntent);
    }
    this.noAnimForOnce = false;
    this.firstHasFocus = false;
  }
  
  public void pause() {}
  
  public void resume()
  {
    this.startNewActivity = false;
  }
  
  public void stop()
  {
    if (!this.startNewActivity) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     mqq.app.ModalWindow
 * JD-Core Version:    0.7.0.1
 */