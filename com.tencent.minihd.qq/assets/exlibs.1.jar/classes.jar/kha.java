import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.activity.TroopBarUploadManagerActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class kha
  implements DialogInterface.OnClickListener
{
  public kha(TroopBarUploadManagerActivity paramTroopBarUploadManagerActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.a.a.hide();
      return;
    }
    TroopBarUploadManagerActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kha
 * JD-Core Version:    0.7.0.1
 */