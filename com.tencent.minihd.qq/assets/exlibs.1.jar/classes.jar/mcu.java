import android.os.Handler;
import cooperation.qzone.music.RemoteMusicManager;
import cooperation.qzone.remote.IActionListener.Stub;
import cooperation.qzone.remote.RecvMsg;

public class mcu
  extends IActionListener.Stub
{
  public mcu(RemoteMusicManager paramRemoteMusicManager) {}
  
  public void onRecvFromMsg(RecvMsg paramRecvMsg)
  {
    if (RemoteMusicManager.access$000(this.a) != null) {
      RemoteMusicManager.access$100(this.a).post(new mcv(this, paramRecvMsg));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mcu
 * JD-Core Version:    0.7.0.1
 */