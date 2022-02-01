package com.tencent.mars;

import android.content.Context;
import com.tencent.mars.comm.PlatformComm;
import com.tencent.mm.app.o.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;
import java.util.ArrayList;
import java.util.Arrays;

public class Mars
{
  private static final int CertVersion_Mainland = 1;
  private static final int CertVersion_WeChatUS = 2;
  private static final o.a appForegroundListener = new o.a()
  {
    public final void onAppBackground(String paramAnonymousString)
    {
      Mars.onForeground(false);
    }
    
    public final void onAppForeground(String paramAnonymousString)
    {
      Mars.onForeground(true);
    }
  };
  private static volatile boolean hasInitialized = false;
  public static final String libMarsBase = "wechatbase";
  public static final String libMarsHttp = "wechathttp";
  public static final String libMarsMM = "wechatmm";
  public static final String libMarsNetwork = "wechatnetwork";
  private static ArrayList<String[]> libModules = new ArrayList();
  
  public static void checkLoadedModules(ArrayList<String> paramArrayList, String paramString)
  {
    label7:
    if (paramArrayList == null)
    {
      break label167;
      break label167;
    }
    for (;;)
    {
      int i;
      try
      {
        String[] arrayOfString = new String[0];
        Log.i(paramString, "loaded modules: " + Arrays.toString(paramArrayList.toArray(arrayOfString)));
        Arrays.sort(arrayOfString);
        libModules.add(arrayOfString);
        j = 0;
        i = 1;
        if (j >= libModules.size()) {
          break label194;
        }
        if (Arrays.equals((Object[])libModules.get(j), (Object[])libModules.get(0))) {
          break label187;
        }
        i = 0;
      }
      finally {}
      int j = i;
      int k;
      int m;
      if (k < libModules.size())
      {
        m = k + 1;
        if (m >= libModules.size()) {
          break label228;
        }
        if (hasInterSection((String[])libModules.get(k), (String[])libModules.get(m))) {
          break label223;
        }
        j = 1;
      }
      else
      {
        label167:
        if (j != 0) {
          break label7;
        }
        throw new IllegalStateException("mars lib module custom made error, pls check your *.so.");
        label187:
        j += 1;
        continue;
        label194:
        j = i;
        if (i != 0) {
          break;
        }
        k = 0;
        continue;
      }
      for (;;)
      {
        i = j;
        if (j == 0) {
          break label228;
        }
        m += 1;
        i = j;
        break;
        label223:
        j = 0;
      }
      label228:
      j = i;
      if (i == 0) {
        break;
      }
      k += 1;
    }
  }
  
  public static int currentCertVer()
  {
    switch (WeChatBrands.AppInfo.current().getDefaultXAgreementId())
    {
    case 0: 
    case 1: 
    case 2: 
    default: 
      return 1;
    }
    return 2;
  }
  
  private static boolean hasInterSection(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    boolean bool2 = false;
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfString1.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramArrayOfString1[i]);
      i += 1;
    }
    j = paramArrayOfString2.length;
    i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (localArrayList.contains(paramArrayOfString2[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static void init(Context paramContext, MMHandler paramMMHandler)
  {
    PlatformComm.init(paramContext, paramMMHandler);
    hasInitialized = true;
  }
  
  private static void initCert()
  {
    onInit(currentCertVer());
  }
  
  public static void loadDefaultMarsLibrary()
  {
    try
    {
      System.loadLibrary("c++_shared");
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void onCreate()
  {
    initCert();
    BaseEvent.onCreate();
  }
  
  public static void onCreate(boolean paramBoolean)
  {
    if ((paramBoolean) && (hasInitialized)) {
      onCreate();
    }
    for (;;)
    {
      appForegroundListener.alive();
      return;
      if (paramBoolean) {
        break;
      }
      onCreate();
    }
    throw new IllegalStateException("function MarsCore.init must be executed before Mars.onCreate when application firststartup.");
  }
  
  public static void onDestroy()
  {
    onDestroyImpl();
    appForegroundListener.dead();
  }
  
  private static void onDestroyImpl() {}
  
  public static void onExceptionCrash() {}
  
  public static void onForeground(boolean paramBoolean)
  {
    BaseEvent.onForeground(paramBoolean);
  }
  
  private static void onInit(int paramInt)
  {
    Log.i("MicroMsg.Mars", "packerEncoderVersion %s", new Object[] { Integer.valueOf(paramInt) });
    BaseEvent.onInitConfigBeforeOnCreate(paramInt);
  }
  
  public static void onNetworkChange() {}
  
  public static void onSingalCrash(int paramInt)
  {
    BaseEvent.onSingalCrash(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mars.Mars
 * JD-Core Version:    0.7.0.1
 */