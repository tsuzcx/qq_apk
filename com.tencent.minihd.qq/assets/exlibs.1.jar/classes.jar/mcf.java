import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import cooperation.qzone.music.RemoteMusicManager;

public class mcf
  implements Runnable
{
  public mcf(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin) {}
  
  public void run()
  {
    RemoteMusicManager.getInstance().getPlayMode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mcf
 * JD-Core Version:    0.7.0.1
 */