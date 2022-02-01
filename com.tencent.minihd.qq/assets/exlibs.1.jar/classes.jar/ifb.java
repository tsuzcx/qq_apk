import com.tencent.mobileqq.app.EmosmHandler;
import com.tencent.mobileqq.app.EmosmHandler.EmosmHandlerListener;
import com.tencent.mobileqq.data.EmosmResp;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.ReqInfo;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ifb
  implements EmosmHandler.EmosmHandlerListener
{
  public ifb(EmojiManager paramEmojiManager, ReqInfo paramReqInfo, EmosmHandler paramEmosmHandler, boolean paramBoolean, ArrayList paramArrayList, Object paramObject) {}
  
  public void a(boolean paramBoolean, int paramInt, EmosmResp paramEmosmResp)
  {
    int i = paramEmosmResp.epId;
    int j = paramEmosmResp.timestamp;
    Object localObject1 = (ArrayList)paramEmosmResp.data;
    Object localObject3;
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonReqInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonReqInfo.jdField_a_of_type_JavaLangString.equals(paramEmosmResp.keySeq)))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppEmosmHandler.b(this);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.jdField_a_of_type_JavaUtilArrayList.remove(this);
      if (!paramBoolean) {
        break label281;
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        ??? = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)???).hasNext())
        {
          localObject3 = (Emoticon)((Iterator)???).next();
          this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a().a((Emoticon)localObject3);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonReqInfo.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonReqInfo.jdField_a_of_type_Int = paramEmosmResp.resultcode;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonReqInfo.b = paramEmosmResp.timeoutReason;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaLangObject.notify();
        if (QLog.isColorLevel())
        {
          ??? = this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.jdField_a_of_type_JavaLangString;
          localObject3 = new StringBuilder().append("fetchEmoticonEncryptKeys|net get key backepId=").append(i).append(" tstamp=").append(j).append(" list.size=");
          if (localObject1 == null)
          {
            localObject1 = "null";
            QLog.d((String)???, 2, localObject1 + " encryptSuccess=" + paramBoolean + " type=" + paramInt + " er.resultCode=" + paramEmosmResp.resultcode);
          }
        }
        else
        {
          return;
          label281:
          this.jdField_a_of_type_ComTencentMobileqqEmoticonReqInfo.jdField_a_of_type_Boolean = false;
        }
      }
      localObject1 = Integer.valueOf(((ArrayList)localObject1).size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ifb
 * JD-Core Version:    0.7.0.1
 */