package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.luggage.c.b.a.a;
import com.tencent.luggage.c.b.a.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.a.f;
import java.util.Timer;

@com.tencent.mm.ui.base.a(7)
public class HCETransparentUI
  extends Activity
{
  private ResultReceiver Cz;
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    y.i("MicroMsg.HCETransparentUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramIntent = a.gyn;
    if (paramInt1 == 1)
    {
      y.i("MicroMsg.HCEActivityMgr", "alvinluo back from REQUEST_JUMP_NFC_SETTING");
      paramIntent.gyf = true;
    }
    while (paramInt1 != 2) {
      return;
    }
    y.i("MicroMsg.HCEActivityMgr", "alvinluo back from REQUEST_SET_DEFAULT_NFC_APPLICATION");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(a.a.hce_transparent_ui);
    this.Cz = ((ResultReceiver)getIntent().getParcelableExtra("HCE_Result_Receiver"));
    paramBundle = a.gyn;
    ResultReceiver localResultReceiver = this.Cz;
    y.i("MicroMsg.HCEActivityMgr", "alvinluo setHceActivity");
    if ((this == null) || (localResultReceiver == null)) {
      y.e("MicroMsg.HCEActivityMgr", "alvinluo setHceActivity hceActivity is null, or resultReceiver is null");
    }
    paramBundle.gyk = this;
    paramBundle.Cz = localResultReceiver;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    a.gyn.dismissDialog();
  }
  
  protected void onResume()
  {
    super.onResume();
    y.i("MicroMsg.HCETransparentUI", "alvinluo onResume");
    Object localObject = new ComponentName(this, HCEService.class.getCanonicalName());
    a locala = a.gyn;
    y.i("MicroMsg.HCEActivityMgr", "alvinluo setPaymentServiceComponent");
    locala.gyj = ((ComponentName)localObject);
    localObject = a.gyn;
    if (((a)localObject).gyf)
    {
      ((a)localObject).gyi = new a.1((a)localObject);
      ((a)localObject).gyh = new Timer();
      ((a)localObject).gyh.scheduleAtFixedRate(((a)localObject).gyi, 0L, 300L);
      if (((a)localObject).gyk != null)
      {
        ((a)localObject).gyl = f.e(((a)localObject).gyk, ((a)localObject).gyk.getString(a.b.luggage_app_waiting));
        return;
      }
      y.e("MicroMsg.HCEActivityMgr", "alvinluo showProgressDialog mHceActivity is null");
      return;
    }
    ((a)localObject).ajG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.HCETransparentUI
 * JD-Core Version:    0.7.0.1
 */