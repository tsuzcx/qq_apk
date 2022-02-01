import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class jvu
  implements Runnable
{
  jvu(jvt paramjvt, String paramString) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.a, this.jdField_a_of_type_JavaLangString + "泄漏，正在生成dump文件", 2000).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     jvu
 * JD-Core Version:    0.7.0.1
 */