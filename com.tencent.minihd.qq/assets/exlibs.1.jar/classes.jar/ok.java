import com.qqreader.QRBridgeActivity;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import cooperation.plugin.IPluginManager;

public class ok
  extends OnPluginInstallListener.Stub
{
  public ok(QRBridgeActivity paramQRBridgeActivity, String paramString) {}
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    IPluginManager.a(String.valueOf(paramInt), "阅读中心");
    this.jdField_a_of_type_ComQqreaderQRBridgeActivity.finish();
  }
  
  public void onInstallFinish(String paramString)
  {
    this.jdField_a_of_type_ComQqreaderQRBridgeActivity.b(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ok
 * JD-Core Version:    0.7.0.1
 */