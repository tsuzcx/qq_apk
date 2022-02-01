package com.tencent.midas.plugin;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

public abstract interface IAPPluginActivity
{
  public abstract boolean IDispatchTouchEvent(MotionEvent paramMotionEvent);
  
  public abstract void IFinish();
  
  public abstract View IGetContentView();
  
  public abstract Handler IGetInHandler();
  
  public abstract Resources IGetResource();
  
  public abstract void IInit(String paramString1, String paramString2, Activity paramActivity, ClassLoader paramClassLoader, PackageInfo paramPackageInfo);
  
  public abstract boolean IIsWrapContent();
  
  public abstract void IOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void IOnConfigurationChanged(Configuration paramConfiguration);
  
  public abstract void IOnCreate(Bundle paramBundle);
  
  public abstract boolean IOnCreateOptionsMenu(Menu paramMenu);
  
  public abstract void IOnDestroy();
  
  public abstract boolean IOnKeyDown(int paramInt, KeyEvent paramKeyEvent);
  
  public abstract boolean IOnKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent);
  
  public abstract boolean IOnKeyUp(int paramInt, KeyEvent paramKeyEvent);
  
  public abstract boolean IOnMenuItemSelected(int paramInt, MenuItem paramMenuItem);
  
  public abstract void IOnNewIntent(Intent paramIntent);
  
  public abstract boolean IOnOptionsItemSelected(MenuItem paramMenuItem);
  
  public abstract void IOnPause();
  
  public abstract boolean IOnPrepareOptionsMenu(Menu paramMenu);
  
  public abstract void IOnRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
  
  public abstract void IOnRestart();
  
  public abstract void IOnRestoreInstanceState(Bundle paramBundle);
  
  public abstract void IOnResume();
  
  public abstract void IOnSaveInstanceState(Bundle paramBundle);
  
  public abstract void IOnStart();
  
  public abstract void IOnStop();
  
  public abstract boolean IOnTouchEvent(MotionEvent paramMotionEvent);
  
  public abstract void IOnUserInteraction();
  
  public abstract void IOnWindowFocusChanged(boolean paramBoolean);
  
  public abstract void IRequestPermissions(String[] paramArrayOfString, int paramInt);
  
  public abstract void ISetIntent(Intent paramIntent);
  
  public abstract void ISetOutHandler(Handler paramHandler);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.midas.plugin.IAPPluginActivity
 * JD-Core Version:    0.7.0.1
 */