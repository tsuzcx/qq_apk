package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.diffdev.IDiffDevOAuth;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
  implements IDiffDevOAuth
{
  private Handler a;
  private List<OAuthListener> b;
  private b c;
  private OAuthListener d;
  
  public a()
  {
    AppMethodBeat.i(3722);
    this.a = null;
    this.b = new ArrayList();
    this.d = new a();
    AppMethodBeat.o(3722);
  }
  
  public void addListener(OAuthListener paramOAuthListener)
  {
    AppMethodBeat.i(3725);
    if (!this.b.contains(paramOAuthListener)) {
      this.b.add(paramOAuthListener);
    }
    AppMethodBeat.o(3725);
  }
  
  public boolean auth(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, OAuthListener paramOAuthListener)
  {
    AppMethodBeat.i(3723);
    Log.i("MicroMsg.SDK.DiffDevOAuth", "start auth, appId = ".concat(String.valueOf(paramString1)));
    if ((paramString1 != null) && (paramString1.length() > 0) && (paramString2 != null) && (paramString2.length() > 0))
    {
      if (this.a == null) {
        this.a = new Handler(Looper.getMainLooper());
      }
      if (!this.b.contains(paramOAuthListener)) {
        this.b.add(paramOAuthListener);
      }
      if (this.c != null)
      {
        Log.d("MicroMsg.SDK.DiffDevOAuth", "auth, already running, no need to start auth again");
        AppMethodBeat.o(3723);
        return true;
      }
      paramString1 = new b(paramString1, paramString2, paramString3, paramString4, paramString5, this.d);
      this.c = paramString1;
      if (Build.VERSION.SDK_INT >= 11) {
        paramString1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(3723);
        return true;
        paramString1.execute(new Void[0]);
      }
    }
    Log.d("MicroMsg.SDK.DiffDevOAuth", String.format("auth fail, invalid argument, appId = %s, scope = %s", new Object[] { paramString1, paramString2 }));
    AppMethodBeat.o(3723);
    return false;
  }
  
  public void detach()
  {
    AppMethodBeat.i(3728);
    Log.i("MicroMsg.SDK.DiffDevOAuth", "detach");
    this.b.clear();
    stopAuth();
    AppMethodBeat.o(3728);
  }
  
  public void removeAllListeners()
  {
    AppMethodBeat.i(3727);
    this.b.clear();
    AppMethodBeat.o(3727);
  }
  
  public void removeListener(OAuthListener paramOAuthListener)
  {
    AppMethodBeat.i(3726);
    this.b.remove(paramOAuthListener);
    AppMethodBeat.o(3726);
  }
  
  public boolean stopAuth()
  {
    AppMethodBeat.i(3724);
    Log.i("MicroMsg.SDK.DiffDevOAuth", "stopAuth");
    for (;;)
    {
      try
      {
        b localb = this.c;
        if (localb != null) {
          continue;
        }
        bool = true;
      }
      catch (Exception localException)
      {
        Log.w("MicroMsg.SDK.DiffDevOAuth", "stopAuth fail, ex = " + localException.getMessage());
        boolean bool = false;
        continue;
      }
      this.c = null;
      AppMethodBeat.o(3724);
      return bool;
      bool = this.c.a();
    }
  }
  
  class a
    implements OAuthListener
  {
    a()
    {
      AppMethodBeat.i(242919);
      AppMethodBeat.o(242919);
    }
    
    public void onAuthFinish(OAuthErrCode paramOAuthErrCode, String paramString)
    {
      AppMethodBeat.i(242932);
      Log.d("MicroMsg.SDK.ListenerWrapper", String.format("onAuthFinish, errCode = %s, authCode = %s", new Object[] { paramOAuthErrCode.toString(), paramString }));
      a.a(a.this, null);
      Object localObject = new ArrayList();
      ((ArrayList)localObject).addAll(a.a(a.this));
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((OAuthListener)((Iterator)localObject).next()).onAuthFinish(paramOAuthErrCode, paramString);
      }
      AppMethodBeat.o(242932);
    }
    
    public void onAuthGotQrcode(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(242922);
      Log.d("MicroMsg.SDK.ListenerWrapper", "onAuthGotQrcode, qrcodeImgPath = ".concat(String.valueOf(paramString)));
      Object localObject = new ArrayList();
      ((ArrayList)localObject).addAll(a.a(a.this));
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((OAuthListener)((Iterator)localObject).next()).onAuthGotQrcode(paramString, paramArrayOfByte);
      }
      AppMethodBeat.o(242922);
    }
    
    public void onQrcodeScanned()
    {
      AppMethodBeat.i(242927);
      Log.d("MicroMsg.SDK.ListenerWrapper", "onQrcodeScanned");
      if (a.b(a.this) != null) {
        a.b(a.this).post(new a());
      }
      AppMethodBeat.o(242927);
    }
    
    class a
      implements Runnable
    {
      a()
      {
        AppMethodBeat.i(242923);
        AppMethodBeat.o(242923);
      }
      
      public void run()
      {
        AppMethodBeat.i(242928);
        Object localObject = new ArrayList();
        ((ArrayList)localObject).addAll(a.a(a.this));
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((OAuthListener)((Iterator)localObject).next()).onQrcodeScanned();
        }
        AppMethodBeat.o(242928);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.a.a
 * JD-Core Version:    0.7.0.1
 */