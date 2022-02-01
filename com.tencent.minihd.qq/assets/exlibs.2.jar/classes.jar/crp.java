import com.tencent.image.Utils;
import com.tencent.mobileqq.app.AppConstants;
import java.util.concurrent.atomic.AtomicInteger;

public class crp
{
  int a;
  public String a;
  public AtomicInteger a;
  public String b;
  
  public crp()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_Int = 0;
  }
  
  void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    paramString = Utils.Crc64String(paramString);
    this.b = (AppConstants.aR + paramString + ".apk");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     crp
 * JD-Core Version:    0.7.0.1
 */