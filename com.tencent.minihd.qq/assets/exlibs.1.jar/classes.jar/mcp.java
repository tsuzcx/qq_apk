import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import cooperation.qzone.music.RemoteMusicManager;
import java.util.ArrayList;

public class mcp
  implements Runnable
{
  public mcp(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin, ArrayList paramArrayList) {}
  
  public void run()
  {
    RemoteMusicManager.getInstance().playMusicList(QzoneWebMusicJsPlugin.access$300(this.jdField_a_of_type_CooperationQzoneMusicQzoneWebMusicJsPlugin), 1, 0, this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mcp
 * JD-Core Version:    0.7.0.1
 */