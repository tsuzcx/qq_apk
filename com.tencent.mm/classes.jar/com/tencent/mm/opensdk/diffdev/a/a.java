package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.diffdev.IDiffDevOAuth;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import java.util.ArrayList;
import java.util.List;

public final class a
  implements IDiffDevOAuth
{
  private List<OAuthListener> c;
  private d d;
  private OAuthListener e;
  private Handler handler;
  
  public a()
  {
    AppMethodBeat.i(3722);
    this.handler = null;
    this.c = new ArrayList();
    this.e = new b(this);
    AppMethodBeat.o(3722);
  }
  
  public final void addListener(OAuthListener paramOAuthListener)
  {
    AppMethodBeat.i(3725);
    if (!this.c.contains(paramOAuthListener)) {
      this.c.add(paramOAuthListener);
    }
    AppMethodBeat.o(3725);
  }
  
  public final boolean auth(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, OAuthListener paramOAuthListener)
  {
    AppMethodBeat.i(3723);
    Log.i("MicroMsg.SDK.DiffDevOAuth", "start auth, appId = ".concat(String.valueOf(paramString1)));
    if ((paramString1 == null) || (paramString1.length() <= 0) || (paramString2 == null) || (paramString2.length() <= 0))
    {
      Log.d("MicroMsg.SDK.DiffDevOAuth", String.format("auth fail, invalid argument, appId = %s, scope = %s", new Object[] { paramString1, paramString2 }));
      AppMethodBeat.o(3723);
      return false;
    }
    if (this.handler == null) {
      this.handler = new Handler(Looper.getMainLooper());
    }
    addListener(paramOAuthListener);
    if (this.d != null)
    {
      Log.d("MicroMsg.SDK.DiffDevOAuth", "auth, already running, no need to start auth again");
      AppMethodBeat.o(3723);
      return true;
    }
    this.d = new d(paramString1, paramString2, paramString3, paramString4, paramString5, this.e);
    paramString1 = this.d;
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
  
  public final void detach()
  {
    AppMethodBeat.i(3728);
    Log.i("MicroMsg.SDK.DiffDevOAuth", "detach");
    this.c.clear();
    stopAuth();
    AppMethodBeat.o(3728);
  }
  
  public final void removeAllListeners()
  {
    AppMethodBeat.i(3727);
    this.c.clear();
    AppMethodBeat.o(3727);
  }
  
  public final void removeListener(OAuthListener paramOAuthListener)
  {
    AppMethodBeat.i(3726);
    this.c.remove(paramOAuthListener);
    AppMethodBeat.o(3726);
  }
  
  public final boolean stopAuth()
  {
    AppMethodBeat.i(3724);
    Log.i("MicroMsg.SDK.DiffDevOAuth", "stopAuth");
    for (;;)
    {
      try
      {
        d locald = this.d;
        if (locald != null) {
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
      this.d = null;
      AppMethodBeat.o(3724);
      return bool;
      bool = this.d.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.a.a
 * JD-Core Version:    0.7.0.1
 */