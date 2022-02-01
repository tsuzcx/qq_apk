import android.os.Handler;
import android.os.Message;
import android.widget.EditText;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.EmoticonManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonKeyword;
import com.tencent.mobileqq.data.EmoticonKeywordForCloud;
import com.tencent.mobileqq.emoticonview.EmotionPreviewLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class igs
  implements URLDrawable.URLDrawableListener
{
  public igs(EmotionPreviewLayout paramEmotionPreviewLayout) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if ((this.a.jdField_a_of_type_AndroidWidgetEditText == null) || (this.a.b == null) || (!this.a.b.equals(this.a.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString()))) {
      return;
    }
    EmoticonKeywordForCloud localEmoticonKeywordForCloud = (EmoticonKeywordForCloud)paramURLDrawable.getTag();
    if (localEmoticonKeywordForCloud != null)
    {
      paramURLDrawable.setTag(localEmoticonKeywordForCloud);
      localEmoticonKeywordForCloud.loadedType = 3;
      if (QLog.isColorLevel())
      {
        paramThrowable = EmotionPreviewLayout.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder().append("emotion onLoadFialed, keyword:").append(this.a.b).append(", epid_eid:");
        if (localEmoticonKeywordForCloud.epId == null) {
          break label236;
        }
        paramURLDrawable = localEmoticonKeywordForCloud.epId;
        label120:
        localStringBuilder = localStringBuilder.append(paramURLDrawable).append("_");
        if (localEmoticonKeywordForCloud.eId == null) {
          break label242;
        }
        paramURLDrawable = localEmoticonKeywordForCloud.eId;
        label145:
        QLog.e(paramThrowable, 2, paramURLDrawable);
      }
    }
    for (;;)
    {
      paramURLDrawable = this.a;
      paramURLDrawable.g -= 1;
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.a.jdField_a_of_type_AndroidOsHandler, 10002));
      if (this.a.g != 0) {
        break;
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(Message.obtain(this.a.jdField_a_of_type_AndroidOsHandler, 10000), 3000L);
      return;
      label236:
      paramURLDrawable = "~";
      break label120;
      label242:
      paramURLDrawable = "~";
      break label145;
      if (QLog.isColorLevel()) {
        QLog.e(EmotionPreviewLayout.jdField_a_of_type_JavaLangString, 2, "emotion onLoadFialed, k:null, keyword:" + this.a.b);
      }
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if ((this.a.jdField_a_of_type_AndroidWidgetEditText == null) || (this.a.b == null) || (!this.a.b.equals(this.a.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString()))) {
      return;
    }
    paramURLDrawable = (EmoticonKeywordForCloud)paramURLDrawable.getTag();
    Object localObject;
    if (paramURLDrawable != null)
    {
      paramURLDrawable.loadedType = 2;
      if (this.a.jdField_a_of_type_JavaUtilList == null) {
        break label234;
      }
      localObject = this.a.jdField_a_of_type_JavaUtilList.iterator();
      EmoticonKeyword localEmoticonKeyword;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localEmoticonKeyword = (EmoticonKeyword)((Iterator)localObject).next();
      } while ((!localEmoticonKeyword.eId.equals(paramURLDrawable.eId)) || (!localEmoticonKeyword.epId.equals(paramURLDrawable.epId)));
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.a.jdField_a_of_type_JavaUtilList.add(paramURLDrawable);
      }
      for (;;)
      {
        paramURLDrawable = this.a;
        paramURLDrawable.g -= 1;
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.a.jdField_a_of_type_AndroidOsHandler, 10002));
        if (this.a.g != 0) {
          break;
        }
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(Message.obtain(this.a.jdField_a_of_type_AndroidOsHandler, 10000), 3000L);
        return;
        label234:
        localObject = (EmoticonManagerImp)EmotionPreviewLayout.a(this.a).getManager(13);
        if (localObject != null)
        {
          ((EmoticonManagerImp)localObject).b(paramURLDrawable);
          ((EmoticonManagerImp)localObject).a(paramURLDrawable);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     igs
 * JD-Core Version:    0.7.0.1
 */