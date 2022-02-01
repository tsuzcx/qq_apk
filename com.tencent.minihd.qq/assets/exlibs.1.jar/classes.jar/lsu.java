import com.tencent.widget.TCWNumberPicker.Formatter;
import java.util.Formatter;

public final class lsu
  implements TCWNumberPicker.Formatter
{
  final StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  final Formatter jdField_a_of_type_JavaUtilFormatter = new Formatter(this.jdField_a_of_type_JavaLangStringBuilder);
  final Object[] jdField_a_of_type_ArrayOfJavaLangObject = new Object[1];
  
  public String a(int paramInt)
  {
    this.jdField_a_of_type_ArrayOfJavaLangObject[0] = Integer.valueOf(paramInt);
    this.jdField_a_of_type_JavaLangStringBuilder.delete(0, this.jdField_a_of_type_JavaLangStringBuilder.length());
    this.jdField_a_of_type_JavaUtilFormatter.format("%02d", this.jdField_a_of_type_ArrayOfJavaLangObject);
    return this.jdField_a_of_type_JavaUtilFormatter.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lsu
 * JD-Core Version:    0.7.0.1
 */