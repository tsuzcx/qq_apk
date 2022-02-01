import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.activity.TroopBarUploadManagerActivity;
import com.tencent.mobileqq.troop.data.TroopBarUploadItemEntity;
import com.tencent.mobileqq.troop.data.TroopBarUploadTaskManager;
import mqq.manager.TicketManager;

class khe
  implements View.OnClickListener
{
  khe(khd paramkhd) {}
  
  public void onClick(View paramView)
  {
    paramView = (khf)paramView.getTag();
    paramView = (TroopBarUploadItemEntity)this.jdField_a_of_type_Khd.a.jdField_a_of_type_Khd.getItem(paramView.a);
    switch (paramView.mState)
    {
    default: 
      return;
    case 4: 
      this.jdField_a_of_type_Khd.a.a(paramView);
      return;
    case 2: 
      this.jdField_a_of_type_Khd.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadTaskManager.a(this.jdField_a_of_type_Khd.a.app, paramView.mId, paramView.mProgress);
      return;
    }
    TicketManager localTicketManager = (TicketManager)this.jdField_a_of_type_Khd.a.app.getManager(2);
    this.jdField_a_of_type_Khd.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadTaskManager.b(this.jdField_a_of_type_Khd.a.app, this.jdField_a_of_type_Khd.a.app.a(), localTicketManager.getSkey(this.jdField_a_of_type_Khd.a.app.a()), paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     khe
 * JD-Core Version:    0.7.0.1
 */