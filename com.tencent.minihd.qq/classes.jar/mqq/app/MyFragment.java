package mqq.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;

public class MyFragment
  extends Fragment
{
  public static final int NO_REMOVE_VIEW = 1001;
  DecelerateInterpolator dInter = new DecelerateInterpolator(1.5F);
  boolean fromUser;
  boolean isBaseFragment;
  private BasePadActivity mactivity;
  boolean noAnim;
  boolean noAnimForOnce;
  boolean noCoverAnim;
  boolean replaceStack;
  boolean stop;
  boolean twice;
  
  public MyFragment(BasePadActivity paramBasePadActivity)
  {
    this.mactivity = paramBasePadActivity;
  }
  
  public BasePadActivity getBasePadAct()
  {
    return this.mactivity;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.mactivity.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.mactivity.onAttachedToWindow();
  }
  
  public boolean onBackEvent()
  {
    this.mactivity.beginCallBackEvent = true;
    boolean bool = this.mactivity.onBackEvent();
    this.mactivity.beginCallBackEvent = false;
    if (this.mactivity.calledFinish)
    {
      this.mactivity.calledFinish = false;
      bool = true;
    }
    return bool;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.mactivity.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public Animator onCreateAnimator(final int paramInt1, final boolean paramBoolean, final int paramInt2)
  {
    if ((this.noAnim) || (this.noAnimForOnce) || (this.noCoverAnim)) {
      this.mactivity.notAnim(paramBoolean);
    }
    Object localObject4;
    if (this.noAnim)
    {
      localObject4 = null;
      return localObject4;
    }
    if (this.noAnimForOnce)
    {
      if (this.twice) {
        this.twice = false;
      }
      for (;;)
      {
        return null;
        this.noAnimForOnce = false;
      }
    }
    ObjectAnimator localObjectAnimator = null;
    Object localObject1;
    if (paramInt1 == 1001) {
      localObject1 = (ViewGroup)this.mactivity.getWindow().getDecorView();
    }
    for (Object localObject2 = localObject1; (localObject1 == null) || (localObject2 == null); localObject2 = getView())
    {
      return null;
      localObject1 = this.mactivity.getActivity();
      localObject2 = this.mactivity;
      localObject1 = (ViewGroup)((Activity)localObject1).findViewById(BasePadActivity.getContaierViewId());
    }
    int i = ((ViewGroup)localObject1).getMeasuredWidth();
    paramInt2 = i;
    if (i <= 0) {
      paramInt2 = this.mactivity.getRightPanelWidth();
    }
    if (this.replaceStack) {
      if (paramBoolean)
      {
        localObjectAnimator = ObjectAnimator.ofFloat(null, "alpha", new float[] { 0.0F, 1.0F });
        ((BasePadActivity)this.mactivity.getActivity()).onAlphaAnimStart();
      }
    }
    for (;;)
    {
      boolean bool2 = false;
      localObject4 = null;
      Object localObject3 = localObject4;
      final boolean bool1 = bool2;
      if (this.fromUser)
      {
        localObject3 = localObject4;
        bool1 = bool2;
        if (getResources().getConfiguration().orientation == 1) {
          if ((paramBoolean) || (this.mactivity.getRealFragmentCount() != 1))
          {
            localObject3 = localObject4;
            bool1 = bool2;
            if (paramBoolean)
            {
              localObject3 = localObject4;
              bool1 = bool2;
              if (this.mactivity.getRealFragmentCount() != 1) {}
            }
          }
          else
          {
            localObject3 = ((ViewGroup)localObject1).getBackground();
            if (localObject3 != null) {
              ((ViewGroup)localObject1).setBackgroundDrawable(null);
            }
            ((BasePadActivity)this.mactivity.getActivity()).onAlphaAnimStart();
            bool1 = true;
          }
        }
      }
      this.fromUser = false;
      this.replaceStack = false;
      localObject4 = localObjectAnimator;
      if (localObjectAnimator == null) {
        break;
      }
      localObjectAnimator.setDuration(300L);
      localObjectAnimator.setInterpolator(this.dInter);
      this.mactivity.onAnimStart(paramBoolean);
      localObjectAnimator.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          MyFragment.this.mactivity.onAnimEnd(paramBoolean);
          ((BasePadActivity)MyFragment.this.mactivity.getActivity()).onAlphaAnimEnd();
          this.val$view.post(new Runnable()
          {
            public void run()
            {
              MyFragment.2.this.val$view.setTranslationX(0.0F);
              MyFragment.2.this.val$view.setAlpha(1.0F);
            }
          });
          if (bool1)
          {
            if (this.val$containerBg != null) {
              this.val$fragmentContainer.setBackgroundDrawable(this.val$containerBg);
            }
            ((BasePadActivity)MyFragment.this.mactivity.getActivity()).onAlphaAnimEnd();
            if ((!paramBoolean) && (!((BasePadActivity)MyFragment.this.getActivity()).alwaysShowRightView())) {
              this.val$fragmentContainer.setVisibility(8);
            }
          }
        }
      });
      return localObjectAnimator;
      localObjectAnimator = ObjectAnimator.ofFloat(null, "alpha", new float[] { 1.0F, 0.0F });
      continue;
      if (this.fromUser)
      {
        if (!this.noCoverAnim) {
          if (paramBoolean) {
            localObjectAnimator = ObjectAnimator.ofFloat(null, "translationX", new float[] { paramInt2, 0.0F });
          } else {
            localObjectAnimator = ObjectAnimator.ofFloat(null, "translationX", new float[] { 0.0F, paramInt2 });
          }
        }
      }
      else if (paramBoolean)
      {
        localObjectAnimator = ObjectAnimator.ofFloat(null, "translationX", new float[] { -paramInt2 / 6.0F, 0.0F });
      }
      else
      {
        this.mactivity.allowContainerNotRemove((View)localObject1, true);
        ((ViewGroup)localObject1).post(new Runnable()
        {
          public void run()
          {
            MyFragment.this.mactivity.allowContainerNotRemove(this.val$fragmentContainer, false);
            if (this.val$view.getParent() == null) {
              return;
            }
            MyFragment.this.mactivity.onAnimStart(paramBoolean);
            ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.val$view, "translationX", new float[] { 0.0F, -paramInt2 / 6.0F });
            localObjectAnimator.setDuration(300L);
            localObjectAnimator.setInterpolator(MyFragment.this.dInter);
            localObjectAnimator.addListener(new AnimatorListenerAdapter()
            {
              public void onAnimationEnd(Animator paramAnonymous2Animator)
              {
                if (MyFragment.1.this.val$transit != 1001) {
                  MyFragment.1.this.val$fragmentContainer.removeView(MyFragment.1.this.val$view);
                }
                MyFragment.1.this.val$view.post(new Runnable()
                {
                  public void run()
                  {
                    MyFragment.1.this.val$view.setTranslationX(0.0F);
                  }
                });
                MyFragment.this.mactivity.onAnimEnd(MyFragment.1.this.val$enter);
              }
            });
            localObjectAnimator.start();
          }
        });
      }
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    this.mactivity.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = this.mactivity.getWindow().getDecorView();
    if (paramLayoutInflater.getParent() != null)
    {
      this.noAnimForOnce = true;
      paramViewGroup = (ViewGroup)paramLayoutInflater.getParent();
      this.mactivity.allowContainerNotRemove(paramViewGroup, false);
      paramViewGroup.removeView(paramLayoutInflater);
    }
    paramLayoutInflater.setTag(Fragment.class.getName());
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    try
    {
      super.onDestroy();
      this.mactivity.onDestroy();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.mactivity.onDetachedFromWindow();
  }
  
  public void onPause()
  {
    super.onPause();
    this.mactivity.onPause();
    this.mactivity.onWindowFocusChanged(false);
  }
  
  public void onResume()
  {
    super.onResume();
    this.stop = false;
    this.mactivity.onResume();
    this.mactivity.onWindowFocusChanged(true);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.mactivity.onSaveInstanceState(paramBundle);
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.stop) {
      this.mactivity.onRestart();
    }
    this.mactivity.onStart();
    this.stop = false;
  }
  
  public void onStop()
  {
    super.onStop();
    this.stop = true;
    this.mactivity.onStop();
  }
  
  public void setNoAnimOnce(boolean paramBoolean)
  {
    this.noAnimForOnce = paramBoolean;
  }
  
  public void startLeftEnterAnim()
  {
    if ((!this.noAnim) && (!this.noAnimForOnce))
    {
      this.fromUser = false;
      this.replaceStack = false;
      Animator localAnimator = onCreateAnimator(1001, true, 0);
      if (localAnimator != null)
      {
        localAnimator.setTarget(this.mactivity.getWindow().getDecorView());
        localAnimator.start();
      }
    }
  }
  
  public void startLeftExistAnim()
  {
    if ((!this.noAnim) && (!this.noAnimForOnce))
    {
      this.fromUser = false;
      this.replaceStack = false;
      Animator localAnimator = onCreateAnimator(1001, false, 0);
      if (localAnimator != null)
      {
        localAnimator.setTarget(this.mactivity.getWindow().getDecorView());
        localAnimator.start();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     mqq.app.MyFragment
 * JD-Core Version:    0.7.0.1
 */