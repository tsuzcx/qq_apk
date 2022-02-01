import android.app.Activity;
import android.app.Instrumentation;
import com.tencent.mobileqq.memoryleak.LeakInspector;

public class jgg
  extends Instrumentation
{
  public void callActivityOnDestroy(Activity paramActivity)
  {
    LeakInspector.a().callActivityOnDestroy(paramActivity);
    LeakInspector.a(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jgg
 * JD-Core Version:    0.7.0.1
 */