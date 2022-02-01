import android.content.Context;
import android.widget.Toast;
import com.tencent.qphone.base.util.QLog;

public class kyq
  extends Toast
{
  public kyq(Context paramContext)
  {
    super(paramContext);
  }
  
  public void show()
  {
    try
    {
      super.show();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QQToast", 2, "", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     kyq
 * JD-Core Version:    0.7.0.1
 */