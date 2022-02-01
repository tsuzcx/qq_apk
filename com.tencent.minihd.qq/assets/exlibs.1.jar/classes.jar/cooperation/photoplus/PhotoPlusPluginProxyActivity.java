package cooperation.photoplus;

import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;

public class PhotoPlusPluginProxyActivity
  extends PluginProxyActivity
{
  private int a;
  
  private void a()
  {
    Display localDisplay = getWindowManager().getDefaultDisplay();
    if (localDisplay.getWidth() > localDisplay.getHeight()) {}
    for (this.a = 6;; this.a = 7)
    {
      setRequestedOrientation(this.a);
      return;
    }
  }
  
  public String getPluginID()
  {
    return "Photoplus.apk";
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.photoplus.PhotoPlusPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */