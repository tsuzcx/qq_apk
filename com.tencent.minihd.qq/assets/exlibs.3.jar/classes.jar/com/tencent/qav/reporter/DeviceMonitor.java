package com.tencent.qav.reporter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.qav.log.AVLog;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DeviceMonitor
{
  static final String TAG = "DeviceMonitor";
  private static DeviceMonitor deviceMonitor;
  private volatile String cpuTemperature = "0";
  private volatile String deviceTemperature = "0";
  private boolean hasInited;
  private NetChangedReceiver mNetChangeReceiver = new NetChangedReceiver(null);
  List<onNetWorkTypeChangeListener> netWorkTypeChangeListeners = new ArrayList();
  
  public static DeviceMonitor getInstance()
  {
    if (deviceMonitor == null) {}
    try
    {
      if (deviceMonitor == null) {
        deviceMonitor = new DeviceMonitor();
      }
      return deviceMonitor;
    }
    finally {}
  }
  
  public void addOnNetworkTypeChangeListener(onNetWorkTypeChangeListener paramonNetWorkTypeChangeListener)
  {
    this.netWorkTypeChangeListeners.add(paramonNetWorkTypeChangeListener);
  }
  
  int convertNetType2ApnType(@NetType int paramInt)
  {
    int i;
    switch (paramInt)
    {
    case 1: 
    default: 
      i = 100;
    }
    for (;;)
    {
      AVLog.d("DeviceMonitor", "convertNetType2ApnType netType = " + paramInt + ",apnType = " + i);
      return i;
      i = 3;
      continue;
      i = 9;
      continue;
      i = 11;
      continue;
      i = 1;
      continue;
      i = 0;
    }
  }
  
  public int getApnType(Context paramContext)
  {
    return convertNetType2ApnType(getNetWorkType(paramContext));
  }
  
  public String getCpuTemperature()
  {
    return this.cpuTemperature;
  }
  
  public String getDeviceTemperature()
  {
    return this.deviceTemperature;
  }
  
  public int getNetWorkType(Context paramContext)
  {
    int j = 0;
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    int i = j;
    if (paramContext != null)
    {
      if (paramContext.getType() != 1) {
        break label57;
      }
      i = 2;
    }
    for (;;)
    {
      AVLog.d("DeviceMonitor", "getNetWorkType: " + i);
      return i;
      label57:
      i = j;
      if (paramContext.getType() == 0) {
        switch (paramContext.getSubtype())
        {
        case 7: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        default: 
          i = 4;
          break;
        case 1: 
        case 2: 
        case 4: 
          i = 4;
          break;
        case 3: 
        case 5: 
        case 6: 
        case 8: 
          i = 3;
          break;
        case 13: 
          i = 5;
        }
      }
    }
  }
  
  public void init(Context paramContext)
  {
    if (this.hasInited) {
      return;
    }
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      paramContext.registerReceiver(this.mNetChangeReceiver, localIntentFilter);
      this.hasInited = true;
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public void removeOnNetworkTypeChangeListener(onNetWorkTypeChangeListener paramonNetWorkTypeChangeListener)
  {
    this.netWorkTypeChangeListeners.remove(paramonNetWorkTypeChangeListener);
  }
  
  public void uinInit(Context paramContext)
  {
    if (!this.hasInited) {
      return;
    }
    try
    {
      paramContext.unregisterReceiver(this.mNetChangeReceiver);
      this.netWorkTypeChangeListeners.clear();
      this.hasInited = false;
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public void updateCpuTemperature(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.cpuTemperature = paramString;
    }
  }
  
  public void updateDeviceTemperature(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.deviceTemperature = paramString;
    }
  }
  
  private class NetChangedReceiver
    extends BroadcastReceiver
  {
    private NetChangedReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction()))
      {
        int i = 0;
        paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if ((paramContext != null) && (paramContext.isAvailable())) {
          if (paramContext.getType() == 1) {
            i = 2;
          }
        }
        for (;;)
        {
          paramContext = DeviceMonitor.this.netWorkTypeChangeListeners.iterator();
          while (paramContext.hasNext()) {
            ((DeviceMonitor.onNetWorkTypeChangeListener)paramContext.next()).onAppNetWorkTypeChange(i);
          }
          if (paramContext.getType() == 0) {
            switch (paramContext.getSubtype())
            {
            case 7: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            default: 
              i = 4;
              break;
            case 1: 
            case 2: 
            case 4: 
              i = 4;
              break;
            case 3: 
            case 5: 
            case 6: 
            case 8: 
              i = 3;
              break;
            case 13: 
              i = 5;
              continue;
              i = 0;
            }
          }
        }
      }
    }
  }
  
  @Retention(RetentionPolicy.CLASS)
  public static @interface NetType
  {
    public static final int NT_2G = 4;
    public static final int NT_3G = 3;
    public static final int NT_4G = 5;
    public static final int NT_LINE = 1;
    public static final int NT_NONE = 0;
    public static final int NT_OTHER = 100;
    public static final int NT_WIFI = 2;
  }
  
  public static abstract interface onNetWorkTypeChangeListener
  {
    public abstract void onAppNetWorkTypeChange(@DeviceMonitor.NetType int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.qav.reporter.DeviceMonitor
 * JD-Core Version:    0.7.0.1
 */