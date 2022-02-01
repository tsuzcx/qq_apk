import android.content.Intent;
import com.tencent.mobileqq.troop.activity.AbsPublishIphoneTitleBarActivity;
import org.json.JSONObject;

class kca
  implements Runnable
{
  kca(kbz paramkbz) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("result", this.a.jdField_a_of_type_OrgJsonJSONObject.toString());
    this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity.setResult(-1, localIntent);
    this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kca
 * JD-Core Version:    0.7.0.1
 */