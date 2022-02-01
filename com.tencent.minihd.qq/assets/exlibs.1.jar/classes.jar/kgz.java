import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.activity.TroopBarUploadManagerActivity;
import com.tencent.mobileqq.troop.data.TroopBarUploadItemEntity;
import com.tencent.mobileqq.troop.data.TroopBarUploadTaskManager;
import mqq.manager.TicketManager;

public class kgz
  implements DialogInterface.OnClickListener
{
  public kgz(TroopBarUploadManagerActivity paramTroopBarUploadManagerActivity, TroopBarUploadItemEntity paramTroopBarUploadItemEntity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramDialogInterface.dismiss();
      return;
    }
    paramDialogInterface = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarUploadManagerActivity.app.getManager(2);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarUploadManagerActivity.a.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarUploadManagerActivity.app, this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarUploadManagerActivity.app.a(), paramDialogInterface.getSkey(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarUploadManagerActivity.app.a()), this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kgz
 * JD-Core Version:    0.7.0.1
 */