import com.tencent.mobileqq.activity.RecentSaidActivity;
import com.tencent.mobileqq.utils.TimeFormatterUtils;

public class ewc
  extends evz
{
  long b;
  public CharSequence b;
  
  public ewc(RecentSaidActivity paramRecentSaidActivity, long paramLong1, CharSequence paramCharSequence, long paramLong2)
  {
    super(paramRecentSaidActivity, paramLong1);
    this.jdField_b_of_type_JavaLangCharSequence = paramCharSequence;
    this.jdField_b_of_type_Long = paramLong2;
  }
  
  public CharSequence a()
  {
    if (this.jdField_a_of_type_JavaLangCharSequence == null) {
      this.jdField_a_of_type_JavaLangCharSequence = TimeFormatterUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentSaidActivity, this.jdField_a_of_type_Long * 1000L);
    }
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ewc
 * JD-Core Version:    0.7.0.1
 */