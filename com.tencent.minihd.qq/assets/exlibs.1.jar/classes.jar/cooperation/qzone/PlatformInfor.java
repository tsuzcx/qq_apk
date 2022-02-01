package cooperation.qzone;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.common.config.provider.NetworkStateForConfig;
import com.tencent.qphone.base.util.BaseApplication;

public class PlatformInfor
{
  private static PlatformInfor jdField_a_of_type_CooperationQzonePlatformInfor;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static final String jdField_a_of_type_JavaLangString = PlatformInfor.class.getSimpleName();
  private static final String e = "wifi";
  private static final String f = "2g";
  private static final String g = "3g";
  private static String h = "";
  private static String i = "";
  private Context jdField_a_of_type_AndroidContentContext = BaseApplication.getContext();
  private TelephonyManager jdField_a_of_type_AndroidTelephonyTelephonyManager = null;
  private String b = "";
  private String c = "";
  private String d = null;
  
  private PlatformInfor()
  {
    try
    {
      h = this.jdField_a_of_type_AndroidContentContext.getPackageManager().getPackageInfo(this.jdField_a_of_type_AndroidContentContext.getPackageName(), 0).versionName;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static PlatformInfor a()
  {
    if (jdField_a_of_type_CooperationQzonePlatformInfor == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_CooperationQzonePlatformInfor == null) {
        jdField_a_of_type_CooperationQzonePlatformInfor = new PlatformInfor();
      }
      return jdField_a_of_type_CooperationQzonePlatformInfor;
    }
  }
  
  private void a()
  {
    try
    {
      h = this.jdField_a_of_type_AndroidContentContext.getPackageManager().getPackageInfo(this.jdField_a_of_type_AndroidContentContext.getPackageName(), 0).versionName;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private String h()
  {
    switch (NetworkStateForConfig.a().b())
    {
    default: 
      return "wan";
    case 1: 
      return "wifi";
    case 2: 
      return "3g";
    }
    return "2g";
  }
  
  public String a()
  {
    if ((h == null) || (h.length() == 0)) {
      a();
    }
    return h;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    try
    {
      if (!TextUtils.isEmpty(i)) {
        return i;
      }
      if (this.jdField_a_of_type_AndroidTelephonyTelephonyManager != null)
      {
        i = this.jdField_a_of_type_AndroidTelephonyTelephonyManager.getSubscriberId();
        return i;
      }
      return "";
    }
    catch (Exception localException) {}
    return "";
  }
  
  public String d()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("MANUFACTURER=" + Build.MANUFACTURER + ",SDK=" + Build.VERSION.SDK_INT + ",board=" + Build.BOARD);
    localStringBuffer.append(",device=" + Build.DEVICE);
    localStringBuffer.append(",brand=" + Build.BRAND);
    localStringBuffer.append(",display=" + Build.DISPLAY);
    localStringBuffer.append(",model=" + Build.MODEL);
    localStringBuffer.append(",product=" + Build.PRODUCT);
    return localStringBuffer.toString();
  }
  
  public String e()
  {
    if ((this.d != null) && (this.d.length() > 0))
    {
      localObject1 = new StringBuilder(this.d);
      ((StringBuilder)localObject1).append("n=").append(h());
      return ((StringBuilder)localObject1).toString();
    }
    Object localObject2 = (WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window");
    Object localObject1 = new DisplayMetrics();
    ((WindowManager)localObject2).getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("i=").append("").append('&');
    ((StringBuilder)localObject2).append("mac=").append(g()).append('&');
    ((StringBuilder)localObject2).append("m=").append(Build.MODEL).append('&');
    ((StringBuilder)localObject2).append("o=").append(Build.VERSION.RELEASE).append('&');
    ((StringBuilder)localObject2).append("a=").append(Build.VERSION.SDK_INT).append('&');
    StringBuilder localStringBuilder = ((StringBuilder)localObject2).append("sc=");
    if (Environment.getExternalStorageState().equals("mounted")) {}
    for (int j = 1;; j = 0)
    {
      localStringBuilder.append(j).append('&');
      ((StringBuilder)localObject2).append("sd=").append("0").append('&');
      ((StringBuilder)localObject2).append("p=").append(((DisplayMetrics)localObject1).widthPixels).append('*').append(((DisplayMetrics)localObject1).heightPixels).append('&');
      ((StringBuilder)localObject2).append("f=").append(Build.MANUFACTURER).append('&');
      this.d = ((StringBuilder)localObject2).toString();
      ((StringBuilder)localObject2).append("n=").append(h());
      return ((StringBuilder)localObject2).toString();
    }
  }
  
  public String f()
  {
    String str2 = NetworkStateForConfig.a().b();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public String g()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        return "null";
      }
      Object localObject = (WifiManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("wifi");
      if (localObject == null) {
        return "null";
      }
      localObject = ((WifiManager)localObject).getConnectionInfo();
      if (localObject == null) {
        return "null";
      }
      localObject = ((WifiInfo)localObject).getMacAddress();
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "null";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.PlatformInfor
 * JD-Core Version:    0.7.0.1
 */