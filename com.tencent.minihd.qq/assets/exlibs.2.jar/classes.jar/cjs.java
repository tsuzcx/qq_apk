import android.os.Bundle;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountMenuResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class cjs
  implements BusinessObserver
{
  public cjs(PublicAccountManager paramPublicAccountManager, NewIntent paramNewIntent, QQAppInterface paramQQAppInterface, String paramString, BusinessObserver paramBusinessObserver) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountManager", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {
      return;
    }
    for (;;)
    {
      try
      {
        for (;;)
        {
          Object localObject2 = paramBundle.getByteArray("data");
          mobileqq_mp.GetPublicAccountMenuResponse localGetPublicAccountMenuResponse = new mobileqq_mp.GetPublicAccountMenuResponse();
          try
          {
            localGetPublicAccountMenuResponse.mergeFrom((byte[])localObject2);
            long l;
            label98:
            int i;
            if (localGetPublicAccountMenuResponse.uin.has())
            {
              l = localGetPublicAccountMenuResponse.uin.get() & 0xFFFFFFFF;
              if (!localGetPublicAccountMenuResponse.seqno.has()) {
                break label222;
              }
              i = localGetPublicAccountMenuResponse.seqno.get();
              label119:
              localObject2 = PublicAccountManager.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
              if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
                break label228;
              }
              paramBundle.putInt("update_type", 1);
              label158:
              j = this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a("" + l);
              if (i == j) {
                break;
              }
            }
            while (localGetPublicAccountMenuResponse != null)
            {
              ThreadManager.b(new cjt(this, localGetPublicAccountMenuResponse, paramInt, paramBoolean, paramBundle));
              return;
              l = 0L;
              break label98;
              label222:
              i = 0;
              break label119;
              label228:
              if (!localGetPublicAccountMenuResponse.update_type.has()) {
                break label265;
              }
              j = localGetPublicAccountMenuResponse.update_type.get();
              paramBundle.putInt("update_type", j);
              break label158;
            }
          }
          catch (Exception localException2) {}
        }
      }
      catch (Exception localException1)
      {
        int j;
        label265:
        Object localObject1 = null;
        continue;
      }
      j = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cjs
 * JD-Core Version:    0.7.0.1
 */