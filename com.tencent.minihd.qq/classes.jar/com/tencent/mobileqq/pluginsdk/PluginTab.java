package com.tencent.mobileqq.pluginsdk;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.View;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;
import com.tencent.qphone.base.util.QLog;

public class PluginTab
  extends PluginActivity
  implements TabHost.OnTabChangeListener, TabHost.TabContentFactory
{
  private PluginTabHost d;
  private String e;
  private TabHost.OnTabChangeListener f;
  
  protected final void addTabSpec(TabHost.TabSpec paramTabSpec, String paramString, Intent paramIntent)
  {
    if (this.d == null) {
      return;
    }
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "PluginTab addTabSpec:" + paramTabSpec.getTag() + ", " + paramString);
    }
    paramTabSpec.setContent(this);
    this.d.a(paramTabSpec.getTag(), paramString, paramIntent);
    this.d.addTab(paramTabSpec);
  }
  
  public View createTabContent(String paramString)
  {
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "PluginTab createTabContent:" + paramString);
    }
    PluginTabHost.TabSpecPluginInfo localTabSpecPluginInfo = this.d.getPluginInfo(paramString);
    if (localTabSpecPluginInfo != null)
    {
      try
      {
        paramString = getBaseContext().getClassLoader();
        IPluginActivity localIPluginActivity = (IPluginActivity)paramString.loadClass(localTabSpecPluginInfo.mActivityName).newInstance();
        if (DebugHelper.sDebug) {
          DebugHelper.log("plugin_tag", "PluginTab Activity:" + localIPluginActivity);
        }
        localIPluginActivity.IInit(this.mPluginID, this.mApkFilePath, this, paramString, this.mPackageInfo, this.mUseSkinEngine, this.mPluginResourcesType);
        localIPluginActivity.ISetIsTab();
        localIPluginActivity.ISetParent(this);
        localIPluginActivity.ISetIntent(localTabSpecPluginInfo.mIntent);
        localIPluginActivity.IOnSetTheme();
        localIPluginActivity.IOnCreate(null);
        paramString = localIPluginActivity.IGetContentView();
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        try
        {
          localTabSpecPluginInfo.mActivity = localIPluginActivity;
          return paramString;
        }
        catch (Exception localException2)
        {
          break label177;
        }
        localException1 = localException1;
        paramString = null;
      }
      label177:
      QLog.e("plugin_tag", 1, this.mPluginID + " createTabContent fail", localException1);
      PluginRuntime.handleCrash(localException1, this.mPluginID, this);
      return paramString;
    }
    return null;
  }
  
  protected IPluginActivity getActivityByTag(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      paramString = this.d.getPluginInfo(paramString);
      localObject1 = localObject2;
      if (paramString != null) {
        localObject1 = paramString.mActivity;
      }
    }
    return localObject1;
  }
  
  protected IPluginActivity getCurrentActivity()
  {
    return getActivityByTag(this.d.getCurrentTabTag());
  }
  
  public PluginTabHost getTabHost()
  {
    return this.d;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    IPluginActivity localIPluginActivity = getCurrentActivity();
    if (localIPluginActivity != null) {
      localIPluginActivity.IOnActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    int j = this.d.getTabCount();
    int i = 0;
    while (i < j)
    {
      paramConfiguration = this.d.getTabAt(i);
      if (paramConfiguration != null)
      {
        paramConfiguration = this.d.getPluginInfo(paramConfiguration.getTag());
        if ((paramConfiguration == null) || (paramConfiguration.mActivity == null)) {}
      }
      i += 1;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    int j = this.d.getTabCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = this.d.getTabAt(i);
      if (localObject != null)
      {
        localObject = this.d.getPluginInfo(((TabHost.TabSpec)localObject).getTag());
        if ((localObject != null) && (((PluginTabHost.TabSpecPluginInfo)localObject).mActivity != null)) {
          ((PluginTabHost.TabSpecPluginInfo)localObject).mActivity.IOnDestroy();
        }
      }
      i += 1;
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    IPluginActivity localIPluginActivity = getCurrentActivity();
    if (localIPluginActivity != null) {
      localIPluginActivity.IOnPause();
    }
  }
  
  protected void onRestart()
  {
    super.onRestart();
    IPluginActivity localIPluginActivity = getCurrentActivity();
    if (localIPluginActivity != null) {
      localIPluginActivity.IOnRestart();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    IPluginActivity localIPluginActivity = getCurrentActivity();
    if (localIPluginActivity != null) {
      localIPluginActivity.IOnResume();
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    IPluginActivity localIPluginActivity = getCurrentActivity();
    if (localIPluginActivity != null) {
      localIPluginActivity.IOnStart();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    IPluginActivity localIPluginActivity = getCurrentActivity();
    if (localIPluginActivity != null) {
      localIPluginActivity.IOnStop();
    }
  }
  
  public void onTabChanged(String paramString)
  {
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "PluginTab onTabChanged:" + paramString);
    }
    IPluginActivity localIPluginActivity = getActivityByTag(this.e);
    if (localIPluginActivity != null) {
      localIPluginActivity.IOnPause();
    }
    this.e = paramString;
    localIPluginActivity = getCurrentActivity();
    if (localIPluginActivity != null) {
      localIPluginActivity.IOnResume();
    }
    if (this.f != null) {
      this.f.onTabChanged(paramString);
    }
  }
  
  public void setOnTabChangedListener(TabHost.OnTabChangeListener paramOnTabChangeListener)
  {
    this.f = paramOnTabChangeListener;
  }
  
  protected final void setPluginTabHost(PluginTabHost paramPluginTabHost)
  {
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "PluginTab setPluginTabHost:" + paramPluginTabHost);
    }
    this.d = paramPluginTabHost;
    this.d.setup();
    this.d.setOnTabChangedListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginTab
 * JD-Core Version:    0.7.0.1
 */