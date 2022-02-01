package com.tencent.qqmusicplayerprocess.netspeed;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.widget.qqmusic.QQMusicHelper;
import com.tencent.mobileqq.activity.widget.qqmusic.business.vkey.VkeyLocal;
import com.tencent.mobileqq.activity.widget.qqmusic.business.vkey.VkeyNet;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MLog;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MusicUtil;
import lqa;
import lqb;

public class VkeyManager
{
  public static final long NET_VKEY_DB_DIRTY_TIME = 6900000L;
  public static final long NET_VKEY_DIRTY_TIME = 7200000L;
  public static final long NET_VKEY_REFLUSH_TIME = 7260000L;
  private static final String TAG = "liwei";
  public static final String VKEY_PACKAGE_TAG = "VKEY";
  private static Object mLock = new Object();
  private static VkeyManager sInstance;
  private String lastStrongQQNum;
  private Handler mAutoReflushDirtyHandler = new lqb(this, Looper.getMainLooper());
  private VkeyLocal mCurrentLocalVkey;
  private VkeyNet mCurrentNetVkey;
  
  static
  {
    try
    {
      System.loadLibrary("express_verify");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      MLog.a("liwei", localUnsatisfiedLinkError);
    }
  }
  
  private void createNewNetVKey()
  {
    MLog.a("liwei", "Get HQ vkey----3-1:createNewNetVKey");
    if (this.mCurrentNetVkey != null) {
      this.mCurrentNetVkey.a();
    }
    this.mCurrentNetVkey = new VkeyNet();
    long l1 = System.currentTimeMillis();
    long l2 = this.mCurrentNetVkey.a();
    this.mAutoReflushDirtyHandler.removeMessages(0);
    this.mAutoReflushDirtyHandler.sendEmptyMessageDelayed(0, 7260000L - (l1 - l2));
  }
  
  public static VkeyManager getInstance()
  {
    if (sInstance == null) {}
    synchronized (mLock)
    {
      if (sInstance == null) {
        sInstance = new VkeyManager();
      }
      return sInstance;
    }
  }
  
  public native String createContentKey(String paramString, int paramInt1, int paramInt2);
  
  public native String createWeakExpressKey(String paramString, int paramInt1, int paramInt2);
  
  public String getContKey(String paramString, int paramInt)
  {
    try
    {
      String str = createContentKey(paramString, paramInt, 128);
      MLog.a("liwei", "getContKey　filename = " + paramString + ", iPaid = " + paramInt + ",contkey :" + str);
      if (!TextUtils.isEmpty(str)) {
        return str;
      }
      return "";
    }
    catch (Exception paramString)
    {
      return "";
    }
    catch (Throwable paramString)
    {
      MLog.d("liwei", paramString.toString());
    }
    return "";
  }
  
  public String getCurrentVkey()
  {
    try
    {
      if (this.mCurrentNetVkey != null) {
        if (!this.mCurrentNetVkey.a()) {
          str1 = this.mCurrentNetVkey.a();
        }
      }
      for (;;)
      {
        String str2 = str1;
        try
        {
          if (TextUtils.isEmpty(str1))
          {
            if ((this.mCurrentLocalVkey != null) && (this.mCurrentLocalVkey.a()))
            {
              this.mCurrentLocalVkey.a();
              this.mCurrentLocalVkey = null;
            }
            if (this.mCurrentLocalVkey == null) {
              this.mCurrentLocalVkey = new VkeyLocal();
            }
            str2 = str1;
            if (this.mCurrentLocalVkey != null)
            {
              if (this.mCurrentLocalVkey.a()) {
                break label122;
              }
              str2 = this.mCurrentLocalVkey.a();
            }
          }
          return str2;
          MLog.d("liwei", "getCurrentVkey() mCurrentNetVkey isDirty");
          str1 = null;
          continue;
          label122:
          MLog.d("liwei", "getCurrentVkey() mCurrentLocalVkey isDirty");
          return str1;
        }
        catch (Exception localException1) {}
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        String str1 = null;
      }
    }
    MLog.a("liwei", localException1);
    return str1;
  }
  
  public String getStrongQQNum()
  {
    if (MusicUtil.a(this.lastStrongQQNum)) {}
    try
    {
      this.lastStrongQQNum = (QQMusicHelper.a() + "");
      return this.lastStrongQQNum;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public String getVKey()
  {
    for (;;)
    {
      String str1;
      int i;
      synchronized (mLock)
      {
        if (this.mCurrentNetVkey != null)
        {
          if (this.mCurrentNetVkey.a()) {
            createNewNetVKey();
          }
          str1 = this.mCurrentNetVkey.a();
          i = 0;
          if ((!MusicUtil.a(str1)) || (!this.mCurrentNetVkey.b()) || (i >= 6)) {
            break label141;
          }
          MLog.a("zhangsg", "getVKey:waitTime = " + i);
        }
      }
      try
      {
        Thread.sleep(500L);
        int j = i + 1;
        i = j;
        if (this.mCurrentNetVkey != null)
        {
          str1 = this.mCurrentNetVkey.a();
          i = j;
          continue;
          createNewNetVKey();
          continue;
          str2 = finally;
          throw str2;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
    label141:
    if (str2 != null)
    {
      MLog.a("VKEY", "getNetVKey Suc:" + str2);
      return str2;
    }
    if ((this.mCurrentLocalVkey != null) && (this.mCurrentLocalVkey.a()))
    {
      this.mCurrentLocalVkey.a();
      this.mCurrentLocalVkey = null;
    }
    if (this.mCurrentLocalVkey == null) {
      this.mCurrentLocalVkey = new VkeyLocal();
    }
    MLog.a("VKEY", "getLocalVKey Suc:" + this.mCurrentLocalVkey.a());
    String str3 = this.mCurrentLocalVkey.a();
    return str3;
  }
  
  public String getVKeyPair()
  {
    synchronized (mLock)
    {
      if (this.mCurrentNetVkey != null)
      {
        if (this.mCurrentNetVkey.a()) {
          createNewNetVKey();
        }
        String str1 = this.mCurrentNetVkey.b();
        if (str1 != null)
        {
          MLog.a("VKEY", "getNetVKey Suc:" + str1);
          return str1;
        }
      }
      else
      {
        createNewNetVKey();
      }
    }
    if ((this.mCurrentLocalVkey != null) && (this.mCurrentLocalVkey.a()))
    {
      this.mCurrentLocalVkey.a();
      this.mCurrentLocalVkey = null;
    }
    if (this.mCurrentLocalVkey == null) {
      this.mCurrentLocalVkey = new VkeyLocal();
    }
    MLog.a("VKEY", "getLocalVKey Suc:" + this.mCurrentLocalVkey.a());
    String str2 = this.mCurrentLocalVkey.a();
    return str2;
  }
  
  public void init()
  {
    if (sInstance != null) {
      new Thread(new lqa(this)).start();
    }
  }
  
  public void onLoginStateChanged(String paramString)
  {
    synchronized (mLock)
    {
      if (!MusicUtil.a(paramString, this.lastStrongQQNum))
      {
        this.lastStrongQQNum = paramString;
        if (this.mCurrentNetVkey != null) {
          this.mCurrentNetVkey.b(this.lastStrongQQNum);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.qqmusicplayerprocess.netspeed.VkeyManager
 * JD-Core Version:    0.7.0.1
 */