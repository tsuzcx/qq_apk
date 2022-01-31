package com.tencent.mm.plugin.freewifi.ui;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.model.c;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

public class FreeWifiManufacturerLoadingUI
  extends MMActivity
{
  private String bssid;
  private am byQ;
  private ImageView ksi;
  private TextView ksj;
  private Button ksk;
  private final int ksl = 1;
  private final int ksm = 2;
  private final int ksn = 3;
  private int[] kso = { R.g.free_wifi_loading_1, R.g.free_wifi_loading_2, R.g.free_wifi_loading_3, R.g.free_wifi_loading_4, R.g.free_wifi_loading_5 };
  ah ksp = new FreeWifiManufacturerLoadingUI.1(this);
  ah ksq = new ah();
  private String ssid;
  
  private void DF(String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    localMessage.obj = paramString;
    this.ksp.sendMessage(localMessage);
  }
  
  private void aVc()
  {
    if (this.byQ != null) {
      this.byQ.stopTimer();
    }
    this.ksp.sendEmptyMessage(2);
  }
  
  private void ap(int paramInt, String paramString)
  {
    y.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "errcode=%d, errmsg=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (paramInt != 0)
    {
      aVc();
      if (paramInt == 1154) {
        DF(getString(R.l.free_wifi_manufacturer_loading_getting_portal_url_unsupported) + "(031" + k.b.knB.knD + "-" + Math.abs(paramInt) + ")");
      }
    }
    else
    {
      return;
    }
    DF(getString(R.l.free_wifi_manufacturer_loading_getting_portal_url_fail) + "(031" + k.b.knB.knD + "-" + Math.abs(paramInt) + ")");
    this.ksq.postDelayed(new FreeWifiManufacturerLoadingUI.6(this), 0L);
  }
  
  private static String bC(Context paramContext)
  {
    try
    {
      paramContext = ((ActivityManager.RunningTaskInfo)((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
      y.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "top activity name =" + paramContext);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      y.printErrStackTrace("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", paramContext, "", new Object[0]);
    }
    return "(null)";
  }
  
  public final void aVd()
  {
    this.ksp.sendEmptyMessage(1);
    if (this.byQ != null) {
      this.byQ.stopTimer();
    }
    this.byQ = new am(new am.a()
    {
      public final boolean tC()
      {
        FreeWifiManufacturerLoadingUI.this.ksp.sendEmptyMessage(1);
        return true;
      }
    }, true);
    this.byQ.S(200L, 200L);
    String str = this.ssid;
    j.aUl().aTT().post(new FreeWifiManufacturerLoadingUI.5(this, str));
  }
  
  public void finish()
  {
    aVc();
    super.finish();
  }
  
  protected final int getLayoutId()
  {
    return R.i.free_wifi_manufacturer_loading;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(R.l.free_wifi_title);
    this.ssid = getIntent().getStringExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Ssid");
    this.bssid = getIntent().getStringExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Bssid");
    this.ksi = ((ImageView)findViewById(R.h.free_wifi_manufacturer_app_logo_iv));
    this.ksj = ((TextView)findViewById(R.h.free_wifi_manufacturer_hint));
    this.ksk = ((Button)findViewById(R.h.free_wifi_manufacturer_reconnect_btn));
    this.ksk.setOnClickListener(new FreeWifiManufacturerLoadingUI.2(this));
    setBackBtn(new FreeWifiManufacturerLoadingUI.3(this));
    aVd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiManufacturerLoadingUI
 * JD-Core Version:    0.7.0.1
 */