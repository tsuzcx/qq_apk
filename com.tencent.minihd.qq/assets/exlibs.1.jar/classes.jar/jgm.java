import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class jgm
  implements Runnable
{
  public jgm(MultiMsgManager paramMultiMsgManager, ArrayList paramArrayList, HashMap paramHashMap, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface, int paramInt, String paramString) {}
  
  public void run()
  {
    ArrayList localArrayList1 = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
    MultiMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager, System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager.a(this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    MultiMsgManager.a().b("save nick to db ");
    MultiMsgManager.a().c();
    ArrayList localArrayList2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localArrayList1, null);
    MultiMsgManager.a().b("save multimsg to db ");
    MultiMsgManager.a().c();
    ArrayList localArrayList3 = new ArrayList();
    Object localObject1 = localArrayList2.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (MessageRecord)((Iterator)localObject1).next();
      String str;
      if ((localObject2 instanceof MessageForPic))
      {
        str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        localObject2 = PicBusiManager.a(7, (MessageForPic)localObject2, this.jdField_a_of_type_Int, str, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        if (localObject2 != null) {
          localArrayList3.add(localObject2);
        } else if (QLog.isColorLevel()) {
          QLog.e("MultiMsg", 2, "[requestSendMultiMsg]createForwardPicInfo from MessageForPic failed");
        }
      }
      else if ((localObject2 instanceof MessageForMixedMsg))
      {
        str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        localObject2 = PicBusiManager.a(7, (MessageForMixedMsg)localObject2, this.jdField_a_of_type_Int, str, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        if (localObject2 != null) {
          localArrayList3.addAll((Collection)localObject2);
        } else if (QLog.isColorLevel()) {
          QLog.e("MultiMsg", 2, "[requestSendMultiMsg]createForwardPicInfos from MessageForMixedMsg failed");
        }
      }
    }
    localObject1 = (ChatMessage)localArrayList1.get(0);
    if (localObject1 != null) {}
    for (int i = ((ChatMessage)localObject1).istroop;; i = 0)
    {
      if (i == 0) {
        i = 1;
      }
      for (;;)
      {
        int j;
        if (this.jdField_a_of_type_Int == 0) {
          j = 1;
        }
        for (;;)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004660", "0X8004660", 0, 0, i + "", j + "", "" + localArrayList1.size(), "" + localArrayList3.size());
          if (localArrayList3.size() > 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("MultiMsg", 2, "[requestSendMultiMsg]Upload pictures, count is [" + localArrayList3.size() + "], goto requestUploadPics");
            }
            MultiMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null, localArrayList2, localArrayList3);
            return;
            if (i == 3000)
            {
              i = 2;
              break;
            }
            if (i != 1) {
              break label610;
            }
            i = 3;
            break;
            if (this.jdField_a_of_type_Int == 3000)
            {
              j = 2;
              continue;
            }
            if (this.jdField_a_of_type_Int != 1) {
              break label605;
            }
            j = 3;
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg", 2, "[requestSendMultiMsg]There's not any picture messages, goto onPackAndSendMsg");
          }
          MultiMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null, localArrayList2, true);
          return;
          label605:
          j = 4;
        }
        label610:
        i = 4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jgm
 * JD-Core Version:    0.7.0.1
 */