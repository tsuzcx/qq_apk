package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.nfc.NfcAdapter;
import android.nfc.cardemulation.CardEmulation;
import android.nfc.cardemulation.HostApduService;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

@TargetApi(19)
public final class b
{
  private static final byte[] hUY;
  public static b hVa;
  private static long mStartTime;
  ResultReceiver Di;
  ArrayList<String> hUR;
  boolean hUS;
  private boolean hUT;
  boolean hUU;
  boolean hUV;
  private a hUW;
  private com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.b hUX;
  HostApduService hUZ;
  int hUy;
  String mAppId;
  
  static
  {
    AppMethodBeat.i(137928);
    hUY = new byte[] { 0, 0 };
    mStartTime = -1L;
    hVa = null;
    hVa = new b();
    AppMethodBeat.o(137928);
  }
  
  public b()
  {
    AppMethodBeat.i(137919);
    this.mAppId = null;
    this.hUS = false;
    this.hUT = true;
    this.hUU = false;
    this.hUV = false;
    this.hUW = new b.a(this, (byte)0);
    this.hUX = new b((byte)0);
    AppMethodBeat.o(137919);
  }
  
  private void E(Bundle paramBundle)
  {
    AppMethodBeat.i(137926);
    ab.i("MicroMsg.HCEServiceMgr", "alvinluo HCE EVENT mm to AppBrand");
    if (this.Di != null) {
      this.Di.send(10002, paramBundle);
    }
    AppMethodBeat.o(137926);
  }
  
