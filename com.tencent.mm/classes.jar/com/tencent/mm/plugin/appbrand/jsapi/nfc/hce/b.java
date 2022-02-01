package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.nfc.NfcAdapter;
import android.nfc.cardemulation.CardEmulation;
import android.nfc.cardemulation.HostApduService;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.a;
import com.tencent.mm.plugin.appbrand.y.m;
import com.tencent.mm.plugin.appbrand.y.m.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.List;

@TargetApi(19)
public final class b
{
  private static final byte[] lco;
  public static b lcq;
  private static long mStartTime;
  ResultReceiver MK;
  int lbO;
  ArrayList<String> lch;
  boolean lci;
  private boolean lcj;
  boolean lck;
  boolean lcl;
  private a lcm;
  private com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.b lcn;
  HostApduService lcp;
  String mAppId;
  
  static
  {
    AppMethodBeat.i(136176);
    lco = new byte[] { 0, 0 };
    mStartTime = -1L;
    lcq = null;
    lcq = new b();
    AppMethodBeat.o(136176);
  }
  
  public b()
  {
    AppMethodBeat.i(136167);
    this.mAppId = null;
    this.lci = false;
    this.lcj = true;
    this.lck = false;
    this.lcl = false;
    this.lcm = new a((byte)0);
    this.lcn = new b((byte)0);
    AppMethodBeat.o(136167);
  }
  
  private void K(Bundle paramBundle)
  {
    AppMethodBeat.i(136174);
    ae.i("MicroMsg.HCEServiceMgr", "alvinluo HCE EVENT mm to AppBrand");
    if (this.MK != null) {
      this.MK.send(10002, paramBundle);
    }
    AppMethodBeat.o(136174);
  }
  
  /* Error */
  private void a(byte[] paramArrayOfByte, boolean paramBoolean, HostApduService paramHostApduService)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 112
    //   4: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 91
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
    //   25: getfield 74	com/tencent/mm/plugin/appbrand/jsapi/nfc/hce/b:lcj	Z
    //   28: invokestatic 120	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   31: aastore
    //   32: invokestatic 123	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   35: aload_0
    //   36: getfield 74	com/tencent/mm/plugin/appbrand/jsapi/nfc/hce/b:lcj	Z
    //   39: ifeq +94 -> 133
    //   42: aload_0
    //   43: iconst_0
    //   44: putfield 74	com/tencent/mm/plugin/appbrand/jsapi/nfc/hce/b:lcj	Z
    //   47: invokestatic 129	java/lang/System:currentTimeMillis	()J
    //   50: lstore 4
    //   52: ldc 91
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
    //   72: getstatic 57	com/tencent/mm/plugin/appbrand/jsapi/nfc/hce/b:mStartTime	J
    //   75: lsub
    //   76: invokestatic 136	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   79: aastore
    //   80: invokestatic 123	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: aload_3
    //   84: ifnull +57 -> 141
    //   87: aload_3
    //   88: aload_1
    //   89: invokevirtual 142	android/nfc/cardemulation/HostApduService:sendResponseApdu	([B)V
    //   92: iload_2
    //   93: ifeq +40 -> 133
    //   96: aload_0
    //   97: getfield 70	com/tencent/mm/plugin/appbrand/jsapi/nfc/hce/b:mAppId	Ljava/lang/String;
    //   100: astore_1
    //   101: ldc 144
    //   103: ldc 146
    //   105: iconst_1
    //   106: anewarray 4	java/lang/Object
    //   109: dup
    //   110: iconst_0
    //   111: aload_1
    //   112: aastore
    //   113: invokestatic 123	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: ldc 148
    //   118: invokestatic 154	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   121: checkcast 148	com/tencent/mm/plugin/appbrand/s/b
    //   124: sipush 14838
    //   127: aload_1
    //   128: invokeinterface 158 3 0
    //   133: ldc 112
    //   135: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: aload_0
    //   139: monitorexit
    //   140: return
    //   141: ldc 91
    //   143: ldc 160
    //   145: invokestatic 163	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
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
  
