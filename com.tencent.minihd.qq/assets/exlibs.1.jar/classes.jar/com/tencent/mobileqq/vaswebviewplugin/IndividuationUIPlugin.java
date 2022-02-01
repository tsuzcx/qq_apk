package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class IndividuationUIPlugin
  extends VasWebviewUiPlugin
{
  private static final String TAG = "IndividuationUIPlugin";
  RedTouch myIndividuationRedTouch;
  String path = "100005.100022";
  RedTouchManager rtm = null;
  
  private void onReportRed(BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("service_type", 0);
      localJSONObject.put("act_id", paramInt);
      localJSONObject.put("obj_id", "");
      localJSONObject.put("pay_amt", 0);
      localJSONObject.put("service_id", 100005);
      new RedTouchManager(this.mRuntime.a()).b(paramAppInfo, localJSONObject.toString());
      return;
    }
    catch (JSONException paramAppInfo)
    {
      paramAppInfo.printStackTrace();
    }
  }
  
  void OnActivityCreate()
  {
    super.OnActivityCreate();
    this.activity.M = super.decodeUrl(this.activity.M);
    if (QLog.isColorLevel()) {
      QLog.d("IndividuationUIPlugin", 2, this.activity.M);
    }
    if (this.rtm == null) {
      this.rtm = new RedTouchManager(this.mRuntime.a());
    }
    BusinessInfoCheckUpdate.AppInfo localAppInfo = this.rtm.a(this.path);
    this.myIndividuationRedTouch = new RedTouch(this.activity, this.activity.getRightTextView()).a(53).a();
    this.myIndividuationRedTouch.a(localAppInfo);
    onReportRed(this.rtm.a(this.path), 1001);
    this.activity.setRightButton(2131366280, new IndividuationUIPlugin.1(this));
  }
  
  protected long getPluginBusiness()
  {
    return 1048576L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.IndividuationUIPlugin
 * JD-Core Version:    0.7.0.1
 */