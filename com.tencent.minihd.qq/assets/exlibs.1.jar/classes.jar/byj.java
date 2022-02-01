import com.rookery.asyncHttpClient.JsonHttpResponseHandler;
import com.rookery.translate.google.GoogleTranslator;
import com.rookery.translate.type.Language;
import com.rookery.translate.type.TranslateError;
import com.rookery.translate.type.TranslateWithTimeCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class byj
  extends JsonHttpResponseHandler
{
  public byj(GoogleTranslator paramGoogleTranslator, TranslateWithTimeCallback paramTranslateWithTimeCallback, Long paramLong) {}
  
  public void a(int paramInt, Header[] paramArrayOfHeader, JSONArray paramJSONArray)
  {
    if (QLog.isColorLevel()) {
      QLog.e("GoogleTranslator", 2, "[ERROR][SHOULD NOT GO HERE][onSuccess] statusCode:" + paramInt);
    }
  }
  
  public void a(int paramInt, Header[] paramArrayOfHeader, JSONObject paramJSONObject)
  {
    paramArrayOfHeader = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("data");
      if (paramJSONObject != null)
      {
        paramJSONObject = paramJSONObject.getJSONArray("translations");
        if (paramJSONObject != null)
        {
          paramInt = 0;
          while (paramInt < paramJSONObject.length())
          {
            String str1 = ((JSONObject)paramJSONObject.get(paramInt)).getString("translatedText");
            String str2 = ((JSONObject)paramJSONObject.get(paramInt)).getString("detectedSourceLanguage");
            if ((paramArrayOfHeader != null) && (localArrayList != null))
            {
              paramArrayOfHeader.add(Language.fromString(str2));
              localArrayList.add(str1);
            }
            paramInt += 1;
          }
        }
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      this.jdField_a_of_type_ComRookeryTranslateTypeTranslateWithTimeCallback.a(paramArrayOfHeader, localArrayList, this.jdField_a_of_type_JavaLangLong);
    }
  }
  
  public void a(Throwable paramThrowable, String paramString)
  {
    this.jdField_a_of_type_ComRookeryTranslateTypeTranslateWithTimeCallback.a(new TranslateError(paramThrowable), this.jdField_a_of_type_JavaLangLong);
    if (QLog.isColorLevel()) {
      QLog.e("GoogleTranslator", 2, " [onFailure][GoogleTranslateClient] Throwable:" + paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     byj
 * JD-Core Version:    0.7.0.1
 */