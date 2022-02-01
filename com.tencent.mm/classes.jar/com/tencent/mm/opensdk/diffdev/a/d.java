package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;

public final class d
  extends AsyncTask<Void, Void, a>
{
  private static String h = "https://open.weixin.qq.com/connect/sdk/qrconnect?appid=%s&noncestr=%s&timestamp=%s&scope=%s&signature=%s";
  private String appId;
  private String i;
  private String j;
  private OAuthListener k;
  private f l;
  private String scope;
  private String signature;
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, OAuthListener paramOAuthListener)
  {
    this.appId = paramString1;
    this.scope = paramString2;
    this.i = paramString3;
    this.j = paramString4;
    this.signature = paramString5;
    this.k = paramOAuthListener;
  }
  
  public final boolean a()
  {
    AppMethodBeat.i(3719);
    Log.i("MicroMsg.SDK.GetQRCodeTask", "cancelTask");
    if (this.l == null)
    {
      bool = cancel(true);
      AppMethodBeat.o(3719);
      return bool;
    }
    boolean bool = this.l.cancel(true);
    AppMethodBeat.o(3719);
    return bool;
  }
  
  static final class a
  {
    public OAuthErrCode m;
    public String n;
    public String o;
    public String p;
    public int q;
    public String r;
    public byte[] s;
    
    /* Error */
    public static a a(byte[] paramArrayOfByte)
    {
      // Byte code:
      //   0: sipush 3742
      //   3: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: new 2	com/tencent/mm/opensdk/diffdev/a/d$a
      //   9: dup
      //   10: invokespecial 33	com/tencent/mm/opensdk/diffdev/a/d$a:<init>	()V
      //   13: astore_2
      //   14: aload_0
      //   15: ifnull +8 -> 23
      //   18: aload_0
      //   19: arraylength
      //   20: ifne +25 -> 45
      //   23: ldc 35
      //   25: ldc 37
      //   27: invokestatic 43	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   30: aload_2
      //   31: getstatic 48	com/tencent/mm/opensdk/diffdev/OAuthErrCode:WechatAuth_Err_NetworkErr	Lcom/tencent/mm/opensdk/diffdev/OAuthErrCode;
      //   34: putfield 50	com/tencent/mm/opensdk/diffdev/a/d$a:m	Lcom/tencent/mm/opensdk/diffdev/OAuthErrCode;
      //   37: sipush 3742
      //   40: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   43: aload_2
      //   44: areturn
      //   45: new 54	java/lang/String
      //   48: dup
      //   49: aload_0
      //   50: ldc 56
      //   52: invokespecial 59	java/lang/String:<init>	([BLjava/lang/String;)V
      //   55: astore_0
      //   56: new 61	org/json/JSONObject
      //   59: dup
      //   60: aload_0
      //   61: invokespecial 64	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   64: astore_0
      //   65: aload_0
      //   66: ldc 66
      //   68: invokevirtual 70	org/json/JSONObject:getInt	(Ljava/lang/String;)I
      //   71: istore_1
      //   72: iload_1
      //   73: ifeq +91 -> 164
      //   76: ldc 35
      //   78: ldc 72
      //   80: iconst_1
      //   81: anewarray 4	java/lang/Object
      //   84: dup
      //   85: iconst_0
      //   86: iload_1
      //   87: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   90: aastore
      //   91: invokestatic 82	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   94: invokestatic 43	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   97: aload_2
      //   98: getstatic 85	com/tencent/mm/opensdk/diffdev/OAuthErrCode:WechatAuth_Err_NormalErr	Lcom/tencent/mm/opensdk/diffdev/OAuthErrCode;
      //   101: putfield 50	com/tencent/mm/opensdk/diffdev/a/d$a:m	Lcom/tencent/mm/opensdk/diffdev/OAuthErrCode;
      //   104: aload_2
      //   105: iload_1
      //   106: putfield 87	com/tencent/mm/opensdk/diffdev/a/d$a:q	I
      //   109: aload_2
      //   110: aload_0
      //   111: ldc 89
      //   113: invokevirtual 93	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
      //   116: putfield 95	com/tencent/mm/opensdk/diffdev/a/d$a:r	Ljava/lang/String;
      //   119: sipush 3742
      //   122: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   125: aload_2
      //   126: areturn
      //   127: astore_0
      //   128: ldc 35
      //   130: ldc 97
      //   132: iconst_1
      //   133: anewarray 4	java/lang/Object
      //   136: dup
      //   137: iconst_0
      //   138: aload_0
      //   139: invokevirtual 101	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   142: aastore
      //   143: invokestatic 82	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   146: invokestatic 43	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   149: aload_2
      //   150: getstatic 85	com/tencent/mm/opensdk/diffdev/OAuthErrCode:WechatAuth_Err_NormalErr	Lcom/tencent/mm/opensdk/diffdev/OAuthErrCode;
      //   153: putfield 50	com/tencent/mm/opensdk/diffdev/a/d$a:m	Lcom/tencent/mm/opensdk/diffdev/OAuthErrCode;
      //   156: sipush 3742
      //   159: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   162: aload_2
      //   163: areturn
      //   164: aload_0
      //   165: ldc 103
      //   167: invokevirtual 107	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
      //   170: ldc 109
      //   172: invokevirtual 112	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   175: astore_3
      //   176: aload_3
      //   177: ifnull +10 -> 187
      //   180: aload_3
      //   181: invokevirtual 116	java/lang/String:length	()I
      //   184: ifne +25 -> 209
      //   187: ldc 35
      //   189: ldc 118
      //   191: invokestatic 43	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   194: aload_2
      //   195: getstatic 121	com/tencent/mm/opensdk/diffdev/OAuthErrCode:WechatAuth_Err_JsonDecodeErr	Lcom/tencent/mm/opensdk/diffdev/OAuthErrCode;
      //   198: putfield 50	com/tencent/mm/opensdk/diffdev/a/d$a:m	Lcom/tencent/mm/opensdk/diffdev/OAuthErrCode;
      //   201: sipush 3742
      //   204: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   207: aload_2
      //   208: areturn
      //   209: aload_3
      //   210: iconst_0
      //   211: invokestatic 127	android/util/Base64:decode	(Ljava/lang/String;I)[B
      //   214: astore_3
      //   215: aload_3
      //   216: ifnull +8 -> 224
      //   219: aload_3
      //   220: arraylength
      //   221: ifne +25 -> 246
      //   224: ldc 35
      //   226: ldc 129
      //   228: invokestatic 43	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   231: aload_2
      //   232: getstatic 121	com/tencent/mm/opensdk/diffdev/OAuthErrCode:WechatAuth_Err_JsonDecodeErr	Lcom/tencent/mm/opensdk/diffdev/OAuthErrCode;
      //   235: putfield 50	com/tencent/mm/opensdk/diffdev/a/d$a:m	Lcom/tencent/mm/opensdk/diffdev/OAuthErrCode;
      //   238: sipush 3742
      //   241: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   244: aload_2
      //   245: areturn
      //   246: aload_2
      //   247: getstatic 132	com/tencent/mm/opensdk/diffdev/OAuthErrCode:WechatAuth_Err_OK	Lcom/tencent/mm/opensdk/diffdev/OAuthErrCode;
      //   250: putfield 50	com/tencent/mm/opensdk/diffdev/a/d$a:m	Lcom/tencent/mm/opensdk/diffdev/OAuthErrCode;
      //   253: aload_2
      //   254: aload_3
      //   255: putfield 134	com/tencent/mm/opensdk/diffdev/a/d$a:s	[B
      //   258: aload_2
      //   259: aload_0
      //   260: ldc 136
      //   262: invokevirtual 112	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   265: putfield 138	com/tencent/mm/opensdk/diffdev/a/d$a:n	Ljava/lang/String;
      //   268: aload_2
      //   269: aload_0
      //   270: ldc 140
      //   272: invokevirtual 112	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   275: putfield 142	com/tencent/mm/opensdk/diffdev/a/d$a:o	Ljava/lang/String;
      //   278: ldc 35
      //   280: ldc 144
      //   282: iconst_3
      //   283: anewarray 4	java/lang/Object
      //   286: dup
      //   287: iconst_0
      //   288: aload_2
      //   289: getfield 138	com/tencent/mm/opensdk/diffdev/a/d$a:n	Ljava/lang/String;
      //   292: aastore
      //   293: dup
      //   294: iconst_1
      //   295: aload_2
      //   296: getfield 142	com/tencent/mm/opensdk/diffdev/a/d$a:o	Ljava/lang/String;
      //   299: aastore
      //   300: dup
      //   301: iconst_2
      //   302: aload_2
      //   303: getfield 134	com/tencent/mm/opensdk/diffdev/a/d$a:s	[B
      //   306: arraylength
      //   307: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   310: aastore
      //   311: invokestatic 82	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   314: invokestatic 147	com/tencent/mm/opensdk/utils/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   317: sipush 3742
      //   320: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   323: aload_2
      //   324: areturn
      //   325: astore_0
      //   326: ldc 35
      //   328: ldc 149
      //   330: iconst_1
      //   331: anewarray 4	java/lang/Object
      //   334: dup
      //   335: iconst_0
      //   336: aload_0
      //   337: invokevirtual 101	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   340: aastore
      //   341: invokestatic 82	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   344: invokestatic 43	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   347: aload_2
      //   348: getstatic 85	com/tencent/mm/opensdk/diffdev/OAuthErrCode:WechatAuth_Err_NormalErr	Lcom/tencent/mm/opensdk/diffdev/OAuthErrCode;
      //   351: putfield 50	com/tencent/mm/opensdk/diffdev/a/d$a:m	Lcom/tencent/mm/opensdk/diffdev/OAuthErrCode;
      //   354: sipush 3742
      //   357: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   360: aload_2
      //   361: areturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	362	0	paramArrayOfByte	byte[]
      //   71	35	1	i	int
      //   13	348	2	locala	a
      //   175	80	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   45	56	127	java/lang/Exception
      //   56	72	325	java/lang/Exception
      //   76	119	325	java/lang/Exception
      //   164	176	325	java/lang/Exception
      //   180	187	325	java/lang/Exception
      //   187	201	325	java/lang/Exception
      //   209	215	325	java/lang/Exception
      //   219	224	325	java/lang/Exception
      //   224	238	325	java/lang/Exception
      //   246	317	325	java/lang/Exception
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.a.d
 * JD-Core Version:    0.7.0.1
 */