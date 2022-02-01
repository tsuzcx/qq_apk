package cooperation.qwallet.plugin.proxy;

import android.content.Intent;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import cooperation.thirdpay.NFCPayPluginProxyActivity;

public class QWalletPluginProxyActivity
  extends PluginProxyActivity
{
  public String getPluginID()
  {
    return "qwallet_plugin.apk";
  }
  
  protected Class getProxyActivity(String paramString)
  {
    if ("com.qwallet.QvipPayWalletActivity".equals(paramString)) {
      return QWalletPluginHomeProxyActivity.class;
    }
    if ("cooperation.thirdpay.CardPayPluginProxyActivity".equals(paramString)) {
      return NFCPayPluginProxyActivity.class;
    }
    return QWalletPluginProxyActivity.class;
  }
  
  protected boolean isWrapContent()
  {
    boolean bool = false;
    if (getIntent() != null) {
      bool = getIntent().getBooleanExtra("QWalletExtra.isFling", false);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qwallet.plugin.proxy.QWalletPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */