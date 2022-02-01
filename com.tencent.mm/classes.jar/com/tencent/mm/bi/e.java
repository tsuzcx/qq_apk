package com.tencent.mm.bi;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.app.o.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

public final class e
{
  private static e mbV = null;
  private o.a appForegroundListener;
  QueueWorkerThread lLz;
  private byte[] mLock;
  private String mbW;
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
        paramAnonymousString.lLz.pause(true);
        AppMethodBeat.o(148390);
      }
    };
    this.lLz = new QueueWorkerThread(1, "speex_worker");
    this.mLock = new byte[0];
    this.onSceneEndCallback = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.q paramAnonymousq)
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
          h.aGY().b(240, e.d(e.this));
          if (paramAnonymousInt2 == 0)
          {
            d.bpf();
            d.bph();
          }
          paramAnonymousString = new com.tencent.mm.vfs.q(e.c(e.this));
          try
          {
            boolean bool = paramAnonymousString.cFq();
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
            e.bpn().start();
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
  
  public static e bpn()
  {
    AppMethodBeat.i(148398);
    if (mbV == null) {
      mbV = new e();
    }
    e locale = mbV;
    AppMethodBeat.o(148398);
    return locale;
  }
  
  private static com.tencent.mm.vfs.q dV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148401);
    Object localObject1 = new com.tencent.mm.vfs.q(b.bpe());
    if ((!((com.tencent.mm.vfs.q)localObject1).ifE()) || (!((com.tencent.mm.vfs.q)localObject1).isDirectory()))
    {
      AppMethodBeat.o(148401);
      return null;
    }
    com.tencent.mm.vfs.q[] arrayOfq = ((com.tencent.mm.vfs.q)localObject1).ifJ();
    int i = 0;
    localObject1 = null;
    Object localObject2 = localObject1;
    if (arrayOfq != null)
    {
      localObject2 = localObject1;
      if (i < arrayOfq.length)
      {
        localObject2 = arrayOfq[i];
        localObject1 = localObject2;
        long l;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((com.tencent.mm.vfs.q)localObject2).ifH())
          {
            Log.d("MicroMsg.SpeexUploadCore", "file " + ((com.tencent.mm.vfs.q)localObject2).getPath());
            localObject1 = ((com.tencent.mm.vfs.q)localObject2).getPath();
            l = ((com.tencent.mm.vfs.q)localObject2).length();
            if (((com.tencent.mm.vfs.q)localObject2).getName().endsWith(".spx")) {
              break label163;
            }
          }
        }
        for (localObject1 = null;; localObject1 = null)
        {
          i += 1;
          break;
          label163:
          if ((l >= paramInt1) && (l <= paramInt2)) {
            break label220;
          }
          Log.d("MicroMsg.SpeexUploadCore", "unfit delete %s, minsize: %d, maxSize: %d", new Object[] { localObject1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          u.deleteFile((String)localObject1);
        }
      }
    }
    label220:
    AppMethodBeat.o(148401);
    return localObject2;
  }
  
  public final void b(QueueWorkerThread.ThreadObject paramThreadObject)
  {
    AppMethodBeat.i(148399);
    Log.d("MicroMsg.SpeexUploadCore", "pushWork");
    this.lLz.add(paramThreadObject);
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
 * Qualified Name:     com.tencent.mm.bi.e
 * JD-Core Version:    0.7.0.1
 */