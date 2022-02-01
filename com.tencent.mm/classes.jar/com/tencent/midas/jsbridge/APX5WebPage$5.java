package com.tencent.midas.jsbridge;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.control.APMidasPayHelper;
import com.tencent.midas.data.APPluginDataInterface;
import com.tencent.midas.data.APPluginReportManager;

class APX5WebPage$5
  implements View.OnClickListener
{
  APX5WebPage$5(APX5WebPage paramAPX5WebPage, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(192873);
    APLog.d("APX5WebPage", "closeBtn() clicked");
    APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), "sdk.plugin.webpage.x5.close", "", "");
    paramView = new APMidasResponse();
    paramView.resultCode = 100;
    paramView.resultMsg = "关闭";
    APMidasPayHelper.midasCallBack(paramView);
    this.val$activityFinal.finish();
    AppMethodBeat.o(192873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.midas.jsbridge.APX5WebPage.5
 * JD-Core Version:    0.7.0.1
 */