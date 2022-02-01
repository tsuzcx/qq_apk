import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import cooperation.qzone.music.RemoteMusicManager;

public class mcr
  implements Runnable
{
  public mcr(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin) {}
  
  public void run()
  {
    RemoteMusicManager.getInstance().resumePlay();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mcr
 * JD-Core Version:    0.7.0.1
 */