import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.SystemMsgController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class iic
  implements Runnable
{
  public iic(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  public void run()
  {
    Object localObject = new ArrayList();
    ((List)localObject).addAll(this.a.jdField_e_of_type_JavaUtilList);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.a, 2, "systemMsgAIODataReadConfirm, mNewAddFriendUinList");
      }
      SystemMsgController.a().a(Long.parseLong(str), this.a.app);
    }
    if ((this.a.jdField_e_of_type_Boolean) && (this.a.f))
    {
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.a, 2, "clearSystemMsgData");
      }
      this.a.app.a(new iid(this));
      Face2FaceAddFriendActivity.a(this.a.app);
      FriendSystemMsgController.a().a(this.a.app, 0);
      FriendSystemMsgController.a().a(this.a.app);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iic
 * JD-Core Version:    0.7.0.1
 */