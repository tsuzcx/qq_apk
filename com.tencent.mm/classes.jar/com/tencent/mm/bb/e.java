package com.tencent.mm.bb;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.app.q.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;

public final class e
{
  private static e oUQ = null;
  private q.a appForegroundListener;
  private byte[] mLock;
  QueueWorkerThread oEb;
  private String oUR;
  private com.tencent.mm.am.h onSceneEndCallback;
  
  private e()
  {
    AppMethodBeat.i(148397);
    this.appForegroundListener = new q.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(148391);
        paramAnonymousString = e.this;
        Looper.myQueue().addIdleHandler(new e.2(paramAnonymousString));
        AppMethodBeat.o(148391);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(148390);
        paramAnonymousString = e.this;
        Log.d("MicroMsg.SpeexUploadCore", "now pause speex uploader");
        paramAnonymousString.oEb.pause(true);
        AppMethodBeat.o(148390);
      }
    };
    this.oEb = new QueueWorkerThread(1, "speex_worker");
    this.mLock = new byte[0];
    this.onSceneEndCallback = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(148396);
        if (e.c(e.this) == null)
        {
          AppMethodBeat.o(148396);
          return;
        }
        Log.d("MicroMsg.SpeexUploadCore", "onSceneEnd " + ((a)paramAnonymousp).filename + " filepath " + e.c(e.this) + " errCode " + paramAnonymousInt2);
        if (((a)paramAnonymousp).filename.equals(e.c(e.this)))
        {
          com.tencent.mm.kernel.h.aZW().b(240, e.d(e.this));
          if (paramAnonymousInt2 == 0)
          {
            d.bMM();
            d.bMO();
          }
          paramAnonymousString = new u(e.c(e.this));
          try
          {
            boolean bool = paramAnonymousString.diJ();
            Log.d("MicroMsg.SpeexUploadCore", "delete " + e.c(e.this) + " delete " + bool + " errCode " + paramAnonymousInt2);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            Log.e("MicroMsg.SpeexUploadCore", "exception:%s", new Object[] { Util.stackTraceToString(paramAnonymousString) });
            return;
          }
          finally
          {
            e.bMU().start();
            e.e(e.this);
            AppMethodBeat.o(148396);
          }
        }
        AppMethodBeat.o(148396);
      }
    };
    this.appForegroundListener.alive();
    AppMethodBeat.o(148397);
  }
  
  public static e bMU()
  {
    AppMethodBeat.i(148398);
    if (oUQ == null) {
      oUQ = new e();
    }
    e locale = oUQ;
    AppMethodBeat.o(148398);
    return locale;
  }
  
  private static u eN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148401);
    Object localObject1 = new u(b.bML());
    if ((!((u)localObject1).jKS()) || (!((u)localObject1).isDirectory()))
    {
      AppMethodBeat.o(148401);
      return null;
    }
    u[] arrayOfu = ((u)localObject1).jKX();
    int i = 0;
    localObject1 = null;
    Object localObject2 = localObject1;
    if (arrayOfu != null)
    {
      localObject2 = localObject1;
      if (i < arrayOfu.length)
      {
        localObject2 = arrayOfu[i];
        localObject1 = localObject2;
        long l;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((u)localObject2).jKV())
          {
            Log.d("MicroMsg.SpeexUploadCore", "file " + ah.v(((u)localObject2).mUri));
            localObject1 = ah.v(((u)localObject2).mUri);
            l = ((u)localObject2).length();
            if (((u)localObject2).getName().endsWith(".spx")) {
              break label169;
            }
          }
        }
        for (localObject1 = null;; localObject1 = null)
        {
          i += 1;
          break;
          label169:
          if ((l >= paramInt1) && (l <= paramInt2)) {
            break label226;
          }
          Log.d("MicroMsg.SpeexUploadCore", "unfit delete %s, minsize: %d, maxSize: %d", new Object[] { localObject1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          y.deleteFile((String)localObject1);
        }
      }
    }
    label226:
    AppMethodBeat.o(148401);
    return localObject2;
  }
  
  public final void b(QueueWorkerThread.ThreadObject paramThreadObject)
  {
    AppMethodBeat.i(148399);
    Log.d("MicroMsg.SpeexUploadCore", "pushWork");
    this.oEb.add(paramThreadObject);
    AppMethodBeat.o(148399);
  }
  
  public final void start()
  {
    AppMethodBeat.i(148400);
    if (!NetStatusUtil.isWifi(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(148400);
      return;
    }
    new MMHandler(Looper.getMainLooper()).postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(148395);
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
        {
          public final boolean queueIdle()
          {
            AppMethodBeat.i(148394);
            e.this.b(new QueueWorkerThread.ThreadObject()
            {
              public final boolean doInBackground()
              {
                return true;
              }
              
              public final boolean onPostExecute()
              {
                AppMethodBeat.i(148393);
                e.b(e.this);
                AppMethodBeat.o(148393);
                return false;
              }
            });
            AppMethodBeat.o(148394);
            return false;
          }
        });
        AppMethodBeat.o(148395);
      }
    }, 100L);
    AppMethodBeat.o(148400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.bb.e
 * JD-Core Version:    0.7.0.1
 */