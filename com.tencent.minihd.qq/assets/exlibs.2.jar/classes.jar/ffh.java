import com.tencent.mobileqq.activity.TextPreviewActivity;
import com.tencent.mobileqq.business.sougou.WordMatchManager.MatcherCallback;
import com.tencent.mobileqq.business.sougou.WordMatchManager.WordMatcher;

public class ffh
  implements WordMatchManager.MatcherCallback
{
  public ffh(TextPreviewActivity paramTextPreviewActivity) {}
  
  public void a(WordMatchManager.WordMatcher paramWordMatcher)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher = paramWordMatcher;
    this.a.e = paramWordMatcher.a(1, TextPreviewActivity.a(this.a), 3, this.a.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatchCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ffh
 * JD-Core Version:    0.7.0.1
 */