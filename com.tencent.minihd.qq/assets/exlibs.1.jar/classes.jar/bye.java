import android.content.Context;
import com.rookery.asyncHttpClient.AsyncHttpResponseHandler;
import com.rookery.translate.AITranslator;
import com.rookery.translate.AITranslator.TranslatorType;
import com.tencent.qphone.base.util.QLog;
import org.apache.http.Header;

public class bye
  extends AsyncHttpResponseHandler
{
  public bye(AITranslator paramAITranslator, Context paramContext) {}
  
  public void a(int paramInt, Header[] paramArrayOfHeader, String paramString)
  {
    if (paramString.equalsIgnoreCase("1"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Translator", 2, "[policy update]: GOOGLE");
      }
      AITranslator.a(this.jdField_a_of_type_ComRookeryTranslateAITranslator, this.jdField_a_of_type_AndroidContentContext, Boolean.valueOf(true));
      AITranslator.a(this.jdField_a_of_type_ComRookeryTranslateAITranslator, this.jdField_a_of_type_AndroidContentContext, AITranslator.TranslatorType.GOOGLE, 0L);
      AITranslator.a(this.jdField_a_of_type_ComRookeryTranslateAITranslator, this.jdField_a_of_type_AndroidContentContext, AITranslator.TranslatorType.MS, 200000L);
    }
    do
    {
      return;
      if (paramString.equals("2"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Translator", 2, "[policy update]: MS");
        }
        AITranslator.a(this.jdField_a_of_type_ComRookeryTranslateAITranslator, this.jdField_a_of_type_AndroidContentContext, Boolean.valueOf(true));
        AITranslator.a(this.jdField_a_of_type_ComRookeryTranslateAITranslator, this.jdField_a_of_type_AndroidContentContext, AITranslator.TranslatorType.MS, 0L);
        AITranslator.a(this.jdField_a_of_type_ComRookeryTranslateAITranslator, this.jdField_a_of_type_AndroidContentContext, AITranslator.TranslatorType.GOOGLE, 200000L);
        return;
      }
      if (paramString.equals("0"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Translator", 2, "[policy update]: stop service");
        }
        AITranslator.a(this.jdField_a_of_type_ComRookeryTranslateAITranslator, this.jdField_a_of_type_AndroidContentContext, Boolean.valueOf(false));
        return;
      }
      if (paramString.equals("3"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Translator", 2, "[policy update]: decide by Client");
        }
        AITranslator.a(this.jdField_a_of_type_ComRookeryTranslateAITranslator, this.jdField_a_of_type_AndroidContentContext, Boolean.valueOf(true));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Translator", 2, "[policy update]: Update Failed");
  }
  
  public void a(Throwable paramThrowable, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Translator", 2, "update policy error" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bye
 * JD-Core Version:    0.7.0.1
 */