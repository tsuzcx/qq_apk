package cooperation.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.NetworkUtil;

public class PluginManagerV2$NetworkReceiver
  extends BroadcastReceiver
{
  private static final String jdField_a_of_type_JavaLangString = "android.net.conn.CONNECTIVITY_CHANGE";
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.a();
  private boolean jdField_a_of_type_Boolean;
  
  public PluginManagerV2$NetworkReceiver(PluginManagerV2 paramPluginManagerV2) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this, localIntentFilter);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    try
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction())) && (NetworkUtil.b(this.jdField_a_of_type_AndroidContentContext) == 0)) {
      PluginManagerV2.a(this.jdField_a_of_type_CooperationPluginPluginManagerV2).sendEmptyMessage(66304);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.plugin.PluginManagerV2.NetworkReceiver
 * JD-Core Version:    0.7.0.1
 */