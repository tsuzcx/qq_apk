package midas.x;

import java.util.HashMap;
import okhttp3.HttpUrl;
import okhttp3.HttpUrl.Builder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class ia
{
  public WebSocket a;
  public s9 b;
  public WebSocketListener c;
  public v9 d;
  public String e;
  
  public static ia d()
  {
    return b.a();
  }
  
  public void a()
  {
    WebSocket localWebSocket = this.a;
    if (localWebSocket != null) {
      localWebSocket.close(1000, "bye");
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString2 = x9.a(paramString2, paramString3, paramString4);
    paramString2.i = "msg";
    paramString2.k = paramString1;
    paramString1 = new w9(paramString2, this.e);
    paramString2 = new StringBuilder();
    paramString2.append("send() mWebSocket = ");
    paramString2.append(this.a);
    paramString2.append(", signText = ");
    paramString2.append(paramString1.a());
    ca.c("WSManager", paramString2.toString());
    paramString2 = this.a;
    if (paramString2 != null) {
      paramString2.send(paramString1.a());
    }
  }
  
  public void a(s9 params9, v9 paramv9, WebSocketListener paramWebSocketListener)
  {
    this.b = params9;
    this.d = paramv9;
    this.c = paramWebSocketListener;
    b();
  }
  
  public final void b()
  {
    Object localObject1 = this.b.c;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(this.b.d);
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject1 = localObject2;
    if (!((String)localObject2).startsWith("wss://"))
    {
      localObject1 = localObject2;
      if (!((String)localObject2).startsWith("ws://"))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("wss://");
        ((StringBuilder)localObject1).append((String)localObject2);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    OkHttpClient localOkHttpClient = ha.c().b();
    Request localRequest = new Request.Builder().url((String)localObject1).build();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("wssUrl = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ca.a("WSManager", ((StringBuilder)localObject2).toString());
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("app_id", this.b.e);
    ((HashMap)localObject1).put("openid", this.b.f);
    ((HashMap)localObject1).put("openkey", this.b.g);
    ((HashMap)localObject1).put("session_id", this.b.h);
    ((HashMap)localObject1).put("session_type", this.b.i);
    ((HashMap)localObject1).put("pf", this.b.j);
    ((HashMap)localObject1).put("pfkey", this.b.k);
    ((HashMap)localObject1).put("client_id", this.b.n);
    ((HashMap)localObject1).put("token", this.d.a);
    ((HashMap)localObject1).put("random", String.valueOf(System.currentTimeMillis()));
    this.e = la.a();
    localObject1 = pa.a((HashMap)localObject1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("srcData = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ca.a("RegisterManager", ((StringBuilder)localObject2).toString());
    localObject2 = la.a((String)localObject1, this.e);
    String str = ma.a(oa.a(this.e, oa.a()));
    localObject2 = localRequest.url().newBuilder().addQueryParameter("app_id", this.b.e).addQueryParameter("openid", this.b.f).addQueryParameter("encrypt_msg", (String)localObject2).addQueryParameter("msg_len", String.valueOf(((String)localObject1).length())).addQueryParameter("key_msg", str).addQueryParameter("req_from", this.b.m).build().toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("httpUrl = ");
    ((StringBuilder)localObject1).append((String)localObject2);
    ca.a("WSManager", ((StringBuilder)localObject1).toString());
    if (((String)localObject2).startsWith("http://"))
    {
      localObject1 = ((String)localObject2).replaceFirst("http://", "ws://");
    }
    else
    {
      localObject1 = localObject2;
      if (((String)localObject2).startsWith("https://")) {
        localObject1 = ((String)localObject2).replaceFirst("https://", "wss://");
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("httpUrl = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ca.a("WSManager", ((StringBuilder)localObject2).toString());
    this.a = localOkHttpClient.newWebSocket(localRequest.newBuilder().url((String)localObject1).build(), this.c);
  }
  
  public String c()
  {
    return this.e;
  }
  
  public static class b
  {
    public static ia a = new ia(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.ia
 * JD-Core Version:    0.7.0.1
 */