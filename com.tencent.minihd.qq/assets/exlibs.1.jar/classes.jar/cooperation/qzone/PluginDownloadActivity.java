package cooperation.qzone;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;
import java.math.BigDecimal;

public class PluginDownloadActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, PluginManagerHelper.OnPluginManagerLoadedListener
{
  private static final int jdField_a_of_type_Int = 400;
  public static final String a = "plugin_type_key";
  private static final int b = 1000;
  public static final String b = "plugin_type_watermark";
  private static final int c = 1001;
  public static final String c = "plugin_type_video";
  private static final int jdField_d_of_type_Int = 1002;
  private static final int jdField_e_of_type_Int = 1003;
  private static final int jdField_f_of_type_Int = 1004;
  private static final int jdField_g_of_type_Int = 90;
  private static String jdField_g_of_type_JavaLangString;
  private static final int jdField_h_of_type_Int = 99;
  private static String jdField_h_of_type_JavaLangString;
  private static final String i = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "tencent" + File.separator + "zebrasdk" + File.separator;
  private long jdField_a_of_type_Long;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private PluginManagerClient jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private String jdField_d_of_type_JavaLangString;
  private String jdField_e_of_type_JavaLangString;
  private String jdField_f_of_type_JavaLangString;
  
  static
  {
    g = "https://dldir1.qq.com/invc/zebra/imgs/watermarkIntro.jpg";
    h = "https://qzs.qq.com/qzone/photo/v7/js/common/images/mini_video_cover.png";
  }
  
  public PluginDownloadActivity()
  {
    this.d = "";
    this.e = "";
    this.f = "";
  }
  
  private String a(int paramInt)
  {
    Object localObject = "20秒";
    float f1;
    if (paramInt != 0)
    {
      f1 = (float)((System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L) / paramInt * (100 - paramInt);
      if (f1 > 60.0F) {
        localObject = "1分钟";
      }
    }
    else
    {
      return localObject;
    }
    localObject = new BigDecimal(f1).setScale(1, 4);
    return localObject + "秒";
  }
  
  private void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("IphoneTitleBarActivity", 4, "[WMBridgeActivity] [initUI] start!");
    }
    if (this.d.equals("plugin_type_watermark")) {
      setTitle("水印相机");
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131302461));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302460));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131302462));
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageURL(this.f);
      return;
      if (this.d.equals("plugin_type_video")) {
        setTitle("短视频");
      }
    }
  }
  
  private void a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("IphoneTitleBarActivity", 4, "[WMBridgeActivity] [finishAndResult] begin!");
    }
    setResult(paramInt, this.jdField_a_of_type_AndroidContentIntent);
    finish();
  }
  
  public void a(String paramString, PluginBaseInfo paramPluginBaseInfo)
  {
    if (paramPluginBaseInfo == null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.isReady()) {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1001, 400L);
      }
      return;
    }
    switch (paramPluginBaseInfo.mState)
    {
    case -1: 
    default: 
      return;
    case -2: 
      if (QLog.isDevelopLevel()) {
        QLog.d("IphoneTitleBarActivity", 4, "[WMBridgeActivity] [handlePluginInfo] PluginInfo.STATE_ERROR!");
      }
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(1003);
      return;
    case 0: 
      if (QLog.isDevelopLevel()) {
        QLog.d("IphoneTitleBarActivity", 4, "[WMBridgeActivity] [handlePluginInfo] PluginInfo.STATE_NODOWNLOAD!");
      }
      this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.installPlugin(paramString);
    case 1: 
      if (QLog.isDevelopLevel()) {
        QLog.d("IphoneTitleBarActivity", 4, "[WMBridgeActivity] [handlePluginInfo] PluginInfo.STATE_DOWNLOADING!");
      }
    case 2: 
      if (QLog.isDevelopLevel()) {
        QLog.d("IphoneTitleBarActivity", 4, "[WMBridgeActivity] [handlePluginInfo] PluginInfo.STATE_DOWNLOADED!");
      }
      int j = (int)(paramPluginBaseInfo.mDownloadProgress * 90.0F);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(1000, j, 0).sendToTarget();
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1001, 400L);
      return;
    case 3: 
      if (QLog.isDevelopLevel()) {
        QLog.d("IphoneTitleBarActivity", 4, "[WMBridgeActivity] [handlePluginInfo] PluginInfo.STATE_INSTALLING!");
      }
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(1002);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1001, 400L);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("IphoneTitleBarActivity", 4, "[WMBridgeActivity] [handlePluginInfo] PluginInfo.STATE_INSTALLED!");
    }
    a(-1);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int j = 99;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (QLog.isDevelopLevel()) {
        QLog.d("IphoneTitleBarActivity", 4, "[WMBridgeActivity] [handleMessage] ACTION_UPDATE_PROGRESS!");
      }
      j = Math.min(paramMessage.arg1, 90);
      this.jdField_a_of_type_AndroidWidgetTextView.setText("正在加载(" + j + "%)，大约还需" + a(j));
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(j);
      continue;
      if (QLog.isDevelopLevel()) {
        QLog.d("IphoneTitleBarActivity", 4, "[WMBridgeActivity] [handleMessage] ACTION_INCREMENT!");
      }
      int k = this.jdField_a_of_type_AndroidWidgetProgressBar.getProgress();
      if (k > 99) {}
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText("正在加载(" + j + "%)，大约还需" + a(j));
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(j);
        break;
        j = k + 1;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("IphoneTitleBarActivity", 4, "[WMBridgeActivity] [handleMessage] ACTION_QUERY!");
      }
      if (!isFinishing())
      {
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.queryPlugin(this.e);
        a(this.e, paramMessage);
        continue;
        if (QLog.isDevelopLevel()) {
          QLog.d("IphoneTitleBarActivity", 4, "[WMBridgeActivity] [handleMessage] ACTION_ERROR!");
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText("加载失败");
        Toast.makeText(this, "网络无连接，请检查你的网络连接", 0).show();
      }
    }
  }
  
  protected boolean onBackEvent()
  {
    a(0);
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    this.d = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("plugin_type_key");
    if (this.d.equals("plugin_type_watermark"))
    {
      getWindow().setBackgroundDrawableResource(2131427375);
      this.e = "WaterMarkCamera.apk";
      this.f = g;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(this);
      PluginManagerHelper.getPluginInterface(this, this);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      return;
      if (this.d.equals("plugin_type_video"))
      {
        this.e = "QzoneVideoPlugin.apk";
        this.f = h;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient = paramPluginManagerClient;
    setContentView(2130904535);
    a();
    if (QLog.isDevelopLevel()) {
      QLog.d("IphoneTitleBarActivity", 4, "[WMBridgeActivity] [onCreate] SUPPORT_NETWORKING = false 直接安装本地包!");
    }
    a(-1);
    if (!NetworkUtil.f(getApplicationContext())) {
      Toast.makeText(this, "网络无连接，请检查你的网络连接", 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.PluginDownloadActivity
 * JD-Core Version:    0.7.0.1
 */