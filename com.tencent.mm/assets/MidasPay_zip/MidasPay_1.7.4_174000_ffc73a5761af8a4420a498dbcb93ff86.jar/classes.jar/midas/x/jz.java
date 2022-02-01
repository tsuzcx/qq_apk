package midas.x;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.HttpUrl.Builder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;

public class jz
{
  private OkHttpClient a;
  private HttpUrl.Builder b;
  
  public jz(OkHttpClient paramOkHttpClient, HttpUrl.Builder paramBuilder)
  {
    this.a = paramOkHttpClient;
    this.b = paramBuilder;
  }
  
  public jz a(String paramString1, String paramString2)
  {
    this.b.addQueryParameter(paramString1, paramString2);
    return this;
  }
  
  public void a(final ka paramka)
  {
    final HttpUrl localHttpUrl = this.b.build();
    Object localObject = new Request.Builder().url(localHttpUrl).build();
    localObject = this.a.newCall((Request)localObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HttpUrl = ");
    localStringBuilder.append(localHttpUrl.toString());
    jw.a("GetRequest", localStringBuilder.toString());
    ((Call)localObject).enqueue(new Callback()
    {
      public void onFailure(Call paramAnonymousCall, IOException paramAnonymousIOException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onFailure() = ");
        localStringBuilder.append(paramAnonymousIOException);
        jw.a("GetRequest", localStringBuilder.toString());
        if (!paramAnonymousCall.isCanceled()) {
          paramAnonymousCall.cancel();
        }
        paramka.a(paramAnonymousCall, paramAnonymousIOException);
      }
      
      /* Error */
      public void onResponse(Call paramAnonymousCall, okhttp3.Response paramAnonymousResponse)
        throws IOException
      {
        // Byte code:
        //   0: new 32	java/lang/StringBuilder
        //   3: dup
        //   4: invokespecial 33	java/lang/StringBuilder:<init>	()V
        //   7: astore 4
        //   9: aload 4
        //   11: ldc 75
        //   13: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   16: pop
        //   17: aload 4
        //   19: aload_2
        //   20: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   23: pop
        //   24: ldc 44
        //   26: aload 4
        //   28: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   31: invokestatic 53	midas/x/jw:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   34: aload_2
        //   35: invokevirtual 81	okhttp3/Response:code	()I
        //   38: sipush 200
        //   41: if_icmplt +170 -> 211
        //   44: aload_2
        //   45: invokevirtual 81	okhttp3/Response:code	()I
        //   48: sipush 300
        //   51: if_icmpge +160 -> 211
        //   54: aload_2
        //   55: invokevirtual 85	okhttp3/Response:body	()Lokhttp3/ResponseBody;
        //   58: invokevirtual 90	okhttp3/ResponseBody:string	()Ljava/lang/String;
        //   61: astore 4
        //   63: new 32	java/lang/StringBuilder
        //   66: dup
        //   67: invokespecial 33	java/lang/StringBuilder:<init>	()V
        //   70: astore 5
        //   72: aload 5
        //   74: ldc 92
        //   76: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   79: pop
        //   80: aload 5
        //   82: aload 4
        //   84: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   87: pop
        //   88: ldc 44
        //   90: aload 5
        //   92: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   95: invokestatic 53	midas/x/jw:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   98: new 94	org/json/JSONObject
        //   101: dup
        //   102: aload 4
        //   104: invokespecial 97	org/json/JSONObject:<init>	(Ljava/lang/String;)V
        //   107: astore 4
        //   109: aload 4
        //   111: ldc 99
        //   113: invokevirtual 103	org/json/JSONObject:optInt	(Ljava/lang/String;)I
        //   116: istore_3
        //   117: iload_3
        //   118: ifne +24 -> 142
        //   121: aload 4
        //   123: ldc 105
        //   125: invokevirtual 109	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
        //   128: astore 4
        //   130: aload_0
        //   131: getfield 22	midas/x/jz$1:a	Lmidas/x/ka;
        //   134: aload 4
        //   136: invokevirtual 112	midas/x/ka:a	(Lorg/json/JSONObject;)V
        //   139: goto +61 -> 200
        //   142: aload 4
        //   144: ldc 114
        //   146: invokevirtual 118	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
        //   149: astore 4
        //   151: aload_0
        //   152: getfield 22	midas/x/jz$1:a	Lmidas/x/ka;
        //   155: aload_1
        //   156: new 120	midas/x/kd
        //   159: dup
        //   160: aload_0
        //   161: getfield 24	midas/x/jz$1:b	Lokhttp3/HttpUrl;
        //   164: invokevirtual 123	okhttp3/HttpUrl:toString	()Ljava/lang/String;
        //   167: iload_3
        //   168: aload 4
        //   170: invokespecial 126	midas/x/kd:<init>	(Ljava/lang/String;ILjava/lang/String;)V
        //   173: invokevirtual 67	midas/x/ka:a	(Lokhttp3/Call;Ljava/lang/Exception;)V
        //   176: goto +24 -> 200
        //   179: astore_1
        //   180: goto +25 -> 205
        //   183: astore 4
        //   185: aload 4
        //   187: invokevirtual 129	java/lang/Exception:printStackTrace	()V
        //   190: aload_0
        //   191: getfield 22	midas/x/jz$1:a	Lmidas/x/ka;
        //   194: aload_1
        //   195: aload 4
        //   197: invokevirtual 67	midas/x/ka:a	(Lokhttp3/Call;Ljava/lang/Exception;)V
        //   200: aload_2
        //   201: invokevirtual 132	okhttp3/Response:close	()V
        //   204: return
        //   205: aload_2
        //   206: invokevirtual 132	okhttp3/Response:close	()V
        //   209: aload_1
        //   210: athrow
        //   211: aload_2
        //   212: invokevirtual 85	okhttp3/Response:body	()Lokhttp3/ResponseBody;
        //   215: invokevirtual 90	okhttp3/ResponseBody:string	()Ljava/lang/String;
        //   218: astore 4
        //   220: new 32	java/lang/StringBuilder
        //   223: dup
        //   224: invokespecial 33	java/lang/StringBuilder:<init>	()V
        //   227: astore 5
        //   229: aload 5
        //   231: ldc 134
        //   233: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   236: pop
        //   237: aload 5
        //   239: aload 4
        //   241: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   244: pop
        //   245: ldc 44
        //   247: aload 5
        //   249: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   252: invokestatic 53	midas/x/jw:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   255: goto +10 -> 265
        //   258: astore 4
        //   260: aload 4
        //   262: invokevirtual 129	java/lang/Exception:printStackTrace	()V
        //   265: aload_1
        //   266: invokeinterface 59 1 0
        //   271: ifne +9 -> 280
        //   274: aload_1
        //   275: invokeinterface 62 1 0
        //   280: aload_0
        //   281: getfield 22	midas/x/jz$1:a	Lmidas/x/ka;
        //   284: aload_1
        //   285: new 136	midas/x/ke
        //   288: dup
        //   289: aload_0
        //   290: getfield 24	midas/x/jz$1:b	Lokhttp3/HttpUrl;
        //   293: invokevirtual 123	okhttp3/HttpUrl:toString	()Ljava/lang/String;
        //   296: aload_2
        //   297: invokevirtual 81	okhttp3/Response:code	()I
        //   300: aload_2
        //   301: invokevirtual 139	okhttp3/Response:message	()Ljava/lang/String;
        //   304: invokespecial 140	midas/x/ke:<init>	(Ljava/lang/String;ILjava/lang/String;)V
        //   307: invokevirtual 67	midas/x/ka:a	(Lokhttp3/Call;Ljava/lang/Exception;)V
        //   310: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	311	0	this	1
        //   0	311	1	paramAnonymousCall	Call
        //   0	311	2	paramAnonymousResponse	okhttp3.Response
        //   116	52	3	i	int
        //   7	162	4	localObject	Object
        //   183	13	4	localException1	java.lang.Exception
        //   218	22	4	str	String
        //   258	3	4	localException2	java.lang.Exception
        //   70	178	5	localStringBuilder	StringBuilder
        // Exception table:
        //   from	to	target	type
        //   54	117	179	finally
        //   121	139	179	finally
        //   142	176	179	finally
        //   185	200	179	finally
        //   54	117	183	java/lang/Exception
        //   121	139	183	java/lang/Exception
        //   142	176	183	java/lang/Exception
        //   211	255	258	java/lang/Exception
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.jz
 * JD-Core Version:    0.7.0.1
 */