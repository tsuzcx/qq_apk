import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.dating.DatingOthersActivity;

public class iby
  implements TextWatcher
{
  private int jdField_a_of_type_Int;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private int b;
  
  public iby(DatingOthersActivity paramDatingOthersActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.jdField_a_of_type_JavaLangCharSequence.length() > 0)
    {
      if ((this.b == 0) && (this.jdField_a_of_type_Int > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqDatingDatingOthersActivity.b(true);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingOthersActivity.b(false);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    this.b = paramInt1;
    this.jdField_a_of_type_Int = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iby
 * JD-Core Version:    0.7.0.1
 */