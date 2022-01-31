package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.model.c;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

public class FreeWifiManufacturerLoadingUI
  extends MMActivity
{
  private String bssid;
  private ap caS;
  private ImageView mNW;
  private TextView mNX;
  private Button mNY;
  private final int mNZ;
  private final int mOa;
  private final int mOb;
  private int[] mOc;
  ak mOd;
  ak mOe;
  private String ssid;
  
  public FreeWifiManufacturerLoadingUI()
  {
    AppMethodBeat.i(21018);
    this.mNZ = 1;
    this.mOa = 2;
    this.mOb = 3;
    this.mOc = new int[] { 2130838890, 2130838891, 2130838892, 2130838893, 2130838894 };
    this.mOd = new FreeWifiManufacturerLoadingUI.1(this);
    this.mOe = new ak();
    AppMethodBeat.o(21018);
  }
  
  private void ON(String paramString)
  {
    AppMethodBeat.i(21023);
    j.bAN().bAw().post(new FreeWifiManufacturerLoadingUI.5(this, paramString));
    AppMethodBeat.o(21023);
  }
  
  private void OO(String paramString)
  {
    AppMethodBeat.i(21025);
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    localMessage.obj = paramString;
    this.mOd.sendMessage(localMessage);
    AppMethodBeat.o(21025);
  }
  
  private void aJ(int paramInt, String paramString)
  {
    AppMethodBeat.i(21024);
    ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "errcode=%d, errmsg=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (paramInt != 0)
    {
      bBB();
      if (paramInt == 1154)
      {
        OO(getString(2131300170) + "(031" + k.b.mJo.mJq + "-" + Math.abs(paramInt) + ")");
        AppMethodBeat.o(21024);
        return;
      }
      OO(getString(2131300169) + "(031" + k.b.mJo.mJq + "-" + Math.abs(paramInt) + ")");
      this.mOe.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(21016);
          FreeWifiManufacturerLoadingUI.d(FreeWifiManufacturerLoadingUI.this).setVisibility(0);
          AppMethodBeat.o(21016);
        }
      }, 0L);
    }
    AppMethodBeat.o(21024);
  }
  
  private void bBB()
  {
    AppMethodBeat.i(21019);
    if (this.caS != null) {
      this.caS.stopTimer();
    }
    this.mOd.sendEmptyMessage(2);
    AppMethodBeat.o(21019);
  }
  
  private static String ch(Context paramContext)
  {
    AppMethodBeat.i(21026);
    try
    {
      paramContext = ((ActivityManager.RunningTaskInfo)((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
      ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "top activity name =".concat(String.valueOf(paramContext)));
      AppMethodBeat.o(21026);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      ab.printErrStackTrace("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", paramContext, "", new Object[0]);
      AppMethodBeat.o(21026);
    }
    return "(null)";
  }
  
  public final void bBC()
  {
    AppMethodBeat.i(21022);
    this.mOd.sendEmptyMessage(1);
    if (this.caS != null) {
      this.caS.stopTimer();
    }
    this.caS = new ap(new ap.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(21012);
        FreeWifiManufacturerLoadingUI.this.mOd.sendEmptyMessage(1);
        AppMethodBeat.o(21012);
        return true;
      }
    }, true);
    this.caS.ag(200L, 200L);
    ON(this.ssid);
    AppMethodBeat.o(21022);
  }
  
  public void finish()
  {
    AppMethodBeat.i(21020);
    bBB();
    super.finish();
    AppMethodBeat.o(21020);
  }
  
  public int getLayoutId()
  {
    return 2130969630;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(21021);
    super.onCreate(paramBundle);
    setMMTitle(2131300181);
    this.ssid = getIntent().getStringExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Ssid");
    this.bssid = getIntent().getStringExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Bssid");
    this.mNW = ((ImageView)findViewById(2131824269));
    this.mNX = ((TextView)findViewById(2131824270));
    this.mNY = ((Button)findViewById(2131824271));
    this.mNY.setOnClickListener(new FreeWifiManufacturerLoadingUI.2(this));
    setBackBtn(new FreeWifiManufacturerLoadingUI.3(this));
    bBC();
    AppMethodBeat.o(21021);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiManufacturerLoadingUI
 * JD-Core Version:    0.7.0.1
 */