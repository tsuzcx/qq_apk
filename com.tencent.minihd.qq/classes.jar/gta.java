import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.photoplus.PhotoPlusBridgeActivity;
import java.util.ArrayList;

public class gta
  implements View.OnClickListener
{
  public gta(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
    paramView = new Intent(BaseApplication.getContext(), PhotoPlusBridgeActivity.class);
    paramView.putExtra("photo_path", (String)PhotoPreviewActivity.a(this.a).get(0));
    paramView.putExtra("iswaitforsult", this.a.jdField_a_of_type_Boolean);
    paramView.putExtra("type", this.a.jdField_a_of_type_Int);
    paramView.putExtra("uin", this.a.jdField_a_of_type_JavaLangString);
    paramView.putExtra("nick", this.a.b);
    paramView.putExtra("headDir", this.a.c);
    this.a.startActivityForResult(paramView, 100003);
    this.a.overridePendingTransition(2130968627, 2130968628);
    this.a.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gta
 * JD-Core Version:    0.7.0.1
 */