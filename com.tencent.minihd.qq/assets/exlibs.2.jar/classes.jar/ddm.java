import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class ddm
  implements Runnable
{
  ddm(ddl paramddl, String paramString, int paramInt) {}
  
  public void run()
  {
    Drawable localDrawable = this.jdField_a_of_type_Ddl.a.app.b(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Ddl.a.runOnUiThread(new ddn(this, localDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ddm
 * JD-Core Version:    0.7.0.1
 */