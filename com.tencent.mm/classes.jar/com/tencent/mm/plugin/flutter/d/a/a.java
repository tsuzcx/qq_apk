package com.tencent.mm.plugin.flutter.d.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.at;
import com.tencent.mm.vfs.u;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.platform.PlatformView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.n.n;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/plugins/platform/PlatformPagView;", "Lio/flutter/plugin/platform/PlatformView;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "context", "Landroid/content/Context;", "id", "", "creationParams", "", "", "", "channel", "Lio/flutter/plugin/common/MethodChannel;", "(Landroid/content/Context;ILjava/util/Map;Lio/flutter/plugin/common/MethodChannel;)V", "pagView", "Lorg/libpag/PAGView;", "dispose", "", "getView", "Landroid/view/View;", "onFlutterViewAttached", "p0", "onFlutterViewDetached", "onInputConnectionLocked", "onInputConnectionUnlocked", "onMethodCall", "methodCall", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "Companion", "plugin-flutter_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements MethodChannel.MethodCallHandler, PlatformView
{
  public static final a.a Hky;
  private static final Map<String, String> Hkz;
  private static final String TAG;
  private final PAGView CAn;
  
  static
  {
    AppMethodBeat.i(263193);
    Hky = new a.a((byte)0);
    TAG = "PlatformPagView";
    Hkz = (Map)new LinkedHashMap();
    AppMethodBeat.o(263193);
  }
  
  public a(Context paramContext, Map<String, ? extends Object> paramMap, MethodChannel paramMethodChannel)
  {
    AppMethodBeat.i(263170);
    this.CAn = new PAGView(paramContext);
    this.CAn.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    ah.f localf = new ah.f();
    localf.aqH = "";
    if ((paramMap != null) && (paramMap.containsKey("pagPath")))
    {
      paramMap = paramMap.get("pagPath");
      if (paramMap == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(263170);
        throw paramContext;
      }
      localf.aqH = ((String)paramMap);
    }
    if (n.U((String)localf.aqH, "http", false))
    {
      paramContext = at.acHs + "/cache/";
      paramMap = (String)localf.aqH;
      int i = n.b((CharSequence)localf.aqH, '/');
      if (paramMap == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(263170);
        throw paramContext;
      }
      Object localObject = paramMap.substring(i);
      s.s(localObject, "(this as java.lang.String).substring(startIndex)");
      paramMap = new ah.f();
      paramMap.aqH = (paramContext + '/' + (String)localObject);
      localObject = new u((String)paramMap.aqH);
      if ((Hkz.containsKey(localf.aqH)) || (((u)localObject).jKS()))
      {
        Hkz.put(localf.aqH, paramMap.aqH);
        paramContext = PAGFile.Load((String)Hkz.get(localf.aqH));
        this.CAn.setComposition((PAGComposition)paramContext);
        this.CAn.setRepeatCount(-1);
        this.CAn.play();
      }
      for (;;)
      {
        if (paramMethodChannel != null) {
          paramMethodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler)this);
        }
        AppMethodBeat.o(263170);
        return;
        paramContext = new u(paramContext);
        if (!paramContext.jKS()) {
          paramContext.jKY();
        }
        h.ahAA.bm(new a..ExternalSyntheticLambda1(localf, paramMap, paramMethodChannel));
      }
    }
    if (paramContext == null) {}
    for (paramContext = null;; paramContext = paramContext.getAssets())
    {
      paramContext = PAGFile.Load(paramContext, (String)localf.aqH);
      this.CAn.setComposition((PAGComposition)paramContext);
      this.CAn.setRepeatCount(-1);
      this.CAn.play();
      break;
    }
  }
  
  private static final void a(ah.f paramf1, ah.f paramf2, MethodChannel paramMethodChannel)
  {
    AppMethodBeat.i(263177);
    s.u(paramf1, "$pagPath");
    s.u(paramf2, "$filePath");
    Hkz.put(paramf1.aqH, paramf2.aqH);
    if (paramMethodChannel != null) {
      paramMethodChannel.invokeMethod("refresh", null);
    }
    AppMethodBeat.o(263177);
  }
  
  /* Error */
  private static final void b(ah.f paramf1, ah.f paramf2, MethodChannel paramMethodChannel)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc_w 279
    //   5: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: ldc_w 265
    //   12: invokestatic 268	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   15: aload_1
    //   16: ldc_w 270
    //   19: invokestatic 268	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   22: new 281	android/os/Handler
    //   25: dup
    //   26: invokestatic 287	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   29: invokespecial 290	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   32: astore 8
    //   34: new 292	java/net/URL
    //   37: dup
    //   38: aload_0
    //   39: getfield 127	kotlin/g/b/ah$f:aqH	Ljava/lang/Object;
    //   42: checkcast 146	java/lang/String
    //   45: invokespecial 293	java/net/URL:<init>	(Ljava/lang/String;)V
    //   48: astore 6
    //   50: aload 6
    //   52: invokevirtual 297	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   55: astore 7
    //   57: aload 7
    //   59: invokevirtual 302	java/net/URLConnection:connect	()V
    //   62: aload 7
    //   64: invokevirtual 306	java/net/URLConnection:getContentLength	()I
    //   67: istore 4
    //   69: new 308	java/io/BufferedInputStream
    //   72: dup
    //   73: aload 6
    //   75: invokevirtual 312	java/net/URL:openStream	()Ljava/io/InputStream;
    //   78: sipush 8192
    //   81: invokespecial 315	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   84: checkcast 317	java/io/InputStream
    //   87: astore 6
    //   89: new 319	java/io/FileOutputStream
    //   92: dup
    //   93: aload_1
    //   94: getfield 127	kotlin/g/b/ah$f:aqH	Ljava/lang/Object;
    //   97: checkcast 146	java/lang/String
    //   100: invokespecial 320	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   103: checkcast 322	java/io/OutputStream
    //   106: astore 7
    //   108: sipush 1024
    //   111: newarray byte
    //   113: astore 9
    //   115: aload 6
    //   117: checkcast 308	java/io/BufferedInputStream
    //   120: aload 9
    //   122: invokevirtual 326	java/io/BufferedInputStream:read	([B)I
    //   125: istore 5
    //   127: iload 5
    //   129: iconst_m1
    //   130: if_icmpeq +218 -> 348
    //   133: aload 7
    //   135: checkcast 319	java/io/FileOutputStream
    //   138: aload 9
    //   140: iconst_0
    //   141: iload 5
    //   143: invokevirtual 330	java/io/FileOutputStream:write	([BII)V
    //   146: iload_3
    //   147: iload 5
    //   149: iadd
    //   150: istore_3
    //   151: getstatic 90	com/tencent/mm/plugin/flutter/d/a/a:TAG	Ljava/lang/String;
    //   154: ldc_w 332
    //   157: iload_3
    //   158: iload 4
    //   160: idiv
    //   161: bipush 100
    //   163: imul
    //   164: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   167: invokestatic 342	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   170: invokestatic 348	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: iload 5
    //   175: iconst_m1
    //   176: if_icmpne +169 -> 345
    //   179: aload 7
    //   181: checkcast 319	java/io/FileOutputStream
    //   184: invokevirtual 351	java/io/FileOutputStream:flush	()V
    //   187: aload 7
    //   189: checkcast 319	java/io/FileOutputStream
    //   192: invokevirtual 354	java/io/FileOutputStream:close	()V
    //   195: aload 6
    //   197: checkcast 308	java/io/BufferedInputStream
    //   200: invokevirtual 355	java/io/BufferedInputStream:close	()V
    //   203: aload 8
    //   205: new 357	com/tencent/mm/plugin/flutter/d/a/a$$ExternalSyntheticLambda0
    //   208: dup
    //   209: aload_0
    //   210: aload_1
    //   211: aload_2
    //   212: invokespecial 358	com/tencent/mm/plugin/flutter/d/a/a$$ExternalSyntheticLambda0:<init>	(Lkotlin/g/b/ah$f;Lkotlin/g/b/ah$f;Lio/flutter/plugin/common/MethodChannel;)V
    //   215: invokevirtual 362	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   218: pop
    //   219: aload 7
    //   221: invokevirtual 363	java/io/OutputStream:close	()V
    //   224: aload 6
    //   226: invokevirtual 364	java/io/InputStream:close	()V
    //   229: ldc_w 279
    //   232: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: return
    //   236: astore_2
    //   237: aconst_null
    //   238: astore_0
    //   239: aconst_null
    //   240: astore_1
    //   241: getstatic 90	com/tencent/mm/plugin/flutter/d/a/a:TAG	Ljava/lang/String;
    //   244: aload_2
    //   245: invokevirtual 365	java/lang/Exception:toString	()Ljava/lang/String;
    //   248: invokestatic 368	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   251: aload_0
    //   252: ifnull +7 -> 259
    //   255: aload_0
    //   256: invokevirtual 363	java/io/OutputStream:close	()V
    //   259: aload_1
    //   260: ifnull +7 -> 267
    //   263: aload_1
    //   264: invokevirtual 364	java/io/InputStream:close	()V
    //   267: ldc_w 279
    //   270: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   273: return
    //   274: astore_2
    //   275: aconst_null
    //   276: astore_0
    //   277: aconst_null
    //   278: astore_1
    //   279: aload_0
    //   280: ifnull +7 -> 287
    //   283: aload_0
    //   284: invokevirtual 363	java/io/OutputStream:close	()V
    //   287: aload_1
    //   288: ifnull +7 -> 295
    //   291: aload_1
    //   292: invokevirtual 364	java/io/InputStream:close	()V
    //   295: ldc_w 279
    //   298: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   301: aload_2
    //   302: athrow
    //   303: astore_2
    //   304: aconst_null
    //   305: astore_0
    //   306: aload 6
    //   308: astore_1
    //   309: goto -30 -> 279
    //   312: astore_2
    //   313: aload 7
    //   315: astore_0
    //   316: aload 6
    //   318: astore_1
    //   319: goto -40 -> 279
    //   322: astore_2
    //   323: goto -44 -> 279
    //   326: astore_2
    //   327: aconst_null
    //   328: astore_0
    //   329: aload 6
    //   331: astore_1
    //   332: goto -91 -> 241
    //   335: astore_2
    //   336: aload 7
    //   338: astore_0
    //   339: aload 6
    //   341: astore_1
    //   342: goto -101 -> 241
    //   345: goto -230 -> 115
    //   348: goto -175 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	paramf1	ah.f
    //   0	351	1	paramf2	ah.f
    //   0	351	2	paramMethodChannel	MethodChannel
    //   1	160	3	i	int
    //   67	94	4	j	int
    //   125	52	5	k	int
    //   48	292	6	localObject1	Object
    //   55	282	7	localObject2	Object
    //   32	172	8	localHandler	android.os.Handler
    //   113	26	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   34	89	236	java/lang/Exception
    //   34	89	274	finally
    //   89	108	303	finally
    //   108	115	312	finally
    //   115	127	312	finally
    //   133	146	312	finally
    //   151	173	312	finally
    //   179	219	312	finally
    //   241	251	322	finally
    //   89	108	326	java/lang/Exception
    //   108	115	335	java/lang/Exception
    //   115	127	335	java/lang/Exception
    //   133	146	335	java/lang/Exception
    //   151	173	335	java/lang/Exception
    //   179	219	335	java/lang/Exception
  }
  
  public final void dispose()
  {
    AppMethodBeat.i(263225);
    Log.d(TAG, "dispose");
    AppMethodBeat.o(263225);
  }
  
  public final View getView()
  {
    AppMethodBeat.i(263210);
    Log.d(TAG, "getView");
    View localView = (View)this.CAn;
    AppMethodBeat.o(263210);
    return localView;
  }
  
  public final void onFlutterViewAttached(View paramView)
  {
    AppMethodBeat.i(263215);
    s.u(paramView, "p0");
    Log.d(TAG, "onFlutterViewAttached");
    AppMethodBeat.o(263215);
  }
  
  public final void onFlutterViewDetached()
  {
    AppMethodBeat.i(263221);
    Log.d(TAG, "onFlutterViewDetached");
    AppMethodBeat.o(263221);
  }
  
  public final void onInputConnectionLocked()
  {
    AppMethodBeat.i(263231);
    Log.d(TAG, "onInputConnectionLocked");
    AppMethodBeat.o(263231);
  }
  
  public final void onInputConnectionUnlocked()
  {
    AppMethodBeat.i(263236);
    Log.d(TAG, "onInputConnectionUnlocked");
    AppMethodBeat.o(263236);
  }
  
  public final void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    AppMethodBeat.i(263242);
    s.u(paramMethodCall, "methodCall");
    s.u(paramResult, "result");
    Log.d(TAG, "onMethodCall ");
    AppMethodBeat.o(263242);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.d.a.a
 * JD-Core Version:    0.7.0.1
 */