package com.tencent.mm.audio.b;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelvoice.e;
import com.tencent.mm.modelvoice.f;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public final class i
  implements com.tencent.mm.an.i
{
  public static boolean ftw = true;
  Queue<String> ftp;
  Queue<r> ftq;
  Map<String, f.a> ftr;
  private boolean fts;
  private boolean ftt;
  public int ftu;
  private long ftv;
  f.a ftx;
  private MTimerHandler fty;
  private boolean running;
  
  public i()
  {
    AppMethodBeat.i(148358);
    this.ftp = new LinkedList();
    this.ftq = new LinkedList();
    this.ftr = new HashMap();
    this.fts = false;
    this.ftt = false;
    this.running = false;
    this.ftu = 0;
    this.ftv = 0L;
    this.ftx = new f.a();
    this.fty = new MTimerHandler(h.aHJ().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148356);
        Log.i("MicroMsg.SceneVoiceService", "onTimerExpired[%s]", new Object[] { i.this.toString() });
        i.h(i.this);
        AppMethodBeat.o(148356);
        return false;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(148357);
        String str = super.toString() + "|scenePusher";
        AppMethodBeat.o(148357);
        return str;
      }
    }, false);
    Log.i("MicroMsg.SceneVoiceService", "SceneVoiceService %s", new Object[] { Util.getStack().toString() });
    h.aGY().a(127, this);
    h.aGY().a(128, this);
    AppMethodBeat.o(148358);
  }
  
  public static final i afj()
  {
    AppMethodBeat.i(228630);
    i locali = a.afl();
    AppMethodBeat.o(228630);
    return locali;
  }
  
  private void afk()
  {
    AppMethodBeat.i(148360);
    this.ftr.clear();
    this.ftp.clear();
    this.ftq.clear();
    this.ftt = false;
    this.fts = false;
    this.running = false;
    Log.i("MicroMsg.SceneVoiceService", "Finish service use time(ms):" + this.ftx.avE() + "[" + toString() + "]");
    AppMethodBeat.o(148360);
  }
  
  public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final q paramq)
  {
    AppMethodBeat.i(148359);
    String str1 = toString();
    String str2 = Util.nullAs(paramString, "");
    if (paramq != null) {}
    for (paramString = paramq.toString();; paramString = Integer.valueOf(0))
    {
      Log.i("MicroMsg.SceneVoiceService", "[%s]errType:%s errCode:%s errMsg:%s scene:%s", new Object[] { str1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str2, paramString });
      h.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(148352);
          String str;
          int i;
          if (paramq.getType() == 128)
          {
            i.a(i.this);
            str = ((e)paramq).fileName;
            i = ((e)paramq).retCode;
            r localr = s.YL(str);
            if ((paramq.getType() == 128) && (localr != null) && (localr.brF()) && (localr.status != 98))
            {
              s.Yb(str);
              Log.w("MicroMsg.SceneVoiceService", "re-download set error");
            }
            long l2 = 0L;
            long l1 = l2;
            if (str != null)
            {
              l1 = l2;
              if (i.this.ftr.get(str) != null)
              {
                l1 = ((f.a)i.this.ftr.get(str)).avE();
                i.this.ftr.remove(str);
              }
            }
            Log.i("MicroMsg.SceneVoiceService", "onSceneEnd SceneType:" + paramq.getType() + " errtype:" + paramInt1 + " errCode:" + paramInt2 + " retCode:" + i + " file:" + str + " time:" + l1);
            if ((paramInt1 != 3) || (i == 0)) {
              break label445;
            }
            i.c(i.this);
          }
          for (;;)
          {
            Log.i("MicroMsg.SceneVoiceService", "onSceneEnd stop:" + i.d(i.this) + " running:" + i.e(i.this) + " recving:" + i.f(i.this) + " sending:" + i.g(i.this));
            if (i.d(i.this) <= 0) {
              break label464;
            }
            i.h(i.this);
            AppMethodBeat.o(148352);
            return;
            if (paramq.getType() == 127)
            {
              i.b(i.this);
              str = ((f)paramq).fileName;
              i = ((f)paramq).retCode;
              break;
            }
            Log.e("MicroMsg.SceneVoiceService", "onSceneEnd Error SceneType:" + paramq.getType());
            AppMethodBeat.o(148352);
            return;
            label445:
            if (paramInt1 != 0) {
              i.a(i.this, 0);
            }
          }
          label464:
          if ((!i.g(i.this)) && (!i.f(i.this)))
          {
            i.i(i.this);
            Log.i("MicroMsg.SceneVoiceService", "onSceneEnd fin and try next delay 3s [%d, %d] [%b]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), Boolean.valueOf(i.ftw) });
            if ((i.ftw) && (paramInt1 == 4)) {
              h.aHJ().postToWorkerDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(148351);
                  Log.i("MicroMsg.SceneVoiceService", "onSceneEnd fin and try run");
                  i.this.run();
                  AppMethodBeat.o(148351);
                }
              }, 10000L);
            }
          }
          AppMethodBeat.o(148352);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(148353);
          String str = super.toString() + "|onSceneEnd";
          AppMethodBeat.o(148353);
          return str;
        }
      });
      AppMethodBeat.o(148359);
      return;
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(148361);
    Log.i("MicroMsg.SceneVoiceService", "run() %s", new Object[] { toString() });
    h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(148354);
        long l = System.currentTimeMillis() - i.j(i.this);
        Log.i("MicroMsg.SceneVoiceService", "Try Run service runningFlag:" + i.e(i.this) + " timeWait:" + l + " sending:" + i.g(i.this) + " recving:" + i.f(i.this) + "[" + i.this.toString() + "]");
        if (i.e(i.this))
        {
          if (l < 60000L)
          {
            AppMethodBeat.o(148354);
            return;
          }
          Log.e("MicroMsg.SceneVoiceService", "ERR: Try Run service runningFlag:" + i.e(i.this) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + i.g(i.this) + " recving:" + i.f(i.this));
        }
        i.k(i.this);
        i.b(i.this);
        i.a(i.this, 3);
        i.a(i.this);
        i.this.ftx.jvB = SystemClock.elapsedRealtime();
        i.l(i.this).startTimer(10L);
        AppMethodBeat.o(148354);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(148355);
        String str = super.toString() + "|run";
        AppMethodBeat.o(148355);
        return str;
      }
    });
    AppMethodBeat.o(148361);
  }
  
  static final class a
  {
    private static final i ftC;
    
    static
    {
      AppMethodBeat.i(227056);
      ftC = new i();
      AppMethodBeat.o(227056);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.b.i
 * JD-Core Version:    0.7.0.1
 */