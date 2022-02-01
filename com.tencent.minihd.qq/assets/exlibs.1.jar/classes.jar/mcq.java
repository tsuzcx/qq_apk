import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import cooperation.qzone.music.RemoteMusicManager;
import java.util.ArrayList;

public class mcq
  implements Runnable
{
  public mcq(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin, int paramInt, ArrayList paramArrayList) {}
  
  public void run()
  {
    RemoteMusicManager.getInstance().playMusicList(QzoneWebMusicJsPlugin.access$300(this.jdField_a_of_type_CooperationQzoneMusicQzoneWebMusicJsPlugin), 2, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mcq
 * JD-Core Version:    0.7.0.1
 */