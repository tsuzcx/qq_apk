package com.tencent.matrix.resource.processor;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.matrix.memorydump.a;
import com.tencent.matrix.resource.analyzer.model.DestroyedActivityInfo;
import com.tencent.matrix.resource.b.a.b;
import java.io.File;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public final class e
  extends b
{
  private final BroadcastReceiver bJm = new BroadcastReceiver()
  {
    public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if ("android.intent.action.SCREEN_OFF".equals(paramAnonymousIntent.getAction()))
      {
        com.tencent.matrix.e.c.v("Matrix.LeakProcessor.LazyForkAnalyze", "action screen off", new Object[0]);
        e.a(e.this, true);
        com.tencent.matrix.e.b.aAp().post(e.c(e.this));
      }
      while (!"android.intent.action.SCREEN_ON".equals(paramAnonymousIntent.getAction())) {
        return;
      }
      com.tencent.matrix.e.c.v("Matrix.LeakProcessor.LazyForkAnalyze", "action screen on", new Object[0]);
      e.a(e.this, false);
      com.tencent.matrix.e.b.aAp().removeCallbacks(e.c(e.this));
    }
  };
  private volatile boolean fct = false;
  private final Queue<a> fcu = new LinkedBlockingQueue();
  private final Runnable fcv = new Runnable()
  {
    public final void run()
    {
      com.tencent.matrix.e.c.v("Matrix.LeakProcessor.LazyForkAnalyze", "analyze task start. background: " + e.a(e.this) + ", queue empty: " + e.b(e.this).isEmpty(), new Object[0]);
      for (;;)
      {
        e.a locala;
        if (e.a(e.this))
        {
          locala = (e.a)e.b(e.this).poll();
          if (locala == null) {
            com.tencent.matrix.e.c.v("Matrix.LeakProcessor.LazyForkAnalyze", "task queue is cleared", new Object[0]);
          }
        }
        else
        {
          com.tencent.matrix.e.c.v("Matrix.LeakProcessor.LazyForkAnalyze", "analyze task complete. background: " + e.a(e.this) + ", queue empty: " + e.b(e.this).isEmpty(), new Object[0]);
          return;
        }
        e.a(e.this, locala);
      }
    }
  };
  
  public e(com.tencent.matrix.resource.f.b paramb)
  {
    super(paramb);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    paramb.fcO.getApplication().registerReceiver(this.bJm, localIntentFilter);
  }
  
  public final boolean a(DestroyedActivityInfo paramDestroyedActivityInfo)
  {
    if (Build.VERSION.SDK_INT > 31)
    {
      com.tencent.matrix.e.c.e("Matrix.LeakProcessor.LazyForkAnalyze", "cannot fork-dump with unsupported API version " + Build.VERSION.SDK_INT, new Object[0]);
      a(4, a.b.fbp, paramDestroyedActivityInfo.mActivityName, paramDestroyedActivityInfo.mKey, "Unsupported API", "0");
      return false;
    }
    azu();
    com.tencent.matrix.resource.f.b.azx();
    String str1 = paramDestroyedActivityInfo.mActivityName;
    String str2 = paramDestroyedActivityInfo.mKey;
    long l = System.currentTimeMillis();
    File localFile = azr().azo();
    int i;
    if ((localFile != null) && (!a.gQ(localFile.getPath())))
    {
      com.tencent.matrix.e.c.e("Matrix.LeakProcessor.LazyForkAnalyze", String.format("heap dump for further analyzing activity with key [%s] was failed, just ignore.", new Object[] { str2 }), new Object[0]);
      i = 0;
    }
    while (i != 0)
    {
      azu().m(paramDestroyedActivityInfo.mActivityName, false);
      return true;
      if ((localFile == null) || (localFile.length() == 0L))
      {
        a(2, a.b.fbp, str1, str2, "FileNull", "0");
        com.tencent.matrix.e.c.e("Matrix.LeakProcessor.LazyForkAnalyze", "cannot create hprof file", new Object[0]);
        i = 0;
      }
      else
      {
        com.tencent.matrix.e.c.i("Matrix.LeakProcessor.LazyForkAnalyze", String.format("dump cost=%sms refString=%s path=%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), str2, localFile.getPath() }), new Object[0]);
        com.tencent.matrix.e.c.i("Matrix.LeakProcessor.LazyForkAnalyze", "dump complete, push task into lazy analyze task queue", new Object[0]);
        this.fcu.add(new a(localFile, str1, str2, l));
        i = 1;
      }
    }
    return false;
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    azu().fcO.getApplication().unregisterReceiver(this.bJm);
  }
  
  static final class a
  {
    final long fcA;
    final File fcx;
    final String fcy;
    final String fcz;
    
    a(File paramFile, String paramString1, String paramString2, long paramLong)
    {
      this.fcx = paramFile;
      this.fcy = paramString1;
      this.fcz = paramString2;
      this.fcA = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.resource.processor.e
 * JD-Core Version:    0.7.0.1
 */