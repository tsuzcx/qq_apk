import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;

public class gbs
  extends SosoInterface.OnLocationListener
{
  public gbs(PublicAccountChatPie paramPublicAccountChatPie, int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    super(paramInt, paramBoolean1, paramLong, paramBoolean2, paramBoolean3, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    double d3 = 0.0D;
    String str;
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null) && (paramSosoLbsInfo.a.jdField_b_of_type_JavaLangString != null))
    {
      str = paramSosoLbsInfo.a.jdField_b_of_type_JavaLangString;
      if ((paramSosoLbsInfo == null) || (paramSosoLbsInfo.a == null)) {
        break label174;
      }
    }
    label174:
    for (double d1 = paramSosoLbsInfo.a.a;; d1 = 0.0D)
    {
      double d2 = d3;
      if (paramSosoLbsInfo != null)
      {
        d2 = d3;
        if (paramSosoLbsInfo.a != null) {
          d2 = paramSosoLbsInfo.a.jdField_b_of_type_Double;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "onLocationUpdate() latitude=" + d1 + " longitude=" + d2 + ", address=" + str);
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, d1, d2, str);
      }
      return;
      str = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gbs
 * JD-Core Version:    0.7.0.1
 */