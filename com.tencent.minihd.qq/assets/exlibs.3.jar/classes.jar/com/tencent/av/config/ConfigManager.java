package com.tencent.av.config;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.qav.log.AVLog;

public class ConfigManager
{
  public static final String ACTION_GOT_SHARP_CONFIG_PAYLOAD = "com.tencent.av.ACTION_GOT_SHARP_CONFIG_PAYLOAD";
  public static final String ACTION_WRITE_CONFIG_INFO_TO_FILE = "com.tencent.av.ACTION_WRITE_CONFIG_INFO_TO_FILE";
  public static final String EXTRA_VERSION = "version";
  private static final String TAG = "ConfigManager";
  private static ConfigManager sConfigManager = null;
  private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      paramAnonymousIntent = paramAnonymousIntent.getAction();
      AVLog.d("ConfigManager", String.format("onReceive action=%s", new Object[] { paramAnonymousIntent }));
      if (("com.tencent.av.ACTION_WRITE_CONFIG_INFO_TO_FILE".equals(paramAnonymousIntent)) || ("com.tencent.av.ACTION_GOT_SHARP_CONFIG_PAYLOAD".equals(paramAnonymousIntent))) {
        ConfigManager.this.reload(paramAnonymousContext);
      }
    }
  };
  private BaseConfigParser mConfigBaseParser = null;
  private Context mContext;
  private int mVersion = 0;
  
  private ConfigManager(Context paramContext)
  {
    this.mContext = paramContext;
    paramContext = new IntentFilter();
    paramContext.addAction("com.tencent.av.ACTION_WRITE_CONFIG_INFO_TO_FILE");
    paramContext.addAction("com.tencent.av.ACTION_GOT_SHARP_CONFIG_PAYLOAD");
    this.mContext.registerReceiver(this.mBroadcastReceiver, paramContext);
  }
  
  public static ConfigManager getInstance(Context paramContext)
  {
    if (sConfigManager == null) {}
    try
    {
      if (sConfigManager == null) {
        sConfigManager = new ConfigManager(paramContext);
      }
      return sConfigManager;
    }
    finally {}
  }
  
  private void reload(Context paramContext)
  {
    try
    {
      if (this.mConfigBaseParser == null) {
        return;
      }
      int i = ConfigInfo.getSharpConfigVersionFromFile(paramContext);
      if ((this.mVersion != i) || (this.mConfigBaseParser.isEmpty()))
      {
        this.mConfigBaseParser = null;
        this.mVersion = 0;
      }
      return;
    }
    finally {}
  }
  
  public BaseConfigParser getParser()
  {
    try
    {
      if (this.mConfigBaseParser == null)
      {
        localObject1 = ConfigInfo.getSharpConfigPayloadFromFile(this.mContext);
        this.mVersion = ConfigInfo.getSharpConfigVersionFromFile(this.mContext);
        this.mConfigBaseParser = new BaseConfigParser((String)localObject1);
      }
      Object localObject1 = this.mConfigBaseParser;
      return localObject1;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.config.ConfigManager
 * JD-Core Version:    0.7.0.1
 */