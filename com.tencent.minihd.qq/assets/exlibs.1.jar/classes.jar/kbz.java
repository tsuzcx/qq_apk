import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.activity.AbsPublishIphoneTitleBarActivity;
import com.tencent.mobileqq.troop.data.TroopBarUploadItemEntity;
import com.tencent.mobileqq.troop.data.TroopBarUploadTaskManager;
import mqq.manager.TicketManager;
import org.json.JSONObject;

public class kbz
  implements Runnable
{
  public kbz(AbsPublishIphoneTitleBarActivity paramAbsPublishIphoneTitleBarActivity, TroopBarUploadItemEntity paramTroopBarUploadItemEntity, JSONObject paramJSONObject) {}
  
  public void run()
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity.app.a();
    String str2 = ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity.app.getManager(2)).getSkey(str1);
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity.app.a().createEntityManager();
    localEntityManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity);
    localEntityManager.a();
    TroopBarUploadTaskManager.a().a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity.app, str1, str2, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity.getWindow().getDecorView().post(new kca(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kbz
 * JD-Core Version:    0.7.0.1
 */