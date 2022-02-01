import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.dating.PublishDatingHelper;

public class ien
  implements IphonePickerView.PickerViewAdapter
{
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  public ien(PublishDatingHelper paramPublishDatingHelper, String[] paramArrayOfString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
  }
  
  public int a()
  {
    return 1;
  }
  
  public int a(int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {
      return 0;
    }
    return this.jdField_a_of_type_ArrayOfJavaLangString.length;
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {
      return "";
    }
    return this.jdField_a_of_type_ArrayOfJavaLangString[paramInt2];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ien
 * JD-Core Version:    0.7.0.1
 */