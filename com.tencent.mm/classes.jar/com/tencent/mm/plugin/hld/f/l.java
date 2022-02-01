package com.tencent.mm.plugin.hld.f;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.hld.a.j;
import com.tencent.mm.plugin.hld.b.e.a;
import com.tencent.mm.plugin.hld.model.WxImeInterService;
import com.tencent.mm.plugin.hld.model.n;
import com.tencent.mm.plugin.hld.model.o;
import com.tencent.mm.plugin.hld.view.ImeKeyRelativeLayout;
import com.tencent.mm.protocal.protobuf.dbp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.vfs.y;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/utils/WxImeUtil;", "", "()V", "TAG", "", "lastNoInitFinishTimestamp", "", "getLastNoInitFinishTimestamp", "()J", "setLastNoInitFinishTimestamp", "(J)V", "checkDictValid", "", "dict", "Lcom/tencent/mm/protocal/protobuf/ImeLocalCloudDict;", "checkFetchFirstCloudResDownload", "", "checkInInputMethodList", "checkPermission", "permissions", "", "([Ljava/lang/String;)Z", "clearUserData", "closeIme", "context", "Landroid/content/Context;", "defaultIme", "disabledIme", "enableIme", "filterEnableIme", "finishActiveFifthProcess", "finishActiveFirstProcess", "finishActiveSecondProcess", "finishFirstCloudResDownload", "getAssetsCacheFile", "assetDirName", "fileName", "getBitmapCachePath", "isLandscape", "getBitmapCachePathByKeyboard", "ordinal", "", "getCPUInfo", "getCloudResPathByName", "name", "getCurIme", "getDefaultModeConfig", "getDialogType", "getEmojiImagPath", "getEngineProcessStr", "processType", "Lcom/tencent/mm/plugin/hld/model/ImeProcessInputType;", "keyParam", "Lcom/tencent/mm/plugin/hld/api/ImeKeyParam;", "getFinishFirstCloudResStatus", "getImeState", "getInvalidUserKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKV", "getRecoveryConfig", "getStatusBarHeight", "getTotalMemory", "getTotalRAMMemory", "getTotalROMMemory", "getUserDictPath", "getUserKV", "getUserPath", "getWxImeCachePath", "getWxImeCommonUserPath", "getWxImeEnginePath", "safetyMode", "getWxImeNetworkPath", "getWxImePath", "getWxImeUserPath", "goToContactInfoUI", "ifShowOldUserGuideView", "inInputMethodListBySystem", "isActionKey", "view", "Lcom/tencent/mm/plugin/hld/view/ImeKeyRelativeLayout;", "isCurrentIme", "isDefaultIme", "isDeleteKey", "isEmptyEditText", "isEnoughSpace", "size", "isExptImeVisible", "isFinishActiveFifthProcess", "isFinishActiveFirstProcess", "isFinishActiveSecondProcess", "isFirstFetchRes", "isImeActive", "isImeCurActive", "isImeEnable", "isImeInstall", "isInImeList", "isLocalFinishActiveFifthProcess", "isLocalFinishActiveFirstProcess", "isLocalFinishActiveSecondProcess", "isLogin", "isSafetyKeyboard", "killImeProcess", "killProcess", "pid", "printDict", "printList", "T", "rets", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "arg", "printUserClickData", "tag", "content", "resetActiveProcess", "setDefaultIme", "default", "showNoInitFinishToast", "showNoSupportToast", "switchToDefaultIme", "close", "triggerNewTips", "unFinishFirstCloudResDownload", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  public static final l JyV;
  private static long JyW;
  
  static
  {
    AppMethodBeat.i(312126);
    JyV = new l();
    AppMethodBeat.o(312126);
  }
  
  /* Error */
  public static String L(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 181
    //   2: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 182
    //   8: invokestatic 188	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_1
    //   12: ldc 189
    //   14: invokestatic 188	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   17: aload_2
    //   18: ldc 190
    //   20: invokestatic 188	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   23: getstatic 196	com/tencent/mm/plugin/hld/f/f:Jyn	Lcom/tencent/mm/plugin/hld/f/f;
    //   26: astore 4
    //   28: new 198	com/tencent/mm/vfs/u
    //   31: dup
    //   32: invokestatic 202	com/tencent/mm/plugin/hld/f/f:fOg	()Ljava/lang/String;
    //   35: aload_2
    //   36: invokespecial 205	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: astore 4
    //   41: aload 4
    //   43: invokevirtual 209	com/tencent/mm/vfs/u:jKS	()Z
    //   46: ifeq +19 -> 65
    //   49: aload 4
    //   51: invokevirtual 213	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   54: invokestatic 219	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   57: astore_0
    //   58: ldc 181
    //   60: invokestatic 151	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aload_0
    //   64: areturn
    //   65: aload_0
    //   66: invokevirtual 225	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   69: aload_1
    //   70: aload_2
    //   71: invokestatic 229	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   74: invokevirtual 235	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   77: astore_0
    //   78: aload_0
    //   79: ldc 237
    //   81: invokestatic 240	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   84: aload_0
    //   85: checkcast 242	java/io/Closeable
    //   88: astore_0
    //   89: aload_0
    //   90: checkcast 244	java/io/InputStream
    //   93: astore_2
    //   94: aload 4
    //   96: invokestatic 250	com/tencent/mm/vfs/y:ap	(Lcom/tencent/mm/vfs/u;)Ljava/io/OutputStream;
    //   99: astore_1
    //   100: aload_1
    //   101: ldc 252
    //   103: invokestatic 240	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   106: aload_1
    //   107: checkcast 242	java/io/Closeable
    //   110: astore_1
    //   111: aload_1
    //   112: checkcast 254	java/io/OutputStream
    //   115: astore 5
    //   117: sipush 1024
    //   120: newarray byte
    //   122: astore 6
    //   124: aload_2
    //   125: aload 6
    //   127: invokevirtual 258	java/io/InputStream:read	([B)I
    //   130: istore_3
    //   131: iload_3
    //   132: ifle +134 -> 266
    //   135: aload 5
    //   137: aload 6
    //   139: iconst_0
    //   140: iload_3
    //   141: invokevirtual 262	java/io/OutputStream:write	([BII)V
    //   144: goto -20 -> 124
    //   147: astore_2
    //   148: ldc 181
    //   150: invokestatic 151	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: aload_2
    //   154: athrow
    //   155: astore 5
    //   157: aload_1
    //   158: aload_2
    //   159: invokestatic 268	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   162: ldc 181
    //   164: invokestatic 151	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: aload 5
    //   169: athrow
    //   170: astore_1
    //   171: ldc 181
    //   173: invokestatic 151	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   176: aload_1
    //   177: athrow
    //   178: astore_2
    //   179: aload_0
    //   180: aload_1
    //   181: invokestatic 268	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   184: ldc 181
    //   186: invokestatic 151	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: aload_2
    //   190: athrow
    //   191: astore_0
    //   192: ldc_w 270
    //   195: new 272	java/lang/StringBuilder
    //   198: dup
    //   199: ldc_w 274
    //   202: invokespecial 277	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   205: aload_0
    //   206: invokevirtual 281	java/lang/Object:getClass	()Ljava/lang/Class;
    //   209: invokevirtual 286	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   212: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   215: bipush 32
    //   217: invokevirtual 293	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   220: aload_0
    //   221: invokevirtual 296	java/io/IOException:getMessage	()Ljava/lang/String;
    //   224: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 304	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   233: ldc_w 270
    //   236: ldc_w 274
    //   239: aload 4
    //   241: invokevirtual 308	com/tencent/mm/vfs/u:jKU	()Lcom/tencent/mm/vfs/u;
    //   244: invokestatic 229	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   247: invokestatic 310	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: aload 4
    //   252: invokevirtual 213	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   255: invokestatic 219	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   258: astore_0
    //   259: ldc 181
    //   261: invokestatic 151	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   264: aload_0
    //   265: areturn
    //   266: getstatic 316	kotlin/ah:aiuX	Lkotlin/ah;
    //   269: astore_2
    //   270: aload_1
    //   271: aconst_null
    //   272: invokestatic 268	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   275: getstatic 316	kotlin/ah:aiuX	Lkotlin/ah;
    //   278: astore_1
    //   279: aload_0
    //   280: aconst_null
    //   281: invokestatic 268	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   284: goto -51 -> 233
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	paramContext	Context
    //   0	287	1	paramString1	String
    //   0	287	2	paramString2	String
    //   130	11	3	i	int
    //   26	225	4	localObject1	Object
    //   115	21	5	localOutputStream	java.io.OutputStream
    //   155	13	5	localObject2	Object
    //   122	16	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   111	124	147	finally
    //   124	131	147	finally
    //   135	144	147	finally
    //   266	270	147	finally
    //   148	155	155	finally
    //   89	111	170	finally
    //   157	170	170	finally
    //   270	279	170	finally
    //   171	178	178	finally
    //   65	89	191	java/io/IOException
    //   179	191	191	java/io/IOException
    //   279	284	191	java/io/IOException
  }
  
  public static boolean L(String[] paramArrayOfString)
  {
    AppMethodBeat.i(311954);
    s.u(paramArrayOfString, "permissions");
    int j = paramArrayOfString.length;
    int i = 0;
    boolean bool = true;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      i += 1;
      if ((bool) && (com.tencent.mm.pluginsdk.permission.b.k(MMApplicationContext.getContext(), str, false))) {
        bool = true;
      } else {
        bool = false;
      }
    }
    AppMethodBeat.o(311954);
    return bool;
  }
  
  public static String b(com.tencent.mm.plugin.hld.model.h paramh, com.tencent.mm.plugin.hld.a.g paramg)
  {
    AppMethodBeat.i(312046);
    s.u(paramh, "processType");
    String str = "";
    if (paramg == null)
    {
      paramh = null;
      paramg = str;
    }
    for (;;)
    {
      if (paramh == null) {
        Log.e("WxIme.ImeKeyboardActionListener", "getEngineProcessStr keyParam is null");
      }
      AppMethodBeat.o(312046);
      return paramg;
      paramg = paramh.value + ' ' + paramg.text;
      paramh = ah.aiuX;
    }
  }
  
  public static <T> String b(List<? extends T> paramList, kotlin.g.a.b<? super T, String> paramb)
  {
    AppMethodBeat.i(312054);
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("[");
    if (paramList != null)
    {
      Iterator localIterator = ((Iterable)paramList).iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (localObject == null)
        {
          paramList = null;
          if (paramList == null) {
            localStringBuilder2.append("null");
          }
          localStringBuilder2.append(" ");
        }
        else
        {
          if (paramb == null) {}
          for (StringBuilder localStringBuilder1 = null;; localStringBuilder1 = localStringBuilder2.append((String)paramb.invoke(localObject)))
          {
            paramList = localStringBuilder1;
            if (localStringBuilder1 != null) {
              break;
            }
            paramList = localStringBuilder2.append(localObject.toString());
            break;
          }
        }
      }
    }
    localStringBuilder2.append("]");
    paramList = localStringBuilder2.toString();
    s.s(paramList, "result.toString()");
    AppMethodBeat.o(312054);
    return paramList;
  }
  
  public static boolean bGa()
  {
    AppMethodBeat.i(311994);
    if (com.tencent.mm.kernel.b.aZQ() != 0)
    {
      AppMethodBeat.o(311994);
      return true;
    }
    AppMethodBeat.o(311994);
    return false;
  }
  
  public static boolean e(ImeKeyRelativeLayout paramImeKeyRelativeLayout)
  {
    AppMethodBeat.i(311651);
    s.u(paramImeKeyRelativeLayout, "view");
    if (((paramImeKeyRelativeLayout.getType() & 0x2) == 2) && (paramImeKeyRelativeLayout.getFunctionCode() == 1))
    {
      AppMethodBeat.o(311651);
      return true;
    }
    AppMethodBeat.o(311651);
    return false;
  }
  
  private static final void f(IPCVoid paramIPCVoid, com.tencent.mm.ipcinvoker.f paramf)
  {
    AppMethodBeat.i(312097);
    s.u(paramIPCVoid, "$noName_0");
    s.u(paramf, "$noName_1");
    if (com.tencent.mm.kernel.h.baC().aZN())
    {
      com.tencent.mm.plugin.newtips.a.gtf();
      com.tencent.mm.plugin.newtips.a.i.aPW(com.tencent.mm.plugin.newtips.a.d.Msw);
      AppMethodBeat.o(312097);
      return;
    }
    Log.i("WxIme.WxImeUtil", "registerLocalNewTips no login ");
    AppMethodBeat.o(312097);
  }
  
  public static boolean f(ImeKeyRelativeLayout paramImeKeyRelativeLayout)
  {
    AppMethodBeat.i(311658);
    s.u(paramImeKeyRelativeLayout, "view");
    if (((paramImeKeyRelativeLayout.getType() & 0x2) == 2) && (paramImeKeyRelativeLayout.getFunctionCode() == 2))
    {
      AppMethodBeat.o(311658);
      return true;
    }
    AppMethodBeat.o(311658);
    return false;
  }
  
  public static boolean fKH()
  {
    AppMethodBeat.i(311989);
    com.tencent.mm.plugin.hld.a.d locald = (com.tencent.mm.plugin.hld.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.hld.a.d.class);
    if ((locald != null) && (locald.fKH() == true))
    {
      AppMethodBeat.o(311989);
      return true;
    }
    AppMethodBeat.o(311989);
    return false;
  }
  
  public static boolean fKJ()
  {
    AppMethodBeat.i(312009);
    Object localObject = new Intent("android.settings.INPUT_METHOD_SETTINGS");
    localObject = MMApplicationContext.getContext().getPackageManager().queryIntentActivities((Intent)localObject, 32);
    s.s(localObject, "getContext().packageMana…nager.GET_INTENT_FILTERS)");
    Log.i("WxIme.WxImeUtil", "filterEnableIme resolveInfos.size:%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
    if (((List)localObject).size() <= 0)
    {
      localObject = com.tencent.mm.plugin.hld.model.k.JvH;
      com.tencent.mm.plugin.hld.model.k.d(1, 0, null, 12);
      AppMethodBeat.o(312009);
      return true;
    }
    AppMethodBeat.o(312009);
    return false;
  }
  
  public static boolean fKK()
  {
    AppMethodBeat.i(312027);
    Object localObject1 = MMApplicationContext.getContext().getSystemService("input_method");
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      AppMethodBeat.o(312027);
      throw ((Throwable)localObject1);
    }
    localObject1 = ((InputMethodManager)localObject1).getInputMethodList();
    if (localObject1 == null) {}
    for (int i = 0;; i = ((List)localObject1).size())
    {
      Log.i("WxIme.WxImeUtil", s.X("inInputMethodList inputMethodList.size", Integer.valueOf(i)));
      localObject1 = ((List)localObject1).iterator();
      Object localObject2;
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label168;
        }
        localObject2 = (InputMethodInfo)((Iterator)localObject1).next();
        Log.i("WxIme.WxImeUtil", s.X("inInputMethodList ", ((InputMethodInfo)localObject2).getId()));
        Object localObject3 = ((InputMethodInfo)localObject2).getId();
        o localo = o.Jwm;
        if (s.p(localObject3, o.fNf())) {
          break;
        }
        localObject2 = ((InputMethodInfo)localObject2).getId();
        localObject3 = o.Jwm;
      } while (!s.p(localObject2, o.fNg()));
      AppMethodBeat.o(312027);
      return true;
    }
    label168:
    Log.e("WxIme.WxImeUtil", "inInputMethodList false!!!");
    localObject1 = com.tencent.mm.plugin.hld.model.k.JvH;
    com.tencent.mm.plugin.hld.model.k.d(2, 0, null, 12);
    AppMethodBeat.o(312027);
    return false;
  }
  
  public static void fKL()
  {
    int j = 0;
    AppMethodBeat.i(312017);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("wx_ime");
    int i = j;
    if (localMultiProcessMMKV != null)
    {
      i = j;
      if (!localMultiProcessMMKV.getBoolean("ime_if_check_input_method_list", false)) {
        i = 1;
      }
    }
    if (i == 0)
    {
      AppMethodBeat.o(312017);
      return;
    }
    localMultiProcessMMKV = MultiProcessMMKV.getMMKV("wx_ime");
    if (localMultiProcessMMKV != null) {
      localMultiProcessMMKV.putBoolean("ime_if_check_input_method_list", true);
    }
    new Thread(l..ExternalSyntheticLambda3.INSTANCE).start();
    AppMethodBeat.o(312017);
  }
  
  public static String fOC()
  {
    AppMethodBeat.i(311559);
    String str = s.X(com.tencent.mm.loader.i.b.bmr(), "wxime");
    if (!y.ZC(str)) {
      y.bDX(str);
    }
    AppMethodBeat.o(311559);
    return str;
  }
  
  public static String fOD()
  {
    AppMethodBeat.i(311570);
    int i = com.tencent.mm.kernel.b.aZQ();
    if (i == 0)
    {
      AppMethodBeat.o(311570);
      return null;
    }
    Object localObject1 = new StringBuilder().append(fOC()).append('/');
    Object localObject2 = s.X("ime_", Integer.valueOf(i));
    Charset localCharset = kotlin.n.d.UTF_8;
    if (localObject2 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(311570);
      throw ((Throwable)localObject1);
    }
    localObject2 = ((String)localObject2).getBytes(localCharset);
    s.s(localObject2, "(this as java.lang.String).getBytes(charset)");
    localObject1 = com.tencent.mm.b.g.getMessageDigest((byte[])localObject2);
    if (!y.ZC((String)localObject1)) {
      y.bDX((String)localObject1);
    }
    AppMethodBeat.o(311570);
    return localObject1;
  }
  
  public static String fOE()
  {
    AppMethodBeat.i(311579);
    String str = s.X(com.tencent.mm.loader.i.b.bmr(), "wxime/cache");
    if (!y.ZC(str)) {
      y.bDX(str);
    }
    AppMethodBeat.o(311579);
    return str;
  }
  
  public static String fOF()
  {
    AppMethodBeat.i(311592);
    String str = s.X(fOC(), "/emoji_res");
    if (!y.ZC(str)) {
      y.bDX(str);
    }
    AppMethodBeat.o(311592);
    return str;
  }
  
  public static int fOG()
  {
    return 1003;
  }
  
  public static boolean fOH()
  {
    AppMethodBeat.i(311644);
    Object localObject = (com.tencent.mm.plugin.hld.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.hld.a.d.class);
    if (localObject == null) {
      localObject = null;
    }
    while (localObject == null)
    {
      AppMethodBeat.o(311644);
      return false;
      localObject = ((com.tencent.mm.plugin.hld.a.d)localObject).fKG();
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((com.tencent.mm.plugin.hld.a.b)localObject).Yk(1);
      }
    }
    if ((Util.isNullOrNil(((com.tencent.mm.plugin.hld.a.e)localObject).JnB)) && (Util.isNullOrNil(((com.tencent.mm.plugin.hld.a.e)localObject).JnD)) && (Util.isNullOrNil(((com.tencent.mm.plugin.hld.a.e)localObject).JnC)))
    {
      AppMethodBeat.o(311644);
      return true;
    }
    AppMethodBeat.o(311644);
    return false;
  }
  
  public static String fOI()
  {
    return "/emojiuser1/";
  }
  
  public static boolean fOJ()
  {
    AppMethodBeat.i(311750);
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yUx, -1) == 1)
    {
      AppMethodBeat.o(311750);
      return true;
    }
    AppMethodBeat.o(311750);
    return false;
  }
  
  public static String fOK()
  {
    AppMethodBeat.i(311762);
    String str = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yUy, "60000_4");
    s.s(str, "service(IExptService::cl…covery_config, \"60000_4\")");
    AppMethodBeat.o(311762);
    return str;
  }
  
  public static int fOL()
  {
    AppMethodBeat.i(311766);
    int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yUz, 1);
    AppMethodBeat.o(311766);
    return i;
  }
  
  public static int fOM()
  {
    AppMethodBeat.i(311774);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("wx_ime");
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(311774);
      return 0;
    }
    int i = localMultiProcessMMKV.getInt("ime_first_cloud_resource_download_STATUS", 0);
    AppMethodBeat.o(311774);
    return i;
  }
  
  public static void fON()
  {
    AppMethodBeat.i(311782);
    Log.i("WxIme.WxImeUtil", "triggerNewTips");
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.mzv, l..ExternalSyntheticLambda0.INSTANCE.getClass(), null);
    AppMethodBeat.o(311782);
  }
  
  public static boolean fOO()
  {
    AppMethodBeat.i(311788);
    if (fOM() != 2)
    {
      AppMethodBeat.o(311788);
      return true;
    }
    AppMethodBeat.o(311788);
    return false;
  }
  
  public static void fOP()
  {
    long l1 = 0L;
    AppMethodBeat.i(311801);
    int i = fOM();
    Log.i("WxIme.WxImeUtil", s.X("finishFirstCloudResDownload ", Integer.valueOf(i)));
    if (i != 2)
    {
      localObject = MMApplicationContext.getContext();
      s.s(localObject, "getContext()");
      boolean bool1 = id((Context)localObject);
      if (!bool1) {
        break label216;
      }
      fON();
      localObject = MultiProcessMMKV.getMMKV("wx_ime");
      if (localObject != null) {
        ((MultiProcessMMKV)localObject).putInt("ime_first_cloud_resource_download_STATUS", 2);
      }
      localObject = MMApplicationContext.getContext();
      s.s(localObject, "getContext()");
      boolean bool2 = ic((Context)localObject);
      boolean bool3 = fKJ();
      Log.i("WxIme.WxImeUtil", "finishFirstCloudResDownload visible:" + fOJ() + " enable:" + bool2 + " filterEnable:" + bool3 + " isInImeList:" + bool1);
      if ((fOJ()) && (!bool2) && (!bool3))
      {
        localObject = MMApplicationContext.getContext();
        s.s(localObject, "getContext()");
        ia((Context)localObject);
      }
    }
    Object localObject = n.JvW;
    n.fMK();
    AppMethodBeat.o(311801);
    return;
    label216:
    localObject = MultiProcessMMKV.getMMKV("wx_ime");
    label229:
    long l2;
    if (localObject == null)
    {
      l2 = cn.bDx();
      if (l2 - l1 <= 60000L) {
        break label292;
      }
    }
    label292:
    for (l1 = 60000L;; l1 = l2 - l1)
    {
      Log.i("WxIme.WxImeUtil", s.X("finishFirstCloudResDownload interTime:", Long.valueOf(l1)));
      com.tencent.threadpool.h.ahAA.p(l..ExternalSyntheticLambda2.INSTANCE, l1);
      break;
      l1 = ((MultiProcessMMKV)localObject).getLong("ime_enable_time", 0L);
      break label229;
    }
  }
  
  public static void fOQ()
  {
    AppMethodBeat.i(311806);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("wx_ime");
    if (localMultiProcessMMKV != null) {
      localMultiProcessMMKV.putInt("ime_first_cloud_resource_download_STATUS", 0);
    }
    AppMethodBeat.o(311806);
  }
  
  public static void fOR()
  {
    AppMethodBeat.i(311811);
    int i = fOM();
    Log.i("WxIme.WxImeUtil", s.X("checkFetchFirstCloudResDownload ", Integer.valueOf(i)));
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(311811);
      return;
      com.tencent.mm.plugin.hld.c.a locala = com.tencent.mm.plugin.hld.c.a.JoL;
      if (!com.tencent.mm.plugin.hld.c.a.fKU())
      {
        locala = com.tencent.mm.plugin.hld.c.a.JoL;
        com.tencent.mm.plugin.hld.c.a.fKW();
        AppMethodBeat.o(311811);
        return;
        locala = com.tencent.mm.plugin.hld.c.a.JoL;
        if (!com.tencent.mm.plugin.hld.c.a.fKU())
        {
          locala = com.tencent.mm.plugin.hld.c.a.JoL;
          com.tencent.mm.plugin.hld.c.a.fKW();
        }
      }
    }
  }
  
  public static boolean fOS()
  {
    AppMethodBeat.i(311829);
    if (bGa())
    {
      localMultiProcessMMKV = fPk();
      if (localMultiProcessMMKV == null)
      {
        AppMethodBeat.o(311829);
        return false;
      }
      bool = localMultiProcessMMKV.getBoolean("ime_active_first_process_privacy_info", false);
      AppMethodBeat.o(311829);
      return bool;
    }
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("wx_ime_0");
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(311829);
      return false;
    }
    boolean bool = localMultiProcessMMKV.getBoolean("ime_active_first_process_privacy_info", false);
    AppMethodBeat.o(311829);
    return bool;
  }
  
  public static boolean fOT()
  {
    AppMethodBeat.i(311837);
    if (bGa())
    {
      localObject = fPk();
      if (localObject == null) {
        bool = false;
      }
      while (!bool)
      {
        localObject = i.JyA;
        if ((i.fOs() & 0x10000) == 65536)
        {
          AppMethodBeat.o(311837);
          return true;
          bool = ((MultiProcessMMKV)localObject).getBoolean("ime_active_first_process_privacy_info", false);
        }
        else
        {
          AppMethodBeat.o(311837);
          return false;
        }
      }
      AppMethodBeat.o(311837);
      return bool;
    }
    Object localObject = MultiProcessMMKV.getMMKV("wx_ime_0");
    if (localObject == null)
    {
      AppMethodBeat.o(311837);
      return false;
    }
    boolean bool = ((MultiProcessMMKV)localObject).getBoolean("ime_active_first_process_privacy_info", false);
    AppMethodBeat.o(311837);
    return bool;
  }
  
  public static void fOU()
  {
    AppMethodBeat.i(311846);
    MultiProcessMMKV localMultiProcessMMKV = fPk();
    if (localMultiProcessMMKV != null) {
      localMultiProcessMMKV.putBoolean("ime_active_first_process_privacy_info", true);
    }
    localMultiProcessMMKV = MultiProcessMMKV.getMMKV("wx_ime_0");
    if (localMultiProcessMMKV != null) {
      localMultiProcessMMKV.putBoolean("ime_active_first_process_privacy_info", true);
    }
    AppMethodBeat.o(311846);
  }
  
  public static boolean fOV()
  {
    AppMethodBeat.i(311853);
    if (bGa())
    {
      localMultiProcessMMKV = fPk();
      if (localMultiProcessMMKV == null)
      {
        AppMethodBeat.o(311853);
        return false;
      }
      bool = localMultiProcessMMKV.getBoolean("ime_active_second_process_collect_data", false);
      AppMethodBeat.o(311853);
      return bool;
    }
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("wx_ime_0");
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(311853);
      return false;
    }
    boolean bool = localMultiProcessMMKV.getBoolean("ime_active_second_process_collect_data", false);
    AppMethodBeat.o(311853);
    return bool;
  }
  
  public static boolean fOW()
  {
    AppMethodBeat.i(311858);
    if (bGa())
    {
      localObject = fPk();
      if (localObject == null) {
        bool = false;
      }
      while (!bool)
      {
        localObject = i.JyA;
        if ((i.fOs() & 0x8) == 8)
        {
          AppMethodBeat.o(311858);
          return true;
          bool = ((MultiProcessMMKV)localObject).getBoolean("ime_active_second_process_collect_data", false);
        }
        else
        {
          AppMethodBeat.o(311858);
          return false;
        }
      }
      AppMethodBeat.o(311858);
      return bool;
    }
    Object localObject = MultiProcessMMKV.getMMKV("wx_ime_0");
    if (localObject == null)
    {
      AppMethodBeat.o(311858);
      return false;
    }
    boolean bool = ((MultiProcessMMKV)localObject).getBoolean("ime_active_second_process_collect_data", false);
    AppMethodBeat.o(311858);
    return bool;
  }
  
  public static void fOX()
  {
    AppMethodBeat.i(311860);
    MultiProcessMMKV localMultiProcessMMKV = fPk();
    if (localMultiProcessMMKV != null) {
      localMultiProcessMMKV.putBoolean("ime_active_second_process_collect_data", true);
    }
    localMultiProcessMMKV = MultiProcessMMKV.getMMKV("wx_ime_0");
    if (localMultiProcessMMKV != null) {
      localMultiProcessMMKV.putBoolean("ime_active_second_process_collect_data", true);
    }
    AppMethodBeat.o(311860);
  }
  
  public static boolean fOY()
  {
    AppMethodBeat.i(311862);
    if (bGa())
    {
      localMultiProcessMMKV = fPk();
      if (localMultiProcessMMKV == null)
      {
        AppMethodBeat.o(311862);
        return false;
      }
      bool = localMultiProcessMMKV.getBoolean("ime_active_fifth_process_choose_keyboard", false);
      AppMethodBeat.o(311862);
      return bool;
    }
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("wx_ime_0");
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(311862);
      return false;
    }
    boolean bool = localMultiProcessMMKV.getBoolean("ime_active_fifth_process_choose_keyboard", false);
    AppMethodBeat.o(311862);
    return bool;
  }
  
  public static boolean fOZ()
  {
    AppMethodBeat.i(311869);
    if (bGa())
    {
      localObject = fPk();
      if (localObject == null) {
        bool = false;
      }
      while (!bool)
      {
        localObject = i.JyA;
        if ((i.fOs() & 0x10) == 16)
        {
          AppMethodBeat.o(311869);
          return true;
          bool = ((MultiProcessMMKV)localObject).getBoolean("ime_active_fifth_process_choose_keyboard", false);
        }
        else
        {
          AppMethodBeat.o(311869);
          return false;
        }
      }
      AppMethodBeat.o(311869);
      return bool;
    }
    Object localObject = MultiProcessMMKV.getMMKV("wx_ime_0");
    if (localObject == null)
    {
      AppMethodBeat.o(311869);
      return false;
    }
    boolean bool = ((MultiProcessMMKV)localObject).getBoolean("ime_active_fifth_process_choose_keyboard", false);
    AppMethodBeat.o(311869);
    return bool;
  }
  
  public static void fPa()
  {
    AppMethodBeat.i(311880);
    MultiProcessMMKV localMultiProcessMMKV = fPk();
    if (localMultiProcessMMKV != null) {
      localMultiProcessMMKV.putBoolean("ime_active_fifth_process_choose_keyboard", true);
    }
    localMultiProcessMMKV = MultiProcessMMKV.getMMKV("wx_ime_0");
    if (localMultiProcessMMKV != null) {
      localMultiProcessMMKV.putBoolean("ime_active_fifth_process_choose_keyboard", true);
    }
    AppMethodBeat.o(311880);
  }
  
  public static boolean fPb()
  {
    AppMethodBeat.i(311887);
    Object localObject = MMApplicationContext.getContext();
    s.s(localObject, "getContext()");
    boolean bool = iz((Context)localObject);
    localObject = MultiProcessMMKV.getMMKV("wx_ime");
    if (localObject == null)
    {
      AppMethodBeat.o(311887);
      return bool;
    }
    bool = ((MultiProcessMMKV)localObject).getBoolean("ime_is_default", bool);
    AppMethodBeat.o(311887);
    return bool;
  }
  
  public static String fPc()
  {
    AppMethodBeat.i(311913);
    Object localObject = MMApplicationContext.getContext().getContentResolver();
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG("default_input_method").cG(localObject);
    localObject = (String)com.tencent.mm.hellhoundlib.a.a.a(new Object(), ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/hld/utils/WxImeUtil", "getCurIme", "()Ljava/lang/String;", "android/provider/Settings$Secure", "getString", "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;");
    AppMethodBeat.o(311913);
    return localObject;
  }
  
  public static long fPd()
  {
    int i = 0;
    AppMethodBeat.i(311919);
    String str1;
    Object localObject2;
    long l;
    try
    {
      Object localObject1 = new BufferedReader((Reader)new FileReader("/proc/meminfo"), 8192);
      str1 = ((BufferedReader)localObject1).readLine();
      s.s(str1, "localBufferedReader.readLine()");
      localObject2 = (CharSequence)str1;
      localObject2 = ((Collection)new kotlin.n.k("\\s+").o((CharSequence)localObject2, 0)).toArray(new String[0]);
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(311919);
        throw ((Throwable)localObject1);
      }
    }
    catch (Exception localException1)
    {
      l = 0L;
    }
    for (;;)
    {
      Log.e("WxIme.WxImeUtil", s.X("getTotalMemory ", localException1.getMessage()));
      for (;;)
      {
        AppMethodBeat.o(311919);
        return l;
        localObject2 = (String[])localObject2;
        int j = localObject2.length;
        while (i < j)
        {
          String str2 = localObject2[i];
          i += 1;
          Log.i(str1, s.X(str2, "\t"));
        }
        i = Integer.valueOf(localObject2[1]).intValue();
        l = i * 1024L;
        try
        {
          localException1.close();
        }
        catch (Exception localException2) {}
      }
    }
  }
  
  public static void fPe()
  {
    AppMethodBeat.i(311933);
    int i = com.tencent.mm.app.i.il(s.X(MMApplicationContext.getApplicationId(), com.tencent.mm.plugin.hld.a.f.JnF));
    Log.e("WxIme.WxImeUtil", "killImeProcess() pid = %s, stack[%s]", new Object[] { Integer.valueOf(i), Util.getStack() });
    Log.w("WxIme.WxImeUtil", s.X("killProcess pid:", Integer.valueOf(i)));
    try
    {
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/plugin/hld/utils/WxImeUtil", "killProcess", "(I)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)locala.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/hld/utils/WxImeUtil", "killProcess", "(I)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      AppMethodBeat.o(311933);
      return;
    }
    catch (Exception localException)
    {
      Log.e("WxIme.WxImeUtil", "killProcess %s, %s %s", new Object[] { Integer.valueOf(i), localException.getClass().getSimpleName(), localException.getMessage() });
      AppMethodBeat.o(311933);
    }
  }
  
  public static boolean fPf()
  {
    AppMethodBeat.i(311942);
    if ((float)Util.getDataAvailableSize() < 62914560.0F)
    {
      AppMethodBeat.o(311942);
      return false;
    }
    AppMethodBeat.o(311942);
    return true;
  }
  
  public static long fPg()
  {
    AppMethodBeat.i(311962);
    Object localObject1 = new ActivityManager.MemoryInfo();
    Object localObject2 = MMApplicationContext.getContext().getSystemService("activity");
    if (localObject2 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
      AppMethodBeat.o(311962);
      throw ((Throwable)localObject1);
    }
    ((ActivityManager)localObject2).getMemoryInfo((ActivityManager.MemoryInfo)localObject1);
    long l = ((ActivityManager.MemoryInfo)localObject1).totalMem;
    AppMethodBeat.o(311962);
    return l;
  }
  
  public static long fPh()
  {
    AppMethodBeat.i(311972);
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l1 = localStatFs.getBlockCountLong();
    long l2 = localStatFs.getBlockSizeLong();
    AppMethodBeat.o(311972);
    return l2 * l1;
  }
  
  /* Error */
  public static String fPi()
  {
    // Byte code:
    //   0: ldc_w 1071
    //   3: invokestatic 145	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 272	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 339	java/lang/StringBuilder:<init>	()V
    //   13: astore 4
    //   15: getstatic 1076	android/os/Build:SUPPORTED_ABIS	[Ljava/lang/String;
    //   18: astore 5
    //   20: aload 5
    //   22: ldc_w 1078
    //   25: invokestatic 240	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   28: aload 5
    //   30: arraylength
    //   31: istore_2
    //   32: iconst_0
    //   33: istore_0
    //   34: aload 4
    //   36: astore_3
    //   37: iload_0
    //   38: iload_2
    //   39: if_icmpge +64 -> 103
    //   42: aload 5
    //   44: iload_0
    //   45: aaload
    //   46: astore_3
    //   47: aload 4
    //   49: checkcast 935	java/lang/CharSequence
    //   52: invokeinterface 1081 1 0
    //   57: ifne +32 -> 89
    //   60: iconst_1
    //   61: istore_1
    //   62: iload_1
    //   63: ifne +12 -> 75
    //   66: aload 4
    //   68: ldc_w 1083
    //   71: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload 4
    //   77: aload_3
    //   78: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: iload_0
    //   83: iconst_1
    //   84: iadd
    //   85: istore_0
    //   86: goto -52 -> 34
    //   89: iconst_0
    //   90: istore_1
    //   91: goto -29 -> 62
    //   94: astore_3
    //   95: new 272	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 339	java/lang/StringBuilder:<init>	()V
    //   102: astore_3
    //   103: aload_3
    //   104: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: astore_3
    //   108: aload_3
    //   109: ldc_w 1085
    //   112: invokestatic 240	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   115: ldc_w 1071
    //   118: invokestatic 151	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: aload_3
    //   122: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   33	53	0	i	int
    //   61	30	1	j	int
    //   31	9	2	k	int
    //   36	42	3	localObject1	Object
    //   94	1	3	localException	Exception
    //   102	20	3	localObject2	Object
    //   13	63	4	localStringBuilder	StringBuilder
    //   18	25	5	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   15	32	94	java/lang/Exception
    //   47	60	94	java/lang/Exception
    //   66	75	94	java/lang/Exception
    //   75	82	94	java/lang/Exception
  }
  
  public static boolean fPj()
  {
    boolean bool = true;
    AppMethodBeat.i(312002);
    Object localObject = fPk();
    int i;
    if ((localObject != null) && (((MultiProcessMMKV)localObject).getInt("ime_old_user_guide_show", 0) == 1))
    {
      i = 1;
      if (i == 0) {
        break label82;
      }
      localObject = MMApplicationContext.getContext();
      s.s(localObject, "getContext()");
      if (iz((Context)localObject)) {
        break label65;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(312002);
      return bool;
      i = 0;
      break;
      label65:
      localObject = fPk();
      if (localObject != null) {
        ((MultiProcessMMKV)localObject).putInt("ime_old_user_guide_show", 2);
      }
      label82:
      bool = false;
    }
  }
  
  public static MultiProcessMMKV fPk()
  {
    AppMethodBeat.i(312082);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(s.X("wx_ime_", Integer.valueOf(com.tencent.mm.kernel.b.aZQ())));
    AppMethodBeat.o(312082);
    return localMultiProcessMMKV;
  }
  
  public static MultiProcessMMKV fPl()
  {
    AppMethodBeat.i(369994);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("wx_ime_0");
    AppMethodBeat.o(369994);
    return localMultiProcessMMKV;
  }
  
  private static final void fPm()
  {
    AppMethodBeat.i(312105);
    fON();
    AppMethodBeat.o(312105);
  }
  
  private static final void fPn()
  {
    AppMethodBeat.i(312111);
    if (!fOO()) {
      fON();
    }
    AppMethodBeat.o(312111);
  }
  
  private static final void fPo()
  {
    AppMethodBeat.i(312120);
    Log.i("WxIme.WxImeUtil", "checkInInputMethodList start");
    int i = 0;
    long l3 = System.currentTimeMillis();
    long l1 = 0L;
    label397:
    for (;;)
    {
      long l2 = l1;
      if (i == 0) {
        try
        {
          Object localObject1 = MMApplicationContext.getContext().getSystemService("input_method");
          if (localObject1 == null)
          {
            localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            AppMethodBeat.o(312120);
            throw ((Throwable)localObject1);
          }
        }
        catch (Exception localException1) {}
      }
      for (;;)
      {
        for (;;)
        {
          Log.e("WxIme.WxImeUtil", s.X("checkInInputMethodList ", localException1.getMessage()));
          l2 = l1;
          Object localObject2 = MMApplicationContext.getContext().getSystemService("input_method");
          if (localObject2 == null)
          {
            localObject2 = new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            AppMethodBeat.o(312120);
            throw ((Throwable)localObject2);
            localObject2 = ((InputMethodManager)localObject2).getInputMethodList().iterator();
            l2 = l1;
            label142:
            l1 = l2;
          }
          try
          {
            if (((Iterator)localObject2).hasNext())
            {
              InputMethodInfo localInputMethodInfo = (InputMethodInfo)((Iterator)localObject2).next();
              Log.d("WxIme.WxImeUtil", s.X("startCheckInInputMethodList ", localInputMethodInfo.getId()));
              String str = localInputMethodInfo.getId();
              o localo = o.Jwm;
              if (!s.p(str, o.fNf()))
              {
                str = localInputMethodInfo.getId();
                localo = o.Jwm;
                l2 = l1;
                if (!s.p(str, o.fNg())) {
                  break label142;
                }
              }
              Log.i("WxIme.WxImeUtil", s.X("startCheckInInputMethodList exist:", localInputMethodInfo.getId()));
              l2 = System.currentTimeMillis() - l3;
              i = 1;
              break label142;
            }
            Thread.sleep(50L);
            l2 = System.currentTimeMillis();
            if (l2 - l3 <= 60000L) {
              break label397;
            }
            l1 = 60000L;
            i = 1;
          }
          catch (Exception localException2) {}
        }
        localObject2 = ((InputMethodManager)localObject2).getInputMethodList().iterator();
        while (((Iterator)localObject2).hasNext()) {
          Log.i("WxIme.WxImeUtil", s.X("startCheckInInputMethodList: ", ((InputMethodInfo)((Iterator)localObject2).next()).getId()));
        }
        Log.i("WxIme.WxImeUtil", s.X("startCheckInInputMethodList time:", Long.valueOf(l2)));
        localObject2 = com.tencent.mm.plugin.hld.model.k.JvH;
        com.tencent.mm.plugin.hld.model.k.d(3, (int)l2, null, 8);
        com.tencent.threadpool.h.ahAA.bm(l..ExternalSyntheticLambda1.INSTANCE);
        AppMethodBeat.o(312120);
        return;
      }
    }
  }
  
  public static MultiProcessMMKV getKV()
  {
    AppMethodBeat.i(369993);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("wx_ime");
    AppMethodBeat.o(369993);
    return localMultiProcessMMKV;
  }
  
  public static int getStatusBarHeight(Context paramContext)
  {
    AppMethodBeat.i(311600);
    s.u(paramContext, "context");
    int i = 0;
    int j = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (j > 0) {
      i = paramContext.getResources().getDimensionPixelSize(j);
    }
    AppMethodBeat.o(311600);
    return i;
  }
  
  public static boolean iA(Context paramContext)
  {
    AppMethodBeat.i(311741);
    s.u(paramContext, "context");
    if ((fOT()) && (fOW()) && ((iC(paramContext) & iD(paramContext))) && (fOZ()))
    {
      AppMethodBeat.o(311741);
      return true;
    }
    AppMethodBeat.o(311741);
    return false;
  }
  
  public static void iB(Context paramContext)
  {
    AppMethodBeat.i(311898);
    s.u(paramContext, "context");
    Log.i("WxIme.WxImeUtil", s.X("switchToDefaultIme close:", Boolean.TRUE));
    paramContext = new Intent(paramContext, WxImeInterService.class);
    paramContext.putExtra("ime_switch_ime_to_default", true);
    paramContext.putExtra("ime_close_wxime", true);
    com.tencent.mm.br.c.n(paramContext, "hld");
    AppMethodBeat.o(311898);
  }
  
  public static boolean iC(Context paramContext)
  {
    AppMethodBeat.i(311905);
    s.u(paramContext, "context");
    paramContext = paramContext.getSystemService("input_method");
    if (paramContext == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      AppMethodBeat.o(311905);
      throw paramContext;
    }
    paramContext = ((InputMethodManager)paramContext).getEnabledInputMethodList().iterator();
    while (paramContext.hasNext())
    {
      Object localObject1 = (InputMethodInfo)paramContext.next();
      Log.d("WxIme.WxImeUtil", s.X("checking ", ((InputMethodInfo)localObject1).getId()));
      Object localObject2 = ((InputMethodInfo)localObject1).getId();
      o localo = o.Jwm;
      if (!s.p(localObject2, o.fNf()))
      {
        localObject1 = ((InputMethodInfo)localObject1).getId();
        localObject2 = o.Jwm;
        if (!s.p(localObject1, o.fNg())) {
          break;
        }
      }
      else
      {
        AppMethodBeat.o(311905);
        return true;
      }
    }
    AppMethodBeat.o(311905);
    return false;
  }
  
  public static boolean iD(Context paramContext)
  {
    AppMethodBeat.i(311911);
    s.u(paramContext, "context");
    paramContext = paramContext.getContentResolver();
    paramContext = new com.tencent.mm.hellhoundlib.b.a().cG("default_input_method").cG(paramContext);
    paramContext = (String)com.tencent.mm.hellhoundlib.a.a.a(new Object(), paramContext.aYi(), "com/tencent/mm/plugin/hld/utils/WxImeUtil", "isImeCurActive", "(Landroid/content/Context;)Z", "android/provider/Settings$Secure", "getString", "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;");
    Log.d("WxIme.WxImeUtil", s.X("isImeCurActive ime = ", paramContext));
    o localo = o.Jwm;
    if (!s.p(o.fNf(), paramContext))
    {
      localo = o.Jwm;
      if (!s.p(o.fNg(), paramContext)) {}
    }
    else
    {
      AppMethodBeat.o(311911);
      return true;
    }
    AppMethodBeat.o(311911);
    return false;
  }
  
  public static void ia(Context paramContext)
  {
    AppMethodBeat.i(311687);
    s.u(paramContext, "context");
    Object localObject = MultiProcessMMKV.getMMKV("wx_ime");
    if (localObject == null) {}
    for (long l = 0L;; l = ((MultiProcessMMKV)localObject).getLong("ime_enable_time", 0L))
    {
      Log.i("WxIme.WxImeUtil", "enableIme " + Util.getStack() + " enableTime:" + l);
      localObject = com.tencent.mm.plugin.hld.model.k.JvH;
      com.tencent.mm.plugin.hld.model.k.Yy(6);
      paramContext.getPackageManager().setComponentEnabledSetting(new ComponentName(paramContext, "com.tencent.mm.plugin.hld.WxHldService"), 1, 1);
      if (l == 0L)
      {
        l = cn.bDx();
        paramContext = MultiProcessMMKV.getMMKV("wx_ime");
        if (paramContext != null) {
          paramContext.putLong("ime_enable_time", l);
        }
        Log.i("WxIme.WxImeUtil", s.X("enableIme ", Long.valueOf(l)));
      }
      AppMethodBeat.o(311687);
      return;
    }
  }
  
  public static boolean ic(Context paramContext)
  {
    AppMethodBeat.i(311720);
    s.u(paramContext, "context");
    if (paramContext.getPackageManager().getComponentEnabledSetting(new ComponentName(paramContext, Class.forName("com.tencent.mm.plugin.hld.WxHldService"))) == 1)
    {
      AppMethodBeat.o(311720);
      return true;
    }
    AppMethodBeat.o(311720);
    return false;
  }
  
  public static boolean id(Context paramContext)
  {
    AppMethodBeat.i(311711);
    s.u(paramContext, "context");
    if (!ic(paramContext))
    {
      AppMethodBeat.o(311711);
      return false;
    }
    paramContext = MultiProcessMMKV.getMMKV("wx_ime");
    if (paramContext == null) {}
    for (long l1 = 0L;; l1 = paramContext.getLong("ime_enable_time", 0L))
    {
      long l2 = cn.bDx();
      if (l1 == 0L)
      {
        paramContext = MultiProcessMMKV.getMMKV("wx_ime");
        if (paramContext != null) {
          paramContext.putLong("ime_enable_time", l2);
        }
        Log.i("WxIme.WxImeUtil", s.X("isInImeList ", Long.valueOf(l2)));
      }
      if ((l1 == 0L) || (l2 - l1 <= 60000L)) {
        break;
      }
      AppMethodBeat.o(311711);
      return true;
    }
    boolean bool = fKK();
    AppMethodBeat.o(311711);
    return bool;
  }
  
  public static void iv(Context paramContext)
  {
    AppMethodBeat.i(311625);
    s.u(paramContext, "context");
    aa.makeText(paramContext, a.j.wxime_no_support_function, 0).show();
    AppMethodBeat.o(311625);
  }
  
  public static void iw(Context paramContext)
  {
    AppMethodBeat.i(311634);
    s.u(paramContext, "context");
    if (System.currentTimeMillis() - JyW > 2000L)
    {
      Object localObject = (com.tencent.mm.plugin.hld.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.hld.a.d.class);
      if (localObject == null) {
        break label91;
      }
      localObject = ((com.tencent.mm.plugin.hld.a.d)localObject).fKG();
      if ((localObject == null) || (((com.tencent.mm.plugin.hld.a.b)localObject).fKu() != true)) {
        break label91;
      }
    }
    label91:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        JyW = System.currentTimeMillis();
        aa.makeText(paramContext, a.j.wxime_engine_no_init_finish, 0).show();
      }
      AppMethodBeat.o(311634);
      return;
    }
  }
  
  public static void ix(Context paramContext)
  {
    AppMethodBeat.i(311666);
    s.u(paramContext, "context");
    Object localObject = o.Jwm;
    if (o.fNe())
    {
      localObject = new Intent(paramContext, Class.forName("com.tencent.mm.hld.ContactInfoUI"));
      ((Intent)localObject).setFlags(335544320);
      ((Intent)localObject).putExtra("ime_auto_open_choose_list", true);
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/hld/utils/WxImeUtil", "goToContactInfoUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/hld/utils/WxImeUtil", "goToContactInfoUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(311666);
      return;
    }
    localObject = new Intent();
    ((Intent)localObject).setClassName(paramContext, "com.tencent.mm.plugin.hld.ui.WelabHldInfoUI");
    ((Intent)localObject).setFlags(335544320);
    ((Intent)localObject).putExtra("ime_auto_open_choose_list", true);
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/hld/utils/WxImeUtil", "goToContactInfoUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/hld/utils/WxImeUtil", "goToContactInfoUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(311666);
  }
  
  public static void iy(Context paramContext)
  {
    AppMethodBeat.i(311701);
    s.u(paramContext, "context");
    Log.i("WxIme.WxImeUtil", s.X("disabledIme ", Util.getStack()));
    paramContext.getPackageManager().setComponentEnabledSetting(new ComponentName(paramContext, "com.tencent.mm.plugin.hld.WxHldService"), 2, 1);
    AppMethodBeat.o(311701);
  }
  
  public static boolean iz(Context paramContext)
  {
    AppMethodBeat.i(311731);
    s.u(paramContext, "context");
    boolean bool1 = iC(paramContext);
    boolean bool2 = iD(paramContext);
    AppMethodBeat.o(311731);
    return bool1 & bool2;
  }
  
  public static void jC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(312037);
    s.u(paramString1, "tag");
    s.u(paramString2, "content");
    e locale = e.Jym;
    if (e.fNX()) {
      try
      {
        Log.i(paramString1, String.valueOf(paramString2));
        AppMethodBeat.o(312037);
        return;
      }
      catch (Exception paramString1)
      {
        Log.e("WxIme.WxImeUtil", s.X("printUserClickData ", paramString1.getMessage()));
      }
    }
    AppMethodBeat.o(312037);
  }
  
  public static boolean m(dbp paramdbp)
  {
    AppMethodBeat.i(311821);
    s.u(paramdbp, "dict");
    if (y.ZC(paramdbp.path))
    {
      if (Util.isEqual(y.bub(paramdbp.path), paramdbp.md5))
      {
        AppMethodBeat.o(311821);
        return true;
      }
      y.deleteFile(paramdbp.path);
      Log.e("WxIme.WxImeUtil", "checkDictValid " + paramdbp.path + " md5(" + paramdbp.md5 + ") no equeal");
    }
    for (;;)
    {
      AppMethodBeat.o(311821);
      return false;
      Log.e("WxIme.WxImeUtil", "checkDictValid " + paramdbp.path + " no exist");
    }
  }
  
  public static String n(dbp paramdbp)
  {
    AppMethodBeat.i(312066);
    s.u(paramdbp, "dict");
    paramdbp = paramdbp.path + ' ' + paramdbp.aaGX + ' ' + paramdbp.KPQ + ' ' + paramdbp.dataType + ' ' + paramdbp.md5;
    AppMethodBeat.o(312066);
    return paramdbp;
  }
  
  private static String xq(boolean paramBoolean)
  {
    AppMethodBeat.i(311585);
    String str2 = fOD();
    if (paramBoolean) {}
    for (String str1 = "/imgcachelandscape";; str1 = "/imgcache")
    {
      str1 = s.X(str2, str1);
      if (!y.ZC(str1)) {
        y.bDX(str1);
      }
      AppMethodBeat.o(311585);
      return str1;
    }
  }
  
  public static void xr(boolean paramBoolean)
  {
    AppMethodBeat.i(311893);
    Object localObject = MultiProcessMMKV.getMMKV("wx_ime");
    if (localObject != null) {
      ((MultiProcessMMKV)localObject).putBoolean("ime_is_default", paramBoolean);
    }
    localObject = com.tencent.mm.plugin.hld.b.e.JoK;
    if (paramBoolean) {}
    for (localObject = com.tencent.mm.plugin.hld.model.b.Juj;; localObject = com.tencent.mm.plugin.hld.model.b.Juk)
    {
      e.a.a((com.tencent.mm.plugin.hld.model.b)localObject, 0L, null, 6);
      AppMethodBeat.o(311893);
      return;
    }
  }
  
  public final String bg(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(312159);
    String str = xq(paramBoolean) + '/' + paramInt + ".png";
    AppMethodBeat.o(312159);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.f.l
 * JD-Core Version:    0.7.0.1
 */