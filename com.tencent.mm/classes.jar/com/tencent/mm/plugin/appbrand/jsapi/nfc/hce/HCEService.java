package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import android.annotation.TargetApi;
import android.content.Intent;
import android.nfc.cardemulation.HostApduService;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Base64;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

@TargetApi(19)
public class HCEService
  extends HostApduService
{
  private String mAppId = null;
  
  public void onCreate()
  {
    super.onCreate();
    y.i("MicroMsg.HCEService", "alvinluo HCEService onCreate");
  }
  
  public void onDeactivated(int paramInt)
  {
    y.i("MicroMsg.HCEService", "alvinluo HCEService onDeactivated reason: %d", new Object[] { Integer.valueOf(paramInt) });
    b.gyA.gyu = false;
    b.gyA.gyv = false;
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_on_deactivated_reason", paramInt);
    b.gyA.b(this.mAppId, 41, localBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    y.i("MicroMsg.HCEService", "alvinluo HCEService onDestroy");
    b.gyA.ajJ();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.HCEService", "alvinluo HCEService onStartCommand");
    long l1 = System.currentTimeMillis();
    y.i("MicroMsg.HCEService", "alvinluo HCEService onStartCommand start: %d", new Object[] { Long.valueOf(l1) });
    if (paramIntent == null) {
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
    }
    b localb = b.gyA;
    Object localObject = (ResultReceiver)paramIntent.getParcelableExtra("HCE_Result_Receiver");
    y.i("MicroMsg.HCEServiceMgr", "alvinluo setHceService");
    localb.gyz = this;
    localb.Cz = ((ResultReceiver)localObject);
    this.mAppId = paramIntent.getStringExtra("key_appid");
    localb = b.gyA;
    localb.gxY = paramIntent.getIntExtra("key_time_limit", 1500);
    if (localb.gxY < 1500)
    {
      y.i("MicroMsg.HCEServiceMgr", "alvinluo HCEService timeLimit: %d smaller than: %d and set a valid value", new Object[] { Integer.valueOf(localb.gxY), Integer.valueOf(1500) });
      localb.gxY = 1500;
    }
    if (localb.gxY > 60000)
    {
      y.i("MicroMsg.HCEServiceMgr", "alvinluo HCEService timeLimit: %d, bigger than: %d and set a valid value", new Object[] { Integer.valueOf(localb.gxY), Integer.valueOf(60000) });
      localb.gxY = 60000;
    }
    y.i("MicroMsg.HCEServiceMgr", "alvinluo HCEService valid timeLimit: %d", new Object[] { Integer.valueOf(localb.gxY) });
    localb = b.gyA;
    localObject = this.mAppId;
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("key_aid_list");
    localb.mAppId = ((String)localObject);
    localb.gyr = localArrayList;
    b.gyA.ajI();
    b.gyA.gys = false;
    long l2 = System.currentTimeMillis();
    y.i("MicroMsg.HCEService", "alvinluo HCEService onStartCommand end: %d, total: %d", new Object[] { Long.valueOf(l2), Long.valueOf(l2 - l1) });
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  public byte[] processCommandApdu(byte[] paramArrayOfByte, Bundle paramBundle)
  {
    y.i("MicroMsg.HCEService", "alvinluo HCECOMMAND processCommandApdu, received command from system: %s", new Object[] { c.P(paramArrayOfByte) });
    paramArrayOfByte = Base64.encode(paramArrayOfByte, 2);
    paramBundle = new Bundle();
    paramBundle.putString("key_apdu_command", new String(paramArrayOfByte));
    b.gyA.a(31, this.mAppId, paramBundle);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.HCEService
 * JD-Core Version:    0.7.0.1
 */