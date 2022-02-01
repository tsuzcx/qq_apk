import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecommendContact;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;

public class hmj
  implements Runnable
{
  public hmj(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "deleteRecommendList ");
    }
    PhoneContactManagerImp.a(this.a).a(RecommendContact.class);
    this.a.a.clear();
    this.a.j();
    ((NewFriendManager)PhoneContactManagerImp.a(this.a).getManager(33)).d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hmj
 * JD-Core Version:    0.7.0.1
 */