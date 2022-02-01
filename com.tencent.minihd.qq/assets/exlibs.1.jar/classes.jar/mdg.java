import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.view.Window;
import com.tencent.qphone.base.util.BaseApplication;

public final class mdg
  implements Runnable
{
  public mdg(String paramString) {}
  
  public void run()
  {
    Object localObject = new AlertDialog.Builder(BaseApplication.getContext());
    ((AlertDialog.Builder)localObject).setMessage(this.a).setTitle("点击上报成功");
    localObject = ((AlertDialog.Builder)localObject).create();
    ((AlertDialog)localObject).getWindow().setType(2003);
    try
    {
      ((AlertDialog)localObject).show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mdg
 * JD-Core Version:    0.7.0.1
 */