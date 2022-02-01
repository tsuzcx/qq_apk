package cooperation.qzone;

import android.app.Activity;
import android.os.Bundle;

public class QzoneGPUPluginProxyActivity
  extends QzonePluginProxyActivity
{
  private static volatile Activity a;
  
  public static Activity a()
  {
    return a;
  }
  
  private void a(Activity paramActivity)
  {
    a = paramActivity;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a(this);
  }
  
  public void setTheme(int paramInt)
  {
    if (!this.bActivityToFragment) {
      super.setTheme(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.QzoneGPUPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */