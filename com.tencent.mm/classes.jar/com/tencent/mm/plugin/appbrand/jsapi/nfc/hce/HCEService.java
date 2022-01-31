package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import android.annotation.TargetApi;
import android.content.Intent;
import android.nfc.cardemulation.HostApduService;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@TargetApi(19)
public class HCEService
  extends HostApduService
{
  private String mAppId = null;
  
  public void onCreate()
  {
    AppMethodBeat.i(137907);
    super.onCreate();
    ab.i("MicroMsg.HCEService", "alvinluo HCEService onCreate");
    AppMethodBeat.o(137907);
  }
  
  public void onDeactivated(int paramInt)
  {
    AppMethodBeat.i(137911);
    ab.i("MicroMsg.HCEService", "alvinluo HCEService onDeactivated reason: %d", new Object[] { Integer.valueOf(paramInt) });
    b.hVa.hUU = false;
    b.hVa.hUV = false;
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_on_deactivated_reason", paramInt);
    b.hVa.b(this.mAppId, 41, localBundle);
    AppMethodBeat.o(137911);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(137908);
    super.onDestroy();
    ab.i("MicroMsg.HCEService", "alvinluo HCEService onDestroy");
    b.hVa.aEh();
    AppMethodBeat.o(137908);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137909);
    ab.i("MicroMsg.HCEService", "alvinluo HCEService onStartCommand");
    long l1 = System.currentTimeMillis();
    ab.i("MicroMsg.HCEService", "alvinluo HCEService onStartCommand start: %d", new Object[] { Long.valueOf(l1) });
    if (paramIntent == null)
    {
      paramInt1 = super.onStartCommand(paramIntent, paramInt1, paramInt2);
      AppMethodBeat.o(137909);
      return paramInt1;
    }
    try
    {
      b localb = b.hVa;
      Object localObject = (ResultReceiver)paramIntent.getParcelableExtra("HCE_Result_Receiver");
      ab.i("MicroMsg.HCEServiceMgr", "alvinluo setHceService");
      localb.hUZ = this;
      localb.Di = ((ResultReceiver)localObject);
      this.mAppId = paramIntent.getStringExtra("key_appid");
      localb = b.hVa;
      localb.hUy = paramIntent.getIntExtra("key_time_limit", 1500);
      if (localb.hUy < 1500)
      {
        ab.i("MicroMsg.HCEServiceMgr", "alvinluo HCEService timeLimit: %d smaller than: %d and set a valid value", new Object[] { Integer.valueOf(localb.hUy), Integer.valueOf(1500) });
        localb.hUy = 1500;
      }
      if (localb.hUy > 60000)
      {
        ab.i("MicroMsg.HCEServiceMgr", "alvinluo HCEService timeLimit: %d, bigger than: %d and set a valid value", new Object[] { Integer.valueOf(localb.hUy), Integer.valueOf(60000) });
        localb.hUy = 60000;
      }
      ab.i("MicroMsg.HCEServiceMgr", "alvinluo HCEService valid timeLimit: %d", new Object[] { Integer.valueOf(localb.hUy) });
      localb = b.hVa;
      localObject = this.mAppId;
      ArrayList localArrayList = paramIntent.getStringArrayListExtra("key_aid_list");
      localb.mAppId = ((String)localObject);
      localb.hUR = localArrayList;
      b.hVa.aEg();
      b.hVa.hUS = false;
      long l2 = System.currentTimeMillis();
      ab.i("MicroMsg.HCEService", "alvinluo HCEService onStartCommand end: %d, total: %d", new Object[] { Long.valueOf(l2), Long.valueOf(l2 - l1) });
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.HCEService", localException, "under dos attack(?): invalid key_result_receiver", new Object[0]);
      }
    }
    paramInt1 = super.onStartCommand(paramIntent, paramInt1, paramInt2);
    AppMethodBeat.o(137909);
    return paramInt1;
  }
  
  public byte[] processCommandApdu(byte[] paramArrayOfByte, Bundle paramBundle)
  {
    AppMethodBeat.i(137910);
    ab.i("MicroMsg.HCEService", "alvinluo HCECOMMAND processCommandApdu, received command from system: %s", new Object[] { c.aj(paramArrayOfByte) });
    paramArrayOfByte = Base64.encode(paramArrayOfByte, 2);
    paramBundle = new Bundle();
    paramBundle.putString("key_apdu_command", new String(paramArrayOfByte, StandardCharsets.UTF_8));
    b.hVa.a(31, this.mAppId, paramBundle);
    AppMethodBeat.o(137910);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.HCEService
 * JD-Core Version:    0.7.0.1
 */