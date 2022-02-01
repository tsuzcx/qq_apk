package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

@Deprecated
public class JsApiBatchGetContact
  extends a<r>
{
  public static final int CTRL_INDEX = 410;
  public static final String NAME = "batchGetContact";
  
  static class JsApiBatchGetContactTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<JsApiBatchGetContactTask> CREATOR;
    private String errMsg;
    private r jFj;
    private int kmu;
    public ArrayList<String> kuN;
    private m kuO;
    private String kuP;
    
    static
    {
      AppMethodBeat.i(45463);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45463);
    }
    
    public JsApiBatchGetContactTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45454);
      e(paramParcel);
      AppMethodBeat.o(45454);
    }
    
    public JsApiBatchGetContactTask(m paramm, r paramr, int paramInt, ArrayList<String> paramArrayList)
    {
      this.kuO = paramm;
      this.jFj = paramr;
      this.kmu = paramInt;
      this.kuN = paramArrayList;
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(45456);
      b.c(new Runnable()
      {
        /* Error */
        public final void run()
        {
          // Byte code:
          //   0: ldc 29
          //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   5: iconst_1
          //   6: newarray boolean
          //   8: astore 5
          //   10: aload 5
          //   12: iconst_0
          //   13: iconst_0
          //   14: bastore
          //   15: new 37	java/util/Timer
          //   18: dup
          //   19: invokespecial 38	java/util/Timer:<init>	()V
          //   22: astore_3
          //   23: aload_3
          //   24: new 16	com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask$1$1
          //   27: dup
          //   28: aload_0
          //   29: aload 5
          //   31: aload_3
          //   32: invokespecial 41	com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask$1$1:<init>	(Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask$1;[ZLjava/util/Timer;)V
          //   35: ldc2_w 42
          //   38: invokevirtual 47	java/util/Timer:schedule	(Ljava/util/TimerTask;J)V
          //   41: new 49	java/util/ArrayList
          //   44: dup
          //   45: invokespecial 50	java/util/ArrayList:<init>	()V
          //   48: astore 6
          //   50: new 52	org/json/JSONArray
          //   53: dup
          //   54: invokespecial 53	org/json/JSONArray:<init>	()V
          //   57: astore 4
          //   59: aload_0
          //   60: getfield 22	com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask$1:kuQ	Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask;
          //   63: getfield 57	com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask:kuN	Ljava/util/ArrayList;
          //   66: invokevirtual 61	java/util/ArrayList:iterator	()Ljava/util/Iterator;
          //   69: astore 7
          //   71: aload 7
          //   73: invokeinterface 67 1 0
          //   78: ifeq +255 -> 333
          //   81: aload 7
          //   83: invokeinterface 71 1 0
          //   88: checkcast 73	java/lang/String
          //   91: astore 8
          //   93: aload 8
          //   95: iconst_0
          //   96: aconst_null
          //   97: invokestatic 79	com/tencent/mm/plugin/appbrand/config/x:a	(Ljava/lang/String;ZLcom/tencent/mm/plugin/appbrand/config/x$e;)Landroid/util/Pair;
          //   100: astore_1
          //   101: aload_1
          //   102: getfield 85	android/util/Pair:second	Ljava/lang/Object;
          //   105: ifnonnull +11 -> 116
          //   108: aload 6
          //   110: aload 8
          //   112: invokevirtual 89	java/util/ArrayList:add	(Ljava/lang/Object;)Z
          //   115: pop
          //   116: ldc 13
          //   118: monitorenter
          //   119: aload 5
          //   121: iconst_0
          //   122: baload
          //   123: ifeq +16 -> 139
          //   126: ldc 13
          //   128: monitorexit
          //   129: aload_3
          //   130: invokevirtual 92	java/util/Timer:cancel	()V
          //   133: ldc 29
          //   135: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   138: return
          //   139: aload_1
          //   140: getfield 98	android/util/Pair:first	Ljava/lang/Object;
          //   143: ifnull +19 -> 162
          //   146: aload_1
          //   147: getfield 98	android/util/Pair:first	Ljava/lang/Object;
          //   150: checkcast 100	com/tencent/mm/plugin/appbrand/config/WxaAttributes
          //   153: getfield 104	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_appInfo	Ljava/lang/String;
          //   156: invokestatic 110	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
          //   159: ifeq +46 -> 205
          //   162: aload 5
          //   164: iconst_0
          //   165: iconst_1
          //   166: bastore
          //   167: aload_0
          //   168: getfield 22	com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask$1:kuQ	Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask;
          //   171: ldc 112
          //   173: invokestatic 115	com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask:a	(Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask;Ljava/lang/String;)Ljava/lang/String;
          //   176: pop
          //   177: ldc 117
          //   179: ldc 119
          //   181: invokestatic 125	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
          //   184: aload_0
          //   185: getfield 22	com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask$1:kuQ	Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask;
          //   188: invokestatic 129	com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask:b	(Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask;)Z
          //   191: pop
          //   192: ldc 13
          //   194: monitorexit
          //   195: aload_3
          //   196: invokevirtual 92	java/util/Timer:cancel	()V
          //   199: ldc 29
          //   201: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   204: return
          //   205: new 131	org/json/JSONObject
          //   208: dup
          //   209: aload_1
          //   210: getfield 98	android/util/Pair:first	Ljava/lang/Object;
          //   213: checkcast 100	com/tencent/mm/plugin/appbrand/config/WxaAttributes
          //   216: getfield 104	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_appInfo	Ljava/lang/String;
          //   219: invokespecial 134	org/json/JSONObject:<init>	(Ljava/lang/String;)V
          //   222: ldc 136
          //   224: invokevirtual 140	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
          //   227: astore_2
          //   228: aload_2
          //   229: astore_1
          //   230: aload_2
          //   231: ifnonnull +11 -> 242
          //   234: new 131	org/json/JSONObject
          //   237: dup
          //   238: invokespecial 141	org/json/JSONObject:<init>	()V
          //   241: astore_1
          //   242: aload_1
          //   243: ldc 143
          //   245: aload 8
          //   247: invokevirtual 147	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
          //   250: pop
          //   251: aload 4
          //   253: aload_1
          //   254: invokevirtual 150	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
          //   257: pop
          //   258: ldc 13
          //   260: monitorexit
          //   261: goto -190 -> 71
          //   264: astore_1
          //   265: ldc 13
          //   267: monitorexit
          //   268: ldc 29
          //   270: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   273: aload_1
          //   274: athrow
          //   275: astore_1
          //   276: ldc 117
          //   278: aload_1
          //   279: ldc 152
          //   281: iconst_0
          //   282: anewarray 4	java/lang/Object
          //   285: invokestatic 156	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
          //   288: aload_0
          //   289: getfield 22	com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask$1:kuQ	Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask;
          //   292: new 158	java/lang/StringBuilder
          //   295: dup
          //   296: ldc 160
          //   298: invokespecial 161	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   301: aload_1
          //   302: invokevirtual 165	org/json/JSONException:getMessage	()Ljava/lang/String;
          //   305: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   308: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   311: invokestatic 115	com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask:a	(Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask;Ljava/lang/String;)Ljava/lang/String;
          //   314: pop
          //   315: aload_0
          //   316: getfield 22	com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask$1:kuQ	Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask;
          //   319: invokestatic 175	com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask:d	(Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask;)Z
          //   322: pop
          //   323: aload_3
          //   324: invokevirtual 92	java/util/Timer:cancel	()V
          //   327: ldc 29
          //   329: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   332: return
          //   333: aload 6
          //   335: invokestatic 179	com/tencent/mm/sdk/platformtools/bu:ht	(Ljava/util/List;)Z
          //   338: ifne +51 -> 389
          //   341: ldc 117
          //   343: ldc 181
          //   345: iconst_1
          //   346: anewarray 4	java/lang/Object
          //   349: dup
          //   350: iconst_0
          //   351: aload 6
          //   353: invokevirtual 185	java/util/ArrayList:size	()I
          //   356: invokestatic 191	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   359: aastore
          //   360: invokestatic 194	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   363: aload 6
          //   365: invokestatic 179	com/tencent/mm/sdk/platformtools/bu:ht	(Ljava/util/List;)Z
          //   368: ifne +21 -> 389
          //   371: getstatic 200	com/tencent/e/h:MqF	Lcom/tencent/e/i;
          //   374: new 202	com/tencent/mm/plugin/appbrand/config/x$2
          //   377: dup
          //   378: aload 6
          //   380: invokespecial 205	com/tencent/mm/plugin/appbrand/config/x$2:<init>	(Ljava/util/List;)V
          //   383: invokeinterface 211 2 0
          //   388: pop
          //   389: ldc 13
          //   391: monitorenter
          //   392: aload 5
          //   394: iconst_0
          //   395: baload
          //   396: ifeq +16 -> 412
          //   399: ldc 13
          //   401: monitorexit
          //   402: aload_3
          //   403: invokevirtual 92	java/util/Timer:cancel	()V
          //   406: ldc 29
          //   408: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   411: return
          //   412: aload 5
          //   414: iconst_0
          //   415: iconst_1
          //   416: bastore
          //   417: ldc 117
          //   419: ldc 213
          //   421: invokestatic 215	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   424: new 131	org/json/JSONObject
          //   427: dup
          //   428: invokespecial 141	org/json/JSONObject:<init>	()V
          //   431: astore_1
          //   432: aload_1
          //   433: ldc 217
          //   435: ldc 219
          //   437: invokevirtual 147	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
          //   440: pop
          //   441: aload_1
          //   442: ldc 221
          //   444: aload 4
          //   446: invokevirtual 147	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
          //   449: pop
          //   450: aload_0
          //   451: getfield 22	com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask$1:kuQ	Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask;
          //   454: aload_1
          //   455: invokevirtual 222	org/json/JSONObject:toString	()Ljava/lang/String;
          //   458: invokestatic 224	com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask:b	(Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask;Ljava/lang/String;)Ljava/lang/String;
          //   461: pop
          //   462: aload_0
          //   463: getfield 22	com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask$1:kuQ	Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask;
          //   466: invokestatic 227	com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask:c	(Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask;)Z
          //   469: pop
          //   470: ldc 13
          //   472: monitorexit
          //   473: aload_3
          //   474: invokevirtual 92	java/util/Timer:cancel	()V
          //   477: ldc 29
          //   479: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   482: return
          //   483: astore_1
          //   484: ldc 13
          //   486: monitorexit
          //   487: ldc 29
          //   489: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   492: aload_1
          //   493: athrow
          //   494: astore_1
          //   495: aload_3
          //   496: invokevirtual 92	java/util/Timer:cancel	()V
          //   499: ldc 29
          //   501: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   504: aload_1
          //   505: athrow
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	506	0	this	1
          //   100	154	1	localObject1	Object
          //   264	10	1	localObject2	Object
          //   275	27	1	localJSONException	org.json.JSONException
          //   431	24	1	localJSONObject1	org.json.JSONObject
          //   483	10	1	localObject3	Object
          //   494	11	1	localObject4	Object
          //   227	4	2	localJSONObject2	org.json.JSONObject
          //   22	474	3	localTimer	Timer
          //   57	388	4	localJSONArray	org.json.JSONArray
          //   8	405	5	arrayOfBoolean	boolean[]
          //   48	331	6	localArrayList	ArrayList
          //   69	13	7	localIterator	java.util.Iterator
          //   91	155	8	str	String
          // Exception table:
          //   from	to	target	type
          //   126	129	264	finally
          //   139	162	264	finally
          //   167	195	264	finally
          //   205	228	264	finally
          //   234	242	264	finally
          //   242	261	264	finally
          //   265	268	264	finally
          //   41	71	275	org/json/JSONException
          //   71	116	275	org/json/JSONException
          //   116	119	275	org/json/JSONException
          //   268	275	275	org/json/JSONException
          //   333	389	275	org/json/JSONException
          //   389	392	275	org/json/JSONException
          //   487	494	275	org/json/JSONException
          //   399	402	483	finally
          //   417	473	483	finally
          //   484	487	483	finally
          //   41	71	494	finally
          //   71	116	494	finally
          //   116	119	494	finally
          //   268	275	494	finally
          //   276	323	494	finally
          //   333	389	494	finally
          //   389	392	494	finally
          //   487	494	494	finally
        }
      }, "AppBrandJsApiBatchGetContact");
      AppMethodBeat.o(45456);
    }
    
    public final void aOY()
    {
      AppMethodBeat.i(45455);
      ae.i("MicroMsg.JsApiBatchGetContact", "runInClientProcess callback, appId[%s], msg[%s], callbackId[%d], isRunning[%b]", new Object[] { this.jFj.getAppId(), this.kuP, Integer.valueOf(this.kmu), Boolean.valueOf(this.jFj.isRunning()) });
      if (!bu.isNullOrNil(this.kuP)) {
        this.jFj.h(this.kmu, this.kuP);
      }
      for (;;)
      {
        bix();
        AppMethodBeat.o(45455);
        return;
        this.jFj.h(this.kmu, this.kuO.e(this.errMsg, null));
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(45457);
      this.kuN = paramParcel.readArrayList(getClass().getClassLoader());
      this.kuP = paramParcel.readString();
      this.errMsg = paramParcel.readString();
      AppMethodBeat.o(45457);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45458);
      paramParcel.writeList(this.kuN);
      paramParcel.writeString(this.kuP);
      paramParcel.writeString(this.errMsg);
      AppMethodBeat.o(45458);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiBatchGetContact
 * JD-Core Version:    0.7.0.1
 */