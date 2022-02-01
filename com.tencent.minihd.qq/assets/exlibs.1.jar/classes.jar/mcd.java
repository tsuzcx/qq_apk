import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import cooperation.qzone.music.RemoteMusicManager;

public class mcd
  implements Runnable
{
  public mcd(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin) {}
  
  public void run()
  {
    RemoteMusicManager.getInstance().getPlayingSong();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mcd
 * JD-Core Version:    0.7.0.1
 */