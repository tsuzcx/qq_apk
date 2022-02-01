package com.qcloud.qvb;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.qcloud.qvb.a.a.b;
import com.qcloud.qvb.a.a.c;
import com.qcloud.qvb.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public final class XNet
{
  private static String SDK_VERSION;
  static final String TAG;
  private static WeakReference<Context> appCtx;
  private static String archCpuAbi;
  private static String cacheDir;
  private static String filesDir;
  private static boolean sIsSoLoaded;
  private byte _hellAccFlag_;
  
  static
  {
    AppMethodBeat.i(207612);
    TAG = "[TencentXP2P][" + XNet.class.getSimpleName() + "]";
    archCpuAbi = "";
    appCtx = null;
    sIsSoLoaded = false;
    cacheDir = null;
    filesDir = null;
    AppMethodBeat.o(207612);
  }
  
  private static native void _alias(String paramString1, String paramString2);
  
  private static native long _construct(String paramString1, String paramString2, String paramString3, String paramString4, Context paramContext);
  
  private static native void _destroy();
  
  private static native void _disableDebug();
  
  private static native void _enableDebug();
  
  private static native String _host();
  
  private static native void _resume();
  
  private static native void _setInfo(String paramString1, String paramString2, String paramString3);
  
  private static native void _setLogger();
  
  private static native String _targetArchABI();
  
  private static native String _version();
  
  public static void alias(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207455);
    if (sIsSoLoaded) {
      _alias(paramString1, paramString2);
    }
    AppMethodBeat.o(207455);
  }
  
  public static int create(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(207463);
    if ((paramContext != null) && (paramString1 != null) && (paramString2 != null) && (paramString3 != null) && (paramString4 != null))
    {
      appCtx = new WeakReference(paramContext);
      loadLibrary(paramContext);
      int i = (int)_construct(paramString1, paramString2, paramString3, paramString4, ((ContextWrapper)paramContext).getBaseContext());
      paramContext = paramContext.getApplicationContext().getSharedPreferences("BuglySdkInfos", 0).edit();
      paramContext.putString("e30245116c", getVersion());
      paramContext.apply();
      AppMethodBeat.o(207463);
      return i;
    }
    paramContext = new NullPointerException("context or appId or appKey or appSecretKey or requestToken can't be null when init p2p live stream!");
    AppMethodBeat.o(207463);
    throw paramContext;
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(207472);
    if (sIsSoLoaded) {
      _destroy();
    }
    AppMethodBeat.o(207472);
  }
  
  public static void disableDebug()
  {
    AppMethodBeat.i(207524);
    if (sIsSoLoaded) {
      _disableDebug();
    }
    AppMethodBeat.o(207524);
  }
  
  public static void enableDebug()
  {
    AppMethodBeat.i(207518);
    if (sIsSoLoaded) {
      _enableDebug();
    }
    AppMethodBeat.o(207518);
  }
  
  private static String getArchABI()
  {
    AppMethodBeat.i(207511);
    if ((archCpuAbi.isEmpty()) && (sIsSoLoaded)) {
      archCpuAbi = _targetArchABI();
    }
    if (isArchValid(archCpuAbi))
    {
      String str = archCpuAbi;
      AppMethodBeat.o(207511);
      return str;
    }
    AppMethodBeat.o(207511);
    return "";
  }
  
  private static String getCacheDir()
  {
    AppMethodBeat.i(207491);
    Object localObject = cacheDir;
    if (localObject != null)
    {
      AppMethodBeat.o(207491);
      return localObject;
    }
    localObject = (Context)appCtx.get();
    if (localObject != null)
    {
      localObject = ((Context)localObject).getCacheDir().getAbsolutePath();
      AppMethodBeat.o(207491);
      return localObject;
    }
    AppMethodBeat.o(207491);
    return "/";
  }
  
  private static String getDiskDir()
  {
    AppMethodBeat.i(207608);
    Object localObject = filesDir;
    if (localObject != null)
    {
      AppMethodBeat.o(207608);
      return localObject;
    }
    localObject = (Context)appCtx.get();
    if (localObject != null)
    {
      localObject = ((Context)localObject).getFilesDir().getAbsolutePath();
      AppMethodBeat.o(207608);
      return localObject;
    }
    AppMethodBeat.o(207608);
    return "/";
  }
  
  public static String getHost()
  {
    AppMethodBeat.i(207445);
    if (sIsSoLoaded)
    {
      String str = _host();
      AppMethodBeat.o(207445);
      return str;
    }
    AppMethodBeat.o(207445);
    return "";
  }
  
  public static String getVersion()
  {
    AppMethodBeat.i(207497);
    if ((sIsSoLoaded) && (SDK_VERSION == null)) {
      SDK_VERSION = _version();
    }
    String str = SDK_VERSION;
    AppMethodBeat.o(207497);
    return str;
  }
  
  private static boolean isArchValid(String paramString)
  {
    AppMethodBeat.i(207503);
    boolean bool = Arrays.asList(com.qcloud.qvb.a.a.dYz).contains(paramString);
    AppMethodBeat.o(207503);
    return bool;
  }
  
  private static void loadLibrary(Context paramContext)
  {
    AppMethodBeat.i(207605);
    try
    {
      paramContext = new com.tencent.mm.hellhoundlib.b.a().cG("AdvanceP2P");
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject, paramContext.aYi(), "com/qcloud/qvb/XNet", "loadLibrary", "(Landroid/content/Context;)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      System.loadLibrary((String)paramContext.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/qcloud/qvb/XNet", "loadLibrary", "(Landroid/content/Context;)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      sIsSoLoaded = true;
      paramContext = "load library failed.";
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      while (!TextUtils.isEmpty(paramContext.getMessage())) {
        paramContext = paramContext.getMessage();
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        if (!TextUtils.isEmpty(paramContext.getMessage()))
        {
          paramContext = paramContext.getMessage();
          continue;
          paramContext = new Exception(paramContext);
          AppMethodBeat.o(207605);
          throw paramContext;
        }
        else
        {
          paramContext = "load library failed.";
        }
      }
    }
    if (sIsSoLoaded)
    {
      AppMethodBeat.o(207605);
      return;
    }
  }
  
  private static boolean loadSoFromSdcard(com.qcloud.qvb.a.a parama)
  {
    AppMethodBeat.i(207601);
    for (;;)
    {
      int i;
      File localFile;
      String[] arrayOfString;
      try
      {
        boolean bool = parama.dYD.isEmpty();
        if (bool)
        {
          parama = null;
          if (parama == null)
          {
            AppMethodBeat.o(207601);
            return false;
          }
        }
        else
        {
          localObject = new File(parama.basePath).listFiles(new a.b(parama));
          int j = localObject.length;
          i = 0;
          if (i < j)
          {
            parama.deleteDir(localObject[i]);
            i += 1;
            continue;
          }
          str2 = "";
          str1 = "";
          File[] arrayOfFile = new File(parama.dYA).listFiles(new a.c("libAdvanceP2P"));
          j = arrayOfFile.length;
          i = 0;
          localObject = null;
          if (i < j)
          {
            localFile = arrayOfFile[i];
            arrayOfString = localFile.getName().split("_");
            if ((arrayOfString.length != 3) || (arrayOfString[1].compareTo(str2) <= 0)) {
              break label315;
            }
            if (localObject == null) {
              break label292;
            }
            ((File)localObject).delete();
            break label292;
          }
          if (localObject == null) {
            break label318;
          }
          str2 = b.a((File)localObject);
          if (!(str2 + ".so").toLowerCase(Locale.US).equals(str1.toLowerCase(Locale.US))) {
            break label318;
          }
          parama = parama.dYA + File.separator + ((File)localObject).getName();
          continue;
        }
        System.load(parama);
      }
      finally
      {
        AppMethodBeat.o(207601);
        return false;
      }
      label292:
      String str2 = arrayOfString[1];
      String str1 = arrayOfString[2];
      Object localObject = localFile;
      label315:
      for (;;)
      {
        i += 1;
        break;
      }
      label318:
      parama = null;
    }
  }
  
  public static String proxyOf(String paramString)
  {
    AppMethodBeat.i(207481);
    String str = getHost();
    if (str.isEmpty())
    {
      AppMethodBeat.o(207481);
      return "";
    }
    paramString = str + "/" + paramString + "/";
    AppMethodBeat.o(207481);
    return paramString;
  }
  
  public static boolean resume()
  {
    AppMethodBeat.i(207537);
    if (sIsSoLoaded)
    {
      _resume();
      AppMethodBeat.o(207537);
      return true;
    }
    AppMethodBeat.o(207537);
    return false;
  }
  
  public static void setCacheDir(String paramString)
  {
    cacheDir = paramString;
  }
  
  public static void setFilesDir(String paramString)
  {
    filesDir = paramString;
  }
  
  public static void setInfo(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(207545);
    if ((paramString1 != null) && (paramString2 != null) && (paramString3 != null))
    {
      if (sIsSoLoaded) {
        _setInfo(paramString1, paramString2, paramString3);
      }
      AppMethodBeat.o(207545);
      return;
    }
    paramString1 = new NullPointerException("appId or appKey or appSecretKey can't be null!");
    AppMethodBeat.o(207545);
    throw paramString1;
  }
  
  public static void setLoggerCallback(LoggerCallback paramLoggerCallback)
  {
    AppMethodBeat.i(207529);
    LoggerCallback.setLoggerCallback(paramLoggerCallback);
    if (sIsSoLoaded) {
      _setLogger();
    }
    AppMethodBeat.o(207529);
  }
  
  protected final void onEvent(int paramInt, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.qcloud.qvb.XNet
 * JD-Core Version:    0.7.0.1
 */