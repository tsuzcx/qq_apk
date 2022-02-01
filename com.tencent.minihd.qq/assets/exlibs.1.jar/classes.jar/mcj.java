import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import cooperation.qzone.music.RemoteMusicManager;

public class mcj
  implements Runnable
{
  public mcj(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    RemoteMusicManager.getInstance().setPlayMode(this.jdField_a_of_type_CooperationQzoneMusicQzoneWebMusicJsPlugin.mRuntime.a().getLongAccountUin(), this.jdField_a_of_type_Int, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mcj
 * JD-Core Version:    0.7.0.1
 */