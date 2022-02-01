package com.tencent.mm.bg;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.app.o.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public final class e
{
  private static e jlU = null;
  private o.a appForegroundListener;
  QueueWorkerThread iVg;
  private String jlV;
  private byte[] mLock;
  private i onSceneEndCallback;
  
  private e()
  {
    AppMethodBeat.i(148397);
    this.appForegroundListener = new o.a()
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
        paramAnonymousString.iVg.pause(true);
        AppMethodBeat.o(148390);
      }
    };
    this.iVg = new QueueWorkerThread(1, "speex_worker");
    this.mLock = new byte[0];
    this.onSceneEndCallback = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(148396);
        if (e.c(e.this) == null)
        {
          AppMethodBeat.o(148396);
          return;
        }
        Log.d("MicroMsg.SpeexUploadCore", "onSceneEnd " + ((a)paramAnonymousq).filename + " filepath " + e.c(e.this) + " errCode " + paramAnonymousInt2);
        if (((a)paramAnonymousq).filename.equals(e.c(e.this)))
        {
          g.azz().b(240, e.d(e.this));
          if (paramAnonymousInt2 == 0)
          {
            d.bfP();
            d.bfR();
          }
          paramAnonymousString = new o(e.c(e.this));
          try
          {
            boolean bool = paramAnonymousString.delete();
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
            e.bfX().start();
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
  
  public static e bfX()
  {
    AppMethodBeat.i(148398);
    if (jlU == null) {
      jlU = new e();
    }
    e locale = jlU;
    AppMethodBeat.o(148398);
    return locale;
  }
  
  private static o dy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148401);
    Object localObject1 = new o(b.bfO());
    if ((!((o)localObject1).exists()) || (!((o)localObject1).isDirectory()))
    {
      AppMethodBeat.o(148401);
      return null;
    }
    o[] arrayOfo = ((o)localObject1).het();
    int i = 0;
    localObject1 = null;
    Object localObject2 = localObject1;
    if (arrayOfo != null)
    {
      localObject2 = localObject1;
      if (i < arrayOfo.length)
      {
        localObject2 = arrayOfo[i];
        localObject1 = localObject2;
        long l;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((o)localObject2).isFile())
          {
            Log.d("MicroMsg.SpeexUploadCore", "file " + aa.z(((o)localObject2).mUri));
            localObject1 = aa.z(((o)localObject2).mUri);
            l = ((o)localObject2).length();
            if (((o)localObject2).getName().endsWith(".spx")) {
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
          s.deleteFile((String)localObject1);
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
    this.iVg.add(paramThreadObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bg.e
 * JD-Core Version:    0.7.0.1
 */