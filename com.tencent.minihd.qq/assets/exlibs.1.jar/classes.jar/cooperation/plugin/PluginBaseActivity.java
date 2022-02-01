package cooperation.plugin;

import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;

public class PluginBaseActivity
  extends BasePluginActivity
{
  public int b()
  {
    return getResources().getDimensionPixelSize(2131492923);
  }
  
  public String b()
  {
    return getString(2131366374);
  }
  
  public final Activity getActivity()
  {
    return this;
  }
  
  public boolean onBackEvent()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.plugin.PluginBaseActivity
 * JD-Core Version:    0.7.0.1
 */