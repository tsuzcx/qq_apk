package com.tencent.mm.bh;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.app.n.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.be.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;

public final class e
{
  private static e inQ = null;
  private n.a appForegroundListener;
  be hXq;
  private String inR;
  private byte[] mLock;
  private f onSceneEndCallback;
  
  private e()
  {
    AppMethodBeat.i(148397);
    this.appForegroundListener = new n.a()
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
        ad.d("MicroMsg.SpeexUploadCore", "now pause speex uploader");
        paramAnonymousString.hXq.pause(true);
        AppMethodBeat.o(148390);
      }
    };
    this.hXq = new be(1, "speex_worker");
    this.mLock = new byte[0];
    this.onSceneEndCallback = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(148396);
        if (e.c(e.this) == null)
        {
          AppMethodBeat.o(148396);
          return;
        }
        ad.d("MicroMsg.SpeexUploadCore", "onSceneEnd " + ((a)paramAnonymousn).filename + " filepath " + e.c(e.this) + " errCode " + paramAnonymousInt2);
        if (((a)paramAnonymousn).filename.equals(e.c(e.this)))
        {
          g.aiU().b(240, e.d(e.this));
          if (paramAnonymousInt2 == 0)
          {
            d.aLp();
            d.aLr();
          }
          paramAnonymousString = new com.tencent.mm.vfs.e(e.c(e.this));
          try
          {
            boolean bool = paramAnonymousString.delete();
            ad.d("MicroMsg.SpeexUploadCore", "delete " + e.c(e.this) + " delete " + bool + " errCode " + paramAnonymousInt2);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            ad.e("MicroMsg.SpeexUploadCore", "exception:%s", new Object[] { bt.n(paramAnonymousString) });
            return;
          }
          finally
          {
            e.aLx().start();
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
  
  public static e aLx()
  {
    AppMethodBeat.i(148398);
    if (inQ == null) {
      inQ = new e();
    }
    e locale = inQ;
    AppMethodBeat.o(148398);
    return locale;
  }
  
  private static com.tencent.mm.vfs.e jdMethod_do(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148401);
    Object localObject1 = new com.tencent.mm.vfs.e(b.aLo());
    if ((!((com.tencent.mm.vfs.e)localObject1).exists()) || (!((com.tencent.mm.vfs.e)localObject1).isDirectory()))
    {
      AppMethodBeat.o(148401);
      return null;
    }
    com.tencent.mm.vfs.e[] arrayOfe = ((com.tencent.mm.vfs.e)localObject1).fOM();
    int i = 0;
    localObject1 = null;
    Object localObject2 = localObject1;
    if (arrayOfe != null)
    {
      localObject2 = localObject1;
      if (i < arrayOfe.length)
      {
        localObject2 = arrayOfe[i];
        localObject1 = localObject2;
        long l;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((com.tencent.mm.vfs.e)localObject2).isFile())
          {
            ad.d("MicroMsg.SpeexUploadCore", "file " + com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject2).mUri));
            localObject1 = com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject2).mUri);
            l = ((com.tencent.mm.vfs.e)localObject2).length();
            if (((com.tencent.mm.vfs.e)localObject2).getName().endsWith(".spx")) {
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
          ad.d("MicroMsg.SpeexUploadCore", "unfit delete %s, minsize: %d, maxSize: %d", new Object[] { localObject1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          i.deleteFile((String)localObject1);
        }
      }
    }
    label226:
    AppMethodBeat.o(148401);
    return localObject2;
  }
  
  public final void b(be.a parama)
  {
    AppMethodBeat.i(148399);
    ad.d("MicroMsg.SpeexUploadCore", "pushWork");
    this.hXq.c(parama);
    AppMethodBeat.o(148399);
  }
  
  public final void start()
  {
    AppMethodBeat.i(148400);
    if (!ay.isWifi(aj.getContext()))
    {
      AppMethodBeat.o(148400);
      return;
    }
    new ap(Looper.getMainLooper()).postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(148395);
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
        {
          public final boolean queueIdle()
          {
            AppMethodBeat.i(148394);
            e.this.b(new be.a()
            {
              public final boolean aEm()
              {
                return true;
              }
              
              public final boolean aEn()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bh.e
 * JD-Core Version:    0.7.0.1
 */