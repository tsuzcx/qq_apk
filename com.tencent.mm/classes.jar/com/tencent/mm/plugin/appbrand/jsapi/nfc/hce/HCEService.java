package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import android.annotation.TargetApi;
import android.content.Intent;
import android.nfc.cardemulation.HostApduService;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@TargetApi(19)
public class HCEService
  extends HostApduService
{
  private String mAppId = null;
  
  public void onCreate()
  {
    AppMethodBeat.i(136155);
    super.onCreate();
    Log.i("MicroMsg.HCEService", "alvinluo HCEService onCreate");
    AppMethodBeat.o(136155);
  }
  
  public void onDeactivated(int paramInt)
  {
    AppMethodBeat.i(136159);
    Log.i("MicroMsg.HCEService", "alvinluo HCEService onDeactivated reason: %d", new Object[] { Integer.valueOf(paramInt) });
    b.mhH.mhB = false;
    b.mhH.mhC = false;
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_on_deactivated_reason", paramInt);
    b.mhH.b(this.mAppId, 41, localBundle);
    AppMethodBeat.o(136159);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(136156);
    super.onDestroy();
    Log.i("MicroMsg.HCEService", "alvinluo HCEService onDestroy");
    b.mhH.bHT();
    AppMethodBeat.o(136156);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(136157);
    Log.i("MicroMsg.HCEService", "alvinluo HCEService onStartCommand");
    long l1 = System.currentTimeMillis();
    Log.i("MicroMsg.HCEService", "alvinluo HCEService onStartCommand start: %d", new Object[] { Long.valueOf(l1) });
    if (paramIntent == null)
    {
      paramInt1 = super.onStartCommand(paramIntent, paramInt1, paramInt2);
      AppMethodBeat.o(136157);
      return paramInt1;
    }
    try
    {
      b localb = b.mhH;
      Object localObject = (ResultReceiver)paramIntent.getParcelableExtra("HCE_Result_Receiver");
      Log.i("MicroMsg.HCEServiceMgr", "alvinluo setHceService");
      localb.mhG = this;
      localb.MU = ((ResultReceiver)localObject);
      this.mAppId = paramIntent.getStringExtra("key_appid");
      localb = b.mhH;
      localb.mhf = paramIntent.getIntExtra("key_time_limit", 1500);
      if (localb.mhf < 1500)
      {
        Log.i("MicroMsg.HCEServiceMgr", "alvinluo HCEService timeLimit: %d smaller than: %d and set a valid value", new Object[] { Integer.valueOf(localb.mhf), Integer.valueOf(1500) });
        localb.mhf = 1500;
      }
      if (localb.mhf > 60000)
      {
        Log.i("MicroMsg.HCEServiceMgr", "alvinluo HCEService timeLimit: %d, bigger than: %d and set a valid value", new Object[] { Integer.valueOf(localb.mhf), Integer.valueOf(60000) });
        localb.mhf = 60000;
      }
      Log.i("MicroMsg.HCEServiceMgr", "alvinluo HCEService valid timeLimit: %d", new Object[] { Integer.valueOf(localb.mhf) });
      localb = b.mhH;
      localObject = this.mAppId;
      ArrayList localArrayList = paramIntent.getStringArrayListExtra("key_aid_list");
      localb.mAppId = ((String)localObject);
      localb.mhy = localArrayList;
      b.mhH.bHS();
      b.mhH.mhz = false;
      long l2 = System.currentTimeMillis();
      Log.i("MicroMsg.HCEService", "alvinluo HCEService onStartCommand end: %d, total: %d", new Object[] { Long.valueOf(l2), Long.valueOf(l2 - l1) });
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.HCEService", localException, "under dos attack(?): invalid key_result_receiver", new Object[0]);
      }
    }
    paramInt1 = super.onStartCommand(paramIntent, paramInt1, paramInt2);
    AppMethodBeat.o(136157);
    return paramInt1;
  }
  
  public byte[] processCommandApdu(byte[] paramArrayOfByte, Bundle paramBundle)
  {
    AppMethodBeat.i(136158);
    Log.i("MicroMsg.HCEService", "alvinluo HCECOMMAND processCommandApdu, received command from system: %s", new Object[] { c.aL(paramArrayOfByte) });
    paramArrayOfByte = Base64.encode(paramArrayOfByte, 2);
    paramBundle = new Bundle();
    paramBundle.putString("key_apdu_command", new String(paramArrayOfByte, StandardCharsets.UTF_8));
    b.mhH.a(31, this.mAppId, paramBundle);
    AppMethodBeat.o(136158);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.HCEService
 * JD-Core Version:    0.7.0.1
 */