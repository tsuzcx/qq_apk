package com.tencent.theme;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.os.Process;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.lang.reflect.Field;

public class SkinnableActivityProcesser
  extends BroadcastReceiver
{
  public static final String TAG = "[SkinnableActivityProcesser]";
  private final Activity a;
  private final Callback b;
  
  public SkinnableActivityProcesser(Activity paramActivity, Callback paramCallback)
  {
    this.a = paramActivity;
    this.b = paramCallback;
    try
    {
      this.a.registerReceiver(this, new IntentFilter("com.tencent.qplus.THEME_INVALIDATE"), "com.tencent.msg.permission.pushnotify", null);
      return;
    }
    catch (Exception paramActivity) {}
  }
  
  static boolean a(Drawable paramDrawable)
  {
    boolean bool2 = false;
    if (!(paramDrawable instanceof DrawableContainer)) {
      return false;
    }
    paramDrawable = (DrawableContainer.DrawableContainerState)paramDrawable.getConstantState();
    Object localObject = paramDrawable.getChildren();
    int j = paramDrawable.getChildCount();
    int i = 0;
    if (i < j)
    {
      Drawable localDrawable = localObject[i];
      boolean bool1;
      if ((localDrawable instanceof SkinnableNinePatchDrawable)) {
        bool1 = true;
      }
      for (;;)
      {
        i += 1;
        bool2 = bool1;
        break;
        bool1 = bool2;
        if ((localDrawable instanceof DrawableContainer)) {
          bool1 = bool2 | a(localDrawable);
        }
      }
    }
    try
    {
      localObject = DrawableContainer.DrawableContainerState.class.getDeclaredField("mComputedConstantSize");
      ((Field)localObject).setAccessible(true);
      ((Field)localObject).setBoolean(paramDrawable, false);
      label109:
      if (bool2) {
        try
        {
          localObject = DrawableContainer.DrawableContainerState.class.getDeclaredField("mPaddingChecked");
          ((Field)localObject).setAccessible(true);
          ((Field)localObject).setBoolean(paramDrawable, false);
          localObject = DrawableContainer.DrawableContainerState.class.getDeclaredField("mConstantPadding");
          ((Field)localObject).setAccessible(true);
          ((Field)localObject).set(paramDrawable, null);
          return true;
        }
        catch (Exception paramDrawable)
        {
          return true;
        }
      }
      return bool2;
    }
    catch (Exception localException)
    {
      break label109;
    }
  }
  
  public void destory()
  {
    try
    {
      this.a.unregisterReceiver(this);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    j = 0;
    if (paramIntent.getIntExtra("pid", Process.myPid()) != Process.myPid()) {}
    do
    {
      return;
      if (this.b != null) {
        this.b.onPreThemeChanged();
      }
      paramContext = this.a.getWindow().getDecorView();
      paramIntent = (ViewGroup)paramContext;
      View[] arrayOfView = new View[paramIntent.getChildCount()];
      i = 0;
      while (i < paramIntent.getChildCount())
      {
        arrayOfView[i] = paramIntent.getChildAt(i);
        i += 1;
      }
      for (;;)
      {
        try
        {
          paramIntent.removeAllViews();
          i = j;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          i = j;
          continue;
        }
        if (i >= arrayOfView.length) {
          continue;
        }
        paramIntent.addView(arrayOfView[i]);
        i += 1;
      }
      SkinEngine.invalidateAll(paramContext);
    } while (this.b == null);
    this.b.onPostThemeChanged();
  }
  
  public static abstract interface Callback
  {
    public abstract void onPostThemeChanged();
    
    public abstract void onPreThemeChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.theme.SkinnableActivityProcesser
 * JD-Core Version:    0.7.0.1
 */