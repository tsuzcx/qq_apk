import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.DatingFeedActivity;
import com.tencent.mobileqq.dating.DatingHandler;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.service.message.MessageCache;

public class ibj
  implements Runnable
{
  public ibj(DatingFeedActivity paramDatingFeedActivity) {}
  
  public void run()
  {
    DatingHandler localDatingHandler = (DatingHandler)this.a.app.a(40);
    this.a.app.e(true);
    DatingManager localDatingManager = (DatingManager)this.a.app.getManager(67);
    if (localDatingManager.f != 1)
    {
      DatingUtil.b("need turn on dating_msg switch", new Object[] { Byte.valueOf(localDatingManager.f) });
      localDatingHandler.a((byte)0);
    }
    int i = (int)MessageCache.a();
    int j = localDatingManager.a(0);
    if (i - j > localDatingManager.a(1)) {
      localDatingHandler.a(j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ibj
 * JD-Core Version:    0.7.0.1
 */