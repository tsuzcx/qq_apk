package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.utils.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public final class j
  extends d
{
  private static final int CTRL_INDEX = 361;
  public static final String NAME = "updateLivePusher";
  
  public final int V(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145899);
    int i = paramJSONObject.optInt("livePusherId");
    AppMethodBeat.o(145899);
    return i;
  }
  
  /* Error */
  public final boolean c(com.tencent.mm.plugin.appbrand.jsapi.h paramh, int paramInt, final android.view.View paramView, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc 47
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 49
    //   7: ldc 51
    //   9: iconst_1
    //   10: anewarray 53	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: iload_2
    //   16: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   19: aastore
    //   20: invokestatic 64	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   23: aload_3
    //   24: instanceof 66
    //   27: ifne +28 -> 55
    //   30: ldc 49
    //   32: ldc 68
    //   34: iconst_1
    //   35: anewarray 53	java/lang/Object
    //   38: dup
    //   39: iconst_0
    //   40: iload_2
    //   41: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   44: aastore
    //   45: invokestatic 71	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   48: ldc 47
    //   50: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: iconst_0
    //   54: ireturn
    //   55: aload_3
    //   56: checkcast 66	com/tencent/mm/plugin/appbrand/jsapi/coverview/CoverViewContainer
    //   59: ldc 73
    //   61: invokevirtual 77	com/tencent/mm/plugin/appbrand/jsapi/coverview/CoverViewContainer:aT	(Ljava/lang/Class;)Ljava/lang/Object;
    //   64: checkcast 73	android/view/View
    //   67: astore_3
    //   68: aload_3
    //   69: instanceof 79
    //   72: ifne +17 -> 89
    //   75: ldc 49
    //   77: ldc 81
    //   79: invokestatic 85	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: ldc 47
    //   84: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: iconst_0
    //   88: ireturn
    //   89: aload_3
    //   90: checkcast 79	com/tencent/mm/plugin/appbrand/jsapi/live/AppBrandLivePusherView
    //   93: astore_3
    //   94: aload 4
    //   96: ldc 87
    //   98: invokevirtual 91	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   101: ifeq +50 -> 151
    //   104: aload_3
    //   105: aload 4
    //   107: ldc 87
    //   109: aload_3
    //   110: getfield 94	com/tencent/mm/plugin/appbrand/jsapi/live/AppBrandLivePusherView:eBs	Ljava/lang/String;
    //   113: invokevirtual 98	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   116: putfield 94	com/tencent/mm/plugin/appbrand/jsapi/live/AppBrandLivePusherView:eBs	Ljava/lang/String;
    //   119: aload_3
    //   120: aload 4
    //   122: ldc 100
    //   124: aconst_null
    //   125: invokevirtual 98	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   128: putfield 103	com/tencent/mm/plugin/appbrand/jsapi/live/AppBrandLivePusherView:eBt	Ljava/lang/String;
    //   131: aload_3
    //   132: getfield 94	com/tencent/mm/plugin/appbrand/jsapi/live/AppBrandLivePusherView:eBs	Ljava/lang/String;
    //   135: invokestatic 108	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   138: ifeq +170 -> 308
    //   141: aload 4
    //   143: ldc 87
    //   145: ldc 110
    //   147: invokevirtual 114	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   150: pop
    //   151: aload_3
    //   152: aload 4
    //   154: invokestatic 120	com/tencent/mm/plugin/appbrand/jsapi/live/n:an	(Lorg/json/JSONObject;)Landroid/os/Bundle;
    //   157: invokevirtual 124	com/tencent/mm/plugin/appbrand/jsapi/live/AppBrandLivePusherView:ab	(Landroid/os/Bundle;)V
    //   160: aload 4
    //   162: ldc 126
    //   164: invokevirtual 91	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   167: ifeq +36 -> 203
    //   170: aload 4
    //   172: ldc 126
    //   174: invokevirtual 130	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   177: astore 5
    //   179: aload 4
    //   181: ldc 132
    //   183: invokevirtual 134	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   186: astore 6
    //   188: aload 5
    //   190: invokestatic 108	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   193: ifeq +150 -> 343
    //   196: ldc 49
    //   198: ldc 136
    //   200: invokestatic 138	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: aload 4
    //   205: ldc 87
    //   207: invokevirtual 91	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   210: ifeq +27 -> 237
    //   213: aload 4
    //   215: ldc 87
    //   217: invokevirtual 130	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   220: astore 5
    //   222: aload 5
    //   224: invokestatic 108	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   227: ifeq +167 -> 394
    //   230: ldc 49
    //   232: ldc 140
    //   234: invokestatic 138	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: aload 4
    //   239: ldc 142
    //   241: invokevirtual 91	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   244: ifeq +36 -> 280
    //   247: aload 4
    //   249: ldc 142
    //   251: invokevirtual 130	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   254: astore 5
    //   256: aload 4
    //   258: ldc 144
    //   260: invokevirtual 134	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   263: astore 4
    //   265: aload 5
    //   267: invokestatic 108	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   270: ifeq +174 -> 444
    //   273: ldc 49
    //   275: ldc 146
    //   277: invokestatic 138	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: ldc 47
    //   282: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   285: iconst_1
    //   286: ireturn
    //   287: astore 5
    //   289: ldc 49
    //   291: ldc 148
    //   293: iconst_1
    //   294: anewarray 53	java/lang/Object
    //   297: dup
    //   298: iconst_0
    //   299: aload 5
    //   301: aastore
    //   302: invokestatic 71	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   305: goto -154 -> 151
    //   308: aload_3
    //   309: getfield 94	com/tencent/mm/plugin/appbrand/jsapi/live/AppBrandLivePusherView:eBs	Ljava/lang/String;
    //   312: ldc 150
    //   314: invokevirtual 155	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   317: ifne +15 -> 332
    //   320: aload_3
    //   321: getfield 94	com/tencent/mm/plugin/appbrand/jsapi/live/AppBrandLivePusherView:eBs	Ljava/lang/String;
    //   324: ldc 157
    //   326: invokevirtual 155	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   329: ifeq -178 -> 151
    //   332: aload 4
    //   334: ldc 87
    //   336: invokevirtual 161	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   339: pop
    //   340: goto -189 -> 151
    //   343: aload_1
    //   344: aload 5
    //   346: aload 6
    //   348: new 6	com/tencent/mm/plugin/appbrand/jsapi/live/j$1
    //   351: dup
    //   352: aload_0
    //   353: aload_3
    //   354: aload 5
    //   356: invokespecial 164	com/tencent/mm/plugin/appbrand/jsapi/live/j$1:<init>	(Lcom/tencent/mm/plugin/appbrand/jsapi/live/j;Lcom/tencent/mm/plugin/appbrand/jsapi/live/AppBrandLivePusherView;Ljava/lang/String;)V
    //   359: invokestatic 170	com/tencent/mm/plugin/appbrand/utils/g:a	(Lcom/tencent/mm/plugin/appbrand/jsapi/f;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/utils/g$a;)V
    //   362: goto -159 -> 203
    //   365: astore 5
    //   367: ldc 49
    //   369: ldc 172
    //   371: iconst_2
    //   372: anewarray 53	java/lang/Object
    //   375: dup
    //   376: iconst_0
    //   377: ldc 126
    //   379: aastore
    //   380: dup
    //   381: iconst_1
    //   382: aload 5
    //   384: invokevirtual 176	org/json/JSONException:getLocalizedMessage	()Ljava/lang/String;
    //   387: aastore
    //   388: invokestatic 64	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   391: goto -188 -> 203
    //   394: aload_1
    //   395: aload 5
    //   397: aconst_null
    //   398: new 8	com/tencent/mm/plugin/appbrand/jsapi/live/j$2
    //   401: dup
    //   402: aload_0
    //   403: aload_3
    //   404: aload 5
    //   406: invokespecial 177	com/tencent/mm/plugin/appbrand/jsapi/live/j$2:<init>	(Lcom/tencent/mm/plugin/appbrand/jsapi/live/j;Lcom/tencent/mm/plugin/appbrand/jsapi/live/AppBrandLivePusherView;Ljava/lang/String;)V
    //   409: invokestatic 170	com/tencent/mm/plugin/appbrand/utils/g:a	(Lcom/tencent/mm/plugin/appbrand/jsapi/f;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/utils/g$a;)V
    //   412: goto -175 -> 237
    //   415: astore 5
    //   417: ldc 49
    //   419: ldc 172
    //   421: iconst_2
    //   422: anewarray 53	java/lang/Object
    //   425: dup
    //   426: iconst_0
    //   427: ldc 87
    //   429: aastore
    //   430: dup
    //   431: iconst_1
    //   432: aload 5
    //   434: invokevirtual 176	org/json/JSONException:getLocalizedMessage	()Ljava/lang/String;
    //   437: aastore
    //   438: invokestatic 64	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   441: goto -204 -> 237
    //   444: aload_1
    //   445: aload 5
    //   447: aload 4
    //   449: new 10	com/tencent/mm/plugin/appbrand/jsapi/live/j$3
    //   452: dup
    //   453: aload_0
    //   454: aload_3
    //   455: invokespecial 180	com/tencent/mm/plugin/appbrand/jsapi/live/j$3:<init>	(Lcom/tencent/mm/plugin/appbrand/jsapi/live/j;Lcom/tencent/mm/plugin/appbrand/jsapi/live/AppBrandLivePusherView;)V
    //   458: invokestatic 170	com/tencent/mm/plugin/appbrand/utils/g:a	(Lcom/tencent/mm/plugin/appbrand/jsapi/f;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/utils/g$a;)V
    //   461: goto -181 -> 280
    //   464: astore_1
    //   465: ldc 49
    //   467: ldc 172
    //   469: iconst_2
    //   470: anewarray 53	java/lang/Object
    //   473: dup
    //   474: iconst_0
    //   475: ldc 142
    //   477: aastore
    //   478: dup
    //   479: iconst_1
    //   480: aload_1
    //   481: invokevirtual 176	org/json/JSONException:getLocalizedMessage	()Ljava/lang/String;
    //   484: aastore
    //   485: invokestatic 64	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   488: goto -208 -> 280
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	491	0	this	j
    //   0	491	1	paramh	com.tencent.mm.plugin.appbrand.jsapi.h
    //   0	491	2	paramInt	int
    //   0	491	3	paramView	android.view.View
    //   0	491	4	paramJSONObject	JSONObject
    //   177	89	5	str1	String
    //   287	68	5	localJSONException1	org.json.JSONException
    //   365	40	5	localJSONException2	org.json.JSONException
    //   415	31	5	localJSONException3	org.json.JSONException
    //   186	161	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   141	151	287	org/json/JSONException
    //   160	203	365	org/json/JSONException
    //   343	362	365	org/json/JSONException
    //   203	237	415	org/json/JSONException
    //   394	412	415	org/json/JSONException
    //   237	280	464	org/json/JSONException
    //   444	461	464	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.j
 * JD-Core Version:    0.7.0.1
 */