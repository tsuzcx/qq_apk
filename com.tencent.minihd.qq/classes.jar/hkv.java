import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.LifeOnlineAccountInfo;
import com.tencent.mobileqq.app.LifeOnlineAccountInfoManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class hkv
  implements Runnable
{
  public hkv(LifeOnlineAccountInfoManager paramLifeOnlineAccountInfoManager) {}
  
  public void run()
  {
    if (LifeOnlineAccountInfoManager.jdField_a_of_type_Long == 0L) {
      return;
    }
    Object localObject = this.a.a(LifeOnlineAccountInfoManager.jdField_a_of_type_Long);
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d("LifeOnlineAccountInfoManager", 2, "-------list is null!!!");
      }
    }
    for (;;)
    {
      this.a.b();
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        LifeOnlineAccountInfo localLifeOnlineAccountInfo = (LifeOnlineAccountInfo)((Iterator)localObject).next();
        if (localLifeOnlineAccountInfo == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("LifeOnlineAccountInfoManager", 2, "LifeOnlineAccountInfo is null!!!");
          }
        }
        else if (localLifeOnlineAccountInfo.pstate != 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("LifeOnlineAccountInfoManager", 2, "info.pstate != LifeOnlineAccountInfo.PRE_MSG_NORMAL");
          }
        }
        else if (HttpUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication())) {
          this.a.a(localLifeOnlineAccountInfo);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hkv
 * JD-Core Version:    0.7.0.1
 */