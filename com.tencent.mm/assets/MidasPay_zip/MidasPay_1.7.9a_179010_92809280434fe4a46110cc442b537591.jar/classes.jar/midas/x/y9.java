package midas.x;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class y9
{
  public s9 a;
  public q9 b;
  public int c = -1;
  public boolean d = false;
  public Runnable e = new a();
  
  public static y9 d()
  {
    return d.a();
  }
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("close mCurrentStatus = ");
    localStringBuilder.append(this.c);
    ca.c("CoreManager", localStringBuilder.toString());
    this.d = true;
    if (this.c == -1) {
      return;
    }
    this.c = -1;
    ea.a(this.e);
    aa.a();
    ia.d().a();
  }
  
  public final void a(int paramInt, Bundle paramBundle)
  {
    if (paramInt == 0)
    {
      paramBundle.getString("rebalance_data");
      b();
      c();
    }
  }
  
  public void a(Handler paramHandler, s9 params9, q9 paramq9)
  {
    this.b = paramq9;
    if (ea.a()) {
      ea.a(new ba(paramHandler));
    }
    this.d = false;
    int i = this.c;
    if ((i != 1) && (i != 0) && (i != 2))
    {
      a(params9);
      return;
    }
    paramHandler = new StringBuilder();
    paramHandler.append("connect() prepare connecting, So return! mCurrentStatus=");
    paramHandler.append(this.c);
    ca.a("CoreManager", paramHandler.toString());
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ia.d().a(paramString1, paramString2, paramString3, paramString4);
  }
  
  public void a(final s9 params9)
  {
    this.a = params9;
    this.c = 0;
    aa.a(params9, new b(params9));
  }
  
  public void a(s9 params9, v9 paramv9)
  {
    ia.d().a(params9, paramv9, new c());
  }
  
  public final void b()
  {
    ea.a(this.e);
  }
  
  public final boolean c()
  {
    if (this.d) {
      return false;
    }
    if (this.c == 2) {
      return true;
    }
    this.c = 2;
    return ea.b(this.e);
  }
  
  public class a
    implements Runnable
  {
    public a() {}
    
    public void run()
    {
      y9 localy9 = y9.this;
      localy9.a(y9.a(localy9));
    }
  }
  
  public class b
    implements z9<v9>
  {
    public b(s9 params9) {}
    
    public void a(int paramInt, Throwable paramThrowable)
    {
      if (!y9.c(y9.this))
      {
        y9.a(y9.this, -1);
        y9.b(y9.this).a(new t9(-2, "", paramThrowable));
      }
    }
    
    public void a(v9 paramv9)
    {
      if (paramv9 != null)
      {
        y9.b(y9.this).a(0, paramv9);
        y9.this.a(params9, paramv9);
        return;
      }
      if (!y9.c(y9.this))
      {
        y9.a(y9.this, -1);
        y9.b(y9.this).a(new t9(-2, "", new Exception("Cridential is Null")));
      }
    }
  }
  
  public class c
    extends WebSocketListener
  {
    public c() {}
    
    public void onClosed(@NotNull WebSocket paramWebSocket, int paramInt, @NotNull String paramString)
    {
      paramWebSocket = new StringBuilder();
      paramWebSocket.append("onClosed() code = ");
      paramWebSocket.append(paramInt);
      paramWebSocket.append(", reason = ");
      paramWebSocket.append(paramString);
      ca.a("CoreManager", paramWebSocket.toString());
      y9.b(y9.this).a(paramInt, paramString);
    }
    
    public void onClosing(@NotNull WebSocket paramWebSocket, int paramInt, @NotNull String paramString)
    {
      paramWebSocket = new StringBuilder();
      paramWebSocket.append("onClosing() code = ");
      paramWebSocket.append(paramInt);
      paramWebSocket.append(", reason = ");
      paramWebSocket.append(paramString);
      ca.a("CoreManager", paramWebSocket.toString());
    }
    
    public void onFailure(@NotNull WebSocket paramWebSocket, @NotNull Throwable paramThrowable, @Nullable Response paramResponse)
    {
      paramWebSocket = new StringBuilder();
      paramWebSocket.append("onFailure() Throwable = ");
      paramWebSocket.append(paramThrowable);
      paramWebSocket.append(", response = ");
      paramWebSocket.append(paramResponse);
      ca.a("CoreManager", paramWebSocket.toString());
      if (paramThrowable != null) {
        paramThrowable.printStackTrace();
      }
      if (!y9.c(y9.this))
      {
        y9.a(y9.this, -1);
        y9.b(y9.this).a(new t9(-1, paramThrowable.toString(), paramThrowable));
      }
    }
    
    public void onMessage(@NotNull WebSocket paramWebSocket, @NotNull String paramString)
    {
      paramWebSocket = new StringBuilder();
      paramWebSocket.append("onMessage() text = ");
      paramWebSocket.append(paramString);
      ca.c("CoreManager", paramWebSocket.toString());
      if (TextUtils.isEmpty(paramString))
      {
        ca.c("CoreManager", "onMessage() text = Empty, return");
        return;
      }
      try
      {
        paramWebSocket = w9.a(paramString, ia.d().c()).a;
        paramString = new StringBuilder();
        paramString.append("onMessage() wsText = ");
        paramString.append(paramWebSocket);
        ca.c("CoreManager", paramString.toString());
        if (paramWebSocket.b())
        {
          paramString = new Bundle();
          paramString.putString("rebalance_data", paramWebSocket.k);
          y9.a(y9.this, 0, paramString);
        }
        else if (paramWebSocket.a())
        {
          ca.c("CoreManager", "onMessage() isMessage");
          y9.b(y9.this).a(paramWebSocket);
        }
        else
        {
          paramString = new StringBuilder();
          paramString.append("onMessage() wsText other = ");
          paramString.append(paramWebSocket);
          ca.c("CoreManager", paramString.toString());
        }
        ca.c("CoreManager", "onMessage() wsText : finally");
        return;
      }
      finally
      {
        try
        {
          paramString = new StringBuilder();
          paramString.append("onMessage() text Exception = ");
          paramString.append(paramWebSocket.toString());
          ca.c("CoreManager", paramString.toString());
          paramWebSocket.printStackTrace();
          return;
        }
        finally
        {
          ca.c("CoreManager", "onMessage() wsText : finally");
        }
      }
    }
    
    public void onMessage(@NotNull WebSocket paramWebSocket, @NotNull ByteString paramByteString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMessage() bytes = ");
      localStringBuilder.append(paramByteString);
      ca.a("CoreManager", localStringBuilder.toString());
      super.onMessage(paramWebSocket, paramByteString);
    }
    
    public void onOpen(@NotNull WebSocket paramWebSocket, @NotNull Response paramResponse)
    {
      paramWebSocket = new StringBuilder();
      paramWebSocket.append("onOpen() response = ");
      paramWebSocket.append(paramResponse);
      ca.a("CoreManager", paramWebSocket.toString());
      y9.a(y9.this, 1);
      y9.d(y9.this);
      try
      {
        paramWebSocket = paramResponse.body().string();
        y9.b(y9.this).b(0, paramWebSocket);
        return;
      }
      catch (Exception paramWebSocket)
      {
        paramWebSocket.printStackTrace();
        y9.b(y9.this).b(0, "");
      }
    }
  }
  
  public static class d
  {
    public static y9 a = new y9(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.y9
 * JD-Core Version:    0.7.0.1
 */