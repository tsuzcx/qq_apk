import com.tencent.mobileqq.app.EmosmHandler;
import com.tencent.mobileqq.app.EmosmHandler.EmosmHandlerListener;
import com.tencent.mobileqq.app.EmoticonManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmosmResp;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class hjf
  implements EmosmHandler.EmosmHandlerListener
{
  public hjf(EmoticonManagerImp paramEmoticonManagerImp, EmosmHandler paramEmosmHandler) {}
  
  public void a(boolean paramBoolean, int paramInt, EmosmResp paramEmosmResp)
  {
    Object localObject;
    if ((paramInt == 2) && (paramBoolean == true))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppEmosmHandler.b(this);
      localObject = paramEmosmResp.data;
      ((List)localObject).addAll(paramEmosmResp.magicData);
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManagerImp", 2, "getEmosmList respone in updateEmoticonAuth,rlistSuze=" + ((List)localObject).size());
      }
    }
    for (;;)
    {
      int i;
      try
      {
        paramEmosmResp = new ArrayList();
        i = 0;
        paramInt = 0;
        if (i < ((List)localObject).size())
        {
          EmoticonPackage localEmoticonPackage1 = (EmoticonPackage)((List)localObject).get(i);
          this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp.jdField_a_of_type_JavaUtilMap.put(localEmoticonPackage1.epId, localEmoticonPackage1);
          EmoticonPackage localEmoticonPackage2 = this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp.b(localEmoticonPackage1.epId);
          if ((localEmoticonPackage2 == null) || ((localEmoticonPackage2.valid == localEmoticonPackage1.valid) && (localEmoticonPackage2.wordingId == localEmoticonPackage1.wordingId))) {
            break label363;
          }
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonManagerImp", 2, "update EmosmList in updateEmoticonAuth,epid=" + localEmoticonPackage2.epId + ";valid=" + localEmoticonPackage2.valid + ";wordingId=" + localEmoticonPackage2.wordingId);
          }
          localEmoticonPackage2.expiretime = localEmoticonPackage1.expiretime;
          localEmoticonPackage2.valid = localEmoticonPackage1.valid;
          localEmoticonPackage2.wordingId = localEmoticonPackage1.wordingId;
          paramEmosmResp.add(localEmoticonPackage2);
          paramInt = 1;
          break label363;
        }
        if (paramInt != 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp.a(paramEmosmResp);
          localObject = (EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42);
          paramEmosmResp = paramEmosmResp.iterator();
          if (paramEmosmResp.hasNext())
          {
            ((EmojiManager)localObject).b((EmoticonPackage)paramEmosmResp.next());
            continue;
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramEmosmResp)
      {
        paramEmosmResp.printStackTrace();
      }
      EmoticonManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp, true, 300L);
      return;
      label363:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hjf
 * JD-Core Version:    0.7.0.1
 */