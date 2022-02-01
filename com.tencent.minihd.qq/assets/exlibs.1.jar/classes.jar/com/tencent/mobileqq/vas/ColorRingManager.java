package com.tencent.mobileqq.vas;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kuy;
import mqq.manager.Manager;
import org.json.JSONObject;

public class ColorRingManager
  implements Manager
{
  public static final int a = 0;
  public static final String a = "ColorRingManager";
  public static final int b = 1;
  public static final String b = "show_color_ring_tip";
  public static final int c = 2;
  public static final String c = "show_color_ring_aio_white_tip";
  public static final String d = "last_color_ring_play_id";
  public static final String e = "show_comming_ring_tips_sp_key_";
  public static final String f = "comming_ring_down_key";
  public static final String g = "colorring";
  public static final String h = "comering";
  public QQAppInterface a;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new kuy(this, "param_WIFIColorRingDownloadFlow", "param_XGColorRingDownloadFlow");
  private DownloaderFactory jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = null;
  public IPCDownloadListener a;
  
  public ColorRingManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = ((DownloaderFactory)paramQQAppInterface.getManager(46));
  }
  
  public static int a(String paramString1, String paramString2)
  {
    int i = BaseApplicationImpl.a().getSharedPreferences("mobileQQ", 0).getInt("show_color_ring_tip_" + paramString1 + "_" + paramString2, 2);
    if (i != 0) {
      a(paramString1, 0, paramString2);
    }
    return i;
  }
  
  public static long a()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.a().getSharedPreferences("mobileQQ", 4);
    long l = localSharedPreferences.getLong("last_color_ring_play_id", 0L);
    localSharedPreferences.edit().remove("last_color_ring_play_id").commit();
    return l;
  }
  
  public static Bitmap a(long paramLong)
  {
    if (paramLong == 0L) {}
    for (;;)
    {
      return null;
      Object localObject = b(paramLong, 1);
      if (new File((String)localObject).exists())
      {
        try
        {
          localObject = BitmapFactory.decodeFile((String)localObject);
          return localObject;
        }
        catch (OutOfMemoryError localOutOfMemoryError) {}
        if (QLog.isColorLevel()) {
          QLog.d("ColorRingManager", 2, "getCoverBitmap OOM.");
        }
      }
    }
  }
  
  public static Boolean a(String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.a().getSharedPreferences("mobileQQ", 0);
    if (localSharedPreferences == null) {
      return Boolean.valueOf(false);
    }
    String str = localSharedPreferences.getString("show_color_ring_aio_white_tip_" + paramString2, "");
    String[] arrayOfString = str.split("&");
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equals(paramString1)) {
        return Boolean.valueOf(false);
      }
      i += 1;
    }
    if (arrayOfString.length >= 3) {
      return Boolean.valueOf(false);
    }
    if (str.length() == 0) {}
    for (;;)
    {
      localSharedPreferences.edit().putString("show_color_ring_aio_white_tip_" + paramString2, paramString1).commit();
      return Boolean.valueOf(true);
      paramString1 = str + "&" + paramString1;
    }
  }
  
  public static String a(long paramLong)
  {
    Object localObject1;
    if (paramLong == 0L) {
      localObject1 = "默认彩铃";
    }
    for (;;)
    {
      return localObject1;
      String str = "";
      Object localObject2 = new File(b(paramLong, 2));
      localObject1 = str;
      if (((File)localObject2).exists()) {
        try
        {
          localObject2 = FileUtils.a((File)localObject2);
          localObject1 = str;
          if (localObject2 != null)
          {
            localObject1 = new JSONObject((String)localObject2).getString("name");
            return localObject1;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    return "";
  }
  
  public static String a(long paramLong, int paramInt)
  {
    String str = "";
    if (paramInt == 3) {
      str = "https://imgcache.qq.com/qqshow/admindata/comdata/vipRing_item_" + paramLong + "/" + paramLong + "_2.mp3";
    }
    do
    {
      return str;
      if (paramInt == 2) {
        return "https://imgcache.qq.com/qqshow/admindata/comdata/vipRing_item_" + paramLong + "/config.json";
      }
    } while (paramInt != 1);
    return "https://imgcache.qq.com/qqshow/admindata/comdata/vipRing_item_" + paramLong + "/preview.jpg";
  }
  
  public static JSONObject a(long paramLong)
  {
    Object localObject = new File(ColorRingConstants.a + File.separator + paramLong + File.separator + "config.txt");
    try
    {
      localObject = FileUtils.a((File)localObject);
      if (localObject != null)
      {
        localObject = new JSONObject((String)localObject);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public static void a(long paramLong)
  {
    BaseApplicationImpl.a().getSharedPreferences("mobileQQ", 4).edit().putLong("last_color_ring_play_id", paramLong).commit();
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    BaseApplicationImpl.a().getSharedPreferences("mobileQQ", 0).edit().putInt("show_color_ring_tip_" + paramString1 + "_" + paramString2, paramInt).commit();
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool = false;
    paramString2 = BaseApplicationImpl.a().getSharedPreferences(paramString2, 4);
    int i = paramString2.getInt("show_comming_ring_tips_sp_key_" + paramString1, 0);
    if (i < 3)
    {
      paramString2.edit().putInt("show_comming_ring_tips_sp_key_" + paramString1, i + 1).commit();
      bool = true;
    }
    return bool;
  }
  
  public static String b(long paramLong, int paramInt)
  {
    if (paramLong == 0L) {}
    do
    {
      return "";
      if (paramInt == 2) {
        return ColorRingConstants.a + File.separator + paramLong + File.separator + "config.txt";
      }
      if (paramInt == 1) {
        return ColorRingConstants.a + File.separator + paramLong + File.separator + "cover.jpg";
      }
    } while (paramInt != 3);
    return ColorRingConstants.a + File.separator + paramLong + File.separator + "ring.mp3";
  }
  
  public void a(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a(true, a(paramLong, paramInt));
  }
  
  public void a(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, ">>startDownload, id=" + paramLong);
    }
    Object localObject = new File(b(paramLong, paramInt1) + ".tmp");
    localObject = new DownloadTask(a(paramLong, paramInt1), (File)localObject);
    ((DownloadTask)localObject).e = 3145728L;
    Bundle localBundle = new Bundle();
    localBundle.putLong("id", paramLong);
    localBundle.putBoolean("isIPC", paramBoolean);
    localBundle.putInt("resourceType", paramInt1);
    localBundle.putString("colorType", paramString);
    if (paramBoolean) {
      localBundle.putInt("srcType", paramInt2);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a((DownloadTask)localObject, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
      if (QLog.isColorLevel()) {
        QLog.d("ColorRingManager", 2, "<<startDownload, id=" + paramLong);
      }
      return;
      ((DownloadTask)localObject).b = true;
    }
  }
  
  public void a(IPCDownloadListener paramIPCDownloadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = paramIPCDownloadListener;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ColorRingManager
 * JD-Core Version:    0.7.0.1
 */