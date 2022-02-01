import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;

class clh
  implements Runnable
{
  clh(clg paramclg, boolean paramBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    j = 0;
    int k = 0;
    i = 0;
    if (this.jdField_a_of_type_Boolean) {}
    for (i = j;; i = 0) {
      for (;;)
      {
        try
        {
          localObject4 = this.jdField_a_of_type_AndroidOsBundle.getByteArray("data");
          if (localObject4 == null) {
            break label402;
          }
          i = j;
          localGetPublicAccountDetailInfoResponse = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
          i = j;
          localGetPublicAccountDetailInfoResponse.mergeFrom((byte[])localObject4);
          i = j;
          if (!localGetPublicAccountDetailInfoResponse.ret_info.has()) {
            break label402;
          }
          i = j;
          if (!((mobileqq_mp.RetInfo)localGetPublicAccountDetailInfoResponse.ret_info.get()).ret_code.has()) {
            break label402;
          }
          i = j;
          if (((mobileqq_mp.RetInfo)localGetPublicAccountDetailInfoResponse.ret_info.get()).ret_code.get() != 0) {
            break label402;
          }
          i = j;
          localObject4 = new AccountDetail(localGetPublicAccountDetailInfoResponse);
          i = j;
          Object localObject5 = this.jdField_a_of_type_Clg.a.a(this.jdField_a_of_type_Clg.a.getAccount()).createEntityManager();
          if (localObject5 == null) {
            break label402;
          }
          i = j;
          ((EntityManager)localObject5).b((Entity)localObject4);
          if (localObject4 != null)
          {
            i = j;
            if (((AccountDetail)localObject4).followType == 1)
            {
              i = j;
              localObject5 = (PublicAccountDataManager)this.jdField_a_of_type_Clg.a.getManager(54);
              if (localObject5 != null)
              {
                i = j;
                if (((PublicAccountDataManager)localObject5).a(((AccountDetail)localObject4).uin) == null)
                {
                  i = j;
                  ((PublicAccountDataManager)localObject5).a(PublicAccountInfo.createPublicAccount((AccountDetail)localObject4, 0L));
                }
              }
            }
          }
          i = j;
          j = k;
        }
        catch (Exception localException)
        {
          Object localObject4;
          mobileqq_mp.GetPublicAccountDetailInfoResponse localGetPublicAccountDetailInfoResponse;
          label376:
          continue;
        }
        for (;;)
        {
          try
          {
            if (PublicAccountUtil.a != null)
            {
              j = k;
              PublicAccountUtil.a.sendEmptyMessage(36);
              i = 1;
            }
          }
          finally
          {
            i = j;
            break label376;
          }
          try
          {
            if ((PublicAccountUtil.a() != null) && (localGetPublicAccountDetailInfoResponse.uin.has()))
            {
              localObject4 = Message.obtain();
              ((Message)localObject4).obj = String.valueOf(localGetPublicAccountDetailInfoResponse.uin.get());
              ((Message)localObject4).what = 200;
              PublicAccountUtil.a().sendMessage((Message)localObject4);
            }
            if (i != 0) {}
          }
          finally
          {
            break label376;
          }
          try
          {
            if (PublicAccountUtil.a != null) {
              PublicAccountUtil.a.sendEmptyMessage(36);
            }
            return;
          }
          finally {}
        }
        j = k;
        localObject4 = this.jdField_a_of_type_Clg.a.a(Conversation.class);
        if (localObject4 == null) {
          break;
        }
        j = k;
        ((Handler)localObject4).sendEmptyMessage(1014);
        break;
        j = i;
        throw localGetPublicAccountDetailInfoResponse;
        label402:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     clh
 * JD-Core Version:    0.7.0.1
 */