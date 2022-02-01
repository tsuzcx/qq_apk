import android.text.TextUtils;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsView;
import com.tencent.mobileqq.widget.FormMutiItem;

class gfr
  implements Runnable
{
  gfr(gfq paramgfq, String paramString) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Gfq.a.b.setSecondLineText("");
      this.jdField_a_of_type_Gfq.a.b.setSecondLineVisible(false);
      return;
    }
    this.jdField_a_of_type_Gfq.a.b.setSecondLineText(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Gfq.a.b.setSecondLineVisible(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gfr
 * JD-Core Version:    0.7.0.1
 */