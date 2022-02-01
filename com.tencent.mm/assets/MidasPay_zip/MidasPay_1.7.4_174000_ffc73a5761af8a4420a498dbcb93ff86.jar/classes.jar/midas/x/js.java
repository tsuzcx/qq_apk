package midas.x;

import android.os.Bundle;
import android.os.Handler;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class js
{
  private jm a;
  private jp b;
  private jk c;
  private int d = -1;
  private boolean e = false;
  private Runnable f = new Runnable()
  {
    public void run()
    {
      js.this.a(js.a(js.this));
    }
  };
  
  public static js a()
  {
    return a.a();
  }
  
  private void a(int paramInt, Bundle paramBundle)
  {
    if (paramInt == 0)
    {
      paramBundle.getString("rebalance_data");
      d();
      c();
    }
  }
  
  private boolean c()
  {
    if (this.e) {
      return false;
    }
    if (this.d == 2) {
      return true;
    }
    this.d = 2;
    return jy.a(this.f);
  }
  
  private void d()
  {
    jy.b(this.f);
  }
  
  public void a(Handler paramHandler, jm paramjm, jk paramjk)
  {
    this.c = paramjk;
    if (jy.a()) {
      jy.a(new jv(paramHandler));
    }
    this.e = false;
    if ((this.d != 1) && (this.d != 0) && (this.d != 2))
    {
      a(paramjm);
      return;
    }
    paramHandler = new StringBuilder();
    paramHandler.append("connect() prepare connecting, So return! mCurrentStatus=");
    paramHandler.append(this.d);
    jw.b("CoreManager", paramHandler.toString());
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    kc.a().a(paramString1, paramString2, paramString3, paramString4);
  }
  
  public void a(final jm paramjm)
  {
    this.a = paramjm;
    this.d = 0;
    ju.a(paramjm, new jt()
    {
      public void a(int paramAnonymousInt, Throwable paramAnonymousThrowable)
      {
        if (!js.c(js.this))
        {
          js.a(js.this, -1);
          js.b(js.this).a(new jn(-2, "", paramAnonymousThrowable));
        }
      }
      
      public void a(jp paramAnonymousjp)
      {
        if (paramAnonymousjp != null)
        {
          js.b(js.this).a(0, paramAnonymousjp);
          js.this.a(paramjm, paramAnonymousjp);
          return;
        }
        if (!js.c(js.this))
        {
          js.a(js.this, -1);
          js.b(js.this).a(new jn(-2, "", new Exception("Cridential is Null")));
        }
      }
    });
  }
  
  public void a(jm paramjm, jp paramjp)
  {
    this.b = paramjp;
    kc.a().a(paramjm, paramjp, new WebSocketListener()
    {
      public void onClosed(@NotNull WebSocket paramAnonymousWebSocket, int paramAnonymousInt, @NotNull String paramAnonymousString)
      {
        paramAnonymousWebSocket = new StringBuilder();
        paramAnonymousWebSocket.append("onClosed() code = ");
        paramAnonymousWebSocket.append(paramAnonymousInt);
        paramAnonymousWebSocket.append(", reason = ");
        paramAnonymousWebSocket.append(paramAnonymousString);
        jw.b("CoreManager", paramAnonymousWebSocket.toString());
        js.b(js.this).a(paramAnonymousInt, paramAnonymousString);
      }
      
      public void onClosing(@NotNull WebSocket paramAnonymousWebSocket, int paramAnonymousInt, @NotNull String paramAnonymousString)
      {
        paramAnonymousWebSocket = new StringBuilder();
        paramAnonymousWebSocket.append("onClosing() code = ");
        paramAnonymousWebSocket.append(paramAnonymousInt);
        paramAnonymousWebSocket.append(", reason = ");
        paramAnonymousWebSocket.append(paramAnonymousString);
        jw.b("CoreManager", paramAnonymousWebSocket.toString());
      }
      
      public void onFailure(@NotNull WebSocket paramAnonymousWebSocket, @NotNull Throwable paramAnonymousThrowable, @Nullable Response paramAnonymousResponse)
      {
        paramAnonymousWebSocket = new StringBuilder();
        paramAnonymousWebSocket.append("onFailure() Throwable = ");
        paramAnonymousWebSocket.append(paramAnonymousThrowable);
        paramAnonymousWebSocket.append(", response = ");
        paramAnonymousWebSocket.append(paramAnonymousResponse);
        jw.b("CoreManager", paramAnonymousWebSocket.toString());
        if (paramAnonymousThrowable != null) {
          paramAnonymousThrowable.printStackTrace();
        }
        if (!js.c(js.this))
        {
          js.a(js.this, -1);
          js.b(js.this).a(new jn(-1, paramAnonymousThrowable.toString(), paramAnonymousThrowable));
        }
      }
      
      /* Error */
      public void onMessage(@NotNull WebSocket paramAnonymousWebSocket, @NotNull String paramAnonymousString)
      {
        // Byte code:
        //   0: new 23	java/lang/StringBuilder
        //   3: dup
        //   4: invokespecial 24	java/lang/StringBuilder:<init>	()V
        //   7: astore_1
        //   8: aload_1
        //   9: ldc 94
        //   11: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   14: pop
        //   15: aload_1
        //   16: aload_2
        //   17: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   20: pop
        //   21: ldc 37
        //   23: aload_1
        //   24: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   27: invokestatic 96	midas/x/jw:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   30: aload_2
        //   31: invokestatic 102	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   34: ifeq +11 -> 45
        //   37: ldc 37
        //   39: ldc 104
        //   41: invokestatic 96	midas/x/jw:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   44: return
        //   45: aload_2
        //   46: invokestatic 109	midas/x/kc:a	()Lmidas/x/kc;
        //   49: invokevirtual 111	midas/x/kc:b	()Ljava/lang/String;
        //   52: invokestatic 116	midas/x/jq:a	(Ljava/lang/String;Ljava/lang/String;)Lmidas/x/jq;
        //   55: getfield 119	midas/x/jq:a	Lmidas/x/jr;
        //   58: astore_1
        //   59: new 23	java/lang/StringBuilder
        //   62: dup
        //   63: invokespecial 24	java/lang/StringBuilder:<init>	()V
        //   66: astore_2
        //   67: aload_2
        //   68: ldc 121
        //   70: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   73: pop
        //   74: aload_2
        //   75: aload_1
        //   76: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   79: pop
        //   80: ldc 37
        //   82: aload_2
        //   83: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   86: invokestatic 96	midas/x/jw:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   89: aload_1
        //   90: invokevirtual 126	midas/x/jr:c	()Z
        //   93: ifeq +33 -> 126
        //   96: new 128	android/os/Bundle
        //   99: dup
        //   100: invokespecial 129	android/os/Bundle:<init>	()V
        //   103: astore_2
        //   104: aload_2
        //   105: ldc 131
        //   107: aload_1
        //   108: getfield 135	midas/x/jr:k	Ljava/lang/String;
        //   111: invokevirtual 138	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
        //   114: aload_0
        //   115: getfield 14	midas/x/js$3:a	Lmidas/x/js;
        //   118: iconst_0
        //   119: aload_2
        //   120: invokestatic 141	midas/x/js:a	(Lmidas/x/js;ILandroid/os/Bundle;)V
        //   123: goto +63 -> 186
        //   126: aload_1
        //   127: invokevirtual 143	midas/x/jr:b	()Z
        //   130: ifeq +26 -> 156
        //   133: ldc 37
        //   135: ldc 145
        //   137: invokestatic 96	midas/x/jw:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   140: aload_0
        //   141: getfield 14	midas/x/js$3:a	Lmidas/x/js;
        //   144: invokestatic 50	midas/x/js:b	(Lmidas/x/js;)Lmidas/x/jk;
        //   147: aload_1
        //   148: invokeinterface 148 2 0
        //   153: goto +33 -> 186
        //   156: new 23	java/lang/StringBuilder
        //   159: dup
        //   160: invokespecial 24	java/lang/StringBuilder:<init>	()V
        //   163: astore_2
        //   164: aload_2
        //   165: ldc 150
        //   167: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   170: pop
        //   171: aload_2
        //   172: aload_1
        //   173: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   176: pop
        //   177: ldc 37
        //   179: aload_2
        //   180: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   183: invokestatic 96	midas/x/jw:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   186: ldc 37
        //   188: ldc 152
        //   190: invokestatic 96	midas/x/jw:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   193: return
        //   194: astore_1
        //   195: goto +49 -> 244
        //   198: astore_1
        //   199: new 23	java/lang/StringBuilder
        //   202: dup
        //   203: invokespecial 24	java/lang/StringBuilder:<init>	()V
        //   206: astore_2
        //   207: aload_2
        //   208: ldc 154
        //   210: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   213: pop
        //   214: aload_2
        //   215: aload_1
        //   216: invokevirtual 84	java/lang/Throwable:toString	()Ljava/lang/String;
        //   219: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   222: pop
        //   223: ldc 37
        //   225: aload_2
        //   226: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   229: invokestatic 96	midas/x/jw:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   232: aload_1
        //   233: invokevirtual 74	java/lang/Throwable:printStackTrace	()V
        //   236: ldc 37
        //   238: ldc 152
        //   240: invokestatic 96	midas/x/jw:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   243: return
        //   244: ldc 37
        //   246: ldc 152
        //   248: invokestatic 96	midas/x/jw:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   251: aload_1
        //   252: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	253	0	this	3
        //   0	253	1	paramAnonymousWebSocket	WebSocket
        //   0	253	2	paramAnonymousString	String
        // Exception table:
        //   from	to	target	type
        //   45	123	194	finally
        //   126	153	194	finally
        //   156	186	194	finally
        //   199	236	194	finally
        //   45	123	198	java/lang/Throwable
        //   126	153	198	java/lang/Throwable
        //   156	186	198	java/lang/Throwable
      }
      
      public void onMessage(@NotNull WebSocket paramAnonymousWebSocket, @NotNull ByteString paramAnonymousByteString)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onMessage() bytes = ");
        localStringBuilder.append(paramAnonymousByteString);
        jw.b("CoreManager", localStringBuilder.toString());
        super.onMessage(paramAnonymousWebSocket, paramAnonymousByteString);
      }
      
      public void onOpen(@NotNull WebSocket paramAnonymousWebSocket, @NotNull Response paramAnonymousResponse)
      {
        paramAnonymousWebSocket = new StringBuilder();
        paramAnonymousWebSocket.append("onOpen() response = ");
        paramAnonymousWebSocket.append(paramAnonymousResponse);
        jw.b("CoreManager", paramAnonymousWebSocket.toString());
        js.a(js.this, 1);
        js.d(js.this);
        try
        {
          paramAnonymousWebSocket = paramAnonymousResponse.body().string();
          js.b(js.this).b(0, paramAnonymousWebSocket);
          return;
        }
        catch (Exception paramAnonymousWebSocket)
        {
          paramAnonymousWebSocket.printStackTrace();
          js.b(js.this).b(0, "");
        }
      }
    });
  }
  
  public void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("close mCurrentStatus = ");
    localStringBuilder.append(this.d);
    jw.a("CoreManager", localStringBuilder.toString());
    this.e = true;
    if (this.d == -1) {
      return;
    }
    this.d = -1;
    jy.b(this.f);
    ju.a();
    kc.a().c();
  }
  
  static class a
  {
    private static js a = new js(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.js
 * JD-Core Version:    0.7.0.1
 */