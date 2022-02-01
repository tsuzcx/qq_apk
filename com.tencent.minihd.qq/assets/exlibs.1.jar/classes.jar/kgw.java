import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.troop.activity.TroopBarUploadManagerActivity;
import com.tencent.mobileqq.troop.data.TroopBarUploadItemEntity;
import com.tencent.mobileqq.widget.SlideDetectListView;
import org.json.JSONObject;

public class kgw
  extends Handler
{
  public kgw(TroopBarUploadManagerActivity paramTroopBarUploadManagerActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    Message localMessage = null;
    String str;
    switch (paramMessage.what)
    {
    default: 
    case 1: 
      float f;
      int i;
      do
      {
        do
        {
          do
          {
            return;
          } while (paramMessage.obj == null);
          paramMessage = (JSONObject)paramMessage.obj;
          str = paramMessage.optString("entity_id");
          f = (float)paramMessage.optDouble("entity_progress", 0.0D);
          i = paramMessage.optInt("op_type");
        } while (this.a.jdField_a_of_type_Khd == null);
        if (i == 1)
        {
          TroopBarUploadManagerActivity.a(this.a, paramMessage.optString("entity_id"));
          return;
        }
        if (i == 2)
        {
          this.a.jdField_a_of_type_Khd.a(str);
          return;
        }
      } while (i != 0);
      this.a.jdField_a_of_type_Khd.a(str, f);
      return;
    case 2: 
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.a.jdField_a_of_type_Khd);
      return;
    case 3: 
      if ((paramMessage.obj instanceof TroopBarUploadItemEntity))
      {
        paramMessage = (TroopBarUploadItemEntity)paramMessage.obj;
        str = paramMessage.mId;
        localMessage = paramMessage;
        paramMessage = str;
      }
      break;
    }
    while (this.a.jdField_a_of_type_Khd != null)
    {
      this.a.jdField_a_of_type_Khd.a(paramMessage, localMessage);
      return;
      if ((paramMessage.obj instanceof String))
      {
        paramMessage = (String)paramMessage.obj;
        continue;
        this.a.a();
      }
      else
      {
        paramMessage = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kgw
 * JD-Core Version:    0.7.0.1
 */