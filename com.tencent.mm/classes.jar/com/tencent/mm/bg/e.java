package com.tencent.mm.bg;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.app.n.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bd.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;

public final class e
{
  private static e hUv = null;
  private n.a appForegroundListener;
  bd hEL;
  private String hUw;
  private byte[] mLock;
  private com.tencent.mm.ak.g onSceneEndCallback;
  
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
        ac.d("MicroMsg.SpeexUploadCore", "now pause speex uploader");
        paramAnonymousString.hEL.pause(true);
        AppMethodBeat.o(148390);
      }
    };
    this.hEL = new bd(1, "speex_worker");
    this.mLock = new byte[0];
    this.onSceneEndCallback = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(148396);
        if (e.c(e.this) == null)
        {
          AppMethodBeat.o(148396);
          return;
        }
        ac.d("MicroMsg.SpeexUploadCore", "onSceneEnd " + ((a)paramAnonymousn).filename + " filepath " + e.c(e.this) + " errCode " + paramAnonymousInt2);
        if (((a)paramAnonymousn).filename.equals(e.c(e.this)))
        {
          com.tencent.mm.kernel.g.agi().b(240, e.d(e.this));
          if (paramAnonymousInt2 == 0)
          {
            d.aIe();
            d.aIg();
          }
          paramAnonymousString = new com.tencent.mm.vfs.e(e.c(e.this));
          try
          {
            boolean bool = paramAnonymousString.delete();
            ac.d("MicroMsg.SpeexUploadCore", "delete " + e.c(e.this) + " delete " + bool + " errCode " + paramAnonymousInt2);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            ac.e("MicroMsg.SpeexUploadCore", "exception:%s", new Object[] { bs.m(paramAnonymousString) });
            return;
          }
          finally
          {
            e.aIn().start();
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
  
  public static e aIn()
  {
    AppMethodBeat.i(148398);
    if (hUv == null) {
      hUv = new e();
    }
    e locale = hUv;
    AppMethodBeat.o(148398);
    return locale;
  }
  
  private static com.tencent.mm.vfs.e dl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148401);
    Object localObject1 = new com.tencent.mm.vfs.e(b.aId());
    if ((!((com.tencent.mm.vfs.e)localObject1).exists()) || (!((com.tencent.mm.vfs.e)localObject1).isDirectory()))
    {
      AppMethodBeat.o(148401);
      return null;
    }
    com.tencent.mm.vfs.e[] arrayOfe = ((com.tencent.mm.vfs.e)localObject1).fxX();
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
            ac.d("MicroMsg.SpeexUploadCore", "file " + com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject2).mUri));
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
          ac.d("MicroMsg.SpeexUploadCore", "unfit delete %s, minsize: %d, maxSize: %d", new Object[] { localObject1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          i.deleteFile((String)localObject1);
        }
      }
    }
    label226:
    AppMethodBeat.o(148401);
    return localObject2;
  }
  
  public final void b(bd.a parama)
  {
    AppMethodBeat.i(148399);
    ac.d("MicroMsg.SpeexUploadCore", "pushWork");
    this.hEL.c(parama);
    AppMethodBeat.o(148399);
  }
  
  public final void start()
  {
    AppMethodBeat.i(148400);
    if (!ax.isWifi(ai.getContext()))
    {
      AppMethodBeat.o(148400);
      return;
    }
    new ao(Looper.getMainLooper()).postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(148395);
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
        {
          public final boolean queueIdle()
          {
            AppMethodBeat.i(148394);
            e.this.b(new bd.a()
            {
              public final boolean aBj()
              {
                return true;
              }
              
              public final boolean aBk()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.bg.e
 * JD-Core Version:    0.7.0.1
 */