  /* Error */
  private void a(byte[] paramArrayOfByte, boolean paramBoolean, HostApduService paramHostApduService)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 112
    //   4: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 90
    //   9: ldc 114
    //   11: iconst_2
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: iload_2
    //   18: invokestatic 120	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   21: aastore
    //   22: dup
    //   23: iconst_1
    //   24: aload_0
    //   25: getfield 73	com/tencent/mm/plugin/appbrand/jsapi/nfc/hce/b:hUT	Z
    //   28: invokestatic 120	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   31: aastore
    //   32: invokestatic 123	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   35: aload_0
    //   36: getfield 73	com/tencent/mm/plugin/appbrand/jsapi/nfc/hce/b:hUT	Z
    //   39: ifeq +94 -> 133
    //   42: aload_0
    //   43: iconst_0
    //   44: putfield 73	com/tencent/mm/plugin/appbrand/jsapi/nfc/hce/b:hUT	Z
    //   47: invokestatic 129	java/lang/System:currentTimeMillis	()J
    //   50: lstore 4
    //   52: ldc 90
    //   54: ldc 131
    //   56: iconst_2
    //   57: anewarray 4	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: lload 4
    //   64: invokestatic 136	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   67: aastore
    //   68: dup
    //   69: iconst_1
    //   70: lload 4
    //   72: getstatic 56	com/tencent/mm/plugin/appbrand/jsapi/nfc/hce/b:mStartTime	J
    //   75: lsub
    //   76: invokestatic 136	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   79: aastore
    //   80: invokestatic 123	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: aload_3
    //   84: ifnull +57 -> 141
    //   87: aload_3
    //   88: aload_1
    //   89: invokevirtual 142	android/nfc/cardemulation/HostApduService:sendResponseApdu	([B)V
    //   92: iload_2
    //   93: ifeq +40 -> 133
    //   96: aload_0
    //   97: getfield 69	com/tencent/mm/plugin/appbrand/jsapi/nfc/hce/b:mAppId	Ljava/lang/String;
    //   100: astore_1
    //   101: ldc 144
    //   103: ldc 146
    //   105: iconst_1
    //   106: anewarray 4	java/lang/Object
    //   109: dup
    //   110: iconst_0
    //   111: aload_1
    //   112: aastore
    //   113: invokestatic 123	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: ldc 148
    //   118: invokestatic 154	com/tencent/luggage/a/e:r	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   121: checkcast 148	com/tencent/mm/plugin/appbrand/o/b
    //   124: sipush 14838
    //   127: aload_1
    //   128: invokeinterface 158 3 0
    //   133: ldc 112
    //   135: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: aload_0
    //   139: monitorexit
    //   140: return
    //   141: ldc 90
    //   143: ldc 160
    //   145: invokestatic 163	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: goto -56 -> 92
    //   151: astore_1
    //   152: aload_0
    //   153: monitorexit
    //   154: aload_1
    //   155: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	b
    //   0	156	1	paramArrayOfByte	byte[]
    //   0	156	2	paramBoolean	boolean
    //   0	156	3	paramHostApduService	HostApduService
    //   50	21	4	l	long
    // Exception table:
    //   from	to	target	type
    //   2	83	151	finally
    //   87	92	151	finally
    //   96	133	151	finally
    //   133	138	151	finally
    //   141	148	151	finally
  }
  
  private void ew(boolean paramBoolean)
  {
    AppMethodBeat.i(137922);
    Bundle localBundle = new Bundle();
    if (paramBoolean)
    {
      localBundle.putInt("errCode", 0);
      localBundle.putString("errMsg", "");
    }
    for (;;)
    {
      b(this.mAppId, 12, localBundle);
      AppMethodBeat.o(137922);
      return;
      localBundle.putInt("errCode", 13006);
      localBundle.putString("errMsg", "register aids failed");
    }
  }
  
  public final void a(int paramInt, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(137920);
    ab.i("MicroMsg.HCEServiceMgr", "alvinluo genCallHCEService type = %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(137920);
      return;
      if (this.hUW != null)
      {
        paramBundle = paramBundle.getString("key_apdu_command");
        this.hUW.co(paramString, paramBundle);
        AppMethodBeat.o(137920);
        return;
        if (this.hUW != null)
        {
          paramBundle = paramBundle.getString("key_apdu_command");
          this.hUW.cn(paramString, paramBundle);
          AppMethodBeat.o(137920);
          return;
          if (this.hUX != null)
          {
            this.hUX.onCreate();
            AppMethodBeat.o(137920);
            return;
            if (this.hUX != null)
            {
              this.hUX.onResume();
              AppMethodBeat.o(137920);
              return;
              if (this.hUX != null)
              {
                this.hUX.onPause();
                AppMethodBeat.o(137920);
                return;
                if (this.hUX != null)
                {
                  this.hUX.onDestroy();
                  AppMethodBeat.o(137920);
                  return;
                  aEh();
                  if (this.hUZ != null) {
                    this.hUZ.stopSelf();
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  @TargetApi(21)
  public final void aEg()
  {
    AppMethodBeat.i(137921);
    if ((this.hUR == null) || (this.hUZ == null))
    {
      ab.e("MicroMsg.HCEServiceMgr", "alvinluo mAidList is null, or mHceService is null fail to register");
      AppMethodBeat.o(137921);
      return;
    }
    Object localObject = NfcAdapter.getDefaultAdapter(this.hUZ);
    if (localObject == null)
    {
      ab.e("MicroMsg.HCEServiceMgr", "alvinluo NfcAdapter is null when register aids");
      AppMethodBeat.o(137921);
      return;
    }
    if (Build.VERSION.SDK_INT < 21)
    {
      ab.e("MicroMsg.HCEServiceMgr", "alvinluo android version: %d is not satisfied when register aids", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(137921);
      return;
    }
    localObject = CardEmulation.getInstance((NfcAdapter)localObject);
    if (localObject != null)
    {
      try
      {
        ComponentName localComponentName = new ComponentName(this.hUZ, this.hUZ.getClass());
        boolean bool = ((CardEmulation)localObject).registerAidsForService(localComponentName, "payment", this.hUR);
        ab.i("MicroMsg.HCEServiceMgr", "alvinluo register aids result: %b", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break label269;
        }
        ew(true);
        localObject = ((CardEmulation)localObject).getAidsForService(localComponentName, "payment");
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          int i = 0;
          while (i < ((List)localObject).size())
          {
            ab.e("MicroMsg.HCEServiceMgr", "dynamicAIDList aid=" + (String)((List)localObject).get(i));
            i += 1;
          }
        }
        AppMethodBeat.o(137921);
        return;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.HCEServiceMgr", localException, "alvinluo HCEService register aid exception", new Object[0]);
        ew(false);
      }
    }
    else
    {
      AppMethodBeat.o(137921);
      return;
    }
    label269:
    ew(false);
    AppMethodBeat.o(137921);
  }
  
  @TargetApi(21)
  public final void aEh()
  {
    AppMethodBeat.i(137924);
    if (this.hUZ == null)
    {
      ab.e("MicroMsg.HCEServiceMgr", "alvinluo mHceService is null fail to unregisterAids");
      AppMethodBeat.o(137924);
      return;
    }
    Object localObject = NfcAdapter.getDefaultAdapter(this.hUZ);
    if (localObject == null)
    {
      AppMethodBeat.o(137924);
      return;
    }
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(137924);
      return;
    }
    localObject = CardEmulation.getInstance((NfcAdapter)localObject);
    if (localObject != null)
    {
      ComponentName localComponentName = new ComponentName(this.hUZ, this.hUZ.getClass());
      ab.i("MicroMsg.HCEServiceMgr", "alvinluo HCEService unregister aids");
      ((CardEmulation)localObject).removeAidsForService(localComponentName, "payment");
    }
    AppMethodBeat.o(137924);
  }
  
  public final void b(String paramString, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(137923);
    paramBundle.putString("key_appid", paramString);
    paramBundle.putInt("key_event_type", paramInt);
    E(paramBundle);
    AppMethodBeat.o(137923);
  }
  
  final class b
    implements com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.b
  {
    private b() {}
    
    public final void onCreate()
    {
      AppMethodBeat.i(137915);
      ab.i("MicroMsg.HCEServiceMgr", "alvinluo HCELifeCycle AppBrandUI onCreate");
      AppMethodBeat.o(137915);
    }
    
    public final void onDestroy()
    {
      AppMethodBeat.i(137918);
      ab.i("MicroMsg.HCEServiceMgr", "alvinluo HCELifeCycle AppBrandUI onDestroy");
      AppMethodBeat.o(137918);
    }
    
    public final void onPause()
    {
      AppMethodBeat.i(137917);
      ab.i("MicroMsg.HCEServiceMgr", "alvinluo HCELifeCycle AppBrandUI onPause");
      b.this.aEh();
      b.b(b.this, true);
      AppMethodBeat.o(137917);
    }
    
    public final void onResume()
    {
      AppMethodBeat.i(137916);
      ab.i("MicroMsg.HCEServiceMgr", "alvinluo HCELifeCycle AppBrandUI onResume");
      if (b.i(b.this))
      {
        b.this.aEg();
        b.b(b.this, false);
      }
      AppMethodBeat.o(137916);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.b
 * JD-Core Version:    0.7.0.1
 */