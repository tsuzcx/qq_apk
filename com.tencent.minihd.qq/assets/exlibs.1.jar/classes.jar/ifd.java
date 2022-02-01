import com.tencent.mobileqq.emoticon.SogouEmoji;
import com.tencent.mobileqq.emoticon.SogouEmoji.OnEmojiJsonBackSogou;
import com.tencent.mobileqq.emoticon.SogouEmojiTaskController;
import com.tencent.qphone.base.util.QLog;

public class ifd
  implements SogouEmoji.OnEmojiJsonBackSogou
{
  public ifd(SogouEmoji paramSogouEmoji) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(SogouEmoji.jdField_a_of_type_JavaLangString, 2, "func onEmojiJsonBack begins, taskId:" + paramInt + ",packId:" + paramString1);
    }
    boolean bool = this.a.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmojiTaskController.a(paramInt);
    if (bool) {
      this.a.a(paramString1, paramString2, false);
    }
    if (QLog.isColorLevel()) {
      QLog.d(SogouEmoji.jdField_a_of_type_JavaLangString, 2, "func onEmojiJsonBack ends, isTaskExist:" + bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ifd
 * JD-Core Version:    0.7.0.1
 */