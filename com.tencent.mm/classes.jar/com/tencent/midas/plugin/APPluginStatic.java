package com.tencent.midas.plugin;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.midas.comm.APLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public abstract class APPluginStatic
{
  public static final String PARAM_CLASS_STATISTICS_UPLOADER = "clsUploader";
  public static final String PARAM_CLEAR_TOP = "cleartop";
  static final String PARAM_IS_IN_PLUGIN = "pluginsdk_IsPluginActivity";
  public static final String PARAM_LAUNCH_ACTIVITY = "pluginsdk_launchActivity";
  public static final String PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY = "PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY";
  public static final String PARAM_PLUGIN_IS_NEW_PROCESS = "pluginsdk_isNewProcess";
  public static final String PARAM_PLUGIN_LOCATION = "pluginsdk_pluginLocation";
  public static final String PARAM_PLUGIN_LOG_CALLBACK_CLASS_NAME = "pluginsdk_logCallbackClassName";
  public static final String PARAM_PLUGIN_LOG_ENABLE = "pluginsdk_logEnable";
  public static final String PARAM_PLUGIN_NAME = "pluginsdk_pluginName";
  public static final String PARAM_PLUGIN_PATH = "pluginsdk_pluginpath";
  public static final String PARAM_PLUGIN_RECEIVER_CLASS_NAME = "pluginsdk_launchReceiver";
  private static final String TAG = "APPluginStatic";
  public static final int USER_QQ_RESOURCES_NO = -1;
  public static final int USER_QQ_RESOURCES_YES = 1;
  private static ArrayList<WeakReference<IAPPluginActivity>> sInstances = new ArrayList();
  static final ConcurrentHashMap<String, PackageInfo> sPackageInfoMap = new ConcurrentHashMap();
  
  static void add(IAPPluginActivity paramIAPPluginActivity)
  {
    
    synchronized (sInstances)
    {
      sInstances.add(new WeakReference(paramIAPPluginActivity));
      return;
    }
  }
  
  static List<WeakReference<IAPPluginActivity>> getActivitys()
  {
    return sInstances;
  }
  
  public static ClassLoader getOrCreateClassLoader(Context paramContext, String paramString)
  {
    return APPluginLoader.getOrCreateClassLoader(paramContext, paramString);
  }
  
  public static void release()
  {
    APPluginLoader.release();
    sPackageInfoMap.clear();
    APLog.d("APPluginStatic", "release sInstances size: " + sInstances.size());
  }
  
  static void remove(IAPPluginActivity paramIAPPluginActivity)
  {
    updateReference();
    removeActivity(paramIAPPluginActivity);
  }
  
  private static boolean removeActivity(IAPPluginActivity paramIAPPluginActivity)
  {
    ArrayList localArrayList = sInstances;
    int i = 0;
    try
    {
      while (i < sInstances.size())
      {
        if (((WeakReference)sInstances.get(i)).get() == paramIAPPluginActivity)
        {
          sInstances.remove(i);
          return true;
        }
        i += 1;
      }
      return false;
    }
    finally
    {
      paramIAPPluginActivity = finally;
      throw paramIAPPluginActivity;
    }
  }
  
  public static void removeAll()
  {
    updateReference();
    ArrayList localArrayList = sInstances;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < sInstances.size())
        {
          IAPPluginActivity localIAPPluginActivity = (IAPPluginActivity)((WeakReference)sInstances.get(i)).get();
          if (localIAPPluginActivity != null)
          {
            localIAPPluginActivity.IFinish();
            sInstances.remove(i);
            i -= 1;
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  static void updateReference()
  {
    ArrayList localArrayList = sInstances;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < sInstances.size())
        {
          if (((WeakReference)sInstances.get(i)).get() == null)
          {
            sInstances.remove(i);
            i -= 1;
          }
        }
        else {
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.midas.plugin.APPluginStatic
 * JD-Core Version:    0.7.0.1
 */