package midas.x;

import java.util.HashMap;
import okhttp3.HttpUrl;
import okhttp3.HttpUrl.Builder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class kc
{
  private WebSocket a;
  private jm b;
  private WebSocketListener c;
  private jp d;
  private String e;
  
  public static kc a()
  {
    return a.a();
  }
  
  private void d()
  {
    Object localObject1 = this.b.e;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(this.b.f);
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
    OkHttpClient localOkHttpClient = kb.a().b();
    Request localRequest = new Request.Builder().url((String)localObject1).build();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("wssUrl = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    jw.b("WSManager", ((StringBuilder)localObject2).toString());
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("app_id", this.b.g);
    ((HashMap)localObject1).put("openid", this.b.h);
    ((HashMap)localObject1).put("openkey", this.b.i);
    ((HashMap)localObject1).put("session_id", this.b.j);
    ((HashMap)localObject1).put("session_type", this.b.k);
    ((HashMap)localObject1).put("pf", this.b.l);
    ((HashMap)localObject1).put("pfkey", this.b.m);
    ((HashMap)localObject1).put("client_id", this.b.p);
    ((HashMap)localObject1).put("token", this.d.a);
    ((HashMap)localObject1).put("random", String.valueOf(System.currentTimeMillis()));
    this.e = kf.a();
    localObject1 = kj.a((HashMap)localObject1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("srcData = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    jw.b("RegisterManager", ((StringBuilder)localObject2).toString());
    localObject2 = kf.a((String)localObject1, this.e);
    String str = kg.a(ki.a(this.e, ki.a()));
    localObject2 = localRequest.url().newBuilder().addQueryParameter("app_id", this.b.g).addQueryParameter("openid", this.b.h).addQueryParameter("encrypt_msg", (String)localObject2).addQueryParameter("msg_len", String.valueOf(((String)localObject1).length())).addQueryParameter("key_msg", str).addQueryParameter("req_from", this.b.o).build().toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("httpUrl = ");
    ((StringBuilder)localObject1).append((String)localObject2);
    jw.b("WSManager", ((StringBuilder)localObject1).toString());
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
    jw.b("WSManager", ((StringBuilder)localObject2).toString());
    this.a = localOkHttpClient.newWebSocket(localRequest.newBuilder().url((String)localObject1).build(), this.c);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString2 = jr.a(paramString2, paramString3, paramString4);
    paramString2.i = "msg";
    paramString2.k = paramString1;
    paramString1 = new jq(paramString2, this.e);
    paramString2 = new StringBuilder();
    paramString2.append("send() mWebSocket = ");
    paramString2.append(this.a);
    paramString2.append(", signText = ");
    paramString2.append(paramString1.a());
    jw.a("WSManager", paramString2.toString());
    if (this.a != null) {
      this.a.send(paramString1.a());
    }
  }
  
  public void a(jm paramjm, jp paramjp, WebSocketListener paramWebSocketListener)
  {
    this.b = paramjm;
    this.d = paramjp;
    this.c = paramWebSocketListener;
    d();
  }
  
  public String b()
  {
    return this.e;
  }
  
  public void c()
  {
    if (this.a != null) {
      this.a.close(1000, "bye");
    }
  }
  
  static class a
  {
    private static kc a = new kc(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.kc
 * JD-Core Version:    0.7.0.1
 */