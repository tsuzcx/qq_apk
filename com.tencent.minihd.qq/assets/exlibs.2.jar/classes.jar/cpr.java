import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.webviewplugin.HbEventPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class cpr
  extends BroadcastReceiver
{
  public String a;
  public String b;
  
  private cpr(HbEventPlugin paramHbEventPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getExtras();
    paramContext = localBundle.get("bc_data");
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager.HbEventPlugin", 2, "DataReceive | onReceive data = null");
      }
      return;
    }
    int i = paramIntent.getIntExtra("portal_type_key", -1);
    int j = paramIntent.getIntExtra("bc_seq", -1);
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager.HbEventPlugin", 2, "DataReceiver.onReceive | " + i + "," + j + "," + this.jdField_a_of_type_JavaLangString + "," + localBundle);
    }
    switch (i)
    {
    case 1001: 
    case 1003: 
    default: 
      return;
    case 1000: 
    case 1002: 
    case 1005: 
    case 1006: 
    case 1007: 
      if (!this.jdField_a_of_type_ComTencentBizWebviewpluginHbEventPlugin.a(j, i))
      {
        this.jdField_a_of_type_ComTencentBizWebviewpluginHbEventPlugin.a(j);
        return;
      }
      break;
    case 1004: 
      if (!this.jdField_a_of_type_ComTencentBizWebviewpluginHbEventPlugin.a(j, i))
      {
        this.jdField_a_of_type_ComTencentBizWebviewpluginHbEventPlugin.a(j);
        return;
      }
      paramIntent = new JSONObject();
      try
      {
        paramIntent.put("hasjoined", (String)paramContext);
        this.jdField_a_of_type_ComTencentBizWebviewpluginHbEventPlugin.a(this.jdField_a_of_type_JavaLangString, new String[] { paramIntent.toString() });
        this.jdField_a_of_type_ComTencentBizWebviewpluginHbEventPlugin.a(j);
        return;
      }
      catch (JSONException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
    }
    this.jdField_a_of_type_ComTencentBizWebviewpluginHbEventPlugin.a(this.jdField_a_of_type_JavaLangString, new String[] { (String)paramContext });
    this.jdField_a_of_type_ComTencentBizWebviewpluginHbEventPlugin.a(j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cpr
 * JD-Core Version:    0.7.0.1
 */