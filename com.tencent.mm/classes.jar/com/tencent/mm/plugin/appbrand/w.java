package com.tencent.mm.plugin.appbrand;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.appbrand.v8.v;
import com.tencent.mm.appbrand.v8.v.5;
import com.tencent.mm.appbrand.v8.v.a;
import com.tencent.mm.plugin.appbrand.appcache.be;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.k;
import com.tencent.mm.plugin.appbrand.z.d;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class w
{
  protected com.tencent.mm.appbrand.v8.w cOi;
  protected q jdy;
  public v jhA;
  private ArrayList<v.a> jhB;
  k jhz;
  
  public w(q paramq)
  {
    AppMethodBeat.i(134612);
    this.cOi = new com.tencent.mm.appbrand.v8.w()
    {
      public final int LV()
      {
        AppMethodBeat.i(134606);
        if (w.this.jhz != null)
        {
          int i = w.this.jhz.getNativeBufferId();
          AppMethodBeat.o(134606);
          return i;
        }
        AppMethodBeat.o(134606);
        return 0;
      }
      
      public final void bufferStoreBindTo(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(134610);
        if (w.this.jhz != null) {
          w.this.jhz.bufferStoreBindTo(paramAnonymousLong1, paramAnonymousLong2);
        }
        AppMethodBeat.o(134610);
      }
      
      public final ByteBuffer getBuffer(int paramAnonymousInt)
      {
        AppMethodBeat.i(134607);
        if (w.this.jhz != null)
        {
          ByteBuffer localByteBuffer = w.this.jhz.getNativeBuffer(paramAnonymousInt);
          AppMethodBeat.o(134607);
          return localByteBuffer;
        }
        AppMethodBeat.o(134607);
        return null;
      }
      
      public final void n(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(134611);
        w.this.jdy.aUV().evaluateJavascript(String.format("typeof WeixinWorker.workerMsgHandler !== 'undefined' && WeixinWorker.workerMsgHandler(%d, %s);", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString }), null);
        AppMethodBeat.o(134611);
      }
      
      public final void setBuffer(int paramAnonymousInt, ByteBuffer paramAnonymousByteBuffer)
      {
        AppMethodBeat.i(134608);
        if (w.this.jhz != null) {
          w.this.jhz.setNativeBuffer(paramAnonymousInt, paramAnonymousByteBuffer);
        }
        AppMethodBeat.o(134608);
      }
      
      public final boolean supportBufferStoreBindTo()
      {
        AppMethodBeat.i(134609);
        if (w.this.jhz != null)
        {
          boolean bool = w.this.jhz.supportBufferStoreBindTo();
          AppMethodBeat.o(134609);
          return bool;
        }
        AppMethodBeat.o(134609);
        return false;
      }
    };
    this.jdy = paramq;
    this.jhz = ((k)paramq.aUV().P(k.class));
    this.jhA = aUx();
    this.jhB = new ArrayList();
    String str1 = this.jdy.Dr() + "wxa_library/bootstrap_j2v8_worker.js";
    String str2 = d.Rn("wxa_library/bootstrap_j2v8_worker.js");
    this.jhB.add(new v.a(str1, str2));
    paramq.aUV().addJavascriptInterface(this, "WeixinWorker");
    AppMethodBeat.o(134612);
  }
  
  protected v.a Hy(String paramString)
  {
    AppMethodBeat.i(134615);
    paramString = new v.a(this.jdy.Dq() + paramString, be.d(this.jdy.getRuntime(), paramString) + this.jdy.ck(paramString));
    AppMethodBeat.o(134615);
    return paramString;
  }
  
  protected void a(ArrayList<v.a> paramArrayList, String paramString)
  {
    AppMethodBeat.i(134616);
    paramArrayList.add(new v.a(this.jdy.Dr() + "config", String.format("var __wxConfig = %s;", new Object[] { this.jdy.Do().toString() })));
    AppMethodBeat.o(134616);
  }
  
  protected v aUx()
  {
    AppMethodBeat.i(134613);
    v localv = new v(this.cOi);
    AppMethodBeat.o(134613);
    return localv;
  }
  
  @JavascriptInterface
  public int create(String paramString)
  {
    AppMethodBeat.i(134614);
    int i = createWithParams(paramString, null);
    AppMethodBeat.o(134614);
    return i;
  }
  
  /* Error */
  @JavascriptInterface
  public int createWithParams(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 163
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 165
    //   7: ldc 167
    //   9: iconst_2
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: aload_1
    //   16: aastore
    //   17: dup
    //   18: iconst_1
    //   19: aload_2
    //   20: aastore
    //   21: invokestatic 172	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   24: new 60	java/util/ArrayList
    //   27: dup
    //   28: aload_0
    //   29: getfield 63	com/tencent/mm/plugin/appbrand/w:jhB	Ljava/util/ArrayList;
    //   32: invokespecial 175	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   35: astore 6
    //   37: aload_0
    //   38: aload 6
    //   40: aload_1
    //   41: invokevirtual 177	com/tencent/mm/plugin/appbrand/w:a	(Ljava/util/ArrayList;Ljava/lang/String;)V
    //   44: aload 6
    //   46: aload_0
    //   47: aload_1
    //   48: invokevirtual 179	com/tencent/mm/plugin/appbrand/w:Hy	(Ljava/lang/String;)Lcom/tencent/mm/appbrand/v8/v$a;
    //   51: invokevirtual 94	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   54: pop
    //   55: aload_2
    //   56: ifnull +132 -> 188
    //   59: new 136	org/json/JSONObject
    //   62: dup
    //   63: aload_2
    //   64: invokespecial 182	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   67: ldc 184
    //   69: invokevirtual 188	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   72: astore 5
    //   74: aload 5
    //   76: ifnull +112 -> 188
    //   79: aload 5
    //   81: invokevirtual 194	org/json/JSONArray:length	()I
    //   84: ifle +104 -> 188
    //   87: new 60	java/util/ArrayList
    //   90: dup
    //   91: bipush 10
    //   93: invokespecial 196	java/util/ArrayList:<init>	(I)V
    //   96: astore 4
    //   98: iconst_0
    //   99: istore_3
    //   100: aload 4
    //   102: astore_1
    //   103: iload_3
    //   104: aload 5
    //   106: invokevirtual 194	org/json/JSONArray:length	()I
    //   109: if_icmpge +45 -> 154
    //   112: aload 4
    //   114: aload 5
    //   116: iload_3
    //   117: invokevirtual 200	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   120: invokeinterface 203 2 0
    //   125: pop
    //   126: iload_3
    //   127: iconst_1
    //   128: iadd
    //   129: istore_3
    //   130: goto -30 -> 100
    //   133: astore 4
    //   135: aconst_null
    //   136: astore_1
    //   137: ldc 165
    //   139: aload 4
    //   141: ldc 205
    //   143: iconst_1
    //   144: anewarray 4	java/lang/Object
    //   147: dup
    //   148: iconst_0
    //   149: aload_2
    //   150: aastore
    //   151: invokestatic 209	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   154: aload_0
    //   155: getfield 58	com/tencent/mm/plugin/appbrand/w:jhA	Lcom/tencent/mm/appbrand/v8/v;
    //   158: aload 6
    //   160: aload_0
    //   161: getfield 36	com/tencent/mm/plugin/appbrand/w:jdy	Lcom/tencent/mm/plugin/appbrand/q;
    //   164: aload_1
    //   165: invokevirtual 212	com/tencent/mm/appbrand/v8/v:a	(Ljava/util/ArrayList;Lcom/tencent/mm/plugin/appbrand/jsapi/d;Ljava/util/List;)I
    //   168: istore_3
    //   169: ldc 163
    //   171: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: iload_3
    //   175: ireturn
    //   176: astore 5
    //   178: aload 4
    //   180: astore_1
    //   181: aload 5
    //   183: astore 4
    //   185: goto -48 -> 137
    //   188: aconst_null
    //   189: astore_1
    //   190: goto -36 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	w
    //   0	193	1	paramString1	String
    //   0	193	2	paramString2	String
    //   99	76	3	i	int
    //   96	17	4	localArrayList1	ArrayList
    //   133	46	4	localJSONException1	org.json.JSONException
    //   183	1	4	localJSONException2	org.json.JSONException
    //   72	43	5	localJSONArray	org.json.JSONArray
    //   176	6	5	localJSONException3	org.json.JSONException
    //   35	124	6	localArrayList2	ArrayList
    // Exception table:
    //   from	to	target	type
    //   59	74	133	org/json/JSONException
    //   79	98	133	org/json/JSONException
    //   103	126	176	org/json/JSONException
  }
  
  @JavascriptInterface
  public void postMsgToWorker(int paramInt, String paramString)
  {
    AppMethodBeat.i(134618);
    v localv = this.jhA;
    m localm = (m)localv.cOh.get(Integer.valueOf(paramInt));
    if (localm != null) {
      localm.cMX.r(new v.5(localv, localm, paramString));
    }
    AppMethodBeat.o(134618);
  }
  
  @JavascriptInterface
  public void terminate(int paramInt)
  {
    AppMethodBeat.i(134617);
    m localm = (m)this.jhA.cOh.remove(Integer.valueOf(paramInt));
    if (localm != null) {
      localm.destroy();
    }
    AppMethodBeat.o(134617);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.w
 * JD-Core Version:    0.7.0.1
 */