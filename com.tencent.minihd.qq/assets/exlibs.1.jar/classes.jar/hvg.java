import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import java.util.concurrent.Executor;

public class hvg
  implements Executor
{
  final hvi jdField_a_of_type_Hvi = new hvi(30);
  Runnable jdField_a_of_type_JavaLangRunnable;
  
  protected int a()
  {
    try
    {
      int i = this.jdField_a_of_type_Hvi.a();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void a()
  {
    try
    {
      Runnable localRunnable = (Runnable)this.jdField_a_of_type_Hvi.a();
      this.jdField_a_of_type_JavaLangRunnable = localRunnable;
      if (localRunnable != null) {
        QQAnimationDrawable.a.execute(this.jdField_a_of_type_JavaLangRunnable);
      }
      return;
    }
    finally {}
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_Hvi.a();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void execute(Runnable paramRunnable)
  {
    try
    {
      this.jdField_a_of_type_Hvi.a(new hvh(this, paramRunnable));
      if (this.jdField_a_of_type_JavaLangRunnable == null) {
        a();
      }
      return;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hvg
 * JD-Core Version:    0.7.0.1
 */