import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.mobileqq.app.NearFieldDiscussHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import tencent.im.nearfield_discuss.nearfield_discuss.LBSInfo;

public class gwc
  implements Runnable
{
  public gwc(CreateFaceToFaceDiscussionActivity paramCreateFaceToFaceDiscussionActivity) {}
  
  public void run()
  {
    NearFieldDiscussHandler localNearFieldDiscussHandler = (NearFieldDiscussHandler)this.a.app.a(35);
    nearfield_discuss.LBSInfo localLBSInfo = CreateFaceToFaceDiscussionActivity.a(this.a);
    localNearFieldDiscussHandler.a(this.a.a.toString(), this.a.b, localLBSInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gwc
 * JD-Core Version:    0.7.0.1
 */