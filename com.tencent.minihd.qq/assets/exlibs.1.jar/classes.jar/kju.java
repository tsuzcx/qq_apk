import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import org.json.JSONException;
import org.json.JSONObject;

class kju
  implements Runnable
{
  kju(kjt paramkjt) {}
  
  public void run()
  {
    BizTroopHandler localBizTroopHandler = (BizTroopHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21);
    JSONObject localJSONObject;
    if (localBizTroopHandler != null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("entity_id", this.a.jdField_a_of_type_JavaLangString);
      localJSONObject.put("entity_progress", this.a.jdField_a_of_type_Float);
      localJSONObject.put("op_type", this.a.jdField_a_of_type_Int);
      localBizTroopHandler.a(localJSONObject);
      return;
    }
    catch (JSONException localJSONException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kju
 * JD-Core Version:    0.7.0.1
 */