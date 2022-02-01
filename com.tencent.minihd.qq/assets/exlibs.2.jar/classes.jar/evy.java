import com.tencent.mobileqq.activity.RecentSaidActivity;
import com.tencent.mobileqq.utils.TimeFormatterUtils;

public class evy
  extends evz
{
  public int a;
  
  public evy(RecentSaidActivity paramRecentSaidActivity, long paramLong)
  {
    super(paramRecentSaidActivity, paramLong);
    this.jdField_a_of_type_Evy = this;
    this.jdField_a_of_type_Int = 0;
  }
  
  public CharSequence a()
  {
    if (this.jdField_a_of_type_JavaLangCharSequence == null) {
      this.jdField_a_of_type_JavaLangCharSequence = TimeFormatterUtils.a(this.jdField_a_of_type_Long * 1000L);
    }
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     evy
 * JD-Core Version:    0.7.0.1
 */