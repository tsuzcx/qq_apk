import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.mobileqq.app.NearFieldDiscussHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import tencent.im.nearfield_discuss.nearfield_discuss.LBSInfo;

class gwh
  implements Runnable
{
  gwh(gwg paramgwg) {}
  
  public void run()
  {
    nearfield_discuss.LBSInfo localLBSInfo = CreateFaceToFaceDiscussionActivity.a(this.a.a);
    ((NearFieldDiscussHandler)this.a.a.app.a(35)).a(this.a.a.a.toString(), this.a.a.b, localLBSInfo, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gwh
 * JD-Core Version:    0.7.0.1
 */