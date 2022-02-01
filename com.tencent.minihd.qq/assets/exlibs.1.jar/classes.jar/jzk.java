import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.service.message.MessageFactoryReceiver.UploadStreamStruct;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.qphone.base.util.QLog;

public class jzk
  extends MessageObserver
{
  public jzk(BuddyTransfileProcessor paramBuddyTransfileProcessor) {}
  
  protected void a(boolean paramBoolean, MessageFactoryReceiver.UploadStreamStruct paramUploadStreamStruct)
  {
    if (QLog.isColorLevel()) {
      if ("Stream ptt:onUpdateUploadStreamFinished : isSuccess:" + paramBoolean + " Key:" + paramUploadStreamStruct != null) {
        break label87;
      }
    }
    label87:
    for (String str = "null";; str = paramUploadStreamStruct.jdField_a_of_type_JavaLangString + " FilePath:" + this.a.a.e + " seq:" + paramUploadStreamStruct.jdField_a_of_type_Short + " Layer:" + paramUploadStreamStruct.jdField_a_of_type_Int + " RespCode:" + paramUploadStreamStruct.b + " isStreamPttSuccess:" + this.a.m)
    {
      QLog.e("streamptt.send", 2, str);
      this.a.c(2);
      if ((paramUploadStreamStruct != null) && (paramUploadStreamStruct.jdField_a_of_type_JavaLangString != null) && (paramUploadStreamStruct.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.a.a.e))) {
        break;
      }
      return;
    }
    if (!paramBoolean)
    {
      BuddyTransfileProcessor.a(this.a, false, paramUploadStreamStruct);
      return;
    }
    BuddyTransfileProcessor.a(this.a, true, paramUploadStreamStruct);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jzk
 * JD-Core Version:    0.7.0.1
 */