  private void gM(boolean paramBoolean)
  {
    AppMethodBeat.i(136170);
    Bundle localBundle = new Bundle();
    if (paramBoolean)
    {
      localBundle.putInt("errCode", 0);
      localBundle.putString("errMsg", "");
    }
    for (;;)
    {
      b(this.mAppId, 12, localBundle);
      AppMethodBeat.o(136170);
      return;
      localBundle.putInt("errCode", 13006);
      localBundle.putString("errMsg", "register aids failed");
    }
  }
  
  public final void a(int paramInt, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(136168);
    ae.i("MicroMsg.HCEServiceMgr", "alvinluo genCallHCEService type = %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(136168);
      return;
      if (this.lcm != null)
      {
        paramBundle = paramBundle.getString("key_apdu_command");
        this.lcm.dp(paramString, paramBundle);
        AppMethodBeat.o(136168);
        return;
        if (this.lcm != null)
        {
          paramBundle = paramBundle.getString("key_apdu_command");
          this.lcm.jdMethod_do(paramString, paramBundle);
          AppMethodBeat.o(136168);
          return;
          if (this.lcn != null)
          {
            this.lcn.onCreate();
            AppMethodBeat.o(136168);
            return;
            if (this.lcn != null)
            {
              this.lcn.onResume();
              AppMethodBeat.o(136168);
              return;
              if (this.lcn != null)
              {
                this.lcn.onPause();
                AppMethodBeat.o(136168);
                return;
                if (this.lcn != null)
                {
                  this.lcn.onDestroy();
                  AppMethodBeat.o(136168);
                  return;
                  bmu();
                  if (this.lcp != null) {
                    this.lcp.stopSelf();
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final void b(String paramString, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(136171);
    paramBundle.putString("key_appid", paramString);
    paramBundle.putInt("key_event_type", paramInt);
    K(paramBundle);
    AppMethodBeat.o(136171);
  }
  
  @TargetApi(21)
  public final void bmt()
  {
    AppMethodBeat.i(136169);
    if ((this.lch == null) || (this.lcp == null))
    {
      ae.e("MicroMsg.HCEServiceMgr", "alvinluo mAidList is null, or mHceService is null fail to register");
      AppMethodBeat.o(136169);
      return;
    }
    Object localObject = NfcAdapter.getDefaultAdapter(this.lcp);
    if (localObject == null)
    {
      ae.e("MicroMsg.HCEServiceMgr", "alvinluo NfcAdapter is null when register aids");
      AppMethodBeat.o(136169);
      return;
    }
    if (Build.VERSION.SDK_INT < 21)
    {
      ae.e("MicroMsg.HCEServiceMgr", "alvinluo android version: %d is not satisfied when register aids", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(136169);
      return;
    }
    localObject = CardEmulation.getInstance((NfcAdapter)localObject);
    if (localObject != null)
    {
      try
      {
        ComponentName localComponentName = new ComponentName(this.lcp, this.lcp.getClass());
        boolean bool = ((CardEmulation)localObject).registerAidsForService(localComponentName, "payment", this.lch);
        ae.i("MicroMsg.HCEServiceMgr", "alvinluo register aids result: %b", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break label275;
        }
        gM(true);
        localObject = ((CardEmulation)localObject).getAidsForService(localComponentName, "payment");
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          int i = 0;
          while (i < ((List)localObject).size())
          {
            ae.e("MicroMsg.HCEServiceMgr", "dynamicAIDList aid=" + (String)((List)localObject).get(i));
            i += 1;
          }
        }
        AppMethodBeat.o(136169);
        return;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.HCEServiceMgr", localException, "alvinluo HCEService register aid exception", new Object[0]);
        gM(false);
      }
    }
    else
    {
      AppMethodBeat.o(136169);
      return;
    }
    label275:
    gM(false);
    AppMethodBeat.o(136169);
  }
  
  @TargetApi(21)
  public final void bmu()
  {
    AppMethodBeat.i(136172);
    if (this.lcp == null)
    {
      ae.e("MicroMsg.HCEServiceMgr", "alvinluo mHceService is null fail to unregisterAids");
      AppMethodBeat.o(136172);
      return;
    }
    Object localObject = NfcAdapter.getDefaultAdapter(this.lcp);
    if (localObject == null)
    {
      AppMethodBeat.o(136172);
      return;
    }
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(136172);
      return;
    }
    localObject = CardEmulation.getInstance((NfcAdapter)localObject);
    if (localObject != null)
    {
      ComponentName localComponentName = new ComponentName(this.lcp, this.lcp.getClass());
      ae.i("MicroMsg.HCEServiceMgr", "alvinluo HCEService unregister aids");
      ((CardEmulation)localObject).removeAidsForService(localComponentName, "payment");
    }
    AppMethodBeat.o(136172);
  }
  
  final class a
    implements a
  {
    private a() {}
    
    public final void jdMethod_do(String paramString1, String paramString2)
    {
      AppMethodBeat.i(136161);
      ae.i("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND send to AppBrand, appId: %s, command: %s", new Object[] { paramString1, paramString2 });
      if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)))
      {
        ae.e("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND invalid appId or command when send request command to AppBrand");
        AppMethodBeat.o(136161);
        return;
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("key_apdu_command", paramString2);
      b.this.b(paramString1, 31, localBundle);
      b.a(b.this);
      if (!b.b(b.this))
      {
        b.c(b.this);
        b.a(b.this, false);
        b.access$502(System.currentTimeMillis());
        m.bCj().k(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(136160);
            ae.i("MicroMsg.HCEServiceMgr", "alvinluo HCEService timer check, timeLimit: %d, hasCommandNotResponded: %b", new Object[] { Integer.valueOf(b.d(b.this)), Boolean.valueOf(b.e(b.this)) });
            b.a(b.this, true);
            b.a(b.this, b.bmv(), true, b.f(b.this));
            AppMethodBeat.o(136160);
          }
        }, b.d(b.this));
        AppMethodBeat.o(136161);
        return;
      }
      if (b.g(b.this))
      {
        ae.w("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND TimeExceeded, just return default command");
        b.a(b.this, b.bmv(), true, b.f(b.this));
        b.a(b.this, false);
      }
      AppMethodBeat.o(136161);
    }
    
    public final void dp(String paramString1, String paramString2)
    {
      AppMethodBeat.i(136162);
      if ((b.h(b.this) == null) || (!b.h(b.this).equals(paramString1)) || (bu.isNullOrNil(paramString2)))
      {
        ae.e("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND not the same appId, or invalid response command, mAppId: %s, appId: %s, responseCommand: %s", new Object[] { b.h(b.this), paramString1, paramString2 });
        AppMethodBeat.o(136162);
        return;
      }
      byte[] arrayOfByte = Base64.decode(paramString2, 2);
      ae.i("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND response from AppBrand, appId: %s, command in base64: %s, send to system: %s, hasCommandNotResponded: %b", new Object[] { paramString1, paramString2, c.au(arrayOfByte), Boolean.valueOf(b.e(b.this)) });
      b.a(b.this, arrayOfByte, false, b.f(b.this));
      AppMethodBeat.o(136162);
    }
  }
  
  final class b
    implements com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.b
  {
    private b() {}
    
    public final void onCreate()
    {
      AppMethodBeat.i(136163);
      ae.i("MicroMsg.HCEServiceMgr", "alvinluo HCELifeCycle AppBrandUI onCreate");
      AppMethodBeat.o(136163);
    }
    
    public final void onDestroy()
    {
      AppMethodBeat.i(136166);
      ae.i("MicroMsg.HCEServiceMgr", "alvinluo HCELifeCycle AppBrandUI onDestroy");
      AppMethodBeat.o(136166);
    }
    
    public final void onPause()
    {
      AppMethodBeat.i(136165);
      ae.i("MicroMsg.HCEServiceMgr", "alvinluo HCELifeCycle AppBrandUI onPause");
      b.this.bmu();
      b.b(b.this, true);
      AppMethodBeat.o(136165);
    }
    
    public final void onResume()
    {
      AppMethodBeat.i(136164);
      ae.i("MicroMsg.HCEServiceMgr", "alvinluo HCELifeCycle AppBrandUI onResume");
      if (b.i(b.this))
      {
        b.this.bmt();
        b.b(b.this, false);
      }
      AppMethodBeat.o(136164);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.b
 * JD-Core Version:    0.7.0.1
 */