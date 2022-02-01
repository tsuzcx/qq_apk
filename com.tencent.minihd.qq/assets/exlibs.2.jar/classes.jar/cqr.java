import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.webviewplugin.SosoPlugin;
import com.tencent.qphone.base.util.QLog;

public class cqr
  implements AsyncBack
{
  public cqr(SosoPlugin paramSosoPlugin) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(SosoPlugin.c(this.a), 2, "get offline format white list, loaded, code : " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cqr
 * JD-Core Version:    0.7.0.1
 */