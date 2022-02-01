package com.tencent.mm.bg;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.app.o.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bf.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;

public final class e
{
  private static e iqK = null;
  private o.a appForegroundListener;
  bf iai;
  private String iqL;
  private byte[] mLock;
  private f onSceneEndCallback;
  
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
        ae.d("MicroMsg.SpeexUploadCore", "now pause speex uploader");
        paramAnonymousString.iai.pause(true);
        AppMethodBeat.o(148390);
      }
    };
    this.iai = new bf(1, "speex_worker");
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
        ae.d("MicroMsg.SpeexUploadCore", "onSceneEnd " + ((a)paramAnonymousn).filename + " filepath " + e.c(e.this) + " errCode " + paramAnonymousInt2);
        if (((a)paramAnonymousn).filename.equals(e.c(e.this)))
        {
          g.ajj().b(240, e.d(e.this));
          if (paramAnonymousInt2 == 0)
          {
            d.aLM();
            d.aLO();
          }
          paramAnonymousString = new k(e.c(e.this));
          try
          {
            boolean bool = paramAnonymousString.delete();
            ae.d("MicroMsg.SpeexUploadCore", "delete " + e.c(e.this) + " delete " + bool + " errCode " + paramAnonymousInt2);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            ae.e("MicroMsg.SpeexUploadCore", "exception:%s", new Object[] { bu.o(paramAnonymousString) });
            return;
          }
          finally
          {
            e.aLU().start();
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
  
  public static e aLU()
  {
    AppMethodBeat.i(148398);
    if (iqK == null) {
      iqK = new e();
    }
    e locale = iqK;
    AppMethodBeat.o(148398);
    return locale;
  }
  
  private static k jdMethod_do(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148401);
    Object localObject1 = new k(b.aLL());
    if ((!((k)localObject1).exists()) || (!((k)localObject1).isDirectory()))
    {
      AppMethodBeat.o(148401);
      return null;
    }
    k[] arrayOfk = ((k)localObject1).fTj();
    int i = 0;
    localObject1 = null;
    Object localObject2 = localObject1;
    if (arrayOfk != null)
    {
      localObject2 = localObject1;
      if (i < arrayOfk.length)
      {
        localObject2 = arrayOfk[i];
        localObject1 = localObject2;
        long l;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((k)localObject2).isFile())
          {
            ae.d("MicroMsg.SpeexUploadCore", "file " + w.B(((k)localObject2).mUri));
            localObject1 = w.B(((k)localObject2).mUri);
            l = ((k)localObject2).length();
            if (((k)localObject2).getName().endsWith(".spx")) {
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
          ae.d("MicroMsg.SpeexUploadCore", "unfit delete %s, minsize: %d, maxSize: %d", new Object[] { localObject1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          o.deleteFile((String)localObject1);
        }
      }
    }
    label226:
    AppMethodBeat.o(148401);
    return localObject2;
  }
  
  public final void b(bf.a parama)
  {
    AppMethodBeat.i(148399);
    ae.d("MicroMsg.SpeexUploadCore", "pushWork");
    this.iai.c(parama);
    AppMethodBeat.o(148399);
  }
  
  public final void start()
  {
    AppMethodBeat.i(148400);
    if (!az.isWifi(ak.getContext()))
    {
      AppMethodBeat.o(148400);
      return;
    }
    new aq(Looper.getMainLooper()).postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(148395);
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
        {
          public final boolean queueIdle()
          {
            AppMethodBeat.i(148394);
            e.this.b(new bf.a()
            {
              public final boolean aEC()
              {
                return true;
              }
              
              public final boolean aED()
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
 * Qualified Name:     com.tencent.mm.bg.e
 * JD-Core Version:    0.7.0.1
 */