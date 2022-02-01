package cooperation.qwallet.plugin;

import android.os.Bundle;
import android.view.Window;
import com.tencent.mobileqq.activity.QQBasePluginActivity;
import cooperation.qwallet.plugin.proxy.BuscardLoadNFCProxyActivity;
import cooperation.qwallet.plugin.proxy.QWalletNFCProxyActivity;
import cooperation.thirdpay.ThirdPayPluginProxyActivity;

public class QWalletPluginProxyActivity
  extends QQBasePluginActivity
{
  public boolean c()
  {
    return false;
  }
  
  public String getPluginID()
  {
    return "qwallet_plugin.apk";
  }
  
  protected Class getProxyActivity(String paramString)
  {
    if ("cooperation.thirdpay.CardPayPluginProxyActivity".equals(paramString)) {
      return ThirdPayPluginProxyActivity.class;
    }
    if ("com.tenpay.android.qqplugin.activity.BusCardActivity".equals(paramString)) {
      return QWalletNFCProxyActivity.class;
    }
    if ("com.tenpay.android.qqplugin.activity.RedepositActivity".equals(paramString)) {
      return BuscardLoadNFCProxyActivity.class;
    }
    return QWalletPluginProxyActivity.class;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setWindowAnimations(2131559070);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qwallet.plugin.QWalletPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */