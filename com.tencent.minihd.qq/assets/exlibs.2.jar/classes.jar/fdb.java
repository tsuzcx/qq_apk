import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class fdb
  implements Runnable
{
  fdb(fda paramfda, String paramString, int paramInt) {}
  
  public void run()
  {
    Drawable localDrawable = this.jdField_a_of_type_Fda.a.app.b(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Fda.a.runOnUiThread(new fdc(this, localDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fdb
 * JD-Core Version:    0.7.0.1
 */