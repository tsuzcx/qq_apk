import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public final class kmb
  implements Runnable
{
  public kmb(Context paramContext, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.b(this.jdField_a_of_type_AndroidContentContext, 230);
    localQQCustomDialog.setTitle(this.jdField_a_of_type_JavaLangString).setMessage(this.b);
    localQQCustomDialog.setPositiveButton(this.jdField_a_of_type_AndroidContentContext.getResources().getString(this.jdField_a_of_type_Int), new kmc(this));
    localQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kmb
 * JD-Core Version:    0.7.0.1
 */