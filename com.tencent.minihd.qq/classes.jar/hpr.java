import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.RichStatus.SigZanInfo;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class hpr
  implements Runnable
{
  public hpr(RichStatus paramRichStatus, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    long l3 = System.currentTimeMillis();
    Object localObject3;
    long l1;
    for (;;)
    {
      try
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
        if (localObject3 != null) {
          break label1596;
        }
        localObject1 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49)).a(this.jdField_a_of_type_JavaLangString);
        if (localObject1 == null) {
          return;
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        boolean bool;
        label222:
        return;
        return;
        localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
        if (localObject5 != null) {
          continue;
        }
        return;
        localObject4 = new JSONObject();
        try
        {
          ((JSONObject)localObject4).put("ver", "1.0");
          ((JSONObject)localObject4).put("time", String.valueOf(((RichStatus)localObject3).jdField_a_of_type_Long));
          if ((((RichStatus)localObject3).jdField_c_of_type_JavaLangString != null) && (((RichStatus)localObject3).jdField_c_of_type_JavaLangString.trim().length() > 0))
          {
            ((JSONObject)localObject4).put("aid", String.valueOf(((RichStatus)localObject3).b));
            ((JSONObject)localObject4).put("actiontext", ((RichStatus)localObject3).jdField_c_of_type_JavaLangString);
          }
          if ((((RichStatus)localObject3).jdField_d_of_type_JavaLangString != null) && (((RichStatus)localObject3).jdField_d_of_type_JavaLangString.trim().length() > 0))
          {
            ((JSONObject)localObject4).put("did", String.valueOf(((RichStatus)localObject3).jdField_c_of_type_Int));
            ((JSONObject)localObject4).put("datatext", ((RichStatus)localObject3).jdField_d_of_type_JavaLangString);
          }
          ((JSONObject)localObject4).put("loctextpos", String.valueOf(((RichStatus)localObject3).g));
          if ((((RichStatus)localObject3).jdField_a_of_type_JavaUtilArrayList != null) && (((RichStatus)localObject3).jdField_a_of_type_JavaUtilArrayList.size() > 0))
          {
            j = ((RichStatus)localObject3).jdField_a_of_type_JavaUtilArrayList.size();
            localObject6 = new JSONArray();
            i = 0;
            if (i < j)
            {
              str = (String)((RichStatus)localObject3).jdField_a_of_type_JavaUtilArrayList.get(i);
              if (str == null) {
                break label1602;
              }
              ((JSONArray)localObject6).put(str);
              break label1602;
            }
            if (((JSONArray)localObject6).length() > 0) {
              ((JSONObject)localObject4).put("plaintext", localObject6);
            }
          }
          if ((((RichStatus)localObject3).e != null) && (((RichStatus)localObject3).e.trim().length() > 0)) {
            ((JSONObject)localObject4).put("loctext", ((RichStatus)localObject3).e);
          }
          if (!TextUtils.isEmpty(((RichStatus)localObject3).f)) {
            ((JSONObject)localObject4).put("feedid", ((RichStatus)localObject3).f);
          }
          ((JSONObject)localObject4).put("tplid", ((RichStatus)localObject3).jdField_d_of_type_Int);
          k = 0;
          m = 0;
          j = m;
          i = k;
          if (((RichStatus)localObject3).jdField_a_of_type_JavaUtilHashMap != null)
          {
            j = m;
            i = k;
            if (((RichStatus)localObject3).jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(255)) != null)
            {
              i = ((RichStatus.SigZanInfo)((RichStatus)localObject3).jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(255))).b;
              j = ((RichStatus.SigZanInfo)((RichStatus)localObject3).jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(255))).jdField_c_of_type_Int;
            }
          }
          ((JSONObject)localObject4).put("count", i);
          ((JSONObject)localObject4).put("zanfalg", j);
          if (((JSONObject)localObject4).length() > 3) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("SignatureManager", 2, "sign is empty,rs.actionText is:" + ((RichStatus)localObject3).jdField_c_of_type_JavaLangString + ",rs.dataText is:" + ((RichStatus)localObject3).jdField_d_of_type_JavaLangString + ",rs.plainText is:" + ((RichStatus)localObject3).jdField_a_of_type_JavaUtilArrayList + ",rs.locationText is:" + ((RichStatus)localObject3).e);
          }
          return;
        }
        catch (JSONException localJSONException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SignatureManager", 2, "insertSignMsgIfNeeded failed,error msg is:" + localJSONException.getMessage(), localJSONException);
          }
        }
        return;
        localObject4 = ((JSONObject)localObject4).toString();
        long l2 = ((RichStatus)localObject3).jdField_a_of_type_Long;
        localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, ((RecentUser)localObject5).type);
        l1 = l2;
        if (localObject5 == null) {
          continue;
        }
        l1 = l2;
        if (((List)localObject5).size() <= 0) {
          continue;
        }
        l1 = ((MessageRecord)((List)localObject5).get(((List)localObject5).size() - 1)).time;
        localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, 0, new int[] { -1034 });
        if (localObject5 == null) {
          break label1362;
        }
        localObject5 = ((List)localObject5).iterator();
        if (!((Iterator)localObject5).hasNext()) {
          break label1362;
        }
        localObject6 = (MessageRecord)((Iterator)localObject5).next();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((MessageRecord)localObject6).frienduin, ((MessageRecord)localObject6).istroop, ((MessageRecord)localObject6).uniseq);
        continue;
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SignatureManager", 2, "insert signature cost:" + (System.currentTimeMillis() - l3) + " ms");
      }
      bool = ((ExtensionInfo)localObject1).isAdded2C2C;
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SignatureManager", 2, "insert signature cost:" + (System.currentTimeMillis() - l3) + " ms");
        }
      }
      else
      {
        l1 = NetConnInfoCenter.getServerTime();
        l2 = ((ExtensionInfo)localObject1).richTime;
        l1 -= l2;
        if ((l1 > 0L) && (l1 >= 604800L))
        {
          if (QLog.isColorLevel()) {
            QLog.d("SignatureManager", 2, "insert signature cost:" + (System.currentTimeMillis() - l3) + " ms");
          }
        }
        else
        {
          localObject3 = ((ExtensionInfo)localObject1).getRichStatus();
          if ((((RichStatus)localObject3).a()) || (TextUtils.isEmpty(((RichStatus)localObject3).f)))
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, 0, new int[] { -1034 });
            if (localObject1 != null)
            {
              localObject1 = ((List)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject3 = (MessageRecord)((Iterator)localObject1).next();
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject3).frienduin, 0, ((MessageRecord)localObject3).msgtype, ((MessageRecord)localObject3).uniseq);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((MessageRecord)localObject3).frienduin, ((MessageRecord)localObject3).istroop, ((MessageRecord)localObject3).uniseq);
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      Object localObject4;
      int j;
      Object localObject6;
      int i;
      String str;
      int k;
      int m;
      label1362:
      Object localObject5 = MessageRecordFactory.a(-1034);
      ((MessageRecord)localObject5).init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, (String)localObject4, l1, -1034, 0, l1);
      ((MessageRecord)localObject5).isread = true;
      if (QLog.isColorLevel()) {
        QLog.d("SignatureManager", 2, "----------addFriendFeedMsg  friendUin: " + this.jdField_a_of_type_JavaLangString + " msgTime: " + ((MessageRecord)localObject5).time);
      }
      if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject5, false))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject5, ((MessageRecord)localObject5).selfuin);
        if (localExtensionInfo != null)
        {
          localExtensionInfo.isAdded2C2C = true;
          ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49)).a(localExtensionInfo);
        }
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "signature", "aio_sig_show", 0, 0, String.valueOf(((RichStatus)localObject3).jdField_d_of_type_Int), "", "", "");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SignatureManager", 2, "insert signature cost:" + (System.currentTimeMillis() - l3) + " ms");
      return;
      label1596:
      Object localObject2 = null;
      break label222;
      label1602:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hpr
 * JD-Core Version:    0.7.0.1
 */