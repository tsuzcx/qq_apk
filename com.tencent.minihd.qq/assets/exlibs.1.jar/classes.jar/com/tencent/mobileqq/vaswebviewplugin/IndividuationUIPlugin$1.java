package com.tencent.mobileqq.vaswebviewplugin;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;

class IndividuationUIPlugin$1
  implements View.OnClickListener
{
  IndividuationUIPlugin$1(IndividuationUIPlugin paramIndividuationUIPlugin) {}
  
  public void onClick(View paramView)
  {
    VasWebviewUtil.a(this.this$0.activity, VasWebviewConstants.INDIVIDUATION_MY_URL, 32L, null, true, -1);
    ReportController.b(null, "CliOper", "", "", "Trends_tab", "Clk_mine_web", 0, 0, "", "", "", "");
    if (this.this$0.rtm == null) {
      this.this$0.rtm = new RedTouchManager(this.this$0.mRuntime.a());
    }
    this.this$0.myIndividuationRedTouch.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.IndividuationUIPlugin.1
 * JD-Core Version:    0.7.0.1
 */