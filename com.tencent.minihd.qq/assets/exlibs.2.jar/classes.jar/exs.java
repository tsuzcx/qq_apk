import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class exs
  implements Runnable
{
  public exs(RegisterPhoneNumActivity paramRegisterPhoneNumActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterPhoneNumActivity, 230);
    localQQCustomDialog.setTitle(this.jdField_a_of_type_JavaLangString);
    localQQCustomDialog.setMessage(this.b);
    ext localext = new ext(this);
    exu localexu = new exu(this);
    localQQCustomDialog.setPositiveButton(2131366918, localext);
    localQQCustomDialog.setNegativeButton(2131365736, localexu);
    localQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     exs
 * JD-Core Version:    0.7.0.1
 */