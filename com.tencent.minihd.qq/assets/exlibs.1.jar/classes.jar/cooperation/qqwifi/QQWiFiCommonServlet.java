package cooperation.qqwifi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import org.json.JSONArray;
import org.json.JSONObject;
import qqwifi.LBS.LBSInfo;
import qqwifi.MQQ.ContentRequest;
import qqwifi.MQQ.ContentResponse;

public class QQWiFiCommonServlet
  extends MSFServlet
{
  public static final int a = 1;
  public static final String a = "QQWiFiCommonServlet";
  public static final String b = "MQQ.AsyncContentMgrServer.AsyncContentMgrObj";
  public static final String c = "getContentList";
  public static final String d = "QQWifiSvc.getContentList";
  public static final String e = "cmd";
  
  private void a(FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiCommonServlet", 2, "onGetNotificationBarActivityInfo");
    }
    paramFromServiceMsg = (ContentResponse)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new ContentResponse());
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.ret == 0)) {}
    try
    {
      Object localObject = new JSONObject(paramFromServiceMsg.resource).getJSONArray("resource");
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiCommonServlet", 2, "resource=" + paramFromServiceMsg.resource);
      }
      paramFromServiceMsg = ((JSONArray)localObject).getJSONObject(0);
      localObject = BaseApplication.getContext();
      if (Build.VERSION.SDK_INT > 10) {}
      for (int i = 4;; i = 0)
      {
        ((Context)localObject).getSharedPreferences("qqwifi", i).edit().putInt("BarOperation_id", paramFromServiceMsg.getInt("id")).putInt("BarOperation_type", paramFromServiceMsg.getInt("type")).putString("BarOperation_url", URLDecoder.decode(paramFromServiceMsg.getString("url"), "UTF-8")).putLong("BarOperation_expiry", paramFromServiceMsg.getLong("expiry")).commit();
        return;
      }
      return;
    }
    catch (Exception paramFromServiceMsg)
    {
      paramFromServiceMsg.printStackTrace();
    }
  }
  
  private void a(Packet paramPacket)
  {
    ContentRequest localContentRequest = new ContentRequest(2L, new LBSInfo(), "5.9.3");
    paramPacket.setSSOCommand("QQWifiSvc.getContentList");
    paramPacket.setServantName("MQQ.AsyncContentMgrServer.AsyncContentMgrObj");
    paramPacket.setFuncName("getContentList");
    paramPacket.setTimeout(20000L);
    paramPacket.addRequestPacket("req", localContentRequest);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if ("QQWifiSvc.getContentList".equals(paramFromServiceMsg.getServiceCmd())) {
      a(paramFromServiceMsg);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    switch (paramIntent.getIntExtra("cmd", 0))
    {
    default: 
      return;
    }
    a(paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qqwifi.QQWiFiCommonServlet
 * JD-Core Version:    0.7.0.1
 */