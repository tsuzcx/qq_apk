import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class fhi
  implements View.OnClickListener
{
  public fhi(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof Integer)) {}
    switch (((Integer)paramView).intValue())
    {
    default: 
      return;
    case 10: 
      this.a.h();
      return;
    }
    paramView = TroopInfoActivity.a(this.a);
    if (!TextUtils.isEmpty(paramView))
    {
      this.a.a(paramView);
      return;
    }
    if (((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.r == 2) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.r == 3)) && (this.a.jdField_a_of_type_Long > 0L) && (this.a.jdField_a_of_type_Long <= this.a.b))
    {
      paramView = DialogUtil.a(this.a, 230);
      paramView.setTitle(null);
      paramView.setMessage(this.a.getString(2131364167, new Object[] { this.a.jdField_a_of_type_Long + "" }));
      paramView.setPositiveButton(this.a.getString(2131364168), new fhj(this, paramView));
      paramView.setPositiveButtonContentDescription(this.a.getString(2131364168));
      paramView.show();
      return;
    }
    this.a.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fhi
 * JD-Core Version:    0.7.0.1
 */