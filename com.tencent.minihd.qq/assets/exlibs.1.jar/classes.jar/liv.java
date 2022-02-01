import com.tencent.qav.bussiness.BaseBussinessCtrl;
import com.tencent.qav.channel.VideoChannelSupportCallback;

public class liv
  implements VideoChannelSupportCallback
{
  public liv(BaseBussinessCtrl paramBaseBussinessCtrl) {}
  
  public boolean isMultiVideoMsgSupport(int paramInt)
  {
    return false;
  }
  
  public boolean isSharpVideoMsgSupport(int paramInt)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     liv
 * JD-Core Version:    0.7.0.1
 */