import com.tencent.mobileqq.app.ThreadManager;

public class hqg
  implements Runnable
{
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private String jdField_a_of_type_JavaLangString;
  
  public hqg(Runnable paramRunnable, String paramString)
  {
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    ThreadManager.a("ThreadManager", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_JavaLangRunnable.run();
    ThreadManager.b("ThreadManager", this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hqg
 * JD-Core Version:    0.7.0.1
 */