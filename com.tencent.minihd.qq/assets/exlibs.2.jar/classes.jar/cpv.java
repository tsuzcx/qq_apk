import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.common.util.LoadedCallBack;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;

public class cpv
  implements LoadedCallBack
{
  public cpv(OfflinePlugin paramOfflinePlugin, JsBridgeListener paramJsBridgeListener) {}
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginJsBridgeListener.a(" { retcode: -1, msg: 'error' }");
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 121;
    localMessage.obj = new Object[] { this.jdField_a_of_type_ComTencentMobileqqWebviewpluginJsBridgeListener, paramString };
    this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cpv
 * JD-Core Version:    0.7.0.1
 */