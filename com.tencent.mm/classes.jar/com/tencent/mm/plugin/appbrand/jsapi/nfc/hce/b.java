package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.nfc.NfcAdapter;
import android.nfc.cardemulation.CardEmulation;
import android.nfc.cardemulation.HostApduService;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;

@TargetApi(19)
public final class b
{
  public static b gyA = new b();
  private static final byte[] gyy = { 0, 0 };
  private static long mStartTime = -1L;
  ResultReceiver Cz;
  int gxY;
  ArrayList<String> gyr;
  boolean gys = false;
  private boolean gyt = true;
  boolean gyu = false;
  boolean gyv = false;
  private a gyw = new b.a(this, (byte)0);
  private com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.b gyx = new b.b(this, (byte)0);
  HostApduService gyz;
  String mAppId = null;
  
  static
  {
    gyA = null;
  }
  
  /* Error */
  private void a(byte[] paramArrayOfByte, boolean paramBoolean, HostApduService paramHostApduService)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 80
    //   4: ldc 82
    //   6: iconst_2
    //   7: anewarray 4	java/lang/Object
    //   10: dup
    //   11: iconst_0
    //   12: iload_2
    //   13: invokestatic 88	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   16: aastore
    //   17: dup
    //   18: iconst_1
    //   19: aload_0
    //   20: getfield 61	com/tencent/mm/plugin/appbrand/jsapi/nfc/hce/b:gyt	Z
    //   23: invokestatic 88	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   26: aastore
    //   27: invokestatic 94	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   30: aload_0
    //   31: getfield 61	com/tencent/mm/plugin/appbrand/jsapi/nfc/hce/b:gyt	Z
    //   34: ifeq +91 -> 125
    //   37: aload_0
    //   38: iconst_0
    //   39: putfield 61	com/tencent/mm/plugin/appbrand/jsapi/nfc/hce/b:gyt	Z
    //   42: invokestatic 100	java/lang/System:currentTimeMillis	()J
    //   45: lstore 4
    //   47: ldc 80
    //   49: ldc 102
    //   51: iconst_2
    //   52: anewarray 4	java/lang/Object
    //   55: dup
    //   56: iconst_0
    //   57: lload 4
    //   59: invokestatic 107	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   62: aastore
    //   63: dup
    //   64: iconst_1
    //   65: lload 4
    //   67: getstatic 48	com/tencent/mm/plugin/appbrand/jsapi/nfc/hce/b:mStartTime	J
    //   70: lsub
    //   71: invokestatic 107	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   74: aastore
    //   75: invokestatic 94	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   78: aload_3
    //   79: ifnull +49 -> 128
    //   82: aload_3
    //   83: aload_1
    //   84: invokevirtual 113	android/nfc/cardemulation/HostApduService:sendResponseApdu	([B)V
    //   87: iload_2
    //   88: ifeq +37 -> 125
    //   91: aload_0
    //   92: getfield 57	com/tencent/mm/plugin/appbrand/jsapi/nfc/hce/b:mAppId	Ljava/lang/String;
    //   95: astore_1
    //   96: ldc 115
    //   98: ldc 117
    //   100: iconst_1
    //   101: anewarray 4	java/lang/Object
    //   104: dup
    //   105: iconst_0
    //   106: aload_1
    //   107: aastore
    //   108: invokestatic 94	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: ldc 119
    //   113: invokestatic 125	com/tencent/luggage/b/e:j	(Ljava/lang/Class;)Lcom/tencent/luggage/b/d;
    //   116: checkcast 119	com/tencent/mm/plugin/appbrand/p/b
    //   119: aload_1
    //   120: invokeinterface 129 2 0
    //   125: aload_0
    //   126: monitorexit
    //   127: return
    //   128: ldc 80
    //   130: ldc 131
    //   132: invokestatic 135	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: goto -48 -> 87
    //   138: astore_1
    //   139: aload_0
    //   140: monitorexit
    //   141: aload_1
    //   142: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	b
    //   0	143	1	paramArrayOfByte	byte[]
    //   0	143	2	paramBoolean	boolean
    //   0	143	3	paramHostApduService	HostApduService
    //   45	21	4	l	long
    // Exception table:
    //   from	to	target	type
    //   2	78	138	finally
    //   82	87	138	finally
    //   91	125	138	finally
    //   128	135	138	finally
  }
  
  private void dr(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    if (paramBoolean)
    {
      localBundle.putInt("errCode", 0);
      localBundle.putString("errMsg", "");
    }
    for (;;)
    {
      b(this.mAppId, 12, localBundle);
      return;
      localBundle.putInt("errCode", 13006);
      localBundle.putString("errMsg", "register aids failed");
    }
  }
  
  public final void a(int paramInt, String paramString, Bundle paramBundle)
  {
    y.i("MicroMsg.HCEServiceMgr", "alvinluo genCallHCEService type = %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                } while (this.gyw == null);
                paramBundle = paramBundle.getString("key_apdu_command");
                this.gyw.bF(paramString, paramBundle);
                return;
              } while (this.gyw == null);
              paramBundle = paramBundle.getString("key_apdu_command");
              this.gyw.bE(paramString, paramBundle);
              return;
            } while (this.gyx == null);
            this.gyx.onCreate();
            return;
          } while (this.gyx == null);
          this.gyx.onResume();
          return;
        } while (this.gyx == null);
        this.gyx.onPause();
        return;
      } while (this.gyx == null);
      this.gyx.onDestroy();
      return;
      ajJ();
    } while (this.gyz == null);
    this.gyz.stopSelf();
  }
  
  @TargetApi(21)
  public final void ajI()
  {
    if ((this.gyr == null) || (this.gyz == null)) {
      y.e("MicroMsg.HCEServiceMgr", "alvinluo mAidList is null, or mHceService is null fail to register");
    }
    for (;;)
    {
      return;
      Object localObject = NfcAdapter.getDefaultAdapter(this.gyz);
      if (localObject == null)
      {
        y.e("MicroMsg.HCEServiceMgr", "alvinluo NfcAdapter is null when register aids");
        return;
      }
      if (Build.VERSION.SDK_INT < 21)
      {
        y.e("MicroMsg.HCEServiceMgr", "alvinluo android version: %d is not satisfied when register aids", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
        return;
      }
      localObject = CardEmulation.getInstance((NfcAdapter)localObject);
      if (localObject != null) {
        try
        {
          ComponentName localComponentName = new ComponentName(this.gyz, this.gyz.getClass());
          boolean bool = ((CardEmulation)localObject).registerAidsForService(localComponentName, "payment", this.gyr);
          y.i("MicroMsg.HCEServiceMgr", "alvinluo register aids result: %b", new Object[] { Boolean.valueOf(bool) });
          if (bool)
          {
            dr(true);
            localObject = ((CardEmulation)localObject).getAidsForService(localComponentName, "payment");
            if ((localObject != null) && (((List)localObject).size() > 0))
            {
              int i = 0;
              while (i < ((List)localObject).size())
              {
                y.e("MicroMsg.HCEServiceMgr", "dynamicAIDList aid=" + (String)((List)localObject).get(i));
                i += 1;
              }
            }
          }
          else
          {
            dr(false);
            return;
          }
        }
        catch (Exception localException)
        {
          y.printErrStackTrace("MicroMsg.HCEServiceMgr", localException, "alvinluo HCEService register aid exception", new Object[0]);
          dr(false);
        }
      }
    }
  }
  
  @TargetApi(21)
  public final void ajJ()
  {
    if (this.gyz == null) {
      y.e("MicroMsg.HCEServiceMgr", "alvinluo mHceService is null fail to unregisterAids");
    }
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = NfcAdapter.getDefaultAdapter(this.gyz);
      } while ((localObject == null) || (Build.VERSION.SDK_INT < 21));
      localObject = CardEmulation.getInstance((NfcAdapter)localObject);
    } while (localObject == null);
    ComponentName localComponentName = new ComponentName(this.gyz, this.gyz.getClass());
    y.i("MicroMsg.HCEServiceMgr", "alvinluo HCEService unregister aids");
    ((CardEmulation)localObject).removeAidsForService(localComponentName, "payment");
  }
  
  public final void b(String paramString, int paramInt, Bundle paramBundle)
  {
    paramBundle.putString("key_appid", paramString);
    paramBundle.putInt("key_event_type", paramInt);
    y.i("MicroMsg.HCEServiceMgr", "alvinluo HCE EVENT mm to AppBrand");
    if (this.Cz != null) {
      this.Cz.send(10002, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.b
 * JD-Core Version:    0.7.0.1
 */